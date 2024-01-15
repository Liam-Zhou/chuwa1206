# 4. JPA and Hibernate
1. JPA (Java Persistence API):

JPA is a Java specification for accessing, persisting, and managing data between Java objects and a relational database.
It's an API and a part of Java EE and Java SE that provides an ORM (Object-Relational Mapping) framework to map Java objects to database tables.
JPA is implemented through various providers like Hibernate, EclipseLink, and Apache OpenJPA.
2. Hibernate:

Hibernate is an ORM (Object-Relational Mapping) framework for Java.
It's one of the most popular JPA implementations.
Hibernate maps Java classes to database tables and Java data types to SQL data types, simplifying database operations.

# 5. HikariCP and Connection Pooling
1. HikariCP:

HikariCP is a high-performance JDBC connection pool.
It's known for its lightweight, performance, and reliability.
2. Benefits of Connection Pooling:

Improves application performance by reusing existing connections instead of creating a new one for every database operation.
Reduces the database load and resource consumption.
Manages concurrent database connections efficiently.

# 6. JPA Relationships with Examples
```java
public class User {
    @OneToMany(mappedBy = "user")
    private List<Order> orders;
}

public class Order {
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
```

```java
public class Student {
    @ManyToMany(mappedBy = "students")
    private List<Course> courses;
}

public class Course {
    @ManyToMany
    @JoinTable( /* Define join table details here */ )
    private List<Student> students;
}
```

# 7. CascadeType and orphanRemoval
1. cascade = CascadeType.ALL:

All operations (Persist, Remove, Refresh, Merge, Detach) are cascaded to the related entities.
Used when actions on the parent entity should propagate to child entities.
2. orphanRemoval = true:

Automatically removes child entities if they are no longer referenced from the parent entity.
3. Other Cascade Types:

CascadeType.PERSIST: Cascade only persist operation.
CascadeType.MERGE: Cascade only merge operation.
CascadeType.REMOVE: Cascade only remove operation.
CascadeType.REFRESH: Cascade only refresh operation.
CascadeType.DETACH: Cascade only detach operation.

# 8. FetchType.LAZY vs FetchType.EAGER
1. FetchType.LAZY:

The associated entities are loaded lazily on demand.
Reduces the initial load time and memory footprint.
Preferred in most scenarios for performance reasons.
2. FetchType.EAGER:

The associated entities are loaded immediately with the parent entity.
Can lead to performance issues due to loading unnecessary data.
3. Choosing FetchType:

Use LAZY for better performance, especially when you don't always need
related data immediately.

Use EAGER when you almost always need related data together with the parent entity, and the data size is manageable.

# 9. JPA Naming Convention and Method Implementation
1. JPA Naming Convention:

JPA uses specific naming conventions for methods in repository interfaces. The method name typically starts with find...By, read...By, query...By, count...By, and get...By.
The part after By uses the property names of the entity class to form a query.
2. Method Implementation:

You don’t need to implement these methods manually. Spring Data JPA automatically generates the implementation based on the method names.
Your job is to define the method signatures in the repository interface.

```java
public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findByLastName(String lastName);
    User findByEmail(String email);
    List<User> findByAgeGreaterThan(int age);
}
```

# 13. What is JPQL?
JPQL (Java Persistence Query Language) is a query language used in JPA (Java Persistence API) to execute queries against a database in a platform-independent way. It is very similar to SQL but operates on the entity objects rather than the database tables. JPQL allows users to write database queries based on the entity model of their application.

# 14. What is @NamedQuery and @NamedQueries?
1. @NamedQuery: This annotation is used to define a query with a name. It can be applied to an entity class and allows writing a query once and then calling it anywhere in the application using its name.

2. @NamedQueries: This annotation is used to define multiple @NamedQuery annotations. It's a container for several named queries.

```java
@Entity
@NamedQuery(name="User.findAll", query="SELECT u FROM User u")
public class User {
    // ...
}
```

# 15. What is @Query?
@Query: This annotation is used in Spring Data JPA to define SQL or JPQL queries directly on repository methods. It allows for more flexibility and complex queries beyond the naming convention of Spring Data.

The @Query annotation is used in repository interfaces, typically extending JpaRepository or CrudRepository.

```java
public interface UserRepository extends JpaRepository<User, Long> {
    @Query("SELECT u FROM User u WHERE u.email = ?1")
    User findByEmailAddress(String emailAddress);
}
```

# 16. What is HQL and Criteria Queries?
HQL (Hibernate Query Language): HQL is a query language used in Hibernate, similar to JPQL but specific to the Hibernate ORM framework.
Criteria Queries: A programmatic, type-safe way to build queries in JPA. Criteria API is used to construct dynamic queries in a type-safe manner, avoiding syntax errors at compile time.

# 17. What is EntityManager?
EntityManager is a JPA interface responsible for managing the persistence operations on entities. It provides methods for CRUD operations, querying, and transaction management. It's the primary interface used in JPA to interact with the persistence context.

# 18. What is SessionFactory and Session?
In Hibernate:

1. SessionFactory: A thread-safe and immutable object that bootstraps Hibernate and creates Session instances. It is heavyweight and usually created once during application initialization.
2. Session: A single-threaded and short-lived object representing a conversation between the application and the database. It's where you perform operations like saving and retrieving entities.

# 19. What is a Transaction? How to Manage Your Transaction
A transaction in the context of databases and Hibernate is a sequence of operations performed as a single logical unit of work. A transaction must be atomic, consistent, isolated, and durable (ACID properties). If one operation in the transaction fails, the transaction should be rolled back to maintain data integrity.

1. Managing Transactions:

In a Java application using JPA or Hibernate, transactions are managed using the EntityManager or Hibernate Session APIs. Transactions can be managed programmatically or declaratively.
Programmatic transaction management involves explicitly controlling the transaction boundaries (begin, commit, rollback) using API calls.
Declarative transaction management, which is more common and recommended in Spring applications, is handled using annotations like @Transactional. This abstracts away the underlying transaction management code.

# 20. What is Hibernate Caching?
Hibernate caching is a mechanism to reduce the number of database hits by storing entities or data in memory. It comes in two levels:

1. First-Level Cache: Enabled by default in Hibernate. It's associated with the Session object and caches objects within the scope of a session.
2. Second-Level Cache: An optional cache that can be configured to be shared across sessions at the SessionFactory level. It's useful for caching objects across multiple transactions and sessions.

# 21. Difference Between First-Level and Second-Level Cache
1. First-Level Cache:
+ Scope: Limited to a single session.
+ Lifespan: As long as the session is open.
+ Usage: Automatically used for each session.
2. Second-Level Cache:
+ Scope: Across sessions and transactions.
+ Lifespan: Typically, as long as the application is running.
+ Usage: Must be explicitly enabled and configured.

# 22. Understanding @Transactional
@Transactional is an annotation used in Spring to declare transactional boundaries declaratively. When applied to a class or method, it indicates that the method should be executed within a transactional context.
Key Features:
1. Rollback behavior: By default, transactions are rolled back on runtime exceptions but not on checked exceptions. This can be configured.
2. Propagation behavior: Defines how transactions relate to each other, such as required, requires new, supports, etc.
3. Isolation levels: Can be specified to define how transactions are isolated from one another.
4. Read-only status: Can be set to optimize performance for read-only operations.