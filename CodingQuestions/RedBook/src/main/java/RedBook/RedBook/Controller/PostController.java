package RedBook.RedBook.Controller;

import RedBook.RedBook.Entity.Post;
import RedBook.RedBook.Service.PostService;
import RedBook.RedBook.payload.PostDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.http.HttpResponse;
import java.util.List;

@RestController
@RequestMapping("/api/v1/posts")
public class PostController {

    @Autowired
    PostService postService;
    public PostController(PostService postService){

        this.postService = postService;
    }

    @PostMapping
    public ResponseEntity<PostDTO>posts(@RequestBody PostDTO postDTO){

        return ResponseEntity.ok(postService.savePosts(postDTO));
    }

    @GetMapping
    public List<PostDTO>getAll(){

        return postService.getAll();
    }
//    @ExceptionHandler(value = NoClassDefFoundError.class)
    @PutMapping("/{id}")
    public ResponseEntity<PostDTO>updateById(@PathVariable long id, @RequestBody PostDTO postDTO){

        return ResponseEntity.ok(postService.updateById(id,postDTO));
    }



}
