## HW3

# Q1

# Q2  What is the checked exception and unchecked exception in Java, could you give one example.
- **Checked Exceptions**: All exceptions other than RuntimeException and Error are known as Checked exception. These exceptions are checked by the compiler at the compile time. E.g. `FileNotFoundException`, `SQLException`, `IOException`, etc.

- **Unchecked Exceptions**: Runtime Exceptions are known as Unchecked exceptions. Compiler does not force us to handle these exceptions. E.g. `NullPointerException`, `ArithmeticException`, `ArrayIndexOutOfBoundException`, etc.


# Q3 Can there be multiple finally blocks?
You cannot have multiple `finally` blocks associated with a single `try` block, but you can have multiple `finally` blocks if they are associated with different `try` blocks.


# Q4 When both catch and finally return values, what will be the final result?
The return value in `finally` block will be the final result.


# Q5 What is Runtime/unchecked exception? what is Compile/Checked Exception?
- **Checked/Compile Exceptions**: All exceptions other than RuntimeException and Error are known as Checked exception. These exceptions are checked by the compiler at the compile time. E.g. `FileNotFoundException`, `SQLException`, `IOException`, etc.

- **Unchecked/Runtime Exceptions**: Runtime Exceptions are known as Unchecked exceptions. Compiler does not force us to handle these exceptions. E.g. `NullPointerException`, `ArithmeticException`, `ArrayIndexOutOfBoundException`, etc.


# Q6 What is the difference between throw and throws?
- `throw` is a keyword which is used to explicitly throw an exception in the program, inside a function or inside a block of code, whereas `throws` is a keyword which is used with the method signature to declare an exception which might get thrown by the method while executing the code

- `throw` keyword is followed by an instance of an Exception class whereas `throws` is followed by Exception class names

- You can `throw` one exception at a time but you can declare multiple exceptions using `throws` keyword

- Using `throw` keyword, only unchecked exceptions are propagated, whereas using `throws` keyword both checked and unchecked exceptions can be propagated.


# Q7 Run the below three pieces codes, Noticed the printed exceptions. why do we put the Null/Runtime exception before Exception ?

Because `Exception` will catch all exceptions if it is before `Null/Runtime Exception`. In such case, the specific Null/Runtime exception handling code will never be executed and they will cause syntax error. 


# Q7 What is optional? why do you use it? write an optional example.
`Optional` is a container object introduced in Java 8, used to represent a value that is either present or absent. The primary purpose of `Optional` is to provide a type-level solution for representing optional values instead of using `null`. This can help in avoiding `NullPointerException` and improves the readability and maintainability of the code by providing a clear and explicit way to deal with the presence or absence of a value. Example:

```
import java.util.Optional;

public class OptionalExample {
    public static void main(String[] args) {
        // Create an Optional object from a non-null value
        Optional<String> optionalValue = Optional.of("Hello World");

        // Check if a value is present
        if (optionalValue.isPresent()) {
            // Get the value
            String value = optionalValue.get();
            System.out.println("Value: " + value);
        }

        // Create an Optional object that may be null
        Optional<String> emptyOptional = Optional.ofNullable(null);

        // Use orElse to provide a default value in case of null
        String defaultValue = emptyOptional.orElse("Default Value");
        System.out.println("Default: " + defaultValue);

        // Using functional-style operations
        optionalValue.ifPresent(v -> System.out.println("Value is present: " + v));
    }
}

```

# Q8 Why finally always be executed ?
The `finally` block in Java is designed to be executed always, regardless of what happens in the `try` block or any `catch` blocks that may be associated with it. This consistent execution is guaranteed in several scenarios:

- **Normal Completion**: If the `try` block completes normally, without throwing any exceptions, the `finally` block will be executed after the `try` block.

- **Exception Handled**: If an exception is thrown in the `try` block and is caught in one of the `catch` blocks, the `finally` block will be executed after the corresponding `catch` block.

