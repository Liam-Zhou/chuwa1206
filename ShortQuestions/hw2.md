# HW2

1.  Write up Example code to demonstrate the three foundmental concepts of OOP. (reference Code Demo 
repo as example)
- **Encapsulation**;
  
  ```Java
    class Light {
        private boolean isOn = false;

        public void turnOn() {
            this.isOn = true;
        }

        public void turnOff() {
            this.isOn = false;
        }

        public Boolean getIsOn() {
            return this.isOn;
        }
    }

    public class Encapsulation {
        public static void main(String[] args) {
            Light light = new Light();
            light.turnOn(); //turn on light
            light.turnOff();
            System.out.println(light.getIsOn()); //print current status
        }
    }
  ```


- **Polymorphism**;
  ```Java
    class Light {
        private boolean isOn = false;

        private String color;

        public void turnOn() {
            this.isOn = true;
        }

        public void turnOff() {
            this.isOn = false;
        }

        public Boolean getIsOn() {
            return this.isOn;
        }

        public String getColor() {
            return color;
        }

        public void setColor(String color) {
            this.color = color;
        }
    }

    class TrafficLight extends Light {

        @Override
        public void setColor(String color) {
            if (color.equals("red") || color.equals("green") || color.equals("yellow")) {
                setColor(color);
            } else {
                System.out.println("color is not supported");
            }
        }
    }
  ```
  

- **Inheritance**; 
  ```Java
    class Light {
        private boolean isOn = false;

        public void turnOn() {
            this.isOn = true;
        }

        public void turnOff() {
            this.isOn = false;
        }

        public Boolean getIsOn() {
            return this.isOn;
        }
    }

    class TrafficLight extends Light {

        private String color;

        public String getColor() {
            return color;
        }
        public void setColor(String color) {
            this.color = color;
        }
    }
  ```
2.  What is wrapper class in Java and Why we need wrapper class? 
   > Wrapper class in Java are the conversion of primitive data type to objects. Because primitive types are not object, wrapper classes make the Java code completely object-oriented. 
    >
    > Conversion to object type provides additional feature to primitive types in sitations including:
        - Wrapper Class will convert primitive data types into objects. The objects are necessary if we wish to modify the arguments passed into the method (because primitive types are passed by value).
        - The classes in java.util package handles only objects and hence wrapper classes help in this case also.
        - Data structures in the Collection framework such as ArrayList and Vector store only the objects (reference types) and not the primitive types.
        - The object is needed to support synchronization in multithreading.

3.  What is the difference between HashMap and HashTable?
    | Feature      | HashMap | HashTable |
    | ----------- | ----------- | --------|
    | Synchronization | Not synchronized | synchronized |
    | Performance     | Generally faster | Slower |
    | Null values     | Allows one null key and multiple null values | Does not allow null keys or values |
    | Thread safety   | Not thread-safe | Thread-safe |
    | Flexibility     | Introduced in Java 1.2 | Deprecated since Java 1.2, use HashMap or ConcurrentHashMap instead |
    | Performance Overhead | Less overhead | More overhead due to synchronization |

4.  What is String pool in Java and why we need String pool? 
   > String pool is a specific chunk of memory in Java Heap storing string variables defined without the "new" keyword. When you create a string using double quotes (" "), Java looks into the string pool to check if an identical string already exists. If it does, the existing instance is returned, and if it doesn't, a new string is created and added to the pool. Strings in the string pool can be reused so as to save some memory space. And it allows easy comparison of strings using `==`, providing better performance than `equals()` method.
5.  What is Java garbage collection?
   > It is a process that Java will automatically recycle the memory when the allocated memory are no longer reachable or referenced by the program.
6.  What are access modifiers and their scopes in Java? 
    | Access modifiers | Scope |
    | ----------- | ----------- |
    | Default     | With in the package |
    | Public      | Everywhere |
    | Protected   | Within The package or all subclasses | 
    | Private     | Only the class itself |

7.  What is final key word? (Field, Method, Class)
   > - For field: it makes the variable a constant, which means memory address the variable refers to cannot be changed
   > - For method: methods defined with final cannot be override
   > - For class: final keyword prevents class from being subclassed and constraints the object intances to be immutable

8.  What is static keyword? (Field, Method, Class). When do we usually use it?
> - Static fields:  indicates that the variable is a class variable, shared by all instances of the class. There is only one copy of the static variable, regardless of how many instances of the class are created.
> - Static methods: methods can be called without object instances
> - Static classes: `static` keyword is not directly applicable to top-level classes. However, it can be applied to nested classes. A static nested class is a static member of its enclosing class and can be instantiated without creating an instance of the outer class.

Example
 ``` Java
    public class OuterClass {
        static class StaticNestedClass {
            // Static nested class members
        }
    }
```

