package com.chuwa.redbook.dao;

import com.chuwa.redbook.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    /**
     * 不用实现。但要学语法
     * @param postId
     * @return
     */
    List<Comment> findByPostId(long postId);
}
