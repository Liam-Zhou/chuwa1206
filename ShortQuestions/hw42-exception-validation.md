### Q1
### Q2
- `@Configuration` is a class-level annotation, indicates the class contains bean definitions. it used for Spring's Dependency Injection
- `@Bean` is a method-level annotation, indicates a method returns a bean to be managed by Spring. it used within a class marked with `@Configuration`

### Q3
- `@ExceptionHandler`, method-level annotation, handles exceptions in specific controller
-  ControllerAdvice, class-level, handles exceptions across multiple controllers
- ResponseStatesException, programmatically throw specific HTTP status errors, used within controller methods
- `@ResponseStatus`, interface for global exception handling, custom implementations possible
- `@RestControllerAdvice`, combinations of `@ControllerAdvice` and `@ResponseBody`, handles exceptions in RESTful services

### Q4
By using bean validation api(`@Valid`,`@Validated`) or spring validation framework(implement `Validator` interface) to handle validations
`@NotNull`, `@NotEmpty`, `@NotBlank`

`@Size(min=, max=)`, `@Min(value)`, `@Max(value)`

`@Email`, `Pattern(regexp=)`

### Q5
it provides various management and monitoring features for the application. It exposes a number of built-in endpoints that provide insights into the application's runtime and other aspects
- `/actuator/health`, show application health information
- `/actuator/info`, displays arbitrary application info
- `/actuator/metrics`, provides metrics of the application
- `/actuator/httprace`, shows http trace information
- `/actuator/mappings`, displays a list of all `@RequestMapping` paths


