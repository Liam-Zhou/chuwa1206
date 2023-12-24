package tutorial.excercise.completablefuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CompletableFutureHw2 {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture<String> productsFuture = fetchProducts();
        CompletableFuture<String> reviewsFuture = fetchReviews();
        CompletableFuture<String> inventoryFuture = fetchInventory();

        CompletableFuture<Void> combinedFuture = CompletableFuture.allOf(productsFuture, reviewsFuture, inventoryFuture);

        String combined = combinedFuture.thenApply(v -> {
            String products = productsFuture.join();
            String reviews = reviewsFuture.join();
            String inventory = inventoryFuture.join();
            return mergeData(products, reviews, inventory);
        }).get();

        System.out.println(combined);
    }

    private static CompletableFuture<String> fetchProducts() {
        return CompletableFuture.supplyAsync(() -> {
            return "Products data from API";
        });
    }

    private static CompletableFuture<String> fetchReviews() {
        return CompletableFuture.supplyAsync(() -> {
            return "Reviews data from API";
        });
    }

    private static CompletableFuture<String> fetchInventory() {
        return CompletableFuture.supplyAsync(() -> {
            return "Inventory data from API";
        });
    }
    
    private static String mergeData(String products, String reviews, String inventory) {
        return "Merged Data: \n" + products + "\n" + reviews + "\n" + inventory;
    }
}
