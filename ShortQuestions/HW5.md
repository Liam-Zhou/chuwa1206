## 1. Read: https://www.interviewbit.com/multithreading-interview-questions/#class-level-lock-vs-object-level-lock

## 2. Explain what is volatile in java? (we also use it in Singleton)

In Java, the `volatile` keyword is used to indicate that a variable's value may be changed by multiple threads simultaneously. It essentially tells the compiler and the JVM that the variable's value may be changed by other threads, and therefore, every thread should read the variable's value directly from main memory rather than using a cached or locally stored value.

When a variable is declared as `volatile`, it ensures the following two things:

1. **Visibility:** Changes to a `volatile` variable are immediately visible to other threads. This means that when a thread modifies the value of a `volatile` variable, all other threads will see the updated value when they access the variable.
    
2. **Atomicity of Reads and Writes:** The `volatile` keyword guarantees atomicity of reads and writes for the variable. However, it does not provide atomicity for compound actions (such as incrementing a variable if the current value is a certain number).

Using the `volatile` keyword is one way to address the issue of double-checked locking in the Singleton pattern.  By declaring the Singleton instance as `volatile`, you ensure that changes to the instance are immediately visible to other threads, and it helps in avoiding potential issues related to the ordering of reads and writes. This makes the double-checked locking idiom safer in a multithreaded environment.
## 3. How to create a new thread(Please also consider Thread Pool approach)?
**Extending the `Thread` class:**

You can create a new class that extends the `Thread` class and override the `run` method to define the code that will be executed in the new thread.

```java
public class MyThread extends Thread {
    public void run() {
        // Code to be executed in the new thread
    }
}
MyThread myThread = new MyThread(); 
myThread.start();
```

**Implementing the `Runnable` interface:**

You can create a class that implements the `Runnable` interface and provide an implementation for the `run` method.
```java
public class MyRunnable implements Runnable {
    public void run() {
        // Code to be executed in the new thread
    }
}
MyRunnable myRunnable = new MyRunnable();
Thread thread = new Thread(myRunnable);
thread.start();

```

**Implementing the `Callable` interface:**

You can create a class that implements the `Callable` interface and provide an implementation for the `call` method.
```java
public class MyCallable implements Callable<String> {
    public String call() throws Exception {
        // Code to be executed in the new thread
        return "Start new thread using callable";
    }
}

```

**Using Thread Pool:**

Using a thread pool is a more efficient way to manage threads, especially in scenarios where you need to perform multiple tasks concurrently. Java provides the `ExecutorService` framework to work with thread pools.

```java
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolExample {
    public static void main(String[] args) {
        // Create a thread pool with a fixed number of threads
        int numberOfThreads = 5;
        ExecutorService executorService = Executors.newFixedThreadPool(numberOfThreads);

        // Submit tasks to the thread pool
        for (int i = 0; i < 10; i++) {
            executorService.submit(new MyRunnable());
        }

        // Shutdown the thread pool when done
        executorService.shutdown();
    }
}

```
## 4. Difference between Runnable and Callable?
`Runnable` and `Callable` are interfaces that represent tasks that can be executed concurrently. They are commonly used in the context of multithreading and parallel programming. However, there are some key differences between the two:

1. **Return value:**
    
    - The main difference lies in the return value. The `Runnable` interface's `run` method doesn't return a result. It is designed for tasks that don't produce a result or whose result is not needed.
    - On the other hand, the `Callable` interface's `call` method returns a result. This result can be obtained through a `Future` object when the task is executed.
2. **Exception handling:**

	- In the `Runnable` interface, the `run` method cannot throw checked exceptions directly. Any checked exceptions thrown within the `run` method must be caught and handled within the method.
	- The `call` method of the `Callable` interface, on the other hand, is allowed to throw checked exceptions. The calling code must explicitly handle or propagate these exceptions.
3. **Usage with Executors:**

	- Both `Runnable` and `Callable` can be submitted to an `ExecutorService` for concurrent execution.
	- The `ExecutorService` provides a `submit` method for both `Runnable` and `Callable`, but the `submit` method for `Callable` returns a `Future` object that can be used to retrieve the result of the computation.

