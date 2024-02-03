
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