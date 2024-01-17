> [!NOTE]
> This a markdown file for hw5

## question 2 
Explain what is volatile in java?

It indicates that a variable's value may be changed by different threads and that these changes are visible to all other threads. The volatile keyword ensures that the value of the variable is always read from and written to the main memory, not just from the thread's local cache.
(No caching + Prevents Reordering)


## question 3
How to create a new thread(Please also consider Thread Pool approach)?

1. Direct Thread Creation:
    ```java
    Thread thread = new Thread(() -> {
        // Task code
    });
    thread.start();
    ```
2. Using a Thread Pool:
    ```java
    ExecutorService executor = Executors.newFixedThreadPool(4);
    executor.submit(() -> {
        // Task code
    });
    executor.shutdown();
    ```




## question 4
Difference between Runnable and Callable?
1. Runnable:
+ Does not return a result.
+ Cannot throw checked exceptions.
+ Method signature: void run().
+ Example usage: new Thread(new Runnable()).

2. Callable:
+ Returns a result.
+ Can throw checked exceptions.
+ Method signature: V call() returns V.
+ Used with ExecutorService, returns Future<V>.




## question 5
What is the difference between t.start() and t.run()?
1. `t.start()`: Starts a new thread and calls the `run()` method in the new thread context. This is the correct way to start a new thread of execution.

2. `t.run()`: Simply calls the `run()` method in the current thread context, just like a normal method call, without starting a new thread.


## question 6
Which way of creating threads is better: Thread class or Runnable interface?
1. Thread Class:
+ Extending Thread means the class cannot extend any other class.
+ Directly controls thread behavior.

2. Runnable Interface:
+ More flexible, allows implementing Runnable and extending from another class.
+ Preferred when you only need to override the `run()` method without requiring other Thread functionalities.


## question 7
What are the thread statuses?
1. NEW: A thread that has been created but not yet started.
2. RUNNABLE: A thread executing in the JVM, either running or ready to run.
3. BLOCKED: A thread that is blocked waiting for a monitor lock.
4. WAITING: A thread waiting indefinitely for another thread to perform a particular action.
5. TIMED_WAITING: A thread waiting for a specified amount of time.
6. TERMINATED: A thread that has exited.


## question 8
What is deadlock?

two or more threads are blocked forever, each waiting for the other to release a resource. This typically happens when multiple threads need the same locks but obtain them in different orders.

## question 9
How do threads communicate each other?

Threads communicate with each other through shared objects. Methods like `wait()`, `notify()`, and `notifyAll()` within synchronized blocks or methods are used for inter-thread communication.

## question 10
What’s the difference between class lock and object lock?

1. Class Lock: Synchronized on the class object (`synchronized(MyClass.class`)) or static synchronized methods. It locks at the class level, so only one thread can execute a static synchronized method of that class at a time.
2. Object Lock: Synchronized on an instance of a class (synchronized(this) or non-static synchronized methods). It locks at the instance level, so different instances can have concurrent executing threads in synchronized methods.

## question 11
What is join() method?

`join()` is a method in the Thread class that causes the current thread to pause execution until the thread it joins with completes its execution.


## question 12
what is yield() method

`yield()` is a static method in the Thread class that causes the currently executing thread to pause and allow other threads of the same priority to execute. It's a hint to the scheduler, not a guarantee.

## question 13
What is ThreadPool? How many types of ThreadPool? What is the TaskQueue in
    ThreadPool?

A ThreadPool is a group of pre-instantiated reusable threads. Common types include Fixed Thread Pool, Cached Thread Pool, and Scheduled Thread Pool. TaskQueue is a queue that stores tasks waiting to be executed by threads in the pool.

## question 14
Which Library is used to create ThreadPool? Which Interface provide main
    functions of thread-pool?

The java.util.concurrent package is used to create ThreadPool, with ExecutorService being the main interface providing functionalities of thread-pool.


## question 15
How to submit a task to ThreadPool?

Tasks are submitted to ThreadPool using `submit(Runnable task)` or `submit(Callable<T> task)` methods of ExecutorService.
## question 16
What is the advantage of ThreadPool?

ThreadPool improves performance by reducing the overhead of thread creation and destruction, enhances resource management, and offers easier task and execution management.

## question 17
Difference between shutdown() and shutdownNow() methods of executor

1. `shutdown()`: Initiates an orderly shutdown where previously submitted tasks are executed, but no new tasks are accepted.
2. `shutdownNow()`: Attempts to stop all actively executing tasks, halts the processing of waiting tasks, and returns a list of the tasks that were awaiting execution.

