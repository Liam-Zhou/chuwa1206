# HW 5

## Q2 Explain what is volatile in java? (we also use it in Singleton)


The **volatile** keyword in Java is used to ensure that **changes** to a variable are **immediately visible** to **all threads**. It's commonly used in multithreading contexts to **prevent caching of variables** by threads, thus avoiding inconsistent views of the variable's value. In the Singleton pattern, volatile is often used to ensure that a Singleton instance is correctly constructed and visible to all threads, particularly in the Double-Checked Locking idiom. However, volatile does not provide atomicity and is not a replacement for full synchronization.

## Q3 How to create a new thread? (Please also consider Thread Pool approach)

Creating a new thread in Java can be achieved in two main ways: 
- By extending the Thread class or implementing the Runnable interface.

```
class MyThread extends Thread {
    public void run() {
    }
}

MyThread t = new MyThread();
t.start();
```

```
class MyRunnable implements Runnable {
    public void run() {
        
    }
}

Thread t = new Thread(new MyRunnable());
t.start();
```

- By using a thread pool is a more efficient approach for managing multiple threads.

```
ExecutorService executor = Executors.newFixedThreadPool(4);


executor.submit(new MyRunnable());
executor.submit(new MyRunnable());



executor.shutdown();
```

# Q4 Difference between Runnable and Callable?

The main differences between Runnable and Callable in Java are:

- **Return Value**:

    + Runnable: Does not return any value (void method).
    + Callable: Can return a value of any type.

- **Exception Handling**:

    + Runnable: Cannot throw checked exceptions.
    + Callable: Can throw checked exceptions.

- **Usage with Executors**:

    + Runnable tasks submitted to an executor do not return a result.
    + Callable tasks return a Future object, allowing you to retrieve the result asynchronously.


## Q5 What is the difference between t.start() and t.run()?
In Java:

- **t.start()**: Initiates a new thread, executing the run() method of the Thread object t concurrently.
- **t.run()**: Executes the run() method in the current thread, not starting a new thread.

## Q6 Which way of creating threads is better: Thread class or Runnable interface?

Using the **Runnable** interface is generally considered better than extending the Thread class for creating threads in Java due to:

- **Flexibility**: Runnable allows separating task definition from thread execution and doesn't restrict you from extending other classes.
- **Compatibility with Executors**: Runnable tasks can be easily managed with Java's Executor framework.
- **Better Design Practice**: Implementing Runnable promotes a cleaner, more modular design and enhances code reusability.

## Q7 What are the thread statuses?

In Java, a thread can be in one of the following states:

- **New**: The thread is created but not yet started.
- **Runnable**: The thread is ready to run and might be running or ready to run at any instant.
- **Blocked**: The thread is blocked waiting for a monitor lock (typically in synchronized blocks).
- **Waiting**: The thread is waiting indefinitely for another thread to perform a particular action.
- **Timed Waiting**: The thread is waiting for another thread to perform an action for up to a specified waiting time.
- **Terminated**: The thread has completed execution.

## Q8 What is deadlock?
Deadlock in Java is a situation where two or more threads are blocked forever, each waiting for the other to release a lock.

## Q9 How do threads communicate each other?

In Java, threads communicate with each other primarily through shared objects and using **wait()**, **notify()**, and **notifyAll()** methods defined in the Object class. These methods are used within synchronized blocks or methods to achieve inter-thread communication, allowing threads to wait for specific conditions to be met or to signal other threads about condition changes.

## Q10 What’s the difference between class lock and object lock?

In Java:

- **Object Lock**: Obtained on an instance of a class. It's specific to the instance, so different threads can access synchronized instance methods of different instances simultaneously.

- **Class Lock**: Obtained on the class itself. It's global to all instances of the class, so different threads can't simultaneously access any synchronized static methods of the class.

## Q11 What is join() method?

The join() method in Java allows one thread to wait for the completion of another. When it's called on a thread, the calling thread goes into a waiting state until the referenced thread finishes execution.

## Q12 what is yield() method? 
The yield() method in Java is a static method that hints to the thread scheduler that the current thread is willing to yield its current use of a processor. If the hint is acted upon, it moves the current thread to the Ready/Runnable state, allowing other threads of the same priority to get a chance to execute.

## Q13 What is ThreadPool? How many types of ThreadPool? What is the TaskQueue in ThreadPool?

**ThreadPool**: A group of pre-instantiated, reusable threads for executing tasks, improving performance by reducing the overhead of thread creation.

Types of ThreadPool:

