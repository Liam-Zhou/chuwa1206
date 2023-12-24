1. Read.

2. Explain what is volatile in java? (we also use it in Singleton)

    - `volatile` keyword indicates that its value might be modified by different threads asynchronously. It ensures that changes made to a `volatile` variable by one thread are immediately visible to other threads.


3. How to create a new thread(Please also consider Thread Pool approach)?

   1. Thread pool. eg:
        1. FixedThreadPool
      2. CachedThreadPool
      3. SingleThreadExecutor
   2. Create a class that extends the Thread class and overrides its run method.
   3. Implement the Runnable interface and override run() method (often use lambda).
   4. Implements the Callable interface and override call() method.
   


4. Difference between Runnable and Callable?

    - Runnable has run method whereas Callable has call method.
    - The run method has no return whereas call method has return value.


5. What is the difference between t.start() and t.run()?

   - t.start starts a new thread and executes the task（run()）
   - t.run() only executes the task in the current thread.


6. Which way of creating threads is better: Thread class or Runnable interface?

    - It depends on specific requirements, preferences, and design goals. Generally, you should use the runnable interface if you want to separate the logic of the thread from its execution and share the same task among multiple threads. 
    - The thread class is preferable if you want to customize behavior and properties of the thread, access its methods and attributes directly, and create a new thread for each task.
     - On the other hand, extending Thread class means that it cannot extend other classes because Java does not allow multiple inheritance.
   Another difference is, when you implement Runnable, it shares the same object to multiple threads. These are the scenarios where you want to implement Runnable.


7. What are the thread statuses?

   1. New State
   2. Runnable State
   3. Blocked State
   4. Waiting State
   5. Timed Waiting State
   6. Terminated State


8. What is deadlock?

   - a deadlock occurs when a process or thread enters a waiting state because a requested system resource is held by another waiting process, which in turn is waiting for another resource held by another waiting process.[3] If a process remains indefinitely unable to change its state because resources requested by it are being used by another process that itself is waiting, then the system is said to be in a deadlock.
    - Four necessary conditions for deadlock:
        1. Mutual exclusion
      2. Hold and wait
      3. No pre-emption
      4. Circular wait

9. How do threads communicate with each other?

    - Threads communicate primarily through shared memory or by signaling mechanisms.
      1. Shared Memory: Threads can communicate by sharing memory space. They can read from and write to shared variables or objects.
      2. Signaling Mechanisms: Threads can use signaling to communicate and synchronize their activities, include Wait/Notify.
      3. Message Passing: Threads can communicate using message passing protocols, Java provides constructs like BlockingQueue or ConcurrentLinkedQueue to facilitate message passing among threads.

10. What’s the difference between class lock and object lock?

    - Object locks synchronize access to instance-specific data, whereas class locks synchronize access to class-level resources or static data.

11. What is join() method?

    - `Join` method in Java allows one thread to wait until another thread completes its execution.

12. what is yield() method

    - It causes the currently executing thread object to temporarily pause and allow other threads to execute.

13. What is ThreadPool? How many types of ThreadPool? What is the TaskQueue in
    ThreadPool?

    - A thread pool reuses previously created threads to execute current tasks and offers a solution to the problem of thread cycle overhead and resource thrashing.
    - There are 4 types:
        1. FixedThreadPool
        2. CachedThreadPool
        3. SingleThreadExecutor
      4. ScheduledThreadPool
    -  `TaskQueue` is a data structure that holds tasks or jobs awaiting execution by worker threads. It acts as a buffer or storage for pending tasks until a worker thread becomes available to execute them.

14. Which Library is used to create ThreadPool? Which Interface provide main
    functions of thread-pool?

    - Library: java.util.concurrent.Executors
    - Interface: ExecutorService and ScheduledExecutorService.

15. How to submit a task to ThreadPool?

    - By calling submit method of a ThreadPool object.

