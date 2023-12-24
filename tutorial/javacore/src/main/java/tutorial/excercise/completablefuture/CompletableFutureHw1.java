package tutorial.excercise.completablefuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CompletableFutureHw1 {

    public static void main(String[] args) {
        int a = 5;
        int b = 10;

        CompletableFuture<Integer> sumFuture = CompletableFuture.supplyAsync(() -> a + b);
        CompletableFuture<Integer> productFuture = CompletableFuture.supplyAsync(() -> a * b);

        sumFuture.thenAccept(sum -> System.out.println("Sum: " + sum));
        productFuture.thenAccept(product -> System.out.println("Product: " + product));

        try {
            CompletableFuture.allOf(sumFuture, productFuture).get();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }
}