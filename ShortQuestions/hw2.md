# HW2

## 1. Write up Example code to demonstrate the three foundmental concepts of OOP. 

- Encapsulation

```java
public class Student {
  private String id;
	private String name;
  
  public Student(String id, String name) {
		this.id = id;
    this.name = name;
  }
  
  public void setId(String id) {
    this.id = id;
  }
  
  public String getId() {
    return this.id;
  } 

	public void setName(String name) {
		thie.name = name;
	}
	
	public String getName() {
		return this.name;
	}
}
```

- Inheritance

```java
class Vehicle {

}

class Car extends Vehicle {

}

class Truck extends Vehicle {

}
```

- Polymorphism

```java
class Vehicle {
  public void run() {
    System.out.prinrln("Vehicle run.");
  }
}

class Car extends Vehicle {
  @Override
  public void run() {
    System.out.prinrln("Car run.");
  }  
}

class Truck extends Vehicle {
  @Override
  public void run() {
    System.out.prinrln("Truck run.");
  }  
}
```

## 2. What is a Wrapper Class in Java?

A wrapper class in Java provides a way to use primitive data types (like int, char, double) as objects. The table below shows the primitive type and its corresponding wrapper class:

| Primitive Type | Wrapper Class |
| -------------- | ------------- |
| byte           | Byte          |
| short          | Short         |
| int            | Integer       |
| long           | Long          |
| float          | Float         |
| double         | Double        |
| char           | Character     |
| boolean        | Boolean       |

### Why do we need wrapper classed?

1. **Object Requirement**: Some frameworks and data structures in Java, like collections in Java's Collection Framework (e.g., **`ArrayList`**, **`HashMap`**), only work with objects and do not accept primitive types. Wrapper classes enable the use of primitive types in these contexts.
2. **Utility Methods**: Wrapper classes provide a variety of utility methods that can be very useful. For example, **`Integer`** class has methods like **`parseInt`**, **`compare`**, and others that are frequently used.
3. **Null Value Support**: Primitive types can't be null, but their wrapper classes can hold null. This can be useful in scenarios where one needs to represent the absence of a value or the state is unknown.
4. **Type Conversions**: Wrapper classes offer methods to easily convert between different types, both to and from strings and other primitive types.
5. **Generic Types**: Java generics work only with Object types, not primitive types. Wrapper classes allow the use of primitive types with generics.

### AutoBoxing and Unboxing

- **Autoboxing**: The automatic conversion that the Java compiler makes between the primitive types and their corresponding object wrapper classes. For example, converting an **`int`** to an **`Integer`**.
- **Unboxing**: The reverse process of autoboxing. It is the automatic conversion of wrapper classes to their corresponding primitive types.

``` 
// Autoboxing - the compiler automatically converts primitive to Integer object
Integer i = 10;

// Unboxing - the compiler automatically converts Integer object to primitive
int j = i;
```

## 3. What is the difference between HashMap and HashTable?

### **1. Synchronization and Thread Safety**

- **HashTable**: It is synchronized, which means it is thread-safe. 
- **HashMap**: It is not synchronized and not thread-safe by default. 

### **2. Performance**

- Due to its non-synchronized nature, **`HashMap`** is usually faster and uses less memory than **`HashTable`**. **`HashTable`**'s synchronization feature adds overhead that slows down its performance.

### **3. Null Keys and Null Values**

- **HashTable**: Does not allow null keys or null values. Any attempt to store a null key or null value will result in a **`NullPointerException`**.
- **HashMap**: Allows one null key and multiple null values. This flexibility can be beneficial in applications where null has a specific meaning.

### **4. Initial capacity size and expansion size**

- If the capacity is not specified at creation time, Hashtable defaults to an initial size of 11 and then expands to 2n+1 times its original size with each expansion. HashMap defaults to an initial size of 16 and doubles its capacity with each expansion.
- If a capacity is specified at creation, Hashtable will use the size you provided, whereas HashMap will expand it to the nearest power of 2 (ensured by the `tableSizeFor()` method in HashMap, source code provided below). This means HashMap always uses powers of 2 as the hash table size, and later it will be explained why it is a power of 2.

### **5. Underlying Data Structure**

