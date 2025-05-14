package edu.matc.controller;

import edu.matc.entity.Post;
import edu.matc.persistence.GenericDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet that handles deletion of a post by its owner.
 */
@WebServlet("/deletePost")
public class DeletePost extends HttpServlet {

    /**
     * Handles HTTP POST requests to delete a post.
     *
     * @param req  the Http Request containing the post ID and session info
     * @param resp the Http Response used to redirect after deletion
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException      if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int postId = Integer.parseInt(req.getParameter("postId"));
        int sessionUserId = (int) req.getSession().getAttribute("userId");

        GenericDao<Post> postDao = new GenericDao<>(Post.class);
        Post postToDelete = postDao.getById(postId);

        // Only allow deletion if the post belongs to the logged-in user
        if (postToDelete != null && postToDelete.getUser().getUser_id() == sessionUserId) {
            postDao.delete(postToDelete);
        }

        // Redirect back to the post feed
        resp.sendRedirect("postFeed.jsp");
    }
}
