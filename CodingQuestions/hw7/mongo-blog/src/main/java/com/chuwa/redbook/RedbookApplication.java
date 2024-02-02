package com.chuwa.redbook;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.chuwa.redbook.dao.jpa")
@EnableMongoRepositories(basePackages = "com.chuwa.redbook.dao.mongo")
public class RedbookApplication {

	public static void main(String[] args) {
		SpringApplication.run(RedbookApplication.class, args);
	}

}
