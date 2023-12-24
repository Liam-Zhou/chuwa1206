package coding_hw5;

import java.util.concurrent.CompletableFuture;
import java.util.logging.Level;
import java.util.logging.Logger;

public class OnlineStoreExampleWithExceptionHandling {

    private static final Logger logger = Logger.getLogger(OnlineStoreExampleWithExceptionHandling.class.getName());

    public static void main(String[] args) {
        // Replace these URLs with the actual URLs of the APIs you want to use
        String productsApiUrl = "https://jsonplaceholder.typicode.com/todos/1";
        String reviewsApiUrl = "https://jsonplaceholder.typicode.com/comments/1";
        String inventoryApiUrl = "https://jsonplaceholder.typicode.com/posts/1";

        CompletableFuture<String> productsFuture = fetchDataFromApi(productsApiUrl, "Default Products Data");
        CompletableFuture<String> reviewsFuture = fetchDataFromApi(reviewsApiUrl, "Default Reviews Data");
        CompletableFuture<String> inventoryFuture = fetchDataFromApi(inventoryApiUrl, "Default Inventory Data");

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

    private static CompletableFuture<String> fetchDataFromApi(String apiUrl, String defaultValue) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                // Simulate fetching data from the API
                // Replace this with your actual logic to fetch data from the API
                System.out.println("Fetching data from API: " + apiUrl);
                // Simulate an exception (remove this line in a real scenario)
                // throw new RuntimeException("Simulated exception during API call");
                return "Data from " + apiUrl;
            } catch (Exception e) {
                // Log the exception information
                logger.log(Level.SEVERE, "Exception during API call", e);
                // Return the default value in case of an exception
                return defaultValue;
            }
        }).exceptionally(ex -> {
            // Log the exception information
            logger.log(Level.SEVERE, "Exception during API call", ex);
            // Return the default value in case of an exception
            return defaultValue;
        });
    }

    private static String mergeData(String productsData, String reviewsData, String inventoryData) {

        return "Merged Data: \nProducts: " + productsData + "\nReviews: " + reviewsData + "\nInventory: " + inventoryData;
    }
}
