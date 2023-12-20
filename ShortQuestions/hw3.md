# Homework 3

## 2 What is the checked exception and unchecked exception in Java?

- Checked exceptions are those exceptions that are checked at compile-time. This means that the compiler checks whether the code that may throw a checked exception is surrounded by proper exception-handling mechanisms (try-catch blocks or throws clause). e.g. IOException, FileNotFoundException

- Unchecked exceptions are not checked at compile-time; they occur at runtime. e.g. NullPointerException, ArrayIndexOutOfBoundsException

## 3 Can there be multiple finally blocks?

- No

## 4 When both catch and finally return values, what will be the final result?

- it will execute both blocks and return the values after executing the finally block.

## 5 What is Runtime/uncheck exception? What is Compiled/Checked Exception?

- Same as Q2, Runtime exception is the same as uncheck exception, Compiled exception is the same as checked exception

## 6 What is the difference between throw and throws?

- throw means explicitly throw an exception

- throws means the method might throw certain types of exceptions

## 7 Why do we put the Null/Runtime exception before Exception?

- because the scope should be from small to large, if we put the large scope in the front, the smaller scope will never be executed

## 8 What is optional? Why do you use it? Write an example

- Optional is a container object that is used to avoid null checks and runtime NullPointerExceptions

```java
public class OptionalDemo {
    public static void main(String[] args) {
        Map<Integer, User> userMap = new HashMap<>();
        userMap.put(1, new User("Alice", new Address("Main
Street")));
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
        System.out.println("Street name without Optional: " +
streetName);
        // With Optional
        streetName = Optional.ofNullable(userMap.get(2))
                .map(User::getAddress)
                .map(Address::getStreet)
                .orElse("Unknown");
        System.out.println("Street name with Optional: " +
streetName);
    }
}
```

## 9 Why finally always be executed?

- The `finally` block in Java is designed to always be executed, regardless of whether an exception is thrown or not. This behavior is fundamental to the Java exception-handling mechanism and **ensures that certain cleanup or resource release code is executed**, even if an exception occurs.

## 10 What are the types of design patterns in Java?

- Creational
  
  - Singleton
  
  - Factory Method
  
  - Abstract Factory

- Structural
  
  - Adapter
  
  - Decorator
  
  - Facade

- Behavioral
  
  - Observer
  
  - Strategy
  
  - Command

## 11 What are the SOLID Principles?

- The SOLID principles are a set of five design principles that aim to make software designs more understandable, flexible, and maintainable.

- Single Responsibility Principle(SRP)

- Open/Closed Principle(OCP)

- Liskov Substitution Principle(LSP)

- Interface Segregation Principle(ISP)

- Dependancy Inversion Principle(DIP)

## 12 How can you achieve thread-safe singleton patterns in Java?

- Eager load: init the instance during class loading `private static final Singleton instance = new Singleton();`

- Lazy load: use a static inner class `SingletonHolder` to ensure the Singleton is only load once when getInstance() is called 

## 13 What do you understand by the Open-Closed Principle (OCP)?

- The OCP states that a software module (such as a class or function) should be open for extension but closed for modification. This principle encourages the design of software entities in a way that allows them to be easily extended with new functionality without altering their existing code.

## 14 Liskov’s substitution principle states that if class B is a subtype of class A, then object of type A may be substituted with any object of type B. What does this actually mean? 3
