1. Read: https://www.interviewbit.com/multithreading-interview-questions/#class-level-lock-vs-object-level-lock

2. Explain what is volatile in java? (we also use it in Singleton)

   volatile is used to indicate that variable's value may be changed by multiple threads simultaneously. When a viriable is volatile, it ensures that all reads and writes to that volatile are done directly from and to the main memory. This prevents any thread from caching the variable's value and ensure that the latest value is always visible to all threads.

   ```java
   public class Singleton {
       private static volatile Singleton instance;
   
       private Singleton() {
       }
   
       public static Singleton getInstance() {
           if (instance == null) {
               synchronized (Singleton.class) {
                   if (instance == null) {
                       instance = new Singleton();
                   }
               }
           }
           return instance;
       }
   }
   ```

   

3. How to create a new thread(Please also consider Thread Pool approach)?

   There are usually 3 ways to create a new thread

   - extend thread class
   - implement runnable interface
   - thread pool

   Extend thread class:

   ```java
   class MyThread extends Thread {
     public void run(){
       
     }
   }
   
   public class Main {
     public static void main(String[] args) {
       MyThread my = new Mythread();
       my.start();
     }
   }
   ```

   Implement runnable interface:

   ```java
   class MyThread implements Runnable {
     public void run(){
       
     }
   }
   
   public class Main {
     public static void main(String[] args) {
       MyThread my = new Mythread();
       my.start();
     }
   }
   ```

   Thread pool:

   ```java
   class MyThread implements Runnable {
     public void run(){
       
     }
   }
   public class Main {
     public static void main(String[] args) {
       ExecutorService ex = Executors.newFixedThreadPool(5);
       for(int i = 0; i < 10; i++){
         ex.submit(new MyThread());
       }
       ex.shutdown();
     }
   }
   
   ```

   

4. Difference between Runnable and Callable?

   Runnable does not have return, Callable has

   Runnable's run function cannot throw checked exceptions, which should be caught within the run method

   Callable's call is allowed to throw

5. What is the difference between t.start() and t.run()?

   t.start() initiates a new thread of execution, and the run() is invoked in the new thread.

   t.run() does not start a new thread, it just invokes the run method on the current thread. this is not used for multithreading purposes.

6. Which way of creating threads is better: Thread class or Runnable interface?

   Runnable is better.

   - Java supports single inheritance, if you extend thread, the class cannot extend any other class.
   - runnable allows user too separate the code that needs to be executed in a separate thread from the thread itself
   - runnable allows user to share the same instance among multiple threads

7. What are the thread statuses?

   - NEW: created but not started
   - RUNNABLE: ready to run
   - BLOCKED: waiting for a monitor lock to enter a shynchronized block or method
   - WAITING: a thread that is waiting for a nother thread
   - TIMED_WAITING: a thread that is waiting for a nother thread to perform a particular action in an amount of time
   - TERMINATED: a thread that has exited

8. What is deadlock?

   a situation when 2 or more threads are blocked forever, each waiting for the other to release a lock

9. How do threads communicate each other?

   - shared data. 
   - wait and notify. Threads can use wait and notify methods to synchronize and communicate
   - countdown latch is a synchronization aid that allows threads to wait until a countdown reaches zero
   - blocking queue, one thread can put an item into a queue and another thread can take it

10. What’s the difference between class lock and object lock?

    class lock is associated with the class itself, not the instance of the class. When a thread acquires a class lock, it prevents other threads from executing synchronized static methods of the same class.

11. What is join() method?

    The `join()` method in Java is a method provided by the `Thread` class that allows one thread to wait for the completion of another thread, often used where the main thread needs to wait for other threads to finish.

12. what is yield() method

    When a thread calls `Thread.yield()`, it essentially indicates to the thread scheduler that the current thread is willing to yield its current use of the processor. This method is a hint to the scheduler, suggesting that it can give up the current thread's time slice to allow other threads to run.

