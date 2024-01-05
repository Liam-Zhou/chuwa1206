package multithreading.Future.Other;

import org.junit.Test;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import static org.junit.Assert.assertTrue;

public class CompletableFutureApiLearn {

    /**
     * Using CompletableFuture as a Simple Future.
     */
    @Test
    public void demo01() {
        CompletableFuture<String> completableFuture = new CompletableFuture();

        ExecutorService executorService = Executors.newCachedThreadPool();

        executorService.submit(() -> {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            // 执行完毕后，通过completableFuture.complete("Hello")
            // 将CompletableFuture标记为已完成，并设置结果为字符串"Hello"。
            completableFuture.complete("Hello");
        });

        try {
            // `completableFuture.get()`会等待`CompletableFuture`完成，并返回异步任务的结果。
            // 在这里，它会打印出异步任务的结果，即字符串"Hello"。
            System.out.println(completableFuture.get());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Using Static methods runAsync and supplyAsync to create a CompletableFuture
     * instance out of Runnable and Supplier functional types correspondingly.
     *
     * CompletableFuture.supplyAsync 有返回值 - CompletableFuture<String>
     * CompletableFuture.runAsync（）没返回值 - CompletableFuture<Void>。参数是runnable 对象。
     */
    @Test
    public void demo02() {

        /**
         * CompletableFuture.supplyAsync() 方法返回一个 CompletableFuture<U> 对象，其中的 U 类型是 Supplier 对象的返回类型；
         * 而 CompletableFuture.runAsync() 方法返回一个 CompletableFuture<Void> 对象，表示异步任务没有返回值。
         *
         * 主线程： 主线程是执行 main 方法的线程。主线程启动了两个异步任务，然后进行一些输出和等待操作。在等待的过程中，主线程并未被阻塞，可以执行其他任务。
         *
         * 第一个异步线程： 由 CompletableFuture.supplyAsync(() -> {...}) 创建。这个线程负责执行 cf1 异步任务。在这个线程中，Lambda 表达式内的代码输出 "Hello1"，并通过 return "Hello1" 返回了一个字符串。
         *
         * 第二个异步线程： 由 CompletableFuture.runAsync(() -> {...}) 创建。这个线程负责执行 cf2 异步任务。在这个线程中，Lambda 表达式内的代码输出 "Hello2"。由于 runAsync 表示异步任务没有返回值，cf2 的类型是 CompletableFuture<Void>。
         *
         * 主线程通过 cf2.isDone() 两次打印 cf2 异步任务的执行状态，然后通过 Thread.sleep(1000) 等待一秒，接着再次打印 cf2 的执行状态。这是为了演示异步任务可能在主线程等待的过程中完成。
         *
         * 最后，主线程通过 cf1.get() 获取 cf1 异步任务的结果。这是一个阻塞操作，如果异步任务尚未完成，主线程会等待直到任务完成。
         *
         * 所以，总共有三个线程在执行不同的任务，而且由于异步任务的性质，它们可能并行执行。
         */
        CompletableFuture<String> cf1 = CompletableFuture.supplyAsync(() -> {
            System.out.println(Thread.currentThread() + ": Hello1");
            return "Hello1";
        });
        CompletableFuture<Void> cf2 = CompletableFuture.runAsync(() ->
                System.out.println(Thread.currentThread() + ": Hello2"));

        try {
            System.out.println(cf2.isDone());
            Thread.sleep(1000);
            System.out.println(cf2.isDone());
            System.out.println(cf1.get());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Using thenApply Method process the result, and returns a Future that holds a
     * value returned by a function:
     */
    @Test
    public void demo03() {
        CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(() -> "Hello");
        CompletableFuture<String> future = completableFuture
                .thenApply(s -> s + " World");

        try {
            System.out.println(future.get());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * The thenAccept method receives a Consumer(no return) and passes it the result of the computation
     */
    @Test
    public void demo04() {
        CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(() -> "Hello");

        CompletableFuture<Void> future = completableFuture
                .thenAccept(s -> System.out.println("Computation returned: " + s));

        try {
            future.get();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * If we neither need the value of the computation, nor want to return some value at the
     * end of the chain, then we can pass a Runnable lambda to the thenRun method
     */
    @Test
    public void demo05() {
        CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(() -> "Hello");

        CompletableFuture<Void> future = completableFuture
                .thenRun(() -> System.out.println("Computation finished."));

        try {
            future.get();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Using the thenCompose method to chain two Futures sequentially.
     * The thenApply and the thenCompose methods closely relate to the map and flatMap methods of Stream
     */
    @Test
    public void demo06() {
        CompletableFuture<String> future1
                = CompletableFuture.supplyAsync(() -> "Hello")
                .thenCompose(s -> CompletableFuture.supplyAsync(() -> s + " World"));

        CompletableFuture<CompletableFuture<String>> future2 = CompletableFuture.supplyAsync(() -> "Hello")
                .thenApply(s -> CompletableFuture.supplyAsync(() -> s + " World"));

        try {
            System.out.println(future1.get());

            System.out.println(future2.get());
            System.out.println(future2.get().get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }

    /**
     * Using the thenCombine method to execute two independent Futures and do something
     * with their results and return the final result
     */
    // 启动两个任务，最后都完成了才有的值
    @Test
    public void demo07() {
        CompletableFuture<String> completableFuture
                = CompletableFuture.supplyAsync(() -> {
                    System.out.println("1");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    System.out.println("2");
                    return "Hello";
                })
                .thenCombine(CompletableFuture.supplyAsync(() -> {
                    System.out.println("3");
                    return " World";
                }), (s1, s2) -> s1 + s2);

        try {
            System.out.println(completableFuture.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }

    /**
     * Using the thenAcceptBoth to execute two independent Futures and do something
     * with their results, but don't pass any result
     */
    @Test
    public void demo08() {
        CompletableFuture future = CompletableFuture.supplyAsync(() -> "Hello")
                .thenAcceptBoth(CompletableFuture.supplyAsync(() -> " World"),
                        (s1, s2) -> System.out.println(s1 + s2));
    }

    /**
     * CompletableFuture.allOf static method allows waiting for completion of all the Futures
     */
    @Test
    public void demo09() {
        CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() -> "Hello");
        CompletableFuture<String> future2 = CompletableFuture.supplyAsync(() -> "Beautiful");
        CompletableFuture<String> future3 = CompletableFuture.supplyAsync(() -> "World");

        CompletableFuture<Void> combinedFuture = CompletableFuture.allOf(future1, future2, future3);

        try {
            // 等待所有给定的 CompletableFuture 完成
            combinedFuture.get();
            System.out.println(combinedFuture.isDone());

            assertTrue(future1.isDone());
            assertTrue(future2.isDone());
            assertTrue(future3.isDone());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }

    /**
     * The CompletableFuture.join() method is similar to the get method, but it throws an unchecked
     * exception. This makes it possible to use it as a method reference in the Stream.map()
     */
    @Test
    public void demo10() {
        CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() -> "Hello");
        CompletableFuture<String> future2 = CompletableFuture.supplyAsync(() -> "Beautiful");
        CompletableFuture<String> future3 = CompletableFuture.supplyAsync(() -> "World");

        CompletableFuture<Void> combinedFuture = CompletableFuture.allOf(future1, future2, future3);

        try {
            String combined = Stream.of(future1, future2, future3)
                    .map(CompletableFuture::join)
                    .collect(Collectors.joining(" "));

            System.out.println(combined);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Handling Errors
     */
    @Test
    public void demo11() {
        CompletableFuture<Integer> completableFuture = CompletableFuture.supplyAsync(() -> {
            System.out.println("111");
            return 2;
        }).handle((f, e) -> {
            int i = 10 / 0;
            System.out.println("222");
            return f + 2;
        }).handle((f, e) -> {
            System.out.println("333");
            return f + 3;
        }).whenComplete((v, e) -> {
            System.out.println("complete");
            // 如果没有异常输出结果
            if (e == null) {
                System.out.println("calculate result： " + v);
            }
        }).exceptionally(e -> {
            // 用于处理异常的情况
            e.printStackTrace();
            System.out.println(e.getMessage());
            return null;
        });

        try {
            System.out.println(completableFuture.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }
}
