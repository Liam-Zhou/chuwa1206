## 2. Checked and Unchecked Exceptions in Java
1. **Checked exceptions** are exceptions that must be either **caught** or **declared in the method signature** using `throws`. They are checked at **compile-time**.

Example: IOException is a common checked exception, often encountered in file operations.
```java
import java.io.FileReader;
import java.io.IOException;

public class FileReaderExample {
    public void readFile(String file) throws IOException {
        FileReader reader = new FileReader(file);
        // read the file
    }
}
```
2. **Unchecked exceptions** are **not** checked at compile-time. They are usually errors that reflect some kind of programming or logical flaw in the code, like passing **invalid arguments** or **null pointer access**.

Example: `NullPointerException`, use an object reference that has the null value.

```java
public class NullPointerExceptionExample {
    public void printLength(String str) {
        System.out.println(str.length()); // Throws NullPointerException if str is null
    }
}
```
## 3. Multiple Finally Blocks
   No, there **cannot** be multiple finally blocks for a single try-catch block in Java. Each try-catch block can be followed by **only one** finally block.

## 4. Result When Both Catch and Finally Return a Value
   
   The return value from the `finally` block will be the final result of the `try-catch-finally` construct, overriding any return value from the `catch` block.

## 5. Runtime/Unchecked Exception vs Compile/Checked Exception
   1. Runtime/Unchecked Exception:
   They are not checked at compile-time, and the programmer is **not** required to handle or declare them.
   Examples: `ArithmeticException`, `NullPointerException`, `ArrayIndexOutOfBoundsException`.
   2. Compile/Checked Exception:
   Checked at compile time. The programmer **must** handle these exceptions either with a `try-catch` block or by declaring them with `throws`.
   Examples: `IOException`, `SQLException`.
## 6. Difference Between throw and throws
   1. throw: explicitly throw an exception from a method or any block of code. Throw one exception at a time.

      `throw new NullPointerException("Null reference");`

   2. throws: Used in the method signature to declare that a method might throw **one or more** exceptions.

      `public void myMethod() throws IOException, SQLException { }`

## 7. Catch order
1. The order in which these catch blocks are arranged follows the principle of **handling more specific exceptions before more general ones**.
2. If a catch block for a general exception (like `Exception`) is placed before more specific exception types, the **specific catch blocks become unreachable**. General catch block will intercept all exceptions, including those that the specific blocks are meant to handle.

## 8. What is Optional in Java? Why Use It? Example:
   1. **Definition:**
   `Optional` is a way to express an optional value (a value that might be present or absent).

   2. **Why Use Optional:**

      1. Null Safety: Reduces the risk of `NullPointerException`.
   
      2. More Readable Code: Makes the code more readable by explicitly handling the case of absent values.

      3. Functional Programming Style: Facilitates a functional programming approach, enabling operations like map, filter, and flatMap.
```java
import java.util.Optional;

public class OptionalExample {
    public static void main(String[] args) {
        Optional<String> optionalString = getOptionalString("Hello");

        // Check if value is present
        if (optionalString.isPresent()) {
            System.out.println(optionalString.get()); // Prints "Hello"
        }

        // Or use functional approach
        optionalString.ifPresent(System.out::println);
    }

    private static Optional<String> getOptionalString(String str) {
        // Returns an Optional containing 'str' if not null, otherwise returns an empty Optional
        return Optional.ofNullable(str);
    }
}
```

## 9. Why is finally Always Executed?
   This ensures the execution of important cleanup code, irrespective of what happens in the try and catch blocks.

## 10. Types of Design Patterns in Java
   Design patterns in Java are divided into three main categories

   1. **Creational Patterns:** Deal with object creation mechanisms, optimizing object creation compared to a basic approach. 

      Examples: Singleton, Factory, Builder, Prototype.

   
   2. **Structural Patterns:** Concerned with object composition and typically identify simple ways to realize relationships between different objects. 

      Examples: Adapter, Bridge, Composite, Decorator.


   3. **Behavioral Patterns:** Focus on communication between objects, how objects interact, and distribute responsibility. 

      Examples: Observer, Strategy, Command, Iterator.


## 11. SOLID Principles:

   SOLID is an acronym for five design principles intended to make software designs more understandable, flexible, and maintainable:

   **S** - Single Responsibility Principle: A class should have one and only one reason to change, meaning it should have only one job.

   **O** - Open/Closed Principle: Objects or entities should be open for extension but closed for modification.

   **L** - Liskov Substitution Principle: Objects of a superclass shall be replaceable with objects of its subclasses without breaking the application.

   **I** - Interface Segregation Principle: No client should be forced to depend on methods it does not use.

   **D** - Dependency Inversion Principle: High-level modules should not depend on low-level modules; both should depend on abstractions.

## 12.Achieving Thread-Safe Singleton in Java:

   1. **Eager Initialization:** Create the instance at the time of class loading.
   2. **Lazy Initialization with Synchronization:** Use synchronized keyword on the method returning the singleton instance. 
   3. **Double-Checked Locking:** Double-check the instance and then synchronize.
   4. **Using an Enum:** The simplest and most robust method, as Java ensures that the enum value is instantiated only once.

## 13. Open-Closed Principle (OCP):

   **Software entities (classes, modules, functions, etc.) should be open for extension, but closed for modification.**
   1. write code that doesn’t have to be changed every time the requirements change but can be extended by adding new code.
   2. This is typically achieved through the use of `interfaces`, `abstract classes`, and `design patterns` like Strategy or Decorator.

## 14. Liskov’s substitution principle
    

1. It means that if the object of type A can do something, the object of type B could also be able to perform the same thing.


2. **Explanation:**
    This principle emphasizes that a subclass should not only inherit the properties and methods of the parent class but also conform to the expected behavior (contract) of the parent class.