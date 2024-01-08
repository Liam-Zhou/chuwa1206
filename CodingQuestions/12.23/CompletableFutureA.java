import java.util.concurrent.*;

/**
 * Question 25 part a
 */
public class CompletableFutureA {
    public static void main(String[] args) {
        int num1 = 10;
        int num2 = 20;
        CompletableFuture<Integer> sumFuture = CompletableFuture.supplyAsync(() -> num1 + num2);
        CompletableFuture<Integer> productFuture = CompletableFuture.supplyAsync(() -> num1 * num2);
        sumFuture.thenAcceptBoth(productFuture,
                (sum, product) ->
                        System.out.printf("%d + %d = %d, %d * %d = %d", num1, num2, sum, num1, num2, product)
        );
    }
}
