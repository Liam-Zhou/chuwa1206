## HW4

#### What is generic in Java?  and type the generic code by yourself.
   
Generics in Java provide a way to create classes, interfaces, and methods with placeholders for data types. This allows you to create more flexible and reusable code by writing classes and methods that can work with any data type. 

```Java
/**
 * Generic class
*/

public GenericClass<T> {
    T obj;
    public GenericClass(T obj) {
        this.obj = obj;
    }   

    public T getObj() {
        return this.obj;
    }

}

/**
 * Generic Method
 * The type parameter is specified before the return type.
*/

public <T extends Comparable<T>> T maximum(T x, T y, T z) {
    T max = x;
    max = (y.compareTo(max) > 0)? y : max;
    max = (z.compareTo(max) > 0)? z : max;
    return max;
} 

/**
 * Multiple generic arguments
*/

public <T1, T2, T3> void temp(T1 x, T2 y, T3 z) {
    System.out.println("This is x = " + x);
    System.out.println("This is y = " + y);
    System.out.println("This is z = " + z);
}

```
#### Read those codes and type it one by one by yourself. the push the code to your branch.
[Click here](../CodingQuestions/coding-java8/)

#### Write the Singleton design pattern include eager load and lazy load. 

```Java
// Eager load
public class Singleton {
    private static Singleton instance = new Singleton();
    private Singleton(){};
    public static Singleton getInstance {
        return instance;
    }
}


// Lazy load
public class Singleton {
    private Singleton(){};
    private static class SingletonHolder {
        private static final Singleton instance = new Singleton();
    }
    public static Singleton getInstance() {
        return SingletonHolder.instance;
    }

}
```
   
#### What is Runtime Exception? could you give me some examples?
   Runtime exceptions are exceptions that are not checked in compile time. E.g `NullPointerException`, `ArrayIndexOutOfBoundsException`
#### Could you give me one example of NullPointerException?
   ```Java
   String str = null;
    // Attempting to invoke a method on a null reference
    int length = str.length(); 
   ```
#### What is the Optional class?
Optional is a class that is designed to represent an optional value that may or may not present. It is helpful to hold values that are nullable and avoid null checks.
#### What are the advantages of using the Optional class?
It is useful for handling situations where a method could return a value or no value (null) and allows you to avoid null checks.
####  What is the @FunctionalInterface?
This is an annotation that indicate that an interface is intended to be a functional interface and the compiler will do sanity check accordingly. 

#### What is lambda?
n Java, a lambda expression is a concise way to express an anonymous function (a function without a name) that can be passed around, especially as an argument to higher-order functions or methods.

#### How does a lambda expression relate to a functional interface?
Lambda expressions are primarily used to define the implementation of a functional interface. The lambda expression allows you to provide the implementation of that single method without explicitly creating a separate class or using anonymous inner classes.

#### What is Method Reference?
Method reference in Java is a shorthand notation that allows you to refer to methods or constructors using a concise syntax. It simplifies the lambda expressions further when the lambda expression's sole purpose is to call a method. Method references enable you to reuse existing methods or constructors without explicitly writing a lambda expression.

#### What are Java 8 new features?
- Lambda expressiom
- Functional interfaces
- Optional class
- Stream API
- Default methods
- Method references
- Java Time API
  
#### Lambda can use unchanged variable outside of lambda? what is the details?
Only if the address of the varibale is never changed, it can be used by lambda. This includes:
- Final variable
- Non final variable but has never changed
- Object variable that has never reassigned

#### Can a functional interface extend/inherit another interface?
Yes based on the rule of Single Abstract Method. A functional interface must have exactly one abstract method. If an interface extends another interface with exactly one abstract method, the derived interface is still considered a functional interface.

#### What does the String::ValueOf expression mean?
It is a method reference that refers to the `valueof` method in the String class. It converts data type to their String version.
#### What are Intermediate and Terminal operations?
Intermediate operations are operations that transform a stream into another stream. They are executed lazily, which means they are not evaluated until a terminal operation is invoked on the stream.

Terminal operations are operations that produce a result or a side effect. When a terminal operation is invoked on a stream, it triggers the processing of the stream elements.
#### What are the most commonly used Intermediate operations?
- map
- filter
- flatMap
- dinstint
- sort
- limit
- skip
#### What is the difference between findFirst() and findAny()?
findFirst() returns the first element of the stream while findAny() returns any one of the elements of the stream
####  How are Collections different from Stream?
Collections are containers that are for data storage while Stream is for data processing without any functionality of storing data. 