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

        User retrievedUser = userDao.getUserById(1);
        Assertions.assertEquals(1, retrievedUser.getUser_id());
        Assertions.assertEquals("JCipri", retrievedUser.getUsername());
        Assertions.assertEquals("Jake", retrievedUser.getFirst_name());
        Assertions.assertEquals("Cipri", retrievedUser.getLast_name());
        Assertions.assertEquals("jcipri@madisoncollege.edu", retrievedUser.getEmail());

    }

    /**
     * Update.
     */
    @Test
    public void update() {

        User retrievedUser = userDao.getUserById(1);
        retrievedUser.setUser_id(1);
        retrievedUser.setFirst_name("John");
        retrievedUser.setLast_name("Doe");
        retrievedUser.setUsername("JDoe");
        retrievedUser.setEmail("jdoe@madisoncollege.edu");
        userDao.updateUser(retrievedUser);

        User actualUser = userDao.getUserById(1);
        Assertions.assertEquals(1, actualUser.getUser_id());
        Assertions.assertEquals("John", actualUser.getFirst_name());
        Assertions.assertEquals("Doe", actualUser.getLast_name());
        Assertions.assertEquals("JDoe", actualUser.getUsername());
        Assertions.assertEquals("jdoe@madisoncollege.edu", actualUser.getEmail());

    }

    /**
     * Insert.
     */
    @Test
    public void insert() {

        User retrievedUser = new User();
        retrievedUser.setUsername("JSmith");
        retrievedUser.setFirst_name("Jane");
        retrievedUser.setLast_name("Smith");
        retrievedUser.setEmail("jsmith@madisoncollege.edu");

        int insertedUserId = userDao.insertUser(retrievedUser);
        Assertions.assertNotEquals(0, insertedUserId);

        User insertedUser = userDao.getUserById(insertedUserId);
        Assertions.assertEquals(2, insertedUser.getUser_id());
        Assertions.assertEquals("Jane", insertedUser.getFirst_name());
        Assertions.assertEquals("Smith", insertedUser.getLast_name());
        Assertions.assertEquals("JSmith", insertedUser.getUsername());
        Assertions.assertEquals("jsmith@madisoncollege.edu", insertedUser.getEmail());

    }

    /**
     * Delete.
     */
    @Test
    public void delete() {

        userDao.deleteUser(userDao.getUserById(1));
        Assertions.assertNull(userDao.getUserById(1));

    }

    /**
     * Gets all.
     */
    @Test
    public void getAll() {

        List<User> retrievedUsers = userDao.getAllUsers();
        Assertions.assertEquals(1, retrievedUsers.size());

    }
}
