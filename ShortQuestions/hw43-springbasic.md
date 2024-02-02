### Q2
- spring is a robust Java framework for building applications, focusing on Dependency injection and aspect-oriented programming to facilitate good design practices
- springboot is an extension of spring. It simplifies spring application development by offering auto-configuration, embedded server options, and easy dependency management. It's easier and faster
- simplified configuration, embedded servers, auto-configuration, reduced development time, easy dependency management

### Q3
- IOC(Inversion of Control)
  - design principle in software engineering
  - inverts the flow of control in a program
  - framework/container manages the program flow
  - central to spring's functioning
- DI(dependency injection)
  - design pattern implementing IOC
  - objects receive their dependencies from an external source
  - reduces coupling btwn classes
  - central to configuring spring applications

### Q4
it is used to specify the packages(`@Component`, `@Service`, `@Respository`) to scan for annotated components.
it enables automatic detection and registration of beans in Spring container.
it simplifies configuration and reduces manual bean registration

### Q5
- In XML
  - use the `<context:component-scan>`tage
  - specify the base package using the `base-package` attribute
- Annotation
  - use the `@ComponentScan`
  - provide the base package names as arguments
  - also can be used in a class annotated with `@Configuration`

### Q6
it combines three annotations
  - `@Configuration` marks class as source of bean definitions
  - `@EnableAutoConfiguration` enables springboot's auto-configuration
  - `@ComponentScan` scans for components, configurations, services

it used on main application class as entry point for springboot applications

### Q7
- using `@Bean` annotation, method-level annotation
- component scanning, automatically detected and registered, (`@Component`, `@Service`, `@Respository`)
- XML configuration, uses `<bean>` tag
- JavaConfig class, equivalent to XML configuration
- import configuration, `@Import`, combines configurations from different classes

### Q8
- `@Component`
  - class name, camel case format (`MyService` -> `myService`)
- `@Bean`
  - method name (`public MyBean myBean()` -> `myBean`)

### Q9
- `@Component` generic, for any Spring component
- `@Service`, specific to service/business layer
- `@Repository`, specific to data access layer
  - it converts SQL related exceptions to Spring's DataAccessException

### Q10
- `@Autowired`, can be used on field, setter, constructors
- `@Inject`
- `@Resource`, can specify a bean by name
- `@Qualifier`, used with `@Autowired`, specifies which bean to inject when multiple candidates exist

### Q11
- constructor injection, through the class constructor
- setter injection, use setter method
- field injection, directly into fields
- `Constructor Injection`, b/c
  - **immutable dependencies**, once set they cannot be altered
  - **clearer dependencies**, explicitly define required dependencies
  - **easier for unit testing**
  - **avoid partial construction**, prevents the creation of beans in an incomplete state
  - **framework independence**, reduces coupling with the spring

### Q12
- `@Primary` annotation
- if no primary bean
  - `@Qualifier`, use it with `@Autowired`
  - bean naming, by default the bean name is method or class name, use specific bean names to differentiate and specify in `@Autowired`
  - field name as bean name
  - customer qualifiers

### Q13
`ApplicationContext` offers more advanced enterprise features, while `BeanFactory` is a simpler container with basic functionality

### Q14
- **Singleton**, one instance per Spring IoC container
- **Prototype**, new instance each time a bean is requested
- **request**, one instance per HTTP session
- **Application**, one instance per `ServletContext`
- **WebSocket**, one instance per WebSocket

### Q15
- Define the Bean: Using <bean> tag.
- Configure Dependencies: Through <constructor-arg> or <property>.
- Constructor Injection Example: Inject dependencies via constructors.
- Setter Injection Example: Inject dependencies via setters.
- Referencing Other Beans: Use ref attribute for bean references.
- Primitive/String Values: Inject using value attribute.