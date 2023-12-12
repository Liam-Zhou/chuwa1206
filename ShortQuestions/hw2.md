1. Example code:

   1. Encapsulation

      ```java
      public class Student {
      
          private String name;
          private int age;
      
          public Student(String name, int age) {
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

      

   2. Polymorphism

      ```java
      // Superclass
      class Animal {
          void makeSound() {
              System.out.println("Sound");
          }
      }
      
      // Subclass 1
      class Dog extends Animal {
          @Override
          void makeSound() {
              System.out.println("Woof!");
          }
      }
      
      // Subclass 2
      class Cat extends Animal {
          @Override
          void makeSound() {
              System.out.println("Meow!");
          }
      }
      ```

      

   3. Inheritance

      ```java
      // Superclass
      class Animal {
          private String sound;
          
          void makeSound() {
              System.out.println(sound);
          }
      }
      
      // Subclass
      class Cat extends Animal {
          private int speed;
          
          void jump(){
              speed+=1;
          }
      }
      ```

      

2. In Java, a wrapper class is a class that provides an object representation for a primitive data type. The Java programming language includes primitive data types like `int`, `double`, `char`, and others, which are not objects. However, in certain situations, we may need to treat these primitive types as objects. So we can  use wrapper classes to convert an `int` to an `Integer` object and vice versa. Objects can have a `null` value, which can be useful in various situations.

   - `Integer` for `int`
   - `Double` for `double`
   - `Character` for `char`
   - `Boolean` for `boolean`
   - `Byte` for `byte`
   - `Short` for `short`
   - `Long` for `long`
   - `Float` for `float`

3. `HashMap` and `Hashtable` are both classes in Java that implement the `Map` interface and are used to store key-value pairs. However, `HashMap` is preferred due to its better performance and flexibility, and if thread safety is required, other options like `ConcurrentHashMap` are often more suitable than `Hashtable`.

4. "String pool" is a specific area of memory where String objects are stored to enhance performance and reduce memory usage. In Java, Strings are immutable, meaning their values cannot be changed once they are created. To save memory and improve performance, Java maintains a pool of unique String literals in memory. When we create a String literal, Java checks if that String already exists in the pool. If it does, it reuses the existing String object instead of creating a new one. So it is more memory efficient, and can provide better performance.

5. Java garbage collection is an automatic memory management process in the Java Virtual Machine (JVM) that automatically identifies and reclaims memory that is no longer in use by the program. It is a critical feature of the Java programming language that helps developers avoid memory leaks and manage memory efficiently.

6. Access modifiers are keywords that specify the visibility and accessibility of classes, fields, methods, and constructors within a program. They control which parts of a Java program can access, modify, or extend other parts. There are four main access modifiers in Java, each with its scope and visibility rules: `public`, `private`, `protected`, and `default`. These access modifiers help control the encapsulation, visibility, and maintainability of Java code. By using the appropriate access modifier, we can restrict access to certain parts of our code, which can improve security, prevent unintended modification, and promote better code organization.

7. In Java, the `final` keyword can be applied to fields, methods, and classes to indicate different levels of immutability, restriction, or finality. 

   1. Final Field:  the field's value cannot be changed (it's constant). This is often used for constants and to ensure that a field remains unchanged once initialized. 
   2. Final method: the method cannot be overridden by subclasses. Subclasses are not allowed to provide a different implementation for a final method. This provides a level of security or stability in the class's design.
   3. Final class: the class cannot have any subclasses.

8. Static field, method, class:

   1. Static field: the field is shared among all instances (objects) of the class. There is only one copy of the static field that is shared across all instances.
   2. Static method: the method is associated with the class itself, rather than with instances of the class. Static methods can be called using the class name, without creating an object of the class.
   3. Static class (nested class): the nested class is a static nested class, which does not have access to the instance-specific data of the outer class. It can be instantiated without creating an instance of the outer class.

9. Overriding and overloading are two fundamental concepts in Java.

   1. Overloading: also known as compile-time polymorphism or static polymorphism, occurs when a class has multiple methods with the same name but different parameter lists. It is used to define multiple methods in a class that perform similar tasks but with different inputs or argument types. The compiler determines which method to call based on the number and types of arguments provided at compile time (during method invocation).
   2. Overriding: also known as runtime polymorphism or dynamic polymorphism, occurs when a subclass provides a specific implementation for a method that is already defined in its superclass. It is used to implement a new version of a method in a subclass to customize or extend the behavior of the method inherited from the superclass. The method to be called is determined at runtime, based on the actual object type, rather than at compile time.

10. `This` is used to address fields or methods within the class. `Super` is used to address field or methods in the parent class.

11. It is the steps and order in which classes are loaded into the Java Virtual Machine (JVM) during the execution of a Java program. The class loading process ensures that the necessary classes are available for execution.

12. It allows objects of different classes to be treated as objects of a common superclass. It enables you to write more flexible and reusable code by providing a way to work with objects of different types in a unified way.

13. Encapsulation is one of the fundamental principles of object-oriented programming (OOP) that aims to restrict direct access to an object's internal state (data members or attributes) and only allow controlled access through methods (getters and setters). 

14. An interface in Java is a contract that defines a set of abstract methods (methods without implementations) that a class must implement if it implements the interface. It contains only method signatures and constants (public static final fields). An abstract class in Java is a class that can have both abstract methods (methods without implementations) and concrete methods (methods with implementations). Abstract classes can also have fields and constructors. If we need to define a contract for unrelated classes or achieve multiple inheritance, interfaces are suitable. If we want to provide a common base class with shared behavior and fields, an abstract class is appropriate.

15. In the coding question folder

16. `Queue` interface is part of the Java Collections Framework and defines a collection for holding elements in a specific order suitable for processing. It follows the First-In-First-Out (FIFO) principle, where the first element added to the queue is the first to be removed. 