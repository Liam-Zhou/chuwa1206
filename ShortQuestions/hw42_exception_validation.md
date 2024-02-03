## Q2 What is the @configuration and @bean?
@Configuration is a class-level annotation in Spring that indicates that the class has @Bean definitions. Spring treats the class as a source of bean definitions. Each @Bean method within a @Configuration class instantiates and configures a bean to be managed by the Spring container.
```java
@Configuration
public class AppConfig {
    @Bean
    public MyBean myBean() {
        return new MyBean();
    }
}
```
@Bean is a method-level annotation in Spring that indicates that a method produces a bean to be managed by the Spring container. The annotation is usually declared in classes annotated with @Configuration.
```java
@Bean
public MyService myService() {
    return new MyService();
}
```
## Q3 How do you handle the exception in Spring?
Exception handling in Spring can be accomplished using the @ControllerAdvice and @ExceptionHandler annotations. @ControllerAdvice allows us to handle exceptions across the whole application, not just to an individual controller. We can combine it with @ExceptionHandler to define methods for handling specific exceptions.
```java
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<Object> handleException(Exception ex) {
        return new ResponseEntity<>("An error occurred: " + ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
```

## Q4 How do you do the validations in Spring? And list some validation annotaitons you know.
Validations in Spring can be performed using the Spring Validation API and annotations from the Java Bean Validation API (javax.validation.constraints package). We typically annotate our model attributes with validation constraints and use @Valid or @Validated annotations in our controller methods to trigger the validation of @RequestBody annotated parameters.
@NotNull: The annotated element must not be null.
@NotEmpty: The annotated element must not be empty. Supported for strings, collections, maps, and arrays.
@Size(min=, max=): The annotated element size must be between the specified boundaries.
@Email: The annotated element must be a valid email address.
@Min(value): The annotated element must be a number whose value must be higher or equal to the specified minimum.
@Max(value): The annotated element must be a number whose value must be lower or equal to the specified maximum.
```java
public class User {

    @NotNull
    @Email
    private String email;

    @NotEmpty
    @Size(min = 8, max = 20)
    private String password;
}
```

## Q5 What is the actuator, list some endpoints it provides?
Spring Boot Actuator is a Spring Boot sub-project that helps us monitor and manage our application by providing production-ready features like health checks and metrics.

Some common endpoints provided by Actuator include:
health: Shows application health information.
info: Displays arbitrary application info.
metrics: Shows ‘metrics’ information for the current application.
env: Exposes properties from Spring’s ConfigurableEnvironment.
loggers: Shows and modifies the configuration of loggers in the application.
heapdump: Returns a GZip compressed hprof heap dump file.
threaddump: Performs a thread dump.
auditevents: Exposes audit events information for the current application.
```java
GET /actuator/health
GET /actuator/info
GET /actuator/metrics
GET /actuator/env
GET /actuator/loggers
```
Actuator endpoints are highly configurable and can be enabled or disabled as per application requirements.




