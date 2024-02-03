2. In Java, `volatile` is a keyword used to declare a variable as being stored in main memory. It ensures that reads and writes to the variable are done directly form and to main memory, providing a visibility guarantee across threads. This means when a thread modifies a `volatile` variable; all other threads will see the updated value immediately. In a Singleton pattern, it's often sued to ensure that the instance is accessed safely in a multithreaded environment. 
3. Extending Thread Class:
```
class MyThread extends Thread{
public void run(){}
}

Thread t = new Thread(new Myrunnable());
t.start();
```

   Implementing Runnable Interface: 
``` 
class MyRunnable implements Runnable{
public void run(){}
}
Thread t = new Thread(new MyRunnable()); 
t.start();
```
Implements Callable: 
```
public class MyCallable implements Callable<String>{
@override
public String call() throws Exception{
Thread.sleep(5000);
return "Start new thread using Callable."}
} 
```
Thread Pool using Executor Framework:
```
ExecutorService Executor = Executors.newFixedThreadPool(10);
executor.excute(new Runnable(){
   public void run(){}
   };
   
 executor.shutdown();
```
4. The differences between `Runnable` and `Callable` in Java are:

   (1) Return Value: Runnable: Does not return any value. It's a void method. 

      Callable:Can return a value. The value which can be returned can be any type. 
   （2）Exception Handling: Runnable: Cannot throw checked exceptions. 
      Callable: Can throw checked exceptions from its `call` method.
5. t.start() starts a new thread to execute the task(run()). t.run() execute the task in the current thread. 
6. Using Runnable interface is generally considered better for creating threads, because using Runnable allows your class extend another class while still being able to run in a thread. 
Implementing Runnable make it easier to share resources. Multiple threads can be passed the same Runnable instance, allowing for easier resource sharing and synchronization. 
7. In Java, Thread status can be: 

New: The thread is created but not yet started.
Runnable: The thread is ready to run and might be running or waiting for CPU allocation.
Blocked: The thread is blocked and waiting for a monitor lock, typically to enter a synchronized block\method. 
Waiting: The thread is waiting indefinitely for another thread to perform a specific action. 
Timed_waiting: Thread waits for a specified amount of time.  
Terminated: The thread has completed its execution and exited. 
8. Deadlock means two or more threads are blocked forever, each waiting for the other to released a resource. 
9. (1) Synchronized mechanisms can use shared objects. Threads can access and modify shared objects.
   (2) wait(), notify(), notifyAll(): 
10. Object locks are for controlling synchronization between multiple instances of a class, which classes locks are for controlling synchronization between threads at the class level, typically used for static data. 
11. join() allows one thread to wait for the completion of another. When a thread invokes the join() method on another thread instance, it moves into a waiting state until the referenced thread terminates. 
12. yield() is a static method that hints to the thread scheduler that the current thread is willing to yield its current use of processor. The scheduler is free to ignore this hint.
13. ThreadPool in Java is a group of pre-instantiated reusable threads that are available to perform a set of arbitrary tasks. It can reduce the overhead of thread creation. 

Types of ThreadPool in java:
(1) FixedThreadPool: A thread pool with a fixed number of threads. If all threads are active, tasks wait in a queue until a thread is available.

(2) CachedThreadPool: A thread pool that creates new threads as needed, but reuses previously constructed threads when available. Old threads are removed if they've been idle for a certain time.

(3) SingleThreadExecutor: A thread pool with only one thread. All tasks are executed sequentially.

(4) ScheduledThreadPoolExecutor: A thread pool for delayed ot periodic task execution.

TaskQueue in ThreadPool is a queue that holds tasks waiting to be executed. When all threads in the pool are actively executing tasks, new tasks are placed in this queue until a thread becomes available. The nature of this queue
depends on the ThreadPool implementation and its configuration. 
14. `java.util.concurrent` is the library used to create and manage thread pools. `ExecutorService` is the main interface used to provide main functions of thread pool. 
15. Use an `ExecutorSerive` instance. 
```
ExecutorSerice executor = Executors.newFixedThreadPool(5);
executor.execute(new Runnable(){
   public void run(){}
   }
```

```
Future<?> future =- executor.submit(new Runnable(){public void run(){}};
Future<Integer> futureWithResult = executor.submit(new Callable<Integer>(){
   public Interger call(){return someResult;}}}
executor.shutdown();
```
16. The advantages are Resource Management, Improved Performance, Enhanced Scalability, Control over Task Execution, Better System Stability, Flexibility in Task Handling. 
17. They are used to terminate the executor, but they do so in different ways. `shutdown()` is the preferred method for orderly and graceful shutdown, allowing in-progress to complete, while `shutdownNow()` is used for an immediate shutdown, potentially interrupting running tasks. 
18. Atomic classes in Java can perform atomic operations on single variables without using synchronization. These classes are used for building non-blocking algorithms and performing thread-safe operations on single variables.
Types of Atomic Classes: Basic Types: ``` AtomicBoolean; AtomicInterger; AtomicLong``` ArrayTypes: ``` AtomicIntegerArray; AtomicLongArray; AtomicReferenceArray``` Reference Types: ```AtomicReference; AtomicStampedReference; AtomicMarkableReference ``` Filed Updater Type: ``` AtomicIntegerFieldUpdater; AtomicLongFieldUpdarter; AtomicReferenceFieldUpdater```
Here is the example code: 
```
public class AtomicExample{Private AtomicInteger count = new AtomicInteger(0);

   public void increment(){
      count.incrementAndGet();
   }
   public void decrement(){
      count.decrementAndGet();
   }
   public int getCount(){
      return count.get():
   }
```
When you need to perform thread-safe operations on single variables without using `synchronized`. In high-concurrency scenarios where the overhead of synchronization is too high. In non-blocking algorithms where you need to avoid thread blocking. When implementing counters or accumulators that are accessed by multiple threads. 
19. Concurrent collections in Java are special thread-safe collections. These collections are designed for concurrent access, allowing multiple threads to read and write concurrently without the need for external synchronization. 
Here are some key concurrent data structure: (1) ConcurrentHashMap (2) concurrentLinkedQueue (3) ConcurrentLinkedDeque (4) CopyOnWriteArrayList (5) CopyOnWriteArraySet (6) BlockingDeque (7) BlockingQueue (8) ConcurrentSkipListMap and ConcurrentSkipListSet.
20. (1) Intrinsic Locks(Synchronized Blocks/Monitors): Simple and easy to use for basic synchronization needs. Intrinsic locks are built into every Java object and class. 

(2) Reentrant Locks: More Flexible than intrinsic locks. Supports fairness policy, lock interruptibility, and the ability to check if the lock is being held. 

(3) Read-Write Locks: Allows multiple threads to read a resource concurrently, as long as it's not being written to. Improve performance in read-heavy scenarios. 

(4) Stamped Lock: Optimized for read-heavy operations with methods that facilitate optimistic locking. Also provides read ans write locks like `ReadWriteLock`.

(5) Semaphore: Controls the number of threads that can access a resource. Useful for implementing resource pools or limiting concurrent access to a certain number of resources. 

(6) CountDownLatch: Allows one or more threads to wait until a set of operations being performed by other threads completes. 

(7) CyclicBarrier: Allows a set of threads to all wait for each other to reach a common barrier point, useful for parallel divide-and-conquer tasks.

