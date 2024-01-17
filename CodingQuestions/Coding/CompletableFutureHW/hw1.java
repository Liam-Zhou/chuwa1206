package Coding.CompletableFutureHW;

import java.util.concurrent.CompletableFuture;

public class hw1 {

    public static void main(String[] args) {
        int a = 3;
        int b = 5;

        CompletableFuture<Integer> sumFuture = CompletableFuture.supplyAsync(() -> add(a, b));
        CompletableFuture<Integer> productFuture = CompletableFuture.supplyAsync(() -> product(a, b));

        // Combine the results of both CompletableFuture
        CompletableFuture<Void> combinedFuture = sumFuture.thenCombine(productFuture, (sum, product) -> {
            System.out.println("Sum: " + sum);
            System.out.println("Product: " + product);
            return null;
        });
        combinedFuture.join();
        System.out.println("Main Thread Terminated");
    }

    private static int add(int a, int b) {
        return a + b;
    }

    private static int product(int a, int b) {
        return a * b;
    }


}
