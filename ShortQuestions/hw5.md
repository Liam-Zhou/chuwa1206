1.  Read: https://www.interviewbit.com/multithreading-interview-questions/#class-level-lock-vs-object-level-lock
2.  Explain what is volatile in java? (we also use it in Singleton)

    In Java, the **volatile** keyword is used to indicate that a variable's value may be modified by different threads concurrently. When a variable is declared as volatile, it ensures that any thread that reads the variable will see the most recent write to that variable by any other thread. Essentially, it establishes a happens-before relationship between the write to the volatile variable and subsequent reads of that variable.

3.  How to create a new thread?

    1.  **Extending the Thread class:**

    ```
    public class MyThread extends Thread {
        public void run() {
            // Code to be executed in the new thread
            System.out.println("This is a new thread.");
        }

        public static void main(String[] args) {
            MyThread thread = new MyThread();
            thread.start(); // Start the new thread
        }
    }

    ```

    2. **Implementing the Runnable interface:**

    ```
    public class MyRunnable implements Runnable {
        public void run() {
            // Code to be executed in the new thread
            System.out.println("This is a new thread.");
        }

        public static void main(String[] args) {
            MyRunnable myRunnable = new MyRunnable();
            Thread thread = new Thread(myRunnable);
            thread.start(); // Start the new thread
        }
    }

    ```

    3. **Implementing the Runnable interface:**

    ```
    public class MyCallable implements Callable<String> {
        @Override
        public String call() throws Exception {
        Thread.sleep(5000);
        return "Start new thread using Callable";
        }
    }
    ```

4.  Difference between Runnable and Callable?

    - runnable has no return;
    - callable has return;

5.  What is the difference between t.start() and t.run()?

    - t.start() starts a new thread to excute the task（run()）
    - t.run() excute the task in the current thread.

6.  Which way of creating threads is better: Thread class or Runnable interface?

    Using the Runnable interface is preferred over extending the Thread class because implementing the Runnable interface provides better flexibility, maintainability, and adherence to object-oriented design principles.

7.  What are the thread statuses?

    1. NEW: A thread that has been created but has not yet started is in the NEW state.
    2. RUNNABLE: A thread is in the RUNNABLE state if it has been started and is eligible to run, but the scheduler has not selected it to be the running thread.
    3. BLOCKED: A thread is in the BLOCKED state when it's waiting for a monitor lock to enter a synchronized block or method. It is waiting for another thread to release the lock.
    4. WAITING: A thread is in the WAITING state when it's waiting indefinitely for another thread to perform a particular action. It remains in this state until it's either interrupted or notified.
    5. TIMED_WAITING: Similar to WAITING, but the thread transitions to the TIMED_WAITING state when it's waiting for a specified period. It waits for another thread to perform a specific action within a certain time frame.
    6. TERMINATED: A thread is in the TERMINATED state if it has exited its run() method and has completed its execution.

8.  What is deadlock?

    Deadlock is a situation in concurrent programming where two or more threads are blocked forever, each waiting for the other to release a resource that it needs in order to proceed. In other words, deadlock occurs when two or more threads are stuck in a circular wait for resources that are held by each other.

9.  How do threads communicate each other?

    Threads communicate with each other through `shared memory` or `message passing`.

    - Shared Memory:
      Threads can communicate by sharing access to common variables or data structures in memory. Java provides synchronization mechanisms such as synchronized blocks, ReentrantLock, and ReadWriteLock for managing access to shared resources.

      syncronized: wait & notify & notifyAll

      ReentrantLock: condition.await() & condition.signal() & condition.signalAll()

    - Message Passing: Threads can communicate by sending messages to each other through predefined channels or message queues. In Java, message passing can be achieved using constructs like BlockingQueue, java.util.concurrent.ConcurrentLinkedQueue, or custom implementations using sockets or RMI (Remote Method Invocation).

10. What’s the difference between class lock and object lock?

    - Object locks are associated with individual instances of a class, while class locks are associated with the class itself.

    - Object locks are acquired by threads when they enter synchronized methods or blocks associated with a particular instance, while class locks are acquired when they enter synchronized static methods or static blocks associated with the class.

    - Acquiring an object lock does not prevent other threads from acquiring the lock of a different object of the same class. However, acquiring a class lock prevents other threads from entering synchronized static methods or static blocks of the class, regardless of the object instance.

11. What is join() method?

    In Java, the join() method is a method provided by the Thread class that allows one thread to wait for the completion of another thread before proceeding with its own execution. When a thread calls the join() method on another thread, it effectively blocks its own execution and waits until the other thread completes its execution or until a specified timeout period elapses.

