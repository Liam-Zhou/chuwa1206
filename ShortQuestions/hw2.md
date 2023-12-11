# HW2

## 1.  Write up Example code to demonstrate the three foundmental concepts of OOP. 
1. Encapsulation
Encapsulation is a process of Binding data and methods within a class. Think of it like showing the essential details of a class by using the access control modifiers (public, private, protected
 ). To achieve encapsulation in Java:
	1. Declare the variables of a class as private.
	2. Provide public setter and getter methods to modify and view the variable values.

```
public class Employee {

    private String name;
    private int age;
    private double salary;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age > 0) {
            this.age = age;
        }
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        if (salary > 0) {
            this.salary = salary;
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Employee emp = new Employee();

        // Setting values through setter methods
        emp.setName("John Doe");
        emp.setAge(30);
        emp.setSalary(50000.0);

        // Accessing values through getter methods
        System.out.println("Employee Name: " + emp.getName());
        System.out.println("Employee Age: " + emp.getAge());
        System.out.println("Employee Salary: " + emp.getSalary());
    }
}

```


2. Polymorphism
Polymorphism is the process in which an object or function takes different forms. There are 2 types of Polymorphism :

	- Compile Time (static) Polymorphism (Method Overloading)
```
public class MathOperations {

    public int sum(int a, int b) {
        return a + b;
    }

    public int sum(int a, int b, int c) {
        return a + b + c;
    }
}
```
	- Run Time (dynamic) Polymorphism (Method Overriding)

```
class Shape {
    public void draw() {
        System.out.println("Drawing a shape");
    }
}

class Circle extends Shape {
    @Override
    public void draw() {
        System.out.println("Drawing a circle");
    }
}

class Rectangle extends Shape {
    @Override
    public void draw() {
        System.out.println("Drawing a rectangle");
    }
}

public class Main {
    public static void main(String[] args) {
        Shape myShape = new Shape();     
        Shape myCircle = new Circle();   
        Shape myRectangle = new Rectangle();

        myShape.draw();       // Output: Drawing a shape
        myCircle.draw();      // Output: Drawing a circle (method overriding)
        myRectangle.draw();   // Output: Drawing a rectangle (method overriding)
    }
}
```

3. Inheritance
Inheritance provides a way to create a new class from an existing class. The new class is a specialized version of the existing class such that it inherits all the non-private fields (variables) and methods of the existing class. 

	- Single Inheritance
```
class Bicycle {
    public int gear;
    public int speed;

    public Bicycle(int gear, int speed) {
        this.gear = gear;
        this.speed = speed;
    }

    public void speedUp(int increment) {
        speed += increment;
    }

    public String toString() {
        return ("Num of gears are " + gear + "\nSpeed of bicycle is " + speed);
    } 
}

class MountainBike extends Bicycle {

    public int seatHeight;

    public MountainBike(int gear, int speed, int startHeight) {
        // Invoking base-class constructor
        super(gear, speed);
        this.seatHeight = startHeight;
    } 

    public void setHeight(int newValue) {
        this.seatHeight = newValue;
    } 

    @Override
    public String toString() {
        return (super.toString() + "\nSeat height is " + seatHeight);
    }
}

```

	- Multiple Inheritance (using interfaces)
	
```
public interface Flyer {
    void fly();
}

public interface Swimmer {
    void swim();
}

public class FlyingFish implements Flyer, Swimmer {

    @Override
    public void fly() {
        System.out.println("FlyingFish is flying");
    }

    @Override
    public void swim() {
        System.out.println("FlyingFish is swimming");
    }

    public static void main(String[] args) {
        FlyingFish myFlyingFish = new FlyingFish();

        myFlyingFish.fly();   // Output: FlyingFish is flying
        myFlyingFish.swim();  // Output: FlyingFish is swimming
    }
}
```


## 2.  What is wrapper class in Java and Why we need wrapper class?
Wrapper classes in Java provide a way to use primitive data types (int, char, float, etc.) as objects. Each primitive data type in Java has a corresponding wrapper class:

- int ➔ Integer
- char ➔ Character
- byte ➔ Byte
- short ➔ Short
- long ➔ Long
- float ➔ Float
- double ➔ Double
- boolean ➔ Boolean

