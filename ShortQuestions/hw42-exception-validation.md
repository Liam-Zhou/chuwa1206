# 2. what is the @configuration and @bean?

@Configuration in Spring is used to define Java-based configuration. It indicates that a class contains bean definitions that should be processed by the Spring container. @Bean is used to declare a method as a bean provider, and the returned object will be registered as a bean.

# 3. How do you handle the exception in Spring?

Exception handling in Spring can be done using @ExceptionHandler annotation in a controller or using a global exception handler by implementing the HandlerExceptionResolver interface.

# 4. How do you do the validations in Spring? And list some validation annotations you know.

Validations in Spring can be achieved using validation annotations like @NotNull, @NotEmpty, @Size, etc. You can use these annotations on fields or method parameters in your beans. Spring provides the @Valid annotation to trigger validation

# 5. What is the actuator, list some endpoints it provides.

Spring Actuator is a set of production-ready features, including monitoring and management. Some endpoints it provides are /health, /info, /metrics, /env, etc
