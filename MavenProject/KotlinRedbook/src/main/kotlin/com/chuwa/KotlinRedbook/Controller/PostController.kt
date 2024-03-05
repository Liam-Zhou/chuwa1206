package com.chuwa.KotlinRedbook.Controller

import com.chuwa.KotlinRedbook.Entity.Post
import com.chuwa.KotlinRedbook.Service.PostService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/posts")
class PostController {
    @Autowired
    private lateinit var postService : PostService

    @PostMapping
    fun createPost(@RequestBody requestBody : PostCreateRequestBody) : ResponseEntity<Post>{
        var response = postService.createPost(requestBody.title, requestBody.content);
        return ResponseEntity(response, HttpStatus.CREATED)
    }

    @GetMapping("/{id}")
    fun getPostById(@PathVariable id : Long) : ResponseEntity<Post> {
        return ResponseEntity(postService.getPostById(id), HttpStatus.OK)
    }

    @GetMapping
    fun getAllPost() : ResponseEntity<List<Post>> {
        return ResponseEntity.ok(postService.getAllPost())
    }

    data class PostCreateRequestBody(
        val title : String,
        val content : String
    )
}