We need wrapper class for multiple reasons:
1. **Use in Collections**: Java collections such as `ArrayList`, `HashMap`, etc., can only hold objects and cannot store primitive types. 
2. **Use of Object Methods**: Wrapper classes provide a way to use methods and properties of objects. For example, the Integer class has methods like `.compareTo()`, `.toString()`, `.equals()`, and others.
3. **Null Assignment**: Primitives cannot be null, but their wrapper class objects can be. This is useful in scenarios where you may need to represent the absence of a value (e.g., in a database).
4. **Type Safety**: Wrapper classes help in enforcing type safety in generic code.
5. **Class-Level Operations**: Since primitives are not objects, operations like serialization, synchronization, etc., require the use of object counterparts.

## 3.  What is the difference between HashMap and HashTable?
| Feature                      | HashMap                          | HashTable                        |
|------------------------------|----------------------------------|----------------------------------|
| Synchronization              | Not synchronized (not thread-safe) | Synchronized (thread-safe)      |
| Null Values                  | Allows one null key and multiple null values | Does not allow null keys or values |
| Performance                  | Generally faster due to no synchronization | Slower due to synchronization    |
| Iterators                    | Fail-fast iterators               | Iterators are not fail-fast      |
| Subclass                     | Subclass of `AbstractMap`         | Subclass of `Dictionary`         |
| Method Synchronization       | Methods are not synchronized      | Methods are synchronized         |


## 4.  What is String pool in Java and why we need String pool?
The String Pool in Java is a special storage area in the Java heap memory. It's used to store a collection of `String` literals. When you create a `String` using string literals, Java first checks the string pool to see if an identical string already exists. If a match is found, the reference to the existing string is returned instead of creating a new one. 

We need String pool because
1. Memory Efficiency: The primary purpose of the String Pool is to reduce memory usage and improve performance. Since strings are immutable in Java, it makes sense to reuse them. If each string literal created a new object, it would lead to a significant memory overhead, especially considering how frequently strings are used.
2. Faster Comparisons: Comparing strings using `==` operator is much faster than using `equals()` method as it compares object references rather than the content. 

## 5.  What is Java garbage collection?

Garbage collection in java is the process of looking at heap memory, identifying which objects are in use and which are not and deleting the unused objects. An unused object or unreferenced object, is no longer referenced by any part of your program. Garbage collector is a daemon thread that keeps running in the background, freeing up heap memory by destroying the unreachable objects.


