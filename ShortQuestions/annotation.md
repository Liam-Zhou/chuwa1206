### Annotation by Entity

#### @Entity

```java
//mark a class as a JPA entity. It indicates that the class should be mapped to a database table.
@Entity
public class Product {
    // Entity fields, getters, setters, etc.
}
```

#### @Table

```java
//specify the details of the table that the entity will be mapped to.
@Entity
@Table(name = "products")
public class Product {
    // Entity fields, getters, setters, etc.
}
```

#### @Id

```java
// used to declare the primary key field of the entity.
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    // Other entity fields, getters, setters, etc.
}
```

#### @Colum

```java
//used to specify the details of a column in the database table, such as the name, length, nullable, etc.
public class Product {
    @Column(name = "product_name", nullable = false, length = 100)
    private String productName;
    // Other entity fields, getters, setters, etc.
}
```

#### @DataTimeFormat

```java
//used to define the format of a Date or LocalDate field when converting to/from a String.
 @DateTimeFormat(pattern = "yyyy-MM-dd")
 private Date eventDate;
```

#### @CreatedDate & @LastModifiedDate

```java
// used to automatically populate fields with the current date and time during the creation or modification of an entity.
public class BaseEntity {
    @CreatedDate
    private Date createdDate;

    @LastModifiedDate
    private Date lastModifiedDate;
    // Other entity fields, getters, setters, etc.
}
```





### Annotation By Controller

#### @Controller

```java
//used to indicate that a class serves the role of a controller. It is typically applied to a class.
@Controller
public class MyController {
    // Controller methods and logic
}
```

#### @RestController

```java
// specialized version of the @Controller annotation that is used for RESTful web services. It combines @Controller and @ResponseBody.
@RestController
public class MyRestController {
    // RESTful controller methods and logic
}
```

#### @RequestMapping

```java

@Controller
@RequestMapping("/api")
public class MyController {
    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String hello() {
        return "Hello, World!";
    }
}
```

#### @GetMapping, @PostMapping, @PutMapping, @DeleteMapping, @PatchMapping

// These annotations are shortcuts for `@RequestMapping` with specific HTTP methods

#### @PathVariable

```java
 //used to extract values from the URI template and bind them to method parameters.
@RestController
@RequestMapping("/users")
public class UserController {
    @GetMapping("/{userId}")
    public String getUser(@PathVariable Long userId) {
        // Logic to retrieve user with given userId
        return "User ID: " + userId;
    }
}
```

#### @RequestBody

```java
//used to bind the body of the web request to a method paramete
@RestController
@RequestMapping("/api")
public class MyRestController {
    @PostMapping("/create")
    public String create(@RequestBody MyObject myObject) {
        // Logic to process the MyObject from the request body
        return "Object created: " + myObject;
    }
}
```

#### @RequestParam

```java
// extract query parameters from the request URL.
@Controller
@RequestMapping("/example")
public class MyController {
    @GetMapping("/greet")
    public String greet(@RequestParam(name = "name", defaultValue = "Guest") String name) {
        return "Hello, " + name + "!";
    }
}
```

