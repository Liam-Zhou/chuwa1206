# 1

Read: https://www.interviewbit.com/multithreading-interview-questions/#class-level-lock-vs-object-level-lock

Done



# 2

Explain what is volatile in java? (we also use it in Singleton)

the `volatile` keyword is used to indicate that a variable's value may be changed by different threads. This ensures that the value of the variable is always read from the main memory, not from a thread's local cache, providing a form of synchronization. In the context of a Singleton pattern, it helps in safely creating a single instance of a class in a multi-threaded environment.



# 3

How to create a new thread(Please also consider Thread Pool approach)?

We can use Using `Runnable` Interface/Using `Callable` Interface with `FutureTask` and Using `Thread` Directly to create thread.



``` Java
public class MyRunnable implements Runnable {
    @Override
    public void run() {
        
    }
}

Thread thread = new Thread(new MyRunnable());
thread.start();

```



``` Java
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class MyCallable implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        
        return 42;
    }
}

FutureTask<Integer> futureTask = new FutureTask<>(new MyCallable());
Thread thread = new Thread(futureTask);
thread.start();


Integer result = futureTask.get(); 

```



``` Java
public class MyThread extends Thread {
    @Override
    public void run() {
        
    }
}

MyThread myThread = new MyThread();
myThread.start();

```



# 4

Difference between Runnable and Callable?



The key difference between `Runnable` and `Callable` in Java is that `Runnable` does not return a result and cannot throw checked exceptions, whereas `Callable` can return a result and is able to throw checked exceptions.





# 5

What is the difference between t.start() and t.run()?

calling `t.start()` on a thread object `t` initiates a new thread and calls the `run()` method in that new thread, providing multithreading capability. On the other hand, calling `t.run()` directly just executes the `run()` method in the current thread, without starting a new thread.



# 6

Which way of creating threads is better: Thread class or Runnable interface?

Using the `Runnable` interface is generally considered better for creating threads in Java because it allows for more flexibility by separating the task from the thread mechanism and enabling the class to extend other classes, as Java supports implementing multiple interfaces but only allows extending one class.



# 7

What are the thread statuses?

 a thread can be in one of several states: New (created but not yet started), Runnable (running or ready to run), Blocked (waiting to acquire a lock), Waiting (waiting indefinitely for another thread to perform a specific action), Timed Waiting (waiting for a specified period), and Terminated (completed its execution).



# 8

What is deadlock?



It is a situation where two or more threads or processes are blocked forever, each waiting for the other to release a resource. This happens when each thread holds a lock on a resource and waits for a lock on a resource held by another thread, creating a cycle of dependencies that prevents any of the threads from proceeding.



# 9

How do threads communicate each other?

Threads communicate with each other through shared memory or by using message passing. In shared memory, threads access common data structures or variables, while in message passing, they send and receive messages containing data.



# 10

What’s the difference between class lock and object lock?

A class lock in programming is used to lock static methods or static blocks of a class, ensuring that only one thread can access these static resources at a time. An object lock, on the other hand, is used to lock non-static methods or blocks of an object, allowing only one thread to access the instance-specific resources of that particular object at a time.



# 11

What is join() method?



The `join()` method in Java combines multiple strings into a single string, using a specified delimiter to separate each element.



# 12

what is yield() method



The `yield()` method in Java suggests that the current thread is willing to yield its current use of a processor, allowing other threads to execute. This is a way to signal that the thread is not doing something critical and can pause.



# 13

What is ThreadPool? How many types of ThreadPool? What is the TaskQueue in ThreadPool?


ChatGPT

A ThreadPool in Java is a group of pre-instantiated reusable threads used to execute tasks. There are several types, including Fixed, Cached, Single, and Scheduled ThreadPools. The TaskQueue in a ThreadPool is a queue that stores tasks waiting to be executed by the threads.



# 14

Which Library is used to create ThreadPool? Which Interface provide main functions of thread-pool?

 the `java.util.concurrent` library is used to create ThreadPool. The `ExecutorService` interface provides the main functions of a thread-pool, including managing and executing tasks.



# 15

How to submit a task to ThreadPool?



To submit a task to a ThreadPool in Java, you typically use the `ExecutorService` interface. You can submit a task either as a `Runnable` or `Callable` object using methods like `execute()`, `submit()`, or `invokeAll()`.



# 16

What is the advantage of ThreadPool?

The advantage of using a ThreadPool is that it improves performance by reducing the overhead of creating and destroying threads for each task. It also allows for efficient management of a set of threads executing various tasks, leading to better system resource utilization.



# 17

Difference between shutdown() and shutdownNow() methods of executor

`shutdown()` method of an executor gradually stops its work, not starting any new tasks but allowing current tasks to finish. `shutdownNow()`, on the other hand, tries to stop all actively executing tasks right away and doesn't start any new tasks.



# 18

What is Atomic classes? How many types of Atomic classes? Give me some code example of Atomic classes and its main methods. when to use it?



Atomic classes in Java provide a way to perform atomic operations, which are performed in a single step, on a single variable. They are used in multithreading to ensure thread safety without using synchronization. There are several types of atomic classes, including `AtomicInteger`, `AtomicLong`, `AtomicBoolean`, and `AtomicReference`.

Example of `AtomicInteger` and its main methods:

``` Java
import java.util.concurrent.atomic.AtomicInteger;

public class AtomicExample {
    public static void main(String[] args) {
        AtomicInteger atomicInt = new AtomicInteger(0);

        
        atomicInt.incrementAndGet(); 

        
        atomicInt.decrementAndGet(); 

        
        atomicInt.addAndGet(5); 

      
        System.out.println("Current Value: " + atomicInt.get());
    }
}

```



