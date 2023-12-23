package t08_multithreading.exercise.complete_future;

import java.util.concurrent.CompletableFuture;

public class Homework1 {

    public static void main(String[] args) {
        int num1 = 5;
        int num2 = 10;
        CompletableFuture<Integer> sumFuture = CompletableFuture.supplyAsync(() -> {
            return num1 + num2;
        });

        CompletableFuture<Integer> productFuture = CompletableFuture.supplyAsync(() -> {
            return num1 * num2;
        });

        sumFuture.thenCombine(productFuture, (sum, product) -> {
            System.out.println("Sum: " + sum);
            System.out.println("Product: " + product);
            return null;
        }).join();
    }
}

