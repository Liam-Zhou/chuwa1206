package com.chuwa.mongoblog;

import com.chuwa.mongoblog.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
public class MongoBlogApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(MongoBlogApplication.class, args);
	}

	@Autowired
	private PostService postService;

	@Override
	public void run(String... args) throws Exception {
		this.postService.createGroceryItems();
		this.postService.showAllGroceryItems();
		this.postService.searchItemByCategory("snacks");
	}
}
