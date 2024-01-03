# HW5

## *2. Explain what is volatile in java? (we also use it in Singleton)*

In Java, the `volatile` keyword is used to indicate that a variable's value will be modified by different threads.

1. **Visibility**: The primary purpose of the `volatile` keyword is to ensure visibility. When a variable is declared as `volatile`, it ensures that any write to that variable will be immediately visible to other threads. In other words, it guarantees that the value of the volatile variable will always be read from the main memory, not from the thread's local cache.
2. **Happens-Before Guarantee**: `volatile` variables have a "happens-before" relationship. This means that all the actions (reads or writes) that happen before the write to a volatile variable are visible to the thread which reads the variable after the write.
3. **Prevents Reordering**: In Java, the compiler and processor might reorder instructions for optimization. However, with `volatile` variables, it prevents instruction reordering that would otherwise occur naturally as a part of optimization. This is critical for maintaining predictability in multithreaded environments.
4. **Limited Synchronization**: While `volatile` provides a degree of synchronization, it's important to note that it's not a complete substitute for synchronization through `synchronized` blocks or methods. `volatile` only ensures visibility and ordering, but it does not provide atomicity. For instance, operations like incrementing a volatile variable (like `volatileVar++`) are not atomic operations.

## *3. How to create a new thread(Please also consider Thread Pool approach)?*

### 1. Extending the `Thread` Class

```java
class MyThread extends Thread {
    public void run() {
    }
}

public class Main {
    public static void main(String args[]) {
        MyThread t1 = new MyThread();
        t1.start(); // starts the thread
    }
}
```

### 2. Implementing the `Runnable` Interface

```java
class MyRunnable implements Runnable {
    public void run() {

    }
}

public class Main {
    public static void main(String args[]) {
        MyRunnable runnable = new MyRunnable();
        Thread thread = new Thread(runnable);
        thread.start(); // starts the thread
    }
}
```

### 3. Using a Thread Pool (Executor Service)

```java
class MyTask implements Runnable {
    public void run() {

    }
}

public class Main {
    public static void main(String args[]) {
        ExecutorService executor = Executors.newFixedThreadPool(4); // thread pool with 4 threads

        for (int i = 0; i < 10; i++) {
            Runnable task = new MyTask();
            executor.execute(task); // adds task to the pool
        }
        
        executor.shutdown(); // shuts down the executor service
    }
}
```

## *4. Difference between Runnable and Callable?*

### 1. Return Value

- **Runnable**: The `run()` method in the `Runnable` interface does not return any value. Its method signature is `public void run()`.
- **Callable**: The `call()` method in the `Callable` interface can return a value. The return type is generic, allowing for flexibility. Its method signature is `public V call() throws Exception`, where `V` is the type of the returned value.

### 2. Exception Handling

- **Runnable**: The `run()` method in the `Runnable` interface cannot throw checked exceptions. Any exceptions that occur in the `run()` method must be handled inside the method itself.
- **Callable**: The `call()` method in the `Callable` interface can throw checked exceptions, allowing the caller to handle them directly.

## *5. What is the difference between t.start() and t.run()?*

### `t.start()`

- **Thread Creation**: When you call `t.start()` on a `Thread` object `t`, a new thread is created and the `run()` method of that thread will be executed in this new thread asynchronously. This means that the `run()` method executes independently of the thread that called `t.start()`.
- **Concurrency**: Invoking `t.start()` enables the JVM to perform thread scheduling and run the thread's `run()` method concurrently with other threads.
- **Single Execution**: You can call `t.start()` only once per thread. Trying to call `t.start()` again on the same thread after it has completed or even started will throw a `java.lang.IllegalThreadStateException`.

### `t.run()`

- **Method Invocation**: Calling `t.run()` is just like any other method call. It does not start a new thread; instead, the `run()` method runs in the current thread synchronously. This means that if you call `t.run()`, the `run()` method's code will execute in the same thread that called `t.run()` and will block until it completes.
- **No Concurrency**: Since `t.run()` does not start a new thread, it does not provide any concurrency. It's just a normal method call.
- **Multiple Invocations**: Unlike `t.start()`, you can call `t.run()` multiple times. It behaves like any other method, and each call will execute and finish before the next line of your code is executed.

## *6. Which way of creating threads is better: Thread class or Runnable interface?*

### Implementing the `Runnable` Interface

- **Flexibility**: Implementing `Runnable` is more flexible. Since it’s an interface, your class can still extend another class.
- **Separation of Task and Execution**: Implementing `Runnable` separates the task (what the thread is supposed to do) from the thread execution (how it’s done). This is in line with the principle of separation of concerns.
- **Reuse and Loose Coupling**: It allows the same `Runnable` instance to be executed by multiple threads, promoting reuse and loose coupling. You can pass the `Runnable` to different executors or thread pools, making it more versatile.
- **Scalability with Executors**: `Runnable` works seamlessly with the Executor framework, which is a powerful way to manage thread execution and pooling in larger applications.

## *7. What are the thread statuses?*

