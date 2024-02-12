package com.example.redbook.dao;
import com.example.redbook.entity.Comment;
import com.example.redbook.entity.Post;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;

@Repository
public class PostDao {

    private final JdbcTemplate jdbcTemplate;

    public PostDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Post> getAllPosts() {
        String sql = "SELECT * FROM posts";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Post.class));
    }

    public Post getPostById(Long id) {
        String sql = "SELECT * FROM posts WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Post.class), id);
    }

    public int createPost(Post post) {
        String sql = "INSERT INTO posts (title, description, content, createDateTime, updateDateTime) " +
                "VALUES (?, ?, ?, ?, ?)";
        return jdbcTemplate.update(sql, post.getTitle(), post.getDescription(), post.getContent(),
                Timestamp.valueOf(post.getCreateDateTime()), Timestamp.valueOf(post.getUpdateDateTime()));
    }

    public int updatePost(Post post) {
        String sql = "UPDATE posts SET title = ?, description = ?, content = ?, " +
                "createDateTime = ?, updateDateTime = ? WHERE id = ?";
        return jdbcTemplate.update(sql, post.getTitle(), post.getDescription(), post.getContent(),
                Timestamp.valueOf(post.getCreateDateTime()), Timestamp.valueOf(post.getUpdateDateTime()),
                post.getId());
    }

    public int deletePostById(Long id) {
        String sql = "DELETE FROM posts WHERE id = ?";
        return jdbcTemplate.update(sql, id);
    }

    public List<Comment> getCommentsByPostId(Long postId) {
        String sql = "SELECT * FROM comments WHERE post_id = ?";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Comment.class), postId);
    }

    // Additional methods as needed...

}