package edu.matc.controller;

import edu.matc.persistence.WeatherDao;
import edu.matc.entity.Response;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet that handles weather searches based on user input.
 */
@WebServlet("/WeatherSearch")
public class WeatherSearch extends HttpServlet {

    /**
     * Handles GET requests to search for weather data based on a location.
     *
     * @param request  the HTTP request containing the location parameter
     * @param response the HTTP response used to forward to the index page
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException      if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String location = request.getParameter("location"); // Get city from form input

        if (location != null && !location.trim().isEmpty()) {
            WeatherDao dao = new WeatherDao();
            Response weatherData = dao.getWeather(location);

            request.setAttribute("weatherData", weatherData); // Set weatherData attribute
        }

        // Forward to index.jsp
        RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");
        dispatcher.forward(request, response);
    }
}
