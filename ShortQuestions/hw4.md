1.  What is generic in Java? and type the generic code by yourself.

    In Java, generic allows classes and methods to operate on objects of various types while providing **compile-time type safety**. Generics enable you to write code that can work with different data types without sacrificing type safety. Generic also increases and **code reusability**.

    **generic class**

    ```
    public class GenericClass<T> {
    // T -> Integer, User, Product
    T obj;

    public GenericClass(T obj) {
        this.obj = obj;
    }

    public T getObj() {
        return this.obj;
    }
    }
    ```

    **generic method**

    ```
    public static < T extends Comparable<T>> T maximum(T x, T y, T z) {
         T max = x;

         if (y.compareTo(max) > 0) {
             max = y;
         }

         if (z.compareTo(max) > 0) {
             max = z;
         }
         return max;
     }
    ```

    note: This example generic T extends Comparable class, so that variable y and z have an access to `compareTo()` function.

2.  code has created in the directory: Coding Questions/ShoppingCartUtil.java
3.  no answer need for this question.
4.  no answer need for this question.
5.  Write the Singleton design pattern include eager load and lazy load.

    **eager load**

    ```
    public class Singleton {
         // 1, private static variable
         private static Singleton instance = new Singleton();
         // 2, make constructor be private
         private Singleton() {}
         // 3. static getInstance method
         public static Singleton getInstance() {
            return instance;
         }
     }
    ```

    **lazy load**

    ```
    public class Singleton {
        // Private constructor to prevent instantiation from outside the class
        private Singleton() {}
        static{
            // initialization
        }
        // Static inner class to hold the Singleton instance
        private static class SingletonHolder {
        private static final Singleton INSTANCE = new Singleton();
        }
        // Public static method to get the Singleton instance
        public static Singleton getInstance() {
            return SingletonHolder.INSTANCE;
        }
    }
    ```

6.  What is Runtime Exception? could you give me some examples?

    **Runtime or Unchecked Exceptions**: Runtime or Unchecked exceptions are not checked at compile-time; they are detected only at runtime. Unchecked exceptions usually result from programming errors, such as attempting to access an array index that does not exist or dividing by zero. Developers are not required to catch or declare unchecked exceptions, but they can if they want to.

    - NullPointerException (NPE)
    - IndexOutOfBoundsException (e.g. List/Array)
    - ClassCastException
    - SecurityException

7.  Could you give me one example of NullPointerException?

    ```
    public class NullPointerExceptionExample {
     public static void main(String[] args) {
         // Creating a String variable
         String greeting = null;

         // Attempting to get the length of the String
         try {
             int length = greeting.length(); // This line will throw a NullPointerException
             System.out.println("Length of greeting: " + length);
         } catch (NullPointerException e) {
             System.err.println("NullPointerException caught: " + e.getMessage());
             }
         }
     }
    ```

8.  What is the Optional class?

    `Optional` is a class introduced in Java to deal with the problem of null references. It is designed to provide a more expressive and safer way to represent values that might be absent. The primary goal of `Optional` is to help avoid null pointer exceptions and make code more readable by explicitly stating when a value may be absent.

9.  What are the advantages of using the Optional class?

    More effective and safer way to handle possibly null values. Using Optional objects, we can avoid NullPointerException and make the code more concise and readable.

10. What is the @FunctionalInterface?

    In Java, the `@FunctionalInterface` annotation is used to indicate that an interface is intended to be a functional interface. A functional interface is an interface that contains only one abstract method.

11. What is lamda?

    In Java, a lambda expression is a concise way to express anonymous functions (i.e. functions that do not have a name). Lambda expressions are often used in conjunction with `functional interfaces`, which are interfaces that have exactly one abstract method (SAM - Single Abstract Method). These interfaces are also known as functional interfaces, and they can be implemented using lambda expressions.

12. What is Method Reference?

    Method references are used to directly access existing methods or constructors of a class or instance. Method references provide a way to reference a method without executing it, which requires a target type context consisting of a compatible functional interface. When evaluated, a method reference creates an instance of the functional interface.

13. What is Java 8 new features?

    - Functional programming ideas
    - Lambda expression
    - Stream API
    - Optional class

14. Lambda can use unchanged variable outside of lambda? What is the details?

    As long as the memory address of the variable does not change, the variable can be used by lambda.

    - Final variable
    - Non-final variable however never changed
    - Object variable (if we use new to reassign a new memory, then this variable is changed, can not be used in lambda)

15. Describe the newly added features in Java 8.

    1. **Lambda Expressions**: Lambda expressions provide a concise syntax for representing anonymous functions. They allow you to treat functionality as a method argument, making it easier to express instances of single-method interfaces (functional interfaces). Lambda expressions are particularly useful when working with the Stream API for processing collections of data.
    2. **Functional Interfaces**: Functional interfaces are interfaces that have exactly one abstract method. Java 8 introduced the @FunctionalInterface annotation to indicate that an interface is intended to be used as a functional interface. Functional interfaces are a key part of the lambda expression feature.
    3. **Streams**: The Stream API provides a fluent and functional approach to processing collections of data. Streams allow you to express complex data manipulations using a pipeline of operations, such as filtering, mapping, and reducing. They work well with lambda expressions.
    4. **Optional class**: Optional is a class introduced in Java to deal with the problem of null references. It is designed to provide a more expressive and safer way to represent values that might be absent. The primary goal of Optional is to help avoid null pointer exceptions and make code more readable by explicitly stating when a value may be absent.

