# hw10: hw43-Spring-Basic

### 2. What is Spring and Spring Boot? What are the benefits of using Spring Boot?
Spring is a powerful and versatile framework for building Java applications. It provides a comprehensive infrastructure to support the development of robust Java applications easily and rapidly.

Spring Boot is an extension of the Spring framework that simplifies the initial setup and development of new Spring applications. It provides a range of features like auto-configuration, standalone code, and production-ready configuration to streamline the application development process.

Benefits of using Spring Boot:
- Simplifies dependency management with starter dependencies.
- Automates configuration with auto-configuration feature.
- Provides embedded servers to avoid complex server configuration.
- Offers production-ready features like metrics and health checks.
- Enhances productivity and reduces development time.

### 3. What is IOC and What is DI?
Inversion of Control (IOC) is a principle in software engineering where the control of objects or portions of a program is transferred to a container or framework.

Dependency Injection (DI) is a design pattern that implements IOC. It allows the creation of dependent objects outside of a class and provides those objects to a class in different ways.

### 4. What is @Component Scan?
`@ComponentScan` is an annotation used in Spring Framework. It is used to specify the packages that Spring should scan for annotated components. Spring will register all the components annotated with `@Component`, `@Service`, `@Repository`, and `@Controller` that are present in the specified packages.

### 5. How to define which package spring needs to scan in XML and annotation?
In XML configuration, you define the package to scan using the <context:component-scan> tag and the base-package attribute.
```xml
<context:component-scan base-package="com.example"/>
```
In annotation-based configuration, you use the `@ComponentScan` annotation and specify the base packages as its attribute.
```java
@ComponentScan("com.example")
```

### 6. What is @SpringBootApplication?
`@SpringBootApplication` is a convenience annotation in Spring Boot that encapsulates `@Configuration`, `@EnableAutoConfiguration`, and `@ComponentScan` annotations. It denotes the main class of a Spring Boot application and triggers the auto-configuration and component scanning features.

### 7. How many ways can we define a bean?
Beans can be defined in multiple ways in Spring:
1. Annotation-based configuration: Using annotations like `@Component`, `@Service`, `@Repository`, and `@Controller`.
2. Java-based configuration: Using `@Bean` annotation inside classes annotated with `@Configuration`.
3. XML-based configuration: Defining beans in the Spring XML configuration file.

### 8. What is the default bean name for @Component and @Bean?
The default bean name for an `@Component` annotated class is the uncapitalized simple classname. For the `@Bean` annotated method, the default bean name is the method name.

### 9. What is the difference between @Component, @Service, and @Repository?
`@Component` is a generic stereotype annotation for any Spring-managed component.
`@Service` is a stereotype annotation representing a service provider in the business layer.
`@Repository` is a stereotype annotation representing a repository that encapsulates the storage, retrieval, and search behavior typically from a database.

### 10. How many annotations can we use to inject the bean?
In Spring, you can use several annotations to inject beans, including `@Autowired`, `@Inject`, and `@Resource`.

### 11. Tell me the three types of dependency injection (How can we inject the beans in Spring)? Which way is better and why?
The three types of dependency injection in Spring are:
1. Constructor Injection: Dependencies are provided through a class constructor.
2. Setter Injection: The client exposes a setter method that the injector uses to inject the dependency.
3. Field Injection: The injector injects the dependency directly into the class field.

Constructor Injection is generally considered better as it allows the instance to be created with all its dependencies, ensuring that the object is always in a fully initialized state.

### 12. If we have multiple beans for one type, how to set one as primary? And how to let Spring pick one bean to inject if no primary?
You can use the `@Primary` annotation on one of the beans to designate it as the primary bean. If no `@Primary` bean is found, Spring will consider beans marked with `@Qualifier` annotation.

### 13. What is the difference between BeanFactory and ApplicationContext in Spring?
`BeanFactory` is the root interface for accessing the Spring container. It provides basic functionality for managing beans.
`ApplicationContext` is a sub-interface of `BeanFactory` and adds more enterprise-specific functionality like easier integration with Spring's AOP features, message resource handling for i18n, and event propagation.

### 14. What is the Scope of a Bean? and list the examples for each scope.
The scope of a bean defines the lifecycle of the bean in the Spring Framework.

- singleton: Only one instance of the bean is created and shared across the entire application.
    ```java
    @Bean
    @Scope("singleton")
    public Person personSingleton() {
        return new Person();
    }
    ```

- prototype: A new instance of the bean is created every time it is requested.
    ```java
    @Bean
    @Scope("prototype")
    public Person personPrototype() {
        return new Person();
    }
    ```

- request: A new instance of the bean is created for each HTTP request.
    ```java
    @Bean
    @Scope(value = WebApplicationContext.SCOPE_REQUEST, proxyMode = ScopedProxyMode.TARGET_CLASS)
    public HelloMessageGenerator requestScopedBean() {
        return new HelloMessageGenerator();
    }
    ```
    
    or
    
    ```java
    @Bean
    @RequestScope
    public HelloMessageGenerator requestScopedBean() {
        return new HelloMessageGenerator();
    }
    ```

- session: A single instance of the bean is created for each HTTP session.
    ```java
    @Bean
    @Scope(value = WebApplicationContext.SCOPE_SESSION, proxyMode = ScopedProxyMode.TARGET_CLASS)
    public HelloMessageGenerator sessionScopedBean() {
        return new HelloMessageGenerator();
    }
    ```
    
    or
    
    ```java
    @Bean
    @SessionScope
    public HelloMessageGenerator sessionScopedBean() {
        return new HelloMessageGenerator();
    }
    ```

- application: A single instance of the bean is created for the lifecycle of the application.
    ```java
    @Bean
    @Scope(value = WebApplicationContext.SCOPE_APPLICATION, proxyMode = ScopedProxyMode.TARGET_CLASS)
    public HelloMessageGenerator applicationScopedBean() {
        return new HelloMessageGenerator();
    }
    ```
    
    or
    
    ```java
    @Bean
    @ApplicationScope
    public HelloMessageGenerator applicationScopedBean() {
        return new HelloMessageGenerator();
    }
    ```

- websocket: A single instance of the bean is created for the lifecycle of a WebSocket.
    ```java
    @Bean
    @Scope(scopeName = "websocket", proxyMode = ScopedProxyMode.TARGET_CLASS)
    public HelloMessageGenerator websocketScopedBean() {
        return new HelloMessageGenerator();
    }
    ```

### 15. Configure a bean using xml. If a bean has parameters/dependencies, how can we configure the bean?
You can define beans and their dependencies in XML configuration like this:

Example of a simple bean:
```xml
<beans xmlns="http://www.springframework.org/schema/beans">
    <bean id="app-config" class="com.typesafe.config.Config"/>
</beans>
```

Example of bean configuration with dependencies (Setter Injection):
```xml
<beans xmlns="http://www.springframework.org/schema/beans">

    <bean id="grandmother" class="com.dulaj.stack.Grandmother">
        <property name="father" ref="fatherBean"/>
    </bean>

    <bean id="fatherBean" class="com.dulaj.stack.FatherBean"/>
</beans>
```
