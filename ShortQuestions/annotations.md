# Annotations

```plaintext
@Component
Indicates that a class annotated with it is a "component" and becomes a Spring-managed bean. When using annotation-based configuration and classpath scanning, these classes are considered automatically detected candidates. Additionally, @Component is also a meta-annotation.

@Service
A composed annotation (composed of @Component) used in the service layer (business logic layer).

@Repository
A composed annotation (composed of @Component) used in the data access layer (data access layer).

@Controller
A composed annotation (composed of @Component) used in the MVC layer (controller layer). DispatcherServlet automatically scans classes annotated with this annotation and maps web requests to methods annotated with @RequestMapping.

@RequestMapping
Used to map web requests, including defining the access path and parameters (can be applied to classes or methods).

@ResponseBody
Supports placing the return value directly in the response body instead of rendering a page. Typically used for returning JSON data (applied next to the return value or at the method level).

@RequestBody
Allows request parameters to be in the request body instead of directly attached to the URL. Applied to method parameters.

@PathVariable
Used to receive path parameters, e.g., when declaring paths with @RequestMapping("/hello/{name}"). Place the annotation in front of the parameter to retrieve its value, often used for implementing Restful interfaces.

@RestController
A composed annotation (combination of @Controller and @ResponseBody). Applied at the class level, meaning that all methods in this controller are, by default, annotated with @ResponseBody.

@ExceptionHandler
Used to globally handle exceptions in controllers.

@ModelAttribute
Originally used to bind key-value pairs to the Model. In @ControllerAdvice, it makes key-value pairs set here globally available to all @RequestMapping methods.

@Autowired
Spring's tool for automatic dependency injection. Automatically injected by Spring's dependency injection tools (BeanPostProcessor, BeanFactoryPostProcessor).

@Configuration
Declares the current class as a configuration class, equivalent to a Spring configuration XML file (applied at the class level).

@Bean
An annotation applied to a method, declaring that the method's return value is a bean. The returned bean class can define init() and destroy() methods, which are executed after construction and before destruction, respectively (applied at the method level).

@ComponentScan
Automatically scans all classes in the specified package using @Service, @Component, @Controller, and @Repository annotations, and registers them (applied at the class level).

@Aspect
Declares an aspect (applied at the class level). Uses @After, @Before, @Around to define advice, and the interception rules (pointcuts) are passed as parameters.

@After: Executed after the method.
@Before: Executed before the method.
@Around: Executed before and after the method.
@Pointcut: Declares a pointcut.
@EnableAspectJAutoProxy
Used in a Java configuration class to enable Spring's support for AspectJ proxies (applied at the class level).

@Scope
Defines the mode used to create a bean (applied at the method level, in conjunction with @Bean). Possible types include:
- Singleton: A single bean instance for the entire Spring container (default mode).
- Prototype: A new bean instance for each call.
- Request: A new bean instance for each HTTP request (web projects).
- Session: A new bean instance for each HTTP session (web projects).
- GlobalSession: A new bean instance for each global HTTP session (web projects).

@PostConstruct
Applied to a method, indicating that the method should be executed after construction.

@PreDestroy
Applied to a method, indicating that the method should be executed before the object is destroyed.

@Value
Often used with Spring Expression Language (SpEL) to inject plain characters, system properties, expression results, other bean properties, file contents, web request contents, or configuration file properties.

@EnableAsync
Applied at the class level in a configuration class, enabling support for asynchronous tasks by implementing the AsyncConfigurer interface.

@Async
Applied to methods in actual beans to declare them as asynchronous tasks (applied at the method level or on all methods in a class if @EnableAsync is used to enable asynchronous tasks).

@EnableScheduling
Used in a configuration class, enabling support for scheduled tasks (applied at the class level).

@Scheduled
Declares a method as a scheduled task, including cron, fixDelay, fixRate, etc. (applied at the method level, requires enabling scheduled task support).

@Enable*
Annotations that indicate enabling support for specific features. For example:
- @EnableAspectJAutoProxy: Enables support for AspectJ auto-proxy.
- @EnableAsync: Enables support for asynchronous methods.
- @EnableScheduling: Enables support for scheduled tasks.
- @EnableWebMvc: Enables Web MVC configuration support.
- @EnableConfigurationProperties: Enables support for @ConfigurationProperties annotated configuration beans.
- @EnableJpaRepositories: Enables support for Spring Data JPA repositories.
- @EnableTransactionManagement: Enables annotation-driven transaction management.
- @EnableTransactionManagement: Enables annotation-driven transaction management.
- @EnableCaching: Enables annotation-driven caching.

```

