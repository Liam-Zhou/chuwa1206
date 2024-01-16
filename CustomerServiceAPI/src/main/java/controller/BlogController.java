@RestController
@RequestMapping("/api/blogs")
public class BlogController {

    @GetMapping("v1/blogs")
    public ResponseEntity<List<BlogPost>> getAllBlogPosts() {
        // ...
    }

    @GetMapping("v1/create")
    public ResponseEntity<BlogPost> createBlogPost(@RequestBody BlogPost newPost) {
        // ...
    }

    @GetMapping("v1/blogs/{blogId}")
    public ResponseEntity<BlogPost> getBlogPost(@PathVariable Long blogId) {
        // ...
    }

    @PutMapping("v1/blogs/{blogId}")
    public ResponseEntity<BlogPost> updateBlogPost(@PathVariable Long blogId, @RequestBody BlogPost updatedPost) {
        // ...
    }

    @DeleteMapping("v1/blogs/{blogId}")
    public ResponseEntity<Void> deleteBlogPost(@PathVariable Long blogId) {
        // ...
    }
}