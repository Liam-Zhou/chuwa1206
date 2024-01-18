package com.chuwa.mongoblog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MongoBlogApplication {

	public static void main(String[] args) {
		//SpringApplication.run(MongoBlogApplication.class, args);

		Parent parent = new Parent(){
			public void display() {
				System.out.println("anonymous inner class");
			}
		};
		parent.display();
	}
}

class Parent {
	public void display() {
		System.out.println("parent");
	}
}