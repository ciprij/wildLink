package edu.matc.persistence;

import edu.matc.entity.Like;
import edu.matc.entity.Post;
import edu.matc.utilities.Database;
import org.junit.Ignore;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * The type Like dao test.
 */
class LikeDaoTest {

    private GenericDao<Like> likeDao;
    private GenericDao<Post> postDao;

    /**
     * Sets up.
     */
    @BeforeEach
    void setUp() {
        Database.getInstance().runSQL("cleandb.sql");
        likeDao = new GenericDao<>(Like.class);
        postDao = new GenericDao<>(Post.class);
    }

    /**
     * Insert success.
     */
    @Test
    void insertSuccess() {
        Post post = postDao.getById(1);
        Like newLike = new Like();
        newLike.setLike_total(1);
        newLike.setPost(post);

        int id = likeDao.insert(newLike);
        assertNotEquals(0, id);

        Like retrieved = likeDao.getById(id);
        assertEquals(post.getPost_id(), retrieved.getPost().getPost_id());
    }

    /**
     * Update success.
     */
    @Test
    void updateSuccess() {
        Like like = likeDao.getById(1);
        like.setLike_total(99);
        likeDao.update(like);

        Like updated = likeDao.getById(1);
        assertEquals(99, updated.getLike_total());
    }

    /**
     * Delete success.
     */
    @Test
    void deleteSuccess() {
        Like like = likeDao.getById(1);
        assertNotNull(like);
        likeDao.delete(like);
        assertNull(likeDao.getById(1));
    }

    /**
     * Gets by id success.
     */
    @Test
    void getByIdSuccess() {
        Like like = likeDao.getById(1);
        assertNotNull(like);
        assertEquals(3, like.getLike_total());
    }

    /**
     * Gets by id not found.
     */
    @Test
    void getByIdNotFound() {
        assertNull(likeDao.getById(-1));
    }
}
