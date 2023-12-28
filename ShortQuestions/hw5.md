1. Explain what is volatile in java? (we also use it in Singleton)
   - The volatile keyword ensures that any thread reading the variable sees the most recent modification made by any other thread.
   - It ensures that operations on that variable are not reordered by the compiler or the CPU.
2. How to create a new thread(Please also consider Thread Pool approach)?
      - Thread Class
      ```java
       class MyThread extends Thread {
          public void run() {
             // Code to be executed in the new thread
             System.out.println("New thread is running.");
          }
       }
    
       // Create and start the thread
       MyThread myThread = new MyThread();
       myThread.start();
      ```
    - `Runnable` Interface
    ```java
        class MyRunnable implements Runnable {
           public void run() {
             // Code to be executed in the new thread
             System.out.println("New thread is running.");
           }
        }

        // Create a thread and start it
        Thread thread = new Thread(new MyRunnable());
        thread.start();

    ```
   - `Callable` Interface
   ```java
    import java.util.concurrent.Callable;
    import java.util.concurrent.ExecutorService;
    import java.util.concurrent.Executors;
    import java.util.concurrent.Future;

    public class MyCallable implements Callable<String> {
    @Override
    public String call() throws Exception {
       // Code to be executed in the new thread
       return "Result from the Callable thread.";
    }

    public static void main(String[] args) {
        // Create a thread pool with a single thread
        ExecutorService executorService = Executors.newSingleThreadExecutor();

        // Create an instance of MyCallable
        MyCallable myCallable = new MyCallable();

        // Submit the Callable task to the thread pool
        Future<String> future = executorService.submit(myCallable);

        try {
            // Get the result from the Callable task
            String result = future.get();
            System.out.println(result);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Shutdown the thread pool when done
            executorService.shutdown();
        }
    }
    }

   ```
   - `ExecutorService` and Thread Pool:
   ```java
    import java.util.concurrent.ExecutorService;
    import java.util.concurrent.Executors;
    
    class MyRunnableTask implements Runnable {
       @Override
       public void run() {
          // Code to be executed in the new thread
          System.out.println("Runnable task is running.");
       }
    }
    
    public class ThreadPoolExample {
       public static void main(String[] args) {
            // Create a fixed-size thread pool with 3 threads
            ExecutorService executorService = Executors.newFixedThreadPool(3);
    
            // Create instances of your Runnable tasks
            Runnable task1 = new MyRunnableTask();
            Runnable task2 = new MyRunnableTask();
            Runnable task3 = new MyRunnableTask();
    
            // Submit the Runnable tasks to the thread pool
            executorService.submit(task1);
            executorService.submit(task2);
            executorService.submit(task3);
    
            // Shutdown the thread pool when done
            executorService.shutdown();
        }
    }

   ```
3. Difference between Runnable and Callable?
   - Return Value:
     - Runnable: The run method of a Runnable does not return a value. It is designed for tasks that don't produce a result or whose result is not needed.
     - Callable: The call method of a Callable returns a result. It is designed for tasks that produce a result, and the result can be obtained through a Future object.
   - Exception Handling:
     - Runnable: The run method of a Runnable cannot throw checked exceptions directly. If a Runnable needs to handle checked exceptions, it must catch them within the run method.
     - Callable: The call method of a Callable can throw checked exceptions. These exceptions can be caught and handled by the calling code or propagated through the Future object.
   - Usage with Executors:
     - Runnable: Typically used with the Executor framework through the ExecutorService interface. You submit a Runnable to an ExecutorService using the execute method.
     - Callable: Also used with the Executor framework, but you submit a Callable to an ExecutorService using the submit method, which returns a Future object that can be used to obtain the result of the computation.
4. What is the difference between t.start() and t.run()?
   - t.start()
     - Create a new thread
     - The run method of the Runnable or Thread is executed concurrently in that new thread.
     
   - t.run()
     - Does not create a new thread. Instead, it executes the run method in the current thread.
5. Which way of creating threads is better: Thread class or Runnable interface?
   - Thread: separate the thread's behavior
   - Runnable: can have return value
