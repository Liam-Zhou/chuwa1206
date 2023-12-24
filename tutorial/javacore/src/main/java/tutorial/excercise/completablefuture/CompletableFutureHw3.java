package tutorial.excercise.completablefuture;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.concurrent.CompletableFuture;
// DEFAULT_VALUE
import java.util.logging.Logger;
import java.util.logging.Level;

public class CompletableFutureHw3 {

    private static final HttpClient httpClient = HttpClient.newHttpClient();
    private static final Logger logger = Logger.getLogger(CompletableFutureHw2.class.getName());
    // DEFAULT_VALUE
    private static final String DEFAULT_VALUE = "{}";

    public static CompletableFuture<String> fetchFromAPI(String endpoint) {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://my-json-server.typicode.com/arield3/FakeAPI/" + endpoint))
                .build();
        return httpClient.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                .thenApply(HttpResponse::body)
                .exceptionally(e -> {
                    logger.log(Level.SEVERE, "Exception occurred during API call: " + endpoint, e);
                    return DEFAULT_VALUE;
                });
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