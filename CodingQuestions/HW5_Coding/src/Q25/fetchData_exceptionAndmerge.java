package Q25;
import java.util.concurrent.CompletableFuture;
import java.util.logging.Level;
import java.util.logging.Logger;

public class fetchData_exceptionAndmerge {

    private static final Logger LOGGER = Logger.getLogger(OnlineStoreExample.class.getName());

    public static void main(String[] args) {
        CompletableFuture<Void> resultFuture = CompletableFuture
                .allOf(
                        fetchProducts(),
                        fetchReviews(),
                        fetchInventory()
                )
                .thenRunAsync(() -> {
                    try {
                        // Retrieve the results of each CompletableFuture with exception handling
                        String productsData = handleException(productsFuture, "Products Data");
                        String reviewsData = handleException(reviewsFuture, "Reviews Data");
                        String inventoryData = handleException(inventoryFuture, "Inventory Data");

                        // Merge the data for further processing
                        String mergedData = mergeData(productsData, reviewsData, inventoryData);

                        // Further processing with mergedData
                        System.out.println("Merged Data: " + mergedData);

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                });

        // Wait for all tasks to complete
        resultFuture.join();
    }

    private static CompletableFuture<String> fetchProducts() {
        return CompletableFuture.supplyAsync(() -> fetchDataFromApi("Products API", 2000));
    }

    private static CompletableFuture<String> fetchReviews() {
        return CompletableFuture.supplyAsync(() -> fetchDataFromApi("Reviews API", 1500));
    }

    private static CompletableFuture<String> fetchInventory() {
        return CompletableFuture.supplyAsync(() -> fetchDataFromApi("Inventory API", 1000));
    }

    private static String fetchDataFromApi(String apiName, int sleepMillis) {
        try {
            // Simulate fetching data from the API
            sleep(sleepMillis);
            // For simulation purposes, let's assume there was an exception during the API call
            throw new RuntimeException("Exception during " + apiName + " call");
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Exception occurred during " + apiName + " call", e);
            return "Default Data for " + apiName;
        }
    }

    private static String handleException(CompletableFuture<String> future, String defaultValue) {
        try {
            return future.join();
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Exception occurred during CompletableFuture execution", e);
            return defaultValue;
        }
    }

    private static String mergeData(String productsData, String reviewsData, String inventoryData) {
        // Simulate merging data from different sources
        return "Merged: " + productsData + ", " + reviewsData + ", " + inventoryData;
    }

    private static void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
