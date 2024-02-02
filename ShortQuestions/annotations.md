# 1. @ComponentScan:

Summary: Used to specify the base packages to scan for Spring-managed components (beans).

```
@Configuration
@ComponentScan(basePackages = "com.example")
public class AppConfig {
// Configuration class content
}
```

# 2. @Autowired:

Summary: Used to automatically inject a dependency by type.

```
@Component
public class UserService {
private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

}
```

# 3. @RestController:

Summary: Combination of @Controller and @ResponseBody, used to create RESTful controllers.

```
@RestController
@RequestMapping("/api")
public class ApiController {
@GetMapping("/hello")
public String hello() {
    return "Hello, World!";
}

}
```

# 4. @RequestMapping:

Summary: Maps HTTP requests to handler methods in a controller.

```
@Controller
@RequestMapping("/example")
public class ExampleController {
@GetMapping("/greet")
    public String greet() {
        return "Greetings!";
    }
}

```

# 5. @Service:

Summary: Indicates that a class is a service, typically used in the service layer.

```
@Service
public class UserService {
// Service methods
}
```

# 6. @Repository:

Summary: Indicates that a class is a Data Access Object (DAO) and should be treated as a bean.

```
@Repository
public class UserRepository {
// Data access methods
}
```

# 7. @Configuration:

Summary: Indicates that a class declares one or more @Bean methods.

```
@Configuration
public class AppConfig {
    @Bean
    public SomeBean someBean() {
        return new SomeBean();
    }
}
```

# 8. @Component:

Summary: Indicates that a class is a Spring bean and should be managed by the Spring container.

```
@Component
public class MyComponent {
    // Class content
}
```

# 9. @Value:

Summary: Used to inject values from properties files into a Spring bean.

```
@Component
public class MyComponent {
    @Value("${my.property}")
    private String myProperty;
}
```

# 10. @Qualifier:

Summary: Used along with @Autowired to specify which bean to inject when multiple beans of the same type exist.

```
@Component
public class MyService {
    @Autowired
    @Qualifier("specificBean")
    private MyInterface myBean;
}
```

# 11. @Scope:

Summary: Specifies the scope of a Spring bean (e.g., singleton, prototype).

```
@Component
@Scope("prototype")
public class MyPrototypeBean {
    // Class content
}
```

# 12. @ResponseBody:

Summary: Indicates that the return value of a method should be serialized directly to the response body in a web application.

```
@RestController
public class MyController {
    @GetMapping("/data")
    @ResponseBody
    public MyData getData() {
        // Return MyData object
    }
}
```

# 13. @PathVariable:

Summary: Used to extract values from URI templates in Spring MVC.

```
@RestController
@RequestMapping("/api")
public class MyController {
    @GetMapping("/user/{id}")
    public String getUser(@PathVariable Long id) {
        // Retrieve user with specified ID
    }
}
```
