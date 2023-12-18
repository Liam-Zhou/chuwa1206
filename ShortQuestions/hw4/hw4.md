# 1

1. What is generic in Java? and type the generic code by yourself.

a. https://github.com/TAIsRich/chuwa-eij-tutorial/tree/main/02-java-core/src/main/java/com/chuwa/tutorial/t01_basic/generic

In Java, generics let us write code that can work with different types of objects while ensuring type safety. We define a class or method with a placeholder for a type, and when using it, we specify the actual type. This approach allows us to reuse code for different types and helps prevent errors related to incorrect data types.



type the generic code by yourself:
Done by my own IDE



# 2

Read those codes and type it one by one by yourself. the push the code to your branch. https://github.com/TAIsRich/chuwa-eij-tutorial/tree/main/02-java-core/src/main/java/com/chuwa/tutorial/t06_java8



因为hw3还没有merge，所以我重新新建了一个项目作为这次作业的coding部分。为了方便，我没有使用public class，每个分类全部使用class写在了一个java文件内.



Please check hw4 directory in codingQuestion.





# 3

practice stream API at least 3 times

a. https://blog.devgenius.io/15-practical-exercises-help-you-master-javastream-api-3f9c86b1cf82



重写把test部分写了

Done



# 4

Practice Optional methods at least 2 times



Done



# 5

Write the Singleton design pattern include eager load and lazy load.

Eager Load
```Java
public class Eager{
	private Eager(){};
	private static final Eager eager = new Eager();
	public static getEager(){
		return eager;
	}
}
```

Lazy Load
```Java
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

# 6

What is Runtime Exception? could you give me some examples?

A runtime exception is an error that occurs during the execution of a program. Unlike compile-time errors, which are identified by the compiler before the program runs, runtime exceptions happen while the program is operating. For example, if ou r program tries to divide a number by zero, it will cause a runtime exception. Another common example is when a program tries to access an item in a list or array at an index that doesn't exist, like trying to get the 10th item in a list that only has 5 items.



# 7

Could you give me one example of NullPointerException?

``` Java
public class Example {
    public static void main(String[] args) {
        String text = null;
        int length = text.length(); // This line will throw a NullPointerException
    }
}

```





# 8

What is the Optional class?

The `Optional` class in Java is a container object used to contain not-null objects. It provides a way to avoid `NullPointerException` by offering methods to explicitly deal with cases where a value may be absent. Essentially, it's a means of expressing an optional value; a value that is either there (present) or not there (absent).



# 9

What are the advantages of using the Optional class?

it improves code readability by explicitly handling the presence or absence of a value, reduces the risk of `NullPointerException` by forcing developers to actively think about the case where a value might be null, and enhances API design by clearly indicating which methods might not return a value. This leads to more robust and clear code, making it easier to understand and maintain.





# 10

What is the @FunctionalInterface?

The `@FunctionalInterface` annotation in Java is used to indicate that an interface is intended to be a functional interface, which means it should have exactly one abstract method. 



# 11

what is lamda?



It is a concise way to represent a function or method. It provides a clear and simple way to implement a method defined by a functional interface, using a syntax that is typically more compact than an anonymous class.





# 12

What is Method Reference?



A method reference in Java is a shorthand notation of a lambda expression to call a method. It's used to refer directly to a method of an object or class



# 13

What is Java 8 new features?

**Lambda Expressions**

**Streams API**

**Optional**

**Default Methods**

**Method References**



# 14

Lambda can use unchanged variable outside of lambda? what is the details?

a lambda expression can access local variables from its enclosing scope, but those variables must be effectively final. This means the variables do not need to be explicitly declared as final, but they cannot be modified after initialization. If a local variable is assigned a new value after its initial declaration, it can no longer be used inside a lambda expression. This restriction ensures consistency and prevents potential concurrency issues.



# 15

Describe the newly added features in Java 8?

**Lambda Expressions**

**Streams API**

**Optional**

**Default Methods**

**Method References**





# 16

Can a functional interface extend/inherit another interface?

Yes, a functional interface can extend another interface, but the new interface must remain a functional interface, meaning it should still have only one abstract method in total. This can be achieved either by the new interface not adding any abstract methods or by inheriting a single abstract method from the parent interface.



# 17

What is the lambda expression in Java and How does a lambda expression relate to a functional interface?

A lambda expression in Java is a concise way to implement a functional interface, an interface with a single abstract method. It allows for simpler and more readable code, directly expressing the implementation of that method.



# 18

In Java 8, what is Method Reference?

a method reference is a shorthand notation of a lambda expression to directly refer to an existing method. It's used to point to methods by their names rather than providing a method body, making the code more concise and readable.



# 19

The `String::valueOf` expression in Java is a method reference that refers to the `valueOf` static method of the `String` class, used to convert different types of values (like objects, integers, etc.) into their string representations.



# 20

Intermediate operations in Java's Stream API are operations that transform a stream into another stream, such as `filter` or `map`, and are lazy, meaning they don't perform any processing until a terminal operation is invoked. Terminal operations, like `forEach`, `collect`, or `reduce`, produce a result or a side-effect from the stream and once invoked, they process the stream pipeline and end the stream.



# 21

What are the most commonly used Intermediate operations?

map

Filter

flatmap

sorted

Distinct

limit



# 22

What is the difference between findFirst() and findAny()?

`findFirst()` and `findAny()` are both terminal operations in Java's Stream API; `findFirst()` returns the first element of the stream, while `findAny()` returns any element (useful in parallel streams where finding the first element is costly). The choice between them often depends on whether the stream has a defined encounter order.



# 23

How are Collections different from Stream?

Collections in Java are in-memory data structures for storing and manipulating groups of objects, while Streams are a sequence of elements supporting sequential and parallel aggregate operations, designed for declarative data processing rather than data storage. Streams do not store data but process data from sources like collections on the fly.