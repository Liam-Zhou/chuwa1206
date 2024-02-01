2. **What is Spring and Spring Boot? What are the benefits of using Spring Boot?**
   - **Spring:** A powerful and flexible framework for building Java applications.
   - **Spring Boot:** Simplifies the setup and development of new Spring applications. It has default configuration for most parts.
   - **Benefits:** Offers rapid application development, easy configuration, and simplifies deployment.

3. **What is IOC and What is DI?**
   - **IOC (Inversion of Control):** A design principle where the control of the lifecycle of objects is transferred to a container or framework.
   - **DI (Dependency Injection):** A pattern where objects receive their dependencies from an external source rather than creating them internally.

4. **What is @ComponentScan?**
   - It's an annotation used in Spring to automatically detect and register beans from pre-defined project packages.

5. **How to define which package Spring needs to scan in XML and annotation?**
   - In XML: Use the `<context:component-scan base-package="..."/>` tag.
   - In Annotation: Use `@ComponentScan` with the package name.

6. **What is @SpringBootApplication?**
    - Spring Boot @SpringBootApplication annotation is  used to mark a configuration class that declares one or more @Bean methods and also triggers auto-configuration and component scanning. It’s same as declaring a class with @Configuration, @EnableAutoConfiguration and @ComponentScan annotations.

7. **How many ways can we define a bean?**
   - Using Annotation (e.g., @Bean)
   - In XML configuration
   - Via Component Scanning

8. **What is the default bean name for @Component and @Bean?**
   - The default bean name is the uncapitalized version of the class name.

9. **What is the difference between @Component, @Service, and @Repository?**
   - @Component: Generic stereotype for any Spring-managed component.
   - @Service: Annotates classes at the service layer.
   - @Repository: Indicates that the class provides mechanisms for storage, retrieval, search, update, and delete operation on objects.

10. **How many annotations can we use to inject the bean?**
    - @Autowired
    - @Inject
    - @Resource

11. **Tell me the three types of dependency injection in Spring. Which way is better and why?**
    - Constructor Injection
    - Setter Injection
    - Field Injection
    - Constructor Injection is generally preferred for mandatory dependencies.

12. **If we have multiple beans of one type, how to set one as primary? And how to let Spring pick one bean to inject if no primary?**
    - Use `@Primary` to denote the primary bean.
    - For selection, use `@Qualifier` annotation to specify which bean to inject.

13. **What is the difference between BeanFactory and ApplicationContext in Spring?**
    - BeanFactory: Basic Spring container, providing basic support for DI.
    - ApplicationContext: Advanced container with more enterprise-specific functionalities.

14. **What is the Scope of a Bean? List the examples for each scope.**
    - Singleton: One instance per Spring Container.
    - Prototype: A new instance for each bean request.
    - Request: One instance per HTTP request.
    - Session: One instance per HTTP session.

15. **Configure a bean using XML. If a bean has parameters/dependencies, how can we configure the bean?**
    - Use `<bean>` tag in XML file.
    - Specify dependencies using `<property>` or `<constructor-arg>` tags.
    - Example:
      ```xml
      <bean id="exampleBean" class="com.example.ExampleBean">
          <property name="dependency" ref="dependencyBean"/>
      </bean>
      ```



