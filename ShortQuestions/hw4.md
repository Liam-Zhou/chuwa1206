### 1. what is generic in Java (code in coding 3 folder)
it is a set of related methods or a set of similar types. Generics allow types Integer, String, or even user-defined types to be passed as a parameter to classes, methods or interfaces.
### 2. code in coding3/t06_java/feature folder
### 3. code in coding3/exercise/streamExercise
### 4. code in coding3/exercise/optionalExercise
### 5. code in coding3/exercise/Singleton
### 6. What is Runtime Exception
Runtime exceptions are internal to the application but are not typically recoverable. RuntimeException is the superclass of those exceptions that can be thrown during the normal operation of the JVM.
It is the unchecked exception. For example, NullPointerException is a runtime exception.
### 7. example of NullPointerException
```
StringBuilder sb = null;
System.out.println(sb.toString());
// it will throw a NullPointerException.
```
### 8. Optional class
Optional is a container object used to contain not-null objects. It is used to represent null with absent value.
### 9. advantages of using Optional class
Optional class allows we to use it without wrapping the data to avoid the null check with some try-catch blocks, which as a result allow people to use the chain method calls and more fluent, functional code.
### 10. @FunctionalInterface
It is an informative annotation type used to indice that an interface type declaration is intended to be a functional interface as defined by the Java Language Specification. The functional interface has exactly one abstract method.
### 11. what is lambda
Lambda expression is a short block of code which takes in parameters and returns a value, it is similar to a method, but it doesn't need a name and it can be implemented right in the body of a method.
### 12. Method Reference
Method Reference is used to refer method of the functional interface, it is a compact and easy form of a lambda interface.
### 13. Java 8 new features
- Interface can have static and default methods that despite being declared in an interface, have a defined behavior.
- Method Reference can be used as a shorter and more readable alternative for a lambda expression that only calls an existing method.
- Optional class can help handle situations where there is a possibility of getting the NullPointerException. It can return a value of this object if this value is not a null, and when the value is null, it allows doing some predefined actions instead of throwing the NullPointerException.
### 14. Lambda can use unchanged variable outside of lambda?
Yes, the local variables declared outside of the lambda should be final or effectively final.
### 15. The newly added features in Java 8
- Interface can have static and default methods that despite being declared in an interface, have a defined behavior.
- Method Reference can be used as a shorter and more readable alternative for a lambda expression that only calls an existing method.
- Optional class can help handle situations where there is a possibility of getting the NullPointerException. It can return a value of this object if this value is not a null, and when the value is null, it allows doing some predefined actions instead of throwing the NullPointerException.
### 16. Can a functional interface extend/inherit another interface?
The functional interface can extend another interfaces only when it does not have any abstract method.
### 17. what is lambda expression, how does it relate to a functional interface
Lambda expression is a short block of code which takes in parameters and returns a value, it is similar to a method, but it doesn't need a name and it can be implemented right in the body of a method. The lambda expression is used to provide the implementation of an interface which has functional interface. In case of lambda expression, we don't need to define the method again for providing the implementation.
### 18. what is method reference
Method Reference is used to refer method of the functional interface, it is a compact and easy form of a lambda interface.'
### 19. what does the String::ValueOf expression mean
It means use the ValueOf() function in String class.
### 20. Intermediate and terminal operations
- Intermediate operations transform or filter elements in a stream, returning a new stream.
- Terminal Operations give the end result and stop the stream.
### 21. mostly commonly used Intermediate operations
filter, map, flatMap, distinct, sorted, and limit
### 22. findFirst() vs findAny() 
findFirst() always return the first elements in the stream that matched the given criteria, findAny() returns any element that matched the criteria.
### 23. Collections vs Stream
The collections are used to store data while Stream does not store data.


