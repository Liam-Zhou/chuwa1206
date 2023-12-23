# Q1
Read the blog.

# Q2
Volatile is a Java keyword that applies to variables to ensure visibility of changes and no reordering. It is used to achieve thread safety during multithread programming.

# Q3
```
public class MyThread extends Thread {
    @Override
    public void run() {
        System.out.println("start new thread using extends thread");
    }

    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        myThread.start();
    }
}
```
```
public class MyRunnable implements Runnable{
    @Override
    public void run() {
        System.out.println("Start new thread using Runnable");
    }

    public static void main(String[] args) {
        Thread thread = new Thread(new MyRunnable());
        thread.start();
    }
}
```
```
public class MyCallable implements Callable<String> {
    @Override
    public String call() throws Exception {
        Thread.sleep(5000);
        return "Start new thread using callable";
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        Callable<String> callableTask = new MyCallable();
        Future<String> future = executor.submit(callableTask);

        String res = future.get();

        System.out.println(res);

        executor.shutdown();
    }
}
```
```
public class MyThreadPool {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(4); // 4 threads
        fixedThreadPool.execute(() -> System.out.println("Task executed using runnable"));
        Future<String> future = fixedThreadPool.submit(() -> "Result from Callable");
        System.out.println(future.get());
        fixedThreadPool.shutdown();
    }
}
```

# Q4
Runnable does not have any return value, whereas Callable has return value.

# Q5
`t.start()` initiate a new thread execution and calls `run()` method inside the new thread. This means the code inside the `run()` method is executed in the new thread.
`t.run` does not start a new thread and simply execute `run()` method inside the current thread.

# Q6
Using `Runnable` is generally preferred because it separate task execution logic from thread management and `Runnable` can be handled by Java concurrent utility classes like `Executor`. However, extending `Thread` class is suitable for simpler scenarios or when need to manipulate thread-specific data.

# Q7
- NEW: When a new thread is created, it is in the new state.
- RUNNABLE: A thread that is ready to run is moved to a runnable state. For example, after calling `t.start()`. 
- BLOCKED: The thread will be in blocked state when it is trying to acquire a lock but currently the lock is acquired by the other thread. 
- WAITING: The thread will be in waiting state when it calls wait() method or join() method. It will move to the runnable state when other thread will notify or that thread will be terminated.
- TIMED_WAITING: A thread lies in a timed waiting state when it calls a method with a time-out parameter. A thread lies in this state until the timeout is completed or until a notification is received. 
- TERMINATED: The thread enters terminated state when either it exits normally, or there occurred some unusual error.

# Q8
A deadlock is a situation where a set of processes are blocked because each process is holding a resource and waiting for another resource acquired by some other process. A simple example would be thread `A` requires lock `a` which is hold by thread `B`, the thread `B` requires lock `b` which is hold by lock `A`. Thread `A` cannot release lock `b` until it gets lock `a` and `B` cannot release lock `a` until it gets lock `b`.

# Q9
Threads communicate with each other using 
- share objects and variables
- `wait()`, `notify()`, `notifyAll()`
- Blocking Queues
- Concurrent Collections
- CountDownLatch, CyclicBarrier, and Phaser
- Exchanger
- Pipes
-  Signals or Flags like `AtomicBoolean`

# Q10
- A class lock applies to all instances of the class. It is used to synchronize static methods or blocks within the class. Class lock blocks other threads from accessing any static methods of the class.
- An object lock only applies to this specific instance. It is used to synchronize instance methods or blocks within an instance. Different threads can simultaneously access the same synchronized instance methods on different instances of the same class.

# Q11
`join()` means the current thread waits for the other thread to die.

# Q12
`yield()` is a hint the scheduler that the current thread is willing to yield its current use of processor.

# Q13
A thread pool is a software design pattern for achieving concurrency of execution in a computer program.

There are fixed thread pool, cached thread pool, single thread executor, scheduled thread pool, work stealing pool.

The task queue in thread pool holds tasks that waits to be executed.

