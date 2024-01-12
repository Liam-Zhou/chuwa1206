package com.chuwa.redbook.payload;

import com.chuwa.redbook.entity.Post;

public class PostDto {
    private long id;
    private String content;
    private String description;
    private String title;

    public PostDto(String content, String description, String title) {
        this.content = content;
        this.description = description;
        this.title = title;
    }

    public PostDto(Post post){
        this.id=post.getId();
        this.title= post.getTitle();
        this.description=post.getDescription();
        this.content=post.getContent();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
