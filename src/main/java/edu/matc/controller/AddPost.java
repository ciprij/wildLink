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
 * The type Add post.
 */
@WebServlet("/addPost")
public class AddPost extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private PostDao postDao;

    @Override
    public void init() {
        postDao = new PostDao();  // Initialize PostDao
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieve form parameters
        String postSubject = request.getParameter("title");
        String postBody = request.getParameter("content");

        // Get the logged-in user (this assumes you're storing a user in the session)
        HttpSession session = request.getSession();
        User loggedInUser = (User) session.getAttribute("loggedInUser");

        // Check if the user is logged in
        if (loggedInUser == null) {
            String originalDestination = "addPost.jsp";
            response.sendRedirect("logIn?state=" + java.net.URLEncoder.encode(originalDestination, "UTF-8"));

            return;
        }

        // Create a new Post object
        Post post = new Post();
        post.setPost_subject(postSubject);
        post.setPost_body(postBody);
        post.setUser(loggedInUser); // Set the user as the logged-in user
        post.setDate_posted(new Timestamp(System.currentTimeMillis())); // Set the current time as the post date

        // Insert the post into the database using the PostDao
        int postId = postDao.insert(post);

        // Check if the post was created successfully
        if (postId > 0) {
            try {
                response.sendRedirect("index.jsp"); // Redirect to homepage after successful post creation
                System.out.println("post added");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } else {
            response.sendRedirect("addPost.jsp"); // Redirect to error page if insertion failed
            System.out.println("post not added!");
        }
    }

    @Override
    public void destroy() {
        postDao = null;  // Cleanup resources if needed
    }
}
