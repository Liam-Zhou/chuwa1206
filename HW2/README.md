
# Homework2

## 1. Write up Example code to demonstrate the three foundmental concepts of OOP. (the codes are shown in Java project)
### Encapsulation:

Encapsulation package the attributes and behavior of an abstract thing into a class, and use access modifier to manage the access control.

### Polymorphism:

polymorphism refers to the same object exhibiting different forms and behaviors.   

Static Polymorphism - Overload (same class) - compile time
Dynamic Polymorphism - Override (child class) - run time

### Inheritance:

Inheritance means that we can extend or implement the parent class or interface.

One class can only extend one parent class, one interface can extend one or more interface, one class can implements one or more interface.

## 2. What is wrapper class in Java and Why we need wrapper class?

Wrapper class is the class formation of primetive type variables. Somethings we need their class type like in collections List<Integer>

## 3. What is the difference between HashMap and HashTable? 

HashMap is not synchronized, Hashtable is synchronized.  
HashMap allows one null key and multiple null values, HashTable not.

## 4. What is String pool in Java and why we need String pool?

String pool stores the strings. All the strings with same characters refer to the same space.

But when we use new String("cat") to build a string, it still make a new space.

## 5. What is Java garbage collection?

Java garbage collection is the tool help us clear heap. It will scan the heap and mark, when it find the space which loses the reference, it will clear this space.

## 6. What are access modifiers and their scopes in Java?

public: can be accessed by all.
protected: can be accessed by the class in the same package and its subclasses.
default: can be accessed within the same package.
private: can only be accessed by its class.

## 7. What is final key word? (Filed, Method, Class)

Final is a restrict method. 

When we use final for variable, it can not change the value(primetive type) and reference(object). 
When we use final for method, it can not be overrided.
When we use final for class, it can not be extend.  

## 8. What is static keyword? (Filed, Method, Class). When do we usually use it?

Static means that this attribute or method is common for all object of a class.
The static method can only call the static method or attribute. 
The method can call the static or non-static method or attribute. 
we can call the static method or attribute by the class name.

We will use it for some methods as tools, also for Integer, String, Math, System etc.

## 9. What is the differences between overriding and overloading?

Overriding means the subclass cover the methods in the parent class.

Overloading is for methods with same name, we can use different parameters' number, type and sequence.

## 10. What is the differences between super and this?

super points to the immediate parent of the current class.
this points to the current class.

## 11. What is the Java load sequence?

1. Load the class into the Java Virtual Machine (JVM).
2. Verification, The JVM checks the loaded class file to ensure it adheres to the correct format and does not violate security constraints.
3. Preparation: Static variables are allocated memory and initialized with their default values.
4. Resolution, Symbols (references to other classes or methods) are resolved to concrete memory addresses.
5. Initialization, static variables are initialized with the values specified in the code, and the static initialization block (if present) is executed.

## 12. What is Polymorphism? And how Java implements it?

Polymorphism refers to the same object exhibiting different forms and behaviors.

Implements please refer to the CodingQuestions/coding1 codes.

## 13. What is Encapsulation ? How Java implements it? And why we need encapsulation?

Encapsulation package the attributes and behavior of an abstract thing into a class, and use access modifier to manage the access control. 

Implements please refer to the CodingQuestions/coding1 codes.

We use encapsulation for the data access control and make code united for better flexibility and maintenance.

## 14. What is Interface and what is abstract class? What are the differences between them?

Interface is a block which contains functions (these functions only can have function signature).

Abstract class is alos a block it can contain functions (these functions can only have function signature for complete implementation).

All of them can not new an object without implementing all the methods.

## 15. design a parking lot (put the code to codingQuestions/coding1 folder)
### 1. If you have no ability to design it, please find the solution in internet, then understand it, and re-type it.(Do NOT just copy and paste)

## 16. What are Queue interface implementations and what are the differences and when to use what?

The Queue has been implements for LinkedList, PriorityQueue, ArrayDeque, BlockingQueue

LinkedList is a simple implements for Queue FIFO.

PriorityQueue can be used when we want to sort the elements.

ArrayDeque can have two direction for both in and out operation.

BlockingQueue can be used when dealing with concurrent programming, it can provide a thread-safe queue;