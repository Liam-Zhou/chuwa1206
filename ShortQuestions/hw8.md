## 2. how do you do the debug?

# Set Breakpoints:
Place breakpoints in your Java code where you suspect the issue is occurring. Breakpoints allow you to pause the execution of the program at a specific line and inspect variables.

# Inspect Variables: 
While paused at a breakpoint, inspect the values of variables. This can help you understand the state of your application at that point in time.

# Postman + Status Code:
Use postman to send request to test and debug by the reponse status code.

## 3. What is DTO, VO, Payload, DO, model?

# PTO:
DTO is used for transferring data between processes or layers.

# VO:
VO is a type of object representing a value with no conceptual identity.

# Payload:
Payload refers to the actual data transmitted over a network or exchanged between components.

# DO:
DO represents domain concepts with both data and behavior.

# Model
Model, in the context of MVC, refers to the part of the application responsible for business logic and data management.

## 4. What is @JsonProperty("description_yyds")?

@JsonProperty: Annotation indicating the JSON property name

## 5. Do you know what is jackson?

Jackson is a widely used open-source Java library for JSON processing. It provides a set of tools for working with JSON data in Java applications, including capabilities for reading JSON content, writing JSON content, and mapping JSON data to and from Java objects.

## 6.What is spring-boot-stater? what dependecies in the below starter? do you know any starters?

A Spring Boot starter typically includes the necessary dependencies for a specific functionality or feature, and it may also provide default configuration settings. The spring-boot-starter-web is a commonly used starter for developing web applications with Spring Boot. It includes dependencies related to web development, such as Spring MVC, Tomcat (or another embedded web server), and other necessary libraries.

spring-boot-starter-data-jpa: Includes dependencies for working with Java Persistence API (JPA) and relational databases.

spring-boot-starter-security: Provides dependencies for securing your application with Spring Security.

spring-boot-starter-test: Includes dependencies for testing your Spring Boot application.

## 7. Do you know @RequestMapping(value = "/users", method = RequestMethod.POST)? Could you list CRUD by this style?

It is for requests by POST for URL "/users"

@RequestMapping(value = "/users/{userId}", method = RequestMethod.GET)
@RequestMapping(value = "/users/{userId}", method = {RequestMethod.PUT, RequestMethod.PATCH})
@RequestMapping(value = "/users/{userId}", method = RequestMethod.DELETE)

## 8. What is ResponseEntity? why do we need it?

ResponseEntity is a class in Spring Framework that represents the entire HTTP response, including the status code, headers, and body. It is commonly used in Spring MVC controllers to provide a more flexible way to control the HTTP response sent back to the client.

## 9. What is ResultSet in jdbc? and describe the flow how to get data using JDBC

 A ResultSet is an interface in the Java programming language that provides methods for retrieving and processing the results of a database query.

 1. Establish Database Connection
 2. Create a Statement
 3. Execute a Query and Get ResultSet
 4. Process ResultSet
 5. Close Resources

## 10. What is the ORM framework?

ORM stands for Object-Relational Mapping. It is a programming technique that allows data to be accessed, manipulated, and represented in an object-oriented programming language, while the actual data is stored in a relational database. The primary goal of ORM is to bridge the gap between the relational world of databases and the object-oriented world of programming languages, making it easier to work with databases in applications. 

## 12. What is the serialization and desrialization?

Serialization and deserialization are processes that involve converting data from one representation to another. These processes are often used in the context of transmitting data between different systems or storing data in a format that can be easily reconstructed. The terms are commonly associated with object-oriented programming and data interchange formats like JSON or XML.

## 13. Use stream api to get the average of the array [20, 3, 78, 9, 6, 53, 73, 99, 24, 32] 

Arrays.stream(numbers).average().orElse(0.0);


