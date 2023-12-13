1. 
2. Checked Exception: Exceptions that are checked at compile time. Example: `IOException`.
Unchecked Exception: Exceptions not checked at compile time. Example: `NullPointerException`.
3. No, there can't be multiple `finally` blocks in a single try-catch structure in Java.
4. If both `catch` and `finally` return values, the value from the `finally` block will be the final result.
5. Runtime/Unchecked Exception: An exception not checked at compile-time, e.g., `NullPointerException`.
Compile/Checked Exception: An exception checked at compile-time, e.g., `IOException`.
6. `throw`: Used to explicitly throw an exception from a method or block of code.
`throws`: Declares that a method might throw exceptions, allowing them to be handled elsewhere.
7. Placing `NullPointerException` or other runtime exceptions before `Exception` in catch blocks ensures specific handling for them, as `Exception` would catch all exceptions, including runtime ones, if placed first.
7. `Optional` is a container object used to contain not null objects to avoid `NullPointerException` and to represent optional values that either exist or don't. 

For example:
```
import java.util.Optional;
public class OptionalExample {
public static void main(String[] args) {
Optional<String> optionalString = Optional.ofNullable(getNullableString());

        // Check if value is present
        if (optionalString.isPresent()) {
            System.out.println(optionalString.get());
        } else {
            System.out.println("String is null");
        }
    }

    static String getNullableString() {
        // This method might return a null string
        return null;
    }
}
```
8. Because `Finally` will always execute to ensure the important cleanup code runs regardless of whether an exception occurs or not. Java design to let `final` always being execute. 
10.  Design pattern have three types: (1) Creational Patterns: deals with object creation mechanisms, For example: Singleton, Factory, Abstract Factory.
     (2) Structural Patterns: deal with object composition and typically identify simple ways to realize relationships between different objects. Example: Adapter, Bridge, Composite, Decorator, Facade, Proxy.
     (3) Behavioral Patterns: Concerned with object interaction and responsibility assignment. Examples: Interpreter, Iterator, Mediator. Observer, Visitor, Strategy. 
11. SOLID means Single Responsibility Principle, Open-Closed Principle, Liskov Substitution Principle, Interface Segregation Principle, Dependency Inversion Principle. 
which means A class should have only one reason to change. Software entities should be open for extension, but closed for modification. 
12. To achieve a thread-safe in Java, we need to Eager Initialization, Synchronized Accessor Method, Double-Checked Locking, Static Inner Class, Enum Singleton. 
13. Open for extension, closed for modification. 
14. A. 