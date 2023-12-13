### Q1
CodingQuestion Folder
### Q2
- Checked Exception
    - All exceptions other than _RunTimeException_ and Error are known as Checked exception.
    - These exceptions are checked by the compiler at the compile time itself
    - _FileNotFoundException_ (when you are trying to read from a file, then the compiler enforces us to handle this exception b/c it's possible that the file may not be present)

- Unchecked Exception
  - Runtime Exception are known as Unchecked exception. Compiler does not force us to handle these exception
  - _NullPointerException_

### Q3
NO
### Q4
anything inside _finally_ block
### Q5
- Checked Exception
    - All exceptions other than _RunTimeException_ and Error are known as Checked exception.
    - These exceptions are checked by the compiler at the compile time itself
    - _FileNotFoundException_ (when you are trying to read from a file, then the compiler enforces us to handle this exception b/c it's possible that the file may not be present)
    - _SQLException_
    - _IOException_
- Unchecked Exception
    - Runtime Exception are known as Unchecked exception. Compiler does not force us to handle these exception
    - _NullPointerException_
    - _ArithmeticException_
    - _ArrayIndexOutOfBoundException_
### Q6
- Throw
    - is used to explicitly throw an exception int the program, inside a function/ block of code
    - followed by an instance of an Exception class
    - you can throw one exception at a time
    - only _Unchecked Exception_ are propagated
- Throws
    - is used w/ the method signature to declare an exception which might get thrown by the method while excueting the code
    - followed by an Exception class name
    - you can declear multiple exceptions using throws
    - both Checked and Unchecked exceptions can be propagated
### Q7
In try/catch block, handle the most specific exception and move down to most generic ones
### Q7
- Wrapper class to check the null values and helps in further processing based on the value
- Optional class is a container object which can contain a null value. It can help in writing a neat code without using too many null checks
- ```
  Optional<String> optionalValue = Optional.of("Hello, World!");
  ```
### Q8
- it is executed whether an exception is thrown or not
- Cleanup Operations
    - is used for cleanup operations, such as releasing resources or performing tasks that need to execute regardless of exceptions
- Guaranteed Execution
    - it ensures that specific code will be executed, providing a guarantee that essential cleanup or finalization steps are not skipped
- Unwinding the Call Stack
    - it is executed during this process before transferring control to the catch block
### Q9
same as Q1
### Q10
- Factory Design Pattern
- Abstract Factory Design Pattern
- Strategy Design Pattern
- Builder Design Pattern
- Singleton Design Pattern
- Observer Design Pattern
### Q11
S - Single-responsibility Principle
O - Open-closed Principle
L - Liskov Substitution Principle
I - Interface Segregation Principle
D - Dependency Inversion Principle
### Q12
```
getInstance()
```
- In Eager load, it created at the time of class loading, however it may lead to unnecessary resource utilization if the instance is not always needed
- In Lazy load, it delays the instantiation of the singleton until it's actually needed. It used _double-checked locking_ to synchronize the creation of the instance
### Q13
- Open for Extension
  - The principle encourages designing classes that can be extended to accommodate new features or behaviors
- Closed for Modification
    - Once a class is implemented, its code should be closed for modification to avoid unintentional changes and maintain stability
- Use of Abstraction
    - Abstraction is often employed to provide a foundation for extension w/o modifying concrete implementations
- Preventing Code Fragility
    - Adhering to the OCP helps prevent code fragility, ensuring that changes for one feature do not introduce unintended consequences or bugs in other parts of the system

### Q14
3

Object of a superclass should be replaceable with objects of a subclass w/o affecting the correctness of the program.
It's crucial that the subclass adheres to the contract defined by the superclass
If class B is a subtype of class A, ensuring that objects of type B can be used wherever objects of type A are expected
### Q15
