# Annotations

## Entities

### @Entity

- map a class to a table through JPA (specify this annotation at the class level)

### @Table

- use this annotation if the table in the DB and the name of the entity is not the same

### @Id

- The primary key of each entity (unique), we can auto-generate the id with `@GeneratedValue` (we can use any of AUTO, TABLE, SEQUENCE, IDENTITY)

### @Column

- to mark the details of a column in the table, e.g. name, length, nullable, unique, etc.

### @CreationTimestamp, @UpdateTimestamp

- The `@CreationtTimestamp` is an annotation that sets the field value to the current timestamp when the entity is first saved.
- The `@UpdateTimestamp` is another annotation provided by Hibernate. It automatically sets the field value to the current timestamp on each entity update. 

```java
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
    private long id;

    @Column(nullable=false)
    private String title;

    @Column(name="description", nullable=false)
    private String description;

    @Column(name="content", nullable=false)
    private String content;

    @CreationTimestamp
    private LocalDateTime createDateTime;

    @UpdateTimestamp
    private LocalDateTime updateDateTime;
}
```

### @ManyToOne, @OneToMany, @ManyToMany, @JoinColumn



-  shows the relationships in relational databases -> foreign key



```java
@OneToOne(cascade=CascadeType.ALL)
@JoinColumn(name="profile_id", referencedColumnName="id")
private PlayerProfile playerProfile;


// In Comments
@ManyToOne(fetch=FetchType.LAZY)
@JoinColumn(name="post_id", nullable=false)
private Post post;
// In Post
@OneToMany(mappedBy="post", CascadeType.ALL, orphanRemoval=true)
private Set<Comment> comments = new HashSet<>();


@ManyToMany(fetch=FetchType.LAZY)
@JoinColumn(name="sku_inventory", joinColumns=@JoinColumn(name="sku_id"), inverseJoinColumns=@JoinColumn(name="inventory_id"))
private Set<PmsInventory> pmsInventories = new HashSet<>();
```



## Controller and API Annotations

### @Controller

- We can annotate classic controllers with the `@Controller` annotation. This is simply a specialization of the `@Component` class, which allows us to auto-detect implementation classes through the classpath scanning.
- We typically use `@Controller` in combination with a `@RequestMapping` annotation for request handling methods.

### @RestController

- `@RestController` is a specialized version of the controller. It includes the `@Controller` and `@ResponseBody` annotations, and as a result, simplifies the controller implementation (`@ResponseBody` annotation is no longer required)

### @RequestMapping

- It is used to map the web requests. It has many optional elements like consumes, header, method, name, params, path, produces, and value. We use it with the class as well as the method.

### @GetMapping, @PostMapping, @PutMapping, @DeleteMapping, @PatchMapping

- Maps the HTTP (GET, POST, PUT, DELETE, PATCH) requests on the specific handler method. They are used to create web service endpoints corresponding to specified HTTP methods.

### @PathVariable

- It is used to extract the values from the URI. It is most suitable for the RESTful web service, where the URL contains a path variable. We can define multiple `@PathVariable` in a method.

### @RequestBody

- It is used to bind HTTP request with an object in a method parameter. Internally it uses HTTP MessageConverters to convert the body of the request. When we annotate a method parameter with `@RequestBody`, the Spring framework binds the incoming HTTP request body to that parameter.

### @RequestParam

- It is used to extract the query parameters form the URL. It is also known as a query parameter. It is most suitable for web applications. It can specify default values if the query parameter is not present in the URL.

## Other Annotations

### @Autowired

- to mark a dependency which Spring is going to resolve and inject
- this annotation can be used with a constructor, setter, or field injection

```java
// field injection
@Autowired 
private PostService postService;
```

### @Service

- It is also used at class level. It tells the Spring that the class contains the **business logic**.

```java
@Service
public class PostServiceImpl implements PostService {...}
```

### @Repository

- It is a class-level annotation. The repository is a DAO (Data Access Object) that accesses the database directly. The repository does all the operations related to the database.

```java
@Repository
public interface PostRepository extends JpaRepository<Post, Long> {}
```
