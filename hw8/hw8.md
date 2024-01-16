# 1.  List all of the new annotations to your annotaitons.md and explain its role.
    @Component: allows Spring to detect custom beans automatically, is a spring managed component
    @controller, @service and @Repository: they ared used to indicate the roles of the annotated classes witin the appliation
    @RequestMapping: mapping request to a method or class based on URI pattern
    @Controller: mark a calss as spring MVC controller
    @RestController: a specialization of @controller used in RESTful web service
    It is made up of 2 anotations, @Controller and @responseBody (attach the generated outpu direcly into the body of the Http response)
    @responseBody (attach the generated outpu direcly into the body of the Http response), serialize the object to the response body
    @Autowired: automatic dependency injection 
# 2.  how do you do the debug?
    1. set breakpoints
    2. run in Debug mode
    3. stepping through code
    4. inspect Variables 
    5. resume Execution

# 3.  What is DTO, VO, Payload, DO, model?
    DTO (Data Transfer Object):
    
    A DTO is a data transfer object that encapsulates values to carry data between processes or networks, often between the data access layer and the business logic layer.
    VO (Value Object):
    
    A VO is a special type of object that can hold values such as Integer or Long. They are immutable and are used to model attributes or characteristics of entities.
    Payload:
    
    Payload refers to the actual data transmitted in a communication system. It represents the data part of an HTTP request.
    DO (Domain Object):
    
    A DO encapsulates state and behavior relevant to the business domain and corresponds to a real-world entity.
    Model:
    
    Model is a representation of data and the rules governing the relationships between data in a database.
    UI Model:
    
    A UI model represents the structure and behavior of the user interface.
    

# 4.  What is @JsonProperty("description_yyds") (不会的话，课上问)?
    The @JsonProperty is used to specify the property name in a JSON object when serializing or deserializing a Java object
    using the Jackson library.
    often used when the JSON property name is different from the field naeme in the java object.
# 5. do you know what is jackson? 
    It is java library for handling JSON data. It provides a set of tools for parsing JSON data into java objects 
    and serializin Java objects into JSON format (serialization)

# 6. What is spring-boot-stater?
    In the content of spring-boot, a starter is a pre-configured set of dependencies that are commonly used together in a specific type of applicaiotn.
# 7. do you know  @RequestMapping(value = "/users", method = RequestMethod.POST)  ? could you list CRUD by this style?
    It is commonly used for mapping HTTP requests to controller methods 
    @Controller
    @RequestMapping("/users")
    public class UserController {
        @RequestMapping(method = RequestMethod.POST)
        public String createUser() {
        return "redirect:/users";
        }
    
        @RequestMapping(value = "/{id}", method = RequestMethod.GET)
        public String getUser(@PathVariable Long id, Model model) {
            return "userDetails";
        }
        
        @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
        public String updateUser(@PathVariable Long id) {
            return "redirect:/users";
        }
        
        @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
        public String deleteUser(@PathVariable Long id) {
            return "redirect:/users";
        }
        
        @RequestMapping(method = RequestMethod.GET)
        public String getAllUsers(Model model) {
            return "userList";
        }
    }

# 8. What is ResponseEntity? why do we need it?
    It represents the entire HTTP response, including the status code, headers, ad body. It's often
    used as the return type for methods in Spring MVC controllers 

# 9. What is ResultSet in jdbc? and describe the flow how to get data using JDBC
    in JDBC, it is an interface that provides methods to retrieve and process data retrieved from a relational database
    , usually as a result of executing a SQL query.
    1. load JDBC driver 
    2. establish Database connection 
    3. Create statement 
    4. Execute Query 
    5. Process ResultSet
    6. close resources 
# 10. What is the ORM framework?
    map classes and their relationsips to database tables and thier associations. Each object instance corresonding to a row in
    a table 
# 11. Learn how to use ObjectMapper by this example
    see FoodoutJackson

# 12. What is the serialization and desrialization?
    Serialization: It is process of converting an objec's state into a byte stream or other formats such as JSON
    The result can be stored in a file, sent over a network
    Deserialization: It is the process of reconstructing an object from its seralized form. It involves converting the byte
    stream or serialized data back into an object with the same state 

# 13. use stream api to get the average of the array [20, 3, 78, 9, 6, 53, 73, 99, 24, 32].
    double average = list.stream().mapToInt(Integer::intValue).average().orElse(0.0);