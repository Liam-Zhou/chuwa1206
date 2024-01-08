# HW4

## Q2. volatile

An object declared by 'volatile' will be immediately visible to all thread after it is changed. It contibutes to thread safe in many cases for example, double check lock singleton implementation.



## Q3. How to create a new thread(Please also consider Thread Pool approach)?

1. extends threads class
2. implements runnable and pass to Thread constructor
3. implement callable and pass to Thread constructor
4. create threadexecutor and submit runnable or callable to it



## Q4. Difference between Runnable and Callable

runnable do not have return value and callable can



## Q5. What is the difference between t.start() and t.run()?

t.start会创建并run，t.run会直接把t放在当前线程run，不会创建新的线程.



## Q6. Which way of creating threads is better: Thread class or Runnable interface?

Runnable interface is better because it allows you to define a new class for your task. In addition your runnable class can extends other class while your thread class can only extends Thread.



## Q7. What are the thread statuses?

1. 初始化（new）：new了一个Thread object但还没run
2. 运行（runnable）：就绪（ready）和运行中（running）统称为“运行”状态。就绪状态为调用start后等待cpu调度
3. 阻塞（blocking）：线程阻塞于锁
4. 等待（waiting）：等待其他线程做出一些动作（通知或中断）
5. 超时等待（Timed_waiting）：不同于waiting，等待结束后可以自行返回，或者被通知提前返回。而waiting状态没有其他动作打断就会一直waiting
6. 终止（Teminated）



## Q8. What is deadlock?

when there are two resource, and two thread both require both to run. Each thread lcok one of them and is waiting for the other to be released. That caused a deadlock.



## Q9. How do threads communicate each other?

- wait() and notify()
- use shared data with synchronized and volatile keywords to protect safety



## Q10. What’s the difference between class lock and object lock?

object lock: synchronized class method or field

class lock: synchronized static

object lock means the field or method from a same object can only be accessed by one thread at a time. Class lock means this field or methd from all object of this class can only be accessed by ...



## Q11. What is join() method?

t.join() means the current thread wait for t to terminate.



## Q12. what is yield() method

yield method suggest JVM that current thread is willing to give the timepiece to other thread with same priority.



## Q13. What is ThreadPool? How many types of ThreadPool? What is the TaskQueue in ThreadPool?
ThreadPool is a useful strategy to manage threads in multithreading which assign submitted tasks tp certain amount of threads. It can control the total number of thread, reduce the cost of creating and deleting threads, also queue the waiting threads.

- FixedThreadpool: fixed number of thread
- CachedThreadPool: Flexible number of thread
- SingleThreadExecutor: only one thread can be run at a time

A task queue in a thread pool is a data structure that holds a collection of tasks or jobs that need to be executed concurrently by a pool of worker threads.  



## Q14. Which Library is used to create ThreadPool? Which Interface provide main functions of thread-pool?
java.util.concurrent

ExecutorService executor = Executors.newFixedThreadPool(10);



## Q15. How to submit a task to ThreadPool?

executor.submit(runnable)



## Q16. What is the advantage of ThreadPool?

- reuse thread, reduce the cost of creating and deleting threads.
- automatically manage the lifecycle of threads
- Control the number of concurrent task by setting pool size
- can queue the waiting tasks
- can return future object to get return value
- can handle execption



## Q17. Difference between shutdown() and shutdownNow() methods of executor

shutdown will wait for current thread to finish their work, but will not accept new tasks.

shutdownnow will interrupt all running tasks



## Q18. What is Atomic classes? How many types of Atomic classes? Give me some code example of Atomic classes and its main methods. when to use it?
atomic class realize thread safe without lock. Usually used in adder and counter

- AtomicBoolean
- AtomicInteger
- AtomicLong



- addAndGet(int delta)

- incrementAndGet()

- getAndSet(int newValue)
- getAndIncrement()



## Q19. What is the concurrent collections? Can you list some concurrent data structure (Thread-safe)

They are thread safe version of basic collections liskt List, Map

- CopyOnWriteArrayList
- ConcurrentHashMap
- CopyOnWriteArraySet
- ArrayBlockingQueue/LinkedBlockingQueue
- LinkedBlockingDeque



## Q20. What kind of locks do you know? What is the advantage of each lock?

- ReentrantLock: A thread can obtain the lock of a resource multiple times in recursive case for example, or the same thread calls another function that require this lock.

- ReadWriteLock：one write at a time/ multiple read at a time. Good in Read-heavy cases

- StampedLock: allow writing when reading

  



## Q21. What is future and completableFuture? List some main methods of ComplertableFuture.
Future is used to get the return value of async callable in threadpool. Exeutor.submit() will return a Future object. When try to furture.get() the result, it will block the current thread and wait for future pops a return value.

CompletableFuture can accept a callback that will be exectued after future returns. 



## Q22- 25

Coding questions are completable futures. Will be done after Christmas