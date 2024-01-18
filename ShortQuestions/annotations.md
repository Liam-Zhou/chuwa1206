1. create a file to list all of the annotations you learned and known, and explain the **usage** and **how do you understand** it. you need to update it when you learn a new annotation. Please organize those annotations well, like annotations used by entity, annotations used by controller.
   1. File name: **annotations.md**
   2. you'd better also list a **code example** under the annotations.

# Annotations used by **entity**

- @Entity

Used at a class level and mark the POJO class as a persistent entity that can be stored in tables in a database

```
 @Entity
 public class Post
```

- @Table

Used to specify the table used to persist the data in the database

```
@Table(
      name = "posts"
)
```

- @UniqueConstraint

Used to annotate multiple unique keys in the table level

```
@UniqueConstraint(columnNames = {"title"})
```

- @Id

Used to denote the primary key column

```
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private long id;
```

- @GeneratedValue

Used to specify the primary key generation strategy

```
@GeneratedValue(strategy = GenerationType.IDENTITY)
```

- @Column

Used to customize the mapping between entity field and database column

```
 @Column(name = "title", nullable = false)
 private String title;
```

- @CreationTimestamp

Used to track creation time of the record and persist into the database

```
 @CreationTimestamp
 private LocalDateTime createDateTime;
```

- @UpdateTimestamp

```
 @UpdateTimestamp
 private LocalDateTime updateDateTime;
```

Used to track latest update time of the record and persist into the database

- @NamedQuery

Creates a JPQL statement in the entity class that can be used by the EntityManager in repository to query data from database.

```
  @NamedQuery(name="Post.getAll", query="select p from Post p")
```

# Annotations used by **controller**

- @RestController

@Controller + @ResponseBody, used to create RESTful web services using Spring MVC

```
@RestController
@RequestMapping("/api/v1/posts")
public class PostController
```

- @RequestMapping

Maps requests to controller methods

```
@RestController
@RequestMapping("/api/v1/posts")
public class PostController
```

- @PostMapping (@GetMapping, @PutMapping, @DeleteMapping)

Maps URLs to handlers that receive and process data submitted through POST requests

```
@PostMapping
public ResponseEntity<PostDto> createPost(@RequestBody PostDto postDto) {}
```

- @Service

A version of @Component to denote a service class

```
@Service
public class PostServiceImpl implements PostService {}
```

- @RequestBody

Captures the request body and convert it to DTO

```
public ResponseEntity<PostDto> createPost(@RequestBody PostDto postDto)
```

- @RequestParam

maps request parameters to controller parameters

```
@RequestParam(value = "pageNo", defaultValue = AppConstants.DEFAULT_PAGE_NUMBER, required = false) int pageNo
```

- @PathVariable

maps path variables to controller parameters

```
public ResponseEntity<PostDto> getPostById(@PathVariable(name = "id") long id)
```

# Annotations used by **repository**

- @Transactional

Used to mark a class or a method. Any database operation performed within the class or method marked as transactional will be performed within a transaction.

```
@Transactional
public class PostJPQLRepositoryImpl implements PostJPQLRepository
```

- @PersistenceContext

Used to inject EntityManager.

```
@PersistenceContext
EntityManager entityManager;
```

- @Query

Used in Spring JPA to define customized JPQL and SQL queries.

```
@Query("select p from Post p where p.id = :key or p.title = :title")
Post getPostByIDOrTitleWithJPQLNamedParameters(@Param("key") Long id,
                                                @Param("title") String title);
```

- @Param

Maps input parameters to named placeholders in the query above.

```
@Query("select p from Post p where p.id = :key or p.title = :title")
Post getPostByIDOrTitleWithJPQLNamedParameters(@Param("key") Long id,
                                                @Param("title") String title);
```

# Annotations used by **dependency injection**

- @Autowired
- @Resource
- @Inject

Used to inject Beans into Beans

```
@Autowired
private PostService postService;
```

- @Component

Allows Spring to detect our custom beans to inject into the framework

```
@Component
public class ComponentExample {
}
```

- @Service

A component annotation that marks the current class being service component

```
@Service
public class PostService {
}
```

- @Repository

A component annotation that marks the current class being persistance component, acting as database

```
@Repository
public interface PostRepository extends JpaRepository {
}
```

- @Controller

A component annotation that marks the current class being Controller component

```
@Controller
public class ControllerExample {
}
```

- @ControllerAdvice

Allows handling exceptions across the whole application in one global handling component

```
@ControllerAdvice
public class GlobalExceptionHandler
```

- @Bean

Applied on a method to specify that it returns a bean to be managed by the Spring context

```
@Bean
public ModelMapper modelMapper() {
    return new ModelMapper();
}
```

- @ComponentScan

Used by Spring framework for auto-detecting and registering spring-managed components within a specified package or a set of packages.

```
@Configuration
@ComponentScan
public class SpringComponentScanApp
```

- @SpringBootApplication

Combination of @Configuration, @EnableAutoConfiguration, and @ComponentScan

```
@SpringBootApplication
public class BankStatementApplication {
	public static void main(String[] args) {
		SpringApplication.run(BankStatementApplication.class, args);
	}
}
```

- @Configuration

declares a class as the source for bean definitions

```
@Configuration
public class Configuration {
}
```

- @Primary

indicates that a bean should be given preference when multiple beans are candidates to be autowired to a single-valued dependency

```
@Bean
@Primary
public MovieCatalog firstMovieCatalog() { ... }
```

- @Qualifier

to resolve the ambiguity by specifying which bean should be autowired when there are multiple beans of the same type

```
@Autowired
@Qualifier("fooFormatter")
private Formatter formatter;
```
