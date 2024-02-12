package com.example.redbook.dao;

import com.example.redbook.entity.Post;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostJPQLRepository {

    List<Post> getAllPostWithJPQL();
}