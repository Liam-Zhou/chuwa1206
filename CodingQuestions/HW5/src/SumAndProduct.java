import java.util.concurrent.CompletableFuture;

public class SumAndProduct {
    public static void main(String[] args) {
        int num1 = 5;
        int num2 = 10;

        CompletableFuture<Integer> sumFuture = CompletableFuture.supplyAsync(() -> {
            System.out.println("Calculating sum asynchronously...");
            return num1 + num2;
        });

        CompletableFuture<Integer> productFuture = CompletableFuture.supplyAsync(() -> {
            System.out.println("Calculating product asynchronously...");
            return num1 * num2;
        });

        sumFuture.thenAccept(result -> System.out.println("Sum: " + result));
        productFuture.thenAccept(result -> System.out.println("Product: " + result));
    }
}
