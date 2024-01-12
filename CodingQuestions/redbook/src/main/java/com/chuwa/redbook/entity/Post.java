package com.chuwa.redbook.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(
        name = "posts",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = {"title"})
        },
        indexes = {
                @Index(name = "idx_title", columnList = "title") // Index on 'title'
        }
)
// specify details about the table that a JPA entity should be mapped to

@NoArgsConstructor
@Getter
@Setter
@NamedQuery(name="Post.getAll", query="select p from Post p")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // rely on databases that support auto-increment columns (database automatically generates a unique value for each row when new records are inserted)
    private long id;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "content", nullable = false)
    private String content;

    @CreationTimestamp
    @Column(name = "create_date_time")
    // automatically managing the creation and last update timestamps of entity fields
    // When an entity is created and saved, Hibernate sets the annotated field with the current date and time
    private LocalDateTime createDateTime;

    @UpdateTimestamp
    @Column(name = "update_date_time")
    // Whenever an entity is updated and saved, Hibernate updates the annotated field with the current date and time.
    private LocalDateTime updateDateTime;

    private String email;

    public Post(long id, String title, String description, String content, LocalDateTime createDateTime, LocalDateTime updateDateTime) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.content = content;
        this.createDateTime = createDateTime;
        this.updateDateTime = updateDateTime;
    }

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", content='" + content + '\'' +
                ", createDateTime=" + createDateTime +
                ", updateDateTime=" + updateDateTime +
                '}';
    }
}
