## 1. What is generic in Java? and type the generic code by yourself.

Generics refer to a feature that allows you to write classes, interfaces, and methods with placeholders for data types. These placeholders are known as type parameters, and they provide a way to create classes and methods that operate on objects of any type. GGenerics in Java provide compile-time type safety, which means that the type information is verified at compile time rather than at runtime. Generics enable you to design reusable and type-safe code by allowing you to specify the type of data that a particular class or method can work with.
## 2. Read those codes and type it one by one by yourself. the push the code to your branch.

See in CodeQuestion.

## 3. practice stream API at least 3 times

See in CodeQuestion.

## 4. Practice Optional methods at least 2 times

See in CodeQuestion.

## 5. Write the Singleton design pattern include eager load and lazy load.

Eager Load:
```java
public class EagerSingleton {
    // Eagerly creating an instance of the class
    private static final EagerSingleton instance = new EagerSingleton();


    private EagerSingleton() {
    }

    public static EagerSingleton getInstance() {
        return instance;
    }


}

```

Lazy Load:
```java
//double-check
public class LazySingleton {
    // Volatile ensures visibility of the instance across threads
    private static volatile LazySingleton instance;

    private LazySingleton() {
    }

    public static LazySingleton getInstance() {
        if (instance == null) {
            synchronized (LazySingleton.class) {
                if (instance == null) {
                    instance = new LazySingleton();
                }
            }
        }
        return instance;
    }

}

```

## 6. What is Runtime Exception? could you give me some examples?
  
A runtime exception in Java is a type of exception that occurs during the execution of a Java program. Unlike checked exceptions, which must be declared in the method signature or caught using a try-catch block, runtime exceptions (also known as unchecked exceptions) do not need to be explicitly handled. They typically indicate errors that occur at runtime and are not expected to be recoverable.

Here are some examples of common runtime exceptions:

**NullPointerException:**

- Occurs when you try to access or invoke a method on an object reference that is `null`.

**ArrayIndexOutOfBoundsException:**

- Occurs when you attempt to access an array element using an index that is outside the valid range.

**ClassCastException:**

- Occurs when you try to cast an object to a type that is not compatible with its actual type.

**IllegalArgumentException:**

- Occurs when an illegal or inappropriate argument is passed to a method.


## 7. Could you give me one example of NullPointerException?
```java
public class NullPointerExceptionExample {
    public static void main(String[] args) {
        String str = null;

        try {
            // Attempting to get the length of a null string
            int length = str.length();  // This line will throw a NullPointerException
            System.out.println("Length of the string: " + length);
        } catch (NullPointerException e) {
            System.err.println("NullPointerException caught: " + e.getMessage());
        }
    }
}
```
In this example:

1. We declare a `String` variable `str` and assign `null` to it.
2. We then attempt to get the length of the string using `str.length()`. Since `str` is `null`, trying to invoke a method on it results in a `NullPointerException`.
3. We catch the exception and print a message to the console.

## 8. What is the Optional class?
  
The `Optional` class was introduced in Java 8 to address the issue of dealing with potentially null values and to help prevent null pointer exceptions. It is part of the `java.util` package and provides a container object that may or may not contain a non-null value. The primary goal of `Optional` is to express the idea that a value might be absent, rather than using a nullable reference (which can lead to null pointer exceptions).

## 9. What are the advantages of using the Optional class?
1. **Clarity and Intent:**
    
    - The use of `Optional` in method signatures explicitly communicates that a value may or may not be present, making the code more self-explanatory. It reflects the intent that a method might return an absent value.
    - The use of `Optional` often leads to cleaner and more concise code, reducing the need for explicit null checks and conditional logic.
2. **Null-Safe Operations:**
    
    - `Optional` provides a null-safe way to perform operations on values. Instead of directly manipulating potentially null references, you can use methods like `orElse`, `orElseGet`, or `orElseThrow` to provide default values or handle absence gracefully.
3. **Prevention of Null Pointer Exceptions:**
    
    - The introduction of `Optional` helps reduce the likelihood of null pointer exceptions. By encouraging developers to handle cases where values may be absent, it makes the code more robust and less error-prone.
4. **Avoidance of Defensive Coding:**
    
    - Developers often resort to defensive coding by adding numerous null checks to avoid potential null pointer exceptions. With `Optional`, these checks are encapsulated within the API, leading to cleaner and more readable code.
5. **Stream Integration:**
    
    - `Optional` seamlessly integrates with the Stream API, allowing developers to work with potentially absent values in a functional and expressive manner.
6. **Encouragement of Best Practices:**
    
    - The use of `Optional` encourages the adoption of best practices, such as returning empty `Optional` instead of null from methods, making it clear that absence is a valid and expected outcome.
