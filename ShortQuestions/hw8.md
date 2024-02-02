### RUD

1. annotations
2. I first check the logs so that I can quickly locate the module that went wrong. After I located the range of code that reports an error, I do the debug mode and run line by line.
3. An object used to encapsulate data and send it from one system or layer to another within an application. Its primary purpose is to transfer data between parts of a system or across networks, minimizing the number of method calls.
4. `@JsonProperty("description_yyds")` is an annotation used in Java, particularly with the Jackson library, which is a popular library for processing JSON data. This annotation specifies the name of the JSON property that should be mapped to the Java field or method it annotates. When deserializing JSON to Java objects (reading JSON into Java), it tells Jackson to bind the JSON property named `description_yyds` to the annotated Java field or method. Conversely, when serializing Java objects to JSON (writing Java to JSON), it instructs Jackson to use `description_yyds` as the key name for the JSON element corresponding to the annotated Java field or method. This is useful for ensuring consistency between the Java model and the JSON structure, especially when they do not follow the same naming conventions.
5. Jackson is a popular, high-performance Java library used for processing JSON data format. It provides functionality for reading and writing JSON, either to and from basic POJOs (Plain Old Java Objects), or to and from a general-purpose JSON Tree Model (`JsonNode`), as well as related functionality for performing conversions. It is widely used for serializing Java objects into JSON format and deserializing JSON strings into Java objects. Jackson offers a rich set of features including streaming API, data binding, and tree model, making it versatile for various JSON processing tasks.
6. Spring Boot Starter" is a pre-configured and reusable set of dependencies that simplify the setup and configuration of specific features or functionality in a Spring Boot application. These starters are designed to streamline the development process by providing a curated collection of libraries, settings, and templates related to a particular use case.
7. 
   1. Create (POST):
      1. `@RequestMapping(value = "/users", method = RequestMethod.POST)`
      2. Purpose: This maps a POST request to the "/users" URL to create a new user.
   2. Read (GET):
      1. `@RequestMapping(value = "/users/{id}", method = RequestMethod.GET)`
      2. Purpose: This maps a GET request to "/users/{id}" to retrieve user details by their ID.
   3. Update (PUT):
      1. `@RequestMapping(value = "/users/{id}", method = RequestMethod.PUT)`
      2. Purpose: This maps a PUT request to "/users/{id}" to update an existing user's information.
   4. Delete (DELETE):
      1. `@RequestMapping(value = "/users/{id}", method = RequestMethod.DELETE)`
      2. Purpose: This maps a DELETE request to "/users/{id}" to delete a user by their ID.

8. We need `ResponseEntity` because it allows us to have more control and flexibility over the HTTP response sent to the client. 

   It contains: 

   1. HTTP Status Codes: `ResponseEntity` allows us to set specific HTTP status codes (e.g., 200 OK, 404 Not Found) to indicate the outcome of the request accurately.
   2. Response Body: It can include the response data as well as the data type, which is especially helpful when returning different types of data (e.g., JSON, XML).
   3. Headers: `ResponseEntity` allows us to add custom headers to the HTTP response, providing additional information to the client or enabling cross-origin resource sharing (CORS).
   4. Flexibility: It gives developers fine-grained control over the response, allowing them to handle various scenarios, such as error responses, redirects, or custom content negotiation.

9. In JDBC (Java Database Connectivity), a `ResultSet` is an object that represents the result set of a database query. It provides methods to iterate through the rows of the query result and retrieve data from the database.

10. An ORM (Object-Relational Mapping) framework is a computer science tool that facilitates the interaction between a relational database and object-oriented programming languages. It maps database tables and their relationships to corresponding objects and classes in the programming language, allowing developers to work with databases using object-oriented principles. ORM frameworks help abstract away the complexities of SQL queries, making it easier to perform database operations using code and objects rather than raw SQL statements. Popular ORM frameworks include Hibernate (for Java) and Entity Framework (for .NET).

11. code.

12. erialization is the process of converting an object's state into a byte stream, typically for the purpose of storing or transmitting it. It allows objects to be saved to files, sent over networks, or stored in databases in a format that can later be reconstructed into an object.

    Deserialization, on the other hand, is the reverse process of taking a byte stream and reconstructing the original object's state from it. It is used to retrieve and use objects that were previously serialized.

    Serialization and deserialization are commonly used in computer science for data persistence, caching, and communication between distributed systems, allowing objects to be easily moved and used across different environments and platforms.

13. ```java
    import java.util.Arrays;
    
    public class ArrayAverage {
        public static void main(String[] args) {
            int[] numbers = {20, 3, 78, 9, 6, 53, 73, 99, 24, 32};
    
            double average = Arrays.stream(numbers)
                    .average()
                    .orElse(0.0); // Default value if the array is empty
    
            System.out.println("Average: " + average);
        }
    }
    ```

14. copy code.

15. copy code.

16. code.



### post

1. code.
2. code.
3. code.