## 5. What is the difference between t.start() and t.run()?
`t.start()` and `t.run()` are two different ways to initiate the execution of a thread, and they have distinct behaviors:
**t.start():**
    - This method is used to begin the execution of a thread by invoking its `run` method in a separate new thread.
    - The `start()` method is essential for concurrent execution. When you call `start()`, a new thread is created, and the `run` method of the `Runnable` or `Thread` is invoked in that new thread.
    - If you directly call `run` after creating a thread (`t.run()`), it will not create a new thread; instead, it will execute the `run` method in the current thread, making it a simple method call without any concurrency.

**t.run():**
	- This method is used to directly call the `run` method of the `Runnable` or `Thread` in the current thread, without creating a new thread.
	- If you use `t.run()`, it won't achieve parallelism or concurrency because it executes the `run` method in the same thread that made the call.
	- It's similar to any other method invocation and doesn't create a new execution context.

## 6. Which way of creating threads is better: Thread class or Runnable interface?

In modern Java development, the preference is often to use the `Runnable` interface or the `Callable` interface (for tasks that return values) because it allows better separation of concerns, promotes a more modular design, and facilitates code reuse.

## 7. What are the thread statuses?
1. **NEW:**
    
    - A thread that has been created but has not yet started is in the `NEW` state. The `start()` method must be invoked on the thread object to transition it to the `RUNNABLE` state.
2. **RUNNABLE:**
    
    - A thread in the `RUNNABLE` state is either executing its task or waiting to be scheduled by the operating system to run. The thread is actively running or is ready to run.
3. **BLOCKED:**
    
    - A thread is in the `BLOCKED` state when it is waiting for a monitor lock to enter a synchronized block/method. It is blocked and cannot proceed until the lock is acquired.
4. **WAITING:**
    
    - A thread in the `WAITING` state is waiting for another thread to perform a particular action. It can be in this state due to calling methods like `Object.wait()`, `Thread.join()`, or during park/unpark operations.
5. **TIMED_WAITING:**
    
    - Similar to the `WAITING` state, a thread in the `TIMED_WAITING` state is waiting for a specific amount of time. Threads enter this state by calling methods like `Thread.sleep()` or `Object.wait(timeout)`.
6. **TERMINATED:**
    
    - A thread that has completed its execution or terminated due to an uncaught exception is in the `TERMINATED` state.

## 8. What is deadlock?

A deadlock is a situation in concurrent programming where two or more threads are unable to proceed because each is waiting for the other to release a resource. In other words, a set of processes or threads are blocked indefinitely, each waiting for the other to release a resource, resulting in a standstill.

**Thread 1:**
    
    - Acquires Resource A.
    - Waits for Resource B.
**Thread 2:**
    
    - Acquires Resource B.
    - Waits for Resource A.

In this scenario, neither thread can proceed because each is holding a resource that the other needs. The threads are effectively waiting for each other to release the resource, resulting in a deadlock.


## 9. How do threads communicate each other?
**Shared Memory:**

- Threads can communicate through shared memory by accessing shared variables or objects. However, careful synchronization using mechanisms like `synchronized` keyword or `java.util.concurrent` classes is necessary to avoid data inconsistency or race conditions.

**Wait and Notify:**

- Threads can use the `wait()`, `notify()`, and `notifyAll()` methods to communicate and synchronize. These methods are part of the `Object` class and can be used within synchronized blocks.

**Blocking Queue:**

- The `BlockingQueue` interface in the `java.util.concurrent` package provides a way for threads to exchange data in a producer-consumer scenario. Threads can enqueue and dequeue elements from a shared queue.

**CountDownLatch, CyclicBarrier, Semaphore:**

- These synchronization constructs in the `java.util.concurrent` package can be used for coordination between threads.
    - `CountDownLatch`: Allows one or more threads to wait until a set of operations being performed in other threads completes.
    - `CyclicBarrier`: Allows a set of threads to wait until all threads reach a common barrier point.
    - `Semaphore`: Controls access to a shared resource through a set number of permits.
## 10. What’s the difference between class lock and object lock?

1. **Scope:**
    
    - Object lock is associated with an instance of a class, and each instance has its own lock.
    - Class lock is associated with the class itself, and all instances of the class share the same lock.
2. **Usage:**
    
    - Object lock is used when synchronizing instance methods or blocks.
    - Class lock is used when synchronizing static methods or blocks.
3. **Acquisition:**
    
    - Object lock is acquired on a specific instance using the `synchronized` keyword or `synchronized` method.
    - Class lock is acquired on the `Class` object itself, often using the `synchronized` keyword.

