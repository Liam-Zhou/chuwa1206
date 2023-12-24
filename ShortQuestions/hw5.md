# hw5

1. Read: <https://www.interviewbit.com/multithreading-interview-questions/#class-level-lock-vs-object-level-lock>

2. Explain what is volatile in java? (we also use it in Singleton)

- `volatile` is a key word in java, which can only be used for variable. when we use volatile for a variable that variable will have following property
  - visibility: `volatile` guarantees the change of the variable will see by the other thread immediatly.
  - it will tell jvm does not do the memory reordering for that variable.
  - no caching: `volatile` will ensure that thread read and write from the main memory instead of cach.
  - `volatile` is not atomicity.
  
3. How to create a new thread(Please also consider Thread Pool approach)?

   1. extern `Thread` class
   2. implement `runnable` interface
      - *can also use anonymous class way*
   3. use Callable and Future
   4. new Thread pool from Executors.

4. Difference between Runnable and Callable?
   1. `runnbale`: has `run()` method does not have the return value, and it not declare any checked exceptions, if we need deal with exceptions, use try catch in `run()` method.
   2. `callable`: can have return value and has declared checked exceptions.
5. What is the difference between t.start() and t.run()?
   1. `start()` create a thread, then call the run method.
   2. `run()` just can be considered as call the run method.
6. Which way of creating threads is better: Thread class or Runnable interface?
   1. in general speaking, Runnable is betterway, since java only allow single extend.
   2. but it is still depends. Generally, we should use the runnable interface if we want to separate the logic of the thread from its execution and share the same task among multiple threads. The thread class is preferable if we want to customize behavior and properties of the thread, access its methods and attributes directly, and create a new thread for each task. There are other alternatives for creating and managing threads in Java, such as executors, futures, callables, and parallel streams.
7. What are the thread statuses?
   1. new
   2. runnable
   3. blocked
   4. waiting
   6. terminated.
8. What is deadlock?
   1. thinking of `Thread A` holding `resource A` but requesting `resource b`, `Thread B` holding `resource B` but requesting `resource A`.
   2. four factors that is a must when deallock happen, we can deal any of them to resovle deadlock issue. 
      1. mutual exclusion
      2. hold and wait
      3. no preemption
      4. circular wait.
   
9.  How do threads communicate each other?
    1.  shared data but take care of race condition.
    2.  Inter thread communication. such as `wait()`, `notify()`, `notifyAll()`
10. What’s the difference between class lock and object lock?
    1.  class lock is the lock of the clock, it ensure that only one thread can holding in the critique section.
    2.  object level lock is associated with instance of the class, it allow more than one instances of the same class to be in the critical section
    3.  when a method is static with sychorized. class level lock, but non-static could be object level.
11. What is join() method?
    1.  whenever how is running join, that thread will be waiting for the target thread.
12. what is yield() method
    1.  `yield()` is a static method in `thread`. it just tell the jvm scheduler the calling thread are willing to yeild to other thread which have the same priority, but it is not guaranted that yield will happen. 

13. What is ThreadPool? How many types of ThreadPool? What is the TaskQueue in ThreadPool?
    1.  `ThreadPool` provide a way to manage and reuse threads, it is kind like IOC, we just thread pool will take care of new thread or managing thread for us. 
        1.  FixedThreadPool
        2.  CachedThreadPool
        3.  SingleThreadExecutor
        4.  ScheduledThreadPool
    2.  `taksQueue` is a queue which is the task linedup to be processed. thinking of message queue.
    
14. Which Library is used to create ThreadPool? Which Interface provide main functions of thread-pool?
    1.  `util.concurrent`
    2.  Excutor or executorService.
15. How to submit a task to ThreadPool?
    1.  usually call the submit method.

16. What is the advantage of ThreadPool?
    1.  thread reuse, so it can improve performance.
    2.  resource management.


