package edu.matc.persistence;

import edu.matc.entity.User;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.apache.logging.log4j.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.criteria.HibernateCriteriaBuilder;

import java.util.ArrayList;
import java.util.List;

/**
 * The type User dao.
 */
public class UserDao {

    private final Logger logger = LogManager.getLogger(this.getClass());
    /**
     * The Session factory.
     */
    SessionFactory sessionFactory = SessionFactoryProvider.getSessionFactory();

    /**
     * Gets by username.
     *
     * @param username the username
     * @return the by username
     */
    public User getByUsername(String username) {
        Session session = sessionFactory.openSession();
        User user = null;

        try {
            user = session.createQuery("from User where username = :username", User.class)
                    .setParameter("username", username)
                    .uniqueResult();
        } catch (Exception e) {
            logger.error("Error fetching user by Cognito username: ", e);
        } finally {
            session.close();
        }

        return user;
    }

    /**
     * Insert from claims.
     *
     * @param username  the username
     * @param email     the email
     * @param firstName the first name
     * @param lastName  the last name
     */
    public User insertFromClaims(String username, String email, String firstName, String lastName) {
        User existingUser = getByUsername(username);

        Session session = sessionFactory.openSession();
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

    /**
     * Gets all user.
     *
     * @return the all user
     */
    public List<User> getAll() {

        Session session = sessionFactory.openSession();

        HibernateCriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<User> query = builder.createQuery(User.class);
        Root<User> root = query.from(User.class);
        List<User> user = session.createSelectionQuery(query).getResultList();

        logger.debug("The list of users {}", user);
        session.close();

        return user;

    }

}
