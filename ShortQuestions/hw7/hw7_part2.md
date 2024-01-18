# 2. explain how the below annotations specify the table in the database.

```
@Column(columnDefinition = "varchar(255) default 'John Snow'")
private String name;

@Column(name="STUDENT_NAME", length=50, nullable=false, unique=false)
private String studentName;

```

The first annotation uses columnDefinition to specify the database column with a default value.
The second annotation uses name, length, nullable, and unique to define column attributes.

# 3. What are the default column names of the table in the database for @Column?

```
@Column
private String firstName;
@Column
private String operatingSystem;
```

The default column names are derived from the field names:
firstName will have a default column name of "first_name."
operatingSystem will have a default column name of "operating_system."

# 4. What are the layers in the spring boot application? what is the role of each layer?

Layers: Controller, Service, Repository (or DAO), and Model (or Entity).
Roles: Controller handles requests and responses, Service contains business logic, Repository deals with data access, and Model represents data entities.

# 5. Describe the flow in all of the layers if an API is called by Postman.

Request received by Controller -> Controller processes input -> Invokes Service layer -> Service performs business logic -> Interacts with Repository for data -> Repository interacts with Database -> Response generated and returned through the layers.

# 6. What is the application.properties? do you know application.yml?

application.properties is a file for configuring application settings in a key-value format.
application.yml is an alternative to properties, using YAML syntax for configuration. It offers a more human-readable and structured format.
