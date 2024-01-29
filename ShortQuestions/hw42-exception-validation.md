#### 2.what is @configuration and @bean

@configuration is a class--level annotation used to denote a configuration class. It can contain bean definitions. The configuration class may replace or supplement Spring's XML-based configuration.It's where you can define beans and inject dependencies.

@Bean is a method-level annotation used within a class marked as @Configuration. It create a Bean for Spring IOC to manager.

#### 3.How do you handle the exception in Spring

Using Exception Handler and ControllerAdvice.

#### 4.How do you do the validations in Spring? And list some validation annotaitons you know

1.add `spring-boot-starter-validation` dependency

2.Use validation annotations(@NotEmpty, @Size) on field in the model class.

3.Use @Valid annotation in the controller method to trigger the validation of a model attribute

4.handle validation errors



Validation annotations:

1. **@NotNull**:
   - Ensures that the annotated field is not null.
2. **@NotEmpty**:
   - Ensures that the annotated field is not null and its size/length is greater than zero. It applies to collections, arrays, and strings.
3. **@NotBlank**:
   - Ensures that the annotated string field is not null and trimmed length is greater than zero.
4. **@Size(min=, max=)**:
   - Checks that the annotated element size is between the specified `min` and `max` bounds.
5. **@Min(value)**:
   - Ensures that the annotated numeric field has a value no smaller than the specified minimum.
6. **@Max(value)**:
   - Ensures that the annotated numeric field has a value no larger than the specified maximum.
7. **@Email**:
   - Ensures that the annotated field is a valid email address.



#### 5.What is the actuator, list some endpoints it provides

 Actuator mainly exposes operational information about the running application — health, metrics, info, dump, environment, etc. — through HTTP or JMX endpoints. It is mainly used to expose operational information about the running application.

1. **actuator/health**:
   - Shows application health information (like database status, disk space, custom checks).
2. **/actuator/info**:
   - Displays arbitrary application information.
3. **/actuator/metrics**:
   - Shows various metrics information for the application.
4. **/actuator/env**:
   - Exposes properties from Spring’s ConfigurableEnvironment.
5. **/actuator/loggers**:
   - Shows and modifies the configuration of loggers in the application.