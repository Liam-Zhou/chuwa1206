# 1

Practice collection



# 2

What is the checked exception and unchecked exception in Java, could you give one example?

**Checked Exception**: These are exceptions that are checked at compile-time. This means that the code must handle these exceptions either by using a `try-catch` block or by declaring them in the method signature using the `throws` keyword. If not handled, the code will not compile. An example of a checked exception is `IOException`, which is thrown when an input/output operation fails or is interrupted.

Example:

``` Java
import java.io.*;

public class Example {
    public static void main(String[] args) {
        try {
            FileInputStream file = new FileInputStream("example.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

```

**Unchecked Exception**: These are exceptions that are not checked at compile-time, meaning the compiler does not require these exceptions to be caught or declared in the method signature. Unchecked exceptions are mostly due to programming errors, such as logic errors or improper use of an API. Unchecked exceptions are subclasses of `RuntimeException`. An example of an unchecked exception is `NullPointerException`, which occurs when a program attempts to use an object reference that has the `null` value.

Example:

``` Java
public class Example {
    public static void main(String[] args) {
        String text = null;
        try {
            int length = text.length(); 
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }
}

```



# 3

Can there be multiple finally blocks?

there cannot be multiple `finally` blocks associated with a single `try` block. Each `try` block can be followed by zero or more `catch` blocks and one `finally` block.



# 4

When both catch and finally return values, what will be the final result?

when both the `catch` block and the `finally` block contain `return` statements, the `return` statement from the `finally` block will always prevail. The value returned by the `finally` block will be the final result of the try-catch-finally construct, overriding any value that might have been returned from the `catch` block.



# 5

What is Runtime/unchecked exception? what is Compile/Checked Exception?

1. **Runtime/Unchecked Exceptions**:
   - **Definition**: Unchecked exceptions are the exceptions that are not checked at compile time. In other words, the compiler does not require these exceptions to be caught or declared in a method's `throws` clause.
   - **Subclass of**: They are subclasses of `RuntimeException`, and they represent problems that are a result of a programming error, such as logic errors or improper use of an API.
   - **Examples**: `NullPointerException`, `ArrayIndexOutOfBoundsException`, `ArithmeticException`, etc.
   - **Handling**: Unchecked exceptions do not need to be explicitly handled in the code. They can be caught and handled using a try-catch block, but it's not mandatory from a compiler's perspective.
2. **Compile-time/Checked Exceptions**:
   - **Definition**: Checked exceptions are the exceptions that are checked at compile time. The Java compiler forces the programmer to handle these exceptions, either with a try-catch block or by declaring them in the method signature using the `throws` keyword.
   - **Subclass of**: They are subclasses of `Exception` (but not `RuntimeException`).
   - **Examples**: `IOException`, `SQLException`, `ClassNotFoundException`, etc.
   - **Handling**: If a method might throw a checked exception, the method must either handle the exception with a try-catch block or declare it with a `throws` clause. If not handled, the code will not compile.



# 6

What is the difference between throw and throws?

- **`throw`**:
  - **Like an Action**:`throw` as if we are physically throwing a ball (where the ball represents an exception). When we use `throw` in a part of our code, it means we are creating and throwing an exception right there.
  - **For Example**: If we write `throw new NullPointerException();` in our code, it's like we are saying, "Hey, there's a problem here!" and then we throw an exception that represents this problem.
- **`throws`**:
  - **Like a Warning Sign**: On the other hand, `throws` is more like a warning sign. It's placed at the beginning of a method to tell others (or other parts of the code that call this method) that "Be aware, this method might throw certain types of balls (exceptions)."
  - **For Example**: If a method is declared as `void ourMethod() throws IOException`, it's akin to saying, "If you call our method, you need to be ready to catch, or deal with, the possibility of an IOException being thrown."

### Core Differences:

- **Where It's Used**: `throw` is used inside a method when we need to indicate that there's a problem; `throws` is used in the method declaration to alert others that the method might have potential issues.
- **Purpose**: `throw` is us actively throwing a problem (an exception), whereas `throws` is telling others that our method might have issues, so they should prepare for how to handle them.



# 7

Run the below three pieces codes, Noticed the printed exceptions. why do we put the Null/Runtime exception before Exception ?



