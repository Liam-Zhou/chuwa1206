package Coding.CompletableFutureHW;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

 class FutureFetchAPI {
    public static void main(String[] args) {
        CompletableFuture<String> productsFuture = fetchDataFromAPI("https://jsonplaceholder.typicode.com/posts/1");
        CompletableFuture<String> reviewsFuture = fetchDataFromAPI("https://jsonplaceholder.typicode.com/comments/1");
        CompletableFuture<String> inventoryFuture = fetchDataFromAPI("https://jsonplaceholder.typicode.com/todos/1");

        CompletableFuture<Void> mergeResult = CompletableFuture.allOf(productsFuture, reviewsFuture, inventoryFuture)
                .thenRun(() -> {
                    try {
                        String productsData = productsFuture.get();
                        String reviewsData = reviewsFuture.get();
                        String inventoryData = inventoryFuture.get();

                        System.out.println("Product Data: " + productsData);
                        System.out.println("Review Data: " + reviewsData);
                        System.out.println("Merged Inventory Data: " + inventoryData);
                    } catch (InterruptedException | ExecutionException e) {
                        handleException("Exception during processing", e);
                    }
                });

        mergeResult.join();
    }

    private static CompletableFuture<String> fetchDataFromAPI(String api) {
        HttpClient httpClient = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(api)).build();

        return CompletableFuture.supplyAsync(() -> {
            try {
                System.out.println("Fetching data from: " + api);
                HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
                return response.body();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }).exceptionally(throwable -> handleFetchException(api, throwable));
    }

    private static void handleException(String message, Exception e) {
        System.out.println(message);
        e.printStackTrace();
    }

    private static String handleFetchException(String api, Throwable throwable) {
        System.err.println("Exception during fetching from: " + api);
        throwable.printStackTrace();
        return "Here is the default data from " + api;
    }
}