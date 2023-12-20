1. What is generic in Java?

   - Generics in Java provide a way to create classes, interfaces, and methods with placeholders for the types (classes and interfaces) that they operate on. The main purpose of generics is to enable stronger type checking at compile time and to create more flexible and reusable code.

2. See Q2
   
   


3. See Q3




4. See Q4




5. Write the Singleton design pattern include eager load and lazy load.

    - See Q5


6. What is Runtime Exception? could you give me some examples?

    - Runtime Exception is also called compile time exception, which is an exception that occurs during the execution of a program at runtime.
        - Examples: NullPointerException, ArrayIndexOutOfBoundsException, ArithmeticException, etc.

7. Could you give me one example of NullPointerException?

    - See Q7


8. What is the Optional class?

    - `Optional` is a class introduced in Java 8 to address the problem of dealing with null values and to provide a more expressive and safer way to represent the possibility of a value being absent.


9. What are the advantages of using the Optional class?

    - We can use the `Optional` class to wrap our data and avoid the classical null checks and some of the try-catch blocks. As a result, we'll be able to chain method calls and have more fluent, functional code.


10. What is the @FunctionalInterface?

    - `@FunctionalInterface` is an informative annotation type used to indicate that an interface type declaration is intended to be a functional interface as defined by the Java Language Specification.

11. what is lamda?

    - A lambda expression in Java is a concise way to represent an anonymous function, also known as a lambda function or lambda. It was introduced in Java 8 as part of the Java Programming Language's functional programming features.

12. What is Method Reference?

    - Method reference in Java is a shorthand notation of a lambda expression used to call a method. Include:
      - Static Method Reference
      - Instance Method Reference on a Particular Instance
      - Instance Method Reference on an Arbitrary Instance
      - Constructor Reference

13. What is Java 8 new features?

    - Some of the key Java 8 new features include:
        - Lambda Expressions: Lambda expressions enable the use of functional programming constructs in Java. They provide a concise syntax for writing anonymous methods (functions).
        - Functional Interfaces: Functional interfaces are interfaces that have exactly one abstract method.
        - Stream API: The Stream API provides a fluent and functional approach to processing collections of data.
        - Default Methods: Default methods allow interfaces to have method implementations.
        - Method References: Method references provides a shorthand notation for writing lambda expressions when the lambda body simply calls an existing method
        - Optional: The Optional class is introduced to handle the presence or absence of values more effectively.
        - New Date and Time API: In The `java.time` package.

14. Lambda can use unchanged variable outside of lambda? what is the details?

    - Yes. As long as the variable is effectively final, which means the value does not change after it is initially assigned.

15. Describe the newly added features in Java 8?

    - Lambda Expressions: Lambda expressions enable the use of functional programming constructs in Java. They provide a concise syntax for writing anonymous methods (functions).
    - Functional Interfaces: Functional interfaces are interfaces that have exactly one abstract method.
    - Stream API: The Stream API provides a fluent and functional approach to processing collections of data.
    - Default Methods: Default methods allow interfaces to have method implementations.
    - Method References: Method references provides a shorthand notation for writing lambda expressions when the lambda body simply calls an existing method
    - Optional: The Optional class is introduced to handle the presence or absence of values more effectively.
    - New Date and Time API: In The `java.time` package.

16. Can a functional interface extend/inherit another interface?

    - A functional interface can extend another interface only when it does not have any abstract method.

17. What is the lambda expression in Java and How does a lambda expression relate
    to a functional interface?

    - A lambda expression is a concise way to express an anonymous function. A functional interface is an interface with a single abstract method (SAM). Lambda expressions can be used to provide the implementation of that single abstract method, making the code concise.

18. In Java 8, what is Method Reference?

    - Method reference in Java is a shorthand notation of a lambda expression used to call a method. Include:
      - Static Method Reference
      - Instance Method Reference on a Particular Instance
      - Instance Method Reference on an Arbitrary Instance
      - Constructor Reference

19. What does the String::ValueOf expression mean?

    - `String::valueOf` is a method reference that refers to the valueOf method of the String class. This method is a static method in the String class. The syntax `String::valueOf` is a shorthand for a lambda expression. It is equivalent to the lambda expression `(x) -> String.valueOf(x)`.

20. What are Intermediate and Terminal operations?

    - Intermediate operations are operations used to process data in Stream, which take Stream object and return Stream object.
    - Terminal operations are operations used to collect data in Stream, which take Stream object but return non-Stream object so the stream terminates.

21. What are the most commonly used Intermediate operations?

    - filter
    - limit
    - skip
    - distinct
    - map
    - flatMap
    - sort

22. What is the difference between findFirst() and findAny()?

    - `findFirst()` method returns the first element in the stream whereas `findAny()` method returns any elements that satisfy the condition.

23. How are Collections different from Stream?

    1. Collections are data structures that hold all the data elements whereas Streams do not store data, and have the ability to process an infinite number of elements on demand.
    2. It is easy to access elements in Collections whereas there is no direct way of accessing specific elements in Stream.
    3. Elements in collections can be processed any times whereas can only be processed once in Stream.
    4. Collections do External Iteration whereas Streams do Internal Iteration.
