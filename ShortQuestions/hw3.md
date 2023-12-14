# HW3

## 2. What is the checked exception and unchecked exception in Java, could you give one example?

- Checked exceptions are exceptions that are checked at compile time. This means that the compiler requires the code to either handle these exceptions with a try-catch block or declare them in the method's signature using the throws keyword.

Example: IOEXception

```java
try {
            
} catch (IOException e) {

}   
```

- Unchecked exceptions are the exceptions that are not checked at compile time. In other words, the compiler doesn't require these exceptions to be caught or declared thrown. Unchecked exceptions are also known as runtime exceptions and they represent problems that are the result of a programming error, like a logic mistake.

Example: NullPointerException

```java
int arr = {0, 1}

try {
	arr[2] = 1;
} catch (NullPointerException e) {
	// not mandartory	
}
```

## 3. Can there be multiple finally blocks?

No. Only one finally block.

## 4. When both catch and finally return values, what will be the final result?

The return value from the finally block will be the final result.

```java
try {
	throw new Exception();
} catch (Exception e) {
	return 1;
} finally {
	return 2;
}
// actually return 2
```

## 5. What is Runtime/unchecked exception? what is Compile/Checked Exception?

- Runtime or unchecked exceptions are exceptions that are not checked at compile time. This means the compiler does not enforce handling of these exceptions. They are called unchecked because the compiler doesn't check at compile time to see whether a method handles or throws these exceptions.
- Compile-time or checked exceptions are checked at compile time. This means the compiler requires the code to handle these exceptions either with a try-catch block or declare them in the method's signature using **`throws`**.

## 6. What is the difference between throw and throws?

- The throw keyword is used within a method to explicitly throw an exception. Can throw either checked or unchecked exceptions using the throw keyword.

```java
try {
	throw new Exception e;
}
```

- The throws keyword is used in a method's signature to declare that a method might throw one or more exceptions. It is used for checked exceptions.

```java
public void method() throws IOException, SQLException {

}
```

## 7. Run the below three pieces codes, Noticed the printed exceptions. Why do we put the Null/Runtime exception before Exception ?

If we put the catch block for `Exception` first, it will handle all exceptions, including `NullPointerException` and `RuntimeException`. As a result, any subsequent catch blocks for these specific exceptions will be unreachable code, leading to a compile-time error.

To avoid this, we should catch more specific exceptions first and then catch more general exceptions. 

## 8. What is optional? why do you use it? write an optional example.

Optional is a container object which is used to represent the presence or absence of a value. Optional is used to avoid NullPointerException that can occur when a method returns null.

```java
import java.util.Optional;

public class OptionalExample {
    
    public static void main(String[] args) {
        OptionalExample example = new OptionalExample();

        // Example with a non-null value
        Optional<String> greeting = example.getGreeting("John");
        System.out.println("Greeting: " + greeting.orElse("Hello, Guest!"));

        // Example with a null value
        Optional<String> noGreeting = example.getGreeting(null);
        System.out.println("Greeting: " + noGreeting.orElse("Hello, Guest!"));
    }

    public Optional<String> getGreeting(String name) {
        if (name == null) {
            return Optional.empty();
        }
        return Optional.of("Hello, " + name + "!");
    }
}
```

## 9. Why finally always be executed ?

- **Resource Management**: Ensures that resources (like files or network connections) are closed or released, regardless of whether an exception occurs.

- **Guaranteed Execution**: Executes after the **`try`** and **`catch`** blocks, regardless of whether an exception is thrown or caught, ensuring that certain critical code always runs.

- **Preventing Resource Leaks**: Prevents resource leaks by ensuring that resources are properly closed, especially if an exception interrupts the normal flow in the **`try`** block.
- **Maintaining Consistency**: Helps maintain the consistency and integrity of the application's state, especially in error-handling scenarios.

## 10. What are the types of design patterns in Java ?

- **Aggregation**: The lifetime of the owned object does not depend on the lifetime of the owner.

- **Composition**:  The lifetime of the owned object depends on the lifetime of the owner.

## 11. What are the SOLID Principles ?

1. **Single Responsibility Principle (SRP)**: Each class should have only one reason to change, focusing on a single task or responsibility.
2. **Open/Closed Principle (OCP)**: Software entities should be open for extension but closed for modification, allowing new functionality to be added without changing existing code.
3. **Liskov Substitution Principle (LSP)**: Subclasses should be substitutable for their base classes without affecting the program's correctness.
4. **Interface Segregation Principle (ISP)**: Create small, specific interfaces so clients don't depend on interfaces they don't use, leading to decoupled and clearer systems.
5. **Dependency Inversion Principle (DIP)**: High-level modules should not depend on low-level modules; both should depend on abstractions. Abstractions shouldn't depend on details; details should depend on abstractions, reducing coupling and increasing flexibility.

## 12. How can you achieve thread-safe singleton patterns in Java ?

```java
public class Singleton {
	private Singleton() {}

	static {}

	private static class SingletonHolder {
		private static final Singleton INSTANCE = new Singleton();
	}

	public static Singleton getInstance() {
		return SingletonHolder.INSTANCE;
	}
}
```

## 13. What do you understand by the Open-Closed Principle (OCP) ?

**Open for Extension**: This aspect of the principle suggests that the behavior of a module can be extended.

**Closed for Modification**: The principle also dictates that modifying the existing code of the module is not required for the extension.

## 14. Liskov’s substitution principle states that if class B is a subtype of class A, then object of type A may be substituted with any object of type B. What does this actually mean? (from OA ) choose your answer.

1. It mean that if the object of type A can do something, the object of type B could also be able to perform the same thing

## 15. Watch the design pattern video, and type the code, submit it to MavenProject folder.

In  [MavenProject](../MavenProject) folder.