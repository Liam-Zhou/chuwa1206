package com.chuwa.redbook.dao;

import com.chuwa.redbook.entity.Comment;
import com.chuwa.redbook.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {

    /**
     * 不用实现。但要学语法
     * @param postId
     * @return
     */
    List<Comment> findByPostId(long postId);

    /**
     * count how many comments by post id
     * @param post
     * @return
     */
    Long countCommentsByPostIs(Post post);
}