7. **Functional Programming Support:**
    
    - `Optional` aligns well with the principles of functional programming by providing methods like `map`, `flatMap`, and `filter`. These methods allow for more expressive and composable code.

## 10. What is the @FunctionalInterface?
The `@FunctionalInterface` annotation is used in Java to indicate that an interface is intended to be a functional interface. Here is some key points:
1. **Annotation Purpose:**
    
    - The `@FunctionalInterface` annotation serves as a marker to indicate that an interface is intended to be used as a functional interface.
2. **Compiler Check:**
    
    - If an interface is annotated with `@FunctionalInterface` and it doesn't satisfy the conditions of having exactly one abstract method, the compiler will generate an error.
3. **Single Abstract Method (SAM) Rule:**
    
    - A functional interface must have exactly one abstract method. However, it can have multiple default or static methods without violating the functional interface contract.

## 11. What is lamda?
Lambda expressions provide a concise way to express instances of single-method interfaces (functional interfaces). They facilitate functional programming by allowing the representation of anonymous functions.

## 12. What is Method Reference?
  
Method reference in Java is a shorthand notation that allows you to refer to methods or constructors using a concise syntax. It is introduced in Java 8 as part of the lambda expressions and functional programming enhancements. Method references make the code more readable by providing a compact way to express certain types of operations.

There are several types of method references:

1. **Static Method Reference:**
    
    - Syntax: `ClassName::staticMethodName`
        
    - Example:
        ```
        // Lambda expression
		Function<String, Integer> parseIntLambda = s -> Integer.parseInt(s);

		// Method reference
		Function<String, Integer> parseIntReference = Integer::parseInt;
		```
        
2. **Instance Method Reference for a Particular Object:**
    
    - Syntax: `object::instanceMethodName`
        
    - Example:
        
    ```
    // Lambda expression
	Consumer<String> printUpperCaseLambda = s -> System.out.println(s.toUpperCase());

	// Method reference
	Consumer<String> printUpperCaseReference = System.out::println;

	```
        
3. **Instance Method Reference for an Arbitrary Object of a Particular Type:**
    
    - Syntax: `ClassName::instanceMethodName`
        
    - Example:
        
    ```
    // Lambda expression
	Comparator<String> lengthComparatorLambda = (s1, s2) -> s1.length() - s2.length();

	// Method reference
	Comparator<String> lengthComparatorReference = Comparator.comparing(String::length);
	```   
        
4. **Constructor Reference:**
    
    - Syntax: `ClassName::new`
        
    - Example:
	```
	// Lambda expression
	Supplier<List<String>> listSupplierLambda = () -> new ArrayList<>();

	// Constructor reference
	Supplier<List<String>> listSupplierReference = ArrayList::new;
	```
        
       

## 13. What is Java 8 new features?
**Lambda Expressions:**

- Lambda expressions provide a concise way to express instances of single-method interfaces (functional interfaces). They facilitate functional programming by allowing the representation of anonymous functions.

**Functional Interfaces:**

- Functional interfaces are interfaces with exactly one abstract method. They are annotated with `@FunctionalInterface` and can be used with lambda expressions.

**Streams:**

- The Stream API provides a set of classes and methods to process sequences of elements in a functional style. Streams can be parallelized and are designed to work with lambda expressions.

**Default Methods:**

- Default methods allow interfaces to have method implementations without affecting the implementing classes. This feature is useful for evolving interfaces without breaking backward compatibility.

**Method References:**

- Method references provide a shorthand notation for lambda expressions when they just call a method. They are useful when you want to pass a method as an argument to a higher-order function or use an existing method as a lambda expression. They are often more concise and readable.

**Optional Class:**

- The `Optional` class provides a container object that may or may not contain a non-null value. It helps in reducing the number of null pointer exceptions.

**Static Methods in Interfaces**:
Prior to Java 8, interfaces could only declare abstract methods, leaving no room for including concrete methods. The introduction of static methods in interfaces added a way to include utility methods or other behavior that doesn't depend on an instance of the interface.


## 14. Lambda can use unchanged variable outside of lambda? what is the details?

Lambda expressions can use effectively final variables from their enclosing scope. An effectively final variable is a variable whose value doesn't change after it has been assigned. In the context of lambda expressions, it means that the lambda can capture and use variables from its surrounding scope as long as those variables are effectively final.

Here are the key points:

1. **Effectively Final Variables:**
    
    - Lambda expressions can access and use local variables (including parameters of the enclosing method) that are effectively final. An effectively final variable is one whose value is not modified after its initialization.
2. **Accessing Variables:**
    
    - The lambda expression can read the value of effectively final variables from the enclosing scope. It doesn't create a copy of the variable; rather, it captures a reference to the variable.
## 15. Describe the newly added features in Java 8?

See Q13.


## 16. Can a functional interface extend/inherit another interface?
A functional interface in Java can extend or inherit from another interface. However, there are certain rules and considerations to keep in mind:

