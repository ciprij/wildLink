package edu.matc.persistence;

import edu.matc.entity.User;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.apache.logging.log4j.*;

import java.util.List;

public class UserDao extends GenericDao<User> {
    private final Logger logger = LogManager.getLogger(this.getClass());

    public UserDao() {
        super(User.class);
    }

    public User insertFromClaims(String username, String email, String firstName, String lastName) {
        List<User> users = getByPropertyEqual("username", username);
        User existingUser = users.isEmpty() ? null : users.get(0);

        Session session = getSession();
        Transaction transaction = session.beginTransaction();

        User user;
        if (existingUser == null) {
            user = new User();
            user.setUsername(username);
            user.setEmail(email);
            user.setFirst_name(firstName);
            user.setLast_name(lastName);
            session.persist(user);
            logger.debug("Inserted new user with username: {}", username);
        } else {
            existingUser.setEmail(email);
            existingUser.setFirst_name(firstName);
            existingUser.setLast_name(lastName);
            session.merge(existingUser);
            user = existingUser;
            logger.debug("Updated user with username: {}", username);
        }

        transaction.commit();
        session.close();
        return user;
    }
}