12. What is yield() method?

    In Java, the yield() method is a static method of the Thread class that is used to suggest to the scheduler that the current thread is willing to yield its current execution to allow other threads to run. Essentially, it is a hint to the scheduler that the current thread is willing to pause its execution temporarily to give other threads a chance to execute.

13. What is ThreadPool? How many types of ThreadPool? What is the TaskQueue in ThreadPool?

    A `thread pool` is a managed collection of pre-initialized threads that are available for performing tasks concurrently. It's a design pattern used in concurrent programming to improve the efficiency of executing multiple tasks by reusing threads instead of creating new ones for each task.

    - **FixedThreadPool:** A fixed-size thread pool has a specified number of threads that remain active regardless of whether there are tasks to execute. Once all threads in the pool are occupied, additional tasks are queued until a thread becomes available.
    - **CachedThreadPool:** A cached thread pool dynamically adjusts its size based on the workload. It creates new threads as needed and reuses idle threads if available, terminating threads after a specified idle time.
    - **SingleThreadExecutor:** A single-threaded executor uses only one thread to execute tasks sequentially. It guarantees that tasks are executed in the order they are submitted and provides a simple way to serialize access to a shared resource

    In a thread pool, the task queue (also known as the work queue or task queue) is a data structure that holds the tasks submitted to the thread pool for execution. As threads in the pool become available, they retrieve tasks from the task queue and execute them.

14. Which Library is used to create ThreadPool? Which Interface provide main functions of thread-pool?

    `java.util.concurrent` package is used to create ThreadPool
    `ExecutorService` interface provides the main functions and operations for managing thread pools and executing tasks asynchronously.

15. How to submit a task to ThreadPool?

    - **submit(Runnable task):** Submits a Runnable task for execution and returns a Future representing the task's result.
    - **submit(Callable<T> task):** Submits a Callable task for execution and returns a Future representing the task's result.

16. What is the advantage of ThreadPool?

    Thread pools help streamline the management of concurrent tasks, improve system performance, enhance responsiveness, and promote efficient resource utilization in multi-threaded applications. They are a fundamental building block for developing scalable and responsive concurrent systems in Java and other programming languages.

17. Difference between shutdown() and shutdownNow() methods of executor
    `shutdown():` The shutdown() method initiates an orderly shutdown of the executor service. It allows previously submitted tasks to complete execution, including those that are queued in the task queue awaiting execution. After calling shutdown(), the executor service stops accepting new tasks, but it continues to execute tasks that were submitted before the shutdown was initiated. Once all tasks have completed execution, the executor service transitions to the terminated state, and its resources are released.

    `shutdownNow():` The shutdownNow() method attempts to stop all actively executing tasks and prevents queued tasks from being executed. It interrupts any running tasks by calling Thread.interrupt() on the underlying threads and returns a list of tasks that were queued but not started for execution. Unlike shutdown() method, shutdownNow() does not guarantee that all tasks will be stopped immediately. It makes a best-effort attempt to cancel tasks, but some tasks may still be running or may not respond to interruption. After calling shutdownNow(), the executor service stops accepting new tasks and attempts to halt the processing of waiting tasks.

18. What is Atomic classes? How many types of Atomic classes? Give me some code example of Atomic classes and its main methods. when to use it?

    Atomic classes are designed to support concurrent programming by ensuring that certain operations on shared variables are performed atomically, without the need for explicit synchronization using locks.

    - AtomicBoolean: Provides atomic operations on a boolean variable.
    - AtomicInteger: Provides atomic operations on an integer variable.
    - AtomicLong: Provides atomic operations on a long variable.
    - AtomicReference: Provides atomic operations on a reference variable.

      ```
      public class AtomicDemo {
          private static AtomicInteger atomicInteger = new AtomicInteger(1);
          public static void main(String[] args) {
              System.out.println(atomicInteger.getAndIncrement());
              System.out.println(atomicInteger.get());//count
          }

      }
      ```

19. What is the concurrent collections? Can you list some concurrent data structure (Thread-safe)?

    Concurrent collections are designed to be thread-safe and provide consistent behavior even when accessed concurrently by multiple threads.
    | Interface | Thread-safe collection |
    | --- | --- |
    | List | CopyOnWriteArrayList |
    | Map | ConcurrentHashMap |
    | Set | CopyOnWriteArraySet |
    | Queue | ArrayBlockingQueue / LinkedBlockingQueue |
    | Deque | LinkedBlockingDeque |

20. What kind of locks do you know? What is the advantage of each lock?

    - **ReentrantLock:** Supports the concept of reentrant synchronization, allowing a thread to lock the same lock multiple times without deadlocking itself.
    - **ReadWriteLock:** Allows multiple threads to read simultaneously, improving performance in scenarios where reads are more frequent than writes.
    - **StampedLock:** Extends the concept of a read-write lock with a more flexible API, including optimistic locking and converting between lock modes.

