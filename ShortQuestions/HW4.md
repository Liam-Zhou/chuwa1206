6. Runtime exception occurs during the execution of a program, typically due to
illegal operation or faulty logic. For example, NullPointerException, ArrayIndexOutOfBoundException, ArithmeticException, ILLegalArgumentException, IllegalStateException. 
7. ```
   public static void main(String[] args) {
        String text = null;
        int length = text.length(); // NullPointerException here
    }
   ```
8. `Optional` in Java is used to represent the presence or absence of a value. It can prevent NullPointerException and improves code readability. 
9. Using Optional can reduce the risk of NullPointerException by providing a clear and explicit way to deal with the presence or absence of a value. Also, can make code more readable and self-explanatory by explicitly showing that a value can be absent. 
10. It is a annotation in Java used to indicate that an interface is intend to be a functional interface which means only have one abstract method. 
11. Lambda is a concise way to represent a function or a method interface using an expression. 
12. Method reference is a shorthand notation of a lambda expression to call a method. It's used to refer directly to a method without executing it.
13. In Java 8, Lambda Expression, Streams API, Optional, Method References, Default Methods. 
14. Yes. Lambda only can use final variables or effective final variables. Lambda also can use instance and static variables, but cannot redefine a local variable that is already defined in its enclosing scope. 
15. Lambda expression enabled writing concise and flexible functional code. Streams APIis for processing sequences of data in a functional style, with operations like map, reduce, filter. Optional is a container object to represent the optional presence of value, reducing null-related errors. Method references is a shorted syntax for calling methods, usd with lambdas. Default methods allowed adding new methods to interfaces without breaking existing implementations. 
16. Yes. A function interface in Java can extend another interface, but total number of abstract method must remain one. The functional interface can extend another interface only if it doesn't add any additional abstract methods. It can inherit default methods from the extended interface without losing its functional interface status. 
17. Lambda expression is in Java provide a concise way to represent an anonymous function. They can be implement interfaces with a single abstract method. Functional interface with a single abstract method, lambda expressions are often used to implement these interfaces. 
18. Method reference is a feature that provides a way to refer to a method without executing it. It's used to create a concise, easy-to-read lambda expression for methods that already have a name.
19. String::ValueOf means convert other things into String, In lambda is (obj -> String.valueOf(obj))
20. Intermediate Operation means process data, set up the pipeline of transformations. Terminate Operation means trigger the processing and conclude the pipeline. 
21. `filter map flatmap distince sorted peek`
22. findFirst() means only find the first one, findAnt() means find any element from the stream. 
23. Collection is primarily data structures that store elements. can be iterated over multiple times and their elements can be accessed directly be index and can be modified. Streams is a sequence of elements supporting sequential and parallel aggregate operations. They are designed for one-time use and can handling large datasets. Steams do not store elements. 