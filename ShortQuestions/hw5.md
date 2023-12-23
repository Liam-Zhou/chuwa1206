# 2. Explain what is volatile in java? (we also use it in Singleton)

when variables declared as volatile, it will force threads to access the variable from main memeory instead of their own local cache.
during the singleton, the volatile would prevent the instruction ordering.
When we create an object, new Singleton(), it consists of three steps

1. create memory
2. initalize the object
3. assgin the memory addrss to the var
   Without the volatile, the order could be 1, 3, 2, so when other threads could pass the instance == null check, and start using the instance
   but in reality, the instance has not been intialized completely and would throw error.

```java
public class Singleton {
    private static volatile Singleton instance;

    private Singleton() {}
    //only one thread can sucessfull create the singleton
    public static Singleton getInstance() {
        if (instance == null) { //double-checked locking
            synchronized (Singleton.class) {
                if (instance == null) {
                    instance = new Singleton(); // not atomic operation
                }
            }
        }
        return instance;
    }
}

```

# 3. How to create a new thread(Please also consider Thread Pool approach)?

```java
Thread t = new MyThread();
Thread t2 = new Thread(new MyRunnable());
ExecutorService executorService = Executors.newFixedThreadPool(1);
MyCallable myCallable = new MyCallable();
executorService.submit(myCallable);
```

# 4. Difference between Runnable and Callable?

callable return future object which could be used to communicate between two threads.
runnable has no return

# 5. What is the difference between t.start() and t.run()?

`t.start()` will start a new thread to execute the task
`t.run()` only call the run method of the runnable in the current thread

# 6. Which way of creating threads is better: Thread class or Runnable interface?

Runnable is better. Because it abstract the task itself from the thread and achieve the separation of concern

# 7. What are the thread statuses?

New: A new thread object has been created, but the start() method has not been called yet
Runnable: after creating the thread, the thread ar e int the runnable thrad pool, waiting to be select for thread
scheduling to obtain CPU usage rights.
Blocked: inidicaets that the thread is blocked by a lock
Waiting: threads is wairing for other threads to perform speciific actions
Timed Waiting: unlik waiting, the stat e an retur nafter a specified period of its own. like sleep()
Terminated: threads has completed its execution

# 8. What is deadlock?

two or more threads cannot proceed because each is waiting for the other to release a resource

# 9. How do threads communicate each other?

Shared Memory: Threads share the same memory space in the process
Synchoronization: like locks, semaphores, and barriers
Thread Signaling: wait() and notify()
Futures and Promises: provide a way for thread to asynchronously obtain the result of another thread

# 10. What’s the difference between class lock and object lock?

Object loks are associated with instances of a class and acqureing on does not prevent other threads from
acquiring locks on ther instances of the same class
class locks are associated with the entire class, acquiring on prevent the other threads from acuiqring lcok on any instances

# 11. What is join() method?

when calling t.join() on main thread, maint thread will stop and wait for thread t completes its task
main thread will continue after t finished its task

# 12. what is yield() method?

pase the currently executing thread, allowing other threads of the same priority to execute
yield() does not release the lock or monitor of the thread

# 13. What is ThreadPool? How many types of ThreadPool? What is the TaskQueue in ThreadPool?

A threadpool in java is a pool of worker threads that are managed by the JVM for executing tasks concurrently
It helps in managing the execution of tasks in a multithreaded environemnt
FixedThreadPool
CachedThreadPool: the number of threads can grow dynamically based on the demand.
SingleThreadExecutor: A single-threaded pool ensures that all tasks are executed sequentially in a single thread.
ScheduledThreadPool: scheduling tasks to be executed after a delay or periodically.
Taskqueue is data structure used by thread pools to hold tasks that are waiting to be executed

# 14. Which Library is used to create ThreadPool? Which Interface provide main functions of thread-pool?

It is in the java.util.concurrent package
ExecutorService interface provide higher-level replacement for the simple method of executor

# 15. How to submit a task to ThreadPool?

```java
ExecutorService executor = Executors.newFixedThreadPool(5);
Runnable myRunnable = () -> {
    System.out.println("hello")
}
executor.submit(myRunnable);
```

# 16. What is the advantage of ThreadPool?

It could help in managing the resing thread efficietly. Creating and destorying threads can be resource-intensive.
ThreadPool reduces this overhead by keep a pool of pre-created threads. It could also control the number of concurrent
running jobs.

# 17. Difference between shutdown() and shutdownNow() methods of executor

shutdown(): does not forcibly terminate the executing tasks
shutdownNow(): does not wait for the ongoing tasks to complete; it tries to stop them immediately

# 18. What is Atomic classes? How many types of Atomic classes? Give me some code example of Atomic classes and its main methods. when to use it?

it is a class that support atomic operations without the need for explicit synchronization. It could be used in multithreaded environements
to ensure that certain operatoins are executed atomically.
AtomicBoolean, AtomicInteger, AtomicLong, AtomicReference

```java
AtomicInteger atomicInt = new AtomicInteger(0);
int newValue = atomicInt.incrementAndGet();
```

# 19. What is the concurrent collections? Can you list some concurrent data structure (Thread-safe)

They are designed to be thread-safe, allowing mutiple threads to safely access and modify them concurrently
ConcurrentHashMap, CopyOnWriteArrayList, CopyOnWriteArraySet

# 20. What kind of locks do you know? What is the advantage of each lock?

ReentrantLock: alows the same thread to acquire the lock multiple times
ReadWriteLock: Separetes locks for read and write opearions. Multiple threads can acquire the read lock simultaneously,
but only one thread can acquire the write lock at a time

# 21. What is future and completableFuture? List some main methods of ComplertableFuture.

It provides a way to perform asynchronous programming
supports chaining operatoins for easy combintation and managemetn of multiple asynchronous tasks
non-block asynchronous operations

```java
CompletableFuture<Double> cf = CompletableFuture.supplyAsync(Main::fetchPrice);
cf.thenAccept((result) -> {
    System.out.prointln("price: " + result);
});
cf.exceptionally((e) -> {
    e.printStackTrace();
    return null;
})
// thenAccept()
// exceptionally()
// thenApplyAsync()
// anyOf() and allOf()
```
