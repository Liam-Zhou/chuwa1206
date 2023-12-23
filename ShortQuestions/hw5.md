 ### Q1
- Class lock
  - keyword: 'static synchronized'
  - make static data thread-safe
  - generally used when one wants to prevent multiple threads from entering a synchronized block
- Object lock
  - keyword: 'synchronized'
  - protect non-static data
  - generally used when one wants to synchronize a non-static method
  - or block so that only the thread will be able to execute the code block on a given instance of the class
### Q2
- Volatile can be applied only to variables, not for class/method.
- To ensures that threads will read this variable from the main memory instead of their own local cache when apply volatile to a shared variables that is accessed in a multithreaded environment
### Q3
- Extends Thread Class
```
public class MyThread extends Thread {
    @Override
    public void run() {
        sout;
    }
}
Thread t = new MyThread();
t.start();
```
- Implement Runnable
```
public class MyRunnable implements Runnable {
    @Override
    public void run() {
        sout
    }
}
Thread t2 = new Thread(new MyRunnable());
t2.start();
```
- Implements Callable
```
public class MyCallable implements Callable<String> {
  @Override
  public String call() throws Exception {
    Thread.sleep(5000);
    return "Start new thread using Callable";
  }
}
Thread t3 = new Thread(MyCallable());
t3.start();
```
- Thread Pool
```
ExecutorService es = Executors.newFixedThreadPool(4);
for (int i = 0; i < 6; i ++) {
  es.submit(new Task("" + i));
}
es.shutdown();
```
### Q4
- Runnable has no return, it shows the result or throws an exception, but doesn't do both
- Callable has return, it throws the checked exception and returns the results
### Q5
- `t.start` starts a new thread to execute the task(run())
- `t.run` execute the task in the current thread
### Q6
Runnable interface is preferred b/c 
- it allows to extend any other class
- it promotes a cleaner separation btwn the thread's behavior
- it allows to share the same `Runnable` instance among multiple threads
### Q7
- New -> thread object has been created but hasn't used in the start method
- Runnable -> thread is running, or it's already to take task
- Blocked -> blocked at lock
- Waiting -> thread is waiting or take other actions(notify)
- Timed-waiting -> return after a certain time of waiting
- Terminated -> thread is terminated
### Q8
Deadlock is a state where multiple threads are blocked forever, each waiting for the other to release a resource
### Q9
- shared data -> all threads in the same program share the same mmemory space
- using thread control methods -> `suspend()`, `join()`, `resume()`
- using `wait()`, `notify()`, `notifyAll()`
### Q10
- Class lock
  - keyword: 'static synchronized'
  - make static data thread-safe
  - generally used when one wants to prevent multiple threads from entering a synchronized block
- Object lock
  - keyword: 'synchronized'
  - protect non-static data
  - generally used when one wants to synchronize a non-static method
  - or block so that only the thread will be able to execute the code block on a given instance of the class
### Q11
- `joint()` method causes the current thread to pause execution until the thread which has called joint() method is dead
- can be used to execute the threads sequentially or in some specific order
- some overloaded version
  - `join(long milliseconds)`
  - `join(long milliseconds, long nanoseconds)`
### Q12
- it pauses the currently executing thread temporarily for giving a chance to the remaining waiting threads of the same priority to execut
- if there is no waiting thread or all the waiting threads have a lower priority then the same thread will continue its execution
- when the yielded thread will get the chance for execution is decided by the thread scheduler whose behavior is vendor dependent
- yield method doesn't guarantee that the current thread will pause or stop but it guarantees that CUP will be relinquished by current Thread as a result of a call to Thread.yield() method in java
### Q13
- ThreadPool
  - It is a pool of worker threads that are created and managed to efficiently execute asynchronous tasks.
  - The primary goal is to reduce the overhead of creating and destroying threads for each task
  - A fixed number of threads are kept alive in the pool, and tasks are submitted to the pool for execution
- Type of ThreadPool
  - FixedThreadPool
    - A fixed number of threads in the pool
    - suitable when the number of tasks is known in advance
  - CachedThreadPool
    - dynamically adjusts the number of threads based on the workload
    - creates new threads if needed and reuses existing idle threads
  - ScheduledThreadPool
    - supports scheduling tasks to run periodically or after a delay
    - useful for tasks that need to be executed at fixed intervals
  - SingleThreadExecutor
    - a single thread in the pool
    - useful for tasks that need to be executed sequentially