9.  What is the differences between overriding and overloading?
   > Overloading handles in compile time, it allows a class having functions with the same name and different argument list. Override handles in run time, allowing child classes to have the functions with the same name and augument list so that an object instance can behave differently.
10.   What is the differences between super and this?
   > Super points to the parent class while this points to the object itself.

11.   What is the Java load sequence?
   > 1. `Loading`: Load the class bytecode into memory
   > 2. `Linking`:
        - `Verification`: Ensure the bytecode adheres to language and security rules.
        - `Preparation`: Allocate memory for static fields and initialize them.
        - `Resolution`: Replace symbolic references with direct references.
   > 3. `Initialization`: Execute static initialization blocks and initialize static variables.
12.   What is Polymorphism ? And how Java implements it ? 
   > Polymorphism as an OOP concept, describes the ability of something to have or to be displayed in more than one form.
   Java implements polymorphism through static polymprphism (method overloading) that  allows methods to be defined with the same name in different classes and dynamic polymorphism (method overriding) that allows a subclass to provide a specific implementation for a method already defined in its superclass.
   >
   > The key mechanisms are:
   >
   > Method Overloading: The Java compiler differentiates between overloaded methods based on the number and types of their parameters. During compile-time, the correct method to be called is determined based on the method signature.
   >
   > Method Overriding: The JVM determines which overridden method to call at runtime based on the actual type of the object that the reference variable points to. This is achieved through dynamic method dispatch.

13.   What is Encapsulation ? How Java implements it? And why we need encapsulation? 
   > Encapsulation is a method of binding data and methods to manipulate data within the unit. In Java, encapsulation is implemented using access modifiers and getter and setter methods. The access modifiers (private, protected, default, and public) control the visibility of fields and methods in a class.Data can only be manipulated by the given methods and is not directly accessible which enhances the data safety. It also abstract the internal implementations of an object, providing a simplified and understandable interface to the rest of the program.
14.   What is Interface and what is abstract class? What are the differences between them?
   > `Abstract class` is a class that cannot be instantiated on its own and may contain abstract methods (methods without a body) as well as concrete methods. 
   >
   > `Interface` is a collection of abstract methods (methods without a body) and constant declarations. It provides a way to achieve abstraction by defining a contract that implementing classes must adhere to.
   >
   > **Differences between Interface and Abstract Class:**
   >
   > **Instantiation**:
   >
   > `Interface`: Cannot be instantiated. It  defines a contract for classes to implement.
    `Abstract Class`: Cannot be instantiated on its own. It is meant to be subclassed. 
   >
   > **Multiple Inheritance:**
   >
   > `Interface`: Supports multiple inheritance. A class can implement multiple interfaces.
   ` Abstract Class`: Supports single inheritance. A class can extend only one abstract class.
   >
   > **Constructors:**
   > 
   > `Interface`: Cannot have instance variables or constructors.
   > `Abstract Class`: Can have instance variables, constructors, and other methods.
   >
   >  **Accessibility:**
   > `Interface`: Members are implicitly public, static, and final. Methods are implicitly public and abstract.
   `Abstract Class`: Members can have various access modifiers. Methods can be abstract or concrete.
   > 
   > Default Methods:
   > `Interface`: Can have default methods (with a body) since Java 8.
   > `Abstract Class`: Cannot have default methods.
   >
   > Fields:
   `Interface`: Can only have public static final fields.
   `Abstract Class`: Can have various types of fields, including instance variables.
   >
   > Use Cases:
  `Interface`: Used when you want to provide a contract for multiple unrelated classes to implement. Used for achieving full abstraction.
  `Abstract Class`: Used when you want to provide a common base class with some shared implementation. Used for achieving partial abstraction.
14.    Design a parking lot
    [Check this](../CodingQuestions/coding1/src/main/java/org/example/)

15.   What are Queue interface implementations and what are the differences and when to use that?
   > 1.  **LinkedList**:
   > Use case: LinkedList can be used as a queue by using the offer, poll, and peek methods. Use it when you need a simple and efficient queue without specific ordering requirements. While LinkedList can be used as a queue, it can also function as a list and a deque, offering versatility.
   > 2. **PriorityQueue**:
    Use case: when elements need to be processed based on their priority.
    Elements are ordered based on their natural ordering or the ordering imposed by a comparator. The head of the queue is the least element.
    > 3. **ArrayDeque**:
      Use case: ArrayDeque is a resizable array-based implementation that can be used as a queue or a stack. It provides better performance than LinkedList in certain scenarios due to its array-based structure.
    > 4. **BlockingQueue Implementations (e.g., LinkedBlockingQueue)**:
      Use case: These queues are designed for use in concurrent programming, providing thread-safe operations.
      </blockquote>