## 6.  What are access modifiers and their scopes in Java?
Access modifiers in Java are keywords used before a class, method, or variable to define its access level or scope.
| Modifier                      | Description                          |
|------------------------------|----------------------------------|
| Default              | declarations are visible only **within the package (package private）** |
| Private                  | declarations are visible only **within the class** |
| Protected                  | declarations are visible **within the package or all subclasses** |
| Public                    | eclarations are visible **everywhere**               |


## 7.  What is final key word? (Filed, Method, Class)

- A **final variable** becomes a constant, meaning its value cannot be modified once it is initialized.
- A **final method** cannot be overridden by subclasses.
- A **final class** cannot be subclassed. The fianl key word makes the class immutable

## 8.  What is static keyword? (Filed, Method, Class). When do we usually use it?
A static member is a member of a class that isn’t associated with an instance of a class. Instead, the member belongs to the class itself.
1. **Static Variable**: Only single copy of the variable gets created and all instances of the class share same static variable. The static variable gets memory only once in the class area at the time of class loading.
	- *When to use static variable*: static variables should be used to declare common property of all objects as only single copy is created and shared among all class objects, for example, the company name of employees etc.

2. **Static Method**: These methods belong to the class rather than the object of the class. As a result, a static method can be directly accessed using class name without the need of creating an object. You can’t access a non-static method or field from a static method.
	- *When to use static method*: Static methods are used for operations that don't require any data from an instance of the class (instance variables).

3. **Static Class**: You cannot declare a top-level class as static, but nested classes can be static. Static nested classes can access only the static members of the outer class. Static nested classes can be accessed without instantiating the outer class.
	- *When to use static class*: Static classes are used when you doesn't need to access the instance variables of the outer class.


## 9.  What is the differences between overriding and overloading?
- **Method overloading** occurs when two or more methods in the same class have the same name but different parameters (different type, number, or both of parameters). It is compile-time (static) polymorphism.
- **Method overriding** occurs when a subclass provides a specific implementation for a method that is already defined in its superclass. It is run-time (dynamic) polymorphism.

## 10.  What is the differences between super and this?
1. **Reference Difference**: `this` is a reference to the current object, whose method or constructor is being invoked, while `super` is a reference to the parent class object.
2. **Constructor Invocation**: `this()` is used to invoke a constructor of the same class, while `super()` is used to invoke a constructor of the immediate parent class.
3. **Method and Variable Access**: `this` is used to access members (methods or fields) of the current class, and `super` is used to access members of the parent class, particularly when they are overridden or hidden in the child class.

## 11.  What is the Java load sequence?
The Java load sequence refers to the order in which Java classes and objects are loaded, initialized, and instantiated. 
1. **Loading**: When a Java program runs, classes are loaded into memory. This happens the first time a class is referenced in the program. 
2. **Linking**: 
	- Verification: Ensures the correctness of the loaded class.
	- Preparation: Allocates memory for class variables and initializing the memory to default values.
	- Resolution: Transforms symbolic references from the type into direct references.
3. **Initialization**: Static variables are assigned their values and static blocks are executed in the order they appear in the class.

Java class loaders are responsible to the above steps. ClassLoader is a java class which is used to load `.class` files in memory. There are 3 types of built-in class loaders in java: bootstrap class loader, extensions class loade, and system class loader.


## 12.  What is Polymorphism ? And how Java implements it ? 
Polymorphism is the process in which an object or function takes different forms. There are 2 types of Polymorphism: compile-time (static) polymorphism and runtime (dynamic) polymorphism. Compile-time polymorphism is achieved through method overloading. Runtime polymorphism is achieved through method overriding.

## 13.  What is Encapsulation ? How Java implements it? And why we need encapsulation? 
Encapsulation is a process of Binding data and methods within a class. Java implements encapsulation by makeing the variables of a class `private`, and providing `public setter and getter` methods. We need encapsulation becuase:

1. **Increase Security**: By making the class variables private and only providing access through public methods, you can protect the integrity of the data.
2. **Hide Complexity**: Encapsulation helps to hide the complex implementation details and only expose what is necessary to the outside world.
3. **Modularization**: It helps in building independent modules that do not affect other parts of the program.

## 14.  What is Interface and what is abstract class? What are the differences between them?
- **Abstract class**: A class that is declared using “abstract” keyword is known as abstract class. It can have abstract methods (methods without body) as well as concrete methods (methods with body).

- **Interface**: An interface in Java is a blueprint of a class. It has static constants and abstract methods. Interfaces specify what a class must do but not how to do.

- The differences between them are: 
	- Abstract class can have both abstract and concrete methods but interface can only have abstract methods (Java 8 onwards, it can have default and static methods as well)
	- Abstract class methods can have access modifiers other than public but interface methods are implicitly public and abstract
	- Abstract class can have final, non-final, static and non-static variables but interface variables are only static and final
	- A subclass can extend only one abstract class but it can implement multiple interfaces
	- An Abstract class can extend one other class and can implement multiple interfaces but an interface can only extend other interfaces


## 15.  design a parking lot (put the code to codingQuestions/coding1 folder, )
Please see codingQuestions/coding1.

## 16.  What are Queue interface implementations and what are the differences and when to use what?
The `Queue` interface is used to represent a `queue` data structure, which is a collection ordered by FIFO (First In First Out) principle.
Implements of `Queue`:
1. LinkedList: Use LinkedList when frequent insertions and deletions are required.
2. PriorityQueue: Use PriorityQueue when you need to retrieve elements in a priority-based order.
3. ArrayBlockingQueue: ArrayBlockingQueue is a bounded, blocking queue that stores the elements internally in an array. It is thread-safe and orders elements FIFO. Use ArrayBlockingQueue when you need a size-limited collection.
