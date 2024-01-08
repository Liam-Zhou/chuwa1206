1. (1) `@RestController`  It used to define RESTful Web service. It marked on a class to indicate that the class handles HTTP requests, and each method's return value is automatically serialized to JSON or XML and returned as the HTTP response body. 

Example: 
```
@RestController
public class Mycontroller{
    @GetMapping("/greet")
    public String greet(){
        return "Hello World."
    }
}
```
In this example, The `@GetMapping` annotation on the greet() method indicates it responds to GET requests. 

When accessing the URL like (`/greet`), the string returned by method will sent to back to client directly as the body of the HTTP response. 

(2) `@AutoWire` It is used for automatic dependency injection. Don't need to write getter ans setter anymore.
(3) `@RequestMapping` It is used for mapping a specific request path to the entire controller or method. 
```
@Controller
@RequestMapping("/users")
public class UserController {

    @RequestMapping(value = "/{userId}", method = RequestMethod.GET)
    public String getUser(@PathVariable String userId) {
        // Handle the request to get a user
    }

    @RequestMapping(value = "/{userId}/posts", method = RequestMethod.POST)
    public String addUserPost(@PathVariable String userId) {
        // Handle the request to add a user post
    }
}

```
(4) @PostMapping It is used to mapping HTTP POST requests to specific handler method.
```
@RestController
public class MyController {

    @PostMapping("/register")
    public String registerUser(@RequestBody User user) {
        // Handle user registration
    }
}
```
(5) `@Entity` It is used to map a regular Java class to a table in database. `@Table` is used to map to a specific table in the database. 
`@Id` indicates that the `id` filed is the primary key of the entity. 
```
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;
```
`@GeneratedValue` can generate ID automatically. 
``` 
@Column(name = "title", nullable = false)
private String title;
```
which can map to a column named `tittle` and cannot be a null value. 
`@CreationTimestamp` and `@UpdateTimestamp` can automatically sets the entity's creation time and update time. 
```
    @CreationTimestamp
    private LocalDateTime createDateTime;

    @UpdateTimestamp
    private LocalDateTime updateDateTime;
```
(6) `@Service` It is used to mark service layer classes. It indicated that the class is a service class,which used for writing business logic.
(7) `@SpringBootApplication` is entrance of SpringBoot Application. 
