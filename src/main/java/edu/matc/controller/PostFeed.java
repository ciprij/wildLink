package edu.matc.controller;

import edu.matc.entity.Post;
import edu.matc.persistence.PostDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Servlet that retrieves all posts sorted by most recent and forwards to the post feed page.
 */
@WebServlet("/postFeed")
public class PostFeed extends HttpServlet {

    /**
     * Handles GET requests to display the post feed.
     *
     * @param req  the HTTP request
     * @param resp the HTTP response used to forward to the JSP
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException      if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PostDao postDao = new PostDao();
        List<Post> posts = postDao.getAllPostsSortedByDateDesc();
        req.setAttribute("posts", posts);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/postFeed.jsp");
        dispatcher.forward(req, resp);
    }
}
