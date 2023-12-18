## 1. What is generic in Java? and type the generic code by yourself.

## 2. Read those codes and type it one by one by yourself. the push the code to your branch.

## 3. practice stream API at least 3 times.

## 4. Practice Optional methods at least 2 times.

## 5. Write the Singleton design pattern include eager load and lazy load.

Please see the /chuwa1206/CodingQuestions/HW4/src/singleton

## 6. What is Runtime Exception? could you give me some examples?

Runtime Exception is the exception we throw during the execution of a program, like ArithmeticException, NullPointerException, ArrayIndexOutOfBoundException .. 

## 7. Could you give me one example of NullPointerException?

We define a variable List<Integer> array = null, when we call the array.size(), it will throw NullPointerException.

## 8. What is the Optional class?

Optional is a Java package in Java 8 which provides a more explicit and safer way to handle potentially null values. 

We usually use methods like of, ofNullable, get, ifPresent, orElse/orElseGet.orElseThrow

## 9. What are the advantages of using the Optional class?

It provides a more explicit and safer way to handle potentially null values and give responses.

## 10. What is the @FunctionalInterface?

It is an annotation for the interface, it shows that the interface can only have one abstract method. We use it with lambda together.

## 11. What is lamda?

Lambda is an expression can be passed as a parameter to a body function.

## 12. What is Method Reference?

Method Reference is a shorthand notation that allows you to refer to a method by its name instead of providing a lambda expression to describe the method's behavior.

## 13. What is Java 8 new features?

Lambda Expressions, Functional Interfaces, Streams API, Default Methods, Method References, Optional Class, New Date and Time API

## 14. Lambda can use unchanged variable outside of lambda? what is the details?

Yes, we can use the variables with final or without final, but we can not change the variable or reference before or after this lambda.

## 15. Describe the newly added features in Java 8?

Functional Interfaces, a functional interface is an interface with only one abstract method, and it can have multiple default or static methods.

Lambda Expressions, provides a concise way to express instances of single-method interfaces.

Streams API, it introduces the stream package with different methods to deal with the data.

Default Methods, it is in the interfaces which we want to implements common function for the classes which implementing this interface. 

Method References, method references provide a shorthand notation for lambda expressions, making the code more concise.

Optional Class, it provides a more explicit and safer way to handle potentially null values and give responses.

New Date and Time API, provides a modern date and time API that is more comprehensive and flexible.

## 16. Can a functional interface extend/inherit another interface?

Yes, a functional interface can extend/inherit another interface, but it can not has one abstract class in total.

## 17. What is the lambda expression in Java and How does a lambda expression relate to a functional interface?

Lambda Expressions, provides a concise way to express instances of single-method interfaces.
The lambda can be used with functional interface. lambda can provide the parameters and function body to the abstract method in the functional interface.

## 18. In Java 8, what is Method Reference?

Method Reference is a shorthand notation that allows you to refer to a method by its name instead of providing a lambda expression to describe the method's behavior.

## 19. What does the String::ValueOf expression mean?

It converts the given value to its string representation using the static valueOf method in the String class.

## 20. What are Intermediate and Terminal operations?

Intermediate operations are operations that transform a stream into another stream. They are not executed until a terminal operation is invoked.

Terminal operations are operations that produce a result or a side effect. They trigger the processing of elements in the stream and, once executed, a stream cannot be used again.

## 21. What are the most commonly used Intermediate operations?

filter, map, flatMap, distinct, sorted and limit

## 22. What is the difference between findFirst() and findAny()?

findFirst() will return the first one it find macthes, findAny() will return anyone.

## 23. How are Collections different from Stream?

Collections focus on collecting data and Stream focus on deal with the data, stream do not store data.