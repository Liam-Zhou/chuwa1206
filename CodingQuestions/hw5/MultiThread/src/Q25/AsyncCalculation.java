package Q25;

import java.util.concurrent.CompletableFuture;

public class AsyncCalculation {

    public static void main(String[] args) {
        int a = 5;
        int b = 10;

        CompletableFuture<Integer> sumFuture = CompletableFuture.supplyAsync(() -> {
            return a + b;
        });

        CompletableFuture<Integer> productFuture = CompletableFuture.supplyAsync(() -> {
            return a * b;
        });

        sumFuture.thenAccept(sum -> System.out.println("Sum: " + sum));

        productFuture.thenAccept(product -> System.out.println("Product: " + product));

        CompletableFuture<Void> combinedFuture = CompletableFuture.allOf(sumFuture, productFuture);
        combinedFuture.join();
        System.out.println("Both sum and product calculations are complete.");
    }
}
