# HW3

1. [Practice collection](https://github.com/B1gO/chuwa-eij-tutorial/tree/main/02-java-core/src/main/java/com/chuwa/exercise/collection)
2. What is the checked exception and unchecked exception in Java, could you give one example?

* **checked exception:** has to be handled by catch or throws. eg.`IOException` or `SQLException`
* **uncheck exception:** also called runtime exception. The complier does not enforce to handle, but we did not handle it correctly, it could cause the program errors or abnormals. eg:`NullPointerException`, `ArrayIndexOutofBoundsException`.

3. Can there be multiple finally blocks?
    no, we can only have one finally blocks, but we can have multiple catch, from small to big.

4. When both catch and finally return values, what will be the final result?

    the finally statement have more priority, so the finally will return, but the catch return statement will not be executed.
5. What is **Runtime/unchecked exception**? what is Compile/Checked Exception?
   1. runtime/unchecked expection will not checked by the compiler. the root cause of the exception could be some logic error in the program. common runtime exceptions are: `NullPointerException`, `ArrayIndexOutofBoundsException`.
   2. checked exceptions are check by compiler, and it will be enforced to handle by `try-catch` or `throws`. Examples include `IOException, SQLException, and ClassNotFoundException`.
6. What is the difference between **throw and throws**?
`throw` and `throws` are two concepts related to exception handling in Java, But both of them is kind of `negative way` to handle the exceptions, it just throw the caller a exceptions, then the caller could handle it or throw it again.

    **`throws`:**

    * `throws` is used in the method signature (header).
    * It indicates the possibility of an exception occurring during the execution of the method. However, it does not guarantee that these exceptions will occur.
    * It is a declaration that informs the caller of the method about the potential exceptions that might be thrown.

    **`throw`:**

    * `throw` is used inside the method body.
    * It is used to explicitly throw an exception during the execution of the method.
    * When `throw` is executed, it guarantees that a specific exception is thrown.

7. Run the below three pieces codes, Noticed the printed exceptions. why do we put the Null/Runtime
exception before Exception ?

   * when we handle exceptions, we should do it in the order of small to big.  It is a good practice to handle more specific exceptions first because if a more general exception catch block is placed before a more specific one, the specific catch block will never be reached (the code is unreachable).

```java
public class Main {
    public static void main(String[] args) {
        int a = 0;
        int b = 3
        String s = null;
        try {
            System.out.println(b / a);
            System.out.println(s.equals("aa"));
            throw new RuntimeException();
        } catch (ArithmeticException e) {
            e.printStackTrace();
        } catch (NullPointerException e) {
            e.printStackTrace();
        } catch (RuntimeException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.getMessage();
        }
        System.out.println("End ...");
    }
}
public class Main {
    public static void main(String[] args) {
        int a = 0;
        int b = 3
        String s = null;
        try {
        // System.out.println(b / a);
            System.out.println(s.equals("aa"));
             throw new RuntimeException();
        } catch (ArithmeticException e) {
            e.printStackTrace();
        } catch (NullPointerException e) {
            e.printStackTrace();
        } catch (RuntimeException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.getMessage();
        }
            System.out.println("End ...");
    }
}
public class Main {
    public static void main(String[] args) {
        int a = 0;
        int b = 3;
        String s = null;
        try {
        // System.out.println(b / a);
        // System.out.println(s.equals("aa"));
            throw new RuntimeException();
        } catch (ArithmeticException e) {
            e.printStackTrace();
        } catch (NullPointerException e) {
            e.printStackTrace();
        } catch (RuntimeException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.getMessage();
        }
             System.out.println("End ...");
    }
}
```

7. What is optional? why do you use it? write an optional example.

   optional is a more elegant way to handle null pointerExcpetion.`but`, please be mind, if we use optional as a field and it cannot be serialized.

```java

    // User with an email
    User userWithEmail = new User("<john@example.com>");
    Optional<String> userEmail = userWithEmail.getEmail();

    // Print the email if present, otherwise print a default value
    System.out.println("User email: " + userEmail.orElse("No email available"));

    // User without an email
    User userWithoutEmail = new User(null);
    Optional<String> emptyEmail = userWithoutEmail.getEmail();

    // Print the email if present, otherwise print a default value
    System.out.println("User email: " + emptyEmail.orElse("No email available"));

```

8. Why finally always be executed ?
   * we ofthen use finally as release of the resoure, such as connection fo DB, by using finally we can ensuring that certain actions are taken before the control leaves the try-catch block.
9. Practice collection problems here: <https://github.com/TAIsRich/chuwa-eij-tutorial/tree/main/02-java-core/src/main/java/com/chuwa/exercise/collection>

10. What are the types of design patterns in Java ?

    1. **Creational Design Patterns:**
       * These patterns deal with object creation mechanisms, trying to create objects in a manner suitable to the situation.
       * Examples include:
          * **Singleton Pattern:** Ensures that a class has only one instance and provides a global point of access to that instance.
          * **Factory Method Pattern:** Defines an interface for creating an object but leaves the choice of its type to the subclasses, creating the object without specifying its exact class.
          * **Abstract Factory Pattern:** Provides an interface for creating families of related or dependent objects without specifying their concrete classes.

    2. **Structural Design Patterns:**
       * These patterns deal with the composition of classes or objects to form larger structures.
       * Examples include:
          * **Adapter Pattern:** Allows the interface of an existing class to be used as another interface.
          * **Decorator Pattern:** Attaches additional responsibilities to an object dynamically. Decorators provide a flexible alternative to subclassing for extending functionality.
          * **Composite Pattern:** Composes objects into tree structures to represent part-whole hierarchies. It allows clients to treat individual objects and compositions of objects uniformly.

    3. **Behavioral Design Patterns:**
       * These patterns define the ways in which objects interact and communicate with each other.
       * Examples include:
          * **Observer Pattern:** Defines a one-to-many dependency between objects so that when one object changes state, all its dependents are notified and updated automatically.
          * **Strategy Pattern:** Defines a family of algorithms, encapsulates each algorithm, and makes them interchangeable. Strategy lets the algorithm vary independently from clients that use it.
          * **Command Pattern:** Encapsulates a request as an object, thereby allowing for parameterization of clients with different requests, queuing of requests, and logging of the parameters.


14. What are the SOLID Principles ?
    
    **S** - Single-responsiblity Principle. *Duties should be singular and not take on too many responsibilities*
    **O** - Open-closed Principle, *opend to extendtion, close to modification*.
    **L** - Liskov Substitution Principle.  *All the places where the parent class can appear, the child class can appear and replace it without any errors*
   **I** - Interface Segregation Principle. *The interface must be as small as possible, as small as it can be*
    **D** - Dependency Inversion Principle. *We should program interface-oriented. By abstracting into interfaces, the implementation of each class is independent of each other, realizing the loose coupling between classes*
15. How can you achieve thread-safe singleton patterns in Java ?
    1. double check locking way
    2. inner static class way (more recommanded) **The SingletonHolder class is only loaded and initialized when the getInstance method is called for the first time.**

        ```java
        public class Singleton {
            private Singleton() {
                // Private constructor to prevent instantiation
            }

            private static class SingletonHolder {
                private static final Singleton INSTANCE = new Singleton();
            }

            public static Singleton getInstance() {
                return SingletonHolder.INSTANCE;
            }
        }

        ```

16. What do you understand by the Open-Closed Principle (OCP) ?
    The Open-Closed Principle means software entities should be open for extension, but closed for modification.

17. Liskov’s substitution principle states that if class B is a subtype of class A, then object of type A may be
substituted with any object of type B. What does this actually mean? (from OA ) choose your answer.
    1. It mean that if the object of type A can do something, the object of type B could also be able tp
    perform the same thing
    2. It means that all the objects of type A could execute all the methods present in its subtype B
    3. It means if a method is present in class A, it should also be present in class B so that the object of
    type B could substitute object of type A.
    4. It means that for the class B to inherit class A, objects of type B and objects of type A must be same.
    **chose A(1)**

18.  Watch the design pattern video, and type the code, submit it to MavenProject_designPattern folder

* singleton: <https://www.bilibili.com/video/BV1Np4y1z7BU?p=22>
* Factory: <https://www.bilibili.com/video/BV1Np4y1z7BU?p=35&vd_source=310561eab1216a27f7accf859bf7f6d9>
* Builder: <https://www.bilibili.com/video/BV1Np4y1z7BU?p=50&vd_source=310561eab1216a27f7accf859bf7f6d9>
* Publisher_Subscriber: <https://www.bilibili.com/video/BV1Np4y1z7BU?p=114&vd_source=310561eab1216a27f7accf859bf7f6d9>
