[TOC]



# Spring-Data

## @Entity

> `@Entity` to flag your Pojo as JPA or Spring Data managed bean to read or write it to a database. help map our domain objects (POJOs) to the relational database table

## @Table

> `@Table` annotation provides options to customize the mapping of an entity to a database table

```java
@Table(
        name = "post",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = {"title"})
        }
)
```

## @Id

> this column is a primary key

## @GeneratedValue(strategy = GenerationType.IDENTITY)

> The generative strategy for primary key

## @Column(name = "description", nullable = false)

> specify the informaiton for this column, like name in database, can be null or not in database

## @JoinColumn(name="profile_id", referenceColumnName="id")

> Is a JPA annotation that is used to define a foreign key column in a database table that references the primary key of another table.

## @OneToOne(cascade=CascadeType.ALL)

> `@OneToOne` is an annotation used to establish a one-to-one relationship between two entities in a database. The `cascade` attribute, when set to `CascadeType.ALL`, specifies that if an operation (such as persist, remove, merge, etc.) is performed on one side of the relationship, the same operation should be cascaded to the other side.

## @ManyToOne(fetch = FetchType.LAZY)

> is used to define a many-to-one relationship between two entities. 

## @ManyToMany(fetch = FetchType.LAZY)

> Is used to define a many-to-many relationship between two entities. 
>
> `FetchType.LAZY`, which means that the associated entities will be loaded lazily. Lazily means that the associated entities will only be loaded from the database when you explicitly access them in your code. This can be beneficial for performance, as it avoids loading unnecessary data until it's actually needed.

## @JoinTable(name = "sku_inventory", joinColumns = @JoinColumn(name = "sku_id"),inverseJoinColumns = @JoinColumn(name ="inventory_id"))

> is defining the join table for a many-to-many relationship between entities, specifying the table name and the foreign key columns.

## @Query

> The `@Query` annotation in Spring Data JPA is used to define custom queries directly within a repository interface. This annotation allows you to write JPQL (Java Persistence Query Language) or native SQL queries to fetch or manipulate data from the database



## @Param

>The `@Param` annotation in Spring is used to bind a method parameter to a named parameter in a query. This annotation is often used in conjunction with the `@Query` annotation in Spring Data repositories.



## **@NamedQuery:**

> is used to define a single named query for an entity. It is applied to the entity class itself.
>
> ```java
> @Entity
> @NamedQuery(
>     name = "Person.findAll",
>     query = "SELECT p FROM Person p"
> )
> public class Person {
>     // entity fields and methods
> }
> 
> 
> // Here's an example of using a named query in Java code:
> TypedQuery<Person> query = entityManager.createNamedQuery("Person.findAll", Person.class);
> List<Person> resultList = query.getResultList();
> ```

## @NamedQueries

> used to define multiple named queries for an entity
>
> ```java
> @Entity
> @NamedQueries({
>     @NamedQuery(
>         name = "Person.findAll",
>         query = "SELECT p FROM Person p"
>     ),
>     @NamedQuery(
>         name = "Person.findByAge",
>         query = "SELECT p FROM Person p WHERE p.age = :age"
>     )
> })
> public class Person {
>     // entity fields and methods
> }
> 
> // example on how to use
> TypedQuery<Person> query = entityManager.createNamedQuery("Person.findAll", Person.class);
> List<Person> resultList = query.getResultList();
> ```
>
> 

# Spring Bean

## @Bean

> - The `@Bean` annotation is used to explicitly declare a bean. A method annotated with `@Bean` produces a bean definition for the object that will be returned from that method.
> - This annotation is typically used on methods within classes annotated with `@Configuration`. The method's return type is the type of the bean, and the method body contains the logic for creating and configuring the bean.
> - Spring container manages the lifecycle of beans defined with `@Bean` and injects them into other beans or components.

## @Component

> `@Component` is a class that is eligible to be scanned by Spring's auto-detection for dependency injection

## @Repository

> Handle all DataAccessExceptions differently to a general Throwable type

## @Service

> Used to annotate classes that provide business services or service-related functionality.

## @Controller

> the @Controller annotation is typically used in UI-based applications where the response is generally an HTML page

# HttpAPI 相关

## @ResponseBody

> The @ResponseBody annotation indicates a method return value should be bound to the web response body

## @RestController

> is used in the case of REST style controllers i.e. handler methods shall return the JSON/XML response directly to the client rather than using view resolvers. The @RestController is a convenience annotation that combines the @Controller and @ResponseBody annotations.



## @RequestBody

