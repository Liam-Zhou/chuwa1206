package t08_multithreading.exercise.complete_future;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class Homework2 {

//    private static final HttpClient httpClient = HttpClient.newHttpClient();

    private static final HttpClient httpClient = HttpClient.newHttpClient();

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture<String> productDataFuture = fetchFromApi("https://jsonplaceholder.typicode.com/posts/1");
        CompletableFuture<String> reviewDataFuture = fetchFromApi("https://jsonplaceholder.typicode.com/comments?postId=1");
        CompletableFuture<String> inventoryDataFuture = fetchFromApi("https://jsonplaceholder.typicode.com/users/1");

        CompletableFuture<Void> combinedFuture = CompletableFuture.allOf(productDataFuture, reviewDataFuture, inventoryDataFuture);

        combinedFuture.thenRun(() -> {
            try {
                String productData = productDataFuture.get();
                String reviewData = reviewDataFuture.get();
                String inventoryData = inventoryDataFuture.get();

                // 这里你可以合并和处理数据
                System.out.println("Product Data: " + productData);
                System.out.println("Review Data: " + reviewData);
                System.out.println("Inventory Data: " + inventoryData);
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }).get();
    }

    private static CompletableFuture<String> fetchFromApi(String uri) {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(uri))
                .GET()
                .build();

        return httpClient.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                .thenApply(HttpResponse::body);
    }
}
