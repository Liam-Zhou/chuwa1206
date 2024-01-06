1. Screenshot
2. see REST API.md
3. see annotations.md
4. explain how the below annotaitons specify the table in database?

    - In Java Persistence API (JPA), which is used for mapping Java objects to database tables, the @Column annotation is used to specify the mapping between a field or property of an entity class and a column in a database table.
    - It allows you to define the exact SQL data type. It defines a VARCHAR column with a maximum length of 255 characters and a default value of 'John Snow'.
    - `name`: Specifies the name of the column in the database. 1: Specifies the column length. `nullable`: Specifies whether the column is nullable. `unique`: Specifies whether the column values must be unique across all rows in the table

5. What is the default column names of the table in database for @Column ?

    - The default column name in the database is derived from the field or property name in your Java entity. so firstName -> first_name
      operatingSystem -> operating_system

6. What are the layers in springboot application? what is the role of each layer?

   - Presentation layer: Authentication, JSON Translation
   - Business layer: Business logic, validation, authorisation
   - Persistence layer: Storage logic
   - Database: Actual database

7. Describe the flow in all of the layers if an API is called by Postman.

   - Presentation layer: Postman sends an HTTP request to the Spring Boot application.
     Spring Boot's Controller receives the request. This is where the presentation layer begins.
     Authentication may happen here, depending on your configuration.
     The Controller processes the request and invokes the appropriate service in the business layer.
   - Business layer: The service in the business layer executes the business logic related to the API request.
     Validation checks are performed on the incoming data to ensure it meets the required criteria.
     Authorization checks may occur here to verify if the authenticated user has the necessary permissions.
     The service may interact with the persistence layer to retrieve or store data.
   - Persistence layer: The business layer interacts with the persistence layer to perform storage-related operations.
     This layer contains repositories or DAOs responsible for database interactions.
     Data may be retrieved from or saved to the database based on the business logic requirements.
   - Database: The database processes queries or updates based on the requests from the persistence layer.

8. What is the application.properties? do you know application.yml?

   - `application.properties` is a text file where configurations are specified using a key-value pair format.
   - ` YAML` is a human-readable data serialization format, `application.yml` is also a configuration file used to customize the behavior of the application.

9. Create a Project, name it with mongo-blog, write a POST API for mongo-blog, change database to
   MongoDB


