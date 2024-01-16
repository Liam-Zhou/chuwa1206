package com.example.mongoblog;

import com.example.mongoblog.dao.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
public class MongoBlogApplication {

	public static void main(String[] args) {
		SpringApplication.run(MongoBlogApplication.class, args);
	}

}
