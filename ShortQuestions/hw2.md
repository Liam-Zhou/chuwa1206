### 1.

#### Encapsulation

``` java
public class Player {
    private String name;
    private int age;
    private String team;

    public Player(String name, int age, String team) {
        this.name = name;
        this.age = age;
        this.team = team;
    }

    // Getter methods for encapsulated fields
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getTeam() {
        return team;
    }

    // Setter methods for encapsulated fields
    public void setTeam(String team) {
        this.team = team;
    }

    // Encapsulated method
    public void play() {
        System.out.println(name + " is playing for " + team);
    }
}

```

#### Polymorphism & Inheritance

``` java
public interface Playable {
    void play();
}

public class FootballPlayer extends Player implements Playable {
    public FootballPlayer(String name, int age, String team) {
        super(name, age, team);
    }
		//override
    @Override
    public void play() {
        System.out.println(getName() + " is playing football for " + getTeam());
    }
    //overload
    public void play(String opponent) {
        System.out.println(name + " is playing football against " + opponent + " for " + team);
    }
}

public class BasketballPlayer extends Player implements Playable {
    public BasketballPlayer(String name, int age, String team) {
        super(name, age, team);
    }

    @Override
    public void play() {
        System.out.println(getName() + " is playing basketball for " + getTeam());
    }
  

    public void play(String opponent) {
        System.out.println(name + " is playing basketball against " + opponent + " for " + team);
    }
}
```

```java
```



### 2. . What is wrapper class in Java and Why we need wrapper class?

> Wrapper class is a class that encapsulates the functionality of a primitive data type into an object. Such as Integer,Double. Character... We need wrapper class because many feature in a OOP language works with object, since primitive data types are not objects, wrapper classes provide a way to treat primitive data types as objects so that can provide additional functionality.

### 3. What is the difference between HashMap and HashTable?

> **Synchronization:** HashTable is thread-safe and HashMap is not.
>
> **Null value:** *HashMap* allows adding one *Entry* with *null* as key as well as many entries with *null* as value. HashTable will throw *NullPointerException* when adding an object with null key.
>
> **Inheritance:** HashMap extends AbstractMap class, HashTable extends Dictionary class.

### 4. What is String pool in Java and why we need String pool?

> String pool is a special area in the memory heap where Strings are stored. When a new string created,  the JVM checks the String pool first. If the String already exists in the pool, a reference to the existing String object is returned, rather than creating a new object.
>
> **pros:**  Memory Efficiency(Reusing existing String objects reduces the overall memory footprint of a program. )
>
>  Performance(Comparing Strings using the `==` operator is faster than using the `equals()` method, and String interning allows for efficient comparison using `==` because it ensures that identical String literals refer to the same object.),
>
> Safety(Immutable Strings so they can safely be shared among multiple parts of a program without the risk of unintended changes.)

### 5. What is Java garbage collection?

> It's an automatic memory management process, JVM  is responsible for reclaiming memory occupied by objects that are no longer reachable or in use by the program. The primary goal of garbage collection is to free up memory and prevent memory leaks, where memory is allocated but never released, leading to inefficient memory usage.

### 6.  What are access modifiers and their scopes in Java?

> **Public:**
>
> - Scope: Accessible from any class.
>
> **Private:**
>
> - Scope: Accessible only within the same class.
>
> **Protected:**
>
> - Scope: Accessible within the same class, subclasses, and classes in the same package.
>
> **Default :**
>
> - Scope: Accessible only within the same package.

### 7.  What is final key word? (Filed, Method, Class)

> the `final` keyword is used to indicate that a field, method, or class cannot be further modified once it has been defined or instantiated.
>
> **Filed**: When applied to a field, it means that the field's value cannot be changed after it has been assigned a value. 
>
> **Method**: When applied to a method, it means that the method cannot be overridden by subclasses. Subclasses are not allowed to provide a different implementation for a final method.
>
> **Class**:  When applied to a class, it means that the class cannot be subclassed. 

### 8. What is static keyword? (Filed, Method, Class). When do we usually use it?

