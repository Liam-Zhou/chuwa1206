1. What is generic in Java?  and type the generic code by yourself.

   - T - Type

   - E - Element

   - K - Key

   - N - Number

   - V - Value

     Generic is a language feature that allows the definition and use of generic types and methods, which help to provide stronger type check at compile time and support generic programming.

5. What is Runtime Exception? could you give me some examples?

   `RuntimeException` in Java is a subclass of `Exception` that represents exceptions which can occur during the program's runtime. These exceptions do not need to be declared in a method's `throws` clause. 

   Example:

   - NullPointerException
   - ArrayIndexOutOfBoundsException
   - ClassCastException

6. Could you give me one example of NullPointerException?

   ```java
   public class NullPointerExceptionExample {
       public static void main(String[] args) {
           String text = null; 
           try {
               int length = text.length(); 
           } catch (NullPointerException e) {
               System.out.println("Caught NullPointerException: " + e.getMessage());
           }
       }
   }
   ```

7. What is the Optional class?

   The `Optional` class in Java is a container object which may or may not contain a non-null value. it is used for avoid Null checks and run time NullPointerExceptions.

8. What are the advantages of using the Optional class?

   Optional` can help in avoiding `NullPointerException

   `Optional` supports various methods that are similar to stream operations, like `map`, `flatMap`, `filter`

    It makes the code more readable by explicitly handling the cases of present and absent values, making the code's intention clearer.

9. What is the @FunctionalInterface?

   The `@FunctionalInterface` annotation in Java is used to indicate that a particular interface is intended to be a functional interface.

   - has 1 single abstract method
   - can have a lot of default methods
   - provide a target type for lambda expressions and method references

10. what is lamda?

    A lambda expression in Java is a concise and powerful way to define an anonymous (unnamed) function

    Lambda is used to replace anonymous inner class and work with functional interface.

    Example:

    ```java
    Collections.sort(list, (s1, s2) -> s1.compareTo(s2));
    
    ```

    

11. What is Method Reference?

    Method references provide a way to refer to a method without executing it.

    method references are syntactic sugar for lambda expressions, used to call a specific method by referring to it with the help of its name.

12. What is Java 8 new features?

    - Lambda expressions
    - Stream APIs
    - Method references
    - Optional class
    - New Date and Time API
    - Collection API Improvements(facilitated by stream api and lambda)

13. Lambda can use unchanged variable outside of lambda? what is the details?

    Yes, lambda can use unchanged variable outside of lambda. There are 3 situations of variable that lambda can use.

    - final variable

    - non-final variable however never changed

    - object variable

      In short, if that variable's address never changed, it can be used by lambda.

15. Can a functional interface extend/inherit another interface?

    Yes. But have to maintain the single abstract method rule, which means this interface cant have any abstract method.

16. What is the lambda expression in Java and How does a lambda expression relate to a functional interface?

    A lambda expression is a concise representation of an anonymous function that can be passed around. It doesn't have a name but it has a list of parameters, a body, a return type, and possibly a list of exceptions that can be thrown.

    A functional interface in Java is an interface that contains exactly one abstract method.  Since a lambda expression is essentially a method without a name, it needs a context in which its parameters and return type are defined. Functional interfaces provide this context. That is to say, lambda is the implementation of the abstract method.

    ```java
    @FunctionalInterface
    interface MathOperation {
        int operation(int a, int b);
    }
    
    public class LambdaExample {
        public static void main(String[] args) {
            MathOperation addition = (a, b) -> a + b;
            System.out.println("10 + 5 = " + addition.operation(10, 5));
        }
    }
    
    ```

18. What does the String::ValueOf expression mean?

    valueOf method of the String class, it is a method reference

19. What are Intermediate and Terminal operations?

    Intermediate:function that return a new stream

    - filter

    - map

    - limit

    - skip

    - distinct

    - flatMap

    - sort

      Terminal:function that produce a result or a side-effect

      - allMatch
      - anyMatch
      - noneMatch
      - findFirst
      - findAny
      - count
      - max
      - min
      - forEach
      - reduce

20. What are the most commonly used Intermediate operations?

    - filter

    - map
    - limit
    - skip
    - distinct
    - flatMap
    - sort

21. What is the difference between findFirst() and findAny()?

    findFirst: return the first element

    findAny: return any element in the stream

22. How are Collections different from Stream?

    Collections are used for save data, Stream is used for data calculations.

    Collections:

    - data structure holds all data elements
    - external iteration
    - can be processed any number of times
    - elements are easy to access
    - data store

    Streams:

    - no data is stored
    - internal iteration
    - traversed only once
    - no direct way of accessing specific elements
    - is an api to process data

    