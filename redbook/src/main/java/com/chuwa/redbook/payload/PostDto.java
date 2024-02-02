package com.chuwa.redbook.payload;

import java.util.Optional;

public class PostDto {
    private Long id;
    private String title;
    private String description;
    private String content;
    private Long authorId;

    public PostDto() {
    }

    public PostDto(Long id, String title, String description, String content, Long authorId) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.content = content;
        this.authorId = authorId;
    }

    public Long getId() { return id; }

    public void setId(Long id) {
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

    public Optional<Long> getAuthorId() { return Optional.ofNullable(authorId); }

    public void setAuthorId(Long authorId) {
        this.authorId = authorId;
    }

}
