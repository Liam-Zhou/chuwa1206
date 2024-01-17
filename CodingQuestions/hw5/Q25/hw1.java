import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CompletableFutureDemo {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        int a = 10;
        int b = 5;

        // Asynchronously compute the sum of a and b
        CompletableFuture<Integer> sumFuture = CompletableFuture.supplyAsync(() -> {
            return a + b;
        });

        // Asynchronously compute the product of a and b
        CompletableFuture<Integer> productFuture = CompletableFuture.supplyAsync(() -> {
            return a * b;
        });

        // Wait and get the results
        int sum = sumFuture.get();
        int product = productFuture.get();

        // Print the results
        System.out.println("Sum: " + sum);
        System.out.println("Product: " + product);
    }
}
