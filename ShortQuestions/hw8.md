# 2. how do you do the debug?

Separation of concerns and write unit tests for each module, isolate the problem then inspect the vairables in the problem module.

# 3. What is DTO, VO, Payload, DO, model?

DTO (Data Transfer Object): Represents data that needs to be transferred between subsystems.
VO (Value Object): Represents an object with attributes but no distinct identity.
Payload: General term for data transmitted over a network.
DO (Domain Object): Represents real-world entities in the application domain.
Model: Generic term for objects representing data, often used interchangeably with DTO.

# 4. What is @JsonProperty("description_yyds")?

It's a Jackson annotation specifying the JSON property name for serialization and deserialization

# 5. do you know what is jackson?

```
<dependency>
      <groupId>com.fasterxml.jackson.core</groupId>
      <artifactId>jackson-databind</artifactId>
      <version>2.13.3</version>
      <scope>compile</scope>
</dependency>

```

Jackson is a JSON processing library for Java. The provided Maven dependency includes Jackson's jackson-databind module for data-binding.

# 6. What is spring-boot-stater?

what dependencies are in the below starter? do you know any starters?

```
<dependency>
   <groupId>org.springframework.boot</groupId>
   <artifactId>spring-boot-starter-web</artifactId>
</dependency>
```

It's a convenient way to add common dependencies to a project. The mentioned starter (spring-boot-starter-web) includes dependencies for building web applications. Other starters exist for different purposes

# 7. do you know @RequestMapping(value = "/users", method = RequestMethod.POST) ? could you list CRUD by this style?

Create (POST): @RequestMapping(value = "/users", method = RequestMethod.POST)
Read (GET): @RequestMapping(value = "/users/{id}", method = RequestMethod.GET)
Update (PUT): @RequestMapping(value = "/users/{id}", method = RequestMethod.PUT)
Delete (DELETE): @RequestMapping(value = "/users/{id}", method = RequestMethod.DELETE)

# 8. What is ResponseEntity? why do we need it?

```
new ResponseEntity<>(postResponse, HttpStatus.OK);
new ResponseEntity<>(postResponse, HttpStatus.CREATED);
ResponseEntity.ok(postService.getPostById(id));
```

ResponseEntity represents the entire HTTP response. It's used to customize the response, status, and headers. Examples:

new ResponseEntity<>(postResponse, HttpStatus.OK)
new ResponseEntity<>(postResponse, HttpStatus.CREATED)
ResponseEntity.ok(postService.getPostById(id))

# 9. What is ResultSet in jdbc? and describe the flow how to get data using JDBC

ResultSet is a table of data representing a database result set. To get data:

Step 1: Execute a query using Statement or PreparedStatement.
Step 2: Access the result set using ResultSet.
Step 3: Iterate through rows and retrieve data using methods like getInt(), getString().

# 10. what is the ORM framework?

ORM (Object-Relational Mapping) frameworks facilitate interaction between a database and an object-oriented programming language, mapping database entities to objects in the language.

# 12. What is serialization and deserialization?

- **Serialization:** Converting an object into a format (like JSON or XML) suitable for transmission.
- **Deserialization:** Recreating an object from a serialized format. It involves interpreting transmitted data back into an object.

# 13. Use stream api to get the average of the array [20, 3, 78, 9, 6, 53, 73, 99, 24, 32]

```
import java.util.Arrays;

public class StreamAverageExample {
    public static void main(String[] args) {
        int[] numbers = {20, 3, 78, 9, 6, 53, 73, 99, 24, 32};

        double average = Arrays.stream(numbers)
                .average()
                .orElse(0.0);

        System.out.println("Average: " + average);
    }
}

```
