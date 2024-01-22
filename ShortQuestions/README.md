## 2. explain how the below annotaitons specify the table in database?

- First @Column Annotation: columnDefinition: Specifies the SQL fragment to be used when generating the DDL for the column. In this case, it defines the column as a VARCHAR with a maximum length of 255 characters, and a default value of 'John Snow'. This annotation is used to customize the SQL schema generation for the name field.

- Second @Column Annotation: 

name: Specifies the name of the column in the database table. In this case, it is set to "STUDENT_NAME".
length: Specifies the maximum length of the column. Here, the maximum length is set to 50 characters.
nullable: Defines whether the column can contain null values. In this case, it is set to false, indicating that the studentName cannot be null.
unique: Specifies whether the column should have a unique constraint. In this case, it is set to false, indicating that duplicate values are allowed for this column.
This annotation is used to customize the details of the SQL schema for the studentName field.

## 3. What is the default column names of the table in database for @Column?

The default behavior for the @Column annotation in JPA is to use the field name as the default column name in the database. If you don't explicitly provide a name attribute in the @Column annotation, the JPA provider will use the name of the field as the default column name.

## 4. What are the layers in springboot application? what is the role of each layer?

Presentation Layer (Controller):

Role: This layer handles incoming HTTP requests, processes them, and returns the appropriate HTTP response. Controllers are responsible for receiving user input, invoking the business logic, and returning the result to the client.

Service Layer:

Role: The service layer contains business logic and acts as an intermediary between the presentation layer (controllers) and the data access layer. It encapsulates the application's core logic, often dealing with complex operations, validations, and coordination between multiple entities.

Repository or Data Access Layer:

Role: This layer is responsible for interacting with the database or any external data source. It typically contains repository interfaces that define methods for CRUD (Create, Read, Update, Delete) operations on entities. The implementation of these interfaces is handled by Spring Data or custom code.

Entity Layer:

Role: Entities represent the data model of the application. These are Java objects that map to database tables. They often encapsulate business logic related to data and provide a way to interact with the underlying database.

DTO (Data Transfer Object) Layer:

Role: DTOs are used to transfer data between layers. They are often used to encapsulate a subset of entity data or to aggregate data from multiple entities. DTOs help in avoiding tight coupling between the layers and provide a clear contract for data exchange.

## 5. Describe the flow in all of the layers if an API is called by Postman.

Presentation Layer (Controller):

Postman sends an HTTP request to the API endpoint specified in the request.
The Spring Boot controller, mapped to the endpoint, receives the HTTP request.
The controller method is responsible for processing the request, validating input parameters, and invoking the appropriate service method.

Service Layer:

The controller delegates the processing logic to the service layer.
The service layer contains business logic, performs necessary operations, and may interact with the data access layer (repositories).
Service methods orchestrate the necessary actions to fulfill the request.

Repository or Data Access Layer:

The service layer may interact with repositories to perform CRUD operations on the database or other data sources.
Repository interfaces define the methods for data access, and the actual implementation is often handled by Spring Data.

Entity Layer:

Entities represent the data model and are used by the data access layer to interact with the database.
The service layer may use entities to encapsulate and manipulate data.

DTO (Data Transfer Object) Layer:

DTOs may be used to transfer data between the service layer and the presentation layer.
They help in avoiding tight coupling by defining a clear contract for data exchange.

## 6. What is the application.properties? do you know application.yml?

Application.properties and application.yml are configuration files that allow you to externalize and customize application settings. These files are used to configure various aspects of the application, such as database connection details, logging levels, server port, and more.

