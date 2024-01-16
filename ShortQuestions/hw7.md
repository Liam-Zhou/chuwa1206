# API
1. 5 GET APIs with Different Response Types
+ OpenWeatherMap API - Weather Data:

Endpoint: GET http://api.openweathermap.org/data/2.5/weather?q=London&appid=YOUR_API_KEY
Response Type: JSON (weather data for London)
+ JSONPlaceholder - Fake Online REST API:

Endpoint: GET https://jsonplaceholder.typicode.com/posts
Response Type: JSON (list of posts)
+ PokéAPI - Pokémon Information:

Endpoint: GET https://pokeapi.co/api/v2/pokemon/ditto
Response Type: JSON (data about Pokémon 'Ditto')
+ GitHub API - User Repositories:

Endpoint: GET https://api.github.com/users/octocat/repos
Response Type: JSON (list of repositories for the user 'octocat')
2. 5 POST APIs with JSON Request Body
+ JSONPlaceholder - Create a Post:

Endpoint: POST https://jsonplaceholder.typicode.com/posts
Request Body: JSON (e.g., {"title": "foo", "body": "bar", "userId": 1})
+ Reqres - Create a User:

Endpoint: POST https://reqres.in/api/users
Request Body: JSON (e.g., {"name": "morpheus", "job": "leader"})
+ Fake Store API - Create a Product:

Endpoint: POST https://fakestoreapi.com/products
Request Body: JSON (e.g., {"title": "test product", "price": 13.5, "description": "a test product", "image": "https://i.pravatar.cc"})
+ My JSON Server - Add a Book:

Endpoint: POST https://my-json-server.typicode.com/typicode/demo/posts
Request Body: JSON (e.g., {"id": 1, "title": "JSON Server", "author": "typicode"})
+ HTTPBin - Test POST:

Endpoint: POST https://httpbin.org/post
Request Body: JSON (e.g., {"sample": "data"})
3. 3 PUT APIs with JSON Request Body
+ JSONPlaceholder - Update a Post:

Endpoint: PUT https://jsonplaceholder.typicode.com/posts/1
Request Body: JSON (e.g., {"id": 1, "title": "updated title", "body": "updated body", "userId": 1})
+ Reqres - Update a User:

Endpoint: PUT https://reqres.in/api/users/2
Request Body: JSON (e.g., {"name": "morpheus", "job": "zion resident"})
+ Fake Store API - Update a Product:

Endpoint: PUT https://fakestoreapi.com/products/1
Request Body: JSON (e.g., {"title": "updated product", "price": 15.5, "description": "an updated test product", "image": "https://i.pravatar.cc"})
4. 2 DELETE APIs
+ JSONPlaceholder - Delete a Post:

Endpoint: DELETE https://jsonplaceholder.typicode.com/posts/1
+ Reqres - Delete a User:

Endpoint: DELETE https://reqres.in/api/users/2




# 2
```java
@Column(columnDefinition = "varchar(255) default 'John Snow'")
private String name;
```
1. columnDefinition: This property allows you to define the complete column definition in SQL. Here, it specifies that the column for the name field should be created as a VARCHAR type with a maximum length of 255 characters, and the default value for the column is set to 'John Snow'.
2. Mapping: The field name in the Java entity will be mapped to a column in the database table with the specified columnDefinition. If you don't specify the name attribute in the @Column annotation, the column name will default to the name of the field (name in this case).

  
```java
@Column(name="STUDENT_NAME", length=50, nullable=false, unique=false)
private String studentName;
```
1. name: Specifies the name of the column in the database.
2. length: Defines the column length. Here, the column will have a maximum length of 50 characters.
3. nullable: nullable=false means the column will be created as NOT NULL, enforcing that every row must have a value for this column.
4. unique: unique=false indicates that duplicate values are allowed in this column.


# 3
firstName for the firstName property.
operatingSystem for the operatingSystem property.

# Layers in a Spring Boot Application
1. Controller Layer:

    Role: Handles HTTP requests, translates parameters, and validates input.
    
    Components: REST Controllers (@RestController), which use request mapping annotations (@GetMapping, @PostMapping, etc.).
2. Service Layer:

   Role: Contains business logic, handles the application's operations and business rules.
   
    Components: Services (@Service) which process data, perform calculations, and call methods from the repository layer.
3. Repository Layer:

   Role: Interacts with the database, performs CRUD (Create, Read, Update, Delete) operations.
   
    Components: Repositories (@Repository) which use Spring Data JPA or similar technologies to interact with database models.
4. Model/Domain Layer:

   Role: Represents data and business entities.
   
    Components: Entity classes (@Entity) that map to database tables.
5. DTOs and Mappers (optional but recommended):

   Role: Transfer data between layers, map entities to DTOs (Data Transfer Objects).
   
    Components: DTO classes and mapper classes or frameworks like MapStruct.

# Flow of an API Call
1. HTTP Request: Postman sends an HTTP request to the Spring Boot application.

2. Controller Layer:

The request hits a controller method mapped to the request's URL.
The controller validates and processes the request data, then calls a service method.
3. Service Layer:

The service layer handles business logic and operations.
It may interact with the repository layer to retrieve or update data.
4. Repository Layer:

If data access or modification is needed, the service layer communicates with the repository layer.
The repository layer performs database operations and returns data (typically as entities) back to the service layer.
5. Service Layer (continued):

The service layer processes the data, applies business logic, and may transform entities to DTOs.
6. Controller Layer (continued):

The controller receives the processed data (or DTOs) from the service layer.
It constructs an HTTP response (e.g., JSON format) and sends it back to the client.

# application.properties and application.yml
1. application.properties:

It's a properties file for configuring a Spring Boot application.
It contains key-value pairs to configure various aspects of the application, like database settings, server port, logging levels, etc.
2. application.yml:

An alternative to application.properties, it provides the same configuration capabilities but uses the YAML format.
YAML can be more readable and supports hierarchical configuration data, which can be particularly useful for complex configurations.

# mongo-post see CodeQuestions