# Q14
`java.util.concurrent.Executors` handles the creation of thread pool. `java.util.concurrent.ExecutorService` is the interface that provids main functionalities to handle thread pool.

# Q15
Use `submit(Callable<T> task)`, `submit(Runnable task)`, and `execute(Runnable command)` to submit tasks. `execute(Runnable command)` does not return anything.

# Q16
The advantages of a thread pool are the following:
- Resource Management: Reduce overhead of creating and destroying threads for each task and limits the number of active threads.
- Improve Performance: faster task execution without waiting for thread creation and efficient task handling.
- Enhanced Scalability: handling high concurrency and adaptable to load.
- Task Queue Management: Organized Task Execution and custom task handling.
- Improved Stability: Avoids System Overload and Error Containment

# Q17
- `shutdown()` initiates an orderly shutdown in which previously submitted tasks are executed, but no new tasks will be accepted.
- `shutdownNow()` attempts to stop all actively executing tasks, halts the processing of waiting tasks, and returns a list of the tasks that were awaiting execution.

# Q18
Atomic classes provide a way to perform atomic operations on single variables without using synchronization. It ensures the variable is updated safely in a concurrent environment.

Types of Atomic Classes are the following:
- Atomic Integer Types: `AtomicInteger`, `AtomicLong`, `AtomicIntegerArray`, `AtomicLongArray`
- Atomic Reference Types: `AtomicReference`, `AtomicReferenceArray`, `AtomicMarkableReference`, `AtomicStampedReference`
- Atomic Boolean Type: `AtomicBoolean`
- Atomic Update Types: `AtomicIntegerFieldUpdater`, `AtomicLongFieldUpdater`, `AtomicReferenceFieldUpdater`

Code Example:
```
import java.util.concurrent.atomic.AtomicInteger;

public class AtomicIntegerExample {
    public static void main(String[] args) {
        AtomicInteger atomicInt = new AtomicInteger(0);

        int incrementedValue = atomicInt.incrementAndGet();
        System.out.println("Incremented: " + incrementedValue);

        int addedValue = atomicInt.addAndGet(3);
        System.out.println("Added: " + addedValue);

        boolean updated = atomicInt.compareAndSet(4, 10);
        System.out.println("Updated: " + updated);
        System.out.println("Current Value: " + atomicInt.get());
    }
}
```

Use Atomic classes in the following scenarios:
- Concurrent Updates to primitives
- avoiding synchronization
- lock-free programming
- implementing counters or flags

# Q19
Concurrent collections are thread-safe version of the standard collections designed for use in multithreaded contexts. They provide improved performance through non-blocking algorithms and finer grained locking, making theme more scalable under concurrent access compared to their synchronized counterparts.

Some concurrent data structures are ConcurrentHashMap, ConcurrentSkipListMap, CopyOnWriteArrayList, ConcurrentHashMap, CopyOnWriteArraySet, ArrayBlockingQueue, LinkedBlockingQueue.

# Q20
- Intrinsic Locks (Using `synchronized` keyword): simple to use, automatic lock management, reentrancy
- Reentrant Locks: lock interruptibly, timed lock attempts, fairness policy, better condition support
- ReadWrite Locks: Concurrency in reads, improve performance when reading is more frequent than writing
- Stamped Lock: versatility as it provides read, write, and optimistic reading

# Q21
- `Future` represents the result of an asynchronous computation. However, the method `get` that obtains the result is blocking and checking if the result is available using `isDone` is also inefficient.
- `CompletableFuture` is also a asynchronous programming tool. It implements `Future` and provides more functionalities. It supports chaining operations for easy combination and management of multiple async tasks. It is non-blocking.

# Q22

# Q23
Checkout `/CodingQuestions/12.23/OddEvenPrinter` and `/CodingQuestions/12.23/ReentrantLockOddEvenPrinter`.

# Q24
Checkout `/CodingQuestions/12.23/PrintNumber`

# Q25
Checkout `/CodingQuestions/12.23/CompletableFutureA` and `/CodingQuestions/12.23/ApiIntegration`