### 2. How do you do the debug?
1. Set breakpoints
2. 
### 3. What is DTO, VO, Payload, DO, model?

1. **DTO (Data Transfer Object):**
    
    - **Definition:** DTO is an object that carries data between processes, typically between the business layer and the presentation layer. It is used to transfer data between different parts of a program or between different applications.
    - **Purpose:** DTOs help to encapsulate and transport data across layers or between services without exposing the internal details of the data structure.
2. **VO (Value Object):**
    
    - **Definition:** VO is an object that represents a descriptive aspect of the domain with no conceptual identity. In other words, it is an immutable object that carries attributes but has no distinct identity.
    - **Purpose:** VOs are used to encapsulate simple pieces of information or values that belong together in a way that makes sense in the domain context.
3. **Payload:**
    
    - **Definition:** Payload generally refers to the data transmitted in a communication or passed as an argument to a method. In the context of web development or APIs, payload often refers to the data part of a request or response.
    - **Purpose:** The payload contains the actual data being sent or received, whether it's in the body of an HTTP request, a message in a queue, or any other communication mechanism.
4. **DO (Domain Object):**
    
    - **Definition:** DO represents an object in the domain model of the application. It encapsulates business logic and data related to a specific domain concept.
    - **Purpose:** DOs are used to model and implement the core business logic of the application. They are often persisted in a database and represent the real-world entities the application is dealing with.
5. **Model:**
    
    - **Definition:** "Model" is a broad term that can refer to any representation of data in an application. It can include domain objects, view models, data transfer objects, and more.
    - **Purpose:** The purpose of a model is to represent and manage the data of an application. It can be used to transfer data between layers, present data to the user, or represent the structure of the application's domain.

### 4. What is @JsonProperty("description_yyds")

`@JsonProperty("description_yyds")` is a Jackson annotation used in Java to customize the mapping between Java objects and JSON (JavaScript Object Notation) during serialization and deserialization. Specifically, this annotation is used to define a custom mapping between the annotated Java property and its corresponding JSON property. In this case, the JSON property is named "description_yyds."

### 5. Do you know what is jackson?

`Jackson` is a widely used Java library for working with JSON (JavaScript Object Notation) data. It provides a set of APIs and tools for both serializing Java objects into JSON format (serialization) and deserializing JSON data into Java objects (deserialization). Jackson is commonly used in Java applications to handle JSON data, making it easier to work with web APIs, exchange data between systems, and store data in a human-readable format. Some key features and components of Jackson include:

1. **JSON Data Binding:**
    
    - Jackson allows mapping Java objects to JSON and vice versa, providing a seamless way to work with JSON data in Java applications.
    - It supports automatic conversion between Java objects and JSON, eliminating the need for manual parsing and serialization/deserialization code.
2. `ObjectMapper`: 
	- The ObjectMapper class is at the core of Jackson and is used for converting JSON data to Java objects (deserialization) and Java objects to JSON (serialization). It allows you to customize the mapping between JSON properties and Java object properties, handle different data types, and manage JSON data in a flexible way.
3. **Streaming API:**
    
    - Jackson provides a streaming API for reading and writing JSON content in a more memory-efficient way.
    - The streaming API allows you to process JSON data incrementally without loading the entire structure into memory.
4. **Tree Model:**
    
    - Jackson supports a tree model, where the entire JSON structure is represented as a tree of `JsonNode` objects.
    - This model is useful for manipulating JSON data when the structure is not known in advance.
5. **Annotation Support:**
    
    - Jackson uses annotations, such as `@JsonProperty`, `@JsonIgnore`, etc., to customize the serialization and deserialization process.
    - Annotations provide fine-grained control over how Java objects are mapped to JSON and vice versa.
6. **Polymorphic Type Handling:**
    
    - Jackson supports polymorphic types and allows handling complex object hierarchies during serialization and deserialization.
    - This is useful when working with inheritance and interfaces in Java.
7. **Custom Serialization and Deserialization:**
    
    - Jackson allows developers to create custom serializers and deserializers to handle specific serialization or deserialization requirements.
    - Customization can be done at the class, field, or method level.
8. **Modularity:**
    
    - Jackson is modular and extensible. It can be used with other Jackson modules or third-party modules to extend its functionality.
9. **Support for Java Generics:**
    
    - Jackson supports the serialization and deserialization of Java generics, making it versatile for a wide range of use cases.
### 6. What is spring-boot-stater?
The `spring-boot-starter-web starter` is a versatile choice for developing web applications in Spring Boot. It sets up a basic web application environment with sensible defaults and allows you to quickly start building web-based projects. You can always customize and add additional dependencies based on your specific requirements as your project evolves.