- After JDK 1.8, there have been significant changes in HashMap for resolving hash collisions. When the length of a linked list exceeds the threshold (default is 8), it converts the linked list into a red-black tree (before converting to a red-black tree, it checks if the current array size is less than 64; if so, it opts for array expansion rather than conversion to a red-black tree), to reduce search time. This process will be analyzed in detail with source code later in the article. Hashtable does not have such a mechanism.

## 4. What is String pool in Java and why we need String pool?

- **String Literal Storage**: The String Pool is used to store string literals that are explicitly defined in the code. For example, when you create a string using double quotes (**`String s = "Hello"`**), it's stored in the String Pool.

- **String Interning**: String interning is a method of storing only one copy of each distinct string value, which must be immutable. When a string is created, the JVM checks the pool first. If the string already exists in the pool, a reference to the pooled instance is returned. If the string doesn't exist, a new string instance is created and placed in the pool.

```java
String s1 = "Hello"; // String literal, uses String Pool
String s2 = "Hello"; // Reuses the string from String Pool
String s3 = new String("Hello"); // Creates a new string object in heap

System.out.println(s1 == s2); // true, as both refer to the same string in the pool
System.out.println(s1 == s3); // false, as s3 is a new object in the heap
```

- **Memory Efficiency**: Without the String Pool, every string literal would result in a new object in the heap, even if the same string already exists. This could lead to a significant waste of memory. The String Pool helps in reusing the immutable strings.

- **Performance Optimization**: By reusing existing strings from the pool, the JVM reduces the load on the garbage collector and decreases heap memory usage. This can lead to performance improvements, especially in applications that use many string literals.

- **String Comparison Efficiency**: String interning allows for faster string comparison using **`==`**, as it compares memory addresses. If two string variables point to the same string in the pool, **`==`** will return **`true`**.

## 5. What is Java garbage collection?

Java garbage collection is a process by which the Java runtime environment (JRE) reclaims memory occupied by objects that are no longer in use. This is an essential aspect of Java's memory management system, helping to ensure efficient use of memory and preventing memory leaks.

## 6.  What are access modifiers and their scopes in Java?

1. **Public:** The `public` keyword is used to declare a class, method, or variable that can be accessed from any other class or method in any other package. It provides the widest scope of accessibility.
2. **Protected:** The `protected` keyword is used to declare a class, method, or variable that is accessible within its own package and by subclasses in other packages. It offers a more restricted level of accessibility compared to `public`, yet it is more accessible than the default access level.
3. **Private:** The `private` keyword is used to declare a class, method, or variable that is accessible only within the class it is declared in. It is the most restrictive access level and is used to encapsulate the internal workings of a class, hiding them from other classes and methods.

## 7.  What is final key word? (Filed, Method, Class)

1. **Final Field:** When a field is declared as `final`, it means that once it is initialized, its value cannot be altered. This makes the field effectively a constant. For primitive types, the value is immutable, and for object references, it means the reference cannot be changed to point to another object, though the object itself can still be mutable.

   ```java
   final int MAX_VALUE = 10;
   ```

2. **Final Method:** A final method cannot be overridden by subclasses. This is useful when you want to prevent a method from being modified in any subclass, often for reasons of security, simplicity, or performance.

   ```Java
   public final void display() {
       System.out.println("This is a final method.");
   }
   ```

3. **Final Class:** A final class cannot be subclassed. This is particularly useful when creating an immutable class like the `String` class in Java or when you want to ensure that your class is not extended for security reasons.

   ```Java
   public final class MyFinalClass {
   
   }
   ```

## 8. What is static keyword? (Filed, Method, Class). When do we usually use it?

1. **Static Field (Variable):**

   - **Definition:** A static field belongs to the class rather than any instance of the class (object). It is shared among all instances of the class.

   - **Usage:** Commonly used for constants or variables that should be shared across all instances.

     ```java
     class MyClass {
         static int staticVar = 10;
     }
     ```

2. **Static Method:**

   - **Definition:** A static method belongs to the class rather than any instance of the class. It can be called without creating an instance of the class.

   - **Usage:** Typically used for utility or helper methods that don't require any object state. Since they can't access instance variables, they are often used in singleton patterns or as part of utility classes like `Math` or `Collections`.

     ```java
     class MyClass {
         static void staticMethod() {
             System.out.println("This is a static method.");
         }
     }
     ```

