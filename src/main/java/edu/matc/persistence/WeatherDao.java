package edu.matc.persistence;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import edu.matc.entity.Response;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * The type Weather dao.
 */
public class WeatherDao {
    private static final String API_KEY = "6dbbd747934e44bf84312529252303"; // Replace with your actual API key
    private static final String BASE_URL = "https://api.weatherapi.com/v1/current.json";
    private final Logger logger = LogManager.getLogger(this.getClass());

    /**
     * Gets weather.
     *
     * @param location the location
     * @return the weather
     */
    public Response getWeather(String location) {
        Client client = ClientBuilder.newClient();
        WebTarget target = client.target(BASE_URL)
                .queryParam("key", API_KEY)
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