21. What is future and completableFuture? List some main methods of
    ComplertableFuture.

    - Future: A `Future` represents the result of an asynchronous computation. It has methods to check if the computation is done, wait for its completion, and retrieve the result.

    - CompletableFuture: A `CompletableFuture` is an extension of Future that provides a more powerful and flexible way to handle asynchronous computations. It allows you to chain multiple asynchronous operations, combine their results, and handle errors more easily.

      - **thenAccept(Consumer<? super T> action):** Returns a new CompletionStage that, when this stage completes normally, is executed with this stage's result as the argument to the supplied action.
      - **exceptionally(Function<Throwable,? extends T> fn):** Returns a new CompletableFuture that is completed when this CompletableFuture completes, with the result of the given function of the exception triggering this CompletableFuture's completion when it completes exceptionally; otherwise, if this CompletableFuture completes normally, then the returned CompletableFuture also completes normally with the same value.
      - **thenApplyAsync(Function<? super T,? extends U> fn):** Returns a new CompletionStage that, when this stage completes normally, is executed using this stage's default asynchronous execution facility, with this stage's result as the argument to the supplied function.
      - **anyOf(CompletableFuture<?>... cfs) / allOf(CompletableFuture<?>... cfs):** Returns a new CompletableFuture that is completed when any/all of the given CompletableFutures complete.

22. Type the code by your self and try to understand it. (package
    com.chuwa.tutorial.t08_multithreading)

23. Write a code to create 2 threads, one thread print 1,3,5,7,9, another thread print 2,4,6,8,10.

    a.

    ```
    public class OddEventPrinter {
    private static final Object monitor = new Object();
    private static int value = 1;

        public static void main(String[] args) {
            PrintRunnable runnable = new PrintRunnable();
            new Thread(runnable).start();
            new Thread(runnable).start();
        }

        static class PrintRunnable implements Runnable {
            @Override
            public void run() {
                synchronized (monitor) {
                    while (value <= 10) {
                        System.out.println(Thread.currentThread().getName() + ": " + value++);
                        monitor.notify();
                        try {
                            if (value < 11) {
                                monitor.wait();
                            }
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }

    }
    ```

        b.

    ```
    public class PrintRunnable implements Runnable {
        private final Lock lock = new ReentrantLock();
        private final Condition condition = lock.newCondition();
        private int value = 1;

        @Override
        public void run() {
            lock.lock();
            try {
                while (value <= 10) {
                    System.out.println(Thread.currentThread().getName() + ": " + value++);
                    condition.signal(); // Signal to other threads
                    if (value <= 10) {
                        condition.await(); // Release the lock and wait for signal
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
        public static void main(String[] args) {
            PrintRunnable runnable = new PrintRunnable();
            Thread thread1 = new Thread(runnable);
            Thread thread2 = new Thread(runnable);

            thread1.start();
            thread2.start();
        }

    }

    ```

24. create 3 threads, one thread ouput 1-10, one thread output 11-20, one thread output 21-22. threads run sequence is random.

        ```
        public class PrintNumber1 {
        private static int n = 1;

        public static void main(String[] args) {
            Thread t1 = new Thread(() -> printNumber());
            Thread t2 = new Thread(() -> printNumber());
            Thread t3 = new Thread(() -> printNumber());

            t1.start();
            t2.start();
            t3.start();
        }

        private static synchronized void printNumber() {
            int count = 10;
            while (count-- > 0) {
                System.out.println(Thread.currentThread().getName() + ": " + n++);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            PrintNumber1.class.notifyAll();
        }

    }

    ```

    ```

25. Completable future:

    Write a simple program that uses CompletableFuture to asynchronously get the sum and product of two integers, and print the results.

    ```
    public class CompletableFutureExample {
        public static void main(String[] args) {
                int a = 5;
                int b = 10;

                // Asynchronously calculate the sum
                CompletableFuture<Integer> sumFuture = CompletableFuture.supplyAsync(() -> {
                    System.out.println("Calculating the sum asynchronously...");
                    return a + b;
        });

            // Asynchronously calculate the product
            CompletableFuture<Integer> productFuture = CompletableFuture.supplyAsync(() -> {
                System.out.println("Calculating the product asynchronously...");
                return a * b;
            });

            // Combine the results when both futures complete
            CompletableFuture<Void> combinedFuture = sumFuture.thenAcceptBothAsync(productFuture,
                    (sum, product) -> {
                        System.out.println("Sum: " + sum);
                        System.out.println("Product: " + product);
                    });

            try {
                // Wait for both calculations to complete
                combinedFuture.get();
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }

        }
    ```
