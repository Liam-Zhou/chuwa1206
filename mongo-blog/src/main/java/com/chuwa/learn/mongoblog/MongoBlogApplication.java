package com.chuwa.learn.mongoblog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MongoBlogApplication {

    public static void main(String[] args) {
        SpringApplication.run(MongoBlogApplication.class, args);
        System.out.println("App");
    }

}
