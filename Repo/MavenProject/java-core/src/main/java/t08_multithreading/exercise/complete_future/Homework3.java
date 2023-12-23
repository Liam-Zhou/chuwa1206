package t08_multithreading.exercise.complete_future;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
public class Homework3 {
    private static final HttpClient httpClient = HttpClient.newHttpClient();

    public static void main(String[] args) {
        CompletableFuture<String> productDataFuture = fetchFromApi("https://jsonplaceholder.typicode.com/posts/1");
        CompletableFuture<String> reviewDataFuture = fetchFromApi("https://jsonplaceholder.typicode.com/comments/1");
        CompletableFuture<String> inventoryDataFuture = fetchFromApi("https://jsonplaceholder.typicode.com/users/1");

        CompletableFuture<Void> combinedFuture = CompletableFuture.allOf(productDataFuture, reviewDataFuture, inventoryDataFuture);

        combinedFuture.thenRun(() -> {
            String productData = productDataFuture.join();
            String reviewData = reviewDataFuture.join();
            String inventoryData = inventoryDataFuture.join();

            System.out.println("Product Data: " + productData);
            System.out.println("Review Data: " + reviewData);
            System.out.println("Inventory Data: " + inventoryData);
        }).exceptionally(ex -> {
            System.err.println("An error occurred: " + ex.getMessage());
            return null;
        });
    }
    private static CompletableFuture<String> fetchFromApi(String uri) {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(uri))
                .GET()
                .build();

        return httpClient.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                .thenApply(HttpResponse::body)
                .exceptionally(ex -> {
                    System.err.println("Error fetching data from " + uri + ": " + ex.getMessage());
                    return "Default Value";
                });
    }
}
