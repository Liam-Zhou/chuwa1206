
## 2. Explain what is volatile in java? (we also use it in Singleton)

It indicates that any thread may modify the variable at any given time, even if it seems like a single thread should have exclusive access to it.

1. When a variable is declared as volatile, changes to its value are immediately visible to other threads. This ensures that each thread working with the variable sees the most up-to-date value.

2. Guarantees atomic reads and writes for the variable. 

## 3. How to create a new thread(Please also consider Thread Pool approach)?

1. We create a pool with 'ExecutorService executorService = Executors.newFixedThreadPool(5);'

2. Submit the task into this poll 'executorService.submit(new MyTask());'

3. Close the pool with 'executorService.shutdown();'

## 4. Difference between Runnable and Callable?

1. Return Value: The run() method of the Runnable interface does not return a value. It is a void method, while The call() method of the Callable interface returns a result and can throw exceptions. The result is returned as a generic type and is obtained through a Future object.

2. Exception Handling: The run() method of Runnable cannot throw checked exceptions directly. Any exceptions thrown by run() must be caught and handled within the run method while the call() method of Callable is allowed to throw checked exceptions.

3. Usage with Executors: Typically used with ExecutorService for asynchronous execution. The ExecutorService takes a Runnable and executes it in a separate thread while when you submit a Callable, you get a Future object that can be used to retrieve the result of the computation.

4. Generics: call() can use a generics to return value while run() can not.

## 5. What is the difference between t.start() and t.run()?

t.start(): it start a new thread to run the task.

t.run(): run the task in current thread.

## 6. Which way of creating threads is better: Thread class or Runnable interface?

I think the Runnable is better.

1. Runnable can separate the task from the thread while Thread class can not.

2. We can inheritance the Runnable interface and other interface in one class.

3. Runnable can be reusable when we implement it with this interface.

4. Runnable is easier to use with Thread Pooling.

## 7. What are the thread statuses?

NEW: The thread is in this state before the start() method is invoked on it.

RUNNABLE: The thread is in this state when it is ready to run but may be waiting for its turn to be picked by the thread scheduler. It includes both the running and the ready-to-run states.

BLOCKED: If one thread holds a lock, other threads trying to acquire the same lock will be in the BLOCKED state.

WAITING: A thread is in this state when it is waiting indefinitely for another thread to perform a particular action.

TIMED_WAITING: Similar to the WAITING state, but the thread is waiting for a specified period. It can occur, for instance, when a thread calls the sleep() method or when it waits for the completion of another thread using join() with a timeout.

TERMINATED: A thread is in this state when it has exited its run() method or when an uncaught exception occurs in the thread. Once a thread is in the TERMINATED state, it cannot return to any other state.

## 8. What is deadlock?

Deadlock is a state where a set of processes are blocked because each process is holding a resource and waiting for another resource acquired by some other process.

## 9. How do threads communicate each other?

1. Shared Memory: Threads within the same process can share data through shared memory. This involves using shared variables that multiple threads can read from and write to.

2. Message Passing: Threads can communicate by passing messages between them. One way to implement message passing is by using wait() and notify() methods.

3. Pipes and Streams:Threads can communicate through pipes or streams, especially in I/O-intensive applications. One thread may write to an output stream or pipe, and another thread may read from the corresponding input stream or pipe. Java provides various classes for working with streams, such as InputStream, OutputStream, Reader, and Writer.

4. Synchronization Constructs: Synchronization constructs like synchronized blocks, locks and semaphores can be used to coordinate and synchronize the activities of multiple threads.

5. Joining Threads: The join() method in Java allows one thread to wait for the completion of another thread.

6. Condition Variables: Condition variables, often associated with locks, allow threads to wait for a particular condition to be true before proceeding. The await() and signal() methods in Java's Condition interface are examples.

## 10. What’s the difference between class lock and object lock?

Class Lock: Associated with the class itself. Affects all instances of the class. Used for synchronization of static methods or code blocks.

Object Lock: Associated with a specific instance of the class. Different instances have different locks. Used for synchronization of instance methods or code blocks.

## 11. What is join() method?

The join() method is a method in Java that is used to wait for a thread to finish its execution. When a thread calls the join() method on another thread, it waits for that thread to complete before continuing its own execution.

## 12. What is yield() method?

