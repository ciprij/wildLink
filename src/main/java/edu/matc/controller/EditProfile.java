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
 * Servlet to display the edit profile form for the logged-in user.
 * Retrieves the current user from the session and forwards to editProfile.jsp.
 */
@WebServlet("/editProfile")
public class EditProfile extends HttpServlet {

    /**
     * Handles GET requests to load the edit profile form.
     *
     * @param req  the HttpServletRequest
     * @param resp the HttpServletResponse
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException      if an I/O error occurs
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

        req.getRequestDispatcher("/editProfile.jsp").forward(req, resp);
    }
}

