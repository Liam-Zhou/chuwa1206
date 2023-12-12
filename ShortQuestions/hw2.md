#### 1.  Write up Example code to demonstrate the three foundmental concepts of OOP. (reference Code Demo repo as example)
##### 1.  Encapsulation
```java
class Student{
    private String name;
    private int gender;

    public void setGender(int gender){
        System.out.println("Setting Gender");
        this.gender = gender;
    }
    public void setName(String name){
        System.out.println("Setting Name");
        this.name = name;
    }
    public int getGender(){
        return gender;
    }
    public String getName(){
        return name;
    }
}

class Main {
    public static void main(String[] args) {
        Student s = new Student();
        s.setGender(1);
        s.setName("Hans");
        System.out.println("Gender was set:" + s.getGender());
        System.out.println("Name was set:" + s.getName());
        //System.out.println(s.name);
    }
}
```
Result:

![Result](./hw2%20Screenshots/1.png)
##### 2.  Polymorphism
###### 1.  @Override
```java
class Student{
    public void printName(){
        System.out.println("Hans Yu");
    }
}

class ChineseStudent extends Student{
    @Override
    public void printName() {
        System.out.println("Hanxiang Yu");
    }
}

class Main {
    public static void main(String[] args) {
        ChineseStudent s = new ChineseStudent();
        s.printName();
    }
}

```
Result:

![Result](./hw2%20Screenshots/2.png)
###### 2.  @Overload
```java
class Score{
    private int mathScore;
    private int englishScore;
    private int chineseScore;

    Score(int mathScore,int englishScore, int chineseScore){
        this.mathScore = mathScore;
        this.chineseScore = chineseScore;
        this.englishScore = englishScore;
    }

    public int add(){
        return mathScore + englishScore;
    }
    public int add(int mathScore, int englishScore,int chineseScore){
        return mathScore + englishScore + chineseScore;
    }
}

class Main {
    public static void main(String[] args) {
        Score s = new Score(90,90,90);
        System.out.println("Score of Math and English:" + s.add());
        System.out.println("Total Score:" + s.add(90,90,90));
    }
}
```
Result:

![Result](./hw2%20Screenshots/3.png)
##### 3.  Inheritance
```java
class Student{
    public void printName(){
        System.out.println("Hans Yu");
    }
}

interface StudentImformation{
    public void printGender();
    public void printScore();
}

class ChineseStudent extends Student implements StudentImformation{
    public void printGender(){
        System.out.println("Male");
    }
    public void printScore(){
        System.out.println("A+");
    }
}

class Main {
    public static void main(String[] args) {
        ChineseStudent s = new ChineseStudent();
        s.printName();
        s.printGender();
        s.printScore();
    }
}
```
Result:

![Result](./hw2%20Screenshots/4.png)
#### 2.  What is wrapper class in Java and Why we need wrapper class?
A wrapper class in Java is a type of class that encapsulates a primitive data type within an object. These classes are part of the Java standard library and provide a way to use primitive data types as objects.
For example:
```
byte ➜ Byte
short ➜ Short
int ➜ Integer
long ➜ Long
float ➜ Float
double ➜ Double
char ➜ Character
boolean ➜ Boolean
```
Wrapper classes allow primitives to be treated as objects, so it enables the use of primitive data types with collections like ***ArrayList***, ***HashMap***, etc.  
Wrapper classes provide useful methods for conversions, comparisons, and character operations which are not available with primitive types, it also involves the ability to deal with ***"null"*** values. 
#### 3.  What is the difference between HashMap and HashTable?
| Feature                | HashMap                          | HashTable                       |
|------------------------|----------------------------------|---------------------------------|
| Synchronization        | Not synchronized                 | Synchronized                    |
| Null keys and values   | Allows one null key and multiple null values | Does not allow null keys or values |
| Performance            | Faster, as it is not synchronized | Slower, due to synchronization   |
| Inheritance            | Inherits `AbstractMap` class     | Inherits `Dictionary` class     |
| Thread Safety          | Not thread-safe                  | Thread-safe                     |
#### 4.  What is String pool in Java and why we need String pool?
The String Pool in Java is a special memory region where Java stores literal String values, different String variables can refer to the same String object in the pool if they have the same value.
##### Why Do We Need String Pool?
- **Memory Optimization**: The main purpose is to reduce memory usage and improve performance by storing only one copy of each distinct String value.
- **Faster String Comparison**: Using `==` operator for String comparison is much faster compared to `equals()` method.
- **Java Efficiency**: As Strings are widely used in Java applications, having a pool significantly boosts the performance of Java applications.
#### 5.  What is Java garbage collection?
Java Garbage Collection is an automatic memory management process in Java which identifies and discards objects that are no longer in use by a program.
This process helps in freeing up memory space that was previously occupied by discarded objects, ensuring efficient memory usage and avoiding memory leaks.

