1.
// Example of Encapsulation

class Employee {
    private String name;
    private int salary;

    public Employee(String name, int salary) {
        this.name = name;
        this.salary = salary;
    }

    // Getter and Setter methods
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
}

// Example of Inheritance

class Manager extends Employee {
    private int bonus;

    public Manager(String name, int salary, int bonus) {
        super(name, salary);
        this.bonus = bonus;
    }

    public int getBonus() {
        return bonus;
    }

    public void setBonus(int bonus) {
        this.bonus = bonus;
    }
}

// Example of Polymorphism

class Company {
    public void paySalary(Employee employee) {
        System.out.println("Paying salary to " + employee.getName() + " : $" + employee.getSalary());
    }
}

public class Main {
    public static void main(String[] args) {
        Employee employee = new Employee("Alice", 5000);
        Manager manager = new Manager("Bob", 8000, 2000);

        Company company = new Company();

        // Polymorphism: Manager is also an Employee
       
        company.paySalary(employee);
        company.paySalary(manager);
    }
}


2.
In Java, a wrapper class is a class that turns a primitive data type into an object, allowing primitives to be used in contexts that require objects, such as in collection frameworks.

3.
Synchronization: HashMap is not synchronized, suitable for non-thread-safe operations. HashTable is synchronized, thread-safe but less efficient in single-threaded contexts.
Null Keys and Values: HashMap allows one null key and multiple null values. HashTable does not allow null keys or values.
Performance: HashMap is generally faster and uses less memory than HashTable due to the lack of synchronization.

4.
In Java, the String Pool is a special memory area in the Heap where strings are stored to improve efficiency and reduce memory overhead. The String Pool allows reusing immutable string objects, reducing the need for creating new objects each time a string is declared, thus saving memory and enhancing performance.

5.
Java garbage collection is an automatic process where the Java Runtime Environment identifies and disposes of objects that are no longer in use to free up memory. This helps in managing memory efficiently and reducing the likelihood of memory leaks in a Java application.

6.
In Java, access modifiers are keywords that set the accessibility of classes, methods, and other members, determining how they can be accessed from other parts of the code. The main access modifiers are public (accessible from any class), protected (accessible within the same package and subclasses), default (no keyword, accessible within the same package), and private (accessible only within the declared class).

7.
Final Field: A final field in Java can be assigned only once and its value cannot be modified, essentially making it a constant.
Final Method: A final method cannot be overridden by subclasses, ensuring that the original implementation remains unchanged.
Final Class: A final class cannot be subclassed, preventing any class from inheriting from it and ensuring its behavior remains consistent.

8.
Static Field: Shared by all class instances, often used for constants.
Static Method: Called without an instance, typically for utility functions.
Static Class: Nested class without enclosing class reference, for logical grouping.
Static keywords are used for shared elements or functionalities independent of class instances.

9.
In Java, overloading happens when two or more methods in the same class have the same name but different parameters (type, number, or both).
Overriding in Java occurs when a subclass provides a specific implementation for a method that already exists in its superclass.

10.
In Java, super refers to the superclass of the current class, allowing access to its methods and constructors, while this refers to the current instance of the class, used for accessing instance variables, methods, and constructors.

11.
In Java, the class loading sequence involves the JVM locating and loading classes, followed by linking which encompasses verification, preparation, and resolution, and concludes with initialization, where static variables and blocks are executed. This process is managed by a hierarchy of class loaders.

12.
Polymorphism in Java allows methods to have multiple forms, implemented via overloading (same method name, different parameters) and overriding (subclass redefines a superclass method).

13.
Encapsulation in Java combines data hiding and abstraction by enclosing data and methods within classes, using access modifiers for security. It enhances data protection, maintainability, modularity, and information hiding.

14.
An interface in Java is a completely abstract class used to define methods that must be implemented by classes; an abstract class can have both abstract and concrete methods. The key difference is that a class can implement multiple interfaces but can only extend one abstract class.

15.
Done in coding questions folder

17.
In Java, Queue interface implementations like LinkedList, PriorityQueue, and ArrayDeque differ in ordering and performance characteristics, with LinkedList for general-purpose queuing, PriorityQueue for ordered retrieval, and ArrayDeque for efficient insertions and deletions at both ends.
