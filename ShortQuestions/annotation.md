### Core Annotations:
`@SpringBootApplication:`
This annotation is used to mark the main class of a Spring Boot application. 
Combines `@Configuration, @EnableAutoConfiguration, and @ComponentScan`.
```Java
@SpringBootApplication

// Class
public class DemoApplication {

	// Main driver method
	public static void main(String[] args)
	{

		SpringApplication.run(DemoApplication.class, args);
	}
}

```
`@Controller:`
Indicates that the class serves the controller role, playing a pivotal role in handling web requests. 
```Java
@Controller
@RequestMapping(“cars”)
public class CarsController {
    @RequestMapping(value= “/{name}”, method= RequestMethod.GET)
    public Employee getCarsByName() {
        Return carsTemplate;
    }
}
```

`@RestController:`
Combines @Controller and @ResponseBody.
Used for RESTful web services.

`@Service:`
It is used at the class level. It shows that the annotated class is a service class, such as business basic logic, and call external APIs.
```Java
@Service
public class TestService
{
    public void service1(){
    // business code
    }
}
```

`@Repository:`
It is a Data Access Object (DAO) that accesses the database directly. It indicates that the annotated class is a repository. 
```Java
@Repository
public interface PostRepository extends JpaRepository<Post, Long> {}
```

`@Component:`
Marks a class as a Spring component, allowing it to be scanned and initialized by Spring.

`ComponentScan`
Specifies the range that Spring should scan to detect and registers Spring components

### Configuration Annotations:
`@Configuration:`
Indicates that a class provides bean definitions.

`@Bean:`
Marks a method to produce a bean to be managed by the Spring container.


### Dependency Injection Annotations:
`@Autowired:`
This annotation is used to auto-wire spring bean on setter methods, constructor and instance variable. It injects object dependency implicitly. When we use this annotation, the spring container auto-wires the bean by its matching data type.

`@Qualifier:`
Used along with @Autowired to specify which bean to inject when multiple candidates are available.

`Primary:`
It is used to indicate a primary bean when multiple beans of the same type are available.

### Request Handling Annotations:
`@RequestMapping:`
Maps HTTP requests to handler methods.
```Java
@RequestMapping("/api/v1/posts")
```

`@GetMapping, @PostMapping, @PutMapping, @DeleteMapping:`
Shortcut annotations for @RequestMapping with specific HTTP methods.
```Java
@RestController
@RequestMapping("/api/v1/posts")
public class PostController {

    @Autowired
    private PostService postService;

    @PostMapping
    public ResponseEntity<PostDto> createPost(@RequestBody PostDto postDto) {
        PostDto response = this.postService.createPost(postDto);
        return new ResponseEntity<>(response, HttpStatus.CREATED);

    }

    @GetMapping
    public ResponseEntity<List<PostDto>> getAllPost() {
        return new ResponseEntity<>(this.postService.getAllPost(), HttpStatus.OK);

    }
```

`@RequestParam:`
Binds parameters in the query string of a URL to method parameters.

```Java

@RestController
public class MyController{

    @GetMapping("/authors")
    public String getAuthors(@RequestParam(name="authorName") String name){
        //insert code here
    }
}
```

`@PathVariable:`
Extracts values from the URI template.
```Java
@PutMapping("/{id}")
    public ResponseEntity<PostDto> updatePostById(@RequestBody PostDto postDto, @PathVariable(name="id") long id) {
        PostDto response = this.postService.updatePostById(postDto, id);
        return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
    }
```

`@RequestBody:`
Binds the body of a request to a method parameter.
```Java
@PutMapping("/{id}")
    public ResponseEntity<PostDto> updatePostById(@RequestBody PostDto postDto, @PathVariable(name="id") long id) {
        PostDto response = this.postService.updatePostById(postDto, id);
        return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
    }
```

### Data Access Annotations:
`@Entity:`
It is used at the class level and marks the class as a persistent entity. It signals to the JPA provider that the class should be treated as a table in the database.
```Java
@Entity
public class Employee {
    // code here
}
```

`@Table`
It provides the specifics of the corresponding database table including the name of the table, the catalog and the schema.
```Java
@Table(
        name = "posts",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = {"title"})

        }
)
```

`@Id`, `@GeneratedValue:`
Each JPA entity must have a primary key that uniquely identifies it. The @Id annotation defines the primary key. We can generate the identifiers in different ways, which are specified by the @GeneratedValue annotation. We can choose from four id generation strategies with the strategy element. The value can be `AUTO, TABLE, SEQUENCE, or IDENTITY`:
```Java
@Entity
public class Student {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    
    private String name;
    
    // getters and setters
}
```

`@Column:`
we can use the @Column annotation to mention the details of a column in the table.

The @Column annotation has many elements such as name, length, nullable, and unique:
```Java
@Entity
@Table(name="STUDENT")
public class Student {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    
    @Column(name="STUDENT_NAME", length=50, nullable=false, unique=false)
    private String name;
    
    // other fields, getters and setters
}
```

`@OneToMany, @ManyToOne, @ManyToMany`

`@Repository:`
Indicates that a class is a data repository.

`@Transactional:`
Specifies that a method is transactional.

### Testing Annotations:
`@SpringBootTest:`
Used to specify the configuration of the ApplicationContext.

`@RunWith(SpringRunner.class):`
Indicates that a JUnit class should use Spring's JUnit runner when running tests.

`@MockBean:`
Mocks a bean in the Spring context.

#### Validation Annotations:
`@NotNull`: Ensures that the annotated element is not null.
`@NotEmpty`: Ensures that the annotated element is not null and not an empty string.
`NotBlank`: Ensures that the annotated element is not null and contains at least one non-whitespace character.
`@Size`: Specifies the size constraints of a string, collection, or array.
`@Min, @Max`: Specifies the minimum and maximum values for numeric types.
`@Email`: Ensures that the annotated element is a valid email address.
`@Pattern`: Specifies a regular expression pattern that the annotated element must match.
`@AssertTrue, @AssertFalse`: Ensures that the annotated element is true or false, respectively.
`@Valid`: Used to validate nested objects.

### Others:
`@Value:`
Injects values from application properties into a Spring bean.

`@ConfigurationProperties:`
Binds and validates the application properties.