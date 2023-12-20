> [!NOTE]
> This a markdown file for hw4

## questions solved
- [x] question 1
- [x] question 2
- [x] question 3]
- [x] question 4]
- [x] [question 5](#question-5)
- [x] [question 6](#question-6)
- [x] [question 7](#question-7)
- [x] [question 8](#question-8)
- [x] [question 9](#question-9)
- [x] [question 10](#question-10)
- [x] [question 11](#question-11)
- [x] [question 12](#question-12)
- [x] [question 13](#question-13)
- [x] [question 14](#question-14)
- [x] [question 15](#question-15)
- [x] [question 16](#question-16)

## question 5
```java
public class EagerLoadedSingleton {
    // Create an instance of the class at the time of class loading
    private static final EagerLoadedSingleton INSTANCE = new EagerLoadedSingleton();

    // Private constructor to prevent creating an instance from outside the class
    private EagerLoadedSingleton() {}

    // Public method to provide the global access point to the instance
    public static EagerLoadedSingleton getInstance() {
        return INSTANCE;
    }
}

```
```java
public class LazyLoadedSingleton {
    // Instance of the class, initially null
    private static LazyLoadedSingleton instance;

    // Private constructor to prevent creating an instance from outside the class
    private LazyLoadedSingleton() {}

    // Public method to provide the global access point to the instance
    public static LazyLoadedSingleton getInstance() {
        // Create the instance if it's not already created
        if (instance == null) {
            instance = new LazyLoadedSingleton();
        }
        return instance;
    }
}

```
## question 6
A RuntimeException in Java is a type of **unchecked** exception. 

These exceptions are not checked at compile time.

`NullPointerException`, `ArrayIndexOutOfBoundsException`, `ArithmeticException`, `IllegalArgumentException`

## question 7
```java
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class MyTest {

    @Test
    public void testMethodThatShouldThrowNullPointerException() {
        Object obj = null;
        assertThrows(NullPointerException.class, () -> {
            obj.toString(); // This will throw a NullPointerException
        });
    }
}
```

## question 8
Optional is a container class in Java introduced in Java 8. 
It can contain a non-null value or be empty (contain no value). 
It's a way of expressing optional values in Java without using null.

## question 9
Advantages of Using the Optional Class:
1. Null Safety: Reduces the risk of NullPointerException.
2. More robust APIs where the user is explicitly made aware of the possibility of absent values.
3. Functional Style Operations: Supports operations like map, flatMap, and filter.

## question 10
What is the @FunctionalInterface?

Indicate that an interface is intended to be a functional interface. 
A functional interface is an interface that has **exactly one abstract method.** 

This annotation ensures that the interface adheres to the contract of a functional interface.

## question 11
A lambda expression in Java is a concise representation of an anonymous function that can be passed around. 

It doesn't have a name but has a list of parameters, a body, a return type, and possibly a list of exceptions that can be thrown. 

Lambdas are used primarily to implement functional interfaces.


## question 12
What is Method Reference:
A method reference in Java is a shorthand notation of a lambda expression to call a method. 

It's used to refer directly to a method by name.

## question 13
Java 8 introduced several significant new features:

1. Lambda Expressions: For writing concise and functional-style code.
2. Streams API: For processing collections of objects in a functional style.
3. Optional: A new way of handling nullable values.
4. Default Methods in Interfaces: Allowing new methods in interfaces without breaking existing implementations.
5. Method References: Shorthand syntax for lambda expressions to call methods.


## question 14
lambda expressions can use variables from their enclosing scope, but with a constraint: those variables must be **effectively final**. 

This means:
1. The variable does not need to be explicitly declared as final.
2. The variable must not be modified after initialization, whether it's declared as final or not.

## question 15

## question 16
Can a Functional Interface Extend/Inherit Another Interface?
Yes, a functional interface can extend another interface, but there are conditions:

1. The functional interface must not introduce a new abstract method.
2. If it extends an interface that declares an abstract method, the functional interface must provide an implementation for it.

## question 17
Lambda expressions are often associated with functional interfaces because they provide a succinct way to implement these interfaces without the need for an anonymous class.

## question 18
A method reference in Java 8 is a shorthand notation of a lambda expression to directly refer to a method. It's a compact and easy-to-read way to pass methods as arguments to other methods. Method references can be used anywhere you would use a lambda.

## question 19
String::valueOf is a method reference that refers to the valueOf method of the String class.

## question 20
1. Intermediate Operations: These operations transform a stream into another stream. They are lazy and do not process the elements until a terminal operation is invoked. Examples include map, filter, and sorted.
2. Terminal Operations: These operations produce a result or a side-effect. Once a terminal operation is invoked, the stream pipeline is considered consumed, and it can't be used anymore. Examples include forEach, collect, and reduce.
## question 21
Commonly used intermediate operations include:

1. `map`: Transforms each element using a provided function.
2. `filter`: Selects elements based on a predicate.
3. `sorted`: Sorts the elements.

## question 22
1. `findFirst()`: Returns the first element of the stream.
2. `findAny()`: Returns any element from the stream. This is useful in **parallel streams** as it allows more flexibility in which element is returned.

## question 23
1. Mutability: Collections are about data and storage and can be mutable. Streams are about computations on data and do not store data themselves.
2. Size: Collections have a finite size. Streams can be finite or infinite.
3. Reusability: Collections can be used multiple times. Streams are consumable and can be used only once.
4. Performance: Streams can be more efficient for large datasets, especially with parallel processing.