## 11. What is join() method?
  
The `join()` method in Java is a method provided by the `Thread` class that allows one thread to wait for the completion of another thread. When a thread invokes the `join()` method on another thread, the calling thread is blocked until the thread it joined completes its execution.

## 12. What is yield() **method**?
  
The `yield()` method in Java is a static method of the `Thread` class that is used to hint to the scheduler that the current thread is willing to yield its current time slice to other threads. In other words, it suggests to the scheduler that it is a good time for the current thread to give up its current execution and let other threads run.

The `yield()` method is a way to voluntarily relinquish the CPU, allowing other threads of the same priority to have a chance to run. It is important to note that the scheduler may or may not honor the `yield()` request, as it depends on the underlying operating system and its scheduling policies.

## 13. What is ThreadPool? How many types of ThreadPool? What is the TaskQueue in ThreadPool?

A ThreadPool, or thread pool, is a collection of threads that are created and managed to efficiently execute tasks concurrently. Instead of creating a new thread for each individual task, a thread pool reuses a limited number of threads from a pool, which helps manage and control the number of threads in the application. This can lead to better resource utilization, reduced overhead, and improved performance.

The `Executor` framework provides the `ThreadPoolExecutor` class, which is a flexible and powerful implementation of a thread pool. The `ThreadPoolExecutor` manages a pool of worker threads and a task queue to which tasks are submitted for execution.

### Types of Thread Pools:

1. **FixedThreadPool:**
    
    - In a fixed-size thread pool, the number of threads in the pool is fixed during the pool's creation. Once a thread completes its task, it is returned to the pool, and a new task is assigned to it.
2. **CachedThreadPool:**
	
	- In a cached thread pool, the pool can dynamically adjust the number of threads based on the demand for processing. If a thread is not used for a certain period, it may be terminated and removed from the pool.
3. **SingleThreadExecutor:**
	
	- In a single-threaded pool, there is only one worker thread. It ensures that all tasks are executed sequentially in the order they are submitted.
4. **ScheduledThreadPool:**
	
	- A scheduled thread pool is similar to a fixed-size thread pool but also allows scheduling tasks to be executed periodically or with a delay.

### Task Queue in ThreadPool:

The task queue in a `ThreadPoolExecutor` is responsible for holding tasks that are submitted to the thread pool but are not yet executed. There are two types of task queues:

1. **Unbounded Queue (`LinkedBlockingQueue`):**
    
    - This queue has no upper limit on the number of tasks that can be held. New tasks are always accepted, which can potentially lead to increased memory usage if the rate of task submission exceeds the rate of task execution.
2. **Bounded Queue (`ArrayBlockingQueue`):**

	- This queue has a fixed capacity, and once it is full, additional tasks are rejected or handled according to a specified policy. Bounded queues can help control the number of pending tasks and prevent excessive memory usage.
## 14. Which Library is used to create ThreadPool? Which Interface provide main functions of thread-pool?

The `java.util.concurrent` package providesne cessary classes and interfaces to create and manage thread pools, like the ThreadPoolExecutor class and the ExecutorService interface. The main interface that defines the essential functions of a thread pool is the `ExecutorService` interface.
## 15. How to submit a task to ThreadPool?
  
You can submit a task to a ThreadPool using the `submit()` method provided by the `ExecutorService` interface. The `submit()` method allows you to submit both `Runnable` and `Callable` tasks for execution. Here's how you can submit tasks to a ThreadPool:

## 16. What is the advantage of ThreadPool?

Thread pools save resources by reusing threads instead of creating new ones for each task. Creating and destroying threads is expensive, so thread pools reduce this overhead.

Thread pools save resources by reusing threads instead of creating new ones for each task. Creating and destroying threads is expensive, so thread pools reduce this overhead.
## 17. Difference between shutdown() and shutdownNow() methods of executor？

 `shutdown()`:
- The `shutdown()` method initiates an orderly shutdown of the executor service.
- It allows previously submitted tasks to complete their execution.
- It prevents the executor service from accepting new tasks for processing.
- After calling `shutdown()`, the executor service will not be able to restart or accept new tasks.
	Advantages:
	
	- Provides a graceful way to shut down the executor service, allowing existing tasks to complete.
	- Allows for a more controlled termination process.


 `shutdownNow()`:
 - The `shutdownNow()` method attempts to stop all actively executing tasks.
