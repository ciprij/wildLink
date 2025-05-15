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
 * Servlet that handles updating an existing post.
 */
@WebServlet("/updatePost")
public class UpdatePost extends HttpServlet {

    /**
     * Handles POST requests to update a post, if the current user is the owner.
     *
     * @param req  the HTTP request containing updated post data
     * @param resp the HTTP response used to redirect after processing
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException      if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int postId = Integer.parseInt(req.getParameter("postId"));
        int sessionUserId = (int) req.getSession().getAttribute("userId");

        GenericDao<Post> postDao = new GenericDao<>(Post.class);
        Post postToUpdate = postDao.getById(postId);

        // Only allow update if the user owns the post
        if (postToUpdate != null && postToUpdate.getUser().getUser_id() == sessionUserId) {
            postToUpdate.setPost_subject(req.getParameter("post_subject"));
            postToUpdate.setPost_body(req.getParameter("post_body"));
            postDao.update(postToUpdate);
        }

        resp.sendRedirect("postFeed");
    }
}