- FixedThreadPool: Has a fixed number of threads; excess tasks wait in a queue.
- CachedThreadPool: Creates new threads as needed; reuses available ones.
- SingleThreadExecutor: Contains only one thread, ensuring sequential task execution.
- ScheduledThreadPool: Executes tasks with specified delays or periodically.

**TaskQueue in ThreadPool**: A queue holding tasks that await execution by the threads in the pool. Its behavior varies with the ThreadPool type.

## Q14 Which Library is used to create ThreadPool? Which Interface provide main functions of thread-pool?

The Java standard library, specifically the **java.util.concurrent** package, is used to create ThreadPool. The main interface providing the functionality of a thread pool in this package is **ExecutorService**.


## Q15 How to submit a task to ThreadPool?

To submit a task to a ThreadPool in Java, use the **submit()** method of the **ExecutorService** interface. This method takes a **Runnable** or **Callable** task and returns a **Future** object representing the task's pending result.

## Q16 What is the advantage of ThreadPool?

The advantages of using a ThreadPool in Java include:

1. **Improved Resource Management**: Reduces the overhead of creating and destroying threads for each task.
1. **Enhanced Performance**: Reusing existing threads reduces the time and memory cost associated with thread lifecycle management.
1. **Better Task Management**: Allows for fine-tuning of the number of active tasks and threads, improving system stability.
1. **Controlled Resource Allocation**: Prevents system overload by limiting the number of concurrent threads.
1. **Task Queueing**: Enables efficient execution of tasks by queuing incoming tasks and processing them as threads become available.

## Q17 Difference between shutdown() and shutdownNow() methods of executor? 

In Java's **ExecutorService**:

- **shutdown()**: Initiates an orderly shutdown where previously submitted tasks are executed, but no new tasks are accepted. It doesn't interrupt existing tasks.

- **shutdownNow()**: Attempts to stop all actively executing tasks, halts the processing of waiting tasks, and returns a list of tasks that were awaiting execution. This method attempts to interrupt currently executing tasks.

## Q18 What is Atomic classes? How many types of Atomic classes?

Atomic classes in Java, from the **java.util.concurrent.atomic** package, provide **thread-safe** operations on single variables without synchronization. Key types include **AtomicInteger**, **AtomicLong**, **AtomicBoolean**, and **AtomicReference**.

```
AtomicInteger atomicInt = new AtomicInteger(0);
atomicInt.incrementAndGet(); 
atomicInt.getAndSet(5); 
atomicInt.compareAndSet(5, 10); 
```

## Q19 What is the concurrent collections? Can you list some concurrent data structure (Thread-safe)?

**Concurrent collections** in Java are thread-safe versions of standard collections designed for concurrent access. Examples include:

- **ConcurrentHashMap**: Thread-safe version of HashMap.
- **CopyOnWriteArrayList**: An ArrayList variant for frequent reads and infrequent writes.
- **ConcurrentLinkedQueue**: A thread-safe linked node-based queue.
- **BlockingQueue** (like ArrayBlockingQueue, LinkedBlockingQueue): Queues that support operations waiting for space or elements.
- **ConcurrentSkipListMap and ConcurrentSkipListSet**: Sorted, thread-safe map and set.

## Q20 What kind of locks do you know? What is the advantage of each lock?

In Java, different types of locks offer various advantages:

- **Intrinsic Locks** (Synchronized Blocks/Methods): Easy to use; best for simple synchronization.
- **ReentrantLock**: More flexible than intrinsic locks; supports fairness, lock polling, and interruption.
- **ReadWriteLock** (ReentrantReadWriteLock): Allows multiple readers; ideal for read-heavy scenarios.
- **StampedLock**: Offers read, write, and optimistic locks; optimized for scenarios with more reads than writes.
- **Semaphore**: Controls access to a resource pool; useful for managing limited resources.

## Q21 What is future and completableFuture? List some main methods of ComplertableFuture.


**Future** represents the result of an asynchronous computation.

**CompletableFuture** is an advanced version of Future with enhanced features for asynchronous programming.

Key CompletableFuture Methods:

- **complete(T value)**: Manual completion.
- **thenApply(Function)**: Result transformation.
- **thenCombine(CompletionStage, BiFunction)**: Combining results.
- **thenAccept(Consumer)**: Result handling.
- **exceptionally(Function)**: Exception handling.
- **supplyAsync(Supplier)**: Asynchronous value supply.
- **runAsync(Runnable)**: Asynchronous execution.
- **allOf(CompletableFuture...)**: Waiting for all.
- **anyOf(CompletableFuture...)**: Waiting for any.