17. Difference between shutdown() and shutdownNow() methods of executor
    1.  shotdown initiates an order shutdown, which can allow already submitted tasks to be competed, but shotdownnow will try to shotdown the taks immediately.
    2.  shotdown return void, but shutdownNow return a list of tasks that could not be terminated. 
18. What is Atomic classes? How many types of Atomic classes? Give me some code example of Atomic classes and its main methods. when to use it?

- AtomicInteger
  
```java
AtomicInteger atomicInt = new AtomicInteger(0);
int result = atomicInt.incrementAndGet();
```

- AtomicLong
- atomicBoolean
- we need use antomic classes in the condition the multithreading and want to make thread safe for non atomic operations or data structers.
  
19.  What is the concurrent collections? Can you list some concurrent data structure (Thread-safe)

     - concurrent collections are collections in java but just the `thread safe version`.
     - concurrentHashMap
     - CopyOnWriteArrayList
     - ConcurrenLinkedQueue;

20. What kind of locks do you know? What is the advantage of each lock?
    Certainly! Here's a table summarizing different types of locks in Java along with their advantages:

| Lock Type                   | Advantages                                                                                                                                                                                                                                   |
|-----------------------------|---------------------------------------------------------------------------------------------------
| ReentrantLock                | - Provides flexibility and power for locking. <br> - Supports features like fairness and fine-grained control over locking and unlocking.                                                                                                |
| ReadWriteLock (ReentrantReadWriteLock) | - Allows multiple threads to read concurrently for improved read performance. <br> - Supports exclusive write access, ensuring a single thread for writing.                                                                          |
| StampedLock                 | - Extends capabilities of `ReentrantReadWriteLock`. <br> - Supports optimistic locking for potentially faster reads without acquiring a full lock.                                                                                         |
| LockSupport                 | - Provides lower-level thread synchronization mechanisms for blocking and unblocking threads. <br> - Useful in building custom synchronization constructs.                                                                            |
| Condition (associated with Lock)       | - Allows threads to wait for specific conditions to be met before proceeding. <br> - Useful for more complex synchronization requirements.|

    
1.  What is future and completableFuture? List some main methods of ComplertableFuture.
    - future can get the processing result synchronized. but `get()` method is blocking, kind of like asynchronized. completableFuture is the better version of future. in `completableFuture` we can easly to manage the whole procudure. It allows you to chain together multiple asynchronous operations and provides a variety of methods to combine and manipulate these operations.
    - CompletableFuture.supplyAsync()
    - whenComplete()
    - Future.thenApply()
    - thenAccept()
    - thenCombine()

2.  Type the code by your self and try to understand it. (package com.chuwa.tutorial.t08_multithreading)

    **see coding_hw5 folder**
    
3.  Write a code to create 2 threads, one thread print 1,3,5,7,9, another thread print
2,4,6,8,10. (solution is in
com.chuwa.tutorial.t08_multithreading.c05_waitNotify.OddEventPrinter)

    a. One solution use synchronized and wait notify

    b. One solution use ReentrantLock and await, signal
        **see coding_hw5 folder**

1. create 3 threads, one thread ouput 1-10, one thread output 11-20, one thread
output 21-22. threads run sequence is random. (solution is in com.chuwa.exercise.t08_multithreading.PrintNumber1)
    **see coding_hw5 folder**
1. completable future:
   
    a. Homework 1: Write a simple program that uses CompletableFuture to
    asynchronously get the sum and product of two integers, and print the
    results.

    b. Homework 2: Assume there is an online store that needs to fetch data
    from three APIs: products, reviews, and inventory. Use
    CompletableFuture to implement this scenario and merge the fetched
    data for further processing. (需要找public api去模拟，)

        i.  Sign In to Developer.BestBuy.com
        ii. Best Buy Developer API Documentation
            (bestbuyapis.github.io)
        iii.  可以用fake api <https://jsonplaceholder.typicode.com/>

    c.  Homework 3: For Homework 2, implement exception handling. If an
    exception occurs during any API call, return a default value and log the
    exception information.
