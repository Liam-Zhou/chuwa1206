1. Demonstrate in OOPDemo directory.
2. A wrapper class in Java is a class that encapsulates a primitive data type into an object. These classes are part of the java.lang package and are as follows:
    - `Boolean` for the `boolean` primitive type.
    - `Byte` for the `byte` primitive type.
    - `Character` for the `char` primitive type.
    - `Double` for the `double` primitive type.
    - `Float` for the `float` primitive type.
    - `Integer` for the `int` primitive type.
    - `Long` for the `long` primitive type.
    - `Short` for the `short` primitive type.
We need wrapper class in Java due to the following reasons:
    - Object Requirement: Java is an OOP language and in many cases we need to work with object instead of primitive types.
    - Mathod Invocation: Wrapper classes provides ways to use primitive data as objects. For example, we sometimes need to pass an object to a method instead of primitive type.
    - Utility Methods: Wrapper classes contain useful methods.
    - Type Safaty and Generics: Generics only works with objects instead of primitive types.
    - Null Value Representation: Primitive types cannot be null but wrapper calss object can be.
3. 
    - HashMap:   
      - Not thread safe 
      - Allows one and only one NULL key
      - Better Performance
    - HashTable
      - Thread safe
      - No Null key allowed
      - Lower performance
4. - String Pool is a special memory area in Java Heap where Java stores literal String objects. It plays a important role in conserving memory and improving performance in Java. It stores all the String literals created in the program and it will refer to an existing String in the pool when the String is referred.
    - Using String pool improve memory efficiency and optimize performance by reusing existing String in the pool. 
5. Garbage collection is a process in Java where unused memory is recycled. Garbage collector counts the references to objects. When the number of references to an object becomes 0 in JVM, the collector will destroy and recycle the memory.
6. - private: Allows access in the same class.
   - default: Allow access for classes in the same package.
   - protected: Allows access for classes in the same package and subclasses
   - public: Allows access from anywhere. 
7. final is a non-access modifier. final method cannot be overriden. final class cannot be inherited. final variable cannot be re-referenced.
8. The static keyword is a non-access modifier that is applicable for blocks, variables, methods, and classes. The static keyword belongs to the class than an instance of the class. The static block is initialized once and first when the class is first loaaded. The static variable is shared among all instances of the class. The static method is associated with class, not object, and it can be accessed before any object of its class are created, without reference to any object. The static class can be made only if it is a nested class. The static class can be accessed using the name of its parent class.
9. 
    - Overriding is used to achieve runtime polymorphism. The method in the child class override the method in the parent class by using exactly the same method signature.
    - Overloading is used to achieve compile time polymorphism.  The methods in the same class share the same name but different parameters.
10. 
    - super refers to the parent class. It can be used to access superclass variable, invoking superclass methods, and invoking superclass constructors.
    - this refers to the current object. It can be used to access instance variables, invoking other constructors of the same class, passing current instance, and returning current instance.
11. 
    Load sequence refers to the process of loading, linking, and initializing classes and interfaces in the JVM.
    - Loading
      - Class Loader: A class is loaded into memory by JVM using class loader. The class loader reads the binary data of the class and creates a Class object.
      - Types of class loader: Java uses different types of class loaders like Bootstrap loarder, extension class loader, and system/application class loader.
      - Finding classes: The class loader searches for classes in file systems, network locations, or other sources.
    - Linking
      - Verification: The JVM verifies that the loaded class conforms to the Java language specifications.
      - Preparation: JVM allocates memory for class variables and initialize them to default value.
      - Resolution: JVM replaces symbolic references from loaded class with direct references.
    - Initialization
      - Static Initialization: Initialization involves executing static initializer and static initialization blocks.
      - Superclass initialization: The superclass is initialized first before the the class initializes its static fields and blocks.
    - Lazy loading: Classes in Java are not loaded into the memory at once. They are loaded at demand.
    - Caching of classes: The loaded classes are caches in JVM memory.
    - Dynamic class loading: Java allows classes to be loaded dynamically at runtime.