13. What is ThreadPool? How many types of ThreadPool? What is the TaskQueue in ThreadPool?

    A ThreadPool is a pool of pre-initialized threads that are ready to perform tasks. A ThreadPool efficiently manages a pool of worker threads, which can be reused for multiple tasks. 

    - **FixedThreadPool**: In a FixedThreadPool, a fixed number of worker threads are created and maintained in the pool. If a task is submitted, and all threads are busy, it will wait in the queue until a thread becomes available.
    - **CachedThreadPool**: In a CachedThreadPool, threads are created on demand and reused if available. If a thread remains idle for a certain period, it may be terminated to reduce the number of active threads.
    - **SingleThreadExecutor**：In a SingleThreadExecutor, only one thread is created. It guarantees that tasks are executed sequentially in the order they are submitted.
    - **ScheduledThreadPool**： A ScheduledThreadPool is designed for scheduling tasks to run at a certain time or with a fixed interval.

14. Which Library is used to create ThreadPool? Which Interface provide main functions of thread-pool?

    java.util.concurrent

    ExecutorService

15. How to submit a task to ThreadPool?

    use .submit function

    ```java
    Future<?> future = executor.submit(myRunnableTask);
    ```

    

16. What is the advantage of ThreadPool?

    - Threadpool maintain a pool of pre-initialized threads, reduce the source that used for create and destroy task
    - allows tasks to be excuted concurrently
    - can control level of concurrency

17. Difference between shutdown() and shutdownNow() methods of executor

    The `shutdown()` method initiates an orderly shutdown of the thread pool. It allows previously submitted tasks to complete but does not accept any new tasks. After calling `shutdown()`, the `ExecutorService` will not accept any new tasks for execution.

    The `shutdownNow()` method attempts to stop all actively executing tasks, halts the processing of waiting tasks, and returns a list of the tasks that were waiting to be executed.

18. What is Atomic classes? How many types of Atomic classes? Give me some code example of Atomic classes and its main methods. when to use it?

    Atomic classes are designed to be used in multithreaded environments where multiple threads may access and modify shared variables concurrently.

    1. **AtomicBoolean:**: Provides atomic operations for `boolean` variables.

    2. **AtomicInteger:**: Provides atomic operations for `int` variables.

    3. **AtomicLong:**: Provides atomic operations for `long` variables.

    4. **AtomicReference:**: Provides atomic operations for reference variables (objects).

       ```java
       import java.util.concurrent.atomic.AtomicBoolean;
       
       public class AtomicBooleanExample {
           public static void main(String[] args) {
               AtomicBoolean atomicBoolean = new AtomicBoolean(true);
       
               // Atomic set and get
               boolean previousValue = atomicBoolean.getAndSet(false);
               System.out.println("Previous Value: " + previousValue);
               System.out.println("Current Value: " + atomicBoolean.get());
       
               // Atomic compare and set
               boolean updated = atomicBoolean.compareAndSet(false, true);
               System.out.println("Update Successful: " + updated);
           }
       }
       
       ```

       ```java
       import java.util.concurrent.atomic.AtomicInteger;
       
       public class AtomicIntegerExample {
           public static void main(String[] args) {
               AtomicInteger atomicInteger = new AtomicInteger(0);
       
               // Atomic increment and decrement
               int incrementedValue = atomicInteger.incrementAndGet();
               System.out.println("Incremented Value: " + incrementedValue);
       
               int decrementedValue = atomicInteger.decrementAndGet();
               System.out.println("Decremented Value: " + decrementedValue);
       
               // Atomic add and subtract
               atomicInteger.addAndGet(5);
               System.out.println("Updated Value after Add: " + atomicInteger.get());
       
               atomicInteger.subtractAndGet(2);
               System.out.println("Updated Value after Subtract: " + atomicInteger.get());
           }
       }
       
       ```

       ```java
       import java.util.concurrent.atomic.AtomicReference;
       
       class Data {
           private String value;
       
           public Data(String value) {
               this.value = value;
           }
       
           public String getValue() {
               return value;
           }
       
           public void setValue(String value) {
               this.value = value;
           }
       }
       
       public class AtomicReferenceExample {
           public static void main(String[] args) {
               AtomicReference<Data> atomicReference = new AtomicReference<>(new Data("Initial Value"));
       
               // Atomic get and set
               Data previousData = atomicReference.getAndSet(new Data("Updated Value"));
               System.out.println("Previous Value: " + previousData.getValue());
               System.out.println("Current Value: " + atomicReference.get().getValue());
       
               // Atomic compare and set
               boolean updated = atomicReference.compareAndSet(new Data("Updated Value"), new Data("New Value"));
               System.out.println("Update Successful: " + updated);
               System.out.println("Current Value after CompareAndSet: " + atomicReference.get().getValue());
           }
       }
       
       ```

       

