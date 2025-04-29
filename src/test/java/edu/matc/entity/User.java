package edu.matc.entity;


import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * The type User.
 */
@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private int user_id;

    @Column
    private String username;

    @Column
    private String first_name;

    @Column
    private String last_name;

    @Column
    private String email;

    @Column
    private String bio;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Post> posts = new ArrayList<>();

    /**
     * Instantiates a new Users.
     */
    public User() {

    }

    /**
     * Instantiates a new Users.
     *
     * @param user_id    the user id
     * @param username   the username
     * @param first_name the first name
     * @param last_name  the last name
     * @param email      the email
     * @param bio        the bio
     */
    public User(int user_id, String username, String first_name, String last_name, String email, String bio) {
        this.user_id = user_id;
        this.username = username;
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.bio = bio;
    }

    /**
     * Add post.
     *
     * @param post the post
     */
    public void addPost(Post post) {
        posts.add(post);
        post.setUser(this);
    }

    /**
     * Remove post.
     *
     * @param post the post
     */
    public void removePost(Post post) {
        posts.remove(post);
        post.setUser(null);
    }

    /**
     * Gets posts.
     *
     * @return the posts
     */
    public List<Post> getPosts() {
        return posts;
    }

    /**
     * Sets posts.
     *
     * @param posts the posts
     */
    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

    /**
     * Gets user id.
     *
     *
     * @return the user id
     */
    public int getUser_id() {
        return user_id;
    }

    /**
     * Sets user id.
     *
     * @param user_id the user id
     */
    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    /**
     * Gets username.
     *
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * Sets username.
     *
     * @param username the username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Gets first name.
     *
     * @return the first name
     */
    public String getFirst_name() {
        return first_name;
    }

    /**
     * Sets first name.
     *
     * @param first_name the first name
     */
    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    /**
     * Gets last name.
     *
     * @return the last name
     */
    public String getLast_name() {
        return last_name;
    }

    /**
     * Sets last name.
     *
     * @param last_name the last name
     */
    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    /**
     * Gets email.
     *
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets email.
     *
     * @param email the email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Gets bio.
     *
     * @return the bio
     */
    public String getBio() { return bio; }

    /**
     * Sets bio.
     *
     * @param bio the bio
     */
    public void setBio(String bio) { this.bio = bio; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(username, user.username)
                && Objects.equals(first_name, user.first_name)
                && Objects.equals(last_name, user.last_name)
                && Objects.equals(email, user.email)
                && Objects.equals(bio, user.bio);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, first_name, last_name, email, bio);
    }

    @Override
    public String toString() {
        return "Users{" +
                "user_id=" + user_id +
                ", username='" + username + '\'' +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", email='" + email + '\'' +
                ", bio='" + bio + '\'' +
                '}';
    }
}
