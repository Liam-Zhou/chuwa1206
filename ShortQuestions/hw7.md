# HW7

## Q1 Annotation

/spring学习笔记/annotation.md



## Q2 annotation in database

```java
@Column(columnDefinition = "varchar(255) default 'John Snow'")
private String name;
@Column(name="STUDENT_NAME", length=50, nullable=false, unique=false)
private String studentName;
```



@Column specify the schema in databse. 

ColumnDefinition allows input SQL DDL, while using (name = "") will use auto DDL and mapping by JPA.



## Q3 What is the default column names of the table in database for @Column

```java
@Column
private String firstName;
@Column
private String operatingSystem;
```

It will use variable name and convert camel case to snake case. So the auto column name would be first_name and operating_system



## Q4 Layers in Springboot

- controller层 前端交互，接受http请求
  - DTO/Payload/response/request/DO/VO 用来hold java对象，把获得的数据存在java对象中
- service层，有business logic, controller会调service
- jpa/dao/repository - CRUD, interact with database
- Entity - mapping database: table, column 把数据库映射到java object



## Q5 Describe the flow in all of the layers if an API is called by Postman.

- controller receive the request, and call the service layer to do certain tasks accordingly.
- service layer will process the data and perform business logic. Also it may read from or write data to database
- DAO layer perform CRUD operations if service layer ask to. In JPA case, it use ORM framework Hibernate to fetch data from database.
- Entity layer maps database and java object if read or write is needed.



## Q6 What is the application.properties? do you know application.yml?

 They are configuration files used in Spring Boot applications to define various settings and properties.

application.properties is a text-based configuration file typically written in a key-value format.

application.yml is an alternative configuration file format that uses YAMLsyntax, which is more human-readable and concise compared to application.properties. YAML allows you to define properties, lists, and nested configurations using indentation.



## Q7 /mavenproject

![image-20240111022253549](C:\Users\Hanyun\OneDrive\桌面\chuwa java batch\assignments\chuwa1206\ShortQuestions\typora_images\hw7\image-20240111022253549.png)