import java.util.concurrent.CompletableFuture;


public class CompletableFutureExample {
    public static void main(String[] args) {
        int number1 = 5;
        int number2 = 10;

        CompletableFuture<Integer> sumFuture =
                CompletableFuture.supplyAsync(() -> number1 + number2);

        CompletableFuture<Integer> productFuture =
                CompletableFuture.supplyAsync(() -> number1 * number2);

        sumFuture.thenAccept(sum -> System.out.println("Sum: " + sum));

        productFuture.thenAccept(product -> System.out.println("Product: " + product));

        CompletableFuture.allOf(sumFuture, productFuture).join();
    }
}
