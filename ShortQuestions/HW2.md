1. Write up Example code to demonstrate the three foundmental concepts of OOP. (reference Code Demo repo as example)

   Encapsulation

   In the reference code demo repo, they use the User class as an example. I can also try to use Person class to implement for encapsulation.

   ```java
   public class Person {
     private String name;
     private String gender;
     
     public String getName() { return name; }
     public void setName(String name) { this.name = name; }
     public String getGender() { return gender; }
     public void setGender(String gender) { this.gender = gender; }
     
     public class Main {
       public static void main(String [] args){
         Person person = new Person();
         person.setName("Chuwa");
         person.setGender("NB");
         System.out.println(person.getName());
         System.out.println(person.getGender());
       }
     }
   }
   ```

   Polymorphism

   In the code demo repo, chuwa uses the shape for the reference of polymorphism, i think this is great and i learn from it and implement something on my own.

   ```java
   public class Shape {
   
       public double getArea() {
           return 0;
       }
   
   }
   
   class Rectangle extends Shape {   
   
       private double width;
       private double height;
   
       public Rectangle(double width, double heigh) {
           this.width = width;
           this.height = heigh;
       }
   
       @Override
       public double getArea() {
           return width * height;
       }
   
   }
   
   class Circle extends Shape {
       private double radius;
   
       public Circle(double radius) {
           this.radius = radius;
       }
   
       @Override
       public double getArea() {
           return 3.14 * radius * radius;
       }
   }
   
   class Square extends Shape{
     private double length;
     public Square(double length){
       this.length = length;
     }
     @Override
     public double getArea(){
       return length * length;
     }
   }
   ```

   Inheritance

   ```java
   public class Vehicle {
       public void move() {
           System.out.println("Vehicle");
       }
   }
   
   public class Car extends Vehicle {
       @Override
       public void move() {
           System.out.println("Car");
       }
   }
   
   ```

   

2. What is wrapper class in Java and Why we need wrapper class? 

   Wrapper class is a tool in Java to use primitive data types as objects.

   The reason we need wrapper class is because they offer a way to use primitives as objects, so we can use them in collections and we can use methods in the object class.

   

3. What is the difference between HashMap and HashTable?

   HashMap is not synchronized and not thread-safe, HashTable is synchronized and thread-safe.

   HashMap allows one null key and multiple null values, HashTable does not allow null keys or values.

   

4. What is String pool in Java and why we need String pool? 

   String pool in Java is a memory region where Strings are stored by JVM. The String pool works as when a String is created and if it already exists in the pool, the new variable will point to the exising String, instead of creating a new one.

   We need String pool because this can save memory and improve effieciency because it reduces the number of String objects created.

   

5. What is Java garbage collection?

   JWM automatically removes objects that are no longer referenced by program, which helps to free up the memory and improve performance.

   

6. What are access modifiers and their scopes in Java? 

   public: any class

   private: only this class

   default: the same package

   protected: same package and subclasses

   

7. What is final key word? (Filed, Method, Class)

   Filed: a final field can not be changed once initialized

   Method: a final method makes it can not be overridden by subclasses

   Class: a final class cannot be subclassed

   

8. What is static keyword? (Filed, Method, Class). When do we usually use it?

   Filed: a static field belongs to the class rather than instances of class

   Method: a static method can be called without creating an instance of class

   Class: a static inner class do not reference an outer class instance

   

   Use for constants, or single instance objects.

   

9. What is the differences between overriding and overloading?

   Overloading:

   - has complie time
   - gives better performance because the binding is being done at compile time
   - private and final methods can be overloaded
   - return type of method does not matter
   - arguments must be different
   - in the same class

   Overriding:

   - has run time

   - gives less performance because the binding is being done at run time

   - private and final methods can not be overriden

   - return type of method must be the same

   - arguments must be the same

   - require base and child classes

     

10. What is the differences between super and this?

    Super: refers to parent class(super class) objects and is used to call super class methods and constructors.

    This: referes to the current instance of a class and used to call other constructors and methods in the same class.

    

11. What is the Java load sequence?

    - load the class, find the class and read the binary data

    - there is a process called Linking includes verification, preparation, and resolution

    - then start to initialize, which includes static blocks and constructor execution

      

12. What is Polymorphism ? And how Java implements it ? 

    Polymorphism includes static Polymorphism(Overload) and dynamic Polymorphism(Override). it means the same object exhibit different form and behaviors.

    Java implements it by overloadding and overriding.

    

13. What is Encapsulation ? How Java implements it? And why we need encapsulation? 

    Encapsulation in OOP means binding the data and the methods to manipulate that data together in a single unit/class.

    Java implements encapusulation by using different modifiers(private, public, protected, default).

    We need encapsulation bevause we want to do data hiding and protecting the internal state of an object.

    

14. What is Interface and what is abstract class? What are the differences between them?

    Interface: defines a contract with abstract methods that classes can implement.

    Abstract class: similar to normal class but can have abstract methods.

    Differences:

    - itnerface can have only abstract methods; abstract class can have abstract mehod and concrete methods.
    - variables declacred in interface are final; abstract class can contain non-final variables.
    - abstract can provide implementation of interface; interface cant provide implementation of abstract class.
    - interface uses "implements"; abstract class uses "extends"
    - 1 interface can extend 1 or more interfaces; 1 abstact class can extend 1 class and implements 1 or more interfaces
    - multiple inheritance can be achieved by using interfaces but not abstract classes

15. design a parking lot (put the code to codingQuestions/coding1 folder, )

    Done.

16. What are Queue interface implementations and what are the differences and when to use what?

    ![](/Users/yinchen/chuwa_training/ShortQuestions/iScreen Shoter - Google Chrome - 231211182806.jpg)

    - LinkedList: LinkedList is implemented to implements thelink list data structure. It is a linear data structure where the elements are not stored in contiguous locations and every element is a separate object with a data part and address part. The elements are linked using pointers and addresses. Each element is known as a node. It is usually used when there are more insertions and deletions than searching.
    - PriorityQueue: PriorityQueue class is implemented and provides a way to process the objects based on the priority. It is known that a queue follows the First-In-First-Out algorithm, but sometimes the elements of the queue are needed to be processed according to the priority.
    - ArrayDeque: ArrayDeque class in Java is an implementation of the Deque interface that uses a resizable array to store its elements. ArrayDeque class provides constant-time performance for inserting and removing elements from both ends of the queue, making it a good choice for scenarios where you need to perform many add and remove operations.