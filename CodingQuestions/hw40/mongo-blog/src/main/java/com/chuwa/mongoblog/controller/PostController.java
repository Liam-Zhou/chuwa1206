package com.chuwa.mongoblog.controller;


import com.chuwa.mongoblog.payload.PostDto;
import com.chuwa.mongoblog.service.PostService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/posts")
public class PostController {


    private PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @PostMapping
    public ResponseEntity<PostDto> createPost(@RequestBody PostDto postDto){
        return new ResponseEntity<>(postService.createPost(postDto), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<PostDto>> getAllPost(){
        return new ResponseEntity<>(postService.getAllPost(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PostDto> getPostById(@PathVariable(value="id") long id){
        return new ResponseEntity<>(postService.getPostById(id), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PostDto> updatePostById(@RequestBody PostDto postDto, @PathVariable(name="id") long id){
        return new ResponseEntity<>(postService.updatePostById(postDto, id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> removePostById(@PathVariable(name="id") long id){
        postService.removePostById(id);
        return new ResponseEntity<>("Delete Successfully", HttpStatus.OK);
    }

}

