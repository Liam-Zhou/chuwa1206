# 5. Write the Singleton design pattern include eager load and lazy load.

```
public class EagerSingleton {

    private static final EagerSingleton instance = new EagerSingleton();

    private EagerSingleton() {}

    public static EagerSingleton getInstance() {
        return instance;
    }
}

```

```
public class LazySingleton {

    private static LazySingleton instance;

    private LazySingleton() {}

    public static LazySingleton getInstance() {
        if (instance == null) {
            instance = new LazySingleton();
        }
        return instance;
    }
}

```

# 6. What is Runtime Exception? could you give me some examples?

Unchecked exceptions that occur during program execution and don't need to be explicitly declared in the method's throws clause. Examples include NullPointerException, ArrayIndexOutOfBoundsException, and NumberFormatException.

# 7. Could you give me one example of NullPointerException?

Occurs when trying to access a member or method of a null object. For example, calling null.method() would throw this exception.

# 8. What is the Optional class?

Introduces a container for values that might be present or absent, avoiding null checks and potential NullPointerExceptions.

# 9. What are the advantages of using the Optional class?

Improves code clarity and readability by explicitly handling null values.
Reduces null checks and potential NullPointerExceptions.
Provides chaining methods for concise and expressive operations.

# 10. What is the @FunctionalInterface?

An annotation applied to an interface that declares a single abstract method. Used for lambda expressions to identify compatible interfaces.

# 11. what is lamda?

Anonymous function introduced in Java 8 that allows concise implementation of functional interfaces. It replaces bulky anonymous classes for simpler and cleaner code.

# 12. What is Method Reference?

A shorthand syntax for lambda expressions that refer to existing methods. Simplifies lambda creation by referencing existing methods instead of writing anonymous blocks.

# 13. What is Java 8 new features?

Lambda expressions and functional interfaces
Streams API for collection processing
Optional class for null handling
Date and Time API improvements
New methods in existing classes

# 14. Lambda can use unchanged variable outside of lambda? what is the details?

Lambdas can access final or effectively final variables declared outside the lambda body. Modifying these variables from within the lambda is not allowed.

# 15. Describe the newly added features in Java 8?

Lambda expressions and functional programming
Stream API for parallel and concurrent operations
New collection methods (forEach, removeIf, etc.)
Interface improvements (default methods, static methods)
Optional class for null handling

# 16. Can a functional interface extend/inherit another interface?

A functional interface can extend another functional interface (single abstract method) or non-functional interface (multiple methods). It inherits all methods but must still have its own abstract method.

# 17. What is the lambda expression in Java and How does a lambda expression relate to a functional interface?

Lambda expressions implement the single abstract method of a functional interface. The lambda body defines the implementation, and the interface signature defines the expected behavior.

# 18. In Java 8, what is Method Reference?

A shorthand syntax for creating lambda expressions that refer to existing methods. Simplifies lambda creation by referencing existing methods instead of writing anonymous blocks.

# 19. What does the String::ValueOf expression mean?

A method reference expression that refers to the valueOf method of the String class. It can be used as a lambda expression in stream operations to create String objects from other data types.

# 20. What are Intermediate and Terminal operations?

Intermediate: Transform and manipulate stream elements without performing the final computation. Examples include filter, map, and sorted.
Terminal: Produce a final result from the stream. Examples include findFirst, count, and forEach.

# 21. What are the most commonly used Intermediate operations?

filter: Selects elements based on a predicate.
map: Transforms each element into a new element.
sorted: Sorts elements in a specific order.
distinct: Removes duplicates from the stream.

# 22. What is the difference between findFirst() and findAny()?

findFirst: Returns the first element in the stream, or Optional.empty if no element exists.
findAny: Returns any element in the stream, or Optional.empty if no element exists. Both are non-deterministic if the stream is parallel.

# 23. How are Collections different from Stream?

Collections: Data structures that hold elements, support access and modification, and offer various iterator-based methods.
Streams: Represent sequences of elements and provide functional operations for data processing without modifying the original collection. Offer concise and efficient operations compared to iterators.
