### 5. Write the Singleton design pattern include eager load and lazy load.

```java
//eager load
Class Singleton{
  private static Singleton instance = new Singleton();
  
  private Singleton(){
    
  }
  public static getInstance(){
    return instance;
  }
}

//lazy load
Class Singleton{
  private Singleton(){
    
  }
  static{
    //do something
  }
  private static Class SingletonHolder{
    private static final Singleton INSTANCE = new Singleton();
  }
  
  public static Singleton getInstance(){
    return SingletonHolder.INSTANCE;
  }
}
```

### 6. What is Runtime Exception? could you give me some examples?

>A runtime exception is an exception that occurs during the execution of a program. Also called unchecked exception.
>
>Examples:  NullPointerException, IndexOutOfBoundsException
>
>

### 7. Could you give me one example of NullPointerException?

```java
public class User {
    String username;
    Address addr;

    //...

    public Address getAddress() {
        return addr;
    }
}
User user = new User();
user.getAddress();
```

### 8. What is the Optional class?

> The `Optional` class is a container class introduced in Java 8 as part of the java.util package. It's used to  avoid Null checks and run time NullPointerExceptions.

### 9. What are the advantages of using the Optional class

>**Avoiding NullPointerException**
>
>**Expressive Code**
>
>**Reduced Need for Null Checks**
>
>**Useful functions like orElse(), isPresent()**

### 10. What is the @FunctionalInterface?

> `@FunctionalInterface` is an annotation in Java introduced with Java 8 to indicate that an interface is intended to be a functional interface. A functional interface is an interface that has exactly one abstract method (SAM - Single Abstract Method). 
>
> The `@FunctionalInterface` annotation is closely related to the use of lambda expressions. Lambda expressions can be used to provide a concise way to implement the single abstract method of a functional interface.

### 11. what is lamda?

> A lambda expression in Java is a concise way to express anonymous functions—functions without a name. Lambda expressions were introduced in Java 8 to support functional programming features, making it easier to write code that is more concise and expressive
>
> ``` java
> (parameters) -> expression
> //or
> (parameters) -> { statements; }
> ```
>
> 

### 12. What is Method Reference

> Method Reference is just a way to simplify Lambda expressions. It is a feature introduced in Java 8 and is often used in conjunction with functional interfaces (interfaces with a single abstract method) and lambda expressions. Method references help to make code more readable and reduce boilerplate code when the method being referenced is straightforward.
>
> **Syntax: `ClassName::MethodName`**

### 13. What is Java 8 new features?

> **Default method and static method in interface**
>
> **Lambda & Functional Interface**
>
> **Method Reference**
>
> **Optional**
>
> **Stream API **

### 14. Lambda can use unchanged variable outside of lambda? what is the details?

> Yes, Lambda can use unchanged variable outside of lambda as long as the address of the variable is unchanged.
>
> * Final variable 
> * Non-final variable however never changed
> *  Object variable (if we use new to reassign a new memory, then this variable is changed, can not be used in lambda)

### 16. Can a functional interface extend/inherit another interface?

> > A functional interface in Java can extend another interface, even if that other interface is also a functional interface, as long as the extending interface doesn't introduce another abstract method.

### 17.  What is the lambda expression in Java and How does a lambda expression relate to a functional interface?

> Lambda expression is a concise way to express anonymous functions. It provides a clear and more readable syntax for writing functional interfaces. Lambda expression can be used to instantiate an object of that a functional interface.
>
> ```java
> @FunctionalInterface
> interface MyFunctionalInterface {
>     void myMethod();
> }
> 
> MyFunctionalInterface myFunction = () -> {
>     System.out.println("Executing myMethod");
> };
> 
> ```

### 18. In Java 8, what is Method Reference?

> Method Reference is just a way to simplify Lambda expressions. It is a feature introduced in Java 8 and is often used in conjunction with functional interfaces (interfaces with a single abstract method) and lambda expressions. Method references help to make code more readable and reduce boilerplate code when the method being referenced is straightforward.
>
> **Syntax: `ClassName::MethodName`**

### 19. What does the String::ValueOf expression mean?

> It's a use of method reference, Specifically, it refers to the `valueOf` method of the `String` class.
>
> The `String::valueOf` method reference is often used as a shorthand for a lambda expression that takes an argument and invokes `String.valueOf` on it. 
>
> ```java
> // Lambda expression
> Function<Integer, String> lambda = (x) -> String.valueOf(x);
> 
> // Method reference
> Function<Integer, String> methodReference = String::valueOf;
> ```
>
> 

### 20&21. What are Intermediate and Terminal operations? What are the most commonly used Intermediate operations?

> They are two stages of a StreamAPI Where intermediate operations are responsible for processing data, terminal operations are reponsible for collecting data.
>
> // Intermediate operations
>
> 1. filter(Predicate p) 
> 2. limit(n) 
> 3.  skip(n) 
> 4.  distinct() 
>
> // Terminal operations
>
> 1. allMatch(Predicate p)
>
> 2. anyMatch(Predicate p) 
>
> 3. noneMatch(Predicate p) 
>
> 4. findFirst 
>
> 5. findAny 
>
> 6. count 
>
> 7. max(Comparator c)
>
> 8. min(Comparator c) 
> 9. collect(Collectors c)

### 22. What is the difference between findFirst() and findAny()?

> **`findFirst()`** returns the first element of the stream. 
>
> **`findAny()`**returns any element of the stream. It is not guaranteed to return the first element, especially in the case of parallel streams. For parallel streams, it may return the first encountered element, but it is not guaranteed due to the nature of parallel processing.

### 23. How are Collections different from Stream?

| COLLECTIONS                                | STREAMS                                                      |
| ------------------------------------------ | ------------------------------------------------------------ |
| Data structure holds all the data elements | No data is stored. Have the capacity to process an infinite number of elements on demand |
| External Iteration                         | Internal Iteration                                           |
| Can be processed any number of times       | Traversed only once                                          |
| Elements are easy to access                | No direct way of accessing specific elements                 |
| Is a data store                            | Is an API to process the data                                |

