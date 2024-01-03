package Multi_Threading.Q3;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class SumOfTwoInt {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        int num1 = 5;
        int num2 = 10;

        CompletableFuture<Integer> sumFuture = CompletableFuture.supplyAsync(() -> calculateSum(num1, num2));
        CompletableFuture<Integer> productFuture = CompletableFuture.supplyAsync(() -> calculateProduct(num1, num2));

        CompletableFuture.allOf(sumFuture, productFuture)
                .thenAccept((v) -> {
                    int sum = sumFuture.join();
                    int product = productFuture.join();
                    System.out.println("Sum: " + sum);
                    System.out.println("Product: " + product);
                });
    }

    private static int calculateSum(int a, int b) {
        return a + b;
    }

    private static int calculateProduct(int a, int b) {
        return a * b;
    }
}
