## 2.What is authentication?
Authentication is the process of verifying the identity of a user or entity. In the context of a system or application, it involves confirming that someone is who they claim to be, typically through credentials like usernames and passwords.

## 3. What is authorization?
Authorization is the process of granting an authenticated user permission to access specific resources or functions. It determines what users can and cannot do within a system after their identity has been verified.

## 4. What is the difference between authentication and authorization?
Authentication verifies a user's identity to ensure they are who they claim to be, while authorization determines the resources and operations a user is permitted to access or perform after being authenticated.

## 5. What is HTTP Session?
An HTTP Session is a server-side mechanism that maintains state between HTTP requests. It allows web applications to store user-specific information (like user preferences or data) across multiple requests from the same user.

## 6. What is Cookie?
A cookie is a small piece of data sent from a website and stored on the user's computer by the user's web browser while the user is browsing. Cookies are designed to be a reliable mechanism for websites to remember stateful information (such as items added in the shopping cart) or to record the user's browsing activity.

## 7. What is the difference between Session and Cookie?
Sessions are stored on the server side and maintain data across multiple requests from the same user. Cookies are stored on the client side and send data back to the server with each request. Sessions use cookies as a means to identify session instances across requests.

## 8. How do we use session and cookie to keep user information across the application?
Sessions can store user information on the server, which is referenced by a session ID. This ID is stored in a cookie on the user's browser and sent to the server with each request, allowing the server to retrieve user-specific information. Cookies can also directly store small amounts of data on the client's browser for persistence across visits to the site.

## 9. What is JWT?
JWT (JSON Web Token) is a compact, URL-safe means of representing claims to be transferred between two parties. It is used in authentication and information exchange, where its compact structure makes it suitable for passing information in HTTP headers or URL parameters.

## 10. What is the spring security filter?
A Spring Security filter is part of the Spring Security framework that intercepts requests to a web application to enforce security measures. It's responsible for tasks such as authentication, authorization, and ensuring the integrity of security contexts across requests. Filters are configured in a security filter chain to apply various security rules and checks.

## 11. decribe how do JWT work(slides ⾥有图， 26页)

JWTs work by transmitting information between two parties as a JSON object. The process typically follows these steps:
Creation: The issuer generates a JWT with claims (data) and signs it using a secret or a private key.
Transmission: The issuer sends the JWT to a recipient. This usually happens in the header of an HTTP request.
Verification: The recipient of the JWT validates the signature with the secret or public key. This confirms the token's integrity and authenticity.
Usage: After verification, the recipient can use the data (claims) inside the JWT. For authentication, the JWT often contains user identity claims.

##  12. Do you use any Encoder to encode Password?
Yes, password encoding is a critical security practice. In Java and Spring Security, BCryptPasswordEncoder, Pbkdf2PasswordEncoder, or SCryptPasswordEncoder are commonly used to hash and salt passwords securely.

## 13. What is UserDetailService? AuthenticationProvider?AuthenticationManager? 
AuthenticationFilter?(把这⼏个名字看熟悉也⾏)
UserDetailsService: An interface used in Spring Security to retrieve user-related data. It is used by the AuthenticationManager to load details about the user during authentication.
AuthenticationProvider: Defines an interface for an authentication mechanism. It is responsible for verifying the authenticity of an authentication request.
AuthenticationManager: The main strategy interface for authentication. It delegates the authentication process to an AuthenticationProvider.
AuthenticationFilter: Filters are used in the security chain to intercept authentication requests. Examples include UsernamePasswordAuthenticationFilter and JwtAuthenticationFilter.

## 14. What is the disadvantage of Session? how to overcome the disadvantage?
The main disadvantage of sessions is scalability and resource usage, as session data is stored server-side. This can be overcome by using stateless authentication methods like JWTs, which reduce server memory usage and allow for easier scaling across multiple servers.

##  15. how to get value from application.properties?
Values from application.properties can be accessed using the @Value annotation or by configuring a @ConfigurationProperties class in Spring Boot.
```java
@Value("${property.name}")
private String propertyName;
```
## 16. What is the role of configure(HttpSecurity http) and 
configure(AuthenticationManagerBuilder auth)?

configure(HttpSecurity http): Configures web-based security for specific http requests. By defining certain parameters, we can control access to resources, configure custom login pages, enable CSRF protection, and more.
configure(AuthenticationManagerBuilder auth): Configures authentication mechanisms by allowing in-memory authentication, JDBC authentication, adding UserDetailsService, and configuring AuthenticationProvider.

## 17. What is Spring security authentication and authorization?

Spring Security authentication is the process of verifying a user's identity, ensuring the user is who they claim to be. Authorization, on the other hand, determines what authenticated users are allowed to do within the application, such as accessing specific resources. Spring Security provides a comprehensive system for both authentication and authorization, offering multiple mechanisms and tools to secure Spring-based applications effectively.
