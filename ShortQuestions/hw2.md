**What are the three fundamental concepts of OOP?**
1. Encapsulation: 
```Java
public class Car {
    private String brand;

    public getBrand(){
        return this.brand;
    }

    public setBrand(String brand){
        this.brand = brand;
    }

    public void drive(){
        System.out.println("drive a car");
    }
    
}
```
2. Polymorphism: 
```Java
public interface Vehicle {
    void drive();
}

public class Car implements Vehicle {
    @Override
    public void drive() {
        System.out.println("Drive a car");
    }

    public void drive(int passengers) {
        System.out.println("Drive a car with " + String.valueOf(passengers) + " passengers");
    }
}

public class Bike implements Vehicle {
    @Override
    public void drive() {
        System.out.println("Ride a bike");
    }

   
}

```
3. Inheritance: 
```Java
public class Vehicle {
    public void drive() {
        System.out.println("Drive a vehicle");
    }
}

public class Car extends Vehicle {
    @Override
    public void drive() {
        System.out.println("Drive a car");
    }
}

```


**What is a wrapper class in Java and why do we need it?**
- Wrapper class provides a way to use primitive types like `int` as an object. This is necessary becuase Java is object-oriented. Sometimes it's necessary to use wrapper class. Example:
    ```Java
    ArrayList<int> myNumbers = new ArrayList<int>(); // Invalid

    ArrayList<Integer> myNumbers = new ArrayList<Integer>(); // Valid
    ```

**What is the difference between HashMap and HashTable?**
- `HashMap` and `Hashtable` both store data in key-value pairs but differ in <span style="color:orange">synchronization and null allowance </span>. HashMap is unsynchronized, allowing null values and keys, whereas Hashtable is synchronized and doesn't allow nulls.


**What is the String pool in Java and why do we need it?**
- String pool is a storage space in the Java heap memory where string literals are stored. It is also known as String Constant Pool or String Intern Pool. 
- We need it becuase it decreases the number of String objects created in the JVM, thereby reducing memory load and improving performance.
- Reference: https://www.scaler.com/topics/java/string-pool-in-java/


**What is Java garbage collection?**
- Java's garbage collection is an automatic process of memory management, freeing up memory that is no longer in use by an application. It helps in managing memory efficiently and preventing memory leaks.

**What are access modifiers and their scopes in Java?**
- default: declarations are visible only within the package (package private)  
- Private: declarations are visible within the class only
- Protected: declarations are visible within the package or all subclasses 
- public: declarations are visible everywhere


**What is the final keyword?**
- Variable:
    - `public static final String APP_NAME=“testApp”`
    - Purpose: define constants

- Method
    - `public final int add(int a, int b){ return a + b; }`
    - Purpose: prevent override Class

- Class
    - final class MyClass(){}
    - Purpose:
        1. prevent inheritance,like Integer,String class etc; 
        2. Make class immutable

**What is the static keyword?**
- The static keyword is a non-access modifier used for methods and attributes. Static methods/attributes can be accessed without creating an object of a class.
- Example: 

**What are the differences between overriding and overloading?**
 - Method overriding is the process of redefining a parent class’s method in a subclass.
    - Method overriding is very useful in OOP. Some of its advantages are stated below:
    - The derived classes can give their own specific implementations to inherited methods without modifying the parent class methods.
For any method, a child class can use the implementation in the parent class or make its own implementation.

 - Method overloading refers to methods with the same name, but different number of arguments. 
    - Same number of arguments with different types is allowed
    - different return types is allowed if they have different arguments (different type, number, or both)

**What are the differences between super and this?**
- Super keyword is used to access methods of the parent class while this is used to access methods of the current class

**What is the Java load sequence?**

1. Static Blocks and Static Variables: These are initialized first, in the order they appear in the class.

2. Constructor: After all static and instance variables have been initialized, the constructor of the class is called

**What is Polymorphism, and how does Java implement it?**
- Polymorphism in Java is the ability of an object to take many forms. It's implemented through method overloading (same method name, different parameters) and method overriding (same method name, same parameters, in subclass).

**What is Encapsulation, how does Java implement it, and why do we need it?**
- Encapsulation in OOP refers to binding the data and the methods to manipulate that data together in a single unit (class).

**What is an Interface and what is an abstract class? What are the differences between them?**
- Interfaces and abstract classes in Java are used for achieving abstraction. 
- An interface can only have abstract methods, while an abstract class can have both abstract and non-abstract methods. 
- Interfaces support multiple inheritance, whereas abstract classes do not.

**What are Queue interface implementations and what are the differences and when to use what?**
- LinkedList: Implements both List and Queue interfaces. It's useful when you need both functionalities. Good for implementing a standard queue.

- PriorityQueue: Elements are ordered based on their natural ordering or by a Comparator provided at queue construction time. Ideal for priority-based tasks where elements need to be processed in a specific order.

- ArrayDeque: It's an array-based implementation. Likely faster than LinkedList for most Queue operations. It's better suited for queues where elements are frequently added and removed from both ends.