- **Exception Not Handled**: If an exception is thrown in the `try` block but is not caught (because there are no matching catch blocks or no catch blocks at all), the `finally` block will still be executed before the method exits.

- **Return Statement**: If a return statement is encountered in the `try` or `catch` block, the `finally` block will execute right before the method actually returns.

- **Break, Continue, or Throw**: If a `break`, `continue`, or `throw` statement is used within a `try` or `catch` block, the `finally` block will execute before those statements take effect.

# Q9 Practice Collection problems

# Q10 What are the types of design patterns in Java ?

- **Singleton Pattern**: Ensures that a class has only one instance and provides a global point of access to it.

- **Factory Method Pattern**: Defines an interface for creating an object, but lets subclasses alter the type of objects that will be created.

- **Abstract Factory Pattern**: Provides an interface for creating families of related or dependent objects without specifying their concrete classes.

- **Strategy Pattern**: Defines a family of algorithms, encapsulates each one, and makes them interchangeable. Strategy lets the algorithm vary independently from clients that use it.

- **Builder Pattern**: Separates the construction of a complex object from its representation, allowing the same construction process to create various representations.

- **Observer Pattern**: Defines a dependency between objects so that when one object changes state, all its dependents are notified automatically.

# Q11 What are the SOLID Principles ?
1. Single Responsibility Principle (SRP)
	- Principle: A class should have one, and only one, reason to change. This means that a class should only have one job or responsibility.
	- Purpose: This principle aims to reduce the complexity of code by ensuring that a class is only focused on doing one thing and therefore has fewer reasons to change. It leads to better organization of code and easier maintenance.
2. Open/Closed Principle (OCP)
	- Principle: Software entities (classes, modules, functions, etc.) should be open for extension but closed for modification.
	- Purpose: This means you should be able to add new functionality to an entity without changing its existing code. It encourages the use of interfaces or abstract classes to enable making changes without modifying existing code, leading to more robust and less error-prone software.
3. Liskov Substitution Principle (LSP)
	- Principle: Objects of a superclass should be replaceable with objects of its subclasses without affecting the correctness of the program.
	- Purpose: This principle ensures that a subclass can stand in for its parent class. It leads to correct hierarchy in the inheritance structure and ensures that inherited classes are not overriding the base class's behavior in unexpected ways.
4. Interface Segregation Principle (ISP)
	- Principle: Clients should not be forced to depend on interfaces they do not use.
	- Purpose: This principle encourages creating more specific interfaces rather than general-purpose ones, so clients only need to know about the methods that are of interest to them. It helps in reducing the side effects of changes in code and makes the software easier to refactor.
5. Dependency Inversion Principle (DIP)
	- Principle: High-level modules should not depend on low-level modules. Both should depend on abstractions. Abstractions should not depend on details. Details should depend on abstractions.
	- Purpose: This principle promotes the decoupling of software modules, allowing high-level modules to be isolated from the changes in low-level modules. It leads to a codebase that is more resilient to changes and easier to update or maintain.

# Q12 How can you achieve thread-safe singleton patterns in Java ?
- Eager Initialization
- Static Block Initialization
- Lazy Initialization with Synchronization
- Double-Checked Locking (DCL)
- Bill Pugh Singleton Implementation (Initialization-on-demand holder idiom)
- Enum Singleton

# Q13 What do you understand by the Open-Closed Principle (OCP) ?
OCP means that software entities (classes, modules, functions, etc.) should be open for extension but closed for modification. This means you should be able to add new functionality to an entity without changing its existing code. It encourages the use of interfaces or abstract classes to enable making changes without modifying existing code, leading to more robust and less error-prone software.

# Q14 Liskov’s substitution principle states that if class B is a subtype of class A, then object of type A may be substituted with any object of type B. What does this actually mean? (from OA ) choose your answer.

1. It means that if the object of type A can do something, the object of type B could also be able to perform the same thing.

# Q15 Watch the design pattern video, and type the code, submit it to MavenProject folder.