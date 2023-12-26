# Homework 5



## 2 Explain what is volatile in Java



- `volatile` is used on variables that are shared between different threads.

- it is used to make sure each thread can read the correct data updated by other threads



## 3 How to create a new thread(also consider thread pool)?



- Extends the Thread class

- Implements Runnable Interface

- Implements Callable Interface

- ThreadPool: `Executors.newFixedThreadPool(n)`



## 4 Difference between Runnable and Callable?



- Runnable doesn't have any return value but Callable has a return value.



## 5 What is the difference between t.start() and t.run()?



- `t.start()` starts a new thread to execute the task

- `t.run()` executes the task in the current task

- `t.run()` is included in `t.start()`



## 6 Which way of creating threads is better: Thread class or Runnable interface?



- Personally, I think Runnable is better, it is more flexible regarding inheritance and working with thread pooling, but Thread is simpler



## 7 What are the thread statuses?



- new: create a new thread object, that hasn't started to execute yet

- runnable: in Java, runnable includes ready and running status
  
  - ready: after the thread is created, and another thread called the start method, the thread will be placed in the thread pool and waiting to be selected to execute
  
  - running: after being selected to execute, the status will turn into running

- blocked: being blocked by locks

- waiting: need to keep waiting before another thread notifies it or interrupt

- timed waiting: similar to waiting, but it will stop waiting after a certain amount of time

- terminated: indicates the thread has finished executing



## 8 What is deadlock?



- Deadlock can happen when different threads need to acquire multiple locks

- Thread A acquires lock A and waits for lock B, while Thread B acquires lock B and waits for lockA

- They will continue to wait and there is nothing they can do if they do not release the acquired lock



## 9 How do threads communicate with each other?



- Shared memory: ReentrantLock, atom classes

- Wait and Notify

- Concurrent Collections

- Thread signaling: e.g. join



## 10 What's the difference between class lock and object lock?



- **Class Lock**: In Java, every class has a unique lock usually called a class-level lock. These locks are achieved using the keyword `static synchronized` and can be used to make static data thread-safe. It is generally used when one wants to prevent multiple threads from entering a synchronized block

- **Object Lock**: In Java, every object has a unique lock, usually called an object-level lock. These locks are achieved using the keyword `synchronized` and can be used to protect non-static data. It is generally used when one wants to synchronize a non-static method or block so that only one thread will be able to execute the code block on a given instance of the class.



## 11 What is join() method?



- if the main thread called`t.join()` means the main thread will stop and wait for thread t to complete its task, and then the main thread will continue 



## 12 What is yield() method?



- It is used to hint the scheduler that the current thread is willing to yield its current use of a processor, allowing other threads of the same priority to be scheduled

- The actual behavior depends on the underlying OS's thread scheduler



## 13 What is ThreadPool? How many types of ThreadPool? What is the TaskQueue in ThreadPool?



- ThreadPool is a pool of worker threads that are available for executing tasks.

- Several types of thread pools implement the ExecuterService interface:
  
  - FixedThreadPool: fixed number of threads
  
  - CachedThreadPool: dynamically adjust the number of threads according to the workload of tasks
  
  - SingleThreadExecutor: a single-threaded pool

- The task queue in a ThreadPool is a queue where tasks (implementations of Runnable or Callable) are stored before being executed by the worker threads. When you submit a task to an ExecutorService, it is placed in the task queue until a worker thread becomes available to execute it.



## 14 Which Library is used to create ThreadPool? Which interface provides the main functions of the thread pool?



- ThreadPool is defined in the `java.util.concurrent` package. The primary interface for thread pool management is the `ExecutorService` interface.

- We can use the implementation of the `ExecutorService` interface such as `FixedThreadPool`. To create a thread pool, we can either use `Executors.newFixedThreadPool(numThreads)` or `new ThreadPoolExecutor()`



## 15 How to submit a task to ThreadPool?



