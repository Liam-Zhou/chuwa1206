# 1
Done

# 2
Authentication is the process of verifying the identity of a user or system.

# 3
Authorization is the process of verifying what specific applications, files, and data a user has access to.

# 4
Authentication is about who are you. Authorization is about are you allowed to do this?

Authentication always precedes authorization. The system needs to know who the user is before it can determine what the user is allowed to do.

# 5
An HTTP Session is a way to preserve certain data across multiple HTTP requests. A session is a server-side storage of information that is associated with a user.'

# 6
A cookie is a small piece of data sent from a web server to a user's 
browser. The browser stores the cookie and sends it back with each 
subsequent request to the same server. This allows the server to 
identify and track users and remember their preferences or other data.

# 7
A cookie is a small piece of data sent from the server and stored on the client's browser while the user is browsing a website. A session is a server-side storage of information that is associated with a user across multiple requests although sessionId is stored on user side.

# 8
After the user logs into the application, the credentials are sent to the server. The server validates the credentials. If they are correct, the server creates a new session. The server generates a unique session ID for the new session. The server stores user-specific data in the session. The server sends the session ID back to the user's browser in a cookie. With each subsequent request from the user's browser, the cookie containing the session ID is sent to the server.

# 9
JWT stands for json web token. It is a compact, URL-safe means of representing claims to be transferred between two parties. After the user signs in, the server creates a JWT with the user's information and sends it back to the client. The client will store this token and include it in the headers of subsequent requests to the server, allowing the server to authenticate the user based on the token without needing to check the username and password again.

# 10
Spring Security uses a chain of filters, where each filter has a specific responsibility. The filters are applied in a particular order to every HTTP request coming into your application. This chain is fully customizable but comes with sensible defaults that handle common security concerns. Here are some key filters:
- Authentication Filters
- Logout Filter
- UsernamePasswordAuthenticationFilter
- DefaultLoginPageGeneratingFilter
- BasicAuthenticationFilter
- OAuth2 filters
- ExceptionTranslationFilter
- FilterSecurityInterceptor

# 11
When a user logs in using their credentials, a JWT is returned. Whenever the user wants to access a protected route or resource, the user agent should send the JWT, typically in the Authorization header using the Bearer schema. The server's protected routes will check for a valid JWT in the Authorization header, and if it's present, the user will be allowed to access protected resources.

# 12
`DelegatingPasswordEncoder`, `BCryptPasswordEncoder`, `Pbkdf2PasswordEncoder`

# 13
- UserDetailsService is an interface used in Spring Security to retrieve user-related data. It has one method named loadUserByUsername(String username) which locates the user based on the username. The result is wrapped in a UserDetails object that Spring Security uses for performing various authentication and role-based validations.
- AuthenticationProvider is an interface that represents an authentication mechanism. An AuthenticationProvider is responsible for verifying the authentication request and returning a fully populated Authentication object (including granted authorities) if the authentication is successful.
- AuthenticationManager is an interface that defines a high-level API for authentication. The most important method is authenticate(Authentication auth), which is used to process an authentication request.
- AuthenticationFilter is responsible for authenticating users. Different filters are used depending on the authentication method

# 14
## Scalability Issues
When using server-based sessions, session data is stored in the server's memory. This can become a bottleneck in a distributed system where you have multiple instances of your application running. Load balancers may route a user's requests to different instances, but the session might only exist on one instance.

Solution:
- Use Sticky Sessions: Configure your load balancer to ensure that all requests from a particular user are always routed to the same server instance. However, this can lead to unequal load distribution.
- Centralized Session Storage: Use a centralized data store for sessions, such as Redis or a database. This way, any instance of your application can access the session data.

## Memory Usage
Each session consumes memory on the server. With a large number of users, this can lead to significant memory consumption, affecting the performance of your application.

Solution:
- Session Expiration: Implement session expiration to remove old and unused sessions and free up memory.
- Optimize Session Data: Only store essential information in the session. For large data, consider storing a reference or identifier in the session and the actual data in a more suitable storage solution.

## Security Concerns
Sessions can be vulnerable to various attacks, like session hijacking and session fixation.

Solution:
- Secure Cookies: If session IDs are stored in cookies, ensure the cookies are secure (using flags like HttpOnly and Secure).
- Regenerate Session IDs: Regenerate session IDs after login to prevent session fixation attacks.
- Implement CSRF Tokens: Protect against Cross-Site Request Forgery (CSRF) by including CSRF tokens in your forms.

## Server Dependency & Failover
If the server storing the session crashes or needs to be taken down for maintenance, the session data can be lost, leading to a poor user experience.

Solution:
- Persistent Sessions: Store sessions in a persistent storage solution that provides data durability and high availability.
- Replication: Use session replication in a multi-server environment to have backup copies of sessions.

## Stateless Architecture Compliance
Modern architectures, especially those based on microservices, favor stateless designs. Server-based sessions introduce statefulness, which can complicate the architecture.

Solution:
- Token-Based Authentication: Use token-based authentication mechanisms like JWT (JSON Web Tokens). This allows state to be stored client-side, and the server can be stateless, simply validating the token on each request.

# 15
Use @Value

# 16
- configure(HttpSecurity http) allows you to configure the security of your web application at a fine-grained level. It's where you specify the details about how requests are secured, handled, and which resources are protected.
- configure(AuthenticationManagerBuilder auth) is used to define how the system retrieves user information for authentication purposes and how the passwords are encoded. It's where you configure the AuthenticationManager by specifying the details about user storage, password encoding, and the authentication mechanism. Here are some common configurations.

# 17
- Authentication is the process of verifying the identity of a user or system.
- Authorization is the process of verifying what specific applications, files, and data a user has access to.

# 18
Read.
