## 2. What is `@Configuration` and `@Bean` in Spring?

### `@Configuration`
- `@Configuration` is a class-level annotation in Spring Framework, which indicates that the class has `@Bean` definition methods. It signifies that the class can be used by the Spring IoC container as a source of bean definitions.

### `@Bean`
- `@Bean` is a method-level annotation. It signifies that a method produces a bean to be managed by the Spring container. It's used within classes annotated with `@Configuration`. The method's return value becomes a bean and is added to the Spring application context.

## 3. How Do You Handle Exceptions in Spring?

- In Spring, exceptions can be handled using the `@ControllerAdvice` and `@ExceptionHandler` annotations.
- `@ControllerAdvice` allows you to handle exceptions across the whole application, not just to an individual controller. You can define a class with `@ControllerAdvice` and add methods with `@ExceptionHandler` to handle different exceptions.
- `@ExceptionHandler` is used to define methods for handling specific exceptions. These methods can return a response body, which allows for a more controlled and cleaner error response.

## 4. How Do You Do Validations in Spring? List Some Validation Annotations.

- In Spring, validation is often achieved using the Spring Validation API along with Hibernate Validator.
- Annotations from the `javax.validation.constraints` package are commonly used.

### Common Validation Annotations
- `@NotNull`: The annotated element must not be `null`.
- `@NotEmpty`: The annotated element must not be `null` and must contain at least one non-whitespace character.
- `@Size(min=, max=)`: The annotated element size must be within the specified boundaries.
- `@Email`: The annotated element must be a well-formed email address.
- `@Min(value)`: The annotated element must be a number greater than or equal to the specified minimum.
- `@Max(value)`: The annotated element must be a number less than or equal to the specified maximum.

## 5. What is Spring Boot Actuator? List Some Endpoints It Provides.

- Spring Boot Actuator provides production-ready features to help you monitor and manage your application. It includes a number of additional features that help you monitor and manage the application.

### Common Actuator Endpoints
- `/actuator/health`: Shows application health information.
- `/actuator/info`: Displays arbitrary application info.
- `/actuator/metrics`: Shows metrics information for the application.
- `/actuator/env`: Exposes properties from Spring’s `ConfigurableEnvironment`.
- `/actuator/loggers`: Shows and modifies the configuration of loggers in the application.