- It prevents the executor service from accepting new tasks for processing.
- Unlike `shutdown()`, it does not wait for previously submitted tasks to complete; instead, it interrupts ongoing tasks.
- Returns a list of tasks that were waiting to be executed.
	Advantages:
	
	- Can be more aggressive in stopping tasks, but at the cost of potential task interruption.
	- Provides information about tasks that were waiting to be executed.
## 18. What is Atomic classes? How many types of Atomic classes? Give me some code example of Atomic classes and its main methods. when to use it?

Atomic classes in Java are part of the `java.util.concurrent.atomic` package and provide atomic operations on single variables without the need for explicit synchronization. They are designed to be thread-safe and ensure that certain operations on variables are performed atomically, meaning they are executed as a single, indivisible unit.

Types of Atomic Classes:

1. **AtomicBoolean:**
    
    - Provides atomic operations for boolean values.
2. **AtomicInteger:**
    
    - Provides atomic operations for `int` values.
3. **AtomicLong:**
    
    - Provides atomic operations for `long` values.
4. **AtomicReference<\V>:**
    
    - Provides atomic operations for reference variables of type `V`.

Example:
```Java
import java.util.concurrent.atomic.AtomicInteger;

public class AtomicIntegerExample {
    public static void main(String[] args) {
        AtomicInteger atomicInt = new AtomicInteger(0);

        // Atomic increment
        int result = atomicInt.incrementAndGet();
        System.out.println("Incremented value: " + result);

        // Atomic decrement
        result = atomicInt.decrementAndGet();
        System.out.println("Decremented value: " + result);

        // Atomic add
        atomicInt.addAndGet(5);
        System.out.println("After adding 5: " + atomicInt.get());

        // Atomic compare and set
        boolean updated = atomicInt.compareAndSet(6, 10);
        System.out.println("Value updated? " + updated);
        System.out.println("Current value: " + atomicInt.get());
    }
}

```

When to Use Atomic Classes:

Use atomic classes when you have shared variables that are subject to concurrent updates by multiple threads, and you want to ensure atomicity without using explicit locks. Atomic classes are particularly useful in scenarios where simple read-modify-write operations need to be performed without the risk of data inconsistency due to thread interference.

Common use cases include counters, accumulators, and flags where simple operations like incrementing, decrementing, or updating values need to be performed atomically. Atomic classes are more efficient than using locks for simple operations and can improve the performance of concurrent programs.

Keep in mind that while atomic classes are useful in certain scenarios, they may not replace the need for locks in more complex situations where multiple operations need to be performed as a single atomic unit.

## 19. What is the concurrent collections? Can you list some concurrent data structure (Thread-safe)

Concurrent collections in Java are part of the `java.util.concurrent` package and provide thread-safe alternatives to the standard Java collections in the `java.util` package. These concurrent data structures are designed to be used in multithreaded environments, where multiple threads may access and modify data concurrently. Using concurrent collections helps avoid issues like race conditions, data inconsistencies, and the need for explicit synchronization.

Here are some commonly used concurrent data structures:
ConcurrentHashMap, CopyOnWriteArrayList, CopyOnWriteArraySet, LinkedBlockingQueue, ArrayBlockingQueue, PriorityBlockingQueue, ConcurrentLinkedQueue, ConcurrentSkipListMap and ConcurrentSkipListSet.

## 20. What kind of locks do you know? What is the advantage of each lock?

**ReentrantLock:**

- **Advantage:**
    - Supports the concept of reentrant synchronization, allowing a thread to lock the same lock multiple times without deadlocking itself.
    - Provides more flexibility than `synchronized` blocks, such as interruptible locks, fair locks, and the ability to specify a timeout for acquiring a lock.

**ReadWriteLock (ReentrantReadWriteLock):**

- **Advantage:**
    - Allows multiple threads to read simultaneously, improving performance in scenarios where reads are more frequent than writes.
    - Supports the concept of upgrading a read lock to a write lock.

**StampedLock:**

- **Advantage:**
    - Extends the concept of a read-write lock with a more flexible API, including optimistic locking and converting between lock modes.
    - Optimized for scenarios with high contention on read operations.

**Semaphore:**

- **Advantage:**
    - Provides a more general-purpose synchronization mechanism, allowing a fixed number of threads to access a resource concurrently.
    - Useful for scenarios where you want to control the number of simultaneous accesses to a shared resource.


