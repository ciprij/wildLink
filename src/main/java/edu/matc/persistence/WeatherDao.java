package edu.matc.persistence;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import edu.matc.entity.Response;
import edu.matc.utilities.PropertiesLoader;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Properties;

/**
 * The type Weather dao.
 */
public class WeatherDao implements PropertiesLoader {
    private String apiKey;
    private String baseUrl;
    private final Logger logger = LogManager.getLogger(this.getClass());

    /**
     * Loads API credentials from properties.
     */
    public WeatherDao() {
        try {
            Properties properties = loadProperties("/weatherapi.properties");
            this.apiKey = properties.getProperty("api.key");
            this.baseUrl = properties.getProperty("base.url");
        } catch (Exception e) {
            logger.error("Failed to load API properties: ", e);
        }
    }

    /**
     * Gets weather.
     *
     * @param location the location
     * @return the weather
     */
    public Response getWeather(String location) {
        Client client = ClientBuilder.newClient();
        WebTarget target = client.target(baseUrl)
                .queryParam("key", apiKey)
                .queryParam("q", location);

        String responseJson = target.request(MediaType.APPLICATION_JSON).get(String.class);

        ObjectMapper mapper = new ObjectMapper();
        Response weatherResponse = null;
        try {
            weatherResponse = mapper.readValue(responseJson, Response.class);
        } catch (JsonProcessingException e) {
            logger.error(e.getMessage());
        }

        return weatherResponse;
    }
}