- TaskQueue
  - A data structure that holds the tasks submitted to the ThreadPool
  - Once a task is submitted, it's placed in the queue and is picked up by an available thread for execution
  - like a buffer, allowing tasks to be decoupled from the thread
### Q14
- `java.util.concurrent`
- `ExecutorService`
### Q15
`executorService.submit(new MyTask());`
### Q16
- resource efficiency
  - efficiently manages a pool of resualbe threads, reducing the overhead associated w/ creating and destorying threads
- improved responsiveness
  - keeps threads alive,
  - ready to execute tasks
  - leading to reduced tasks start-up time
  - improved responsiveness
- tasks parallelism
- tasks prioritization
- prevention of resource exhaustion
- simplified thread management
- automatic thread recycling
- scalability
- tasks queueing
- thread safety
### Q17
- When `shutdown()` method is called on an executor, then the executor will not accept new tasks and it will wait for the currently executing tasks to finish
- When `shutdownNow()` method is called, it tries to interrupt the running threads and shutdown the executor immediately. However, there is no guarantee that all the running threads will be stopped at the same time
### Q18
- Atomic classes in java provide atomic operations on single variables, eliminating the need for explicit synchronization
- Types
  - `AtomicInteger`, `AtomicLong`, `AtomicBoolean`
```
public class AtomicDemo {
  private static AtomicInteger atomicInteger = 
                                       new AtomicInteger(1);
  public static void main (String[] args) {
    sout(atomicInteger.getAndIncrement());
  }
}
```
- Main method
  - `addAndGet()`
  - `incrementAndGet()`
  - `get()`
  - `set(int newValue)`
  - `compareAndSet(int expect, int update)`
- When to use
  - concurrency control
  - avoiding explicit locks
  - performance improvement
  - thread safety
### Q19
- provide support for concurrent programming, part of `java.util.concurrent`package
- offer thread-safe versions of common collection classes

| Interface | Thread-safe               |
|-----------|---------------------------|
| List      | CopyOnWriteArrayList      |
| Map       | ConcurrentHashMap         |
| Set       | CopyOnWriteArraySet       |
| Queue     | Linked/ArrayBlockingQueue |
| Deque     | LinkedBlockingDeque       |

### Q20
| Lock                            | Ad                                                                                            |
|---------------------------------|-----------------------------------------------------------------------------------------------|
| ReentrantLock                   | Allows threads to enter into the lock on a resource more than once                            |
| ReadWriteLock                   | Allows only one thread to write, but allows several threads to read once no thread is writing |
| StampedLock                     | Allows writing when reading                                                                   |
| Condition(associate with locks) | Allows threads to wait for a specific condition to be met before proceeding (signal)          |

### Q21
- Future 
  - represents the result of an asynchronous computation. It provides methods to check if the computation is complete and to retrieve the result
- CompletableFuture
  - an asynchronous programming tool introduced in java8
  - implements the future interfaces, providing powerful asynchronous capabilities
  - supports chaining operations for easy combination and management of multiple asynchronous tasks
  - non-blocking asynchronous tasks operations
- Main methods
  - Creating
    - `completableFurture.supplyAsync(Supplier<U> supplier)`: executes the given task asynchronously and returns the results
    - `completableFuture.runAsync(Runnable runnable)`: executes the given task asynchronously, w/o returning a value
  - Result processing
    - `completableFuture.thenApply(Function<T, U> fn)`: process the return value and transforms it into another type
    - `completableFuture.thenAccept(Consumer<T>, action)`: process then return value w/o returning a new completableFuture
    - `completableFutre.thenRun(Runnable action)`: ignores the return value and runs a runnable
  - Combination and linking
    - `completableFuture.thenCompose(Function<T, CompletionStage<U>> fn)`: links another cf and passes the result to the next task
    - `completableFuture.thenCombine(CompletionStage<U> other, BiFunction<T, U, V> fn)`: combines the results of two cf and returns a new cf
  - Exception handling
    - `completableFuture.exceptionally(Function<Throwable, T> fn)`: handles exceptions and returns an alternative value
    - `completableFuture.handle(BiFunction<T, Throwable, U> fn)`: handles exceptions while allowing access to the result value
### Q22
### Q23
### Q24
### Q25
