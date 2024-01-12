
### 1. What is Generic in Java?

Generics in Java are a feature that allows you to write code with type parameters, which makes the code more flexible and safer. It enables types (classes and interfaces) to be parameters when defining classes, interfaces, and methods.

```java
public class Box<T> {
    private T t;

    public void set(T t) { this.t = t; }
    public T get() { return t; }
}
```

### 5. Singleton Design Pattern
- **Eager Load Singleton**:

  ```java
  public class EagerSingleton {
      private static final EagerSingleton instance = new EagerSingleton();
      private EagerSingleton(){}
      public static EagerSingleton getInstance() {
          return instance;
    }
  }
  ```

  - **Lazy Load Singleton**:

    ```java
    public class LazySingleton {
      private static LazySingleton instance;
      private LazySingleton(){}
        
      // lock on LazySingleton.class
      public static synchronized LazySingleton getInstance(){
          if (instance == null){
              instance = new LazySingleton();
          }
          return instance;
        }
     
    }
    ```

### 6. What is Runtime Exception?
Runtime exceptions are exceptions that can occur during the execution of a program. They are unchecked exceptions and do not need to be declared in a method's `throws` clause. Examples include `NullPointerException`, `IndexOutOfBoundsException`, and `ArithmeticException`.

### 7. Example of NullPointerException
```java
public class NullPointerExceptionExample {
    public static void main(String[] args) {
        String str = null;
        int length = str.length(); // This line throws NullPointerException
    }
}
```

### 8. What is the Optional Class?
`Optional` is a container object used to contain not-null objects. It is used to avoid NullPointerException.

### 9. Advantages of Using the Optional Class
- Reduces the risk of `NullPointerException`.
- Provide cleaner code by using the provided helper functions.

### 10. What is the @FunctionalInterface?
    `@FunctionalInterface` annotation indicates that the interface is intended to be a functional interface (an interface with exactly one abstract method). The abstract method is implemented using lambda function.

### 11. What is Lambda?
    Lambda expressions in Java are a way to implement methods of functional interfaces. Lambda function is the implementation of SAM (Single Abstract Method).

### 12. What is Method Reference?
    Method references in Java 8 are a shorthand notation of a lambda expression to call a method. For example, `System.out::println` is a method reference for `x -> System.out.println(x)`.

### 13. Java 8 New Features
- Lambda expressions.
- Method references.
- Java Stream API
- `Optional` class
- Default methods in interfaces.
- `CompletableFuture` for asynchronous programming.

### 14. Can Lambda Use Unchanged Variable Outside of Lambda?
    Yes, but the variable must be effectively final (not modified after initialization).

### 15. Newly Added Features in Java 8
- Lambda expressions.
- Method references.
- Java Stream API
- `Optional` class
- Default methods in interfaces.
- `CompletableFuture` for asynchronous programming.

### 16. Can a Functional Interface Extend Another Interface?
    Yes, a functional interface can extend another interface, but the total number of abstract methods must not exceed one.

### 17. Lambda Expression and Functional Interface
    Lambda expressions in Java are a way to implement methods of functional interfaces. Lambda function is the implementation of SAM (Single Abstract Method).

### 18. Method Reference in Java 8
    Method references in Java 8 are a shorthand notation of a lambda expression to call a method. For example, `System.out::println` is a method reference for `x -> System.out.println(x)`.

### 19. String::ValueOf Expression
    `String::valueOf` is a method reference that refers to the `valueOf` method of the `String` class

### 20. What are Intermediate and Terminal operations?
    Intermediate operations in Java Streams are lazy and return another Stream, allowing chained operations. Terminal operations produce a result or a side-effect and terminate the Stream.

### 21. **Common Intermediate operations**: Some of the most commonly used intermediate operations in Java Streams are:
- `map`: Transforms each element of the stream.
- `filter`: Filters elements based on a predicate.
- `sorted`: Sorts elements based on a comparator.
- `distinct`: Removes duplicate elements based on `equals()` method.

### 22. **Difference between findFirst() and findAny()**: 
- `findFirst()`: Returns the first element of the stream. It's mostly used on ordered streams.
- `findAny()`: Returns any element of the stream. It can provide performance benefits on parallel streams as it's less constraining.

### 23. **Collections vs. Stream**: 
- Collections in Java (like List, Set, Map) are data structures that store elements.
- Streams don't store data and are often used to process data.