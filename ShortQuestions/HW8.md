1. what is the @configuration and @bean? 

   **@Configuration**:

   - **Purpose**: is used to indicate that a class declares **one or more `@Bean` methods** and may be processed by the Spring container to generate bean definitions and service requests
   - **Effect**: When a class is annotated with `@Configuration`, it tells the Spring container that **it should treat this class as a source of bean definitions.**

   **@Bean**:

   - **Purpose**: is used to indicate that a method **produces a bean** to be managed by the Spring container. It's a way of explicitly declaring a single bean, rather than letting Spring do it automatically.
   - **Usage**: You use `@Bean` on methods within a class that is annotated with `@Configuration`. The method annotated with `@Bean` will return an object that Spring will register as a bean in its application context.
   - **Effect**: **The return value of the method (the bean) can then be used and autowired in your Spring application**, wherever that particular bean is required.

2. How do you handle the exception in Spring? 

   **Using `@ControllerAdvice` for Global Exception Handling**:

   - create a class annotated with `@ControllerAdvice`. This class can contain methods annotated with `@ExceptionHandler` to handle specific exceptions or exception types.

   - These methods can return custom error responses, redirect to error pages, or perform other actions as needed.

     ```java
     @ControllerAdvice
     public class GlobalExceptionHandler {
     
         @ExceptionHandler(Exception.class)
         public ResponseEntity<ErrorResponse> handleGlobalException(Exception ex) {
             // Create a custom error response and return it
             ErrorResponse errorResponse = new ErrorResponse("Internal Server Error", ex.getMessage());
             return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
         }
     }
     
     ```

     

   **Using `@ExceptionHandler` in Controllers**:

   - Within your controller classes, you can use the `@ExceptionHandler` annotation to handle exceptions specific to that controller.

   - This allows you to provide controller-specific exception handling logic.

     ```java
     @Controller
     public class MyController {
     
         @ExceptionHandler(ResourceNotFoundException.class)
         public ResponseEntity<ErrorResponse> handleResourceNotFound(ResourceNotFoundException ex) {
             // Handle the specific exception and return a custom error response
             ErrorResponse errorResponse = new ErrorResponse("Resource Not Found", ex.getMessage());
             return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
         }
     }
     
     ```

     

3. How do you do the validations in Spring? And list some validation annotaitons you know. 

   Some commonly used validation annotations include:

   - `@NotNull`: Checks if the annotated element is not `null`.
   - `@NotEmpty`: Checks if the annotated string, collection, or array is not empty.
   - `@NotBlank`: Checks if the annotated string is not empty and contains at least one non-whitespace character.
   - `@Min(value)`: Checks if the annotated numeric value is greater than or equal to the specified minimum value.
   - `@Max(value)`: Checks if the annotated numeric value is less than or equal to the specified maximum value.
   - `@Size(min, max)`: Checks if the annotated string, collection, or array has a size within the specified range.
   - `@Email`: Checks if the annotated string is a valid email address.
   - `@Pattern(regexp)`: Checks if the annotated string matches the specified regular expression.
   - `@Valid`: Used to indicate that a nested object should be validated.

4. What is the actuator, list some endpoints it provides?

   Spring Boot Actuator is a set of production-ready features provided by Spring Boot to help you monitor and manage your application in a production environment

   **`/actuator/health`**:

   - This endpoint provides information about the health of your application. It can indicate whether the application is up and running or if there are any issues. 

   **`/actuator/info`**:

   - The `/actuator/info` endpoint allows you to expose custom application information in JSON format

   **`/actuator/metrics`**:

   - The `/actuator/metrics` endpoint provides a wide range of metrics related to your application. These metrics include information about memory usage, garbage collection, HTTP request/response metrics, database connection pools, and more.

   **`/actuator/mappings`**:

   - The `/actuator/mappings` endpoint displays a list of all the HTTP endpoints and their mappings within your application. It helps you understand how different URLs are mapped to controller methods.

   **`/actuator/heapdump`**:

   - The `/actuator/heapdump` endpoint generates and provides a heap dump of the application. This is useful for analyzing memory-related problems.