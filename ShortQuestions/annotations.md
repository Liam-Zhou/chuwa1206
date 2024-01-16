##### @SpringBootApplication

notify where the application shall start.

```java
@SpringBootApplication
public class Demo1redbookApplication {
	public static void main(String[] args) {
		SpringApplication.run(Demo1redbookApplication.class, args);
	}

}
```

##### @RestController

 A Spring annotation that marks a class as a controller where every method returns a domain object instead of a view. It combines `@Controller` and `@ResponseBody` annotations, indicating that the data returned by each method will be written straight into the response body.

##### @RequestMapping

An annotation in Spring Framework used to map web requests to specific handler classes or methods in controllers, defining the URL patterns and HTTP methods (like GET, POST) for request handling.

##### @PathVariable

##### @RequestParam

##### @RequestBody

A Spring annotation used to bind the HTTP request body to a method parameter. It is commonly used to automatically deserialize incoming JSON or XML data into a Java object.

##### @ResponseBody

##### @Autowired

Used for automatic dependency injection. It can be applied to fields, constructors, or methods to inject dependencies into your beans.

```java
@RestController
@RequestMapping("/api/v1")
public class PostController {

    @Autowired
    private PostService postService;

}
```



##### @Controller

marks a class as a Spring MVC controller

```java
@Controller
public class PostController{
}
```

##### @Service

A Spring annotation used to mark a Java class as a service provider, indicating that it contains business logic. It's often used in the service layer of an application for Spring to handle automatic detection and configuration.

```java
@Service
public class PostServiceImpl implements PostService {

}
```



##### @Document

In Java, specifically with Spring Data MongoDB, the `@Document` annotation is used to mark a class as a domain object that will be persisted to a MongoDB document. It defines the collection name and other MongoDB-specific settings.

```java
@Document("groceryitems")
public class GroceryItem {}
```



##### @Entity

marks a class as entity, allowing it to be mapped to a database table

```
@Entity
public class User {
}
```

##### @Table

specifies the database table name associated with an entity class

```
@Entity
@Table(name = "user_table")
public class User{
}
```

##### @UniqueConstraints

```java
@Entity
@Table(
        name = "posts",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = {"title"})
        }
)
```

##### @column

```java
@Column(columnDefinition = "varchar(255) default 'John Snow'")
```

##### 



##### @Id, @GeneratedValue

**@Id**: Marks a field in a Java class as the primary key of the corresponding database table in JPA (Java Persistence API).

**@GeneratedValue**: Specifies the strategy for primary key value generation, automatically handling the creation of unique identifiers for new entity instances.

```
@Entity
public class User{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
}
```
