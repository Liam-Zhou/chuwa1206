package com.example.mdbspringboot.repository.imp;

import com.example.mdbspringboot.MongoRepository;
import com.example.mdbspringboot.model.GroceryItem;

import java.util.List;

public class MongoRepositoryImpl implements MongoRepository {
    @Override
    //CREATE
    public void createGroceryItems() {
        System.out.println("Data creation started...");
        groceryItemRepo.save(new GroceryItem("Whole Wheat Biscuit", "Whole Wheat Biscuit", 5, "snacks"));
        groceryItemRepo.save(new GroceryItem("Kodo Millet", "XYZ Kodo Millet healthy", 2, "millets"));
        groceryItemRepo.save(new GroceryItem("Dried Red Chilli", "Dried Whole Red Chilli", 2, "spices"));
        groceryItemRepo.save(new GroceryItem("Pearl Millet", "Healthy Pearl Millet", 1, "millets"));
        groceryItemRepo.save(new GroceryItem("Cheese Crackers", "Bonny Cheese Crackers Plain", 6, "snacks"));
        System.out.println("Data creation complete...");
    }
    // READ
    // 1. Show all the data
    @Override
    public void showAllGroceryItems() {

        groceryItemRepo.findAll().forEach(item -> System.out.println(getItemDetails(item)));
    }

    @Override
    // 2. Get item by name
    public void getGroceryItemByName(String name) {
        System.out.println("Getting item by name: " + name);
        GroceryItem item = groceryItemRepo.findItemByName(name);
        System.out.println(getItemDetails(item));
    }
    @Override
    // 3. Get name and quantity of a all items of a particular category
    public void getItemsByCategory(String category) {
        System.out.println("Getting items for the category " + category);
        List<GroceryItem> list = groceryItemRepo.findAll(category);

        list.forEach(item -> System.out.println("Name: " + item.getName() + ", Quantity: " + item.getQuantity()));
    }
    @Override
    // 4. Get count of documents in the collection
    public void findCountOfGroceryItems() {
        long count = groceryItemRepo.count();
        System.out.println("Number of documents in the collection: " + count);
    }

    @Override
    public String getItemDetails(GroceryItem item) {
        return null;
    }

    @Override
    public void updateCategoryName(String category) {

    }

    @Override
    public void deleteGroceryItem(String id) {

    }
}
