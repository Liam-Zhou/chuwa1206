1. What is the authentication?

   - Authentication is the process of verifying the identity of a user, system, or device to ensure that they are who they claim to be before granting access to a particular resource or service. In simpler terms, it's a way of confirming someone's identity before allowing them to use something, like logging into a website or accessing secure information.

2. What is the authorization?

   - Authorization is the process of determining what actions or resources a user, system, or application is allowed to access or perform after they have been authenticated. In simpler terms, it's about granting permissions and specifying what someone is allowed to do or access once their identity has been confirmed.

3. What is the difference between authentication and authorization?

   - Authentication is about confirming someone's identity (Who are you?), while authorization is about granting or denying access to specific resources or actions based on that identity (What are you allowed to do?). In short, authentication verifies identity, and authorization determines permissions.

4. What is HTTP Session?

   - An HTTP session is a way to track and manage the state of a user's interaction with a website or web application. It allows the server to store information about the user across multiple requests and responses. In simpler terms, it helps a website remember you and your actions, like items in a shopping cart, as you navigate through different pages during your visit.

5. What is Cookie?

   - A cookie is a small piece of data stored on a user's device by a web browser. It is used to remember information about the user, such as login credentials or preferences, to enhance their browsing experience. In simpler terms, cookies are like digital tags that websites use to remember you and your choices for a smoother and more personalized interaction.

6. What is the difference between Session and Cookie?

   - A session is a way to manage user state on the server side, keeping track of information between requests, while a cookie is a small piece of data stored on the user's device by the browser to remember specific information. In short, sessions are server-side, managing user data on the server, while cookies are client-side, storing information on the user's device.

7. How do we use session and cookie to keep user information across the the application?

8. What is JWT?

   - JWT stands for JSON Web Token. It's a compact, self-contained way to transmit information securely between parties as a JSON object. JWTs are commonly used for authentication and authorization purposes in web development. They consist of three parts: a header, a payload, and a signature. The information in a JWT can be verified and trusted, making it a reliable method for transmitting data between parties in a secure and tamper-proof manner.

9. What is the spring security filter?

   - In Spring Security, a filter is a component that processes web requests before they reach the application's endpoints. The Spring Security filter chain is a series of filters that handle various aspects of security, such as authentication and authorization. These filters work together to secure the application by intercepting and processing incoming HTTP requests. Each filter performs a specific security-related task, contributing to the overall protection of the application.

10. decribe how do JWT work

    - JWT, or JSON Web Token, works by encoding information into a compact, self-contained format that can be easily transmitted between parties. Here's a simplified explanation of how JWT works:
      1. **Creation:**
         - A server creates a JWT containing a header, payload, and a signature.
         - The header typically specifies the algorithm used for the signature, while the payload contains the actual data.
      2. **Encoding:**
         - The JWT is encoded into a string, often in Base64 format.
         - The encoded JWT can be sent to the client or other parties in the HTTP header or request payload.
      3. **Transmission:**
         - The client includes the JWT in subsequent requests to the server.
         - This allows the server to recognize and trust the information provided in the JWT.
      4. **Validation:**
         - Upon receiving the JWT, the server decodes it and verifies the signature.
         - If the signature is valid, the server trusts the information in the JWT and uses it for authentication or authorization.

11. Do you use any Encoder to encode Password?

    - BCryptPasswordEncoder
    - Argon2
    - PBKDF2

12. What is UserDetailService? AuthenticationProvider?AuthenticationManager? AuthenticationFilter?

    1. **UserDetailsService:**
       - The `UserDetailsService` interface is used to retrieve user details during authentication.
       - It has a method, `loadUserByUsername`, that returns a `UserDetails` object containing information like username, password, and authorities.
    2. **AuthenticationProvider:**
       - An `AuthenticationProvider` is responsible for authenticating a user.
       - It takes an `Authentication` request, validates the credentials, and returns a fully populated `Authentication` object if successful.
    3. **AuthenticationManager:**
       - The `AuthenticationManager` is a core interface responsible for authenticating an `Authentication` object.
       - It delegates the authentication process to one or more `AuthenticationProvider`s.
    4. **AuthenticationFilter:**
       - An `AuthenticationFilter` is part of the Spring Security filter chain.
       - It intercepts and processes incoming authentication requests.
       - It typically extracts credentials from the request, creates an `Authentication` object, and passes it to the `AuthenticationManager`.

