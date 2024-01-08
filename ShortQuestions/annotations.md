# Spring Framework General Annotations

## @SpringBootApplication
```java
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
```

## @Autowired
```java
@Service
public class MyService {
    @Autowired
    private MyRepository repository;
}
```

## @Component
```java
@Component
public class MyComponent {
    // class body
}
```

## @Service
```java
@Service
public class UserService {
    // service methods
}
```

## @Repository
```java
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    // repository methods
}
```

## @Configuration, @Bean
```java
@Configuration
public class AppConfig {
    @Bean
    public MyService myService() {
        return new MyServiceImpl();
    }
}
```

# Spring Web Annotations

## @RestController
```java
@RestController
public class MyRestController {
    @GetMapping("/hello")
    public String hello() {
        return "Hello World";
    }
}
```

## @RequestMapping
```java
@Controller
@RequestMapping("/users")
public class UserController {
    // controller methods
}
```

## @GetMapping / @PostMapping / @PutMapping / @DeleteMapping
```java
@RestController
public class UserController {
    @GetMapping("/{id}")
    public User getUser(@PathVariable Long id) { /* ... */ }

    @PostMapping
    public User addUser(@RequestBody User user) { /* ... */ }

    @PutMapping("/{id}")
    public User updateUser(@PathVariable Long id, @RequestBody User user) { /* ... */ }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) { /* ... */ }
}
```

## @PathVariable, @RequestParam
```java
@GetMapping("/users/{id}")
public User getUser(@PathVariable Long id) {
    // ...
}
@GetMapping("/users")
public List<User> getUsers(@RequestParam(required = false) String role) {
    // ...
}
```

## @RequestBody
```java
@PostMapping("/users")
public User addUser(@RequestBody User user) {
    // ...
}
```

## @ResponseBody
```java
@Controller
public class MyController {
    @GetMapping("/hello")
    @ResponseBody
    public String hello() {
        return "Hello World";
    }
}
```

## @ControllerAdvice
```java
@ControllerAdvice
public class MyExceptionHandler {
    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<Object> handleException(Exception e) {
        // ...
    }
}
```

## @ExceptionHandler
```java
@ControllerAdvice
public class MyExceptionHandler {
    @ExceptionHandler(value = MyCustomException.class)
    public ResponseEntity<Object> handleMyCustomException(MyCustomException e) {
        // ...
    }
}
```

# Spring Data/JPA Annotations

## @Entity
```java
@Entity
public class User {
    @Id
    private Long id;
    // ...
}
```

## @Table
```java
@Entity
@Table(name = "users")
public class User {
    // ...
}
```

## @Id
```java
@Entity
public class User {
    @Id
    private Long id;
    // ...
}
```

## @GeneratedValue
```java
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    // ...
}
```

## @Column
```java
@Entity
public class User {
    @Column(name = "email_address")
    private String email;
    // ...
}
```

## @ManyToOne / @OneToMany / @OneToOne / @ManyToMany
```java
@Entity
public class Order {
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    // ...
}

@Entity
public class User {
    @OneToMany(mappedBy = "user")
    private Set<Order> orders;
    // ...
}

@Entity
public class User {
    @OneToOne(mappedBy = "user")
    private UserProfile profile;
    // ...
}

@Entity
public class Student {
    @ManyToMany
    @JoinTable(
            name = "student_course",
            joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "course_id")
    )
    private Set<Course> courses;
    // ...
}
```

## @Transactional
```java
@Service
public class UserService {
    @Transactional
    public void updateUser(User user) {
        // ...
    }
}
```

## @Query
```java
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    @Query("SELECT u FROM User u WHERE u.email = :email")
    User findByEmail(@Param("email") String email);
}
```