6. What are the thread statuses?
   - New: A thread that has been created but has not yet started.
   - Runnable: Executing its task or waiting to be scheduled for execution. This is the state when the start() method has been called, and the thread is running or ready to run.
   - Blocked: It is waiting to acquire a monitor lock and cannot proceed until it successfully acquires the lock.
   - Waiting: A thread that is waiting indefinitely for another thread to perform a particular action.
   - Timed_Waiting: A thread that is waiting for another thread to perform a particular action for up to a specified waiting time.
   - Terminated: Once a thread completes its execution, it enters this state and cannot be started again.
7. What is deadlock?
   - Two or more threads are blocked indefinitely, each waiting for the other to release a resource.
8. How do threads communicate each other?
    - Syncronized: wait & notify & notifyAll
    - ReentrantLock: condition.await() & condition.signal() & condition.signalAll()
9. What’s the difference between class lock and object lock?
    - class-level lock: 
      - A method is declared as `static synchronized` in a class
      - If there are 100 instances of DemoClass at runtime, then only one thread will be able to execute demoMethod() in any one of the instances at a time, and all other instances will be locked for other threads
    - object-level lock:
      - Used to synchronize a `non-static method` or `non-static code block` such that only one thread will be able to execute the code block on a given instance of the class
10. What is join() method?
    - When a thread calls the join() method on another thread, the calling thread is suspended and waits for the specified thread to finish its execution.
11. what is yield() method
    - Temporarily pauses the currently executing thread and allows other threads to execute
    - Only a **hint** to the scheduler and no guarantee that the thread will yield the processor immediately.
    - go back to **Runnable**
