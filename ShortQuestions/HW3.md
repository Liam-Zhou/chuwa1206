## 1. Pratice Collection
In Progress

## 2. What is the checked exception and unchecked exception in Java, could you give one example?

**Checked Exceptions:**

- Checked exceptions are those that the Java compiler forces you to handle explicitly by either using a try-catch block or by declaring the exception using the `throws` clause in the method signature.
- These exceptions are typically related to external factors that a program might encounter, such as file input/output operations or network-related issues.

```Java
//Example
public class CheckedExceptionExample {
    public static void main(String[] args) {
        try {
            // Opening a file that may not exist
            BufferedReader reader = new BufferedReader(new FileReader("nonexistentfile.txt"));
            String line = reader.readLine();
            System.out.println(line);
        } catch (IOException e) {
            // Handling the checked exception
            System.err.println("IOException: " + e.getMessage());
        }
    }
}

```
In this example, `FileReader` and `readLine()` can throw `IOException`, which is a checked exception. The program is required to handle this exception either by catching it or declaring it in the method signature.

**Unchecked Exceptions:**

- Unchecked exceptions, also known as runtime exceptions, are exceptions that do not need to be explicitly caught or declared. They are usually caused by programming bugs and are not checked at compile time.
- Examples include `NullPointerException`, `ArrayIndexOutOfBoundsException`, and `ArithmeticException`.

```Java
public class UncheckedExceptionExample {
    public static void main(String[] args) {
        // Attempting to access an array element that does not exist
        int[] numbers = {1, 2, 3};
        System.out.println(numbers[5]); // This line will throw ArrayIndexOutOfBoundsException
    }
}
```
In this example, trying to access `numbers[5]` leads to an `ArrayIndexOutOfBoundsException`, which is an unchecked exception. Unchecked exceptions do not require explicit handling, but it's good practice to address the underlying issues in the code to prevent such exceptions.

## 3. Can there be multiple finally blocks?
The finally block is used to specify a block of code that will be executed whether an exception is thrown or not. There can be only one finally block associated with a try-catch statement. 
However, it's important to note that there can have nested try-catch-finally blocks, and each try block can have its own finally block.

## 4. When both catch and finally return values, what will be the final result?
When both a `catch` block and a `finally` block return values, the value returned by the `finally` block takes precedence.

## 5. What is Runtime/unchecked exception? what is Compile/Checked Exception?

Same as Q2

**Checked Exceptions:**

- Checked exceptions are those that the Java compiler forces you to handle explicitly by either using a try-catch block or by declaring the exception using the `throws` clause in the method signature.
- These exceptions are typically related to external factors that a program might encounter, such as file input/output operations or network-related issues.


**Unchecked Exceptions:**

- Unchecked exceptions, also known as runtime exceptions, are exceptions that do not need to be explicitly caught or declared. They are usually caused by programming bugs and are not checked at compile time.
- Examples include `NullPointerException`, `ArrayIndexOutOfBoundsException`, and `ArithmeticException`.


## 6. What is the difference between throw and throws?

**throw:**

- The `throw` keyword is used to explicitly throw an exception within a program.
- It is followed by an instance of an exception or a subclass of `Throwable`.
- This is useful when you want to signal that a particular exceptional condition has occurred during the execution of your code.

**throws:**

- The `throws` keyword is used in a method declaration to indicate that the method may throw certain types of exceptions.
- It specifies the exception types that might be thrown during the execution of the method.
- It is part of the method signature and is followed by a list of exception classes.

## 7. Run the below three pieces codes, Noticed the printed exceptions. why do we put the Null/Runtime exception before Exception ?
  
In Java, `NullPointerException` is a specific type of runtime exception that occurs when a program attempts to access or invoke a method on an object reference that is `null`. It is a subclass of `RuntimeException`. When handling exceptions, it is generally recommended to handle more specific exceptions first before catching more general ones.

## 8. What is optional? why do you use it? write an optional example

`Optional` is a class introduced in Java 8 to represent an optional value. It is designed to provide a more expressive and safer way to deal with situations where a value might be absent or present. The primary motivation behind `Optional` is to avoid null references and make it explicit in the code when a value may be absent.

Key points about `Optional`:

1. **Avoiding Null References:**
    
    - `Optional` encourages developers to explicitly handle the case when a value may be absent instead of relying on null references.
2. **Expressiveness:**
    
    - The use of `Optional` in the code makes it clear that a value might be absent, enhancing code readability.
3. **Safer Operations:**
    
    - `Optional` provides methods for performing operations on the value in a way that avoids null checks, making the code safer.

Here's an example of using `Optional`:

