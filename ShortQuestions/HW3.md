2. What is the checked exception and unchecked exception in Java, could you give one example?

   Checked exception: are checked at compile-time. It means if a method is capable of causing an exception that is checked, then it must either handle the exception using a `try-catch` block, or it must declare the exception using the `throws` keyword in the method signature. 

   Example: `IOException`.

   Unchecked exception: not checked at compile-time. The compiler does not force you to either catch them or declare them in the method signature. They are also called runtime exceptions. 

   Example: `NullPointerException`.

   

3. Can there be multiple finally blocks? 

   No, in a try-catch-finally construct, you can only have one `finally` block. 

   

4. When both catch and finally return values, what will be the final result?

   The value returned by the `finally` block will be the final result.

   

5. What is Runtime/unchecked exception? what is Compile/Checked Exception?

   Runtime/Unchecked Exception: These are exceptions that the compiler does not require to be caught or declared in the method signature. Examples include `NullPointerException`, `IndexOutOfBoundsException`.

   Compile/Checked Exception: These are exceptions that are checked at compile time. Examples include `IOException`, `SQLException`.

   

6. What is the difference between throw and throws?

   **`throw`**: Used to explicitly throw an exception from a method or any block of code. It's followed by an instance of an `Exception` class.

   ```java
   public void method() {
       throw new NullPointerException("Detail Message");
   }
   ```

   **`throws`**: Used in the method signature to declare that this method might throw certain exceptions. 

   ```java
   public void method() throws NullPointerException {
   }
   
   ```

   7. What is optional? why do you use it? write an optional example. 

      Optional: is a container object used to contain not-null objects. It's a public final class and is used to represent optional values that are either present or absent. The user can understand whether the returned value can be `null` or not.

      Why use it: advoid NPE
      Example:

      ```java
      import java.util.Optional;
      
      public class OptionalExample {
          public Optional<String> getFullName(String firstName, String lastName) {
              if (firstName == null || lastName == null) {
                  return Optional.empty();
              }
              return Optional.of(firstName + " " + lastName);
          }
      }
      
      ```

      

   8. Why finally always be executed ?

      It's designed to allow the program to clean up some resources, like closing a file or releasing a network connection, regardless of what happens within the `try` and `catch` blocks.

      

   10. What are the types of design patterns in Java ?

       **Creational Patterns:** Deal with object creation mechanisms. Examples include Singleton, Factory, Abstract Factory, Builder, and Prototype.

       **Structural Patterns:** Concerned with how classes and objects are composed to form larger structures. Examples include Adapter, Composite, Proxy, Flyweight, Facade, and Bridge.

       **Behavioral Patterns:** Focus on communication between objects. Examples include Strategy, Observer, Command, Iterator, State, and Template Method.

       

   11. What are the SOLID Principles ?

       SOLID principles are a set of five design principles that help in creating understandable, flexible, and maintainable software designs in object-oriented programming:

       **Single Responsibility Principle (SRP):** A class should have only one reason to change, meaning it should have only one job or responsibility.

       **Open-Closed Principle (OCP):** Software entities (classes, modules, functions, etc.) should be open for extension but closed for modification.

       **Liskov Substitution Principle (LSP):** Objects of a superclass should be replaceable with objects of a subclass without affecting the correctness of the program.

       **Interface Segregation Principle (ISP):** Clients should not be forced to depend upon interfaces they do not use.

       **Dependency Inversion Principle (DIP):** High-level modules should not depend on low-level modules but should depend on abstractions.

       

   12. How can you achieve thread-safe singleton patterns in Java ?

       - Eager load

       - Synchronized accesor

       - Double checked

       - Initialize on demand

         

   13. What do you understand by the Open-Closed Principle (OCP) ?

       The Open-Closed Principle is one of the five SOLID principles of object-oriented design and programming. It states that:

       - **Open for Extension:** be able to extend or add new functionality to an existing class or module.
       - **Closed for Modification:** Extending a class or module should not require modifying the existing code of that class or module.

       

   14. Liskov’s substitution principle states that if class B is a subtype of class A, then object of type A may be 

   substituted with any object of type B. What does this actually mean? (from OA ) choose your answer.

   1. It mean that if the object of type A can do something, the object of type B could also be able to perform the same thing

   2. It means that all the objects of type A could execute all the methods present in its subtype B
   3. It means if a method is present in class A, it should also be present in class B so that the object of type B could substitute object of type A.

   4. It means that for the class B to inherit class A, objects of type B and objects of type A must be same

   I select 1.  LSP states that objects of a superclass should be replaceable with objects of its subclasses without affecting the functionality of the program. 

