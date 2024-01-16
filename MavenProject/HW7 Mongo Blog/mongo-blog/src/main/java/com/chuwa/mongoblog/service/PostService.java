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
        this.groceryItemRepo.save(new GroceryItem("Whole Wheat Biscuit", "Whole Wheat Biscuit", 5, "snacks"));
        this.groceryItemRepo.save(new GroceryItem("Kodo Millet", "XYZ Kodo Millet healthy", 2, "millets"));
        this.groceryItemRepo.save(new GroceryItem("Dried Red Chilli", "Dried Whole Red Chilli", 2, "spices"));
        this.groceryItemRepo.save(new GroceryItem("Pearl Millet", "Healthy Pearl Millet", 1, "millets"));
        this.groceryItemRepo.save(new GroceryItem("Cheese Crackers", "Bonny Cheese Crackers Plain", 6, "snacks"));
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

}