12. Polymorphism means having many forms. Polymorphism allows programmers to define one interface and have multiple implementations. There are two types of polymorphism: runtime polymorphism achieved by overriding, compile time polymorphism achieved by overloading.
13. 
    - Encapsulation refers to the bundling of data and methods that operate on that data within a single class. Encapsulation is a way of hiding the implementation details of a class from outside access and only exposing a public interface that can be used to interact with the class. Encapsulation is achieved by declaring the instance variables of a class as private. To allow access outside class, public methods called getters and setters are defined.
    - We need encapsulation because it achieves data hiding, increase flexibility, reusability, easy for testing.
14. 
    - Interface is a blueprint of a behavior. It contains abstract methods, static final variables, default and static methods. It can achieve multiple inheritance by extending multiple interfaces. Concrete classes implementing interfaces must provide implementation for the abstract methods. Interfaces are public. Interface does not have constructor.
    - Abstract class contains a mix of abstract methods and concrete methods. It cannot be instantiated on its own. Concrete classes extending abstract class must provide implementation for the abstract methods. Abstract class can have any visibility. Abstract class has constructor.
15. See code in codingQuestions/coding1 directory.
16. 
    Implementation of Queue interface includes:
    - AbstractQueue: This class provides skeletal implementations of some Queue operations.
    - ArrayBlockingQueue: Use ArrayBlockingQueue in concurrent applications where you need a fixed-size queue. It's a classic choice for producer-consumer scenarios, especially when memory footprint is a concern.
    - ArrayDeque: Use ArrayDeque when you need a resizable array-based queue with no capacity constraints. It's efficient and faster for both stack and queue operations.
    - ConcurrentLinkedDeque: Use ConcurrentLinkedQueue in concurrent applications where scalability is important, and you expect high concurrency among multiple threads. It is unbounded. It implements Deque interface.
    - ConcurrentLinkedQueue:  Ideal for scenarios where high-throughput and scalability are required for FIFO operations. Commonly used in producer-consumer patterns where order of processing is important. It implements Queue interface.
    - DelayQueue: An unbounded blocking queue of Delayed elements, in which an element can only be taken when its delay has expired.
    - LinkedBlockingDeuqe: Use LinkedBlockingDeuqe in concurrent applications where threads are producing and consuming elements asynchronously. It's useful in scenarios like producer-consumer problems.
    - LinkedBlockingQueue: Use LinkedBlockingQueue in concurrent applications where threads are producing and consuming elements asynchronously. It's useful in scenarios like producer-consumer problems.
    - LinkedList: Use LinkedList when you need both list and queue operations. It's not the most efficient queue implementation for large datasets due to its linked nature.
    - LinkedTransferQueue: LinkedTransferQueue is a concurrent data structure introduced in Java 7, part of the java.util.concurrent package. It is an implementation of the TransferQueue interface, which is an extension of the BlockingQueue interface. LinkedTransferQueue is designed for high throughput in scenarios involving multiple producers and multiple consumers, and it offers several interesting features and capabilities.
    - PriorityBlockingQueue: PriorityBlockingQueue is a thread-safe, unbounded blocking priority queue. Like PriorityQueue, it also orders its elements according to their natural ordering or by a comparator. It is thread-safe. Multiple threads can safely add, remove, and access elements concurrently without the need for external synchronization. Ideal for multi-threaded producer-consumer scenarios where tasks are processed by priority.
    - PriorityQueue: Use PriorityQueue when you need elements to be processed based on priority and not necessarily in FIFO order. Not thread safe.
    - SynchronousQueue: SynchronousQueue is a blocking queue implementation in the java.util.concurrent package of Java. Unlike other BlockingQueue implementations, it does not have any internal capacity; it holds only a single element internally at a time. It is a simple yet powerful concurrency utility that facilitates hand-off between threads. Perfectly suited for scenarios where a thread must wait for a response from another thread, effectively setting up a synchronous information exchange. This is common in thread pool designs and task-handling frameworks.