The yield() method is a static method in the Thread class in Java, and it is used to hint to the scheduler that the current thread is willing to yield its current use of the processor. This method is a way to voluntarily give up the CPU, allowing other threads to run.

## 13. What is ThreadPool? How many types of ThreadPool? What is the TaskQueue in ThreadPool?

A ThreadPool in Java is a pool of worker threads. It reuses a fixed number of threads, improving performance by avoiding the overhead of thread creation and destruction.

FixedThreadPool, CachedThreadPool, ScheduledThreadPool, SingleThreadExecutor.

TaskQueue: A TaskQueue in a ThreadPool is a data structure that holds tasks submitted to the ThreadPool but not yet executed. When the number of tasks exceeds the number of available threads, tasks are placed in the TaskQueue and executed as soon as a thread becomes available.

## 14. Which Library is used to create ThreadPool? Which Interface provide main functions of thread-pool?

The 'java.util.concurrent' package provides a framework for creating and managing thread pools.

Executor Interface: It declares a single method, execute(Runnable command), which is responsible for executing the given command.

ExecutorService Interface: It includes methods like submit(Callable<T> task), which submits a task for execution and returns a Future representing the pending result.

ThreadPoolExecutor Class: It allows configuration of various parameters such as core pool size, maximum pool size, keep-alive time, and the task queue type.

Executors Class: It provides factory methods for creating different types of thread pools using convenient static methods like newFixedThreadPool(int nThreads), newCachedThreadPool(), and newSingleThreadExecutor().

## 15. How to submit a task to ThreadPool?

ExecutorService executor = Executors.newFixedThreadPool(5);
Future<?> future = executor.submit(new MyRunnable());
executor.shutdown();

## 16. What is the advantage of ThreadPool?

Thread pools efficiently manage threads, improve performance, and provide a structured approach to concurrent programming. They are a fundamental tool for building scalable and responsive applications in a concurrent environment.

## 17. Difference between shutdown() and shutdownNow() methods of executor?

shutdown(): Initiates an orderly shutdown of the executor service. Previously submitted tasks are executed, but no new tasks will be accepted for execution. The executor will not terminate until all submitted tasks are completed, and the threads are idle. After calling shutdown(), any attempt to submit a new task will result in a RejectedExecutionException.

shutdownNow(): Attempts to stop all actively executing tasks, halts the processing of waiting tasks, and returns a list of the tasks that were waiting to be executed. It does not wait for previously submitted tasks to complete execution. It interrupts the threads executing the tasks, which may result in tasks throwing an InterruptedException.

## 18. What is Atomic classes? How many types of Atomic classes? Give me some code example of Atomic classes and its main methods. when to use it?

Atomic classes are particularly useful in scenarios where multiple threads might access and modify shared variables concurrently, and you want to ensure atomicity without using explicit synchronization.

## 19. What is the concurrent collections? Can you list some concurrent data structure (Thread-safe)

Concurrent collections in Java are data structures that are designed to be thread-safe, meaning they can be safely accessed and modified by multiple threads concurrently without the need for external synchronization.

ConcurrentHashMap, CopyOnWriteArrayList, LinkedBlockingQueue, ConcurrentLinkedQueue ... 

## 20. What kind of locks do you know? What is the advantage of each lock?

ReentrantLock: Allowing a thread to acquire the same lock multiple times without deadlock.

ReadWriteLock (ReentrantReadWriteLock): Allows multiple threads to read a shared resource concurrently but only allows one thread to write to the resource at a time.

StampedLock: Extends the read-write lock concept and introduces optimistic locking, which allows for improved read performance in some scenarios.

## 21. What is future and completableFuture? List some main methods of ComplertableFuture.

Future represents the result of an asynchronous computation. It provides a way to check if the computation is complete, retrieve the result, or wait for the completion. CompletableFuture is an enhanced implementation introduced in Java 8 that extends the Future interface and provides additional features for handling asynchronous computations in a more flexible and composable manner.

CompletableFuture: 

static CompletableFuture<Void> runAsync(Runnable runnable): Runs the given action asynchronously, potentially using a different thread.

static <U> CompletableFuture<U> supplyAsync(Supplier<U> supplier): Runs the given supplier asynchronously, potentially using a different thread.

