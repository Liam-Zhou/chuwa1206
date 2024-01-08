### In-class API Test
![API](hw7Screenshot/1.png)
![Test](hw7Screenshot/2.png)
### Postman Practice
[Postman Practice.md](Postman%20Practice.md)

### Annotations
[Annotation.md](Annotations.md)

#### 2. Explain how the below annotaitons specify the table in database?
```java
@Column(columnDefinition = "varchar(255) default 'John Snow'")
private String name;
```
- This annotation specifies that the corresponding column in the database table will be defined as a VARCHAR data type with a maximum length of 255 characters.  
- The default 'John Snow' part of the column definition attribute means that if an insert operation is performed without a value for this column, the default value of 'John Snow' will be used.  
- There's no explicit column name provided here, so the column name will default to the name of the property, which is **name** in this case.
```java
@Column(name="STUDENT_NAME", length=50, nullable=false, unique=false)
private String studentName;
```
- This annotation specifies that the corresponding column in the database table should be named STUDENT_NAME.  
- The length=50 attribute sets the maximum length of the column to 50 characters.  
- nullable=false indicates that this column cannot be null, meaning that every record must have a value for this column.  
- unique=false means that duplicate values are allowed in this column, so the same value for studentName can appear in multiple rows.

#### 3. What is the default column names of the table in database for @Column ?
```java
@Column
private String firstName;
@Column
private String operatingSystem;
```
Since there's no explicit column name provided here, so the column names will default to the names of the properties, which are **firstName** and **operatingSystem**.

#### 4. What are the layers in springboot application? what is the role of each layer?
- Controller Layer
  - Role: Acts as the API layer that handles incoming HTTP requests (GET, POST, PUT, DELETE) from clients like Postman. The controller directs these requests to the appropriate service methods.
  - Components: Classes annotated with @RestController that define methods for end-points.

- Service Layer 
  - Role: Contains the business logic of the application. It processes the data received from the controller, performs the necessary business operations, and may interact with the DAO layer to persist data.
  - Components: Classes typically annotated with @Service that encapsulate the business logic.

- DAO (Data Access Object) Layer 
  - Role: Manages the persistence logic. This layer is responsible for interacting with the database to perform CRUD operations. It abstracts and encapsulates all access to the data source. 
  - Components: Interfaces or classes annotated with @Repository that use Spring Data JPA or other data access technologies like JDBC, JPA, Hibernate to interact with the database.

- Database (DB)
  - Role: The database is where the application's data is stored and retrieved. It is not a layer within the application code itself but a service that the application depends on.
  - Components: Typically consists of a relational database management system (RDBMS) like MySQL, PostgreSQL, Oracle, etc.

#### 5. Describe the flow in all of the layers if an API is called by Postman.
When an API is called by Postman, the flow through a Spring Boot application's layers is as follows:

1. **Postman Client**: Sends an HTTP request to the Spring Boot application.

2. **Controller Layer**: Receives the request and uses `@RestController` and `@RequestMapping` to direct it to the appropriate controller method.

3. **Service Layer**: The controller delegates the request to the service layer, marked with `@Service`, which contains the business logic and may validate or process the data.

4. **DAO Layer**: The service layer interacts with the DAO layer (`@Repository`) to perform database operations.

5. **Database**: The DAO layer communicates with the database using JDBC to execute queries and return results.

6. **DAO Layer**: Retrieves the operation results from the database.

7. **Service Layer**: Processes the data from the DAO layer and prepares it for the response.

8. **Controller Layer**: Sends the processed data back to the client in the HTTP response.

9. **Postman Client**: Receives the response from the server.

#### 6. What is the application.properties? Do you know application.yml?
The application.properties is a properties file that uses a simple key-value format for configuration. It allows you to configure the behavior of your application, such as server port, context paths, database URLs, custom configurations etc.
It supports Spring Boot's profile feature, where you can define properties for specific profiles. Spring Boot automatically loads the properties defined in application.properties at startup and makes them available throughout the application via environment abstraction or @Value annotations.

### MongoBlog
[mongo-blog](../Repo/mongo-blog)
![Test](hw7Screenshot/3.png)
