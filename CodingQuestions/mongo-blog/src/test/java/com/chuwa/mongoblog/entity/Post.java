package com.chuwa.mongoblog.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document
public class Post {

    @Id
    private long id;

    private String title;

    private String content;

    public Post() {
    }

    public Post(long id, String title, String description, String content, LocalDateTime createDateTime, LocalDateTime updateDateTime) {
        this.id = id;
        this.title = title;
        this.content = content;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}

