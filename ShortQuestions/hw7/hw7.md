### 2. explain how the below annotaitons specify the table in database?

```java
//This will create a column, the column name will be "name", the type will be varchar(255), and the default value would be John Snow
    @Column(columnDefinition = "varchar(255) default 'John Snow'")
    private String name;

//Create a column named "STUDENT_NAME", set the length limitation to 50, can't be null and do not require the value to be unique.
    @Column(name="STUDENT_NAME", length=50, nullable=false, unique=false)
    private String studentName;
```


### 3. What is the default column names of the table in database for  @Column ?
```java

//firstName
@Column
private String firstName;

//operatingSystem
@Column
private String operatingSystem;
```

### 4.  What are the layers in springboot application? what is the role of each layer?
    1. controller, to handle requests
    2. service, to handle data and finish processing after called by controller.
    3. DAO. data access object used to mapping the Java object to a DB entity.

### 5.  Describe the flow in all of the layers if an API is called by Postman.
    1.  postman make the call (get, post, put, delete)
    2.  controller
    3.  service
    4.  DTO
    5.  DB
    6.  DTO
    7.  service
    8.  controller
    9.  view
    
### 6.  What is the application.properties? do you know application.yml?

    **This file is a key-value pair configuration file typically used in Java Spring applications. It is utilized to set up application properties such as database connections, the port on which the server runs, logging settings, and more.

    **application.yml** is a configuration file formatted in YAML. It offers a clearer and better-organized alternative to the .properties file due to its ability to display hierarchies more distinctly.
