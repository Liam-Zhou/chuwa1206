1.  annotation.md has been created.
2.  What is the authentication?

    Authentication is the process of verifying the identity of a user or entity attempting to access a system or resource. It confirms whether the user is who they claim to be. Authentication typically involves presenting credentials, such as a username and password, to a system or application, which then verifies the authenticity of the credentials provided. The authentication process aims to answer the question: **"Who are you?"**

    There are various methods and mechanisms used for authentication, including:

    - Username and Password
    - Biometric Authentication
    - Multi-Factor Authentication (MFA)
    - Single Sign-On (SSO)

3.  What is the authorization?

    Authorization is the process of determining what actions or operations an authenticated user or entity is allowed to perform within a system or resource. It defines the permissions and privileges granted to an authenticated user. Authorization controls access to specific functionalities, data, or resources and ensures that users only have access to the resources they are entitled to access. Authorization typically follows successful authentication and answers the question: **"What are you allowed to do?"**

    Key concepts and components of authorization include:

    - Access Control Lists (ACLs)
    - Roles and Permissions
    - Policy Enforcement Points (PEPs) and Policy Decision Points (PDPs):
    - Role-Based Access Control (RBAC)
    - Attribute-Based Access Control (ABAC)

4.  What is the difference between authentication and authorization?

    **Authentication:** The primary purpose of authentication is to validate the identity of users or entities before granting them access to a system or resource.

    **Authorization:** The primary purpose of authorization is to control and manage access to specific functionalities, data, or resources based on the permissions and privileges granted to authenticated users.

    Authentication establishes the identity of users or entities, while authorization determines what those authenticated users or entities are allowed to do within a system or resource.

5.  What is HTTP Session?

    HTTP sessions are commonly used in web applications to maintain user authentication status, track user sessions, personalize user experiences, and manage user-specific data across multiple page views and interactions. They provide a convenient mechanism for preserving state information and delivering dynamic, interactive web content.

6.  What is Cookie?

    Cookie is an integral part of web technology, enabling websites and web applications to store user data, personalize content, manage sessions, and enhance user experiences.

    Cookies serve various purposes, including:

    - Session Management: Cookies can be used to maintain session state and track user sessions as users navigate through a website or web application.
    - Personalization: Cookies can store user preferences, settings, and customization options to tailor the browsing experience to individual users.
    - Tracking and Analytics: Cookies are often used for tracking user behavior, collecting analytics data, and targeting advertising based on user interests and demographics.
    - Authentication: Cookies can store authentication tokens or session identifiers to keep users logged in across multiple page views or visits to a website.

7.  What is the difference between Session and Cookie?

    Both sessions and cookies are used to maintain user state and **manage information** in web applications, `sessions` are a server-side concept used to maintain stateful interactions with users, while `cookies` are a client-side mechanism used to store and transmit data between the client and server. `Sessions` are often implemented using `cookies` to store session identifiers or other session-related information, but they represent distinct concepts in web development.

8.  How do we use session and cookie to keep user information across the the
    application?

    - Using Sessions: In Java, you can use HttpSession object to manage sessions in servlet-based applications. Here's a simplified example:

    ```
    // Create or retrieve HttpSession object
    HttpSession session = request.getSession();

    // Store user-specific data in the session
    session.setAttribute("username", "john_doe");

    // Retrieve user-specific data from the session
    String username = (String) session.getAttribute("username");

    // Destroy the session
    session.invalidate();
    ```

    - Using Cookies: In Java, you can use HttpServletResponse and HttpServletRequest objects to set and retrieve cookies in servlet-based applications. Here's a simplified example:

    ```
    // Set a cookie containing user-specific data
    Cookie cookie = new Cookie("username", "john_doe");
    response.addCookie(cookie);

    // Retrieve and parse cookies from the HTTP request
    Cookie[] cookies = request.getCookies();
    String username = null;
    if (cookies != null) {
        for (Cookie c : cookies) {
            if (c.getName().equals("username")) {
                username = c.getValue();
                break;
            }
        }
    }

    ```

9.  What is JWT?

    JSON Web Tokens (JWT) are a compact, self-contained means of securely transmitting information between parties as a JSON object. JWTs are often used for implementing stateless authentication mechanisms, where the server does not need to maintain session state. When a user logs in, the server creates a JWT containing user information and returns it to the client. The client sends the JWT with each subsequent request, and the server verifies the JWT to authenticate the user and authorize access to protected resources.

    The advantages of using JWTs include:

    - Compactness: JWTs are lightweight and can be easily transmitted over networks.
    - Self-contained: JWTs contain all the necessary information within themselves, reducing the need for additional database lookups.
    - Security: JWTs are digitally signed, making them secure against tampering and forgery.

