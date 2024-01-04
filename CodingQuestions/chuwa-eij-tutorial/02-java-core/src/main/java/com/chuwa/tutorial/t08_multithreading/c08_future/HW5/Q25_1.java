package com.chuwa.tutorial.t08_multithreading.c08_future.HW5;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class Q25_1 {
    public static void main(String[] args) {

        int a = 2;
        int b = 4;
        CompletableFuture<Integer> sumFuture = CompletableFuture.supplyAsync(()->{
            return a+b;
        });

        CompletableFuture<Integer> productFuture = CompletableFuture.supplyAsync(()->{
            return a*b;
        });

        try {
            System.out.println(sumFuture.get());
            System.out.println(productFuture.get());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }
    }
}
