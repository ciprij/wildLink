package edu.matc.controller;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

/**
 * Servlet that handles user logout by invalidating the session.
 */
@WebServlet("/logout")
public class LogOut extends HttpServlet {

    /**
     * Handles GET requests to log the user out by ending the session and redirecting to the home page.
     *
     * @param req  the HTTP request
     * @param resp the HTTP response used to redirect to the home page
     * @throws IOException if an I/O error occurs during redirection
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        HttpSession session = req.getSession(false); // don’t create if not exists
        if (session != null) {
            session.invalidate(); // destroy session
        }
        resp.sendRedirect(req.getContextPath() + "/index.jsp");
    }
}
