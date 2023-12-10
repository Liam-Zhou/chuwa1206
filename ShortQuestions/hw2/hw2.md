# 1

Write up Example code to demonstrate the three foundmental concepts of OOP. (reference Code Demo repo as example)

![CleanShot 2023-12-09 at 21.26.58@2x](./assets/CleanShot%202023-12-09%20at%2021.26.58@2x.jpg)

1. Encapsulation;

   For detail, please check my OOP folder.

``` Java
package Encapsulation;

public class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

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
        this.age = age;
    }
}


```



1. Polymorphism;

Please check my  OOP folder.



1. Inheritance;

Please check my  OOP folder.






# 2

What is wrapper class in Java and Why we need wrapper class?

- `byte` → `Byte`
- `short` → `Short`
- `int` → `Integer`
- `long` → `Long`
- `float` → `Float`
- `double` → `Double`
- `char` → `Character`
- `boolean` → `Boolean`



Le me maken an example: Imagine that we have some coins and banknotes (these represent basic data types in Java, such as `int`, `double`, `char`, etc.). These coins and banknotes are very practical, but if we want to use a vending machine, we need to put them into a form that can be accepted by the vending machine, like a banknote clip or a coin box (these are like the wrapper classes in Java).

In the world of Java, some operations or systems only accept "wrapped" data. For example, there are special containers or collections that can only store objects, not basic types like `int` directly. So, when we want to put a value of a basic type into these containers, we need to first "wrap" it into an object. That's the purpose of wrapper classes.



# 3

What is the difference between HashMap and HashTable?



I use my own word(example) to explain the difference:

1. **Thread Safety**:
   - Think of `HashTable` like a one-person-at-a-time bank counter. It's safe because only one person can do stuff at a time, but it's kinda slow. That's what it means to be thread-safe.
   - `HashMap` is more like a food court where everyone gets their food at the same time. It's faster, but if people don't follow the rules, it can get messy. So, `HashMap` isn't thread-safe, and you might need to be careful using it when lots of threads are involved.
2. **Performance**:
   - Because `HashTable` works like a single-service bank counter, it's slower when lots of threads are in play, unlike `HashMap`, which is like a busy food court, serving lots of people quickly when you're just dealing with one thread.
3. **Null Handling**:
   - `HashMap` is chill with having one null key and as many null values as you want, kind of like a store that doesn't mind if you browse without buying anything.
   - `HashTable` won’t let you have any null keys or values. It’s like a shop that only lets you in if you're definitely buying something.
4. **Modernity**:
   - `HashMap` is the newer kid on the block, fitting in with the modern Java style and part of the Java Collections crew.
   - `HashTable` is the old-timer. Still works, but you don't see it around much in the latest Java scenes.



# 4

What is String pool in Java and why we need String pool?



The String Pool in Java is a special storage area in Java's Heap memory. It's used to store a collection of String literals.

My visualized understanding：

The String Pool is like a library's special shelf to manage and reuse popular books efficiently, saving space and improving efficiency.

Let me make an example:

String Pool in Java like a special shelf in a library for popular books that many people read. If you want to read "名侦探柯南" and it's already on this shelf, the librarian gives you that copy. If your friend also wants to read it, they get the same copy, not a new one.

This is efficient because:

1. **Saves Space**: The library doesn't need multiple copies of "名侦探柯南" for everyone. Similarly, Java saves memory by reusing strings from the String Pool.
2. **Increases Efficiency**: The librarian quickly finds the book on the special shelf, just like Java quickly processes strings from the Pool.

But if you want a "名侦探柯南" with your own notes (like creating a completely new String object with `new String()` in Java), even if the book is in the library, you get a new one from the storage.



# 5

What is Java garbage collection?

Java garbage collection is a process by which the Java Virtual Machine (JVM) automatically identifies and discards objects that are no longer being used by a Java application, thus reclaiming their memory. This process is crucial in managing memory in Java applications, as it helps prevent memory leaks and ensures efficient use of memory.





# 6

What are access modifiers and their scopes in Java?

1. **public:** The `public` modifier allows full visibility to other classes. Any class from any package can access a `public` class, method, or field. This is the least restrictive access level.
2. **protected:** A `protected` element is accessible within its own package and also by subclasses in other packages. This modifier is more restrictive than `public` but less restrictive than `default` and `private`.
3. **default (package-private):** When no access modifier is specified, the default access level is applied. Elements with default access can be accessed only within their own package. This is more restrictive than `public` and `protected`, but less restrictive than `private`.
4. **private:** The `private` modifier is the most restrictive access level. Elements declared as `private` can be accessed only within the class in which they are declared. They are not visible to subclasses or to other classes in the same package.





# 7

What is final key word? (Filed, Method, Class)

In Java, the `final` keyword is used to indicate that a variable's value, once assigned, cannot be changed (creating constants); for methods, it means the method cannot be overridden by subclasses; and for classes, it signifies that the class cannot be inherited. In short, `final` is used to create immutable variables, non-overridable methods, and non-inheritable classes.



# 8

What is static keyword? (Filed, Method, Class). When do we usually use it?

