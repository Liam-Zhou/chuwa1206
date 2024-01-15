# hw3: hw21-exception&enum&collection

### 2. Checked vs Unchecked Exceptions
"What is the checked exception and unchecked exception in Java could you give one example?"
- Checked exceptions, like `IOException`, are checked at compile-time. Unchecked exceptions, like `NullPointerException`, occur at runtime.

### 3. Multiple Finally Blocks
"Can there be multiple finally blocks?"
- Java does not allow multiple finally blocks within a single try-catch block.

### 4. Return Values in Catch and Finally
"When both catch and finally return values what will be the final result?"
- The value from the finally block will be returned, overriding the catch block.

### 5. Runtime/Unchecked vs Compile/Checked Exception
"What is Runtime/unchecked exception? what is Compile/Checked Exception?"
- Runtime exceptions, like `IndexOutOfBoundsException`, occur during execution. Compile-time exceptions, like `FileNotFoundException`, are checked at compile-time.

### 6. Throw vs Throws
"What is the difference between throw and throws?"
- 'throw' is used to explicitly throw an exception. 'throws' declares that a method might throw exceptions.

### 7. Exception Order in Catch Blocks
"Run the below three pieces codes Noticed the printed exceptions. why do we put the Null/Runtime exception before Exception ?"
- Specific exceptions should be caught before more general ones to handle them correctly.

### 8. Use of Optional
"What is optional? why do you use it? write an optional example."
- **What is Optional**: Optional is a container for values that may be null.
- **Why Use Optional**: It is used to avoid `NullPointerException`.
- **Example**:
  ```java
  Optional<String> optional = Optional.ofNullable("Hello");
  optional.ifPresent(System.out::println);
  ```

### 9. Execution of Finally Block
"Why finally always be executed ?"
- The finally block ensures that necessary cleanup code is executed, regardless of whether an exception occurs.

### 10. Types of Design Patterns
"What are the types of design patterns in Java ?"
- Java has several design patterns, mainly categorized as Creational, Structural, and Behavioral.

### 11. SOLID Principles
"What are the SOLID Principles ?"
- **Single Responsibility Principle**: Each class should have only one responsibility.
- **Open-Closed Principle**: Software entities should be open for extension but closed for modification.
- **Liskov Substitution Principle**: Objects of a superclass should be replaceable with objects of its subclasses.
- **Interface Segregation Principle**: Larger interfaces should be split into smaller ones.
- **Dependency Inversion Principle**: High-level modules should not depend on low-level modules.

### 12. Thread-Safe Singleton Patterns
"How can you achieve thread-safe singleton patterns in Java ?"
- Use synchronization mechanisms or the initialization-on-demand holder idiom for thread-safe singletons.

### 13. Understanding Open-Closed Principle
"What do you understand by the Open-Closed Principle (OCP) ?"
- It states that software entities should be open for extension but closed for modification.

### 14. Liskov's Substitution Principle
"Liskov’s substitution principle states that if class B is a subtype of class A then object of type A may be substituted with any object of type B. What does this actually mean? (from OA) choose your answer."
- It mean that if the object of type A can do something, the object of type B could also be able to perform the same thing.
- This option correctly conveys the essence of LSP, which is about ensuring that objects of a subclass (type B) can be used interchangeably with objects of their superclass (type A) without causing issues in the program. This means that the subclass should adhere to the behavior expected by the superclass. The key aspect of LSP is the ability of the subclass to perform tasks expected of the superclass, ensuring consistent behavior and compatibility.

