#### 2. Explain what is volatile in java? (we also use it in Singleton)
In Java, the `volatile` keyword is used to mark a Java variable as being stored in main memory. This means that every read of a volatile variable will be read from the computer's main memory, and not from the CPU cache, and that every write to a volatile variable will be written to main memory, and not just to the CPU cache. It is often used in the context of multithreading, where it ensures that changes made in one thread are immediately visible to other threads. In Singleton patterns, it's used to ensure that the instance is not cached by the JVM or the compiler.
#### 3. How to create a new thread(Please also consider Thread Pool approach)?
To create a new thread in Java:
- Extend the `Thread` class and override its `run()` method.
- Implement the `Runnable` interface and override its `run()` method, then pass it to a `Thread` object.

For a thread pool:
- Use the Executors factory methods to create a thread pool, e.g., `Executors.newFixedThreadPool(int nThreads)`.
- Submit tasks to the pool using `execute(Runnable command)` or `submit(Callable<T> task)`.
#### 4. Difference between Runnable and Callable?
`Runnable` and `Callable` are both interfaces used in Java for tasks that are intended to be executed by a separate thread. The main differences are:
- `Runnable` does not return a result and cannot throw checked exceptions, whereas `Callable` can return a result and can throw checked exceptions.
- `Runnable.run()` has no return value, while `Callable.call()` returns a value of type `V`.

#### 5. What is the difference between t.start() and t.run()?
- `t.start()` method of the `Thread` class is used to start a newly created thread. It causes this thread to begin execution; the Java Virtual Machine calls the run method of this thread.
- `t.run()` just calls the `run` method on the current thread, without starting a new thread.

#### 6. Which way of creating threads is better: Thread class or Runnable interface?
Using the `Runnable` interface is generally considered better practice:
- It allows you to extend another class, as Java doesn't support multiple inheritance.
- It promotes separation of task implementation (`Runnable`) from thread management (`Thread`).

#### 7. What are the thread statuses?
A thread in Java can be in one of the following states:
- New: The thread is created but not yet started.
- Runnable: The thread is executing in the Java virtual machine.
- Blocked: The thread is blocked waiting for a monitor lock.
- Waiting: The thread is waiting indefinitely for another thread to perform a particular action.
- Timed Waiting: The thread is waiting for another thread to perform an action for up to a specified waiting time.
- Terminated: The thread has exited.

#### 8. What is deadlock?
Deadlock is a condition in multithreading where two or more threads are blocked forever, each waiting for the other to release a lock. It occurs when multiple threads need the same locks but obtain them in a different order.

#### 9. How do threads communicate each other?
Threads in Java can communicate with each other by:
- Using shared objects and variables.
- Employing wait(), notify(), and notifyAll() methods for coordination.

#### 10. What’s the difference between class lock and object lock?
In Java synchronization:
- An object lock is a mechanism when you want to synchronize a non-static method or block, so that it can be accessed by only one thread at a time for the same instance.
- A class lock is used when you want to synchronize a static method or block, ensuring that it can be accessed by only one thread at a time for the entire class, not just for an instance.

#### 11. What is join() method?
The `join()` method in Java's `Thread` class allows one thread to wait until another thread completes its execution. If `t` is a `Thread` object whose thread is currently executing, then `t.join()` causes the current thread to pause execution until `t`'s thread terminates.

#### 12. what is yield() method
The `yield()` method in Java's `Thread` class causes the currently executing thread to pause and allow other threads to execute. This is essentially a hint to the thread scheduler that the current thread is willing to yield its current use of the processor, but the scheduler is free to ignore this hint.

#### 13. What is ThreadPool? How many types of ThreadPool? What is the TaskQueue in ThreadPool?
A ThreadPool in Java is a group of fixed size threads that are used to execute tasks. Types of ThreadPool in Java's Executor framework include:
- FixedThreadPool
- CachedThreadPool
- ScheduledThreadPool
- SingleThreadExecutor

The TaskQueue in ThreadPool is a queue that stores tasks to be executed by the threads in the pool. It's used to manage the work that gets executed by the threads.

