# 2. What is the authentication?

Authentication verifies who you are. It's like checking your ID at a club. You provide credentials (username/password), and if they match what's stored, you're "authenticated" and granted access.

# 3. What is the authorization?

Authorization determines what you're allowed to do after being authenticated. Imagine a club with VIP areas. Even if you're allowed in, only VIPs can access those sections. Authorization defines roles and permissions that control resource access.

# 4. What is the difference between authentication and authorization?

Authentication: "Are you who you say you are?" (Verification)
Authorization: "What can you do based on who you are?" (Access control)

# 5. What is an HTTP Session?

It's server-side storage for user information (like login state) during a session. Each session has a unique ID (JSESSIONID cookie) sent with requests for ongoing identification.

# 6. What is a Cookie?

A small file stored on the client's device that remembers preferences or identifies them across visits. Session cookies hold session IDs, while persistent cookies hold long-term information like login preferences.

# 7. What is the difference between Session and Cookie?

Session: Server-side data storage, expires after inactivity.
Cookie: Client-side data storage, persistent or session-based.

# 8. How do we use sessions and cookies to keep user information across the application?

Sessions store user data on the server, accessible for the entire session.
Cookies hold small amounts of data like session IDs (for server lookup) or user preferences.

# 9. What is JWT?

JSON Web Token (JWT) is a self-contained, signed token containing user information. It eliminates server-side session storage and allows stateless authorization across servers.

# 10. What is the spring security filter?

Spring Security filters intercept web requests and apply security checks based on configuration. Authentication and authorization filters check credentials and access privileges, respectively

# 11. Decribe how does JWT work?

1. Client sends login request with credentials.
2. Server validates credentials and generates a JWT token with user information.
3. Client receives and stores the JWT token.
4. Client sends subsequent requests with the JWT token in the header.
5. Spring Security filter intercepts the request and verifies the JWT token signature.
6. If valid, authorization rules are applied based on the user information within the token.

# 12. Do you use any Encoder to encode Passwords?

Yes, Spring Security recommends using password encoders like BCrypt to hash and store passwords securely. It prevents storing plaintext passwords and protects against rainbow table attacks.

# 13. What is UserDetailService? AuthenticationProvider? AuthenticationManager? AuthenticationFilter?

UserDetailService: Loads user information (credentials, roles) based on username.
AuthenticationProvider: Compares input credentials with the loaded user information.
AuthenticationManager: Orchestrates authentication with various providers.
AuthenticationFilter: Handles user login attempts and interacts with AuthenticationManager.

# 14. What is the disadvantage of the Session? how to overcome the disadvantage?

Scalability: Sessions require server-side storage, limiting scalability.
Clustering: Sessions complicate user migration across server clusters.
Solutions: JWTs offer stateless authorization, eliminating session needs and improving scalability and clustering.

# 15. how to get value from application.properties?

Use @Value("${property.name}") annotation to inject property values directly into fields or methods. Alternatively, use environment.getProperty("property.name") in your code.

# 16. What is the role of configure(HttpSecurity HTTP) and configure(AuthenticationManagerBuilder auth)?

configure(HttpSecurity HTTP) defines authorization rules, URL access restrictions, and security filters.
configure(AuthenticationManagerBuilder auth) configures authentication providers, password encoders, and user details service.

# 17. What is Spring security authentication and authorization?

Spring Security provides a framework for implementing authentication and authorization mechanisms in your Spring applications. It offers various modules and configuration options to manage user login, access control, and security configurations.
