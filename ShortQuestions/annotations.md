@SpringBootApplication: This annotation is the main entry point for a Spring Boot application. It combines @Configuration, @EnableAutoConfiguration, and @ComponentScan to enable various Spring Boot features.

@Controller: Marks a class as a Spring MVC controller, allowing it to handle HTTP requests.

@RestController: Similar to @Controller, but specifically designed for RESTful web services. It combines @Controller and @ResponseBody.

@RequestMapping: Used to map HTTP requests to specific controller methods. You can specify the URL path and HTTP method (GET, POST, etc.) to handle.

@GetMapping, @PostMapping, @PutMapping, @DeleteMapping: Shorthand annotations for specifying HTTP methods when using @RequestMapping.

@PathVariable: Extracts values from URI templates and binds them to method parameters.

@RequestParam: Binds request parameters (query parameters) to method parameters.

@RequestBody: Binds the HTTP request body to a method parameter, typically used for handling JSON or XML payloads in RESTful APIs.

@ResponseBody: Indicates that the return value of a controller method should be serialized and sent as an HTTP response body.

@Service: Marks a class as a Spring service component, typically used for business logic.

@Repository: Marks a class as a Spring repository component, used for database interaction. It also provides exception translation for JPA.

@Autowired: Automatically injects dependencies into beans, constructors, methods, or fields.

@Qualifier: Used in conjunction with @Autowired to specify which bean to inject when multiple beans of the same type exist.

@Value: Injects values from properties files or environment variables into fields or methods.

@Configuration: Indicates that a class provides Spring bean configuration.

@Component: Marks a class as a Spring component, allowing it to be automatically discovered and registered as a bean.

@Bean: Used in @Configuration classes to declare a Spring bean.

@Profile: Specifies which profiles a component should be included in.

@Conditional: Allows conditional bean registration based on a certain condition.

@EnableAutoConfiguration: Automatically configures Spring Boot based on the classpath and project dependencies.

@EnableWebMvc: Configures Spring MVC if you want to customize it in a Spring Boot application.

@SpringBootTest: Used in integration testing to load the complete Spring context.

@OneToMany:This annotation defines a one-to-many relationship between two entities, where one entity can be associated with multiple instances of another entity.

@ManyToOne: This annotation is used to establish a many-to-one relationship between two entities, where multiple instances of one entity are associated with a single instance of another entity.

@ManyToMany: This annotation defines a many-to-many relationship between two entities, where instances of an entity can be associated with multiple instances of another entity and vice versa.

@OneToOne: This annotation is used to define a one-to-one relationship between two entities.

@Transactional: Although not directly related to entity relationships, the @Transactional annotation is commonly used in the context of JPA and ORM to define the scope of a single database transaction. It's often used on service layer methods to ensure that the operations within are executed within a transactional context, providing consistency and rollback capabilities in case of errors.

