package edu.matc.controller;

import edu.matc.entity.User;
import edu.matc.persistence.UserData;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

/**
 * A simple servlet to get a list of all users.
 */

@WebServlet("/searchUser")
public class SearchUser extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserData userData = new UserData();

        // Get the current page from the request (default to 1)
        int page = 1;
        if (req.getParameter("page") != null) {
            try {
                page = Integer.parseInt(req.getParameter("page"));
            } catch (NumberFormatException e) {
                page = 1; // Default to page 1 if the parameter is invalid
            }
        }

        // Get users for the current page (25 users per page)
        List<User> users = userData.getUsersByPage(page, 25);
        req.setAttribute("users", users);

        // Calculate the total number of pages (total users divided by 25)
        int totalUsers = userData.getAllUsers().size();  // Get the total count of users
        int totalPages = (int) Math.ceil(totalUsers / 25.0);  // Calculate total pages
        req.setAttribute("totalPages", totalPages);
        req.setAttribute("currentPage", page);

        // Forward the request to the results page
        RequestDispatcher dispatcher = req.getRequestDispatcher("/results.jsp");
        dispatcher.forward(req, resp);
    }
}
