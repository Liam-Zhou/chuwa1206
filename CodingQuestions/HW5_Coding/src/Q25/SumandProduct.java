package Q25;

import java.util.concurrent.CompletableFuture;

public class SumandProduct {
    public static void main(String[] args) {
        int num1 = 5;
        int num2 = 10;

        CompletableFuture<Integer> sumFuture = CompletableFuture.supplyAsync(() -> sum(num1, num2));
        CompletableFuture<Integer> productFuture = CompletableFuture.supplyAsync(() -> product(num1, num2));

        sumFuture.thenAcceptAsync(result -> System.out.println("Sum: " + result));
        productFuture.thenAcceptAsync(result -> System.out.println("Product: " + result));

        // Wait for both tasks to complete
        CompletableFuture<Void> combinedFuture = CompletableFuture.allOf(sumFuture, productFuture);
        combinedFuture.join();
    }

    private static int sum(int a, int b) {
        sleep(1000); // Simulating a time-consuming operation
        return a + b;
    }

    private static int product(int a, int b) {
        sleep(1000); // Simulating a time-consuming operation
        return a * b;
    }

    private static void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
