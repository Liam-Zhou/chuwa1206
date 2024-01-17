## HW5

# Q1

# Q2 Explain what is volatile in java? (we also use it in Singleton)
`volatile` is a keyword that can be applied only to variables. Applying `volatile` to a shared variable that is accessed in a multi-threaded environment ensures that threads will read this variable from the main memory and write this variable to main memory instead of their own local cache.


# Q3 How to create a new thread(Please also consider Thread Pool approach)?
1. Extending the `Thread` Class
```
class MyThread extends Thread {
	@Override
    public void run() {
        System.out.println("Thread is running...");
    }

    public static void main(String args[]) {
        MyThread t1 = new MyThread();
        t1.start(); // Starting the thread
    }
}
```

2. Implementing the `Runnable` Interface
```
class MyRunnable implements Runnable {
	@Override
    public void run() {
        System.out.println("Thread is running...");
    }

    public static void main(String args[]) {
        MyRunnable myRunnable = new MyRunnable();
        Thread t1 = new Thread(myRunnable);
        t1.start(); // Starting the thread
    }
}
```

3. Implementing the `Runnable` Interface
```
public class MyCallable implements Callable<String> {
    @Override
    public String call() throws Exception {
        Thread.sleep(5000);
        return "Start new thread using Callable";
    }
}
```

4. Using a Thread Pool (Fixed thread pool)
```
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolExample {
    public static void main(String[] args) {
        // Create a fixed thread pool with 4 threads
        ExecutorService executor = Executors.newFixedThreadPool(4);

        for (int i = 0; i < 10; i++) {
            Runnable worker = new WorkerThread("" + i);
            executor.execute(worker); // Submitting the task to the thread pool
        }

        executor.shutdown(); // Initiates an orderly shutdown in which previously submitted tasks are executed, but no new tasks will be accepted.

        while (!executor.isTerminated()) {
        }

        System.out.println("Finished all threads");
    }
}

class WorkerThread implements Runnable {
    private String command;

    public WorkerThread(String s) {
        this.command = s;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " Start. Command = " + command);
        processCommand();
        System.out.println(Thread.currentThread().getName() + " End.");
    }

    private void processCommand() {
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

```

# Q4 Difference between Runnable and Callable?
- **Return Type**
	- Runnable: It does not return any result. The `run()` method in the `Runnable` interface has a `void` return type.
	- Callable: It can return a result. The `call()` method in the `Callable` interface returns a value, typically wrapped in a `Future` object.
- **Exception Handling**
	- Runnable: It cannot throw checked exceptions. Any checked exceptions within the `run()` method must be handled inside the method itself.
	- Callable: It can throw checked exceptions. The `call()` method can throw an exception, which can then be handled by the code that executes the Callable.
- **Usage**
	- Runnable: It's primarily used for tasks that do not need to return a result or throw checked exceptions.
	- Callable: It's used for tasks that might return a result and might throw a checked exception. Useful in scenarios where you need to track the result of asynchronous computation.

# Q5 What is the difference between t.start() and t.run()?
- t.start(): This method starts a new thread. When you invoke `t.start()`, the Java Virtual Machine calls the `run()` method on the new thread. This new thread will execute separately from the thread that called `start()`.
- t.run(): This method simply calls the run() method of the Thread class directly, just like a normal method call. It does not start a new thread.

# Q6 Which way of creating threads is better: Thread class or Runnable interface?
In most cases, implementing the `Runnable` interface is preferred over extending the `Thread` class due to its flexibility and better design practices. It allows you to extend another class and provides a clear separation between the task and the thread control. However, if your class is solely dedicated to thread operations and does not need to extend any other class, extending the Thread class can be a simpler and more straightforward option.

# Q7 What are the thread statuses?
- **New**: The thread has been created but not yet started. It's in this state right after the instantiation of a Thread object but before the invocation of the `start()` method.
- **Runnable**: The thread is ready to run and may be running whenever it gets CPU time. A thread in this state is considered to be executing its task. This state includes both "ready-to-run" and "running" states, but the JVM doesn't distinguish between them in its thread state reporting.
- **Blocked**: A thread is in the blocked state when it's waiting to acquire a monitor lock to enter or re-enter a synchronized block/method. The thread remains in this state until it acquires the lock.
- **Waiting**: A thread is in this state when it waits indefinitely for another thread to perform a specific action. Methods causing this state include `Object.wait()`, `Thread.join()` without a timeout, or `LockSupport.park()`.
- **Timed Waiting**: Similar to the waiting state, but with a specified waiting time. A thread is in this state when it waits for another thread to perform an action for up to a specified waiting time. This state is caused by methods like `Thread.sleep(long millis)`, `Object.wait(long timeout)`, `Thread.join(long millis)`, or `LockSupport.parkNanos()/parkUntil()`.
- **Terminated**: The thread has completed execution. This state occurs once the `run()` method exits, or an uncaught exception terminates the thread.

