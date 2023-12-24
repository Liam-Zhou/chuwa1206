1. Read.

2. When a variable is marked as `volatile`, any read or write operation on that variable is guaranteed to be seen by all threads. This means that changes made to a volatile variable by one thread are immediately visible to all other threads. In other words, it enforces a happens-before relationship between threads.

3. There are 4 ways to create threads.

   1. Extending the `Thread` class:

      ```java
      public class MyThread extends Thread{
          @override
          public void run(){
              System.out.println("hello");
          }
      }
      ```

   2. Implementing the `Runnable` interface:

      ```java
      public class MyThread implements Runnable{
          @override
          public void run(){
              System.out.println("hello");
          }
      }
      ```

      

   3. Implementing the `Callable` interface:

      ```java
      public class MyThread implements Callable<String> {
      @Override
      public String call() throws Exception {
      	return "hello";
       	}
      }
      ```

      

   4. Thread Pool:

      ```java
      ExecutorService executor = Executors.newFixedThreadPool(3);
      executor.submit(task1);
      ```

4. `Runnable` is a simple interface for running tasks without returning values or handling checked exceptions, while `Callable` is an interface for tasks that can return values and handle checked exceptions.

5. `t.start()` starts a new thread and calls its `run()` method concurrently, while `t.run()` simply calls the `run()` method of the thread as a regular method, without creating a new thread.

6. Using the `Runnable` interface is generally better for creating threads in Java because it offers more flexibility, allowing us to separate the task logic from the threading mechanism and support multiple inheritance.

7. 
   Thread statuses in Java are:

   1. New: A thread that has been created but not started yet.
   2. Runnable: A thread that is executing or ready to execute.
   3. Blocked: A thread that is waiting for a resource, such as a lock, to become available.
   4. Waiting: A thread that is waiting indefinitely for another thread to perform a specific action.
   5. Timed Waiting: A thread that is waiting for a specific period of time.
   6. Terminated: A thread that has completed its execution or was terminated abruptly.

8. Deadlock is a situation in multi-threading where two or more threads are unable to proceed because each is waiting for the other(s) to release a resource or lock, resulting in a standstill.

9. Threads can communicate with each other through mechanisms like shared variables, locks, semaphores, and message passing to coordinate their activities and share data safely in a multi-threaded environment.

10. Class lock (static lock) is associated with the class itself and prevents multiple threads from accessing class-level synchronized methods concurrently. Object lock (instance lock) is associated with an instance of a class and prevents multiple threads from accessing instance-level synchronized methods concurrently on the same object.

11. The `join()` method in Java is used to wait for a thread to finish its execution before the current thread continues. It's used for thread synchronization, allowing one thread to wait for another thread to complete its task.

12. The `yield()` method in Java is used by a thread to voluntarily give up the CPU and allow other threads to run. It's a hint to the scheduler that the current thread is willing to yield its current time slice.

13. A ThreadPool is a managed pool of worker threads used for executing tasks concurrently. There are generally two types of ThreadPools: fixed-size and dynamic (cached) ThreadPools.

    1. Fixed-Size ThreadPool: It has a fixed number of threads that are created and kept alive throughout the lifetime of the ThreadPool.
    2. Cached ThreadPool: It can dynamically create and destroy threads based on the workload. It adjusts the number of threads according to the tasks in the queue.

    The TaskQueue in a ThreadPool is a queue where tasks are stored before being executed by worker threads. It holds tasks until a thread becomes available to execute them.

14. the `java.util.concurrent` library is commonly used to create ThreadPools. The main interface that provides the core functionality of a ThreadPool is `ExecutorService`.

15. We can submit a task to a ThreadPool in Java by using the `submit()` method provided by the `ExecutorService` interface.

16. The main advantage of using a ThreadPool is efficient management and reuse of threads, reducing the overhead of thread creation and destruction, and improving the performance and scalability of concurrent applications.

