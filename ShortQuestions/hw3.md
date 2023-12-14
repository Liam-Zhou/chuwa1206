# HW3

## Q1 Practice collection
Show in folder CodingQuestions

## Q2 What is the checked exception and unchecked exception in Java, could you give one example?

**Checked Exceptions**:

These are exceptions that are checked at compile time. It means if a method is throwing a checked exception, then it must either handle the exception using a ```try-catch``` block or it must declare the exception using the ```throws``` keyword. The compiler enforces handling or declaring these exceptions.

Examples: ```IOException ```, ```FileNotFoundException ```, ```ClassNotFoundException```

**Unchecked Exceptions**:
These are exceptions that are not checked at compile time. In other words, the compiler does not require methods to catch or to specify (with throws) these exceptions. Unchecked exceptions are usually programming bugs, such as logic errors or improper use of an API

Examples: ```NullPointerException```, ```ArrayIndexOutOfBoundsException```, ```IllegalArgumentException```.


## Q3  Can there be multiple finally blocks?

No, there can only be one ```finally``` block for each ```try``` block in Java. It executes after the ```try``` and any ```catch``` blocks, regardless of whether an exception was thrown or not.


# Q4 When both catch and finally return values, what will be the final result?
In Java, if both a ```catch``` block and a ```finally``` block return a value, the value from the ```finally``` block will be the final result.

# Q5 What is Runtime/unchecked exception? what is Compile/Checked Exception?

**Checked Exceptions**: These are exceptions that are checked at compile time. It means if a method is throwing a checked exception, then it must either handle the exception using a ```try-catch``` block or it must declare the exception using the ```throws``` keyword. The compiler enforces handling or declaring these exceptions.
Examples: ```IOException ```, ```FileNotFoundException ```, ```ClassNotFoundException```

**Unchecked Exceptions**:
These are exceptions that are not checked at compile time. In other words, the compiler does not require methods to catch or to specify (with throws) these exceptions. Unchecked exceptions are usually programming bugs, such as logic errors or improper use of an API.
Examples: ```NullPointerException```, ```ArrayIndexOutOfBoundsException```, ```IllegalArgumentException```.


# Q6 What is the difference between throw and throws>

**throw**:
- Used within the method(in method body)
- Used to explicitly throw an exception

**throws**:
- Used in the method signature.
- It declares that a method might throw one or more exceptions. It doesn't throw the exception itself but indicates that the method may throw an exception, and it should be handled by the method caller


## Q7 Run the below three pieces codes, Noticed the printed exceptions. why do we put the Null/Runtime exception before Exception ?

After I ran the code:
1. First code: This results in an ```ArithmeticException``` because of the division by zero (b / a). The catch block for ```ArithmeticException``` will handle this, and the rest of the catch blocks will be skipped.

1. Second Code: This results in a ```NullPointerException``` due to the attempt to call equals on a null object (s). The catch block for ```NullPointerException``` will handle this exception.

1. Third Code: This results in a ```RuntimeException``` because of the explicit ```throw``` new ```RuntimeException()```;. The catch block for ```RuntimeException``` will handle this exception.

We put ```NullPointerException``` or ```ArithmeticException``` before a general Exception because:

- Catch blocks are evaluated in order, so more specific exceptions should be caught first for precise handling.
- Placing a general Exception catch block first would catch all exceptions, preventing more specific catch blocks from handling their respective exceptions.

## Q7 What is optional? why do you use it? write an optional example.

**Optional** in Java is a container object for values that may or may not be null. It's used to avoid ```NullPointerException``` and to provide a clearer way to handle the presence or absence of a value.

```
public class Main {
    public static void main(String[] args) {
        Optional<String> optionalString = Optional.of("Hello, Optional!");

        if (optionalString.isPresent()) {
            System.out.println(optionalString.get());
        }
    }
}
```

## Q8 Why finally always be executed ?
The ```finally``` block in Java is always executed to ensure that necessary cleanup code runs regardless of whether an exception occurs or not in the ```try``` or ```catch``` blocks. It's designed to provide a reliable mechanism for resource management and cleanup.

## Q9 

Done in Q1

## Q10
Design patterns in Java are typically categorized into 3 main types:

- Creational Patterns: Focus on object creation mechanisms (e.g. **Singleton**) 


- Structural Patterns: Deal with object composition and arrangement (e.g. **Adapter**)


- Behavioral Patterns: Concerned with object interaction and responsibility assignment (e.g. **Observer**)

## Q11 What are the SOLID Principles ?

The **SOLID** principles in object-oriented programming are:

- **Single Responsibility Principle**: A class should have only one reason to change, focusing on a single responsibility.

- **Open/Closed Principle**: Software entities should be open for extension but closed for modification.

- **Liskov Substitution Principle**: Subclasses should be replaceable with their base classes without affecting the program.

- **Interface Segregation Principle**: No class should be forced to implement interfaces it doesn't use.

- **Dependency Inversion Principle**: High-level modules should not depend on low-level modules; both should depend on abstractions.

## Q12 How can you achieve thread-safe singleton patterns in Java ?

- **Eager Initialization**: The Singleton instance is created during class loading, ensuring thread safety. Suitable for lightweight instances, but can increase startup time.

- **Lazy Initialization with Synchronization**: The Singleton instance is created when first accessed, with synchronized access for thread safety. Avoids unnecessary resource usage but can reduce performance in high-concurrency scenarios due to synchronization overhead.


## Q13 What do you understand by the Open-Closed Principle (OCP) ?

The Open-Closed Principle (OCP) states that software entities (like classes, modules, functions) should be open for extension but closed for modification. This means you should be able to add new features without changing existing code.

## Q14 Liskov’s substitution principle states that if class B is a subtype of class A, then object of type A may be substituted with any object of type B. What does this actually mean?

1. It means that if the object of type A can do something, the object of type B could also be able to perform the same thing.

## Q15 Watch the design pattern video, and type the code, submit it to MavenProject folde