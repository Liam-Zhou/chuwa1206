1. Read: https://www.interviewbit.com/multithreading-interview-questions/#class
-level-lock-vs-object-level-lock
Done

2.Explain what is volatile in java? (we also use it in Singleton)
In Java, the volatile keyword is used to indicate that a variable's value may be changed by multiple threads and that changes made by one thread should be immediately visible to other threads. It is often used in Singleton patterns to ensure a single, globally accessible instance.

3.How to create a new thread(Please also consider Thread Pool approach)?
Extending the Thread class:
class MyThread extends Thread {
    public void run() {
   
    }
}

MyThread thread = new MyThread();
thread.start();

Implementing the Runnable interface:
class MyRunnable implements Runnable {
    public void run() {
           }
}

MyRunnable myRunnable = new MyRunnable();
Thread thread = new Thread(myRunnable);
thread.start();

4.Difference between Runnable and Callable?
Runnable is used for tasks that don't return a result or handle checked exceptions, while Callable is used for tasks that return a result and can handle checked exceptions.

5.What is the difference between t.start() and t.run()?
t.start() starts a new thread and executes the run() method in that thread, while t.run() simply calls the run() method on the current thread without starting a new one.

6.Which way of creating threads is better: Thread class or Runnable interface?
Using the Runnable interface is generally preferred for creating threads because it allows for better code separation and flexibility in Java.

7. What are the thread statuses?
Thread statuses in Java include NEW, RUNNABLE, BLOCKED, WAITING, TIMED_WAITING, and TERMINATED.

8. What is deadlock?
Deadlock: Deadlock is a situation in which two or more threads are unable to proceed because each is waiting for the other to release a resource.

9. How do threads communicate each other?
Threads communicate with each other through shared data structures, synchronization mechanisms (e.g., locks, semaphores), and inter-thread communication methods like wait/notify or higher-level abstractions like BlockingQueue.

10. What’s the difference between class lock and object lock?
Class lock (static lock) applies to the entire class and prevents multiple threads from executing static synchronized methods simultaneously. Object lock (instance lock) applies to a specific instance of an object and prevents multiple threads from accessing synchronized instance methods of that object simultaneously.

11. What is join() method?
join() method is used to make a thread wait for another thread to complete its execution. It blocks the calling thread until the thread it's joining with finishes.

12. what is yield() method？
yield() method is used to hint to the scheduler that the current thread is willing to yield its current time slice, allowing other threads to run. It's a way to voluntarily give up CPU time.

13. What is ThreadPool? How many types of ThreadPool? What is the TaskQueue in ThreadPool?
ThreadPool is a pool of pre-initialized threads that can be used to execute tasks concurrently. There are different types of thread pools like fixed-size, cached, and scheduled thread pools. TaskQueue in a ThreadPool is a queue that holds tasks waiting to be executed by threads in the pool.

14. Which Library is used to create ThreadPool? Which Interface provide main 
functions of thread-pool?
The java.util.concurrent library is commonly used to create thread pools. The Executor and ExecutorService interfaces provide the main functions of a thread pool in Java.

15. How to submit a task to ThreadPool?
To submit a task to a ThreadPool, we can use the execute() method of an Executor or the submit() method of an ExecutorService. 

16. What is the advantage of ThreadPool?
The advantage of using a ThreadPool includes efficient thread management, reuse of threads, and better control over thread execution. It helps in avoiding the overhead of thread creation and provides a way to manage and limit the number of concurrent threads.

17.  Difference between shutdown() and shutdownNow() methods of executor
shutdown() gracefully shuts down the ThreadPool, allowing previously submitted tasks to complete but not accepting any new tasks. shutdownNow() attempts to stop all actively executing tasks, halts the processing of waiting tasks, and returns a list of the tasks that were waiting to be executed.

18. What is Atomic classes? How many types of Atomic classes? Give me some code 
example of Atomic classes and its main methods. when to use it?
tomic classes in Java provide atomic operations on variables without the need for explicit synchronization. Some types of Atomic classes include AtomicInteger, AtomicLong, AtomicBoolean
Example code for AtomicInteger:

import java.util.concurrent.atomic.AtomicInteger;

AtomicInteger atomicInt = new AtomicInteger(0);
int result = atomicInt.incrementAndGet();

Use atomic classes when we need to perform operations on shared variables in a thread-safe manner without using explicit synchronization.

19. What is the concurrent collections? Can you list some concurrent data structure 
(Thread-safe)
Concurrent collections in Java are thread-safe data structures designed for concurrent access. Some examples include ConcurrentHashMap, ConcurrentLinkedQueue, and CopyOnWriteArrayList.

20. What kind of locks do you know? What is the advantage of each lock?
synchronized keyword (intrinsic lock)
ReentrantLock
ReadLock and WriteLock (for ReentrantReadWriteLock)
StampedLock
Each lock type has advantages like simplicity (synchronized), fine-grained control (ReentrantLock), and optimized read/write operations (ReentrantReadWriteLock).

21. What is future and completableFuture? List some main methods of ComplertableFuture.
Future is a placeholder for a result that will be available in the future. CompletableFuture is a more advanced version of Future that allows you to perform asynchronous operations and handle their results. Main methods of CompletableFuture include thenApply(), thenCombine(), thenCompose(), and exceptionally().

22. Type the code by your self and try to understand it. (package com.chuwa.tutorial.t08_multithreading) 
Done under CodingQuestions file

23.Write a code to create 2 threads, one thread print 1,3,5,7,9, another thread print 2,4,6,8,10. (solution is in com.chuwa.tutorial.t08_multithreading.c05_waitNotify.OddEventPrinter)

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


