package edu.matc.controller;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

/**
 * The type Log out.
 */
@WebServlet("/logout")
public class LogOut extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        HttpSession session = req.getSession(false); // don’t create if not exists
        if (session != null) {
            session.invalidate(); // destroy session
        }
        resp.sendRedirect(req.getContextPath() + "/index.jsp");
    }
}
