### Three types of annotations:

- General purpose annotation 
    - `@Override`: used to indicate the method override the method in its parent class.
    - `@Deprecated`: used to indicated the method is not recommended to be used.
    - `@SuppressWarnings`: used to ignore all warnings comes from compiler. 
    - `@FunctionalInterface`: indicate the interface can only have one abstract method. Used to implement lambda function.
    

- Meta Annotation (used to annotate custom annotation)
https://blog.csdn.net/Mrs_chens/article/details/90899885
    - `@Target`:
        - `ElementType.TYPE`：能修饰类、接口或枚举类型
        - `ElementType.FIELD`：能修饰成员变量
        - `ElementType.METHOD`：能修饰方法
        - `ElementType.PARAMETER`：能修饰参数
        - `ElementType.CONSTRUCTOR`：能修饰构造器
        - `ElementType.LOCAL_VARIABLE`：能修饰局部变量
        - `ElementType.ANNOTATION_TYPE`：能修饰注解
        - `ElementType.PACKAGE`：能修饰包
    - `@Retention`:
        - `RetentionPolicy.SOURCE`： 注解只在源代码中存在，编译成class之后，就没了。@Override 就是这种注解。
        - `RetentionPolicy.CLASS`： 注解在java文件编程成.class文件后，依然存在，但是运行起来后就没了。@Retention的默认值，即当没有显式指定@Retention的时候，就会是这种类型。
        - `RetentionPolicy.RUNTIME`： 注解在运行起来之后依然存在，程序可以通过反射获取这些信息，自定义注解通常用这种方式
    - `@Inherited`: 
        ```java
        public class DBUtilChild extends DBUtil {}
        JDBCConfig config = DBUtilChild.class.getAnnotation(JDBCConfig.class);
        ```
    - `@Documented`: Allow javadoc to auto generate documentation for the annotated class
    - `@Repeatable`: indicate that an annotation can be used more than once.
        ```java
        @Target(  METHOD )
        @Retention( RetentionPolicy.RUNTIME )
        @Repeatable( FileTypes.class )
        public @interface FileType {
            String value();
        };
    
        @FileType( ".java" )
        @FileType( ".html" )
        public void work(){}
        ```
    
    
## SpringBoot annotation (third party annotation)
### Controller Annotations
1. **@RestController**
   - Marks the class as a controller where every method returns a domain object instead of a view.
   - Example: 
     ```markdown
     @RestController
     public class UserController {
         // Class contents...
     }
     ```

2. **@RequestMapping**
   - Maps HTTP requests to handler methods of MVC and REST controllers.
   - Example: 
     ```markdown
     @RestController
     @RequestMapping("/users")
     public class UserController {
         // Class contents...
     }
     ```

3. **@GetMapping**
   - Annotation for mapping HTTP GET requests onto specific handler methods.
   - Example:
     ```markdown
     @GetMapping("/{id}")
     public User getUserById(@PathVariable Long id) {
         // Method contents...
     }
     ```

4. **@PostMapping**
   - Annotation for mapping HTTP POST requests onto specific handler methods.
   - Example:
     ```markdown
     @PostMapping("/")
     public User addUser(@RequestBody User user) {
         // Method contents...
     }
     ```

5. **@PutMapping**
   - Annotation for mapping HTTP PUT requests onto specific handler methods.
   - Example:
     ```markdown
     @PutMapping("/{id}")
     public User updateUser(@PathVariable Long id, @RequestBody User user) {
         // Method contents...
     }
     ```

6. **@DeleteMapping**
   - Annotation for mapping HTTP DELETE requests onto specific handler methods.
   - Example:
     ```markdown
     @DeleteMapping("/{id}")
     public void deleteUser(@PathVariable Long id) {
         // Method contents...
     }
     ```

7. **@Autowired**
   - Marks a constructor, field, setter method, or config method as to be autowired by Spring's dependency injection facilities.
   - Example:
     ```markdown
     @RestController
     public class UserController {
         @Autowired
         private UserService userService;
         // Other contents...
     }
     ```

