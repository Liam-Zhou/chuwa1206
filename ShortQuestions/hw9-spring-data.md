4. **What is JPA? and what is Hibernate?**
   - `JPA`, or Java Persistence API, is a Java specification for accessing, persisting, and managing data between Java objects/classes and a relational database. 
   - `Hibernate` is an ORM (Object-Relational Mapping) tool that implements JPA. It simplifies database interactions by mapping Java objects to database tables.

5. **What is Hikari? What are the benefits of connection pooling?**
   - Hikari is a high-performance JDBC connection pool. Connection pooling improves application performance by reusing existing database connections, reducing the overhead of creating new connections for each database request.

6. **What are `@OneToMany`, `@ManyToOne`, `@ManyToMany`? Write some examples.**
   - These are JPA annotations to define relationships between entities. 
   - `@OneToMany` and `@ManyToOne` represent one-to-many and many-to-one relationships, respectively. 
   - `@ManyToMany` is used for many-to-many relationships.      
        - For example, in a `User` and `Role` relationship, a user can have many roles (`@OneToMany`), and a role can belong to many users (`@ManyToMany`).

7. **What is `cascade = CascadeType.ALL`, `orphanRemoval = true`? What are the other CascadeType and their features? In which situation do we choose which one?**
   - `cascade = CascadeType.ALL` means that all cascade operations (like persist, remove, refresh, merge) are applied to the related entity. `orphanRemoval = true` means that if a child entity is removed from the relationship, it will be automatically deleted. Other `CascadeType` values include `PERSIST`, `MERGE`, `REMOVE`, etc., chosen based on the desired persistence operation propagation.

8. **What is `fetch = FetchType.LAZY`, `fetch = FetchType.EAGER`? What is the difference? In which situation do you choose which one?**
   - `FetchType.LAZY` loads the data on demand, while `FetchType.EAGER` loads it immediately with the parent entity. Lazy loading is preferred for large data sets or rarely accessed data, while eager loading can be used for small or frequently accessed data.

9. **What is the rule of JPA naming convention? Shall we implement the method ourselves? Could you list some examples?**
   - JPA naming convention in Spring Data involves creating method names that describe the query operation, such as `findByUsername`. You don't always need to implement the method; JPA can generate queries based on method names. Examples include `findByLastName`, `countByAgeGreaterThan`, etc.
   - reference: https://docs.spring.io/spring-data/jpa/reference/jpa/query-methods.html

13. **What is JPQL?**
    - Java Persistence Query Language (JPQL) is a query language used in JPA to perform operations on database entities. It is similar to SQL but operates on JPA entities rather than database tables.

14. **What is `@NamedQuery` and `@NamedQueries`?**
    - `@NamedQuery` defines a static query at the entity class level with a given name. `@NamedQueries` is used to group multiple `@NamedQuery` annotations. These queries are pre-defined and can be called by their names.
    ```Java

    @Entity
    @NamedQueries({
        @NamedQuery(name = "Book.findByTitle", 
                    query = "SELECT b FROM Book b WHERE b.title = :title"),

        @NamedQuery(name = "Book. findByPublishingDate"                 
        query = "SELECT b FROM Book b WHERE b.publishingDate =: publishingDate")
    })
    public class Book implements Serializable {
    ...
    }
    ```

15. **What is `@Query`? In which Interface do we write the SQL or JPQL?**
    - The `@Query` annotation is used to specify a SQL or JPQL query directly on a repository method. This is used in the repository interface to create custom queries that are not covered by the naming conventions.
    ```Java
    @Query("select p from Post p where p.id = :key or p.title = :title")
    Post getPostByIDOrTitleWithJPQLNamedParameters(@Param("title") String title, @Param("key") Long id);
    ```

16. **What is HQL and Criteria Queries?**
    - Hibernate Query Language (HQL) is an object-oriented query language similar to SQL, but it works with Hibernate entities instead of database tables. Criteria Queries are a programmatic, type-safe way to build queries in Hibernate.

17. **What is EntityManager?**
    - `EntityManager` is a JPA interface used to interact with the persistence context. It manages the lifecycle of entities and provides methods to perform create, read, update, and delete operations.

18. **What is SessionFactory and Session?**
    - In Hibernate, `SessionFactory` is a factory for `Session` objects. It maintains the configuration and provides a cache of data. `Session` provides methods to save, retrieve, update, or delete entity data and manage transactions.

19. **What is Transaction? How do you manage your transaction?**
    - A transaction in database systems ensures data integrity and consistency across multiple operations. Transactions are managed in JPA/Hibernate using the `EntityTransaction` interface or through Spring's declarative transaction management using `@Transactional`.

20. **What is Hibernate Caching?**
    - Hibernate caching is a mechanism to reduce database access by storing entities or data in memory. It improves application performance by minimizing the number of database hits.

21. **What is the difference between first-level cache and second-level cache?**
    - First-level cache is associated with the `Session` object in Hibernate and is enabled by default. It caches objects within the current session. Second-level cache is associated with the `SessionFactory` and is shared across different sessions.

22. **How do you understand `@Transactional`?**
    - `@Transactional` is a Spring annotation that declares a method or class should be executed within a transactional context. It handles the transaction's lifecycle, including commit and rollback, automatically based on the method's execution outcome.