What dependecies in the below starter? do you know any starters?
```JAVA
<dependency>  
  <groupId>org.springframework.boot</groupId>  
  <artifactId>spring-boot-starter-web</artifactId>  
</dependency>
```

Here are some of the key dependencies that are typically included when you use the spring-boot-starter-web:

Spring MVC: The Spring Framework's Model-View-Controller (MVC) framework is included, allowing you to build web applications with a structured architecture.

Embedded Web Server: An embedded web server, such as Apache Tomcat or Jetty, is included. You don't need to set up a separate web server; Spring Boot takes care of it.

Spring Web: This includes the core Spring Web components, such as the DispatcherServlet and other classes necessary for handling HTTP requests and responses.

Spring Boot: Various Spring Boot libraries and utilities are included to simplify web application development, including auto-configuration for web-related features.

Jackson: The Jackson library is included for JSON serialization and deserialization. This allows you to easily work with JSON data in your web applications.

Validation: Dependencies for Spring's validation framework are included. This is helpful for form validation and data validation in your web application.

### 7. Do you know @RequestMapping(value = "/users", method = RequestMethod.POST) ? could you list CRUD by this style?

It defines a controller method that handles HTTP POST requests at path `/users`.

- create: `@RequestMapping(value = "/users", method = RequestMethod.POST)`
- get: `@RequestMapping(value = "/users/{userId}", method = RequestMethod.GET)`
- get all: `@RequestMapping(value = "/users", method = RequestMethod.GET)`
- update: `@RequestMapping(value = "/users/{userId}", method = RequestMethod.PUT)`
- delete: `@RequestMapping(value = "/users/{userId}", method = RequestMethod.DELETE)`
### 8. What is ResponseEntity? why do we need it?
```java
new ResponseEntity<>(postResponse, HttpStatus.OK);  
new ResponseEntity<>(postResponse, HttpStatus.CREATED);  
ResponseEntity.ok(postService.getPostById(id));
```
`ResponseEntity` is a class in Spring Framework that represents the entire HTTP response. It is commonly used in Spring MVC and Spring WebFlux applications to encapsulate the response status, headers, and body. `ResponseEntity` provides a more flexible way to build and customize HTTP responses compared to returning a simple object or using the `@ResponseBody` annotation.

Here are some key aspects of `ResponseEntity` and why it is useful:

1. **HTTP Status and Headers:**
    
    - `ResponseEntity` allows you to set the HTTP status code and headers for the response. This gives you fine-grained control over the response metadata.
    - You can set status codes like OK (200), Created (201), No Content (204), Bad Request (400), etc.
2. **Response Body:**
    
    - `ResponseEntity` includes a generic type parameter for the response body, allowing you to specify the type of the data you want to return in the response.
    - This can be any Java object or a collection of objects.
3. **Customization:**
    
    - You can customize the entire response, including status, headers, and body, based on various conditions in your application logic.
    - For example, you might return different status codes for success and error scenarios.
4. **Flexibility in Controllers:**
    
    - `ResponseEntity` is commonly used as the return type for Spring MVC and Spring WebFlux controller methods.
    - It provides a clear and consistent way to represent the HTTP response, making it easier to handle various scenarios in a controller.
5. **Error Handling:**
    
    - `ResponseEntity` is often used for handling errors and exceptions in a more controlled manner.
    - You can customize error responses by setting appropriate status codes, headers, and error messages.
6. **Conditional Responses:**
    
    - `ResponseEntity` allows you to handle conditional responses, such as returning different content types based on the client's request (e.g., JSON or XML).
### 9. What is ResultSet in jdbc? and describe the flow how to get data using JDBC


In JDBC (Java Database Connectivity), a `ResultSet` is an interface that represents the result set of a database query. It provides methods to traverse and retrieve data from the result set, which is essentially the tabular data returned by an SQL query.

Here is a basic flow of how to get data using JDBC:

1. **Load the JDBC Driver:**

- Load the JDBC driver for the specific database you are connecting to. This is typically done using `Class.forName()` for most JDBC drivers.
```java
Class.forName("com.mysql.cj.jdbc.Driver"); 

```

2. **Establish a Connection:**

- Create a connection to the database using the `DriverManager.getConnection()` method. Provide the database URL, username, and password.
```java
String url = "jdbc:mysql://localhost:3306/your_database";
String username = "your_username";
String password = "your_password";
Connection connection = DriverManager.getConnection(url, username, password);

```
3. **Create a Statement:**

- Create a `Statement` or `PreparedStatement` object for executing SQL queries. Use `createStatement()` for simple queries or `prepareStatement()` for parameterized queries.
```java
Statement statement = connection.createStatement();

```

