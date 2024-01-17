### 1. create a file to list all of the annotaitons you learned and known, and explain the usage and how do you understand it. you need to update it when you learn a new annotation. Please organize those annotations well, like annotations used by entity, annotations used by controller.

See in annotations.md

### 2. Explain how the below annotaitons specify the table in database?
```java
@Column(columnDefinition = "varchar(255) default 'John Snow'") 
private String name;
@Column(name="STUDENT_NAME", length=50, nullable=false, unique=false) 
private String studentName;
```

- `columnDefinition`  specifies the SQL fragment that is used when generating the DDL(Data Definition Language) for the column.
- In this case, it dsefines a VARCHAR column with a maximum length of 255 characters and a default value of 'John Snow'.
- `name`specifies the name of the column, `length` specifies the column length for string-based columns, `nullable` specifies whether the column can contain null values, `unique` specifies whether the values in the column must be unique.

### 3. What is the default column names of the table in database for @Column ?
```java
@Column

private String firstName;

@Column private String operatingSystem;
```

In JPA and Hibernate, when using `@column` without clarifying any attributes, the default column name in datebases will be derived from the name of the Java fields by following rules:

- Camel Case to Underscore: If the Java field name is in camelCase ( `firstName`), JPA will convert it to underscore-separated format (`first_name`) for the database column name.
- No Conversion: If the Java field name is already in underscore-separated format (`first_name`), JPA will use it as-is for the database column name.

In this case, the default name would be `first_name` and `operating_system`

### 4. What are the layers in springboot application? what is the role of each layer?
1. **Presentation Layer (Controller):**
    
    - **Role:** This layer is responsible for handling user input and presenting the output to the user. It receives requests from the client, processes them, and delegates business logic to the service layer. It also manages the flow of control, handling user interactions, and returning appropriate responses.
    - **Key Components:** Controllers (annotated with `@Controller` or `@RestController`), REST endpoints.
2. **Service Layer:**
    
    - **Role:** The service layer contains the business logic of the application. It encapsulates the application's functionality and performs operations requested by the controller. It acts as an intermediary between the controller and the data access layer, applying business rules and coordinating transactions.
    - **Key Components:** Service classes (annotated with `@Service`), business logic.
3. **Data Access Layer (Repository):**
    
    - **Role:** Responsible for interacting with the database or any other data store. It abstracts the underlying data source, providing a clean and consistent way to perform CRUD (Create, Read, Update, Delete) operations. It often uses ORM (Object-Relational Mapping) frameworks like Hibernate or Spring Data JPA.
    - **Key Components:** Repository interfaces (annotated with `@Repository`), JPA entities, DAOs (Data Access Objects).
4. **Domain (Model) Layer:**
    
    - **Role:** Represents the core domain model of the application. It contains entities that represent business objects and the relationships between them. These entities typically map to database tables and are used to encapsulate business logic and data validation.
    - **Key Components:** Entity classes, value objects.
5. **Presentation Model (DTO - Data Transfer Object):**
    
    - **Role:** Used to transfer data between layers and communicate with the client. DTOs are often used to shape the data sent to and received from the client, preventing over-fetching or under-fetching of data.
    - **Key Components:** DTO classes, often used in the presentation layer.
6. **Configuration Layer:**
    
    - **Role:** Handles the configuration of the application, such as setting up beans, configuring data sources, and defining various properties. It allows the application to be easily configured and adapted to different environments.
    - **Key Components:** Configuration classes (annotated with `@Configuration`), `application.properties` or `application.yml` files.
7. **Infrastructure Layer:**
    
    - **Role:** Contains components responsible for cross-cutting concerns such as security, logging, and caching. These are aspects that may affect multiple layers of the application.
    - **Key Components:** Security configurations, logging aspects, caching components.

### 5. Describe the flow in all of the layers if an API is called by Postman.

1. **Presentation Layer (Controller):**
    
    - Postman sends an HTTP request to the specified endpoint.
    - The request is received by a Controller, which is responsible for handling HTTP requests and managing the flow of control.
2. **Controller:**
    
    - The Controller processes the incoming request, extracting any parameters, headers, or request body as necessary.
    - It invokes the appropriate method to handle the request based on the mapping defined in the `@RequestMapping` or similar annotations.
3. **Service Layer:**
    
    - The Controller delegates the business logic to the Service layer by calling a method in the corresponding Service class.
    - The Service class contains the application's business logic, which may involve processing data, applying business rules, and coordinating with the Data Access layer.
4. **Data Access Layer (Repository):**
    
    - The Service class interacts with the Data Access layer to perform CRUD operations on the database.
    - The Data Access layer uses a Repository interface, which may be implemented using Spring Data JPA or other ORM frameworks.
5. **Domain (Model) Layer:**
    
    - The entities in the Domain layer represent the core business objects and are used to encapsulate business logic and data validation.
    - The Service class may work with these entities to perform business operations.
6. **Presentation Model (DTO):**
    
    - The Service class may use Data Transfer Objects (DTOs) to transfer data between layers. This helps in shaping the data sent to and received from the client.
7. **Controller (Response):**
    
    - The Controller receives the processed data or response from the Service layer.
    - It prepares the HTTP response, which may include the response body, status codes, and headers.
8. **Infrastructure Layer:**
    
    - Cross-cutting concerns such as security, logging, and caching, managed by the Infrastructure layer, may be applied during the processing of the request and response.
9. **HTTP Response:**
    
    - The prepared HTTP response is sent back to Postman, containing the requested data or any relevant information.
    - Postman displays the response, allowing the developer to inspect the result of the API call.


6. What is the application.properties? do you know application.yml?
**`application.properties`:**

- This is a widely used configuration file where configuration properties are defined using a key-value pair format.
- Example:
```java
# Database Configuration
spring.datasource.url=jdbc:mysql://localhost:3306/mydatabase
spring.datasource.username=root
spring.datasource.password=secret

# Server Configuration
server.port=8080

```

`application.yml` is an alternative configuration file format that uses YAML (YAML Ain't Markup Language) syntax, which is more human-readable and supports a hierarchical structure.

```java
# Database Configuration
spring:
  datasource:
    url: jdbc:mysql://localhost:3306/mydatabase
    username: root
    password: secret

# Server Configuration
server:
  port: 8080

```