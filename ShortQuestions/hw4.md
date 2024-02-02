# hw4: hw23-java8
### Question 1: Generics in Java
What is Generic in Java?
Generics in Java are a framework that allows different types to be used as parameters in class, interface, or method definitions. They provide compile-time type safety and eliminate the need for casting, making code more robust and readable.    	

[link](https://github.com/Liam-Zhou/chuwa1206/tree/diana_men/hw4/CodingQuestions/hw4/generic)

### Question 2: Read those codes and type it one by one by yourself. the push the code to your branch.

[link](https://github.com/Liam-Zhou/chuwa1206/tree/diana_men/hw4/CodingQuestions/hw4/t06_java8/features)

### Question 3: practice stream API at least 3 times

[link](https://github.com/Liam-Zhou/chuwa1206/tree/diana_men/hw4/CodingQuestions/hw4/stream_api)

### Question 4: Practice Optional methods at least 2 times

[link](https://github.com/Liam-Zhou/chuwa1206/tree/diana_men/hw4/CodingQuestions/hw4/t06_java8/exercise)

### Question 5: Singleton Design Pattern
Write the Singleton design pattern include eager load and lazy load.
#### Eager Load Singleton in Java:
```java
public class SingletonEager {
    private static final SingletonEager instance = new SingletonEager();
    private SingletonEager() {}
    public static SingletonEager getInstance() {
        return instance;
    }
}
```
#### Lazy Load Singleton in Java:
```java
public class SingletonLazy {
    private static SingletonLazy instance;
    private SingletonLazy() {}
    public static SingletonLazy getInstance() {
        if (instance == null) {
            instance = new SingletonLazy();
        }
        return instance;
    }
}
```

### Question 6: Runtime Exception
What is Runtime Exception? could you give me some examples?
Runtime exceptions are unchecked exceptions that occur during program execution and are not required to be caught or declared in a method's throws clause.
1. NullPointerException - Occurs when trying to use an object reference that has the null value.
```java
String text = null;
int length = text.length(); // Throws NullPointerException
```
2. ArrayIndexOutOfBoundsException - Happens when trying to access an array element with an illegal index (either negative or beyond the array size).
```java
int[] numbers = {1, 2, 3};
int number = numbers[3]; // Throws ArrayIndexOutOfBoundsException
```
3. ArithmeticException - Occurs during arithmetic operations like division by zero.
```java
int result = 10 / 0; // Throws ArithmeticException
```

### Question 7: NullPointerException Example
Could you give me one example of NullPointerException?
```java
String text = null;
int length = text.length(); // Throws NullPointerException
```

### Question 8: Optional Class
What is the Optional class?
The `Optional` class in Java 8 is a container object which may or may not contain a non-null value. It's used to avoid `NullPointerException`. It offers methods like `isPresent()` and `ifPresent()` to deal with values that may be absent.

### Question 9: Advantages of Using Optional
What are the advantages of using the Optional class?
- Avoiding `NullPointerException`.
- Writing cleaner code by avoiding excessive null checks.
- Providing a more expressive way to handle absent values, especially with methods like `orElse()` and `orElseGet()`.

### Question 10: @FunctionalInterface Annotation
What is the @FunctionalInterface?
`@FunctionalInterface` annotation indicates that an interface is intended to be a functional interface, having exactly one abstract method.

### Question 11: Lambda Expressions
what is lamda?
Lambda expressions enable functional programming in Java, allowing concise representation of methods as expressions.

### Question 12: Method Reference
What is Method Reference?
Method references are a shorthand notation of lambda expressions to directly reference methods by their names.

### Question 13: Java 8 New Features
What is Java 8 new features?
- Lambda expressions for more concise and flexible code.
- Functional Interfaces, an interface with a single abstract method.
- Stream API for bulk data operations on collections.
- New Date and Time API for improved date-time manipulation.

### Question 14: Lambda and Unchanged Variables
Lambda can use unchanged variable outside of lambda? what is the details?
Lambda expressions can capture and use final or effectively final local variables from the enclosing scope.

### Question 15: Newly Added Features in Java 8
Describe the newly added features in Java 8?
- Lambda expressions for concise and functional programming.
- Method references to directly refer methods by their names.
- Stream API for efficient processing of collections.
- Default methods in interfaces to add new functionalities to existing interfaces.
- New Date/Time API.

### Question 16: Functional Interface Inheritance
Can a functional interface extend/inherit another interface?
A functional interface in Java 8 can inherit from another interface, provided it doesn’t add any new abstract methods. Inheritance can be used to create a rich hierarchy of functional interfaces.

### Question 17: Lambda Expression and Functional Interface
What is the lambda expression in Java and How does a lambda expression relate 
to a functional interface?
Lambda expressions are primarily used to provide the implementation of the abstract method defined in a functional interface. This allows for more concise and flexible code, especially for single-method interfaces.

### Question 18: Method Reference in Java 8
In Java 8, what is Method Reference?
Method references in Java 8 are a shorthand notation of a lambda expression to directly call a method. They are used to refer to methods by their names and are particularly useful for simplifying the syntax of lambda expressions.

### Question 19: String::valueOf Expression
What does the String::ValueOf expression mean?
`String::valueOf` is a method reference to the `valueOf` method of the `String` class. It's used to convert different types of values into a String. It's a more concise way to write a lambda expression for converting an object to a string.

### Question 20: Intermediate and Terminal Operations
What are Intermediate and Terminal operations?
In Java 8 Streams, intermediate operations are those that return another Stream, such as `map`, `filter`, and `sorted`. Terminal operations produce a non-stream result, such as a value or a side-effect, like `forEach`, `collect`, and `reduce`.

### Question 21: Common Intermediate Operations
What are the most commonly used Intermediate operations?
- `map`: Transforms each element of the stream.
- `filter`: Filters elements based on a predicate.
- `sorted`: Sorts the elements of the stream.

### Question 22: Difference Between findFirst() and findAny()
What is the difference between findFirst() and findAny()?
In Java 8 Streams, `findFirst()` returns the first element of the stream, whereas `findAny()` returns any element of the stream. `findAny()` is generally used in parallel stream operations where the order is not important.

### Question 23: Collections vs Stream
How are Collections different from Stream?
Collections in Java are primarily about storing and accessing data, whereas Streams are about describing computation on data. Streams don't store elements, allowing for more efficient processing especially in large datasets. Streams also support functional-style operations like map and filter.

