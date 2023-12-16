1.  No answer need.
2.  What is the checked exception and unchecked exception in Java, could you give one example?

        **Checked Exception (Compile-Time Exception)**:

        - IOException (e.g. FileNotFound)
        - SQLException/NetworkException (e.g. Id/data does not exits)
          Example:

          ```
          public class Example {
          public static void main(String[] args) {
              try {
                  File file = new File("example.txt");
                  FileReader fr = new FileReader(file);
                  // Code that reads from the file
              } catch (IOException e) { // FileNotFound
                  // Handle the IOException
                  e.printStackTrace();
              }
          }

          }
          ```

        **Unchecked Exception (Runtime Exception)**:

        - NullPointerException (NPE)
        - IndexOutOfBoundsException (e.g. List/Array)
        - ClassCastException
        - SecurityException

        Example:

    ```
        public class Example {
        public static void main(String[] args) {
            int[] numbers = {1, 2, 3};
            System.out.println(numbers[5]);  // This will throw an ArrayIndexOutOfBoundsException at runtime
        }

    }

    ```

3.  Can there be multiple finally blocks?

    No, there cannot be multiple finally blocks within a try-catch block. `finally` can only be used once with a try or try-catch block. And `finally` is optional in a try-catch block.

4.  When both catch and finally return values, what will be the final result?

    `finally` will be **executed whether or not** the exception is handled and will **still be executed** even if there is a `return` statement in the catch clause.

5.  What is Runtime/unchecked exception? what is Compile/Checked Exception?

    **Runtime or Unchecked Exceptions**: Runtime or Unchecked exceptions are not checked at compile-time; they are detected only at runtime. Unchecked exceptions usually result from programming errors, such as attempting to access an array index that does not exist or dividing by zero. Developers are not required to catch or declare unchecked exceptions, but they can if they want to.

    **Compile-Time or Checked Exceptions**: The compile-time/checked exceptions are exceptions that are checked at compile-time. The compiler ensures that the code handles these exceptions, either by catching them using a `try-catch` block or by declaring that the method throws the exception using the `throws` keyword. Developers are required to handle or declare these exceptions; otherwise, the code will not compile.

6.  What is the difference between **throw** and **throws**?
    **throw**: throw is a keyword used to throw an exception explicitly within a block of code.
    **throws** throws is a keyword used in the method declaration to indicate that the method might throw certain types of exceptions, and it informs the calling code about the potential exceptions that need to be handled.

7.  Run the below three pieces codes, Noticed the printed exceptions. why do we put the Null/Runtime
    exception before Exception?

    1. It prints ArithmeticException for the first piece code.
    2. It prints NullPointerException for the second piece code.
    3. It prints RuntimeException for the third piece code.

    The reason we put Runtime
    exception before Exception is that Runtime
    exception is the subclass of Exception, and we need catch **from bottom to top**. Otherwise, the Exception catch block will catch every exceptions.

8.  What is optional? why do you use it? write an optional example.
    The optinal class is a container to store

    `Optional` is a class introduced in Java to deal with the problem of null references. It is designed to provide a more expressive and safer way to represent values that might be absent. The primary goal of `Optional` is to help avoid null pointer exceptions and make code more readable by explicitly stating when a value may be absent.

    Example:

    ```
    public class OptionalDemo {
        public static void main(String[] args) {
            Map<Integer, User> userMap = new HashMap<>();
            userMap.put(1, new User("Alice", new Address("Main
            Street")));
            userMap.put(2, new User("Bob", null));
            streetName = Optional.ofNullable(userMap.get(2))
            .map(User::getAddress)
            .map(Address::getStreet)
            .orElse("Unknown");
            System.out.println("Street name with Optional: " +
            streetName);
        }
    }
    ```

9.  Why finally always be executed?

    The reason the inally always be executed could be:

    Ensures that any cleanup or resource release (e.g., **closing a file or network connection or acquired locks**). The code placed in the finally block will be executed even in the presence of exceptions.

10. Same as Question 1.
11. What are the types of design patterns in Java?
    - Creational Design Patterns(Singleton, Factory Method, Builder, Prototype)
    - Structural Design Patterns(Adapter, Bridge, Composite, Flyweight, Facade)
    - Behavioral Design Patterns(Chain of Responsibility, Command, Interpreter, Iterator, Observer, Visitor...)
12. What are the SOLID Principles?
    - Single Responsibility Principle (SRP)
    - Open/Closed Principle (OCP)
    - Liskov Substitution Principle (LSP)
    - Interface Segregation Principle (ISP)
    - Dependency Inversion Principle (DIP)
13. How can you achieve thread-safe singleton patterns in Java?
    Steps to create a singleton patterns:
    - create a static volatile variable.
    - make constructor be private.
    - static synchronized getInstance method.
    - make sure thread safe. The way to achieve thread-safe is creating a static nested class within the Singleton class(**SingletonHolder**). Since the Java class loading mechanism ensures that a class will only be loaded once. This method also naturally achieves **thread safety**.
14. What do you understand by the Open-Closed Principle (OCP)?

    Software entities (classes, modules, functions, etc.) should be open for extension but closed for modification. This means that the behavior of a module can be extended without modifying its source code. New functionality should be added by adding new code, not by changing existing code.

15. Liskov’s substitution principle states that if class B is a subtype of class A, then object of type A may be
    substituted with any object of type B. What does this actually mean? (from OA ) choose your answer.

    It means if a method is present in class A, it should also be present in class B so that the object of
    type B could substitute object of type A.
