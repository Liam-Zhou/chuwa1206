# Q1
Check CodingQuestions/Coding2/PracticeCollection directory.

# Q2
- Checked exceptions are exceptions that must be either caught or declared in the method signature using the throws keyword. These exceptions are checked at compile-time.
  - An example would be `NullPointerException` 
    -   ```
        try {
            BufferedReader reader = new BufferedReader(new FileReader("somefile.txt"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        ```
- Unchecked exceptions are exceptions that are not checked at compile-time instead it they are checked at runtime. Unchecked exceptions indicate programming errors, such as logic mistakes or improper use of an API.
  - An example would be `NullPointerException` 
    -   ```
        String text = null;
        System.out.println(text.length());
        ```

# Q3
No. There can be only one finally block for each try-catch block.

# Q4
When both catch and finally return values, finally block will return the value.

# Q5
- Unchecked exceptions are exceptions that are not checked at compile-time instead it they are checked at runtime. Unchecked exceptions indicate programming errors, such as logic mistakes or improper use of an API.
- Checked exceptions are exceptions that must be either caught or declared in the method signature using the throws keyword. These exceptions are checked at compile-time.

# Q6
The throws keyword is used to declare which exceptions can be thrown from a method, while the throw keyword is used to explicitly throw an exception within a method or block of code.

# Q7 Run the below three pieces codes, Noticed the printed exceptions. why do we put the Null/Runtime exception before Exception ?
We should always catch exceptions in the scope from small to big meaning we should catch more specific exceptions first and then catch more general exceptions later. In the code, `System.out.println(b / a);` will throw `ArithmeticException`, `System.out.println(s.equals("aa"));` will throw `NullPointerException`, and `throw new RuntimeException();` will throw `RuntimeException`. Once an exception is caught in a catch block, none of the subsequent catch blocks are executed. If we `catch (Exception e)` first, all the previously mentioned exception cannot be caught.

# Q7 What is optional? why do you use it? write an optional example.
- What is optional? Optional is a container object used to contain not-null objects.
- Why do you use it? 
  - Clearly Express Optional Values.
  - To Avoid `NullPointerException`.
  - To Provide a Fluent API.
  - To Represent the Idea of Computation That Might Fail.
-   ```
    public static void main(String[] args) {
        Optional<String> optionalValue = Math.random() > 0.5 ? Optional.of("Hello World") : Optional.empty();

        if (optionalValue.isPresent()) {
            System.out.println("Value: " + optionalValue.get());
        } else {
            System.out.println("No value present");
        }

        String valueOrDefault = optionalValue.orElse("Default Value");
        System.out.println("Value or Default: " + valueOrDefault);
    }
    ```
# Q8
This is Java's design. Finally is typically used for cleanup activities, like closing file streams or releasing resources, which need to happen regardless of whether an error occurred. However, try-with-resource should be preferred to try-finally block when trying to deal with resources.

# Q9 Duplicate of Q1

# Q10
- Creational Patterns
  - Singleton Pattern
  - Factory Method Pattern
  - Abstract Factory Pattern
  - Builder Pattern
  - Prototype Pattern
- Structural Patterns
  - Adapter Pattern
  - Composite Pattern
  - Proxy Pattern
  - Flyweight Pattern
  - Bridge Pattern
  - Decorator Pattern
- Behavioral Patterns
  - Observer Pattern
  - Strategy Pattern
  - Command Pattern
  - State Pattern
  - Iterator Pattern
  - Template Method Pattern
  - Mediator Pattern

# Q11
SOLID stands for Single Responsibility, Open/Closed, Liskov Substitution, Interface Segregation, Dependency Inversion.
- Single responsibility means a class should only have one responsibility. Furthermore, it should only have one reason to change.
- Open/Closed principle means classes should be open for extension but closed for modification.
- Liskov Substitution means if class A is a subtype of class B, we should be able to replace B with A without disrupting the behavior of our program.
- Interface Segregation means larger interfaces should be split into smaller ones.
- Dependency Inversion means decoupling of software modules so that all modules will depend on abstractions.

# Q12
There are several ways to achieve thread-safe singleton patterns in Java, including using synchronized access method, double-checked locking principle, and Bill Pugh Singleton Implementation. The one that is promoted in the class is Bill Pugh Singleton Implementation. Class initialization phase in JVM is thread safe and we do not need synchronization. Plus, this implementation is lazy because the singleton is not created until getInstance() is called and subclass is accessed.
```
public class BillPughSingleton {

    private BillPughSingleton(){}

    private static class SingletonHelper {
        private static final BillPughSingleton INSTANCE = new BillPughSingleton();
    }

    public static BillPughSingleton getInstance() {
        return SingletonHelper.INSTANCE;
    }
}
```

# Q13
- Open/Closed principle means classes should be open for extension but closed for modification. Unless you are debugging the current class, it is not advisable to modify the class to add more functionalities because modifying the class can potentially introduce new bugs. Instead, you should create a new class to extend the previous class.

# Q14
Choose 3. It means if a method is present in class A, it should also be present in class B so that the object of 
type B could substitute object of type A