package com.cassandra.blog.controller;

import com.cassandra.blog.payload.PostDto;
import com.cassandra.blog.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/posts")
public class PostController {

    @Autowired
    private PostService postService;

    @PostMapping
    public ResponseEntity<PostDto> createPost(@RequestBody PostDto postDto) {
        PostDto createdPostDto = postService.createPost(postDto);
        return ResponseEntity.ok(createdPostDto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PostDto> getPostById(@PathVariable UUID id) {
        PostDto postDto = postService.getPostById(id);
        return ResponseEntity.ok(postDto);
    }

    @GetMapping
    public ResponseEntity<List<PostDto>> getAllPosts() {
        List<PostDto> postDtos = postService.getAllPosts();
        return ResponseEntity.ok(postDtos);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PostDto> updatePost(@PathVariable UUID id, @RequestBody PostDto postDto) {
        PostDto updatedPostDto = postService.updatePost(id, postDto);
        return ResponseEntity.ok(updatedPostDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePost(@PathVariable UUID id) {
        postService.deletePost(id);
        return ResponseEntity.ok("Post deleted successfully");
    }
}
