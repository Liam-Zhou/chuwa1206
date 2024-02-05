1.  annotaitons.md has been created.
2.  Typed out the code for the Comment feature of the class project.

    For Post field, it used lazy fetch, and use M:1 Data Relationships in comment class, they join by the column name "post_id"

3.  In postman, call all of the APIs in PostController and CommentController.

4.  What is JPA? And what is Hibernate?

    **JPA** is a specification that defines the Java Persistence API, while Hibernate is an implementation of the JPA specification. **Hibernate** is one of the most popular and feature-rich implementations of JPA and is widely used in Java enterprise applications for **data persistence** and **ORM**.

5.  What is HikariCP? What is the benefits of connection pool?

    HikariCP is a high-performance JDBC connection pool for Java applications. HikariCP is widely used in Java applications, including those built with Spring Boot, due to its excellent performance and reliability.

    Benefits of using a connection pool:

    - Resource Efficiency
    - Improved Performance
    - Connection Management
    - Concurrency Control
    - Configuration Flexibility

6.  What is the @OneToMany, @ManyToOne, @ManyToMany? Write some examples.

    @OneToMany: Used to define a one-to-many relationship between two entities.

    ```
    @Entity
    public class Parent {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @OneToMany(mappedBy = "parent")
        private List<Child> children;
        // getters and setters
    }

    @Entity
    public class Child {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @ManyToOne
        @JoinColumn(name = "parent_id")
        private Parent parent;
        // getters and setters
    }
    ```

    @ManyToOne: Used to define a many-to-one relationship between two entities.

    ```
    @Entity
    public class Child {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @ManyToOne
        @JoinColumn(name = "parent_id")
        private Parent parent;
        // getters and setters
    }

    @Entity
    public class Parent {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @OneToMany(mappedBy = "parent")
        private List<Child> children;
        // getters and setters
    }
    ```

    @ManyToMany: Used to define a many-to-many relationship between two entities.

    ```
    @Entity
    public class Student {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @ManyToMany
        @JoinTable(
            name = "student_course",
            joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "course_id")
        )
        private List<Course> courses;
        // getters and setters
    }

    @Entity
    public class Course {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @ManyToMany(mappedBy = "courses")
        private List<Student> students;
        // getters and setters
    }
    ```

7.  What is the cascade = CascadeType.ALL, orphanRemoval = true? And what
    are the other CascadeType and their features? In which situation we choose
    which one?

    The `cascade` and `orphanRemoval` are attributes in the `@OneToMany`, `@OneToOne`, and `@ManyToMany`. Thw `cascade` allows you to specify how entity operations should be cascaded from one entity to another. The `orphanRemoval` attribute, on the other hand, is used to specify whether orphaned child entities should be removed when they are no longer referenced by the parent entity.

    `cascade = CascadeType.ALL` means all entity operations (e.g., persist, merge, remove, refresh) should be cascaded from the parent entity to the associated child entities.

    `orphanRemoval = true` means orphaned child entities (i.e., child entities that are no longer referenced by the parent entity) should be removed from the database.

    Other CascadeType options include:

    - CascadeType.PERSIST
    - CascadeType.MERGE
    - CascadeType.REMOVE
    - CascadeType.REFRESH
    - CascadeType.DETACH

    If you want changes made to the parent entity to automatically propagate to the child entities, you might use CascadeType.MERGE.

    If you want child entities to be deleted when the parent entity is deleted, you might use CascadeType.REMOVE.

    If you want newly created child entities to be persisted automatically when the parent entity is persisted, you might use CascadeType.PERSIST.

8.  What is the fetch = FetchType.LAZY, fetch = FetchType.EAGER? What is the
    difference? In which situation you choose which one?

    They are used to define how associated entities should be fetched from the database when a query is executed on the owning entity.

    With `FetchType.LAZY`, associated entities are not loaded from the database immediately when the owning entity is fetched. They are fetched from the database only when accessed for the first time.

    With `FetchType.EAGER`, associated entities are loaded from the database immediately along with the owning entity. This means that all associated entities are eagerly fetched in a single query, regardless of whether they are actually needed.

    Use `lazy loading` for associations that are not always needed or accessed infrequently. While use `eager loading` for associations that are almost always needed and accessed frequently.

