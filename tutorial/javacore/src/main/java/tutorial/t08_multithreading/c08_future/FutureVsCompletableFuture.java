package tutorial.t08_multithreading.c08_future;

import org.junit.jupiter.api.Test;

import java.util.concurrent.*;

public class FutureVsCompletableFuture {

    @Test
    public void testFuture() {
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        Future<Integer> futureResult = executorService.submit(() -> {
            TimeUnit.SECONDS.sleep(5);
            return 10 + 20;
        });

        try {
            System.out.println("Performing other tasks...");

            int result = futureResult.get();
            System.out.println("Result from the future: " + result);

            System.out.println("----");

            for (int i = 0; i < 7; i++) {
                System.out.println("step " + i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        } finally {
            executorService.shutdown();
        }
    }

    @Test
    public void testCompletableFuture() {
        CompletableFuture<Integer> completableFuture = CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return 10 + 20;
        });

        System.out.println("Performing other tasks...");

        completableFuture.thenAccept(result -> System.out.println("Result from the CompletableFuture: " + result));

        System.out.println("----");
        for (int i = 0; i < 7; i++) {
            System.out.println("step " + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}

