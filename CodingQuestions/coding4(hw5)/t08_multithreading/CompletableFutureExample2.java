package com.chuwa.tutorial.t08_multithreading;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.concurrent.CompletableFuture;

public class CompletableFutureExample2 {

    public static void main(String[] args){
        String productsUrl = "https://jsonplaceholder.typicode.com/posts";
        String reviewsUrl = "https://jsonplaceholder.typicode.com/comments";
        String inventoryUrl = "https://jsonplaceholder.typicode.com/todos";

        CompletableFuture<String> productsFuture = fetchDataAsync(productsUrl, "product");
        CompletableFuture<String> reviewsFuture = fetchDataAsync(productsUrl, "review");
        CompletableFuture<String> inventoryFuture = fetchDataAsync(productsUrl, "inventory");

        CompletableFuture<Void> combinedFuture = CompletableFuture.allOf(productsFuture, reviewsFuture, inventoryFuture);

        combinedFuture.thenRun(() -> {
            String products = productsFuture.join();
            String reviews = reviewsFuture.join();
            String inventory = inventoryFuture.join();

            String merged = mergeData(products, reviews, inventory);
            System.out.println(merged);
        });

        combinedFuture.join();




    }
    private static CompletableFuture<String> fetchDataAsync(String apiUrl, String apiName){
        return CompletableFuture.supplyAsync(() -> {
            System.out.println("Fetch data from" + apiName);
            try{
                HttpClient client = HttpClient.newHttpClient();
                HttpRequest request = HttpRequest.newBuilder()
                        .uri(URI.create(apiUrl))
                        .build();

                HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
                return response.body();
            } catch(Exception e) {
                throw new RuntimeException("error");
            }

        });
    }

    private static String mergeData(String products, String reviews, String inventory){
        return "Merged Data: \n" + products + "\n" + reviews + "\n" + inventory;
    }


}
