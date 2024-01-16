package com.chuwa.redbook.controller;

import com.chuwa.redbook.payload.PostDto;
import com.chuwa.redbook.payload.PostResponse;
import com.chuwa.redbook.service.PostService;
import com.chuwa.redbook.util.AppConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/api/v1/posts")
public class PostController {

    @Autowired
    private PostService postService;

    @PostMapping
    public ResponseEntity<PostDto> createPost(@RequestBody PostDto postDto) {
        PostDto response = this.postService.createPost(postDto);
        return new ResponseEntity<>(response, HttpStatus.CREATED);

    }

    @GetMapping
//    public ResponseEntity<List<PostDto>> getAllPost() {
//        return new ResponseEntity<>(this.postService.getAllPost(), HttpStatus.OK);
//
//    }
    public ResponseEntity<PostResponse> getAllPost(
            @RequestParam(value="pageNo", defaultValue = AppConstants.DEFAULT_PAGE_NUMBER, required = false) int pageNo,
            @RequestParam(value="pageSize", defaultValue = AppConstants.DEFAULT_PAGE_SIZE, required = false) int pageSize,
            @RequestParam(value="sortBy", defaultValue = AppConstants.DEFAULT_SORT_BY, required = false) String sortBy,
            @RequestParam(value="sortDir", defaultValue = AppConstants.DEFAULT_SORT_DIR, required = false) String sortDir) {
        return new ResponseEntity<>(this.postService.getAllPost(pageNo, pageSize, sortBy, sortDir), HttpStatus.OK);

    }

    @GetMapping("/{id}")
    public ResponseEntity<PostDto> getPostById(@PathVariable(name="id") long id) {
        return ResponseEntity.ok(this.postService.getPostById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PostDto> updatePostById(@RequestBody PostDto postDto, @PathVariable(name="id") long id) {
        PostDto response = this.postService.updatePostById(postDto, id);
        return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePostById(@PathVariable(name="id") long id) {
        this.postService.deletePostById(id);
        return new ResponseEntity<>("Deleted", HttpStatus.OK);
    }
}
