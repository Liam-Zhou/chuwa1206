# Annotations

### Annotations Used by Entity (JPA Entities):

1. **`@Entity`:**

   - Marks a class as a JPA entity, indicating that it will be persisted to the database

     ```java
     import javax.persistence.Entity;
     
     @Entity
     public class User {
         // entity fields and methods
     }
     ```

2. **`@Id`:**

- Specifies the primary key of an entity.

  ```java
  import javax.persistence.Id;
  
  public class User {
      @Id
      private Long id;
      // other fields and methods
  }
  ```

3. **`@GeneratedValue`:**

   - Defines the strategy for generating primary key values.

     ```java
     import javax.persistence.GeneratedValue;
     import javax.persistence.GenerationType;
     
     public class User {
         @Id
         @GeneratedValue(strategy = GenerationType.IDENTITY)
         private Long id;
         // other fields and methods
     }
     ```

4. **`@Column`:**

   - Maps a field to a column in the database.

     ```java
     import javax.persistence.Column;
     
     public class User {
         @Column(name = "user_name")
         private String username;
         // other fields and methods
     }
     
     ```

### Annotations Used by Controller:

1. **`@RestController`:**

   - Combines `@Controller` and `@ResponseBody`, indicating that this class is a controller and its methods return JSON or XML response directly.

     ```java
     import org.springframework.web.bind.annotation.RestController;
     
     @RestController
     public class UserController {
         // controller methods
     }
     ```

2. **`@RequestMapping`:**

   - Maps HTTP requests to specific handler methods.

     ```java
     import org.springframework.web.bind.annotation.RequestMapping;
     import org.springframework.web.bind.annotation.RequestMethod;
     
     @RestController
     @RequestMapping("/api/users")
     public class UserController {
         @RequestMapping(method = RequestMethod.GET)
         public List<User> getAllUsers() {
             // implementation
         }
     }
     
     ```

     

3. **`@PostMapping`, `@GetMapping`, `@PutMapping`, `@DeleteMapping`:**

   - Shortcut annotations for `@RequestMapping` with specific HTTP methods.

     ```java
     import org.springframework.web.bind.annotation.PostMapping;
     
     @RestController
     @RequestMapping("/api/users")
     public class UserController {
         @PostMapping
         public User createUser(@RequestBody User user) {
             // implementation
         }
     }
     
     ```

     

3. **`@RequestBody`:**

   - Binds the method parameter to the body of the HTTP request.

     ```java
     import org.springframework.web.bind.annotation.RequestBody;
     
     @RestController
     @RequestMapping("/api/users")
     public class UserController {
         @PostMapping
         public User createUser(@RequestBody User user) {
             // implementation
         }
     }
     
     ```

     