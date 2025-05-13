package edu.matc.controller;

import edu.matc.entity.Post;
import edu.matc.persistence.GenericDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/deletePost")
public class DeletePost extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int postId = Integer.parseInt(req.getParameter("postId"));
        int sessionUserId = (int) req.getSession().getAttribute("userId");

        GenericDao<Post> postDao = new GenericDao<>(Post.class);
        Post postToDelete = postDao.getById(postId);

        if (postToDelete != null && postToDelete.getUser().getUser_id() == sessionUserId) {
            postDao.delete(postToDelete);
        }

        resp.sendRedirect("postFeed.jsp");
    }
}

