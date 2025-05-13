package edu.matc.controller;

import edu.matc.entity.Post;
import edu.matc.persistence.GenericDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

/**
 * The type Edit post form.
 */
@WebServlet("/editPostForm")
public class EditPostForm extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int postId = Integer.parseInt(req.getParameter("postId"));
        GenericDao<Post> postDao = new GenericDao<>(Post.class);
        Post post = postDao.getById(postId);

        req.setAttribute("post", post);
        req.getRequestDispatcher("/editPost.jsp").forward(req, resp);
    }
}
