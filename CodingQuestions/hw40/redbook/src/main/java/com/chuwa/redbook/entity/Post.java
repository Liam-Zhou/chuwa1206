package com.chuwa.redbook.entity;

import com.chuwa.redbook.payload.PostDto;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(
        name="posts",
        uniqueConstraints={@UniqueConstraint(columnNames = {"title"})}
)
public class Post {


    @Id
    @GeneratedValue(
            strategy=GenerationType.IDENTITY
    )
    private Long id;

    @Column(name="title", nullable=false)
    private String title;

    @Column(name="description",nullable = false)
    private String description;

    @Column(name="content", nullable = false)
    private String content;

    @CreationTimestamp
    private LocalDateTime createDateTime;

    @UpdateTimestamp
    private LocalDateTime updateDateTime;



    public Post(String title, String description, String content) {
        this.title = title;
        this.description = description;
        this.content = content;
    }

    public Post(PostDto postDto){
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
