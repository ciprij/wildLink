package edu.matc.persistence;

import edu.matc.entity.Users;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.apache.logging.log4j.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.criteria.HibernateCriteriaBuilder;

import java.util.List;

/**
 * The type Users dao.
 */
public class UsersDao {

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
    public Users getUserById(int id) {

        Session session = sessionFactory.openSession();
        Users users = session.get(Users.class, id);
        session.close();
        return users;

    }

    /**
     * Save or update users.
     *
     * @param users the users
     */
    public void updateUsers(Users users) {

        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.merge(users);
        transaction.commit();
        session.close();

    }

    /**
     * Insert users int.
     *
     * @param users the users
     * @return the int
     */
    public int insertUsers(Users users) {

        int id = 0;
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.persist(users);
        transaction.commit();
        id = users.getUser_id();
        session.close();
        return id;

    }

    /**
     * Delete users.
     *
     * @param users the users
     */
    public void deleteUsers(Users users) {

        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(users);
        transaction.commit();
        session.close();

    }

    /**
     * Gets all users.
     *
     * @return the all users
     */
    public List<Users> getAllUsers() {

        Session session = sessionFactory.openSession();

        HibernateCriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Users> query = builder.createQuery(Users.class);
        Root<Users> root = query.from(Users.class);
        List<Users> users = session.createSelectionQuery(query).getResultList();

        logger.debug("The list of users {}", users);
        session.close();

        return users;

    }

}
