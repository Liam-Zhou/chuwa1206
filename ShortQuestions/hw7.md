# API Practice

## GET APIs

1. GET **https://dog.ceo/api/breeds/image/random**

*RequestBody: N/A, since it is GET*

Response status: 200 OK

Response:

```json
{
    "message": "<https://images.dog.ceo/breeds/spaniel-sussex/n02102480_8002.jpg>",
    "status": "success"
}
```

1. GET **https://api.ipify.org?format=json**

*RequestBody: N/A, since it is GET*

Response status: 200 OK

Response:

```json
{
    "ip": "67.160.52.29"
}
```

1. GET **https://ipinfo.io/161.185.160.93/geo**

*RequestBody: N/A, since it is GET*

Response status: 200 OK

Response:

```json
{
    "ip": "161.185.160.93",
    "city": "New York City",
    "region": "New York",
    "country": "US",
    "loc": "40.7143,-74.0060",
    "org": "AS22252 The City of New York",
    "postal": "10001",
    "timezone": "America/New_York",
    "readme": "<https://ipinfo.io/missingauth>"
}
```

1. GET **https://official-joke-api.appspot.com/random_joke**

*RequestBody: N/A, since it is GET*

Response status: 200 OK

Response:

```json
{
    "type": "general",
    "setup": "What do prisoners use to call each other?",
    "punchline": "Cell phones.",
    "id": 191
}
```

1. GET **https://randomuser.me/api/**

*RequestBody: N/A, since it is GET*

Response status: 200 OK

Response:

```json
{
    "results": [
        {
            "gender": "male",
            "name": {
                "title": "Mr",
                "first": "Alfredo",
                "last": "Mesa"
            },
            "location": {
                "street": {
                    "number": 9729,
                    "name": "Cerrada Sandoval"
                },
                "city": "San Pablo Pejo (San Pablo)",
                "state": "Jalisco",
                "country": "Mexico",
                "postcode": 59437,
                "coordinates": {
                    "latitude": "29.7066",
                    "longitude": "-145.4318"
                },
                "timezone": {
                    "offset": "-3:00",
                    "description": "Brazil, Buenos Aires, Georgetown"
                }
            },
            "email": "alfredo.mesa@example.com",
            "login": {
                "uuid": "185f5b78-d888-477a-9458-6cd3441db7ea",
                "username": "greenleopard448",
                "password": "donner",
                "salt": "YGGHBDOf",
                "md5": "e57cb86153b16edbbfbc6b7516ab4670",
                "sha1": "4d54fef1ee0e8a836a40f249ef672ee642b4c37a",
                "sha256": "a25af6ee812ab53065622a2f9f575f4c27e52d0f42034351de6a96fedae7985a"
            },
            "dob": {
                "date": "1987-05-22T18:28:28.780Z",
                "age": 36
            },
            "registered": {
                "date": "2018-11-21T13:21:09.347Z",
                "age": 5
            },
            "phone": "(632) 187 4960",
            "cell": "(600) 572 5032",
            "id": {
                "name": "NSS",
                "value": "39 68 83 2712 1"
            },
            "picture": {
                "large": "<https://randomuser.me/api/portraits/men/23.jpg>",
                "medium": "<https://randomuser.me/api/portraits/med/men/23.jpg>",
                "thumbnail": "<https://randomuser.me/api/portraits/thumb/men/23.jpg>"
            },
            "nat": "MX"
        }
    ],
    "info": {
        "seed": "ff7fbe279ee74f53",
        "results": 1,
        "page": 1,
        "version": "1.4"
    }
}
```

## POST APIs

1. POST **https://jsonplaceholder.typicode.com/posts**

RequestBody:

```json
{
    "title": "foo",
    "body": "bar",
    "userId": 1
}
```

Response status: 201 Created

Response:

```json
{
    "title": "foo",
    "body": "bar",
    "userId": 1,
    "id": 101
}
```

1. POST **https://reqres.in/api/users**

RequestBody:

```json
{
    "name": "morpheus",
    "job": "leader"
}
```

Response status: 201 Created

Response:

```json
{
    "name": "morpheus",
    "job": "leader",
    "id": "590",
    "createdAt": "2024-01-08T07:16:48.750Z"
}
```

1. POST **https://httpbin.org/post**

RequestBody:

```json
{
    "sample": "data"
}
```

Response status: 200 OK

Response:

```json
{
    "args": {},
    "data": "{\\n    \\"sample\\": \\"data\\"\\n}",
    "files": {},
    "form": {},
    "headers": {
        "Accept": "*/*",
        "Accept-Encoding": "gzip, deflate, br",
        "Cache-Control": "no-cache",
        "Content-Length": "24",
        "Content-Type": "application/json",
        "Host": "httpbin.org",
        "Postman-Token": "f6cc7960-fe31-4455-90d9-46612299b0f3",
        "User-Agent": "PostmanRuntime/7.36.0",
        "X-Amzn-Trace-Id": "Root=1-659ba297-0a1e9ad81ac83cee1949e06f"
    },
    "json": {
        "sample": "data"
    },
    "origin": "67.160.52.29",
    "url": "<https://httpbin.org/post>"
}
```

1. POST **https://fakestoreapi.com/products**

RequestBody:

```json
{
    "title": "Test Product",
    "price": 13.5,
    "description": "A test product",
    "category": "test"
}
```

Response status: 200 OK

Response:

```json
{
    "id": 21,
    "title": "Test Product",
    "price": 13.5,
    "description": "A test product",
    "category": "test"
}
```

1. POST **https://my-json-server.typicode.com/typicode/demo/posts**

RequestBody:

```json
{
    "id": 10084,
    "title": "Post title"
}
```

