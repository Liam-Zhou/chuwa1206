package hw5;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Thread25 {
    public static void main(String[] args) {
        CompletableFuture<String> completableFuture = new CompletableFuture<>();
        int num1 = 2;
        int num2 = 3;
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.submit(() -> {
           try {
               Thread.sleep(1000);
               int sum = num1 + num2;
               int multply = num1 * num2;
               completableFuture.complete("sum: " + sum + " multiply: " + multply);
           } catch (InterruptedException e) {
               e.printStackTrace();
           }

        });

        try {
            System.out.println(completableFuture.get());
        } catch (Exception e) {
            e.printStackTrace();
        }


        //completable

        try {
            CompletableFuture<String> productsFuture = fetchProducts().exceptionally(throwable -> handleException("Products API", throwable, "Default Products Data"));;
            CompletableFuture<String> reviewsFuture = fetchReviews();
            CompletableFuture<String> inventoryFuture = fetchInventory();

            // Combine results when all futures are completed
            CompletableFuture<Void> allOf = CompletableFuture.allOf(productsFuture, reviewsFuture, inventoryFuture);

            // Further processing after all data is fetched
            CompletableFuture<String> result = allOf.thenApply(v ->
                    productsFuture.join() + "\n" + reviewsFuture.join() + "\n" + inventoryFuture.join());

            System.out.println(result.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }

    // Simulate fetching products from API
    private static CompletableFuture<String> fetchProducts() {
        return CompletableFuture.supplyAsync(() -> {
            // Simulate an exception
            throw new RuntimeException("Error fetching Products");
        });
    }

    // Simulate fetching reviews from API
    private static CompletableFuture<String> fetchReviews() {
        return CompletableFuture.supplyAsync(() -> "Reviews Data");
    }

    // Simulate fetching inventory from API
    private static CompletableFuture<String> fetchInventory() {
        return CompletableFuture.supplyAsync(() -> "Inventory Data");
    }

    private static String handleException(String apiName, Throwable throwable, String defaultValue) {
        System.out.println(apiName + " failed with exception: " + throwable.getMessage());
        return defaultValue;
    }
}
