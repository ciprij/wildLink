package edu.matc.controller;

import edu.matc.entity.User;
import edu.matc.persistence.UserDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;

/**
 * Servlet that handles searching for users by username or listing users with pagination.
 */
@WebServlet("/searchUser")
public class SearchUser extends HttpServlet {
    private static final int PAGE_SIZE = 25;

    /**
     * Handles GET requests to either search users by username or return a paginated list of users.
     *
     * @param req  the HTTP request containing search parameters or pagination info
     * @param resp the HTTP response used to forward to the results page
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException      if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserDao userDao = new UserDao();

        String username = req.getParameter("username");

        if (username != null && !username.trim().isEmpty()) {
            // Search by username using LIKE
            List<User> users = userDao.getByPropertyLike("username", username.trim());
            req.setAttribute("users", users);
            req.setAttribute("searchQuery", username);
            req.setAttribute("totalPages", 1);
            req.setAttribute("currentPage", 1);
        } else {
            // Paginated user view
            int page = 1;
            if (req.getParameter("page") != null) {
                try {
                    page = Integer.parseInt(req.getParameter("page"));
                } catch (NumberFormatException ignored) {}
            }

            List<User> users = userDao.getAllPaged(page, PAGE_SIZE);
            req.setAttribute("users", users);

            int totalUsers = userDao.getAll().size();
            int totalPages = (int) Math.ceil(totalUsers / (double) PAGE_SIZE);
            req.setAttribute("totalPages", totalPages);
            req.setAttribute("currentPage", page);
        }

        RequestDispatcher dispatcher = req.getRequestDispatcher("/results.jsp");
        dispatcher.forward(req, resp);
    }
}
