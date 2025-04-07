package edu.matc.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

/**
 * The type Like.
 */
@Entity
@Table(name = "likes")
public class Like {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private int like_id;

    @Column
    private int like_total; // You can keep this if you prefer, otherwise consider renaming to 'likesCount'

    @ManyToOne
    @JoinColumn(name = "post_id")
    private Post post;

    /**
     * Gets like id.
     *
     * @return the like id
     */
// Getter and Setter Methods
    public int getLike_id() {
        return like_id;
    }

    /**
     * Sets like id.
     *
     * @param like_id the like id
     */
    public void setLike_id(int like_id) {
        this.like_id = like_id;
    }

    /**
     * Gets like total.
     *
     * @return the like total
     */
    public int getLike_total() {
        return like_total;
    }

    /**
     * Sets like total.
     *
     * @param like_total the like total
     */
    public void setLike_total(int like_total) {
        this.like_total = like_total;
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
        return "Like{" +
                "like_id=" + like_id +
                ", like_total=" + like_total +
                ", post=" + post +
                '}';
    }
}
