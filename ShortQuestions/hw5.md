### 2.  Explain what is volatile in java? (we also use it in Singleton)

>  When a variable is declared as volatile, it indicates that the variable's value may be changed by multiple threads simultaneously. This ensures that all threads see the most recent write to the variable.
>
>  The `volatile` keyword is often used in the double-checked locking idiom to ensure that the singleton instance is properly initialized and visible to all threads.

### 3. How to create a new thread(Please also consider Thread Pool approach)?

> 1. Extends Thread Class
>
>    ```java
>    public class MyThread extends Thread { @Override public void run() { System.out.println("start new thread using extends thread"); } }
>    
>    Thread t = new MyThread();
>    ```
>
> 2. Implements Runnable
>
>    ```java
>    public class MyRunnable implements Runnable{ @Override public void run() { System.out.println("Start new thread using Runnable"); } }
>    
>    Thread t2 = new Thread(new MyRunnable());
>    ```
>
> 3. Implements Callable
>
>    ```java
>    public class MyCallable implements Callable<String> { 
>      @Override public String call() throws Exception { 
>        Thread.sleep(5000); return "Start new thread using Callable"; }
>    }
>    ```
>
> 4. Thread Pool
>
>    ```java
>    ExecutorService executor = Executors.newFixedThreadPool(4);
>    executor.submit(() -> "ganhuo");
>    ```
>
>    

### 4. Difference between Runnable and Callable?

>  runnable has no return; callable has return;

### 5. What is the difference between t.start() and t.run()?

> t.start() creates a new thread and t.run() does not. t.run() will invokes the `run` method on the current thread, not on a new thread.

### 6. Which way of creating threads is better: Thread class or Runnable interface?

> Runnable. Implementing the `Runnable` interface promotes a more object-oriented design, as it allows you to separate the task to be performed from the thread of execution.

### 7. What are the thread statuses?

> NEW, RUNNABLE, BLOCKED, WAITING, TIMED_WATING, TERMINATED

### 8. What is deadlock?

> A deadlock is a situation in concurrent programming where two or more threads are unable to proceed because each is waiting for the other to release a resource. In other words, a set of processes or threads are blocked, and each process/thread is holding a resource that another process/thread needs in order to proceed.

### 9. How do threads communicate each other?

> **Shared Data:** Threads can communicate by sharing data. Shared data is accessed and modified by multiple threads, allowing them to exchange information.
>
> **Synchronization:** Synchronization mechanisms like `synchronized` blocks/methods and `Lock` interfaces help ensure that only one thread can access shared resources at a time.
>
> **Wait and Notify:**The `wait()` and `notify()` methods (and their variants) can be used for inter-thread communication.
>
> The `join()` method allows one thread to wait for the completion of another thread. 
>
> `ThreadLocal` allows each thread to have its own copy of a variable. It's a way to provide thread-local variables, which can be used for communication without sharing data explicitly.

### 10. What’s the difference between class lock and object lock?

> Object locks are associated with instances of a class, while class locks are associated with the class itself.
>
> Class locks are acquired at the class level, affecting all instances and static members of the class.
>
> Object locks are often used when you need to synchronize access to instance-specific resources.

### 11. What is join() method?

> The `join()` method causes the currently executing thread to pause and wait for the thread on which it is called to complete its execution.

### 12. what is yield() method

> It is used to suggest to the scheduler that the current thread is willing to yield its current time slice, allowing other threads of the same priority to have a chance to run. 

### 13. What is ThreadPool? How many types of ThreadPool? What is the TaskQueue in ThreadPool?

> A ThreadPool in Java is a pool of worker threads that are managed by an executor service. The purpose of a ThreadPool is to efficiently manage and reuse threads, rather than creating a new thread for each task. 

> FixedThreadPool, CachedThreadPool, SingleThreadExecutor

> The task queue in a ThreadPool is a data structure that holds the tasks (runnable or callable) submitted to the ThreadPool. 
>
> **LinkedBlockingQueue**/ **ArrayBlockingQueue**/ **PriorityBlockingQueue**

### 14. Which Library is used to create ThreadPool? Which Interface provide main functions of thread-pool?

>  the `java.util.concurrent` package provides the necessary libraries and interfaces for creating and managing thread pools. The primary interface that defines the main functions of a thread pool is the `ExecutorService` interface.

### 15. How to submit a task to ThreadPool?

```java
ExecutorService executor = Executors.newFixedThreadPool(3);
Runnable myRunnable = () -> {
		System.out.println("Executing task in thread: " + 				        Thread.currentThread().getName());
 };
executor.submit(myRunnable);
```

### 16. What is the advantage of ThreadPool?

