//a. Sum and Product of Two Integers Asynchronously:

import java.util.concurrent.CompletableFuture;

public class AsyncCalculation {

    public static void main(String[] args) {
        CompletableFuture<Integer> futureSum = CompletableFuture.supplyAsync(() -> 5 + 10);
        CompletableFuture<Integer> futureProduct = CompletableFuture.supplyAsync(() -> 5 * 10);

        futureSum.thenAccept(sum -> System.out.println("Sum: " + sum));
        futureProduct.thenAccept(product -> System.out.println("Product: " + product));
    }
}

//b. Fetch Data from APIs Asynchronously:

public class FetchDataFromAPIs {

    public static CompletableFuture<String> fetchProducts() {
        return CompletableFuture.supplyAsync(() -> "Product data");
    }

    public static CompletableFuture<String> fetchReviews() {
        return CompletableFuture.supplyAsync(() -> "Review data");
    }

    public static CompletableFuture<String> fetchInventory() {
        return CompletableFuture.supplyAsync(() -> "Inventory data");
    }

    public static void main(String[] args) {
        CompletableFuture<Void> allFutures = CompletableFuture.allOf(
                fetchProducts(),
                fetchReviews(),
                fetchInventory()
        );

        allFutures.thenAccept(v -> {
            System.out.println("All data fetched");
        });

        allFutures.exceptionally(e -> {
            System.out.println("An error occurred: " + e.getMessage());
            return null;
        });
    }
}

//c. Implement Exception Handling:

public static CompletableFuture<String> fetchProducts() {
    return CompletableFuture.supplyAsync(() -> {
        if (Math.random() > 0.5) throw new RuntimeException("Failed to fetch products");
        return "Product data";
    });
}

