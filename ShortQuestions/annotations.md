# Annotations

### Entity Annotations
Entity annotations are used to map classes to database tables and configure the schema.

#### @Entity
- **Usage**: Marks a class as an entity (a persistent domain object) and maps it to a database table.
- **Code Example**:
  ```
  @Entity
  public class User {
      // fields, constructors, getters, setters
  }
  ```

#### @Table
- **Usage**: Specifies the table in the database with which an entity is mapped.
- **Code Example**:
  ```
  @Entity
  @Table(name = "users")
  public class User {
      // fields, constructors, getters, setters
  }
  ```

#### @Column
- **Usage**: Specifies the column in the database table mapped to a persistent property or field.
- **Code Example**:
  ```
  @Entity
  public class User {
      @Column(name = "username")
      private String username;
      // other fields, constructors, getters, setters
  }
  ```

#### @Id
- **Usage**: Specifies the primary key of an entity.
- **Code Example**:
  ```
  @Entity
  public class User {
      @Id
      @GeneratedValue(strategy = GenerationType.AUTO)
      private Long id;
      // other fields, constructors, getters, setters
  }
  ```

### Controller Annotations
Controller annotations are used to define controllers and map requests to controller methods.

#### @RestController
- **Usage**: Marks a class as a controller where every method returns a domain object instead of a view. It's a shorthand for including both @Controller and @ResponseBody.
- **Code Example**:
  ```
  @RestController
  public class UserController {
      // mapping methods
  }
  ```

#### @RequestMapping
- **Usage**: Maps HTTP requests to handler methods of MVC and REST controllers.
- **Code Example**:
  ```
  @RestController
  @RequestMapping("/users")
  public class UserController {
      // handler methods
  }
  ```

#### @GetMapping
- **Usage**: Shortcut for @RequestMapping(method = RequestMethod.GET). Maps HTTP GET requests onto specific handler methods.
- **Code Example**:
  ```
  @RestController
  public class UserController {
      @GetMapping("/{id}")
      public User getUserById(@PathVariable Long id) {
          // implementation
      }
  }
  ```

#### @PostMapping
- **Usage**: Shortcut for @RequestMapping(method = RequestMethod.POST). Maps HTTP POST requests onto specific handler methods.
- **Code Example**:
  ```
  @RestController
  public class UserController {
      @PostMapping("/")
      public User createUser(@RequestBody User user) {
          // implementation
      }
  }
  ```

### General Annotations
These annotations are widely used across different layers in a Spring application.

#### @Autowired
- **Usage**: Enables dependency injection by marking a constructor, field, setter method, or config method as to be autowired by Spring's dependency injection facilities.
- **Code Example**:
  ```
  public class UserService {
      @Autowired
      private UserRepository userRepository;
      
      public User findUser(Long id) {
          return userRepository.findById(id).orElse(null);
      }
  ```

#### @Repository
- **Usage**: Marks a class as a repository, which indicates that it's a Data Access Object (DAO) component. It is used with classes that perform database operations.
- **Code Example**:
  ```
  @Repository
  public interface UserRepository extends JpaRepository<User, Long> {
      // Custom query methods can be added here
  }
  ```

#### @Service
- **Usage**: Marks a class as a service, which holds the business logic. It's used to annotate classes that perform service tasks, such as business operations.
- **Code Example**:
  ```
  @Service
  public class UserService {
      @Autowired
      private UserRepository userRepository;
      
      public User saveUser(User user) {
          return userRepository.save(user);
      }
  }
  ```

#### @Value
- **Usage**: Allows the injection of property values into beans. It can be used for injecting values from property files into fields in beans.
- **Code Example**:
  ```
  @Service
  public class MyService {
      @Value("${user.role.default}")
      private String defaultUserRole;
      
      public String getDefaultUserRole() {
          return defaultUserRole;
      }
  }
  ```

#### @Scope
- **Usage**: Defines the scope of a single bean definition. The scope can be singleton, prototype, request, session, etc.
- **Code Example**:
  ```
  @Service
  @Scope("prototype")
  public class MyService {
      // This bean will have a prototype scope
  }
  ```

#### @Qualifier
- **Usage**: Used to resolve the autowiring conflict when there are multiple beans of the same type. It helps in fine-tuning annotation-based autowiring.
- **Code Example**:
  ```
  @Service
  public class MyService {
      @Autowired
      @Qualifier("mainUserService")
      private UserService userService;
      
      // Use userService in the business logic
  }
  ```

#### @ResponseBody
- **Usage**: Indicates that a method return value should be bound to the web response body. Often used in RESTful web services.
- **Code Example**:
  ```
  @RestController
  public class UserController {
      @GetMapping("/user/{id}")
      @ResponseBody
      public User getUser(@PathVariable Long id) {
          // Fetch and return user based on the provided id
      }
  }
  ```

#### @PathVariable
- **Usage**: Used to extract values from the URI. It's most often used with RESTful web services.
- **Code Example**:
  ```
  @RestController
  public class UserController {
      @GetMapping("/user/{id}")
      public User getUser(@PathVariable("id") Long userId) {
          // Fetch and return user based on the provided userId
      }
  }
  ```

#### @Configuration
- **Usage**: Indicates that a class is a source of bean definitions. Often used with @Bean annotations to define beans explicitly.
- **Code Example**:
  ```
  @Configuration
  public class AppConfig {
      @Bean
      public MyBean myBean() {
          return new MyBean();
      }
      // Define more beans as needed
  }
  ```

