2. `name` variable has max 255 characters and default value is "John Snow".
   `StudentName` variable has max length 50, cannot be null and column does not have to be unique. The same value can appear in multiple rows.
3. The default name will be the same as variable name. "firstName" and "operatingSystem"
4. (1) controller layer: handles HTTP requests, processes user input, and returns the appropriate responses.
   (2) Service layer: Contains the business logic of the application.
   (3) Repository (or DAO) layer: Handles data persistence and retrieval.
   (4) Entity layer: Represents the data structure, often mirroring database tables.
   (5) DTO (Data Transfer Object) layer: Transfer data between processes, often used to send data to clients or receive from clients.
5. (1) client layer: The user or client sends an HTTP request to the Spring Boot application. This could be `GET`, `POST`, `PUT`, `DELETE`.
   (2) Controller layer: The request is first received by the appropriate controller, determined by the URL and HTTP method of the request.
   (3) Service layer: The service layer contains the business logic. It processes the request, performs validations, and executes business rules.
   (4) Repository layer: The repository layer interacts with the database. It uses JPA repositories or similar mechanisms to query the database, update records, or retrieve data.
   (5) Model layer: The data retrieved from the database is represented in the form of entities or models in the model layer.
   (6) Back to Service layer: The service layer may perform additional logic on the data received from the repository layer.
   (7) Back to Controller layer: The controller layer receives the processes data from the service layer.
   (8) Response to Client: The response is sent back to the client through the same path it came in. The client receives the response, which includes any data requested, status codes, and messages.
6. `application.properties` is the standard configuration file in Spring Boot applications. It is used to define various configuration properties, such as database connection details, sever port, application parameters, etc.
   `application.yml` is another format for Spring Boot configuration files, offering an option to write configurations in YAML format.

![Screenshot 2024-01-05 at 01.48.41.png](Screenshot%202024-01-05%20at%2001.48.41.png)