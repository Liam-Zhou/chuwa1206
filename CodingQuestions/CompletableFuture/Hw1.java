package com.chuwa.exercise.CompletableFuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class Hw1 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        int num1 = 5;
        int num2 = 10;

        CompletableFuture<Integer> sumFuture = CompletableFuture.supplyAsync(() -> num1 + num2);
        CompletableFuture<Integer> productFuture = CompletableFuture.supplyAsync(() -> num1 * num2);
        System.out.println(sumFuture.get());
        System.out.println(productFuture.get());

    }
}
