package edu.matc.persistence;

import edu.matc.entity.Post;
import edu.matc.utilities.Database;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

class PostDaoTest {

    PostDao postDao;

    @BeforeEach
    void setUp() {

        Database database = Database.getInstance();
        database.runSQL("cleandb.sql");
        postDao = new PostDao();

    }

    @Test
    void getPostById() {

        Post retrievedPost = postDao.getPostById(1);
        Assertions.assertNotNull(retrievedPost);
        Assertions.assertEquals(1, retrievedPost.getUser().getUser_id());
        Assertions.assertEquals("Indoor Bouldering", retrievedPost.getPost_subject());
        Assertions.assertEquals("Indoor bouldering is really fun, it is even better when done with a friend!",
                retrievedPost.getPost_body());

    }

    @Test
    void updatePost() {

        Post retrievedPost = postDao.getPostById(1);
        Assertions.assertNotNull(retrievedPost);
        retrievedPost.setPost_subject("TESTING");
        retrievedPost.setPost_body("TESTING TESTING");
        postDao.updatePost(retrievedPost);

        Post actualPost = postDao.getPostById(1);
        Assertions.assertEquals(retrievedPost.getPost_subject(), actualPost.getPost_subject());
        Assertions.assertEquals(retrievedPost.getPost_body(), actualPost.getPost_body());

    }

    @Test
    void insertPost() {



    }

    @Test
    void deletePost() {

        postDao.deletePost(postDao.getPostById(1));
        Assertions.assertNull(postDao.getPostById(1));

    }

    @Test
    void getAllPosts() {

        List<Post> posts = postDao.getAllPosts();
        Assertions.assertEquals(3, posts.size());

    }
}