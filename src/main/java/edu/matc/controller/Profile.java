package edu.matc.controller;

import edu.matc.entity.User;
import edu.matc.persistence.GenericDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

/**
 * Loads profile data for the currently logged-in user.
 */
@WebServlet("/profile")
public class Profile extends HttpServlet {
    /**
     * Handles HTTP GET requests to display the logged-in user's profile.
     *
     * @param req  the Http Request object containing client request information
     * @param resp the Http Response object used to respond to the client
     * @throws ServletException if the request cannot be handled
     * @throws IOException      if an I/O error occurs during processing
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false);

        if (session == null || session.getAttribute("userId") == null) {
            resp.sendRedirect("login.jsp");
            return;
        }

        int userId = (int) session.getAttribute("userId");
        GenericDao<User> userDao = new GenericDao<>(User.class);
        User user = userDao.getById(userId);

        req.setAttribute("user", user);
        req.getRequestDispatcher("/profile.jsp").forward(req, resp);
    }
}