#### 14. Which Library is used to create ThreadPool? Which Interface provide main functions of thread-pool?
In Java, the `java.util.concurrent` library is used to create and manage ThreadPools. The `Executor` interface and its subtypes like `ExecutorService` and `ScheduledExecutorService` provide the main functionalities for thread pool management in Java.

#### 15. How to submit a task to ThreadPool?
To submit a task to a ThreadPool in Java:
- Create an instance of the ExecutorService using one of the Executors factory methods.
- Use `submit(Runnable task)` for tasks that don't return a value, or `submit(Callable<T> task)` for tasks that return a value.
- After task execution, shutdown the ExecutorService with `shutdown()`.

#### 16. What is the advantage of ThreadPool?
- Improved performance as it reduces the overhead of creating new threads for every task.
- Better resource management as it limits the number of threads running in parallel.
- Provides a solution for managing a large number of concurrent tasks with fewer system resources.

#### 17. Difference between shutdown() and shutdownNow() methods of executor
In Java's Executor framework:
- `shutdown()` method initiates a graceful shutdown in which previously submitted tasks are executed, but no new tasks will be accepted.
- `shutdownNow()` method attempts to stop all actively executing tasks, halts the processing of waiting tasks, and returns a list of tasks that were awaiting execution.

#### 18. What is Atomic classes? How many types of Atomic classes? Give me some code example of Atomic classes and its main methods. when to use it?
Atomic classes in Java, part of the `java.util.concurrent.atomic` package, provide a way to perform atomic operations on a single variable without using synchronization. Types include:
- AtomicBoolean
- AtomicInteger
- AtomicLong
- AtomicReference

Example:
```java
AtomicInteger atomicInt = new AtomicInteger(0);
atomicInt.incrementAndGet(); // atomic increment operation
```
#### 19. What is the concurrent collections? Can you list some concurrent data structure (Thread-safe)
Concurrent collections in Java are thread-safe versions of standard collections that provide improved performance under concurrent access.
- ConcurrentHashMap
- CopyOnWriteArrayList
- ConcurrentLinkedQueue
- ConcurrentSkipListMap
#### 20. What kind of locks do you know? What is the advantage of each lock?
- Intrinsic Locks (synchronized blocks): Easy to use and no need for explicit lock management.
- Reentrant Locks: More flexible than intrinsic locks, allow fairness policy, and provide methods like tryLock().
- ReadWriteLock: Allows multiple readers, but only one writer. Useful in scenarios where reads are more frequent than writes.
  Each lock type offers different levels of control and flexibility for different concurrency requirements.

#### 21. What is future and completableFuture? List some main methods of ComplertableFuture.
`Future` and `CompletableFuture` are used for asynchronous programming in Java:
- `Future` represents the result of an asynchronous computation, but has limited capabilities.
- `CompletableFuture`, an enhancement of `Future`, provides methods for manually completing the computation and combining multiple futures.

Main methods of `CompletableFuture` include:
- `complete(T value)`: Completes the Future with the given value.
- `thenApply(Function)`: Applies a function to the result.
- `thenCombine(CompletableFuture, BiFunction)`: Combines two futures.
- `exceptionally(Function)`: Handles exceptions.
#### 22. Type the code by your self and try to understand it.
[Code](../Repo/MavenProject/java-core/src/main/java/t08_multithreading)
#### 23. Write a code to create 2 threads one thread print 13579 another thread print 246810.
[Code](../Repo/MavenProject/java-core/src/main/java/t08_multithreading/c05_waitNotify)
#### 24. create 3 threads one thread ouput 1-10 one thread output 11-20 one thread output 21-22. threads run sequence is random. (solution is in com.chuwa.exercise.t08_multithreading.PrintNumber1)
[Code](../Repo/MavenProject/java-core/src/main/java/t08_multithreading/exercise/PrintNumber1.java)
#### 25. completable future:
[Code](../Repo/MavenProject/java-core/src/main/java/t08_multithreading/exercise/complete_future)
