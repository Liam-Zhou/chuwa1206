1. Write up Example code to demonstrate the three foundmental concepts of OOP. (reference Code Demo
   repo as example)
   1. Encapsulation;
   ```java
    public class Dog {
        private String breed;
        private String name;
        private int age;
   
        public Dog (String breed, String, name, int age) {
            this.breed = breed;
            this.name = name;
            this.age = age;
        }
   
        public String getBreed() {
            return breed;
        }
   
        public String getName() {
            return name;
        }
 
        public int getAge() {
            return age;
        }  
   
        public void setBreed(String newBreed) {
            this.breed = newBreed;
        }
   
        public void setName(String newName) {
            this.name = newName;
        }
        
        public void setAge(int newage) {
            this.age = newage;
        }
    }   
   ```
   2. Polymorphism
   ```java
    public class Dog {
        public String bark() {
            return "bark bark";
        }    
        
        public String bark(String sounds) {
            return sounds;
        }   
    }
   
    class smallDog extends Dog {
        @Override
        public String bark() {
            return "aroo-roo-roo-roo-roo-roooooooooo";
        }
    } 
   
    class BigDog extends Dog {
        @Override
        public String bark() {
            return "wolf wolf wolf";
        }
    } 

   ```
   3. Inheritance
   ```java
    public class Company {
        private String brand = "Chuwa";
        public String welcome() {
            return "Welcome to Chuwa";
        } 
    }
   class Batch extends Company {
        private String name = "JavaBatch";
    
        public static void main(String[] args) {
            Batch myBatch = new Batch();
            myBatch.welcome();
            System.out.println(myBatch.brand + " " + myBatch.name);
        }    
   }

   ```
2. What is wrapper class in Java and Why we need wrapper class?

   - A wrapper class in Java is a class that encapsulates a primitive data type and provides a way to use it as an object.

   - Wrapper classes are useful when you need to pass a primitive data type as an object.

3. What is the difference between HashMap and HashTable?
    
    |                      | HashMap       | HashTable                                        |
    |----------------------|---------------|--------------------------------------------------|
    | Synchronization      | No            | Yes                                              |
    | Null keys and values | No            | Allow one null key and any number of null values |
    | Performance          | Faster        | Average                                          |
    | Subclass             | LinkedHashMap | None                                             |

4. What is String pool in Java and why we need String pool?
- In Java, a String pool is a storage area in the Java heap where string literals are stored. It is also known as the String Intern Pool or String Constant Pool. By default, it is empty and privately maintained by the Java String class
- To decrease the number of String objects created in the JVM, the String class keeps a pool of strings. When we create a string literal, the JVM first checks that literal in the String pool. If the literal is already present in the pool, it returns a reference to the pooled instance.

5. What is Java garbage collection?
- Java garbage collection is an automatic process. Automatic garbage collection is the process of looking at heap memory, identifying which objects are in use and which are not, and deleting the unused objects. 

6. What are access modifiers and their scopes in Java?
    
    | Modifier  |                                                    |
    |-----------|----------------------------------------------------|
    | Default   | visible only within the package                    |
    | Private   | visible only within the class                      |
    | Protected | visible only within the packages or all subclasses |
    | Public    | visible everywhere                                 |

7. What is final key word? (Filed, Method, Class)
- final variable:  cannot change the value of the final variable. It will be constant
- final method: cannot override it
- final class: cannot extend it 

8. What is static keyword? (Filed, Method, Class). When do we usually use it?
- The static keyword is used to indicate that a variable, method, or class belongs to the class itself, rather than to an instance of the class
  - Static variable:  
    - It is initialized only once at the start of the execution.
    - A static variable is shared among all instances of the class.
  - Static method:
    - It can be called without creating an instance of the class
  - Static class:
    - A static class is a nested class that is a static member of the outer class. It can be accessed without creating an instance of the outer class
9. What is the differences between overriding and overloading?
    
    | Overloading                                                                         | Method Overriding                                                                              |
    |-------------------------------------------------------------------------------------|------------------------------------------------------------------------------------------------|
    | Occurs within the class                                                             | Occurs in two classes with inheritance relationships                                           |
    | Methods must have the same name and different signatures                            | Methods must have the same name and same signature                                             |
    | The return type can or cannot be the same, but we just have to change the parameter | The return type must be the same or co-variant                                                 |
    | Static binding is being used for overloaded methods                                 | Dynamic binding is being used for overriding methods                                           |
    | Poor performance due to compile-time polymorphism                                   | It gives better performance because the binding of overridden methods is being done at runtime |
    | Private and final methods can be overloaded                                         | Private and final methods can’t be overridden                                                  |
    | The argument list should be different while doing method overloading                | The argument list should be the same in method overriding                                      |

10. What is the differences between super and this?
- super and this are both keywords used to make constructor calls
  - super: call the constructor of the parent class
  - this: call the constructor of the current class 

11. What is the Java load sequence?

- Loading: 
    - During the loading phase, the class loader loads the class file into memory
- Linking -> Verifiction -> Preparation -> Resolution
- Initializing: 静态变量，静态变量块在初始化的时候执行，实例变量和实例块在对象创建的时候执行，构造器最后执行
  - JVM initializes the class variables and executes the static initializer block.
  
12. What is Polymorphism? And how Java implements it?
- Polymorphism is a concept in object-oriented programming that allows objects of different classes to be treated as if they were objects of the same class 
- In Java, polymorphism is achieved through method overriding and method overloading

14. What is Encapsulation ? How Java implements it? And why we need encapsulation?
- Encapsulation is a fundamental concept in object-oriented programming (OOP) that refers to the bundling of data and methods that operate on that data within a single unit, which is called a class in Java 
- Java Encapsulation is a way of hiding the implementation details of a class from outside access and only exposing a public interface that can be used to interact with the class
-  In Java, encapsulation is achieved by declaring the instance variables of a class as private, which means they can only be accessed within the class
15. What is Interface and what is abstract class? What are the differences between them?
    
    | Interface                                                                                                | Abstract Class                                                                                       |
    |----------------------------------------------------------------------------------------------------------|------------------------------------------------------------------------------------------------------|
    | An interface can only contain abstract methods, default methods, static methods, and constant variables. | An abstract class can contain both abstract and non-abstract methods, as well as instance variables. |
    | An interface cannot be instantiated.                                                                     | An abstract class cannot be instantiated.                                                            |
    | A class can implement multiple interfaces.                                                               | A class can extend only one abstract class.                                                          |
    | An interface can be used to achieve full abstraction.                                                    | An abstract class can be used to achieve partial abstraction.                                        |
    | An interface is used to define a behavior that a class must implement.                                   | An abstract class is used to provide a common base for a group of related classes.                   |

16. design a parking lot 

   code in codingQuestions/coding1 folder

17. What are Queue interface implementations and what are the differences and when to use what?

    the Queue interface is used to hold a collection of elements in a specific order, following the First-In-First-Out (FIFO) principle. The Queue interface extends the Collection interface and provides several methods for adding, removing, and inspecting elements in the queue.
    
    | Implementation | Description        |
    |----------------|--------------------|
    | LinkedList     | Double linked list |
    | ArrayDeque     | Resizable array    |
    | PriorityQueue  | Priority heap      |