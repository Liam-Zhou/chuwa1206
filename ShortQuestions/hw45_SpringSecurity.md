### HW45

## Q2. What is the authentication?
Authentication is the process of verifying the identity of a user or system. It involves confirming whether an entity (usually a user) is who they claim to be, typically by checking their credentials, such as a username and password, against a set of known values or through other means like tokens.

## Q3. What is the authorization?
Authorization is the process of determining whether an authenticated entity (usually a user or a service) has the permission to perform a specific action or access particular resources within the system.

## Q4. What is the difference between authentication and authorization?
- Purpose: Authentication verifies the identity of a user or system. It's about confirming "Who you are." Authorization determines whether an authenticated user or system has permission to perform specific actions or access particular resources. It's about defining "What you are allowed to do."
- Process: During authentication, users or systems prove their identity to the application, typically through credentials such as usernames and passwords, tokens, biometric data, or other authentication factors. Once an entity is authenticated, the authorization process checks the entity's permissions against a set of policies, roles, or rules to determine whether the requested access or operation should be granted.

## Q5. What is HTTP Session?
An HTTP Session is a server-side mechanism used to manage and store information about a user's interactions with a web application across multiple HTTP requests. When a session is established, the server generates a unique session identifier (session ID), which is sent to the client, typically as a cookie. The client then sends this session ID back to the server with each subsequent request, allowing the server to retrieve the stored session data and maintain context for that user's activities. This mechanism effectively creates a "state" across stateless HTTP transactions.

## Q6. What is Cookie? 
A cookie is a small piece of data sent from a website and stored on the user's computer by the user's web browser while the user is browsing. Cookies were designed to be a reliable mechanism for websites to remember stateful information (such as items added in the shopping cart in an online store) or to record the user's browsing activity (including clicking particular buttons, logging in, or recording which pages were visited in the past). They can also be used to remember arbitrary pieces of information that the user previously entered into form fields, such as names, addresses, passwords, and credit card numbers.

## Q7. What is the difference between Session and Cookie?
- Storage Location
	- Cookies: Cookies are stored on the client-side, within the user's web browser. This allows the data in the cookie to be sent back to the server with each HTTP request made to the same domain.
	- Sessions: Session data is stored on the server-side. A session ID is used to identify a particular session, and this ID is usually stored on the client-side within a cookie, although it can also be passed in the URL.

- Lifespan
	- Cookies: The lifespan of a cookie can be set when the cookie is created. Some cookies, known as session cookies, last only as long as the browser session and are deleted when the browser is closed. Others, known as persistent cookies, have a specified expiration date and can last for an extended period, even across multiple browsing sessions.
	- Sessions: The lifespan of a session is controlled by the server and the browser's session handling settings. Sessions typically expire after a period of inactivity, which can be configured by the web developer.

- Data Storage
	- Cookies: Because cookies are stored on the client-side, they are generally used to store small amounts of data. 
	- Sessions: Since session data is stored on the server, it is more suitable for storing larger amounts of data. Only the session ID is sent between the server and the client, reducing the amount of data transferred with each request.

- Use Cases
	- Cookies: Cookies are well-suited for storing user preferences, tracking user behavior across visits to a website, and managing simple login states.
	- Sessions: Sessions are used when there is a need to maintain user-specific data across multiple requests in a secure manner, such as during a user's logged-in session on a website, where more sensitive data might be involved.

## Q8. How do we use session and cookie to keep user information across the the application? 
1. User Login: When a user logs into a web application, they submit their login credentials (usually a username and password). The server then verifies these credentials against its user database or authentication source.
2. Establishing a Session: Once the credentials are verified, the server creates a new session for the user. This involves generating a unique session identifier (session ID) and initializing a session data store on the server where user-specific data can be stored, such as user preferences, shopping cart contents, or authentication status.
3. Storing the Session ID in a Cookie: The server sends the session ID back to the client's browser as part of the HTTP response. This session ID is typically stored in a cookie. 
4. Client Requests with Session ID: With each subsequent HTTP request to the server, the client's browser automatically includes the session ID cookie in the request headers. This allows the server to identify the session associated with the request by reading the session ID from the cookie.
5. Server-side Session Data Access: Using the session ID, the server retrieves the session data associated with this ID from its session data store. This data can include any user-specific information that the application needs to maintain across requests, such as the user's authentication state, roles, and other personalized content.
6. Maintaining and Updating Session Data: As the user interacts with the application, the server can update the session data store based on user actions. For example, if the user adds an item to their shopping cart, the server can update the shopping cart information stored in the session.
7. Session Expiration and Logout: The session can be configured to expire after a certain period of inactivity or when the user explicitly logs out. Upon expiration or logout, the server invalidates the session ID and clears the associated session data. The client's browser may also be instructed to delete the session ID cookie.


## Q9. What is JWT?
JWTs are a popular method in the field of web security for implementing token-based authentication and authorization.

## Q10. What is the spring security filter?
Spring Security uses a series of filters to enforce authentication and authorization within a web application. These filters are part of a filter chain that intercepts HTTP requests to your application. Each filter has a specific responsibility, and together, they form a comprehensive security mechanism for web applications.

