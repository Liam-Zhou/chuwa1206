1. @Controller
   Description: Marks a class as a Spring MVC controller.

       @Controller
       public class MyController {
       // Controller methods
       }
2. @Service
   Description: Indicates that a class is a service, typically used for business logic.

       @Service
       public class MyService {
       // Service methods
       }

3. Marks a class as a Spring Data repository, used for database access.

       @Repository
       public class UserRepository {
       // Repository methods
       }

4. @Autowired, Injects a bean into a class, typically used for dependency injection.

   @Service
   public class MyService {
   private final UserRepository userRepository;

   @Autowired
   public MyService(UserRepository userRepository) {
   this.userRepository = userRepository;
   }
   }

5. @Component
   @Component
   public class MyComponent {
   // Component methods
   }

6. @RestController
   Combines @Controller and @ResponseBody, used for RESTful APIs.

    @RestController
    @RequestMapping("/api")
    public class MyRestController {
    // RESTful API methods
    }

7. @RequestMapping
   Maps HTTP requests to handler methods in a controller

   @Controller
   @RequestMapping("/example")
   public class MyController {

   @RequestMapping("/endpoint")
   public String handleRequest() {
   return "examplePage";
   }
   }

8. @PathVariable

   @Controller
   @RequestMapping("/example")
   public class MyController {

   @RequestMapping("/user/{id}")
   public String getUser(@PathVariable Long id) {
   // Retrieve user by id
   return "userDetailsPage";
   }
   }

9. @RequestBody

   @RestController
   @RequestMapping("/api")
   public class MyRestController {

   @PostMapping("/create")
   public ResponseEntity<String> create(@RequestBody MyObject myObject) {
   // Process and create
   return ResponseEntity.ok("Object created successfully");
   }
   }

