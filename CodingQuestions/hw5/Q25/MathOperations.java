import java.util.concurrent.CompletableFuture;

public class MathOperations {

    public static void main(String[] args) {
        CompletableFuture<Integer> futureSum = CompletableFuture.supplyAsync(() -> {
            return 10 + 20; // Replace with actual values or calculations
        });

        CompletableFuture<Integer> futureProduct = CompletableFuture.supplyAsync(() -> {
            return 10 * 20; // Replace with actual values or calculations
        });

        futureSum.thenAccept(sum -> System.out.println("Sum: " + sum));
        futureProduct.thenAccept(product -> System.out.println("Product: " + product));
    }
}

