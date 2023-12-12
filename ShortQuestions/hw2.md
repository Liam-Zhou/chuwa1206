# HW 2

## Question 1 Write up Example code to demonstrate the three foundmental concepts of OOP

**Encapsulation**
```
public class Person{
    private String name;
    private int age;
    public Person(String name, int age){
        this.name=name;
        this.age=age;
    }

    public String getName(){
        return name;
    }

    public void changeName(String name){
        this.name=name;
    }

    public int getAge(){
        return age;
    }

    public void setAge(int age){
        this.age=age;
    }

}

public class Main{
    public static void main(String[] args){
        Person citizen = new Person("Jackson",20);

        if (citizen.getAge()>18){
            citizen.changeName("Jack");
        }
    }
}
```

**Polymorphism**

- Complie-time Polymorphism (overloading):
```
public class Calculator{
    int add(int a, int b){
        return a+b;
    }
    
    double add(double a, double b){
        return a+b;
    }
}
```
Runtime Polymorphism (overriding):
```
public class Animal{
    void makeSound(){
        System.out.println("Animal makes sound");
    }
}

public class Dog extends Animal{
    @Override
    void makeSound() {
        System.out.println("Dog barks");
    }
}
```

**Inheritance**
```
public class Vehicle {
    public void move() {
        System.out.println("Vehicle is moving");
    }
}
public class Car extends Vehicle {
    public void horn() {
        System.out.println("Car horn");
    }
}
public class Main {
    public static void main(String[] args) {
        Car myCar = new Car();
        myCar.move(); 
        myCar.horn();
    }
}
```

## Qeustion 2 What is wrapper class in Java and Why we need wrapper class?
A wrapper class in Java is used to convert primitive data types (like int, char, etc.) into objects. We need wrapper class because:

- Java's object-oriented nature often requires objects instead of primitives.
- Collections in Java, like ArrayList and HashMap, work with objects, not primitives.
- Wrapper classes provide utility methods for primitives.
- Wrapper classes null values, unlike primitives.

## Question 3 What's the difference between HashMap and Hashtable?
HashMap and HashTable in Java differ in following aspects:

- **Synchronization**: HashTable is synchronized and thread-safe, while HashMap is not, making HashMap more efficient in single-threaded scenarios.

- **Null Values**: HashMap allows one null key and multiple null values, but HashTable doesn't allow any null keys or values.

- **Inheritance**: HashTable inherits from the legacy Dictionary class, whereas HashMap is part of the modern Java Collections Framework and inherits from AbstractMap.

- **Iterators**: HashMap's iterators are fail-fast, potentially throwing ConcurrentModificationException during iteration. HashTable uses enumerators, which are not fail-fast.

- **Performance**: HashMap generally offers better performance in non-threaded applications due to its lack of synchronization.

## Questions 4 What is String pool in Java and why we need String pool?
The String pool in Java is a special storage area in the Java Heap memory where Java stores literal string values. When a string is created and it already exists in the pool, Java reuses the existing string from the pool instead of creating a new one. This is called string internment.

Why we need String pool:

- **Memory Efficiency**: It reduces memory usage by avoiding multiple instances of identical strings.
- **Performance**: Reusing immutable strings from the pool is faster than creating new instances.

## Question 5 What is Java garbage collection?

Java garbage collection is an automatic process that frees up memory by discarding objects that are no longer in use. It operates primarily on heap memory, targeting objects without references. This mechanism helps prevent memory leaks and optimizes application performance. Java employs a generational collection strategy, managing objects based on their age for efficiency.


## Question 6 What are access modifiers and their scopes in Java?
Access modifiers in Java determine the visibility and accessibility of classes, methods, and variables. There are four main types:

- **public**: Accessible from anywhere in the program.

- **protected**: Accessible within the same package and by subclasses.

- **default (no modifier)**: Accessible only within the same package.

- **private**: Accessible only within the class it is declared.


## Question 7 What is final key word? (Filed, Method, Class)
The final keyword in Java is used to apply restrictions on variables, methods, classes and fields:

- **Final Field**: Once a final field is initialized, it cannot be altered. This effectively makes the field a constant.

- **Final Method**: A final method cannot be overridden by subclasses, preserving its implementation throughout the inheritance hierarchy.

- **Final Class**: A final class cannot be extended by any other class, thus blocking any inheritance from it.

## Question 8 What is static keyword? (Filed, Method, Class). When do we usually use it?
The static keyword in Java is used to indicate that a particular member (field, method, or block) belongs to the class itself, rather than to individual instances of the class.

