## 1. Checked and Unchecked Exceptions
* Checked Exception: These are exceptions that are checked at compile time. Example: IOException. They must be either caught or declared in the method signature.
* Unchecked Exception: These are exceptions that are not checked at compile time. Example: NullPointerException. They are under the RuntimeException class and don't need to be declared or caught.

## 2. Multiple finally blocks
No, there cannot be multiple finally blocks for a single try block. However, you can have a finally block for each try block in your code.

## 3. Return Values in Catch and Finally
If both catch and finally blocks have return statements, the return statement in the finally block will be executed, and it will override the return value from the catch block.

## 4. Runtime/Unchecked Exception vs Compile/Checked Exception:
* Runtime/Unchecked Exception: They are not checked at compile-time, indicating errors that mostly occur due to programming mistakes. Example: ArithmeticException.
* Compile/Checked Exception: They are checked at compile-time, where the compiler expects the code to handle or declare these exceptions. Example: FileNotFoundException.

## 5. Difference Between throw and throws
* throw is used to explicitly throw an exception from a method or any block of code.
* throws is used in the method signature to declare that the method might throw the specified exceptions.

## 6. Exception Handling in Provided Code
Order of Exceptions: In Java, exception handling should start from the most specific to the most general ones. NullPointerException and RuntimeException are more specific than Exception. If Exception were put first, it would catch all exceptions, making specific catch blocks redundant or unreachable.

## 7. What is Optional in Java?
Optional is a container object used to contain not-null objects. It's used to avoid NullPointerException in Java applications.

`Optional<String> optional = Optional.of("Hello");
 if(optional.isPresent()) {
    System.out.println(optional.get());
}`

## 8. Why Finally Block is Always Executed
The finally block is always executed to ensure that the necessary cleanup code is run regardless of whether an exception occurred or not.

## 9.Types of Design Patterns in Java
Generally, design patterns are categorized into three types:
Creational Patterns (like Singleton, Factory, Builder)
Structural Patterns (like Adapter, Composite, Proxy)
Behavioral Patterns (like Observer, Strategy, Command)

## 10.SOLID Principles
They are five design principles intended to make software designs more understandable, flexible, and maintainable.
S: Single Responsibility Principle
O: Open/Closed Principle
L: Liskov Substitution Principle
I: Interface Segregation Principle
D: Dependency Inversion Principle

## 11.Thread-Safe Singleton Pattern
This can be achieved by making the singleton instance a private static final variable, or by using double-checked locking with a volatile variable.

## 12.Open-Closed Principle (OCP)
This principle states that software entities (classes, modules, functions, etc.) should be open for extension, but closed for modification. It means one should be able to extend a class's behavior without modifying it.

## 13.Liskov’s Substitution Principle: The correct interpretation is
It means that if the object of type A can do something, the object of type B could also be able to perform the same thing.