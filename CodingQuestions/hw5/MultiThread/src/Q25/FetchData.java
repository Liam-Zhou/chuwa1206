package Q25;

import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.concurrent.CompletableFuture;
import java.util.logging.Logger;

public class FetchData {

    private static final String API_KEY = "key";
    private static final HttpClient client = HttpClient.newHttpClient();
    private static final Logger logger = Logger.getLogger(FetchData.class.getName());

    public static void main(String[] args) {
        CompletableFuture<String> productsFuture = fetchFromApi("products");
        CompletableFuture<String> reviewsFuture = fetchFromApi("reviews");
        CompletableFuture<String> inventoryFuture = fetchFromApi("inventory");

        productsFuture.thenCombine(reviewsFuture, (products, reviews) -> {
            return "Processed data: " + products + " | " + reviews;
        }).thenCombine(inventoryFuture, (processedData, inventory) -> {
            System.out.println(processedData + " | " + inventory);
        }).join();
    }

    private static CompletableFuture<String> fetchFromApi(String endpoint) {
        String url = "https://api.bestbuy.com/v1/" + endpoint + "?apiKey=" + API_KEY;
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(url)).build();
        return client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                .thenApply(HttpResponse::body)
                .exceptionally(e -> {
                    logger.severe("Error fetching data from " + endpoint + ": " + e.getMessage());
                    return "Default Value";
                });
    }
}
