1. Practice collection

Done under CodingQuestions file

2. What is the checked exception and unchecked exception in Java, could you give one example?

Checked Exceptions: These are exceptions that are checked at compile time. In other words, if a method might throw a checked exception, it must either handle the exception using a try-catch block or declare it using the throws keyword. 
Example: IOException
Unchecked Exceptions: These are exceptions that are not checked at compile time. In other words, the compiler does not require methods to catch or declare these exceptions.
Example: NullPointerException

3. Can there be multiple finally blocks?

No, in Java, there cannot be multiple finally blocks associated with a single try-catch block. 

4. When both catch and finally return values, what will be the final result?

The return value from the finally block will be the one that actually gets returned from the method. The return statement in the catch block is overridden by the return statement in the finally block.

5. What is Runtime/unchecked exception? what is Compile/Checked Exception?

Unchecked exceptions are the exceptions that are not checked at compile-time. In other words, the compiler does not require that you handle or declare these exceptions.

Checked exceptions are exceptions that are checked at compile time. If a method is capable of causing an exception that it does not handle, it must declare this exception in its throws clause.

6. What is the difference between throw and throws?

throw: Used within a method to actively throw an exception.
throws: Used in a method declaration to indicate that the method might throw certain types of exceptions.

7. Run the below three pieces codes, Noticed the printed exceptions. why do we put the Null/Runtime
exception before Exception ?

The order of the catch blocks in Java is crucial because Java uses the first catch block that matches the thrown exception and ignores any subsequent catch blocks. 

First Code Example: The ArithmeticException is thrown due to division by zero. Since there is a specific catch block for ArithmeticException, it catches this exception. The other catch blocks for NullPointerException, RuntimeException, and Exception are not reached.

Second Code Example: Here, the NullPointerException is thrown because of the dereferencing of the null object s. The ArithmeticException catch block is skipped as it doesn't match, and the NullPointerException catch block catches the exception. The subsequent RuntimeException and Exception catch blocks are ignored.

Third Code Example: In this case, a RuntimeException is explicitly thrown. The ArithmeticException and NullPointerException catch blocks are bypassed as they don't match, and the RuntimeException catch block catches the exception. The general Exception catch block is not reached.

8.Why finally always be executed ?

In Java, the finally block is designed to run no matter what happens in the try and catch blocks, ensuring that important cleanup code is executed even if an exception occurs. This is crucial for resource management, like closing files or releasing network resources, to prevent resource leaks and maintain program stability.

9. Practice collection problems here

Done

10. What are the types of design patterns in Java?

In Java, design patterns are categorized into three types:
Creational Patterns: Focus on ways to create objects. Examples: Singleton, Factory, Builder.
Structural Patterns: Deal with object composition and arrangement. Examples: Adapter, Proxy, Decorator.
Behavioral Patterns: Concerned with object interaction and responsibility distribution. Examples: Observer, Strategy, Command.

11. What are the SOLID principles?

The SOLID principles in object-oriented programming are:
Single Responsibility Principle: A class should have one, and only one, reason to change.
Open/Closed Principle: Classes should be open for extension but closed for modification.
Liskov Substitution Principle: Subclasses should be substitutable for their base classes.
Interface Segregation Principle: Make fine-grained interfaces that are client-specific.
Dependency Inversion Principle: Depend on abstractions, not on concretions.

12. How can you achieve thread-safe singleton patterns in Java?

To achieve a thread-safe Singleton pattern in Java:
Eager Initialization: Create the instance at class loading time.
Synchronized Accessor: Use synchronized keyword in the getter method.
Double-Checked Locking (DCL): Check the instance twice with synchronization.

13.What do you understand by the Open-Closed Principle (OCP)?

The Open-Closed Principle (OCP) states that software entities (like classes, modules, functions) should be open for extension but closed for modification. This means we can add new functionality without changing existing code, typically using interfaces or abstract classes.

14. Liskov’s substitution principle states that if class B is a subtype of class A, then object of type A may be substituted with any object of type B. What does this actually mean? (from OA ) choose your answer.
It means that if the object of type A can do something, the object of type B could also be able to perform the same thing
It means that all the objects of type A could execute all the methods present in its subtype B
It means if a method is present in class A, it should also be present in class B so that the object of type B could substitute the object of type A.
It means that for class B to inherit class A, objects of type B and objects of type A must be the same.

1. should be the answer

15. Watch the design pattern video, and type the code, submit it to Maven Project folder

Done under the Maven Project folder
