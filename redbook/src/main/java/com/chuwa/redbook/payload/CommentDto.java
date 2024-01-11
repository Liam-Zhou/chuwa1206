package com.chuwa.redbook.payload;

public class CommentDto {
    private long id;
    private String email;
    private String name;
    private String body;

    public CommentDto() {
    }
    public CommentDto(String email, String name, String body) {
        this.email = email;
        this.name = name;
        this.body = body;
    }
    public CommentDto(long id, String email, String name, String body) {
        this(email, name, body);
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
