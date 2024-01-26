package com.chuwa.learn.statement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class StatementApplication {

    public static void main(String[] args) {
        SpringApplication.run(StatementApplication.class, args);
    }

}
