package edu.matc.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

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
    @JoinColumn(name = "user_id")
    private User user;

    @Column
    private String post_subject;

    @Column
    private String post_body;

    @Column
    private Timestamp date_posted;

    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Comment> comments = new ArrayList<>();

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
     * @param date_posted    the post date
     */
    public Post(User user, String post_subject, String post_body, Timestamp date_posted) {
        this.user = user;
        this.post_subject = post_subject;
        this.post_body = post_body;
        this.date_posted = date_posted;
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
    public Timestamp getDate_posted() {
        return date_posted;
    }

    /**
     * Sets post date.
     *
     * @param date_posted the post date
     */
    public void setDate_posted(Timestamp date_posted) {
        this.date_posted = date_posted;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    @Override
    public String toString() {
        return "Post{" +
                "post_id=" + post_id +
                ", user=" + user +
                ", post_subject='" + post_subject + '\'' +
                ", post_body='" + post_body + '\'' +
                ", post_date=" + date_posted +
                '}';
    }
}
