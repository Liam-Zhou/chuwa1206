# Homework 8



## How do you do the debug?



- set breakpoints with IDE

- Run in debug mode

- Use logging



## What is DTO, VO, Payload, DO, model?




- DTO: A data transfer object is an object that carries data between processes or layers of an application, it is typically used to transfer data between the client and the Service

- VO: value object represents a value rather than an entity with an identity. It is used to encapsulate attributes or values that don't change over time

- Payload: payload refers to the data transmitted over a network or passed between different parts of a system, it is a generic term used to describe the data being sent or received

- DO: Domain Objects represent entities within the domain of the application. They encapsulate both data and business logic related to a specific domain.

- model: In the context of Spring MVC or Spring Boot, the term "Model" typically refers to the data that is being transferred between the controller and the view. 



## What is @JsonProperty("description_yyds")?



- `@JsonProperty` is used to define the mapping between a Java object's property and its corresponding custom name in JSON. In this case, map the property to "description_yyds" in JSON.



## Do you know what is Jackson?



- Jackson is a popular open-source Java library for processing JSON data. It provides a set of high-performance and flexible APIs for reading, writing, and manipulating JSON. Jackson is widely used in Java applications for handling JSON serialization and deserialization tasks.



## What is spring-boot-starter?



- The `spring-boot-starter` artifacts simplify the process of including dependencies in your project by bundling commonly used libraries and configurations together. These starters follow a naming convention, where the artifact's name indicates the type of application or functionality it provides.



## Do you know @RequestMapping(value="/users", method=RequestMethod.POST)?



- It is the same as using `@PostMapping("/users")`

- `@RequestMapping(value="/users", method=RequestMethod.GET)`

- `@RequestMapping(value="/users/{id}", method=RequestMethod.PUT)`

- `@RequestMapping(value="/users/{id}", method=RequestMethod.DELETE)`

- `@RequestMapping(value="/users", method=RequestMethod.POST)`



## What is ResponseEntity? Why do we need it?



- `ResponseEntity` is a class in the Spring Framework that represents the entire HTTP response, including the status code, headers, and body. It is commonly used in Spring MVC to provide more control and flexibility over the HTTP response sent back to the client.



## What is ResultSet in JDBC? Describe the flow of how to get data using JDBC.



- In JDBC (Java Database Connectivity), a `ResultSet` is an interface that represents the result set of a database query. It provides methods to iterate over the rows of the result set and retrieve data from the columns. The `ResultSet` object is obtained from a `Statement` object after executing a SQL query.

- Flow of using JDBC:
  
  - establish a connection
  
  - create a prepared statement or query
  
  - execute the query
  
  - looping through the result set to get the objects
  
  - close the connection



## What is the ORM framework?



- a "bridge" between object-oriented programs and relational databases, i.e. mapping entity classes to relational DB tables



## What is the serialization and deserialization?



- Serialization is the process of converting an object or a data structure into a format that **can be easily transmitted or stored**. The serialized data typically represents the state of the object and its internal structure.

- Deserialization is the process of **reconstructing an object or a data structure** from its serialized form. It involves reading the serialized data and creating an equivalent object with the same state and structure.



## Use stream api to get the average of the array [20, 3, 78, 9, 6, 53, 73, 99, 24, 32]



```java
int[] numbers = [20, 3, 78, 9, 6, 53, 73, 99, 24, 32];
double average = Arrays.stream(numbers).average().orElse(0.0);
```
