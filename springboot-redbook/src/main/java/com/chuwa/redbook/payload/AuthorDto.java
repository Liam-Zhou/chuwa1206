package com.chuwa.redbook.payload;

public class AuthorDto {

    private long id;
    private String name;
    private int age;
    private String biography;

    public AuthorDto() {}

    public AuthorDto(long id, String name, int age, String biography) {
        this.id = id;
        this.name = name;
        this.age = age;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getBiography() {
        return biography;
    }

    public void setBiography(String biography) {
        this.biography = biography;
    }
}