- `executorService.submit(runnable)` or `execute(runnable)`

- tasks can be either `Runnable` task or `Callable<T>`task

## 16 What is the advantage of ThreadPool?



- controls the number of concurrent tasks

- reduce the overhead of thread creation and destruction -> improve performance

- allow tasks queuing for pending execution



## 17 Difference between shutdown() and shutdownNow() methods of executor



- `shutdown()` does not forcefully interrupt executing tasks, whereas `shutdownNow()` forcefully interrupts them.
  - `shutdown()` allows the executor to complete the tasks that are currently executing or waiting in the queue, while `shutdownNow()` attempts to stop all tasks immediately.
  - `shutdownNow()` returns a list of tasks that were waiting to be executed but did not get a chance to run due to the shutdown.



## 18 What is Atomic Class? How many types of Atomic classes? Give some code examples of Atomic classes and their main methods. When to use it?



- These classes are the no-lock, thread-safe version of primitive data types

- Some frequently used atomic classes are:
  
  - AtomicBoolean -> Boolean
  
  - AtomicInteger -> Integer
  
  - AtomicLong -> Long

- Suitable for concurrent calculator or counter



## 19 What are the concurrent collections? Can you list some concurrent data structures?



concurrent collections are the thread-safe version of Collections(e.g. ArrayList, HashMap, Set, Queue, etc.)

| Interface | Non-Thread-Safe       | Thread-safe                            |
| --------- | --------------------- | -------------------------------------- |
| List      | ArrayList             | CopyOnWriteArrayList                   |
| Map       | HashMap               | ConcurrentHashMap                      |
| Set       | HashSet/TreeSet       | CopyOnWriteArraySet                    |
| Queue     | ArrayDeque/LinkedList | ArrayBlockingQueue/LinkedBlockingQueue |
| Deque     | ArrayDeque/LinkedList | LinkedBlockingDeque                    |



## 20 What kind of locks do you know? What is the advantage of each lock?



- ReentrantLock
  
  - allows to be interrupted while waiting to acquire the lock
  
  - more flexible for thread communications

- ReadWriteLock
  
  - allows threads to read simultaneously when no writing happens -> improved performance when we have more read tasks

- StampedLock
  
  - allows reading simultaneously even if writing is possible -> improved performance further if we seldom need writing



## 21 What is the Future and completableFuture? List some main methods of CompletableFuture.



- A Future object represents an asynchronous result that we can get its value later in the future(when the asynchronous computation is done)

- CompletableFuture is the modified version of Future(also implements the Future interface) introduced in Java8, it allows the main thread not to keep waiting when trying to get the value of a Future object.

- CompletableFuture also provides a more extensive set of features for handling asynchronous computations, including composition, chaining, and combining multiple asynchronous tasks.

- Some of the methods of CompletableFuture
  
  - Create a CompletableFuture
    
    - `CompletableFuture.supplyAsync(Supplier<U> supplier)`: execute and get return value
    
    - `CompletableFuture.runAsync(Runnable runnable)`: execute without return value
  
  - Result Processing and Transformation
    
    - `CompletableFuture.thenApply(Function<T, U> fn)`: process return value and turn it into another type
    
    - `CompletableFuture.thenAccept(Consumer<T> action)`: process return value without a new CompletableFuture
    
    - `CompletableFuture.thenRun(Runnable action)`: no return value
  
  - Combination and Linking
    
    - `CompletableFuture.thenCompose(Function<T, CompletionStage<U>> fn)`: connect another Completable Future
    
    - `CompletableFuture.thenCombine(CompletionStage<U> other, BiFunction<T, U, V> fn)`: Combine the results of two CompletableFuture into a new CompletableFuture
  
  - Exception Handling
    
    - `CompletableFuture.exceptionally(Function<Throwable, T> fn)`: handle exception and return an alternative value
    
    - `CompletableFuture.handle(BiFunction<T, Throwable, U> fn)`: handle exception and allows access to results




