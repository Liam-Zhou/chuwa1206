package Future;

import java.util.concurrent.CompletableFuture;

public class OnlineStoreWithExceptionHandling {
    public static void main(String[] args) {
        CompletableFuture<String> productsFuture = fetchDataFromAPI("https://jsonplaceholder.typicode.com/posts");
        CompletableFuture<String> reviewsFuture = fetchDataFromAPI("https://jsonplaceholder.typicode.com/comments");
        CompletableFuture<String> inventoryFuture = fetchDataFromAPI("https://jsonplaceholder.typicode.com/todos");

        CompletableFuture<Void> result = CompletableFuture.allOf(productsFuture, reviewsFuture, inventoryFuture);

        result.exceptionally(ex -> {
            System.out.println("Exception occurred: " + ex.getMessage());
            return null; // Return a default value or handle as needed
        });

        result.thenRun(() -> {
            String productsData = productsFuture.exceptionally(ex -> handleException(ex, "products")).join();
            String reviewsData = reviewsFuture.exceptionally(ex -> handleException(ex, "reviews")).join();
            String inventoryData = inventoryFuture.exceptionally(ex -> handleException(ex, "inventory")).join();

            // Process merged data here
            System.out.println("Merged Data:\n" + productsData + "\n" + reviewsData + "\n" + inventoryData);
        }).join();
    }

    private static CompletableFuture<String> fetchDataFromAPI(String apiUrl) {
        return CompletableFuture.supplyAsync(() -> {
            // Simulate API call
            // Replace this with actual API call in a real-world scenario
            System.out.println("Fetching data from " + apiUrl);

            // Simulate exception for illustration
            if (Math.random() < 0.2) {
                throw new RuntimeException("API call failed for " + apiUrl);
            }

            return "Data from " + apiUrl;
        });
    }

    private static String handleException(Throwable ex, String apiName) {
        System.out.println("Exception occurred for " + apiName + ": " + ex.getMessage());
        return "Default data for " + apiName;
    }
}
