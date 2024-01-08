package com.chuwa.mongoblog.payload;

import java.time.LocalDateTime;

public class ArticleDto {
    private Long id;
    private String title;
    private String content;
    private LocalDateTime createDateTime;
    private LocalDateTime updataDateTime;

    public ArticleDto() {
    }

    public ArticleDto(Long id, String title, String content, LocalDateTime createDateTime, LocalDateTime updataDateTime) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.createDateTime = createDateTime;
        this.updataDateTime = updataDateTime;
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
