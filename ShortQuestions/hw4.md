# HW4

## 1. What is generic in Java? and type the generic code by yourself.

Generics in Java are a language feature that allows for type safety and code reusability. They enable classes, interfaces, and methods to operate on objects of various types while providing compile-time type safety. 

1. **Type Parameters**: Generics introduce type parameters, usually denoted by single uppercase letters like **`T`**, **`E`**, **`K`**, **`N`**, **`V`**. These act as placeholders for the type that the class or method will operate upon.
2. **Compile-Time Type Checking**: By using generics, you can catch invalid types at compile time, making your code more robust and reducing runtime errors.
3. **Type Inference**: Java can often infer the type parameters from context, reducing the verbosity of the code.
4. **Generics and Legacy Code**: Generics were introduced in Java 5. They are backward compatible, meaning that you can still use legacy code without generics in newer versions of Java.
5. **Wildcards**: Wildcards (**`?`**) are used in generic type declarations to specify that any type can be used. They can be bounded (**`? extends ClassType`** for an upper bound or **`? super ClassType`** for a lower bound) to restrict the types that can be used.

```Java
public class Box<T> {
    private T t;

    public void set(T t) {
        this.t = t;
    }

    public T get() {
        return t;
    }

    public static void main(String[] args) {
        Box<Integer> integerBox = new Box<>();
        Box<String> stringBox = new Box<>();

        integerBox.set(new Integer(10));
        stringBox.set(new String("Hello World"));

        System.out.printf("Integer Value :%d\n", integerBox.get());
        System.out.printf("String Value :%s\n", stringBox.get());
    }
}
\
```

## 2. Read those codes and type it one by one by yourself. the push the code to your branch.

~

## 3. practice stream API at least 3 times

~

## 4. Practice Optional methods at least 2 times

~

## 5. Write the Singleton design pattern include eager load and lazy load.

Eager load

```java
public Singleton {
	private Singleton() {}

	private static Singleton instance = new Singleton();

	public static getInstance() {
		return instance;
	}
}
```

Lazy load

```java
public Singleton {
	private Singleton() {}

	private class SingletonHolder {
		private static final Singleton INSTANCE = new Singleton();
	}

	public static getInstance() {
		return SingletonHolder.INSTANCE;
	}
}
```

## 6. What is Runtime Exception? could you give me some examples?

A Runtime Exception refers to an exception that occurs during the execution of a program, as opposed to compile-time exceptions which are identified by the compiler before the program runs. Runtime exceptions in Java are unchecked exceptions, meaning they don't need to be declared in a method's throws clause.

1. **NullPointerException**: Occurs when trying to use an object reference that has the **`null`** value. Example:

   ```java
   String text = null;
   int length = text.length(); // NullPointerException
   ```

2. **ArrayIndexOutOfBoundsException**: Happens when an array is accessed with an illegal index. Example:

   ```java
   int[] numbers = {1, 2, 3};
   int number = numbers[3]; // ArrayIndexOutOfBoundsException
   ```

3. **ArithmeticException**: Often occurs for division by zero in integer arithmetic. Example:

   ```java
   int result = 10 / 0; // ArithmeticException
   ```

4. **ClassCastException**: When trying to cast an object to a subclass of which it is not an instance. Example:

   ```java
   Object i = Integer.valueOf(42);
   String s = (String) i; // ClassCastException
   ```

5. **IllegalArgumentException**: Thrown to indicate that a method has been passed an illegal or inappropriate argument. Example:

   ```java
   Thread t = new Thread();
   t.setPriority(11); // IllegalArgumentException as priority ranges from 1 to 10
   ```

6. **IllegalStateException**: Indicates that a method has been invoked at an illegal or inappropriate time. Example:

   ```java
   ArrayList<Integer> list = new ArrayList<>();
   Iterator<Integer> it = list.iterator();
   it.remove(); // IllegalStateException
   ```

