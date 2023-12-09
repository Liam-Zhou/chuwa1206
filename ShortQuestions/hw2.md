# HW2

## 1.  Write up Example code to demonstrate the three foundmental concepts of OOP. 
1. Encapsulation
Encapsulation is a process of Binding data and methods within a class. Think of it like showing the essential details of a class by using the access control modifiers (public, private, protected
 ). To achieve encapsulation in Java:
	- Declare the variables of a class as private.
	- Provide public setter and getter methods to modify and view the variable values.

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

## 6.  What are access modifiers and their scopes in Java?

## 7.  What is final key word? (Filed, Method, Class)

## 8.  What is static keyword? (Filed, Method, Class). When do we usually use it?

## 9.  What is the differences between overriding and overloading?

## 10.  What is the differences between super and this?

## 11.  What is the Java load sequence?

## 12.  What is Polymorphism ? And how Java implements it ? 

## 13.  What is Encapsulation ? How Java implements it? And why we need encapsulation? 

## 14.  What is Interface and what is abstract class? What are the differences between them?

## 15.  design a parking lot (put the code to codingQuestions/coding1 folder, )

## 16.  What are Queue interface implementations and what are the differences and when to use what?