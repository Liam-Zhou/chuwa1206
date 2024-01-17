package CompletableFuture;

import java.util.concurrent.CompletableFuture;

public class HW1 {
    public static void main(String[] args) throws InterruptedException {
        CompletableFuture<Integer> cf1 = CompletableFuture.supplyAsync(() -> sum(1,2));
        CompletableFuture<Integer> cf2 = CompletableFuture.supplyAsync(() -> product(1,2));
        cf1.thenAccept((result) -> {
            System.out.println("sum: " + result);
        });
        cf1.exceptionally((e) -> {
                    e.printStackTrace();
                    return null;
        });
        cf2.thenAccept((result) -> {
            System.out.println("product: " + result);
        });
        cf2.exceptionally((e) -> {
            e.printStackTrace();
            return null;
        });
        Thread.sleep(200);
    }

    private static int sum(int a, int b) {
        return a+b;
    }

    private static int product(int a, int b) {
        return a*b;
    }
}