## question 18
What is Atomic classes? How many types of Atomic classes? Give me some code
    example of Atomic classes and its main methods. when to use it?

Atomic classes provide lock-free, thread-safe operations on single variables. Types include AtomicInteger, AtomicLong, AtomicBoolean, etc. They are used for operations like increment, decrement, and compare-and-set.
```java
AtomicInteger atomicInt = new AtomicInteger(0);
atomicInt.incrementAndGet(); // Atomic increment
```
## question 19
What is the concurrent collections? Can you list some concurrent data structure
    (Thread-safe)

Concurrent collections are thread-safe collections that allow safe concurrent access. Examples include ConcurrentHashMap, CopyOnWriteArrayList, and BlockingQueue.

## question 20
What kind of locks do you know? What is the advantage of each lock?

1. Intrinsic Locks: Implicit locks used with synchronized blocks. Simple and easy to use.
2. ReentrantLocks: Explicit locks with advanced features like fairness, condition variables.
3. ReadWriteLocks: Allow multiple readers but only one writer, optimizing read-heavy operations.
## question 21
What is future and completableFuture? List some main methods of
    ComplertableFuture.

1. Future: Represents the result of an asynchronous computation.
2. CompletableFuture: An enhancement over Future, allows chaining multiple asynchronous operations, combining them, and handling errors.

3. Main Methods of CompletableFuture
+ thenApply, thenAccept: For processing the result.
+ exceptionally: For handling errors.
+ thenCompose: For chaining two futures sequentially.
+ thenCombine: For combining the results of two futures.
+ allOf, anyOf: For waiting for the completion of multiple futures.

## question 22

## question 23
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
            while (true) {
                lock.lock();
                try {
                    if (value > 10) {
                        break;
                    }
                    System.out.println(Thread.currentThread().getName() + ": " + value++);
                    condition.signal(); // Signal the other thread

                    if (value <= 10) {
                        condition.await(); // Wait for the other thread to signal
                    }
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        }
    }
}

```
## question 24
```java
// 1-10, 11-20, 21-22.
public class ThreeThreadsPrinter {
    private static final Object monitor = new Object();
    private static int value = 1;

    public static void main(String[] args) {
        new Thread(new FirstRunnable()).start();
        new Thread(new SecondRunnable()).start();
        new Thread(new ThirdRunnable()).start();
    }

    static class FirstRunnable implements Runnable {
        @Override
        public void run() {
            synchronized (monitor) {
                while (value <= 10) {
                    System.out.println(Thread.currentThread().getName() + ": " + value++);
                    monitor.notify();
                    try {
                        if (value >= 11) {
                            monitor.wait();
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
    static class SecondRunnable implements Runnable {
        @Override
        public void run() {
            synchronized (monitor) {
                while (value > 10 && value <= 20) {
                    System.out.println(Thread.currentThread().getName() + ": " + value++);
                    monitor.notify();
                    try {
                        if (value <= 10 || value > 20) {
                            monitor.wait();
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
    static class ThirdRunnable implements Runnable {
        @Override
        public void run() {
            synchronized (monitor) {
                while (value > 20) {
                    System.out.println(Thread.currentThread().getName() + ": " + value++);
                    monitor.notify();
                    try {
                        if (value <= 20) {
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

## question 25
```java
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CompletableFutureExample {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        int num1 = 10;
        int num2 = 5;

        CompletableFuture<Integer> sumFuture =
            CompletableFuture.supplyAsync(() -> num1 + num2);

        CompletableFuture<Integer> productFuture =
            CompletableFuture.supplyAsync(() -> num1 * num2);

        sumFuture.thenAcceptBoth(productFuture, (sum, product) -> {
            System.out.println("Sum: " + sum);
            System.out.println("Product: " + product);
        }).get(); // .get() is used to wait for completion, can be omitted if you don't want to block
    }
}
```


```java
CompletableFuture<String> api1 = CompletableFuture.supplyAsync(() -> {
    // Simulate API call
    return "API 1 result";
}).exceptionally(ex -> "Error: " + ex.getMessage());

CompletableFuture<String> api2 = CompletableFuture.supplyAsync(() -> {
    // Simulate API call
    return "API 2 result";
}).exceptionally(ex -> "Error: " + ex.getMessage());

// Merge and process the results
CompletableFuture<String> combinedResult = api1.thenCombine(api2, (result1, result2) -> {
    return result1 + ", " + result2;
});

// Get the final result
String result = combinedResult.get();
```

