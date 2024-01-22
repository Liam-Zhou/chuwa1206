## Entity Annotations

### `@Entity`
- **Usage:** Marks a class as a JPA entity.
- **Explanation:** Indicates that the class is a persistent Java class, and instances of it are stored in the database.

### `@Table`
- **Usage:** Specifies the primary table for the annotated entity.
- **Explanation:** Defines the database table properties, such as name and schema, for the associated entity.

### `@Id`
- **Usage:** Marks a field as the primary key of an entity.
- **Explanation:** Denotes the primary key field of the entity.

### `@GeneratedValue`
- **Usage:** Provides the specification of generation strategies for the values of primary keys.
- **Explanation:** Configures how the primary key values are generated, such as using an identity, sequence, or table.

### `@Column`
- **Usage:** Specifies the details of a column in a table.
- **Explanation:** Defines the database column properties, such as name, nullable, length, etc., for the associated field.

## Controller Annotations

### `@Controller`
- **Usage:** Marks a class as a Spring MVC controller.
- **Explanation:** Identifies a class as a Spring MVC controller, allowing it to handle HTTP requests.

### `@RestController`
- **Usage:** Specialization of `@Controller` for RESTful services.
- **Explanation:** Combines `@Controller` and `@ResponseBody`, indicating that the return value of methods should be serialized directly to the response body.

### `@RequestMapping`
- **Usage:** Maps HTTP requests to handler methods.
- **Explanation:** Defines the URL pattern(s) that a controller method can handle.

### `@GetMapping`, `@PostMapping`, `@PutMapping`, `@DeleteMapping`
- **Usage:** Shortcuts for `@RequestMapping` with specific HTTP methods.
- **Explanation:** Provides convenient annotations for mapping specific HTTP methods to controller methods.

### `@PathVariable`
- **Usage:** Extracts values from URI templates.
- **Explanation:** Binds a method parameter to a template variable in the request URI.

### `@RequestParam`
- **Usage:** Binds request parameters to method parameters.
- **Explanation:** Extracts query parameters from the request URL and binds them to method parameters.

## Component Annotations

### `@Component`
- **Usage:** Marks a class as a Spring component.
- **Explanation:** Indicates that a class is a Spring component, allowing it to be automatically discovered and registered as a bean.

### `@Autowired`
- **Usage:** Injects dependencies.
- **Explanation:** Marks a constructor, field, or method to be autowired by Spring's dependency injection.

### `@Service`
- **Usage:** Marks a class as a service bean.
- **Explanation:** Indicates that a class is a service, allowing it to be automatically discovered and registered as a bean.

### `@ComponentScan`
- **Usage:** Configures the scanning of components for Spring's container.
- **Explanation:** Specifies the base packages to scan for components, such as controllers, services, and repositories.

### `@Configuration`
- **Usage:** Designates a class as a source of bean definitions.
- **Explanation:** Allows the definition of beans in a class using `@Bean` annotated methods.

## Repository Annotations

### `@Repository`
- **Usage:** Indicates that the class is a Spring Data repository.
- **Explanation:** Marks a class as a repository to perform CRUD operations on entities.

### `@CrudRepository`, `@PagingAndSortingRepository`, `@JpaRepository`
- **Usage:** Specialized repository interfaces provided by Spring Data JPA.
- **Explanation:** Offer various features such as CRUD operations, pagination, sorting, and additional JPA-specific functionality.

### `@Query`
- **Usage:** Defines a JPQL query directly on a repository method.
- **Explanation:** Allows the definition of custom queries for retrieving data.

### `@Param`
- **Usage:** Binds method parameters to named parameters in a query.
- **Explanation:** Specifies named parameters in a JPQL query.
