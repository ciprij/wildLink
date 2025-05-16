package edu.matc.controller;

import edu.matc.entity.User;
import edu.matc.entity.Post;
import edu.matc.persistence.GenericDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;

/**
 * Servlet that handles deletion of the currently logged-in user's account,
 * along with all of their associated posts.
 */
@WebServlet("/deleteAccount")
public class DeleteAccount extends HttpServlet {

    /**
     * Handles POST requests to delete the currently logged-in user and their posts.
     *
     * @param req  the Http Request object containing client request data
     * @param resp the Http Response object for sending the response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException      if an I/O error occurs during request handling
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false);

        if (session != null && session.getAttribute("userId") != null) {
            int userId = (int) session.getAttribute("userId");

            GenericDao<User> userDao = new GenericDao<>(User.class);
            GenericDao<Post> postDao = new GenericDao<>(Post.class);

            User userToDelete = userDao.getById(userId);

            if (userToDelete != null) {
                // Retrieve and delete all posts created by the user
                List<Post> userPosts = postDao.getByPropertyEqual("user", userToDelete);
                for (Post post : userPosts) {
                    postDao.delete(post);
                }

                // Delete the user account
                userDao.delete(userToDelete);

                // Terminate the session and redirect to confirmation
                session.invalidate();
                resp.sendRedirect("accountDeleted.jsp");

            } else {
                // If the user could not be found in the database
                resp.sendRedirect("profile.jsp?error=userNotFound");
            }

        } else {
            // If session is invalid or user is not logged in
            resp.sendRedirect("login.jsp");
        }
    }
}
