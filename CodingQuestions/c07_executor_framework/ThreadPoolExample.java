package com.chuwa.tutorial.t08_multithreading.c07_executor_framework;

import org.junit.jupiter.api.Test;

import java.util.concurrent.*;

public class ThreadPoolExample {

    @Test
    public void fixedThreadPool(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(5);

        for (int i = 0; i < 10; i++) {
            int taskId = i + 1;
            executorService.submit(() ->
                    System.out.println("Task " + taskId + " is running on thread " + Thread.currentThread().getName()));
        }

        executorService.shutdown();
    }

    @Test
    public void cachedThreadPoolExample() {
        ExecutorService executorService = Executors.newCachedThreadPool();

        for (int i = 0; i < 10; i++) {
            int taskId = i + 1;
            executorService.submit(() ->
                    System.out.println("Task " + taskId + " is running on thread " + Thread.currentThread().getName()));
        }

        executorService.shutdown();
    }

    @Test
    public void singleThreadExecutorExample() {
        ExecutorService executorService = Executors.newSingleThreadExecutor();

        for (int i = 0; i < 10; i++) {
            int taskId = i + 1;
            executorService.submit(() ->
                    System.out.println("Task " + taskId + " is running on thread " + Thread.currentThread().getName()));
        }

        executorService.shutdown();
    }

    @Test
    public void scheduledThreadPoolExample() {
        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(5);

        executorService.scheduleAtFixedRate(() ->
                System.out.println("Task is running on thread " +
                        Thread.currentThread().getName()), 0, 2, TimeUnit.SECONDS);
    }
    
    @Test
    public void customThreadPoolExample() {
        int corePoolSize = 5;
        int maximumPoolSize = 5;
        long keepAliveTime = 0L;
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        int queueCapacity = 100;

        ThreadPoolExecutor executorService = new ThreadPoolExecutor(
                corePoolSize,
                maximumPoolSize,
                keepAliveTime,
                timeUnit,
                new ArrayBlockingQueue<>(queueCapacity)
        );

        for (int i = 0; i < 10; i++) {
            int taskId = i + 1;
            executorService.submit(() ->
                    System.out.println("Task " + taskId + " is running on thread " + Thread.currentThread().getName()));
        }

        executorService.shutdown();
    }

}
