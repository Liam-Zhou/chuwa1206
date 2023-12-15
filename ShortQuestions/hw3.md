# HW3 
#### Practice collection
   
#### What is the checked exception and unchecked exception in Java, could you give one example?
- Checked exceptions are exceptions that are checked at compile-time. The Java compiler forces the developer to either handle these exceptions using a `try-catch` block or declare that the method throws the exception using the `throws` keyword. 
  e.g. `IOException`, `SQLException`, `FileNotFoundException`
-  Unchecked exceptions are exceptions that are checked at runtime. The compiler does not force the developer to catch or declare them. 
  e.g. `NullPointerException`, `ArrayIndexOutOfBoundsException`

#### Can there be multiple finally blocks?
No

#### When both catch and finally return values,what will be the final result?
The final result will be the return from the finally block

#### What is the difference between throw and throws?
- `Throw` keyword is used to explicitly throw an exception. It is used within a method or block of code to raise an exception manually.
- `Throws` is used in the function signiture to declare that a method may throw certain types of exceptions. For checked exceptions, they are either handled with a `try-catch` block or declare that the method throws the exception.

#### Why do we put the Null/Runtime exception before Exception?
Because Null/Runtime exceptions are more specific while exception is more general that covers the Null/Runtime cases. If reverse the order, the exceptions will be catch at ```catch (exceptions)``` and the check for Null/Runtime exceptions will never be achieved.

#### What is optional? Why do you use it? Write an optional example.
`Optional` is a container class introduced in Java 8 that is designed to represent an optional value, meaning a value that may or may not be present. It is useful for handling situations where a method could return a value or no value (null) and allows you to avoid null checks.

```Java
User user = new User("My name");
String name = Optional.ofNullable(user.getName()).orElse("Unknown");
```

#### Why finally always be executed?
The `finally` block in Java is designed to always be executed, regardless of whether an exception is thrown or not. This behavior ensures that important cleanup tasks are performed regardless of the program's flow.

#### What are the types of design patterns in Java?
1. Creational Design Patterns:
- These patterns deal with the process of object creation, providing ways to create objects while hiding the instantiation logic. They help make a system independent of how its objects are created, composed, and represented.
- Examples include:
    - Singleton Pattern: Ensures a class has only one instance and provides a global point of access to it.
    - Factory Method Pattern: Defines an interface for creating an object but lets subclasses alter the type of objects that will be created.
    - Abstract Factory Pattern: Provides an interface for creating families of related or dependent objects without specifying their concrete classes.
    
2. Structural Design Patterns:
- These patterns deal with the composition of classes or objects, forming larger structures.
- Examples include:
    - Adapter Pattern: Allows the interface of an existing class to be used as another interface.
    - Decorator Pattern: Attaches additional responsibilities to an object dynamically.
    - Composite Pattern: Composes objects into tree structures to represent part-whole hierarchies.
  
3. Behavioral Design Patterns:
These patterns focus on communication between objects, defining how they operate together and how they distribute responsibilities.
- Examples include:
    - Observer Pattern: Defines a one-to-many dependency between objects, so that when one object changes state, all its dependents are notified and updated automatically.
    - Strategy Pattern: Defines a family of algorithms, encapsulates each algorithm, and makes them interchangeable.
    - Command Pattern: Encapsulates a request as an object, thereby parameterizing clients with queues, requests, and operations.

#### What are SOLID principles?
The SOLID principles are a set of five design principles that aim to guide software design and promote maintainability, flexibility, and scalability in object-oriented programming. The acronym SOLID stands for:

- Single Responsibility Principle (SRP):

    - A class should have only one reason to change, meaning that a class should have only one responsibility or job. This principle encourages the separation of concerns, making classes more focused and easier to understand.
- Open/Closed Principle (OCP):

    - Software entities (classes, modules, functions, etc.) should be open for extension but closed for modification. In other words, you should be able to add new functionality without altering existing code. This is often achieved through the use of abstractions and interfaces.
- Liskov Substitution Principle (LSP):

    - Subtypes must be substitutable for their base types without altering the correctness of the program. In simpler terms, if a class is a subtype of another class, it should be able to replace its parent class without affecting the behavior of the program.
- Interface Segregation Principle (ISP):

    - A class should not be forced to implement interfaces it does not use. This principle promotes the creation of specific, client-specific interfaces rather than large, general-purpose ones. Clients should not be forced to depend on interfaces they do not use.
- Dependency Inversion Principle (DIP):

    - High-level modules should not depend on low-level modules. Both should depend on abstractions. Abstractions should not depend on details; details should depend on abstractions. This principle encourages the use of dependency injection and inversion of control to achieve a more flexible and decoupled design.

#### How can you achieve thread-safe singleton patterns in Java?
1. Eager loading
   The singleton instance is created at the time of class loading. It is straightforward and provides thread safety because the instance is created before any thread can access it.
   ```Java
    public class Singleton {
        private static final Singleton instance = new Singleton();

        private Singleton(){};

        public static Singleton getInstance() {
            return instance;
        }
    }
   ```

2. Lazy loading
   This approach uses a static inner helper class to hold the singleton instance. The instance is created when the helper class is loaded, and this method provides both lazy loading and thread safety.
   ```Java
    public class Singleton{
        private Singleton(){}
        private static class SingletonHolder() {
            private static final instance = new Singleton();
        }
        public static Singleton getInstance() {
            return SingletonHolder.instance;
        }

    }
   ```

   #### Liskov’s substitution principle states that if class B is a subtype of class A, then object of type A may be substituted with any object of type B. What does this actually mean?

3. It means if a method is present in classA, it should also be present in class B so that the object of type B could substitute object of type A.
