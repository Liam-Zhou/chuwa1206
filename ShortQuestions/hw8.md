### 2. how to debug
Use postman to test the api, if there is anything wrong, follow the code to check the possible problems.

- 2xx: success
- 4xx: bad request, resource not found
- 5xx: internal failures
### 3. DTO, VO, Payload, DO, model
- DTO: Data Transfer Object, to encapsulate data in a value object that could be transfered over the network.
- VO: Value Object, the object that holds values.
- Payload: contains the actual data being transferred and structured according to the API's specification
- DO:
- model: the entity 
### 4.@JsonProperty("description_yyds") 
To indicate the property name in JSON
### 5. jackson
jackson is a java based library to serialize or map java objects to JSON.
### 6. spring-boot-starter
### 7.  @RequestMapping(value = "/users", method = RequestMethod.POST)
- @RequestMapping(value = "/users", method = RequestMethod.GET)
- @RequestMapping(value = "/users/{id}", method = RequestMethod.PUT)
-  @RequestMapping(value = "/users/{id}", method = RequestMethod.DELETE)
### 8. ResponseEntity
ResponsiEntity represents the whole HTTP response with the status code, headers and body.
We can use it to fully configure the HTTP response.
### 9. ResultSet in jdbc
ResultSet contains all the result got from the database.
- establish a connection
- create a prepared statement or query
- execute the query
- loop through the result set to get the objects
- close the connection
### 10. ORM framework
Object Relational Mapping, to convert the data between relational database and object oriented programing languages.
### 11. ObjectMapper
provides the functionality for reading and writing JSON
### 12. what is the serialization and deserialization
- deserialization: convert the stream of data into objects
- serialization: convert the object into the stream of data
### 13.
Arrays.asList(20,3,78,9,6,53,73,99,24,32).stream().mapToInt(Integer::intValue).average();

