1. Explain how the below annotaitons specify the table in database?

> These annotations help define the mapping between the Java class and the corresponding database table
```java
@Column(columnDefinition = "varchar(255) default 'John Snow'")
private String name;
```


- This annotation is used to define the column properties in the database for the name field.
- `columnDefinition` specifies the SQL data type and additional constraints for the column. In this case, it's set to a varchar with a maximum length of 255 characters, and a default value of 'John Snow' if no value is provided.

```java
@Column(name="STUDENT_NAME", length=50, nullable=false, unique=false)
private String studentName;
```

- This annotation is used to define the column properties for the `studentName` field.
- `name` specifies the name of the column in the database, which is set to "STUDENT_NAME".
- `length` sets the maximum length of the column to 50 characters.
- `nullable` is set to false, indicating that the column cannot contain null values.
- `unique` is set to false, meaning that the values in this column are not required to be unique.

2. What is the default column names of the table in database for @Column ?

```java
@Column
private String firstName;

@Column
private String operatingSystem;
```
- The column for firstName would be named first_name.
- The column for operatingSystem would be named operating_system.

3. What are the layers in springboot application? what is the role of each layer?
![img.png](img5.png)

4. Describe the flow in all of the layers if an API is called by Postman.
![img.png](img6.png)

5. What is the application.properties? do you know application.yml?
![img.png](img7.png)
> Both formats have their own advantages and limitations, and it’s up to the developers to choose the one that best suits their needs.