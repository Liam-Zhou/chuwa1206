1. @Entity
2. @Table
3. @UniqueConstraint
3. @Id
4. @GeneratedValue
5. @Column
6. @CreationTimestamp
7. @UpdateTimestamp

```
@Entity
@Table(
name = "posts",
uniqueConstraints = {@UniqueConstraint(columnNames = {"title"})}
)
public class Post {
    @Id
    @GeneratedValue(
        strategy = GenerationType.IDENTITY
     )
    private Long id;
    @Column(nullable = false)
    private String title;
    @Column(name = "description", nullable = false)
    private String description;
    @Column(name = "content", nullable = false)
    private String content;
    @CreationTimestamp
    private LocalDateTime createDateTime; 
    @UpdateTimestamp
    private LocalDateTime updateDateTime;
}
```

8. @Repository ```public interface PostRepository extends JpaRepository<Post, Long> {
   // No need to write code
   }```
9. @Service ```@Service
   public class PostServiceImpl implements PostService {```
10. @Override
11. @RestController
12. @RequestMapping

```
@RestController
@RequestMapping("/api/v1/posts")
public class PostController { 
```
13. @Autowired ```@Autowired
    private PostService postService;```
14. @PostMapping
15. @RequestBody
```
@PostMapping
public ResponseEntity<PostDto> createPost(@RequestBody PostDto postDto) {
return new ResponseEntity<>(postService.createPost(postDto), HttpStatus.CREATED);
 }
```

16. @RequestParam: is to bind a web request parameter to a method parameter.
17. @Controller: is used to define a class as a Spring MVC controller.
18. @QueryMapping: binds this method to a query, a field under the Query type. The query field is then determined from the method name. (GraphQL)
19. @Argument: binds a named GraphQL argument onto a method parameter.
20. @ResponseStatus: causes Spring boot to respond with the specified HTTP status code whenever this exception is thrown from your controller.
21. @GetMapping: is used to map HTTP GET requests to specific handler methods in your controller, specifically designed for handling HTTP GET operations.
22. @PutMapping: is used to map HTTP PUT requests to specific handler methods in your controller, specifically designed for handling HTTP PUT operations.
23. @DeleteMapping: is used to map HTTP PUT requests to specific handler methods in your controller, specifically designed for handling HTTP DELETE operations.

24. @OneToOne: is to establish a one-to-one relationship between two entities.
```@OneToOne(mappedBy = "another_table_name", cascade = CascadeType.ALL)```
25. @JoinColumn: is to specify the details of a foreign key column in a relational database table.
26. @ManyToOne: indicates a many-to-one relationship between two entities. ```@ManyToOne(fetch = FetchType.LAZY)```
27. @OneToMany: indicating a one-to-many relationship between two entities.
28. @ManyToMany: is used to define a many-to-many relationship between two entities
29. @JoinTable: is used to specify the join table that will store the relationships
```@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToMany
    @JoinTable(
      name = "student_course",
      joinColumns = @JoinColumn(name = "student_id"),
      inverseJoinColumns = @JoinColumn(name = "course_id"))
    private Set<Course> courses;

    // other fields, getters, setters, etc.
}

@Entity
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToMany(mappedBy = "courses")
    private Set<Student> students;

    // other fields, getters, setters, etc.
}
```
30. @NamedQuery: allow you to define queries in a central location (usually within the entity class) and reference them by name when executing operations.
31. @PersistenceContext: is to inject an EntityManager into a component. The EntityManager is a part of the Java Persistence API (JPA) and is responsible for managing the lifecycle of entities in a persistence context.
32. @NamedQueries: allow you to define multiple @NamedQuery.
33. @Query: It is used to declare custom queries directly within repository interfaces.
34. @Param: is used in conjunction with the @Query annotation in Spring Data JPA to bind method parameters to named parameters in JPQL or native SQL queries.
35. @Transactional: is applied at the class level in Spring, it means that all public methods of that class are transactional. This is useful when you want to ensure that all methods within the class are executed within a transactional context. It provides a convenient way to define a default transactional behavior for all methods in the class.
36. @EnableTransactionManagement: enable @Transactional.
37. @Bean: declare a method as a bean。
38. @Configuration: used to indicate that a class declares one or more @Bean methods
39. @ControllerAdvice: allows you to define global elements (such as exception handlers or model attributes) that can be applied to all controllers in the application.
40. @ExceptionHandler: define a method that handles exceptions thrown by controller methods. When an exception occurs during the execution of a controller method, and that exception is of the type specified in the @ExceptionHandler annotation, the annotated method is invoked to handle the exception.
41. @valid: commonly used in combination with @RequestBody to validate the incoming request body in a Spring MVC controller
42. @NotNull: It ensures that the annotated property is not null. If the property is null, a validation error will be triggered.
43. @Size: This annotation is used to define the size constraints for a property. It can be applied to strings, collections, and arrays. You can specify the minimum and maximum size allowed.
44. @NotEmpty: This annotation is a composition of @NotNull and @Size(min = 1)
45. @ComponentScan:  directs Spring to search for components in the
    path specified
46. @SpringBootApplication: @Configuration + @EnableAutoConfiguration + @ComponentScan
47. @Qualifier: specify which bean should be injected when multiple beans of the same type exist in the Spring context.
48. @Primary:  indicate a primary bean when multiple beans of the same type exist in the Spring context.
49. @Value: is a Spring annotation used for injecting values into fields of a Spring bean, typically within a Spring component or configuration class. It is commonly used to inject values from configuration files, properties files, or environment variables.
50. @Aspect: is often used in AOP frameworks to declare a class as an aspect. 
51. @Order: The @Order annotation in Spring is used to specify the order in which components should be processed or executed. 
52. @Before:  Run before the method execution
53. @After: Run after the method returned a result
54. @AfterReturning – Run after the method returned a result, intercept the
    returned result as well.
55. @AfterThrowing – Run after the method throws an exception
56. @Around – Run around the method execution, combine all three advices above.
57. @EnableScheduling: is used in a Spring Boot application to enable the scheduling of tasks using the Spring Framework's @Scheduled annotation.
58. @Scheduled: is used to define scheduled tasks. It allows you to specify when a method should be executed at fixed intervals or according to a cron expression.
59. 



