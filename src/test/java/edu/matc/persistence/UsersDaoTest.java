package edu.matc.persistence;

import edu.matc.utilities.Database;
import edu.matc.entity.Users;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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
        Assertions.assertEquals("Jake", retrievedUser.getFirst_name());
        Assertions.assertEquals("Cipri", retrievedUser.getLast_name());
        Assertions.assertEquals("JCipri", retrievedUser.getUsername());
        Assertions.assertEquals("password123", retrievedUser.getPassword());
        Assertions.assertEquals("jcipri@madisoncollege.edu", retrievedUser.getEmail());

    }

    @Test
    public void saveOrUpdate() {

    }

    @Test
    public void insert() {

    }

    @Test
    public void delete() {

    }

    @Test
    public void getAll() {

    }
}
