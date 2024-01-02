import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class OnlineStoreExample {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // Async call to fetch products
        CompletableFuture<String> productsFuture = CompletableFuture.supplyAsync(() -> fetchProducts());

        // Async call to fetch reviews
        CompletableFuture<String> reviewsFuture = CompletableFuture.supplyAsync(() -> fetchReviews());

        // Async call to fetch inventory
        CompletableFuture<String> inventoryFuture = CompletableFuture.supplyAsync(() -> fetchInventory());

        // Combine all futures and process the results
        CompletableFuture<Void> combinedFuture = CompletableFuture.allOf(productsFuture, reviewsFuture, inventoryFuture)
            .thenRun(() -> {
                try {
                    String products = productsFuture.get();
                    String reviews = reviewsFuture.get();
                    String inventory = inventoryFuture.get();

                    // Further processing with the fetched data
                    processFetchedData(products, reviews, inventory);
                } catch (InterruptedException | ExecutionException e) {
                    e.printStackTrace();
                }
            });

        // Wait for all futures to complete
        combinedFuture.get();
    }

    private static String fetchProducts() {
        
        return "Products Data";
    }

    private static String fetchReviews() {
        
        return "Reviews Data";
    }

    private static String fetchInventory() {
        
        return "Inventory Data";
    }

    private static void processFetchedData(String products, String reviews, String inventory) {
        System.out.println("Processing fetched data:");
        System.out.println(products);
        System.out.println(reviews);
        System.out.println(inventory);
    }
}
