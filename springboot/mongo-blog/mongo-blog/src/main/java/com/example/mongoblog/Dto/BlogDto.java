package com.example.mongoblog.Dto;

/**
 * @author Alex D.
 */
public class BlogDto {
    private String id;

    private String name;

    private String content;

    public BlogDto() {
    }

    public BlogDto(String name, String content) {
        this.id = id;
        this.name = name;
        this.content = content;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
