package com.chuwa.redbook.controller;

import com.chuwa.redbook.payload.PostDto;
import com.chuwa.redbook.service.PostService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

// 实际经验每一个controller都会有一个对应的DTO
@Controller
public class PostGraphQLController {

    private PostService postService;

    // 通过这种方式注入
    public PostGraphQLController(PostService postService) {
        this.postService = postService;
    }

    @QueryMapping
    public PostDto getPostById(@Argument Long id) {
        return this.postService.getPostById(id);
    }

    @QueryMapping
    public List<PostDto> getAllPosts() {
        return this.postService.getAllPost();
    }

    @MutationMapping
    public PostDto createPost(@Argument String title, @Argument String description, @Argument String content){
        PostDto postDto = new PostDto();

        postDto.setTitle(title);
        postDto.setDescription(description);
        postDto.setContent(content);

        return this.postService.createPost(postDto);
    }
}
