package edu.matc.persistence;

import edu.matc.entity.Post;
import edu.matc.entity.User;
import edu.matc.utilities.Database;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Integration tests for Post entity using GenericDao.
 */
class PostDaoTest {

    private PostDao postDao;
    private UserDao userDao;

    /**
     * Sets up.
     */
    @BeforeEach
    void setUp() {
        Database database = Database.getInstance();
        database.runSQL("cleandb.sql");

        postDao = new PostDao();
        userDao = new UserDao();
    }

    /**
     * Gets by id success.
     */
    @Test
    void getByIdSuccess() {
        Post retrieved = postDao.getById(1);
        assertNotNull(retrieved);
        assertEquals("Indoor Bouldering", retrieved.getPost_subject());
    }

    /**
     * Gets all success.
     */
    @Test
    void getAllSuccess() {
        List<Post> posts = postDao.getAll();
        assertFalse(posts.isEmpty());
    }

    /**
     * Insert success.
     */
    @Test
    void insertSuccess() {
        User user = userDao.getById(1);
        Post newPost = new Post();
        newPost.setUser(user);
        newPost.setPost_subject("Test Insert");
        newPost.setPost_body("Insert test body");
        newPost.setDate_posted(Timestamp.valueOf(LocalDateTime.now()));

        int id = postDao.insert(newPost);
        assertNotEquals(0, id);

        Post insertedPost = postDao.getById(id);
        assertEquals("Test Insert", insertedPost.getPost_subject());
    }

    /**
     * Update success.
     */
    @Test
    void updateSuccess() {
        Post postToUpdate = postDao.getById(1);
        postToUpdate.setPost_subject("Updated Subject");
        postDao.update(postToUpdate);

        Post updatedPost = postDao.getById(1);
        assertEquals("Updated Subject", updatedPost.getPost_subject());
    }

    /**
     * Delete success.
     */
    @Test
    void deleteSuccess() {
        Post postToDelete = postDao.getById(1);
        assertNotNull(postToDelete);

        postDao.delete(postToDelete);

        Post deletedPost = postDao.getById(1);
        assertNull(deletedPost);
    }

    /**
     * Gets by id not found.
     */
    @Test
    void getByIdNotFound() {
        Post missingPost = postDao.getById(-1);
        assertNull(missingPost);
    }

    /**
     * Gets all posts sorted by date desc success.
     */
    @Test
    void getAllPostsSortedByDateDescSuccess() {
        List<Post> sortedPosts = postDao.getAllPostsSortedByDateDesc();

        assertNotNull(sortedPosts);
        assertTrue(sortedPosts.size() >= 2, "Should return multiple posts for a valid sort test");

        for (int i = 1; i < sortedPosts.size(); i++) {
            assertTrue(
                    sortedPosts.get(i - 1).getDate_posted().compareTo(sortedPosts.get(i).getDate_posted()) >= 0,
                    "Posts are not sorted in descending order by date_posted"
            );
        }
    }

}
