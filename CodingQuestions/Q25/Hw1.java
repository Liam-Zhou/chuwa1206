package Q25;

import java.util.concurrent.CompletableFuture;

public class Hw1 {
    public static void main(String[] args) {
        demo(2, 3);
    }
    public static void demo(int a, int b) {
        CompletableFuture future = CompletableFuture.supplyAsync(() -> a + b)
                .thenAcceptBoth(CompletableFuture.supplyAsync(() -> a * b),
                        (s1, s2) -> System.out.println("sum: " + s1 + ", " + "product: " + s2));
    }
}
