package edu.matc.persistence;

import edu.matc.entity.Post;
import edu.matc.entity.User;
import edu.matc.utilities.Database;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

/**
 * The type Post dao test.
 */
class PostDaoTest {

    /**
     * The Post dao.
     */
    PostDao postDao;
    GenericDao genericDao;

    /**
     * Sets up.
     */
    @BeforeEach
    void setUp() {

        Database database = Database.getInstance();
        database.runSQL("cleandb.sql");
        postDao = new PostDao();
        genericDao = new GenericDao(Post.class);

    }

    /**
     * Gets post by id.
     */
    @Test
    void getPostById() {
        User expectedUser = new User();
        expectedUser.setUser_id(1);

        Post expectedPost = new Post();
        expectedPost.setPost_id(1);
        expectedPost.setUser(expectedUser);
        expectedPost.setPost_subject("Indoor Bouldering");
        expectedPost.setPost_body("Indoor bouldering is really fun, it is even better when done with a friend!");

        Post actualPost = (Post) genericDao.getById(1);

        Assertions.assertEquals(expectedPost.getPost_subject(), actualPost.getPost_subject());
        Assertions.assertEquals(expectedPost.getPost_body(), actualPost.getPost_body());
        Assertions.assertEquals(expectedPost.getUser().getUser_id(), actualPost.getUser().getUser_id());
    }


    /**
     * Update post.
     */
    @Test
    void updatePost() {

        Post retrievedPost = (Post)genericDao.getById(1);
        Assertions.assertNotNull(retrievedPost);

        retrievedPost.setPost_subject("TESTING");
        retrievedPost.setPost_body("TESTING TESTING");
        genericDao.update(retrievedPost);

        Post actualPost = (Post)genericDao.getById(1);

        Assertions.assertEquals(retrievedPost, actualPost);
    }

    /**
     * Insert post.
     */

    @Test
    void insertPost() {
        PostDao postDao = new PostDao();
        UserDao userDao = new UserDao();

        User user = userDao.getById(1);

        Post newPost = new Post();
        newPost.setUser(user); // fully populated user
        newPost.setPost_subject("TESTING");
        newPost.setPost_body("TESTING TESTING");
        newPost.setDate_posted(Timestamp.valueOf(LocalDateTime.now()));

        int insertedPostId = postDao.insert(newPost);

        assertNotEquals(0, insertedPostId);

        Post retrievedPost = postDao.getById(insertedPostId);

        Post expectedPost = new Post();
        expectedPost.setPost_id(insertedPostId);
        expectedPost.setUser(user); // IMPORTANT: same user object
        expectedPost.setPost_subject("TESTING");
        expectedPost.setPost_body("TESTING TESTING");
        expectedPost.setDate_posted(retrievedPost.getDate_posted());
        // Match retrieved date, because LocalDateTime.now() might differ by milliseconds

        assertEquals(expectedPost, retrievedPost);
    }



    /**
     * Delete post.
     */
    @Test
        void deletePost() {

        genericDao.delete(genericDao.getById(1));
        Assertions.assertNull(genericDao.getById(1));

    }

    /**
     * Gets all posts.
     */
    @Test
    void getAllPosts() {

        List<Post> posts = genericDao.getAll();
        Assertions.assertEquals(3, posts.size());

    }
}