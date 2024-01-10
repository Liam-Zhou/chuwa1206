# Homework 7



## Explain how the below annotations specify the table in a database.



- the first annotation specifies the definition of the `name` column which includes the data type and the default value

- the second one specifies the name, and length, cannot be nullable, and is not unique to the `Student_Name` column



## What are the default column names of the table in the database for @column?



- `firstName` -> `first_name`, `operatingSystem` -> `operating_system`



## What are the layers in the springboot application? What is the role of each layer?



- Controller Layer: This layer is responsible for handling incoming HTTP requests(Defining APIs), processing them, and returning an appropriate response to the client.

- Service Layer: This layer contains the business logic of the application.

- Repository(DAO) Layer: This layer is responsible for interacting with the database or any other data source. It performs CRUD (Create, Read, Update, Delete) operations on the data.

- Model Layer: This layer represents the domain model or entities that are used by the application. These are typically POJOs (Plain Old Java Objects) representing the structure of the data.

- View Layer(Optional): In web applications, the view layer is responsible for presenting data to the user. In RESTful services, the view is often represented as JSON or XML.

- Configuration Layer: This layer contains configuration settings for the application. It may include settings related to databases, security, caching, etc.

- Security Layer: This layer is responsible for handling security concerns such as authentication and authorization.

- Exception Handling Layer:  This layer deals with handling exceptions that may occur during the execution of the application. It provides a centralized way to manage and communicate errors to clients.



## Describe the flow in all of the layers if an API is called by Postman



1. Client: The Postman client sends an HTTP request to the server API

2. Controller: receives and maps the HTTP request to a service function

3. Service: perform the actual business logic, may also perform DTO conversion

4. DAO: service function may interact with DB

5. Controller: receives results from the service layer

6. Client: The Postman client receives the HTTP response from the server



## What is application.properties? Do you know application.yml?



- It is used as a configuration file of the SpringBoot project e.g. defining DB connection, graphQL support, etc.

- We can also use a YAML format configuration file instead of properties, the functionalities are the same.


