package com.chuwa.mongoblog.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class BlogPost {
    @Id
    private String id;
    private String title;
    private String content;
}
