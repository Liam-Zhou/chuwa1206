# hw7: hw40-springboot-post

### Question 1
#### Question: Create a file to list all of the annotations you learned and known and explain the usage and how do you understand it. You need to update it when you learn a new annotation. Please organize those annotations well like annotations used by entity, annotations used by controller.

[annotations.md](https://github.com/Liam-Zhou/chuwa1206/blob/diana_men/hw7/ShortQuestions/annotations.md)

### Question 2
#### Question: Explain how the below annotations specify the table in database?
1. `@Column(columnDefinition = "varchar(255) default 'John Snow'") private String name;`
2. `@Column(name="STUDENT_NAME", length=50, nullable=false, unique=false) private String studentName;`

1. The `@Column` annotation on `name` field specifies the column definition in the database. It declares the column type as varchar(255) and sets the default value to 'John Snow'.
2. The `@Column` annotation on `studentName` field specifies the column in the database with the name 'STUDENT_NAME', a maximum length of 50 characters, it's not nullable, and it's not unique.

### Question 3
#### Question: What is the default column names of the table in database for `@Column`?
1. `@Column private String firstName;`
2. `@Column private String operatingSystem;`

The default column names for the fields annotated with `@Column` in the database are the same as the variable names in the Java class. Hence, the default column names would be 'firstName' and 'operatingSystem', respectively.

### Question 4
#### Question: What are the layers in a Spring Boot application? What is the role of each layer?

A typical Spring Boot application has the following layers:
- **Controller Layer**: Handles HTTP requests, translates them into actions, and returns the response.
- **Service Layer**: Contains the business logic and calls methods in the repository layer.
- **Repository Layer (DAO)**: Deals with data access and communicates with the database.
- **Model Layer (Entity)**: Represents the data structure, often in the form of entities.

### Question 5
#### Question: Describe the flow in all of the layers if an API is called by Postman.

When an API is called by Postman, the flow is as follows:
1. **Controller Layer**: Postman sends an HTTP request which is received by a Controller. The Controller processes the request and calls the appropriate service method.
2. **Service Layer**: The service layer takes the request, processes the business logic, and calls the repository layer to interact with the database if needed.
3. **Repository Layer**: The repository layer interacts with the database to fetch or persist data.
4. **Model Layer**: The data is structured as per the model definitions.
5. The response is sent back through the layers to the Controller, which then sends it back to Postman.

### Question 6
#### Question: What is the `application.properties`? Do you know `application.yml`?

`application.properties` is a configuration file for a Spring Boot application where we can define application-wide properties like database connection details, server port, etc. `application.yml` is an alternative to `application.properties` that offers the same configurations but in a YAML format, which can be more readable and supports hierarchical data representation.

### Question 7
#### Question:
Create a Project named it with mongo-blog write a POST API for mongo-blog change database to MongoDB.

[mongo-blog link](https://github.com/Liam-Zhou/chuwa1206/tree/diana_men/hw7/CodingQuestions/hw7/mongo-blog)

