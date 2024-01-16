### 1. List all of the annotations you learned from class and homework to annotaitons.md
[Annotation.md](./Annotations.md)
### 2. Type out the code for the Comment feature of the class project.
[Code](../Repo/redbook-advanced)
### 3. In postman, call all of the APIs in PostController and CommentController.

### 4. What is JPA? and what is Hibernate?
JPA (Java Persistence API) is a Java specification for accessing, persisting, and managing data between Java objects and a relational database. Hibernate is an ORM (Object-Relational Mapping) framework that implements JPA. It provides a way to map Java objects to database tables and vice versa, enabling developers to work with data in a more object-oriented way.

### 5. What is HikariCP? What are the benefits of connection pooling?
HikariCP is a high-performance JDBC connection pool. Connection pooling provides benefits like reduced overhead in creating and closing connections, improved application performance by reusing connections, and better resource management by controlling the number of database connections.

### 6. What is @OneToMany, @ManyToOne, @ManyToMany? Write some examples.
- `@OneToMany`: Defines a one-to-many relationship between two entities.
    ```java
    @OneToMany(mappedBy = "user")
    private List<Account> accounts;
    ```
- `@ManyToOne`: Defines a many-to-one relationship.
    ```java
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    ```
- `@ManyToMany`: Defines a many-to-many relationship.
    ```java
    @ManyToMany
    @JoinTable(
    name = "user_role",
    joinColumns = @JoinColumn(name = "user_id"),
    inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private List<Role> roles;

    ```
### 7. What is `cascade = CascadeType.ALL`, `orphanRemoval = true`?
`cascade = CascadeType.ALL` means that all persistence operations (such as persist, remove, refresh, merge, detach) that happen on a parent entity will also be cascaded to the child entity. `orphanRemoval = true` is an option to automatically remove child entities when they are no longer referenced from the parent entity.

Other `CascadeType` options include:
- `PERSIST`: Only cascade the persist operation.
- `MERGE`: Only cascade the merge operation.
- `REMOVE`: Only cascade the remove operation.
- `REFRESH`: Only cascade the refresh operation.
- `DETACH`: Only cascade the detach operation.

Choose the appropriate cascade type based on the specific use case and the desired persistence operation behavior.

### 8. What is `fetch = FetchType.LAZY`, `fetch = FetchType.EAGER`?
- `FetchType.LAZY` is used when you want to load the related entities on demand. It is more efficient and should be used when you don't need the related entities immediately.
- `FetchType.EAGER` is used when you want to load the related entities at the same time as the parent entity. It can lead to performance issues if not used carefully due to the potential for loading large amounts of data.

Choose `LAZY` in most situations for better performance, and choose `EAGER` when the size of the related data is small or when it is always used with the parent entity.

### 9. What is the rule of JPA naming convention?
JPA follows a method naming convention where the method name describes the query criteria. The implementation is provided by the JPA provider (like Hibernate) based on the method names.

Examples:
- `findByUsername`: Finds a single entity by the `username` attribute.
- `findAllByLastnameOrderByFirstnameAsc`: Finds all entities with a specific `lastname` and orders them by `firstname` in ascending order.
- `countByAgeGreaterThan`: Counts all entities with an `age` attribute greater than the provided value.

### 13. What is JPQL?
JPQL (Java Persistence Query Language) is a query language defined by JPA for making queries against entities stored in a relational database. It is similar to SQL but operates on the entity objects rather than the database tables.

### 14. What is @NamedQuery and @NamedQueries?
`@NamedQuery` is an annotation used to define a static, named query in the JPA entity class. `@NamedQueries` is used to define multiple `@NamedQuery` annotations.

### 15. What is @Query?
`@Query` is an annotation used to define a query at the repository method level. This can be a SQL or JPQL query. It is used within a repository interface that extends JPA's `JpaRepository` or `Repository`.

### 16. What is HQL and Criteria Queries?
HQL (Hibernate Query Language) is an object-oriented query language similar to SQL, but instead of operating on tables and columns, HQL works with persistent objects and their properties. Criteria Queries are a programmatic, type-safe way to create queries in Hibernate.

### 17. What is EntityManager?
`EntityManager` is a JPA interface that manages the lifecycle of entities. It provides methods to create, read, update, and delete operations for entities, and to query them.

### 18. What is SessionFactory and Session?
`SessionFactory` is a Hibernate concept that creates `Session` instances. It's a thread-safe and immutable cache of compiled mappings for a single database. A `Session` is a single-threaded, short-lived object conceptually a "unit of work" that interacts with the persistence context.

### 19. What is Transaction? How to manage your transaction?
A `Transaction` in the context of databases ensures that a series of data manipulation statements are executed in a way that the database goes from one consistent state to another. Transactions can be managed in Spring using `@Transactional` annotation or by using the `TransactionManager` interface.

### 20. What is Hibernate Caching?
Hibernate Caching is a mechanism in Hibernate that is used to reduce the number of database accesses by storing entities in the cache. It improves performance by minimizing the database queries and thus reducing the overall response time.

### 21. What is the difference between first-level cache and second-level cache?
The first-level cache is associated with the `Session` object and is enabled by default. It is used within the scope of a session and is not shared among other sessions. The second-level cache is associated with the `SessionFactory` and is shared among all sessions created using the same `SessionFactory`. It needs to be explicitly enabled and can cache data across multiple transactions and sessions.

### 22. How do you understand @Transactional?
`@Transactional` is an annotation provided by Spring Framework that can be applied to methods or classes. When used, it indicates that the method or all methods in the class should be executed within a transactional context. It handles the creation, commit, and rollback of a transaction automatically. The annotation abstracts away the underlying transaction management from the developer, making it easier to control transaction boundaries declaratively.

