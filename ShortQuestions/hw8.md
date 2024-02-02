# hw8: hw41-springboot-RUD

### Question 2
**Question**: How do you do the debug?

Debugging can be approached from two perspectives: using an IDE and using Postman for API testing.

- **IDE Debugging**: 
  - Set breakpoints in the code where you want to inspect the state of the application.
  - Start the application in debug mode.
  - Use the IDE's debugging tools to step through the code, inspect variables, evaluate expressions, and monitor the flow of the application.

- **Postman for API Debugging**: 
  - Set up your API request in Postman.
  - Send the request to the server and observe the response.
  - If the behavior is not as expected, use the IDE to set breakpoints in the server code that handles the API request.
  - Trigger the request from Postman again. The execution will halt at the breakpoints set in the IDE.
  - Use the IDE's debugging features to inspect the request, the state of the application, and understand why the response is not as expected.
  - Modify the code as needed and retest until the API behaves correctly.
  
Combining Postman for sending requests and observing responses with an IDE for inspecting the state and flow of the application provides a powerful debugging environment for backend development.


### Question 3
**Question**: What is DTO VO Payload DO model?

- **DTO (Data Transfer Object)**: An object that carries data between processes to reduce the number of method calls. Primarily used for transferring data between the client and the server.
  
- **VO (Value Object)**: An object that represents a descriptive aspect of the domain with no conceptual identity, primarily used for read-only data that is displayed to the user.

- **Payload**: The actual data that is sent in an HTTP request or response body. In the context of APIs, it refers to the substantive part of the message, excluding headers or metadata.
  
- **DO (Data Object)**: An object that represents the domain model of an application, often mirroring database entities. It is primarily used to store, retrieve, and manage data in the database.

- **Model**: A part of the MVC (Model-View-Controller) architecture. In this context, it represents the data and the business rules that govern access to and updates of this data. Models are closely related to the 'DO' as they are often used to represent the domain-specific data and business logic.


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

The `ResultSet` in JDBC represents the result set of a database query. It is essentially a table of data representing a database result set. Here's the flow to retrieve data using JDBC:

1. **Load and Register JDBC Driver**: Load the JDBC driver class using `Class.forName()` and register it with `DriverManager`.

    ```
    Class.forName("com.mysql.jdbc.Driver");
    ```

2. **Establish Connection**: Use `DriverManager.getConnection()` to establish a connection to the database.

    ```
    Connection connection = DriverManager.getConnection(url, username, password);
    ```

3. **Create Statement**: Create a `Statement` or `PreparedStatement` object using the connection object to send SQL queries to the database.

    ```
    Statement statement = connection.createStatement();
    ```

4. **Execute Query**: Execute the query using the `executeQuery` method of the `Statement` object. This returns a `ResultSet`.

    ```
    ResultSet resultSet = statement.executeQuery("SELECT * FROM tableName");
    ```

5. **Process ResultSet**: Iterate through the `ResultSet` object to retrieve and process the data.

    ```
    while (resultSet.next()) {
        // Retrieve data by column name or column index
        // e.g., int id = resultSet.getInt("id");
        // e.g., String name = resultSet.getString("name");
    }
    ```

6. **Close Resources**: Finally, close the `ResultSet`, `Statement`, and `Connection` objects to release the resources.

    ```
    resultSet.close();
    statement.close();
    connection.close();
    ```

This flow represents the basic steps to retrieve data from a database using JDBC, ensuring resource management by closing the connection and other resources at the end.


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

### Question 14、15

03_post_pageable and 04_comment:

[link](https://github.com/Liam-Zhou/chuwa1206/tree/diana_men/hw8/CodingQuestions/hw8/springboot-redbook/README.md)

### Question 16
**Question**: Try to write the CRUD api for a new application Cassandra-Blog

[link](https://github.com/Liam-Zhou/chuwa1206/tree/diana_men/hw8/CodingQuestions/hw8/Cassandra-Blog)
