package com.chuwa.redbook;

import com.chuwa.redbook.payload.CommentDto;
import com.chuwa.redbook.payload.PostDto;
import com.chuwa.redbook.service.CommentService;
import com.chuwa.redbook.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

@SpringBootApplication
public class RedbookApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(RedbookApplication.class, args);
	}

	@Autowired
	private CommentService commentService;

	@Autowired
	private PostService postService;


	@Override
	public void run(String... args) throws Exception {
		if (false) {
			postService.createPost(new PostDto("title", "des", "content"));
			long post_id = postService.getAllPost().get(0).getId();
			commentService.createComment(post_id, new CommentDto("name", "email", "body"));
		}
	}
}
