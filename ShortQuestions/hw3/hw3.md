### Question 2
Checked Exception are exceptions that are checked at compile time. It means if a method is throwing a checked exception, it must either handle the exception using try-catch or it must declare the exception using throws keyword. For example, IOException is a checked exception.
Unchecked Exceptionare exceptions that are not checked at compile time. They are also called runtime exceptions. Unchecked exceptions are subclasses of RuntimeException, and they are usually due to programming errors. For example, NullPointerException is an unchecked exception.

### Question 3
No, there cannot be multiple finally blocks for a single try block. Each try block can be followed by either a single finally block or no finally block at all.

### Question 4
If both catch and finally blocks have return statements, the return value from the finally block will be the final result of the try-catch-finally construct. The return value from the catch block will be overridden by the finally block's return value.

### Question 5
Runtime/Unchecked Exception are exceptions that are not checked at compile time and are typically the result of programming errors. Examples include NullPointerException, ArrayIndexOutOfBoundsException.
Compile/Checked Exception are checked at compile time, and the compiler ensures that they are either caught or declared in the method signature. Examples include IOException, SQLException.

### Question 6
throw keyword is used within a method to throw an exception. It is followed by an instance of an exception class. It is used to explicitly throw an exception.
throws keyword is used in the method signature to declare that a method might throw one or more exceptions. It doesn't throw the exception but declares that it might, allowing callers of the method to handle or propagate it.

### Question 7
When handling exceptions in Java, especially in a try-catch block with multiple catch clauses, it's crucial to order the catch blocks from most specific to least specific. This is because catch blocks are checked and matched in the order they are written.

### Question 8
Optional is a container object which may or may not contain a non-null value. Introduced in Java 8, it's a way to express optional or nullable values instead of using null. This can help prevent NullPointerException issues and leads to cleaner, more readable code.

### Question 9
finally block follows a try-catch block and is executed after the try and catch blocks have finished executing, regardless of whether an exception was thrown or caught. The purpose of the finally block is to provide a mechanism to cleanly release resources held by the program, such as closing file streams or database connections

### Question 10
Creational Patterns deal with object creation mechanisms, trying to create objects in a manner suitable to the situation
Structural Patterns are concerned with how classes and objects can be composed, to form larger structures.
Behavioral Patterns are concerned with algorithms and the assignment of responsibilities between objects. 

### Question 11
SOLID is an acronym representing five key principles of object-oriented programming and design:

### Question 12
Create the singleton instance at the time of class loading. This doesn't provide a lazy-loading advantage. Also, use a synchronized method to control the creation of the singleton instance, ensuring only one thread can execute the creation method at a time.

### Question 13
The Open-Closed Principle states that software entities should be open for extension, but closed for modification. This means you should be able to add new functionality or components to the system without changing the existing code. 

### Question 14
It means that if the object of type A can do something, the object of type B could also be able to perform the same thing.