10. What is the spring security filter?

    The spring security filters provide various security features and mechanisms within a Spring-based application. Spring Security filters are components responsible for intercepting incoming HTTP requests, applying security checks and controls, and modifying the request and response accordingly.

11. Decribe how do JWT work?

    - Authentication:
      - When a user logs in or authenticates with the server, the server generates a JWT containing the user's information (e.g., user ID, username) and signs it with a secret key.
      - The server sends the JWT back to the client as part of the authentication response (e.g., in the response body or as an HTTP header).
      - The client stores the JWT securely, usually in local storage or a cookie, and includes it in the headers of subsequent requests to the server.
      - The server validates the JWT signature and extracts the user information from the payload to authenticate the user and authorize access to protected resources.
    - Authorization:
      - In addition to authentication, JWTs can also be used for authorization by including user roles or permissions in the JWT payload. This allows servers to make access control decisions based on the claims contained within the JWT.

12. Do you use any Encoder to encode Password?

    Yes, here is the steps to encode password:

    - First, you need to add the Spring Security dependency to your project in "pom.xml":
    - Once you have the dependency added, you can use the `PasswordEncoder` interface to encode passwords. Here's an example:

    ```
    public class PasswordEncoderExample {

        public static void main(String[] args) {
            // Create a new instance of the BCryptPasswordEncoder
            PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

            // Encode a password
            String rawPassword = "password123";
            String encodedPassword = passwordEncoder.encode(rawPassword);

            // Print the encoded password
            System.out.println("Encoded Password: " + encodedPassword);

            // Check if a password matches the encoded password
            boolean isMatch = passwordEncoder.matches(rawPassword, encodedPassword);
            System.out.println("Password Match: " + isMatch);
        }
    }
    ```

13. What are UserDetailService, AuthenticationProvider, AuthenticationManager, and
    AuthenticationFilter?

    UserDetailService: In Spring Security, the `UserDetailsService` interface provides a way to retrieve user details (including authentication and authorization information) based on a username or other unique identifier.

    AuthenticationProvider: The `AuthenticationProvider` interface in Spring Security is responsible for authenticating users based on provided credentials and returning a fully authenticated Authentication object if successful.

    AuthenticationManager: The `AuthenticationManager` interface in Spring Security orchestrates the authentication process by delegating authentication requests to one or more `AuthenticationProvider` implementations.

    AuthenticationFilter: In Spring Security, an `AuthenticationFilter` intercepts incoming HTTP requests, extracts authentication credentials (such as username and password) from the request, and attempts to authenticate the user using the configured `AuthenticationManager`.

14. What is the disadvantage of Session? How to overcome the disadvantage?

    Disadvantage:

    1. Server Memory Usage
    2. Session Replication and Failover
    3. Scaling Issues
    4. Session Management Overhead

    Overcome:

    1. Use Stateless Authentication(e.g JSON Web Tokens (JWT))
    2. Distributed Caching(e.g Redis or Memcached)
    3. Session Data Offloading:
    4. Session Replication and Clustering
    5. Session Expiration and Cleanup

15. How to get value from application.properties?

    - Using the @Value Annotation:

    ```
    @Component
    public class MyComponent {

        @Value("${my.property}")
        private String myProperty;

        public void printPropertyValue() {
            System.out.println("Value of my.property: " + myProperty);
        }
    }
    ```

    - Using the Environment Object:

    ```
    @Component
    public class MyComponent {

        @Autowired
        private Environment environment;

        public void printPropertyValue() {
            String myPropertyValue = environment.getProperty("my.property");
            System.out.println("Value of my.property: " + myPropertyValue);
        }
    }
    ```

16. What is the role of configure(HttpSecurity http) and configure(AuthenticationManagerBuilder auth)?

    - The configure(HttpSecurity http) method: It is used to configure security settings related to HTTP requests in your application. It allows you to define access rules, authentication mechanisms, authorization policies, and other security-related configurations.
    - configure(AuthenticationManagerBuilder auth) method: It is used to configure how Spring Security performs authentication. It allows you to define how users are authenticated, including where user details are stored, what authentication mechanisms are used, and how passwords are encoded.

17. What is Spring security authentication and authorization?

    - Some common authentication mechanisms supported by Spring Security include:
      - Form-based authentication
      - HTTP Basic authentication
      - HTTP Digest authentication
      - OAuth 2.0 and OpenID Connect
    - Some key features and concepts related to authorization in Spring Security include:
      - Access control rules
      - Role-based access control (RBAC)
      - Permission-based access control
      - Fine-grained access control
      - Pre and post authorization checks
