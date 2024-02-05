Example 1

```
@SpringBootApplication
public class MyApplication {

    public static void main(String[] args) {
        SpringApplication.run(MyApplication.class, args);
    }
}

```

**@SpringBootApplication:** This annotation is used to mark the main class of a Spring Boot application.

Example 2

```
@RestController
public class HelloController {

    @GetMapping("/hello")
    public String hello() {
        return "Hello, World!";
    }
}

```

**@RestController:** This annotation is used to define a controller class in Spring MVC that handles HTTP requests and returns the response in JSON or XML format.

**@GetMapping:** Indicates that the annotated method handles HTTP GET requests.

Example 3

```
@Service
public class MyService {

    private final MyRepository repository;

    @Autowired
    public MyService(MyRepository repository) {
        this.repository = repository;
    }

    // other methods
}
```

**@Service:** Marks a class as a service or business logic component that should be managed by the Spring container.

**@Autowired:** This annotation is used to automatically wire beans into the annotated class by Spring's dependency injection mechanism.

Example 4

```
@Component
public class MyComponent {
    // bean definition
}
```

**@Component:** This annotation is used to denote that a class is a Spring component. Spring will automatically detect and register this bean during component scanning.

Example 5

```
@Repository
public interface MyRepository extends JpaRepository<MyEntity, Long> {
    // custom methods
}
```

**@Repository:** This annotation is used to indicate that a class is a repository, typically a Spring Data repository for database access.

Example 6

```
@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "full_name", nullable = false, length = 100)
    private String fullName;

    @Column(name = "email", nullable = false, unique = true)
    private String email;
}

```

**@Entity:** Indicates a class should represents a database table.

**@Id:** Marks the field id as the primary key of the entity.

**@GeneratedValue(strategy = GenerationType.IDENTITY):** Specifies that the primary key should be generated automatically by the database. It's commonly used for auto-incremented primary keys in databases like MySQL.

**@Column:** It used to customize the mapping of entity attributes to database table columns. I
