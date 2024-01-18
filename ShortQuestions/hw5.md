# hw5: hw24-multiThreading

### Question1
Read: https://www.interviewbit.com/multithreading-interview-questions/#class
-level-lock-vs-object-level-lock

### Question 2
#### Explain what is volatile in Java?
In Java, the volatile keyword ensures that a variable's updates are visible to other threads. It reads the variable's value directly from main memory, ensuring thread-safe access.

### Question 3
#### How to create a new thread (Please also consider Thread Pool approach)?
To create a new thread:
- Extend the Thread class or implement the Runnable interface.
- For the Thread class, override the run() method.
- For the Runnable interface, implement the run() method.
- Instantiate the Thread or Runnable and call the start() method.
- For a thread pool, use the Executors framework.
- Submit tasks using execute() for Runnable or submit() for Callable.

### Question 4
#### Difference between Runnable and Callable?
Runnable and Callable are both interfaces that can be implemented to execute code on a thread.
The main difference:
- Runnable:
  - Does not return a result.
  - Cannot throw checked exceptions.
- Callable:
  - Returns a result.
  - Can throw checked exceptions.

### Question 5
#### What is the difference between t.start() and t.run()?
- t.start():
  - Initiates a new thread.
  - Calls the thread's run() method in that new thread.
- t.run():
  - Calls the run() method in the current thread.
  - Does not start a new thread.

### Question 6
#### Which way of creating threads is better: Thread class or Runnable interface?
- Runnable interface:
  - Allows a class to extend another class.
  - Provides clear separation of task and thread.
  - Supports multiple threads sharing the same object instance.
- Thread class:
  - Limits class extension due to single inheritance.

### Question 7
#### What are the thread statuses?
Thread statuses include:
- New: Thread is created but not yet started.
- Runnable: Thread is running or ready to run.
- Blocked: Thread is blocked waiting for a monitor lock.
- Waiting: Thread is waiting indefinitely.
- Timed Waiting: Thread is waiting for a specified time.
- Terminated: Thread has completed its execution.

### Question 8
#### What is deadlock?
A deadlock is a situation where two or more threads are perpetually waiting for each other to release locks, causing the threads to be blocked indefinitely.

### Question 9
#### How do threads communicate with each other?
Threads in Java use object's monitor methods and shared resources for communication:
- `wait()`: Causes the current thread to wait until another thread invokes `notify()` or `notifyAll()` on the same object. The thread must own the object's monitor.
- `notify()`: Wakes up a single thread that is waiting on the object's monitor. If multiple threads are waiting, one is chosen at random. The notifying thread does not release the lock until it exits the synchronized block.
- `notifyAll()`: Wakes up all threads waiting on the object's monitor. When the lock is released, the threads will compete for it.
- Shared resources: Threads can also communicate by sharing resources. Access to these resources must be synchronized to prevent conflicts.

### Question 10
#### What’s the difference between class lock and object lock?
- Object lock:
  - Synchronizes instance methods or blocks.
  - Lock is on the instance (object).
- Class lock:
  - Synchronizes static methods or blocks.
  - Lock is on the class, affecting all instances.

### Question 11
#### What is join() method?
The join() method allows one thread to wait for the completion of another thread's execution.

### Question 12
#### What is yield() method?
The yield() method hints to the thread scheduler to pause the current thread's execution and allow other threads to execute.

### Question 13
#### What is ThreadPool? How many types of ThreadPool? What is the TaskQueue in ThreadPool?
A ThreadPool reuses threads for task execution and manages worker threads. Java provides several types:
- `FixedThreadPool`: Reuses a fixed number of threads; all tasks are executed in a shared unbounded queue.
- `CachedThreadPool`: Creates new threads as needed, but reuses previously constructed threads when available.
- `ScheduledThreadPool`: Features that can schedule commands to run after a given delay or periodically.
- `SingleThreadExecutor`: Executes tasks sequentially in a single thread, ensuring task ordering.
The TaskQueue in a ThreadPool is a queue that holds tasks waiting to be executed. It manages the workload, ensuring that active threads have tasks to execute.

### Question 14
#### Which Library is used to create ThreadPool? Which Interface provides main functions of thread-pool?
- Library for creating ThreadPool: java.util.concurrent.Executor.
- Interface providing main functions: Executor and its sub-interface ExecutorService.

### Question 15
#### How to submit a task to ThreadPool?
Submit a task to a ThreadPool using execute(Runnable command) or submit(Callable<T> task) of the ExecutorService interface.

### Question 16
#### What is the advantage of ThreadPool?
ThreadPool advantages:
- Efficient reuse of existing threads.
- Effective thread management.
- Reduced overhead from thread creation and destruction.
- Enhanced application performance.

### Question 17
#### Difference between shutdown() and shutdownNow() methods of executor
- shutdown():
  - Initiates an orderly shutdown.
  - Executes previously submitted tasks, no new tasks accepted.
