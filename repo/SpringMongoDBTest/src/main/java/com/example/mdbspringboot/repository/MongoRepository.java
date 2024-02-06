package com.example.mdbspringboot;

import com.example.mdbspringboot.model.GroceryItem;

public interface MongoRepository {
    public void createGroceryItems();
    public void showAllGroceryItems();
    public void getGroceryItemByName(String name);
    public void getItemsByCategory(String category);
    public void findCountOfGroceryItems();
    public String getItemDetails(GroceryItem item);
    public void updateCategoryName(String category);
    public void deleteGroceryItem(String id);

}
