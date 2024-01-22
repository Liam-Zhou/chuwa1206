package com.example.redbook.dao;

import com.example.redbook.entity.Post;
import com.example.redbook.payload.PostDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Alex D.
 */
@Repository
public interface PostRepo extends JpaRepository<Post,Long> {
}
