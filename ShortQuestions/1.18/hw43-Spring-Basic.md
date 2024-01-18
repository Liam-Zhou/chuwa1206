# 1
Check `/ShortQuestions/1.8/annotations.md`

# 2
The Spring Framework is a powerful, lightweight, and comprehensive framework for developing Java applications. It provides a wide range of functionalities and features including, but not limited to:
- Dependency Injection / Inversion of Control
- Aspect-Oriented Programming
- Data Access
- MVC framework
- Security
- Testing

Spring Boot is built on top of Spring framework, leveraging Spring's technology and simplifies the boilerplate code required to set up a Spring application. The key features of Spring Boot include:
- Auto-configuration
- Standalone
- Opinionated Defaults
- Production-ready featuers

The benefits of using Spring Boot:
- Ease of development: Avoid boilerplate code, XML configuration, and annotations.
- Simplified configuration.
- Microservice ready
- Easy Dependency Management
- Minimal Code Configuration
- Easy to Understand and use.

# 3
Inversion of Control is a design principle in which the control of object creation , configuration, and lifecycle is transferred from the program itself to a container or framework. It is about inverting the flow of control compared to traditional programming where the custom code calls into reusable libraries. In IoC, the framework calls into the custom code.

Benefits:
- Decoupling
- Flexibility & Modularity
- Lifecycle Management

Dependency Injection is a design pattern used to implement IoC. It allows the creation of dependent object outside of a class and provide those objects to a class in different ways. There are three types of DI, constructor injection, setter injection, field injection.

Benefits:
- Testability
- Loose Coupling
- Easier to understand.

IoC is a broader concept, and DI is a form of IoC. IoC can be implemented in different ways, including DI, event handling, or templating.

# 4
@ComponentScan is an annotation used in Spring framework that instucts the Spring Container to scan for components within specific packages. 

# 5
```
<beans xmlns="url"
       xmlns:xsi="url"
       xmlns:context="url"
       xsi:schemaLocation="urls">
    <context:component-scan base-package="com.myapp.services" />
</beans>
```

`@ComponentScan(basePackages = "com.myapp.services")`

# 6
@SpringBootApplication is a annotation in Spring that encapsulates a collection of features and annotations to simplify the configuration and boostrapping of a Spring application. It includes @EnableAutoConfiguration, @ComponentScan, @Configuration.

# 7
We can define a bean using XML and annotations (@Component, @Service, @Repository, @Controller, @Bean).

# 8
The default bean name for @Component and @Bean is the name of the class with lower case first letter.

# 9
- @Component is a generic stereotype for any Spring-managed component. When you annotate a class with @Component, you're telling Spring that the class is a Spring-managed component, and Spring should consider it for auto-detection when using annotation-based configuration and classpath scanning.
- @Service annotation is a specialization of @Component and is used to indicate that the class provides some business functionalities. It holds the business logic, calculations, and calls methods in the repository layer.
- @Repository is a specialization of @Component. It's used to indicate that the class provides the mechanism for storage, retrieval, search, update, and delete operations on objects.

# 10
@Autowired, @Resource, @Inject

# 11
Constructor Injection, Setter Injection, and field Injection. Constructor Injection because it promotes immutability, explicit dependencies, test friendliness, avoid circular dependencies, compatibility with Java records.

# 12
Annotate one of the bean definitions with @Primary.

If there is no primary, we can use qualifier. If no qualifier is available, Spring will use the field name to match the bean. If no bean matches the name of the field, Spring will throw NoUniqueBeanDefinitionException. It lazily initializes beans.

# 13
BeanFactory is the basic container that provides the fundamental features required for dependency injection. It's a low-level foundation for Spring's IoC container. It manages the configuration and creation of objects (beans). The beans are defined in a configuration source (like XML) and are created upon request.

ApplicationContext is a more advanced container that includes all BeanFactory capabilities and adds more enterprise-specific functionality. It is a complete superset of the BeanFactory. It eagerly initializes singleton beans at startup time. This means that all singleton beans are created when the application context is created, not when they are requested.

# 14
- Singleton (Default Scope) The Spring container creates a single instance of the bean, and all requests for that bean name will return the same object, which is cached. Example: A service that provides utility methods.
- Prototype. Each request for the bean will result in a new instance. In other words, the bean is instantiated each time it is injected or retrieved from the container. Example: Objects that are stateful and not thread-safe, or beans that hold data that is specific to a particular user or processing job.
- Request. Creates a bean instance for each HTTP request. The instance is only available during an individual request. Beans that hold user state during a web request, like a user transaction, shopping cart, or user authentication details.
- Session. Creates a bean instance for an HTTP session. The instance is only available during the lifetime of an HTTP session. Example: User preferences or user-specific data that should be persisted across multiple HTTP requests within the same session.
- Application. Creates a bean instance for the lifecycle of a ServletContext. This is somewhat similar to a singleton scope, but it's scoped to a web application's lifecycle.
Example: Beans that are global or application-wide resources, like configuration data or a cache that should be shared across the application.
- WebSocket. Creates a bean instance for the lifecycle of a WebSocket. This is scoped to a particular WebSocket session. Example: Beans that hold information specific to a WebSocket interaction with a client.

# 15
```
<beans xmlns="url"
       xmlns:xsi="url"
       xsi:schemaLocation="url">

    <bean id="myRepository" class="org.example.MyRepository">
        <property name="repositoryName" value="MyRepo"/>
        <property name="dataSource" ref="dataSource"/>
    </bean>
</beans>

```
