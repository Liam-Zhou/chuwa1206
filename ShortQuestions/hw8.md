# HW8

## 1. How Do You Do the Debug?

1. **Setting Breakpoints**: A breakpoint is a marker that you set on a line of code. When the program runs in debug mode, it will stop at these breakpoints, allowing you to inspect the state of the program at that point.
2. **Starting Debug Mode**: Run your program in debug mode. This allows the IDE to pause execution at the breakpoints and lets you step through the code.
3. **Inspecting Variables**: When the program is paused, you can inspect the values of different variables in the current scope. This helps in understanding if the variables are holding the expected values.
4. **Stepping Through Code**: Use the stepping controls (like step over, step into, step out) to execute your code line by line. This helps in identifying exactly where and why the code is not behaving as expected.

## 2. What is DTO, VO, Payload, DO, Model?

1. **DTO (Data Transfer Object)**: This is a pattern used to transfer data between software application subsystems. DTOs are often used to encapsulate data and are frequently used in the context of network communication.
2. **VO (Value Object)**: In domain-driven design, a Value Object is an object that represents a descriptive aspect of the domain with no conceptual identity. They are immutable and used to describe aspects of a domain entity.
3. **Payload**: Refers to the actual data being transported, like in a data packet over the network, the body of an HTTP request, or the data part of an API response.
4. **DO (Domain Object)**: Part of the domain model in domain-driven design, encapsulating business logic and data associated with business entities.
5. **Model**: In architectures like MVC, the term "model" represents the part of the application that manages the data, logic, and rules of the application.

## 3. What is @JsonProperty("description_yyds")?

**`@JsonProperty("description_yyds")`** is an annotation used in Java with the Jackson library to specify the name of a property in JSON when serializing and deserializing Java objects. It helps in mapping JSON to Java fields correctly.

## 4. Do You Know What is Jackson?

Jackson is a popular Java library for processing JSON. It provides functionality for reading and writing JSON, either to and from POJOs or to a JSON Tree Model, as well as performing conversions. It's customizable to work with different styles of JSON content and advanced Object concepts.

## 5. What is Spring-Boot-Starter?

**`spring-boot-starter`** is a set of convenient dependency descriptors for Spring Boot applications. Each starter is a collection of dependencies for a specific type of application or functionality, simplifying Maven or Gradle configuration.

## 6. Do You Know @RequestMapping(value = "/users", method = RequestMethod.POST)? Could You List CRUD by This Style?

**`@RequestMapping`** is used in Spring Framework to map web requests to handler methods. The `value` attribute specifies the URL pattern, and the `method` attribute defines the HTTP method.

1. **Create (POST)**: `@RequestMapping(value = "/users", method = RequestMethod.POST)`
2. **Read (GET)**: `@RequestMapping(value = "/users/{id}", method = RequestMethod.GET)`
3. **Update (PUT)**: `@RequestMapping(value = "/users/{id}", method = RequestMethod.PUT)`
4. **Delete (DELETE)**: `@RequestMapping(value = "/users/{id}", method = RequestMethod.DELETE)`

## 7. What is ResponseEntity? Why Do We Need It?

**`ResponseEntity`** in Spring Framework is used to represent an HTTP response, including headers, body, and status. It allows for full configuration of the HTTP response in handler methods.

## 8. What is ResultSet in JDBC? Describe the Flow How to Get Data Using JDBC

**`ResultSet`** in JDBC is an object representing the data returned by a database query. The process involves loading the JDBC driver, establishing a connection, creating a statement, executing the query, processing the ResultSet, and closing resources.

## 9. What is the ORM Framework?

An ORM (Object-Relational Mapping) framework facilitates the conversion of data between incompatible type systems in object-oriented programming and relational databases. It creates a "virtual object database" for use within the programming language.

## 10. What is the serialization and desrialization?

**Serialization** is the process of converting an object into a format that can be easily stored or transmitted (like converting a Java object to JSON or XML). 

**Deserialization** is the opposite process, where you convert the serialized data back into an object (like converting JSON or XML back to a Java object). These processes are essential for saving objects to files, sending objects over a network, or storing objects in a database.

## 11. Use stream api to get the average of the array [20, 3, 78, 9, 6, 53, 73, 99, 24, 32].

```java
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] numbers = {20, 3, 78, 9, 6, 53, 73, 99, 24, 32};
        double average = Arrays.stream(numbers).average().orElse(Double.NaN);

        System.out.println("The average is: " + average);
    }
}
```

