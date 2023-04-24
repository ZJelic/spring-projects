package com.webapp.springboot.thymeleafdemo.entity;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name="comments")
public class Comment {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="content")
    private String content;

    @Column(name="created_at")
    private Date created_at;

    @Column(name="updated_at")
    private Date updated_at;

    @ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE,
            CascadeType.DETACH, CascadeType.REFRESH }, fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY, cascade=CascadeType.ALL)
    @JoinColumn(name = "blogpost_id")
    private BlogPost blogPost;

    public Comment(){

    }

    public Comment(int id, String content, Date created_at, Date updated_at, User user) {
        this.id = id;
        this.content = content;
        this.created_at = created_at;
        this.updated_at = updated_at;
        this.user = user;
    }

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

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    public Date getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(Date updated_at) {
        this.updated_at = updated_at;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", created_at=" + created_at +
                ", updated_at=" + updated_at +
                ", user=" + user +
                '}';
    }
}