7. **IndexOutOfBoundsException**: Thrown to indicate that an index of some sort is out of range. This can be a superclass of exceptions like **`ArrayIndexOutOfBoundsException`** or **`StringIndexOutOfBoundsException`**. Example:

   ```java
   String str = "Java";
   char ch = str.charAt(5); // StringIndexOutOfBoundsException
   ```

8. **NumberFormatException**: Occurs when a string that is supposed to have a numeric value cannot be parsed as such. Example:

   ```java
   int num = Integer.parseInt("XYZ"); // NumberFormatException
   ```

## 7. Could you give me one example of NullPointerException?

Occurs when trying to use an object reference that has the null value. 

```java
String text = null;
int length = text.length(); // NullPointerException
```

## 8. What is the Optional class?

Optional is a means for expressing optional values (values that are present or absent) instead of using null references. It provides a variety of utility methods to facilitate code to handle values that are potentially absent without the risk of NullPointerException.

## 9. What are the advantages of using the Optional class?

Using the **`Optional`** class in Java provides several benefits that enhance code quality, readability, and robustness:

1. **Explicitly Conveys Optional Data**: **`Optional`** makes it clear that a variable can be absent. This self-documenting feature makes the code more readable and understandable.
2. **Prevents `NullPointerException`**: It helps to avoid the infamous **`NullPointerException`**. By using **`Optional`**, you're forced to actively think about the absent case, which leads to more robust and error-resistant code.
3. **Encourages Immutability**: **`Optional`** instances are immutable (once created, you can't change whether they contain a value), which fits well with functional programming patterns and helps to avoid side effects in your code.

## 10. What is the @FunctionalInterface?

The @FunctionalInterface annotation in Java is used to indicate that a particular interface is intended to be a functional interface. A functional interface is an interface that contains exactly one abstract method. This constraint makes the interface suitable for lambda expressions and method references.

## 11. What is lamda?

A lambda expression in Java is a concise way to represent a function that can be passed around as an object. Introduced in Java 8, lambda expressions are a key feature in enabling functional programming in Java. They allow you to write more concise and flexible code, especially when working with collections and streams.

1. **Anonymous Function**: A lambda expression is essentially an anonymous function; it doesn't have a name like a method would.
2. **Function Without a Class**: Unlike methods, lambda expressions are not associated with any class. However, they can be used wherever an instance of a functional interface is required.
3. **Compact Syntax**: Lambdas have a more concise syntax compared to anonymous inner classes, making the code more readable and maintainable.
4. **Syntax**: A lambda expression typically has the format **`(arguments) -> {body}`**. For example, **`(x, y) -> x + y`** is a lambda expression that takes two arguments **`x`** and **`y`** and returns their sum.
5. **Functional Interface**: Each lambda expression is associated with a specific type, typically a functional interface (an interface with a single abstract method). The lambda expression provides the implementation of the abstract method for the functional interface.
6. **Uses**: Lambda expressions are commonly used with collections and the Stream API in Java. They are used in methods that require functional interfaces like **`forEach`**, **`map`**, **`filter`**, etc.
7. **Scope**: Lambdas can access static variables, instance variables, effectively final method parameters, and effectively final local variables.
8. **Return Types and Parameters**: The return type and the parameter types of a lambda are inferred by the compiler from the context in which the lambda is used.

## 12. What is Method Reference?

Method references in Java are a shorthand notation of a lambda expression to call a method. Introduced in Java 8, they enhance the expressiveness and readability of the code, especially in the context of functional programming. A method reference is used to refer directly to a method without executing it. It acts as a concise, easy-to-read alternative to a lambda expression.

1. Syntax
   - **`ClassName::methodName`** for static methods,
   - **`instance::methodName`** for instance methods, and
   - **`ClassName::new`** for constructors.
2. **Functional Interface**: Like lambda expressions, method references are compatible with functional interfaces (interfaces with a single abstract method). The method reference provides the implementation of this single abstract method.
3. **Usage**: Method references can be used wherever a lambda expression can be used. They are often used in stream operations, such as **`map`**, **`filter`**, **`forEach`**, and so on.
4. Types
   - **Static Method References**: Referencing a static method of a class.
   - **Instance Method of a Particular Object**: Referencing a method of a specific object.
   - **Instance Method of an Arbitrary Object of a Particular Type**: Referencing a method of an object that will be supplied later during the execution.
   - **Constructor References**: Referencing a constructor of a class.
5. **Readability and Clarity**: They often result in more readable and concise code compared to equivalent lambda expressions, especially in cases where a lambda does nothing more than call an existing method.

## 13. What is Java 8 new features?

1. **Lambda Expressions**: One of the most notable features of Java 8. Lambda expressions brought a functional programming aspect to Java, allowing for concise and flexible handling of functional interfaces (interfaces with a single abstract method).
2. **Streams API**: Java 8 introduced the Streams API, which provides a new abstraction for processing sequences of elements, including a declarative approach to parallel processing. This API greatly simplifies the task of performing bulk operations, like filtering, mapping, or reducing collections of data.
3. **Method References**: Method references improve readability and are used to refer to methods by their names. A method reference is used to point to methods by their names using "::" symbol.
4. **Default Methods**: Interfaces were extended to allow default methods and static methods. Default methods enable new functionality to be added to the interfaces of libraries and ensure binary compatibility with code written for older versions of those interfaces.
5. **Optional Class**: Optional is a container object used to contain not-null objects. Optional object is used to represent null with absent value. This class has various utility methods to facilitate code to handle values as ‘available’ or ‘not available’ instead of checking null values.
6. **New Date and Time API**: Java 8 introduced a new Date and Time API (under the package **`java.time`**), inspired by Joda-Time, to address the shortcomings of the older **`java.util.Date`** and **`java.util.Calendar`**. The new API is immutable and fluent, making it more robust and easy to use.

## 14. Lambda can use unchanged variable outside of lambda? what is the details?





## 15. Describe the newly added features in Java 8?

1. **Lambda Expressions**: One of the most notable features of Java 8. Lambda expressions brought a functional programming aspect to Java, allowing for concise and flexible handling of functional interfaces (interfaces with a single abstract method).
2. **Streams API**: Java 8 introduced the Streams API, which provides a new abstraction for processing sequences of elements, including a declarative approach to parallel processing. This API greatly simplifies the task of performing bulk operations, like filtering, mapping, or reducing collections of data.
3. **Method References**: Method references improve readability and are used to refer to methods by their names. A method reference is used to point to methods by their names using "::" symbol.
4. **Default Methods**: Interfaces were extended to allow default methods and static methods. Default methods enable new functionality to be added to the interfaces of libraries and ensure binary compatibility with code written for older versions of those interfaces.
5. **Optional Class**: Optional is a container object used to contain not-null objects. Optional object is used to represent null with absent value. This class has various utility methods to facilitate code to handle values as ‘available’ or ‘not available’ instead of checking null values.
6. **New Date and Time API**: Java 8 introduced a new Date and Time API (under the package **`java.time`**), inspired by Joda-Time, to address the shortcomings of the older **`java.util.Date`** and **`java.util.Calendar`**. The new API is immutable and fluent, making it more robust and easy to use.

## 16. Can a functional interface extend/inherit another interface?

Yes, a functional interface in Java can extend or inherit another interface, but there are specific rules that must be followed for the resulting interface to still be considered a functional interface. A functional interface is defined as an interface with exactly one abstract method. Here's how inheritance works in this context:

1. **Extending a Non-Functional Interface**: A functional interface can extend a non-functional interface (an interface with no abstract methods), and it will remain a functional interface.
2. **Extending Another Functional Interface**: A functional interface can extend another functional interface only if it does not introduce any new abstract methods. In other words, it can inherit the single abstract method from its parent interface.
3. **Default Methods**: A functional interface can have any number of default methods. Default methods have an implementation, so they do not count as abstract methods. This rule also applies to the inherited methods from a parent interface.
4. **Static Methods**: Similarly, static methods are not counted as abstract methods. A functional interface can have any number of static methods and still be considered a functional interface.
5. **Re-abstracting Methods**: If a functional interface extends another interface that has default methods, the functional interface can turn these into abstract methods by re-declaring them without providing an implementation. This is allowed as long as the total number of abstract methods in the functional interface remains one.

## 17. What is the lambda expression in Java and How does a lambda expression relate to a functional interface?

### Lambda Expressions

1. **Definition**: A lambda expression is essentially an anonymous function; it's a block of code with parameters that can be passed around and executed. They are typically used to implement simple method interfaces using an expression.
2. **Syntax**: The general syntax of a lambda expression is `(parameters) -> {body}`. For example:
   - `(x, y) -> x + y` takes two parameters and returns their sum.
   - `() -> System.out.println("Hello World")` takes no parameters and prints a message.
3. **Characteristics**:
   - Concise: Much shorter than anonymous classes for simple method implementations.
   - Functional: Suited for functional programming styles, such as lazy evaluation, immutability, and side-effect-free functions.
   - Portable: Can be passed around as objects and executed on demand.

### Functional Interfaces

1. **Definition**: A functional interface in Java is an interface that has exactly one abstract method. These interfaces can have any number of default or static methods.
2. **Examples**: Common examples include `Runnable`, `Callable`, and `Comparator`.
3. **Usage with Lambda Expressions**: Lambda expressions are often used to provide a straightforward and concise implementation for functional interfaces.

### Relationship Between Lambda Expressions and Functional Interfaces

- **Implementation Mechanism**: A lambda expression provides the implementation of the abstract method of a functional interface. It's a more succinct way to create instances of single-method interfaces than using anonymous classes.
- **Type Inference**: When you use a lambda expression, Java infers the lambda expression's type to be a functional interface type. This makes lambda expressions compatible with methods that expect a functional interface as a parameter.
- **Enhanced Readability and Flexibility**: Using lambda expressions to implement functional interfaces enhances the readability and flexibility of the code, especially when working with APIs that are designed to leverage functional programming concepts (e.g., the Stream API).

```java
List<String> names = Arrays.asList("Alice", "Bob", "Charlie");

// Using a lambda expression to implement the Comparator interface
Collections.sort(names, (String a, String b) -> b.compareTo(a));

```

## 18. In Java 8, what is Method Reference?

Method references in Java are a shorthand notation of a lambda expression to call a method. Introduced in Java 8, they enhance the expressiveness and readability of the code, especially in the context of functional programming. A method reference is used to refer directly to a method without executing it. It acts as a concise, easy-to-read alternative to a lambda expression.

1. Syntax
   - **`ClassName::methodName`** for static methods,
   - **`instance::methodName`** for instance methods, and
   - **`ClassName::new`** for constructors.
2. **Functional Interface**: Like lambda expressions, method references are compatible with functional interfaces (interfaces with a single abstract method). The method reference provides the implementation of this single abstract method.
3. **Usage**: Method references can be used wherever a lambda expression can be used. They are often used in stream operations, such as **`map`**, **`filter`**, **`forEach`**, and so on.
4. Types
   - **Static Method References**: Referencing a static method of a class.
   - **Instance Method of a Particular Object**: Referencing a method of a specific object.
   - **Instance Method of an Arbitrary Object of a Particular Type**: Referencing a method of an object that will be supplied later during the execution.
   - **Constructor References**: Referencing a constructor of a class.
5. **Readability and Clarity**: They often result in more readable and concise code compared to equivalent lambda expressions, especially in cases where a lambda does nothing more than call an existing method.

## 19. What does the String::ValueOf expression mean?

The expression `String::valueOf` is a method reference in Java. It refers to the `valueOf` static method of the `String` class. This expression can be understood as a shorthand for a lambda expression that calls `String.valueOf`.

- **Class and Method**: `String` is the class name, and `valueOf` is the static method of this class.
- **Usage**: This method reference is used to convert different types of values into their string representation.
- **Functional Interface**: It can be assigned to any functional interface (an interface with a single abstract method) whose abstract method's signature matches that of `String.valueOf`.

## 20. What are Intermediate and Terminal operations?

In Java's Stream API, operations on streams are classified into two main categories: intermediate operations and terminal operations. This classification is based on how these operations process stream elements and whether or not they produce a new stream.

### Intermediate Operations

1. **Lazily Executed**: Intermediate operations are lazy. They don't perform any processing until a terminal operation is invoked. This means they build a chain of processing steps without actually running any computations on the elements.
2. **Return Type**: They return another stream. This allows the operations to be connected or "chained" together.
3. **Statelessness vs Statefulness**: Some intermediate operations are stateless (e.g., `map`, `filter`), meaning they process each element independently of others. Others are stateful (e.g., `sorted`, `distinct`), meaning they may need to process the entire stream to produce a result (such as sorting elements).
4. **Examples**:
   - `map`: Transforms each element in the stream using a given function.
   - `filter`: Filters elements according to a predicate.
   - `limit`: Truncates the stream to a given size.
   - `sorted`: Sorts the elements in the stream.

### Terminal Operations

1. **Eager Execution**: Terminal operations trigger the processing of data. When a terminal operation is called, it processes all the intermediate operations and produces a final result.
2. **Return Type**: They typically return a non-stream result, such as a primitive value, a collection, or no value (`void`).
3. **No Further Stream Operations**: After a terminal operation is performed, the stream cannot be used anymore. Attempting to reuse a stream after a terminal operation will result in an `IllegalStateException`.
4. **Examples**:
   - `collect`: Collects the elements of the stream into a collection or another data structure.
   - `forEach`: Applies a function to each element of the stream.
   - `count`: Returns the count of elements in the stream.
   - `reduce`: Performs a reduction on the elements of the stream using an associative accumulation function.

## 21. What are the most commonly used Intermediate operations?

- filter
- map
- flatMap
- limit
- sorted
- distinct
- peek
- skip

## 22. What is the difference between findFirst() and findAny()?

**Behavior**: `findFirst()` returns the first element in the stream according to the encounter order of the stream. For ordered streams (like those sourced from a `List` or sorted), the first element is well-defined.

**Behavior**: `findAny()` returns any element from the stream. The element returned does not follow any specific order and can be different when the operation is repeated.

### Key Differences

- **Order Sensitivity**: `findFirst()` respects the encounter order of the stream, while `findAny()` does not.
- **Performance in Parallel Streams**: `findAny()` is usually more efficient in parallel streams.
- **Predictability**: `findFirst()` will always return the same element in a sequential stream, whereas `findAny()` might return different elements when called multiple times.

### Choice of Method

- Use `findFirst()` when the order of elements matters or when working with sequential streams.
- Use `findAny()` when working with parallel streams for better performance, or when the order is not important.

## 23. How are Collections different from Stream?

For Colletioncs:

**Mutability**: Collections can be mutable (elements can be added, removed, or modified) or immutable.

For Stream:

**Immutability**: Streams are inherently immutable. They do not allow modification of the underlying data source.

### Comparison

- **Purpose**: Collections are for managing data (storing and retrieving); Streams are for computing on data (filtering, transforming, and aggregating).
- **Usage**: Collections are used when you want to store a group of objects and iterate over them. Streams are used when you want to perform single-pass, functional-style operations.
- **Performance**: For large datasets, streams (especially parallel streams) can offer performance benefits over traditional collection-based approaches due to laziness and inherent support for parallelism.
- **Flexibility with Lambda**: Streams are more flexible and succinct when working with lambda expressions compared to collections.
- **Memory Efficiency**: Streams are more memory-efficient for large datasets as they don't require storing all elements in memory as collections do.