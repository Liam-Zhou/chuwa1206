# HW8

## how do you do the debug?

debugger, print, and possibly maven project test functions



## What is DTO, VO, Payload, DO, model?

**DTO**: data transfer object. Everytime there's need to hold data, we create a DTO type

**VO**: value object. They are immutable object used to hold values that should not be modified directly after creation, like money amount, date of birth, RGB color

**payload**: payload is the actual data which is transfered between networks or different part of the modules. In practice, you may use DTO to structure the payload data for organized and controlled data transfer.

**DO**: data object. It can be used to represent data entities or objects in the context of object-relational mapping (ORM) frameworks. DOs typically correspond to database tables or domain objects and may have methods that interact with the database.

**Model**: In context of MVC, model represents the application's data and business logic



## What is @JsonProperty("description_yyds")

It maps the field 'description' in Java object to property 'description_yyds' in JSON object.

``` java
@JsonProperty("description_yyds")
private String description;
```



## What is Jackson

It's a widely used java library for JSON serialization and deserialization



## What is spring-boot-stater?

A starter is a convenient and pre-configured set of dependencies that help you quickly bootstrap or set up a specific type of application or feature within your Spring Boot project.

``` java
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-web</artifactId>
</dependency>
```

Above is spring-boot-starter-web. It contains dependencies including controllers, request handling, and HTTP-related functionality.

Other widely used start are like spring web, spring boot starter, spring boot starter tomcat, Spring Boot Starter Logging



## do you know @RequestMapping(value = "/users", method = RequestMethod.POST) ? could you list CRUD by this style?

This is the post method controller for url /users



## What is ResponseEntity? why do we need it?

It wrap the entire HTTP response, including the status code, headers, and body. It allows developers to fully control the HTTP response sent back to the client.



## What is ResultSet in jdbc? and describe the flow how to get data using JDBC

ResultSet is an interface that represents a table of data representing the result of a database query. It is used to retrieve and manipulate the results returned by executing SQL queries against a database.

1. load driver
2. start connection
3. create a statement
4. execute a query
5. process resultSet
6. close resource



## What is the ORM framework?

Object relational mapping frameworks maps java object and database data, and can perform CRUD operations, schema manipulations to the database without writing SQL queries.



## What is serialization and deserialization

Serialization and deserialization are processes used in computing for converting data structures or object states into a format that can be stored, transmitted, and reconstructed later. The serialized format could be binary, XML, JSON, or another custom format. The main goal of serialization is to save the state of an object in a way that it can be recreated later.





## use stream api to get the average of the array [20, 3, 78, 9, 6, 53, 73, 99, 24, 32].

``` java
List<Integer> numbers = Arrays.asList(20, 3, 78, 9, 6, 53, 73, 99, 24, 32);
double average = numbers.stream()
                        .mapToInt(Integer::intValue)
                        .average()
                        .orElse(Double.NaN);
```



## Redbook

application in Hanyun_Zhao/redbook branch



