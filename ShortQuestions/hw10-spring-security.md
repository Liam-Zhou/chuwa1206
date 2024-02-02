2. **What is authentication?**  
   Authentication verifies the identity of a user or device. It's a process that ensures the entity requesting access is who they claim to be, typically through passwords, biometrics, or other means.

   ```java
   import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
   
   // In-memory authentication example
   @Override
   protected void configure(AuthenticationManagerBuilder auth) throws Exception {
       auth.inMemoryAuthentication()
           .withUser("user").password("{noop}password").roles("USER");
   }
   
   ```

   

3. **What is authorization?**  
   Authorization is the process that determines what resources a user can access and what operations they can perform. It comes after authentication and manages permissions within systems to secure sensitive data or functions.

   ```java
   import org.springframework.security.config.annotation.web.builders.HttpSecurity;
   
   // Configure method to restrict access based on roles
   @Override
   protected void configure(HttpSecurity http) throws Exception {
       http.authorizeRequests()
           .antMatchers("/admin/**").hasRole("ADMIN")
           .anyRequest().authenticated();
   }
   
   ```

   

4. **What is the difference between authentication and authorization?**  
   Authentication identifies and verifies a user's identity, while authorization determines the user's permissions and what they can access or do within a system.

   

5. **What is HTTP Session?**  
   An HTTP Session is a server-side storage of information that is maintained across multiple requests from the same user. It allows web applications to store user-specific data like user preferences or login status.

   

6. **What is Cookie?**  
   A Cookie is a small piece of data sent from a website and stored on the user's computer by the user's web browser while the user is browsing, used to remember information about the user for the duration of the web session or for future visits.

   

7. **What is the difference between Session and Cookie?**  
   The main difference lies in storage location and security. Sessions store data on the server side, offering more security, while cookies store data on the client side, making them easier to access and manipulate.

   

8. **How do we use session and cookie to keep user information across the application?**  
   Sessions and cookies are used to maintain user state and preferences across multiple pages of an application by storing user data like login credentials, shopping cart contents, or user preferences.

   

9. **What is JWT?**  
   JWT (JSON Web Tokens) is a compact, URL-safe means of representing claims to be transferred between two parties, allowing secure transmission of information as a JSON object.

   ```java
   import io.jsonwebtoken.Jwts;
   import io.jsonwebtoken.SignatureAlgorithm;
   
   // Example method to generate a JWT
   public String generateToken(Authentication authentication) {
       return Jwts.builder()
           .setSubject(authentication.getName())
           .signWith(SignatureAlgorithm.HS512, "SecretKey")
           .compact();
   }
   
   ```

   

10. **What is the spring security filter?**  
    Spring Security filter is a component that intercepts HTTP requests to apply security constraints. It's part of the Spring Security framework for authenticating and authorizing user access.

    

11. **Describe how do JWT work.**  
    JWT works by encoding JSON objects, containing claims about an entity, which are securely transmitted between parties as a token. It ensures data integrity and can optionally provide encryption.

    

12. **Do you use any Encoder to encode Password?**  
      Yes, using an encoder like BCryptPasswordEncoder in Spring Security helps hash passwords before storing them, enhancing security by making the original password difficult to recover.

    

13. **What is UserDetailService? AuthenticationProvider? AuthenticationManager? AuthenticationFilter?**  
      These components are part of Spring Security's authentication process. UserDetailsService loads user-specific data, AuthenticationProvider authenticates a user, AuthenticationManager manages authentication, and AuthenticationFilter filters requests for authentication.

    

14. **What is the disadvantage of Session? How to overcome the disadvantage?**  
      Sessions can increase server memory load and affect scalability. Overcome this by using token-based authentication, like JWT, which reduces server load by storing the session state on the client side.

    ```json
    {
      "sub": "12345",
      "name": "John Doe",
      "role": "admin",
      "permissions": ["read", "write", "delete"],
      "email": "john.doe@example.com",
      "exp": 1300819380,
      "preferences": {
        "theme": "dark",
        "language": "en"
      }
    }
    
    ```

    

15. **How to get value from application.properties?**  
      Use the `@Value` annotation or the `Environment` class in Spring to inject property values from `application.properties` into application components.

    ```java
    import org.springframework.beans.factory.annotation.Value;
    
    public class MyService {
        @Value("${my.property}")
        private String myProperty;
    }
    
    ```

    

16. **What is the role of configure(HttpSecurity http) and configure(AuthenticationManagerBuilder auth)?**  
      `configure(HttpSecurity)` defines security configurations for HTTP requests, while `configure(AuthenticationManagerBuilder)` sets up authentication mechanisms, specifying how users are loaded and password encoding.

    

17. **What is Spring security authentication and authorization?**  
      Spring Security provides comprehensive security services for Java applications, handling both authentication (verifying user identity) and authorization (granting access to resources based on user permissions).