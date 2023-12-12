# 1. WriteupExamplecodetodemonstratethethreefoundmentalconceptsofOOP.(referenceCodeDemo repo as an example)1.Encapsulation; 2. Polymorphism; 3. Inheritance;

See in the code questions folder

# 2. What is a wrapper class in Java and Why do we need a wrapper class?

A wrapper class is an Object class for all the primitive data types, such as int, long, double, etc. We need wrapper classes because it allow us to use the Collection interface and Generics, such as List<Integer>, Map<Chracter, Integer> etc; it also enhances the functionality of all the primitive data types, for example, Integer.valueof(x), Character.isDigit(), etc. Also, it provides a unified interface for working with both primitives and objects, which makes code more consistent modular and object-oriented.

# 3. What is the difference between HashMap and HashTable?

The differences are:

1. HashTable is thread-safe, HashMap is not.
2. HashMap allows both null keys and values, hashtable doesn't.
3. HashMap is faster.

# 4. What is Stringpool in Java and why do we need Stringpool?

The string pool is a memory location on the Heap, where frequently used strings are stored.

We need it because it optimizes memory usage and improves string comparison performance.

# 5. What is Java garbage collection?

The garbage collection is an automatic memory management process that reclaims unused or unreachable memory allocated to objects during program execution. it frees up resources and prevents memory leaks.

# 6. What are access modifiers and their scopes in Java?

Public: accessible from anywhere in your program, including different packages.

Private: Accessible only within the class itself.

Protected: Accessible within the class itself, its subclasses, and within the same package.

Default: Accessible within the same package.

# 7. What is the final keyword? (Filed, Method, Class)

The Final field means that a field can not be reassigned a new value after its initial assignment.

The final method means that a method can not be overridden in subclasses.

The final class means that a class can not be extended.

# 8. What is the static keyword? (Filed, Method, Class). When do we usually use it?

The static field means that a field belongs to the class itself, not to any specific instance of the class. it has a single shared value that all instances of the class access, the static method is similar.

A static class is not a standalone class but is nested within another class and cannot be directly instantiated.

# 9. What are the differences between overriding and overloading?

the differences are:

1. overloading occurs within classes, and overriding occurs in subclasses.

2. overloading can have different return types and parameters, but overriding should have the exact same return type and parameters.

3. overloading is Compile-time binding, but overriding is run-time binding.

# 10. What are the differences between super and this?

Super refers to the superclass, but this refers to the current object.

# 11. What is the Java load sequence?

It's a process by which the JVM locates, loads, and prepares classes for execution. it involves several steps and is governed by a hierarchy of class loaders.

1. class loading
2. linking
3. initialization

# 12. What is polymorphism? And how does Java implement it?

It means one action can have different forms, java implements it with overloading and overriding.

# 13. What is Encapsulation? How does Java implement it? And why do we need encapsulation?

Encapsulation = Abstract + Data Hiding, java implements it by using a class to wrap data and methods in a secure package. We need it because it can provide some benefits: Data protection, code maintainability, modular design, and information hiding.

# 14. What is Interface and what is abstract class? What are the differences between them?

The interface is a blueprint for a set of behaviors that a group of classes must implement.

The abstract class is more like a base class for a group of subclasses that share a lot of common fields and methods.

the difference between them is:

1. The Abstract class can have a constructor, interface doesn't
2. The Abstract class can have different access modifier for fields, interface only has public static final.

3. The Abstract class can be directly inherited by only one class, interface can be implemented by multiple classes even unrelated ones.

# 15. design a parking lot (put the code to the codingQuestions/coding1 folder, )

1.  Ifyouhavenoabilitytodesignit, please find the solution on the internet, then understand it, and re-type it. (Do NOT just copy and paste)

see the coding questions folder.

# 16. What are Queue interface implementations and what are the differences and when to use what?

There are some: LinkedList, ArrayDeque, PriortyQueue, Deque. We need to consider the following to decide when to use what: 1. excepted queue size and access patterns, 2. thread safety needs, 3. performance requirements, 4. natural order or custom order needs.

if the order is needed, PirorityQueue is the best, since you can define the custom ordering rule or use its natural order.

if you want thread-safe, ArrayDeque is the one.

if you have frequent element insertion and removal from both ends, LinkedList is the best.
