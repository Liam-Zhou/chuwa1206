# HW4

## Q5 Write the Singleton design pattern include eager load and lazy load.

Eager Load 1:

```
public class SingletonEager1 {
    private SingletonEager1(){};

    private static SingletonEager1 instance = new SingletonEager1();

    public static SingletonEager1 getInstance(){
        return instance;
    }
}
```

Eager Load 2:

```
public class SingletonEager2 {
    private SingletonEager2(){};

    private static SingletonEager2 instance;

    static {
        instance=new SingletonEager2();
    }

    public static SingletonEager2 getInstance(){
        return instance;
    }
}
```

Lazy Load 1:

```
public class SingletonLazy1 {
    private SingletonLazy1(){};

    private static SingletonLazy1 instance;

    public static synchronized SingletonLazy1 getInstance(){
        if (instance==null){
            instance = new SingletonLazy1();
        }
        return instance;


    }
}
```

Lazy Load 2:

```
public class SingletonLazy2 {

    private SingletonLazy2(){};

    private static volatile SingletonLazy2 instance;

    public static SingletonLazy2 getInstance(){
        if(instance==null){
            synchronized (SingletonLazy2.class){
                if(instance==null){
                    instance=new SingletonLazy2();
                }
            }
        }
        return instance;
    }
}
```

Lazy Load 3:

```
public class SingletonLazy3 {
    private SingletonLazy3(){};

    private static class SingletonHolder{
        private static final SingletonLazy3 INSTANCE =new SingletonLazy3();
    }

    public static SingletonLazy3 getInstance(){
        return SingletonHolder.INSTANCE;
    }
}
```




## Q6 What is Runtime Exception? could you give me some examples?
A **RuntimeException** in Java is an unchecked exception, meaning it doesn't need to be declared in a method's throws clause. It usually indicates a programming error, such as accessing a null object, going out of array bounds, or dividing by zero.

- **NullPointerException**: Thrown when attempting to use a null reference.
- **ArrayIndexOutOfBoundsException**: Accessing an array with an illegal index.
- **ArithmeticException**: Exceptional arithmetic conditions like dividing by zero.
- **IllegalArgumentException**: Passing an illegal argument to a method.

## Q7 Could you give me one example of NullPointerException?

```
public class NullPointerExceptionExample {
    public static void main(String[] args) {
        Integer number = null;
        
        int value = number.intValue()
    }
}
```

In this example, attempting to call intValue() on a null Integer object number leads to a NullPointerException.

## Q8 What is the Optional class?

The **Optional** class in Java is a container for a value that may be present or absent. It's used to avoid **NullPointerException** by providing methods to explicitly handle the presence or absence of a value. Key methods include:
- Optional.of()
- Optional.empty()
- Optional.ofNullable(value)
- isPresent()
- ifPresent()
- orElse()
- orElseThrow()

## Q9 What are the advantages of using the Optional class?

The **Optional** class is used for elegantly handling values that might be null, thereby avoiding **NullPointerExceptions** and making the code more concise and readable. It clearly represents the potential absence of a value, reducing the need for null checks and enhancing code clarity.

## Q10 What is the @FunctionalInterface?

The **@FunctionalInterface** annotation in Java designates an interface as a functional interface, meaning it must have **exactly one abstract method**. This is important for lambda expressions and a functional programming approach. The annotation helps in code clarity and ensures that the interface adheres to the functional interface contract.

## Q11 what is lamda?

A **lambda** expression in Java is a concise way to represent a function interface using an expression. It provides a clear and concise way to implement a method of a functional interface, allowing methods to be used as arguments and enabling functional programming style.

## Q12 What is Method Reference?

A **Method Reference** in Java is a **shorthand notation** of a **lambda** expression to call a method. It's used to refer directly to a method by name. Method references enhance code readability and conciseness, especially when a lambda expression simply calls an existing method.

## Q13 What is Java 8 new features?

- **Lambda Expressions**: For concise, functional programming.
- **Streams API**: For processing collections of objects in a functional style.
- **Optional**: To better handle null values.
- **Method References**: Shorter syntax for lambda expressions calling methods.
- **Default Methods**: Allowing methods in interfaces with default implementations.
- **New Date-Time API**: Inspired by Joda-Time, addressing shortcomings of old date/time APIs.
- **Nashorn JavaScript Engine**: A new engine to run JavaScript code within Java applications.
- **Type Annotations**: Enhanced type checking by allowing annotations in more places.
- **Improvements in Collections API and Concurrency**: Including new methods in the ConcurrentHashMap class.
- **New tools like jjs, jdeps**: For JavaScript scripting and analyzing dependencies.

## Q14 Lambda can use unchanged variable outside of lambda? what is the details?

In Java lambda expressions, a variable can be used if its memory address **does not change**. This includes:

- **Final Variables**: Variables explicitly declared as final.

- **Non-final but Effectively Final Variables**: Variables that are not declared as final but whose values are not changed after initialization.

- **Object Variables**: Object references can be used in lambdas as long as they don't get reassigned to new objects. If new is used to reassign a new memory address, then the variable is considered changed and cannot be used in the lambda.

## Q15 Describe the newly added features in Java 8?
Please refer to Question 13

## Q16 Can a functional interface extend/inherit another interface?
Yes, a functional interface can extend another interface, but the **resulting interface must still have exactly one abstract method**. This means it can extend interfaces with default or static methods, or another functional interface, as long as it does not introduce a new abstract method.

## Q17 What is the lambda expression in Java and How does a lambda expression relate to a functional interface?

A lambda expression in Java is a concise way to represent a functional interface's single abstract method using an arrow syntax (->). It provides a simpler way to implement interfaces with only one abstract method, allowing for more readable and concise code. A lambda expression essentially creates an instance of a functional interface, directly linking the two concepts.

## Q18 In Java 8, what is Method Reference?
Please refer to Question 12

## Q19 What does the String::ValueOf expression mean?
The expression **String::valueOf** is a **method reference** in Java. It refers to the valueOf method of the String class.

## Q20 What are Intermediate and Terminal operations? 

In the context of Java Streams API:

- **Intermediate Operations**: Operations that transform a **stream** into **another stream**, such as filter, map, and sorted. They don't start processing the data **until a terminal operation is invoked**.

- **Terminal Operations**: Operations that produce a **non-stream result**, such as forEach, collect, reduce, and sum. Once a terminal operation is performed, the stream can **no longer be used**.

## Q21 What are the most commonly used Intermediate operations?

- **filter**: Used to filter elements based on a given predicate.
- **map**: Transforms each element in the stream to another element using a given function.
- **flatMap**: Flattens a stream of collections/arrays into a single stream of elements.
- **distinct**: Removes duplicates from the stream based on the object's equals method.
- **sorted**: Sorts the elements of the stream.

## Q22 What is the difference between findFirst() and findAny()?

- **findFirst()**: Returns the first element encountered in the stream. It's typically used with ordered streams to find the first element according to the encounter order.

- **findAny()**: Returns any element encountered in the stream. It's more suitable for parallel streams where order doesn't matter, and it can provide better performance in parallel processing.

## Q23 How are Collections different from Stream?

Collections are data structures for storing and managing objects with mutability, while Streams are a way to process data declaratively, often in a lazy and parallelizable manner, without modifying the source data. Streams are suitable for data transformation, while collections are for data storage and modification.
