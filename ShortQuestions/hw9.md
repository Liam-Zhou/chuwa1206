### 4. What is JPA? and what is Hibernate?

>JPA (Java Persistence API) is a Java specification for managing, persisting, and accessing data between Java objects and relational databases. It provides a standardized way for Java applications to interact with relational databases, abstracting the underlying database-specific details. 
>
>Hibernate is an implementation of the JPA specification. It is one of the most widely used and popular frameworks for object-relational mapping (ORM) in the Java ecosystem. Hibernate simplifies the development of database-driven applications by providing a powerful, high-performance, and flexible framework for mapping Java objects to database tables and vice versa.

### 5. What is Hirari? what is the benefits of connection pool?

>Hirari is a lightweight JDBC connection pool for Java applications.
>
>### Benefits of Connection Pooling:
>
>**Resource Reuse:** Instead of opening a new database connection every time a request is made, connection pooling allows the reuse of existing connections. This reduces the overhead of creating and closing connections repeatedly.
>
>**Concurrency Management:** Connection pooling helps manage database connections in a multi-user and concurrent environment. It ensures that multiple users can efficiently share a pool of connections without causing conflicts.
>
>**Connection Timeout Handling:** Connection pools often include mechanisms to handle connection timeouts and automatically remove or replace connections that become stale or unresponsive.
>
>

### 6. What is the @OneToMany, @ManyToOne, @ManyToMany? write some examples.

```java
//@OneToMany:
Indicates a one-to-many relationship between two entities.
@Entity
public class ParentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // One-to-many relationship with ChildEntity
    @OneToMany(mappedBy = "parent", cascade = CascadeType.ALL)
    private List<ChildEntity> children;
}
//@ManyToOne
@Entity
public class ChildEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Many-to-one relationship with ParentEntity
    @ManyToOne
    @JoinColumn(name = "parent_id")
    private ParentEntity parent;
}


//
```

### 7. What is the cascade = CascadeType.ALL, orphanRemoval = true? and what are the other CascadeType and their features? In which situation we choose which one?

>It defines how entity state changes should be cascaded from the owning entity to the associated entities.
>
>- **`CascadeType.PERSIST`:**
>  - Propagates the `persist` operation to associated entities. For example, if you persist the owning entity, the associated entities will also be persisted.
>- **`CascadeType.MERGE`:**
>  - Propagates the `merge` operation to associated entities. If you merge the owning entity, the associated entities will also be merged.
>- **`CascadeType.REFRESH`:**
>  - Propagates the `refresh` operation to associated entities. If you refresh the owning entity, the associated entities will also be refreshed.
>- **`CascadeType.REMOVE`:**
>  - Propagates the `remove` operation to associated entities. If you remove the owning entity, the associated entities will also be removed.
>- **`CascadeType.DETACH`:**
>  - Propagates the `detach` operation to associated entities. If you detach the owning entity, the associated entities will also be detached.

### 8. What is the fetch = FetchType.LAZY, fetch = FetchType.EAGER? what is the difference? In which situation you choose which one?

>FetchType.LAZY Indicates that the associated entities should be loaded lazily, i.e., only when they are explicitly accessed or requested. This means that the associated entities are not loaded along with the owning entity during the initial query.
>
> FetchType.EAGER indicates that the associated entities should be loaded eagerly, i.e., along with the owning entity during the initial query.

### 9. What is the rule of JPA naming convention? Shall we implement the method by ourselves? Could you list some examples?

> **Method Name Syntax:** The method name should start with a verb that indicates the operation (e.g., `findBy`, `deleteBy`, `countBy`).
>
> **Property Expressions:**Property names in the method name are derived from the names of the entity properties.
>
> **Keyword Expressions:**Keywords like `And`, `Or`, `OrderBy`, and `IgnoreCase` can be used to build more complex queries.

### 13. What is JPQL?

>JPQL stands for Java Persistence Query Language. It is a platform-independent query language defined as part of the Java Persistence API (JPA) specification. JPQL uses the class name of the entity and SQL uses table name.

### 14. What is @NamedQuery and @NamedQueries?

>The `@NamedQuery` annotation is used to define a single named query for an entity class. 
>
>The `@NamedQueries` annotation is used to define multiple named queries for an entity class.
>
>They are annotations used to define named queries for entities. Named queries provide a way to define and name a query in the entity class, making it easier to reference and reuse the query in the code. These queries are written in JPQL

### 15. What is @Query? In which Interface we write the sql or JPQL?

> In Java Persistence API (JPA), the `@Query` annotation is part of the Spring Data JPA framework and is used to declare custom queries for repository methods. The SQL or JPQL queries are typically written within the repository interface that extends a Spring Data JPA interface like `JpaRepository`.



### 17. What is EnityManager?

> An EntityManager is responsible for managing the lifecycle of entities.

### 18. What is SessionFactory and Session?

>SessionFactory creates and manages the Session objects.
>
>Session objects are created using sessionFactory.openSession().It is one instance per client/thread/transaction

### 19. What is Transaction? how to manage your transaction?

> a transaction is a unit of work that is performed as a single, indivisible operation. Transactions ensure the consistency and integrity of a database by grouping a set of related operations that must be executed together. 

### 20. What is hibernate Caching?

> Hibernate caching is a mechanism used by the Hibernate framework to improve the performance of database operations by reducing the need to repeatedly fetch data from the database.

### 21. What is the difference between first-level cache and second-level cache?

>The first-level cache is associated with a single Hibernate `Session` object. It exists only within the context of that particular session.
>
>The second-level cache is a shared cache that spans multiple Hibernate sessions. 

### 22. How do you understand @Transactional?

>Spring provides Declarative Transaction Management via @Transactional annotation. When a method is applied with @Transactional, then it will execute inside a database transaction. @Transactional annotation can be applied at the class level also, in that case, all methods of that class will be executed inside a database transaction.
