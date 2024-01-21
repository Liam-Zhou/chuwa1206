# 4. What is JPA? and what is Hibernate?

JPA (Java Persistence API): JPA is a Java specification for managing relational data in Java applications. It provides a standard way to map Java objects to relational databases. JPA defines a set of annotations and interfaces for object-relational mapping.

Hibernate: Hibernate is a popular open-source implementation of the JPA specification. It is an ORM (Object-Relational Mapping) framework that simplifies database interaction in Java applications. Hibernate enables developers to work with Java objects rather than SQL queries, providing a higher level of abstraction.

# 5. What is Hiraki? what are the benefits of a connection pool?

Hikari: HikariCP is a high-performance JDBC connection pool. It efficiently manages and provides a pool of database connections for applications. Its benefits include improved performance, reduced resource consumption, and better handling of database connections, leading to enhanced application scalability.

# 6. What is the @OneToMany, @ManyToOne, @ManyToMany? write some examples.

@OneToMany: Defines a one-to-many relationship between entities. For example, a Parent entity can have multiple Child entities.

```
@Entity
public class Parent {
    @OneToMany(mappedBy = "parent")
    private List<Child> children;
}

@Entity
public class Child {
    @ManyToOne
    private Parent parent;
}

```

@ManyToOne: Specifies a many-to-one relationship. In the example above, Child has a many-to-one relationship with Parent.

@ManyToMany: Represents a many-to-many relationship between entities.

# 7. What is the cascade = CascadeType.ALL, orphanRemoval = true? and what are the other CascadeType and their features? In which situation do we choose which one?

cascade = CascadeType.ALL: Specifies that all operations (persist, merge, remove, refresh) should be cascaded to the associated entities.

orphanRemoval = true: Ensures that if an entity is removed from the collection, it is also deleted from the database.

Other CascadeType options include PERSIST, MERGE, REMOVE, REFRESH, DETACH. The choice depends on the desired behavior. For example, PERSIST cascades the persist operation.

# 8. What is the fetch = FetchType.LAZY, fetch = FetchType.EAGER? what is the difference? In which situation you choose which one?

FetchType.LAZY: Specifies that the related entities should be loaded lazily, i.e., when accessed. Suitable for optimizing performance when you don't always need the related data.

FetchType.EAGER: Indicates that the related entities should be loaded eagerly, i.e., at the time of fetching the owning entity. Useful when you consistently need the related data.

Choose LAZY for better performance unless you frequently need the related data.

# 9. What is the rule of the JPA naming convention? Shall we implement the method by ourselves? Could you list some examples?

JPA naming conventions suggest creating query methods in repositories based on method names. Avoid implementing the methods yourself; let JPA derive queries from method names.

Examples:

findByFirstName(String firstName)
countByAgeGreaterThan(int age)
deleteByLastName(String lastName)

# 13. What is JPQL?

JPQL (Java Persistence Query Language): JPQL is a query language used to perform database operations on entities. It is similar to SQL but operates on JPA entities. JPQL queries are written against entity objects rather than database tables.

# 14. What are @NamedQuery and @NamedQueries?

@NamedQuery: Annotation used to define a named JPQL query at the entity level. This query can be referenced in code using the specified name.

@NamedQueries: Allows grouping multiple named queries within the same annotation.

# 15. What is @Query? In which Interface do we write the SQL or JPQL?

@Query: Annotation used to define native SQL or JPQL queries in a Spring Data repository. It is placed on repository query methods.

For JPQL, use it in a repository interface extending JpaRepository. For native SQL, use it with nativeQuery = true.

# 16. What are HQL and Criteria Queries?

HQL (Hibernate Query Language): Object-oriented query language provided by Hibernate. It operates on persistent objects, not database tables.

Criteria Queries: API for querying the database using a programmatic, type-safe approach. Allows building queries using criteria expressed as Java objects.

# 17. What is EnityManager?

EntityManager: Interface in JPA used to interact with the persistence context. It manages entities, their lifecycle, and provides methods for CRUD operations.

# 18. What is SessionFactory and Session?

SessionFactory: In Hibernate, it is a factory for creating Session instances. It is a heavyweight object created once for an application.

Session: Represents a single-unit-of-work and provides methods for CRUD operations. It is a lightweight object created per client request.

# 19. What is Transaction? how do manage your transactions?

Transaction: A sequence of one or more operations treated as a single unit of work. It ensures data consistency and integrity.

Manage transactions using @Transactional annotation in Spring. It automatically starts and commits transactions or rolls back in case of exceptions.

# 20. What is hibernate Caching?

Hibernate Caching: Mechanism to store and reuse previously fetched data to improve performance. It reduces the need to hit the database for repetitive queries.

# 21. What is the difference between first-level cache and second-level cache?

First-level Cache: Session-specific cache that stores objects within the current session. It is enabled by default and provides a short-lived cache.

Second-level Cache: Shared cache across sessions, providing a longer-lived cache. Improves performance by allowing multiple sessions to share cached data.

# 22. How do you understand @Transactional?

@Transactional: Annotation in Spring that demarcates a transactional boundary. It ensures that a method runs within a transaction. If an exception occurs, the transaction is rolled back; otherwise, it is committed.

Use @Transactional to simplify transaction management and maintain data consistency.
