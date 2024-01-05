package com.chuwa.exercise.CompletableFuture;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class Hw2AndHw3 {
    private static final HttpClient httpClient = HttpClient.newHttpClient();
    public static void main(String[] args) {
        CompletableFuture<String> products = getProductInformation();
        CompletableFuture<String> reviews = getReviews();
        CompletableFuture<String> inventories = getInventory();

        CompletableFuture<Void> allInformation = CompletableFuture.allOf(products, reviews, inventories);
        try {
            // 等待所有给定的 CompletableFuture 完成
            String productResults = products.get();
            String reviewResults = reviews.get();
            String inventoryResults = inventories.get();

            System.out.println("productResults: " + productResults);
            System.out.println("reviewResults: " + reviewResults);
            System.out.println("inventoryResults: " + inventoryResults);


        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }

    public static CompletableFuture<String> getProductInformation() {

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://my-json-server.typicode.com/flyflyflybird/fakeApi/products"))
                .build();
        return httpClient.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                .thenApply(HttpResponse::body)
                .exceptionally(e -> {
                    e.printStackTrace();
                    return handleExceptional();
                });
    }

    public static CompletableFuture<String> getReviews() {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://my-json-server.typicode.com/flyflyflybird/fakeApi/reviews"))
                .build();
        return httpClient.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                .thenApply(HttpResponse::body)
                .exceptionally(e -> {
                    e.printStackTrace();
                    return handleExceptional();
                });
    }

    public static CompletableFuture<String> getInventory() {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://my-json-server.typicode.com/flyflyflybird/fakeApi/inventory"))
                .build();
        return httpClient.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                .thenApply(HttpResponse::body)
                .exceptionally(e -> {
                    e.printStackTrace();
                    return handleExceptional();
                });
    }

    public static String handleExceptional(){
        return "Loading";
    }
}
