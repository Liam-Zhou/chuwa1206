@ControllerAdvice: This annotation is used to define global exception handling for the entire application. 
use @ExceptionHandler methods within classes annotated with @ControllerAdvice to handle exceptions globally.

@Autowired: This annotation is used to automatically inject dependencies. It can be applied to fields, setter methods, or constructors.
@Qualifier: When multiple beans of the same type are available, @Qualifier is used along with @Autowired to specify the name of the bean to be injected.
@Component: This is a generic stereotype annotation indicating that the class is a Spring component.
@Service, @Repository, @Controller: These are specialized annotations that are used in conjunction with @Component.
@Configuration: Indicates that a class declares one or more @Bean methods and may be processed by the Spring container to generate bean definitions and service requests for those beans at runtime.
@Bean: Used within @Configuration classes to define beans explicitly. The methods annotated with @Bean produce a bean to be managed by the Spring container
@CompnonentScan: Comopnet scanning is a feature that allows Spring to automatically discover and register Spring beans in the
applicatoin context without the need for explicit bean definitions.

