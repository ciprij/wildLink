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
     * Gets user by id.
     *
     * @param id the id
     * @return the user by id
     */
    public User getById(int id) {

        Session session = sessionFactory.openSession();
        User user = session.get(User.class, id);
        session.close();
        return user;

    }

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
     * Save or update user.
     *
     * @param user the user
     */
    public void update(User user) {

        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.merge(user);
        transaction.commit();
        session.close();

    }

    /**
     * Insert user int.
     *
     * @param user the user
     * @return the int
     */
    public int insert(User user) {

        int id = 0;
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.persist(user);
        transaction.commit();
        id = user.getUser_id();
        session.close();
        return id;

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
     * Delete user.
     *
     * @param user the user
     */
    public void delete(User user) {

        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(user);
        transaction.commit();
        session.close();

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