## 21. What is future and completableFuture? List some main methods of ComplertableFuture.

Future:

A `Future` represents the result of an asynchronous computation. It has methods to check if the computation is done, wait for its completion, and retrieve the result.

CompletableFuture:

A `CompletableFuture` is an extension of `Future` that provides a more powerful and flexible way to handle asynchronous computations. It allows you to chain multiple asynchronous operations, combine their results, and handle errors more easily.

Main Methods of CompletableFuture:

1. **`supplyAsync(Supplier<U> supplier)`:**
    
    - Asynchronously executes the given supplier and returns a CompletableFuture representing the result.
2. **`thenApplyAsync(Function<T, U> fn)`:**
    
    - Asynchronously applies the given function to the result of this CompletableFuture, producing a new CompletableFuture.
3. **`thenCombineAsync(CompletionStage<U> other, BiFunction<T, U, V> fn)`:**
    
    - Combines the results of two CompletableFutures using the provided function when both complete.
4. **`exceptionally(Function<Throwable, T> fn)`:**
    
    - Applies the given function if this CompletableFuture completes exceptionally, returning a new CompletableFuture.
5. **`handleAsync(BiFunction<T, Throwable, U> fn)`:**
    
    - Combines the result and exception from this CompletableFuture using the provided function.
6. **`thenAcceptAsync(Consumer<T> action)`:**
    
    - Asynchronously performs the given action on the result of this CompletableFuture.
7. **`allOf(CompletableFuture<?>... cfs)`:**
    
    - Returns a new CompletableFuture that is completed when all of the given CompletableFutures complete.
8. **`anyOf(CompletableFuture<?>... cfs)`:**
    
    - Returns a new CompletableFuture that is completed when any of the given CompletableFutures complete.
## 22. Type the code by your self and try to understand it. (package com.chuwa.tutorial.t08_multithreading)

## 23. Write a code to create 2 threads, one thread print 1,3,5,7,9, another thread print 2,4,6,8,10.

```java
public class OddEventPrinter {
    private static final Object monitor = new Object();
    private static int value = 1;

    public static void main(String[] args) {
        PrintRunnable runnable = new PrintRunnable();
        new Thread(runnable).start();
        new Thread(runnable).start();
    }

    static class PrintRunnable implements Runnable {
        @Override
        public void run() {
            synchronized (monitor) {
                while (value <= 10) {
                    System.out.println(Thread.currentThread().getName() + ": " + value++);
                    monitor.notify();
                    try {
                        if (value < 11) {
                            monitor.wait();
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
```

## 24. create 3 threads, one thread ouput 1-10, one thread output 11-20, one thread output 21-22. threads run sequence is random.

```java
public class PrintNumber1 {
    private static int n = 1;

    public static void main(String[] args) {
        Thread t1 = new Thread(() -> printNumber());
        Thread t2 = new Thread(() -> printNumber());
        Thread t3 = new Thread(() -> printNumber());

        t1.start();
        t2.start();
        t3.start();
    }

    private static synchronized void printNumber() {
        int count = 10;
        while (count-- > 0) {
            System.out.println(Thread.currentThread().getName() + ": " + n++);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        PrintNumber1.class.notifyAll();
    }
}
```

## 25. completable future:

### a. Homework 1: Write a simple program that uses CompletableFuture to asynchronously get the sum and product of two integers, and print the results
```java
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CompletableFutureExample {
    public static void main(String[] args) {
        int a = 5;
        int b = 10;

        // Asynchronously calculate the sum
        CompletableFuture<Integer> sumFuture = CompletableFuture.supplyAsync(() -> {
            System.out.println("Calculating the sum asynchronously...");
            return a + b;
        });

        // Asynchronously calculate the product
        CompletableFuture<Integer> productFuture = CompletableFuture.supplyAsync(() -> {
            System.out.println("Calculating the product asynchronously...");
            return a * b;
        });

        // Combine the results when both futures complete
        CompletableFuture<Void> combinedFuture = sumFuture.thenAcceptBothAsync(productFuture,
                (sum, product) -> {
                    System.out.println("Sum: " + sum);
                    System.out.println("Product: " + product);
                });

        try {
            // Wait for both calculations to complete
            combinedFuture.get();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }
}

```

