package edu.matc.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

/**
 * The type Comment.
 */
@Entity
@Table(name = "comments")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private int comment_id;

    @Column
    private int post_id;

    @Column
    private String comment_body;

    @Column
    private String comment_timestamp;

    @ManyToOne
    @JoinColumn(name = "post_id", referencedColumnName = "post_id")
    private Post post;

    /**
     * Instantiates a new Comment.
     */
    public Comment() {

    }

    /**
     * Instantiates a new Comment.
     *
     * @param comment_id        the comment id
     * @param post_id           the post id
     * @param comment_body      the comment body
     * @param comment_timestamp the comment timestamp
     */
    public Comment(int comment_id, int post_id, String comment_body, String comment_timestamp) {
        this.comment_id = comment_id;
        this.post_id = post_id;
        this.comment_body = comment_body;
        this.comment_timestamp = comment_timestamp;
    }

    /**
     * Gets comment id.
     *
     * @return the comment id
     */
    public int getComment_id() {
        return comment_id;
    }

    /**
     * Sets comment id.
     *
     * @param comment_id the comment id
     */
    public void setComment_id(int comment_id) {
        this.comment_id = comment_id;
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
     * Gets comment body.
     *
     * @return the comment body
     */
    public String getComment_body() {
        return comment_body;
    }

    /**
     * Sets comment body.
     *
     * @param comment_body the comment body
     */
    public void setComment_body(String comment_body) {
        this.comment_body = comment_body;
    }

    /**
     * Gets comment timestamp.
     *
     * @return the comment timestamp
     */
    public String getComment_timestamp() {
        return comment_timestamp;
    }

    /**
     * Sets comment timestamp.
     *
     * @param comment_timestamp the comment timestamp
     */
    public void setComment_timestamp(String comment_timestamp) {
        this.comment_timestamp = comment_timestamp;
    }

    /**
     * Gets post.
     *
     * @return the post
     */
    public Post getPost() {
        return post;
    }

    /**
     * Sets post.
     *
     * @param post the post
     */
    public void setPost(Post post) {
        this.post = post;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "comment_id=" + comment_id +
                ", post_id=" + post_id +
                ", comment_body='" + comment_body + '\'' +
                ", comment_timestamp='" + comment_timestamp + '\'' +
                '}';
    }
}