13. What is the disadvantage of Session? how to overcome the disadvantage?

    - By adopting token-based approaches and optimizing session usage, developers can mitigate the scalability issues associated with traditional session management. It allows for more efficient use of resources while maintaining necessary functionality for certain aspects of the application.

14. how to get value from application.properties?

    - **Using @Value Annotation:**

      ```
      javaCopy code
      import org.springframework.beans.factory.annotation.Value;
      import org.springframework.stereotype.Component;
      
      @Component
      public class MyComponent {
          
          @Value("${property.key}")
          private String propertyValue;
      
          public void someMethod() {
              System.out.println("Value from application.properties: " + propertyValue);
          }
      }
      ```

      Replace `"property.key"` with the actual key from your `application.properties` file.

    - **Using Environment Object:**

      ```
      javaCopy code
      import org.springframework.beans.factory.annotation.Autowired;
      import org.springframework.core.env.Environment;
      import org.springframework.stereotype.Component;
      
      @Component
      public class MyComponent {
      
          @Autowired
          private Environment environment;
      
          public void someMethod() {
              String propertyValue = environment.getProperty("property.key");
              System.out.println("Value from application.properties: " + propertyValue);
          }
      }
      ```

    - **Using @ConfigurationProperties Annotation:**

      Define a configuration class:

      ```
      javaCopy code
      import org.springframework.boot.context.properties.ConfigurationProperties;
      import org.springframework.stereotype.Component;
      
      @Component
      @ConfigurationProperties(prefix = "myconfig")
      public class MyConfigProperties {
      
          private String propertyValue;
      
          // getter and setter
      
      }
      ```

      In `application.properties`:

      ```
      propertiesCopy code
      myconfig.propertyValue=value_from_properties
      ```

      Then, inject the configuration class where needed:

      ```
      javaCopy code
      import org.springframework.beans.factory.annotation.Autowired;
      import org.springframework.stereotype.Component;
      
      @Component
      public class MyComponent {
      
          @Autowired
          private MyConfigProperties myConfigProperties;
      
          public void someMethod() {
              String propertyValue = myConfigProperties.getPropertyValue();
              System.out.println("Value from application.properties: " + propertyValue);
          }
      }
      ```

15. What is the role of configure(HttpSecurity http) and configure(AuthenticationManagerBuilder auth)?

    - In a Spring Security configuration class, the `configure(HttpSecurity http)` and `configure(AuthenticationManagerBuilder auth)` methods play essential roles in defining how the application handles security at the HTTP level and how it authenticates users.

16. What is Spring security authentication and authorization?

    - **Spring Security Authentication:** Authentication in Spring Security refers to the process of verifying the identity of a user, ensuring that the user is who they claim to be. It involves collecting and validating credentials, such as usernames and passwords, and granting access to the application if the credentials are valid. Spring Security supports various authentication mechanisms, including form-based authentication, basic authentication, and integration with external authentication providers. The goal is to establish the user's identity before granting access to protected resources.

      Example of configuring in-memory authentication in a Spring Security configuration class:

      ```
      javaCopy code
      @Configuration
      @EnableWebSecurity
      public class SecurityConfig extends WebSecurityConfigurerAdapter {
      
          @Override
          protected void configure(AuthenticationManagerBuilder auth) throws Exception {
              auth
                  .inMemoryAuthentication()
                      .withUser("user").password("{noop}password").roles("USER")
                      .and()
                      .withUser("admin").password("{noop}admin").roles("ADMIN");
          }
      
          // Other security configurations...
      }
      ```

    - **Spring Security Authorization:** Authorization in Spring Security involves determining whether an authenticated user is allowed to access a specific resource or perform a particular action. It defines the permissions and roles associated with users and restricts their access based on these roles. Authorization is typically achieved through the use of access control rules and configurations. Spring Security allows developers to express these rules using expressions, annotations, or configuration, ensuring that only authorized users can perform specific operations.

      Example of configuring authorization rules in a Spring Security configuration class:

      ```
      javaCopy code
      @Configuration
      @EnableWebSecurity
      public class SecurityConfig extends WebSecurityConfigurerAdapter {
      
          @Override
          protected void configure(HttpSecurity http) throws Exception {
              http
                  .authorizeRequests()
                      .antMatchers("/public/**").permitAll()
                      .antMatchers("/admin/**").hasRole("ADMIN")
                      .anyRequest().authenticated()
                      .and()
                  .formLogin()
                      .loginPage("/login")
                      .permitAll()
                      .and()
                  .logout()
                      .permitAll();
          }
      
          // Other security configurations...
      }
      ```

    
