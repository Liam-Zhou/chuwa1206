### Question 1
Encapsulation is about bundling the data and methods that operate on the data into a single unit or class.
Example:
```
public class EncapsulatedObject {
    private int data;

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }
}
```

Polymorphism allows objects of different classes to be treated as objects of a common super class.
Example：
```
class Animal {
    public void sound() {
        System.out.println("Animal makes a sound");
    }
}

class Dog extends Animal {
    public void sound() {
        System.out.println("Dog barks");
    }
}
```

Inheritance allows a new class to inherit properties and methods of an existing class.
Example：
```
class Animal {
    void eat() {
        System.out.println("Eating...");
    }
}

class Dog extends Animal {
    void bark() {
        System.out.println("Barking...");
    }
}
```

### Question 2
Wrapper classes in Java are used to convert primitive types into objects. The reason we need wrapper classes is because primitives are not objects and Java is an object-oriented language. For example, int is a primitive type and Integer is its corresponding wrapper class.

### Question 3
HashMap is not thread-safe, while HashTable is thread-safe.
HashMap is generally faster than HashTable due to the latter's thread-safety overhead.
HashMap allows one null key and multiple null values, whereas HashTable doesn't allow any null key or value.

### Question 4
The String Pool in Java is a special memory region where Strings are stored. Java uses the String Pool to store all literal strings. This means that if a string has already been created, any attempt to create the same string again will not allocate additional memory; instead, the new reference will point to the already existing string

### Question 5
Java Garbage Collection is the process by which Java programs perform automatic memory management. The garbage collector finds and deletes objects that are no longer in use by a program to free up memory resources.

### Question 6
1. private: Accessible only within the declared class.
2. default (no modifier): Accessible within the same package.
3. protected: Accessible within the same package and subclasses.
4. public: Accessible from any class.

### Question 7
1. Final Variable: Cannot be changed once initialized.
2. Final Method: Cannot be overridden by subclasses.
3. Final Class: Cannot be extended.

### Question 8
1. Static Variable: Belongs to the class, not to object instances.
2. Static Method: Can be called without creating an instance of the class.
3. Static Class: Nested static class. It does not have access to instance variables/methods of the outer class.

Static is typically used for methods and variables that are common to all objects of the class.

### Question 9
Overriding is redefining a method in a subclass that already exists in the parent class.
Overloading is creating multiple methods in the same class, with the same name but different parameters.

### Question 10
super refers to the parent class. Used to call methods of the parent class.
this refers to the current object. Used to call methods of the current class or to pass the current object as a parameter.

### Question 11
Loading: The class is loaded by the classloader.
Linking: Verifies, prepares, and optionally resolves the class.
Initialization: Executes static initializers and static initialization blocks.

### Question 12
Polymorphism allows objects of different classes to be treated as objects of a common super class.

### Question 13
Encapsulation is about bundling the data and methods that operate on the data into a single unit or class. We can use modifier to achieve encapsulation. We need it to protect data integrity.

### Question 14
Interface is used to define a contract with only abstract methods. A class can implement multiple interfaces. Abstract class can have a mix of methods with and without implementation. A class can extend only one abstract class. Abstract classes can have constructors, interfaces cannot. Interfaces are good for defining a contract, while abstract classes are good for sharing common code.

### Question 15
In codingQuestion/hw2 folder


### Question 16
1. LinkedList, implemented by doubly-linked list. It is used for applications that require both stack and queue operations, and when frequent insertion and deletion operations are involved.
2. PriorityQueue is implemented by priority heap. Elements are ordered. Useful when objects are supposed to be processed based on their priority. It does not permit null elements.
3. ConcurrentLinkedQueue is implemented by concurrent, unbounded queue based on linked nodes. It is suitable for highly concurrent environments where throughput is more important