19. What is the concurrent collections? Can you list some concurrent data structure (Thread-safe)

    Concurrent collections in Java are data structures designed to be safely used by multiple threads concurrently without the need for external synchronization.

    - ConcurrentHashMap
    - CopyOnWriteArrayList
    - CopyOnWriteArraySet
    - ConcurrentLinkedQueue
    - BlockingQueue
    - ConcurrentSkipListMap
    - ConcurrentSkipListSet
    - LinkedBlockingDeque

20. What kind of locks do you know? What is the advantage of each lock?

    - ReentrantLock: ReentrantLock provides more explicit control over the locking and unlocking of resources compared to implicit locking using synchronized blocks or methods. syncronized uses wait, notify and notifyAll, ReentrantLock uses condition.await, condition.signal and condition.signalAll.

    - ReadWriteLock: only allows multile threads to read data concurrently, only one thread can write. This can significantly improve performance in scenarios where reads are more frequent than writes.

    - StampedLock: a thread can try to read or write without acquireing a lock and validate if the operation can proceed. lead to improved performance in read-dominated scenarios

      

21. What is future and completableFuture? List some main methods of ComplertableFuture.

    The `Future` interface represents the result of an asynchronous computation. It provides methods to check if the computation is complete, retrieve the result (blocking if necessary), and cancel the computation.

    `CompletableFuture` is an extension of `Future` that also provides a set of powerful and composable methods for handling asynchronous computations in a more flexible manner. It supports a wide range of operations, including chaining, combining, and composing asynchronous tasks.

    - thenAccept: process successful resut
    - exceptionally: process unsuccessful result
    - thenApplyAsync: asynchronously using the default executor and returns a new `CompletableFuture`
    - anyOf, allOf: concurrently more completableFuture

23. Write a code to create 2 threads, one thread print 1,3,5,7,9, another thread print 

2,4,6,8,10. (solution is in 
com.chuwa.tutorial.t08_multithreading.c05_waitNotify.OddEventPrinter)
a. One solution use synchronized and wait notify 
b. One solution use ReentrantLock and await, signal

24. create 3 threads, one thread ouput 1-10, one thread output 11-20, one thread 

output 21-22. threads run sequence is random. (solution is in 
com.chuwa.exercise.t08_multithreading.PrintNumber1)
c. Thread-0: 1
Thread-1: 2
Thread-0: 3
Thread-1: 4
Thread-0: 5
Thread-1: 6
Thread-0: 7
Thread-1: 8
Thread-0: 9
Thread-1: 10
Process finished with exit code 0
1
2
3
4
5
6
7
8
9
10
11
12
a. Thread-0: 1
Thread-0: 2
Thread-0: 3
Thread-0: 4
Thread-0: 5
Thread-0: 6
Thread-0: 7
Thread-0: 8
Thread-0: 9
Thread-0: 10
Thread-2: 11
Thread-2: 12
Thread-2: 13
1
2
3
4
5
6
7
8
9
10
11
12
13
No. 2 / 4

25. completable future:

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
iii.  可以用fake api https://jsonplaceholder.typicode.com/
c.  Homework 3: For Homework 2, implement exception handling. If an 
exception occurs during any API call, return a default value and log the 
exception information.
Thread-2: 14
Thread-2: 15
Thread-2: 16
Thread-2: 17
Thread-2: 18
Thread-2: 19
Thread-2: 20
Thread-1: 21
Thread-1: 22
Thread-1: 23
Thread-1: 24
Thread-1: 25
Thread-1: 26
Thread-1: 27
Thread-1: 28
Thread-1: 29
Thread-1: 30
14
15
16
17
18
19
20
21
22
23
24
25
26
27
28
29
30
No. 3 / 4


No. 4 / 4