- NEW
- RUNNABLE
- BLOCKED
- WAITING
- TERMINATED

## *8. What is deadlock?*

Deadlock in multi-threading occurs when two or more threads are blocked forever, each waiting for resources held by the other. This creates a standstill where neither thread can proceed. It's typically caused by a combination of mutually exclusive resource access, hold and wait conditions, no preemption of resources, and a circular wait among the threads. 

## *9. How do threads communicate each other?*

1. **Shared Variables**: Threads running in the same process share the same memory space and can access common variables. One thread can modify a variable, and other threads can read this change, provided the variable is correctly synchronized to ensure visibility and atomicity.
2. **wait(), notify(), and notifyAll() Methods**: These methods are fundamental for inter-thread communication and are used in conjunction with synchronized blocks or methods.
   - `wait()`: Causes the current thread to release the lock it holds on the object and go into a waiting state until another thread calls `notify()` or `notifyAll()` on the same object.
   - `notify()`: Wakes up one thread that is waiting on the object’s monitor (if any are waiting).
   - `notifyAll()`: Wakes up all threads that are waiting on the object’s monitor.
3. **Volatile Variables**: A `volatile` variable can be used to ensure that changes made in one thread are immediately visible to other threads. However, `volatile` is limited to visibility and does not provide atomicity for compound actions.
4. **Concurrent Data Structures**: Java provides thread-safe collections like `BlockingQueue`, which are designed for concurrent use and can be used for inter-thread communication. For example, one thread can place data into a `BlockingQueue`, while another thread takes data from it.
5. **CountDownLatch, CyclicBarrier, and Semaphores**: These are higher-level synchronization utilities that enable threads to wait for certain conditions to be met or coordinate their actions.
6. **Exchanger**: This is a synchronization point at which threads can pair and swap elements, useful for coordinating between pairs of threads.
7. **Atomic Variables**: Classes like `AtomicInteger` and `AtomicReference` provide a way to perform atomic operations on single variables, which is useful for communicating state between threads without using `synchronized`.

## *10. What’s the difference between class lock and object lock?*

- **Object Lock**: Synchronizes access to methods and blocks within a single instance of a class. Different instances can be accessed simultaneously by different threads.
- **Class Lock**: Synchronizes access to static methods and blocks, affecting all instances of the class. Only one thread can execute a static synchronized method in the class at a time, regardless of the number of instances.

## *11. What is join() method?*

The `join()` method in Java is a mechanism that allows one thread to wait for the completion of another. When you call the `join()` method on a thread, the calling thread goes into a waiting state. It remains in this state until the referenced thread terminates or the specified waiting time elapses.

## *12. what is yield() method*

The `yield()` method in Java is a static method of the `Thread` class that suggests to the thread scheduler to pause the execution of the current thread and give other threads of the same priority a chance to execute. It's important to understand that `yield()` is only a suggestion, not a guarantee. The behavior of the `yield()` method is largely dependent on the underlying operating system and the thread scheduler.

## *13. What is ThreadPool? How many types of ThreadPool? What is the TaskQueue in ThreadPool?*

A ThreadPool in Java is a group of pre-instantiated reusable threads that are used to perform tasks. This pool of threads handles multiple tasks without the overhead of creating a new thread for each task. The use of ThreadPools improves performance in programs that execute many short-lived asynchronous tasks.

### Types of ThreadPool

1. **FixedThreadPool**: A thread pool with a fixed number of threads. If all threads are active when a new task is submitted, the task waits in a queue until a thread becomes available.
2. **CachedThreadPool**: A thread pool that creates new threads as needed, but reuses previously constructed threads when they are available. Threads that have not been used for sixty seconds are terminated and removed from the cache.
3. **SingleThreadExecutor**: A thread pool with only one thread. All submitted tasks are executed sequentially.
4. **ScheduledThreadPoolExecutor**: A thread pool that can schedule commands to run after a given delay, or to execute periodically.
5. **WorkStealingPool** (Java 8+): Based on a ForkJoinPool, it uses multiple queues (one per thread) and steals tasks from other queues (threads) when blocked, optimizing CPU usage.

### TaskQueue in ThreadPool

- **FixedThreadPool and SingleThreadExecutor**: Typically use a LinkedBlockingQueue, which holds a potentially large number of tasks in a linked-node structure. The queue can be bounded or unbounded.
- **CachedThreadPool**: Uses a SynchronousQueue, which does not store tasks but hands them off directly to threads.
- **ScheduledThreadPoolExecutor**: Uses a DelayQueue to schedule tasks.

## *14. Which Library is used to create ThreadPool? Which Interface provide main functions of thread-pool?*


To create and manage thread pools in Java, the primary library used is the `java.util.concurrent` package. This package includes a range of utilities for concurrent programming, including several classes for handling thread pools effectively.

### Key Classes and Interfaces in `java.util.concurrent` for ThreadPool:

