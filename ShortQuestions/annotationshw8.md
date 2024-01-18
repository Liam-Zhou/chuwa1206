1. @Entity
2. @Table
3. @UniqueConstraint
3. @Id
4. @GeneratedValue
5. @Column
6. @CreationTimestamp
7. @UpdateTimestamp

```
@Entity
@Table(
name = "posts",
uniqueConstraints = {@UniqueConstraint(columnNames = {"title"})}
)
public class Post {
    @Id
    @GeneratedValue(
        strategy = GenerationType.IDENTITY
     )
    private Long id;
    @Column(nullable = false)
    private String title;
    @Column(name = "description", nullable = false)
    private String description;
    @Column(name = "content", nullable = false)
    private String content;
    @CreationTimestamp
    private LocalDateTime createDateTime; 
    @UpdateTimestamp
    private LocalDateTime updateDateTime;
}
```

8. @Repository ```public interface PostRepository extends JpaRepository<Post, Long> {
   // No need to write code
   }```
9. @Service ```@Service
   public class PostServiceImpl implements PostService {```
10. @Override
11. @RestController
12. @RequestMapping

```
@RestController
@RequestMapping("/api/v1/posts")
public class PostController { 
```
13. @Autowired ```@Autowired
    private PostService postService;```
14. @PostMapping
15. @RequestBody
```
@PostMapping
public ResponseEntity<PostDto> createPost(@RequestBody PostDto postDto) {
return new ResponseEntity<>(postService.createPost(postDto), HttpStatus.CREATED);
 }
```

16. @RequestParam: is to bind a web request parameter to a method parameter.
17. @Controller: is used to define a class as a Spring MVC controller.
18. @QueryMapping: binds this method to a query, a field under the Query type. The query field is then determined from the method name. (GraphQL)
19. @Argument: binds a named GraphQL argument onto a method parameter.
20. @ResponseStatus: causes Spring boot to respond with the specified HTTP status code whenever this exception is thrown from your controller.
21. @GetMapping: is used to map HTTP GET requests to specific handler methods in your controller, specifically designed for handling HTTP GET operations.
22. @PutMapping: is used to map HTTP PUT requests to specific handler methods in your controller, specifically designed for handling HTTP PUT operations.
23. @DeleteMapping: is used to map HTTP PUT requests to specific handler methods in your controller, specifically designed for handling HTTP DELETE operations.
