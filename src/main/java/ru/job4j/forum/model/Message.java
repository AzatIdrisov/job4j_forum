package ru.job4j.forum.model;

import javax.persistence.*;
import java.util.Calendar;

/**
 * @author Azat Idrisov
 * @version 1.0
 * @since 30.08.2021
 */
@Entity
@Table(name = "messages")
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String content;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created")
    private Calendar created;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "posts_id")
    private Post post;

    private String author;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Calendar getCreated() {
        return created;
    }

    public void setCreated(Calendar created) {
        this.created = created;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
