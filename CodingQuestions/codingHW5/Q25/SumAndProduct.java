package com.chuwa.tutorial.t08_multithreading.c08_future;

import java.util.concurrent.CompletableFuture;

public class SumAndProduct {

    public static void main(String[] args) {
        CompletableFuture<Integer> sumFuture= CompletableFuture.supplyAsync(()->10+20);
        CompletableFuture<Integer> productFuture=CompletableFuture.supplyAsync(()->10*20);

        sumFuture.thenAccept(sum -> {
            System.out.println("Sum: " + sum);
        });

        productFuture.thenAccept(product -> {
            System.out.println("Product: " + product);
        });
        

    }

}
