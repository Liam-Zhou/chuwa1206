package com.chuwa.tutorial.t08_multithreading;

import java.util.concurrent.CompletableFuture;

public class CompletableFutureExample1 {
    public static void main(String[] args){
        int num1 = 1;
        int num2 = 2;

        CompletableFuture<Integer> sum = CompletableFuture.supplyAsync(() -> calculateSum(num1, num2));
        CompletableFuture<Integer> prod = CompletableFuture.supplyAsync(() -> calculateProd(num1, num2));
        CompletableFuture<Void> combinedFuture = CompletableFuture.allOf(sum, prod);

        combinedFuture.thenRun(() -> {
           int sumResult = sum.join();
           int prodResult = prod.join();
           System.out.println("Sum: " + sumResult);
            System.out.println("Product: " + prodResult);
        });

        combinedFuture.join();
    }

    private static int calculateSum(int num1, int num2){
        return num1 + num2;
    }

    private static int calculateProd(int num1, int num2){
        return num1 * num2;
    }

}