9.  What is the rule of JPA naming convention? Shall we implement the method by
    ourselves? Could you list some examples?

    - Entity Class Naming: Camel case convention and represent singular nouns.
    - Table Naming: Lowercase and represent plural nouns. By default, JPA maps an entity class to a database table with the same name as the class.
    - Field Naming: Camel case convention.
    - Relationship Naming: Relationships between entities are usually expressed through field names that reflect the nature of the relationship. For example, a User entity might have a field named orders to represent a one-to-many relationship with Order entities.
    - Primary Key Naming: You can override this default by specifying a different field name using @Id annotation. By default, JPA assumes that the primary key field in an entity class is named `id`.

    You typically do not need to implement these methods manually, as JPA implementations like Hibernate automatically generate SQL queries for CRUD (Create, Read, Update, Delete) operations based on the entity mappings and method signatures defined in repository interfaces.

    Example code:

    ```
    @Entity
    @Table(name = "users")
    public class User {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @Column(name = "first_name")
        private String firstName;

        @Column(name = "last_name")
        private String lastName;

        // Getters and setters
    }
    ```

10. Try to use JPA advanced methods in your class project. In the repository layer,
    you need to use the naming convention to use the method provided by JPA.

11. (Optional) Check out a new branch(https://github.com/TAIsRich/springboot-redbook/tree/hw02_01_jdbcTemplate) from branch 02_post_RUD, replace the dao layer using JdbcTemplate.

12. type the code, you need to checkout new branch from branch 02_post_RUD, name the new branch with https://github.com/TAIsRich/springboot-redbook/tree/hw05_01_slides_JPQL.
13. What is JPQL?

    JPQL is a powerful and flexible query language that simplifies database interactions in Java applications using JPA. It provides a convenient way to perform CRUD operations, retrieve data, and perform complex queries against the underlying database. It allows developers to write queries to interact with persistent objects in a database-agnostic manner, abstracting away the differences between different database vendors' SQL syntax.

    Example code:

    ```
    String jpql = "SELECT e FROM Employee e WHERE e.department = :department";
    Query query = entityManager.createQuery(jpql);
    query.setParameter("department", department);
    List<Employee> employees = query.getResultList();
    ```

    The `:department` placeholder is a named parameter that can be set dynamically using the `setParameter()` method.

14. What is @NamedQuery and @NamedQueries?

    `@NamedQuery` is used to define a single named query in an entity class. The @NamedQuery annotation is applied to a method in the entity class and specifies the JPQL query string associated with that method.

    ```
        @Entity
        @NamedQuery(
            name = "findEmployeeByName",
            query = "SELECT e FROM Employee e WHERE e.name = :name"
        )
        public class Employee {
            // Entity attributes and methods
        }
    ```

    `@NamedQueries` is used to define multiple named queries in an entity class. The @NamedQueries annotation is applied at the class level and contains an array of @NamedQuery annotations, each defining a named query.

    ```
        @Entity
        @NamedQueries({
            @NamedQuery(
                name = "findEmployeeByName",
                query = "SELECT e FROM Employee e WHERE e.name = :name"
            ),
            @NamedQuery(
                name = "findEmployeeByDepartment",
                query = "SELECT e FROM Employee e WHERE e.department = :department"
            )
        })
        public class Employee {
            // Entity attributes and methods
        }
    ```

15. What is @Query? In which Interface we write the sql or JPQL?

    `@Query` allows you to define custom JPQL (Java Persistence Query Language) or native SQL queries directly within Spring Data repository interfaces. This annotation gives you flexibility in writing complex queries and executing them against your database.

    JPQL Queries:

    ```
    public interface UserRepository extends Repository<User, Long> {

    @Query("SELECT u FROM User u WHERE u.age > :age")
    List<User> findUsersByAgeGreaterThan(@Param("age") int age);

    }
    ```

    Native SQL Queries:

    ```
    public interface UserRepository extends Repository<User, Long> {

        @Query(value = "SELECT * FROM users WHERE age > :age", nativeQuery = true)
        List<User> findUsersByAgeGreaterThan(@Param("age") int age);
    }
    ```

16. What is HQL and Criteria Queries?

    HQL is a powerful and flexible query language provided by Hibernate. It is very similar to SQL (Structured Query Language) but operates on objects and their properties rather than tables and columns. HQL queries are written using entity names and properties rather than database tables and columns.

    Criteria Queries provide a type-safe and object-oriented way to build dynamic queries using the Criteria API provided by Hibernate. Criteria Queries allow you to create queries programmatically without writing explicit SQL or HQL strings.

    In summary, HQL and Criteria Queries are two powerful mechanisms provided by Hibernate for querying objects from the database. While HQL offers a SQL-like query language for expressing queries, Criteria Queries provide a more type-safe and object-oriented approach for building queries dynamically in Java code. The choice between HQL and Criteria Queries depends on factors such as query complexity, dynamic nature of the query, and personal preference.

17. What is EnityManager?

    The `EntityManager` interface is a core component of the JPA and is used in JPA-based applications for managing persistent entities, performing database operations, and controlling the object-to-relational mapping process.

    Key Features of the `EntityManager` interface:

    - Entity Management
    - Lifecycle Management
    - Transaction Management
    - Query Execution
    - Entity Relationships

    Example code:

    ```
    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myPersistenceUnit");
    EntityManager entityManager = entityManagerFactory.createEntityManager();

    // Begin transaction
    entityManager.getTransaction().begin();

    // Create and persist a new entity
    User user = new User();
    user.setUsername("john_doe");
    user.setEmail("john@example.com");
    entityManager.persist(user);

    // Commit transaction
    entityManager.getTransaction().commit();

    // Close the EntityManager
    entityManager.close();
    ```

18. What is SessionFactory and Session?

    `SessionFactory` and `Session` are key components in Hibernate.

    `SessionFactory` is a factory class responsible for creating and managing `Session` instances in Hibernate. It is typically created during application startup and represents a single-threaded, immutable cache of compiled mappings for a single database.

    `Session` represents a single-threaded, short-lived unit of work with the database in Hibernate. It serves as the main interface for performing database operations, including CRUD (Create, Read, Update, Delete) operations and queries.

    Example code:

    ```
    // Create a Configuration object and configure Hibernate settings
    Configuration configuration = new Configuration();
    configuration.configure("hibernate.cfg.xml");

    // Create a SessionFactory based on the configuration settings
    SessionFactory sessionFactory = configuration.buildSessionFactory();

    // Obtain a new Session from the SessionFactory
    Session session = sessionFactory.openSession();

    // Begin a new transaction
    Transaction transaction = session.beginTransaction();

    // Perform database operations using the Session
    User user = new User();
    user.setUsername("john_doe");
    user.setEmail("john@example.com");
    session.save(user);

    // Commit the transaction
    transaction.commit();

    // Close the Session
    session.close();

    // Close the SessionFactory when the application shuts down
    sessionFactory.close();
    ```

19. What is Transaction? How to manage your transaction?

    A transaction is a unit of work that is performed against a database. It is a set of operations (such as inserts, updates, deletes, or queries) that should be treated as a single, indivisible operation. Transactions ensure data integrity, consistency, and reliability by ensuring that either all operations within the transaction are successfully completed or none of them are.

    Step managing transactions:

    1. Beginning a Transaction
    2. Performing Operations
    3. Committing or Rolling Back
    4. Handling Exceptions
    5. Transaction Management

20. What is hibernate Caching?

    Hibernate caching is a mechanism provided by Hibernate, improving the performance and scalability of database operations by reducing the number of database accesses and minimizing the load on the underlying database.

    Benefits of Hibernate caching include:

    - Improved performance
    - Scalability
    - Reduced latency

21. What is the difference between first-level cache and second-level cache?

    **First-Level Cache:** The first-level cache is associated with the `Session` object in Hibernate. Each `Session` instance maintains its own first-level cache. The first-level cache is short-lived and lasts only for the duration of the Session. Once the Session is closed, the first-level cache is cleared, and all cached entities are discarded.

    **Second-Level Cache:** The second-level cache is shared across `Session` instances and operates at the session factory level. It is accessible to all sessions within the same session factory. The second-level cache has a longer lifetime compared to the first-level cache. It persists beyond individual `Session` instances and remains available as long as the application is running and the session factory is active.

    In summary, the first-level cache is session-scoped, short-lived, and operates at the entity instance level, while the second-level cache is session factory-scoped, long-lived, and operates at the entity type level. Both caches serve different purposes and can be used in combination to optimize performance and scalability in Hibernate-based applications.

22. How do you understand @Transactional? (https://github.com/TAIsRich/tutorialtransaction)

    @Transactional is an annotation provided by Spring Framework to declare transactional behavior for methods or classes in a Spring application. It allows developers to manage transactions declaratively, without having to manually handle transactional boilerplate code.