> Resource Consumption: Fixed or configurable number of threads, sharing thread resources
>
> Performance: Thread reuse, reducing overhead of thread creation and destruction, improving performance
>
> Thread Lifecycle Management: Automatic thread lifecycle management by thread pool
>
> Task Queuing & Execution Strategy: Allows queuing of tasks waiting for execution
>
> Result Retrieval: submit(runnable) returns a Future object for result retrieval
>
> Thread/Pool Shutdown: executorService.shutdown() or shutdownNow()

### 17. Difference between shutdown() and shutdownNow() methods of executor

> After calling `shutdown()`, the executor service enters a state where it will not accept new tasks, but it will continue to execute previously submitted tasks until they complete.
>
> The `shutdownNow()` method attempts to stop all actively executing tasks, halts the processing of waiting tasks, and returns a list of the tasks that were waiting to be executed.

### 19. What is the concurrent collections? Can you list some concurrent data structure (Thread-safe)

> List -> CopyOnWriteArrayList
>
> Map -> ConcurrentHashMap
>
> Set -> CopyOnWriteArraySet
>
> Queue/Deque  -> ArrayBlockingQueue / LinkedBlockingQueue

### 20. What kind of locks do you know? What is the advantage of each lock?

> **synchronized**: Simple and easy to use. Ensures that only one thread can execute a synchronized block or method at a time, preventing concurrent access to shared resources.
>
> **ReentrantLock**: Provides more flexibility than synchronized blocks. It allows for finer control over locking and unlocking, as well as the ability to implement features like timeouts.
>
> **ReadWriteLock**: Allows multiple threads to read a shared resource concurrently, but only one thread can write to the resource at a time. 
>
> **StampedLock**:Threads can acquire an optimistic read lock without blocking other threads. 

### 21. What is future and completableFuture? List some main methods of ComplertableFuture.

> `Future` interface represent a return that will be returned in the future. It provides a way to check if the computation is complete and to retrieve the result when it is ready.  
>
> `CompletableFuture`  is an asynchronous programming tool introduced in Java 8, it Implements the Future interface, providing powerful asynchronous capabilities. Supports chaining operations for easy combination and management of multiple asynchronous tasks. Non-blocking asynchronous operations

> **Creating a CompletableFuture**
>
> CompletableFuture.supplyAsync(Supplier<U> supplier): : Executes the given task asynchronously and returns the result
>
> CompletableFuture.runAsync(Runnable runnable): Executes the given task asynchronously, without returning a value
>
> **Result Processing and Transformation**
>
> CompletableFuture.thenApply(Function<T, U> fn): Processes the return value and transforms it into another type
>
> CompletableFuture.thenAccept(Consumer<T> action): Processes the return value without returning a new CompletableFuture
>
> CompletableFuture.thenRun(Runnable action): Ignores the return value and runs a runnable
>
> **Combination and Linking**
>
> CompletableFuture.thenCompose(Function<T, CompletionStage<U>> fn): Links another CompletableFuture and passes the result to the next task.
>
> **Exception Handling**
>
> CompletableFuture.exceptionally(Function<Throwable, T> fn): Handles exceptions and returns an alternative value
>
> CompletableFuture.handle(BiFunction<T, Throwable, U> fn): Handles exceptions while allowing access to the result value (if any)
>



### 23. Write a code to create 2 threads, one thread print 1,3,5,7,9, another thread print 2,4,6,8,10. (solution is in com.chuwa.tutorial.t08_multithreading.c05_waitNotify.OddEventPrinter)

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

```java
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class OddEvenPrinter {
    private static final ReentrantLock lock = new ReentrantLock();
    private static final Condition condition = lock.newCondition();
    private static int value = 1;

    public static void main(String[] args) {
        PrintRunnable runnable = new PrintRunnable();
        new Thread(runnable, "Thread-1").start();
        new Thread(runnable, "Thread-2").start();
    }

    static class PrintRunnable implements Runnable {
        @Override
        public void run() {
            lock.lock();
            try {
                while (value <= 10) {
                    System.out.println(Thread.currentThread().getName() + ": " + value++);
                    condition.signal(); 
                    if (value <= 10) {
                        try {
                            condition.await(); 
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            } finally {
                lock.unlock();
            }
        }
    }
}
```

### 24. create 3 threads, one thread ouput 1-10, one thread output 11-20, one thread output 21-22. threads run sequence is random. (

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

### 25. completable future

