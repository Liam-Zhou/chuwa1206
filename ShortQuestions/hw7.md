## HW7
# Q1. create a file to list all of the annotaitons you learned and known, and explain the usage and how do you understand it. 

# Q2. Explain how the below annotaitons specify the table in database?
```

@Column(columnDefinition = "varchar(255) default 'John Snow'")
private String name;
  
@Column(name="STUDENT_NAME", length=50, nullable=false, unique=false)
private String studentName;
```
1. `@Column(columnDefinition = "varchar(255) default 'John Snow'")`: The column data type in the database is varchar with a maximum length of 255 characters.
The default value for the column is 'John Snow'. If a new record is inserted into the database without a specific value for name, it will default to 'John Snow'.

2. `@Column(name="STUDENT_NAME", length=50, nullable=false, unique=false)`: 
- name="STUDENT_NAME": Specifies the name of the column in the database as STUDENT_NAME. If not specified, the default column name would be the same as the field name (studentName in this case).
- length=50: Defines the maximum length of the column as 50 characters. This is typically used with string-based columns (varchar in SQL).
- nullable=false: Indicates that the column cannot contain NULL values, making it a required field in the database.
- unique=false: Specifies that the column values do not need to be unique across rows. This means that duplicate values for studentName are allowed in different rows of the table.

# Q3. What is the default column names of the table in database for `@Column`
```
@Column
private String firstName;
@Column
private String operatingSystem;
``` 
The default column name in the database is derived from the field or property name in your Java entity, so firstName -> first_name, operatingSystem -> operating_system

# Q4. What are the layers in springboot application? what is the role of each layer?
- Presentation layer: Handles HTTP requests and responses, translating user inputs into actions to be performed by the application.
- Service layer: Contains business logic and service classes that encapsulate the application's business rules and operations.
- Repository Layer: Responsible for data access and manipulation, abstracting the interaction with the database or other data sources.
- Model Layer: Represents the business data and defines the business entities and relationships.

# Q5. Describe the flow in all of the layers if an API is called by Postman.
1. A controller in the presentation layer mapped to the requested endpoint receives the HTTP request. The controller parses the request, validates the input (if necessary), and then passes the data (often transformed into a DTO - Data Transfer Object) to the appropriate service in the Service Layer.
2. The service layer handles business-specific operations, such as calculations, data transformations, and decision-making. For data persistence or retrieval, the service layer interacts with the Repository Layer, passing down any entities or data needed for database operations.
3. The repository layer interacts with the database or external services to fetch, update, delete, or save data. This is typically achieved through repository interfaces provided by Spring Data JPA or custom DAOs (Data Access Objects).
4.  Throughout this process, the data is represented using entities or domain models that mirror the database structure and relationships. These entities are used by the Repository Layer to interact with the database and by the Service Layer to apply business logic.

# Q6. What is the application.properties? Do you know application.yml?
`application.properties` and `application.yml` are configuration files used in Spring Boot applications to externalize configuration settings. These files allow developers to manage application, server, and environment-specific configurations separately from the code, making the application more flexible and easier to manage across different environments (development, testing, production, etc.).


# Q7. Create a Project, name it with mongo-blog, write a POST API for mongo-blog, change database to MongoDB;