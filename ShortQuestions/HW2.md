1. Write up Example code to demonstrate the three foundmental concepts of OOP. 
	1. Encapsulation;
		```java
		class Person{
			private int age;
			private String name;
		}
		
		public void setAge(int age){
			this.age = age;
		}

		public void setName(String name){
			this.name = name;
		}

		public int getAge(){
			return this.age;
		}


		public String getName(){
			return this.name;
		}
		```
	2. Polymorphism;
		```java
		//Overload
		public int addNumber(int a, int b){
		    return a + b;
		}
		
		public double addNumber(double a, double b){
		    return a + b;
		}
		//Override
		class Prof extends Person{
		    @Override
			public String getName(){
				return "Prof. " + this.name;
			}
		}
		```
	3. Inheritance; 
		```Java
		Class Prof extends Person{
		}

		Person dr = new Prof();
		dr.getAge();
		dr.getName();
		```

2. What is wrapper class in Java and Why we need wrapper class?
	In Java, a wrapper class is a class that encapsulates primitive data types and provides objects of those types. 
	The primitive data types (like int, char, float, etc.) are not objects, but sometimes we need to use objects, such as when working with collections (like ArrayList or HashMap) that can only store objects. Wrapper classes provide a way to use primitive data types as objects.
	
3. What is the difference between HashMap and HashTable?
	1. **Thread Safety:**
	    - **HashMap:** Not thread-safe by default.
	    - **Hashtable:** Thread-safe but can be slower due to synchronization.
	2. **Null Values:**
	    - **HashMap:** Allows one null key and multiple null values.
	    - **Hashtable:** Does not allow null keys or values.
	3. **Performance:**
	    - **HashMap:** Generally faster, especially in a single-threaded environment.
	    - **Hashtable:** Can be slower due to synchronization, impacting performance.

4. What is String pool in Java and why we need String pool?
	In Java, the String pool is a special area in the heap memory that stores a pool of string literals. When you create a string using double quotes, Java checks the pool to see if an identical string already exists. If it does, the existing string is reused instead of creating a new one, thereby reducing memory load and improving performance.


5. What is Java garbage collection?
In Java, when we create objects, the computer sets aside memory for them. But when you're done using an object, Java doesn't make you clean up that memory yourself. Instead, it has a garbage collector that automatically finds and gets rid of the stuff you're not using anymore.Garbage collection in Java helps simplify memory management and reduces the likelihood of memory leaks.

6. What are access modifiers and their scopes in Java?
	1. **`public`:**
	    - Everyone can access it.
	2. **`protected`:**
	    - Only in the same package or by subclasses.
	3. **Default (no modifier):**
	    - Only in the same package.
	4. **`private`:**
	    - Only in the same class.

7. What is final key word? (Filed, Method, Class)
	**`final` for Variables:**
	- If a variable is declared as `final`, its value cannot be modified (it becomes a constant).
	**`final` for Methods:**
	- If a method is declared as `final` in a class, it means that subclasses cannot override that method.
	**`final` for Classes:**
	- If a class is declared as `final`, it means that it cannot be extended (no subclasses can be created).

8. What is static keyword? (Filed, Method, Class). When do we usually use it?
	**`static` for Variables (Static Fields):**
	- A static variable belongs to the class rather than instances of the class. There is only one copy of a static variable shared among all instances of the class.
	**`static` for Methods (Static Methods):**
	- A static method is associated with the class rather than instances of the class. It can be called without creating an instance of the class.
	**`static` for Classes (Static Nested Classes):**
	- A static nested class is a nested class that is associated with the outer class, and it can be instantiated without creating an instance of the outer class.

	**When to Use `static`:**

	1. **Constants:** When you have values that should remain constant for all instances of a class, you can declare them as `static` variables.
	2. **Utility Methods:** When you have methods that perform a specific task and don't rely on instance-specific data, you can declare them as `static` methods.
	3. **Shared Resources:** When a resource (e.g., a counter, database connection) needs to be shared among all instances of a class, you can use `static` variables.

9. What is the differences between overriding and overloading?
	- **Involvement of Classes:**
	    - Overloading occurs within the same class.
	    - Overriding occurs in a subclass that extends a superclass.
	- **Method Signature:**
	    - Overloading is based on having different parameter lists.
	    - Overriding is based on having the same method signature (name, return type, and parameters).
	- **Inheritance:**
	    - Overloading is not dependent on inheritance.
	    - Overriding is specifically related to inheritance and polymorphism.
	-  **Types of Polymorphism:**
		- Overloading - Compile-time Polymorphism
		- Overriding - Run-time Polymorphism

10. What is the differences between super and this?
- `this` refers to the current instance of the class and is used in instance methods or constructors.
- `super` refers to the superclass and is used in instance methods or constructors to access members of the superclass.

11. What is the Java load sequence?
	The Java load sequence refers to the order in which Java classes and objects are loaded, initialized, and instantiated.
	1. **Loading:**
	    - Java classes are like blueprints for objects.
	    - When you run a Java program, the classes it needs are loaded into memory.
	2. **Linking:**
	    - The loaded classes are checked to make sure they are okay (verification).
	    - Memory is prepared for variables (preparation).
	    - Symbolic references are replaced with actual references (resolution).
	3. **Initialization:**
	    - The class is now ready to be used.
	    - Static blocks and variables are set up.

