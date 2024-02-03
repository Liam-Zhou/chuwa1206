### 2. What is Spring and Spring Boot? What are the benefits of using Spring Boot?
**Spring** is a comprehensive framework that provides a wide array of features for building Java applications. It offers infrastructure support for developing Java apps, allowing developers to focus on application logic without worrying about the boilerplate code.

**Spring Boot** simplifies the process of developing Spring applications. It provides conventions for project configurations through auto-configuration, eliminating much of the manual configuration required by Spring.

**Benefits of using Spring Boot** include:
- **Auto-configuration**: Automatically configures our application based on the dependencies we have added.
- **Standalone**: Allows applications to run independently without deploying on a web server.
- **Opinionated Defaults**: Offers convention over configuration to reduce developer decision time.
- **Spring Ecosystem Integration**: Seamless integration with Spring-related technologies.

### 3. What is IOC and What is DI?
**IOC (Inversion of Control)** is a principle where the control of objects or portions of a program is transferred to a container or framework. It's a design principle in which the flow of control is reversed in comparison to traditional procedural programming.

**DI (Dependency Injection)** is a design pattern that implements IOC, where a class's dependencies are injected into it at runtime rather than the class creating them itself. This allows for more decoupled and testable code.

### 4. What is @ComponentScan?
**@ComponentScan** is an annotation used in Spring to automatically detect and register beans from pre-defined base packages. It scans the classpath for classes annotated with @Component, @Service, @Repository, and @Controller, making them available for DI.

### 5. How to define which package Spring needs to scan in XML and annotation?
In **XML configuration**, we define the base package to scan using the `<context:component-scan base-package="com.example.package"/>` tag.

With **annotations**, we use `@ComponentScan("com.example.package")` to specify the package directly or `@ComponentScan(basePackages = "com.example.package")` to set the base packages to scan.

### 6. What is @SpringBootApplication?
**@SpringBootApplication** is a convenience annotation in Spring Boot that combines @Configuration, @EnableAutoConfiguration, and @ComponentScan with their default attributes.

### 7. How many ways can we define a bean?
Beans can be defined in **three** main ways:
- **Annotation-based configuration**: Using @Component, @Service, @Repository, @Controller, and @Configuration with @Bean methods.
- **Java-based configuration**: Using @Bean in @Configuration annotated classes.
- **XML-based configuration**: Defining beans in an XML file using the `<bean>` tag.

### 8. What is the default bean name for @Component and @Bean?
The default bean name for a component annotated with **@Component** (and derivatives like @Service, @Repository) is the uncapitalized class name. For a method annotated with **@Bean**, the default bean name is the method name.

### 9. What is the difference between @Component and @Service, @Repository?
- **@Component** is a generic stereotype for any Spring-managed component.
- **@Service** annotates classes at the service layer.
- **@Repository** annotates classes at the persistence layer, indicating that the class is a DAO component, providing exception translation.

### 10. How many annotations can we use to inject the bean?
The primary annotations for injecting beans are **@Autowired**, **@Inject** (JSR-330), and **@Resource** (JSR-250).

### 11. Tell me the three types to do dependency injection (How can we inject the beans in Spring)? Which way is better and why?
The three main types of dependency injection in Spring are:
- **Constructor Injection**: Dependencies are provided through a class constructor.
- **Setter Injection**: Dependencies are injected through setter methods.
- **Field Injection**: Dependencies are injected directly into the class fields.

**Constructor Injection** is often considered better because it allows for immutable fields and ensures that a class is always created with its dependencies, facilitating easier testing and more reliable code.

### 12. If we have multiple beans of one type, how to set one as primary? And how to let Spring pick one bean to inject if no primary?
To designate a bean as **primary**, use the `@Primary` annotation on the bean definition. If no primary bean is defined and multiple beans exist, we can use `@Qualifier` annotation to specify which bean to inject.

### 13. What is the difference between BeanFactory and ApplicationContext in Spring?
- **BeanFactory** is the basic container that manages beans. It lazily initializes beans.
- **ApplicationContext** extends BeanFactory, providing additional features like easier integration with Spring's AOP features, message resource handling,

### 14. What is the Scope of a Bean? and list the examples for each scope
Bean scopes define the lifecycle and visibility of a bean within the context. The scopes are:
- **Singleton** Only one instance of the bean is created for the Spring container. This is the default scope.
- **Prototype** A new instance is created each time the bean is requested.
- **Request** A single instance is created for each HTTP request.
- **Session** A single instance is created for each HTTP session.
- **Global Session** A single instance is created for a global HTTP session (typically in a Portlet context).

### 15. Configure a bean using XML. If a bean has parameters/dependencies, how can we configure the bean?
In XML configuration, we define beans inside the <beans> tag in our XML file. We can inject dependencies using <property> or <constructor-arg> tags.
Example for a bean with a constructor dependency:
```java
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
       http://www.springframework.org/schema/beans/spring-beans.xsd">

    <bean id="myBean" class="com.example.MyBean">
        <constructor-arg ref="anotherBean"/>
    </bean>

    <bean id="anotherBean" class="com.example.AnotherBean"/>
</beans>
```
In this example, MyBean has a constructor that requires an instance of AnotherBean. The ref attribute in the <constructor-arg> tag specifies the dependency.