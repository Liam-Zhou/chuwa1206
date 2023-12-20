### 2. What is the checked exception and unchecked exception in Java, could you give one example?

> **checked exception** : checked at compile-time. It means that the compiler forces the developer to handle or declare these exceptions using a `try-catch` block or by adding a `throws` clause to the method signature. (IOException, SQLException/NetworkException)
>
> **unchecked exception** : Runtime Exception. (ArrayIndexOutOfBoundsException, NullPointerException)

### 3. Can there be multiple finally blocks? 

>A try block can be followed by zero or more catch blocks and zero or one finally block. Each try block can have at most one associated finally block. If you need to execute multiple pieces of cleanup code, you can achieve this by nesting try-finally blocks or by using other programming constructs.

```JAVA
public class MultipleFinallyBlocks {
    public static void main(String[] args) {
        try {
            try {
                // Code that may throw an exception
            } finally {
                // Cleanup code for the inner try block
            }
        } finally {
            // Cleanup code for the outer try block
        }
    }
}

```



### 4. When both catch and finally return values, what will be the final result?

>value in final block will be returned.

### 5.What is Runtime/unchecked exception? what is Compile/Checked Exception?

>| -    | **Checked Exceptions:** All exceptions other than *RuntimeException* and Error are known as Checked exception. These exceptions are checked by the compiler at the compile time itself. E.g. when you are trying to read from a file, then compiler enforces us to handle the *FileNotFoundException* because it is possible that the file may not be present. Some other checked exceptions are *SQLException* , *IOException*etc. |
>| ---- | ------------------------------------------------------------ |
>| -    | **Unchecked Exceptions: Runtime Exceptions are known as Unchecked exceptions. Compiler does not force us to handle these exceptions but as a programmer, it is our responsibility to handle runtime exceptions e.g. NullPointerException , ArithmeticException , ArrayIndexOutOfBoundException etc.** |

### 6. What is the difference between throw and throws?

> - throw is a keyword which is used to explicitly throw an exception in the program, inside a function or inside a block of code, whereas throws is a keyword which is used with the method signature to declare an exception which might get thrown by the method while executing the code
> - throw keyword is followed by an instance of an Exception class whereas throws is followed by Exception class names
> - You can throw one exception at a time but you can declare multiple exceptions using throws keyword
> - Using throw keyword, only unchecked exceptions are propagated, whereas using throws keyword both checked and unchecked exceptions can be propagated.Ω v

### 7. What is optional? why do you use it? write an optional example

> `Optional` is a class introduced in Java 8 that is part of the `java.util` package. It is designed to address the problem of dealing with potential null values and to provide a more explicit and safer way of handling scenarios where a value may or may not be present

```java
public class OptionalDemo {
    public static void main(String[] args) {
        Map<Integer, User> userMap = new HashMap<>();
        userMap.put(1, new User("Alice", new Address("Main Street")));
        userMap.put(2, new User("Bob", null));

        // Without Optional
        String streetName = "Unknown";
        User user = userMap.get(2);
        if (user != null) {
            Address address = user.getAddress();
            if (address != null) {
                streetName = address.getStreet();
            }
        }
        System.out.println("Street name without Optional: " + streetName);

        // With Optional
        streetName = Optional.ofNullable(userMap.get(2))
                .map(User::getAddress)
                .map(Address::getStreet)
                .orElse("Unknown");
        System.out.println("Street name with Optional: " + streetName);
    }
}

class Address {
    private String street;

    public Address(String street) {
        this.street = street;
    }

    public String getStreet() {
        return street;
    }
}

class User {
    private String name;
    private Address address;

    public User(String name, Address address) {
        this.name = name;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public Address getAddress() {
        return address;
    }
}
```

### 8. Why finally always be executed ?

> The `finally` block in Java is used to provide a mechanism for cleanup code that should be executed regardless of whether an exception occurs or not. It ensures that certain statements are always executed, making it useful for releasing resources, closing files, or generally performing cleanup operations.

### 10. What are the types of design patterns in Java ?

- **Singleton Pattern:** Ensures that a class has only one instance and provides a global point of access to it.
- **Factory Method Pattern:** Defines an interface for creating an object but leaves the choice of its type to the subclasses, creating an instance of one of several possible classes.
- **Observer Pattern:** Defines a one-to-many dependency between objects so that when one object changes state, all its dependents are notified and updated automatically.

### 11. What are the SOLID Principles ?

> 1. **Single Responsibility Principle (SRP):**
>    - A class should have only one reason to change, meaning that it should have only one responsibility or job. In other words, a class should have only one reason to be modified.
> 2. **Open/Closed Principle (OCP):**
>    - Software entities (such as classes, modules, functions) should be open for extension but closed for modification. This principle encourages the use of abstraction and polymorphism to allow for adding new functionality without altering existing code.
> 3. **Liskov Substitution Principle (LSP):**
>    - Subtypes must be substitutable for their base types without altering the correctness of the program. In simpler terms, objects of a superclass should be replaceable with objects of a subclass without affecting the correctness of the program.
> 4. **Interface Segregation Principle (ISP):**
>    - A class should not be forced to implement interfaces it does not use. This principle suggests that it is better to have multiple small, specific interfaces rather than a large, general one. Clients should not be forced to depend on interfaces they do not use.
> 5. **Dependency Inversion Principle (DIP):**
>    - High-level modules should not depend on low-level modules. Both should depend on abstractions. Additionally, abstractions should not depend on details; details should depend on abstractions. This principle encourages the use of dependency injection and inversion of control to achieve loosely coupled and flexible systems.

### 12. How can you achieve thread-safe singleton patterns in Java ?

```java
public class Singleton {
    // Private constructor to prevent instantiation from outside the class
    private Singleton() {
    }
    static{
      ///do something
    }
  
    // Static inner class to hold the Singleton instance
    private static class SingletonHolder {
        private static final Singleton INSTANCE = new Singleton();
    }
    // Public static method to get the Singleton instance
    public static Singleton getInstance() {
        return SingletonHolder.INSTANCE;
    }
}
```

### 13. What do you understand by the Open-Closed Principle (OCP) ?

> "Software entities (classes, modules, functions, etc.) should be open for extension, but closed for modification."
>
> 1. **Open for Extension:**
>    - The design should allow for adding new functionality or features to a system without modifying existing code.
>    - New behavior can be introduced through inheritance, composition, or other extension mechanisms.
> 2. **Closed for Modification:**
>    - Once a module (class, function, etc.) is stable and in production, its source code should not be modified.
>    - Changes to existing behavior should be achieved through extension rather than modification.

### 14. Liskov’s substitution principle states that if class B is a subtype of class A, then object of type A may be substituted with any object of type B. What does this actually mean? (from OA ) choose your answer. (1)

> 1. It mean that if the object of type A can do something, the object of type B could also be able to perform the same thing 
>
> 2. It means that all the objects of type A could execute all the methods present in its subtype B 
> 3. It means if a method is present in class A, it should also be present in class B so that the object of type B could substitute object of type A. 
> 4.  It means that for the class B to inherit class A, objects of type B and objects of type A must be same