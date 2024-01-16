2. explain how the below annotaitons specify the table in database?
   @Column(columnDefinition = "varchar(255) default 'John Snow'")
   private String name;

   define the mapping of a java entity field to a column in a database table
   columnDefinition: specifies SQL column definition. in this case, it defines a 'VARCHAR' column with 
   maximu length of 255 characters and a default value of "john Snow"

    @Column(name="STUDENT_NAME", length=50, nullable=false, unique=false)
    private String studentName;
    it indicates that the annotated field is mapped to a database column
    Speciifies the name of the database column, the maximum length of the column 50 characters 
    
   
3. What is the default column names of the table in database for  @Column ?
   @Column
   private String firstName;
   @Column
   private String operatingSystem;

   first_name and  operating_system

4. What are the layers in springboot application? what is the role of each layer?
   presentation Layer(Controller)
   Role: Handles incoming HTTP requests, processes them, and returns an appropriate HTTP response
   Components: String MVC Controllers, REST controllers
   
   Service Layer:
   Contains business logic, acts as an intermediary between the controller and data access layer
   Components: service classes annotated with "@service"

   Data Access Layer: (Repository)
   Interacts with the database to perform CRUD (operations) 

   Domain Object:
   data structue of the applicaiotn
   Components: POJOs (plain Old java Objects)

5. Describe the flow in all of the layers if an API is called by Postman.

   Postman initiates an HTTP request to the API, specifying the method, URL, headers, and payload.
   The request is processed by the Controller in the Presentation Layer, where parameters are extracted, and the corresponding Service method is invoked. 
   The Service Layer, containing business logic, interacts with the Data Access Layer, communicating with the database through Repository classes. 
   The Domain Model represents the data structure and business logic.
   The Controller constructs an HTTP response based on the results from the Service Layer, and the response is sent back to Postman, completing the flow.

6. What is the application.properties? do you know application.yml?
   Both files serve as a central place for configuring various aspects of a Spring Boot application, including server properties, 
   database configurations, logging levels, etc
   application.properties: Key-value pairs in a properties file format.
   application.yml:  human-readable and structured format, support nested structures 