# hw10: hw42-exception-validation

### 2. What is the @configuration and @bean?
@configuration and @bean are annotations used in Spring Framework. 

`@configuration` is a class-level annotation that denotes a source of bean definitions. A class annotated with `@configuration` is a configuration by itself and will have methods to instantiate and configure the dependencies.

`@bean` is a method-level annotation and is used inside classes annotated with `@configuration`. The `@bean` annotation tells Spring that a method returns an object that should be registered as a bean in the Spring application context. 

### 3. How do you handle exceptions in Spring?
In Spring, exceptions can be handled using the `@ControllerAdvice` and `@ExceptionHandler` annotations. 

`@ControllerAdvice` is a class-level annotation that allows you to write global code that can be applied to a wide range of controllers. It can handle exceptions across the whole application, not just to an individual controller. 

`@ExceptionHandler` is used to handle specific exceptions and sending custom responses to the client. It can be declared within a controller class or inside a class annotated with `@ControllerAdvice`.

### 4. How do you do validations in Spring? And list some validation annotations you know.
In Spring, validations are typically done using the `@Valid` annotation in combination with Java Bean Validation (JSR-303) annotations. 

You use the `@Valid` annotation on a model attribute in a controller method to enforce validation rules. Spring will then validate the model attribute and bind the result to a `BindingResult` object. 

Some common validation annotations are:
- `@NotNull`: Checks that the annotated value is not null.
- `@NotEmpty`: Checks that the annotated string, collection, map, or array is not empty.
- `@Size`: Checks that the annotated element size is between min and max values (inclusive).
- `@Min` and `@Max`: Checks that the annotated value is greater than or equal to min or less than or equal to max.
- `@Email`: Checks that the annotated value is a valid email address.

### 5. What is the actuator and list some endpoints it provides?
Spring Boot Actuator is a set of tools to help you monitor and manage your Spring Boot application. It provides a number of built-in endpoints that you can use to monitor application metrics, understand traffic or the state of your database.

Some common endpoints provided by Spring Boot Actuator are:
- `/actuator/health`: Shows application health information.
- `/actuator/info`: Displays arbitrary application info.
- `/actuator/metrics`: Shows various metrics information for the application.
- `/actuator/logfile`: Returns the contents of the logfile (if logging.file or logging.path properties are set).
- `/actuator/httptrace`: Displays HTTP trace information (by default, the last 100 HTTP request-response exchanges).