# Q8 What is deadlock?
A deadlock is a situation where two or more threads (or processes) are blocked forever, waiting for each other to release resources.

# Q9 How do threads communicate each other?
- **Shared Variables**: Multiple threads can read from and write to shared data structures. To ensure thread safety, this often requires synchronization mechanisms (like `synchronized` blocks or `ReentrantLocks`) to prevent concurrent modifications leading to inconsistent states or race conditions.
- **wait(), notify(), and notifyAll() Methods**: 
	- `wait()` causes the current thread to wait until another thread calls `notify()` or `notifyAll()` on the same object. This is typically used for waiting until some specific condition is met.
	- `notify()` wakes up a single thread that is waiting on the object's monitor.
	- `notifyAll()` wakes up all threads that are waiting on the object's monitor.
- **Future and Callable**: The `Callable` interface represents a task that returns a result. The `Future` interface represents the result of an asynchronous computation. A Callable can be submitted to an ExecutorService, and a Future is used to retrieve the result. 

# Q10 What’s the difference between class lock and object lock?
- An object lock is associated with an instance of a class (an object). When a method is synchronized on an instance level (using the synchronized keyword on a non-static method), it locks on the object itself. 
- A class lock is associated with the Class object that represents the class in the Java Virtual Machine. When a static method is synchronized (using the synchronized keyword on a static method), it locks on the Class object of the class, not on any individual instance.

# Q11 What is join() method?
The `join()` method in Java is a mechanism that allows one thread to wait for the completion of another.

# Q12 What is yield() method
The `yield()` method is a static method used to give a hint to the thread scheduler that the current thread is willing to yield its current use of a processor. When a thread calls `yield()`, it signals that it's not doing something critically important and, if necessary, it can wait for other threads to execute.

# Q13 What is ThreadPool? How many types of ThreadPool? What is the TaskQueue in ThreadPool?
A ThreadPool is a group of pre-instantiated reusable threads that are available to perform a set of arbitrary tasks. This is more efficient than creating a new thread for every task because thread creation and destruction are resource-intensive processes. 

- **Fixed Thread Pool**: It has a fixed number of threads. If all threads are active when a new task is submitted, the task waits in the queue until a thread is free.
- **Cached Thread Pool**: It creates new threads as needed, but will reuse previously constructed threads when available. If a thread is idle for a certain amount of time (60 seconds by default), it is terminated and removed from the cache.
- **Single Thread Executor**: It has only one thread to ensure that tasks are executed sequentially (one at a time).

**TaskQueue**： In a ThreadPool, the TaskQueue is a queue that holds tasks waiting to be executed. When all threads in the pool are actively working on tasks, new tasks are placed in the TaskQueue and wait in the queue until a thread becomes idle. Once a thread finishes its current task, it retrieves the next task from the queue and executes it.

# Q14 Which Library is used to create ThreadPool? Which Interface provide main functions of thread-pool?
The `java.util.concurrent` package is used to create ThreadPool. The `Executor` Interface provides main functions of ThreadPool.

# Q15 How to submit a task to ThreadPool?
To submit a task to a ThreadPool, you can use the `ExecutorService` interface from the `java.util.concurrent` package. Use the `execute(Runnable command)` method for submitting `Runnable` tasks, and `submit(Callable<T> task)` or `submit(Runnable task)` for `Callable` or `Runnable tasks`, respectively.

# Q16 What is the advantage of ThreadPool?
Using thread pools generally offers better performance and resource management compared to creating single threads directly. Thread pools control the number of concurrent tasks, reduce the overhead of thread creation and destruction, and improve performance. Moreover, thread pools allow task queuing for pending execution, automatically manage thread lifecycles, and provide more flexible error handling mechanisms.

# Q17 Difference between shutdown() and shutdownNow() methods of executor
- **shutdown()**: The `shutdown()` method initiates a graceful shutdown in which previously submitted tasks are executed, but no new tasks will be accepted.
- **shutdownNow()**: The `shutdownNow()` method attempts to stop all actively executing tasks, halts the processing of waiting tasks, and returns a list of the tasks that were awaiting execution.