#### 6.  What are access modifiers and their scopes in Java?
1.**public**: The element is accessible from any other class in the Java environment.  
2.**protected**: The element is accessible within its own package and by subclasses.  
3.**default** (no keyword): The element is accessible only within its own package.  
4.**private**: The element is accessible only within its own class.

| Modifier  | Class | Package | Subclass | World |
|-----------|-------|---------|----------|-------|
| public    | Yes   | Yes     | Yes      | Yes   |
| protected | Yes   | Yes     | Yes      | No    |
| default   | Yes   | Yes     | No       | No    |
| private   | Yes   | No      | No       | No    |
#### 7.  What is final key word? (Filed, Method, Class)
##### 1. Final Field
- **Syntax**: `final dataType fieldName;`
- **Usage**: When a field is declared as final, its value cannot be modified once it is initialized. This means the field must be initialized at the time of declaration or in the constructor of the class.

##### 2. Final Method
- **Syntax**: `final returnType methodName() { ... }`
- **Usage**: A final method cannot be overridden by any subclass. This is used to prevent alteration of the method's behavior in any inheriting class.

##### 3. Final Class
- **Syntax**: `final class ClassName { ... }`
- **Usage**: A final class cannot be subclassed. This is mainly used to prevent inheritance. For example, the `String` class in Java is final.

#### 8.  What is static keyword? (Filed, Method, Class). When do we usually use it?
##### 1. Static Field
- **Syntax**: `static dataType fieldName;`
- **Usage**: Static fields are shared among all instances of a class. They are initialized only once, at the start of the execution, and exist for the lifetime of the class.
##### 2. Static Method
- **Syntax**: `static returnType methodName() { ... }`
- **Usage**: Static methods belong to the class rather than the object. They can be called without creating an instance of the class.

##### 3. Static Block
- **Syntax**: `static { ... }`
- **Usage**: Static blocks are used for static initializations of a class. This block gets executed when the class is loaded in the memory. It is executed before the main method at the time of classloading.

##### When to Use Static
1. **Common Property**: Use a static field when it needs to be shared across all instances of the class.
2. **Utility Methods**: Static methods are used for operations that don’t require any data from an instance of the class.
3. **Class Initialization**: Static blocks are typically used for initializing static variables.
#### 9.  What is the differences between overriding and overloading?
##### Overriding
- **Definition**: Method overriding occurs when a subclass provides a specific implementation for a method that is already defined in its parent class.
- **Purpose**: Used to change or extend the behavior of a method defined in the superclass.
- **Rules**:
  - The method must have the same name and return type as the method in the parent class.
  - The method must have the same parameter list.
  - It can have lower access privileges.
  - It can throw the same, narrower, or no exceptions, but not broader exceptions than the overridden method.
