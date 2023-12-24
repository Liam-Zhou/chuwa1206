package coding_hw5;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * Write a simple program that uses CompletableFuture to asynchronously get the sum and product of two integers,
 * and print the results.
 */
public class CompletableFutureTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        int va1 = 5, va2 = 15;
        //创建异步任务
        CompletableFuture<Integer> sumCompletableFuture = CompletableFuture.supplyAsync(() -> va1 + va2);
        CompletableFuture<Integer> productCompletableFuture = CompletableFuture.supplyAsync(() -> va1 * va2);
        CompletableFuture<Object> objectCompletableFuture = sumCompletableFuture.thenCombineAsync(productCompletableFuture, (sum, product) -> {
            System.out.println("sum : " + sum);
            System.out.println("product : " + product);
            return null;
        });
        objectCompletableFuture.get();

    }

}
