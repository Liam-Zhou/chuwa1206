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

