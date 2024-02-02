package com.chuwa.mongoblog.controller;

public class PostController {
    @RestController
    @RequestMapping("/api/mongdb/v1/post")
    public class PostController {
        private final PostService postService;

        public PostController(PostService postService) {
            this.postService = postService;
        }

        @PostMapping
        public ResponseEntity<PostDto> createBlog(@RequestBody PostDto postDto) { //JSON Object
            PostDto response = postService.createPost(postDto);
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        }
    }
}
