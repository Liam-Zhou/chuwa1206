1. **List all of the new annotations to your annotations.md and explain its role.**


2. **How do you do the debug?**
   - *Describe the debugging process in your context.*

3. **What is DTO VO Payload DO model?**
   - DTO (Data Transfer Object): Used to transfer data between software application subsystems.
   - VO (View Object): Used to display data in the user interface.
   - Payload: Part of transmitted data that is the actual intended message.
   - DO (Data Object): Represents the object from the database.

4. **What is @JsonProperty("description_yyds")?**
   - `@JsonProperty("description_yyds")` is a Jackson annotation used to map a property name in JSON to a different property name in response in Springboot.

5. **Do you know what is Jackson?**
   - Jackson is a high-performance JSON library for Java.

6. **What is spring-boot-starter?**
   - Spring Boot Starters are a set of convenient dependency descriptors you can include in your application.

7. **Do you know @RequestMapping(value = "/users", method = RequestMethod.POST)? Could you list CRUD by this style?**
    `@RequestMapping(value = "/users", method = RequestMethod.POST)` defines a RESTapi endpoint. This is a `POST` request under the path `/users`.
   - Other CRUD operations using @RequestMapping:
     - GET : `@RequestMapping(value = "/users", method = RequestMethod.GET)`
     - UPDATE: `@RequestMapping(value = "/users/{id}", method = RequestMethod.PUT)`
     - Delete: `@RequestMapping(value = "/users/{id}", method = RequestMethod.DELETE)`

8. **What is ResponseEntity? Why do we need it?**
   - ResponseEntity represents the whole HTTP response: 
   ```json
   {
    "HTTPStatus": "String",
    "headers":  "String",
    "responseBody": "String"
   }
  
   ```
   It's used to standardize the HTTP response.

9. **What is ResultSet in JDBC? And describe the flow how to get data using JDBC.**
   - ResultSet is a Java object that is used to retrieve the results of executing SQL queries. The flow involves executing a `preparedStatement` (which contains a SQL query) and iterating over the ResultSet to retrieve data.
   ```java
   String query = "select COF_NAME, SUP_ID, PRICE, SALES, TOTAL from COFFEES";
    try (Statement stmt = con.createStatement()) {
      ResultSet rs = stmt.executeQuery(query);
      while (rs.next()) {
        String coffeeName = rs.getString(1);
        int supplierID = rs.getInt(2);
        float price = rs.getFloat(3);
        int sales = rs.getInt(4);
        int total = rs.getInt(5);
        System.out.println(coffeeName + ", " + supplierID + ", " + price +
                           ", " + sales + ", " + total);
      }
    } catch (SQLException e) {
      JDBCTutorialUtilities.printSQLException(e);
    }
   ```

10. **What is the ORM framework?**
    - ORM (Object-Relational Mapping) is a programming technique for converting data between incompatible type systems using object-oriented programming languages.

11. **Learn how to use ObjectMapper by this example.**


12. **What is serialization and deserialization?**
    - Serialization is the process of converting an object into a stream of bytes to store or transmit it. Deserialization is the reverse process.
    - These are needed to store and transfer complex data structure.

13. **Use stream API to get the average of the array [20, 3, 78, 9, 6, 53, 73, 99, 24, 32].**
```java
   int[] array = {0, 3, 78, 9, 6, 53, 73, 99, 24, 32};
   var result = Arrays.stream(array).average().getAsDouble();
```



