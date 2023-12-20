# hw4

1. What is generic in Java? and type the generic code by yourself.
   a. <https://github.com/TAIsRich/chuwa-eij-tutorial/tree/main/02-java-core/src/main/java/com/chuwa/tutorial/t01_basic/generic>

In java, generic allow us to create `class`, `interface`, `method` to opend to received any type. It is compile-time after the jvm compile the source code generic will be erased.

- `?` is a unbounded wildcard.
  - **uppder bound** `<? extends E>` it can be type of E of subclass of E
  - **lower bound**`<? super E>` it can be E or super class of E.
  
**see sample code in coding3 folder**

2. Read those codes and type it one by one by 
   yourself. the push the code to your branch.
      <https://github.com/TAIsRich/chuwa-eij-tutorial/tree/main/02-java-core/src/main/java/com/chuwa/tutorial/t06_java8>

      **see coding3 folder**

3. practice stream API at least 3 times
   a. <https://blog.devgenius.io/15-practical-exercises-help-you-master-java-stream-api-3f9c86b1cf82>

   **see 03-stream-api-exercises folder**
4. Practice Optional methods at least 2 times
      a. <<https://github.com/TAIsRich/chuwa-eij-tutorial/blob/main/02-java-core/src/main/java/com/chuwa/tutorial/t06_java8/exercise/ShoppingCartUtil.java>

      **see coding3 folder**

5. Write the Singleton design pattern include eager load and lazy load.


   **see coding3 folder**

6. What is Runtime Exception? could you give me some examples?

   runtime exception also can be called as unchecked exception. eg:

   ```java
   int[] array = {1, 2, 3};
   int value = array[10];
   ```

7. Could you give me one example of NullPointerException?

   ```java
   String str = null, str.length()
   ```

8. What is the Optional class?

   we can think optional class as a container which make us easier way to handle `null`.

9.  What are the advantages of using the Optional class?

    1.  make code more readable and clear.
    2.  Optional class provide lots of API we can use. Such as stream.
    3.  working with lamda.

10. What is the @FunctionalInterface?

    @FunctionalInterface is a java annotation java 8 onward. It indicate the `Interface` is java functional interface. `Function interface` in java is an interface which only can have `one abstract method`.

       *tip: functional interface also can have default method and static method*

       ```java
        @FunctionalInterface
        public interface MyFunctionalInterface {
            void myMethod();
        }
       ```

11. what is lamda?

   lamda provide a more concise way to initiate a functional interface. `->` separate parameters and body of the lamda expresion.

   ```java
        Runnable myRunnable = () -> {
        System.out.println("Executing myRunnable");
      };
   ```

   ```java
   @FunctionalInterface
   public interface Runnable {
      /**
      * Runs this operation.
      */
      void run();
   }

   ```

12. What is Method Reference?
    
   such as `System.out :: println` is a method reference. it can call the method.

13. What is Java 8 new features?

- Lamda Expression
- Functional Interface
- Stream
- Default Methods in interface
- static methods in interface
- Optional class
  
14. Lambda can use unchanged variable outside of lambda? what is the details?

    yes. Lamda will capture variable from the scope of the lamda. Lambda can only use the variable if and only if the variable is `final` or `effective final`, effective final means the value not changed after declear.

15. Describe the newly added features in Java 8?
    1. **lambda expression**
        1. lambda expression proivde concise way initiate the instance of functional interface. it can make our code more compact and more readble.
    2. Functional interface.
        1. Functional interface only contain one abstract method. functional interface is the fundation of Lambda interface.  
    3. stream
        1. stream api is a powerful tool to handle collections. it mainly include 3 part.
            1. build stream object
            2. intermediate operation for data processing
            3. terminata operation for data collections.
    4. Default Methods
        1. interface can have default methods which have the method implementations.
    5. `::` method reference. we mainly have different method reference.
        1. static method refernce.
        2. instance method reference.
        3. contructor reference.
    6. Optional class
        1. `optional` class could be a wraper which can wrap null or non-null value. it can help us to handling NPE(null pointer Exception) in a nicer way.
16. Can a functional interface extend/inherit another interface?

    yes. But the total number of abstract method still be one. on the other word, the sub interface must not introduce more abstract method or can only override it's supper class's abstract method.

17. What is the lambda expression in Java and How does a lambda expression relate to a functional interface?

   Lamda expression provide concise way to represent a anonmyous funtion that will pass as argument to other method.(thinking of callback function).
   functional interface is the foundation of Lambda expression, since functional interface only have one abstract method, and lambda expression can provide a concise way to implement that mehotd.

18. In Java 8, what is Method Reference?

      `::` method reference. we mainly have different method reference.
        1. static method refernce.
        2. instance method reference.
        3. contructor reference.

19. What does the String::ValueOf expression mean?

   String::ValueOf is a method reference, it call valueof Method in String class. it convert input value to the represent of String.

20. What are Intermediate and Terminal operations?
    - `intermediate` operations are for date proccessing or transforming to another stream
    - `Terminal` operations are for data getting the result, once the stream is proceessed, it will be closed, so terminal operation only can be called once.
21. What are the most commonly used Intermediate operations?

    **in stream api**
    `Intermediate` operation is mainly for data processing, such as filter, and mapping, which tranform data into different type. eg: `filter`, `map`, `distinct`
    `termination` operation is for data colleciontion.eg: `collect`, `forEach`,`reduce`, `anyMatch`

22. What is the difference between findFirst() and findAny()?
    `findFirst` return the first element, but `finAny` just find any(random) element.

23. How are Collections different from Stream?

- Collections is mainly used for store data, but Stream mainly used to process the data.
- stream will not change the original object, but stream will return result of processing in a stream type.
- stream is lazy compute, the data processing of stream happens at termination stage.
