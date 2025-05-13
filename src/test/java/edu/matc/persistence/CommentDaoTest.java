package edu.matc.persistence;

import edu.matc.entity.Comment;
import edu.matc.entity.Post;
import edu.matc.utilities.Database;
import org.junit.Ignore;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * The type Comment dao test.
 */
class CommentDaoTest {

    private GenericDao<Comment> commentDao;
    private GenericDao<Post> postDao;

    /**
     * Sets up.
     */
    @BeforeEach
    void setUp() {
        Database.getInstance().runSQL("cleandb.sql");
        commentDao = new GenericDao<>(Comment.class);
        postDao = new GenericDao<>(Post.class);
    }

    /**
     * Insert success.
     */
    @Test
    void insertSuccess() {
        Post post = postDao.getById(1);
        Comment newComment = new Comment();
        newComment.setPost(post);
        newComment.setComment_body("Great post!");
        newComment.setComment_timestamp("2025-05-12 10:00:00");

        int id = commentDao.insert(newComment);
        assertNotEquals(0, id);

        Comment retrieved = commentDao.getById(id);
        assertEquals("Great post!", retrieved.getComment_body());
    }

    /**
     * Update success.
     */
    @Test
    void updateSuccess() {
        Comment comment = commentDao.getById(1);
        comment.setComment_body("Updated comment.");
        commentDao.update(comment);

        Comment updated = commentDao.getById(1);
        assertEquals("Updated comment.", updated.getComment_body());
    }

    /**
     * Delete success.
     */
    @Test
    void deleteSuccess() {
        Comment comment = commentDao.getById(1);
        assertNotNull(comment);
        commentDao.delete(comment);
        assertNull(commentDao.getById(1));
    }

    /**
     * Gets by id success.
     */
    @Test
    void getByIdSuccess() {
        Comment comment = commentDao.getById(1);
        assertNotNull(comment);
        assertTrue(comment.getComment_body().length() > 0);
    }

    /**
     * Gets by id not found.
     */
    @Test
    void getByIdNotFound() {
        assertNull(commentDao.getById(-1));
    }
}
