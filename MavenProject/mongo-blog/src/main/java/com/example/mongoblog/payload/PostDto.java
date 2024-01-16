package com.example.mongoblog.payload;

import org.bson.types.ObjectId;

public class PostDto {
    private ObjectId id;

    private String title;

    private String description;

    private String content;

    public PostDto() {}

    public PostDto(ObjectId id, String title, String description, String content) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.content = content;
    }
    public PostDto(String title, String description, String content) {
        this.title = title;
        this.description = description;
        this.content = content;
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
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
}

