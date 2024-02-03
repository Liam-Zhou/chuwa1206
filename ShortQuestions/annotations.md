
## Annotations Used by Entities

### @Entity
Indicates that a class is an entity. This annotation is applied to the class name.
```java
@Entity
public class ExampleEntity {
    // class body
}
```

### @Id
Marks a field as the primary key of an entity.
```java
@Entity
public class ExampleEntity {
    @Id
    private Long id;
    // other fields and methods
}
```

### @Column
Specifies the mapped column for a persistent property or field. If no Column annotation is specified, the default values apply.
```java
@Entity
public class ExampleEntity {
    @Id
    private Long id;
    
    @Column(name = "example_column", nullable = false)
    private String exampleField;
    // other fields and methods
}
```

## Annotations Used by Controllers

### @Controller
Indicates that a particular class serves the role of a controller.
```java
@Controller
public class ExampleController {
    // class body
}
```

### @RequestMapping
Annotation for mapping web requests onto specific handler classes and/or handler methods.
```java
@Controller
public class ExampleController {
    
    @RequestMapping("/example")
    public String exampleMethod() {
        return "example";
    }
}
```

### @GetMapping
A composed annotation that acts as a shortcut for @RequestMapping(method = RequestMethod.GET).
```java
@Controller
public class ExampleController {
    
    @GetMapping("/example")
    public String exampleGetMethod() {
        return "example";
    }
}
```
