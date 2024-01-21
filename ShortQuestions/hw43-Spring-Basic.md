# 2. What is Spring and Springboot? What are the benefits of using Srpingboot?

Spring is a framework for building Java-based enterprise applications. Spring Boot is an extension of the Spring framework that simplifies the process of building production-ready applications. Benefits of Spring Boot include rapid development, easy configuration, and a convention-over-configuration approach

# 3. What is IOC and What is DI?

IOC (Inversion of Control) is a design pattern where the control flow of a program is inverted. DI (Dependency Injection) is a specific type of IOC where dependencies are injected into a class rather than the class creating its dependencies

# 4. What is @CompnonentScan?

@ComponentScan is used to specify the base packages for scanning components in a Spring application

# 5. How to define which package spring needs to scan in XML and annotation?

In XML configuration, you can use the <context:component-scan> element. In annotation-based configuration, you can use @ComponentScan on a configuration class

# 6. What is @SpringbootApplication?

@SpringBootApplication is a meta-annotation that combines @Configuration, @EnableAutoConfiguration, and @ComponentScan. It is commonly used to mark the main class of a Spring Boot application

# 7. How many ways we can define a bean? What is the default bean name for @Component and @Bean?

Beans can be defined in XML, Java Config, and through annotations. The three ways are XML configuration, Java-based configuration, and Component scanning.

The default bean name for @Component is the uncapitalized class name. For @Bean, the default name is the method name.

# 8. What is the difference between @component and @service,@repository? How many annotations we can use to inject the bean?

@Component is a generic stereotype annotation, while @Service and @Repository are specializations of @Component for specific purposes. They are interchangeable, but using them conveys the intended role of the bean.

Annotations like @Autowired, @Resource, and @Inject can be used to inject beans.

# 9. Tell me the three types to do dependency injection(How can we inject the beans in Spring)? Which way is better and why?

Three types of dependency injection are constructor injection, setter injection, and method injection. Constructor injection is often considered better as it ensures that the object is in a valid state after construction.

# 10. If we have multiple beans for one type, how to set one as primary? and how to let the spring to pick one bean to inject if no primary.

To set a bean as primary, use the @Primary annotation. If no primary is set, Spring will use the bean with the highest priority (order value) when multiple candidates are available.

# 11. What is the difference between BeanFactory and ApplicationContext in Spring?

BeanFactory is the basic container that provides the fundamental functionality. ApplicationContext is a more advanced container that includes additional features like event propagation, AOP support, and more.

# 12. What is the Scope of a Bean? and list the examples for each scope.

The scope of a bean defines its lifecycle. Examples include singleton (default), prototype, request, session, and global session.

# 13. Configure a bean using XML. If a bean has parameters/dependencies, how can we configure the bean?

To configure a bean using XML, use the <bean> element. For beans with parameters, use the constructor-arg element to provide dependencies.
