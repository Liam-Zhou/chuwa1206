### `@Entity`
Description: Marks a class as an entity, which maps to a table in a relational database.

Example:
```java
@Entity
public class Product {
    // class fields
}
```

### `@Id`
Description: Indicate the primary key of an entity.

Example:

```java
import javax.annotation.processing.Generated;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productId;
    // other fields
}
```

### `@Column`
Description: Indicate the details of a column in an entity.

Example:
```java
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productId;

    @Column(name = "product_name", nullable = false)
    private String productName;
    // other fields
}
```

## Annotations Used by Controllers

### `@RestController`
Description: Combines `@Controller` and `@ResponseBody`. It is used to create RESTful web services.

Example:
```java
@RestController
@RequestMapping("/api/products")
public class ProductController {
    // controller methods
}
```

### `@PostMapping`
Description: Handles HTTP POST requests.

Example:
```java
@RestController
@RequestMapping("/api/products")
public class ProductController {
    @PostMapping
    public ResponseEntity<Product> createProduct(@RequestBody Product product) {
        // logic to create a new product
    }
}
```

### `@PutMapping`
Description: Handles HTTP PUT requests.

Example:
```java
@RestController
@RequestMapping("/api/products")
public class ProductController {
    @PutMapping("/{productId}")
    public ResponseEntity<Product> updateProduct(@PathVariable Long productId, @RequestBody Product updatedProduct) {
        // logic to update an existing product
    }
}
```

## General Annotations

### `@Autowired`
Description: To implement Dependency Injection.

Example:
```java
@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;
    // other methods
}
```

### `@Service`
Description: Indicates that a class is a service, often used in the service layer of a Spring application.

Example:
```java
@Service
public class ProductService {
    // service methods
}
```

### `@Component`
Description: Indicates that a class is a Spring component.

Example:
```java
@Component
public class EmailService {
    // component methods
}
```

# @SpringBootApplication
This annotation marks the main class of Spring Boot application which is the entry point of the application.
@SpringBootApplication

# @GetMapping, @PostMapping, @PutMapping, @DeleteMapping, @PatchMapping
These are specialized versions of @RequestMapping. They act as a shortcut for @RequestMapping method attribute.

# @Repository
Indicates that an annotated class is a "Repository", a mechanism for encapsulating storage, retrieval, and search behavior which emulates a collection of objects.

# @Component
A generic stereotype for any Spring-managed component. @Repository, @Service, and @Controller are specializations of @Component for more specific use cases.

# @Bean
An annotation at the method level that tells Spring that a method produces a bean to be managed by the Spring container.

# @Value
Indicates a default value expression for the affected argument.

# @PathVariable
Indicates that a method parameter should be bound to a URI template variable.

# @RequestParam
Indicates that a method parameter should be bound to a web request parameter.

# @RequestBody
@RequestBody annotation maps the HttpRequest body to a transfer or domain object, enabling automatic deserialization of the inbound HttpRequest body onto a Java object.

# @Controller
@Controller annotation marks a spring bean as a controller.

# @QueryMapping
a shortcut annotation to bind annotated methods for fields under the Query type.

# @MutationMapping
a shortcut annotation to bind annotated methods for fields under the Mutation type.

# @Argument
The @Argument annotation is used in a controller method to indicate that a method parameter should be bound to a GraphQL argument.

# @GeneratedValue
specify the way to generate a field's value

# @CreationTimestamp
This annotation automatically sets the date and time of the entity's creation in the mapped database column.

# @UpdateTimestamp
This annotation automatically sets the date and time of the entity's update in the mapped database column.
