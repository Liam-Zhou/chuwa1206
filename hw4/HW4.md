# 5. Write the Singleton design pattern include eager load and lazy load
    see answer in singleton hw4/singleton

# 6. What is Runtime Exception? could you give me some examples?
    Runtime Excetption is inherited from throwable and occurs during runtime. Some uncheck exceptions are runtime exceptions and compiler doesnt
    force you to handle explicitly. 
    like NullPointerException. 
# 7. Could you give me one example of NullPointerException?
    Employee employee = null;
    System.out.println(employee.getAge());
# 8. What is the Optional class?
    Optional class is used to represent the value of variable could be absent. It is safe way
    to deal with potentially null values 
# 9. What are the advantages of using the Optional class?
    To avoid Null checks and run time NullPointerExceptons 
# 10. What is the @FunctionalInterface?
    Has one single Abstract method 
    @FunctionalInterface for sanity check 
    can have a lots of default methods
    lambda is implementation of the abstract method
# 11. what is lamda?
    To replace anoymonus inner class 
    work with functionalInterface
# 12. What is Method Reference?
    a method reference is a shorthand notation for representing lambda expressions 
    that directly refrence a particular method or constructor without invoking it
# 13. What is Java 8 new features?
    @functiaonlInterface
    lambda expression
    Stream API
    Default and Static interface methods

# 14. Lambda can use unchanged variable outside of lambda? what is the details?
    final variable or Non-final variable however never changed 
    object variable witought reassign a new memory/create a new object 

# 15. Describe the newly added features in Java 8?
    Lambda Expressions: introduce a concise syntax for writing anonymous methods (functions)
    Functional Interfaces: Functional interfaces are interfaces with exactly one abstract method. 
    Streams API: The Streams API provides a powerful and functional approach to processing collections of data. 
    Default Methods:Default methods allow interfaces to provide default implementations for methods.
    Optional Class: The Optional class is a container object that may or may not contain a value. To avoid Null checks and run time NullPointerExceptons
    Default and Static Interface Methods: Java 8 allows interfaces to have static methods and default implementations of methods.
    
# 16. Can a functional interface extend/inherit another interface?
    Yes, a functional interface in Java can extend or inherit another interface, even if that interface is not a functional interface
    need to adhere the Single Abstract Method (SAM) Rule (exactly one abstract method)
    @FunctionalInterface
    interface AnotherInterface {
        void anotherMethod();
    }
    
    @FunctionalInterface
    interface ExtendedFunctionalInterface extends AnotherInterface {
    }
# 17. What is the lambda expression in Java and How does a lambda expression relate to a functional interface?
    To replace anoymonus inner class 
    work with functionalInterface
    Lambda expressions were introduced in Java 8 to facilitate functional programming by providing a more succinct syntax for working with functional interfaces.
    @FunctionalInterface
    interface MyFunctionalInterface {
        void myMethod();
    }
    
    public class LambdaExample {
        public static void main(String[] args) {
            MyFunctionalInterface myFunction = () -> System.out.println("Hello from lambda!");
            myFunction.myMethod();
        }
    }
# 18. In Java 8, what is Method Reference?
    a method reference is a shorthand notation for representing lambda expressions 
    that directly refrence a particular method or constructor without invoking it

# 19. What does the String::ValueOf expression mean?
    it is method reference and directly reference the static method: Value of of String class withougt invoking it
# 20. What are Intermediate and Terminal operations?    
    intermediate:
        filter(Predicate<T> predicate): Filters the elements based on a given predicate.
        map(Function<T, R> mapper): Transforms each element using the provided function.
        distinct(): Removes duplicate elements from the stream.
        sorted(): Sorts the elements of the stream.
        limit(long maxSize): Limits the number of elements in the stream.
        skip(long n): Skips the first n elements in the stream.
    Terminal:
        forEach(Consumer<T> action): Performs an action for each element in the stream.
        collect(Collector<T, A, R> collector): Transforms the elements into a different form (e.g., a List or Map).
        count(): Returns the count of elements in the stream.
        anyMatch(Predicate<T> predicate): Returns true if any elements match the given predicate.
        allMatch(Predicate<T> predicate): Returns true if all elements match the given predicate.
        noneMatch(Predicate<T> predicate): Returns true if no elements match the given predicate.
# 21. What are the most commonly used Intermediate operations?
        filter(Predicate<T> predicate): Filters the elements based on a given predicate.
        map(Function<T, R> mapper): Transforms each element using the provided function.
# 22. What is the difference between findFirst() and findAny()?
    The findFirst() method returns the first element of the stream
    The findAny() method returns any element of the stream. This method is more suitable for parallel streams, 
    where multiple threads may be processing elements concurrently.
    Optional<String> anyFruit = fruits.parallelStream().findAny();
# 23. How are Collections different from Stream?
    Collections: Collections are data structures that store and organize a group of elements.
    Collections are typically mutable
    Collections: Collections are not inherently designed for parallel processing
    Streams: Streams represent a sequence of elements that can be processed in a functional-style manner
    Streams: Streams, by design, are usually immutable
    Streams: Streams support parallel processing
    functional programming : map , filter