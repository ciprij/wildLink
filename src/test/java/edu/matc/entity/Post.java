package edu.matc.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

import java.time.LocalDateTime;

/**
 * The type Post.
 */
@Entity(name = "Post")
@Table(name = "posts")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private int post_id;

    @ManyToOne
    private User user;

    @Column
    private String post_subject;

    @Column
    private String post_body;

    @Column
    private LocalDateTime post_date;

    /**
     * Instantiates a new Post.
     */
    public Post() {

    }

    /**
     * Instantiates a new Post.
     *
     * @param user         the user
     * @param post_subject the post subject
     * @param post_body    the post body
     * @param post_date    the post date
     */
    public Post(User user, String post_subject, String post_body, LocalDateTime post_date) {
        this.user = user;
        this.post_subject = post_subject;
        this.post_body = post_body;
        this.post_date = post_date;
    }

    /**
     * Gets post id.
     *
     * @return the post id
     */
    public int getPost_id() {
        return post_id;
    }

    /**
     * Sets post id.
     *
     * @param post_id the post id
     */
    public void setPost_id(int post_id) {
        this.post_id = post_id;
    }

    /**
     * Gets user.
     *
     * @return the user
     */
    public User getUser() {
        return user;
    }

    /**
     * Sets user.
     *
     * @param user the user
     */
    public void setUser(User user) {
        this.user = user;
    }

    /**
     * Gets post subject.
     *
     * @return the post subject
     */
    public String getPost_subject() {
        return post_subject;
    }

    /**
     * Sets post subject.
     *
     * @param post_subject the post subject
     */
    public void setPost_subject(String post_subject) {
        this.post_subject = post_subject;
    }

    /**
     * Gets post body.
     *
     * @return the post body
     */
    public String getPost_body() {
        return post_body;
    }

    /**
     * Sets post body.
     *
     * @param post_body the post body
     */
    public void setPost_body(String post_body) {
        this.post_body = post_body;
    }

    /**
     * Gets post date.
     *
     * @return the post date
     */
    public LocalDateTime getPost_date() {
        return post_date;
    }

    /**
     * Sets post date.
     *
     * @param post_date the post date
     */
    public void setPost_date(LocalDateTime post_date) {
        this.post_date = post_date;
    }

    @Override
    public String toString() {
        return "Post{" +
                "post_id=" + post_id +
                ", user=" + user +
                ", post_subject='" + post_subject + '\'' +
                ", post_body='" + post_body + '\'' +
                ", post_date=" + post_date +
                '}';
    }
}
