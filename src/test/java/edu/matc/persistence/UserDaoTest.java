package edu.matc.persistence;

import edu.matc.entity.Post;
import edu.matc.entity.User;
import edu.matc.utilities.Database;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Integration tests for User entity using GenericDao.
 */
class UserDaoTest {

    private UserDao userDao;

    /**
     * Sets up.
     */
    @BeforeEach
    void setUp() {
        Database database = Database.getInstance();
        database.runSQL("cleandb.sql");

        userDao = new UserDao();
    }

    /**
     * Gets by id success.
     */
    @Test
    void getByIdSuccess() {
        User user = userDao.getById(1);
        assertNotNull(user);
        assertEquals("JCipri", user.getUsername());
    }

    /**
     * Gets all success.
     */
    @Test
    void getAllSuccess() {
        List<User> users = userDao.getAll();
        assertFalse(users.isEmpty());
    }

    /**
     * Update success.
     */
    @Test
    void updateSuccess() {
        User userToUpdate = userDao.getById(1);
        userToUpdate.setEmail("updated@example.com");

        userDao.update(userToUpdate);

        User updatedUser = userDao.getById(1);
        assertEquals("updated@example.com", updatedUser.getEmail());
    }

    /**
     * Delete success.
     */
    @Test
    void deleteSuccess() {
        User userToDelete = userDao.getById(2);
        assertNotNull(userToDelete);

        userDao.delete(userToDelete);

        User deletedUser = userDao.getById(2);
        assertNull(deletedUser);
    }

    /**
     * Gets by id not found.
     */
    @Test
    void getByIdNotFound() {
        User user = userDao.getById(-1);
        assertNull(user);
    }

    /**
     * Insert from claims inserts new user.
     */
    @Test
    void insertFromClaimsInsertsNewUser() {
        String username = "new.claim.user";
        String email = "claim@example.com";
        String firstName = "Claim";
        String lastName = "User";

        User result = userDao.insertFromClaims(username, email, firstName, lastName);

        assertNotNull(result);
        assertTrue(result.getUser_id() > 0);
        assertEquals(username, result.getUsername());
        assertEquals(email, result.getEmail());
        assertEquals(firstName, result.getFirst_name());
        assertEquals(lastName, result.getLast_name());
    }

    /**
     * Insert from claims updates existing user.
     */
    @Test
    void insertFromClaimsUpdatesExistingUser() {
        String existingUsername = "JCipri";
        String newEmail = "updated@example.com";
        String newFirstName = "UpdatedFirst";
        String newLastName = "UpdatedLast";

        User result = userDao.insertFromClaims(existingUsername, newEmail, newFirstName, newLastName);

        assertNotNull(result);
        assertEquals(existingUsername, result.getUsername());
        assertEquals(newEmail, result.getEmail());
        assertEquals(newFirstName, result.getFirst_name());
        assertEquals(newLastName, result.getLast_name());
    }

    /**
     * Tests that a user and their posts can be deleted.
     */
    @Test
    void deleteUserWithPosts_deletesPostsToo() {
        User user = userDao.getById(1); // JCipri has 3 posts
        assertNotNull(user);

        // Make sure user has posts first
        PostDao postDao = new PostDao();
        List<Post> userPosts = postDao.getByPropertyEqual("user", user);
        assertEquals(3, userPosts.size(), "User should have 3 posts");

        // Manually delete posts like your servlet does
        for (Post post : userPosts) {
            postDao.delete(post);
        }

        // Now delete the user
        userDao.delete(user);

        assertNull(userDao.getById(1), "User should be deleted");
        assertTrue(postDao.getByPropertyEqual("user", user).isEmpty(), "Posts should be deleted with user");
    }

}