- **Static Variable**: A single copy of the variable shared by all instances of the class. Used for common data across objects.

- **Static Method**: A method that belongs to the class, not instances. Can be called without an object. Used for operations that don't require object data.

- **Static Class (Only for nested classes)**: A nested class that does not have access to instance-specific data of the outer class. Used for grouping classes logically without needing outer class instances.

## Question 9 What is the differences between overriding and overloading?

**Overriding**:

- Occurs when a subclass provides a specific implementation for a method that is already defined in its parent class.
- Methods have the same name, return type, and parameters.
- Used for runtime polymorphism and method implementation customization in subclasses.


**Overloading**:

- Happens when two or more methods in the same class have the same name but different parameters (different type, number, or both).
Return type can vary.
- Provides multiple ways to use a method with different inputs.


## Question 10 What is the differences between super and this?

**super**:

- Refers to the superclass (parent class) of the current object.
- Used to access methods and variables of the parent class.
- Can invoke a superclass's constructor in a subclass.

**this**:

- Refers to the current instance of the class.
- Used to access methods and variables of the current class.
- Can invoke another constructor of the same class.

## Question 11 What is the Java load sequence?

The Java class loading sequence involves:

- **Class Loading**: Locating and loading the class bytecode into memory.

- **Linking**:

    - **Verification**: Checking bytecode validity.
    - **Preparation**: Allocating memory for class variables, initializing to default values.
    - **Resolution**: Converting symbolic references to direct references.

- **Initialization**: Assigning values to static variables and executing static blocks. This occurs when the class is first used.


## Question 12 What is Polymorphism ? And how Java implements it?
**Polymorphism** in Java is the ability of an object to take many forms. Java implements it mainly in two ways:

- **Compile-time Polymorphism (Method Overloading)**: Same method name with different parameters within the same class, allowing methods to behave differently based on the arguments passed.

- **Runtime Polymorphism (Method Overriding)**: A subclass overrides a method of its superclass, enabling different behaviors in subclass objects through the same method call, determined at runtime.

## Question 13 What is Encapsulation ? How Java implements it? And why we need encapsulation?

**Encapsulation** in Java is the practice of keeping fields within a class private and providing access to them via public methods (getters and setters). Java implements encapsulation by:

- Declaring class variables as private.
- Providing public getter and setter methods to access and update these variables.

Encapsulation is used to:

- Protect the integrity of the data by restricting direct access to fields.
- Maintain control over the values stored in fields, enabling validation within setters.
- Hide the internal workings of a class, making it easier to modify or maintain without affecting users of the class.

## Question 14 What is Interface and what is abstract class? What are the differences between them?
**Interface**:

- A blueprint of a class with abstract methods (Java 8 onwards allows default and static methods).
- Used to implement multiple interfaces in a class, enabling multiple inheritance.
- All methods are implicitly public and abstract (unless they are default or static).

**Abstract Class**:

- A class that cannot be instantiated and may contain abstract as well as concrete methods.
- Used when subclasses share a common structure or behavior.
- Can have constructors, member variables, and concrete methods.


Differences:

- **Inheritance**: A class can implement multiple interfaces but can only extend one abstract class.
- **Method Types**: Interfaces can only have abstract, default, or static methods, whereas abstract classes can have a full range of methods.
- **Access Modifiers**: Interface methods are public by default, but methods in abstract classes can have any access modifier.

## Question 15 Desgin a Parking Lot

Show in CodingQuestions


## Question 16 What are Queue interface implementations and what are the differences and when to use what?

In Java, the Queue interface has several implementations, each with specific use cases:

**LinkedList**:
- General-purpose queue.
- Used for implementing standard queue operations with no capacity restrictions.

**PriorityQueue**:
- Orders elements based on priority.
- Commonly used for tasks like scheduling where priority matters.


**ArrayDeque**:
- Efficient stack and queue operations.
- Often used as a faster alternative to Stack and LinkedList for queues and double-ended queues.

**LinkedBlockingQueue**:

- Designed for producer-consumer scenarios in multi-threaded environments.
- Useful in concurrent applications for safe and efficient transfer of elements between threads.

**ConcurrentLinkedQueue**:

- Suitable for high-concurrency applications.
- Used when multiple threads share a single queue without locking.

Choose based on factors like blocking/non-blocking operations, ordering requirements, concurrency needs, and performance considerations.