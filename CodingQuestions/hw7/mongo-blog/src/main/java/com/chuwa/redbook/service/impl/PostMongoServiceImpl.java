package com.chuwa.redbook.service.impl;

import com.chuwa.redbook.dao.mongo.PostMongoRepository;
import com.chuwa.redbook.entity.PostMongo;
import com.chuwa.redbook.payload.PostMongoDto;
import com.chuwa.redbook.service.PostMongoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Diana
 */
@Service
public class PostMongoServiceImpl implements PostMongoService {

    @Autowired
    private PostMongoRepository postRepository;

    @Override
    public PostMongoDto createPost(PostMongoDto postDto) {
        // 把payload转换成entity，这样才能dao去把该数据存到数据库中。
        PostMongo post = new PostMongo();
        post.setId(postDto.getId());
        post.setTitle(postDto.getTitle() != null ? postDto.getTitle() : "");
        post.setDescription(postDto.getDescription() != null ? postDto.getDescription() : "");
        post.setContent(postDto.getContent() != null ? postDto.getContent() : "");
        // 此时已成功把request body的信息传递给entity

        // 调用Dao的save方法，将entity的数据存储到数据库MySQL
        // save()会返回存储在数据库中的数据
        PostMongo savedPost = postRepository.save(post);

        // 将save() 返回的数据转换成controller/前端 需要的数据，然后return给controller
        PostMongoDto postResponse = new PostMongoDto();
        postResponse.setId(savedPost.getId());
        postResponse.setTitle(savedPost.getTitle());
        postResponse.setDescription(savedPost.getDescription());
        postResponse.setContent(savedPost.getContent());

        return postResponse;
    }
}