Response status: 200 Created

Response:

```json
{
    "id": 10084,
    "title": "Post title"
}
```

## PUT APIs

1. PUT **https://jsonplaceholder.typicode.com/posts/1**

Request Body:

```json
{
    "id": 1,
    "title": "Updated title",
    "body": "Updated body",
    "userId": 1
}
```

Response status: 200 OK

Response:

```json
{
    "id": 1,
    "title": "Updated title",
    "body": "Updated body",
    "userId": 1
}
```

1. PUT **https://reqres.in/api/users/2**

Request Body:

```json
{
    "name": "morpheus",
    "job": "zion resident"
}
```

Response status: 200 OK

Response:

```json
{
    "name": "morpheus",
    "job": "zion resident",
    "updatedAt": "2024-01-08T07:32:16.257Z"
}
```

1. PUT **https://fakestoreapi.com/products/1**

Request Body:

```json
{
    "title": "Updated Product",
    "price": 15.5,
    "description": "An updated test product",
    "category": "test"
}
```

Response status: 200 OK

Response:

```json
{
    "id": 1,
    "title": "Updated Product",
    "price": 15.5,
    "description": "An updated test product",
    "category": "test"
}
```

## DELETE APIs

1. DELETE **https://jsonplaceholder.typicode.com/posts/1**

Request Body: *N/A, since it is DELETE*

Response status: 200 OK

Response:

```json
{}
```

1. DELETE **https://reqres.in/api/users/2**

Request Body: *N/A, since it is DELETE*

Response status: 204 No Content

# Short Questions

## 1. Explain how the below annotaitons specify the table in database?

```java
@Column(columnDefinition = "varchar(255) default 'John Snow'")
private String name;
```

- It specifies that the column for the **`name`** field in the database should be of type **`varchar`** with a maximum length of 255 characters.
- Additionally, it sets a default value for the column as 'John Snow'. This means if a new record is inserted into the table without a specific value for **`name`**, it will default to 'John Snow'.

```java
@Column(name="STUDENT_NAME", length=50, nullable=false, unique=false)
private String studentName;
```

- **`name="STUDENT_NAME"`**: This attribute specifies the name of the column in the database table. In this case, the column name will be **`STUDENT_NAME`**. If this attribute is not specified, JPA uses the field name (**`studentName`**) as the default column name.
- **`length=50`**: This sets the maximum length of the column in the database to 50 characters.
- **`nullable=false`**: This means the column cannot have null values. It's a mandatory field in the database.
- **`unique=false`**: This indicates that the column does not have to contain unique values. Multiple records in the table can have the same value for **`STUDENT_NAME`**.

## 2. What is the default column names of the table in database for @Column ?

```java
@Column
private String firstName;
```

firstName

```java
@Column
private String operatingSystem;
```

operatingSystem

## 3. What are the layers in springboot application? what is the role of each layer?

1. Presentation Layer - Controller Layer
   - **Role**: This layer is responsible for handling all user interface and browser communication logic. It acts as a gateway for incoming requests from clients.
   - **Components**: In Spring Boot, this layer is typically implemented using **`@RestController`** or **`@Controller`** annotations. Controllers receive HTTP requests and send responses. They are responsible for processing data received from clients (web browsers, mobile apps, etc.) and sending it to the service layer.
2. Business Layer - Service Layer
   - **Role**: This layer contains the business logic of the application. It controls the application's functionality by performing calculations, processing data, and invoking APIs.
   - **Components**: Services, annotated with **`@Service`**, encapsulate the business logic and rules. They work independently of the user interface and communicate with the data access layer to retrieve, update, and delete data.
3. Data Access Layer - Persistence Layer
   - **Role**: This layer handles all the data persistence mechanisms. It communicates with the database and manages entities and their relationships.
   - **Components**: This layer typically consists of repositories (often JPA Repositories), which are interfaces annotated with **`@Repository`**. These interfaces are responsible for data retrieval and storage, leveraging Spring Data JPA, JDBC, or other data access technologies.
4. Domain Layer - Model Layer
   - **Role**: This layer represents the business domain model of the application. It is the core of the business logic, representing the state and behavior of business entities.
   - **Components**: Domain models or entities annotated with **`@Entity`** represent the application's persistent data model. They map directly to the database tables and define the relationships between different data entities.

## 4. Describe the flow in all of the layers if an API is called by Postman

Post Client

|

Controller (API Layer)

|

Service (Business Logic)

|

DAO (Persistence Logic)

|

DB

## 5. What is the application.properties? do you know application.yml?

**`application.properties`** and **`application.yml`** are both configuration files used in Spring Boot applications.

### **application.properties**

- **Format**: This file uses the standard properties file format, which is simple key-value pairs. Each key-value pair is separated by an **`=`** sign.

- **Usage**: Commonly used to configure various aspects of a Spring Boot application, such as database connections, server port, Spring profiles, and other custom configurations.

- **Example**:

  ```
  server.port=8080
  spring.datasource.url=jdbc:mysql://localhost:3306/mydb
  spring.datasource.username=root
  spring.datasource.password=secret
  ```

### **application.yml**

- **Format**: This file uses YAML (YAML Ain't Markup Language) format. YAML is considered more human-readable, especially for complex configurations. It uses indentation to represent the hierarchy of configuration properties.

- **Usage**: Similar to **`application.properties`**, it's used for configuring a Spring Boot application. It's an alternative to **`application.properties`** and can be used for the same purposes.

- **Example**:

  ```yaml
  server:
    port: 8080
  spring:
    datasource:
      url: jdbc:mysql://localhost:3306/mydb
      username: root
      password: secret
  ```