package tutorial.excercise.completablefuture;

import java.util.concurrent.CompletableFuture;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.URI;

public class CompletableFutureHw2 {

    private static final HttpClient httpClient = HttpClient.newHttpClient();

    public static CompletableFuture<String> fetchFromAPI(String endpoint) {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://my-json-server.typicode.com/arield3/FakeAPI/" + endpoint))
                .build();
        return httpClient.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                .thenApply(HttpResponse::body);
    }

    public static void main(String[] args) {
        CompletableFuture<String> productsFuture = fetchFromAPI("products");
        CompletableFuture<String> reviewsFuture = fetchFromAPI("reviews");
        CompletableFuture<String> inventoryFuture = fetchFromAPI("inventory");

        CompletableFuture<Void> allFutures = CompletableFuture.allOf(
                productsFuture,
                reviewsFuture,
                inventoryFuture
        );

        allFutures.thenApply(v -> {
            try {
                String products = productsFuture.get();
                String reviews = reviewsFuture.get();
                String inventory = inventoryFuture.get();

                processFetchedData(products, reviews, inventory);

            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }).join();
    }

    private static void processFetchedData(String products, String reviews, String inventory) {
        System.out.println("Products: " + products);
        System.out.println("Reviews: " + reviews);
        System.out.println("Inventory: " + inventory);
    }
}