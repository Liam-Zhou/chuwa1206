### 1. class-level lock vs object-level lock
- class lock: using static synchronized to achieve the key, which is often used to prevent the multiple threads from entering the synchronized block.
- object lock: using synchronized to achieve the lock, which is often used when one wants to allow the thread to only execute the code block on a given instance of the class.
### 2. what is volatile
Volatile keyword is used to modify the value of the variable by different threads, it is used to make classed thread safe. It means that multiple threads can use a method and instance of the classes at the same time without any problem.
### 3. how to create a new thread
- create a new thread using Thread class, or implements a Runnable or Callable interface
- create a new thread pool and submit the task to the pool
### 4. Runnable vs Callable
Runnable doesn't have a return type, while Callable can have a return value.
### 5. t.start() vs t.run() 
t.start() means creat a new thread t and run the t as the newly created thread. run() means run the thread t in the current thread, it will not create a new thread for t.
### 6. Thread class or Runnable interface
Implements Runnable is preferred because Java only allow extends one class, thus if extends Thread, the class can not extends the other class. Thus using Runnable Interface allows one to extends other class for specific usage.
### 7. thread statuses
- NEW: thread get created
- RUNNING: thread is running
- READY: thread is ready to be run
- TERMINATED: thread finished the tasks
- WAITING: thread is waiting for the other thread, thread will be in this status after running wait(), join() methods.
- TIMED_WAITING: thread is waiting for others but has a time set for the waiting process
- BLOCKED: thread is blocked by the lock set in the code block by synchronized keyword
### 8. deadlock
when a process or a thread needed 2 resources at the same time while it can only get one resource, so it enters the WAITING status because the resource it needs is held by another waiting process. While the another process is also in WAITING status because it needs the resource which is held by the first process.
### 9. how do threads communicate each other
- wait() put the thread into WAITING status to allow other threads work first.
- notify() wake up a single thread so it can be ready for run
- notifyAll() wake up all the threads so they can be ready for run
### 10. class lock and object lock
- class lock: using static synchronized to achieve the key, which is often used to prevent the multiple threads from entering the synchronized block.
- object lock: using synchronized to achieve the lock, which is often used when one wants to allow the thread to only execute the code block on a given instance of the class.
### 11. join()
join method allows one thread to wait until another thread completes the execution.
### 12. yield()
yield method can stop the current executing thread and will give a chance to other waiting threads of the same priority. In case there are no waiting threads or if all the waiting threads have low priority, then the same thread will continue the execution
### 13. ThreadPool, how many types, what is TaskQueue
A thread pool reuses the previously created threads to execute current tasks.

- Fixed Thread Pool: fixed number of threads that are created when the thread pool is initialized
- Single Thread Executor: has only one thread in the pool, it executes tasks sequentially one at a time
- Scheduled Thread Pool: designed to execute tasks at a specific time or repeatedly at a fixed interval. It is used to schedule tasks to run at a certain time or to repeat at a certain interval.
- Cached Thread Pool: create threads as needed and reuses them when they become available.

Task queue is optimised to properly utilize threads within a thread pool executor.
### 14. which Library is used to create ThreadPool, which interface provide main functions of thread-pool
java.util.concurrent library, Executor interface
### 15. how to submit a task to ThreadPool
By calling the submit() function and passing in the name of the function you wish to execute on another thread.
### 16. the advantage of thread pool
- reduce the resource consumption caused by thread creation and destruction by reusing created threads
- improve response speed by executing the task immediately without waiting for a thread to be created.
### 17. shutdown() vs shutdownNow()
shutdown method will allow previously submitted tasks to execute before terminating, while the shutdownNow method prevents waiting tasks from starting and attempts to stop currently executing tasks
### 18. Atomic class? How many types of Atomic classes
Atomic class is the class that support atomic operations on single variables. The most commonly used atomic variable classes in Java are AtomicInteger, AtomicLong, AtomicBoolean and AtomicReference, they represent an int, long, boolean and object reference respectively which can be atomically updated.
```
public class AtomicDemo {
    private static AtomicInteger atomicInteger = new AtomicInteger(1);
    
    public static void main(String[] args) {
        System.out.println(atomicInteger.getAndIncrement());
        System.out.println(atomicInteger.get());
    }
 }
```
### 19. concurrent collections, list some concurrent data structure
concurrent collections refer to a set of classes that allow multiple threads to access and modify a collection concurrently.

CopyOnWriteArrayList, ConcurrentHashMap, CopyOnWriteArraySet, ArrayBlockingQueue, LinkedBlockingQueue, LinkedBlockingDeque
### 20. what kinds of locks do you know? what is the advantage of each lock
- ReentrantLock: one thread can get this same lock multiple times. Use condition to communicate among multiple threads
- ReadWriteLock: if there is one thread writing, doesn't allow the others to write or read. If there is no thread writing, allow multiple threads reading at the same time.
- StampedLock: allow writing while some other threads are reading, will need more code to handle the different situations
### 21. future and completableFuture, list some main methods of CompletableFuture
when Future wants to get the asynchronous results, it will need to use get() or checking isDone(), which will block the main thread, while CompletableFuture will not block the main thread.
It can also support the chaining operations for easy combination and managerment of multiple asynchronous tasks.
### 22. 
### 23. code in coding4/waitNotify
### 24. code in coding4/printNotify
### 25. code in coding4/completableFuture