Example 1:

```
    @Configuration
    public class AppConfig {

            @Bean
            public MyService myService() {
                return new MyServiceImpl();
            }

            @Bean(name = "dataSource")
            public DataSource dataSource() {
                // Return DataSource bean implementation
            }

    }
```

@Configuration: Classes annotated with `@Configuration` are often referred to as configuration classes. Configuration classes may contain bean definitions, method-level `bean` declarations, and other configuration-related logic.

@bean: `@Bean` is an annotation used to declare a method as a producer of a bean managed by the Spring container.

Example 2:

```
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleException(Exception ex) {
        // Create a custom error response
        ErrorResponse errorResponse = new ErrorResponse("An error occurred", ex.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
```

@ControllerAdvice is an annotation used to define global exception handlers that are applied across multiple controllers.

@ExceptionHandler(Exception.class): You can annotate methods in your Spring MVC controllers with `@ExceptionHandler` to handle specific types of exceptions.

Example 3:

@OneToMany: Used to define a one-to-many relationship between two entities.

```
@Entity
public class Parent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "parent")
    private List<Child> children;
    // getters and setters
}

@Entity
public class Child {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "parent_id")
    private Parent parent;
    // getters and setters
}
```

@ManyToOne: Used to define a many-to-one relationship between two entities.

```
@Entity
public class Child {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "parent_id")
    private Parent parent;
    // getters and setters
}

@Entity
public class Parent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "parent")
    private List<Child> children;
    // getters and setters
}
```

@ManyToOne: Used to define a many-to-one relationship between two entities.

```
@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToMany
    @JoinTable(
        name = "student_course",
        joinColumns = @JoinColumn(name = "student_id"),
        inverseJoinColumns = @JoinColumn(name = "course_id")
    )
    private List<Course> courses;
    // getters and setters
}

@Entity
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToMany(mappedBy = "courses")
    private List<Student> students;
    // getters and setters
}
```

Example 4:

`@NamedQuery` is used to define a single named query in an entity class. The @NamedQuery annotation is applied to a method in the entity class and specifies the JPQL query string associated with that method.

```
    @Entity
    @NamedQuery(
        name = "findEmployeeByName",
        query = "SELECT e FROM Employee e WHERE e.name = :name"
    )
    public class Employee {
        // Entity attributes and methods
    }
```

`@NamedQueries` is used to define multiple named queries in an entity class. The @NamedQueries annotation is applied at the class level and contains an array of @NamedQuery annotations, each defining a named query.

```
    @Entity
    @NamedQueries({
        @NamedQuery(
            name = "findEmployeeByName",
            query = "SELECT e FROM Employee e WHERE e.name = :name"
        ),
        @NamedQuery(
            name = "findEmployeeByDepartment",
            query = "SELECT e FROM Employee e WHERE e.department = :department"
        )
    })
    public class Employee {
        // Entity attributes and methods
    }
```

Example 5:

`@Query` allows you to define custom JPQL (Java Persistence Query Language) or native SQL queries directly within Spring Data repository interfaces.

JPQL Queries:

```
public interface UserRepository extends Repository<User, Long> {

    @Query("SELECT u FROM User u WHERE u.age > :age")
    List<User> findUsersByAgeGreaterThan(@Param("age") int age);

}
```

Native SQL Queries:

```
public interface UserRepository extends Repository<User, Long> {

    @Query(value = "SELECT * FROM users WHERE age > :age", nativeQuery = true)
    List<User> findUsersByAgeGreaterThan(@Param("age") int age);
}
```

Example 6:

```
@Service
@Transactional
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public void createUser(User user) {
        userRepository.save(user);
    }

    @Transactional(readOnly = true)
    public User getUserById(Long userId) {
        return userRepository.findById(userId).orElse(null);
    }
}
```

`@Transactional` is an annotation provided by Spring Framework to declare transactional behavior for methods or classes in a Spring application. It allows developers to manage transactions declaratively, without having to manually handle transactional boilerplate code.

Example 6:

```
@Configuration
@ComponentScan(basePackages = "com.example")
public class AppConfig {
    // Configuration code
}
```

`@ComponentScan` annotation is applied to the AppConfig class, specifying that Spring should scan the package com.example and its sub-packages for Spring-managed components.
