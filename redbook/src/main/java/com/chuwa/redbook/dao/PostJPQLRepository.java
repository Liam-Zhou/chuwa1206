package com.chuwa.redbook.dao;

import com.chuwa.redbook.entity.Post;

import java.util.List;

public interface PostJPQLRepository {
    List<Post> getAllPostsWithJPQL();
}
