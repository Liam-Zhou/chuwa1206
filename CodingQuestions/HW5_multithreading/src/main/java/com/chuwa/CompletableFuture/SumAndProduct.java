package com.chuwa.CompletableFuture;

import java.util.concurrent.*;

public class SumAndProduct {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(5);
        double a = 5.0;
        double b = 3.1;
        CompletableFuture<Double> sum = CompletableFuture.supplyAsync(() -> {
                    {
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    ;
                    return mysum(a, b);
                }
                , executor
        ); //supplyasync cannot accept parameter in lambda expression

        CompletableFuture<Double> product = CompletableFuture.supplyAsync(() -> myproduct(a,b), executor);

        String str = null;
        try {
            str = sum.thenCombine(product, (s, p) ->  s + " " + p).get();
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }
        System.out.println(str);
        executor.shutdown(); // remember to shutdown thread pool
        //sum.thenCombine(product, (s, p) ->  s + " " + p).thenAccept(System.out::println);


    }

    private static double mysum(double a, double b){
        return a + b;
    }

    private static double myproduct(double a, double b){
        return a * b;
    }
}