# 19

What is the concurrent collections? Can you list some concurrent data structure (Thread-safe)

Concurrent collections in Java are data structures designed to be used safely by multiple threads without the need for external synchronization. They provide better scalability when used in a multithreaded context. Here are some common concurrent collections (thread-safe):

1. **ConcurrentHashMap**: A thread-safe version of `HashMap`.
2. **ConcurrentLinkedQueue**: A thread-safe version of `Queue` implemented with a linked list.
3. **ConcurrentLinkedDeque**: A thread-safe double-ended queue.
4. **CopyOnWriteArrayList**: A thread-safe variant of `ArrayList` where all mutative operations (add, set, and so on) are implemented by making a fresh copy.
5. **CopyOnWriteArraySet**: A thread-safe variant of `Set` backed by a `CopyOnWriteArrayList`.
6. **BlockingQueue**: An interface that represents a queue which is thread-safe to put, take, and retrieve elements. Implementations include `ArrayBlockingQueue`, `LinkedBlockingQueue`, etc.
7. **DelayQueue**: A time-based scheduling queue backed by a `PriorityQueue`.
8. **LinkedTransferQueue**: A versatile implementation of a blocking queue in which producers may wait for consumers to receive elements.
9. **ConcurrentSkipListMap**: A scalable concurrent `NavigableMap` implementation.
10. **ConcurrentSkipListSet**: A scalable concurrent `NavigableSet` implementation based on a `ConcurrentSkipListMap`.

These collections improve performance in a multi-threaded environment by reducing the need for locking and allowing concurrent read/write operations.

# 20

What kind of locks do you know? What is the advantage of each lock?

1. **Synchronized Block/Method**: The most basic form of locking mechanism in Java. It's simple to use and ensures that only one thread can access the synchronized block or method at a time.
   - **Advantage**: Easy to understand and implement; built-in language feature.
2. **Reentrant Locks (java.util.concurrent.locks.ReentrantLock)**: A more flexible and sophisticated version of synchronized blocks.
   - **Advantage**: Provides advanced features like the ability to check if the lock is being held, attempt to acquire the lock without blocking, and specify fairness policy.
3. **ReadWriteLock (java.util.concurrent.locks.ReadWriteLock)**: Allows multiple threads to read a resource as long as it's not being written to, and only one thread to write to the resource.
   - **Advantage**: Increases performance in scenarios where reads are more frequent than writes.
4. **Stamped Lock (java.util.concurrent.locks.StampedLock)**: Introduced in Java 8, it's a more performant alternative to `ReadWriteLock`.
   - **Advantage**: Provides a locking mechanism that supports both read and write locks, and also a new "optimistic read lock" mode.
5. **Condition (java.util.concurrent.locks.Condition)**: Used with `ReentrantLock` to allow threads to wait for certain conditions to be met.
   - **Advantage**: More flexible and powerful than the traditional `Object.wait()` and `notify()` methods.
6. **Semaphore (java.util.concurrent.Semaphore)**: Not exactly a lock, but a counting semaphore can be used to control access to a resource.
   - **Advantage**: Useful for controlling a limited number of permits for accessing a resource.
7. **Volatility (volatile keyword)**: Although not a lock, using the `volatile` keyword ensures visibility of changes to variables across threads.
   - **Advantage**: Simpler than locking for ensuring visibility; useful for flags and state monitoring.



# 21

What is future and completableFuture? List some main methods of ComplertableFuture.

`Future` and `CompletableFuture` are constructs used for asynchronous programming in Java.

- **Future**: Represents the result of an asynchronous computation. It provides methods to check if the computation is complete, wait for its completion, and retrieve the result. However, it does not provide methods to combine these computations, handle possible errors, or process the result.
- **CompletableFuture**: An enhancement of `Future` introduced in Java 8. It implements `Future` and `CompletionStage` interfaces and provides a lot of methods for asynchronous programming. It allows you to write non-blocking code by registering callbacks, combining multiple `CompletableFuture`s, handling errors, and more.

Some main methods of `CompletableFuture` include:

1. **`runAsync(Runnable runnable)`:** Runs a task asynchronously and returns a `CompletableFuture` that is completed once the runnable finishes.
2. **`supplyAsync(Supplier<U> supplier)`:** Similar to `runAsync` but returns a result.
3. **`thenApply(Function<? super T,? extends U> fn)`:** Applies a function to the result of the `CompletableFuture` when it's complete.
4. **`thenAccept(Consumer<? super T> action)`:** Accepts the result of the `CompletableFuture` and processes it with a consumer.
5. **`thenRun(Runnable action)`:** Executes a runnable after the `CompletableFuture` completes, regardless of the result.
6. **`whenComplete(BiConsumer<? super T, ? super Throwable> action)`:** Invoked with the result or the error (if any) once the `CompletableFuture` is complete.
7. **`handle(BiFunction<? super T, Throwable, ? extends U> fn)`:** Handles the result or the error, allowing to produce a new value even in case of an error.
8. **`combine(CompletableFuture<? extends U> other, BiFunction<? super T,? super U,? extends V> fn)`:** Combines two `CompletableFuture`s using a function.
9. **`allOf(CompletableFuture<?>... cfs)`:** Returns a new `CompletableFuture` that is completed when all of the given `CompletableFutures` complete.
10. **`anyOf(CompletableFuture<?>... cfs)`:** Returns a new `CompletableFuture` that is completed when any of the given `CompletableFutures` complete.



