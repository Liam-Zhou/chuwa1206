### 2. how do you do the debug?

> Set Breakpoints, Run in Debug Mode, Console Output

### 3. What is DTO, VO, Payload, DO, model?

> **DTO (Data Transfer Object):** A DTO is an object that carries data between processes, often used to transfer data between the application's layers
>
> **VO (Value Object):**
>
> - A Value Object is an object that represents a descriptive aspect of the domain with no conceptual identity.
> - Value Objects are often immutable and are used to encapsulate a set of attributes that describe a value. They are typically used within the domain model to model concepts such as money, date range, or other values.
>
> **Payload:**
>
> - In the context of APIs, a payload refers to the data transmitted in a request or response. It includes the actual content of the message, whether it's in the form of JSON, XML, or other data formats.
>
> **DO (Domain Object):**
>
> - A Domain Object represents a concept in the problem domain, usually associated with business entities and logic.
> - Domain Objects encapsulate both data and behavior related to a specific business concept. They are part of the domain model and are used to represent and solve problems within the application's business domain.
>
> **Model:**
>
> - The term "Model" is often used in the context of the Model-View-Controller (MVC) architectural pattern.
> - The Model represents the application's data and business logic. It encompasses the Domain Objects, DTOs, and other objects that represent the application's state.

### 4. What is @JsonProperty("description_yyds") 

>```java
>public class ExampleClass {
>
>    @JsonProperty("description_yyds")
>    private String description;
>
>    // Constructors, getters, setters, etc.
>}
>//In the example above, the description field in the ExampleClass is annotated with @JsonProperty("description_yyds"). This annotation tells the Jackson library to use the specified name ("description_yyds") as the property name when converting the Java object to JSON (serialization) or JSON to Java object (deserialization).
>```

### 5. do you know what is jackson?

>  Jackson is a popular open-source Java library for processing JSON data. It provides functionalities for both reading and writing JSON, making it a versatile tool for handling JSON data in Java applications. 

### 6.  What is spring-boot-stater? 

> `spring-boot-starter` is a naming convention used for these pre-configured sets of dependencies in Spring Boot projects. These starters follow the pattern of naming conventions like `spring-boot-starter-web`, `spring-boot-starter-data-jpa`, `spring-boot-starter-security`, etc.

### 7. do you know @RequestMapping(value = "/users", method = RequestMethod.POST) ? could you list CRUD by this style?

> @RequestMapping(value = "/users", method = RequestMethod.POST)
>
> @RequestMapping(value = "/users/{userId}", method = RequestMethod.GET)
>
> @RequestMapping(value = "/users/{userId}", method = RequestMethod.PUT)
>
> @RequestMapping(value = "/users/{userId}", method = RequestMethod.DELETE) 

### 8. What is ResponseEntity? why do we need it?

> `ResponseEntity` is a class in Spring Framework that represents the entire HTTP response, including status code, headers, and body. 

### 9. What is ResultSet in jdbc? and describe the flow how to get data using JDBC

> a `ResultSet` is a Java object that represents a set of data obtained from a relational database after executing a SQL query. 
>
> FLOW
>
> **Import JDBC Packages** ->  **Load and Register JDBC Driver** -> **Establish a Connection** -> **Create a Statement** -> **Execute SQL Query** -> **Retrieve Data from ResultSet** -> **Close Resources**

### 10. What is the ORM framework?

>  Object-Relational Mapping, is a programming technique that allows developers to interact with a relational database using an object-oriented programming language. The purpose of an ORM framework is to bridge the gap between the relational database model and the object-oriented programming model.

### 11. Learn how to use ObjectMapper by this example

```java
FoodOutlet foodOutlet = objectMapper.readValue(resBody, FoodOutlet.class);
String s = objectMapper.writeValueAsString(foodOutlet);
objectMapper.readTree() // learn how to use it?
  
//The objectMapper.readTree() method is part of the Jackson library, which is commonly used for JSON processing in Java. This method is used to read a JSON string and parse it into a JsonNode object. The JsonNode object allows you to access individual elements of the JSON structure using methods like get(). The asText(), asDouble(), and asInt() methods are used to retrieve values in the desired format.

```

### 12. What is the serialization and desrialization

> Data serialization is the process of converting an object into a stream of bytes to more easily save or transmit it.
>
> The deserialization process recreates the object, thus making the data easier to read and modify as a native structure in a programming language.
>
> Serialization and deserialization work together to transform/recreate data objects to/from a portable format.

### 13. use stream api to get the average of the array [20, 3, 78, 9, 6, 53, 73, 99, 24, 32].

```java
int[] numbers = {20, 3, 78, 9, 6, 53, 73, 99, 24, 32};
double avg = Arrays.stream(numbers).average()
```

