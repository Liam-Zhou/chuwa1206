## 2. What is wrapper class in Java and Why we need wrapper class?

Wrapper classes provide a way to use primitive data types (int, boolean, etc..) as objects.

Having wrapper classes can allow us to perform operations on primatives more easily. They are also necessary when we are working with generics in a Collection, such as a List.

## 3. What is the difference between HashMap and HashTable?

- HashMap is non-synchronized. It is not thread-safe and can’t be shared between many threads without proper synchronization code whereas Hashtable is synchronized. It is thread-safe and can be shared with many threads.
- HashMap allows one null key and multiple null values whereas Hashtable doesn’t allow any null key or value.
- HashMap is generally preferred over HashTable if thread synchronization is not needed.

## 4. What is String pool in Java and why we need String pool?

String pool is a storage area in Java heap where string literals stores. By default, it is empty and privately maintained by the Java String class.

It is created to decrease the number of string objects created in the memory. Whenever a new string is created, JVM first checks the string pool. If it encounters the same string, then instead of creating a new string, it returns a reference existing string to the variable.

## 5. What is Java garbage collection?

Garbage collection in Java is the automated process of deleting code that's no longer needed or used.

## 6. What are access modifiers and their scopes in Java?

Access modifiers are object-oriented programming that is used to set the accessibility of classes, constructors, methods, and other members of Java.

The modifiers are:

- **Private**: We can access the private modifier only within the same class and not from outside the class.
- **Default**: We can access the default modifier only within the same package and not from outside the package. And also, if we do not specify any access modifier it will automatically consider it as default.
- **Protected**: We can access the protected modifier within the same package and also from outside the package with the help of the child class. If we do not make the child class, we cannot access it from outside the package. So inheritance is a must for accessing it from outside the package.
- **Public**: We can access the public modifier from anywhere. We can access public modifiers from within the class as well as from outside the class and also within the package and outside the package.

## 7. What is final key word? (Filed, Method, Class)

The final keyword is a non-access modifier used for classes, attributes and methods, which makes them non-changeable (impossible to inherit or override).

## 8. What is static keyword? (Filed, Method, Class). When do we usually use it?

In Java, static keyword is mainly used for memory management. It can be used with variables, methods, blocks and nested classes. It is a keyword which is used to share the same variable or method of a given class.

We would use it for a constant variable or a method that is same for every instance of a class.

## 9. What is the differences between overriding and overloading?

Overriding occurs when the method signature is the same in the superclass and the child class. Overloading occurs when two or more methods in the same class have the same name but different parameters.

## 10. What is the differences between super and this?

Super points to the parent class object and this points to the current class object.

## 11. What is the Java load sequence?

- Static blocks and static variables initialization.
- Instance variable initialization and instance blocks.
- Constructor execution.

## 12. What is Polymorphism ? And how Java implements it ?

Polymorphism means "many forms", and it occurs when we have many classes that are related to each other by inheritance.

Inheritance lets us inherit attributes and methods from another class. Polymorphism uses those methods to perform different tasks.

## 13. What is Encapsulation ? How Java implements it? And why we need encapsulation?

Encapsulation is a way of hiding the implementation details of a class from outside access and only exposing a public interface that can be used to interact with the class.

In Java, encapsulation is achieved by declaring the instance variables of a class as private, which means they can only be accessed within the class. To allow outside access to the instance variables, public methods called getters and setters are defined, which are used to retrieve and modify the values of the instance variables.

Advantages of encapsulation include:

- **Data Hiding**: it is a way of restricting the access of our data members by hiding the implementation details. Encapsulation also provides a way for data hiding. The user will have no idea about the inner implementation of the class. It will not be visible to the user how the class is storing values in the variables. The user will only know that we are passing the values to a setter method and variables are getting initialized with that value.
- **Increased Flexibility**: We can make the variables of the class read-only or write-only depending on our requirements.
- **Reusability**: Encapsulation also improves the re-usability and is easy to change with new requirements.
- **Testing code is easy**: Encapsulated code is easy to test for unit testing.
- **Freedom to programmer in implementing the details of the system**: This is one of the major advantage of encapsulation that it gives the programmer freedom in implementing the details of a system. The only constraint on the programmer is to maintain the abstract interface that outsiders see.

## 14. What is Interface and what is abstract class? What are the differences between them?

### Interface

An interface is a sketch that is useful to implement a class. The methods used in the interface are all abstract methods. The interface does not have any concrete method.

### Abstract class

A class that contains an abstract keyword on the declaration is known as an abstract class. It is necessary for an abstract class to have at least one abstract method. It is possible in an abstract class to contain multiple concrete methods

| Abstract Class                                                                          | Interface                                                   |
| --------------------------------------------------------------------------------------- | ----------------------------------------------------------- |
| An abstract class can contain both abstract and non-abstract methods.                   | Interface contains only abstract methods.                   |
| An abstract class can have all four; static, non-static and final, non-final variables. | Only final and static variables are used.                   |
| To declare abstract class abstract keywords are used.                                   | The interface can be declared with the interface keyword.   |
| It supports multiple inheritance.                                                       | It does not support multiple inheritance.                   |
| The keyword 'extend' is used to extend an abstract class.                               | The keyword 'implement' is used to implement the interface. |
| It has class members like private and protected, etc.                                   | It has class members public by default.                     |

## 16. What are Queue interface implementations and what are the differences and when to use what?

LinkedList and PriorityQueue are the most common implementations of Queue interface.

| PriorityQueue                                                  | LinkedList                                                        |
| -------------------------------------------------------------- | ----------------------------------------------------------------- |
| Automatically orders elements according to their priority.     | Maintains the insertion order, and does not sort elements.        |
| Does not allow null elements.                                  | Allows null elements.                                             |
| Provides O(log n) time for enqueuing and dequeuing operations. | Provides constant time for add and remove operations at the ends. |
