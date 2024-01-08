package com.chuwa.mongoblog.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(collection = "posts")
public class Post {
    @Id
    private String id;
    private String title;
    private String description;
    private String content;
    private LocalDateTime createDateTime;
    private LocalDateTime updateDateTime;
    private String email;

    public Post() {
        this.createDateTime = LocalDateTime.now();
    }
    public void onBeforeUpdate() {
        this.updateDateTime = LocalDateTime.now();
    }

    public Post(String id, String title, String description, String content, String email) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.content = content;
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getCreateDateTime() {
        return createDateTime;
    }

    public void setCreateDateTime(LocalDateTime createDateTime) {
        this.createDateTime = createDateTime;
    }

    public LocalDateTime getUpdateDateTime() {
        return updateDateTime;
    }

    public void setUpdateDateTime(LocalDateTime updateDateTime) {
        this.updateDateTime = updateDateTime;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
