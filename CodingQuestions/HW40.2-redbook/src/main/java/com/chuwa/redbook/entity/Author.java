package com.chuwa.redbook.entity;

import jakarta.persistence.*;

@Entity
@Table(
        name = "authors",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = {"title"})
        }
)
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "email", nullable = false)
    private String email;

    public Author() {}

    public Author(Long id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "AuthorDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email +
                '}';
    }
}
