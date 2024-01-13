### Question 1:
@QueryMapping
@MutationMapping
These are for graphql

### Question 2:
Identify the problem by understanding the symptoms and the conditions under which they occur. And check the source code and logs for clues.

### Question 3:
DTO : An object used to encapsulate data, and send it from one subsystem of an application to another.
VO : An object that represents a descriptive aspect of the domain with no conceptual identity.
Payload: In the context of API, it's the actual data sent in a request or response.
DO: Often refers to an object representing a database entity.
Model: In many MVC frameworks, the model represents the data structure, business logic, and functions to manage data.


### Question 4:
@JsonProperty is used to specify the property name in JSON data. For example, @JsonProperty("description_yyds") maps the JSON property description_yyds to the annotated Java field or method.

### Question 5:
Jackson is a popular Java library used for serializing Java objects to JSON and deserializing JSON strings to Java objects. It's widely used for working with RESTful web services in Java.

### Question 6:
Spring Boot Starters are a set of convenient dependency descriptors that you can include in your application. They provide a quick way to pull in all the dependencies required for a specific type of application or functionality. Each starter is designed to simplify the Maven or Gradle configuration.

### Question 7:
@RequestMapping annotation in Spring MVC is used to map web requests to Spring Controller methods. It can specify the URL path, HTTP method, and other request parameters.

### Question 8:
ResponseEntity is a class in Spring Framework, commonly used in the development of RESTful web services with Spring MVC. It represents the entire HTTP response, including the status code, headers, and body. 

### Question 9:
ResultSet in JDBC  is a fundamental interface that represents a table of data returned by an SQL query. It essentially acts as a cursor or pointer that allows you to iterate through the results of a query row by row.

### Question 10:
An ORM framework is a programming technique used to facilitate the conversion of data between incompatible type systems in object-oriented programming languages.

### Question 12:
Serialization and deserialization are processes used in computer science and data communication to convert complex data structures, objects, or data from one format or representation into another, typically for the purpose of storage, transmission, or interchange between different systems or platforms.

### Question 13:
double average = Arrays.stream(numbers)
                .average()
                .orElse(0.0);
