## HW5
#### What is volatile
The `volatile` keyword is used to indicate that a variable's value may be changed by multiple threads simultaneously. It ensures that any thread reading the variable sees the most recent modification made by any other thread, making the variable to be thread-safe.

#### How to create a new thread
1. Create a thread class extending `Thread`  class
2. Implement `runnable` or `callable` interfaces
3. Use the `ExecutorService` interface to create a thread pool

####  Difference between Runnable and Callable
Callable would return a value while runnable doesn't.

#### Difference between t.start() and t.run()
` t.start()` invokes the run method in a new thread of execution, while calling `t.run()` will execute the run method in the current thread, without starting a new thread.

#### Which way of creating threads is better: Thread class or Runnable interface?
Runnable is preferred as the implementation is easier by using Lambda, providing better reusability of codes.

#### What are the thread statuses
- New: When a thread is created but not yet started.
- Runnable: When a thread is ready to run and is waiting for CPU time.
- Blocked: When a thread is prevented from entering a synchronized block or method.
- Waiting: When a thread is waiting indefinitely for another thread to perform a particular action.
- Timed Waiting: When a thread is waiting for another thread to perform a particular action for a specified waiting time.
- Terminated: When a thread has exited.

#### What is deadlock
Two or more threads are unable to move forwards because of waiting others to release the resources.

#### How do threads communicate with each other?
Threads can communicate through shared variables, message passing, or synchronization mechanisms such as `wait()`, `notify()`, and `notifyAll()` methods in Java.

#### What’s the difference between class lock and object lock?
A class lock is associated with the class as a whole, while an object lock is associated with an instance of the class. When using synchronized keyword on a static method or a block, it uses the class lock. For a non-static method or block, it uses the object lock.

#### What is join() method
It is a method for waiting a thread to terminate. It causes the currently executing thread to pause execution until the thread on which it's called is terminated.

#### What is yield() method
It is a hint to the scheduler that the current thread is willing to yield its current use of a processor. It's used to give other threads of equal priority a chance to execute.

#### What is ThreadPool? How many types of ThreadPool? What is the TaskQueue in ThreadPool?
A ThreadPool is a collection of threads that are available for task execusion. 

Thread pools include fixed thread pool, cached thread pool, single thread executor, scheduled thread pool and custom thread pool.

The TaskQueue in a ThreadPool is a queue that holds the tasks awaiting to be executed by the threads in the pool.

#### Which library is used to create ThreadPool? Which interface provides the main functions of the thread-pool?
`java.util.concurrent` is the package and `ExecutorService` is the interface providing main functions of the thread-pool.

#### How to submit a task to ThreadPool?
Submit the task to the TaskQueue using `submit` function of the `ExecutorService`.

#### What is the advantage of ThreadPool?
The threads in the thread pool are reusable for different tasks so that saving the overheads for creating threads for each tasks, improving the overall performance. 

#### Difference between shutdown() and shutdownNow() methods of executor?
`shutdown()` initiates an orderly shutdown in which previously submitted tasks are executed, but no new tasks will be accepted. `shutdownNow()` attempts to stop all actively executing tasks, halts the processing of waiting tasks, and returns a list of the tasks that were waiting to be executed.

#### What are Atomic classes? How many types of Atomic classes? Give me some code examples of Atomic classes and their main methods. When to use them?
Thread-safe versions of primitive variables that are implemented by CAS. Types of Atomic classes include `AtomicInterger`, `AtomicBoolean`, `AtomicLong` and `AtomicReference`.
```Java
public class Demo {
    private static AtomicInteger count = new
   AtomicInteger(1);

   public static void main(String[] args) {
        count.getAndIncrement(); // count++
        count.incrementAndGet(); // ++count
        count.addAndGet(3); // count = count + 3;
        count.getAndSet(5); // return count and then count = 5
6 7}
}
```

#### What is concurrent collections? Can you list some concurrent data structures (Thread-safe)?
Concurrent collections are thread-safe version implementation of collections. Examples include `ConcurrentHashMap`, `CopyOnWriteArrayList`, and `ArrayBlockingQueue`. 

#### What kind of locks do you know? What is the advantage of each lock?
`ReentrantLock`, `ReadWriteLock`, and `StampedLock`. The advantage of ReentrantLock is its ability to provide more control and additional features compared to intrinsic locks. `ReadWriteLock` allows multiple threads to read a resource simultaneously but exclusive access for writing. `StampedLock` provides optimistic reading, potentially improving performance in read-dominated scenarios.

#### What is future and completableFuture? List some main methods of 
A `Future` represents the result of an asynchronous computation. It provides methods to check if the computation is done, retrieve the result, or cancel the computation.

`CompletableFuture` is an extension of Future that provides a more powerful and flexible way to handle asynchronous computations. It allows chain operations and is non-blocking compared to the `Future`.

Main methods include:
- `thenApply(Function<? super T,? extends U> fn)`
Applies the given function to the result of the current CompletableFuture when it completes.
- `thenAccept(Consumer<? super T> action)`
Accepts the result of the current CompletableFuture once it completes, but returns a CompletableFuture\<Void\>.
- `exceptionally(Function<Throwable,? extends T> fn)`
Returns a new CompletableFuture that is completed with the result of the original CompletableFuture or with the specified exception if the original CompletableFuture completes exceptionally.
- `allOf(CompletableFuture<?>... cfs)`
Returns a new CompletableFuture that is completed when all of the given CompletableFuture instances complete.
- `anyOf(CompletableFuture<?>... cfs)`
Returns a new CompletableFuture that is completed when any of the given CompletableFuture instances complete.

#### Write a code to create 2 threads, one thread print 1,3,5,7,9, another thread print 2,4,6,8,10.
[Here](../MavenProject/project/src/main/java/multithreading/ThreadsPrinting1.java)

#### create 3 threads, one thread ouput 1-10, one thread output 11-20, one thread output 21-22. threads run sequence is random
[Here](../MavenProject/project/src/main/java/multithreading/ThreadsPrinting2.java)

#### Completable future
[HW1](../MavenProject/project/src/main/java/CompletableFuture/HW1.java)
[HW2 & 3](../MavenProject/project/src/main/java/CompletableFuture/HW2.java)