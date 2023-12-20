1. [Here](..\MavenProject2\hw4)

2. [Here](..\MavenProject2\hw4)

3. [Here](..\MavenProject2\03-stream-api-exercises)

4. [Here](..\MavenProject2\hw4)

5. Singleton:

   1. Eager Loading Singleton:

      ```java
      public class EagerSingleton {
          private static final EagerSingleton instance = new EagerSingleton();
      
          private EagerSingleton() {
          }
      
          public static EagerSingleton getInstance() {
              return instance;
          }
      }
      ```

   2. Lazy Loading Singleton:

      ```java
      public class LazySingleton {
          private static LazySingleton instance = null;
      
          private LazySingleton() {
          }
      
          public static LazySingleton getInstance() {
              if (instance == null) {
                  instance = new LazySingleton();
              }
              return instance;
          }
      }
      ```

6.  Runtime exception occurs during the execution of a program at runtime. These exceptions are typically not checked by the compiler, which means you're not required to handle them explicitly using try-catch blocks or specify them in the throws clause of a method. Runtime exceptions typically result from programming errors or unexpected conditions in your code. 

7. ```java
   public class NullPointerExceptionExample {
       public static void main(String[] args) {
           String str = null;
           int length = str.length(); // This will throw a NullPointerException
       }
   }
   ```

8. The `Optional` class is a container class introduced in Java 8 to represent an optional value. It is used to handle situations where a value might be present or absent, helping to avoid `NullPointerExceptions` and making your code more robust. 

9. There are several advantages of using the `Optional` class: 1. avoid or handle NullPointerExceptions; 2. improve the readability and intent; 3. enforce the explicit handling; 4. provide default values; 5. implify conditional logics

10. The `FunctionalInterface` is a special type of Interface in which contains one and only one abstract method. The implementation of the FunctionalInterface can use lambda, which greatly simplify the usage and ease the workload.

11.  Lambda expression (or lambda function) is a concise way to represent an anonymous function. It is often used to implement the FunctionalInterface.

12. Method references are especially useful when you have a lambda expression that does nothing more than calling a single method, as they allow you to eliminate the lambda boilerplate and make the code more expressive.

13. Java 8 introduced several significant features and enhancements to the Java programming language, including: Lambda expressions, FunctionalInterface, Stream, Default methods, and Method references.

14. Yes, lambda can use unchanged variable outside of lambda. However, there is a restriction: the variable's value must not be changed after assigned. For instance, variables declared with `final` can be used in lambda; in other cases, we need to manually to make sure that the values are never changed once assigned.

15. Java 8 introduced several significant features and enhancements to the Java programming language, including: Lambda expressions, FunctionalInterface, Stream, Default methods, and Method references.

16. Yes, a functional interface in Java can extend or inherit from another interface just like any other interface. A functional interface is essentially an interface with a single abstract method. When you extend another interface, you're adding more abstract methods, but as long as there is only one abstract method declared in the extended interface hierarchy, the interface can still be considered a functional interface, provided it meets the other criteria for functional interfaces.

17. A lambda expression in Java is a concise way to represent an anonymous function, which can be used to create instances of functional interfaces. It provides a more readable and compact syntax for defining and passing behavior in your code. Lambda expressions were introduced in Java 8 and are a fundamental part of the functional programming support in the language.

18. Method references are especially useful when you have a lambda expression that does nothing more than calling a single method, as they allow you to eliminate the lambda boilerplate and make the code more expressive.

19. The `String::valueOf` expression in Java is an example of a method reference. It is a shorthand notation for referring to a method, and in this case, it refers to the `valueOf` method of the `String` class.

20. Intermediate operations transform a stream's elements and return a new stream. Terminal operations produce a result or a side effect, ending the stream pipeline.

21. These are some commonly used intermediate operations:

    1. **`filter`**: Used to filter elements based on a given predicate.
    2. **`map`**: Transforms elements by applying a function to each element.
    3. **`flatMap`**: Flattens nested streams into a single stream.
    4. **`distinct`**: Removes duplicate elements from the stream.
    5. **`sorted`**: Sorts the elements of the stream based on natural order or a comparator.
    6. **`peek`**: Performs a side effect on each element without affecting the stream.
    7. **`limit`**: Limits the stream to a specified maximum number of elements.
    8. **`skip`**: Skips a specified number of elements in the stream.

22. `findFirst()` returns the first element of the stream (if ordered), while `findAny()` returns any element (not necessarily the first) from the stream (useful in parallel streams or when order doesn't matter).

23. Collections are data structures that store and manage a collection of elements in memory, allowing you to access and manipulate them directly. Streams, on the other hand, are a sequence of elements that enable functional-style processing of data without the need to store them in memory. Streams are designed for processing data in a more declarative and efficient manner, often using lazy evaluation.