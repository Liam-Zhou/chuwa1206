
### HW42 Exception Validation

## Q2 What is the @configuration and @bean?

-`@Configuration` indicates that the class contains bean definitions and configuration methods. It is a class level annotation and is often used in conjunction with `@Bean` to define beans in the configuration class.


-`@Bean` declares a method as a producer of a bean managed by the Spring container. It indicates that the return value of the method should be registered as a bean. It is a method level annotation within a `@Configuration`-annotated class. `@Bean` can declare dependencies, and Spring will automatically inject those dependencies when creating the beans.
```java
@Configuration
public class AppConfig {

    @Bean
    public BeanA BeanA(BeanB BeanB) {
        return new BeanA(BeanB);
    }
}

```


## Q3 How do you handle the exception in Spring?

- **`@ExceptionHandler`:** This annotation is used at the method level to handle exceptions thrown by methods within the same controller. For example, if you have a custom exception `MyException`, you can have a method in your controller to handle this exception specifically.
```java
@Controller
public class MyController {
    @ExceptionHandler(MyException.class)
    public ResponseEntity<String> handleMyException(MyException e) {
        // handle exception
        return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }
}

```

- **`@ControllerAdvice`:** When you have multiple controllers and you want to handle exceptions globally, you can use `@ControllerAdvice`.
This is a specialization of the `@Component` annotation which allows to handle exceptions across the whole application, not just to an individual controller. You can combine it with `@ExceptionHandler`.

```JAVA
@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(MyException.class)
    public ResponseEntity<String> handleMyException(MyException e) {
        // handle exception
        return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }
}

```

- **`HandlerExceptionResolver`:** This is a convenient base class for `@ControllerAdvice` classes that wish to provide centralized exception handling across all `@RequestMapping` methods through `@ExceptionHandler` methods. It provides handling for standard Spring MVC exceptions and translates them into corresponding HTTP status codes.


```JAVA
@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(value = { MyException.class, AnotherException.class })
    protected ResponseEntity<Object> handleConflict(RuntimeException ex, WebRequest request) {
        String bodyOfResponse = "This should be application specific";
        return handleExceptionInternal(ex, bodyOfResponse, 
          new HttpHeaders(), HttpStatus.CONFLICT, request);
    }
}

```
- **`@ResponseStatus`:** You can also declare an @ResponseStatus on custom exception classes. This will automatically translate an exception to an HTTP status code.
```JAVA
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {
    // ...
}

```


## Q4 How do you do the validations in Spring? And list some validation annotaitons you know.

- **Use validation annotations in Spring MVC:**

In a Spring MVC application, you can use validation annotations directly on your model classes or DTOs. When a form is submitted or data is received, Spring MVC will automatically validate the input based on the annotations.

```java
public class UserDTO {

    @NotBlank(message = "Username cannot be blank")
    private String username;

    @Email(message = "Invalid email address")
    private String email;

    @Size(min = 6, message = "Password must be at least 6 characters long")
    private String password;

    // Getters and setters...
}

```

- **Use `@Valid` in Controller Methods:**

In a Spring MVC controller, you can use the `@Valid` in combination with a `BindingResult` object in your controller methods. The BindingResult will hold the result of the validation and any errors that might have occurred.

```java
@Controller
public class UserController {

    @PostMapping("/register")
    public String registerUser(@Valid @ModelAttribute("user") UserDTO userDTO, BindingResult result) {
        if (result.hasErrors()) {
            // Handle validation errors
            return "registration-form";
        }

        // Process registration logic if validation passes
        // ...
        return "registration-success";
    }
}

```

- Validation Annotations:

1. `@NotNull`: The annotated element must not be null.
2. `@NotEmpty`: The annotated element must not be null or empty (applied to collections, strings, maps).
3. `@NotBlank`: The annotated element must not be null and must contain at least one non-whitespace character (usually for strings).
4. `@Size(min=, max=)`: The annotated element size must be between the specified minimum and maximum boundaries.
5. `@Min(value)`: The annotated element must be a number whose value must be higher or equal to the specified minimum.
6. `@Max(value)`: The annotated element must be a number whose value must be lower or equal to the specified maximum.
7. `@Email`: The annotated element must be a valid email address.
8. `@Pattern(regexp)`: The annotated String must match the specified regular expression.
9. `@Positive`: The annotated element must be a strictly positive number.
10. `@PositiveOrZero`: The annotated element must be a positive number or zero.
11. `@Negative`: The annotated element must be a strictly negative number.
12. `@NegativeOrZero`: The annotated element must be a negative number or zero.


## Q5 What is the actuator, list some endpoints it provides?


The Spring Boot Actuator is a sub-project of Spring Boot. It provides a series of production-ready features to help you monitor and manage your Spring Boot applications. The Actuator mainly offers insight into the internals of running applications and gives metrics, health status, and environmental information.

Some of the common endpoints provided by Spring Boot Actuator are:

1. `/actuator`: Shows a list of all available endpoints.
2. `/health`: Provides basic health information about the application (like whether the application is up or down).
3. `/info`: Displays arbitrary application information, which can be customized.
4. `/metrics`: Shows various metrics for the application, like JVM memory usage, thread stats, and others.
5. `/env`: Displays the current environment properties, including system properties, environment variables, configuration properties, etc.
6. `/loggers`: Shows and modifies the logging level of application loggers.
7. `/heapdump`: Triggers a heap dump (useful for diagnosing memory issues).
8. `/threaddump`: Provides a thread dump of the application.
9. `/trace`: Displays trace information (by default, the last 100 HTTP requests).
10. `/auditevents`: Exposes audit events information (like authentication success/failure).
11. `/conditions`: Shows the conditions that were evaluated on configuration and the outcome of those conditions.
12. `/configprops`: Lists all @ConfigurationProperties.
13. `/mappings`: Displays a list of all @RequestMapping paths.
14. `/scheduledtasks`: Shows the scheduled tasks in the application.
15. `/caches`: Shows available caches.
16. `/refresh`: Allows re-loading the boot strap context, useful in cloud environments.