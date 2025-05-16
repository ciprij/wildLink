package edu.matc.controller;

import edu.matc.entity.User;
import edu.matc.persistence.GenericDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Servlet to handle profile updates for the logged-in user.
 * Accepts updated first name, last name, and bio via POST and saves changes to the database.
 */
@WebServlet("/updateProfile")
public class UpdateProfile extends HttpServlet {

    /**
     * Handles POST requests to update the logged-in user's profile.
     *
     * @param req  the HttpServletRequest
     * @param resp the HttpServletResponse
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException      if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false);
        if (session == null || session.getAttribute("userId") == null) {
            resp.sendRedirect("login.jsp");
            return;
        }

        int userId = (int) session.getAttribute("userId");

        GenericDao<User> userDao = new GenericDao<>(User.class);
        User user = userDao.getById(userId);

        user.setFirst_name(req.getParameter("firstName"));
        user.setLast_name(req.getParameter("lastName"));
        user.setBio(req.getParameter("bio"));

        userDao.update(user);

        resp.sendRedirect("profile");
    }
}

