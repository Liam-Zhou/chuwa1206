## 1. three fundamental concepts of OOP
##### 1) Encapsulation
    `public class Encapsulation {
        private int data;
    
        public int getData() { 
            return data;
        }
    
        public void setData(int data) { 
            this.data = data;
        }
    }`

##### 2) Polymorphism
    `class Animal {
            void sound() {
                System.out.println("Animal makes a sound");
            }
        }
        
        class Dog extends Animal {
        @Override
            void sound() {
                System.out.println("Dog barks");
            }
        }`

##### 3) Inheritance
    class Animal {
        void eat() {
            System.out.println("Animal eats");
        }
    }
        
    class Dog extends Animal {
        void bark() {
            System.out.println("Dog barks");
        }
    }

## 2. Wrapper Class in Java
Wrapper classes provide a way to use primitive data types (int, char, etc.) as objects. The need for wrapper classes arises because primitives are not objects and Java is an object-oriented language. For example, Integer is the wrapper class for the primitive int. They are used in collections like ArrayList where primitives cannot be used directly.

## 3. HashMap vs HashTable
1. HashMap: Not synchronized, allows one null key and multiple null values, generally faster.
2. HashTable: Synchronized, doesn’t allow null keys or values, slower due to thread safety.

## 4. String Pool in Java
The String Pool is a special memory region where Java stores string literals. It helps in saving memory space by avoiding duplicate string objects. When a new string is created, Java checks the pool first; if the string already exists, it returns a reference to the existing string instead of creating a new one.

## 5. Java Garbage Collection
Garbage Collection in Java is the process by which the JVM automatically removes objects that are no longer being used or referenced, freeing up memory space.

## 6. Access Modifiers in Java
* private: Accessible only within the declared class.
* default (no modifier): Accessible within the same package.
* protected: Accessible within the same package and subclasses.
* public: Accessible from any class.

## 7. Final Keyword
* Final Field: Cannot be changed once initialized.
* Final Method: Cannot be overridden by subclasses.
* Final Class: Cannot be subclassed.

## 8. Static Keyword
* Static Field: Belongs to the class, not instances of the class.
* Static Method: Can be invoked without creating an instance of the class.
* Static Class: Nested static class.
  * Usage: Often used for constants, utility functions, or singleton design patterns.

## 9. Overriding vs Overloading
* Overriding: Redefining a method in a subclass with the same signature as in the parent class.
* Overloading: Creating multiple methods in the same class with the same name but different parameters.

## 10. Super vs This
* super: Refers to the immediate parent class object.
* this: Refers to the current class object instance.

## 11. Java Load Sequence
* Static blocks and static variables initialization.
* Instance variable initialization and instance blocks.
* Constructor execution.

## 12. Polymorphism
Polymorphism allows objects to be treated as instances of their parent class rather than their actual class. Methods can be overridden to provide specific functionality.  We implement multiple interfaces in a class to realize Polymorphism.

## 13. Inheritance
Inheritance is a mechanism where a new class inherits properties and methods of another class.

## 14. Interface vs Abstract Class
* Interface: A contract for classes to implement. All methods are abstract. Classes can implement multiple interfaces.
* Abstract Class: A class that cannot be instantiated and may contain abstract methods. Classes can extend only one abstract class.

## 16. Queue Interface implementations and when to use what
* LinkedList: Frequent Insertions and Deletions, Less Memory Concerns, List and Queue Operations Together
* PriorityQueue: Ordering Elements by Priority, Heap Operations, 
* ArrayDeque: Stack (LIFO) or Queue (FIFO) Implementation, Add/Remove Operations at Both Ends
