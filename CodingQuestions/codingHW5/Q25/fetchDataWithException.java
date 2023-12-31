package com.chuwa.tutorial.t08_multithreading.c08_future;

import java.util.concurrent.CompletableFuture;

import java.util.logging.Level;
import java.util.logging.Logger;

public class fetchDataWithException {
    private static final Logger logger = Logger.getLogger(fetchDataWithException.class.getName());

    public static void main(String[] args) {

        String productEndpoint = "https://jsonplaceholder.typicode.com/posts/1";
        String reviewsEndpoint = "https://jsonplaceholder.typicode.com/comments/1";
        String inventoryEndpoint = "https://jsonplaceholder.typicode.com/todos/1";


        CompletableFuture<String> productDataFuture = fetchDataFromEndpoint(productEndpoint, "Default Products Value");


        CompletableFuture<String> reviewsDataFuture = fetchDataFromEndpoint(reviewsEndpoint, "Default Reviews Value");


        CompletableFuture<String> inventoryDataFuture = fetchDataFromEndpoint(inventoryEndpoint, "Default Inventory Value");


        CompletableFuture<Void> combinedFuture = CompletableFuture.allOf(
                productDataFuture, reviewsDataFuture, inventoryDataFuture
        );

        combinedFuture.thenRun(() -> {
            try {
                String productData = productDataFuture.join();
                String reviewsData = reviewsDataFuture.join();
                String inventoryData = inventoryDataFuture.join();

                System.out.println("Product Data: " + productData);
                System.out.println("Reviews Data: " + reviewsData);
                System.out.println("Inventory Data: " + inventoryData);
            } catch (Exception e) {
                logger.log(Level.SEVERE, "Exception occurred during data retrieval.", e);
            }
        });

        combinedFuture.join();
    }

    private static CompletableFuture<String> fetchDataFromEndpoint(String endpoint, String defaultValue) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                // simulate exception occurs
                if(Math.random()<0.6){
                    throw new RuntimeException("API call to " + endpoint + " failed.");
                }
                return "Data from " + endpoint;
            } catch (Exception e) {

                logger.log(Level.SEVERE, "Exception occurred during API call to " + endpoint, e);
                return defaultValue;
            }
        });
    }
}
