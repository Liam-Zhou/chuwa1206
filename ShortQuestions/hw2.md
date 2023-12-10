short question from kaiyuan tang

> [!NOTE]
> This a markdown file for hw2

## questions solved
- [x] [question 1](#question-1)
- [x] [question 2](#question-2)
- [x] [question 3](#question-3)
- [x] [question 4](#question-4)
- [x] [question 5](#question-5)
- [x] [question 6](#question-6)
- [x] [question 7](#question-7)
- [x] [question 8](#question-8)
- [x] [question 9](#question-9)
- [x] [question 10](#question-10)
- [x] [question 11](#question-11)
- [x] [question 12](#question-12)
- [x] [question 13](#question-13)
- [x] [question 14](#question-14)
- [x] [question 15](#question-15)
- [x] [question 16](#question-16)

## question 1

1. Encapsulation
   Wrapping the data and method together as a single unit. 
   
   Variables of a class are hidden from other classes and can be accessed only through the methods of their current class.

   ```java
   public class Account {
       private double balance; // Encapsulated field
   
       public Account(double initialBalance) {
           if (initialBalance > 0) {
               this.balance = initialBalance;
           }
       }
   
       public void deposit(double amount) {
           if (amount > 0) {
               balance += amount;
           }
       }
   
       public double getBalance() {
           return balance;
       }
   }
   
   ```
<br>

2. Inheritance allows a new class to inherit properties and behavior (methods) from an existing class.

   ```java
   // Superclass
   public class Animal {
       public void eat() {
           System.out.println("This animal eats food.");
       }
   }
   
   // Subclass
   public class Dog extends Animal {
       @Override
       public void eat() {
           System.out.println("Dog eats dog food.");
       }
   
       public void bark() {
           System.out.println("Dog barks.");
       }
   }

   ```
<br>

3. Polymorphism: Allows objects of different classes to be treated as objects of a common superclass.

   ```java
   public class Main {
       public static void main(String[] args) {
           Animal animal = new Animal(); // Animal reference and object
           Animal dog = new Dog(); // Animal reference but Dog object
   
           animal.eat(); // Calls method in Animal class
           dog.eat(); // Calls method in Dog class (Polymorphism)
       }
   }

   ```

## question 2
wrapper classes are a part of the Java language that provide a way to use primitive data types (like `int`, `char`, `double`) as objects.

1. Use in Collections: Java collections work with objects and not primitive types.
2. Utility Methods: Wrapper classes provide a variety of utility methods for primitives. `Integer.parseInt()`, etc.
3. Null Value Support: Primitives cannot be `null`, but their wrapper classes can be. Represent the absence of a value or the default uninitialized state.
4. Object Manipulation: Primitives are not objects and do not belong to the object hierarchy. Pass to a method expecting an Object parameter.
5. Type Conversion and Casting.
6. Generics Support: Generics in Java work with Objects, not primitive types.
7. Auto-boxing and Unboxing



## question 3
1. **Synchronization and Thread Safety:**

   `HashMap` is non-synchronized and not thread-safe, whereas `HashTable` is synchronized and thread-safe. (integrity guarantee for multiple threads access)

2. **Null Acceptance:** 

   `HashMap` _allows_ null values and a null key, but `HashTable` _does not allow_ null keys or values.

3. **Performance:** 

   `HashMap` is generally faster and more memory efficient than `HashTable` due to the lack of synchronization.


## question 4
The String Pool in Java is a special storage area in the Java **Heap memory**. It is used to store a collection of String literals. 

When you create a String using a **string literal**:

1. Java first checks if the string already exists in the pool. If it does, Java returns a reference to the pooled instance; 
2. if not, it creates a new String object and places it in the pool. This process is known as _interning_.

**Benefits:**
1. **Efficiency in Memory Usage:**
   
   In the String pool, identical strings can be shared and reused.

2. **Faster String Comparison:**

   When comparing two strings that are interned, you can use `==` instead of `equals()`. This is a faster comparison because it compares _reference equality_ (i.e., the memory addresses).

3. **Safe to Share:** 

   string literals in the pool can be safely shared without worrying about their values being altered.



## question 5
Java Garbage Collection is a process by which the **Java Runtime Environment (JRE)** reclaims heap memory occupied by objects that are no longer in use or referenced by the application (_reachability analysis_).


## question 6
**Access modifiers** in Java are keywords used in class, method, and variable declarations to control their visibility and accessibility from other parts of the code.

| Modifier   | Same Class | Same Package | Subclass (Same Package) | Subclass (Different Package) | World |
|------------|:----------:|:------------:|:-----------------------:|:----------------------------:|:-----:|
| public     |    Yes     |     Yes      |           Yes           |              Yes             |  Yes  |
| protected  |    Yes     |     Yes      |           Yes           |              Yes             |   No  |
| default    |    Yes     |     Yes      |           Yes           |               No             |   No  |
| private    |    Yes     |      No      |            No           |               No             |   No  |

1. **Private**

   Commonly used for variables and methods that are intended to be used internally by the class itself.
2. **Default (Package-Private)**

   Useful when you want to allow access to members of classes within the same package but hide them from the rest of the application.
3. **Protected**

   Typically used when you want to allow a specific property or method to be accessible to subclasses, potentially overriding or using it.
4. **Public**

   Used when you want to make a class, method, or variable accessible from any other part of the application.




## question 7
1. **field:**

   A `final field` cannot be modified once it is initialized. It must be initialized when it is declared or in the constructor of the class.
2. **method:** 

   A `final method` cannot be overridden by subclasses. It ensures that the method's implementation remains constant.
3. **class:** 

   A `final class` cannot be subclassed. This is useful when you want to prevent the class from being extended, often for reasons of security, simplicity, or design philosophy.

## question 8
1. **field:** 

   A `static field` is shared among all instances of a class. It belongs to the class itself rather than to individual objects.
2. **method:** 

   A `static method` belongs to the class and does not need an instance to be invoked. It can only access static members of the class.
3. **class:** 

   static cannot be applied to a class, but it can be used in nested classes. A `static nested class` is associated with its outer class, and like static methods and fields, it does not require an instance of the outer class to be created.

## question 9
**Overriding:** 

Overriding happens when a _subclass provides a specific implementation_ for a method that is already provided by one of its parent classes or implemented interfaces. 
The method in the subclass must have the _same name, return type, and parameters_ as the method in the parent class.

<br>

**Overloading:** 

Overloading occurs when two or more methods in the same class have the _same name but different parameters_ (different type, number, or both). 
It's a way to create multiple methods with the same name but different implementations.


## question 10
`super`

Refers to the _immediate parent class object_ and is used to access or call the parent class's methods and constructors.

(Commonly used in method overriding, when you need to call a method from the parent class)

`this`

Refers to the _current instance of a class_ and is used to access methods, constructors, and fields of the current object. 

(differentiating between class fields and parameters with the same name, and for calling one constructor from another)


## question 11
**Java Load Sequence**

1. Class Loading: When a class is used for the first time, it is loaded by the _classloader_. 
   
   The classloader reads the bytecode from a `.class` file and converts it into a class object.


2. Linking: Involves verifying, preparing, and (optionally) resolving the class. 

   Errors like `NoClassDefFoundError` can occur in this phase.


3. static initialization: Static initializers and static initialization blocks are executed. 

   This includes `static fields` and `static blocks`, executed in the order they appear in the class.


4. Creation of Object: Memory is allocated for the object on the heap, instance variables default initialized. `Instance initializers` and `constructors` are executed in the order they appear in the class.


initializer example:
```java
public class MyClass {
    static {
        // Static initializer block
        System.out.println("Static initializer executed.");
    }

    {
        // Instance initializer block
        System.out.println("Instance initializer executed.");
    }

    public MyClass() {
        System.out.println("Constructor executed.");
    }

    public static void main(String[] args) {
        MyClass obj = new MyClass();
    }
}

```

## question 12
Polymorphism refers to the ability of a single interface to represent different underlying data types.

1. _Compile-Time_ Polymorphism (Static Polymorphism): 

   This is achieved through _method overloading and operator overloading_. It's called compile-time polymorphism because the decision about which method to call is made by the compiler at compile time.

   ```java
   public class OverloadingExample {
    void demo (int a) {
       // Method with 1 integer parameter
    }
    void demo (int a, int b) {
       // Method with 2 integer parameters
    }
    double demo(double a) {
       // Method with double parameter
       return a*a;
    }
   }
   ```

2. _Runtime_ Polymorphism (Dynamic Polymorphism): 

   This is achieved through _method overriding_, typically using a _base class reference to refer to a subclass object_. The decision about which method to execute is made at runtime.

   ```java
   class Animal {
      public void sound() {
         System.out.println("Animal makes a sound");
      }
   }
   class Dog extends Animal {
      @Override
      public void sound() {
         System.out.println("Dog barks");
      }
   }
   class Main {
      public static void main(String args[]) {
         Animal obj = new Dog();
         obj.sound(); // Output: Dog barks
      }
   }
   ```   

## question 13
**Encapsulation:**

Bundling of data (variables) and methods that operate on the data into a single unit, or class, and restricting direct access to some of the object's components.

In Java, encapsulation is implemented using _access modifiers_ with classes, methods, and variables. 

Why Encapsulation:

1. **Control:** 

   Encapsulation gives control over the data by restricting who can access it.

2. **Data Hiding:** 

   By making the class variables private and providing public `setter` and `getter` methods, encapsulation hides the internal state of an object from the outside.

3. **Flexibility and Maintainability:** 

   It allows the developer to change the implementation of a class without affecting the client.

4. **Cohesion and Coupling:**

   Encapsulation increases cohesion within classes and reduces coupling between classes.



## question 14
**Interface**

An interface in Java is a reference type, they are used to achieve full abstraction and multiple inheritance in Java.
1. Interfaces cannot have fully implemented methods (except default and static methods).
2. A class can implement multiple interfaces, allowing for a form of _multiple inheritance_.
3. Interfaces cannot have constructors
4. Interfaces only allowed public methods.
5. Interfaces can only have public static final fields (constants).

**Abstract Class**

An abstract class in Java is a class that cannot be instantiated on its own and can contain a mix of methods declared with or without an implementation. 
Abstract classes are used to provide a base for subclass.
1. A class can extend only one abstract class, limiting it to _single inheritance_.

## question 15

## question 16

**Not thread safe**

1. `LinkedList`
   Characteristics: `LinkedList` implements both `List` and `Queue` interfaces. It is a doubly-linked list that can be used as a FIFO (First-In-First-Out) queue.
   Use Cases: It's suitable for applications that require frequent insertions and deletions of elements.
2. `PriorityQueue`
   Characteristics: PriorityQueue is a queue that orders its elements according to their natural ordering or by a Comparator provided at queue construction time.
   Use Cases: Use it when you need to process elements in a specific order other than FIFO.
3. `ArrayDeque`
   Characteristics: Elements can be added or removed from both the front (head) and the back (tail) of the queue. This makes it a `Deque` (Double Ended Queue).
   Use Cases: Used as a stack (LIFO - Last In First Out) with methods `push()` and `pop()`, used as a regular queue (FIFO - First In First Out) with methods `offer()` and `poll()`.

**Thread safe:**

4. `ArrayBlockingQueue`
   Characteristics: `ArrayBlockingQueue` is a _bounded_, _blocking_ queue that stores the elements internally in an array. It follows FIFO. It is _thread-safe_.
   Use Cases: Suitable for producer-consumer scenarios. Use it when bounds need to be set on the maximum number of elements a queue can hold.
4. `LinkedBlockingQueue`
   Characteristics: `LinkedBlockingQueue` is an optionally bounded, _blocking_ queue based on linked nodes. It follows FIFO. It is _thread-safe_.
   Use Cases: It is more flexible in capacity compared to ArrayBlockingQueue. It is suitable for producer-consumer scenarios where the queue might grow dynamically.
5. `ConcurrentLinkedQueue`
   Characteristics: `ConcurrentLinkedQueue` is an _unbounded_, _thread-safe_ queue based on linked nodes and follows FIFO.
   Use Cases: Suitable for high-concurrency applications. Use it when scalability is a concern and you need _non-blocking_ operations.
7. `PriorityBlockingQueue`
   Characteristics: PriorityBlockingQueue is an _unbounded_, _blocking queue_ that uses the same ordering rules as PriorityQueue. It is _thread-safe_.
   Use Cases: Use it in multi-threaded scenarios where you need to process elements based on their priority and need to ensure thread safety.

