package edu.matc.persistence;

import edu.matc.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.apache.logging.log4j.*;

public class UserDao extends GenericDao<User> {
    private final Logger logger = LogManager.getLogger(this.getClass());
    SessionFactory sessionFactory = SessionFactoryProvider.getSessionFactory();

    public UserDao() {
        super(User.class);
    }

    public User getByUsername(String username) {
        Session session = sessionFactory.getCurrentSession();
        User user = null;
        try {
            user = session.createQuery("from User where username = :username", User.class)
                    .setParameter("username", username)
                    .uniqueResult();
        } catch (Exception e) {
            logger.error("Error fetching user by username: ", e);
        } finally {
            session.close();
        }
        return user;
    }

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
}
