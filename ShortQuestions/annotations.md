## Q1

@Entity

marks a class as entity, allowing it to be mapped to a database table
```
@Entity
public class User {
}
```

@Table

specifies the database table name associated with an entity class
```
@Entity
@Table(name = "user_table")
public class User{
}
```
@Id, @GeneratedValue

marks a field as the primary key and specifies its generation strategy
```
@Entity
public class User{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
}
```

-------------------------------------------------------------

@Controller

marks a class as a Spring MVC controller
```
@Controller
public class HomeController{
}
```

@RequestMapping

maps HTTP requests to handler methods in a controller
```
@Controller
public class UserController{
    @RequestMapping("/user")
    public String getUser() {
        // handler method
        return "user";
    }
}
```

@RestController

a specialized version of `@Controller` used for RESTful web services
```
@RestController
public class RestfulController{
    @GetMapping("/api/greet")
    public String greet(){
        // RESTful endpoint
        return "something";
    }
}
```

----------------------------------------------------------------------

@Repository

indicates that an annotated class is a repository, typically for database access
```
@Repository
public interface UserRepository extends JpaRepository<User, Long>{
}
```

-------------------------------------------------------------------

@JsonInclude

specifices which properties of a DTO should be included or excluded during JSON serialization
```
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserDTO{
}
```
--------------------------------------------------------------------

@Service

marks a class as service component in the business layer
```
@Service
public class UserService{
    @Autowired
    private UserRepository userRepository;
}
```

@Transactional

defines the scope of a single database transaction
```
@Service
public class UserService{
    @Autowired
    private UserReporitory userRepository;
    
    @Transactional
    public User saveUser(User user){
        return userRepository.save(user)
    }
}
```

## Q2

`@Column(colummnDefinition = "varchar(255) default 'John Snow'")`
it specifies the details of the database column that corresponds to the annotated field in the entity, in this case, it's a VARCHAR column with a maximumm length of 255 characters and a default value of 'John Snow'

`@Column(name = "STUDENT_NAME", length = 50, nullable = false, unique = false)`
it provides additional details about the mapping of the annotated field to the database column.
In this case, 
`name` specifies the name of the database column, is `STUDENT_NAME`, 
`length` defines the max length of the column for string-based fields, 
`nullable` indicates whether the column is allowed to contain null values,
`unique` specifies whether the column values must be unique across all rows int the table

## Q3
- firstName
- operatingSystem

## Q4
- Controller Layer
  - it's responsible for handling incoming HTTP requests, processing them, and returning appropriate responses.
- Service Layer
  - it contains business logic and serves as an intermediary btwn the controller and the data access layer
- Repository Layer
  - it is responsible for interacting with the database or any other data store, it is commonly used to simplify data access through repositories
- Entity Layer
  - it represents the domain model of the application, it includes POJOs that map to database tables
- DTO Layer
  - it is used to transfer data btwn different layers of the application, especially btwn the service layer and the controller layer
- Security Layer
  - it is responsible for securing the application. it invovles configuring authentication and authorization mechanisms, defining security rules, and protecting endpoints

## Q5
- Client
  - send the http request to the specified endpoint with the required headers, parameter, and body
- Controller Layer
  - it receives the incoming request, and processes the request and extracts necessary information. It calls the appropriate method in the service layer to handle the business logic
- Service Layer
  - it contains the business logic of the application. It performs validations, executes business rules, and coordinates the interaction btwn multiple repositories or services
- Repository Layer
  - it interacts with the repository layer to perform database operations, and is responsible for translating high-level service operations into database queries
- Entity Layer
  - it represents the domain model and provides a mapping btwn Java objects and database tables, and define the structure of the data
- DTO Layer
  - data may be transferred btwn the controller and service layer using DTOs. They provide a clean and standardized way to exchange data and decouple the internal representation from the external one

## Q6
`application.properties` and `application.yml` provide a convenient way to exernalize configuration and make the application more flexible and adaptable to different environment. `application.yml` is often preferred for more complex configurations due to its readability and conciseness


![redbook successful](/Users/yuantingsun/Desktop/redbook.png)