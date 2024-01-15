1. List all of the new annotations to your annotaitons.md and explain its role.
2. how do you do the debug?
   we can debug in different ways, we can set break points for the application, or in pratice, we can just simple print out to debug. we can also set logger to debug level by using log4j.

   ```markdown
   <logger name="com.example.myapp" level="debug" />
   ```

3. What is DTO, VO, Payload, DO, model?

   - **DTO (Data Transfer Object):** Used for transferring data between subsystems or layers.
   - **VO (Value Object):** Represents a descriptive aspect of the domain with no conceptual identity.
   - **Payload:** Data transmitted in a request or response in web development.
   - **DO (Domain Object):** Represents a concept within the domain of the application with both data and behavior.
   - **Model:** Represents data and behavior in the application, with the meaning varying based on the context (e.g., MVC pattern, Spring MVC).
4. What is @JsonProperty("description_yyds") (不会的话，课上问)?
   this annotation is provided by jacson libary. it is used for serilization and deserilization(for transport or persistance). in the parentheses (description_yyds), when serilization and deserilization, in the JSON's file's property`description_yyds`will be used instead of `description`.
5. do you know what is jackson?

    ```<dependency>
        <groupId>com.fasterxml.jackson.core</groupId>
        <artifactId>jackson-databind</artifactId>
        <version>2.13.3</version>
        <scope>compile</scope>
        </dependency>
    ```  

    jackson is a libarary used to serilization and deserilization

6. What is spring-boot-stater?
     `a "starter" is a pre-packaged set of dependencies that are commonly used together to simplify the process of configuring and bootstrapping a specific type of application. A starter includes a curated set of dependencies and default configurations for a particular use case.`
    1. what dependecies in the below starter? do you know any starters?

        ```markdown
        <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-web</artifactId>
        </dependency>
        ```

        `spring-boot-starter-web starter`is commonly used for developing web applications using Spring Boot.
        Here is the English translation of the provided list of Spring Boot starters:

   - **spring-boot-starter:**
     - Core Starter for Spring Boot, including auto-configuration support, logging, and YAML.

   - **spring-boot-starter-actuator:**
     - Provides production-ready monitoring and health check features.

   - **spring-boot-starter-activemq:**
     - Enables the use of Apache ActiveMQ for implementing JMS messaging.

   - **spring-boot-starter-amqp:**
     - Enables the use of Spring AMQP and Rabbit MQ for messaging.
   - **spring-boot-starter-cache:**
      - Utilizes Spring Framework's caching support.

   - **spring-boot-starter-data-elasticsearch:**
     - Enables the use of ElasticSearch for search, analytics, and Spring Data ElasticSearch.

   - **spring-boot-starter-data-jpa:**
     - Implements Spring Data JPA using Hibernate.

   - **spring-boot-starter-data-mongodb:**
     - Enables the use of MongoDB, a document-based database, and Spring Data MongoDB.

   - **spring-boot-starter-data-redis:**
     - Utilizes Spring Data Redis and the Jedis client for key-value data storage in Redis.

   - **spring-boot-starter-mail:**
     - Facilitates email sending using Java Mail and Spring Framework's email support.

   - **spring-boot-starter-quartz:**
     - Provides support for the Quartz scheduling framework for cron jobs and tasks.

   - **spring-boot-starter-security:**
     - Adds support for Spring Security.

   - **spring-boot-starter-test:**
     - Facilitates testing of Spring Boot applications, supporting common testing libraries including JUnit, Hamcrest, and Mockito.

   - **spring-boot-starter-thymeleaf:**
     - Enables the use of Thymeleaf template engine for building MVC web applications.

   - **spring-boot-starter-validation:**
   - Implements Java Bean validation using Hibernate Validator.

     - **spring-boot-starter-web:**
       - Enables the use of Spring MVC for building web applications, including RESTful services. Tomcat is the default embedded container.

   - **spring-boot-starter-websocket:**
       - Facilitates WebSocket support in Spring Framework for building WebSocket applications.

