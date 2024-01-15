package com.example.demo1redbook.dao;

import com.example.demo1redbook.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
/**
 * @author Alex D.
 */
@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
}
