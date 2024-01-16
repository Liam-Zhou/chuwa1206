package com.chuwa.redbook.payload;

public class AuthorDto {
    private Long id;
    private String name;

    public AuthorDto(){};

    public AuthorDto(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public AuthorDto(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
