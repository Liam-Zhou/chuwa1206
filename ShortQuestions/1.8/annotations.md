# @SpringBootApplication
This annotation marks the main class of Spring Boot application which is the entry point of the application.

@SpringBootApplication encapsulates @Configuration, @EnableAutoConfiguration, and @ComponentScan annotations with their default attributes.

```
@SpringBootApplication
class VehicleFactoryApplication {

    public static void main(String[] args) {
        SpringApplication.run(VehicleFactoryApplication.class, args);
    }
}
```

# @EnableAutoConfiguration
@EnableAutoConfiguration enables auto-configuration. It means that Spring looks for auto-configuration beans on its classpath and automatically applies them.

```
@Configuration
@EnableAutoConfiguration
class VehicleFactoryConfig {}
```

# @ConditionalOnClass and @ConditionalOnMissingClass
Using these conditions, Spring will only use the marked auto-configuration bean if the class in the annotation’s argument is present/absent.

# @ConditionalOnBean and @ConditionalOnMissingBean
We can use these annotations when we want to define conditions based on the presence or absence of a specific bean.

# @ConditionalOnProperty
make conditions on the values of properties

# @ConditionalOnResource
use a definition only when a specific resource is present

# @ConditionalOnWebApplication and @ConditionalOnNotWebApplication
create conditions based on if the current application is or isn’t a web application:

# @ConditionalExpression
Spring will use the marked definition when the SpEL expression is evaluated to true

# @Conditional
create a class evaluating the custom condition.

# @RestController
A specialized version of the @Controller annotation which adds the @ResponseBody annotation. It signals that the return value of the methods should be bound to the web response body.

```
@Controller
@ResponseBody
class VehicleRestController {
    // ...
}
```

# @RequestMapping
Used for mapping web requests onto specific handler classes and/or handler methods. It can be applied to class-level and/or method-level in a controller.

```
@Controller
class VehicleController {

    @RequestMapping(value = "/vehicles/home", method = RequestMethod.GET)
    String home() {
        return "home";
    }
}
```
```
@Controller
@RequestMapping(value = "/vehicles", method = RequestMethod.GET)
class VehicleController {

    @RequestMapping("/home")
    String home() {
        return "home";
    }
}
```

# @GetMapping, @PostMapping, @PutMapping, @DeleteMapping, @PatchMapping
These are specialized versions of @RequestMapping. They act as a shortcut for @RequestMapping method attribute.

# @Autowired
Allows Spring to resolve and inject collaborating beans into your bean.

```
public class FooService {
    private FooFormatter fooFormatter;
    @Autowired
    public void setFormatter(FooFormatter fooFormatter) {
        this.fooFormatter = fooFormatter;
    }
}
```
```
public class FooService {
    private FooFormatter fooFormatter;
    @Autowired
    public FooService(FooFormatter fooFormatter) {
        this.fooFormatter = fooFormatter;
    }
}
```
# @Service
Indicates that an annotated class is a "Service", originally defined by Domain-Driven Design (DDD) as "an operation offered as an interface that stands alone in the model, with no encapsulated state."

# @Repository
Indicates that an annotated class is a "Repository", a mechanism for encapsulating storage, retrieval, and search behavior which emulates a collection of objects.

# @Component 
A generic stereotype for any Spring-managed component. @Repository, @Service, and @Controller are specializations of @Component for more specific use cases.

# @Bean
An annotation at the method level that tells Spring that a method produces a bean to be managed by the Spring container.

# @Value
Indicates a default value expression for the affected argument.

# @PathVariable 
Indicates that a method parameter should be bound to a URI template variable.

# @RequestParam 
Indicates that a method parameter should be bound to a web request parameter.

# @RequestBody
@RequestBody annotation maps the HttpRequest body to a transfer or domain object, enabling automatic deserialization of the inbound HttpRequest body onto a Java object.

# @Controller
@Controller annotation marks a spring bean as a controller.

# @QueryMapping
a shortcut annotation to bind annotated methods for fields under the Query type.

# @MutationMapping
a shortcut annotation to bind annotated methods for fields under the Mutation type.

# @Argument
The @Argument annotation is used in a controller method to indicate that a method parameter should be bound to a GraphQL argument.

# @Id
Marks the field as the primary key of the table

# @GeneratedValue
specify the way to generate a field's value

# @Column
specify the column mappings between the entity fields and the corresponding columns in a database table.

# @CreationTimestamp
This annotation automatically sets the date and time of the entity's creation in the mapped database column.

# @UpdateTimestamp
This annotation automatically sets the date and time of the entity's update in the mapped database column.