## Q11. decribe how do JWT work
1. User Authentication: The user logs in to an application using their credentials
2. Token Generation: Upon successful authentication, the server generates a JWT containing a set of claims. Claims are statements about the authenticated user (e.g., user ID, roles) and additional metadata (e.g., token expiration time). The server encodes the JWT claims in JSON format, and then it is base64-encoded. The server also creates a signature for the JWT by signing the encoded header and payload with a secret key or a public/private key pair.
3. Token Issuance: The server sends the JWT back to the client. The JWT can be sent in various ways, commonly included in the response body or as a cookie.
4. Token Usage: The client includes this JWT in the HTTP Authorization header in subsequent requests to the server. 
5. Token Verification: When the server receives a request with a JWT, it first verifies the token's signature to ensure it hasn't been tampered with. It then validates the claims in the token (e.g., the issuer, the audience, and the expiration time).
6. Access Control: Once the JWT is verified, the server uses the claims in the JWT to determine if the client is authorized to perform the requested operation.
7. Token Expiry: JWTs usually have an expiration time. If a token is expired, the server rejects the request, and the client may need to obtain a new token, often by refreshing the authentication or using a refresh token.

## Q12. Do you use any Encoder to encode Password?
In secure applications, passwords should always be encoded using a hash function. Commonly used encoders are bcrypt, Argon2, or PBKDF2. These provide strong hashing with salting to protect against various types of attacks.

## Q13. What is UserDetailService? AuthenticationProvider?AuthenticationManager? AuthenticationFilter?
- UserDetailsService
	- Purpose: `UserDetailsService` is an interface used by Spring Security to retrieve user-specific data. It is used in the authentication process to load the details of the user attempting to log in.
	- Functionality: The `loadUserByUsername(String username)` method, which finds a `UserDetails` object given the username. The `UserDetails` interface provides core user information.
	- Usage: Typically implemented to query a database or other storage system to retrieve user details (like username, password, and granted authorities) during authentication.
```java
	@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), user.getAuthorities());
    }
}
```

- AuthenticationProvider
	- Purpose: An `AuthenticationProvider` is an interface that defines how authentication should be performed. Spring Security can be configured with multiple `AuthenticationProvider`s, each capable of handling different authentication types (e.g., username/password, tokens).
	- Functionality: The `authenticate(Authentication authentication)` method, which performs the actual authentication logic.
```java
public class MyAuthenticationProvider implements AuthenticationProvider {

    @Autowired
    private MyUserDetailsService userDetailsService;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = authentication.getName();
        String password = authentication.getCredentials().toString();

        UserDetails user = userDetailsService.loadUserByUsername(username);

        if (password.equals(user.getPassword())) {
            return new UsernamePasswordAuthenticationToken(username, password, user.getAuthorities());
        } else {
            throw new BadCredentialsException("Authentication failed");
        }
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}
```

- AuthenticationManager
	- Purpose: The AuthenticationManager is the main strategy interface for authentication. It delegates the authentication process to an `AuthenticationProvider`.
	- Main Method: The `authenticate(Authentication authentication)` method, which delegates to the configured `AuthenticationProviders` to perform the authentication.

- AuthenticationFilter
	- Purpose: An `AuthenticationFilter` intercepts incoming requests and attempts to authenticate the request based on its contents. Spring Security has several predefined filters for different authentication mechanisms, such as `UsernamePasswordAuthenticationFilter`.
	- How It Works: The filter extracts authentication details from the request (e.g., username and password from a login form), creates an `Authentication` object, and passes it to the `AuthenticationManager`


## Q14. What is the disadvantage of Session? how to overcome the disadvantage?
**Disadvantages**:
- Scalability: Sessions can pose scalability challenges, especially in distributed environments. Storing session data on the server side requires memory, and as the number of users increases, the memory usage can become significant.
- Performance: The need to read and write session data with each request can impact application performance, particularly if the session data is large or if it's stored in a remote location, such as a database or a distributed cache.

**How to overcome**: Using stateless authentication mechanisms, such as JWT (JSON Web Tokens), can reduce the reliance on server-side sessions. JWTs carry the user's state and are sent with each request, eliminating the need for server-side session storage.

## Q15. how to get value from application.properties?
You can use `@Value` to get value from application.properties.

```java
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class MyBean {

    @Value("${app.val1}")
    private String val1;

    @Value("${app.val2}")
    private String val2;

    // Constructor, getters, or other methods
}

```

## Q16. What is the role of configure(HttpSecurity http) and configure(AuthenticationManagerBuilder auth)?
- configure(HttpSecurity http)
	- Purpose: This method is used to configure web-based security for specific http requests. By default, it applies to all requests, but you can restrict it to specific paths.
	- Functionality: It allows you to configure security directives, such as which paths are secured, which ones are publicly accessible, custom login and logout behavior, session management, CSRF protection, CORS, and more.

- configure(AuthenticationManagerBuilder auth)
	- Purpose: This method is used to establish an authentication mechanism by allowing AuthenticationProviders to be added easily.
	- Functionality: It defines how the application retrieves user details for authentication. This can be in-memory, database, LDAP, or custom authentication providers.

## Q17. What is Spring security authentication and authorization
Authentication is the process of verifying the identity of a user or system. Authorization is the process of determining whether an authenticated user has permission to perform a specific action or access a particular resource.



