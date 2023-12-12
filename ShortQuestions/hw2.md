
# HW 2

## 1. Write up Example code to demonstrate the three foundmental concepts of OOP. (reference Code Demo repo as example)

    1. Encapsulation;
    2. Polymorphism;
    3. Inheritance;

 ```java
// Vehicle class demonstrating Encapsulation
class Vehicle {
    private String brand;

    public Vehicle(String brand) {
        this.brand = brand;
    }

    public String getBrand() {
        return brand;
    }
}

// Car class demonstrating Inheritance
class Car extends Vehicle {
    private int numberOfDoors;

    public Car(String brand, int numberOfDoors) {
        super(brand);
        this.numberOfDoors = numberOfDoors;
    }

    public void drive() {
        System.out.println("Driving the car");
    }
}

// Bicycle class demonstrating Polymorphism
class Bicycle extends Vehicle {
    private int numberOfGears;

    public Bicycle(String brand, int numberOfGears) {
        super(brand);
        this.numberOfGears = numberOfGears;
    }

    public void pedal() {
        System.out.println("Pedaling the bicycle");
    }
}

// Example usage
public class VehicleExample {
    public static void main(String[] args) {
        // Encapsulation
        Vehicle vehicle = new Vehicle("Generic");
        System.out.println("Vehicle brand: " + vehicle.getBrand());//vehicle brand cannot be changed, since we only have the setter but do not have setter.

        // Inheritance
        Car car = new Car("Toyota", 4);
        System.out.println("Car brand: " + car.getBrand());// in car class we do not have getBrand() method, but it inhritaced from it's parents class
        System.out.println("Number of doors: " + car.getNumberOfDoors());
        car.drive();

        // Polymorphism
        Vehicle v1 = new Bicycle("Trek", 18);
        Vehicle v2 = new Car("Honda", 2);
        v1.move();//output move() in Bicycle
        v2.move();//output move() in Car
    }
}
```

Explanation:

1. **Encapsulation:**
   - The `Vehicle` class encapsulates the concept of a generic vehicle and its brand. The `getBrand` method is used to access the private `brand` attribute, demonstrating encapsulation.

2. **Inheritance:**
   - The `Car` class inherits from the `Vehicle` class, indicating an "is-a" relationship. It inherits the brand attribute from `Vehicle` and extends it with additional properties like `numberOfDoors` and a method to drive.

3. **Polymorphism:**
   - Both `Car` and `Bicycle` classes have override the `move()` method of `Vehicle`, which mean they even their type if Vehicle, but they got their own way to move.

## 2. What is wrapper class in Java and Why we need wrapper class?

In Java, a wrapper class is a class that provides an object representation for primitive data types. In Java, the primitive data types (such as `int`, `char`, `float`, etc.) are not objects, and they do not belong to the class hierarchy. Wrapper classes provide a way to convert primitive data types into objects, allowing them to be included in activities reserved for objects, like being added to collections or participating in object-oriented concepts.
In java, a wrapper class wrapp primitve type into object, such as int -> Integer, double -> Double.
The wrapper classes in Java are as follows:

1. **Integer**
2. **Byte**
3. **Short**
4. **Long**
5. **Float**
6. **Double**
7. **Character**
8. **Boolean**

### Why we need wrapper classes:

1. **Object Required:**
   - In Java, collections (like `ArrayList`, `HashMap`) work with objects, and they cannot store primitive data types directly. Wrapper classes provide a way to work with primitive types in the context of objects.

2. **Null Values:**
   - Wrapper classes allow the assignment of `null` values to variables. For example, an `int` cannot be `null`, but `Integer` (the wrapper class for `int`) can.

3. **more powerful:**
   - In wrapper class, it also have some `method()` implemented which often useful.

4. **Methods in Collections:**
   - Many utility methods in the `Collections` class deal with objects. Using wrapper classes allows primitive types to be used seamlessly in these methods.

## 3. What is the difference between HashMap and HashTable?

 1. **HashMap is not thread safe, but hashTable is thread safe.**
    1. But Hashtable using Sychhronized, it is not very efficent. while, we also have ConcurrentHashMap which is using partial lock to achieve thread safe, and it is more efficent.
    2. usually HashMap is more efficent than HashTable since it is not thread safe. 
 2. **HashMap map allow Null as key and value, but HashTabes does not allow null key or value.**
 3. **HashMap's iterator is fail-fast, but HashTable's is not. (fail fast means after the itertor was created, if the content or the structor or the collections is changed, it will throw an ConcurrentModificationException.)**
 4. 

## 4. What is String pool in Java and why we need String pool?

String pool in java is a pool of stored strings in heap memory. We can treat is as constant of string. When we try to creat a `string` jvm will check the pool first, the jvm will allocate a new string only if there is match in the current pool. 

why we need String pool.

1. improve the Effiecienc of memoery by reuse the common string, instead creating new one every time.
2. improve security. since in java string is immutable, it is safe to share the reference to the same string without worry about modification.

## 5. What is Java garbage collection?

Garbage Collection is a mechanism provided by the Java Virtual Machine (JVM) garbage collector to reclaim memory occupied by objects that no longer have any references during periods of idle time.
there is some method of how JVM do the GC.
    1. reference counting. - jvm keep counting the number of reference of every object. if number of reference is 0, GC will do the collection later on.
    2. tracin collector. from the GC root, try to reach the object, if a object is not reachable, will do the GC later.

