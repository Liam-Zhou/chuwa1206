1. Write the Singleton design pattern include eager load and lazy load.
    - Eager Load:
    ```java
    public class Singleton {
        private Singleton() {}
        private static Singleton instance;
        static {
            instance = new Singleton();
        }    
        public static Singleton getInstance() {
            return instance;
        }
    }
    ```
    - Lazy Load:
    ```java
    public class Singleton {
        private Singleton() {}
        private static class singletonHolder {
            private static final Singleton INSTANCE = new Singleton();
        }
        public static Singleton getInstance() {
            return singletonHolder.INSTANCE;
        }
    }
    ```
2. What is Runtime Exception? could you give me some examples?
   - A runtime exception is an error that occurs during the execution of a program. These errors are also known as unchecked exceptions and do not need to be declared in a method or constructor’s throws clause if they can be thrown by the execution of the method or constructor and propagate outside the method or constructor boundary
   - NullPointerException. / ArithmeticExpection
3. Could you give me one example of NullPointerException?
    ```java
    public class Example {
        public static void main(String[] args) {
            String str = null;
            str.length(); // nullPointerException
        }
    }
    ```
4. What is the Optional class?
   - The Optional class is a container object that may or may not contain a non-null value. It is used to represent the presence or absence of a value, instead of using null to indicate the absence of a value. The class is part of the java.util package and was introduced in Java 8.
5. What are the advantages of using the Optional class?
   1. Reduced NullPointerExceptions
   2. Improved Readability
   3. Reduced Boilerplate Code
6. What is the @FunctionalInterface?
   - Indicate an interface is functional interface. Functional interface only has one abstract method and any number of default or static method.
7. what is lambda?
   - A lambda expression is a concise way to represent an anonymous function in code. It is essentially a block of code that can be passed around as an argument to a method or stored in a variable.
8. What is Method Reference?
   - In Java, a method reference is a shorthand syntax for invoking a method or constructor using a lambda expression. It allows you to pass a method or constructor as an argument to a method, without having to explicitly define a lambda expression.
9. What is Java 8 new features?
   1. Lambda expressions
   2. Method references
   3. Functional interface
   4. Stream API
   5. Default methods
   6. data and time API
   7. Optional class
   8. Nashorn JavaScript engine
10. Lambda can use unchanged variable outside of lambda? what is the details?
    > As long as the memory address of the variable does not change, the variable can be used by lambda
    - Using final variable
    - Using non-final variable: no matter before or after lambda function, the variable cannot be changed
    - Object variable: no matter before or after lambda function, the variable cannot be changed
11. Describe the newly added features in Java 8?
    - Lambda expressions: Lambda expressions provide a concise way to represent an anonymous function in code.
    - Method references: Method references provide a shorthand syntax for invoking a method or constructor using a lambda expression.
    - Functional interfaces: Functional interfaces are interfaces that contain exactly one abstract method and any number of default or static methods.
    - Stream API: The Stream API provides a way to perform bulk operations on collections of data.
    - Default methods: Default methods are methods that have a default implementation in an interface.
    - Date and time API: Java 8 introduced a new date and time API that provides a more comprehensive and flexible way to work with dates and times.
    - Optional class: The Optional class is a container object that may or may not contain a non-null value.
    - Nashorn JavaScript engine: Nashorn is a new JavaScript engine that is included with Java 8.
12. Can a functional interface extend/inherit another interface?
    - Yes, a functional interface can extend another interface. However, the resulting interface will only be considered a functional interface if it contains exactly one abstract method.
13. What is the lambda expression in Java and How does a lambda expression relate
    to a functional interface?
    ```java
    public class Example {
        public static void main(String[] args) {
        MyInterface myInterface = () -> System.out.println("Hello, World!");
            myInterface.doSomething();
        }
    
    
        @FunctionalInterface
        interface MyInterface {
            void doSomething();
        }
    }
    ```
    - In Java, a lambda expression is a concise way to represent an anonymous function in code. It is essentially a block of code that can be passed around as an argument to a method or stored in a variable.
14. In Java 8, what is Method Reference?
    - A method reference is a shorthand syntax for invoking a method or constructor using a lambda expression. It allows you to pass a method or constructor as an argument to a method, without having to explicitly define a lambda expression.
15. What does the String::ValueOf expression mean?
    - String::valueOf is a method reference that refers to the valueOf method of the String class. The valueOf method is a static method that returns the string representation of the specified argument.
16. What are Intermediate and Terminal operations?
    - Intermediate operations: Applied to a stream before the terminal operation. They are lazily loaded and do not give end results. Instead, they transform one stream to another stream.
    - Terminal operations: Applied to a stream after all intermediate operations have been applied. They produce a result or a side-effect and cannot be chained together.
17. What are the most commonly used Intermediate operations?
    - filter(Predicate p)
    - limit(n)
    - skip(n)
    - distinct()
18. What is the difference between findFirst() and findAny()?
    - findFirst(): Return the first element in the stream.
    - findAny(): Return any element in the stream.
    - If the stream is unordered, then both findFirst() and findAny() will return a random element from element.
19. How are Collections different from Stream?
    - Collections: storage data.
    - Stream: compute and process data.
    
      | Collections                                | Streams                                                                                  |
      |--------------------------------------------|------------------------------------------------------------------------------------------|
      | Data structure holds all the data elements | No data is stored. Have the capacity to process an infinite number of elements on demand |
      | External Iteration                         | Internal Iteration                                                                       |
      | Can be processed any number of times       | Traversed only once                                                                      |
      | Elements are easy to access                | No direct way of accessing specific elements                                             |
      | Is a data store                            | Is an API to process the data                                                            |