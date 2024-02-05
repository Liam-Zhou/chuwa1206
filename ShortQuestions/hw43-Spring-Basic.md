1.  annotaitons.md has been created.
2.  What is Spring and Springboot? What is the benfits of using Srpingboot?

    Spring Framework: Spring Framework is a comprehensive framework for building Java applications, particularly enterprise applications, following the principles of dependency injection and aspect-oriented programming. It provides a wide range of features and modules for various aspects of application development, including dependency injection, aspect-oriented programming, data access, transaction management, MVC web framework, security, messaging, and more.

    Spring Boot: Spring Boot is an opinionated framework built on top of the Spring Framework, designed to simplify the process of building production-ready, stand-alone Spring-based applications. It provides a convention-over-configuration approach, reducing the need for manual configuration and boilerplate code. Spring Boot auto-configures many components based on sensible defaults and annotations, allowing developers to focus on application logic rather than infrastructure setup. Spring Boot provides a powerful embedded container (e.g., Tomcat, Jetty) that allows you to run Spring applications as stand-alone JAR files, eliminating the need for external application servers.

Benefits of using Spring Boot include:

- Rapid Development
- Convention over Configuration
- Production-Ready Features
- Integration with Spring Ecosystem

3.  What is IOC and What is DI?

    Inversion of Control (IOC): IOC is a design principle where the control of object creation and lifecycle is inverted or moved away from the application code to an external framework or container.

    Dependency Injection (DI): DI is a way to implement IOC, where the dependencies of a component are "injected" or provided to it by an external entity (typically, a DI container or framework) rather than being created or managed by the component itself.

4.  What is `@CompnonentScan`?

    `@ComponentScan` is an annotation provided by the Spring Framework that instructs Spring to scan specified packages for Spring-managed components (e.g. `@Component`, `@Service`, `@Repository`, `@Controller`). It enables Spring to automatically detect and register beans defined in the scanned packages, making them available for dependency injection and other Spring features.

5.  How to define which package spring need to scan in xml and annotaiton?

    In Spring, you can specify which packages the framework should scan for components using either XML configuration or annotation-based configuration.

6.  What is `@SpringbootApplication`?

    `@SpringBootApplication` is an annotation provided by Spring Boot that serves as a convenient shortcut for configuring Spring Boot applications. It combines three commonly used Spring annotations: `@Configuration`, `@EnableAutoConfiguration`, and `@ComponentScan`. It allows simplified configuration and rapid development.

7.  How many ways can define a bean?

    1. XML Configuration

    ```
        <bean id="userService" class="com.example.UserService"/>
    ```

    2. Java Configuration:

    ```
    @Configuration
    public class AppConfig {
        @Bean
        public UserService userService() {
            return new UserService();
        }
    }
    ```

8.  What is default bean name for `@Component` and `@Bean`?

- @Component: The default bean name is derived from the simple class name of the annotated class, with the first letter converted to lowercase.
- @Bean: The default bean name is the same as the name of the method.

9.  What is the difference between `@component` and `@service`, `@repository`?

    1. @Component: It is a generic stereotype annotation used to denote any Spring-managed component.
    2. @Service: It is a specialization of the @Component annotation and is used to denote service layer components in the application.
    3. @Repository: It is a specialization of the @Component annotation and is used to denote repository layer components in the application.

    While @Component, @Service, and @Repository are all used to denote Spring-managed components, they serve different purposes and convey specific semantics about the role and responsibilities of the annotated classes in the application. It's a best practice to use these annotations appropriately to ensure clarity and maintainability in your Spring application architecture.

10. How many annotaitons we can use to inject the bean?

    1. @Autowired
    2. @Inject
    3. @Resource

11. Tell me the three types to do dependency injection(How can we inject the beans in Spring)? Which way is better and why?

    1. Constructor Injection
    2. Setter Injection
    3. Field Injection

    Typically, Constructor Injection is better beacause:

    1. Immutability: Constructor injection allows you to create immutable objects while field injection cannot provide immutability, as it requires setting dependencies after the object is created.
    2. Explicit Dependencies: Constructor injection requires all dependencies to be explicitly declared in the constructor. In contrast, field injection may lead to dependencies being unsatisfied at runtime, as they might be less obvious in the class definition.
    3. Test-Friendliness: Constructor injection makes it easier to provide alternative implementations (e.g., using test doubles) in unit tests. In contrast, field injection might require using reflection or other methods to change private fields, which can make test code more complex.

12. If we have multiple beans for one type, how to set one is primary? And how to let the spring to pick one bean to inject if no primay.

    When you have multiple beans of the same type and you want to specify one of them as the primary bean, you can use the `@Primary` annotation. The @Primary annotation indicates that a particular bean should be given precedence when multiple beans of the same type are candidates for autowiring.

    If there is no primary bean specified for a particular type, Spring will attempt to resolve the dependency by considering other candidate beans of the same type. If there is only one candidate bean, Spring will inject it by default. If there are multiple candidate beans but none of them is marked as primary, Spring will raise an error indicating ambiguity, unless you specify a default by using the @Qualifier annotation or by specifying the bean name.

13. What is the difference between BeanFactory and ApplicationContext in Spring?

    Both `BeanFactory` and `ApplicationContext` serve as containers for managing beans and dependencies in Spring applications, `ApplicationContext` offers more features and capabilities, including eager initialization of singleton beans, support for internationalization, event propagation, resource loading, AOP, and various configuration mechanisms. `BeanFactory` provides basic functionality for managing beans and is suitable for resource-constrained environments or applications with minimal requirements.

14. What is the Scope of a Bean? And list the examples for each scope.

    Singleton Scope:

    ```
    @Component
    public class MySingletonBean {
        // Bean definition
    }
    ```

    Prototype Scope:

    ```
    @Component
    @Scope("prototype")
    public class MyPrototypeBean {
        // Bean definition
    }
    ```

    Request Scope:

    ```
    @Component
    @Scope("request")
    public class MyRequestScopedBean {
        // Bean definition
    }
    ```

    Session Scope:

    ```
    @Component
    @Scope("session")
    public class MySessionScopedBean {
        // Bean definition
    }
    ```

    Application Scope:

    ```
    @Component
    @Scope("application")
    public class MyApplicationScopedBean {
        // Bean definition
    }
    ```

15. Configure a bean using xml. If bean has parameters/dependencies, how can we configure the bean?

- Constructor Injection:

  ```
  @Component
    public class MyBean {
        private Dependency dependency;

        public MyBean(Dependency dependency) {
            this.dependency = dependency;
        }

        // Other methods
    }
  ```

- Setter Injection:

  ```
  @Component
  public class MyBean {
      private Dependency dependency;

      public void setDependency(Dependency dependency) {
          this.dependency = dependency;
      }

      // Other methods
  }

  ```

- Field Injection:

  ```
  @Component
  public class MyBean {
      @Autowired
      private Dependency dependency;

      // Other methods
  }
  ```