4. **Execute the Query:**

- Execute the SQL query using the `executeQuery()` method on the statement object. This returns a `ResultSet`.

```
String sql = "SELECT * FROM your_table";
ResultSet resultSet = statement.executeQuery(sql);

```

5. **Process the ResultSet:**

- Use methods of the `ResultSet` to iterate through the result set and retrieve data. Common methods include `next()`, `getInt()`, `getString()`, etc.
```java
while (resultSet.next()) {
    int id = resultSet.getInt("id");
    String name = resultSet.getString("name");
    // Process the data as needed
}

```

6. **Close Resources:**

- Close the `ResultSet`, `Statement`, and `Connection` to release resources and avoid potential memory leaks.
```java
resultSet.close();
statement.close();
connection.close();

```
### 10. What is the ORM framework?
ORM stands for Object-Relational Mapping. It is a programming paradigm that allows developers to interact with relational databases using an object-oriented programming language. ORM frameworks provide a way to map the data in a relational database to objects in the application code, eliminating the need for direct SQL queries and making database interactions more natural and intuitive for developers.

Key concepts and features of ORM frameworks include:

1. **Object-Relational Mapping:**
    
    - ORM frameworks map database tables to classes in the programming language.
    - Each row in a table corresponds to an object instance, and each column corresponds to an attribute of the object.
2. **Abstraction of Database Operations:**
    
    - Developers interact with the database using programming language constructs (objects, methods) rather than writing raw SQL queries.
    - The ORM framework handles the translation of these operations into SQL.
3. **Automatic Query Generation:**
    
    - ORM frameworks generate SQL queries based on high-level, object-oriented operations performed in the application code.
    - This includes CRUD operations (Create, Read, Update, Delete) and more complex queries.
4. **Transparent Persistence:**
    
    - ORM frameworks manage the persistence of objects, automatically synchronizing changes made to objects in memory with the underlying database.
5. **Relationship Mapping:**
    
    - ORM frameworks handle relationships between objects and tables, such as one-to-one, one-to-many, and many-to-many relationships.
    - Associations in the object model are reflected in the database schema.
6. **Caching and Optimization:**
    
    - ORM frameworks often include caching mechanisms to improve performance by reducing the need for repeated database queries.
    - Optimization strategies are employed to fetch and update data efficiently.
7. **Cross-Database Portability:**
    
    - ORM frameworks abstract away database-specific details, making it easier to switch between different database systems without major code changes.
8. **Schema Generation and Migration:**
    
    - Some ORM frameworks can automatically generate database schemas based on the object model, simplifying database setup.
    - They may also provide tools for database schema migrations as the application evolves.

### 11. Learn how to use ObjectMapper by this example.
https://github.com/B1gO/chuwa-eij-tutorial/blob/main/02-java-core/src/main/java/com/chuwa/exercise/oa/api/FoodOutletJackson.java

### 12. What is the serialization and desrialization?
  
Serialization and deserialization are processes of converting complex data types, such as objects or data structures, into a format that can be easily stored, transmitted, or reconstructed. These processes are often used in the context of programming and data interchange between different systems or components.

1. **Serialization:**
    
    - **Definition:** Serialization is the process of converting an object or a data structure into a byte stream or another format that can be easily stored or transmitted.
    - **Purpose:** Serialized data can be saved to a file, sent over a network, or stored in a database. It allows for the preservation of the object's state.
2. **Deserialization:**
    
    - **Definition:** Deserialization is the process of reconstructing an object or data structure from a byte stream or another serialized format.
    - **Purpose:** Deserialization is used to recreate an object in a different location or context, such as when retrieving data from storage or receiving data over a network.

Example:
```java
import java.io.*;

public class SerializationExample {
    public static void main(String[] args) {
        // Object to be serialized
        Person person = new Person("John Doe", 30);

        // Serialization
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("person.ser"))) {
            oos.writeObject(person);
            System.out.println("Serialization complete");
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Deserialization
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("person.ser"))) {
            Person deserializedPerson = (Person) ois.readObject();
            System.out.println("Deserialization complete");
            System.out.println("Deserialized Person: " + deserializedPerson);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

// Person class implements Serializable
class Person implements Serializable {
    private static final long serialVersionUID = 1L;

    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

```

### 13. Use stream api to get the average of the array [20, 3, 78, 9, 6, 53, 73, 99, 24, 32].
```
int[] nums = new int[]{20, 3, 78, 9, 6, 53, 73, 99, 24};
double avg = Arrays.stream(nums).average().orElse(0.0);
```