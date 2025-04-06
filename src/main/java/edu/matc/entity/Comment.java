package edu.matc.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "comments")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")

    @Column
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

    public Comment() {

    }

    public Comment(int comment_id, int post_id, String comment_body, String comment_timestamp) {
        this.comment_id = comment_id;
        this.post_id = post_id;
        this.comment_body = comment_body;
        this.comment_timestamp = comment_timestamp;
    }

    public int getComment_id() {
        return comment_id;
    }

    public void setComment_id(int comment_id) {
        this.comment_id = comment_id;
    }

    public int getPost_id() {
        return post_id;
    }

    public void setPost_id(int post_id) {
        this.post_id = post_id;
    }

    public String getComment_body() {
        return comment_body;
    }

    public void setComment_body(String comment_body) {
        this.comment_body = comment_body;
    }

    public String getComment_timestamp() {
        return comment_timestamp;
    }

    public void setComment_timestamp(String comment_timestamp) {
        this.comment_timestamp = comment_timestamp;
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
