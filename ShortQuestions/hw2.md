## Q1
### Encapsulation
```
public class Person{
    private String name;
    private int age;
    
    public int getAge(){
        return age;
    }
    
    pubic String getName(){
        return name;
    }
    
    public void setAge(int age){
        this.age = age;
    }
    
    public void setName(String name){
        this.name = name;
    }
}
```
### Polymorphism
```
public class Shape {
    public double getArea() {
        return 0;
    }
}

class Rectangle extends Shape {
    private double width;
    private double height;
    
    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
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
```
### Inheritance
```
public class Animal {
    private String name;
    private int id;
    
    public Animal(String myName, int myId){
        //...    
    }
    
    public void eat(){
        //...
    }
    public void sleep(){
        //...
    }
}

public class Cat extends Animal{
    //...
}
```
```
public interface A {
    public void eat();
    public void sleep();
}
public interface B {
    public void show();
}

public class C implements A, B {
    //...
}
```
## Q2
Wrapper classes are needed to represent primitive data types as Object. It can provide auto-boxing and auto-unboxing function
## Q3
HashTable is synchronized (thread-safe) but restricts null values, HashMap is non-synchronized (faster), allows one/multiple null key.
## Q4
`String is Immutalbe in Java`. String pool is a special storage area in Java heap. If the string is already present in the pool, then instead of creating a new object, old object's referencee is returned. This way different String variables can refer to the same reference in the pool, thus saving a lot of heap space.
## Q5
Garbage collection in java is the process of looking at heap memory, identifying which objects are in use and which are not and deleting the unused objects (which is no longer referenced by any part of your program)
## Q6
`4 in total`
1. Default -> visible only within the package
2. Private -> visible only within the class
3. Protected -> visible within the package or all subclass
4. Public -> visible everywhere
## Q7
_for field -> makes the variable a constant

_for method -> prevents method overriding in subclasses

_for class -> prevents class inheritance
## Q8
_for field -> the field is associated with the class itself, rather than with instances of the class. All instances of the class share the same static field

_for method -> the method belongs to the class rather than to any particular instance. Staic method can be called using the class name, without creating an instance of the class

_for class -> the nested class is a static nested class, which doesn't have access to the instance-specific fields and methods of the outer class without an instance of the outer class

It is useful for scenarios where the member doesn't depend on the specific state of an object but is relevant at the class level
## Q9
| Overloading                                         | Overriding                                                                                         |
|-----------------------------------------------------|----------------------------------------------------------------------------------------------------|
| compile time                                        | runtime                                                                                            |
| better performance                                  | less performance                                                                                   |
| private and final can be overloaded                 | private and final **CANNOT** be overridden                                                         |
| return type of method does not matter               | return type of method must be the same                                                             |
| Arguments must be **different**                     | Arguments must be the **same**                                                                     |
| in same class                                       | base and child classes are required                                                                |
| mostly used to increase the readability of the code | mostly used to provide the implementation of the method that is already provided by its base class |
 
## Q10
| super                                                                   | this                                                                                 |
|-------------------------------------------------------------------------|--------------------------------------------------------------------------------------|
| refers to the immediate parent class object                             | refers to the current instance of the class                                          |
| used in the context of inheritance                                      | used to access instance variables, call other methods                                |
| used to call the parents class's method, access its fields              | used to differentiate btwn instance variables and method parameters w/ the same name |
| differentiate btwn the superclass and subclass members w/ the same name | invoke another constructor of the same class                                         |
| invoke the constructor of the superclass                                | can be used within methods, constructors, or instance initialization blocks          |

## Q11
A dynamic process that occurs on-demand during program execution

Loading, Verification, Preparation, Resolution, Initialization
## Q12
The process in which an object or function takes different forms

- Compile Time Polymorphism (Overloading)
- Run Time Polymorphism (Overriding)
## Q13
A process of _Binding data and methods within a class_. It promotes data protection, modularity, flexibility, and organized code, contributing to the overall principles of OOP
## Q14
- A class that is declared using "abstract" keyword is known as abstract class
- An interface in Java is a blueprint of a class, it has static constants and abstract methods. It specify what a class must do but not how to do

| Abstract Class                                                   | Interface                                                                           |
|------------------------------------------------------------------|-------------------------------------------------------------------------------------|
| have both abstract and concrete method                           | only have abstract methods (Java 8 onwards, it can have default and static methods) |
| methods can have access modifiers other than public              | implicitly public and abstract                                                      |
| have final, non-final, static, and non-static variables          | only have static and final variables                                                |
| subclass can extend only one abstract class                      | subclass can implement multiple interfaces                                          |
| can extend one other class and can implement multiple interfaces | can only extend other interfaces                                                    |

## Q15

## Q16
| List          | What                                                                                                                                      | Differences                                         | When to use                                           |
|---------------|-------------------------------------------------------------------------------------------------------------------------------------------|-----------------------------------------------------|-------------------------------------------------------|
| LinkedList    | implements `Queue` and `Deque` interfaces, fast insertion and deletion at both ends, suitable for general-purpose queue operations        | Suitable for scenarios w/ frequent +/-              | General-purpose queue w/ fast +/- at both end         |
| PriorityQueue | implements `Queue` interface, orders elements based on natural ordering or a specified comparator, suitable for processing elements based on priority | Efficient for processing elements based on priority | Element have priorities, and processing order matters |
| ArrayDeque    | implements `Queue` and `Deque` interfaces. resizable-array implementation, support fast +/- at both ends, suitable for double-ended queue | Fast O(1) time complexity for +/- at both ends      | Double-ended queeu/ fast +/- at both ends is needed   |


