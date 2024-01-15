package com.chuwa.redbook.entity;


import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(
        name="authors"
)
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private String name;

    @CreationTimestamp
    private String CreationTimestamp;

    @UpdateTimestamp
    private String UpdateTimestamp;

    public Author(){};

    public Author(String name, String creationTimestamp, String updateTimestamp) {
        this.name = name;
        CreationTimestamp = creationTimestamp;
        UpdateTimestamp = updateTimestamp;
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

    public String getCreationTimestamp() {
        return CreationTimestamp;
    }

    public void setCreationTimestamp(String creationTimestamp) {
        CreationTimestamp = creationTimestamp;
    }

    public String getUpdateTimestamp() {
        return UpdateTimestamp;
    }

    public void setUpdateTimestamp(String updateTimestamp) {
        UpdateTimestamp = updateTimestamp;
    }
}
