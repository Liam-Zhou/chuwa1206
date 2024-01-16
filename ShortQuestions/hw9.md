1. how do you do the debug?
   - Set Up Your Project:
   - Configure the Application for Debugging:
   - Enable Debugging:
   - Run in Debug Mode:
   - Debugging Tools:
   - Monitor Logs:
   - Stopping the Debug Session:
   
2. What is DTO, VO, Payload, DO, model?
   - DTO (Data Transfer Object):
     - In Spring Boot, DTOs are commonly used to transfer data between layers of an application or between the client and server. They are lightweight objects that carry data without containing any business logic. 
     - DTOs are often employed to encapsulate the data exchanged through API requests and responses.
   - VO (Value Object):
     - While Spring Boot does not explicitly use the term "VO" (Value Object), the concept of using objects to represent values in a domain is consistent with object-oriented programming principles
     - In software engineering, a Value Object (VO) is an object that represents a value or concept in the domain of the application. Unlike an entity, a value object has no identity and is immutable 1. It is used to encapsulate a group of related attributes and is often used to represent a single concept.
   - Payload:
     - In the context of Spring Boot's RESTful APIs, the term "Payload" is often used to refer to the data that is sent in the request or response body. This includes JSON or XML data exchanged between clients and servers.
     - Spring Boot provides annotations like @RequestBody and @ResponseBody to handle and map payloads in controller methods.
   - DO (Domain Object):
     - Domain Objects in Spring Boot represent entities within the application's domain. These objects encapsulate business logic and interact with the database.
     - Entities annotated with @Entity in Spring Data JPA are examples of Domain Objects. They are typically used to model and persist data in a relational database.
   - Model:
     - In Spring Boot, the term "Model" is often associated with the Model-View-Controller (MVC) architecture. The Model represents the application's data and business logic.
     - Spring MVC uses the Model interface to pass data between the controller and the view in web applications.
     
3. What is @JsonProperty("description_yyds")
   ```java
   <dependency>
      <groupId>com.fasterxml.jackson.core</groupId>
      <artifactId>jackson-databind</artifactId>
      <version>2.13.3</version>
      <scope>compile</scope>
   </dependency>
   ```
4. Do you know what is jackson?
5. What is spring-boot-stater?
   - what dependecies in the below starter? do you know any starters?
   ```java
   <dependency>
   <groupId>org.springframework.boot</groupId>
   <artifactId>spring-boot-starter-web</artifactId>
   </dependency>
   ```
6. do you know @RequestMapping(value = "/users", method = RequestMethod.POST) ? could you list
   CRUD by this style?
7. What is ResponseEntity? why do we need it?
   ```java
   new ResponseEntity<>(postResponse, HttpStatus.OK);
   new ResponseEntity<>(postResponse, HttpStatus.CREATED);
   ResponseEntity.ok(postService.getPostById(id));
   ```
8. What is ResultSet in jdbc? and describe the flow how to get data using JDBC
9. What is the ORM framework?
10. What is the serialization and desrialization?
11. Learn how to use ObjectMapper by this example.
    - MavenProject -> api -> FoodOutLetJackson
12. use stream api to get the average of the array [20, 3, 78, 9, 6, 53, 73, 99, 24, 32].