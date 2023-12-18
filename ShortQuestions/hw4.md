#### 1. What is generic in Java? and type the generic code by yourself.
Generics are a feature in Java that allows you to write code with generic types or methods. They enable types (classes and interfaces) to be parameters when defining classes, interfaces, and methods. The primary purpose of generics is to provide type safety and to eliminate the need for type casting. They ensure that you use consistent types throughout your code.  
[Code](../Repo/MavenProject/java-core/src/main/java/generic)
#### 2. Read those codes and type it one by one by yourself. the push the code to your branch.
[Code](../Repo/MavenProject/java-core/src/main/java/java8)
#### 3. Practice stream API at least 3 times.
[Code](../Repo/MavenProject/stream-api-exercises/src/test/java/space/gavinklfong/demo/streamapi/StreamApiTestRewirte.java)
#### 4. Practice Optional methods at least 2 times.
[Code](../Repo/MavenProject/java-core/src/main/java/java8/exercise/ShoppingCartUtil.java)
#### 5. Write the Singleton design pattern include eager load and lazy load.
##### Eagerly Loaded Singletons
1. **Classic Singleton**
      ```java
      public class Singleton {
          private static final Singleton INSTANCE = new Singleton();
          
          private Singleton() {}
 
          public static Singleton getInstance() {
              return INSTANCE;
          }
      }
      ```

2. **Static Block Singleton**
      ```java
      public class Singleton {
          private static final Singleton INSTANCE;
          
          static {
                  INSTANCE = new Singleton();
          }
          
          private Singleton() {}
 
          public static Singleton getInstance() {
              return INSTANCE;
          }
      }
      ```

##### Lazily Loaded Singletons

1. **Lazy Initialization Singleton**
      ```java
      public class Singleton {
          private static Singleton instance;
          
          private Singleton() {}
 
          public static Singleton getInstance() {
              if (instance == null) {
                  instance = new Singleton();
              }
              return instance;
          }
      }
      ```

2. **Thread-Safe Singleton**
      ```java
      public class Singleton {
          private static Singleton instance;
          
          private Singleton() {}
 
          public static synchronized Singleton getInstance() {
              if (instance == null) {
                  instance = new Singleton();
              }
              return instance;
          }
      }
      ```

3. **Double-Checked Locking Singleton**
      ```java
      public class Singleton {
          private static volatile Singleton instance;
          
          private Singleton() {}
 
          public static Singleton getInstance() {
              if (instance == null) {
                  synchronized (Singleton.class) {
                      if (instance == null) {
                          instance = new Singleton();
                      }
                  }
              }
              return instance;
          }
      }
      ```

4. **Bill Pugh Singleton**
      ```java
      public class Singleton {
          private Singleton() {}
 
          private static class Holder {
              private static final Singleton INSTANCE = new Singleton();
          }
 
          public static Singleton getInstance() {
              return Holder.INSTANCE;
          }
      }
      ```

5. **Enum Singleton**
      ```java
      public enum Singleton {
          INSTANCE
      }
      ```

#### 6. What is Runtime Exception? could you give me some examples?
A RuntimeException in Java is an exception that can occur during the execution of a program. These exceptions are unchecked exceptions, meaning they do not need to be declared in a method's `throws` clause.
##### Examples of Runtime Exceptions
1. **NullPointerException**: Occurs when an application tries to use an object reference that has the null value.
2. **ArrayIndexOutOfBoundsException**: Occurs when an array has been accessed with an illegal index.
3. **ArithmeticException**: Thrown when an exceptional arithmetic condition has occurred. For example, dividing by zero.
4. **IllegalArgumentException**: Thrown to indicate that a method has been passed an illegal or inappropriate argument.
5. **IllegalStateException**: Occurs when a method has been invoked at an illegal or inappropriate time.

