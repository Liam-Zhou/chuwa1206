package coding_hw5;

import java.util.concurrent.CompletableFuture;

public class OnlineStoreExample {

    public static void main(String[] args) {
        // Replace these URLs with the actual URLs of the APIs you want to use
        String productsApiUrl = "https://jsonplaceholder.typicode.com/todos/1";
        String reviewsApiUrl = "https://jsonplaceholder.typicode.com/comments/1";
        String inventoryApiUrl = "https://jsonplaceholder.typicode.com/posts/1";

        CompletableFuture<String> productsFuture = fetchDataFromApi(productsApiUrl);
        CompletableFuture<String> reviewsFuture = fetchDataFromApi(reviewsApiUrl);
        CompletableFuture<String> inventoryFuture = fetchDataFromApi(inventoryApiUrl);

        // Combine the results when all API calls are complete
        CompletableFuture<Void> combinedFuture = CompletableFuture.allOf(
                productsFuture, reviewsFuture, inventoryFuture);

        // Handle the combined results
        combinedFuture.thenAcceptAsync((Void) -> {
            String productsData = productsFuture.join();
            String reviewsData = reviewsFuture.join();
            String inventoryData = inventoryFuture.join();

            // Merge and process the data as needed
            String mergedData = mergeData(productsData, reviewsData, inventoryData);
            System.out.println("Merged Data: " + mergedData);
        }).join();
    }

    private static CompletableFuture<String> fetchDataFromApi(String apiUrl) {
        return CompletableFuture.supplyAsync(() -> {
            // Simulate fetching data from the API
            // Replace this with your actual logic to fetch data from the API
            System.out.println("Fetching data from API: " + apiUrl);
            return "Data from " + apiUrl;
        });
    }

    private static String mergeData(String productsData, String reviewsData, String inventoryData) {
        // Replace this with your actual logic to merge and process the data
        return "Merged Data: \nProducts: " + productsData + "\nReviews: " + reviewsData + "\nInventory: " + inventoryData;
    }
}
