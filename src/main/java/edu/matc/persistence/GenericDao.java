package edu.matc.persistence;

import edu.matc.entity.Post;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.criteria.HibernateCriteriaBuilder;

import java.util.List;

/**
 * The type Generic dao.
 *
 * @param <T> the type parameter
 */
public class GenericDao<T> {
    private Class<T> type;
    private final Logger logger = LogManager.getLogger(this.getClass());


    /**
     * Instantiates a new Generic dao.
     *
     * @param type the entity type, for example, user
     */
    public GenericDao(Class<T> type) {
        this.type = type;
    }

    /**
     * Gets by id.
     *
     * @param <T> the type parameter
     * @param id  the id
     * @return the by id
     */
    public <T>T getById(int id) {

        Session session = getSession();
        T entity = (T)session.get(type, id);
        session.close();
        return entity;

    }

    /**
     * Update.
     *
     * @param entity the entity
     */
    public void update (T entity) {

        Session session = getSession();
        Transaction transaction = session.beginTransaction();
        session.merge(entity);
        transaction.commit();
        session.close();

    }

    /**
     * Insert int.
     *
     * @param entity the entity
     * @return the int
     */
    public int insert(T entity) {

        Session session = getSession();
        Transaction transaction = session.beginTransaction();
        int id = (int) session.save(entity);
        transaction.commit();
        session.close();
        return id;

    }

    /**
     * Delete.
     *
     * @param entity the entity
     */
    public void delete(T entity) {

        Session session = getSession();
        Transaction transaction = session.beginTransaction();
        session.delete(entity);
        transaction.commit();
        session.close();

    }

    /**
     * Gets all.
     *
     * @return the all
     */
    public List<T> getAll() {

        Session session = getSession();

        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<T> query = builder.createQuery(type);
        Root<T> root = query.from(type);
        List<T> list = session.createSelectionQuery(query).getResultList();
        session.close();
        return list;

    }

    /**
     * Get entities where a property matches a specific value.
     *
     * @param propertyName the name of the property (e.g., "username", "email", "user.id")
     * @param value        the value to match
     * @return list of matching entities
     */
    public List<T> getByPropertyEqual(String propertyName, Object value) {
        Session session = getSession();
        String hql = "from " + type.getName() + " where " + propertyName + " = :value";
        List<T> results = session.createQuery(hql, type)
                .setParameter("value", value)
                .getResultList();
        session.close();
        return results;
    }

    /**
     * Gets by property like.
     *
     * @param propertyName the property name
     * @param value        the value
     * @return the by property like
     */
    public List<T> getByPropertyLike(String propertyName, String value) {
        Session session = getSession();
        String hql = "from " + type.getName() + " where " + propertyName + " like :value";
        List<T> results = session.createQuery(hql, type)
                .setParameter("value", "%" + value + "%")
                .getResultList();
        session.close();
        return results;
    }

    /**
     * Gets all paged.
     *
     * @param page     the page
     * @param pageSize the page size
     * @return the all paged
     */
    public List<T> getAllPaged(int page, int pageSize) {
        Session session = getSession();
        List<T> results = session.createQuery("from " + type.getName(), type)
                .setFirstResult((page - 1) * pageSize)
                .setMaxResults(pageSize)
                .getResultList();
        session.close();
        return results;
    }

    /**
     * Gets session.
     *
     * @return the session
     */
    protected Session getSession() {
        return SessionFactoryProvider.getSessionFactory().openSession();
    }
}
