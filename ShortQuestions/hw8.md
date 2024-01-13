#### 1. In your redbook application, write the code for RUD APIs.
[Redbook Code](../Repo/redbook)
#### Screenshots
`getAllPosts`
![Screenshot1](./hw8Screenshots/1.png)
`getPostById`
![!Screenshot2](./hw8Screenshots/2.png)
![!Screenshot3](./hw8Screenshots/3.png)
`updatePostById`
![!Screenshot4](./hw8Screenshots/4.png)
`deletePostById`
![!Screenshot5](./hw8Screenshots/5.png)

#### 2.GraphQL implementation
![!Screenshot6](./hw8Screenshots/6.png)

#### 3.Author CRUD and GraphQL
`createAuthor`
![!Screenshot7](./hw8Screenshots/7.png)
`getAllAuthors`
![!Screenshot8](./hw8Screenshots/8.png)
`getAuthorById`
![!Screenshot9](./hw8Screenshots/9.png)

`updateAuthorById`
![!Screenshot10](./hw8Screenshots/10.png)
`deleteAuthorById`
![!Screenshot11](./hw8Screenshots/18.png)
`GraphQL Test`
![!Screenshot12](./hw8Screenshots/11.png)
![!Screenshot13](./hw8Screenshots/12.png)
![!Screenshot14](./hw8Screenshots/13.png)
![!Screenshot15](./hw8Screenshots/14.png)
![!Screenshot16](./hw8Screenshots/15.png)
![!Screenshot17](./hw8Screenshots/16.png)
![!Screenshot18](./hw8Screenshots/17.png)

#### 4.List all of the new annotations to your annotaitons.md and explain its role.
[Annotations](./Annotations.md)

#### 5.How do you do the debug?
##### 1. Run in Debug Mode
- Click the debug icon (bug symbol).
##### 2. Interact with Your Application
- Trigger the code where breakpoints are set by interacting with your application.
##### 3. Inspect and Debug
- When execution hits a breakpoint, IDEA pauses.
- Inspect variables, evaluate expressions, and navigate code.
##### 4. Modify Code on the Fly
- IntelliJ IDEA supports hot-swapping in many cases.
##### 5. Resume Execution
- Click **Resume Program** to continue execution.
##### 6. View Logs and Console Output
- Monitor the IntelliJ IDEA console for logs and output.
##### 7. Stop Debugging
- Click the Stop button to end the debugging session.

#### 6.What is DTO, VO, Payload, DO, model?
##### DTO (Data Transfer Object)
- **Purpose**: Transfer data between software application subsystems/layers.
- **Characteristics**: Encapsulates data, can contain serialized data for network/process/layers transfer.
- **Usage in Spring Boot**: Transfer data between the controller and service layers, decouple internal data representation from client-facing data.

##### VO (Value Object)
- **Purpose**: Represents an object by its values.
- **Characteristics**: Immutable, defined by attributes, two VOs are equal if all properties are equal.
- **Usage in Spring Boot**: Used in the domain layer to represent complex values, treated as a single unit.

##### Payload
- **Purpose**: The actual intended message in transmitted data.
- **Characteristics**: In REST APIs, it's the body of requests and responses (actual data sent/received).
- **Usage in Spring Boot**: Data sent via REST endpoints, like JSON in POST/PUT requests.

##### DO (Domain Object)
- **Purpose**: Represents a domain entity in the business domain.
- **Characteristics**: Direct mapping to database tables, reflect business domain and rules.
- **Usage in Spring Boot**: Often ORM entities (JPA entities), interact directly with the database, usually annotated with `@Entity`.
#### 7.What is @JsonProperty("description_yyds")?
- `@JsonProperty` is an annotation from the Jackson library, commonly used in Java applications for JSON serialization and deserialization.
- When you annotate a Java field with `@JsonProperty("description_yyds")`, it indicates that this field will be mapped to a JSON property named `description_yyds`.
#### 8.Do you know what is jackson?
Jackson is a high-performance JSON processor for Java. It provides the ability to read, write, and manipulate JSON data.
#### 9.What is spring-boot-stater? What dependecies in the below starter? Do you know any starters?
Spring-boot-stater includes a set of dependencies that are commonly used together for a specific type of application.
##### Common Spring Boot Starters
- `spring-boot-starter-web`
    - For building web applications, including RESTful applications using Spring MVC.
    - Dependencies typically include Spring MVC, Tomcat (or another embedded servlet container), Jackson, and others related to web development.

- `spring-boot-starter-data-jpa`
    - For using Spring Data JPA with Hibernate.
    - Includes dependencies such as Spring Data JPA, Hibernate, and a suitable database driver.

- `spring-boot-starter-security`
    - For adding Spring Security to an application.
    - Comes with dependencies needed for securing web applications.

- `spring-boot-starter-test`
    - For testing Spring Boot applications with libraries like JUnit, Hamcrest, Mockito.
    - Includes testing utilities and frameworks for unit and integration tests.
#### 10.Do you know @RequestMapping(value = "/users", method = RequestMethod.POST) ? Could you list CRUD by this style?
`value = "/users"` is used to declare the URL path that the controller method will handle, and method = RequestMethod.POST indicates that the method should handle POST requests.
For example:
```java
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    // Create
    @RequestMapping(value = "/users", method = RequestMethod.POST)
    public String createUser() {
        return "User created";
    }

    // Read
    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public String getAllUsers() {
        return "List of users";
    }

    // Read a single user by ID
    @RequestMapping(value = "/users/{id}", method = RequestMethod.GET)
    public String getUserById() {
        return "User details";
    }

    // Update
    @RequestMapping(value = "/users/{id}", method = RequestMethod.PUT)
    public String updateUser() {
        return "User updated";
    }

    // Delete
    @RequestMapping(value = "/users/{id}", method = RequestMethod.DELETE)
    public String deleteUser() {
        return "User deleted";
    }
}

}
```
#### 11.What is ResponseEntity? Why do we need it?
- `ResponseEntity` is a class in the Spring Web framework which represents the whole HTTP response – status code, headers, and body.
-  It is useful for REST APIs where you need to communicate more than just data – like success or error status.
#### 12.What is ResultSet in jdbc? And describe the flow how to get data using JDBC.
`ResultSet` is an interface in the JDBC API that represents the result set of a database query. It is used to store and manipulate the results returned by `SELECT` queries in SQL.
The flow will be `Establish a Database Connection` -> `Create a Statement` -> `Execute a Query` -> `Get the ResultSet`.
#### 13.What is the ORM framework?
Object-Relational Mapping is a programming technique used to convert data between incompatible type systems in object-oriented programming languages and relational databases. It bridges the gap between the object-oriented model and the relational database model, makes it easier for developers to work with databases by using their native programming language constructs instead of SQL.
#### 14.Use stream api to get the average of the array [20, 3, 78, 9, 6, 53, 73, 99, 24, 32].
```java
array.stream().mapToInt(Integer::intValue).average().orElse(0.0);
```
#### 15+16.抄写代码
[Pageable branch](https://github.com/1109122780/chuwa-redbook/tree/pageable)
[Comment branch](https://github.com/1109122780/chuwa-redbook/tree/comment)

#### 17.Cassandra-Blog
[Cassandra-Blog](../Repo/cassandra-blog)