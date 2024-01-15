##### @SpringBootApplication

notify where the application shall start.

```java
@SpringBootApplication
public class Demo1redbookApplication {
	public static void main(String[] args) {
		SpringApplication.run(Demo1redbookApplication.class, args);
	}

}
```

##### @Autowired

Used for automatic dependency injection. It can be applied to fields, constructors, or methods to inject dependencies into your beans.

##### @Controller

marks a class as a Spring MVC controller

```
@Controller
public class HomeController{
}
```

#####  @RequestMapping

maps HTTP requests to handler methods in a controller

```
@Controller
public class UserController{
    @RequestMapping("/user")
    public String getUser() {
        // handler method
        return "user";
    }
}
```

##### @PathVariable

##### @RequestParam

##### @RequestBody

##### @ResponseBody

##### @Entity

marks a class as entity, allowing it to be mapped to a database table

```
@Entity
public class User {
}
```

##### @Table

specifies the database table name associated with an entity class

```
@Entity
@Table(name = "user_table")
public class User{
}
```

##### @column

```java
@Column(columnDefinition = "varchar(255) default 'John Snow'")
```

##### @Document



##### @Id, @GeneratedValue

marks a field as the primary key and specifies its generation strategy

```
@Entity
public class User{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
}
```
