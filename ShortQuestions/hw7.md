
 1. create a file to list all of the annotaitons you learned and known, and explain the usage and how do youunderstand it. you need to update it when you learn a new annotation. Please organize those annotations 
well, like annotations used by entity, annotations used by controller.
    1.  File name: annotations.md
    2.  you'd better also list a code example under the annotations
   *please see file named annotations.md*

2. explain how the below annotaitons specify the table in database?

```java
//this will be mapped to a column "name" it will a varchar with max lenthg of 255 with default value "john Snow"
    @Column(columnDefinition = "varchar(255) default 'John Snow'")
    private String name;

//column name "STUDENT_NAME" with max len of 50 and must be not null, but could be not unique.
    @Column(name="STUDENT_NAME", length=50, nullable=false, unique=false)
    private String studentName;
```


3. What is the default column names of the table in database for  @Column ?
```java

//firstName
@Column
private String firstName;

//operatingSystem
@Column
private String operatingSystem
```

4.  What are the layers in springboot application? what is the role of each layer?
    1. controller, to handle incoming request
    2. service, usually called by controller by specific reqeusting.
    3. DAO. data access object used to mapping and hadling the request and response with the DB.

5.  Describe the flow in all of the layers if an API is called by Postman.
    1.  postman make the call (get, post, put, delete)
    2.  controller
    3.  service
    4.  DTO
    5.  DB
    6.  DTO
    7.  service
    8.  controller
    9.  view
6.  What is the application.properties? do you know application.yml?

    **application.properties** is a configuration fill usually for java spring application, it is in the form of key-value pair. it used to configure application properties, such as databse connection, server running pot, log setting etc. 

    **application.yml** is also a configuration file in form of YAML, it is more cleared and better organized way than .properties file, since it can show more clear of hierarchiy.


7.  Create a Project, name it with mongo-blog, write a POST API for mongo-blog, change database to MongoDB:
    1. see mongo-blog folder