3. **Static Class:**

   - **Definition:** In Java, you cannot declare a top-level class as static, but nested classes can be static. A static nested class is associated with its outer class, and like static methods and fields, doesn't require an instance of the outer class to be created.

   - **Usage:** Often used for utility or helper classes that are logically grouped within a larger class but do not require access to the instance variables of the outer class.

     ```Java
     class OuterClass {
         static class StaticNestedClass {
             void method() {
                 System.out.println("Method of static nested class.");
             }
         }
     }
     ```

**Common Use Cases for `static`:**

- **Constants:** Static final fields are used to define constants.
- **Utility Methods:** Methods that perform general-purpose tasks and do not require object state.
- **Singleton Pattern:** The `static` keyword is used to ensure that only one instance of a class is created.
- **Shared Resources:** Static fields can be used to share common resources (like configuration settings) across all instances of the class.

## 9. What is the differences between overriding and overloading?

1. **Method Overriding:** A subclass redefines a method from its superclass with the same signature.

   ```java
   class Animal {
       void sound() {
           System.out.println("Generic sound");
       }
   }
   
   class Dog extends Animal {
       @Override
       void sound() {
           System.out.println("Bark");
       }
   }
   ```

2. **Method Overloading:** A class has multiple methods with the same name but different parameters.

   ```java
   class MathOperation {
       int multiply(int a, int b) {
           return a * b;
       }
   
       double multiply(double a, double b) {
           return a * b;
       }
   }
   ```

## 10. What is the differences between super and this?

1. **`this` Keyword:**

   - **Purpose:** Refers to the current instance of the class.

   - Usage:

     - To refer to instance variables of the current class when local variables (parameters) have the same name.
     - To invoke a constructor from another overloaded constructor in the same class.

     ```java
     public class MyClass {
         int var;
     
         MyClass(int var) {
             this.var = var; // Refers to the instance variable 'var'
         }
     
         void myMethod() {
             System.out.println(this.var); // Refers to the current class's 'var' variable
         }
     }
     ```

2. **`super` Keyword:**

   - **Purpose:** Refers to the superclass (parent class) of the current instance.

   - Usage:

     - To refer to instance variables of the superclass when subclass variables hide them.
     - To invoke a method of the superclass that has been overridden.
     - To call a constructor of the superclass from the subclass.

     ```java
     class ParentClass {
         int var = 10;
     }
     
     class ChildClass extends ParentClass {
         int var = 20;
     
         void display() {
             System.out.println(super.var); // Refers to 'var' from ParentClass
         }
     }
     ```

## 11. What is the Java load sequence?

The Java load sequence refers to the order in which Java components are loaded and initialized when a Java application is run. This sequence is important for understanding how Java programs start and execute.

1. **Loading Classes:**
   - When the Java Virtual Machine (JVM) starts, it begins by loading the main class (the class with the `public static void main(String[] args)` method) using the class loader.
   - If this class has any static references to other classes, those classes are also loaded.
2. **Linking:**
   - **Verification:** The bytecode of the loaded classes is verified for security and integrity.
   - **Preparation:** JVM allocates memory for class variables and initializes them to default values.
   - **Resolution:** All symbolic memory references are converted into direct references.
3. **Initialization:**
   - Static fields are initialized to their default values, and then any static initializers (static blocks) are executed.
   - This is done in the order of appearance within the class.
4. **Instantiation of the Main Class (if necessary):**
   - If the main method uses any instances of the main class, the JVM creates these instances.
   - Constructors are called and instance variables are initialized.
5. **Execution of the `main` Method:**
   - The `main` method is executed. This method is the entry point of any standalone Java application.
   - Any further class loading and linking occurs as needed when new classes are referenced during the execution of the program.
6. **Runtime Execution:**
   - As the program runs, classes that haven't been loaded yet are loaded upon their first use.
   - The execution continues, following the program's logic, until it terminates (either normally or due to an unhandled exception).
7. **Unloading of Classes:**
   - Unloading of classes generally only happens when a JVM stops, or if a class loader is garbage collected. In most normal program runs, classes are not unloaded.