>The `static` keyword is used to define members (fields, methods, and nested classes) that belong to the class rather than to instances of the class
>
>**Filed**: When applied to a field, it means that the field is shared among all instances of the class. 
>
>**Method**: Static methods can be called using the class name without creating an instance of the class.
>
>**Class**: It can be instantiated without creating an instance of the outer class.
>
>**Usage**: 
>
>**Constants:** Declare constants as static final fields.
>
>**Utility Methods:** Define utility methods that do not rely on instance-specific state.
>
>**Factory Methods:** Create static factory methods for object creation.
>
>**Static Blocks:** Use static blocks for static initialization.

### 9.  What is the differences between overriding and overloading?

>**Overloading:**
>
>- Same method name, different parameters.
>- Resolved at compile-time.
>- Occurs within the same class.
>
>**Overriding:**
>
>- Same method name, same parameters.
>- Resolved at runtime.
>- Involves inheritance, occurs in subclasses.

### 10.  What is the differences between super and this?

> **this:**
>
> - Refers to the current instance of the class.
> - Used for differentiating between instance variables and parameters, and for invoking the current object's method.
> - Used in instance methods and constructors.
>
> **super:**
>
> - Refers to the superclass.
> - Used to access members (fields or methods) of the superclass.
> - Used in the context of a subclass, typically in methods or constructors.

### 11. What is the Java load sequence?

> static variable/block   -> constructor -> non-static variable/block

### 12.  What is Polymorphism ? And how Java implements it ?

> **Polymorphism** is a fundamental concept in object-oriented programming that allows objects of different types to be treated as objects of a common type. polymorphism is implemented through two mechanisms:  Compile-Time Polymorphism (Method Overloading) and Run-Time Polymorphism (Method Overriding).

### 13. What is Encapsulation ? How Java implements it? And why we need encapsulation?

> Encapsulation in OOP refers to binding the data and the methods to manipulate that data together in a single unit (class)
>
> Why Encapsulation:
>
> - **Data Hiding:** Encapsulation hides the implementation details of a class, allowing changes to be made without affecting the external code that uses the class.
> - **Controlled Access:** By providing controlled access through getter and setter methods, you can enforce validation rules, ensure consistency, and manage the state of an object.
> - **Flexibility:** Encapsulation enables the class to have a well-defined interface, making it easier to evolve and maintain the code over time.
> - **Security:** Hiding the implementation details enhances security by preventing unauthorized access and modification of internal state.

### 14. What is Interface and what is abstract class? What are the differences between them?

| abstract class                                               | Interface                                                    |
| ------------------------------------------------------------ | ------------------------------------------------------------ |
| An abstract class can contain both abstract and non-abstract methods. | Interface contains only abstract methods.                    |
| An abstract class can have all four; static, non-static and final, non-final variables. | Only final and static variables are used.                    |
| To declare abstract class abstract keywords are used.        | The interface can be declared with the interface keyword.    |
| It supports multiple inheritance.                            | It does not support multiple inheritance.                    |
| abstract classes are used when there is some common behavior that all subclasses must share. | Interfaces are used when there is a set of behaviors that all subclasses must supp |



### 15. design a parking lot (put the code to codingQuestions/coding1 folder

### 16. What are Queue interface implementations and what are the differences and when to use what?

> the Queue interface is part of the Java Collections Framework and represents a collection designed for holding elements prior to processing. It follows the First-In-First-Out (FIFO) order.
>
> **LinkedList**
>
> ```java
> Queue<String> linkedListQueue = new LinkedList<>();
> ```
>
> **ArrayDeque**
>
> ```java
> Queue<String> arrayDequeQueue = new ArrayDeque<>();
> ```
>
> **PriorityQueue**
>
> ```java
> Queue<String> priorityQueue = new PriorityQueue<>();
> 
> ```
>
> **ConcurrentLinkedQueue**
>
> ```java
> Queue<String> concurrentLinkedQueue = new ConcurrentLinkedQueue<>();
> 
> ```
>
> **When to Use What:**
>
> - **LinkedList or ArrayDeque:**
>   - Use when you need a general-purpose queue with efficient add and remove operations.
>   - LinkedList is suitable for scenarios where frequent insertions and removals occur from both ends.
>   - ArrayDeque is more memory-efficient and is a good choice for a double-ended queue.
> - **PriorityQueue:**
>   - Use when you need elements to be processed based on priority.
>   - Suitable for tasks where processing order depends on a specified priority.
> - **ConcurrentLinkedQueue:**
>   - Use in a concurrent environment where thread safety is crucial.
>   - Suitable for scenarios with a high level of concurrency.