17. `shutdown()` is used to gracefully shut down an ExecutorService, allowing it to finish processing previously submitted tasks, while `shutdownNow()` attempts to forcefully stop all actively executing tasks, halts the processing of waiting tasks, and returns a list of the tasks that were waiting to be executed.

18. Atomic classes in Java are part of the `java.util.concurrent.atomic` package and provide atomic operations on variables without needing external synchronization. They ensure that operations on these variables are thread-safe and can be used in multi-threaded environments.

    There are several types of Atomic classes, including `AtomicInteger`, `AtomicLong`, `AtomicBoolean`, `AtomicReference`, and others.

    Example using `AtomicInteger`:

    ```
    javaCopy codeimport java.util.concurrent.atomic.AtomicInteger;
    
    public class AtomicExample {
        public static void main(String[] args) {
            AtomicInteger counter = new AtomicInteger(0);
    
            // Increment the counter atomically
            int newValue = counter.incrementAndGet();
            System.out.println("Incremented Value: " + newValue);
    
            // Update the counter with a specific value
            counter.set(42);
            System.out.println("Updated Value: " + counter.get());
    
            // Perform a compare-and-set operation
            boolean updated = counter.compareAndSet(42, 50);
            System.out.println("Was Updated? " + updated);
            System.out.println("Current Value: " + counter.get());
        }
    }
    ```

    Some main methods of `AtomicInteger`:

    - `incrementAndGet()`: Atomically increments the current value by 1 and returns the updated value.
    - `set(int newValue)`: Sets the value to the specified new value atomically.
    - `compareAndSet(int expect, int update)`: Atomically compares the current value with the expected value. If they match, it updates the value to the new value.

19. 
    Concurrent collections are data structures in Java that are designed to be thread-safe, allowing multiple threads to access and modify them concurrently without causing data corruption or synchronization issues. Some concurrent data structures include:

    1. ConcurrentHashMap
    2. ConcurrentLinkedQueue
    3. ConcurrentLinkedDeque
    4. CopyOnWriteArrayList
    5. CopyOnWriteArraySet

20. There are several types of locks in Java:

    1. ReentrantLock: Provides a flexible and customizable lock with support for conditions, timeouts, and interruptible lock acquisition.
    2. Synchronized Block: Used with synchronized methods or synchronized blocks to provide intrinsic locking. It's simple and built-in but less flexible.
    3. ReadWriteLock: Specifically designed for concurrent read and write operations, allowing multiple threads to read simultaneously while ensuring exclusive access for writing.
    4. StampedLock: Provides an optimistic locking mechanism with support for reading, writing, and optimistic reading.

    Advantages :

    - ReentrantLock: Offers more flexibility and control with features like timeouts and condition variables. It allows for finer-grained locking and can be more efficient in certain scenarios.
    - Synchronized Block: Simplicity and ease of use. It's built into the language and provides basic synchronization.
    - ReadWriteLock: Allows multiple readers to access data concurrently, improving read performance in read-heavy scenarios.
    - StampedLock: Optimistic locking can be very efficient in situations where contention is low, as it avoids blocking readers entirely.

    The choice of lock depends on the specific requirements of multi-threaded application. ReentrantLock is often used when need advanced features, while synchronized blocks are suitable for simple synchronization needs. ReadWriteLock and StampedLock are valuable for optimizing scenarios with a mix of read and write operations.

21. `Future` and `CompletableFuture` are classes in Java used for asynchronous programming and handling the results of asynchronous computations, and `CompletableFuture` is an enhanced version of `Future` that provides more flexibility and functionality for asynchronous operations. Some main methods of `CompletableFuture` include: `thenApply`, `thenCompose`, `thenAccept`, `thenRun`, etc.
22. Type the code by your self and try to understand it. (package com.chuwa.tutorial.t08_multithreading)
23. coding
24. coding
25. coding
    1. CompletableFutureExample
    2. 