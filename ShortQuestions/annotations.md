# `@SpringBootApplication`
> The @SpringBootApplication annotation is equivalent to using @Configuration, @EnableAutoConfiguration, and @ComponentScan with their default attributes. Spring Boot enables the developer to use a single annotation instead of using multiple. But, as we know, Spring provided loosely coupled features that we can use for each annotation as per our project needs
> 
   A single @SpringBootApplication annotation can be used to enable those three features, that is:

- @EnableAutoConfiguration: enable Spring Boot’s auto-configuration mechanism
- @ComponentScan: enable @Component scan on the package where the application is located (see the best practices)
- @Configuration: allow to register extra beans in the context or import additional configuration classes
```java
package com.example.myapplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication // same as @Configuration @EnableAutoConfiguration @ComponentScan
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
```


# @Table
> `@Table` annotation provides options to customize the mapping of an entity to a database table
```java
@Table(
        name = "post",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = {"title"})
        }
)
```

# @Column
> When you use @Column annotation without specifying the name attribute, the default behavior is that the column name in the database will be derived from the field name in the entity class


# @Bean
> The @Bean annotation returns an object that spring should register as bean in application context. The body of the method bears the logic responsible for creating the instance.

# @Entity
> `@Entity` to flag your Pojo as JPA or Spring Data managed bean to read or write it to a database. help map our domain objects (POJOs) to the relational database table

# @Component
> `@Component` is a class that is eligible to be scanned by Spring's auto-detection for dependency injection

# @Repository
> Handle all DataAccessExceptions differently to a general Throwable type

# @Service
> Used to annotate classes that provide business services or service-related functionality.

# @Controller
> the @Controller annotation is typically used in UI-based applications where the response is generally an HTML page

# @ResponseBody
> The @ResponseBody annotation indicates a method return value should be bound to the web response body

# @RestController
> is used in the case of REST style controllers i.e. handler methods shall return the JSON/XML response directly to the client rather than using view resolvers. The @RestController is a convenience annotation that combines the @Controller and @ResponseBody annotations.

# @Autowired
> Is used to automatically inject dependencies into a Spring bean. When you mark a field, constructor, or a method with @Autowired, the Spring framework automatically resolves and provides the necessary dependencies at runtime. 

# @PostMapping
> Is used to map HTTP POST requests to a specific handler method in a controller. When you annotate a method with @PostMapping and specify a URL path, the method will be invoked when an HTTP POST request is sent to that path.

# @RequestBody
> When you use @RequestBody with a method parameter, Spring Boot automatically converts the content of the request body (usually in JSON or XML format) into the corresponding Java object.

# @PathVariable
> An annotation used in the context of a Spring MVC controller to extract values from the URI template and bind them to method parameters.

# @GetMapping("/{id}")
> Used to map HTTP GET requests to specific handler methods in a controller class

# @PutMapping("/{id}")
>  used to map HTTP PUT requests to a specific handler method in a controller class.

# @PostMapping
> is used to map HTTP POST requests to a specific handler method in a controller class without specifying a path variable in the URI.

# @Argument
> In GraphQL, @Argument is an annotation that can be used to bind an argument to a target object and inject it into the handler method. By default, the method parameter name is used to look up the argument. The argument name can be specified in the annotation.
```java
@MutationMapping
public User createUser(@Argument String name, @Argument String email) {
    User user = new User();
    user.setName(name);
    user.setEmail(email);
    return userRepository.save(user);
}
```
# @QueryMapping
> In Spring Boot for GraphQL, @QueryMapping is an annotation that can be used to associate a method with a query field in your GraphQL schema.


