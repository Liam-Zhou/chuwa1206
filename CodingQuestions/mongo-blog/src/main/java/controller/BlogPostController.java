package controller;

import model.BlogPost;
import repository.BlogPostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/blogPosts")
public class BlogPostController {

    @Autowired
    private BlogPostRepository blogPostRepository;

    @PostMapping
    public BlogPost createBlogPost(@RequestBody BlogPost blogPost) {
        return blogPostRepository.save(blogPost);
    }
}