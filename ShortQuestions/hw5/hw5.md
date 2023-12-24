### Question 2
The volatile keyword in Java is used to indicate that a variable's value will be modified by different threads. Declaring a variable as volatile ensures that its value is always read from the main memory, not from a thread's cache memory.

### Question 3
The two most common methods are:

Extending the Thread class and overriding its run() method.
Implementing the Runnable interface and passing an instance of the class to a Thread object.

### Question 4
Runnable interface is used for creating threads and it has a run() method that does not return a value.
Callable, introduced in Java 5, is similar to Runnable but it can return a value and throw exceptions. It's used with ExecutorService and returns a Future object.

### Question 5
t.start() method starts a new thread and calls the run() method in that new thread.
t.run() simply executes the run() method in the current thread without starting a new thread.

### Question 6
Implementing the Runnable interface is generally preferred over extending the Thread class as it allows for more flexibility, like extending another class if needed.

### Question 7
 In Java, a thread can be in one of several states: New, Runnable, Blocked, Waiting, Timed Waiting, or Terminated.

### Question 8
A deadlock is a situation in multi-threading where two or more threads are blocked forever, each waiting for the other to release a resource.

### Question 9
Threads in Java can communicate with each other using shared objects. Methods like wait(), notify(), and notifyAll() are used for this purpose.

### Question 10
An object lock is a mechanism when a synchronized method or synchronized block is used on an instance of a class. Each instance has its own lock.
A class lock is associated with the class's Class object, typically used in static synchronized methods.

### Question 11
The join() method allows one thread to wait for the completion of another. If t is a Thread object whose thread is currently executing, then t.join() causes the current thread to pause execution until t's thread terminates.

### Question 12
The yield() method causes the currently executing thread object to temporarily pause and allow other threads to execute.

### Question 13
ThreadPool in Java is a pool of worker threads that are used to execute tasks.
The TaskQueue is a queue of tasks that are waiting to be executed by the threads in the ThreadPool.

### Question 14
The java.util.concurrent package provides the ThreadPool functionality in Java.
The ExecutorService interface provides the main functionality of a thread pool.

### Question 15
Tasks can be submitted to the thread pool using methods like execute() and submit() on the ExecutorService instance.

### Question 16
Improved performance as it reduces the overhead of creating and destroying threads for each task.
Better resource management as the number of threads in the pool is limited.

### Question 17
shutdown() initiates a graceful shutdown where previously submitted tasks are executed but no new tasks will be accepted.
shutdownNow() attempts to stop all actively executing tasks and halts the processing of waiting tasks.

### Question 18
Atomic classes in Java, like AtomicInteger, AtomicLong, etc., provide a way to perform atomic operations on a single variable without using synchronization.

### Question 19
Concurrent collections are thread-safe versions of standard collections like maps, lists, and sets.
Examples include ConcurrentHashMap, CopyOnWriteArrayList, and ConcurrentLinkedQueue.

### Question 20
Reentrant Lock: Allows locking and unlocking in a flexible manner.
ReadWrite Lock: Separates read and write operations for better performance when many reads are expected.
Stamped Lock: Provides a locking mechanism that supports both read and write locks, including optimistic reads.

### Question 21
Future represents the result of an asynchronous computation.
CompletableFuture, an extension of Future, supports more complex operations like transformations and combinations of multiple asynchronous operations.
Methods in CompletableFuture include thenApply, thenCompose, thenCombine, exceptionally, and whenComplete.