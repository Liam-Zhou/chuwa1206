package com.example.mdbspringboot;


import com.example.mdbspringboot.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
public class MdbSpringBootApplication implements CommandLineRunner {

    @Autowired
    ItemRepository groceryItemRepo;

    public static void main(String[] args) {
        SpringApplication.run(MdbSpringBootApplication.class, args);
    }


    @Override
    public void run(String... args) throws Exception {

            System.out.println("-----CREATE GROCERY ITEMS-----\n");

            createGroceryItems();

            System.out.println("\n-----SHOW ALL GROCERY ITEMS-----\n");

            showAllGroceryItems();

            System.out.println("\n-----GET ITEM BY NAME-----\n");

            getGroceryItemByName("Whole Wheat Biscuit");

            System.out.println("\n-----GET ITEMS BY CATEGORY-----\n");

            getItemsByCategory("millets");

            System.out.println("\n-----UPDATE CATEGORY NAME OF SNACKS CATEGORY-----\n");

            updateCategoryName("snacks");

            System.out.println("\n-----DELETE A GROCERY ITEM-----\n");

            deleteGroceryItem("Kodo Millet");

            System.out.println("\n-----FINAL COUNT OF GROCERY ITEMS-----\n");

            findCountOfGroceryItems();

            System.out.println("\n-----THANK YOU-----");

    }
}