# hw2: hw20-java&oop

### 1: Write up Example code to demonstrate the three fundamental concepts of OOP.
- Encapsulation: Encapsulating data and methods within a class, using private fields and public getters/setters.
- Polymorphism: Implementing method overriding and interface implementation to allow objects to take many forms.
- Inheritance: Creating subclasses that inherit properties and behaviors from a parent class, promoting code reuse.
[link](https://github.com/Liam-Zhou/chuwa1206/tree/diana_men/hw2/CodeQuestions/coding1/OOP)

### 2: What is a wrapper class in Java and why do we need a wrapper class?
- Wrapper classes convert primitive types (like int, char) to objects. They are needed for collections and utilities that operate on objects.

### 3: What is the difference between HashMap and HashTable?
- HashMap: Not thread-safe, faster, allows one null key and multiple null values.
- HashTable: Thread-safe, slower, does not allow null keys or values.

### 4: What is the String pool in Java and why do we need a String pool?
- The String pool stores unique strings. It conserves memory by avoiding duplicate string objects.

### 5: What is Java garbage collection?
- Java's garbage collection automatically manages memory, freeing space occupied by objects that are no longer in use.

### 6: What are access modifiers and their scopes in Java?
- Private: Restricted to the current class.
- Protected: Accessible within the same package and subclasses.
- Public: Accessible from any class.
- Package-Private: Accessible only within the same package.

### 7: What is the final keyword? (Field, Method, Class)
- Final keyword prevents modification: variables can't be changed, methods can't be overridden, classes can't be subclassed.

### 8: What is the static keyword? (Field, Method, Class) When do we usually use it?
- Static elements belong to the class, not instances. Used for constants, utility methods, or shared properties.

### 9: What are the differences between overriding and overloading?
- Overloading: Same name, different parameters. Doesn't depend on inheritance.
- Overriding: Same name, same parameters. Used in subclass to modify parent class behavior.

### 10: What are the differences between super and this?
- This: Refers to the current object instance.
- Super: Refers to methods and constructors of the parent class.

### 11: What is the Java load sequence?
- Loading: Class is loaded by ClassLoader.
- Linking: Verifies, prepares, and optionally resolves references.
- Initialization: Executes static initializers and static initialization blocks.

### 12: What is Polymorphism? And how does Java implement it?
- Polymorphism: Objects can take multiple forms. Implemented through method overloading (compile-time) and overriding (runtime).

### 13: What is Encapsulation? How does Java implement it? And why do we need encapsulation?
- Encapsulation hides internal states, using private fields and public accessors. It ensures better control and security over data.

### 14: What is an Interface and what is an abstract class? What are the differences between them?
- Interface: Only abstract methods. Implements multiple inheritance.
- Abstract Class: Can have abstract and concrete methods. Single inheritance.

### 15: Design a parking lot (put the code to codingQuestions/coding1 folder).

#### VehicleSize (Enum)
- Categories: SMALL, MEDIUM, LARGE
- Purpose: Define sizes for vehicles.

#### Vehicle (Class)
- Attributes: licensePlate, size, color, model, brand, parkingDuration
- Methods: startParking(), endParking()
- Purpose: Represent vehicles with size, color, and other details.

#### Car (Subclass of Vehicle)
- Inherits Vehicle
- Purpose: Represent a car with medium size.

#### Motorcycle (Subclass of Vehicle)
- Inherits Vehicle
- Purpose: Represent a motorcycle with small size.

#### ParkingSpot (Class)
- Attributes: vehicle, spotNumber, size
- Methods: parkVehicle(), removeVehicle(), isAvailable()
- Purpose: Manage individual parking spots with size and availability.

#### ParkingLot (Class)
- Attributes: array of ParkingSpots
- Methods: parkVehicle(), removeVehicle()
- Purpose: Organize and manage parking spots, handle vehicle parking and removal.

#### TestParkingLot (Main Class)
- Purpose: Demonstrate functionality of the parking lot system.

[link](https://github.com/Liam-Zhou/chuwa1206/tree/diana_men/hw2/CodeQuestions/coding1/ParkingLot)

### 16: What are Queue interface implementations and what are the differences and when to use what?
- LinkedList: Doubly-linked list. Good for frequent insertions and deletions.
- PriorityQueue: Orders elements based on priority. Useful when objects need to be processed based on priority.
- ArrayDeque: Array-based deque, efficient for resizable-array implementation of the Deque interface.
- ConcurrentLinkedQueue: Thread-safe, uses non-blocking algorithm, suitable for high-concurrency applications.
- LinkedBlockingQueue: Optionally bounded, blocks on operations when empty or full, suitable for producer-consumer scenarios.

