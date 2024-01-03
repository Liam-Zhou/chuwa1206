# 2. Explain what is volatile in java? (we also use it in Singleton)

In Java, volatile ensures all threads see the same updated value of a variable, preventing stale data. It acts like a megaphone for changes, making sure everyone hears loud and clear. This comes in handy for critical shared variables, like flags in singletons or thread termination markers.

# 3. How to create a new thread(Please also consider Thread Pool approach)?

Creating threads can be done in two ways: either inheriting from the Thread class and overriding the run() method, or implementing the Runnable interface and passing it to a Thread object. Think of it like choosing between building your own car or renting one - both get you there, but with different levels of customization.

# 4. Difference between Runnable and Callable?

While both Runnable and Callable represent tasks for threads, Callable has a superpower: it can return a value after execution. Runnable is like a silent worker, just doing its job, while Callable brings back a souvenir from its mission.

# 5. What is the difference between t.start() and t.run()?

Calling t.start() is like pressing the launch button on a rocket, creating a new thread and sending it off with its task. t.run(), on the other hand, is more like running alongside the rocket on the ground, keeping things moving but staying in the same place.

# 6. Which way of creating threads is better: Thread class or Runnable interface?

Thread classes and Runnable interfaces both have their perks. Choosing one over the other depends on your needs. Threads offer more flexibility, while Runnables play well with existing object hierarchies. Think of it like deciding between a Swiss Army knife (Thread) and a specialized tool (Runnable) for the job at hand.

# 7. What are the thread statuses?

Threads can be in various states, like a rollercoaster ride – New (waiting in line), Runnable (on the climb), Blocked (stuck at a turn), Waiting (patiently in queue), and Terminated (done with the ride!).

# 8. What is deadlock?

Deadlock is like a traffic jam with everyone stuck, waiting for someone else to move. In threads, it happens when two or more wait for each other's resources, creating a permanent standstill. Think of it as everyone needing the same key to unlock their cars, but none willing to let go first.

# 9. How do threads communicate each other?

Threads can talk to each other in several ways, like sharing secrets through hidden compartments (shared variables with synchronization), sending smoke signals (wait/notify), or using shared padlocks (locks).

# 10. What’s the difference between class lock and object lock?

Locking on a class is like holding the master key to all its rooms, affecting all instances. Locking on an object instance is like having a specific room key, only controlling that one space. It all depends on how specific you need to be with your thread communication.

# 11. What is join() method?

Joining a thread is like waiting for your friend to finish their task before you move on. You pause your own work until they're done.

# 12. what is yield() method

Yielding, on the other hand, is like politely suggesting someone else gets a turn on the playground – you might give up your chance, but it's not guaranteed.

# 13. What is ThreadPool? How many types of ThreadPool? What is the TaskQueue in ThreadPool?

Think of a ThreadPool as a taxi fleet for your tasks. Instead of creating new cars (threads) every time, you have a pool of reusable ones ready to go. This saves time and resources, like a well-oiled machine for handling your errands.

# 14. Which Library is used to create ThreadPool? Which Interface provide main functions of thread-pool?

There are different types of ThreadPools, each with its own specialty. A FixedThreadPool is like a small, reliable fleet, always available. A CachedThreadPool is like a fleet that grows and shrinks on demand, adapting to your needs. And a ScheduledThreadPool is like a fleet with timers, sending cars out at specific times for scheduled deliveries.

The TaskQueue is the waiting line for your tasks in the ThreadPool. They queue up until a free taxi (thread) picks them up and runs them.

The main library for creating ThreadPools is the java.util.concurrent package. It provides the ExecutorService interface, the conductor of your thread orchestra.

# 15. How to submit a task to ThreadPool?

You use execute() for regular errands (Runnable tasks) and submit() for tasks that return a result (Callable tasks).

# 16. What is the advantage of ThreadPool?

Using a ThreadPool has many advantages. It's like having a well-managed workforce for your tasks, improving performance and saving resources compared to creating individual threads every time.

# 17. Difference between shutdown() and shutdownNow() methods of executor

When deciding between shutdown() and shutdownNow(), think of it like closing a restaurant. shutdown() politely tells customers to finish their meals before closing, while shutdownNow() is like suddenly turning off the lights - tasks might be interrupted if they haven't finished.

# 18. What is Atomic classes? How many types of Atomic classes? Give me some code example of Atomic classes and its main methods. when to use it?

Tiny thread-safe vaults for variables.
Types: AtomicInteger, AtomicLong, AtomicBoolean, etc.
Example: AtomicInteger count = new AtomicInteger(0); count.incrementAndGet();
Use for simple, non-blocking thread-safe operations on single variables.

# 19. What is the concurrent collections? Can you list some concurrent data structure (Thread-safe)

Thread-safe versions of collections for multiple thread access.
Examples: ConcurrentHashMap, CopyOnWriteArrayList, BlockingQueue.

# 20. What kind of locks do you know? What is the advantage of each lock?

ReentrantLock: Basic lock with fairness and reentrancy support, Basic and versatile: Suitable for various synchronization needs.
Fairness: Ensures threads waiting for the lock acquire it in the order they requested it.
Reentrancy: A thread can hold the lock multiple times without causing deadlock.

ReadWriteLock: Separate locks for read and write operations. Improved concurrency for read-heavy scenarios: Many threads can read concurrently while only one writes.
Reduced lock contention: Minimizes blocking for read operations, improving performance.
Fine-grained control: Offers separate locks for reading and writing.

StampedLock: Optimistic locking for potential performance gains. Optimistic locking: Improves performance by checking for modifications before acquiring the lock (avoiding unnecessary blocking).
Non-blocking reads: Can perform read operations without acquiring the lock if no write is ongoing.
Complex use cases: Requires careful design and understanding of its unique behavior.

# 21. What is future and completableFuture? List some main methods of ComplertableFuture.

Represent results of asynchronous computations.
CompletableFuture offers more control and chaining operations.
Main methods: get(), thenApply(), thenAccept(), etc.