# Q18 What is Atomic classes? How many types of Atomic classes? Give me some code example of Atomic classes and its main methods. when to use it?
Atomic classes provide a way to perform atomic (thread-safe and non-blocking) operations on single variables without using synchronization. Types of Atomic Classes:
- **Primitive Types**: Like `AtomicInteger`, `AtomicLong`, and `AtomicBoolean`.
- **Array Types**: Like `AtomicIntegerArray`, `AtomicLongArray`, and `AtomicReferenceArray`.
- **Reference Types**: Like `AtomicReference`, `AtomicStampedReference`.
- **Field Updaters**: Like AtomicIntegerFieldUpdater, AtomicLongFieldUpdater, and AtomicReferenceFieldUpdater.

```
import java.util.concurrent.atomic.AtomicInteger;

public class AtomicIntegerExample {
    public static void main(String[] args) {
        AtomicInteger atomicInt = new AtomicInteger(0);

        // Basic operations
        int incrementedValue = atomicInt.incrementAndGet(); // Atomically increments by 1
        int currentValue = atomicInt.get(); // Gets the current value
        atomicInt.set(5); // Sets the value to 5
        boolean isSuccess = atomicInt.compareAndSet(5, 10); // Sets to 10 if current value is 5
    }
}
```
**When to Use Atomic Classes**
- When multiple threads need to access and modify a single variable concurrently.
- When you want to avoid the overhead of traditional synchronization, especially for simple atomic operations.
- In scenarios where you want to implement non-blocking algorithms that require atomicity.

# Q19 What is the concurrent collections? Can you list some concurrent data structure (Thread-safe)
Concurrent collections in Java are thread-safe versions of standard collections that provide improved performance in multithreaded environments.
Some Concurrent Data Structures: `ConcurrentHashMap`,`ConcurrentLinkedQueue`,`ConcurrentLinkedDeque`,`CopyOnWriteArrayList`.

# Q20 What kind of locks do you know? What is the advantage of each lock?
- ReentrantLock; `ReentrantLock` is a mutual exclusion lock with the same basic behavior and semantics as the implicit monitor lock accessed using `synchronized`.  
- ReadWriteLock: `ReadWriteLock` maintains a pair of locks for read and write access. The idea is that multiple threads can hold the read lock as long as there's no thread holding the write lock, which allows for higher concurrency in read-heavy scenarios.
- StampedLock: `StampedLock` is a lock with three modes (writing, reading, and optimistic reading). It is a more sophisticated version of ReadWriteLock with better throughput under certain conditions. Optimistic reading allows performing write while read. 

# Q21 What is future and completableFuture? List some main methods of ComplertableFuture
- `Future` provides a way to access the result of an asynchronous computation once it's completed. You submit a `Callable` or `Runnable` task to an executor and receive a `Future` object.
- `CompletableFuture` implements Future and CompletionStage interfaces and allows composing and chaining multiple asynchronous operations. 
`CompletableFuture` methods include: 
- Creating a CompletableFuture: 
	- `CompletableFuture.supplyAsync(Supplier<U> supplier)`: Executes the given task asynchronously and returns the result
	- `CompletableFuture.runAsync(Runnable runnable)`: Executes the given task asynchronously, without returning a value
- Result Processing and Transformation:  
	- `CompletableFuture.thenApply(Function<T, U> fn)`: Processes the return value and transforms it into another type
	- `CompletableFuture.thenAccept(Consumer<T> action)`: Processes the return value without returning a new CompletableFuture
	- `CompletableFuture.thenRun(Runnable action)`: Ignores the return value and runs a runnable
- Combination and Linking
	- `CompletableFuture.thenCompose(Function<T, CompletionStage<U>> fn)`: Links another CompletableFuture and passes the result to the next task
	- `CompletableFuture.thenCombine(CompletionStage<U> other, BiFunction<T, U, V> fn)`: Combines the results of two CompletableFutures and returns a new CompletableFuture
- Exception Handling
	- `CompletableFuture.exceptionally(Function<Throwable, T> fn)`: Handles exceptions and returns an alternative value
	- `CompletableFuture.handle(BiFunction<T, Throwable, U> fn)`: Handles exceptions while allowing access to the result value (if any)


# Q22 Type the code by your self and try to understand it. (package com.chuwa.tutorial.t08_multithreading)

# Q23 Write a code to create 2 threads, one thread print 1,3,5,7,9, another thread print 2,4,6,8,10. One solution use synchronized and wait notify. One solution use ReentrantLock and await, signal.

# Q24 create 3 threads, one thread ouput 1-10, one thread output 11-20, one thread output 21-22. threads run sequence is random.

# Q25 completable future











