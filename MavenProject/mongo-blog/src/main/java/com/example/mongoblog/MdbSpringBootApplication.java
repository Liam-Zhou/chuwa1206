package com.example.mongoblog;

import com.example.mongoblog.model.Post;
import com.example.mongoblog.payload.PostDto;
import com.example.mongoblog.repository.PostRepository;
import com.example.mongoblog.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
public class MdbSpringBootApplication implements CommandLineRunner {

    @Autowired
//    private PostRepository postRepository;
    private PostService postService;

    public static void main(String[] args) {
        SpringApplication.run(MdbSpringBootApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
//        postRepository.save(new Post("title", "des", "content"));
//        System.out.println("saved");
        postService.createPost(new PostDto("title", "des", "content"));

    }
}