8. **@RequestBody**
   - Annotation indicating a method parameter should be bound to the body of the web request.
   - Example:
     ```markdown
     @PostMapping("/")
     public User addUser(@RequestBody User user) {
         // Method contents...
     }
     ```

9. **@PathVariable**
   - Annotation which indicates that a method parameter should be bound to a URI template variable.
   - Example:
     ```markdown
     @GetMapping("/{id}")
     public User getUserById(@PathVariable(name="id") Long id) {
         // Method contents...
     }
     ```

10. **@RequestParam**
    - Annotation which indicates that a method parameter should be bound to a web request parameter.
    - Example:
      ```markdown
      @GetMapping("/search")
      public List<User> searchUsers(@RequestParam String name) {
          // Method contents...
      }
      ```

### DAO (Data Access Object) Annotations
 - Todo

### Entity Annotations
1. **@Entity**
   - Specifies that the class is an entity (i.e., a JPA entity representing a table in a database).
   - Example: 
     ```markdown
     @Entity
     public class Comment {
         // Class contents...
     }
     ```

2. **@Table**
   - Specifies the primary table for the annotated entity.
   - Example:
     ```markdown
     @Entity
     @Table(name = "comments")
     public class Comment {
         // Class contents...
     }
     ```

3. **@Id**
   - Specifies the primary key of an entity.
   - Example:
     ```markdown
     @Entity
     public class Comment {
         @Id
         private Long id;
         // Other fields...
     }
     ```

4. **@GeneratedValue**
   - Provides for the specification of generation strategies for the values of primary keys.
   - Example:
     ```markdown
     @Id
     @GeneratedValue(strategy = GenerationType.AUTO)
     private Long id;
     ```

5. **@JsonProperty**
   - Indicates that a property should be serialized to JSON with a specific name.
   - Example:
     ```markdown
     @JsonProperty("name")
     private String userName;
     ```

6. **@ManyToOne**
   - Defines a many-to-one relationship between two entities.
   - Example:
     ```markdown
     @ManyToOne(fetch = FetchType.LAZY)
     @JoinColumn(name = "post_id", nullable = false)
     private Post post;
     ```

7. **@JoinColumn**
   - Specifies a column for joining an entity association or element collection.
   - Example:
     ```markdown
     @JoinColumn(name = "post_id", nullable = false)
     private Post post;
     ```

8. **@CreationTimestamp**
   - Marks a field as the timestamp when the entity was created.
   - Example:
     ```markdown
     @CreationTimestamp
     private LocalDateTime createdAt;
     ```

9. **@UpdateTimestamp**
   - Marks a field as the timestamp when the entity was last updated.
   - Example:
     ```markdown
     @UpdateTimestamp
     private LocalDateTime updatedAt;
     ```

### Service Annotations
1. **@Service**
   - Marks a Java class as a service class, declaring it as a bean and a candidate for auto-detection when using annotation-based configuration and classpath scanning.
   - Example:
     ```markdown
     @Service
     public class CommentService {
         // Class contents...
     }
     ```

### Payload Annotations
#### Common Validation Annotations
- `@NotNull`: The annotated element must not be `null`.
- `@NotEmpty`: The annotated element must not be `null` and must contain at least one non-whitespace character.
- `@Size(min=, max=)`: The annotated element size must be within the specified boundaries.
- `@Email`: The annotated element must be a well-formed email address.
- `@Min(value)`: The annotated element must be a number greater than or equal to the specified minimum.
- `@Max(value)`: The annotated element must be a number less than or equal to the specified maximum.

### Exception Annotations
1. **@ResponseStatus**
   - Marks a method or exception class with the status code and reason that should be returned.
   - Example:
     ```markdown
     @ResponseStatus(value= HttpStatus.NOT_FOUND, reason = "Resource Not Found")
     public class ResourceNotFoundException extends RuntimeException {
         // Class contents...
     }
     ```

        
    

```markdown
For all annotations, there can be

- Marker Annotations  - without any member: @Overrride
- Single-Valued Annotations - with single member: @SuppressWarnings(”Unchecked”)
- Multi-Valued Annotations - with more than one member
```
