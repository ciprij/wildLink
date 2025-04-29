package edu.matc.persistence;

import edu.matc.utilities.Database;
import edu.matc.entity.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

/**
 * The type Users dao test.
 */
public class UserDaoTest {

    /**
     * The Users dao.
     */
    UserDao userDao;

    /**
     * Sets up.
     */
    @BeforeEach
    public void setUp() {

        Database database = Database.getInstance();
        database.runSQL("cleandb.sql");
        userDao = new UserDao();

    }

    /**
     * Gets by id.
     */
    @Test
    public void getById() {

        User expectedUser = new User();
        expectedUser.setUser_id(1);
        expectedUser.setUsername("JCipri");
        expectedUser.setFirst_name("Jake");
        expectedUser.setLast_name("Cipri");
        expectedUser.setEmail("jcipri@madisoncollege.edu");
        expectedUser.setBio("software dev with a love for the outdoors!");

        User actualUser = userDao.getById(1);

        Assertions.assertEquals(expectedUser, actualUser);
    }

    /**
     * Update.
     */
    @Test
    public void update() {

        User retrievedUser = userDao.getById(1);
        retrievedUser.setFirst_name("John");
        retrievedUser.setLast_name("Doe");
        retrievedUser.setUsername("JDoe");
        retrievedUser.setEmail("jdoe@madisoncollege.edu");
        retrievedUser.setBio("bio");

        userDao.update(retrievedUser);

        User actualUser = userDao.getById(1);

        Assertions.assertEquals(retrievedUser, actualUser);

    }

    /**
     * Insert.
     */
    @Test
    public void insert() {

        User newUser = new User();
        newUser.setUsername("JSmith");
        newUser.setFirst_name("Jane");
        newUser.setLast_name("Smith");
        newUser.setEmail("jsmith@madisoncollege.edu");
        newUser.setBio("Just a gal that is not real");

        int insertedUserId = userDao.insert(newUser);
        Assertions.assertNotEquals(0, insertedUserId);

        User actualUser = userDao.getById(insertedUserId);

        newUser.setUser_id(insertedUserId); // IMPORTANT so equals() passes
        Assertions.assertEquals(newUser, actualUser);
    }

    /**
     * Delete.
     */
    @Test
    public void delete() {

        User userToDelete = userDao.getById(1);
        Assertions.assertNotNull(userToDelete);

        userDao.delete(userToDelete);

        User deletedUser = userDao.getById(1);
        Assertions.assertNull(deletedUser);
    }

    /**
     * Gets all.
     */
    @Test
    public void getAll() {

        List<User> users = userDao.getAll();
        Assertions.assertEquals(2, users.size());

        User expectedUser = new User();
        expectedUser.setUser_id(3);  // If you know the ID from cleandb.sql
        expectedUser.setUsername("AnotherUser");
        expectedUser.setFirst_name("Another");
        expectedUser.setLast_name("User");
        expectedUser.setEmail("another@example.com");
        expectedUser.setBio("Some bio");

    }
}
