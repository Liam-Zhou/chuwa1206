## 2. What is volatile in Java?
In Java, the volatile keyword is used to mark a variable as being stored in the main memory. It means that every read of a volatile variable will be read from the computer's main memory, and not from the CPU cache, and that every write to a volatile variable will be written to main memory, and not just to the CPU cache. It's often used in the context of multithreading to ensure that changes made by one thread to a shared variable are visible to other threads. In Singleton patterns, it's used to prevent issues with the instance being initialized multiple times.

## 3. How to create a new thread (Thread Pool approach)?
To create a new thread, you can either extend the Thread class or implement the Runnable interface. For a thread pool, you use Executors to create a pool of threads and submit tasks to it. This allows for efficient management of a pool of threads to execute tasks asynchronously.
`ExecutorService executor = Executors.newFixedThreadPool(10);
executor.execute(new RunnableTask());`

## 4. How to create a new thread (Thread Pool approach)?
Runnable and Callable are both interfaces used to execute code on a thread. The Runnable interface has a run() method that does not return a result and cannot throw checked exceptions. On the other hand, the Callable interface's call() method can return a result and throw checked exceptions.

## 5. What is the difference between t.start() and t.run()?
t.start() starts a new thread and calls the run() method on that new thread, whereas t.run() simply calls the run() method on the current thread, without starting a new one.

## 6.Which way of creating threads is better: Thread class or Runnable interface?
Using the Runnable interface is generally considered better because it allows you to extend another class while still being able to run your code on a separate thread. Java doesn't support multiple inheritance, so using Runnable is more flexible.

## 7. What are the thread statuses?
A thread in Java can be in one of several states: New, Runnable, Blocked, Waiting, Timed Waiting, or Terminated.

## 8. What is deadlock?
Deadlock is a situation in multithreading where two or more threads are blocked forever, each waiting for the other to release a lock.

## 9. How do threads communicate with each other?
Threads can communicate with each other using shared objects. Methods like wait(), notify(), and notifyAll() are used for communication between synchronized threads.

## 10. What’s the difference between class lock and object lock?
An object lock is a lock on an instance of an object, used for synchronized instance methods or blocks. A class lock is a lock on the Class object itself and is used for static synchronized methods or blocks.

## 11. What is the join() method?
The join() method allows one thread to wait for the completion of another. If t is a Thread object whose thread is currently executing, then t.join() causes the current thread to pause execution until t's thread terminates.

## 12. What is the yield() method?
The yield() method causes the currently executing thread to pause and allow other threads of the same priority to execute. It's a way of suggesting that the current thread is willing to yield its current use of a processor.

## 13.What is ThreadPool? How many types of ThreadPool? What is the TaskQueue in ThreadPool?
A ThreadPool is a group of pre-instantiated reusable threads that can be used to execute tasks. Java's ExecutorService manages a pool of threads and offers various thread pool implementations like FixedThreadPool, CachedThreadPool, SingleThreadExecutor, and ScheduledThreadPool. The TaskQueue is a queue that holds tasks waiting to be executed by the threads in the pool.

## 14. Which Library is used to create ThreadPool? Which Interface provide main functions of thread-pool?
The java.util.concurrent package contains the ThreadPoolExecutor class and the ExecutorService interface, which are used to create and manage thread pools.

## 15. How to submit a task to ThreadPool?
You can submit tasks to a thread pool using the execute(Runnable) or submit(Callable) methods of the ExecutorService.

## 16. What is the advantage of ThreadPool?
ThreadPool reuses a number of threads to execute tasks, reducing the overhead of thread creation, especially for large numbers of short-lived tasks. It also allows for easy management of the number of active threads and tasks.

## 17. Difference between shutdown() and shutdownNow() methods of executor
shutdown() initiates a graceful shutdown where previously submitted tasks are executed, but no new tasks will be accepted. shutdownNow() attempts to stop all actively executing tasks and halts the processing of waiting tasks.

## 18. What is Atomic classes? How many types of Atomic classes?
Atomic classes in the java.util.concurrent.atomic package support lock-free and thread-safe programming on single variables. Common atomic classes include AtomicInteger, AtomicLong, AtomicBoolean, and AtomicReference. They provide methods to perform atomic operations, such as compare-and-set, get-and-set, increment.

## 19. What is the concurrent collections? Can you list some concurrent data structures (Thread-safe)?
Concurrent collections are designed to allow multiple threads to access and modify the collection concurrently without the need for external synchronization. Examples include ConcurrentHashMap, CopyOnWriteArrayList, and BlockingQueue implementations like ArrayBlockingQueue and LinkedBlockingQueue.

## 20. What kind of locks do you know? What is the advantage of each lock?
Common types of locks include intrinsic locks (synchronized blocks/methods) and explicit locks (like ReentrantLock). Intrinsic locks are easy to use but less flexible. Explicit locks offer more advanced features like tryLock, fairness, and the ability to interrupt a waiting thread.

## 21. What is future and CompletableFuture? List some main methods of CompletableFuture.
Future represents the result of an asynchronous computation. CompletableFuture is an extension that provides a lot of flexibility and the ability to chain steps, combine several futures, or handle exceptions. Some main methods include thenApply, thenAccept, thenCombine, exceptionally, and applyToEither.




