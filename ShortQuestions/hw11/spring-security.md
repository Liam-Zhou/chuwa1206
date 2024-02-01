### Question 1:
@EnableWebSecurity
@Secured
@PreAuthorize

### Question 2:
Authentication is the process of verifying who someone is, essentially confirming the identity of a user. It involves validating credentials such as usernames and passwords, biometric data, or other forms of identification to ensure that a user is who they claim to be.

### Question 3:
Authorization is the process of determining what resources or actions a user is permitted to access or perform after they are authenticated. It involves setting permissions and privileges to resources like files, databases, services, and other system components based on user roles, groups, or policies.

### Question 4:
Authentication verifies who the user is (identity verification).
Authorization determines what resources a user can access or what actions they can perform after being authenticated.
Authentication happens before authorization and serves as the first step in access control, while authorization is the second.

### Question 5:
An HTTP session is a way to persist state information on the server side between HTTP requests. Since HTTP is stateless, sessions provide a way to store user data across multiple requests, using a session identifier sent between the client and server, typically through cookies.

### Question 6:
A cookie is a small piece of data sent from a website and stored on the user's computer by the user's web browser while the user is browsing. Cookies are used to remember information about the user, such as login information, preferences, and shopping cart contents, across different sessions.

### Question 7:
Session is stored on the server side and can store a larger amount of data securely. It is identified by a session ID.
Cookie is stored on the client side, has size limitations, and is less secure since it can be accessed by client-side scripts. It's used to track user preferences and login sessions.

### Question 8:
Sessions and cookies can be used together to maintain user information across the application. A session ID is stored in a cookie on the user's browser, which is sent back to the server with each request. The server uses this session ID to retrieve the user's stored session information, allowing for a consistent user experience across multiple requests.

### Question 9:
JWT (JSON Web Token) is an open standard that defines a compact and self-contained way for securely transmitting information between parties as a JSON object. This information can be verified and trusted because it is digitally signed. JWTs are commonly used for authorization and information exchange.

### Question 10:
The Spring Security filter is a core component of the Spring Security framework that intercepts incoming requests to an application to enforce security measures. It is responsible for tasks like authentication, authorization, and other security checks before allowing access to application resources.

### Question 11:
JWT works in three parts: Header, Payload, and Signature.

The Header contains metadata about the token, such as the type of token and the hashing algorithm used.
The Payload contains the claims, which are statements about an entity (typically the user) and additional metadata.
The Signature is created by encoding the header and payload with a secret key using the specified algorithm in the header.

### Question 12:
Yes, in modern applications, especially those built with frameworks like Spring Security, it's common practice to use a password encoder to hash passwords before storing them in a database. Spring Security provides several password encoders, like BCryptPasswordEncoder, Pbkdf2PasswordEncoder

### Question 13:
UserDetailsService: An interface used by Spring Security to retrieve user-related data. It has a single method loadUserByUsername which is used to fetch a user's details from a database or other storage systems.
AuthenticationProvider: Defines an interface for implementing authentication logic. Spring Security can use different AuthenticationProvider implementations to authenticate a user against various backends like LDAP, a database, or other custom sources.
AuthenticationManager: Acts as a facade for various AuthenticationProvider objects, managing the authentication process within Spring Security. It delegates the authentication request to the appropriate provider based on the type of authentication required.
AuthenticationFilter: Intercepts authentication requests, typically at the entry points of an application, such as login forms or API endpoints. It processes incoming authentication data and submits them to the AuthenticationManager.

### Question 14:
Sessions can be resource-intensive on the server side, especially with a large number of users, leading to scalability issues. They can also be vulnerable to session hijacking attacks.

### Question 15:
Use the @Value annotation to inject values from application.properties into fields in components.

### Question 16:
configure(HttpSecurity http): Configures security concerns related to HTTP security. It allows configuring web-based security for specific http requests. By overriding this method, you can customize security directives, configure CORS, CSRF, session management, rules for protected resources, and more.
configure(AuthenticationManagerBuilder auth): Configures global security concerns, mainly around authentication. It allows setting up the AuthenticationManager by specifying the authentication mechanism, configuring 

### Question 17:
Authentication is the process of establishing a principal is who they claim to be .
Authorization refers to the process of deciding whether a principal is allowed to perform an action within application.




