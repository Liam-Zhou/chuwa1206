## HW7
# Q1. create a file to list all of the annotaitons you learned and known, and explain the usage and how do you understand it. 

# Q2. Explain how the below annotaitons specify the table in database?
```

@Column(columnDefinition = "varchar(255) default 'John Snow'")
private String name;
  
@Column(name="STUDENT_NAME", length=50, nullable=false, unique=false)
private String studentName;
```

# Q3. What is the default column names of the table in database for `@Column`
```
@Column
private String firstName;
@Column
private String operatingSystem;
``` 

# Q4. What are the layers in springboot application? what is the role of each layer?

# Q5. Describe the flow in all of the layers if an API is called by Postman.

# Q6. What is the application.properties? Do you know application.yml?

# Q7. Create a Project, name it with mongo-blog, write a POST API for mongo-blog, change database to MongoDB;