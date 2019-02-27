package com.codeup.blog.controllers;

public class Post {
    private String title;
    private String body;
    private long id;

    public Post(String title, String body, long id) {
        this.title = title;
        this.body = body;
        this.id = id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getTitle() {
        return title;
    }

    public String getBody() {
        return body;
    }
}