thenApply(Function<? super T,? extends U> fn): Returns a new CompletableFuture that, when this future completes, is executed with this future's result as the argument to the supplied function.

thenApplyAsync(Function<? super T,? extends U> fn): Returns a new CompletableFuture that, when this future completes, is executed with this future's result as the argument to the supplied function using the default executor.

thenAccept(Consumer<? super T> action): Returns a new CompletableFuture that, when this future completes, is executed with this future's result as the argument to the supplied action.

thenAcceptAsync(Consumer<? super T> action): Returns a new CompletableFuture that, when this future completes, is executed with this future's result as the argument to the supplied action using the default executor.


## 1. What is generic in Java? and type the generic code by yourself.

## 2. Read those codes and type it one by one by yourself. the push the code to your branch.

## 3. practice stream API at least 3 times.

## 4. Practice Optional methods at least 2 times.

## 5. Write the Singleton design pattern include eager load and lazy load.

Please see the /chuwa1206/CodingQuestions/HW4/src/singleton

## 6. What is Runtime Exception? could you give me some examples?

Runtime Exception is the exception we throw during the execution of a program, like ArithmeticException, NullPointerException, ArrayIndexOutOfBoundException .. 

## 7. Could you give me one example of NullPointerException?

We define a variable List<Integer> array = null, when we call the array.size(), it will throw NullPointerException.

## 8. What is the Optional class?

Optional is a Java package in Java 8 which provides a more explicit and safer way to handle potentially null values. 

We usually use methods like of, ofNullable, get, ifPresent, orElse/orElseGet.orElseThrow

## 9. What are the advantages of using the Optional class?

It provides a more explicit and safer way to handle potentially null values and give responses.

## 10. What is the @FunctionalInterface?

It is an annotation for the interface, it shows that the interface can only have one abstract method. We use it with lambda together.

## 11. What is lamda?

Lambda is an expression can be passed as a parameter to a body function.

## 12. What is Method Reference?

Method Reference is a shorthand notation that allows you to refer to a method by its name instead of providing a lambda expression to describe the method's behavior.

## 13. What is Java 8 new features?

Lambda Expressions, Functional Interfaces, Streams API, Default Methods, Method References, Optional Class, New Date and Time API

## 14. Lambda can use unchanged variable outside of lambda? what is the details?

Yes, we can use the variables with final or without final, but we can not change the variable or reference before or after this lambda.

## 15. Describe the newly added features in Java 8?

Functional Interfaces, a functional interface is an interface with only one abstract method, and it can have multiple default or static methods.

Lambda Expressions, provides a concise way to express instances of single-method interfaces.

Streams API, it introduces the stream package with different methods to deal with the data.

Default Methods, it is in the interfaces which we want to implements common function for the classes which implementing this interface. 

Method References, method references provide a shorthand notation for lambda expressions, making the code more concise.

Optional Class, it provides a more explicit and safer way to handle potentially null values and give responses.

New Date and Time API, provides a modern date and time API that is more comprehensive and flexible.

## 16. Can a functional interface extend/inherit another interface?

Yes, a functional interface can extend/inherit another interface, but it can not has one abstract class in total.

## 17. What is the lambda expression in Java and How does a lambda expression relate to a functional interface?

Lambda Expressions, provides a concise way to express instances of single-method interfaces.
The lambda can be used with functional interface. lambda can provide the parameters and function body to the abstract method in the functional interface.

## 18. In Java 8, what is Method Reference?

Method Reference is a shorthand notation that allows you to refer to a method by its name instead of providing a lambda expression to describe the method's behavior.

## 19. What does the String::ValueOf expression mean?

It converts the given value to its string representation using the static valueOf method in the String class.

## 20. What are Intermediate and Terminal operations?

Intermediate operations are operations that transform a stream into another stream. They are not executed until a terminal operation is invoked.

Terminal operations are operations that produce a result or a side effect. They trigger the processing of elements in the stream and, once executed, a stream cannot be used again.

## 21. What are the most commonly used Intermediate operations?

filter, map, flatMap, distinct, sorted and limit

## 22. What is the difference between findFirst() and findAny()?

findFirst() will return the first one it find macthes, findAny() will return anyone.

## 23. How are Collections different from Stream?

Collections focus on collecting data and Stream focus on deal with the data, stream do not store data.