12. What is ThreadPool? How many types of ThreadPool? What is the TaskQueue in
    ThreadPool?
    - A thread pool is a collection of worker threads that are managed by the system and can be used to execute tasks in parallel
    - [Six type of ThreadPool](https://juejin.cn/post/6890701585169678344)
      - FixedThreadPool: The number of threads remains constant. If a thread is terminated due to an exception or a failure during execution, a new thread will replace it
      - SingleThreadExecutor: A single-threaded executor that uses a single worker thread for task execution. Tasks are processed sequentially, one at a time.
      - CachedThreadPool: A dynamic thread pool that creates new threads as needed, but reuses previously constructed threads when available. Threads that have been idle for a specified timeout are terminated and removed from the pool.
      - ScheduledThreadPool: Provides support for scheduling tasks to run after a given delay or to execute periodically
      - SingleThreadScheduledExecutor: Creates a single-threaded executor that can schedule commands to run after a given delay, or to execute periodically.
      - ForkJoinPool: Uses a work-stealing algorithm to execute tasks in parallel 1. This algorithm allows idle threads to steal tasks from other threads that are still busy, which helps to balance the workload across all threads in the pool.  
      It is also useful for executing tasks that can be executed in parallel, such as matrix multiplication or image processing .
13. Which Library is used to create ThreadPool? Which Interface provide main
    functions of thread-pool?
    - java.util.concurrent package. The ThreadPoolExecutor class provides support for creating and managing thread pools in Java
    - The Executor and ExecutorService interfaces are used to work with different thread pool implementations in Java
14. How to submit a task to ThreadPool?
    ```java
    import java.util.concurrent.Callable;
    import java.util.concurrent.ExecutorService;
    import java.util.concurrent.Executors;
    import java.util.concurrent.Future;
    
    public class ThreadPoolExample {
    public static void main(String[] args) {
            // Create a ThreadPool with a fixed number of threads (e.g., 5)
            ExecutorService executor = Executors.newFixedThreadPool(5);
    
            // Submit a Runnable task
            executor.submit(new MyRunnable());
    
            // Submit a Callable task and obtain a Future object
            Future<String> futureResult = executor.submit(new MyCallable());
    
            // You can do other work while the task is running
    
            try {
                // Get the result of the Callable task using the Future object
                String result = futureResult.get();
                System.out.println("Callable task result: " + result);
            } catch (Exception e) {
                e.printStackTrace();
            }
    
            // Shutdown the ThreadPool when done
            executor.shutdown();
        }
    }
    
    class MyRunnable implements Runnable {
       @Override
       public void run() {
          System.out.println("Runnable task executed");
       }
    }
    
    class MyCallable implements Callable<String> {
       @Override
       public String call() throws Exception {
          System.out.println("Callable task executed");
          return "Task result";
       }
    }
    ```
    ```java
    import java.util.concurrent.ExecutorService;
    import java.util.concurrent.Executors;
    import java.util.concurrent.Future;
    
    public class ThreadPoolExample {
    public static void main(String[] args) {
            // Create a ThreadPool with a fixed number of threads (e.g., 5)
            ExecutorService executor = Executors.newFixedThreadPool(5);
    
            // Submit a Runnable task
            executor.submit(() -> {
                System.out.println("Runnable task executed");
            });
    
            // Submit a Callable task and obtain a Future object
            Future<String> futureResult = executor.submit(() -> {
                System.out.println("Callable task executed");
                return "Task result";
            });
    
            // You can do other work while the task is running
    
            try {
                // Get the result of the Callable task using the Future object
                String result = futureResult.get();
                System.out.println("Callable task result: " + result);
            } catch (Exception e) {
                e.printStackTrace();
            }
    
            // Shutdown the ThreadPool when done
            executor.shutdown();
        }
    }

    ```
15. What is the advantage of ThreadPool?
    - Improve overall system performance by avoiding the overhead of continuously creating and destroying threads.
    - Thread pools allow task queuing for pending execution, automatically manage thread lifecycles, and provide more flexible error handling
      mechanisms.
16. Difference between shutdown() and shutdownNow() methods of executor
    - shutdown(): cannot accept new task, but the already submitted tasks continue to run
    - shutdownNow(): cannot accept new task, and will try to cancel the already submitted tasks by interrupting the relevant threads. 
17. What is Atomic classes? How many types of Atomic classes? Give me some code
    example of Atomic classes and its main methods. when to use it?
    - Provide atomic operations for variables without the need for explicit synchronization. 
    - These classes are designed to be used in concurrent programming to ensure atomicity (indivisibility) of certain operations without the need for explicit locks.
    - 6 types
      - AtomicInteger
      - AtomicLong
      - AtomicBoolean
      - AtomicReference<V>
      - AtomicIntegerArray, AtomicLongArray, AtomicReferenceArray
    - simple for AtomicInteger
        ```java
            import java.util.concurrent.atomic.AtomicInteger;
            public class AtomicIntegerExample {
            public static void main(String[] args) {
               AtomicInteger atomicInt = new AtomicInteger(0);
    
               // Atomic increment
               int incrementedValue = atomicInt.incrementAndGet();
               System.out.println("Incremented Value: " + incrementedValue);
    
               // Atomic add
               atomicInt.addAndGet(5);
               System.out.println("After adding 5: " + atomicInt.get());
    
               // Atomic compare and set
               boolean success = atomicInt.compareAndSet(7, 10);
               System.out.println("Compare and Set Result: " + success + ", Current Value: " + atomicInt.get());
           }
         }


        ```
18. What is the concurrent collections? Can you list some concurrent data structure
    (Thread-safe)
    - Concurrent collections are thread-safe data structures that can be accessed by multiple threads concurrently without causing any data inconsistency or thread interference
    - ConcurrentHashMap, CopyOnWriteArrayList, ConcurrentLinkedDeque, ConcurrentLinkedQueue, CopyOnWriteArraySet
19. What kind of locks do you know? What is the advantage of each lock?
    - Synchronized: Provided by JVM, 可以实现class-level, method, non-method, code block的lock用法更灵活
    - [ReentranLock](https://www.51cto.com/article/707239.html): light than Synchronized, fix deadlock by catch error
    - ReadWriteLock: 
      - Only one Thread can write
      - When no Write Operation, Multiple threads allow Read Operation at the same time.
      - When the Read Operation happen, other threads are not allowed to write
    - StampedLock:
      - Introduces optimistic read locks, which can be more efficient in scenarios where reads vastly outnumber writes. 
      - It also provides the ability to conditionally acquire a write lock based on the current state.
      
20. What is future and completableFuture? List some main methods of
    ComplertableFuture.
    > Future and CompletableFuture are classes in Java that represent the result of an asynchronous computation.
    - Future: provides basic functionality for working with asynchronous tasks
    - CompletableFuture is a more powerful and flexible class introduced in Java 8 that extends and enhances the capabilities of Future.
        - supplyAsync(Supplier<U> supplier)
        - thenApply(Function<? super T,? extends U> fn)
        - thenAccept(Consumer<? super T> action)
