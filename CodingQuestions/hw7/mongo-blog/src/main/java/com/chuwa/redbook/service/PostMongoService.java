package com.chuwa.redbook.service;

import com.chuwa.redbook.payload.PostMongoDto;

/**
 * @author Diana
 */
public interface PostMongoService {

    PostMongoDto createPost(PostMongoDto postDto);
}
