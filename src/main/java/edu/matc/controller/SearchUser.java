package edu.matc.controller;

import edu.matc.persistence.UserData;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.annotation.*;
import java.io.IOException;

/**
 * A simple servlet to get a list of all users.
 */

@WebServlet(
        urlPatterns = {"/searchUser"}
)

public class SearchUser extends HttpServlet {

    /**
     * Handles HTTP GET requests by retrieving all users and forwarding the request to the results page.
     *
     * @param req  the HttpServletRequestobject that contains the request the client made
     * @param resp the HttpServletResponse object that contains the response the servlet sends
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException      if an input or output error occurs while handling the request
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        UserData userData = new UserData();
        req.setAttribute("users", userData.getAllUsers());
        RequestDispatcher dispatcher = req.getRequestDispatcher("/results.jsp");
        dispatcher.forward(req, resp);
    }

}