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

(8) `@OneToMany` is to build a one-to-many relationship between two entities. 
To use is need to write like this:  在这里 one是本class或者本eneity many指的是被修饰的变量
```
@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
private Set<Order> orders; 
在这个代码中，意思是 一个user 有很多的orders，
cascade type all 是指对user的所有操作都会关联到order 
fetch = FetchType.LAZY指的是实际使用关联实体之前，不会加载这些实体适合访问量大或者访问频率低
如果是 fetch = FetchType.EAGER, 表示立即加载所有相关实体。
一般来说@OneToMany是LAZY, @OneToOne和@ManyToOne是EAGER.
```

(9) `@JsonProperty`  is to build mapping to java object and JSON data. It can customize Serialization and Deserialization.

(10) `@JoinColumn` is the connection between two tables. 例如在comment的entity中，对post变量修饰了@ManyToOne，意思是很多comment对应一个post 在post变量上面修饰了 `@JoinColumn(name = "post_id", nullable = false)` 这个的意思就是 comment和post是两个table
但是共用post_id来作为两个table的连接 这个连接也叫做外键。
