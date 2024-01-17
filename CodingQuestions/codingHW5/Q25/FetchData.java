package com.chuwa.tutorial.t08_multithreading.c08_future;

import java.util.concurrent.CompletableFuture;

public class FetchData {
    public static void main(String[] args) {

        String productEndpoint = "https://jsonplaceholder.typicode.com/posts/1";
        String reviewsEndpoint = "https://jsonplaceholder.typicode.com/comments/1";
        String inventoryEndpoint = "https://jsonplaceholder.typicode.com/todos/1";


        CompletableFuture<String> productDataFuture = fetchDataFromEndpoint(productEndpoint);


        CompletableFuture<String> reviewsDataFuture = fetchDataFromEndpoint(reviewsEndpoint);


        CompletableFuture<String> inventoryDataFuture = fetchDataFromEndpoint(inventoryEndpoint);


        CompletableFuture<Void> combinedFuture = CompletableFuture.allOf(
                productDataFuture, reviewsDataFuture, inventoryDataFuture
        );

        combinedFuture.thenRun(() -> {
            String productData = productDataFuture.join();
            String reviewsData = reviewsDataFuture.join();
            String inventoryData = inventoryDataFuture.join();


            System.out.println("Product Data: " + productData);
            System.out.println("Reviews Data: " + reviewsData);
            System.out.println("Inventory Data: " + inventoryData);


        });

        combinedFuture.join();


    }


    private static CompletableFuture<String> fetchDataFromEndpoint(String endpoint) {
        return CompletableFuture.supplyAsync(() -> "Data from " + endpoint);
    }
}