> When you use @RequestBody with a method parameter, Spring Boot automatically converts the content of the request body (usually in JSON or XML format) into the corresponding Java object.

## @PathVariable

> An annotation used in the context of a Spring MVC controller to extract values from the URI template and bind them to method parameters.

## @GetMapping("/{id}")

> Used to map HTTP GET requests to specific handler methods in a controller class

## @PutMapping("/{id}")

>  used to map HTTP PUT requests to a specific handler method in a controller class.

## @PostMapping("")

> is used to map HTTP POST requests to a specific handler method in a controller class without specifying a path variable in the URI.

## @DeleteMapping("/{id}")

> handle HTTP DELETE requests for a specific endpoint mapped to the given `{id}` path variable.

## @Argument

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
## @QueryMapping

> In Spring Boot for GraphQL, @QueryMapping is an annotation that can be used to associate a method with a query field in your GraphQL schema.

# Spring 相关

## @Autowired

> Is used to automatically inject dependencies into a Spring bean. When you mark a field, constructor, or a method with @Autowired, the Spring framework automatically resolves and provides the necessary dependencies at runtime. 



## @SpringBootApplication

> The @SpringBootApplication annotation is equivalent to using @Configuration, @EnableAutoConfiguration, and @ComponentScan with their default attributes. Spring Boot enables the developer to use a single annotation instead of using multiple. But, as we know, Spring provided loosely coupled features that we can use for each annotation as per our project needs
>
> A single @SpringBootApplication annotation can be used to enable those three features, that is:

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



## @Transactional

> is used to declare the transactional behavior of a method or a class. It indicates that the annotated method or all methods in the annotated class should be executed within a transactional context. 



## @EnableTransactionManagement

> is used to enable Spring's annotation-driven transaction management capability. It is typically applied to a configuration class, and it allows the use of `@Transactional` annotations for managing transactions in Spring beans.

![image-20240117205528935](/Users/jingwei/CS材料/Chuwa/hw/chuwa1206/ShortQuestions/images/img10.png)



# Exception Handling

## @ExceptionHandler

> - Method Level
>
> - used to handle the specific exceptions and sending the custom responses to the client



## @ControllerAdvice

> - Class Level
> - make this class be a bean
>
> When an exception is thrown during the execution of a controller method, Spring will look for a method annotated with `@ExceptionHandler` in the `@ControllerAdvice` class that can handle the exception.

```java
@ControllerAdvice
public class ExceptionHandlerController {
    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleException(Exception e) {
        return new ResponseEntity<>("An error occurred: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
```



# Validation

## @valid

> is a Spring annotation that is used to enable validation of method parameters and return values.



## @NotEmpty(message = "Name should not be null or empty")

> is part of the Hibernate Validator framework, which is an implementation of the Bean Validation API. It is used to validate that a string is not null and not empty.
>
> Note: Only can be used for **String, Collection, Map**



## @NotNull

> The `@NotNull` annotation in Java is used to validate that a field, property, or parameter is not `null`



## @Pattern

> The `@Pattern` annotation in Java is used to apply a regular expression pattern to a field, property, or parameter. It is commonly used with `String` types to ensure that the string matches a specified pattern.



# Dependancy Injection / IOC

## @Resource

> to inject resources into a class ( is part of the Java EE specification rather than the Spring framework.)



## @Inject

>  is used to inject dependencies into a class ( is part of the Java EE specification rather than the Spring framework.)



## @Primary

> is used to indicate a primary bean when multiple beans of the same type exist in the Spring application context. 



## @Configuration

> - The `@Configuration` annotation is used to indicate that a class declares one or more `@Bean` methods and may be processed by the Spring container to generate bean definitions and service requests for those beans at runtime.
> - Classes annotated with `@Configuration` are typically used to define the configuration of the Spring application context, including the declaration of beans.



## @ComponentScan

>  @ComponentScan` is an annotation in the Spring framework that is used to specify the packages that Spring should scan for annotated components. By default, Spring scans the package of the class annotated with `@SpringBootApplication` and its sub-packages. If you want to scan additional packages, you can specify them using the `basePackages` or `basePackageClasses` attributes of `@ComponentScan

```java
@Configuration
@ComponentScan(basePackages = "com.example")
public class AppConfig {

    // @Bean methods or other configuration...

}
```

```java
@SpringBootApplication
@ComponentScan(basePackages = "com.example")
public class YourApplication {

    public static void main(String[] args) {
        SpringApplication.run(YourApplication.class, args);
    }
}
```



## @Qualifier("hibernateChuwa")

> The `@Qualifier` annotation in Spring is used to disambiguate between multiple beans of the same type when injecting dependencies.