16. Can a functional interface extend/inherit another interface?

    Yes, a functional interface in Java can extend or inherit another interface, as long as it adheres to the rules of functional interfaces. A functional interface is an interface that has exactly one abstract method, and it can contain any number of default or static methods.

    When a functional interface extends another interface, it inherits the abstract methods from that interface. If the extended interface has more than one abstract method, the compiler will raise an error, unless the extending interface provides default methods to override or implement the additional abstract methods.

17. What is the lambda expression in Java and How does a lambda expression relate to a functional interface?
    In Java 8, a lambda expression is a concise way to express anonymous functions (i.e. functions that do not have a name).Lambda expressions are often used in conjunction with `functional interfaces`, which are interfaces that have exactly one abstract method (SAM - Single Abstract Method). These interfaces are also known as functional interfaces, and they can be implemented using lambda expressions.
18. In Java 8, what is Method Reference?

    Method references provide a shorthand notation for expressing lambda expressions that call a method. They allow you to refer directly to a method by its name.

19. What does the String::ValueOf expression mean?

    The expression `String::valueOf` is an example of a method reference in Java. It is a shorthand notation that can be used to refer to a method without invoking it. In this particular case, `String::valueOf` refers to the static valueOf method of the String class, and it is overloaded to convert different types of values to their string representations. This method is commonly used to convert primitive types and objects to strings.

20. What are Intermediate and Terminal operations?

    In Java Streams, operations can be classified into two main categories: intermediate operations and terminal operations.

    **Intermediate Operations:**
    Intermediate operations are operations that transform a stream into another stream. They are usually applied to the elements of the stream and produce a new stream as a result.

    Example:

    - **filter(Predicate<T> predicate):** Returns a stream consisting of elements that match the given predicate.
    - **map(Function<T, R> mapper):** Applies a function to each element of the stream and returns a stream of the results.
    - **distinct():** Returns a stream consisting of distinct elements.
    - **sorted():** Returns a stream sorted according to the natural order of the elements.
    - **limit(long maxSize):** Returns a stream consisting of the first maxSize elements.

    **Terminal Operations:**
    erminal operations are operations that produce a result or a side-effect. When a terminal operation is invoked on a stream, it triggers the processing of the stream and consumes its elements.

    Example:

    - **forEach(Consumer<T> action):** Performs an action for each element of the stream.
    - **toArray():** Converts the elements of the stream into an array.
    - **collect(Collector<T, A, R> collector):** Transforms the elements of the stream into a different form, usually a collection.
    - **reduce(BinaryOperator<T> accumulator):** Performs a reduction on the elements of the stream using an associative accumulation function.
    - **count():** Returns the count of elements in the stream.
    - **anyMatch(Predicate<T> predicate)**: Returns true if any elements of the stream match the given predicate.

21. What are the most commonly used Intermediate operations?

    Refer to the example above.

22. What is the difference between findFirst() and findAny()?

    In Java 8 Streams, both findFirst() and findAny() are terminal operations that return an Optional containing the first element of the stream, if any. However, there is a subtle difference between them:

    **findFirst():**

    - **Behavior**: Returns the first element of the stream, or an empty Optional if the stream is empty.
    - **Use Case**: Useful when the order of elements in the result matters, and you want the first element of the stream.

    **findAny():**

    - **Behavior:** Returns any element of the stream, or an empty Optional if the stream is empty. The element returned is not guaranteed to be the first one and can vary between different executions, especially when using parallel streams.
    - **Use Case:** Useful when you don't care about the order of elements and just want to find any element that satisfies the given conditions.

23. How are Collections different from Stream?

    Collections and Streams are both concepts in Java that deal with data, but they serve different purposes and have different characteristics.

    **Collections:**

    - **Mutability**: Collections are generally mutable. You can add, remove, or modify elements within a collection after it has been created.

    - **Storage**: Collections store elements in memory.

    - **Load**: Collections use eager evaluation. This means that when you create a collection, all the elements are computed and stored in memory at that moment.

    - **External Iteration**: Iterating over a collection is done using constructs like loops (e.g., `for` or `foreach`), and you explicitly control the iteration.

    - **Terminal Operations**: Operations on collections are typically done using explicit iteration, and terminal operations return values or perform side effects.

    **Streams:**

    - **Mutability**: Streams are generally immutable. Once a stream is created, its source data is not modified. Instead, operations on streams produce new streams.

    - **Functional Operations**: Streams provide a set of functional-style operations (e.g., `map`, `filter`, `reduce`) that allow you to express complex data manipulations in a concise and declarative manner.

    - **Load**: Streams use lazy evaluation. Elements are processed and computed only when needed, which can lead to more efficient use of resources.

    - **External Iteration**: Iterating over a stream is done internally by the stream itself. The iteration is abstracted away, and you don't explicitly control it.

    - **Terminal Operations**: Operations on streams are divided into intermediate and terminal operations. Intermediate operations return a new stream, and terminal operations produce a result or a side effect.
