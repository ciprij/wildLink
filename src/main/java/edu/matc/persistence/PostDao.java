package edu.matc.persistence;

import edu.matc.entity.Post;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.criteria.HibernateCriteriaBuilder;

import java.util.List;

/**
 * The type Post dao.
 */
public class PostDao {

    private final Logger logger = LogManager.getLogger(this.getClass());
    /**
     * The Session factory.
     */
    SessionFactory sessionFactory = SessionFactoryProvider.getSessionFactory();

    /**
     * Gets by id.
     *
     * @param id the id
     * @return the by id
     */
    public Post getById(int id) {

        Session session = sessionFactory.openSession();
        Post post = session.get(Post.class, id);
        session.close();
        return post;

    }

    /**
     * Update.
     *
     * @param post the post
     */
    public void update(Post post) {

        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.merge(post);
        transaction.commit();
        session.close();

    }

    /**
     * Insert int.
     *
     * @param post the post
     * @return the int
     */
    public int insert(Post post) {

        int id = 0;
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.persist(post);
        transaction.commit();
        id = post.getPost_id();
        session.close();
        return id;

    }

    /**
     * Delete.
     *
     * @param post the post
     */
    public void delete(Post post) {

        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(post);
        transaction.commit();
        session.close();

    }

    /**
     * Gets all.
     *
     * @return the all
     */
    public List<Post> getAll() {

        Session session = sessionFactory.openSession();

        HibernateCriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Post> query = builder.createQuery(Post.class);
        Root<Post> root = query.from(Post.class);
        List<Post> post = session.createSelectionQuery(query).getResultList();

        logger.debug("The list of posts {}", post);
        session.close();

        return post;

    }


}
