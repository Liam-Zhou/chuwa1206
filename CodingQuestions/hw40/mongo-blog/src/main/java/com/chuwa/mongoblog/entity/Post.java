package com.chuwa.mongoblog.entity;


import com.chuwa.mongoblog.payload.PostDto;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document
public class Post {

    @Id
    private long id;
    private String title;

    private String description;

    private String content;



    public Post(long id, String title, String description, String content) {
        this.id=id;
        this.title = title;
        this.description = description;
        this.content = content;
    }

    public Post(PostDto postDto){
        this.id=postDto.getId();
        this.title=postDto.getTitle();
        this.content=postDto.getContent();
        this.description= postDto.getDescription();
    }
    public void updatePost(PostDto postDto){
        if(postDto.getTitle()!=null) title=postDto.getTitle();
        if(postDto.getDescription()!=null) description= postDto.getDescription();
        if(postDto.getContent()!=null) content=postDto.getContent();
    }
    public Post() {

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
