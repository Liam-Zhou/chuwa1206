# hw8: hw41-springboot-RUD

### Question 2
**Question**: How do you do the debug?

Debugging in Spring Boot can be accomplished by using the built-in support in the IDE (like IntelliJ or Eclipse). Breakpoints can be set in the code, the application can be run in debug mode, and various features like step-over, step-into, watch variables, or evaluate expressions can be utilized to understand the issue and fix the bugs.

### Question 3
**Question**: What is DTO VO Payload DO model?

DTO (Data Transfer Object), VO (View Object), Payload, and DO (Domain Object) are patterns used in object mapping and data interaction layers in applications. DTO is an object that carries data between processes, VO represents data that can be displayed or communicated between client and server, Payload often refers to the part of transmitted data that is the actual intended message, and DO is a domain object that encapsulates business logic.

### Question 4
**Question**: What is @JsonProperty("description_yyds")?

@JsonProperty("description_yyds") is an annotation from the Jackson JSON processing library. It is used to map a property of a Java object to a JSON key in a JSON object. In this case, it maps the "description_yyds" JSON key to the associated property in the Java object.

### Question 5
**Question**: Do you know what is Jackson?

Jackson is a high-performance JSON processor for Java. It provides functionality for reading and writing JSON, either to and from basic POJOs (Plain Old Java Objects), or to and from a general-purpose JSON Tree Model (JsonNode), as well as related functionality for performing conversions.

### Question 6
**Question**: What is spring-boot-starter?

Spring Boot Starter is a set of convenient dependency descriptors that you can include in your application. It helps to simplify the Maven or Gradle configuration by including a single dependency that provides all necessary libraries for a specific feature or framework (like spring-boot-starter-web for web applications).

### Question 7
**Question**: Do you know @RequestMapping(value = "/users", method = RequestMethod.POST)? Could you list CRUD by this style?

The @RequestMapping annotation is used in Spring Framework to map web requests to specific handler classes or handler methods. It is capable of handling HTTP request methods like GET, POST, DELETE, PUT, etc. In this specific case, `@RequestMapping(value = "/users", method = RequestMethod.POST)` maps a POST request for the "/users" URL to the associated method, typically used for creating a new resource. 
```
@RequestMapping(value = "/users", method = RequestMethod.POST) // Create
@RequestMapping(value = "/users/{id}", method = RequestMethod.GET) // Read
@RequestMapping(value = "/users/{id}", method = RequestMethod.PUT) // Update
@RequestMapping(value = "/users/{id}", method = RequestMethod.DELETE) // Delete
```

### Question 8
**Question**: What is ResponseEntity? Why do we need it?

ResponseEntity is a type in Spring Framework that allows to specify the response fully in the RESTful web services, including status code, headers, and body. It provides more control over the HTTP response and is typically used to return custom responses in the REST endpoints.

### Question 9
**Question**: What is ResultSet in JDBC? And describe the flow how to get data using JDBC.

ResultSet is a Java object that is returned when a query is executed using JDBC. It represents a database result set, which is essentially a table of data representing a database result set. 
The flow typically involves establishing a connection to the database, creating a statement, executing a query, iterating through the ResultSet to retrieve data, and finally closing the connection and resources.

### Question 10
**Question**: What is the ORM framework?

ORM (Object-Relational Mapping) framework is a programming technique for converting data between incompatible type systems using object-oriented programming languages. It creates a "virtual object database" that can be used from within the programming language. Examples include Hibernate, JPA, and Spring Data.

### Question 11
**Question**: Learn how to use ObjectMapper by this example.
```
FoodOutlet foodOutlet = objectMapper.readValue(resBody, FoodOutlet.class);
String s = objectMapper.writeValueAsString(foodOutlet);
objectMapper.readTree() // learn how to use it?
```

ObjectMapper is part of the Jackson library used for serializing Java objects to JSON and deserializing JSON to Java objects. The provided example demonstrates reading a JSON as a Java object (FoodOutlet), converting a Java object to a JSON string, and reading a JSON structure as a tree.

### Question 12
**Question**: What is the serialization and deserialization?

Serialization is the process of converting an object into a format that can be easily stored or transmitted, like JSON or XML. Deserialization is the reverse process, converting the serialized data back into an object. These processes are crucial for data exchange between different systems or layers in an application.

### Question 13
**Question**: Use stream API to get the average of the array [20, 3, 78, 9, 6, 53, 73, 99, 24, 32].

```
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] numbers = {20, 3, 78, 9, 6, 53, 73, 99, 24, 32};
        double average = Arrays.stream(numbers)
                               .average()
                               .orElse(Double.NaN);
        System.out.println("The average is " + average);
    }
}
```

