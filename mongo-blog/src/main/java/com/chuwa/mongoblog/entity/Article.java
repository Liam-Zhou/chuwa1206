package com.chuwa.mongoblog.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.LocalDateTime;


@Document
public class Article {
    @Id
    private long id;

    private String title;

    private String content;

    private LocalDateTime createDateTime;

    private LocalDateTime updataDateTime;

    public Article() {
    }

    public Article(long id, String title, String content, LocalDateTime createDateTime, LocalDateTime updataDateTime) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.createDateTime = createDateTime;
        this.updataDateTime = updataDateTime;
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

    public LocalDateTime getUpdataDateTime() {
        return updataDateTime;
    }

    public void setUpdataDateTime(LocalDateTime updataDateTime) {
        this.updataDateTime = updataDateTime;
    }
}
