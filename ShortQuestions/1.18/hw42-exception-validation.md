# 1
Check `/ShortQuestions/1.8/annotations.md`

# 2
@Configuration

Used to mark a class as a source of bean definitions. The class annotated with @Configuration is a configuration class that many contain bean definitions and dependency injection settings.

@Bean

Bean is used to indicate that a method produces a bean to be managed by the Spring container.

# 3
Use ControllerAdvice and exception handler. In classes annotated with @ControllerAdvice or @RestControllerAdvice, we can define methods annotated with @ExceptionHandler to handle specific types of exceptions that are thrown during the execution of controller methods.

# 4
We can conduct validation by using Java Bean Validation API along with Spring's own support for validation. We first need to annotate model attributes with constraint annotations, then telling Spring to enforce these constraints at appropriate points.

In controller methods, we can use @Valid or @Validated annotation before medel attributes to tell Spring to validate them when the method is called.
- @Valid
- @Validated
- @NotNull
- @Size
- @Email

# 5 
Spring Boot actuator is a powerful set of features that monitor and manage your application. It exposes operational information about the running application via HTTP endpoints, JMX, or other means.
`/actuator/health`, `/actuator/info`, `/actuator/metrics`, `/actuator/beans`

# 6
Watched.