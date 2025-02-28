package edu.matc.persistence;

import edu.matc.entity.User;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.apache.logging.log4j.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.criteria.HibernateCriteriaBuilder;

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
    public User getUserById(int id) {

        Session session = sessionFactory.openSession();
        User user = session.get(User.class, id);
        session.close();
        return user;

    }

    /**
     * Save or update user.
     *
     * @param user the user
     */
    public void updateUser(User user) {

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
    public int insertUser(User user) {

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
     * Delete user.
     *
     * @param user the user
     */
    public void deleteUser(User user) {

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
    public List<User> getAllUsers() {

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