The exceptions are put in this order (`ArithmeticException`, `NullPointerException`, then `RuntimeException`) to ensure that the most specific exceptions are caught first. If `Exception` were placed before these, it would catch all exceptions, and the specific exception handlers would never be reached, making them useless and the code containing them unreachable.



# 8

What is optional? why do you use it? write an optional example.



`Optional` in Java is used to avoid `null` references and to handle the absence of a value more gracefully.



``` Java
import java.util.Optional;

public class Example {
    public static void main(String[] args) {
        Optional<String> optional = Optional.ofNullable(null);
        optional.ifPresent(System.out::println);
    }
}

```

In this example, an `Optional` is created that might hold a `null`. The `ifPresent` method does nothing because the `Optional` is empty.



# 9

Why finally always be executed ?

1. **Guaranteed Execution**: It provides a guarantee that the code within it will be executed. This is particularly important for resource release and cleanup.
2. **Exception Handling**: Even if an exception is thrown in the `try` block and not caught in the `catch` blocks, the `finally` block will still execute.
3. **Return Statements**: If a `return` statement is executed within the `try` or `catch` block, the `finally` block will execute right before the method returns the value.



# 10

Practice collection problems here: https://github.com/TAIsRich/chuwa-eij-tutorial/tree/main/02-java-core/src/main/java/com/chuwa/exercise/collection





# 11

What are the types of design patterns in Java ?

**Creational Patterns**

- Singleton Pattern
- Factory Method Pattern
- Abstract Factory Pattern
- Builder Pattern
- Prototype Pattern

**Structural Patterns**

- Adapter Pattern
- Composite Pattern
- Proxy Pattern
- Flyweight Pattern
- Facade Pattern
- Bridge Pattern
- Decorator Pattern

**Behavioral Patterns**

- Strategy Pattern
- Observer Pattern
- Command Pattern
- Iterator Pattern
- Template Method Pattern
- Visitor Pattern
- Mediator Pattern
- Memento Pattern
- State Pattern
- Interpreter Pattern
- Chain of Responsibility Pattern



# 12

What are the SOLID Principles ?

The SOLID principles are a set of five design principles introduced by Robert C. Martin, which are intended to make software designs more understandable, flexible, and maintainable. They are guidelines that can be applied to object-oriented design to achieve a better design and allow for easier refactoring. 



# 13

How can you achieve thread-safe singleton patterns in Java ?

**Eager Initialization**:

public class Singleton {
    private static final Singleton INSTANCE = new Singleton();

```Java
public class Singleton {
    private static final Singleton INSTANCE = new Singleton();

    private Singleton() {}

    public static Singleton getInstance() {
        return INSTANCE;
    }
}


```


**Lazy Initialization**

``` Java
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



# 14

What do you understand by the Open-Closed Principle (OCP) ?

Imagine we have a software application, like a drawing program. The Open-Closed Principle suggests that this program should be designed in a way that allows it to be extended with new features without changing the existing code.

For example, if our drawing program can draw circles, and we want to add a feature to draw squares, the Open-Closed Principle says we should be able to add this new square drawing feature without altering the code that draws circles. We "open" the program for extension (adding new shapes) but "close" it for modification (not changing existing functionalities).

In simple terms, the Open-Closed Principle is about writing code that we can add to, without needing to rewrite or change the old code. This makes our code more flexible and easier to maintain.

# 15

Liskov’s substitution principle states that if class B is a subtype of class A, then object of type A may be substituted with any object of type B. What does this actually mean? (from OA ) choose your answer.

A is correct



1. It mean that if the object of type A can do something, the object of type B could also be able tp perform the same thing

2. It means that all the objects of type A could execute all the methods present in its subtype B

3. It means if a method is present in class A, it should also be present in class B so that the object of type B could substitute object of type A.

4. It means that for the class B to inherit class A, objects of type B and objects of type A must be same.



# 16

Watch the design pattern video, and type the code, submit it to MavenProject folder

singleton: https://www.bilibili.com/video/BV1Np4y1z7BU?p=22 Factory: https://www.bilibili.com/video/BV1Np4y1z7BU?p=35&vd_source=310561eab1216a27f7accf859bf7f6d9 Builder: https://www.bilibili.com/video/BV1Np4y1z7BU?p=50&vd_source=310561eab1216a27f7accf859bf7f6d9 Publisher_Subscriber: https://www.bilibili.com/video/BV1Np4y1z7BU?p=114&vd_source=310561eab1216a27f7accf859bf7f6d9



