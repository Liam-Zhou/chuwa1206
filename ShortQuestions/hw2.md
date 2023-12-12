### 1. code in CodingQuestions/coding1
### 2. wrapper class
The wrapper classes provides the mechanism to convert primitive into object and object into primitive.
Creating a wrapper class can automatically creates a new field where the primitive data types are stored.
### 3. hashmap vs hashtable
HashMap is non-synchronized, which is not thread-safe while Hashtable is synchronized.
### 4. String pool
String pool is a storage space in Java Heap memory to store the string literals.
String pool allows the string constants to be reused and can reduce the memory usage.
### 5. Java garbage collection
Java garbage collection is the automated process of deleting code that is no longer needed, which will automatically frees up memory space.
### 6. access modifiers
Access modifiers are used to set the accessibility of classes, constructors, methods and other members of Java.
It defines the scope and visibility of classes, methods, fields and constructors within a program.

- public: allows full access from other classes
- protected: allows access in the same package and subclasses
- private: allows access from the same class
- default: allows access from the same class 
### 7. final
Final keyword is a non-access modifier used for classes, attributes and methods, makes them non-changeable and impossible to inherit and override.
### 8. static
The static keyword is used to declare variables and methods in a class that can be accessed without creating an instance of the class. The variables or methods are shared among all the objects in the class.

The static keyword helps in efficient memory management. 
### 9. override vs overload
When the method signature is the same in a superclass and the child class, we use override. When the two methods in the same class have same name but different parameters, we use overload.

Overload happens at compile time while override happens at runtime.
### 10. super vs this
- super: refers to the immediate parent class object
- this: refers to the current class object.
### 11. load sequence
The JVM load sequence start from the static variables and blocks, then to the constructors.
### 12. Polymorphism
Polymorphism occurs when many classes are related and we need to use the inherited properties to perform different tasks.
There are two implementations in Java:
- override: during runtime
- overload: during compile time
### 13. Encapsulation
Encapsulation refers to integrating data and code into a single unit.

Java implements it by using the access modifiers with classes, methods and variables.

Encapsulation can help with data hiding and keep related fields and methods together, which makes the code clear.
### 14. abstract vs interface
- abstract class: contains an abstract keyword on the declaration. A class can extend only one abstract class.
- interface: is a sketch used to implement a class. An interface can not have the fully implemented methods. A class can implement multiple interfaces.
### 15. code in codingQuestions/coding1
### 16. implementation of the queue interface
- PriorityQueue: A queue follows the FIFO rule.
- LinkedList: A linear structure where the elements are linked using pointers and addresses.
- PriorityBlockingQueue: the thread-safe alternative implementation for the PriorityQueue and LinkedList.