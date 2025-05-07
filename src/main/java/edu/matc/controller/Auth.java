package edu.matc.controller;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.fasterxml.jackson.databind.ObjectMapper;
import edu.matc.auth.*;
import edu.matc.entity.User;
import edu.matc.persistence.UserDao;
import edu.matc.utilities.PropertiesLoader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.commons.io.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.math.BigInteger;
import java.net.URI;
import java.net.URL;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.RSAPublicKeySpec;
import java.util.*;
import java.util.stream.Collectors;

@WebServlet(urlPatterns = {"/auth"})
public class Auth extends HttpServlet implements PropertiesLoader {

    Properties properties;
    String CLIENT_ID;
    String CLIENT_SECRET;
    String OAUTH_URL;
    String LOGIN_URL;
    String REDIRECT_URL;
    String REGION;
    String POOL_ID;
    Keys jwks;

    private final Logger logger = LogManager.getLogger(this.getClass());

    @Override
    public void init() throws ServletException {
        super.init();
        loadProperties();
        loadKey();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String authCode = req.getParameter("code");
        String userName = null;

        if (authCode == null) {
            // TODO: forward to an error page or back to the login
        } else {
            HttpRequest authRequest = buildAuthRequest(authCode);
            try {
                TokenResponse tokenResponse = getToken(authRequest);
                userName = validate(tokenResponse, req);
                req.getSession().setAttribute("userName", userName);
            } catch (IOException e) {
                logger.error("Error getting or validating the token: " + e.getMessage(), e);
                // TODO: forward to an error page
            } catch (InterruptedException e) {
                logger.error("Error getting token from Cognito oauth url " + e.getMessage(), e);
                // TODO: forward to an error page
            }
        }

        String state = req.getParameter("state");
        if (state == null || state.isEmpty()) {
            state = "index.jsp";  // Fallback if 'state' is not found
        }

        resp.sendRedirect(state);
    }

    private TokenResponse getToken(HttpRequest authRequest) throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        HttpResponse<?> response = client.send(authRequest, HttpResponse.BodyHandlers.ofString());

        logger.debug("Response headers: " + response.headers().toString());
        logger.debug("Response body: " + response.body().toString());

        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(response.body().toString(), TokenResponse.class);
    }

    private String validate(TokenResponse tokenResponse, HttpServletRequest req) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        CognitoTokenHeader tokenHeader = mapper.readValue(CognitoJWTParser.getHeader(tokenResponse.getIdToken()).toString(), CognitoTokenHeader.class);

        String keyId = tokenHeader.getKid();
        String alg = tokenHeader.getAlg();

        BigInteger modulus = new BigInteger(1, org.apache.commons.codec.binary.Base64.decodeBase64(jwks.getKeys().get(0).getN()));
        BigInteger exponent = new BigInteger(1, org.apache.commons.codec.binary.Base64.decodeBase64(jwks.getKeys().get(0).getE()));

        PublicKey publicKey = null;
        try {
            publicKey = KeyFactory.getInstance("RSA").generatePublic(new RSAPublicKeySpec(modulus, exponent));
        } catch (InvalidKeySpecException | NoSuchAlgorithmException e) {
            logger.error("Error creating public key: " + e.getMessage(), e);
        }

        Algorithm algorithm = Algorithm.RSA256((RSAPublicKey) publicKey, null);

        String iss = String.format("https://cognito-idp.%s.amazonaws.com/%s", REGION, POOL_ID);

        JWTVerifier verifier = JWT.require(algorithm)
                .withIssuer(iss)
                .withClaim("token_use", "id")
                .acceptLeeway(60)
                .build();

        DecodedJWT jwt = verifier.verify(tokenResponse.getIdToken());

        String userName = jwt.getClaim("cognito:username").asString();
        String email = jwt.getClaim("email").asString();
        String givenName = jwt.getClaim("given_name").asString();
        String familyName = jwt.getClaim("family_name").asString();

        logger.debug("User info - Username: {} Email: {} Name: {} {}", userName, email, givenName, familyName);

        // Insert or update user in the database
        UserDao userDao = new UserDao();
        User loggedInUser = userDao.insertFromClaims(userName, email, givenName, familyName);
        System.out.println("The logged in user is --> " + loggedInUser);

        HttpSession session = req.getSession();
        session.setAttribute("loggedInUser", loggedInUser);

        return userName;
    }

    private HttpRequest buildAuthRequest(String authCode) {
        String keys = CLIENT_ID + ":" + CLIENT_SECRET;

        HashMap<String, String> parameters = new HashMap<>();
        parameters.put("grant_type", "authorization_code");
        parameters.put("client-secret", CLIENT_SECRET);
        parameters.put("client_id", CLIENT_ID);
        parameters.put("code", authCode);
        parameters.put("redirect_uri", REDIRECT_URL);

        String form = parameters.keySet().stream()
                .map(key -> key + "=" + URLEncoder.encode(parameters.get(key), StandardCharsets.UTF_8))
                .collect(Collectors.joining("&"));

        String encoding = Base64.getEncoder().encodeToString(keys.getBytes());

        return HttpRequest.newBuilder().uri(URI.create(OAUTH_URL))
                .headers("Content-Type", "application/x-www-form-urlencoded", "Authorization", "Basic " + encoding)
                .POST(HttpRequest.BodyPublishers.ofString(form)).build();
    }

    private void loadKey() {
        ObjectMapper mapper = new ObjectMapper();

        try {
            URL jwksURL = new URL(String.format("https://cognito-idp.%s.amazonaws.com/%s/.well-known/jwks.json", REGION, POOL_ID));
            File jwksFile = new File("jwks.json");
            FileUtils.copyURLToFile(jwksURL, jwksFile);
            jwks = mapper.readValue(jwksFile, Keys.class);
            logger.debug("Keys loaded.");
        } catch (IOException ioException) {
            logger.error("Cannot load JSON: " + ioException.getMessage(), ioException);
        } catch (Exception e) {
            logger.error("Error loading JSON: " + e.getMessage(), e);
        }
    }

    private void loadProperties() {
        try {
            properties = loadProperties("/cognito.properties");
            CLIENT_ID = properties.getProperty("client.id");
            CLIENT_SECRET = properties.getProperty("client.secret");
            OAUTH_URL = properties.getProperty("oauthURL");
            LOGIN_URL = properties.getProperty("loginURL");
            REDIRECT_URL = properties.getProperty("redirectURL");
            REGION = properties.getProperty("region");
            POOL_ID = properties.getProperty("poolId");
        } catch (IOException ioException) {
            logger.error("Cannot load properties: " + ioException.getMessage(), ioException);
        } catch (Exception e) {
            logger.error("Error loading properties: " + e.getMessage(), e);
        }
    }
}