7. do you know  @RequestMapping(value = "/users", method = RequestMethod.POST)  ? could you list CRUD by this style?
     - `value` = "/users" means the URL path ("/users").
     - `method` = RequestMethod.POST means it is a post request.
     - ```@RequestMapping(value = "/users", method = RequestMethod.PUT)```
     - ```@RequestMapping(value = "/users/{id}", method = RequestMethod.GET)```
     - ```@RequestMapping(value = "/users/{id}", method = RequestMethod.DELETE)```

8. What is ResponseEntity? why do we need it?

    ```
    new ResponseEntity<>(postResponse, HttpStatus.OK);
    new ResponseEntity<>(postResponse, HttpStatus.CREATED);
    ResponseEntity.ok(postService.getPostById(id));
    ```
    `ResponseEntity` is a class in java spring which is the response re HTTP requests. by using ResponseEntity we can comustomize our reponse, such as http code, headers, and body. it gives us more granular control of the response.
9.  What is ResultSet in jdbc? and describe the flow how to get data using JDBC
    in `jdbc` resultSet is a set of result after querying the database.
    the flows are:
    1. load DB driver
    2. connect the DB
    3. using prepared statement to construct the query
    4. execute query
    5. handling the result
    6. close the nessary connections or resources.
10. What is the ORM framework?
    ORM stands for Obect relational Mapping, it is used to mapping DB tables to java class(POJO).
11. Learn how to use ObjectMapper by this example.
    1. <https://github.com/TAIsRich/chuwa-eij-tutorial/blob/main/02-java-core/src/main/java/com/chuwa/exercise/oa/api/FoodOutletJackson.java>

        ```java
        FoodOutlet foodOutlet = objectMapper.readValue(resBody, FoodOutlet.class);
        String s = objectMapper.writeValueAsString(foodOutlet);
        objectMapper.readTree() // learn how to use it?
        ```
        - `objectMapper` is used for data processing when serilization and deserilization. `objectMapper.readValue(resBody, FoodOutlet.class)` convert resBody to java object in the type of `FoodOutlet`.  `serilization`
        - `objectMapper.writeValueAsString` convert foodOutlet back to string.`deserilization`
        - `objectMapper.readTree()`used to parse a JSON string and create a JsonNode tree structure. JsonNode is a part of the Jackson library and represents a node in the JSON tree. It can be used to navigate and manipulate the JSON structure.
12. What is the serialization and desrialization?
    1. <https://hazelcast.com/glosgsary/serialization/>
    Serialization refers to the process of converting an object into a byte stream, allowing the storage of the object or transmission of the object to memory, a database, or a file. Its primary purpose is to preserve the state of an object so that it can be recreated when needed. The reverse process is called "deserialization."



13. use stream api to get the average of the array [20, 3, 78,9, 6, 53, 73, 99, 24, 32].

    ```java
    import java.util.Arrays;

    public class ArrayAverage {
        public static void main(String[] args) {
            int[] numbers = {20, 3, 78, 9, 6, 53, 73, 99, 24, 32};

            // Using the Stream API to calculate the average
            double average = Arrays.stream(numbers)
                .average().getAsDouble();
                    
            System.out.println("Average: " + average);
        }
    }
    ```

14. 抄写，<https://github.com/TAIsRich/springboot-redbook/tree/03_post_pageable>，你也可以像我一样分branch添加新代码。
15. 抄写 <https://github.com/TAIsRich/springboot-redbook/tree/04_comment>你也可以像我一样分branch添加新代码。
16. Try to write the CRUD api for a new application Cassandra-Blog
    1. Watch(很重要) <https://www.bilibili.com/video/BV1aQ4y1Z7Nj/>
    2. spring 提供了相关dependency,(<https://start.spring.io/>)
        1. Spring Data for Apache Cassandra
    3. Cassandra十分流行，且面试问的多。
