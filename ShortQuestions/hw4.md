# HW4

## Q1. What is generic in Java? and type the generic code by yourself
Java Generics provides a way to reuse the same code with different inputs.
Advantages:
- Generics provide compile-time type safety that allows programmers to catch invalid types at compile time.
- When using Generics, there is no need of type-casting.
- By using generics, programmers can implement generic algorithms that work on collections of different types, can be customized and are type safe and easier to read.


## Q2. Read those codes and type it one by one by yourself. Then push the code to your branch

## Q3. Practice stream API at least 3 times

## Q4. Practice Optional methods at least 2 times

## Q5. Write the Singleton design pattern include eager load and lazy load.

Eager Load
```
public class Eager{
	private Eager(){};

	private static final Eager eager = new Eager();

	public static getEager(){
		return eager;
	}
}
```

Lazy Load
```
public class Lazy{
	priavte final static lazy;

	private static fianl Lazy = new Lazy();

	public getLazy(){
		if (lazy == null){
			lazy = new Lazy();
		}
		return lazy;
	}
}
```

## Q6. What is Runtime Exception? could you give me some examples?
A Runtime Exeception is a uncheked exception. Compiler does not force the programmer to handle runtime exceptions. E.g. NullPointerException, ArithmeticException, ArrayIndexOutOfBoundException, etc.

## Q7. Could you give me one example of NullPointerException?
```
public class Test{
	public void main(String[] args){
		String str = null;

		try{
			int len = str.length;
		}catch (NullPointerException e){
			System.out.println("Caught a NullPointerException!");
            e.printStackTrace();
		}
	}
}
```

## Q8. What is the Optional class?
The `Optional` class in Java is a container object which may or may not contain a non-null value. The primary purpose of `Optional` is to provide a type-level solution for representing optional values instead of using `null`. This can help in avoiding `NullPointerException` and improves the readability and maintainability of the code by providing a clear and explicit way to deal with the presence or absence of a value. 


## Q9. What are the advantages of using the Optional class?
- **Improved Code Readability**: `Optional` makes your code more readable by explicitly handling the case of absence of a value.

- **Null Safety**: `Optional` helps to avoid `NullPointerException`.

- **Functional Programming Style**: `Optional` supports various methods for functional-style operations, like `map`, `flatMap`, `filter`, and `ifPresent`, which makes it easy to perform transformations and actions on the value if it is present. 

- **Default Values and Actions**: `Optional` provides methods like `orElse`, `orElseGet`, and `orElseThrow`, allowing default actions and values to be specified cleanly if the `Optional` is empty.

## Q10. What is the @FunctionalInterface?
The `@FunctionalInterface` annotation is used to indicate that an interface is intended to be a functional interface. A functional interface is an interface that contains exactly one abstract method. These interfaces are used as the basis for **lambda expressions** in Java's functional programming features.

## Q11. What is lamda?
A `lambda` is a concise way to represent an anonymous function. Lambda expressions are particularly useful when implementing functional interfaces. The basic syntax of a lambda expression is `(parameters) -> {body}`

## Q12. What is Method Reference?
Method references in Java are a feature that allows you to reference methods or constructors in a more concise way, often used in conjunction with lambda expressions and functional interfaces. The general syntax of a method reference is: `Object::methodName`.

## Q13. What is Java 8 new features?
- Lambda Expressions
- Streams API
- Functional Interfaces
- Method References
- Default Methods
- Optional Class
- New Date and Time API

## Q14. Lambda can use unchanged variable outside of lambda? what is the details?
Yes, lambda can use unchanged variable outside of lambda. Specifically, lambda expressions can capture instance variables, static variables, local variables.

## Q15. Describe the newly added features in Java 8?
- Lambda Expressions: lambda expressions brought a new syntax element that allows for clearer and more concise representation of single method interfaces (functional interfaces). 
- Streams API: A new abstraction called Stream that allows processing sequences of elements (like collections) in a functional style.
- Functional Interfaces: Functional interfaces are those that contain exactly one abstract method.
- Method References: Method references provide a way to refer to methods by their names and are used to create compact, easy-to-read lambda expressions for methods that already have a name.
- Default Methods: Interfaces in Java 8 can have default methods with implementation. 
- Optional Class: The `Optional` class was introduced to avoid `NullPointerException` and to provide a clear and explicit way to deal with the absence of a value.
- New Date and Time API: A new comprehensive and immutable Date-Time API.

