package com.chuwa.redbook.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDate;
@Entity
@Table(    name = "posts",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = {"title"})
        })

public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "title", nullable = false)
    private String title;
    @Column(name = "description", nullable = false)
    private String description;
    @Column(name = "content", nullable = false)
    private String content;
    @CreationTimestamp
    private LocalDate createDateTime;
    @UpdateTimestamp
    private LocalDate updateDateTime;

    public Post(long id, String title, String description, String content, LocalDate createDateTime, LocalDate updateDateTime) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.content = content;
        this.createDateTime = createDateTime;
        this.updateDateTime = updateDateTime;
    }

    public Post() {

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

    public LocalDate getCreateDateTime() {
        return createDateTime;
    }

    public void setCreateDateTime(LocalDate createDateTime) {
        this.createDateTime = createDateTime;
    }

    public LocalDate getUpdateDateTime() {
        return updateDateTime;
    }

    public void setUpdateDateTime(LocalDate updateDateTime) {
        this.updateDateTime = updateDateTime;
    }
}
