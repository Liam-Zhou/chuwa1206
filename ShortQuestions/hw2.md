# HW2

## Q1. foundmental concepts of OOP

```java
/* Encapsulation example
Encapsulation avoid exposing internal control logic or data to users. Instead it requires developers to build a nice interface with which the software can interact with users.
*/
public class player{
	//private int diamond;
	public int getDiamondNum(){
		// Read from database, or private field
        // return num;
	}
    public void updateDiamond(){
        //update database or private field
        return;
    }
}

/* Polymorphism example
Polymorphism allow the same object to have various behavior, thus provide more flexibility and expanability to the program.

Polymorephism is mainly achieved by overload(static polymorphism) and override(dynamic polymorphism)
*/
public class calculator{
    public int add(int a, int b){
		return a + b;
    }
    
    public double add(double a, double b){
		return a + b;
    }
}

public class crazy_calculate extends calculator{
    @Override
    public string add(int a, int b){
        return String.valueOf(a + b);
    }
}


/* Inheritance example
Inheritance contibute to reusability of code and extensibility by gathering common attribuites and methods in base class, and use subclass to inherite it.
*/
public class Animal{
    private power;
    private IQ;
    Animal(int power, int IQ){
        this.power = power;
        this.IQ = IQ;
    }
    public void eat(){
    	// pass
    }
}

public class Human extends Animal{
    public class think(){
        //pass
    }
}

public class Monkey extends Animal{
    public class climb(){
        //pass
    }
}



```





## Q2. What is wrapper class in Java and Why we need wrapper class?

Wrapper class are encapsulation of the primitive types. There're eight types of wrapper class for eight primitive types. Primitive types are not objects. But by using wrapper class, primitive types can then act as object, equipped with more support functions, and more fit Java OOD pattern.



## Q3. What is the difference between HashMap and HashTable?

They are both used to store key value pairs. The main difference is first HashMap is not synchronized, thus not thread-safe, while HashTable is thread safe. This results in better speed of HashMap. Second is HashMap support one null key and multiple null values, while HashTable does not support any null type.



## Q4. What is String pool in Java and why we need String pool?

String pool is an area in heap memory, where some strings are stored there with hash. When trying to create a string variable without new, instead of allocate new space for that, jvm first check if there're existing one in the string pool. If yes, then only a new reference is created. This save spaces. Also it saves time when doing comparison because when two reference are same, we can skip value comparison.



## Q5. What is Java garbage collection?

JVM provide a machanism that constantly looking for heap memory that stores some objects but no longer reachable, and reclaim those space.



## Q6. What are access modifiers and their scopes in Java?

There're four types of access modifier, public, protected, default and private, with scope in descending order. Public member is accessible from all package and class. Protected member is accessible from same package and subclasses. Default (no keyword, different from default keyword) is accessible from same package. Private is accessible only from self.



## Q7. What is final key word? (Field, Method, Class)

Final field: const

Final method: cannot be override

Final class: Cannot be inherited, and make class immutable.



## Q8. What is static keyword? (Field, Method, Class). When do we usually use it?

static field: this field is the only shared one among all class object

static method: can be called through class name, instead of class object

static class: In nested class, the inner class doesn't require access to instance-specific data, then define it as static



static member is loaded when JVM classloader loads classes. static fields are stored in JVM method area.



## Q9. What is the differences between overriding and overloading?

Overload: different function signature, happen in compile time, refer to functions in same class

Override: same function signature, happen in runtime, refer to functions in base and sub class



## Q10. What is the differences between super and this?

This refers to the current object.

Super refers to the immediate parent class, often used to explicitly invoke parent class function or field.



## Q11. What is the Java load sequence?

First static fields and blocks are loaded according to the order of code. Non static ones will be loaded after object is created.



## Q12. What is Polymorphism ? And how Java implements it ?

See Q1 comment. In java polymorphism is implemented through override, overload, abstract class and interface.



## Q13. What is Encapsulation ? How Java implements it? And why we need encapsulation?

See Q1 comment. It is implemented through acess modifier and getter setter.



## Q14. What is Interface and what is abstract class? What are the differences between them?

Abstract class is a special type of class, using *class* and *abstract* keyword. Abstract class methods can be implemented or not. Subclass of an abstract class must implement all abstract methods. Abstract class can have constructor, but cannot be instantiated.

Interface is not a class. It use *interface* keyword. Normally interface can only contain abstract functions, but after java8, default, static, and private methods in interface can have implementation. Interface cannot have constructor. interface can extends interface, class can implement interface.



## Q15. coding



## Q16. What are Queue interface implementations and what are the differences and when to use what?

LinkedList: Basic

PriorityQueue: ranked in certain order

ArrayDeque: can push and pop on both end

BlockingQueue: in concurrent situation