1. **Single Abstract Method (SAM) Rule:**
    
    - A functional interface must have exactly one abstract (unimplemented) method. This is known as the Single Abstract Method (SAM) rule.
2. **Multiple Default or Static Methods:**
    
    - While a functional interface can declare multiple default or static methods, these methods do not count toward the single abstract method requirement.
3. **Inheritance:**
    
    - A functional interface can extend another interface that may or may not be a functional interface itself.
## 17. What is the lambda expression in Java and How does a lambda expression relate to a functional interface?
Lambda expression is a concise way to express an instance of a functional interface (an interface with a single abstract method). It provides a clear and more readable syntax for writing anonymous methods (implementations of functional interfaces) by eliminating the need for boilerplate code.
Lambda is the implementation of functional interface. Functional interfaces serve as the type for lambda expressions, allowing them to be used in a context where a functional interface is expected.
## 18. In Java 8, what is Method Reference?

See Q12.
## 19. What does the String::ValueOf expression mean?
The `String::valueOf` expression is a method reference in Java, and it refers to the `valueOf` method of the `String` class. This method is a static method that converts different types of data, including primitive types and objects, to their string representations.
```
// Using lambda expression
List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
List<String> stringNumbersLambda = numbers.stream()
                                         .map(n -> String.valueOf(n))
                                         .collect(Collectors.toList());

// Using method reference
List<String> stringNumbersReference = numbers.stream()
                                            .map(String::valueOf)
                                            .collect(Collectors.toList());

```
## 20. What are Intermediate and Terminal operations?

Intermediate Operations:

Intermediate operations are operations that transform a stream into another stream. They are lazy, meaning they do not process the elements of the stream until a terminal operation is invoked. Intermediate operations are usually combined to form a stream pipeline.

Terminal Operations:

Terminal operations are operations that produce a result or a side-effect. They trigger the processing of the elements in the stream and close the stream, making it unable to be used for further processing.

## 21. What are the most commonly used Intermediate operations?
1. **`filter(Predicate<T> predicate)`:**
    
    - This operation is used to filter elements of the stream based on a given predicate. Only elements that satisfy the predicate are included in the resulting stream.
    
    `stream.filter(x -> x > 5)`
    
2. **`map(Function<T, R> mapper)`:**
    
    - The `map` operation is used to transform each element of the stream using the provided function.
    
    `stream.map(x -> x * 2)`
    
3. **`flatMap(Function<T, Stream<R>> mapper)`:**
    
    - This operation is similar to `map`, but it flattens the result by merging multiple streams into one.
    
    `stream.flatMap(str -> Arrays.stream(str.split(" ")))`
    
4. **`distinct()`:**
    
    - The `distinct` operation returns a stream consisting of distinct elements (according to their natural order or a provided comparator).
    
    `stream.distinct()`
    
5. **`sorted()`, `sorted(Comparator<T> comparator)`:**
    
    - The `sorted` operation is used to sort the elements of the stream. The default behavior is to sort elements in their natural order, but a custom comparator can be provided.
    
    `stream.sorted()`
    
6. **`peek(Consumer<T> action)`:**
    
    - The `peek` operation allows you to perform an action on each element of the stream without modifying the elements. It can be useful for debugging or logging.
    
    `stream.peek(System.out::println)`

## 22. What is the difference between findFirst() and findAny()?
The `findFirst()` method returns the first element in the stream, considering the order of the elements in the stream. For sequential streams, it returns the first element encountered; for parallel streams, it may return the first element that is processed in parallel.
This operation is useful when the order of elements is important, and you want to get the first element according to that order.

The `findAny()` method, on the other hand, returns any element from the stream. It is not constrained to return the first element and may return any element that matches the given condition.
This operation is particularly useful in parallel processing, where it can return the first element that is encountered by any thread, making it more suitable for parallel streams.
## 23. How are Collections different from Stream?

Collections are primarily employed as storage structures supporting various data types like List, Map, and Set. They serve as containers for holding and managing data. On the other hand, Streams are a set of APIs designed for data processing. Unlike Collections, Streams do not serve as a storage mechanism; instead, they offer functional programming capabilities, allowing users to customize their data processing workflows according to their needs. 
### Collections:
1. **Mutable:**
    
    - Most collections in Java are mutable, meaning you can add, remove, or modify elements within the collection after its creation.
2. **Eager Evaluation:**
    
    - Collections use eager evaluation, which means the data is computed and stored as soon as an operation is performed on the collection.


### Streams:


1. **Immutable:**
    
    - Streams are often created from existing collections, but they do not modify the underlying data. Instead, they produce a new stream with the desired operations applied.
2. **Lazy Evaluation:**
    
    - Streams use lazy evaluation, meaning the data is processed on-demand and not computed until it is needed.
