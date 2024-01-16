# @SpringBootApplication
This annotation marks the main class of Spring Boot application which is the entry point of the application.

@SpringBootApplication encapsulates @Configuration, @EnableAutoConfiguration, and @ComponentScan annotations with their default attributes.

```
@SpringBootApplication
class VehicleFactoryApplication {

    public static void main(String[] args) {
        SpringApplication.run(VehicleFactoryApplication.class, args);
    }
}
```

# @EnableAutoConfiguration
@EnableAutoConfiguration enables auto-configuration. It means that Spring looks for auto-configuration beans on its classpath and automatically applies them.

```
@Configuration
@EnableAutoConfiguration
class VehicleFactoryConfig {}
```

# @ConditionalOnClass and @ConditionalOnMissingClass
Using these conditions, Spring will only use the marked auto-configuration bean if the class in the annotation’s argument is present/absent.

# @ConditionalOnBean and @ConditionalOnMissingBean
We can use these annotations when we want to define conditions based on the presence or absence of a specific bean.

# @ConditionalOnProperty
make conditions on the values of properties

# @ConditionalOnResource
use a definition only when a specific resource is present

# @ConditionalOnWebApplication and @ConditionalOnNotWebApplication
create conditions based on if the current application is or isn’t a web application:

# @ConditionalExpression
Spring will use the marked definition when the SpEL expression is evaluated to true

# @Conditional
create a class evaluating the custom condition.

# @RestController
A specialized version of the @Controller annotation which adds the @ResponseBody annotation. It signals that the return value of the methods should be bound to the web response body.

```
@Controller
@ResponseBody
class VehicleRestController {
    // ...
}
```

# @RequestMapping
Used for mapping web requests onto specific handler classes and/or handler methods. It can be applied to class-level and/or method-level in a controller.

```
@Controller
class VehicleController {

    @RequestMapping(value = "/vehicles/home", method = RequestMethod.GET)
    String home() {
        return "home";
    }
}
```
```
@Controller
@RequestMapping(value = "/vehicles", method = RequestMethod.GET)
class VehicleController {

    @RequestMapping("/home")
    String home() {
        return "home";
    }
}
```

# @GetMapping, @PostMapping, @PutMapping, @DeleteMapping, @PatchMapping
These are specialized versions of @RequestMapping. They act as a shortcut for @RequestMapping method attribute.

# @Autowired
Allows Spring to resolve and inject collaborating beans into your bean.

```
public class FooService {
    private FooFormatter fooFormatter;
    @Autowired
    public void setFormatter(FooFormatter fooFormatter) {
        this.fooFormatter = fooFormatter;
    }
}
```
```
public class FooService {
    private FooFormatter fooFormatter;
    @Autowired
    public FooService(FooFormatter fooFormatter) {
        this.fooFormatter = fooFormatter;
    }
}
```
# @Service
Indicates that an annotated class is a "Service", originally defined by Domain-Driven Design (DDD) as "an operation offered as an interface that stands alone in the model, with no encapsulated state."

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

# @Id
Marks the field as the primary key of the table

# @GeneratedValue
specify the way to generate a field's value

# @Column
specify the column mappings between the entity fields and the corresponding columns in a database table.

# @CreationTimestamp
This annotation automatically sets the date and time of the entity's creation in the mapped database column.

# @UpdateTimestamp
This annotation automatically sets the date and time of the entity's update in the mapped database column.



