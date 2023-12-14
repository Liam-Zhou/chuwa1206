### 1. in codingQuestions/coding2
### 2. checked exception and unchecked exception
- checked exception: The exception that must be either caught or declared in the method in which it is thrown. IOException is a checked exception.
- unchecked exception: The exception that doesn't need to be caught or declared in the method. NullPointerException is an unchecked exception.
### 3. Can there be multiple finally blocks?
No, there can only have one finally block. And it must follow the catch blocks.
### 4. when both catch and finally return values, what will be the final result
the final result will come from the finally block
### 5. Runtime/unchecked exception and Compile/Checked exception
- runtime/unchecked exception: it is not checked during the compile time. And it doesn't need to be caught or declared in the method
- compile/checked exception: it is checked during the compile time. They should be either caught or declared in the method in which it is thrown.
### 6. difference between throw and throws
- throw: used to explicitly throw an exception from within a block of code or a method
- throws: used in a method signature to declare the exceptions that a method can potentially throw.
### 7. why put Null/Runtime exception before Exception
Put more specific exception first so that it can be caught first, if put Exception first, it will catch all the exceptions and leave no room for the specific ones to work in specific case.
### 8. optional
optional is used to handle the null situation.
```
String name = 'Alice';
Optional<String> nameOptional = Optional.ofNullable(name);
String name2 = null;
Optional<String> nameOptional = Optional.ofNullable(name2);
```
### 9. why finally always be executed
ensures the finally block can be executed even if an exception occurs.
### 10. in codingQuestions/coding2
### 11. types of design patterns in java
- Creational: Singleton, Abstract Factory
- Structural: Adapter, Composite
- Behavioral: Iterator, Observer
### 12. what are the SOLID principles
- Single Responsibility Principle
- Open-Closed Principle
- Liskov Substitution Principle
- Interface Segregation Principle
- Dependency Inversion Principle
### 13. achieve thread-safe singleton patterns in Java
Using eager or lazy initialization with double checking
### 14. Open-Closed Principle(OCP) 
The entities including classes, modules, functions should be open for extension but closed for modification so that ensures the extensibility and security of the software.
### 15. Liskov's substitution principle states that if class B is a subtype of class A, then object of type A may be substituted with any object of type B.
it means if a method is present in class A, it should also be present in class B so that object of type B couls substitute the object of type A.
### MavenProject folder