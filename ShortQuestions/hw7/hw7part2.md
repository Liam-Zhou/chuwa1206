### Question 2
@Column: This is the main annotation used to specify the details of the column to which a field will be mapped in the database.
columnDefinition = "varchar(255) default 'John Snow'"): This part of the annotation is used to provide a SQL fragment that defines the column.
name="STUDENT_NAME": This sets the name of the column in the database table to STUDENT_NAME. If not specified, JPA would use the field name (studentName) 
length=50: This specifies that the maximum length of the column is 50 characters.
nullable=false: This indicates that the column cannot have NULL values. It is a required field in the database.
unique=false: This specifies that the column does not need to have unique values across different rows in the table.

### Question 3
private String firstName;
The default column name in the database will be firstName.
private String operatingSystem;
The default column name in the database will be operatingSystem.

### Question 4
Controller Layer: This is the presentation layer responsible for handling HTTP requests and responses. It receives client requests and calls the appropriate services or business logic.

Service Layer: This layer contains the business logic of the application. It is responsible for processing data, applying business rules, and performing operations on behalf of the controller.

Repository/Data Access Layer: This layer interacts with the database or data source. It contains code for data access and storage, such as CRUD (Create, Read, Update, Delete) operations.

### Question 5
Request Received: The request hits the controller layer. The controller handles the incoming HTTP request.

Controller Processing: The controller might use DTOs to transfer data and may validate the input data.

Business Logic: The controller calls the appropriate service method. The service layer contains the core business logic and may interact with the model entities.

Data Access: If needed, the service layer interacts with the repository layer to query, update, or delete data in the database.

Response Generation: After processing, the result is sent back to the controller.

Return Response: The controller then sends the response back to the client (in this case, Postman).

### Question 6
application.properties: This is a properties file used in Spring Boot applications for configuration. It allows defining various settings like database connection details, server port, application-specific properties, etc. The format is simple key-value pairs.

application.yml: This is an alternative to application.properties but uses YAML format. It offers a more readable and hierarchical format for configuration. It can represent the same configurations as application.properties but in a structured way that's often easier to read and write, especially for complex configurations.