## 2. explain how the below annotations specify the table in the database.

@Column(columnDefinition = "varchar(255) default 'John Snow'")

This annotation specifies that the column for the name field in the database should be defined as a VARCHAR type with a maximum length of 255 characters. It also sets a default value of 'John Snow' for the column. This means if a record is inserted into the table without a specific value for name, it will default to 'John Snow'.

@Column(name="STUDENT_NAME", length=50, nullable=false, unique=false)

This annotation customizes the studentName field to be mapped to a database column named STUDENT_NAME. It defines the column to have a maximum length of 50 characters, to not allow null values (nullable=false), and specifies that the column does not enforce uniqueness (unique=false).

## 3. What are the default column names of the table in the database for @Column?

@Column
private String firstName;
@Column
private String operatingSystem;

The default column names in the database would be the same as the field names but are typically converted to uppercase or snake_case depending on the database naming convention used. Therefore, by default, they would be FIRSTNAME and OPERATINGSYSTEM or first_name and operating_system, respectively, if the convention is to use snake_case.

## 4. What are the layers in springboot application? what is the role of each layer?

Controller Layer: Handles HTTP requests, dispatching them to the service layer, and returns responses to the client. It acts as the entry point for the client requests.

Service Layer: Contains the business logic of the application. It is responsible for processing the data sent to and from the DAO layer and executing business rules.

Repository (DAO) Layer: Responsible for data access and manipulation. This layer interacts directly with the database through ORM (Object Relational Mapping) tools like Hibernate.

Model/Entity Layer: Represents the domain model of the application, usually mapped to database tables.

## 5. Describe the flow in all of the layers if an API is called by Postman.

Controller Layer: The request hits a specific controller based on the URL and HTTP method. The controller processes the request and delegates the business logic execution to the service layer.

Service Layer: The service layer executes the required business logic, such as input validation, and performs operations required by the request. It might interact with the repository layer to retrieve or update data in the database.

Repository Layer: If the operation involves data, this layer interacts with the database to execute CRUD (Create, Read, Update, Delete) operations and returns the data to the service layer.

Back to Service Layer: The service layer may perform additional operations on the data retrieved from the database and then passes the response back to the controller.

Controller Layer: Finally, the controller sends the response back to the client (Postman in this case) in the form of JSON, XML, or any other format depending on the API design.

## 6. What is the application.properties? do you know application.yml?

application.properties: A properties file used by Spring Boot to configure various aspects of the application. It includes settings like server port, database connections, and custom application settings.

application.yml: An alternative to application.properties, offering the same configuration capabilities but in YAML format, which is more readable and supports hierarchical configuration data.
