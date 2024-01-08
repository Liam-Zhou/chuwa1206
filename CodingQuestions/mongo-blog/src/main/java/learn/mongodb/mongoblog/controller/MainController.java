package learn.mongodb.mongoblog.controller;

import learn.mongodb.mongoblog.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller // This means that this class is a Controller
@RequestMapping(path="/demo") // This means URL's start with /demo (after Application path)
public class MainController {
    @Autowired // This means to get the bean, which is auto-generated and injected by Spring
    private BlogService blogService;

    @PostMapping(path="/addBlog") // Map ONLY POST Requests
    public @ResponseBody String addNewUser (@RequestParam String author, @RequestParam String content) {
        // @ResponseBody means the returned String is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request
        blogService.saveBlog(author, content);
        return "Saved";
    }
}
