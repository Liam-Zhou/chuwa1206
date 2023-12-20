1. See CodingQuestions


2. What is the checked exception and unchecked exception in Java, could you give one example?

    - Checked Exception are those that the compiler forces you to catch or declare in a `throws` clause. They extend Exception class. Whereas unchecked exception is runtime exception, which extends RuntimeException.
    - Eg: Checked: IOException, Unchecked: NullPointerException

3. Can there be multiple finally blocks?

    - No.

4. When both catch and finally return values, what will be the final result?

    - If both catch and finally return values, the one in finally will be the final result.

5. What is Runtime/unchecked exception? what is Compile/Checked Exception?

    - Checked Exception are those that the compiler forces you to catch or declare in a `throws` clause. They extend Exception class. Whereas unchecked exception is runtime exception, which extends RuntimeException.

6. What is the difference between throw and throws?

   - `throw` is a keyword used to explicitly throw an exception within a method or block of code.
   - `throws` is used in a method declaration to indicate that the method might throw exceptions.

7. Run the below three pieces codes, Noticed the printed exceptions. why do we put the Null/Runtime
   exception before Exception ?

   1. ``` java.lang.ArithmeticException: / by zeroat Main.main(Main.java:7) ```
   2. ``` java.lang.NullPointerException: Cannot invoke "String.equals(Object)" because "s" is nullat Main.main(Main.java:8) ```
   3. ``` java.lang.RuntimeExceptionat Main.main(Main.java:9) ```

   - Because Exception is the parent class, if Exception is in front of the Null/Runtime exception, then only the catch block with Exception will be called.

8. What is optional? why do you use it? write an optional example.

   - `Optional` is a container objecgt that may contain a null value. The purpose is to provide a way of handling cases where a value may be obsent, reducing the null checks of `NullPointerExceptions`.
   - ```
      public static void main(String[] args) {
         Optional obj1 = Optional.of
         ("This is a sample text"); 
         Optional obj2 = Optional.empty();
         if (obj1.isPresent()) {          
            System.out.println
            ("isPresent method called on obj1 returned true");
         }       
         obj1.ifPresent(s -> System.out.println("ifPresent method called on obj1"));
         obj2.ifPresent(s -> System.out.println("ifPresent method called on obj2 "));
      } 
   ```

9. Why finally always be executed ?

   - The finally block ensures specific code always runs, no matter if an exception is thrown or not. It's vital for executing cleanup tasks or releasing resources, even if there's an exception in the try block or an early method return.

   

10. Practice collection problems here: https://github.com/TAIsRich/chuwa-eij-tutorial/tree/main/02-java-core/
   src/main/java/com/chuwa/exercise/collection

   - Same as problem 1.


11. What are the types of design patterns in Java ?

   - There are 3 main types:
      - Creational Patterns: These patterns deal with object creation mechanisms, providing ways to create objects more flexibly and efficiently than with direct instantiation. Examples include Singleton, Factory Method, Abstract Factory, Builder, Prototype.
      - Structural Patterns: These patterns focus on the composition of classes and objects, enabling the creation of larger structures while keeping them flexible and efficient. Examples include Adapter, Decorator, Proxy, Facade, Bridge.
      - Behavioral Patterns: These patterns concentrate on communication between objects, defining how they interact and distribute responsibility. Examples include Observer, Strategy, Command, Iterator, Visitor.

12. What are the SOLID Principles ?

    - SOLID design is an acronym for five principles that serve as a valuable standard. SOLID principles are class-level, object-oriented design concepts that, in conjunction with an extensive test suite, help you avoid code rot.
      - Single Responsibility Principle
      - Open-Closed Principle 
      - Liskov Substitution Principle 
      - Interface Segregation Principle 
      - Dependency Inversion Principle

13. How can you achieve thread-safe singleton patterns in Java ?

    - There are multiple ways to achieve this:
      - Eager Initialization
      - Lazy Initialization (Synchronized Method)
      - Double-Checked Locking
      - Using enum

14. What do you understand by the Open-Closed Principle (OCP) ?

   - Software entities (classes, modules, functions, etc.) should be open for extension, but closed for modification". Which means, an entity can allow its behaviour to be extended without modifying its source code.


15. Liskov’s substitution principle states that if class B is a subtype of class A, then object of type A may be
    substituted with any object of type B. What does this actually mean? (from OA ) choose your answer.
    1. It mean that if the object of type A can do something, the object of type B could also be able tp
       perform the same thing
    2. It means that all the objects of type A could execute all the methods present in its subtype B
    3. It means if a method is present in class A, it should also be present in class B so that the object of
       type B could substitute object of type A.
    4. It means that for the class B to inherit class A, objects of type B and objects of type A must be same.
    
   - 3 or C is my answer. "It means if a method is present in class A, it should also be present in class B so that the object of
     type B could substitute object of type A."

16. See CodingQuestions/MavenProject folder