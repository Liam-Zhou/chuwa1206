package CompletableFuture;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class HW2 {
    private static final HttpClient httpClient = HttpClient.newHttpClient();
    public static void main(String[] args) {
        CompletableFuture<String> products;
        CompletableFuture<String> reviews;
        CompletableFuture<String> inventory;
        try {
            products = fetchDataFromAPI("https://my-json-server.typicode.com/queenieohyeah/fake_apis/products");
            reviews = fetchDataFromAPI("https://my-json-server.typicode.com/queenieohyeah/fake_apis/reviews");
            inventory = fetchDataFromAPI("https://my-json-server.typicode.com/queenieohyeah/fake_apis/inventory");
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        CompletableFuture<Void> allOf = CompletableFuture.allOf(products, reviews, inventory);
        allOf.exceptionally((e) -> {
            e.printStackTrace();
            return null;
        });

        // Handle further processing after all data is fetched
        allOf.thenRun(() -> {
            String productsData = products.join();
            String reviewsData = reviews.join();
            String inventoryData = inventory.join();


            System.out.println("Merged and processed data: ");
            System.out.println("Products: " + productsData);
            System.out.println("Reviews: " + reviewsData);
            System.out.println("Inventory: " + inventoryData);

        });

        // Keep the main thread alive to allow CompletableFuture to complete
        try {
            Thread.sleep(5000); // Sleep for 5 seconds for CompletableFuture to complete
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static CompletableFuture<String> fetchDataFromAPI(String apiUrl) throws ExecutionException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(apiUrl))
                .build();
        CompletableFuture<Void> response = httpClient.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                .thenAccept((resp) -> {
                    int status = resp.statusCode();
                    if (status != 200) {
                        System.out.println(resp.body());
                        throw new APIException("Api Error");
                    }
                });
        response.get();


        return httpClient.sendAsync(request, HttpResponse.BodyHandlers.ofString()).thenApply(HttpResponse::body);


    }

    private static class APIException extends RuntimeException {
        public APIException(String s) {
            super(s);
        }
    }
}