## 12. What is Polymorphism ? And how Java implements it ?

Polymorphism refers to the same object exhibiting different forms and behaviors

```Java
class Vehicle {
  public void run() {
    System.out.prinrln("Vehicle run.");
  }
}

class Car extends Vehicle {
  @Override
  public void run() {
    System.out.prinrln("Car run.");
  }  
}

class Truck extends Vehicle {
  @Override
  public void run() {
    System.out.prinrln("Truck run.");
  }  
}
```

### 13. What is Encapsulation ? How Java implements it? And why we need encapsulation?

Encapsulation is achieved by using private variables (or fields) and public methods to access these fields.

Encapsulation in OOP refers to binding the data and the methods to manipulate that data together in a single unit (class)

Getter/Setter (methods)

```java
public class Student {
	private String name;

	public void setName(String name) {
		thie.name = name;
	}
	
	public String getName() {
		return this.name;
	}
}
```

## 14. What is Interface and what is abstract class? What are the differences between them?

1. **Interface:**

   - An interface is a completely abstract class. It can have only abstract methods (until Java 8, after which it can also have default and static methods).

   - Interfaces are used to define a contract or a behavior that implementing classes must follow.

   - A class can implement multiple interfaces, enabling multiple inheritance of type.

   - Interfaces do not have constructors and cannot store state (they cannot have instance fields, but they can have static final fields which are effectively constants).

     ```java
     interface Animal {
         void sound();
     }
     ```

2. **Abstract Class:**

   - An abstract class is a class that cannot be instantiated on its own and can have both abstract and concrete methods.

   - Abstract classes are used when some common behavior among related classes should be defined and shared, but we also want to enforce that no instances of the abstract class are created.

   - A class can extend only one abstract class, due to Java's single inheritance principle.

   - Abstract classes can have constructors and can maintain state (have instance variables).

     ```java
     abstract class Animal {
         abstract void sound();
     
         void breathe() {
             System.out.println("Breathing...");
         }
     }
     ```

**Differences between Interface and Abstract Class:**

- **Method Implementation:** Abstract classes can have fully implemented methods, but interfaces cannot (before Java 8).
- **State Maintenance:** Abstract classes can maintain state (with instance variables), but interfaces cannot.
- **Multiple Inheritance:** A class can implement multiple interfaces but can extend only one abstract class.
- **Constructor:** Abstract classes can have constructors, while interfaces cannot.
- **Access Modifiers:** By default, all methods in an interface are public, while in an abstract class they can have any access modifier.

## 15. What are Queue interface implementations and what are the differences and when to use what?

 `Queue` interface is part of the Java Collections Framework and is used to represent a sequence of elements in a first-in-first-out (FIFO) order. There are several implementations of the `Queue` interface, each with its own specific use cases:

1. **LinkedList:**
   - Implements both `List` and `Queue` interfaces.
   - It's a doubly-linked list that can be used as a FIFO, LIFO, or a list.
   - Good for applications where you need dynamic array behavior along with queue operations.
   - Not synchronized (not thread-safe).
2. **PriorityQueue:**
   - Elements are ordered according to their natural ordering or by a `Comparator` provided at queue construction time.
   - It does not permit `null` elements.
   - A good choice when you need to retrieve elements in a priority order (not necessarily FIFO).
   - Not synchronized (not thread-safe).
3. **ArrayDeque:**
   - Resizable-array implementation of the `Deque` interface (hence also a `Queue`).
   - More efficient than `LinkedList` for queue operations.
   - No capacity restrictions; grows as necessary to support usage.
   - Does not permit `null` elements.
   - Use it when you need a resizable-array implementation without the need for capacity restriction.
4. **ConcurrentLinkedQueue:**
   - An appropriate choice for highly concurrent environments (thread-safe).
   - Implements a concurrent lock-free queue.
   - Use it when multiple threads share a single queue.
5. **BlockingQueue Implementations:**
   - `LinkedBlockingQueue`, `ArrayBlockingQueue`, `PriorityBlockingQueue`, `DelayQueue`, etc.
   - These queues block when attempting to retrieve an element from an empty queue or trying to add an element to a full queue (in case of fixed-capacity queues).
   - Ideal for producer-consumer scenarios.