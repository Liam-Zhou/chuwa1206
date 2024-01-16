package RedBook.RedBook.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "post",uniqueConstraints = @UniqueConstraint(columnNames = "title"))
@Getter
@Setter
public class Post {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private long id;

@Column(name = "title",nullable = false)
private String title;

@Column(name = "description",nullable = false)
private String description;

@Column(name = "content",nullable = false)
private  String content;

@CreationTimestamp
private LocalDateTime createTime;

@UpdateTimestamp
private LocalDateTime updateTime;




}