```java
import java.util.Optional;

public class OptionalExample {
    public static void main(String[] args) {
        // Creating an Optional with a non-null value
        Optional<String> presentOptional = Optional.of("Hello, Optional!");

        // Creating an Optional with a potentially null value
        String nullableValue = null;
        Optional<String> nullableOptional = Optional.ofNullable(nullableValue);

        // Creating an empty Optional
        Optional<String> emptyOptional = Optional.empty();

        // Using Optional to perform operations on the value
        if (presentOptional.isPresent()) {
            String value = presentOptional.get();
            System.out.println("Present Optional Value: " + value);
        }

        // Using ifPresent to perform an action if the value is present
        presentOptional.ifPresent(value -> System.out.println("Value is present: " + value));

        // Using orElse to provide a default value if the Optional is empty
        String result = emptyOptional.orElse("Default Value");
        System.out.println("Result with orElse: " + result);

        // Using map to transform the value if present
        String transformedValue = presentOptional.map(s -> s.toUpperCase()).orElse("No Value");
        System.out.println("Transformed Value: " + transformedValue);

        // Using filter to conditionally process the value
        Optional<String> filteredOptional = presentOptional.filter(s -> s.length() > 10);
        System.out.println("Filtered Optional: " + filteredOptional.orElse("No Value"));

        // Chaining multiple operations using flatMap
        Optional<String> chainedOptional = presentOptional.flatMap(s -> Optional.of(s + " - Chained"));
        System.out.println("Chained Optional: " + chainedOptional.orElse("No Value"));
    }
}

```

In this example, `Optional` is used to handle cases where a value might be absent or present. Methods like `ifPresent`, `orElse`, `map`, `filter`, and `flatMap` provide expressive ways to interact with the value inside the `Optional`. The use of `Optional` helps make the code more robust and less prone to null pointer exceptions.

## 9. Why finally always be executed ?

The primary purpose of the `finally` block is to ensure that certain code is executed, whether normal execution occurs or an exception is thrown.
Here are some specific reasons:
1. **Cleanup Operations:**
    
    - The `finally` block is often used to define code that performs cleanup operations, such as closing resources (e.g., closing a file or a database connection) or releasing acquired resources (e.g., releasing locks or network connections).
    - Ensuring that cleanup code in the `finally` block runs regardless of exceptions helps maintain the integrity of the program's state.
2. **Guaranteed Execution:**
    
    - The `finally` block is executed even if an uncaught exception propagates up the call stack. This ensures that critical cleanup tasks are completed even in the presence of unexpected errors.
    - Without the `finally` block, if an exception occurs and is not caught in a preceding `catch` block, the program would terminate, and any cleanup code would be skipped.
3. **Exception Handling Flow:**
    
    - When an exception is thrown, the Java runtime searches for an appropriate `catch` block to handle the exception. After the `catch` block is executed (if found), the `finally` block is executed before control is transferred out of the try-catch-finally structure.
    - If no matching `catch` block is found, the `finally` block is still executed before the exception propagates up the call stack or before the program terminates.

## 10. What are the types of design patterns in Java ?

In Java, design patterns are categorized into three main types:

1. **Creational Patterns:**
    
    - These patterns deal with the process of object creation. They provide mechanisms to create objects in a manner suitable to the situation, while also making the system independent of the specific classes being instantiated.
    - Examples include:
        - Singleton Pattern
        - Factory Method Pattern
        - Abstract Factory Pattern
        - Builder Pattern
        - Prototype Pattern
2. **Structural Patterns:**
    
    - Structural patterns are concerned with the composition of classes and objects. They help form larger structures from individual parts, making it easier to manage and understand the relationships between them.
    - Examples include:
        - Adapter Pattern
        - Bridge Pattern
        - Composite Pattern
        - Decorator Pattern
        - Facade Pattern
        - Flyweight Pattern
        - Proxy Pattern
3. **Behavioral Patterns:**
    
    - Behavioral patterns focus on the interaction and communication between objects. They define the ways in which classes interact and communicate with each other, enabling flexible and extensible systems.
    - Examples include:
        - Chain of Responsibility Pattern
        - Command Pattern
        - Interpreter Pattern
        - Iterator Pattern
        - Mediator Pattern
        - Memento Pattern
        - Observer Pattern
        - State Pattern
        - Strategy Pattern
        - Template Method Pattern
        - Visitor Pattern

## 11. What are the SOLID Principles ?

The SOLID principles are a set of five design principles that, when followed, help create more maintainable, scalable, and flexible software. These principles were introduced by Robert C. Martin and are widely used in object-oriented programming and software design. The SOLID acronym represents five individual principles:

