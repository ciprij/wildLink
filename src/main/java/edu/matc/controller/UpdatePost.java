package edu.matc.controller;

import edu.matc.entity.Post;
import edu.matc.persistence.GenericDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/updatePost")
public class UpdatePost extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int postId = Integer.parseInt(req.getParameter("postId"));
        int sessionUserId = (int) req.getSession().getAttribute("userId");

        GenericDao<Post> postDao = new GenericDao<>(Post.class);
        Post postToUpdate = postDao.getById(postId);

        if (postToUpdate != null && postToUpdate.getUser().getUser_id() == sessionUserId) {
            postToUpdate.setPost_subject(req.getParameter("post_subject"));
            postToUpdate.setPost_body(req.getParameter("post_body"));
            postDao.update(postToUpdate);
        }

        resp.sendRedirect("postFeed.jsp");
    }
}

