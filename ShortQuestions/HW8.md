2. I can set breakpoints, start debug mode. 
3. (1) DTO is data transfer object which is used to transfer data between software application subsystem or layers. DTOs are often used to encapsulate data and are commonly used to serialize and deserialize data for communication.
   (2)VO which is value object. Represents an object with a specific identity, often used in domain-driven design. VO is immutable and is defined by its attributes.
   (3) Payload is used to refer to the part of transmitted data that is the actual intended message.
   (4) DO is domain object which represents a bussiness entity in the domain model. DOs are usually part of the bussiness layer and hold business data and state. They can contain business logic or methods that are operate on the data.
   (5) Model is used to represents data and possibly business logic in MVC. In sprintboot, model often refer to domain models ot entities in an MVC application. They are used to encapsulate data that is ultimately displayed on the view. 
4. `@JsonProperty` is used to specify the name of a property in JSON. `@JsonProprety("description_yyds")` means we are telling Jackson to map this filed or methods to a JSON property named `description_yyds`. 
5. `jackson-databind` can convert between Java Object and JSON. 
6. `spring-boot-starter-web` is used to build web application, including Spring MVC and RESTful application. Starters include a range of dependencies that we  typical for a given type of application, removing the need to specify each dependency individually in `pom.xml`.
7. `@RequestMapping` annotation in Spring Boot is used to map HTTP requests to handler methods of MVC and REST controllers. 
I can defined CRUD as following:
   (1) Create(POST):
```
@RequestMapping(value = "/users", method = RequestMethod.POST)
public ResponseEntity<User> createUser(@RequestBody User user){
}
```
(2) Read(GET):
```
@RequestMapping(value = "/users", method = RequestMethod.GET)
public ResponseEntity<List<User>> getAllUsers(){
}
```
or
```
@ReuqestMapping(value = "/users/{id}", method = RequestMethod.GET)
public ResponseEntity<User> getUserById(@PathVariable Long id){
}
```
(3) Update(PUT)
```
@RequestMapping(value = "/users/{id}", method = RequestMethod.PUT)
public ResponseEntity<User> updateUser(@Pathvariable Long id, @RequestBody User user){
}
```
(4) Delete (DELETE)
```
@RequestMapping(value = "/users/{id}", method = RequestMethod.DELETE)
public ResponseEntity<Void> deleteUser(@PathVariable Long id){
}
```
8. `ResponseEntity` allows you to have complete control over the HTTP response sent back to the client. And can return different
 HTTP status codes depending on the outcome of the request. And also can handling exception. 
9. `ResultSet` provides methods to iterate through the data returned from a SQL query. It maintains a cursor pointing to its current row of data. Intially, this cursor is positioned before the first row. The `next()` method moves the cursor to the next row, and because it returns `false` when there are no more rows, it is often used in a loop to iterate through the result set. 

To get data from JDBC: (1) Establish connection: Create a connection to the database using `DriverManager.getConnection()`.
(2) Create a statement: Create a `Statement` or `PreparedStatement` object. This object is used to execute the SQL query.
(3) Execute the Query: execute a SQL query using the `executeQuery()` method of the `Statement` or `PreparedStatement`. This returns a `ResultSet`.
(4) Process the ResultSet: Iterate over the `ResultSet` to retrieve the data returned from the query.
(5) Close the ResultSet and Statement: Once the data is retrieved, close the `ResultSet` and `Statement` to release the resources.
(6) Close the connection: close the connection to the database to free up the resources.
10. ORM framework enable developers to work with database data in a more object-oriented way. Instead of writing SQL queries, developers interact with the database through objects in their programming language. 
12. Serialization is the process of converting an object's state into a format that can be stored or transmitted. The format could be binary, XML, JSON, or another format suitable for storage in a file or transmission over a network. 

Deserialization is the reverse process of serialization. It involves converting the serialized data back into an object. It is necessary when retrieving data from a file, database, ot network, allowing the program to use the object in its original from. 
13. 
```
List<Integer> numbers = Arrays.asList(20, 3, 78, 9, 6, 53, 73, 99, 24, 32);
double average = numbers.stream()
                        .mapToInt(Integer::intValue)
                        .average()
                        .orElse(0.0);
```