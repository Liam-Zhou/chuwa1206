## 2. What is the checked exception and unchecked exception in Java, could you give one example?

Checked Exception means the exception that happens in the compile time like the IOException and SQLException.

Unchecked Exception usually use in runtime, like the NullPointerException, indexOutOfBoundsException which may happen when the application runs.

## 3. Can there be multiple finally blocks?

There can be multiple finally blocks, the blocks will execute by the order of the code.

## 4. When both catch and finally return values, what will be the final result?

The final result will be the reture value by finally.

## 5. What is Runtime/unchecked exception? what is Compile/Checked Exception?

Runtime/unchecked exception is the exception that for codes after it runs. It may get the exception after we run the application.

Compile/Checked Exception is the exception when we compile the code. We will find the exception when we compile it.

## 6. What is the difference between throw and throws?

The throw keyword is used to explicitly throw an exception in a program.

The throws keyword is used in the method declaration to indicate that the method may throw one or more types of exceptions.

## 7. Run the below three pieces codes, Noticed the printed exceptions. why do we put the Null/Runtime exception before Exception?

The result will be catch by the ArithmeticException and NullPointerException.

The Exception will be caught from top to down, so we should code the exception scope from small to large. The scope of Exception is larger, we put the Null/Runtime exception before Exception.

## 8. What is optional? why do you use it? write an optional example.

It is designed to address the issue of dealing with potential null values and to provide a more expressive and safer way of handling such situations. 

Code please see the HW3/Coding2/src/OptionalDemo

## 10. What are the types of design patterns in Java?

Creational Design Patterns: Singleton Pattern, Factory Method Pattern, Abstract Factory Pattern

Structural Design Patterns: Adapter Pattern, Decorator Pattern, Facade Pattern

Behavioral Design Patterns: Observer Pattern, Strategy Pattern

## 11. What are the SOLID Principles?

S: Single Responsibility Principle, a class should have only one reason to change, meaning that it should have only one responsibility.

O: Open/Closed Principle, software entities (classes, modules, functions, etc.) should be open for extension but closed for modification.

L: Liskov Substitution Principle, objects of a superclass should be able to be replaced with objects of a subclass without affecting the correctness of the program.

I: Interface Segregation Principle, it encourages the creation of smaller, specific interfaces rather than a large, general-purpose one.

D: Dependency Inversion Principle, abstractions should not depend on details; details should depend on abstractions. This principle promotes the use of dependency injection, inversion of control, and programming to interfaces to achieve a flexible and maintainable design.

## 12. How can you achieve thread-safe singleton patterns in Java ?

We should use synchronized for the block when we create the object.

## 13. What do you understand by the Open-Closed Principle (OCP)

This principle promotes the idea that existing code should not be modified to add new functionality. Instead, new functionality should be added through extension, often achieved through the use of interfaces, abstract classes, and polymorphism.

## 14. The answer should be 1

## 15. Please see the MavanProject/src


