
## Annotations Used by Entities

### @Entity
Indicates that a class is an entity. This annotation is applied to the class name.
```java
@Entity
public class ExampleEntity {
    // class body
}
```

### @Id
Marks a field as the primary key of an entity.
```java
@Entity
public class ExampleEntity {
    @Id
    private Long id;
    // other fields and methods
}
```

### @Column
Specifies the mapped column for a persistent property or field. If no Column annotation is specified, the default values apply.
```java
@Entity
public class ExampleEntity {
    @Id
    private Long id;
    
    @Column(name = "example_column", nullable = false)
    private String exampleField;
    // other fields and methods
}
```

## Annotations Used by Controllers

### @Controller
Indicates that a particular class serves the role of a controller.
```java
@Controller
public class ExampleController {
    // class body
}
```

### @RequestMapping
Annotation for mapping web requests onto specific handler classes and/or handler methods.
```java
@Controller
public class ExampleController {
    
    @RequestMapping("/example")
    public String exampleMethod() {
        return "example";
    }
}
```

### @GetMapping
A composed annotation that acts as a shortcut for @RequestMapping(method = RequestMethod.GET).
```java
@Controller
public class ExampleController {
    
    @GetMapping("/example")
    public String exampleGetMethod() {
        return "example";
    }
}
```

##HW42
### @RestController
A convenience annotation that is itself annotated with @Controller and @ResponseBody. It indicates that the class is a controller where every method returns a domain object instead of a view.
```java
@RestController
public class GreetingController {
    
    @GetMapping("/greeting")
    public String greeting() {
        return "Hello, World";
    }
}
```

### @PathVariable
Indicates that a method parameter should be bound to a URI template variable. Used on Spring MVC and Spring WebFlux handler methods.
```java
@RestController
public class UserController {
    
    @GetMapping("/users/{id}")
    public User getUserById(@PathVariable Long id) {
        return new User(id, "John Doe");
    }
}
```
### @Autowired
Marks a constructor, field, setter method, or config method as to be autowired by Spring's dependency injection facilities.
```java
@Service
public class UserService {
    
    private final UserRepository userRepository;
    
    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
}
```

### @Repository
Indicates that an annotated class is a "Repository", a mechanism for encapsulating storage, retrieval, and search behavior which emulates a collection of objects.
```java
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
```

### @Service
Indicates that an annotated class is a "Service", originally defined by Domain-Driven Design (DDD) as "an operation offered as an interface that stands alone in the model, with no encapsulated state."
```java
@Service
public class BookingService {
    
    public boolean bookFlight(String flightNumber) {
        // Business logic to book a flight
        return true;
    }
}
```

### @RequestBody
Annotation indicating a method parameter should be bound to the body of the web request. Used on Spring MVC handler methods.
```java
@RestController
public class BookingController {
    
    @PostMapping("/book")
    public String bookFlight(@RequestBody FlightBooking bookingDetails) {
        // Logic to handle booking
        return "Booking successful";
    }
}
```

### @Bean
Used to indicate that a method instantiates, configures, and initializes a new object to be managed by the Spring IoC container.
```java
@Configuration
public class AppConfig {
    
    @Bean
    public MyBean myBean() {
        return new MyBean();
    }
}
```

### @SpringBootApplication
A convenience annotation that adds all of the following: @Configuration, @EnableAutoConfiguration, and @ComponentScan. It's used to mark the main class of a Spring Boot application.
```java
@SpringBootApplication
public class Application {
    
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
```

### @Transactional
Describes a transaction attribute on an individual method or on a class. When declared at the class level, it applies as a default to all methods of the class.
```java
@Service
public class AccountService {
    
    @Transactional
    public void transferMoney(Long sourceAccountId, Long targetAccountId, BigDecimal amount) {
        // Logic to transfer money between accounts
    }
}
```

### @Query
Used to declare finder queries directly on repository methods. Supports both JPQL and native queries.
```java
public interface UserRepository extends JpaRepository<User, Long> {
    
    @Query("SELECT u FROM User u WHERE u.email = ?1")
    User findByEmailAddress(String emailAddress);
}
```

### @RequestParam
Indicates that a method parameter should be bound to a web request parameter. Used on Spring MVC handler methods.
```java
@RestController
public class ParameterController {
    
    @GetMapping("/find")
    public String findUser(@RequestParam String name) {
        return "Finding user by name: " + name;
    }
}
```

### @Component
A generic stereotype for any Spring-managed component. @Repository, @Service, and @Controller are specializations of @Component for more specific use cases.
```java
@Component
public class UtilityComponent {
    
    public String getApplicationStatus() {
        return "Running";
    }
}
```

### @ExceptionHandler
An annotation used to define a method for handling exceptions specifically in the current controller or globally for the entire application.
```java
@ControllerAdvice
public class GlobalExceptionHandler {
    
    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<Object> handleException(Exception e) {
        return new ResponseEntity<>("An error occurred", HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
```

### @Configuration
Indicates that a class declares one or more @Bean methods and may be processed by the Spring container to generate bean definitions and service requests for those beans at runtime.
```java
@Configuration
public class WebConfig {
    
    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**").allowedOrigins("http://example.com");
            }
        };
    }
}
```

