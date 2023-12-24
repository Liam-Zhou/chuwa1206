package Q25;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.concurrent.CompletableFuture;

public class HW2 {

    public static void main(String[] args) {
        HW2.demo();
    }
    public static void demo() {
        CompletableFuture<String> productInformation = ApiIntegration.getProductInformation();
        CompletableFuture<String> reviews = ApiIntegration.getReviews();
        CompletableFuture<String> inventory = ApiIntegration.getInventory();

        CompletableFuture<Void> combined = CompletableFuture.allOf(productInformation, reviews, inventory);

        // for future processing...
    }
}

class ApiIntegration {
    private static final HttpClient httpClient = HttpClient.newHttpClient();

    public static CompletableFuture<String> getProductInformation() {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://api.bestbuy.com/v1/products/8880044.json?show=sku,name,salePrice&apiKey=zhengyangfuhw5"))
                .build();
        return httpClient.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                .thenApply(HttpResponse::body);
    }

    public static CompletableFuture<String> getReviews() {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://jsonplaceholder.typicode.com/comments"))
                .build();
        return httpClient.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                .thenApply(HttpResponse::body);
    }

    public static CompletableFuture<String> getInventory() {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://api.bestbuy.com/v1/products/8880044.json?show=detail&apiKey=zhengyangfuhw5"))
                .build();
        return httpClient.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                .thenApply(HttpResponse::body);
    }
}