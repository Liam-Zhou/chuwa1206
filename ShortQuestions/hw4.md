# Q1

Generics in Java are a powerful feature that allows you to write code that is flexible and type-safe. They were introduced in Java 5 to enhance the language's type system. Here are the key aspects of generics:

- Type safety
- Code Reusability
- Elimination of Cast
- Enforcing Type Constraints
- Generic Classes, Interfaces, and Methods
- Bounded Type Parameters
- WildCards

# Q5

Singleton Eager Load:

```java
public class EagerSingleton {
    private static final EagerSingleton INSTANCE = new EagerSingleton();
    private EagerSingleton() {}
    public EagerSingleton getInstance() {
        return INSTANCE;
    }
}
```

Lazy Load:

```java
public class LazySingleton {
    private LazySingleton() {};
    private static class SingletonHandler {
        private static final LazySingleton INSTANCE = new LazySingleton();
    }
    public LazySingleton getInstance() {
        return SingletonHandler.INSTANCE;
    }
}
```

# Q6

Runtime exceptions are exceptions that are thrown at runtime. Runtime exceptions indicate programming errors, such as logic mistakes or improper use of an API. Some examples are NullPointerException, IndexOutofBoundsException, BufferOverflowException.

# Q7

```java
String text = null;
System.out.println(text.length());
```

# Q8

Optional is a container object which may or may not contain a non-null value.

# Q9

Advantages of using the Optional class:

- Explicitness and Readability: Object can contain null, so less null checks
- Null Safety: Developers can use methods in Optional to deal with null checks more elegantly.
- API design
- Functional Programming Support
- Better Control over Data Flow
- Integration with Streams API
- Reduces Boilerplate Code

# Q10

@FunctionalInterface itself is a annotation that asks compiler to check if the interface marked by this annotation follow the rules of Functional Interface.

Functional Interface is an interface with one and only one abstract method.

# Q11

Lambda is a new feature introduced in Java 8. A lambda expression is a short block of code which takes in parameters and returns a value. Lambda is the implementation of the abstract method. It serves as shortcut for anonymous class. By pairing with functional interface, programmers can you lambda instead of anonymous class to achieve functional programming.

# Q12

Method references are a special type of lambda expressions. It is a shorthand notation of a lambda expression to call a method. They’re often used to create simple lambda expressions by referencing existing methods.
There are four kinds of method references:

- Static methods
- Instance methods of particular objects
- Instance methods of an arbitrary object of a particular type
- Constructor

# Q13

Java 8 new features includes:

- Default method and static method in Interface
- Lambda
- Method Reference
- Stream
- Optional
- Java Time API
- forEach() method in Iterable interface
- Collection API improvements
- Concurrency API improvements
- Java IO improvements

# Q14

Lambda can use unchanged variable outside of lambda. However, that variable has to be either final or effective final. This means that the variable cannot be modified after it has been assigned a value, within the scope where the lambda is defined.

# Q15

Java 8 new features includes:

- Default method and static method in Interface
- Lambda
- Method Reference
- Stream
- Optional
- Java Time API
- forEach() method in Iterable interface
- Collection API improvements
- Concurrency API improvements
- Java IO improvements

# Q16

Yes. A functional interface can extend/inherit another interface. It can extend other interfaces so long as it adhere to the following scenarios:

- Extending Another Functional Interface Without Adding Abstract Methods
- Extending a Non-Functional Interface that does not have abstract method
- Overriding the Abstract Method of the Super Interface

# Q17

Lambda is a new feature introduced in Java 8. A lambda expression is a short block of code which takes in parameters and returns a value. Lambda is the implementation of the abstract method in functional interface. It serves as shortcut for anonymous class. By pairing with functional interface, programmers can you lambda instead of anonymous class to achieve functional programming.

# Q18

Method references are a special type of lambda expressions. It is a shorthand notation of a lambda expression to call a method. They’re often used to create simple lambda expressions by referencing existing methods.
There are four kinds of method references:

- Static methods
- Instance methods of particular objects
- Instance methods of an arbitrary object of a particular type
- Constructor

# Q19

`String::valueOf` is a method reference that refer to the static method `valueOf` in `String` class.

# Q20

- Intermediate operations are operations that transform a stream into another stream. These operations are lazy, meaning they don't perform any processing until a terminal operation is invoked.
- Terminal operations are operations that produce a non-stream result. Once a terminal operation is performed, the stream pipeline is considered consumed and can no longer be used.

# Q21

Commonly used intermediate operations includes `filter`, `limit`, `skip`, `distinct`, `map`, `flatMap`, `sort`

# Q22

`findFirst()` find the first element in the stream, whereas `findAny()` returns any element in the stream.

# Q23

- Collections serves as containers. It contains data.
- Stream process data. It does not contain data nor change the data of the source.

- A more detailed version would be:

| Collections                            | STREAMS                                                                                       |
| -------------------------------------- | --------------------------------------------------------------------------------------------- |
| Data structures holds all the elements | TitleNo data is stored. Have the capacity to process an infinite number of elements on demand |
| External Iteration                     | Internal Iteration                                                                            |
| Can be processed any number of times   | Travered only once                                                                            |
| Elements are easy to access            | No direct way of accessing specific elements                                                  |
| Is a data store                        | Is an API to process the data                                                                 |