1. **Executors**: This class contains utility methods for creating different types of thread pools, such as `newFixedThreadPool`, `newCachedThreadPool`, `newSingleThreadExecutor`, and `newScheduledThreadPool`. It acts as a factory for creating `ExecutorService` instances based on various configurations.
2. **Executor Interface**: This is the basic interface that represents an object that executes submitted `Runnable` tasks. It provides a single `execute(Runnable command)` method for launching tasks.
3. **ExecutorService Interface**: This is a more extensive interface that extends `Executor`. It provides methods for managing the lifecycle of both the tasks and the executor itself, including methods like `submit`, `shutdown`, `shutdownNow`, `invokeAll`, and `invokeAny`. The `ExecutorService` is the main interface that provides the functionality of a thread pool.
4. **ThreadPoolExecutor Class**: This class is an implementation of the `ExecutorService` interface and provides a highly customizable thread pool. It allows you to specify core and maximum pool sizes, keep-alive time for idle threads, a blocking queue for tasks, and thread factory and handler policies.
5. **ScheduledExecutorService Interface**: This is a subinterface of `ExecutorService` for delayed and periodic task execution. It is implemented by `ScheduledThreadPoolExecutor`.

## *15. How to submit a task to ThreadPool?*

### 1. Using the `execute(Runnable)` Method

```java
ExecutorService executor = Executors.newFixedThreadPool(4);
executor.execute(() -> {
    // Task code
});
```

### 2. Using the `submit(Runnable)` Method

```java
ExecutorService executor = Executors.newFixedThreadPool(4);
Future<?> future = executor.submit(() -> {
    // Task code
});
```

### 3. Using the `submit(Callable<T>)` Method

```java
ExecutorService executor = Executors.newFixedThreadPool(4);
Future<Integer> future = executor.submit(() -> {
    // Task code that returns an Integer
    return 42;
});
```

## *16. What is the advantage of ThreadPool?*

1. **Efficiency**: Reduces the overhead of creating and destroying threads for each task, leading to better performance.
2. **Resource Management**: Limits the number of active threads, preventing excessive resource consumption and system overload.
3. **Improved System Stability**: Avoids scenarios where too many threads consume all system resources, enhancing the stability of the application.
4. **Task Management**: Simplifies handling and scheduling of tasks, with capabilities for periodic and delayed execution.
5. **Scalability**: Adapts gracefully to changes in workload, improving scalability of applications.
6. **Load Balancing**: Distributes tasks among threads efficiently, balancing the workload.

## *17. Difference between shutdown() and shutdownNow() methods of executor*

- **shutdown()**: Initiates a graceful shutdown where it stops accepting new tasks but allows already submitted tasks to complete. Actively executing tasks are not interrupted.
- **shutdownNow()**: Attempts to stop all actively executing tasks, halts processing of waiting tasks, and returns a list of tasks that were awaiting execution.

## *18. What is Atomic classes? How many types of Atomic classes? Give me some code example of Atomic classes and its main methods. when to use it?*

### Types of Atomic Classes

1. **Basic Types**: `AtomicInteger`, `AtomicLong`, `AtomicBoolean`
2. **Array Types**: `AtomicIntegerArray`, `AtomicLongArray`, `AtomicReferenceArray`
3. **Reference Types**: `AtomicReference`, `AtomicStampedReference`, `AtomicMarkableReference`
4. **Updater Types**: `AtomicIntegerFieldUpdater`, `AtomicLongFieldUpdater`, `AtomicReferenceFieldUpdater`

### Code Example: AtomicInteger

```java
import java.util.concurrent.atomic.AtomicInteger;

AtomicInteger count = new AtomicInteger(0);

// Increment
count.incrementAndGet();

// Get current value
int currentValue = count.get();
```

### When to Use Atomic Classes

- In high-concurrency scenarios for simple atomic operations like increments, decrements, and updates.
- When you need performance efficiency and thread safety without the complexity of locks.
- For maintaining counters or flags that are accessed and modified by multiple threads.

## *19. What is the concurrent collections? Can you list some concurrent data structure Thread-safe)*

1. **ConcurrentHashMap**: A thread-safe and high-performance HashMap alternative.
2. **ConcurrentSkipListMap**: A scalable concurrent NavigableMap implementation.
3. **ConcurrentSkipListSet**: A Set implementation using ConcurrentSkipListMap.
4. **CopyOnWriteArrayList**: A List implementation optimized for frequent reads and infrequent writes.
5. **CopyOnWriteArraySet**: A Set implementation based on CopyOnWriteArrayList.
6. **BlockingQueue Implementations**: Such as ArrayBlockingQueue, LinkedBlockingQueue, PriorityBlockingQueue, and DelayQueue for thread-safe queuing operations.
7. **ConcurrentLinkedQueue**: A thread-safe unbounded queue.
8. **ConcurrentLinkedDeque**: A thread-safe double-ended queue.

## *20. What kind of locks do you know? What is the advantage of each lock?*

## *21. What is future and completableFuture? List some main methods of ComplertableFuture.*

## *22. Type the code by your self and try to understand it.