- **[Example](#1-override)**
##### Overloading
- **Definition**: Method overloading occurs when two or more methods in the same class have the same name but different parameters (different type, number, or both).
- **Purpose**: Used to increase the readability of the program by allowing different kinds of parameters within the same method name.
- **Rules**:
  - Methods must have the same name.
  - Methods must have different parameter lists (either in type, number, or both).
  - Methods can have different return types and different access modifiers.
- **[Example](#2-overload)**
#### 10.  What is the differences between super and this?
##### `super`
- **Purpose**: The `super` keyword is used to refer to the ***immediate*** parent class of the current class.
- **Usage**:
  1. **Accessing Parent Class Methods**: To call methods of the parent class that may have been overridden in the current class.
  2. **Accessing Parent Class Constructor**: To call the constructor of the parent class.
##### `this`
- **Purpose**: The `this` keyword is used to refer to the current instance of the class.
- **Usage**:
  1. **Accessing Instance Variables**: To distinguish instance variables from parameters with the same name.
  2. **Accessing Instance Methods**: To call other methods of the same class.
  3. **Calling Current Class Constructor**: To call another constructor of the same class in terms of constructor chaining.

#### 11.  What is the Java load sequence?
1. **Loading of the Class**
  - A class is loaded when the JVM reads the class file for the first time.
  - Loading can be triggered by:
    - Creating an instance of the class.
    - Accessing a static member of the class.

2. **Linking**
  - **Verification**: Checks the correctness of the class file.
  - **Preparation**: Allocates memory for class variables and initializing them to default values.
  - **Resolution**: Transforms symbolic references from the type into direct references.

3. **Initialization**
  - Static variables are initialized to their values defined in the code.
  - Static initialization blocks are executed.

4. **Creation of the Object**
  - Memory for the object is allocated on the heap.
  - Each object attribute is initialized to its default value.

5. **Initialization of the Object**
  - The constructor of the class is called.
  - If there is a superclass, the constructor of the superclass is called first.
  - Instance variables are initialized to their explicit values.
  - Instance initialization blocks are executed.
  - The rest of the constructor code is executed.
  - 
#### 12.  What is Polymorphism ? And how Java implements it ?
This means "many shapes" and in Java, it primarily refers to the ability of one interface or method to be used for different data types. It can be achieved through method overriding (runtime polymorphism) and method overloading (compile-time polymorphism).
[Implementation Example](#2-polymorphism)
#### 13.  What is Encapsulation ? How Java implements it? And why we need encapsulation?
Encapsulation is about bundling the data (attributes) and the methods (functions) that operate on the data into a single unit, called an object. It also involves controlling the access to these attributes and methods by using access modifiers like private, public, and protected.
[Implementation Example](#1-encapsulation)
##### Why Do We Need Encapsulation?
1. **Control of Data**
  - Encapsulation helps in controlling the data by providing getter and setter methods.
2. **Data Hiding**
  - By making the class fields private, we can hide the internal state of an object.
  - It allows the internal representation of an object to be hidden from outside view.
3. **Reduce Complexity and Increase Reusability**
  - Encapsulation simplifies the maintenance and evolution of the system by keeping a consistent interface even as the internal workings change.
  - It allows a class to change its internal implementation without hurting the classes that use it.
4. **Modularity**
  - Encapsulation improves the modularity of the application. It allows the developer to build modules that do not reveal the internal implementation details.
#### 14.  What is Interface and what is abstract class? What are the differences between them?
##### Interface
- **Definition**: An interface in Java is a blueprint of a class. It has static constants and abstract methods. Interfaces provide a way to achieve abstraction and multiple inheritance.
- **Characteristics**:
  - Cannot have concrete methods (except default and static methods in Java 8 and later).
  - All methods are inherently abstract.
  - Used to achieve full abstraction and multiple inheritance.
  - Can have only static and final variables.

##### Abstract Class

- **Definition**: An abstract class is a class that cannot be instantiated on its own and must be subclassed. It can have both abstract and concrete methods.
- **Characteristics**:
  - Can have a mix of methods with or without implementation.
  - Unlike interfaces, they can have member variables that are not final.
  - Can have constructors.
  - Used when some common behavior needs to be defined in the base class.

##### Differences

| Feature                    | Interface                                    | Abstract Class                             |
|----------------------------|----------------------------------------------|--------------------------------------------|
| Method Implementation      | Cannot have fully implemented methods (except in Java 8 and later) | Can have both abstract and fully implemented methods |
| Constructors               | Cannot have constructors                     | Can have constructors                      |
| Multiple Inheritance       | Supports multiple inheritance                | Does not support multiple inheritance     |
| Type of Methods            | Only abstract, default, or static methods    | Can have all types of methods              |
| Instance Variables         | Can only have static and final variables     | Can have non-final instance variables      |
| Accessibility              | Public or default access                     | Can have any access modifier               |
#### 15.  design a parking lot (put the code to codingQuestions/coding1 folder, )
[Code](../CodingQuestions/ParkingLot.java)
#### 16.  What are Queue interface implementations and what are the differences and when to use what?
| Queue Implementation    | Description                                                                                   | Key Features                                       | When to Use                                                                                     |
|-------------------------|-----------------------------------------------------------------------------------------------|----------------------------------------------------|-------------------------------------------------------------------------------------------------|
| **LinkedList**          | Implements the Queue interface, providing FIFO operations. It is a doubly-linked list.        | - Dynamically sized<br> - Allows null elements<br> - Provides queue and deque operations | - Suitable for applications needing list and queue functionalities<br> - Frequent insertions and deletions |
| **PriorityQueue**       | A priority heap based queue that orders elements by natural ordering or a provided Comparator. | - Ordered by natural ordering or Comparator<br> - No null elements<br> - Not strictly FIFO | - Processing elements in priority order<br> - Suitable for algorithms like Dijkstra's or priority-based task scheduling |
| **ConcurrentLinkedQueue** | A thread-safe version of a linked queue with non-blocking operations, suitable for high concurrency. | - Lock-free, thread-safe<br> - High concurrency<br> - Uses CAS operations | - High-throughput, concurrent scenarios<br> - Non-blocking operations and scalability |
