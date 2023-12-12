1. Write up Example code to demonstrate the three fundamental concepts of OOP. (reference Code Demo repo as example)

   - Encapsulation

   ```
   class Square {
       private int width;
       Rectangle(int width) {
           this.width = width;
       }
       public int getWidth() {
           return width;
       }

       public int setWidth(int width) {
           this.width = width;
       }
   }
   ```

   - Polymorphism

   ```
   public class Shape {
       public double getArea() {
           return 0;
       }
   }

   public class Circle extends Shape {

       private double radius;
       Circle(double radius) {
           this.radius = radius;
       }

       @Override
       public double getArea() {
           return 3.14 * radius * radius;
       }
   }

   public class Square extends Shape {

   private double side;
       Square(double side) {
           this.side = side;
       }

       @Override
       public double getArea() {
           return side * side;
       }
   }

   public class Main {
       public static void main(String args[]) {
           Shape[] shapes = new Shape[2];
           shapes[0] = new Square(3);
           shapes[1] = new Circle(4);
           System.out.println(shapes[0].getArea());
           System.out.println(shapes[1].getArea());
       }
   }
   ```

   - Inheritance

   ```
   public class Rectangle {
        private double width;
        private double height;

        Rectangle(double width, double height) {
            this.width = width;
            this.height = height;
        }
        public double getArea() {
            return width * height;
        }
    }


    public class Square extends Rectangle{
        Square(double side) {
            super(side, side);
        }
    }

    public class Main {
        public static void main(String args[]) {
            Square square = new Square(4);
            System.out.println(square.getArea());
        }
    }

   ```

2. What is wrapper class in Java and Why we need wrapper class?

   Wrapper class helps conversions between primitive data type and objects.\
   When we want to serialize a primitive data type, we need to first convert it to an object with the help of a wrapper class.

3. What is the difference between HashMap and HashTable?

   HashMap is non-synchronized and it is not thread-safe.\
   HashTable is synchronized and it is thread-safe.

4. What is String pool in Java and why we need String pool?

   String pool is a storage area in heap to store strings.\
   String pool gives us reusability of strings and it helps saving time and space by pointing references of same strings to the same memory in heap instead of creating a new object.

5. What is Java garbage collection?

   Java garbage collection is an automated process to periodically free up memory space.

6. What are access modifiers and their scopes in Java?

   - Private\
     Accessible within class.
   - Default\
     Accessible within the package
   - Protected\
     Accessible within class and subclasses.
   - Public\
     Accessible by everyone.

7. What is final key word? (Field, Method, Class)

   - Field\
     Cannot be changed
   - Method\
     Cannot be overridden
   - Class\
     Cannot have subclasses

8. What is static keyword? (Field, Method, Class). When do we usually use it?

   Only one field/method/sub class is relative to the class. They are stored in one fixed memory and can be accessed without creating an instance.\
   We use static for utility methods

9. What is the differences between overriding and overloading?

   - Override
     - Subclass method overrides superclass method with same method name, parameter, and return type
     - happens during runtime
     - worse performance
     - private and final method cannot be overridden
   - Overload
     - Same class method overloads same class method with same method name, different parameters, and return type does not matter
     - happens during runtime
     - better performance
     - private and final method can be overloaded

10. What is the differences between super and this?

    - super refers to parent object. It is used when calling methods and constructor from parent class.
    - this refers to current object. It is used when calling methods from current class.

11. What is the Java load sequence?

    static block/variables -> constructor

12. What is Polymorphism ? And how Java implements it ?

    Polymorphism occurs when multiple classes are related each other by inheritance.\
    It is implemented through overload and override.

13. What is Encapsulation ? How Java implements it? And why we need encapsulation?

    Encapsulation is to bind data and functions manipulating them into a same class.\
    It is implemented by setting fields to private and writing public getter and setter methods for manipulating and accessing them.\
    We need encapsulation to hide data behind the class to prevent unauthorized parties from directly accessing them.

14. What is Interface and what is abstract class? What are the differences between them?

    - Interface acts like a code contract and has to be implemented by a concrete class
    - Abstract class is like a normal class, but it can include abstract methods to be implemented by subclasses. Abstract class cannot be instantiated

15. design a parking lot (put the code to codingQuestions/coding1 folder, )

    1. If you have no ability to design it, please find the solution in internet, then understand it, and re-type it.(Do NOT just copy and paste)

16. What are Queue interface implementations and what are the differences and when to use what?

    - PriorityQueue: used when objects are supposed to be processed by priority\
      Based on arrays
    - LinkedList: used to store and process elements not in contiguous locations by pointers\
      Based on pointers
