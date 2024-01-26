# hw9: hw42-Spring-Data

### Question 4: JPA and Hibernate
#### What is JPA? and what is Hibernate?
 
- JPA, Java Persistence API, is a Java specification for accessing, persisting, and managing data between Java objects and relational databases. 
- Hibernate is an Object-Relational Mapping (ORM) framework that implements JPA. It provides a framework for mapping an object-oriented domain model to a relational database.

### Question 5: Hikari and Connection Pool Benefits
#### What is Hikari? What are the benefits of a connection pool?
 
- HikariCP is a high-performance JDBC connection pool. 
- The benefits of using a connection pool like HikariCP include improved performance due to reused connections, reduced database connection creation and closure overhead, and better resource management by controlling the number of database connections.

### Question 6: JPA Relationships
#### What is the @OneToMany, @ManyToOne, @ManyToMany? Write some examples.
 
These annotations define the type of relationship between entities:
- @OneToMany: Indicates a one-to-many relationship. Example: One user has many posts.
- @ManyToOne: Indicates a many-to-one relationship. Example: Many posts belong to one user.
- @ManyToMany: Indicates a many-to-many relationship. Example: Many students enrolled in many courses.
```java
    @Entity
    public class User {
        @OneToMany(mappedBy = "user")
        private List<Post> posts;
    }

    @Entity
    public class Post {
        @ManyToOne
        @JoinColumn(name = "user_id")
        private User user;
    }
```

### Question 7: Cascade Types and Orphan Removal
#### What is the cascade = CascadeType.ALL, orphanRemoval = true? And what are the other CascadeType and their features? In which situation do we choose which one?
 
- `cascade = CascadeType.ALL` means that all CascadeType operations (PERSIST, REMOVE, REFRESH, MERGE, DETACH) are cascaded from the parent to the child entity.
- `orphanRemoval = true` means that when a child entity is removed from the collection, it will also be removed from the database.
- Other cascade types and their features:
  - CascadeType.PERSIST: Propagates persist operation from parent to child.
  - CascadeType.REMOVE: Propagates remove operation from parent to child.
  - CascadeType.MERGE: Propagates merge operation from parent to child.
  - CascadeType.DETACH: Propagates detach operation from parent to child.
  - CascadeType.REFRESH: Propagates refresh operation from parent to child.
- The choice depends on the specific requirements of the relationship and operations performed on entities.

### Question 8: FetchType.LAZY vs FetchType.EAGER
#### What is fetch = FetchType.LAZY, fetch = FetchType.EAGER? What is the difference? In which situation do you choose which one?
 
- `FetchType.LAZY` loads the related entities lazily, on-demand. 
- `FetchType.EAGER` loads all related entities immediately with the main entity. 
- Use `LAZY` to improve performance when you don't need related entities immediately and `EAGER` when you need related entities immediately after loading the main entity.

### Question 9: JPA Naming Convention
#### What is the rule of JPA naming convention? Shall we implement the method by ourselves? Could you list some examples?
 
JPA naming convention allows defining repository methods with specific names that translate into SQL queries. No need to implement the method; JPA interprets the method name and creates the query. Examples:
- `findByName(String name)` translates to `SELECT * FROM table WHERE name = ?`.
- `findByAgeGreaterThan(int age)` translates to `SELECT * FROM table WHERE age > ?`.

### Question 13: JPQL
#### What is JPQL?
 
JPQL, Java Persistence Query Language, is a query language used in JPA to perform queries against entities stored in a relational database. It is similar to SQL but operates at the object level rather than the table level.

### Question 14: @NamedQuery and @NamedQueries
#### What is @NamedQuery and @NamedQueries?
 
- `@NamedQuery` defines a static, named query at the entity level. 
- `@NamedQueries` allows defining multiple `@NamedQuery`. These queries are precompiled and more efficient for repeated executions.

### Question 15: @Query
#### What is @Query? In which Interface do we write the SQL or JPQL?
 
`@Query` is used to define a query at the repository method level. It can contain a SQL or JPQL query. This annotation is used in Repository interfaces extending `JpaRepository` or `CrudRepository`.

### Question 16: HQL and Criteria Queries
#### What is HQL and Criteria Queries?
 
HQL, Hibernate Query Language, is similar to SQL but works with persistent objects rather than tables. Criteria Queries are a type-safe and more object-oriented way to query entities by creating a query programmatically.

### Question 17: EntityManager
#### What is EntityManager?
 
`EntityManager` is an interface used in JPA for accessing a database. It provides methods to create, read, and delete operations for entities. It also manages entity objects' lifecycle and persistence context.

### Question 18: SessionFactory and Session
#### What is SessionFactory and Session?
 
- SessionFactory is a factory for creating Session objects in Hibernate. It's created once per application. 
- Session is a single-threaded, short-lived object representing a conversation between the application and the database. It's the main runtime interface between a Java application and Hibernate.

### Question 19: Transaction Management
#### What is Transaction? How to manage your transaction?
 
- A transaction represents a unit of work with the database and has ACID properties. 
- Transaction management can be declarative (using annotations like `@Transactional`) or programmatic (using the Transaction API to manually begin, commit, and rollback transactions).

### Question 20: Hibernate Caching
#### What is hibernate Caching?
 
Hibernate caching is a mechanism to reduce database access, improve application performance, and manage the persistence session. Hibernate supports first-level (session cache) and second-level (shared cache) caching.

### Question 21: First-Level vs Second-Level Cache
#### What is the difference between first-level cache and second-level cache?
 
- First-level cache is associated with the `Session` object and can't be disabled. Each session has its own first-level cache. 
- Second-level cache is associated with the `SessionFactory` and is shared across sessions. It can be configured and disabled if needed.

### Question 22: Understanding @Transactional
#### How do you understand @Transactional? (https://github.com/TAIsRich/tutorial-transaction)

`@Transactional` is an annotation used in Spring Framework to declare that a method or a class should be executed within a transactional context. When `@Transactional` is applied, the following behaviors are expected:
- **Transaction Management:** Spring manages the beginning and the end of a transaction automatically. It starts a new transaction before the annotated method executes and commits the transaction after the method completes.
- **Rollback Behavior:** If a runtime exception is thrown during the execution of the method, Spring marks the transaction for rollback. Optionally, the `rollbackFor` and `noRollbackFor` annotation attributes can be used to define specific exceptions for rollback behavior.
- **Isolation Levels:** The annotation can specify the transaction isolation level, which defines how changes made by one transaction are visible to other transactions.
- **Propagation Behavior:** It can also define the transaction propagation behavior, which determines how transactions relate to each other. For instance, whether a method should run within the scope of an existing transaction or start its own new transaction.

The `@Transactional` annotation helps in maintaining the integrity of data and ensuring consistency by handling the transaction boundaries automatically, making it easier to manage complex database operations and reducing the amount of boilerplate code.