```java
//Write a simple program that uses CompletableFuture to asynchronously get the sum and product of two integers, and print the results.
public class PrintNumber1 {

    public static void main(String[] args) {
        int a = 5;
        int b = 3;

        CompletableFuture<Integer> sumFuture = CompletableFuture.supplyAsync(() -> calculateSum(a, b));
        CompletableFuture<Integer> productFuture = CompletableFuture.supplyAsync(() -> calculateProduct(a, b));

        // Combine the results when both calculations are complete
        CompletableFuture<Void> combinedFuture = sumFuture.thenCombine(productFuture, (sum, product) -> {
            System.out.println("Sum: " + sum);
            System.out.println("Product: " + product);
            return null;
        });

        // Block and wait for the combined future to complete
        combinedFuture.join();
    }

    private static int calculateSum(int a, int b) {
        return a + b;
    }

    private static int calculateProduct(int a, int b) {
        return a * b;
    }
}
```

```java
import java.util.concurrent.CompletableFuture;

public class OnlineStoreExample {

    public static void main(String[] args) {
        // Fetch data from three different APIs asynchronously
        CompletableFuture<String> productsFuture = fetchDataFromApi("https://jsonplaceholder.typicode.com/todos/1");
        CompletableFuture<String> reviewsFuture = fetchDataFromApi("https://jsonplaceholder.typicode.com/todos/2");
        CompletableFuture<String> inventoryFuture = fetchDataFromApi("https://jsonplaceholder.typicode.com/todos/3");

        // Combine the results when all API calls are complete
        CompletableFuture<Void> combinedFuture = CompletableFuture.allOf(productsFuture, reviewsFuture, inventoryFuture)
                .thenRun(() -> {
                    // Retrieve results from completed futures
                    String productsData = productsFuture.join();
                    String reviewsData = reviewsFuture.join();
                    String inventoryData = inventoryFuture.join();

                    // Process the merged data (for simplicity, just printing here)
                    System.out.println("Products Data: " + productsData);
                    System.out.println("Reviews Data: " + reviewsData);
                    System.out.println("Inventory Data: " + inventoryData);
                });

        // Block and wait for the combined future to complete
        combinedFuture.join();
    }

    // Simulate fetching data from an API (replace with actual API calls)
    private static CompletableFuture<String> fetchDataFromApi(String apiUrl) {
        return CompletableFuture.supplyAsync(() -> {
            // Simulate fetching data from the API
            System.out.println("Fetching data from API: " + apiUrl);
            return "Data from " + apiUrl;
        });
    }
}

```

```java
import java.util.concurrent.CompletableFuture;
import java.util.logging.Level;
import java.util.logging.Logger;

public class OnlineStoreExampleWithExceptionHandling {

    private static final Logger LOGGER = Logger.getLogger(OnlineStoreExampleWithExceptionHandling.class.getName());

    public static void main(String[] args) {
        // Fetch data from three different APIs asynchronously
        CompletableFuture<String> productsFuture = fetchDataFromApi("https://jsonplaceholder.typicode.com/todos/1");
        CompletableFuture<String> reviewsFuture = fetchDataFromApi("https://jsonplaceholder.typicode.com/todos/2");
        CompletableFuture<String> inventoryFuture = fetchDataFromApi("https://jsonplaceholder.typicode.com/todos/invalid-url"); // Simulate an invalid URL

        // Combine the results when all API calls are complete
        CompletableFuture<Void> combinedFuture = CompletableFuture.allOf(productsFuture, reviewsFuture, inventoryFuture)
                .thenRun(() -> {
                    // Retrieve results from completed futures
                    String productsData = productsFuture.join();
                    String reviewsData = reviewsFuture.join();
                    String inventoryData = inventoryFuture.join();

                    // Process the merged data (for simplicity, just printing here)
                    System.out.println("Products Data: " + productsData);
                    System.out.println("Reviews Data: " + reviewsData);
                    System.out.println("Inventory Data: " + inventoryData);
                });

        // Block and wait for the combined future to complete
        combinedFuture.join();
    }

    // Simulate fetching data from an API (replace with actual API calls)
    private static CompletableFuture<String> fetchDataFromApi(String apiUrl) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                // Simulate fetching data from the API
                System.out.println("Fetching data from API: " + apiUrl);
                if ("https://jsonplaceholder.typicode.com/todos/invalid-url".equals(apiUrl)) {
                    // Simulate an exception for the invalid URL
                    throw new RuntimeException("Invalid URL");
                }
                return "Data from " + apiUrl;
            } catch (Exception e) {
                // Log the exception information
                LOGGER.log(Level.SEVERE, "Exception during API call", e);
                // Return a default value in case of exception
                return "Default Value";
            }
        }).exceptionally(ex -> {
            // Handle exceptions and return a default value
            LOGGER.log(Level.SEVERE, "Exception during API call", ex);
            return "Default Value";
        });
    }
}

```

