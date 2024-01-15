package com.chuwa.cassandrablog.payload;

import java.util.UUID;

public class PostDto {
    private UUID id;
    private String title;

    public PostDto() {
    }

    public PostDto(UUID id, String title) {
        this.id = id;
        this.title = title;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
