import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Question 25 part b and part c
 */
public class ApiIntegration {
    private static final HttpClient httpClient = HttpClient.newHttpClient();
    private static final Logger logger = Logger.getLogger(ApiIntegration.class.getName());

    public static void main(String[] args) {
        CompletableFuture<String> products = getProductInformation();
        CompletableFuture<String> reviews = getReviews();
        products.thenAcceptBoth(reviews, (product, review) -> System.out.println(product + review)).join();
    }

    public static CompletableFuture<String> getProductInformation() {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://jsonplaceholder.typicode.com/posts/1"))
                .build();
        return httpClient.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                .thenApply(HttpResponse::body)
                .exceptionally(e -> {
                    logger.log(Level.SEVERE, "Exception in getProductInformaiton", e);
                    return "Default";
                });
    }

    public static CompletableFuture<String> getReviews() {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://jsonplaceholder.typicode.com/posts/2"))
                .build();
        return httpClient.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                .thenApply(HttpResponse::body)
                .exceptionally(e -> {
                    logger.log(Level.SEVERE, "Exception in getReviews", e);
                    return "Default";
                });
    }

    public static CompletableFuture<String> getInventory() {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://jsonplaceholder.typicode.com/posts/3"))
                .build();
        return httpClient.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                .thenApply(HttpResponse::body)
                .exceptionally(e -> {
                    logger.log(Level.SEVERE, "Exception in getInventory", e);
                    return "Default";
                });
    }
}
