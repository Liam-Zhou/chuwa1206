### Question 1
Generics in Java are a language feature that allows you to write code that can operate on objects of various types while providing compile-time type safety. It's part of Java's type system and is used extensively in the Java Collections Framework.
Coding inside of CodingQuestions Folder

### Question 2
Coding inside of CodingQuestions Folder

### Question 3
Coding inside of CodingQuestions Folder

### Question 4
Coding inside of CodingQuestions Folder

### Question 5
```
public class EagerSingleton {
    private static final EagerSingleton INSTANCE = new EagerSingleton();

    private EagerSingleton() {}

    public static EagerSingleton getInstance() {
        return INSTANCE;
    }
}
```
```
public class LazySingleton {
    private static LazySingleton instance;

    private LazySingleton() {}

    public static synchronized LazySingleton getInstance() {
        if (instance == null) {
            instance = new LazySingleton();
        }
        return instance;
    }
}
```

### Question 6
RuntimeException in Java is an unchecked exception, not checked at compile-time. Examples include NullPointerException, IndexOutOfBoundsException, ArithmeticException.

### Question 7
```
String str = null;
int length = str.length();
```

### Question 8
Optional is a container object used to contain not-null objects. It's a way to avoid null references in Java programs.

### Question 9
Reduces NullPointerException errors.
Provides a clearer and more readable API.
Encourages developers to handle the absence of a value explicitly.

### Question 10
@FunctionalInterface annotation indicates that an interface is intended to be a functional interface, meaning it should have exactly one abstract method.

### Question 11
A lambda expression is a short block of code which takes in parameters and returns a value.

### Question 12
A method reference is a shorthand notation of a lambda expression to call a method. 

### Question 13
1. Lambda Expressions
2. Functional Interfaces
3. Method References
4. Stream API
5. Optional Class
6. New Date and Time API

### Question 14
We can access final or effectively final variables from the enclosing scope.

### Question 15
1. Lambda Expressions simplify the implementation of single method interfaces
2. Functional Interfaces is an interface with exactly one abstract method is termed as a functional interface. 
3. Method References are a shorthand notation of a lambda expression to call a method.
4. Stream API lets us process data in a easy way.
5. Optional class introduced to avoid null references and handle the absence of a value.
6. New Date and Time API addressed the shortcomings of the old java.util.Date and java.util.Calendar.

### Question 16
A functional interface can extend another interface, but it must not have more than one abstract method in total.

### Question 17
A lambda expression provides a concise way to represent an anonymous function. It can be used as an implementation of a functional interface.

### Question 18
Example: System.out::println is equivalent to x -> System.out.println(x).

### Question 19
String::valueOf is a method reference to the valueOf method of the String class. It's used to convert an object to its string form.

### Question 20
Intermediate Operations: Operations that transform a stream into another stream, such as filter, map.
Terminal Operations: Operations that produce a result or a side-effect, such as forEach, reduce, collect.

### Question 21
map
filter
sorted

### Question 22
findFirst() returns the first element of the stream.
findAny() returns any element of the stream.

### Question 23
Collections is a framework that provides an architecture to store and manipulate a group of objects.
Stream is a sequence of elements supporting sequential and parallel aggregate operations, focusing on computation, not storage. Streams don't modify the underlying data structure.
