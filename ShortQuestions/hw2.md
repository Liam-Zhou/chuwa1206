1.  Write up Example code to demonstrate the three foundmental concepts of OOP. (reference Code Demo
    repo as example)

    1.  **Encapsulation**

    ```
    class User {

        // Private fields
        private String userName;
        private String password;

        //Parameterzied constructor to create a new users
        public User(String userName, String password) {
            this.userName = userName;
            this.password = password;
        }

        public void login(String userName, String password) {
            //Check if the username and password match
            if (this.userName.toLowerCase().equals(userName.toLowerCase()) && this.password.equals(password)) {
                // .toLowrcase converts all the characters to lowercase & .equals checks if two strings match

                System.out.println("Access Granted against the username: "+this.userName +" and password: "+this.password);
            } else {
                System.out.println("Invalid Credentials!"); //Else invalid credentials
            }
        }
    }
    ```

    This example encapsulates the data (userName and password) in the User class. And manipulate that data using the login() method.

    2.  **Polymorphism**

    ````
        public class Shape {

            public double getArea() {
                return 0;
            }


        }

        // A Rectangle is a Shape with a specific width and height
        class Rectangle extends Shape {   // extended form the Shape class

            private double width;
            private double height;

            public Rectangle(double width, double heigh) {
                this.width = width;
                this.height = heigh;
            }

            @Override
            public double getArea() {
                return width * height;
            }

        }

        // A Circle is a Shape with a specific radius
        class Circle extends Shape {
            private double radius;

            public Circle(double radius) {
                this.radius = radius;
            }

            @Override
            public double getArea() {
                return 3.14 * radius * radius;
            }

        }
        ```

    Here we consider the example of a Shape class, which is the base class while many shapes like Rectangle and Circle extending from the base class are derived classes. These classes contain the getArea() method which
    calculates the area for the respective shape.

    ````

    3.  **Inheritance**

    ```
        public abstract class Person {
        private String name;
        private String phoneNumber;

        // abstract class have constructors
        public Person(String name, String phoneNumber) {
            this.name = name;
            this.phoneNumber = phoneNumber;
        }

        public Person(String name) {
            this.name = name;
        }

        public Person(){
            System.out.println("Person non-arguments construtor");
        }

        public abstract boolean signUp(); //???

        public void walk() {
            System.out.println("People Walk");
        }

        public void meeting() {
            System.out.println("People meeting");
        }
        }
        public class Student extends Person{
        public Student(String name, String phoneNumber) {
            super(name, phoneNumber);
        }

        public Student(){}

        @Override
        public boolean signUp() {
            return false;
        }

        @Override
        public void walk() {
            super.walk();
        }

        public void walkable() {
        super.walk();
        super.meeting();
        }

        public static void main(String[] args) {
            Student student = new Student();
            student.meeting();
        }

        }

    ```

    In this example, the Student class as sub-class(derived class) extends the Person class(super class). It inherits all the non-private fields (variables) and methods of the Person class. Since the Person class is an abstract class, which has an abstract method, the Student class must make an implement for this method.

2.  What is **wrapper class** in Java and Why we need wrapper class?

    In Java, a wrapper class is a class that encapsulates, or wraps, the primitive data types in Java into objects.

    The reason for Using Wrapper Classes:

    - Many of the Java Collections classes (like ArrayList, HashMap, etc.) and other APIs work with objects, not with primitive data types.
    - Wrapper classes provide useful methods for converting between primitive data types and strings, parsing values, and performing other utility functions.
    - Wrapper classes can be assigned a null value, whereas primitive data types cannot.

3.  What is the difference between **HashMap** and **HashTable**?

    - Synchronization:
      - **Hashtable**: It is synchronized, which means it is thread-safe. All its methods are implicitly synchronized, making it safe to use in a multi-threaded environment.
      - **HashMap**: It is not synchronized by default. If multiple threads access a HashMap concurrently and at least one of the threads modifies it structurally (adding or removing entries), it must be synchronized externally.
    - Null Values:
      - **Hashtable**: It does not allow null keys or values. If you attempt to insert a null key or value, a `NullPointerException` will be thrown.
      - **HashMap**: It allows one null key and multiple null values. This makes it more flexible when dealing with situations where null values are needed.
    - Performance:
      - **HashMap**: Generally, it performs better than **Hashtable** in a non-concurrent environment because it is not synchronized by default.
      - **Hashtable**: Due to its synchronized nature, **Hashtable** may have lower performance compared to **HashMap** in a single-threaded environment.
    - Inheritance:
      - Hashtable: It is a legacy class and was part of the original version of Java. It extends the Dictionary class.
      - HashMap: It is part of the Java Collections Framework and extends the AbstractMap class.

    In general, if you are working in a **single-threaded** environment and do not require synchronization, **HashMap** is often preferred due to its better performance. If you need synchronization or are working in a m**ulti-threaded** environment, **Hashtable** might be a better choice. However, for modern development, you might also consider using `ConcurrentHashMap` for thread-safe operations instead of Hashtable.

4.  What is **String pool** in Java and why we need String pool?

    In Java, the **String pool** is a special area in the `heap memory` where the literal strings are stored. When you create a string using double quotes, such as "hello", Java first checks the **string pool**. If a string with the same value already exists in the pool, the existing reference is returned instead of creating a new string object. This mechanism helps in conserving memory and improving performance.

    **Memory Efficiency:** Since strings are **immutable** in Java (their values cannot be changed once they are created), it makes sense to reuse existing string objects with the same value. This reduces the memory footprint of your program.

    **Performance**: String pooling improves the performance of programs by reducing the number of objects that need to be created. When you use a string literal, the JVM can check the pool first before creating a new object. This is particularly beneficial in scenarios where many string objects with the same value are created.

5.  What is Java **garbage collection**?

    Java **garbage collection** is a process that automatically manages the memory used by a Java program by reclaiming memory occupied by objects that are no longer in use. In Java, memory management is handled by the Java Virtual Machine (JVM), and the garbage collector is responsible for identifying and deleting unreferenced objects. Java's **garbage collection** mechanism allows developers to focus on application logic rather than memory management, contributing to Java's reputation for being a relatively safe and developer-friendly language.

6.  What are access modifiers and their scopes in Java?

    | Modifier  | DescriptionDescription                                             |
    | --------- | ------------------------------------------------------------------ |
    | default   | declarations are visible only within the package (package private) |
    | private   | declarations are visible within the class only                     |
    | protected | declarations are visible within the package or all subclasses      |
    | public    | declarations are visible everywhere                                |

7.  What is **final** key word?

    - **Field**: When the `final` keyword applied to a field, it indicates that the variable's value cannot be changed after it has been assigned a value. - **Method**: When the `final` keyword applied to a method, it indicates that the method cannot be `overridden` by subclasses. Subclasses are not allowed to provide a different implementation of a final method. - **Class**: When the `final` keyword applied to a class, it indicates that the class cannot be `subclassed`. It prevents other classes from extending it. |

8.  What is **static** key word? When do we usually use it?

    - **Field**: When the `static` keyword applied to a field, it indicates that the field is a class variable, shared among all instances of the class. There is only one copy of a static field that is shared by all instances of the class.
    - **Method**: When the `static` keyword applied to a method, it indicates that the method is a class method, and it can be called on the class itself rather than on an instance of the class. Static methods cannot directly access non-static variables or methods.
    - **Class**: When the `static` keyword applied to a class, it indicates that the nested class is a static nested class. Static nested classes do not have a reference to an instance of the enclosing class and can be instantiated without an instance of the outer class.
    - **Block**: A static block is a block of code enclosed in curly braces and preceded by the `static` keyword. It is used to initialize `static` variables or perform one-time initialization tasks for the class.

9.  What is the differences between **overriding** and **overloading**?

    **Method Overriding**: Method overriding is the process of redefining a parent class’s method in a subclass.

    **Method Overloading**: Method Overloading is two functions have diffrerent number of arguments, different type aruments, but with thesame method name.
    | Method Overloading | Method Overriding |
    | --- | --- |
    | Overloading happens at **compile time**. | Overriding happens at **runtime**. |
    | Gives **better performance** because the binding is being done at compile time. | Gives **less performance** because the binding is being done at run time. |
    | **Private** and **final** methods can be **overloaded**. | **Private** and **final** methods can **NOT** be overridden. |
    | Return type of method does not matter in case of method overloading. | Return type of method must be the same in the case of overriding. |
    | **Arguments must be different** in the case of overloading. | Arguments must be the same in the case of overriding. |
    | It is being done in the **same class**. | Base and **derived(child) classes** are required here. |
    | Mostly used to increase the **readability** of the code. | Mostly used to provide the **implementation** of the method that is already provided by its base class. |

10. What is the differences between **super** and **this**?

    **this**: `this` refers to the current instance of the object within which it is used. It distinguishes instance variables from local variables when they have the same name.

    **super**: `super` is used to refer to the immediate parent class (superclass) of the current object instance.

11. What is the Java **load sequence**?

    1. Loading: the JVM loads the binary representation of a class into memory.
    2. Linking: The linking phase consists of three sub-phases: verification, preparation(memory is allocated for class variables and initialized), and resolution.
    3. Initialization: static variables are assigned their initial values and static blocks are executed.
    4. Class Constructor: The order is top-down, starting from the class that contains the main method. (Lazy Loading: a class is loaded into memory only when it is required for the first time.)

12. What is **Polymorphism**? And how Java implements it?

    In Java programming, polymorphism refers to the same object exhibiting different forms and behaviors. For example, take the Shape Class. The exact shape you choose can be anything. It can be a rectangle, a circle, a polygon or a diamond. So, these are all shapes but their properties are different. This is called Polymorphism.

    **Static polymorphism**: Static polymorphism is achieved through** method overloading** and method overriding at compile time.

    **Dynamic Polymorphism**: Dynamic Polymorphism is achieved through method overriding. It occurs at runtime and involves a base class and a derived class.

13. What is **Encapsulation**? How Java implements it? And why we need encapsulation?

    **Encapsulation** in OOP refers to binding the **data** and the **methods** to **manipulate** that data together in a single unit (class). Java usually implement it by getter and setter function in a class. The reason we need encapsulation intead of directly access the data variable, we use method to manipulate it to protect the data (security) and also increasing flexibility, extensibility and Organization of the code.

14. What is **Interface** and what is **abstract** class? What are the differences between them?

    **Abstract classes**:

    - An **abstract class** can have everything else as same as a normal Java class has `i.e. constructor, static variables and methods.`
    - **Non-abstract/Normal methods** can be implemented in an **abstract class**.
    - An abstract class **cannot** be **instantiated**.
    - Child classes **must implement all the abstract methods** declared in the parent abstract class.

    **Interfaces**:

    - An interface can have: abstract method(s), static method(s), private method(s), private static method(s), public static final variable(s) and default method(s) (Java 8)
    - methods -> by default public
    - varibles -> by default public static final
    - cannot be instantiated.
    - An interface cannot be declared private or protected.
    - To use an interface, a class **must** `implement` all of the `abstract` method(s) declared in it.
    - cannot have constructor(s) in it.
    - An interface can extend from another interface.

      Note: A class uses the keyword `implements` to use an interface but an interface uses the keyword `extends` to use another interface.

    **Abstract classes**: Abstract classes are used when there is some common behavior that all subclasses must share. (e.g. Shape, Animal class/subclass)

    **Interfaces**: Interfaces are used when there is a set of behaviors that all subclasses must support, but the implementation.

15. Design a parking lot

    The code has created in the codingQuestions/coding1 folder.

16. What are Queue interface implementations and what are the differences and when to use what?

    In Java, the `Queue` interface is a part of the Java Collections Framework and extends the `Collection` interface. It represents a collection designed for holding elements prior to processing, following the First-In-First-Out (FIFO) principle. There are several implementations of the `Queue` interface in Java, each with its own characteristics and use cases. Here are some commonly used Queue implementations:

    - LinkedList: It supports constant-time insertion and removal of elements at both ends of the list, making it efficient for queue operations.
    - PriorityQueue: Elements with higher priority are dequeued before elements with lower priority.
    - ArrayDeque: It provides fast O(1) time complexity for adding and removing elements from both ends.
    - ConcurrentLinkedQueue: It is suitable for high-concurrency scenarios and provides good performance in multi-threaded environments.

    Choosing the appropriate Queue implementation depends on your specific requirements and the characteristics of the problem you are solving. Consider factors such as thread safety, performance, blocking behavior, and ordering requirements when selecting a Queue implementation for your application.
