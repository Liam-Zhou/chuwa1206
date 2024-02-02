package com.example.redbook.controller;

import com.example.redbook.payload.dto.PostDto;
import com.example.redbook.payload.PostResponse;
import com.example.redbook.service.PostService;
import com.example.redbook.util.AppConstants;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/posts")
public class PostController {
    private static final Logger logger = LoggerFactory.getLogger(PostController.class);

    @Autowired
    private PostService postService;

    // /api/v1/posts  POST
    @PostMapping("/post") //annotation indicates that this method should handle HTTP POST request
    public ResponseEntity<PostDto> createPost(@Valid @RequestBody PostDto postDto) {
        return new ResponseEntity<>(postService.createPost(postDto), HttpStatus.CREATED);
    }

//    @GetMapping
////    @ResponseBody: object returned is automatically serialized into JSON and passed back into the HttpResponse object.
//    //ResponseEntity (which includes the @ResponseBody annotation), it indicates that the result should be serialized to JSON and sent as the response bod
//    public ResponseEntity<List<PostDto>> getAllPosts() {
//        return new ResponseEntity<List<PostDto>>(this.postService.getAllPost(), HttpStatus.OK);
//    }

    @GetMapping
    public PostResponse getAllPosts(
            @RequestParam(value = "pageNo", defaultValue = AppConstants.DEFAULT_PAGE_NUMBER, required = false) int pageNo,
            @RequestParam(value = "pageSize", defaultValue = AppConstants.DEFAULT_PAGE_SIZE, required = false) int pageSize,
            @RequestParam(value = "sortBy", defaultValue = AppConstants.DEFAULT_SORT_BY, required = false) String sortBy,
            @RequestParam(value = "sortDir", defaultValue = AppConstants.DEFAULT_SORT_DIR, required = false) String sortDir
    ) {
        return postService.getAllPost(pageNo, pageSize, sortBy, sortDir);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PostDto> getPostById(@PathVariable(name = "id") long id, HttpServletResponse response,
                                               @CookieValue(value = "userName", defaultValue = "defaultValue") String yourCookie) {
        Cookie cookie = new Cookie("userName", "lalala");
        response.addCookie(cookie);
        return ResponseEntity.ok(this.postService.getPostById(id));
    }

    @PutMapping(value = "/{id}", consumes = "application/json")
    public ResponseEntity<PostDto> updatePostById(@RequestBody PostDto postDto, @PathVariable(name="id") long id) {
        PostDto postResponse = this.postService.updatePost(postDto, id);
        logger.info("update post get called");
        return new ResponseEntity<>(postResponse, HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePostById(@PathVariable(name="id") long id) {
        this.postService.deletePostById(id);
        return new ResponseEntity<>("Deleted successfully", HttpStatus.OK);
    }
}