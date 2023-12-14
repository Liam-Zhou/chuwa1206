2. **What is the checked exception and unchecked exception in Java, could you give one example?**
   - Checked exceptions are exceptions that must be either caught or declared in the method's throws clause. Example: `IOException`.
   - Unchecked exceptions or runtime exceptions are exceptions that don't need to be declared or caught. They are raised due to logical mistakes. 
   Example: `NullPointerException`.

3. **Can there be multiple finally blocks?**
   - No, there can only be one `finally` block.

4. **When both catch and finally return values, what will be the final result?**
   - The value returned by the `finally` block will take precedence over the value returned by the `catch` block.

5. **What is Runtime/unchecked exception? What is Compile/Checked Exception?**
   - Runtime/unchecked exceptions are exceptions that occur at runtime and don't need to be explicitly handled. Example: `NullPointerException`.
   - Compile/checked exceptions are exceptions that must be either caught or declared in the method's throws clause. Example: `IOException`.

6. **What is the difference between throw and throws?**
    - `throw` is used to explicity throw an exception in a method.
    - `throws` is used in the method declaration to specify the exceptions that the method might throw.


7. **Run the below three pieces of codes. Notice the printed exceptions. Why do we put the Null/Runtime exception before Exception?**
   - It shows that try block always reports the first exception it finds, even if there are other exceptions after.

8. **What is optional? Why do you use it? Write an optional example.**
   - `Optional` is class that is used to avoid `NullPointerException` and represent the absence of a value. Example:
   ```java
   Optional<String> optionalValue = Optional.ofNullable(null);
   String result = optionalValue.orElse("Default value");
   ```

10. **Why does finally always be executed?**
   - `finally` is used to ensure that a block of code is always executed, whether an exception is thrown or not. It's typically used for cleanup operations.

11. **Types of design patterns in Java**
    - Creational, Structural, and Behavioral are the three main types of design patterns in Java.

12. **SOLID Principles**
    - Single Responsibility
    - Open-Closed
    - Liskov Substitution
    - Interface Segregation
    - Dependency Inversion principles. 
    - These principles help in designing maintainable and scalable software.

13. **Achieving thread-safe singleton patterns in Java**
    - Thread-safe singleton patterns can be achieved using various approaches like eager initialization, lazy initialization with synchronized blocks.
    ```Java
    //Lazy load
    public class Singleton {
    // Private constructor to prevent instantiation from outside the class
    private Singleton() {
    }
    static{
      ///do something
    }
        // Static inner class to hold the Singleton instance
        private static class SingletonHolder {
            private static final Singleton INSTANCE = new Singleton();
    }
        // Public static method to get the Singleton instance
        public static Singleton getInstance() {
            return SingletonHolder.INSTANCE;
    } }
    ```

    ```Java
    // Eager load
    public class Singleton {
    // 1, private static variable
    private static Singleton instance = new Singleton();
    // 2, make constructor be private
    // 保证不能new， 一旦可以new, 就可以建造很多instance， 则就不再是singleton。 
    private Singleton() {
    }
    // 3. static getInstance method
    // static保证在没有instance的情况下，可以调该方法。 
    public static Singleton getInstance() {
            return instance;
        }
    }
    ```

14. **Open-Closed Principle (OCP)**
    - The Open-Closed Principle states that software entities (e.g., classes, modules, functions) should be open for extension but closed for modification. It encourages extending existing code rather than modifying it.

15. **Liskov's Substitution Principle**
    - It means that if class B is a subtype of class A, objects of type A can be replaced with objects of type B without affecting the correctness of the program. It ensures that the derived class adheres to the contract of the base class.