## Q16. Can a functional interface extend/inherit another interface?
Yes, a functional interface in Java can extend another interface, but there are specific rules governing this:
1. **Maintaining a Single Abstract Method**: The key rule for a functional interface is that it must have exactly one abstract method. This rule must still be satisfied even when one functional interface extends another. 
	- **Inherit the Single Abstract Method**: If the parent interface has one abstract method, and the child interface does not declare any new abstract methods, the child interface is still a functional interface.
	- **Override the Abstract Method**: If the child interface provides a concrete (default or static) implementation of the parent interface's abstract method, it can declare a new abstract method and remain a functional interface.
2. **Inheriting from Non-Functional Interfaces**: A functional interface can also extend a non-functional interface as long as it provides default or static implementations for all but one of the abstract methods it inherits, effectively leaving it with a single abstract method.

3. **Inheriting from Multiple Interfaces**: If a functional interface inherits from multiple interfaces, it must still ensure that there is only one abstract method in total across all the interfaces it extends.

## Q17. What is the lambda expression in Java and How does a lambda expression relate to a functional interface?
Lambda expressions are a concise way to represent an anonymous function. They can be used to implement interfaces with a single abstract method, also known as functional interfaces.
The basic syntax of a lambda expression is: `(argument list) -> {body}`. Here is an example of using lambda in functional interface:
```
// Using an anonymous class
Comparator<String> stringComparator = new Comparator<String>() {
    @Override
    public int compare(String s1, String s2) {
        return s1.compareTo(s2);
    }
};

// Using a lambda expression
Comparator<String> stringComparatorLambda = (s1, s2) -> s1.compareTo(s2);
```


## Q18. In Java 8, what is Method Reference?
A method reference is a feature that provides a way to refer directly to a method without executing it. The general syntax of a method reference is: `ClassName::methodName`, or `instance::methodName`.

## Q19. What does the String::ValueOf expression mean?
`String::valueOf` is a method reference. It refers to the `valueOf` static method of the `String` class, which is the `String.valueOf` method.

## Q20. What are Intermediate and Terminal operations?
- **Intermediate operations**: Intermediate operations are operations that transform a stream into another stream. They are lazy, meaning they do not start processing the data when they are called. Instead, they just create a new stream by defining the operation, and actual computation on the data is only performed when a terminal operation is initiated. E.g. `map`, `filter`, `distinct`, `limit`, `skip`.

- **Terminal Operations**: Terminal operations are operations that close the stream. When a terminal operation is called, it triggers the processing of the data, and after the terminal operation is performed, the stream cannot be used anymore. E.g. `forEach`, `collect`, `reduce`,`findFirst`, `findAny`.

## Q21. What are the most commonly used Intermediate operations?
`map`, `filter`, `distinct`, `limit`, `skip`

## Q22. What is the difference between findFirst() and findAny()?
Both `findFirst()` and `findAny()` are terminal operations that return an `Optional` describing an element of the stream.
- **findFirst()**: This method returns the first element of the stream. In a sequential stream, it will return the first element according to the encounter order of the stream. Use `findFirst()` when the order matters.
- **findAny()**: This method returns any element from the stream. In a sequential stream, it will likely return the first element, but there's no guarantee of this. Use `findAny()` when the order does not matter, and you are working with parallel streams. 

## Q23. How are Collections different from Stream?
- Collections
	- Storage: Collections are primarily about storing and accessing data. They are in-memory data structures that hold elements.
	- Eager Construction: Elements in collections are computed eagerly, meaning all elements are stored in memory and can be accessed and modified at any time.
	- Iterative Processing: Collections support iterative operations, typically using loops like for, forEach, or iterator patterns.
	- Data Manipulation: Collections allow you to add, remove, or modify elements directly.
	- Repeated Access: You can iterate over a collection as many times as you want.

- Streams
	- Computation: Streams are about expressing computations over sequences of elements. They do not store data themselves.
	- Lazy Execution: Stream operations are computed lazily, meaning computation on the elements doesn’t start until the result of the processing is actually needed.
	- Functional-Style Operations: Streams encourage a functional programming style, using methods like map, filter, reduce.
	- Non-Interference: Streams are designed for a "use once" approach. Once a terminal operation is performed on a stream, it is considered consumed and cannot be used again.
	- Parallelism: Streams facilitate easy parallelization of operations, which can lead to more efficient processing.





