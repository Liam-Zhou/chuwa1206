# 1

List all of the new annotations to your annotaitons.md and explain its role.

## New

1. `@Controller`: This annotation marks a class as a Spring MVC Controller. It's used in Spring Framework to denote a component that handles HTTP requests.
2. `@QueryMapping`: In the context of GraphQL with Spring, this annotation is used to mark a method in a controller as handling GraphQL queries. It maps a specific GraphQL query to a method.
3. `@MutationMapping`: Similar to `@QueryMapping`, but this one is used for GraphQL mutations instead of queries. It maps a GraphQL mutation to a method, typically for operations that create, update, or delete data.
4. `@Argument`: Used in GraphQL within Spring, this annotation marks a method parameter as a GraphQL argument. It specifies that the parameter should be bound to a named argument from the GraphQL query or mutation.

## Old

@Entity`

(Java Persistence API, JPA) 通过使用 `@Entity` 注解，Spring 允许开发者以面向对象的方式来操作数据库，从而简化了数据库编程的复杂性。

### `Table`

(Java Persistence API, JPA) 用于提供实体对应的数据库表的详细信息。这个注解并不是必需的，如果不使用它，JPA 默认使用实体类的名称作为数据库表的名称。但是，如果你想要自定义表的名称或者其他属性，`@Table` 注解就非常有用。

代码演示：

@Table(  
        name = "posts",  
        uniqueConstraints = {  
                @UniqueConstraint(columnNames = {"title"})  
        }  
)

**uniqueConstraints：** 指定表的唯一约束条件。这是用来确保表中的特定列组合是唯一的，例如，不允许有两条记录具有相同的值组合。

### `@Id`和`@GeneratedValue`

`@Id` 注解通常与 `@GeneratedValue` 注解一起使用。`@GeneratedValue` 注解用于自动生成主键的值，减少手动设置主键的工作。而@Id是标记Primary key。

代码演示：

    @Id  
    @GeneratedValue(strategy = GenerationType.IDENTITY)

- `IDENTITY` 策略意味着主键的值将由数据库自动生成，通常是通过自增字段实现的。
  
- 使用 `IDENTITY` 策略，每当向数据库表中插入新记录时，数据库会自动为主键字段生成一个新的唯一值。这个值通常是一个数字，每插入一条新记录，数字就自增。
  

### `@Column`

@Column(name = "title", nullable = false)

- **作用：** `@Column` 注解用于指定实体类属性如何映射到数据库表的列。它可以定义列的名称、是否可以为 null、最大长度等属性。
  
- **非必需：** 如果不使用 `@Column` 注解，JPA 默认会将实体类的属性映射到同名的数据库列。使用 `@Column` 注解是为了提供额外的映射配置。
  

### `@CreationTimestamp`和`@UpdateTimestamp`

`@CreationTimestamp`

- **作用：** 自动设置实体的创建时间。
  
- **应用：** 当实体首次持久化（即保存到数据库）时，`@CreationTimestamp` 会自动将当前的日期和时间赋值给被注解的字段。
  

`@UpdateTimestamp`

- **作用：** 自动更新实体的最后修改时间。
  
- **应用：** 每次实体被更新并保存到数据库时，`@UpdateTimestamp` 会自动将当前的日期和时间赋值给被注解的字段。
  

### `Service`

`@Service` 是一个用于标记服务层组件的注解，是 Spring 框架提供的一部分。在 Spring 的应用程序中，`@Service` 通常被用于标记执行业务逻辑的类。

### `@RestController`

- **直接对话**：通常在网站后端，我们需要一个能直接和用户“对话”的部分。`@RestController` 就是告诉 Spring 框架：“嘿，这个类会直接和用户交流，我们不需要额外的HTML页面，只要把信息直接发给用户就行了。”
  
- **自动转换信息**：比如，当您想告诉网站访问者某些信息时，`@RestController` 能自动把您的信息（比如 Java 里的一个对象或字符串）转换成网页可以理解的格式（比如 JSON），然后发送出去。
  

### `@RequestMapping`

- **指定请求的类型**：您可以指定 `@RequestMapping` 来处理特定类型的请求，比如 GET, POST, PUT, DELETE 等。
  
- **定义请求的路径**：它告诉 Spring 框架，当有人访问特定路径（如 `/hello`）时，应该调用哪个方法。
  
- **处理请求数据**：`@RequestMapping` 还可以处理请求中的数据，比如从网页表单中获取数据。
  

代码演示：

@RequestMapping("/api/v1/posts")

### `@PostMapping`

`@PostMapping` 是 `@RequestMapping(method = RequestMethod.POST)` 的简写。它提供了一种更简洁的方式来处理 POST 请求。

### `@RequestBody`

`@RequestBody` 是 Spring 框架中的一个注解，用于处理 HTTP 请求的正文内容。当您创建一个 RESTful Web 服务时，这个注解非常有用。它告诉 Spring 框架，方法参数应该被绑定到 HTTP 请求体中。我将通过一个简单的例子来解释它的作用。

# 2

how do you do the debug?

 Set breakpoints in the code, then run the application in debug mode. This way, we can step through the code, inspect variables, and analyze the application's flow to troubleshoot issues.



# 3

1. **DTO (Data Transfer Object)**: A DTO is an object used to transfer data between software application subsystems. It's commonly used to transfer data from a client to a server or between different parts of an application. It only carries data and does not contain any business logic.
2. **VO (Value Object)**: A VO represents a simple object with values but no identity. It's used to describe an aspect of the domain with its attributes and behaviors. Unlike DTOs, VOs can contain business logic.
3. **Payload**: In the context of software, the payload is the part of transmitted data that is the actual intended message. It's the core data that needs to be delivered, excluding any headers or metadata.
4. **DO (Domain Object)**: A DO is an object that contains both data and behavior relevant to the business domain. Unlike DTOs and VOs, DOs are more complex and are a central part of the application's business logic.
5. **Model**: In software, a model typically refers to an object that represents data and also contains logic related to the data. In the context of MVC (Model-View-Controller) architecture, the model represents the application's dynamic data structure, independent of the user interface. It directly manages the data, logic, and rules of the application.





# 4

What is @JsonProperty("description_yyds")



`@JsonProperty("description_yyds")` is an annotation used in Java, specifically with the Jackson library, which is a popular JSON processing library. This annotation is used to map a property of a Java object to a specific field in a JSON object.

Here's a breakdown of what it does:

- **@JsonProperty**: This is the annotation used to indicate the name of the property in the JSON.
- **"description_yyds"**: This is the name of the field in the JSON object that the Java object's property will be mapped to.



# 5

do you know what is jackson?

Yes, Jackson is a popular suite of data-processing tools for Java (and the JVM platform), most commonly used for parsing and generating JSON. The snippet you provided is a Maven dependency for `jackson-databind`, which is a part of the Jackson library.





# 6

Spring Boot Starters are a set of convenient dependency descriptors that you can include in your application. Each starter is designed to simplify the Maven or Gradle configuration by including a group of related dependencies together. This makes it easier to set up and manage Spring applications.



# 7

do you know @RequestMapping(value = "/users", method = RequestMethod.POST)? could you list CRUD by this style?

The annotation `@RequestMapping` in Spring Framework is used for mapping web requests to specific handler methods. Below, I'll list the CRUD (Create, Read, Update, Delete) operations in this style:

1. **Create (POST)**
   - Used for creating a new resource.
   - Example: `@RequestMapping(value = "/users", method = RequestMethod.POST)`
2. **Read (GET)**
   - Used for reading or retrieving a resource or a list of resources.
   - Example for getting all users: `@RequestMapping(value = "/users", method = RequestMethod.GET)`
   - Example for getting a specific user by id: `@RequestMapping(value = "/users/{id}", method = RequestMethod.GET)`
3. **Update (PUT or PATCH)**
   - `PUT` is typically used for updating a complete resource.
   - `PATCH` is used for updating partial resources.
   - Example for `PUT`: `@RequestMapping(value = "/users/{id}", method = RequestMethod.PUT)`
   - Example for `PATCH`: `@RequestMapping(value = "/users/{id}", method = RequestMethod.PATCH)`
4. **Delete (DELETE)**
   - Used for deleting a resource.
   - Example: `@RequestMapping(value = "/users/{id}", method = RequestMethod.DELETE)`





# 8 

What is ResponseEntity? why do we need it?

`ResponseEntity` is a type in Spring Framework used for representing the entire HTTP response. It's not just the data (like a model or an object), but the whole response, including status code, headers, and body. 

It's useful for:

- **Full Control**: we can decide everything about the response.
- **Error Handling**: Easily send error messages and status.
- **Consistent API**: Makes our responses predictable and clear.



# 9

What is ResultSet in jdbc? and describe the flow how to get data using JDBC



It is an object that represents the result set of a database query. It's essentially a table of data representing a database result set, which is generated by executing a statement that queries the database.



1. **Load JDBC Driver**: Make sure the JDBC driver for your database is loaded.
2. **Establish Connection**: Connect to your database.
3. **Create Statement**: Make a statement object to run SQL commands.
4. **Execute Query**: Use the statement to execute a SQL query.
5. **Process ResultSet**: Go through the `ResultSet` to get your data.
6. **Close Resources**: Always close your statement and connection afterward.



# 10

What is the ORM framework?



An ORM (Object-Relational Mapping) framework converts data between a database and an object-oriented programming language. It simplifies database interactions by letting you use objects instead of complex SQL queries.



# 11

done



# 12

What is the serialization and desrialization?



Serialization is converting an object into a format that can be saved or transmitted (like JSON or XML). Deserialization is the reverse process, turning that format back into an object.





# 13

done



# 14

done



# 15

done



# 16

Done 
