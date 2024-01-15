package com.example.mongoblog.controller;

import com.example.mongoblog.Dto.BlogDto;
import com.example.mongoblog.repository.ItemRepository;
import com.example.mongoblog.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Alex D.
 */
@RestController
@RequestMapping("api/v1/blogs")
public class GroceryController {

    @Autowired
    private PostService postService;

    @PostMapping()
    public BlogDto createBlog(@RequestBody BlogDto blogDto){
        return this.postService.createPost(blogDto);
    }


}