- shutdownNow():
  - Attempts to stop all actively executing tasks.
  - Halts the processing of waiting tasks.

### Question 18
#### What are Atomic classes? How many types of Atomic classes? Give me some code example of Atomic classes and its main methods. When to use it?
Atomic classes in the java.util.concurrent.atomic package provide thread-safe operations on single variables, ensuring atomicity. 
Common types include AtomicInteger, AtomicLong, and AtomicBoolean. 
They are used for operations that require atomicity without using synchronization. 
For example, AtomicInteger provides methods like getAndIncrement() for atomic integer operations.

Code example using `AtomicInteger`:
```java
import java.util.concurrent.atomic.AtomicInteger;

public class AtomicExample {
    private AtomicInteger count = new AtomicInteger(0);

    public void increment() {
        count.incrementAndGet(); // Atomically increments by one
    }

    public int getCount() {
        return count.get(); // Returns the current value
    }
}
```

### Question 19
#### What are the concurrent collections? Can you list some concurrent data structures (Thread-safe)?
Concurrent collections ensure thread-safe data handling and improved performance. Examples include:
- ConcurrentHashMap: A thread-safe version of HashMap.
- CopyOnWriteArrayList: A thread-safe variant of ArrayList where all mutative operations are implemented by creating a new copy.
- BlockingQueue: A Queue that additionally supports operations that wait for the queue to become non-empty when retrieving elements.

### Question 20
#### What kind of locks do you know? What is the advantage of each lock?
Different types of locks in Java offer various levels of control and flexibility:
- Intrinsic locks (`synchronized` blocks/methods):
  - Built into Java, providing an easy way to create critical sections.
  - Every object has an intrinsic lock, ensuring mutual exclusion.
- `ReentrantLock`:
  - Provides additional features over intrinsic locks, like lock polling (`tryLock()`), timed lock waits, and interruptible lock waits.
  - Supports fairness parameter, ensuring longest-waiting thread gets the lock.
- `ReadWriteLock`:
  - Separates read and write operations. Multiple threads can hold the read lock (if no thread has the write lock), but only one thread can hold the write lock.
  - Enhances performance in read-heavy scenarios.
- `StampedLock`:
  - Offers methods for optimistic reads, allowing greater concurrency.
  - Provides read and write locks with a stamp (long value), used for lock validation.

### Question 21
#### What is future and CompletableFuture? List some main methods of CompletableFuture.
Future represents a future result of an asynchronous operation. CompletableFuture extends Future, allowing for completion of the operation and chaining asynchronous operations. Main methods include thenApply, thenAccept, thenRun, and exceptionally, facilitating function chaining and exception handling.

### Question 22
#### Type the code by yourself and try to understand it. (package com.chuwa.tutorial.t08_multithreading)

[link](https://github.com/Liam-Zhou/chuwa1206/tree/diana_men/hw5/CodingQuestions/hw5/t08_multithreading)

### Question 23
#### Write a code to create 2 threads, one thread print 13579, another thread print 246810.
Create two threads where one prints odd numbers (1, 3, 5, 7, 9) and the other prints even numbers (2, 4, 6, 8, 10). Use synchronized blocks or ReentrantLock for proper coordination between the threads.

[link](https://github.com/Liam-Zhou/chuwa1206/tree/diana_men/hw5/CodingQuestions/hw5/Q23)

### Question 24
#### Create 3 threads, one thread output 1-10, one thread output 11-20, one thread output 21-30. Threads run sequence is random.
Create three threads, each responsible for printing a specific range of numbers (1-10, 11-20, 21-30). The order of execution is determined by the thread scheduler and is typically random.

[link](https://github.com/Liam-Zhou/chuwa1206/tree/diana_men/hw5/CodingQuestions/hw5/Q24)

### Question 25
#### CompletableFuture: Homework tasks.
- Homework 1: Implement a CompletableFuture to asynchronously calculate and print the sum and product of two integers.
- Homework 2: Use CompletableFuture to fetch data asynchronously from three APIs: products, reviews, and inventory. Combine the results for further processing.
- Homework 3: Add exception handling to Homework 2. If an API call fails, log the exception and return a default value. 

- Homework 1: [link](https://github.com/Liam-Zhou/chuwa1206/tree/diana_men/hw5/CodingQuestions/hw5/Q25/MathOperations.java) 
- Homework 2: [link](https://github.com/Liam-Zhou/chuwa1206/tree/diana_men/hw5/CodingQuestions/hw5/Q25/OnlineStoreWithApiCalls.java)  
- Homework 3: [link](https://github.com/Liam-Zhou/chuwa1206/tree/diana_men/hw5/CodingQuestions/hw5/Q25/OnlineStoreWithApiCallsAndExceptionHandling.java)

