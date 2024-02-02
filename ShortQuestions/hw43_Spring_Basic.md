### HW43 Spring Basic

## Q2 What is Spring and Springboot? What is the benfits of using Srpingboot?

Spring is a popular open-source framework for building Java-based enterprise applications. It provides comprehensive infrastructure support, ensuring easier configuration and integration of your application. Spring is known for its modular and loosely coupled architecture. Spring Boot is built on top of the Spring framework and offers a radically faster and widely accessible getting-started experience for Spring-based applications. It simplifies the process of configuring and deploying Spring applications.

Benefits of using Spring Boot include:

1. **Ease of Development**: Reduces development time and increases productivity by simplifying Spring application setup and configuration.

2. **Microservice Ready**: Ideal for building microservices due to its embedded server and minimal configuration requirements.

3. **Embedded Servers:** Spring Boot includes embedded servers (like Tomcat, Jetty, or Undertow), eliminating the need for external server deployment.

4. **Microservices Architecture Support:** Spring Boot is well-suited for building microservices-based applications. It provides features like easy configuration, service discovery, and distributed tracing.

5. **Auto-Configuration:** Spring Boot automatically configures application components based on the project's dependencies, reducing the manual configuration effort.

## Q3 What is IOC and What is DI?

**IOC (Inversion of Control):**

Inversion of Control (IoC) is a design principle in software development where the control flow of a program is inverted or flipped. In traditional programming, the application code is in charge of the flow of the application. In IoC, this control is inverted; the framework calls the application code. IoC helps in decoupling the execution of a task from the implementation, increasing modularity and promoting flexibility and maintainability.
In the context of the Spring framework, IoC is implemented through Dependency Injection (DI).

**Dependency Injection (DI):**

Dependency Injection is a design pattern and a core feature of the IoC principle. DI allows for dependencies of an object (like services or components it relies on) to be provided ('injected') by an external entity, rather than being created by the object itself.

Dependencies can be injected in several ways - through constructors, setter methods, or directly into fields. By injecting dependencies, the code becomes less coupled and more modular, making it easier to test and maintain.

## Q4 What is @CompnonentScan?

`@ComponentScan` is an annotation used in the Spring Framework, specifically in Spring Boot applications, to automatically detect and register beans in the ApplicationContext. 

When you use `@ComponentScan`, Spring will scan the specified base package (or packages) and its subpackages to discover classes annotated with stereotypes such as `@Component`, `@Service`, `@Repository`, and `@Controller`. These classes are then automatically registered as Spring beans in the application context.

```java
@Configuration
@ComponentScan(basePackages = "com.example.myapp")
public class AppConfig {
    // Configuration beans can be added here
}

```
In this example, Spring will scan the com.example.myapp package for components to register as beans. `@ComponentScan` is particularly useful in large applications with multiple components. It simplifies the configuration by reducing the need for explicit bean definitions for every class and is a key part of Spring's convention over configuration philosophy.

## Q5 How to define which package spring need to scan in xml and annotaiton?

1. Using XML Configuration:

In XML configuration, `<context:component-scan>` specifies the base package(s) for component scanning.
```java
<context:component-scan base-package="com.example"/>

```
2. Using Annotations:

In annotation-based configuration, you can use the `@ComponentScan` annotation on a configuration class to specify the base package(s).

```java
@Configuration
@ComponentScan(basePackages = {"com.package1", "com.package2"})
public class AppConfig {
    //
}

```
## Q6 What is @SpringbootApplication?

`@SpringBootApplication` is a convenience annotation in Spring Boot that combines three commonly used annotations: `@Configuration`, `@EnableAutoConfiguration`, and `@ComponentScan`. It is often placed on the main class of a Spring Boot application to enable a quick setup of a Spring-based application.

```java
@@SpringBootApplication
public class MyApplication {
    public static void main(String[] args) {
        SpringApplication.run(MyApplication.class, args);
    }
}

```

## Q7 How many ways wo can define a bean?
1. **XML Configuration:**
In traditional Spring applications, beans can be defined in XML configuration files using the `<bean>` element.

2. **Annotation-Based Configuration:**

- `@Component`: General-purpose stereotype annotation indicating a Spring-managed component. Specialized versions include `@Service`, `@Repository`, and `@Controller`.
- `@Bean`: Used in `@Configuration` classes. Methods annotated with `@Bean` return an object that should be registered as a bean in the Spring context.


3. **JavaConfig Class Configuration:**
These classes are annotated with @Configuration, and methods are annotated with @Bean to define beans.


4. **Component Scanning:**

- Spring can automatically discover beans to be created in the ApplicationContext by scanning the classpath for classes annotated with `@Component`
- `@ComponentScan` is typically used in a configuration class to specify which packages to scan.
```java
@ComponentScan("com.example")
@Configuration
public class AppConfig {
    // No explicit bean definitions are needed here
}

```