### @ControllerAdvice
A specialization of @Component for classes that declare @ExceptionHandler, @InitBinder, or @ModelAttribute methods to be shared across multiple @Controller classes.
```java
@ControllerAdvice
public class AppControllerAdvice {
    
    @ModelAttribute("currentTime")
    public LocalDateTime getCurrentTime() {
        return LocalDateTime.now();
    }
}
```

### @ResponseBody
Indicates that a method return value should be bound to the web response body. Used on Spring MVC handler methods.
```java
@Controller
public class SimpleController {
    
    @GetMapping("/text")
    @ResponseBody
    public String simpleTextResponse() {
        return "Just a simple text response";
    }
}
```

### @OneToMany
Defines a many-to-one relationship between two entities. It is used to map a collection of entities on the 'many' side of the relationship.
```java
@Entity
public class Post {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Comment> comments = new ArrayList<>();
}
```

## HW42-43
### @Aspect
Indicates that a class is an aspect. Aspects are part of Aspect-Oriented Programming (AOP), which allows for separation of cross-cutting concerns (like logging, security, etc.) from the business logic.
```java
@Aspect
@Component
public class LoggingAspect {
}
```

### @Pointcut
Defines a pointcut, which is a set of one or more join points where an advice should be executed. Pointcuts help to specify when certain actions (advices) should be taken.
```java
@Aspect
public class ApplicationLoggingAspect {

    @Pointcut("execution(* com.example.service.*.*(..))")
    public void forServiceLayer() {
    }
}
```

### @AfterThrowing
Defines an advice that runs after a method throws an exception. It can be used for exception logging or cleanup after the method execution fails.
```java
@Aspect
public class LoggingAspect {

    @AfterThrowing(pointcut = "execution(* com.example.service.*.*(..))", throwing = "ex")
    public void logAfterThrowing(Exception ex) {
        System.out.println("An exception has been thrown: " + ex.getMessage());
    }
}
```

### @Before
Defines an advice that runs before the advised method is invoked. It can be used for tasks such as logging method entry, security checks, or initialization.
```java
@Aspect
public class SecurityAspect {

    @Before("execution(* com.example.service.*.*(..))")
    public void checkAuthentication(JoinPoint joinPoint) {
        // Authentication logic here
    }
}
```

### @After
Defines an advice that runs after the advised method completes, regardless of the outcome. This can be used for logging, security checks, or resource cleanup.
```java
@Aspect
public class LoggingAspect {

    @After("execution(* com.example.service.*.*(..))")
    public void logAfter(JoinPoint joinPoint) {
        System.out.println("Completed: " + joinPoint.getSignature());
    }
}
```

### @Around
Defines an advice that surrounds an advised method execution. It is the most powerful advice type because it allows you to perform custom behavior before and after the method invocation, as well as if you choose, to not proceed with the method invocation at all.
```java
@Aspect
public class PerformanceAspect {

    @Around("execution(* com.example.service.*.*(..))")
    public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();
        
        Object proceed = joinPoint.proceed();
        
        long executionTime = System.currentTimeMillis() - start;
        System.out.println(joinPoint.getSignature() + " executed in " + executionTime + "ms");
        return proceed;
    }
}
```

## HW45
### @SpringBootTest
Used to provide a bridge between Spring Boot test features and JUnit. Whenever we are testing Spring Boot applications, this annotation will load the complete application context to be available for testing.
```java
@SpringBootTest
public class ApplicationTests {

    @Test
    public void contextLoads() {
        // test case
    }
}
```

### @Spy
Used with Mockito to create a spy instance. Spies are used when we want to partially mock an object. By default, real methods are called on a spy. However, we can override this behavior for specific methods.
```java
public class SampleServiceTest {

    @Spy
    private List<String> spyList = new ArrayList<>();

    @Test
    public void testSpy() {
        spyList.add("one");
        Mockito.verify(spyList).add("one");
        assertEquals(1, spyList.size());
    }
}
```

### @BeforeEach
An annotation used with JUnit 5 to denote that the annotated method should be executed before each @Test method in the current test class. It's used for repetitive setup tasks.
```java
public class CalculatorTests {

    private Calculator calculator;

    @BeforeEach
    public void setUp() {
        calculator = new Calculator();
    }

    @Test
    public void testAdd() {
        assertEquals(2, calculator.add(1, 1));
    }
}
```

### @BeforeAll
Used with JUnit 5 to indicate that the annotated method should be executed once before all tests in the current test class. It's ideal for expensive setup tasks that only need to be performed once.
```java
public class DatabaseTests {

    private static Database database;

    @BeforeAll
    public static void initDatabase() {
        database = new Database();
        database.connect();
    }

    @AfterAll
    public static void closeDatabase() {
        database.disconnect();
    }
}

```

### @AfterEach
An annotation used with JUnit 5 to denote that the annotated method should be executed after each @Test method in the current test class. It's typically used for cleanup tasks.

```java
public class CalculatorTests {

    private Calculator calculator = new Calculator();

    @AfterEach
    public void tearDown() {
        calculator.clear();
    }

    @Test
    public void testAdd() {
        assertEquals(2, calculator.add(1, 1));
    }
}


```

### @AfterAll
Used with JUnit 5 to indicate that the annotated method should be executed once after all tests in the current test class are executed. It's used for cleanup tasks that only need to be performed once.


```java
public class DatabaseTests {

    private static Database database = new Database();

    @BeforeAll
    public static void initDatabase() {
        database.connect();
    }

    @AfterAll
    public static void closeDatabase() {
        database.disconnect();
    }
}
```