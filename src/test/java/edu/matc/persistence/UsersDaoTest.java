package edu.matc.persistence;

import edu.matc.utilities.Database;
import edu.matc.entity.Users;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

public class UsersDaoTest {

    UsersDao usersDao;

    @BeforeEach
    public void setUp() {

        Database database = Database.getInstance();
        database.runSQL("cleandb.sql");
        usersDao = new UsersDao();

    }

    @Test
    public void getById() {

        Users retrievedUser = usersDao.getUserById(1);
        Assertions.assertEquals(1, retrievedUser.getUser_id());
        Assertions.assertEquals("JCipri", retrievedUser.getUsername());
        Assertions.assertEquals("Jake", retrievedUser.getFirst_name());
        Assertions.assertEquals("Cipri", retrievedUser.getLast_name());
        Assertions.assertEquals("password123", retrievedUser.getPassword());
        Assertions.assertEquals("jcipri@madisoncollege.edu", retrievedUser.getEmail());

    }

    @Test
    public void update() {

        Users retrievedUser = usersDao.getUserById(1);
        retrievedUser.setUser_id(1);
        retrievedUser.setFirst_name("John");
        retrievedUser.setLast_name("Doe");
        retrievedUser.setUsername("JDoe");
        retrievedUser.setPassword("123");
        retrievedUser.setEmail("jdoe@madisoncollege.edu");
        usersDao.updateUsers(retrievedUser);

        Users actualUser = usersDao.getUserById(1);
        Assertions.assertEquals(1, actualUser.getUser_id());
        Assertions.assertEquals("John", actualUser.getFirst_name());
        Assertions.assertEquals("Doe", actualUser.getLast_name());
        Assertions.assertEquals("JDoe", actualUser.getUsername());
        Assertions.assertEquals("123", actualUser.getPassword());
        Assertions.assertEquals("jdoe@madisoncollege.edu", actualUser.getEmail());

    }

    @Test
    public void insert() {

        Users retrievedUser = new Users(2, "Jane",
                "Smith", "JSmith", "456", "jsmith@madisoncollege.edu");
        int insertedUserId = usersDao.insertUsers(retrievedUser);
        Assertions.assertNotEquals(0, insertedUserId);

        Users insertedUser = usersDao.getUserById(insertedUserId);
        Assertions.assertEquals(2, insertedUser.getUser_id());
        Assertions.assertEquals("Jane", insertedUser.getFirst_name());
        Assertions.assertEquals("Smith", insertedUser.getLast_name());
        Assertions.assertEquals("JSmith", insertedUser.getUsername());
        Assertions.assertEquals("456", insertedUser.getPassword());
        Assertions.assertEquals("jsmith@madisoncollege.edu", insertedUser.getEmail());

    }

    @Test
    public void delete() {

        usersDao.deleteUsers(usersDao.getUserById(1));
        Assertions.assertNull(usersDao.getUserById(1));

    }

    @Test
    public void getAll() {

        List<Users> retrievedUsers = usersDao.getAllUsers();
        Assertions.assertEquals(1, retrievedUsers.size());

    }
}
