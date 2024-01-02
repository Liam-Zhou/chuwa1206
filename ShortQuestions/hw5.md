### 1. What does 'volatile' mean in Java?
The `volatile` keyword in Java ensures that changes made to a variable in one thread are immediately visible to other threads. It's used for variables that are accessed by multiple threads without synchronization.

### 2. How do you create a new thread in Java?
To create a new thread in Java, you can either extend the `Thread` class or implement the `Runnable` interface, then instantiate the Thread object and call its `start()` method.

### 3. What is the difference between `Runnable` and `Callable` in Java?
`Runnable` and `Callable` are both functional interfaces in Java used to define tasks for threads. The main difference is that `Runnable` does not return a result and cannot throw checked exceptions, while `Callable` returns a result and can throw exceptions.

### 4. What is the difference between calling `t.start()` and `t.run()` in a thread in Java?
- t.start starts a new thread to excute the task(run()) 
- t.run() excute the task in the current thread.

### 5. What is the difference between extending the Thread class and implementing the Runnable interface in Java?
Extending the Thread class and implementing the Runnable interface in Java both allow you to create a new thread. However, implementing Runnable is more flexible as it allows you to extend another class, while extending Thread does not.

### 6. What are the different states in the lifecycle of a thread in Java?
The lifecycle of a thread in Java includes several states: New, Runnable, Blocked, Waiting, Timed Waiting, and Terminated.

### 7. What is a deadlock in multi-threading?
Deadlock in multi-threading occurs when two or more threads are blocked forever, each waiting for the other to release a resource. It's like a standoff where neither can proceed.

### 8. How do threads communicate with each other in Java?
In Java, threads communicate with each other using the `wait()`, `notify()`, and `notifyAll()` methods. These methods are used for inter-thread communication to avoid polling and reduce CPU usage.

### 9. What is the difference between class level lock and object level lock in Java?
In Java, a class level lock is associated with the class's Class object and affects static methods, while an object level lock is tied to an instance of the class and affects non-static methods and synchronized blocks.

### 10. What does the `join()` method do in threading in Java?
The `join()` method in Java threading allows one thread to wait for the completion of another. If `t` is a Thread object, `t.join()` causes the current thread to pause execution until `t`'s thread terminates.

### 11. What does the `yield()` method do in threading in Java?
The `yield()` method in Java threading hints the scheduler to pause the execution of the current thread and allow other threads to execute. It's a way to suggest a context switch for better resource utilization.

### 12. What is a ThreadPool in Java and why is it used?
A ThreadPool in Java is a group of pre-instantiated reusable threads. These threads are used to execute tasks, improving performance by reducing the time spent in creating and destroying threads.

### 13. How do you create a ThreadPool in Java?
In Java, a ThreadPool can be created using the Executors framework. You can choose from different types of thread pools like `FixedThreadPool`, `CachedThreadPool`, `ScheduledThreadPool`, etc., based on your needs.

### 14. How do you submit a task to a ThreadPool in Java?
In Java, you submit a task to a ThreadPool using methods like `execute()` for Runnable tasks or `submit()` for Callable tasks. These methods are part of the Executor framework.

### 15. What are the advantages of using a ThreadPool in Java?
The advantages of using a ThreadPool in Java include reduced resource consumption, improved response time, better thread management, and more efficient task processing due to reuse of threads.

### 16. What are Atomic classes in Java and why are they used?
Atomic classes in Java, like `AtomicInteger`, `AtomicLong`, etc., provide thread-safe operations on single variables. They are used in concurrent applications to ensure atomicity and visibility guarantees without using synchronization.

### 17. What are concurrent collections in Java and give some examples?
Concurrent collections in Java are thread-safe versions of standard collections designed for concurrent access. Examples include `ConcurrentHashMap`, `CopyOnWriteArrayList`, and `BlockingQueue`.

### 18.What kind of locks do you know? What is the advantage of each lock?
In Java, different types of locks include intrinsic locks (synchronized blocks) and explicit locks like `ReentrantLock`, `ReadWriteLock`, etc. They offer more control over lock management than synchronized blocks.

### 19. What is `future` and `CompletableFuture`? List some main methods of `CompletableFuture`.

`future` in Java is a mechanism to handle asynchronous computation results. It represents a result that will eventually appear. `CompletableFuture`, an enhancement of `Future`, allows more complex operations and non-blocking asynchronous computations.

Main methods of `CompletableFuture` include:
- `supplyAsync()`: Asynchronously computes a value.
- `thenApply()`: Applies a function to the result.
- `thenAccept()`: Consumes the result without returning.
- `thenCombine()`: Combines two independent futures.
- `exceptionally()`: Handles exceptions.
- `join()`: Waits for completion, retrieving the result.

These methods facilitate managing asynchronous tasks in a more flexible and functional style.