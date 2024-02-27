package com.chuwa.mongoblog.service;

import com.chuwa.mongoblog.model.GroceryItem;
import com.chuwa.mongoblog.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.stereotype.Service;

@Service
public class PostService {
    @Autowired
    private ItemRepository groceryItemRepo;

    public void createGroceryItems() {
        System.out.println("Data creation started...");
        this.groceryItemRepo.save(new GroceryItem("Cocacola Diet Coke", 36, "beverages"));
        this.groceryItemRepo.save(new GroceryItem("toilet paper", 9, "household"));
        System.out.println("Data creation complete...");
    }

    public void showAllGroceryItems() {

        this.groceryItemRepo.findAll().forEach(item -> System.out.println(getItemDetails(item)));
    }

    public String getItemDetails(GroceryItem item) {

        System.out.println(
                "Item Name: " + item.getName() +
                        ", \nQuantity: " + item.getQuantity() +
                        ", \nItem Category: " + item.getCategory()
        );

        return "";
    }

    public void searchItemByCategory(String category){
        System.out.println("Category " + category + ": \n");
        this.groceryItemRepo.findCate(category).forEach(item -> System.out.println(getItemDetails(item)));
    }

}