5. **Factory Method:**

- You can define beans using factory methods within a configuration class.
```java
@Configuration
public class AppConfig {
    @Bean
    public MyBean myBean() {
        return createMyBean();
    }

    private MyBean createMyBean() {
        return new MyBean();
    }
}

```
6. **Using @Import:**

- You can import configurations from other classes using `@Import` annotation.
```java
@Configuration
@Import(AnotherConfig.class)
public class AppConfig {
    // Beans defined in AnotherConfig are also registered
}

```

## Q8 What is default bean name for @Component and @Bean?

1. Default Bean Name for `@Component`:

When you use `@Component` on a class, the default bean name is the uncapitalized non-qualified class name. For example, if your class is named MyService, the default bean name will be myService.

2. Default Bean Name for `@Bean`:

When you use `@Bean` on a method within a configuration class, the default bean name is the method name. For example, if your  `@Bean` method is named `myBean`, that's also the name of the bean in the Spring context.


For both `@Component` and `@Bean`, you can also explicitly specify the name using the `name` attribute:
```java
@Component(name = "customName")
public class MyComponent {
    // Class definition
}

```

## Q9 What is the difference between @component and @service,@repository?
**`@Component`:** `@Component` is a generic stereotype for any Spring-managed component. It indicates that the class is a Spring component and is used when a class doesn't fit into more specific categories like `@Service` or `@Repository`.

**`@Service`:** `@Service` is used to annotate classes that belong to the service layer of your application. This layer typically contains business logic, calculations, and call methods in the repository layer.

**`@Repository`:** `@Repository` is used for classes that encapsulate access to the data source. It is specifically meant for DAOs (Data Access Objects) that interact with the database.

## Q10 How many annotaitons we can use to inject the bean?

- **`@Autowired`:** This is the primary and most commonly used annotation for dependency injection in Spring. It can be used on constructors, setters, or fields to inject a bean by type.
```java
@Autowired
private MyDependency myDependency;

```

- **`@Qualifier`:** `@Qualifier` is often used with @Autowired to further qualify the injected bean. It's useful when you have multiple beans of the same type and need to specify which bean should be injected.

```java
@Autowired
@Qualifier("specificBean")
private MyDependency myDependency;

```

- **`@Resource`:** `@Resource` can be a good choice when you need to qualify a bean with a specific name rather than its type. It supports both field and setter injection.
```java
@Resource(name = "specificBean")
private MyDependency myDependency;

```

- **`@Inject`:** `@Inject` is similar to `@Autowired` but is part of the Java Dependency Injection (JSR-330) standard. It supports constructor, field, and method injection.

```java
@Inject
private MyDependency myDependency;

```

- **`@Value`:** `@Value` is used for injecting values from property files or other sources.It can inject values into fields, methods, or constructor parameters.
```java
@Value("${my.property}")
private String myProperty;
```


## Q11 Tell me the three types to do dependency injection(How can we inject the beans in Spring)? Which way is better and why?
There are three common types of dependency injection:
1. **Constructor Injection:** Dependencies are injected through the constructor of the class.
```java
@Component
public class MyService {
    private final MyRepository repository;

    @Autowired
    public MyService(MyRepository repository) {
        this.repository = repository;
    }
}

```
2. **Setter Injection:** Dependencies are injected through setter methods.
```java
@Component
public class MyService {
    private MyRepository repository;

    @Autowired
    public void setRepository(MyRepository repository) {
        this.repository = repository;
    }
}

```
3. **Field Injection:** Dependencies are injected directly into the fields of a class.
```java
@Component
public class MyService {
    @Autowired
    private MyRepository repository;
}

```
- Constructor Injection is generally recommended for most use cases, especially for mandatory dependencies. It promotes immutability, ensuring that the required dependencies are available when the object is created. This approach also makes your classes easier to test, as dependencies can be passed to the constructor in unit tests, and there's no reliance on the Spring container for injecting dependencies.
- Setter Injection is suitable for optional dependencies that can be set or changed after the object has been constructed. It provides flexibility but sacrifices the benefits of immutability.
- Field Injection is the simplest form of injection but considered less ideal due to several drawbacks, such as not being conducive to immutable objects, and it can make unit testing more challenging without using a reflection-based approach like Spring's ReflectionTestUtils.

## Q12 If we have multiple beans for one type, how to set one is primary? and how to let the spring to pick one bean to inject if no primary

- Use the `@Primary` annotation on the bean that should be considered as the primary choice when multiple candidates of the same type exist.
```java
@Component
@Primary
public class PrimaryBean implements MyService {
    // implementation
}

@Component
public class SecondaryBean implements MyService {
    // implementation
}

```