---

# more annotation

1. `@Service`: This annotation marks service layer classes, indicating that the class is a service class used for writing business logic.

2. `@SpringBootApplication`: It serves as the entry point of a Spring Boot application.

3. `@RestController`: This annotation is utilized to define RESTful web services. It is applied to a class to signify that the class handles HTTP requests. Each method's return value is automatically serialized to JSON or XML and returned as the HTTP response body.

    Example:

    ```java
    @RestController
    public class MyController {
        @GetMapping("/greet")
        public String greet() {
            return "Hello World.";
        }
    }
    ```

    In this example, the `@GetMapping` annotation on the `greet()` method indicates that it responds to GET requests. When accessing the URL like `/greet`, the string returned by the method is sent back to the client directly as the body of the HTTP response.

4. `@Autowired`: This annotation is employed for automatic dependency injection, eliminating the need to write getters and setters.

5. `@RequestMapping`: It is used for mapping a specific request path to the entire controller or method.

Example:

```java
@Controller
@RequestMapping("/users")
public class UserController {
    @RequestMapping(value = "/{userId}", method = RequestMethod.GET)
    public String getUser(@PathVariable String userId) {
        // Handle the request to get a user
    }
    @RequestMapping(value = "/{userId}/posts", method = RequestMethod.POST)
    public String addUserPost(@PathVariable String userId) {
        // Handle the request to add a user post
    }
}
```

8. `@OneToMany`: This annotation is used to establish a one-to-many relationship between two entities.

    Example:

    ```java
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Order> orders;
    ```

    In this code, it signifies that one user has many orders. Cascade type `ALL` means that all operations on the user will be propagated to orders. `FetchType.LAZY` implies that the related entities won't be loaded until accessed, suitable for high access or low-frequency access scenarios. If `FetchType.EAGER` is used, it means loading all related entities immediately. Generally, `@OneToMany` is `LAZY`, while `@OneToOne` and `@ManyToOne` are `EAGER`.

9. `@JsonProperty`: This annotation is utilized to establish a mapping between Java objects and JSON data. It can customize serialization and deserialization.

10. `@JoinColumn`: It represents the connection between two tables. For instance, in the `Comment` entity, the `@ManyToOne` annotation is applied to the `post` variable, indicating that many comments correspond to one post. On the `post` variable, `@JoinColumn(name = "post_id", nullable = false)` signifies that `comment` and `post` are two tables sharing `post_id` as a connection, also known as a foreign key.

11. `@PostMapping`: This annotation is used to map HTTP POST requests to a specific handler method.

    Example:

    ```java
    @RestController
    public class MyController {
        @PostMapping("/register")
        public String registerUser(@RequestBody User user) {
            // Handle user registration
        }
    }
    ```

12. `@Entity`: It is employed to map a regular Java class to a table in a database. `@Table` is used to map to a specific table in the database. `@Id` indicates that the `id` field is the primary key of the entity. `@GeneratedValue` can generate the ID automatically.

    Example:

    ```java
    @Entity
    @Table(name = "example_table")
    public class ExampleEntity {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @Column(name = "title", nullable = false)
        private String title;

        @CreationTimestamp
        private LocalDateTime createDateTime;

        @UpdateTimestamp
        private LocalDateTime updateDateTime;
    }
    ```