#### 7. Could you give me one example of NullPointerException?
Example: Accessing a method of a null object.
```java
String str = null;
int length = str.length(); // This will throw NullPointerException
```
#### 8. What is the Optional class?
`Optional` is a container class introduced in Java 8. The main purpose of `Optional` is to provide a way to reduce the likelihood of `NullPointerException`. It is used to represent the result of an operation that can either yield a result or not. 
#### 9. What are the advantages of using the Optional class?
By using `Optional`, you can explicitly express that a variable can be null, making the code more readable and maintainable.
#### 10. What is the @FunctionalInterface?
`@FunctionalInterface` is an annotation in Java, introduced in Java 8. It indicates that the annotated interface is intended to be a functional interface. A functional interface is an interface that contains exactly one abstract method.
#### 11. What is lambda?
A lambda expression is a short block of code which takes in parameters and returns a value. Lambda expressions are similar to methods, but they do not need a name and they can be implemented right in the body of a method.
#### 12. What is Method Reference?
A Method Reference in Java is a simplified way of expressing a lambda expression that executes just one method.
#### 13. What is Java 8 new features?
- **Lambda Expressions**: Enable you to treat functionality as a method argument, or code as data, facilitating functional programming styles in Java.
- **Stream API**: Provides a new abstraction called Stream that lets you process data in a declarative way, supporting operations like filter, map, sort, and reduce.
- **Method References**: Used to refer methods by their names and are expressed using the `::` symbol; they make your code more concise and readable.
- **Optional Class**: Helps in reducing the number of null checks needed and can help in avoiding `NullPointerException`.
- **Default Methods in Interfaces**: Allow the addition of new methods to interfaces without breaking the existing implementation of these interfaces.
- **Nashorn JavaScript Engine**: A much-improved javascript engine is introduced in JDK 8 to replace the existing Rhino. Nashorn provides 2 to 10 times better performance, as it directly compiles the code in memory and passes the bytecode to JVM.
- **New Date and Time API**: Offers a comprehensive and standardized set of date and time classes that are more intuitive and easy to use.
- **`forEach` method in Iterable Interface**: Enables you to iterate over a collection more verbosely and clearly.
- **Functional Interfaces**: An interface with just one abstract method, which are targeted by lambda expressions and method references.
- **Concurrent Accumulators**: New additions in `java.util.concurrent` package that provide better support for parallel processing.
- **Collectors Class in Streams**: Offers utility methods for common tasks, such as converting a stream into a collection or aggregating elements of a stream.
- **New JavaFX Features**: Improvements and new additions to JavaFX to enhance the development of rich client applications.
- **Type Annotations**: Provide the ability to apply an annotation anywhere you use a type, such as in declarations, generics, and casts.
- **Parallel Operations on Arrays**: The `Arrays` class has been equipped with a set of parallel sort methods that use the fork/join framework for better performance.
- **CompletableFuture**: Provides a way to write non-blocking asynchronous code, which is crucial for developing responsive applications.
- **Repeating Annotations**: Allow you to apply the same annotation to a declaration or type use more than once.
#### 14. Lambda can use unchanged variable outside of lambda? what is the details?
In lambda expressions, you can only use local variables that are _effectively final_. An effectively final variable is one whose value does not change after it is first assigned. There is no need to explicitly declare these variables as final, but they effectively cannot be modified after initial assignment.
#### 15. Describe the newly added features in Java 8?
[Please refer to Question 13](#13-what-is-java-8-new-features)
#### 16. Can a functional interface extend/inherit another interface?
A functional interface in Java can extend another interface, but there are certain conditions that must be met for the extended interface to remain functional.
- The extended interface must not have any abstract methods itself, or if it does, the functional interface must provide implementations for them.
- Essentially, after the extension, the total number of abstract methods in the functional interface (considering methods from the parent interface) must be exactly one.
#### 17. What is the lambda expression in Java and How does a lambda expression relate to a functional interface?
[What is the lambda expression](#11-what-is-lambda)  
A lambda expression can be considered as an instance of a functional interface. It provides a concise way to implement the abstract method of a functional interface.
#### 18. In Java 8 what is Method Reference?
[Please refer to Question 12](#12-what-is-method-reference)
#### 19. What does the String::ValueOf expression mean?
`String::valueOf` is a method reference in Java, which refers to the `valueOf` method of the `String` class.
#### 20. What are Intermediate and Terminal operations?
- **Intermediate Operations**: Intermediate operations are operations that transform a stream into another stream, such as `map`, `filter`, `sorted`. They are lazy, meaning they don't start processing the data when they are called. Instead, they create a new stream and process data only when a terminal operation is initiated.
- **Terminal Operations**: Terminal operations are operations that produce a result or a side-effect, such as `forEach`, `collect`, `reduce`. Once a terminal operation is performed, the stream pipeline is considered consumed, and it can no longer be used.
#### 21. What are the most commonly used Intermediate operations?
For example: `map`, `filter`, `sorted`
#### 22. What is the difference between findFirst() and findAny()?
- `findFirst()` is a terminal operation that returns the first element from the stream. It is typically used in scenarios where the stream has a defined encounter order. In a sequential stream, it will return the first element according to the encounter order.  
- `findAny()` is also a terminal operation but it returns any element from the stream. It is useful in scenarios where the order is not important, such as in parallel processing.  
- In a parallel stream, `findAny()` is generally more performant than `findFirst()`, as it doesn't have to process the entire stream to find the first element.
#### 23. How are Collections different from Stream?
- Collections in Java are primarily focused on storing and managing groups of data elements, like Lists, Sets, or Maps, and they are mutable with explicit iteration mechanisms. In contrast, Streams do not store data but instead provide a pipeline for computational operations, such as map, filter, and reduce, enabling efficient data processing, particularly with large datasets. 
- While Collections are about data storage and can be iterated multiple times, Streams are about expressing complex data processing queries, are traversable only once, and are lazily executed, allowing for optimized, on-demand computations and easy parallel processing.