package Future;

import java.util.concurrent.CompletableFuture;

public class OnlineStore {
    public static void main(String[] args) {
        CompletableFuture<String> productsFuture = fetchDataFromAPI("https://jsonplaceholder.typicode.com/todos/1");
        CompletableFuture<String> reviewsFuture = fetchDataFromAPI("https://jsonplaceholder.typicode.com/todos/1");
        CompletableFuture<String> inventoryFuture = fetchDataFromAPI("https://jsonplaceholder.typicode.com/todos/1");

        CompletableFuture<Void> result = CompletableFuture.allOf(productsFuture, reviewsFuture, inventoryFuture);

        result.thenRun(() -> {
            String productsData = productsFuture.join();
            String reviewsData = reviewsFuture.join();
            String inventoryData = inventoryFuture.join();

            // Process merged data here
            System.out.println("Merged Data:\n" + productsData + "\n" + reviewsData + "\n" + inventoryData);
        }).join();
    }

    private static CompletableFuture<String> fetchDataFromAPI(String apiUrl) {
        return CompletableFuture.supplyAsync(() -> {
            // Simulate API call
            // Replace this with actual API call in a real-world scenario
            System.out.println("Fetching data from " + apiUrl);
            return "Data from " + apiUrl;
        });
    }
}