1. **Single Responsibility Principle (SRP):**
    
    - A class should have only one reason to change, meaning that it should have only one responsibility or job.
    - This principle encourages a class to be focused on doing one thing well, making the class more maintainable and easier to understand.
2. **Open/Closed Principle (OCP):**
    
    - Software entities (such as classes, modules, and functions) should be open for extension but closed for modification.
    - This means that you can add new functionality to a system without altering existing code. This is typically achieved through the use of interfaces, abstract classes, and polymorphism.
3. **Liskov Substitution Principle (LSP):**
    
    - Subtypes must be substitutable for their base types without altering the correctness of the program.
    - In other words, if a class is a subclass of another class, it should be able to be used interchangeably with its parent class without affecting the correctness of the program.
4. **Interface Segregation Principle (ISP):**
    
    - A class should not be forced to implement interfaces it does not use.
    - This principle suggests that it's better to have several small, specific interfaces rather than a large, general-purpose interface. This helps prevent classes from being burdened with methods they don't need.
5. **Dependency Inversion Principle (DIP):**
    
    - High-level modules should not depend on low-level modules; both should depend on abstractions. Abstractions should not depend on details; details should depend on abstractions.
    - This principle promotes the use of dependency injection and inversion of control to decouple high-level modules from low-level modules, reducing the overall coupling in a system.

By adhering to the SOLID principles, developers can create more modular, maintainable, and extensible software. These principles contribute to the development of code that is easier to understand, modify, and extend, ultimately leading to more robust and scalable software systems.

## 12. How can you achieve thread-safe singleton patterns in Java ?

Here are a few ways to achieve thread-safe singleton patterns in Java:
1. Eager Initialization:
```java
public class ThreadSafeSingleton {
    private static final ThreadSafeSingleton instance = new ThreadSafeSingleton();

    // Private constructor to prevent instantiation from outside
    private ThreadSafeSingleton() {}

    public static ThreadSafeSingleton getInstance() {
        return instance;
    }
}
```
2. Lazy Initialization **(Thread-safe if using synchronized method)**
```Java
public class ThreadSafeSingleton {
    private static ThreadSafeSingleton instance;

    // Private constructor to prevent instantiation from outside
    private ThreadSafeSingleton() {}

    public static synchronized ThreadSafeSingleton getInstance() {
        if (instance == null) {
            instance = new ThreadSafeSingleton();
        }
        return instance;
    }
}

```
3. **Double-Checked Locking**
```java
public class ThreadSafeSingleton {
    private static volatile ThreadSafeSingleton instance;

    // Private constructor to prevent instantiation from outside
    private ThreadSafeSingleton() {}

    public static ThreadSafeSingleton getInstance() {
        if (instance == null) {
            synchronized (ThreadSafeSingleton.class) {
                if (instance == null) {
                    instance = new ThreadSafeSingleton();
                }
            }
        }
        return instance;
    }
}

```
4. **Bill Pugh Singleton Design**
```java
public class ThreadSafeSingleton {
    private ThreadSafeSingleton() {}

    private static class SingletonHelper {
        private static final ThreadSafeSingleton instance = new ThreadSafeSingleton();
    }

    public static ThreadSafeSingleton getInstance() {
        return SingletonHelper.instance;
    }
}

```

## 13. What do you understand by the Open-Closed Principle (OCP) ?

The Open-Closed Principle states:
"Software entities (such as classes, modules, and functions) should be open for extension but closed for modification."

Key points of the Open-Closed Principle:

1. **Open for Extension:**
    
    - The term "open" in the principle implies that the behavior of a module can be extended. New functionality can be added without changing the existing code.
2. **Closed for Modification:**
    
    - The term "closed" implies that once a module is completed and tested, its source code should not be modified to add new features. Instead, new functionality should be added through extension mechanisms.
3. **Benefits:**
    
    - The primary benefit of adhering to the Open-Closed Principle is that it promotes a design that is more maintainable, robust, and scalable. Existing code is less likely to be broken when new features are added.
4. **Achieving OCP:**
    
    - Achieving the Open-Closed Principle often involves using techniques such as abstraction, inheritance, and interfaces to create flexible and extensible designs.
    - Common patterns to achieve OCP include the use of abstract classes, interfaces, and polymorphism.

## 14. Liskov’s substitution principle states that if class B is a subtype of class A, then object of type A may be substituted with any object of type B. What does this actually mean? (from OA ) choose your answer.


It means if a method is present in class A, it should also be present in class B so that the object of type B could substitute object of type A.

## 15. Watch the design pattern video, and type the code, submit it to MavenProject folder