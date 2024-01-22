package Future;

import java.util.concurrent.CompletableFuture;

public class CompletableFutureExample {
    public static void main(String[] args) {
        CompletableFuture<Integer> sumFuture = CompletableFuture.supplyAsync(() -> 5 + 3);
        CompletableFuture<Integer> productFuture = CompletableFuture.supplyAsync(() -> 5 * 3);

        sumFuture.thenCombine(productFuture, (sum, product) -> {
            System.out.println("Sum: " + sum);
            System.out.println("Product: " + product);
            return null;
        }).join();
    }
}
