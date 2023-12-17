## 1. What is Runtime Exception?
RuntimeException in Java is a subclass of Exception. These are unchecked exceptions, meaning they don't need to be declared or handled in a method's throws clause. Examples include NullPointerException, ArrayIndexOutOfBoundsException, ArithmeticException, etc.

## 2. What is Runtime Exception?
`String str = null;
int length = str.length(); `
This line will throw a NullPointerException because str is null.

## 3. What is the Optional Class?
Optional in Java is a container class in java.util package used to represent an object which may or may not contain a non-null value. It's a safer alternative to null references.

## 4. Advantages of Using the Optional Class
Reduces the risk of NullPointerException.
Makes code cleaner as there's no need to explicitly check for nulls.
Enhances code readability.
Can express the absence of a value, where null was traditionally used.

## 5. What is the @FunctionalInterface?
@FunctionalInterface is an annotation that indicates that an interface is intended to be a functional interface. Functional interfaces are interfaces that have exactly one abstract method and are used as the basis for lambda expressions in functional programming

## 6. What is Lambda?
A lambda expression is a short block of code which takes in parameters and returns a value. Lambda expressions are similar to methods, but they do not need a name and can be implemented right in the body of a method.

## 7. What is Method Reference?
Method reference is a shorthand notation of a lambda expression to call a method. For example, System.out::println is a method reference that refers to the println method of the System.out object.

## 8. Java 8 New Features
Lambda Expressions
Stream API
Method References
Optional Class
New Date and Time API
Default and Static Methods in Interfaces

## 9. Lambda and Unchanged Variables
Variables used in lambda expressions must be final or effectively final (i.e., their values do not change after initialization). This is because lambda expressions capture variables, not their values.

## 10. Java 8 New Features


## 11. Can a Functional Interface Extend/Inherit Another Interface?
Yes, a functional interface can extend another interface, but it must not introduce more than one abstract method in total, maintaining the contract of a functional interface.

## 12. Lambda Expression and Functional Interface
Lambda expressions are essentially instances of functional interfaces. A functional interface is an interface with a single abstract method, which the lambda expression implements.

## 13. Method Reference in Java 8
Method reference is a feature of Java 8 that allows you to use methods as lambda expressions. It is used to refer directly to a method without executing it.

## 14. String::valueOf Expression
String::valueOf is a method reference to the valueOf static method in the String class. It can be used to convert an object or a primitive type to a string.

## 15. Intermediate and Terminal Operations
Intermediate operations: Operations on streams that return a new stream, such as filter, map, and sorted.
Terminal operations: Operations that close the stream and produce a result, such as collect, forEach, reduce.

## 16. Commonly Used Intermediate Operations
filter(): Filters elements according to a predicate.
map(): Transforms elements using a function.
sorted(): Sorts elements based on a comparator or natural ordering.

## 17. Difference Between findFirst() and findAny()
findFirst(): Returns the first element from a stream.
findAny(): Returns any element from a stream, useful in parallel operations.

## 18. Collections vs Stream
Collections are about data and are in-memory data structures that hold elements within them. They are primarily concerned with efficient management and access to their elements.
Streams are about computations on data and focus more on expressive ways to handle, process, and manipulate data using various operations.








