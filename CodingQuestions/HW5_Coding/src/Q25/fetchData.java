package Q25;
import java.util.concurrent.CompletableFuture;

public class fetchData {
    public static void main(String[] args) {
        CompletableFuture<Void> resultFuture = CompletableFuture
                .allOf(
                        fetchProducts(),
                        fetchReviews(),
                        fetchInventory()
                )
                .thenRunAsync(() -> {
                    try {
                        // Retrieve the results of each CompletableFuture
                        String productsData = productsFuture.join();
                        String reviewsData = reviewsFuture.join();
                        String inventoryData = inventoryFuture.join();

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
        return CompletableFuture.supplyAsync(() -> {
            // Simulate fetching data from the products API
            sleep(2000);
            return "Products Data";
        });
    }

    private static CompletableFuture<String> fetchReviews() {
        return CompletableFuture.supplyAsync(() -> {
            // Simulate fetching data from the reviews API
            sleep(1500);
            return "Reviews Data";
        });
    }

    private static CompletableFuture<String> fetchInventory() {
        return CompletableFuture.supplyAsync(() -> {
            // Simulate fetching data from the inventory API
            sleep(1000);
            return "Inventory Data";
        });
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
