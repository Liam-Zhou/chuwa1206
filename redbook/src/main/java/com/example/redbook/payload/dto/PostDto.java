package com.example.redbook.payload.dto;

public class PostDto {

    private Long id;
    private String title;
    private String description;
    private String content;

    // Constructors
    public PostDto() {
        // Default constructor
    }

    public PostDto(String title, String description, String content) {
        this.title = title;
        this.description = description;
        this.content = content;
    }

    // Getter and Setter methods

    // Getter and Setter methods
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

    // toString method for better representation
    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}