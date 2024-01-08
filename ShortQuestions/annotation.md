# Annotation

### @Entity

- This annotation marks a class as an entity bean, which is a lightweight persistence domain object. Typically, an entity represents a table in a database, and each instance of the entity corresponds to a row in that table.

- Example:

  ```java
  @Entity
  public class User {
      // class body
  }
  ```

### @Table

- The **`@Table`** annotation specifies the primary table for the annotated entity. If no **`@Table`** is specified, the default values are applied: the table name is the same as the class name.

- **Attributes**:

  **`name`**: Specifies the name of the database table.

  **`schema`**: Specifies the schema of the table.

- Example:

  ```java
  @Entity
  @Table(name = "users")
  public class User {
      // class body
  }
  ```

### @Id

- This annotation marks a field as the primary key of an entity.

- Example:

  ```java
  @Entity
  public class User {
      @Id
      private Long id;
      // other fields
  }
  ```

### @GeneratedValue

- This annotation is used in conjunction with **`@Id`** to specify how the primary key should be generated. It supports auto-generation strategies like **`AUTO`**, **`IDENTITY`**, **`SEQUENCE`**, or **`TABLE`**.

- Example:

  ```java
  @Entity
  public class User {
      @Id
      @GeneratedValue(strategy = GenerationType.AUTO)
      private Long id;
      // other fields
  }
  ```

### @Column

- This annotation specifies the mapped column for a persistent property or field. If no **`@Column`** is specified, the default values are applied.

- **Attributes**:

  **`name`**: Name of the column in the database.

  **`nullable`**: Whether the database column is nullable or not.

  **`length`**: The column length.

- Example:

  ```java
  @Entity
  public class User {
      @Id
      private Long id;
  
      @Column(name = "username", nullable = false, length = 50)
      private String username;
      // other fields
  }
  ```

### @CreationTimestamp

- This annotation is used to mark a field for automatic timestamping at the time of creation of the entity.

- Example:

  ```java
  @Entity
  public class User {
      // other fields
  
      @CreationTimestamp
      private LocalDateTime createdDate;
  }
  ```

### @UpdateTimestamp

- Similar to **`@CreationTimestamp`**, this annotation marks a field for automatic timestamping whenever the entity is updated.

- Example:

  ```java
  @Entity
  public class User {
      // other fields
  
      @UpdateTimestamp
      private LocalDateTime lastModifiedDate;
  }
  ```

### @Autowired

- This annotation is used for automatic dependency injection. Spring provides the required beans and injects them where **`@Autowired`** is specified. This reduces the need for manual bean creation and dependency management.

- Example:

  ```java
  @Service
  public class UserService {
      @Autowired
      private UserRepository userRepository;
      // methods
  }
  ```

### @Repository

- This annotation is a marker for any class that fulfills the role of a repository or Data Access Object (DAO). This is primarily used in the data access layer, and it helps Spring to identify it as a component for handling data operations.

- Example:

  ```java
  @Repository
  public interface UserRepository extends JpaRepository<User, Long> {
      // repository methods
  }
  ```

### @Service

- This annotation is used to mark a class as a service provider. It is typically used in the service layer of an application. This layer contains business logic, and the **`@Service`** annotation indicates that a class holds business logic.

- Example:

  ```java
  @Service
  public class UserService {
      // service methods
  }
  ```

### @RestController

- This annotation is a specialized version of the controller. It combines **`@Controller`** and **`@ResponseBody`** annotations and is used to create RESTful web services. The **`@RestController`** annotation ensures that every method returns a domain object instead of a view. It simplifies the creation of RESTful web services.

- Example:

  ```java
  @RestController
  public class UserController {
      // RESTful endpoints
  }
  ```

### @RequestMapping

- This annotation is used to map web requests to specific handler classes or handler methods. It can be applied at the class or method level.

- **Attributes**:

  **`value`** or **`path`**: URL pattern to which the method should be mapped.

  **`method`**: The HTTP method (GET, POST, etc.) to be supported.

- Example:

  ```java
  @RestController
  @RequestMapping("/users")
  public class UserController {
      @GetMapping
      public List<User> getAllUsers() {
          // method body
      }
      // other methods
  }
  ```

### @PostMapping

- This is a composed annotation that acts as a shortcut for **`@RequestMapping(method = RequestMethod.POST)`**. It is specifically designed to handle HTTP POST requests.

- Example:

  ```java
  @RestController
  @RequestMapping("/users")
  public class UserController {
      @PostMapping
      public User createUser(@RequestBody User newUser) {
          // method body
      }
      // other methods
  }
  ```