import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class OddEvenPrinterWithLock {

    private static final ReentrantLock lock = new ReentrantLock();
    private static final Condition condition = lock.newCondition();
    private static int currentValue = 1;

    public static void main(String[] args) {

        Thread oddThread = new Thread(() -> {
            while (currentValue < 10) {
                lock.lock();
                try {
                    while (currentValue % 2 == 0) {
                        condition.await();
                    }
                    System.out.println(Thread.currentThread().getName() + ": " + currentValue);
                    currentValue++;
                    condition.signal();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                } finally {
                    lock.unlock();
                }
            }
        }, "Odd-Thread");

        Thread evenThread = new Thread(() -> {
            while (currentValue <= 10) {
                lock.lock();
                try {
                    while (currentValue % 2 != 0) {
                        condition.await();
                    }
                    System.out.println(Thread.currentThread().getName() + ": " + currentValue);
                    currentValue++;
                    condition.signal();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                } finally {
                    lock.unlock();
                }
            }
        }, "Even-Thread");

        oddThread.start();
        evenThread.start();
    }
}

24. create 3 threads, one thread ouput 1-10, one thread output 11-20, one thread output 21-22. threads run sequence is random.

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


25. completable future:
a. Homework 1: Write a simple program that uses CompletableFuture to
asynchronously get the sum and product of two integers, and print the
results

import java.util.concurrent.CompletableFuture;

public class CompletableFutureExample {
    public static void main(String[] args) {
        int number1 = 5;
        int number2 = 10;

        CompletableFuture<Integer> sumFuture =
                CompletableFuture.supplyAsync(() -> number1 + number2);

        CompletableFuture<Integer> productFuture =
                CompletableFuture.supplyAsync(() -> number1 * number2);

        sumFuture.thenAccept(sum -> System.out.println("Sum: " + sum));

        productFuture.thenAccept(product -> System.out.println("Product: " + product));

        CompletableFuture.allOf(sumFuture, productFuture).join();
    }
}

b. Homework 2: Assume there is an online store that needs to fetch data
from three APIs: products, reviews, and inventory. Use
CompletableFuture to implement this scenario and merge the fetched
data for further processing. (需要找public api去模拟，)
i. Sign In to Developer.BestBuy.com
ii. Best Buy Developer API Documentation
(bestbuyapis.github.io)
iii. 可以⽤fake api https://jsonplaceholder.typicode.com/

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class OnlineStoreExample {
    
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture<String> productsFuture = CompletableFuture.supplyAsync(() -> {
            // 模拟从产品 API 获取数据
            return "Product details from Products API";
        });

        CompletableFuture<String> reviewsFuture = CompletableFuture.supplyAsync(() -> {
            // 模拟从评论 API 获取数据
            return "Review details from Reviews API";
        });

        CompletableFuture<String> inventoryFuture = CompletableFuture.supplyAsync(() -> {
            // 模拟从库存 API 获取数据
            return "Inventory details from Inventory API";
        });

        // 使用 thenCombine() 方法来合并这些数据
        CompletableFuture<Void> combinedFuture = productsFuture
                .thenCombine(reviewsFuture, (products, reviews) -> products + ", " + reviews)
                .thenCombine(inventoryFuture, (previousData, inventory) -> previousData + ", " + inventory)
                .thenAccept(System.out::println);

        // 等待所有的数据获取并处理完毕
        combinedFuture.get();
    }
}
c. Homework 3: For Homework 2, implement exception handling. If an
exception occurs during any API call, return a default value and log the
exception information.


import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class OnlineStoreExample {

    public static void main(String[] args) {
        // 异步从三个不同的 API 端点获取数据
        CompletableFuture<String> productsFuture = fetchDataFromApi("https://jsonplaceholder.typicode.com/todos/1")
                .exceptionally(ex -> handleException(ex, "默认产品数据"));
        CompletableFuture<String> reviewsFuture = fetchDataFromApi("https://jsonplaceholder.typicode.com/todos/2")
                .exceptionally(ex -> handleException(ex, "默认评论数据"));
        CompletableFuture<String> inventoryFuture = fetchDataFromApi("https://jsonplaceholder.typicode.com/todos/3")
                .exceptionally(ex -> handleException(ex, "默认库存数据"));

        // 当所有 API 调用完成后，合并结果
        CompletableFuture<Void> combinedFuture = CompletableFuture.allOf(productsFuture, reviewsFuture, inventoryFuture)
                .thenRun(() -> {
                    // 从已完成的 futures 中检索结果
                    String productsData = productsFuture.join();
                    String reviewsData = reviewsFuture.join();
                    String inventoryData = inventoryFuture.join();

                    // 处理合并后的数据（这里简单地打印出来）
                    System.out.println("产品数据: " + productsData);
                    System.out.println("评论数据: " + reviewsData);
                    System.out.println("库存数据: " + inventoryData);
                });

        // 阻塞并等待组合的 future 完成
        combinedFuture.join();
    }

    // 模拟从 API 获取数据（替换为实际的 API 调用）
    private static CompletableFuture<String> fetchDataFromApi(String apiUrl) {
        return CompletableFuture.supplyAsync(() -> {
            // 模拟从 API 获取数据
            System.out.println("从 API 获取数据: " + apiUrl);
            if (Math.random() > 0.75) { // 引入随机失败的可能性
                throw new RuntimeException("从 " + apiUrl + " 获取数据失败");
            }
            return "来自 " + apiUrl + " 的数据"; // 替换为实际获取数据的逻辑
        });
    }

    // 处理异常，记录错误并返回默认值
    private static String handleException(Throwable throwable, String defaultData) {
        System.err.println("API 调用过程中发生错误: " + throwable.getMessage());
        return defaultData; // 发生异常时返回默认数据
    }
}
