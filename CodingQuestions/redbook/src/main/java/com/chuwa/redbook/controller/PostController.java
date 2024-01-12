package com.chuwa.redbook.controller;

import com.chuwa.redbook.payload.PostDto;
import com.chuwa.redbook.payload.PostResponse;
import com.chuwa.redbook.service.PostService;
import com.chuwa.redbook.util.AppConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// ResponseEntity: used to represent the entire HTTP response, including the status code, headers, and body.
/*
ResponseEntity.ok(item); // 200 OK with the item as body
ResponseEntity.status(HttpStatus.CREATED).body(createdItem); // 201 Created
new ResponseEntity<>(createdItem, headers, HttpStatus.CREATED); // 201 Created with Location header
*/

@RestController
@RequestMapping("/api/v1/posts")
public class PostController {

    @Autowired
    private PostService postService;

    @PostMapping
    public ResponseEntity<PostDto> createPost(@RequestBody PostDto postDto){ // indicate that a method parameter should be bound to the body of the HTTP request
        PostDto response = this.postService.createPost(postDto);

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<PostDto>> getAllPosts(){
        return new ResponseEntity<>(this.postService.getAllPost(), HttpStatus.OK);
        // return new ResponseEntity<>(this.postService.getAllPostWithJPQL(), HttpStatus.OK);
    }

    @GetMapping("/pageable")
    @ResponseBody
    // returns a Java object
    // Java object is serialized into a format that can be transmitted over HTTP, typically JSON. This serialization is usually handled automatically by Jackson.
    // Content-Type header in the HTTP response is typically set to application/json
    // HTTP status code of the response is set to 200 OK
    public PostResponse getAllPosts(
            @RequestParam(value = "pageNo", defaultValue = AppConstants.DEFAULT_PAGE_NUMBER, required = false) int pageNo,
            @RequestParam(value = "pageSize", defaultValue = AppConstants.DEFAULT_PAGE_SIZE, required = false) int pageSize,
            @RequestParam(value = "sortBy", defaultValue = AppConstants.DEFAULT_SORT_BY, required = false) String sortBy,
            @RequestParam(value = "sortDir", defaultValue = AppConstants.DEFAULT_SORT_DIR, required = false) String sortDir
    ) {
        return postService.getAllPost(pageNo, pageSize, sortBy, sortDir);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PostDto> getPostById(@PathVariable(name="id") long id){
        return ResponseEntity.ok(this.postService.getPostById(id));
    }


    @PutMapping("/{id}")
    public ResponseEntity<PostDto> updatePostById(@RequestBody PostDto postDto, @PathVariable(name="id") long id ){
        PostDto postResponse = this.postService.updatePost(postDto, id);
        return new ResponseEntity<>(postResponse,HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePostById(@PathVariable(name="id") long id){
        this.postService.deletePostById(id);
        return new ResponseEntity<>("Deleted successfully", HttpStatus.OK);
    }
}
