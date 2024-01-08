#### Entity Annotations

- `@Entity`
  Marks a class as a persistent Java class.
  ```java
    @Entity
    public class Post {
      @Id
      @GeneratedValue(strategy = GenerationType.IDENTITY)
      private Long id;
      // ... other fields and methods
    }
  ```

- `@Table`
  Specifies the primary table for the annotated entity.
  ```java
    @Entity
    @Table(    name = "posts",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = {"title"})
        })
    public class Post {
      // ... class definition
    }
  ```

- `@Id`
  Marks a field as a primary key field.
  ```java
    @Entity
    public class Post {
      @Id
      private Long id;
      // ... other fields and methods
    }
  ```

- `@GeneratedValue`
  Provides the specification of generation strategies for the values of primary keys.
  ```java
    @Entity
    public class Post {
      @Id
      @GeneratedValue(strategy = GenerationType.IDENTITY)
      private Long id;
      // ... other fields and methods
    }
  ```

- `@Column`
  Specifies the mapped column for a persistent property or field.
  ```java
    @Entity
    public class Post {
      @Id
      @GeneratedValue(strategy = GenerationType.IDENTITY)
      private Long id;
    
      @Column(name = "title", nullable = false)
      private String title;
      // ... other fields and methods
    }
  ```

#### Controller Annotations

- `@RestController`
  A convenience annotation that combines `@Controller` and `@ResponseBody`, which eliminates the need to annotate every request handling method of the controller class with the `@ResponseBody` annotation.
  ```java
    @RestController
    public class PostController {
      // ... class definition
    }
  ```

- `@RequestMapping`
  Annotation for mapping web requests onto methods in request-handling classes with flexible method signatures.
  ```java
    @RestController
    @RequestMapping("/api/v1/posts")
    public class PostController {
    
        @Autowired
        private PostService postService;
        @RequestMapping
        public ResponseEntity<PostDto> createPost(@RequestBody PostDto postDto){
            PostDto response = this.postService.createPost(postDto);
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        }
    }
  ```

- `@RequestBody`
  Annotation indicating a method parameter should be bound to the body of the web request.
  ```java
    @RestController
    public class PostController {
      public ResponseEntity<PostDto> createPost(@RequestBody PostDto postDto){
            // method implementation
      }
    }
  ```

#### Core Annotations

- `@SpringBootApplication`
  Combines `@Configuration`, `@EnableAutoConfiguration`, and `@ComponentScan` annotations with their default attributes.
  ```java
    @SpringBootApplication
    public class RedbookApplication {
    
        public static void main(String[] args) {
            SpringApplication.run(RedbookApplication.class, args);
        }
    
    }
  ```

- `@Autowired`
  Marks a constructor, field, setter method, or config method as to be autowired by Spring's dependency injection facilities.
  ```java
    @Service
    public class PostServiceImpl implements PostService {
        @Autowired
        private PostRepository postRepository;
        // ... class definition
    }
  ```

#### Service Layer Annotations

- `@Service`
  Indicates that an annotated class is a "Service" (e.g., a business service facade).
  ```java
    @Service
    public class PostServiceImpl implements PostService {
        // ... class definition
    }
  ```

- `@Repository`
  Indicates that an annotated class is a "Repository", originally defined by Domain-Driven Design (DDD) as a mechanism for encapsulating storage, retrieval, and search behavior which emulates a collection of objects.
  ```java
    @Repository
    public interface PostRepository extends JpaRepository<Post,Long> {
  
    }
  ```

#### JPA Annotations

- `@CreationTimestamp`
  Marks a property as the timestamp of the entity's creation, automatically set by Hibernate.
  ```java
    @Entity
    public class Post {
        // ... class definition
        @CreationTimestamp
        private LocalDate createDateTime;
    }
  ```

- `@UpdateTimestamp`
  Marks a property as the timestamp of the entity's last update, automatically set by Hibernate.
  ```java
    @Entity
    public class Post {
        // ... class definition
        @UpdateTimestamp
        private LocalDate updateDateTime;
    }
  ```