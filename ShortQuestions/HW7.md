# HW7

2. explain how the below annotaitons specify the table in database?

@Column(columnDefinition = "varchar(255) default 'John Snow'")

private String name;

@Column(name="STUDENT_NAME", length=50, nullable=false, unique=false)
private String studentName;

name's type is varchar and maximum length is 255, default value is John Snow

studentName's name is STUDENT_NAME, length = 50 specifies the maximum length of the column.



3. What is the default column names of the table in database for  @Column ?

@Column

private String firstName;
@Column
private String operatingSystem;

first_name and operating_system



4. What are the layers in springboot application? what is the role of each layer?

   **Presentation Layer (Controller or Web Layer):**

   - **Role:** Handles incoming HTTP requests, processes them, and returns an appropriate response. 

     

   **Service Layer:**

   - **Role:** Contains the business logic of the application. Service layer components are responsible for processing and coordinating application-specific logic, often acting as a bridge between controllers and repositories.

   

   **Repository Layer (Data Access Layer):**

   - **Role:** Handles database interactions, including CRUD operations. 

   **Entity Layer (Domain Model):**

   - **Role:** Represents the core data entities of the application. These entities typically map directly to database tables. Entities define the structure of the data and are often annotated with JPA annotations for ORM.

   **DTO (Data Transfer Object) Layer:**

   - **Role:** Contains data transfer objects used for communication between different layers. DTOs are used to transfer data between the presentation layer and service layer

5. Describe the flow in all of the layers if an API is called by Postman.

   **Client (Postman):**

   - Initiates an HTTP request (e.g., GET, POST) to a specific endpoint of the Spring Boot application.
     

   **Presentation Layer (Controller):**

   - The request is first received by the controller, which is responsible for handling HTTP requests and managing the flow of data.

   - The controller method is invoked, and it may extract information from the request, such as path variables, request parameters, or request body.

   - ```java
     @RestController
     @RequestMapping("/api/users")
     public class UserController {
         @PostMapping
         public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto) {
             // controller method logic
         }
     }
     ```

     

   **DTO Layer:**

   - The controller interacts with Data Transfer Objects (DTOs) to represent the data being transferred between layers.

   - The request body might be mapped to a DTO to abstract away unnecessary details from the service layer.

     

   **Service Layer:**

   - The controller delegates the processing of the request to the service layer, which contains business logic.
   - The service layer may perform operations like validation, transformation, and orchestration of business rules.

   **Repository Layer (Data Access):**

   - The service layer may interact with the repository layer to perform CRUD operations on the database.
   - Data entities may be retrieved or persisted to the database using JPA repositories.

   

   **Entity Layer (Domain Model):**

   - The entity layer represents the core data entities.
   - Entities may be persisted or retrieved from the database by the repository layer.

   **Response Flow:**

   - The service layer returns the processed data (e.g., a UserDto) to the controller.
   - The controller then constructs an HTTP response and sends it back to the client (Postman).

6. What is the application.properties? do you know application.yml?

   ### `application.properties`:

   ```
   # Database Configuration
   spring.datasource.url=jdbc:mysql://localhost:3306/mydb
   spring.datasource.username=root
   spring.datasource.password=secret
   
   # Server Configuration
   server.port=8080
   
   # Logging Configuration
   logging.level.root=INFO
   
   ```

   ### `application.yml`:

   ```
   # Database Configuration
   spring:
     datasource:
       url: jdbc:mysql://localhost:3306/mydb
       username: root
       password: secret
   
   # Server Configuration
   server:
     port: 8080
   
   # Logging Configuration
   logging:
     level:
       root: INFO
   
   ```

   - **`.properties`:**
     - Simple key-value pairs.
     - Concise and often used when the configuration is straightforward.
   - **`.yml` or `.yaml`:**
     - Hierarchical and more readable structure.
     - Preferred when dealing with complex configurations or nested properties.

7. Create a Project, name it with mongo-blog, write a POST API for mongo-blog, change database to MongoDB;