# @ControllerAdvice
This annotation is used to define a class as a global exception handler or a global binder for @Controller class. It allows you to handle exceptions across the whole application, not just to an individual controller. Exception handling methods annotated with @ExceptionHandler within a @ControllerAdvice annotated class will handle exceptions thrown by methods annotated with @RequestMapping.

# @RestControllerAdvice
This is a specialization of @ControllerAdvice. It is annotated on a class to handle exceptions across multiple @RestControllers. The key difference is that @RestControllerAdvice is typically used along with @RestController class, meaning the exception handler defined with @RestControllerAdvice assume you are working with RESTful APIs and the response is usually in JSON or XML format.

# @ExceptionHandler
It is used to define methods in controller class or in @ControllerAdvice annotated classes that will handle specific types of exceptions thrown during execution of controller methods. The primary purpose of @ExceptionHandler is to provide a centralized and neat way of handling exceptions in a Spring MVC or Spring Boot application. Instead of having try-catch blocks scattered throughout your controller methods, @ExceptionHandler allows you to define global or controller specific exception handling.

# @Valid
@Valid is an annotation used in Spring framework for validating the beans. @Valid is part of standard Java Bean validation API. You can use @Valid on a method parameter or a field to indicate that it should be validated when the method is invoked when request is processed by a controller method in a Spring MVC application. When you annotate a method parameter with @Valid, Spring will validate the object before the method executes. If validation fails, a MethodArgumentNotValidException is thrown.

# @Validated
@Validated is part of Spring framework. It can be used at the type level and at the method level. It offers more features compared to @Valid. It supports validation groups. Validation groups allow you to create subsets of constraints.

# @NotNull
The field shoud not be null.

# @Email
The field is an email address.

# @Size
The field should fall into the specified size.

# @OneToMany
Used to define one-to-many relationship between two entity classes. 

# @ManyToOne
Used to define a many-to-one relationship between two entity classes.

# @JoinColumn
UYsed to specify the foreign key column in the owner entity that is used to join with the referenced entity.

# @ManyToMany
Used to define a many-to-many relationship between two entity classes.

# @Configuration
Used to mark a class as a source of bean definitions. The class annotated with @Configuration is a configuration class that many contain bean definitions and dependency injection settings.

# @Bean
Bean is used to indicate that a method produces a bean to be managed by the Spring container.

# @CookieVulue
@CookieValue is used to bind the value of a HTTP Cookie to a parameter.

# @Getter
Create getters for all fields.

# @Setter
Create setters for all fields

# @NoArgsConstructor
Create a no arg constructor

# @AllArgsConstructor
Create an all args constructor

# @Slf4j
The @Slf4j annotation is used at the class level and automatically generates a logger field in that class.


# @EnableBatchProcessing
@EnableBatchProcessing is an annotation provided by the Spring Batch framework. When you add this annotation to a configuration class in a Spring application, it enables various features and configurations related to batch processing.

# @Aspect
The @Aspect annotation is used to mark a class as an aspect, meaning the class will contain methods that should be run at certain points in the execution of the program (join points), such as method invocations or field assignments.

# @PointCut
Define expression to find all main application methods to insert advice

# @Before
Run before the method execution

# @After
Run after the method returned a result

# @AfterReturning
Run after the method returned a result, intercept the returned result as well.

# @AfterThrowing
Run after the method throws an exception

# @Around
Run around the method execution, combine all three advices above.

# @EnableScheduling
@EnableScheduling is a class-level annotation that enables support for scheduled tasks. 

# @Scheduled
@Scheduled is a method-level annotation used to mark a method to be scheduled. You can define the schedule in several ways, including fixed-rate, fixed-delay, or cron expressions.

# @Transactional
@Transactional tells Spring that the method should be executed within a transactional context.

# @Mock
The @Mock annotation is used to declare and create mock instances of a given class or interface.

# @Spy
@Spy is an annotation used in unit testing, particularly with the Mockito testing framework in Java. It is used to create a spy instance of a class. Spies are a special type of mock object where the default behavior is to execute the real underlying method in the class being spied upon.

# @InjectMocks
This annotation is used to automatically inject mock or spy objects into the tested class.

# @Test
It is used to denote that a method is a test method.

# @BeforeAll
Execute the annotated method once before all the test methods.

# @AfterAll
Execute the annotated method once after all the test methods.

# @BeforeEach
Execute the annotated method before each test method.

# @AfterEach
Execute the annotated method after each test method.

# @EnableEurekaServer
@EnableEurekaServer is an annotation used in Java with Spring Boot applications to indicate that the application should act as a Eureka Server.

# @LoadBalanced
The @LoadBalanced annotation is used to mark a Spring RestTemplate or a WebClient bean as one that should use Ribbon (if Ribbon is on the classpath) for client-side load balancing.