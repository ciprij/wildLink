package edu.matc.controller;

import edu.matc.entity.Post;
import edu.matc.persistence.GenericDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

/**
 * Servlet that loads post data into the form for editing.
 */
@WebServlet("/editPostForm")
public class EditPostForm extends HttpServlet {

    /**
     * Handles GET requests to retrieve a post for editing.
     *
     * @param req  the HTTP request containing the post ID
     * @param resp the HTTP response used to forward to the edit form
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException      if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int postId = Integer.parseInt(req.getParameter("postId"));
        GenericDao<Post> postDao = new GenericDao<>(Post.class);
        Post post = postDao.getById(postId);

        req.setAttribute("post", post);
        req.getRequestDispatcher("/editPost.jsp").forward(req, resp);
    }
}
