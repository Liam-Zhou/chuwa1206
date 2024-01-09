### 2.explain how the below annotaitons specify the table in database?

```java
//name field in the Java entity should be mapped to a VARCHAR column named 'name' in the database with default value "John Snow"
@Column(columnDefinition = "varchar(255) default 'John Snow'")
private String name;
//column name is STUDENT_NAME in the database, max length is 50, null value is not accepted, and values can be same
@Column(name="STUDENT_NAME", length=50, nullable=false, unique=false)
private String studentName;
```

### 3. What is the default column names of the table in database for @Column ?

```java
//first_name
@Column
private String firstName;
//operating_system
@Column
private String operatingSystem;
```

### 4. What are the layers in springboot application? what is the role of each layer?

> Controller -> Service -> DAO
>
> Controller:  responsible for handling incoming HTTP requests, processing them, and returning an appropriate response. I
>
> Service: contains business logic and performs operations requested by the controller.

### 5.  Describe the flow in all of the layers if an API is called by Postman.

> Postman Request -> Controller -> Service -> DAO -> db -> Response

### 6. What is the application.properties? do you know application.yml?

>`application.properties` is a plain text file where configurations are specified in a key-value pair format. For example:
>
>```properties
># Database Configuration
>spring.datasource.url=jdbc:mysql://localhost:3306/mydatabase
>spring.datasource.username=root
>spring.datasource.password=secret
>
># Server Configuration
>server.port=8080
>
>```
>
>`application.yml` is a YAML (YAML Ain't Markup Language) file format that allows you to define configurations using indentation.
>
>```yaml
># Database Configuration
>spring:
>  datasource:
>    url: jdbc:mysql://localhost:3306/mydatabase
>    username: root
>    password: secret
>
># Server Configuration
>server:
>  port: 8080
>
>```
>
>