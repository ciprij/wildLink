package edu.matc.persistence;

import edu.matc.entity.Post;
import edu.matc.entity.User;
import edu.matc.utilities.Database;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;

/**
 * The type Post dao test.
 */
class PostDaoTest {

    /**
     * The Post dao.
     */
    PostDao postDao;

    /**
     * Sets up.
     */
    @BeforeEach
    void setUp() {

        Database database = Database.getInstance();
        database.runSQL("cleandb.sql");
        postDao = new PostDao();

    }

    /**
     * Gets post by id.
     */
    @Test
    void getPostById() {

        Post retrievedPost = postDao.getPostById(1);
        Assertions.assertNotNull(retrievedPost);
        Assertions.assertEquals(1, retrievedPost.getUser().getUser_id());
        Assertions.assertEquals("Indoor Bouldering", retrievedPost.getPost_subject());
        Assertions.assertEquals("Indoor bouldering is really fun, it is even better when done with a friend!",
                retrievedPost.getPost_body());

    }

    /**
     * Update post.
     */
    @Test
    void updatePost() {

        Post retrievedPost = postDao.getPostById(1);
        Assertions.assertNotNull(retrievedPost);
        retrievedPost.setPost_subject("TESTING");
        retrievedPost.setPost_body("TESTING TESTING");
        postDao.updatePost(retrievedPost);

        Post actualPost = postDao.getPostById(1);
        Assertions.assertEquals(retrievedPost.getPost_subject(), actualPost.getPost_subject());
        Assertions.assertEquals(retrievedPost.getPost_body(), actualPost.getPost_body());

    }

    /**
     * #TODO Not working as intended - rethink - the way the time is checked is causing issues, unable to run with Tomcat
     * Insert post.

    @Test
    void insertPost() {

        Post newPost = new Post();

        User user = new User();
        user.setUser_id(1);

        newPost.setUser(user);
        newPost.setPost_subject("TESTING");
        newPost.setPost_body("TESTING TESTING");
        newPost.setDate_posted(Timestamp.valueOf(LocalDateTime.now()));
        postDao.insertPost(newPost);

        Timestamp expectedTimestamp = Timestamp.valueOf(LocalDateTime.now());
        expectedTimestamp.setNanos(0);

        Post actualPost = postDao.getPostById(4);
        Assertions.assertEquals(actualPost.getDate_posted().toLocalDateTime().truncatedTo(ChronoUnit.SECONDS),
                expectedTimestamp.toLocalDateTime().truncatedTo(ChronoUnit.SECONDS));
        Assertions.assertEquals(actualPost.getPost_subject(), newPost.getPost_subject());
        Assertions.assertEquals(actualPost.getPost_body(), newPost.getPost_body());


    }
     */

    /**
     * Delete post.
     */
    @Test
        void deletePost() {

        postDao.deletePost(postDao.getPostById(1));
        Assertions.assertNull(postDao.getPostById(1));

    }

    /**
     * Gets all posts.
     */
    @Test
    void getAllPosts() {

        List<Post> posts = postDao.getAllPosts();
        Assertions.assertEquals(3, posts.size());

    }
}