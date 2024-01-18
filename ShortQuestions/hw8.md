1. See annotations.md
2. By setting spring.mvc.log-resolved-exception=true, this property instructs Spring MVC to log information about resolved exceptions. This can be helpful during development and debugging phases to understand how exceptions are being handled and mapped to HTTP status codes.
    Also, add breaking point to debug.
3. What is DTO, VO, Payload, DO, model?

    - DTO: A Data Transfer Object
    - VO: View Object
    - Payload
    - DO: Data Object
    - model
    - Although they have different names, they basically are of the same concept, which is an object that carries data between processes or layers of an application. It is often used to transfer data between a client and a server or between different layers of an application.

4. What is @JsonProperty("description_yyds")

    - It is used to specify the name of the property as it should appear in the JSON representation, overriding the default behavior. In this case, "description_yyds".

5. do you know what is jackson?

    - It refers to the Jackson Databind library.Jackson is a popular open-source Java library for handling JSON data. The Jackson Databind module specifically provides functionality for converting Java objects to JSON (serialization) and JSON to Java objects (deserialization). Key features of Jackson Databind include:
     1. Data Binding: converts JSON to and from POJO (Plain Old Java Object) using property accessor or using annotations.
      2. Supports annotations (such as @JsonProperty, @JsonInclude, etc.) for fine-tuning the serialization and deserialization behavior.


6. What is spring-boot-stater?
    what dependecies in the below starter? do you know any starters?

    - is a special kind of dependency that simplifies the inclusion of commonly used libraries and configurations for specific tasks or features. Starters are designed to be a convenient way to bootstrap your Spring Boot projects by providing a curated set of dependencies with sensible defaults.
    - `spring-boot-starter-web`: Starter for building web, including RESTful, applications using Spring MVC. Uses Tomcat as the default embedded container
    - spring-boot-starter-data-jpa: For working with databases and JPA.
    - spring-boot-starter-test:  For including dependencies for testing, including JUnit and other testing libraries.
    - spring-boot-starter-security: For integrating Spring Security for handling security concerns.
    - spring-boot-starter-actuator: For adding production-ready features, such as monitoring and management endpoints.

7. do you know @RequestMapping(value = "/users", method = RequestMethod.POST) ? could you list
   CRUD by this style?

    - `value` = "/users" specifies the URL path ("/users").
    - `method` = RequestMethod.POST specifies that the annotated method should handle HTTP POST requests.
    - ```@RequestMapping(value = "/users", method = RequestMethod.PUT)```
    - ```@RequestMapping(value = "/users/{id}", method = RequestMethod.GET)```
    - ```@RequestMapping(value = "/users/{id}", method = RequestMethod.DELETE)```


8. What is ResponseEntity? why do we need it?

    - is a class in the Spring Framework that represents the entire HTTP response. It allows you to customize the HTTP response status, headers, and body, providing more control over the response that is sent back to the client.

9. What is ResultSet in jdbc? and describe the flow how to get data using JDBC

    -  `ResultSet` is an interface in the Java programming language that represents the result set of a database query. It provides methods to retrieve and manipulate the data returned by a SQL query.
   1. establishing a connection
   2. creating a prepared statement or query
   3. execute the query
   4. looping through the result set to get the objects
   5. close the connection
    

10. What is the ORM framework?

    -  Object-Relational Mapping is a programming technique that allows data to be seamlessly converted between the object-oriented programming language used by an application and the relational database that stores the data. ORM frameworks provide a higher-level, more abstract way of interacting with databases. benefits of ORM frameworks include:
        1. Abstraction of Database Operations
       2. Automatic Mapping
       3. Increased Productivity
       4. Reduced Boilerplate Code
       5. Cross-Platform Support

11. Learn how to use ObjectMapper by this example

    - `objectMapper.readTree()` is used to read JSON data and create a Jackson `JsonNode` object, representing the hierarchical structure of the JSON data. The `JsonNode` class is part of the Jackson tree model and provides a way to navigate and manipulate JSON data without binding it to specific Java classes.

12. What is the serialization and desrialization?

   - Serialization is the process of converting a data object—a combination of code and data represented within a region of data storage—into a series of bytes that saves the state of the object in an easily transmittable form.
   - The reverse process—constructing a data structure or object from a series of bytes—is deserialization.


13. use stream api to get the average of the array [20, 3, 78, 9, 6, 53, 73, 99, 24, 32].

   - See Hw8 in CodingQuestions


14. 抄写，https://github.com/TAIsRich/springboot-redbook/tree/03_post_pageable，你也可以像我⼀样分
    branch添加新代码。




15. 抄写 https://github.com/TAIsRich/springboot-redbook/tree/04_comment你也可以像我⼀样分branch添加新
    代码。




16. Try to write the CRUD api for a new application Cassandra-Blog


1. Watch(很重要) https://www.bilibili.com/video/BV1aQ4y1Z7Nj/
2. spring 提供了相关dependency,(https://start.spring.io/)
1. Spring Data for Apache Cassandra
3. Cassandra⼗分流⾏，且⾯试问的多