12. What is Polymorphism ? And how Java implements it ?
	Polymorphism allows a single interface or method to be used for objects of various types, providing a way to work with different objects through a common interface.
	There are two types of polymorphism:
	1. **Compile-time Polymorphism (Method Overloading):**
		 - Occurs when multiple methods in the same class have the same name but different parameter lists.
		- The correct method is determined by the compiler based on the method signature during compile-time.
	2. **Run-time Polymorphism (Method Overriding):**
		- Occurs when a subclass provides a specific implementation for a method that is already defined in its superclass.
		- The correct method is determined at runtime based on the actual type of the object.
		- Requires a superclass and subclass relationship. 

13. What is Encapsulation ? How Java implements it? And why we need encapsulation?
	**Encapsulation**  refers to the bundling of data (attributes) and methods (functions) that operate on the data into a single unit known as a class. It involves restricting direct access to some of an object's components and only allowing access through the object's methods.
	In Java, encapsulation is implemented using access modifiers and getter/setter methods. Here's how it works:
	1. **Access Modifiers:**
	    - Java provides access modifiers (`private`, `protected`, `default`, `public`) to control the visibility of classes, variables, and methods.
	    - `private`: Limits access to only within the same class.
	    - `protected`: Allows access within the same package and by subclasses.
	    - `default` (no modifier): Allows access within the same package.
	    - `public`: Allows access from any class.
	2. **Getter/Setter Methods:**
	    - Encapsulation encourages the use of getter methods to retrieve the values of private variables and setter methods to modify them.
	    - This allows for controlled access to the internal state of an object.
	
	**Why Encapsulation?**
	1. **Data Hiding:**
	    - Encapsulation hides the internal details of an object from the outside world.
	    - Users of the class interact with it through a well-defined interface (public methods), without needing to know the internal implementation.
	2. **Security:**
	    - Private variables and methods ensure that sensitive information is not directly accessible from outside the class.
	3. **Controlled Access:**
	    - Getter and setter methods provide controlled access to the internal state of the object, allowing validation and business logic to be applied.


14. What is Interface and what is abstract class? What are the differences between them?
	**Interface:**
	- **Definition:**
	    - An interface in Java is a collection of abstract methods (methods without a body) and constant variables.
	    - It defines a contract for classes that implement it, specifying the methods they must provide.

	**Abstract Class:**
	- **Definition:**
	    - An abstract class in Java is a class that cannot be instantiated on its own and may contain abstract methods.
	    - It can have both abstract and concrete (implemented) methods.

	**Differences:**
	
	1. **Usage:**
	    - Use an interface when you want classes to promise to have certain methods.
	    - Use an abstract class when you want to provide a common base for several related classes with some shared functionality.
	2. **Instantiation:**
	    - You can't create an instance (object) of an interface or an abstract class by itself.
	3. **Methods:**
	    - In an interface, methods are all promises (abstract).
	    - In an abstract class, you can have a mix of promises (abstract methods) and things the class already knows how to do (concrete methods).
	4. **Variables:**
	    - In an interface, variables are like public constants (always the same).
	    - In an abstract class, you can have instance variables (things that can vary).

15. design a parking lot.
		See details in codingQuestions


16. What are Queue interface implementations and what are the differences and when to use what?
  
	In Java, the `Queue` interface is a part of the Java Collections Framework and represents a collection of elements with a specific order for processing. A queue is a linear data structure that follows the First-In-First-Out (FIFO) order, where the element that is added first is the one that is removed first.
	
	Here are some commonly used implementations of the `Queue` interface in Java and their key differences:
	
	**LinkedList:**
	- **Features:**
	    - Allows null elements.
	    - Implements a doubly-linked list, making it efficient for adding and removing elements from both ends.
	- **When to Use:**
	    - Use when you need a general-purpose queue and want fast insertion and deletion at both ends.
	
	**PriorityQueue:**
	- **Features:**
	    - Elements are ordered based on their natural ordering or by a comparator provided at queue construction time.
	    - Does not allow null elements.
	    - Provides a priority-based ordering.
	- **When to Use:**
	    - Use when you need a queue with elements ordered by priority.
	
	**ArrayDeque:**
	- **Features:**
	    - Resizable-array implementation.
	    - Allows null elements.
	    - Supports fast insertion and removal from both ends.
	- **When to Use:**
	    - Use when you need a double-ended queue (Deque) that allows efficient insertion and removal at both ends.
	
	**ConcurrentLinkedQueue:**
	    - **Features:**
	        - Concurrent and non-blocking.
	        - High concurrency for both enqueue and dequeue operations.
	    - **When to Use:**
	        - Use in high-performance scenarios where concurrent access is required without explicit synchronization.
	
	**LinkedBlockingQueue:**
	    - **Features:**
	        - Designed for multithreaded environments.
	        - Implements blocking operations (`put` and `take`) for scenarios where the queue might be full or empty.
	    - **When to Use:**
	        - Use in scenarios where blocking operations are required, such as producer-consumer patterns.
	        - Suitable for applications where the queue size can grow dynamically.
	    
	**ArrayBlockingQueue:**
	    - **Features:**
	        - Similar to `LinkedBlockingQueue` but uses an array to store elements.
	        - Implements blocking operations for scenarios where the queue might be full or empty.
	    - **When to Use:**
	        - Use in scenarios where blocking operations are required and you prefer a fixed-size array-based queue.
	        - Suitable for applications with fixed and known capacity requirements.