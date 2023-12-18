# Homework 4



## 1 What is generic in Java?



- In Java, generics refer to a feature that allows you to write classes, interfaces, and methods that can work with different data types while providing compile-time type safety.

- The main benefits of generics in Java include:
  
  1. **Type Safety:** Generics provide compile-time type checking, which helps catch type-related errors at compile time rather than at runtime. 
  
  2. **Code Reusability:** With generics, you can write classes and methods that operate on a variety of data types, promoting code reuse. This is especially useful in creating data structures (e.g., collections) that can work with elements of any type.
  
  3. **Elimination of Type Casting:** Generics reduce the need for explicit type casting, making the code more readable and less error-prone.



## 5 Write the Singleton design pattern include eager load and lazy load



```java
// eager load Singleton
public class Singleton {
    // 1. private static variable
    private static Singleton instance = new Singleton();
    // 2. make constructor private
    private Singleton() {}
    // 3. static getInstance method
    public static Singleton getInstance() {
        return instance;
    } 
}

// lazy load Singleton
public class Singleton {
    private Singleton() {}
    
    static {}
    
    private static class SingletonHolder {
        private static final Singleton INSTANCE = new Singleton();    
    }
    
    public static Singleton getInstance() {
        return SingletonHolder.INSTANCE;    
    }
}
```



## 6 What is Runtime Exception? Could you give some examples?



- Exceptions that happened at runtime. Runtime exceptions are also called unchecked excpetions

- Examples of Runtime Exceptions: NullPointerException(NPE), IndexOutOfBoundsException (e.g. List/Array)



## 7 Could you give one example of NullPointerException?



A `NullPointerException` occurs in Java when you attempt to access or invoke a method on an object that is `null`



```java
public class NullPointerExceptionExample {
    public static void main(String[] args) {
        String str = null;

        try {
            // Attempting to get the length of a null string
            int length = str.length(); // This line will throw NullPointerException
            System.out.println("Length of the string: " + length); // This line won't be reached
        } catch (NullPointerException e) {
            System.out.println("NullPointerException caught!");
            e.printStackTrace();
        }
    }
}

```



## 8 What is Optional Class?



- Optional is a kind of container object to avoid null checks and runtime NullPointerExceptions



## 9 What are the advantages of using the Optional class?



- More elegently and safely to check possible null values.

- Avoid null checks and runtime NullPointerExceptions

- Make code clean and easy to read



## 10 What is the @FunctionalInterface?



- In Java, `@FunctionalInterface` is an annotation that indicates that an interface is intended to be a functional interface. 

- A functional interface is an interface that has only one abstract method (SAM - Single Abstract Method).

- The `@FunctionalInterface` is an optional annotation which will make the compiler generate an error if an interface marked with it doesn't satisfy the condition of having exactly one abstract method.



## 11 What is Lambda?



- In Java, a lambda expression is a concise way to express instances of functional interfaces. 

- Lambda expressions enable you to treat functionality as a method argument, create more readable and concise code, and facilitate the use of functional programming constructs.

- The main objective of lambda is:
  
  - To replace anonymous inner-class 
  
  - Work with a functional interface



## 12 What is Method Reference?



- Method Reference is basically a syntax sugar(simplified syntax) of Lambda.

- Method references can make your code more readable by providing a compact way to express certain types of operations.



## 13 What are Java 8 new Features?



- default method and static method for interfaces

- Lambda and functional interface

- Optional

- Stream API

- CompletableFuture



## 14 Can Lambda use unchanged variable outside of lambda? what are the details?



- Yes, as long as the variable is unchanged(its memory address is unchanged in the code block)

- Specifically of unchanged:
  
  - final variable is definitely unchanged 
  
  - non-final variable which has not been assigned a new value or use any method to change its value
  
  - object variable that are not assigned new memory addreass. For example, if we  use a set method to change the value the memory address is pointing to, the object itself is considered unchanged, however, if we use "new" keyword to create a new object and assign it to the object variable, the memory address is changed



## 15 Describe the newly added features in Java 8



- Default method and static method is allowed in interfaces

- Lambda is introduced to replace anonymous function and work with functional interface which allow us to treat function as a method argument

- Optional: an container object to avoid null checks and runtime NullPointerExceptions

- Stream API: a new pipeline to process data in a speicific data structure e.g. data in Collections. It allow us to process original source data and collect the results into a new collection.



## 16 Can a functional interface extend/inherit another interface?



- Yes, but a functional interface can extends another interface only when it **does not have any abstract method**



## 17 What is the lambda expression in Java and How does a lambda expression relate to a functional interface?



- A functional interface is an interface that has only one abstract method (SAM - Single Abstract Method).

- Lambda can considered as the implementation of the abstract method



## 18 In Java 8, what is Method Reference?



- Same as Q12.



## 19 What does the String::ValueOf expression mean?



- It is the syntax of method reference, specifically it refers to the `valueOf` method in the `String` class.

- The method referecen is often used in the context of functional interfaces, it is a syntax sugar of lambda expression, for example we can use `String::valueOf` to replace `x -> String.valueOf(x)`



## 20 What are Intermediate and Terminal operations?



- They are part of the Stream API pipeline, the intermediate operations are used to filter, map, or sort the stream after it is created. The terminal operations are used to match, reduce or collect the processed results from the Stream API pipeline. 



## 21 What are the most commonly used Intermediate operations?



- filter, limit, skip, distinct, peek, map, mapToDouble, mapToInt, mapToLong, flatMap, sorted



## 22 What is the difference between findFirst() and findAny()?



- `findFirst()` returns the first element of the stream while `findAny()` doesn't

- The difference mainly shows up in the parallel processing situation, while `findAny()` not necessary returns the first element but has better performances.





## 23 How are Collections different from Stream?



- Collections are more of the data side, it is responsible to store the data, while Stream is more of the computation side, it is responsible to process data.

- Collections have data structure that holds all the data elements while no data is stored in Streams

- Collections need external iteration while streams has internal iteration

- Collections can be processed any number of times while streams are traversed only once

- Elements are easy to access in Collections while there are no direct way of accessing specific elements in Streams
