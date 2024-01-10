

### `@Entity`
Description: Marks a class as an entity, which typically represents a table in a relational database.

Example:
```java
@Entity
public class Product {
    // class fields
}
```

### `@Id`
Description: Specifies the primary key of an entity.

Example:
```java
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productId;
    // other fields
}
```

### `@Column`
Description: Specifies the details of a column in a database table.

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
Description: Injects a bean into a dependent bean.

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