- Use `@Qualifier` when you want to specify exactly which bean should be autowired, bypassing the primary designation.
```java
@Component
public class MyComponent {

    private final MyService myService;

    @Autowired
    public MyComponent(@Qualifier("secondaryBean") MyService myService) {
        this.myService = myService;
    }
}

```

## Q13 What is the difference between BeanFactory and ApplicationContext in Spring?

- BeanFactory
    - Basic Functionality: BeanFactory is the root interface for accessing a Spring bean container. It provides fundamental functionality for managing beans, including retrieving them.

    - Lazy Initialization: By default, beans in a BeanFactory are lazily instantiated. This means that a bean is not created until it is first requested. This can be beneficial for reducing startup time and resource usage.

    - Simplicity: BeanFactory is a simpler and more lightweight interface, suitable for applications where full-fledged Spring functionality is not required.

    - Limited Features: It doesn't support some advanced features like internationalization, event propagation, and AOP functionalities.


- ApplicationContext
    - Advanced Capabilities: ApplicationContext extends BeanFactory and provides more advanced capabilities. It's a complete solution for building enterprise applications.

    - Eager Initialization: By default, all singleton beans in an ApplicationContext are created eagerly during application startup. This ensures all dependencies are available upfront but can increase startup time.

    - Additional Features: ApplicationContext includes everything in BeanFactory and adds more enterprise-specific functionalities like easier integration with Spring's AOP features, message resource handling (for i18n), event propagation, and application-layer specific contexts like WebApplicationContext for web applications.

    - Convenience: ApplicationContext provides more convenient ways to work with Spring's functionalities, like support for different types of property file and XML configurations, annotations, and more.

In most modern Spring applications, ApplicationContext is used because of its comprehensive support for various Spring features. 


## Q14 What is the Scope of a Bean? and list the examples for each scope

**Singleton Scope:**
- The default scope in Spring.
- Only one instance of the bean is created, and it is shared among all requests for that bean.
- The bean is created when the application context is initialized and is destroyed when the context is closed.
```java
@Component
@Scope("singleton")
public class MySingletonBean {
    // Class definition
}
```

**Prototype Scope:**
- A new instance of the bean is created each time it is requested.
- The bean is not shared. It has a one-to-one relationship with the requesting object.
```java
@Scope("prototype")
@Component
public class PrototypeBean {
    // class body
}
```

**Request Scope:**
- A new instance of the bean is created for each HTTP request and is destroyed when the request is completed.
- It is valid only in the context of a web-aware Spring ApplicationContext (e.g., `WebApplicationContext`).
```java
@Component
@Scope("request")
public class MyRequestScopedBean {
    // Class definition
}
```
**Session Scope:**
- A new instance of the bean is created for each HTTP session is destroyed when the session ends.
- Like request scope, it is valid only in the context of a web-aware Spring ApplicationContext.
```java
@Component
@Scope("session")
public class MySessionScopedBean {
    // Class definition
}
```
**Application Scope:**
- A single instance of the bean is created for the entire lifecycle of the application.
- Valid only in the context of a web-aware Spring ApplicationContext.
- Beans are shared at the application level, not limited to a single user or request.
```java
@Component
@Scope("application")
public class MyApplicationScopedBean {
    // Class definition
}
```
**WebSocket Scope:**
- A new instance is created for each WebSocket session.
- Valid only in the context of a web-aware Spring ApplicationContext.

```java
@Component
@Scope("websocket")
public class MyWebSocketScopedBean {
    // Class definition
}
```
## Q15 Configure a bean using xml. If bean has parameters/dependencies, how can we configure the bean?
Suppose you have a MyService class that depends on a MyRepository class:
```java
public class MyService {
    private MyRepository myRepository;

    // Setter for dependency injection
    public void setMyRepository(MyRepository myRepository) {
        this.myRepository = myRepository;
    }

}

public class MyRepository {
    // Repository methods...
}

```

This is the corresponding XML configuration file (e.g., `applicationContext.xml`):
```java
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
                           http://www.springframework.org/schema/beans/spring-beans.xsd">

    <!-- Definition for myRepository bean -->
    <bean id="myRepository" class="com.example.MyRepository"/>

    <!-- Definition for myService bean with dependency injection -->
    <bean id="myService" class="com.example.MyService">
        <property name="myRepository" ref="myRepository"/>
    </bean>

</beans>

```
- `<bean id="myRepository" class="com.example.MyRepository"/>` configures a bean for `myRepository`.
- `<bean id="myService" class="com.example.MyService">` configures a bean for `myService`.
- `<property name="myRepository" ref="myRepository"/>` specifies a constructor argument using constructor injection. It refers to the `myRepository` bean.


You can load the XML configuration and access the beans:
```java
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyApp {
    public static void main(String[] args) {
        // Load the configuration file
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        // Get the bean from the application context
        MyService myService = context.getBean("myService", MyService.class);

        // Use the bean
        // ...
    }
}


```