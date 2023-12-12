# Homework 2



## 1 Write up Example code to demonstrate the three foundmental concepts of OOP(Encapsulation, Polymorphism, Inheritance)



```java
// Encapsulation
class Car {
    private String brand;
    private int year;

    // Constructor
    public Car(String brand, int year) {
        this.brand = brand;
        this.year = year;
    }

    // Getter methods
    public String getBrand() {
        return brand;
    }

    public int getYear() {
        return year;
    }

    // Setter methods
    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setYear(int year) {
        this.year = year;
    }

    // Polymorphic method to print vehicle information
    public void printInfo() {
        System.out.println("Vehicle Info (Car):");
        System.out.println("Brand: " + brand);
        System.out.println("Year: " + year);
    }
}

// Inheritance
class ElectricCar extends Car {
    private int batteryCapacity;

    // Constructor
    public ElectricCar(String brand, int year, int batteryCapacity) {
        super(brand, year); // Call the constructor of the superclass (Car)
        this.batteryCapacity = batteryCapacity;
    }

    // Getter method for batteryCapacity
    public int getBatteryCapacity() {
        return batteryCapacity;
    }

    // Setter method for batteryCapacity
    public void setBatteryCapacity(int batteryCapacity) {
        this.batteryCapacity = batteryCapacity;
    }
    
    // Override the printInfo method to provide specific behavior for ElectricCar
    @Override
    public void printInfo() {
        super.printInfo();
        System.out.println("Battery Capacity: " + batteryCapacity);
    }
}

// Polymorphism
class VehicleInfoPrinter {
    // Overloaded method to print vehicle information for Car
    public void printVehicleInfo(Car vehicle) {
        System.out.println("\nPrinting Vehicle Info (Car) using Overloaded Method:");
        vehicle.printInfo();
    }

    // Overloaded method to print vehicle information for ElectricCar
    public void printVehicleInfo(ElectricCar electricCar) {
        System.out.println("\nPrinting Vehicle Info (ElectricCar) using Overloaded Method:");
        electricCar.printInfo();
    }
}
```



## 2 What is wrapper class in Java and Why we need wrapper class?



- A wrapper class is a class that wraps the functionality of a primitive data type into an object. The wrapper classes are part of the `java.lang` pacakge.

- Reasons for using wrapper classes:
  
  - Many Java collections such as `ArrayList`, `LinkedList`, work with objects not primitive data types
  
  - wrapper classes can represent `null` values
  
  - supports generic classes
  
  - Some methods only work with objects
  
  - Easily convert to/from Strings



## 3 What is the difference between HashMap and HashTable?



- HashMap is non-synchronized, so it's not thread-safe, while HashTable is synchronized.

- HashMap allows null keys and values while HashTable doesn't

- HashMap extends from `AbstractMap` while HashTable extends from `Dictionary` which is obsolete

- In most cases HashMap has better performances than HashTable.



## 4 What is String Pool in Java and Why we need String Pool?



- In Java, the String Pool is a pool of strings maintained by the Java Virtual Machine (JVM). String Pool is a part of the Java heap memory.

- It performs similar to caching, when a new string is created, the JVM checks the String Pool, if the string already exists, the new reference points. to the existing string.

- String Pool is memory efficient, has better performance, and consistent with string immutability in Java



## 5 What is Java garbage collection?



- Java Garbage Collection is a process in the Java Virtual Machine (JVM) that automatically reclaims memory occupied by objects that are no longer reachable or referenced in a program. 

- The primary goal of garbage collection is to free up memory and prevent memory leaks, where unused objects consume memory unnecessarily.



## 6 What are access modifiers and their scopes in Java?



- public: accessible from any classes

- default: no modifiers required, accessible within the same package

- protected: accessible within the same package and subclassess

- private: accessible only within the same class



## 7 What is final keyword?



- The final keyword is a modifier that can be applied to classes, methods, and variables

- final variables are immutable

- final methods are not allowed to be overridden

- final classes indicates that the class cannot be extended by other classes



## 8 What is static keyword?



- The static keyword is a modifier that can be applied to variables, methods, and nested classes.

- Static variables are associated with the class rather than the instances/objects of the class. There is only one copy of a static variable that is shared among all instances.

- Static Methods belong to the class rather than to instances of the class. Static methods can be called without creating an instance of the class

- Static blocks `static {}` will only be executed once when the class is loaded into memory.

- A static nested class is associated with the outer class rather than with instances of the outer class. It can be instantiated without creating an instance of the outer class.



## 9 What is the differences between overriding and overloading?



- Overloading happens at **compile** time (better performance), Overriding happens at **runtime** (less performance)

- Private and final **can be** overloaded, but **cannot be** overridden

- Return type of method does not matter for overloading, but must be the **same for overriding** 

- Arguments must be **different for overloading**, but must be the **same for overriding**

- Overloading is done **in the same class**, overriding happens **between base and child class**

- Overloading is mostly used to increase the **readability** of the code, overriding is mostly used to provide the implementation of the method that is **already provided by its base class**



## 10 What is the differences between super and this?



- `this` is used to refer to the current instance of the class

- `super` is used to refer to the immediate parent class. 

- They are used in different contexts and serve different purposes in Java programming.



## 11 What is Java load sequence?

- In Java, the load sequence refers to the sequence of steps that occur when a Java class is loaded by the Java Virtual Machine (JVM). 

- Class loading is part of the Java class loading mechanism, and it involves: Loading -> verification -> preparation -> resolution -> initialization



## 12 What is Polymorphism? How Java implements it?



- Polymorphism is one of the four fundamental principles of object-oriented programming (OOP), the idea is that an entity in code such as a variable, function or object can have more than one form.

- Java implements Polymorphism by overriding and overloading



## 13 What is Encapsulation? How Java implements it? Why we need encapsulation?



- Encapsulation is a key principle in OOP that promotes data hiding, modularity, and code flexibility. 

- It enhances the security and maintainability of code by providing a controlled and well-defined interface to interact with objects. 

- Java implements it by introducing access modifiers and OOP design.



## 14 What is Interface and what is abstract class? What are the differences between them?



- **Abstract classes** are used when there is some **common behavior that all subclasses must share**. (e.g. Shape, Animal class/subclass)
- **Interfaces** are used when there is a set of behaviors that all subclasses must support, but **the implementation details can vary**. (e.g. collection of data add/remove)



## 16 What are Queue interface implementations and what are the differences and when to use what?



- Use `LinkedList` when you need a general-purpose, simple, and versatile queue implementation.
- Use `ArrayDeque` when you want a resizable array-based implementation that supports both queue and stack operations efficiently.
- Use `PriorityQueue` when you need elements to be processed in a specific order based on their priority.



  


