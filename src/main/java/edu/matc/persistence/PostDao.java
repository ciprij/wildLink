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
public class PostDao extends GenericDao<Post> {

    private final Logger logger = LogManager.getLogger(this.getClass());

    /**
     * Instantiates a new Post dao.
     */
    public PostDao() {
        super(Post.class);
    }

    public List<Post> getAllPostsSortedByDateDesc() {
        Session session = getSession();
        return session.createQuery("FROM Post ORDER BY date_posted DESC", Post.class).list();
    }

}
