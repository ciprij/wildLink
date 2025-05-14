package edu.matc.controller;

import edu.matc.entity.Post;
import edu.matc.entity.User;
import edu.matc.persistence.PostDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Timestamp;

/**
 * Servlet that handles adding a new post to the system.
 */
@WebServlet("/addPost")
public class AddPost extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private PostDao postDao;

    /**
     * Initializes the servlet and its required DAO.
     */
    @Override
    public void init() {
        postDao = new PostDao();  // Initialize PostDao
    }

    /**
     * Handles HTTP POST requests for creating a new post.
     *
     * @param request  the Http Request containing form data
     * @param response the Http Response used to redirect or forward
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException      if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieve form parameters
        String postSubject = request.getParameter("title");
        String postBody = request.getParameter("content");

        // Get the logged-in user
        HttpSession session = request.getSession();
        User loggedInUser = (User) session.getAttribute("loggedInUser");
        System.out.println("The logged in user is --> " + loggedInUser);

        // Check if the user is logged in
        if (loggedInUser == null) {
            String originalDestination = "addPost.jsp";
            response.sendRedirect("logIn?state=" + java.net.URLEncoder.encode(originalDestination, "UTF-8"));
            return;
        }

        // Create and populate a new Post object
        Post post = new Post();
        post.setPost_subject(postSubject);
        post.setPost_body(postBody);
        post.setUser(loggedInUser);
        post.setDate_posted(new Timestamp(System.currentTimeMillis()));

        // Insert the post into the database
        int postId = postDao.insert(post);

        // If successful, forward to the view page; otherwise, redirect to retry
        if (postId > 0) {
            Post insertedPost = postDao.getById(postId);
            request.setAttribute("post", insertedPost);
            request.getRequestDispatcher("/viewPost.jsp").forward(request, response);
        } else {
            response.sendRedirect("addPost.jsp");
        }
    }

    /**
     * Cleans up any resources when the servlet is destroyed.
     */
    @Override
    public void destroy() {
        postDao = null;
    }
}
