### Question 2
- The volatile keyword in Java is used to indicate that a variable's value may be modified by multiple threads simultaneously. 
    It ensures that the variable is always read from and written to the main memory, rather than from thread-specific caches, ensuring visibility across threads.
### Question 3
- Extending the Thread class and overriding its run() method.
- Implementing the Runnable interface and passing an instance of it to a Thread object.

### Question 4
- Callable has its own return type

### Question 5
- start() method starts a new thread and calls the run() method in that new thread.
- run() simply  the run() method in the current thread without starting a new thread.

### Question 6
Implementing the Runnable interface is better than extending the Thread class as it allows for more flexibility.

### Question 7
- `NEW`: Thread is in the new state before the start() method is invoked.
- `RUNNABLE`: Thread is in this state after the start() method is called, and it's eligible to run.
- `BLOCKED`: Thread is waiting for a monitor lock.
- `WAITING`: Thread is waiting indefinitely for another thread to perform a particular action.
- `TIMED_WAITING`: Thread is waiting for a specified amount of time.
- `TERMINATED`: Thread has exited.

### Question 8
- A deadlock is a state where each process or thread is blocked waiting for a resource held by another process or thread, and no progress can be made.
### Question 9
`wait()`, `notify()`, `notifyAll()`

### Question 10
- `Object lock`:  is a mechanism when a synchronized method or synchronized block is used on an instance of a class. 
- `class lock` is associated with the class's Class object, typically used in static methods.

### Question 11
- `join()`: join() method is a method provided by the Thread class. It is used to wait for a thread to complete its execution.

### Question 12
-`yield()`: t suggests to the Java Virtual Machine (JVM) that the current thread is willing to give up its current time slice to allow other threads to execute.

### Question 13
- `ThreadPool`:A ThreadPool, also known as a Thread Pool, is a pool of worker threads that are managed by a thread pool manager.
The main purpose of a ThreadPool is to efficiently manage and reuse a pool of worker threads, allowing for parallel execution of tasks.
It includes: cachedThreadPool, SingleThreadExecutor,FixedThreadPool
### Question 14
- `java.util.concurrent` provides the ThreadPool functionality in Java.
- `ExecutorService` interface provides the main functionality of a thread pool.

### Question 15
 `execute()` and `submit()`.

### Question 16
-  Using thread pools generally offers better performance and resource management
    compared to creating single threads directly. Thread pools control the number of
    concurrent tasks, reduce the overhead of thread creation and destruction, and improve
    performance. Moreover, thread pools allow task queuing for pending execution,
### Question 17
- The `shutdown()` method will allow previously submitted tasks to execute before terminating, 
- while the `shutdownNow()` method prevents waiting tasks from starting and attempts to stop currently executing tasks.
### Question 18
- Atomic classes in Java provide atomic operations, which means that the operations are performed as a single, indivisible unit, and they are thread-safe. These classes are part of the java.util.concurrent.atomic package and are particularly useful in scenarios where multiple threads might access and modify shared variables concurrently.
- Some commonly used atomic classes include AtomicInteger, AtomicLong, AtomicBoolean, AtomicReference, etc.

### Question 19
- Concurrent collections in Java are specialized data structures that are designed to be safely used by multiple threads concurrently.
  including `ConcurrentHashMap`, `CopyOnWriteArrayList`, and `ConcurrentLinkedQueue`.

### Question 20
- `Reentrant Lock`: Provides locking and unlocking in a flexible manner.
- `ReadWrite Lock`: Read and write operations for better performance when many reads are expected.
- `Stamped Lock`: Provides a locking hat supports both read and write locks, including optimistic reads.

### Question 21
- `Future` is an interface representing the result of an asynchronous computation. It provides a way to check if the computation is complete and to retrieve the result when it is ready. However, it has limitations in terms of composability and handling callbacks. 
- `CompletableFuture` is an enhancement introduced in Java 8 to address these limitations and provide a more flexible and powerful way to work with asynchronous computations, including
  `thenApply`, `thenRun(Runnable action)`,`thenCompose``thenApplyAsync`,`thenAcceptAsync`