My visualized understanding：

Imagine that in a classroom, there's a rule or an item that belongs to the whole class rather than to any individual student. This rule or item is like a `static` element in Java.

1. **`static` Variables:** These are like shared items in a classroom, such as a printer. No matter how many students are in the class, there's only one printer, and everyone shares it.
2. **`static` Methods:** These are like a common rule or a notice board in the classroom. It doesn't matter who the student is; anyone can view this rule or notice board and use it.
3. **`static` Class:** We use `static` when we want something to be shared across the entire class (in Java, the class) rather than each student (object) having their own copy. For example, shared resources (variables) or services that everyone can use (methods).

# 9

What is the differences between overriding and overloading?

- **Method Overloading:** In the same class, methods have the same name but differ in parameters (type or number). The purpose is to enable the same method name to handle different types or numbers of arguments, enhancing the flexibility and readability of the code.
- **Method Overriding:** In subclassing, a method in the subclass has the same name and parameters as a method in its superclass. The goal is for the subclass to provide its specific implementation, modifying or expanding the behavior of the method from the superclass.



# 10

What is the differences between super and this?

- **this:** Refers to the current object instance. Used for accessing current class's methods, fields, and constructors.
- **super:** Refers to the superclass (parent class). Used for accessing superclass's methods, fields, and constructors, especially when they are overridden in the subclass.



# 11

What is the Java load sequence?
In Java, the class loading sequence is:

1. **Loading**: The Java Virtual Machine (JVM) loads the class bytecode into memory when the class is first used.
2. **Linking**: This involves verification (checking bytecode correctness), preparation (allocating memory for class variables), and resolution (converting symbolic references to direct ones).
3. **Initialization**: Static initializer blocks and static variables are executed and initialized in the order they appear in the class.



# 12

What is Polymorphism ? And how Java implements it ?

Polymorphism in Java allows objects of different classes to be treated as objects of a common superclass. It's implemented in two main ways:

1. **Method Overloading**: The same method name with different parameters within the same class, allowing different behaviors based on the parameter list.
2. **Method Overriding and Dynamic Dispatch**: In subclasses, methods can override methods of their superclass, enabling runtime determination of the method to execute based on the object's actual type.



# 13

What is Encapsulation ? How Java implements it? And why we need encapsulation?

Encapsulation is a core concept in object-oriented programming. It involves bundling data (variables) and methods that operate on this data into a single unit, usually a class, and restricting direct access to these data for protection of integrity and security.

Implementation of Encapsulation in Java:

In Java, encapsulation is implemented using access modifiers like `private`, `protected`, and `public`. Typically, class fields (member variables) are set to private, and they are accessed and modified via public getter and setter methods.

Why Encapsulation is Necessary：

1. **Controlled Access:** Restricts direct access to data, preventing unauthorized or harmful modifications.
2. **Enhanced Security:** Encapsulation allows adding validation logic within internal logic, ensuring data integrity and safety.
3. **Ease of Maintenance:** Encapsulated code is more modular, making it easier to understand, maintain, and debug.
4. **Flexibility:** Encapsulated code can be modified and extended easily without affecting other parts of the code.



# 14

What is Interface and what is abstract class? What are the differences between them?

1. **Interface**: A blueprint for a class with methods that lack implementation. Interfaces allow multiple inheritances and can contain default and static methods with a body (Java 8+), but traditionally only had abstract methods.
2. **Abstract Class**: A class that cannot be instantiated and can include a mix of implemented and unimplemented methods. Abstract classes support single inheritance and can have methods with various access modifiers.
3. **Key Differences**:
   - Interfaces are purely abstract and cannot hold any state, while abstract classes can have a state and concrete methods.
   - A class can implement multiple interfaces but can extend only one abstract class.
   - Interfaces in Java 8 and later can have default and static methods with bodies, unlike abstract classes, which have always been able to contain method implementations.



# 15

design a parking lot (put the code to codingQuestions/coding1 folder, )

Please check hw2 folder in CodingQuestions



# 16

What are Queue interface implementations and what are the differences and when to use what?

the `Queue` interface is part of the Java Collections Framework and provides several implementations, each with unique characteristics and use-cases. Here are some of the most commonly used implementations of the `Queue` interface:

1. **LinkedList**:
   - **Characteristics**: `LinkedList` implements both `List` and `Queue` interfaces. It provides FIFO (First-In-First-Out) queue operations.
   - **Use Cases**: It is best used when you need both list and queue operations, such as frequent insertions and deletions at both ends.
2. **PriorityQueue**:
   - **Characteristics**: A `PriorityQueue` orders elements according to their natural ordering or based on a `Comparator` provided at queue construction time. It does not permit `null` elements.
   - **Use Cases**: Use it when you need to process elements in a priority order defined either by their natural order or by a custom `Comparator`.
3. **ArrayDeque**:
   - **Characteristics**: `ArrayDeque` is a resizable-array implementation of the `Deque` interface. It is more efficient than `LinkedList` for queue operations.
   - **Use Cases**: Ideal for stacks and queues where null elements are not used. It's a good choice when you need a resizable array implementation of a deque.