### b. Homework 2: Assume there is an online store that needs to fetch data from three APIs: products, reviews, and inventory. Use CompletableFuture to implement this scenario and merge the fetched data for further processing.
```java
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class OnlineStoreExample {
    public static void main(String[] args) {
        // Simulating product, review, and inventory APIs
        CompletableFuture<String> productsApi = fetchDataAsync("Products API");
        CompletableFuture<String> reviewsApi = fetchDataAsync("Reviews API");
        CompletableFuture<String> inventoryApi = fetchDataAsync("Inventory API");

        // Combining results when all APIs complete
        CompletableFuture<Void> combinedFuture = CompletableFuture.allOf(productsApi, reviewsApi, inventoryApi);

        // Further processing after combining results
        combinedFuture.thenRun(() -> {
            try {
                String productsData = productsApi.get();
                String reviewsData = reviewsApi.get();
                String inventoryData = inventoryApi.get();

                // Merge and process the data (simulated merging)
                String mergedData = mergeData(productsData, reviewsData, inventoryData);

                System.out.println("Merged Data: " + mergedData);
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        });

        // Wait for all APIs to complete
        try {
            combinedFuture.get();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }

    // Simulated method to fetch data asynchronously from an API
    private static CompletableFuture<String> fetchDataAsync(String apiName) {
        return CompletableFuture.supplyAsync(() -> {
            // Simulate fetching data from the API
            System.out.println("Fetching data from " + apiName);
            return apiName + " Data";
        });
    }

    // Simulated method to merge data
    private static String mergeData(String productsData, String reviewsData, String inventoryData) {
        // Simulate merging data
        return "Merged: " + productsData + " | " + reviewsData + " | " + inventoryData;
    }
}

```

### c. Homework 3: For Homework 2, implement exception handling. If an exception occurs during any API call, return a default value and log the exception information.

```java
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class OnlineStoreExampleWithExceptionHandling {
    private static final Logger LOGGER = Logger.getLogger(OnlineStoreExampleWithExceptionHandling.class.getName());

    public static void main(String[] args) {
        // Simulating product, review, and inventory APIs
        CompletableFuture<String> productsApi = fetchDataAsync("Products API");
        CompletableFuture<String> reviewsApi = fetchDataAsync("Reviews API");
        CompletableFuture<String> inventoryApi = fetchDataAsync("Inventory API");

        // Combining results when all APIs complete
        CompletableFuture<Void> combinedFuture = CompletableFuture.allOf(productsApi, reviewsApi, inventoryApi);

        // Handling exceptions and further processing after combining results
        combinedFuture.thenRun(() -> {
            try {
                String productsData = productsApi.exceptionally(e -> handleException("Products API", e)).get();
                String reviewsData = reviewsApi.exceptionally(e -> handleException("Reviews API", e)).get();
                String inventoryData = inventoryApi.exceptionally(e -> handleException("Inventory API", e)).get();

                // Merge and process the data (simulated merging)
                String mergedData = mergeData(productsData, reviewsData, inventoryData);

                System.out.println("Merged Data: " + mergedData);
            } catch (InterruptedException | ExecutionException e) {
                LOGGER.log(Level.SEVERE, "Error in further processing: " + e.getMessage(), e);
            }
        });

        // Wait for all APIs to complete
        try {
            combinedFuture.get();
        } catch (InterruptedException | ExecutionException e) {
            LOGGER.log(Level.SEVERE, "Error waiting for all APIs to complete: " + e.getMessage(), e);
        }
    }

    // Simulated method to fetch data asynchronously from an API
    private static CompletableFuture<String> fetchDataAsync(String apiName) {
        return CompletableFuture.supplyAsync(() -> {
            // Simulate fetching data from the API
            System.out.println("Fetching data from " + apiName);
            // Simulate an exception for demonstration purposes
            if ("Reviews API".equals(apiName)) {
                throw new RuntimeException("Simulated exception in " + apiName);
            }
            return apiName + " Data";
        });
    }

    // Simulated method to handle exceptions and return a default value
    private static String handleException(String apiName, Throwable exception) {
        LOGGER.log(Level.SEVERE, "Error in " + apiName + ": " + exception.getMessage(), exception);
        return "Default " + apiName + " Data";
    }

    // Simulated method to merge data
    private static String mergeData(String productsData, String reviewsData, String inventoryData) {
        // Simulate merging data
        return "Merged: " + productsData + " | " + reviewsData + " | " + inventoryData;
    }
}

```