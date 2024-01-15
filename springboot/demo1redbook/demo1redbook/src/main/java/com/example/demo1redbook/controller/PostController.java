package com.example.demo1redbook.controller;

import com.example.demo1redbook.payload.PostDto;
import com.example.demo1redbook.payload.PostResponse;
import com.example.demo1redbook.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Alex D.
 */
@RestController
@RequestMapping("/api/v1")
public class PostController {

    @Autowired
    private PostService postService;

    @PostMapping("/posts")
    public ResponseEntity<PostDto> createPost(@RequestBody PostDto postDto) {
        PostDto postResponse = postService.createPost(postDto);
        return new ResponseEntity<>(postResponse, HttpStatus.CREATED);
    }

    // Jan.8
//    @GetMapping
//    public List<PostDto> getAllPosts(){
//
//    }
    @GetMapping()
    public PostResponse getAllPosts(
            @RequestParam(value="pageNo") int pageNo
    ){
        return postService.getAllPost();
    }



}
