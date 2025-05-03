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

        // Check if a username was submitted
        String username = req.getParameter("username");

        if (username != null && !username.trim().isEmpty()) {
            // Search by username only
            List<User> users = userData.getUsersByUsername(username.trim());
            req.setAttribute("users", users);
            req.setAttribute("searchQuery", username);
            req.setAttribute("totalPages", 1);
            req.setAttribute("currentPage", 1);
        } else {
            // Default to view all users paginated
            int page = 1;
            if (req.getParameter("page") != null) {
                try {
                    page = Integer.parseInt(req.getParameter("page"));
                } catch (NumberFormatException e) {
                    page = 1;
                }
            }

            List<User> users = userData.getUsersByPage(page, 25);
            req.setAttribute("users", users);

            int totalUsers = userData.getAllUsers().size();
            int totalPages = (int) Math.ceil(totalUsers / 25.0);
            req.setAttribute("totalPages", totalPages);
            req.setAttribute("currentPage", page);
        }

        RequestDispatcher dispatcher = req.getRequestDispatcher("/results.jsp");
        dispatcher.forward(req, resp);
    }
}

