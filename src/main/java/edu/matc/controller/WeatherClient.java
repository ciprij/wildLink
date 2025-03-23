package edu.matc.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import edu.matc.entity.Current;
import edu.matc.entity.Response;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class WeatherClient {

    private static final String API_KEY = "6dbbd747934e44bf84312529252303";
    private static final String BASE_URL = "http://api.weatherapi.com/v1/current.json";

    public static String getCurrentWeather(String location) {
        // Build the request URL
        String url = BASE_URL + "?key=" + API_KEY + "&q=" + location + "&aqi=no";

        // Create HTTP client
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .header("Accept", "application/json")
                .GET()
                .build();

        try {
            // Send request and get response
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            // Convert JSON response to Response object
            ObjectMapper objectMapper = new ObjectMapper();
            Response weatherResponse = objectMapper.readValue(response.body(), Response.class);

            // Extract the city name and temperature in Fahrenheit
            String city = weatherResponse.getLocation().getName();
            Object tempF = weatherResponse.getCurrent().getTempF();

            // Return a formatted string with city name and temperature
            return "City: " + city + ", Temperature: " + tempF + "°F";

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
            return "Failed to fetch weather data.";
        }
    }

    public static void main(String[] args) {
        String location = "Madison"; // Example location
        String weatherInfo = getCurrentWeather(location);

        System.out.println(weatherInfo);
    }
}
