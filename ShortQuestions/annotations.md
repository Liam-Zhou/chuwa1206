1. create a file to list all of the annotations you learned and known, and explain the **usage** and **how do you understand** it. you need to update it when you learn a new annotation. Please organize those annotations well, like annotations used by entity, annotations used by controller.
   1. File name: **annotations.md**
   2. you'd better also list a **code example** under the annotations.

- Annotations used by entity

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

- Annotations used by controller

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

  - @Autowired

  Used to inject Beans into Beans

  ```
  @Autowired
  private PostService postService;
  ```

  - @PostMapping

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
