2.  What is the checked exception and unchecked exception in Java, could you give one example?

**Checked Exception**: These are exceptions that are checked at compile-time. This means that the code must handle these exceptions either by using a `try-catch` block or by declaring them in the method signature using the `throws` keyword. An example is FileNotFoundException

**Unchecked Exception**: These are exceptions that are not checked at compile-time, meaning the compiler does not require these exceptions to be caught or declared in the method signature. And example is NullPointerException

3.  Can there be multiple finally blocks?

No. Each `try` block can be followed by zero or more `catch` blocks and one `finally` block.

4.  When both catch and finally return values, what will be the final result?

The result will be the valued returned from the `finally` block.

5.  What is Runtime/unchecked exception? what is Compile/Checked Exception?

A checked exception is caught at compile time whereas a runtime or unchecked exception is caught at runtime.

6.  What is the difference between throw and throws?

`throw` is for actually throwing an exception from a code block and `throws` is part of the method signature that tells dev and compiler that the method can throw certain exceptions.

7.  Run the below three pieces codes, Noticed the printed exceptions. why do we put the Null/Runtime exception before Exception?

Because `Exception` has a broader scope than `NullPointerException`, `Exception` would catch all exceptions, making the other catch block useless. Also putting Exceptions of smaller scopes in front of larger scopes can help refine the exception scope when we need to debug.

8.  What is optional? why do you use it? write an optional example.

`Optional` in Java is used to avoid `null` references and to handle the absence of a value more gracefully.

```Java
public class Example {
    public static void main(String[] args) {
        Optional<String> optional = Optional.ofNullable(null);
        optional.ifPresent(System.out::println);
    }
}
```

9.  Why finally always be executed ?

- **Guaranteed Execution**: It provides a guarantee that the code within it will be executed. This is particularly important for resource release and cleanup.
- **Exception Handling**: Even if an exception is thrown in the `try` block and not caught in the `catch` blocks, the `finally` block will still execute.
- **Return Statements**: If a `return` statement is executed within the `try` or `catch` block, the `finally` block will execute right before the method returns the value.

11. What are the types of design patterns in Java ?

**Creational Patterns**

- Singleton Pattern
- Factory Method Pattern
- Abstract Factory Pattern
- Builder Pattern
- Prototype Pattern

**Structural Patterns**

- Adapter Pattern
- Composite Pattern
- Proxy Pattern
- Flyweight Pattern
- Facade Pattern
- Bridge Pattern
- Decorator Pattern

**Behavioral Patterns**

- Strategy Pattern
- Observer Pattern
- Command Pattern
- Iterator Pattern
- Template Method Pattern
- Visitor Pattern
- Mediator Pattern
- Memento Pattern
- State Pattern
- Interpreter Pattern
- Chain of Responsibility Pattern

12. What are the SOLID Principles ?

SOLID stands for:

S - Single-responsiblity Principle
O - Open-closed Principle
L - Liskov Substitution Principle
I - Interface Segregation Principle
D - Dependency Inversion Principle

13. How can you achieve thread-safe singleton patterns in Java ?

There are 3 ways of doing it:

- Create the instance variable at the time of class loading.
- Synchronize the getInstance() method.
- Use synchronized block inside the if loop and volatile variable

14. What do you understand by the Open-Closed Principle (OCP) ?

software entities (classes, modules, functions, etc.) should be open for extension, but closed for modification; that is, such an entity can allow its behaviour to be extended without modifying its source code.

15. Liskov’s substitution principle states that if class B is a subtype of class A, then object of type A may be
    substituted with any object of type B. What does this actually mean? (from OA ) choose your answer.

A. It mean that if the object of type A can do something, the object of type B could also be able tp
perform the same thing

16. Watch the design pattern video, and type the code, submit it to MavenProject folder
    singleton: https://www.bilibili.com/video/BV1Np4y1z7BU?p=22
    Factory: https://www.bilibili.com/video/BV1Np4y1z7BU?p=35&vd_source=310561eab1216a27f7accf859bf7f6
    d9
    Builder: https://www.bilibili.com/video/BV1Np4y1z7BU?p=50&vd_source=310561eab1216a27f7accf859bf7f6
    d9
    Publisher_Subscriber: https://www.bilibili.com/video/BV1Np4y1z7BU?p=114&vd_source=310561eab1216a27f
    7accf859bf7f6d9
