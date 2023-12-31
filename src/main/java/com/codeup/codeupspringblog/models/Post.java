package com.codeup.codeupspringblog.models;


import jakarta.persistence.*;

@Entity
@Table(name = "posts")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String title;

    @Column(nullable = false, length = 250)
    private String body;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User users;

    public Post() {
    }

    public Post(Long id, String title, String body, User users) {
        this.id = id;
        this.title = title;
        this.body = body;
        this.users = users;
    }

    public Post(String title, String body, User users) {
        this.title = title;
        this.body = body;
        this.users = users;
    }

    public Post(String title, String body) {
        this.title = title;
        this.body = body;
    }

    public Post(User users) {
        this.users = users;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public User getUsers() {
        return users;
    }

    public void setUsers(User users) {
        this.users = users;
    }
}
