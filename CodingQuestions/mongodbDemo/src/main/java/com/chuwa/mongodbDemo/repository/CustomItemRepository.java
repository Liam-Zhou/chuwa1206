package com.chuwa.mongodbDemo.repository;

public interface CustomItemRepository {
    void updateItemQuantity(String itemName, float newQuantity);
}