16. What is the advantage of ThreadPool?

    - Scalability: This scalability ensures that the system doesn't become overloaded with too many simultaneous threads. This reduces the system's resource consumption and improves performance.
    - Resource Management: They manage the creation, reusing, and recycling of threads, preventing the overhead associated with creating new threads for each task.
    - Easier Maintenance

17. Difference between shutdown() and shutdownNow() methods of executor

    - After calling shutdown(), the ExecutorService stops accepting new tasks but allows the submitted tasks, which haven't started yet, to complete.
    - `shutdownNow()` attempts to stop all actively executing tasks, halts the processing of waiting tasks, and returns a list of the tasks that were awaiting execution. It does not wait for actively executing tasks to terminate and attempts to stop them by interrupting threads.

18. What is Atomic classes? How many types of Atomic classes? Give me some code
    example of Atomic classes and its main methods. when to use it?

    - Atomic classes in Java are part of the java.util.concurrent.atomic package and provide atomic operations on single variables without needing explicit synchronization.
    - There are several types of Atomic classes, such as:
        1. `AtomicBoolean`
      2. `AtomicInteger`
      3. `AtomicLong`
      4. `AtomicReference`
    - ```
      public class AtomicExample {
       public static void main(String[] args) {
        AtomicInteger atomicInt = new AtomicInteger(0);

        // Increment operation
        int incrementedValue = atomicInt.incrementAndGet();
        System.out.println("Incremented value: " + incrementedValue);

        // Compare and set operation
        boolean updated = atomicInt.compareAndSet(1, 5);
        System.out.println("Updated? " + updated); // Output: Updated? false, since the value is not 1

        // Get current value
        int currentValue = atomicInt.get();
        System.out.println("Current value: " + currentValue);
       }
      }
      ```
    - Atomic class is used when you need to perform operations on shared variables in a thread-safe manner without using explicit synchronization.

19. What is the concurrent collections? Can you list some concurrent data structure
    (Thread-safe)

    - A Concurrent Collection is a thread-safe collection. Examples:
      - CopyOnWriteArrayList
      - ConcurrentHashMap
      - CopyOnWriteArraySet
      - ArrayBlockingQueue
      - LinkedBlockingDeque

20. What kind of locks do you know? What is the advantage of each lock?

    - Synchronized Blocks: 
        1. Simple and easy to use
      2. Implicitly released when the synchronized block is exited
    - ReentrantLock:
        1. It has the ability to interrupt Thread while waiting for Lock. It provides a convenient tryLock() method, which acquires lock only if its available or not held by any other thread. This reduces the blocking of thread waiting for lock-in Java applications.
        2. Supports fairness policies to avoid thread starvation. Fairness property provides a lock to the longest waiting thread.
    - ReadWriteLock:
        1. Allows multiple threads to read a resource simultaneously while ensuring exclusive access for writing.
      2. Improves performance when there are more reads than writes.
      3. Increases concurrency by allowing parallel reads.
    - StampedLock:
        1. Provides three modes for locking: read, write, and optimistic read.
      2. Supports upgradable and downgradable locks, allowing efficient transitions between lock modes.
      3. Optimistic locking can be faster than exclusive locking in some scenarios.





21. What is future and completableFuture? List some main methods of
    ComplertableFuture.

    - Future represents the result of an asynchronous computation, allowing the retrieval of the computation's result or handling exceptions when the computation completes.
    - CompletableFuture is an extension of the Future interface and provides a more powerful way to write asynchronous, non-blocking code. It  offers a wide range of methods for combining, chaining, and handling results and exceptions asynchronously. Methods include:
        - `thenApply()`
        - `exceptionally()`
        - `thenApplyAsync()`
        - `anyOf()`
        - `allOf()`
        - `thenCombine()`
        - `thenCompose()`
        - `handle()`
        - `complete()`

22. Typed.


23. See Q23



24. See Q24



25. See Q25