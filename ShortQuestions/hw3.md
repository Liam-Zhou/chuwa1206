1. [Practice collection]([chuwa-eij-tutorial/02-java-core/src/main/java/com/chuwa/exercise/collection at main · B1gO/chuwa-eij-tutorial · GitHub](https://github.com/B1gO/chuwa-eij-tutorial/tree/main/02-java-core/src/main/java/com/chuwa/exercise/collection))

2. Checked exceptions are exceptions that are checked at compile time. This means that the Java compiler enforces you to either catch these exceptions using a `try-catch` block or declare them in the method's `throws` clause. Example: `IOException`, `FileNotFoundException`, and `SQLException`.

   Unchecked exceptions, also known as runtime exceptions, are exceptions that are not checked at compile time. The Java compiler does not enforce you to catch or declare them. Example: `NullPointerException`, `ArithmeticException`, `ArrayIndexOutOfBoundsException`

3. No. There can be only one `finally` block associated with a `try-catch` statement. The `finally` block is used for code that needs to be executed regardless of whether an exception is thrown or not. It ensures that certain cleanup or finalization actions are performed.

4. The value returned from the `finally` block takes precedence, and it will be the final result of the entire `try-catch-finally` construct.

5. Checked exceptions are exceptions that are checked at compile time. This means that the Java compiler enforces you to either catch these exceptions using a `try-catch` block or declare them in the method's `throws` clause. Example: `IOException`, `FileNotFoundException`, and `SQLException`.

   Unchecked exceptions, also known as runtime exceptions, are exceptions that are not checked at compile time. The Java compiler does not enforce you to catch or declare them. Example: `NullPointerException`, `ArithmeticException`, `ArrayIndexOutOfBoundsException`

6. `throw` is used within the body of a method to explicitly throw an exception when a specific condition or situation occurs. It is used in the actual code logic to signal an exceptional condition.

   `throws` is used in a method declaration to indicate that the method might throw one or more exceptions of specific types. It is a part of the signature of methods and helps in documenting the potential exceptions that can be thrown by the method.

7. The order of exceptions matters in Java. When we have multiple catch blocks, they are checked in the order from top to bottom. The first catch block that matches the exception type will handle the exception, and the subsequent catch blocks will be skipped. Therefore, we write exceptions in the order from specific to general. If we put `Exception` before `Null/Runtime exception`, then Null/Runtime exception will never be checked.

8. `optional` is used to represent an optional value or the absence of a value. It helps eliminate the risk of null pointer exceptions (NPEs) because you can check whether a value is present before attempting to access it. Besides, it is more readable comparing to if-else blocks, and it encourages developers to handle the absence of a value explicitly, promoting better coding practices.

   Example:

   ```java
   Optional<String> optionalName = Optional.of("John");
   
   // Check if a value is present
   if (optionalName.isPresent()) {
       String name = optionalName.get();
       System.out.println("Name: " + name);
   } else {
       System.out.println("Name is absent.");
   }
   ```

9. The `finally` block is to ensure that resources are properly closed and released. This is essential to prevent resource leaks and ensure that resources are not left in an inconsistent state. Second, the `finally` block ensures that critical cleanup actions always occur, regardless of the program's execution flow. Third, this behavior allows us to handle exceptional situations that may occur during cleanup.

10. Inheritance, Composition, and Aggregation are the most common relationships between classes, and design pattern are patterns that concludes these relations between classes or objects. There are some of the commonly used design patterns in Java, but there are many more patterns that address specific problems and scenarios in software design. 

11. The core idea of SOLID principles is decouple. There are many relationships between classes, such as Inheritance, Composition, and Aggregation. We aim to design a proper pattern that can conclude these relations in a clear and concise method. For example, we don't desire the scenario that after changing one class, we also have to modify a hundred related classes, but want to minimizes the changes. Therefore people propose the SOLID principles, and would like these principles to guide such a clear and concise design.

12. We can use `Eager Initialization` or `Lazy Initialization with Synchronization`. They both are thread-safe. 

    In Eager Initialization, the Singleton instance is created eagerly during the class loading process, guaranteeing that it's thread-safe from the beginning. This method is suitable when the Singleton instance is lightweight and doesn't impose a significant resource burden. 

    In Lazy Initialization with Synchronization, the Singleton instance is created lazily when it's first requested, and synchronization is used to ensure that only one instance is created. This method introduces synchronization overhead, which may affect performance in high-concurrency scenarios.

13. The Open-Closed Principle (OCP) is one of the five SOLID principles of object-oriented programming and software design. It is one of the most important method to decouple. It emphasizes that once a software entity is stable and functional, it should be closed for modification.
14. 1 It mean that if the object of type A can do something, the object of type B could also be able to  perform the same thing
15. [MavenProject](../MavenProject)