## 6. What are access modifiers and their scopes in Java?
Access modifiers are used to determine the visibility or accessibility of a class, method or varibale. it is a fundation of encapsulation.
|access modifier|descript|
|---------------|--------|
|public|accessbile from any other class|
|private|only within the same class|
|protect|same package or subclass in different package|
|Default|same package|

## 7.  What is final key word? (Filed, Method, Class)

`final`keyword can be used to varibale, method, or class, it means no further modification, overrident, or extended. 
    1. **Final variable:** creat a constant.
    2. **Final method:** method cannot be overriden, this will prevent modification of the method.
    3. **final class:** not extended. it prevent other class from inheriting from it.  

## 8.  What is static keyword? (Filed, Method, Class). When do we usually use it?

`static` can be used to field, method, and inner class.
   **1. static fields:** it means the field belongs to the class but not to any instance, in other word, all instance share the same static field.

   **2. static method:** it means the method belongs to the class but not any instance of the class. static methods can be called using class name and do not need creation of an instance.

   **3. static class:** it usually used as nested inner class. This means that innner class is associated with the outter class, but not with any specific instance of the outter class.

### when do we use static?

- when do we need the `initiation` some thing, such as connect of db. thingk of singleton of db connection.
- usually `constant` value associated with class but not instance.
- `static block`, when we need initialize something.

## 9.  What is the differences between overriding and overloading?

- `overloading` happens at the samle class. When two or more method have same name but different parameter. it is complie time,
- `overriding` happend at inheritance when a subclass has its own implimentation of the same method from super class. The overriding method must have the same function signature with the super class.
  
## 10.  What is the differences between super and this?

- `super:` refers to supperclass of current class, it can invoke the supperclass's method.
- `this:` refers to current class, it usually used to differentiate parameter variable and filed variable.
- 
## 11. What is the Java load sequence?

1. `loading:`class loader will load classes into JVM. *classes will be loaded only if they are needed - think of lazy load*
2. `linking`: 
   1. `verification:` ensure class file is structurally correct.
   2. `preparation:` Allocat memory.
   3. `resolution:` direct reference to the method or feild names. 

3. `initialization:` initialize static fields and static blocks.
   - The sequence for loading classes is as follows: the base class is loaded first, and after the base class is loaded, the subclass is loaded.
   - The sequence for initialization is as follows: the base class is initialized first, and after the base class is initialized, the subclass is initialized.

## 12. What is Polymorphism ? And how Java implements it ?

`Polymorphism` is one of the three major features of object-oriented programming, along with encapsulation and inheritance. From a certain perspective, encapsulation and inheritance are almost preparations for polymorphism. This is the last concept, and also the most important one.

The definition of polymorphism: It refers to allowing objects of different classes to respond to the same message. In other words, the same message can be responded to in different ways depending on the type of the sending object. (Sending a message is equivalent to a function call). In simple terms, it means using a reference to the base class to point to an object of a subclass.

The technique of polymorphism is called dynamic binding, which means that during execution, the actual type of the referenced object is determined. Based on its actual type, the corresponding method is called.

**Prerequisites for Polymorphism:**

1. There must be an inheritance relationship.
2. There must be method overriding.
3. There must be a reference to the base class pointing to an object of the subclass.


## 13. What is Encapsulation ? How Java implements it? And why we need encapsulation?

`Encapsulation` is a concept in object-oriented programming that involves privatizing the attributes of an object while providing public methods that can be accessed by the outside world. If certain attributes are not intended to be accessed directly from external sources, we can choose not to provide methods for external access. In java, the `Encapsulation` is enforced by access modifiers.

Using encapsulation provides three key benefits:

1. **Reduced Coupling:**
   - Encapsulation minimizes dependencies between system components, reducing the impact of changes in one part on others.

2. **Flexible Internal Modification:**
   - The internal structure of a class can be freely modified without affecting external code, enhancing codebase maintainability.

3. **Precise Control Over Members:**
   - Encapsulation allows precise control over member access and modification through defined interfaces.

4. **Information Hiding:**
   - Encapsulation hides implementation details, exposing only necessary information and simplifying system complexity.

## 14. What is Interface and what is abstract class? What are the differences between them?

| Feature              | Abstract Class                      | Interface                                   |
|----------------------|-------------------------------------|---------------------------------------------|
| **Instantiation**    | Cannot                               | Cannot                                     |
| **Multiple Inheritance** | One per class                      | Multiple interfaces possible               |
| **Constructors**     | Can have constructors               | Cannot have constructors                   |
| **Data Members**     | Can have private data members       | Public static final constants, no fields   |
| **Methods**          | Can have private, non-abstract methods | All methods are public and abstract        |
| **Variables**        | Can have private, redefinable variables | Public static final, cannot be redefined  |
| **Design Purpose**   | Represents "is-a" relationship       | Represents "like-a" relationship            |
| **Implementation**   | Requires `extends` keyword           | Requires `implements` keyword               |

## 15. design a parking lot (put the code to codingQuestions/coding1 folder, )

*See code codingQuestions/coding1 folder*

## 16. What are Queue interface implementations and what are the differences and when to use what?

1. `LinkedList:` FIFO.
2. `PrioritQueue:` customized priority or by nature order.
3. `ArrayDeque:` can be used both as queue or stack. but not thread safe.

*usage:*

1. `linkedList:` when need frently modification of both end of the queue.
2. `priorityqueue:` when we have different `weight` for each item. by nature ordering or customized.
3. `ArrayDeque:` it is recommaned by java doc of queue. we can use it both as queue or stack. In other word, use arrayDeque if we need fast insertion and removals, especially from both ends.

