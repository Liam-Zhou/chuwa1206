1. See CodingQuestions.
2. What is wrapper class in Java and Why we need wrapper class?

    - Wrapper class is java class that encapsulates primitive data types.
    - We need it because wrapper class support generics, null, a lot of additional class functions, and primitive data types to be used as objects.

3. What is the difference between HashMap and HashTable?

    1. HashTable is synchronized, which means thread safe, whereas HashMap is not in default.
   2. HashTable is generally slower than HashMap due to synchronization.
   3. HashTable does not allow `null` as key or value, whereas HashMap allows one null key and multiple null values.
   4. HashMap's Iterator is fail-fast, which means concurrent modification will throw `ConcurrentModificationException`, whereas HashTable's Iterator is fail-safe, which means it operates on the clone of the collection, not on the original collection
   5. HashTable is a legacy class.

4. What is String pool in Java and why we need String pool?

   - String pool is a pool of Strings stored in memory. Because String is immutable in java, the goal is to reuse a lot of Strings to save memory and improve performance. When we have Strings which have the same content then the Strings can be reused. 

5. What is Java garbage collection?

   Java GC is an automated process in JVM responsible for deallocating memory which is occupied by objects that is no longer in use or reachable.

6. What are access modifiers and their scopes in Java?

   Access modifiers are keywords that control the visibility and accessibility of classes, methods, and fields.
   
   - `Public`: accessible from anywhere.
   - `Default`: accessible only within the same package.
   - `Protected`: (only for Methods and fields) accessible within the package or all subclasses.
   - `Private`: (only for Methods and field) accessible within the class only.

7. What is final key word? (Filed, Method, Class)

   - variable: cannot be changed after initialization.
   - method: cannot be overridden by subclasses.
   - class: cannot be extended, and makes the class immutable.

8. What is static keyword? (Filed, Method, Class). When do we usually use it?

   - variable: it belongs to the class rather than an instance of the class.
   - method: A static method belongs to the class rather than to any particular instance.
   - class: nested class can be declared as static, which makes it does not have access to the instance variables of the outer class.

9. What is the differences between overriding and overloading?

   - Overloading happens at compile time, whereas overriding happens at runtime.
   - overloading has better performance because the binding is done at compile time.
   - Private and final methods can be overloaded but cannot be overridden.
   - Return type must be the same in the case of overriding whereas in case of overloading, it does not matter.
   - Arguments must be different in overloading, and must be the same in overriding.
   - Overloading must be done in the same class whereas overriding must involve derived class.
   - Overloading is used to increase readability and overriding is used to provide the implementation of the method in its base class.

10. What is the differences between super and this?

    - `super`  is used to refer to the parent class of the current class, whereas `this` is used to refer to the current instance of the class.


11. What is the Java load sequence?

   - static block and variables -> constructors -> non-static variables

12. What is Polymorphism ? And how Java implements it ?

   - Polymorphism refers to the same object exhibiting different forms and behaviors. Java implements it through Overloading, and inheritance with Overriding.

13. What is Encapsulation ? How Java implements it? And why we need encapsulation?

   - Encapsulation in OOP refers to binding data and methods to manipulate that data together in a
     single unit (class).
   - Java implements it with class using access modifiers(public, private, protected, default) .
   - Because it can hide data for security issue, allows modular design to enhance code readability and maintenance.

14. What is Interface and what is abstract class? What are the differences between them?

   - Abstract class is class that is declared abstract, it may or may not include abstract methods.
   - Interface is a blueprint of a class containing abstract methods and constants.
   - Differences:

      - Interface supports multiple inheritance whereas abstract class does not support it.
      - Interface contains only method declarations, no method implementations until Java 8 (default and static methods with implementations were introduced), whereas abstract class can contain both abstract methods and concrete methods.
      - Interface cannot have constructors whereas abstract class can have constructors that are called when a subclass object is created.
      - Interface: Fields are implicitly public, static, and final. Methods are implicitly public or in java 8 ((default and static methods were introduced) whereas abstract class can have access modifiers for methods and fields.
      - Interface is for implementing classes whereas abstract class is for extended by subclasses.

15. See CodingQuestions



16. What are Queue interface implementations and what are the differences and when to use what?

   - Implementations include: AbstractQueue, ArrayBlockingQueue, ArrayDeque, ConcurrentLinkedDeque, ConcurrentLinkedQueue, DelayQueue, LinkedBlockingDeque, LinkedBlockingQueue, LinkedList, LinkedTransferQueue, PriorityBlockingQueue, PriorityQueue, SynchronousQueue.
   - Some of the most widely used implementations include: ArrayDeque, LinkedList, PriorityQueue.
   - Differences:
     - LinkedList: Suitable when flexibility is needed in terms of queue operations and when both ends of the queue require frequent access.
       Slower for large queues or for operations involving frequent addition/removal of elements.
     - ArrayDeque: Suitable for a general-purpose FIFO queue when fast insertion and removal from both ends are essential.
       Preferred over LinkedList when the focus is on performance and memory efficiency.
     - PriorityQueue: Ideal when elements need to be processed based on priority.
       Not suitable for cases requiring a strict FIFO order, as elements are ordered by priority.
   - Useage:
     - LinkedList: When flexibility in terms of queue operations (e.g., adding/removing elements from both ends) is required. For smaller queues where performance is not a primary concern.
     - ArrayDeque: For general FIFO queue operations requiring good performance and memory efficiency. When elements are added or removed frequently from both ends of the queue.
     - PriorityQueue: When elements need to be processed based on priority. When a strict FIFO order is not required, and priority-based processing is essential.