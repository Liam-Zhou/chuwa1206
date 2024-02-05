1.  annotaitons.md has been created.
2.  What is the @configuration and @bean?

    @Configuration: Classes annotated with `@Configuration` are often referred to as configuration classes. Configuration classes may contain bean definitions, method-level `bean` declarations, and other configuration-related logic.

    @bean: `@Bean` is an annotation used to declare a method as a producer of a bean managed by the Spring container. When Spring initializes the application context, it invokes methods annotated with @Bean to create bean instances based on the method's return value. The return type of the @Bean-annotated method defines the type of the bean that will be registered in the Spring application context. The name of the bean is derived from the method name unless specified explicitly using the name attribute of the @Bean annotation.

    Example code:

    ```
    @Configuration
    public class AppConfig {

         @Bean
         public MyService myService() {
             return new MyServiceImpl();
         }

         @Bean(name = "dataSource")
         public DataSource dataSource() {
             // Return DataSource bean implementation
         }
    }
    ```

3.  How do you handle the exception in Spring?

    - Using @ExceptionHandler
    - Using @ControllerAdvice

    Step:

    1. create ErrorDetails Class
    2. Create GlobalExceptionHandler Class
    3. Test using Postman Client

4.  How do you do the validations in Spring? And list some validation annotaitons
    you know.
    1. Define Validation Constraints
    2. Enable Validation in Spring MVC
    3. Handle Validation Errors
    4. Here are some commonly used validation annotations in Spring:
       1. @NotNull: Indicates that the annotated element must not be null.
       2. @NotEmpty: Indicates that the annotated string, collection, map, or array must not be null or empty.
       3. @NotBlank: Indicates that the annotated string must not be null or whitespace.
       4. @Size(min, max): Indicates that the annotated element must be a string, collection, map, or array whose size must be between the specified minimum and maximum values.
       5. @Min(value): Indicates that the annotated element must be a number whose value must be greater than or equal to the specified minimum value.
       6. @Max(value): Indicates that the annotated element must be a number whose value must be less than or equal to the specified maximum value.
       7. @Pattern(regex): Indicates that the annotated string must match the specified regular expression.
       8. @Email: Indicates that the annotated string must be a well-formed email address.
5.  What is the actuator, list some endpoints it provides?

    Actuator in Spring provides various endpoints that expose useful information about your application, including health, metrics, environment, configuration, and more.
    Here are some of the commonly used endpoints provided by Spring Boot Actuator:

    - /actuator/health: Provides information about the health of the application.
    - /actuator/info: Exposes arbitrary application information.
    - /actuator/metrics: Provides metrics about your application(memory usage, garbage collection stats, HTTP request metrics, ...)
    - /actuator/env: Exposes information about the application's environment, including properties, system variables, and configuration.
    - /actuator/loggers: Allows you to view and modify the logging levels of different loggers in your application dynamically.
    - /actuator/beans: Provides a list of all beans registered in the application context, including their dependencies and relationships.
