package com.chuwa.redbook.payload;

public class AuthorDto {

    private long id;

    private String name;

    private String biography;

    public AuthorDto() {
    }

    public AuthorDto(String name, String biography) {
        this.name = name;
        this.biography = biography;
    }

    public AuthorDto(String name) {
        this.name = name;
        this.biography = "Not specified";
    }

    public AuthorDto(long id, String name, String biography) {
        this.id = id;
        this.name = name;
        this.biography = biography;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBiography() {
        return biography;
    }

    public void setBiography(String biography) {
        this.biography = biography;
    }
}
