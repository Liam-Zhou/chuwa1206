### What is JPA? What is Hibernate?
  
JPA, which stands for Java Persistence API, is a Java specification for accessing, managing, and persisting data between Java objects and relational databases. It provides a standard interface for Java applications to interact with relational databases, allowing developers to perform database operations using Java objects and queries rather than directly dealing with SQL.

Hibernate is an implementation of the JPA specification. It is a popular open-source object-relational mapping (ORM) framework for Java that simplifies database programming in Java applications. Hibernate maps Java objects to database tables and vice versa, handling the translation between the object-oriented model of Java and the relational model of databases. It provides a powerful and flexible way to interact with databases while abstracting many of the complexities associated with database operations.

### What is Hikari? What is the benefits of connection pool?

Hikari is a high-performance JDBC connection pool for Java applications. A connection pool is a cache of database connections that are reused, rather than being opened and closed for each new request to the database. Hikari is designed to be lightweight, fast, and efficient, making it a popular choice for managing database connections in Java applications.

Here are some benefits of using a connection pool:
1. **Improved Performance:** Connection pools help improve performance by reusing existing database connections. Opening and closing connections are resource-intensive operations, and reusing connections reduces the overhead associated with these operations. Hikari, being a high-performance pool, minimizes the time it takes to acquire and release connections.
    
2. **Resource Management:** Connection pools manage the number of active connections to the database, preventing a situation where too many connections overwhelm the database server. Hikari provides efficient connection management, ensuring that the application doesn't exhaust database resources.
    
3. **Connection Reuse:** Reusing connections rather than creating new ones for each request reduces the latency associated with establishing a new connection. Hikari is designed for low-latency connection acquisition and release, contributing to improved application responsiveness.
    
4. **Concurrency:** Connection pools can manage concurrent access to the database by allowing multiple threads to share a pool of connections. Hikari supports efficient and concurrent access, making it suitable for multi-threaded applications.
    
5. **Configurability:** Hikari allows for fine-tuning and configuration to match the specific needs of an application. It provides various configuration options, allowing developers to optimize the pool size, timeouts, and other parameters based on the application's requirements and the characteristics of the database server.

### What is the @OneToMany, @ManyToOne, @ManyToMany? write some examples.

`@OneToMany`, `@ManyToOne`, and `@ManyToMany` are annotations used to define relationships between entities in a relational database. These annotations help establish associations between entities and specify the cardinality of the relationships. Here are examples of each:

1. `@OneToMany`
```java
@Entity
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @OneToMany(mappedBy = "author")
    private List<Book> books;
    
    // Getters and setters
}

```

2. `@ManyToOne`:
```java
@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;

    @ManyToOne
    @JoinColumn(name = "author_id")
    private Author author;
    
    // Getters and setters
}

```

3. `@ManyToMany`:
```java
@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @ManyToMany
    @JoinTable(name = "student_course",
        joinColumns = @JoinColumn(name = "student_id"),
        inverseJoinColumns = @JoinColumn(name = "course_id"))
    private List<Course> courses;
    
    // Getters and setters
}

```
```java
@Entity
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String courseName;

    @ManyToMany(mappedBy = "courses")
    private List<Student> students;
    
    // Getters and setters
}

```

### What is the cascade = CascadeType.ALL, orphanRemoval = true? What are the other CascadeType and their features? In which situation we choose which one?

In JPA, the `cascade` attribute and `orphanRemoval` attribute are used to define the behavior of related entities when operations are performed on their parent entities. These attributes help manage the cascading effect of operations such as persisting, merging, removing, or refreshing entities.

 When `CascadeType.ALL` is specified, it means that all operations (persist, merge, remove, refresh) on the parent entity should be cascaded to the related entities.
 The `orphanRemoval` attribute is used to specify whether orphaned child entities should be automatically removed when they are no longer referenced by the parent entity. If set to `true`, when you remove a `Book` from the list of books in an `Author` entity, and that `Book` is not referenced by any other author, it will be automatically deleted from the database.
- example:
```java
@OneToMany(mappedBy = "author", cascade = CascadeType.ALL, orphanRemoval = true)
private List<Book> books;
```
In this case, if you persist, merge, remove, or refresh an `Author` entity, the same operation will be applied to all associated `Book` entities.

other `CascadeType` options and their features:

- **`CascadeType.PERSIST`:**
    
    - Cascades the `persist` operation to the associated entities. For example, if you persist an `Author`, all associated `Book` entities will also be persisted.
- **`CascadeType.MERGE`:**
    
    - Cascades the `merge` operation to the associated entities. When you merge an `Author`, all associated `Book` entities will also be merged.
- **`CascadeType.REFRESH`:**
    
    - Cascades the `refresh` operation to the associated entities. If you refresh an `Author`, all associated `Book` entities will also be refreshed.
- **`CascadeType.REMOVE`:**
    
    - Cascades the `remove` operation to the associated entities. If you remove an `Author`, all associated `Book` entities will also be removed.
- **`CascadeType.DETACH`:**
    
    - Cascades the `detach` operation to the associated entities. If you detach an `Author`, all associated `Book` entities will also be detached.
- **`CascadeType.ALL`:**
    
    - Cascades all operations (PERSIST, MERGE, REMOVE, REFRESH, DETACH) to the associated entities.

### What is the fetch = FetchType.LAZY, fetch = FetchType.EAGER? what is the difference? In which situation you choose which one?

  
In JPA, the `fetch` attribute is used to define how related entities should be loaded when querying for an entity. There are two options for the `fetch` attribute: `FetchType.LAZY` and `FetchType.EAGER`.

1. **`FetchType.LAZY`:**
    
    - When `FetchType.LAZY` is specified, it means that the related entities are not loaded immediately when the parent entity is fetched. Instead, they are loaded lazily, on-demand, only when the application attempts to access them. Lazy loading is beneficial for performance, especially when dealing with large and complex object graphs.

2. **`FetchType.EAGER`:**

- When `FetchType.EAGER` is specified, it means that the related entities are loaded immediately along with the parent entity. Eager loading can be useful when you know that you will frequently access the related entities and want to minimize the number of database queries.


- **Use `FetchType.LAZY` when:**
    
    - You have a large number of related entities, and loading them eagerly may result in unnecessary performance overhead.
    - You want to optimize performance by loading related entities only when needed.
    - You want to minimize the amount of data loaded initially.
- **Use `FetchType.EAGER` when:**
    
    - You know that you will frequently access the related entities along with the parent entity.
    - The number of related entities is relatively small, and the performance impact of eager loading is acceptable.
    - You want to reduce the number of additional queries needed to fetch related entities.


1. **Entity Naming:**
    
    - By default, the name of the entity class corresponds to the name of the database table. If the entity class name is `Author`, the corresponding table name is assumed to be `Author`.
2. **Attribute Naming:**
    
    - By default, the name of the attribute corresponds to the name of the database column. If the attribute name is `firstName`, the corresponding column name is assumed to be `first_name`.
3. **Query Method Naming (Derived Queries):**
    
    - JPA provides the ability to automatically generate queries based on method names in the repository interfaces. The convention for query method names is derived from the names of the entity attributes.
    - Example: If you have an attribute `findByFirstName(String firstName)` in a repository interface, Spring Data JPA will automatically generate a query to find entities by the `firstName` attribute.
4. **Derived Query Method Keywords:**
    
    - JPA supports various keywords in derived query method names, such as `And`, `Or`, `Between`, `LessThan`, `GreaterThan`, etc. These keywords are used to construct queries based on the specified criteria.
    - Example: `findByFirstNameAndLastName(String firstName, String lastName)`
5. **Custom Named Queries:**
    
    - You can define custom named queries in an entity using `@NamedQuery` or `@NamedQueries`. These queries can be named and then referenced in your code.
    - This query is associated with a specific entity class and is typically defined within the entity class or its mapping file. Named queries are pre-defined in the entity class and can be referenced by their name in the EntityManager for executing queries.
```java
@NamedQuery(name = "Author.findByLastName", query = "SELECT a FROM Author a WHERE a.lastName = :lastName")

```
6. **Custom Query Methods:**

- You can define custom query methods in repository interfaces by using `@Query` annotations and providing the JPQL or SQL query.
```java
@Query("SELECT a FROM Author a WHERE a.age > :age")
List<Author> findByAgeGreaterThan(@Param("age") int age);

```

7. **Table and Column Annotations:**

- You can use `@Table` and `@Column` annotations to explicitly specify the table and column names if they deviate from the default naming conventions

While JPA provides default behavior based on these conventions, you can implement methods yourself when needed.

### What is JPQL?
JPQL, or Java Persistence Query Language, is a query language defined as part of the Java Persistence API (JPA) for querying entities stored in a relational database. It is similar to SQL (Structured Query Language), but it operates on Java objects and entities rather than on database tables. JPQL is used to express queries against the entity objects defined in your data model.


### What is @NamedQuery and @NamedQueries?
`@NamedQuery` and `@NamedQueries` are annotations in JPA that allow you to define named queries at the entity level. These named queries can then be referenced and executed using the EntityManager.`@NamedQueries` is used to define multiple named queries for an entity.

### What is @Query? In which Interface do we write the SQL or JPQL?

`@Query` is an annotation in Spring Data JPA that allows you to define custom queries directly in a repository interface. You can use it to specify JPQL (Java Persistence Query Language) or native SQL queries to be executed by Spring Data JPA.

Example using JPQL:
```JAVA
public interface UserRepository extends JpaRepository<User, Long> {
    @Query("SELECT u FROM User u WHERE u.email = :email")
    User findByEmail(@Param("email") String email);
}

```

Example using native SQL:
```java
public interface UserRepository extends JpaRepository<User, Long> {
    @Query(value = "SELECT * FROM users WHERE email = :email", nativeQuery = true)
    User findByEmail(@Param("email") String email);
}

```



**HQL (Hibernate Query Language):**

- HQL is an object-oriented query language used in Hibernate, which is an implementation of JPA.
    
- It is similar to SQL but operates on Hibernate-managed entities instead of database tables.

### What is HQL and Criteria Queries?
**Criteria Queries:**

- Criteria Queries are a programmatic way to create queries using a set of Java API classes. It is a type-safe and more dynamic approach for building queries.
    
- Criteria Queries are not tied to a specific persistence provider and can be used with JPA and Hibernate.

Example:
```java
CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
CriteriaQuery<User> criteriaQuery = criteriaBuilder.createQuery(User.class);
Root<User> root = criteriaQuery.from(User.class);
criteriaQuery.select(root).where(criteriaBuilder.equal(root.get("email"), "user@example.com"));
List<User> users = entityManager.createQuery(criteriaQuery).getResultList();

```


### What is EnityManager?

The `EntityManager` is a key interface in the Java Persistence API (JPA) that provides methods for interacting with the persistence context, which represents the entity objects in the database. It serves as a bridge between your application and the underlying database, allowing you to perform operations such as persisting, merging, removing, and querying entities.

Key features and responsibilities of `EntityManager` include:

1. **Entity Operations:**
    
    - `persist`: Adds a new entity instance to the persistence context.
    - `merge`: Merges the state of a detached entity into the persistence context.
    - `remove`: Removes an entity from the persistence context and database.
    - `find`: Retrieves an entity by its primary key.
    - `flush`: Synchronizes the persistence context with the database.
2. **Transaction Management:**
    
    - `getTransaction`: Retrieves the current `EntityTransaction` for managing transactions.
    - `joinTransaction`: Associates the `EntityManager` with the current JTA (Java Transaction API) transaction.
3. **Query Execution:**
    
    - `createQuery`: Creates an instance of `Query` for executing JPQL (Java Persistence Query Language) queries.
    - `createNamedQuery`: Creates an instance of `Query` for executing named queries.
    - `createNativeQuery`: Creates an instance of `Query` for executing native SQL queries.
4. **Lifecycle Management:**
    
    - `persist`: Manages the lifecycle of an entity by making it persistent.
    - `detach`: Detaches an entity from the persistence context.
    - `clear`: Clears the persistence context, detaching all managed entities.
5. **Caching:**
    
    - The `EntityManager` maintains a first-level cache (persistence context) to track managed entities and ensure consistency.

Example:
```java
EntityManager entityManager = // obtain EntityManager instance
EntityTransaction transaction = entityManager.getTransaction();

try {
    transaction.begin();

    // Create and persist a new entity
    Author author = new Author();
    author.setName("John Doe");
    entityManager.persist(author);

    transaction.commit();
} catch (Exception e) {
    if (transaction != null && transaction.isActive()) {
        transaction.rollback();
    }
    e.printStackTrace();
} finally {
    entityManager.close();
}

```

In this example, the `persist` method is used to make the `Author` entity persistent within a transaction managed by the `EntityTransaction` interface.

### What is SessionFactory and Session?

### SessionFactory:

- **Definition:**
    
    - The `SessionFactory` is a factory class in Hibernate responsible for creating `Session` instances.
    - It is a heavyweight object and is typically created once during the application's initialization.
    - The `SessionFactory` is thread-safe and designed to be shared among multiple application threads.
- **Creation:**
    
    - A `SessionFactory` is usually created by configuring Hibernate with a `hibernate.cfg.xml` file or programmatically.
- **Responsibilities:**
    
    - Manages database connections and provides a pool of database connections.
    - Acts as a factory for creating `Session` instances.
    - Holds configuration settings for Hibernate, such as database connection details, dialect, etc.
- **Example:**
```java
Configuration configuration = new Configuration().configure("hibernate.cfg.xml");
ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);

```

### Session:

- **Definition:**
    
    - A `Session` is a lightweight object representing a single-threaded, short-lived unit of work in Hibernate.
    - It is created by the `SessionFactory` and is responsible for managing the lifecycle of persistent objects.
- **Responsibilities:**
    
    - Performs database operations (CRUD operations) on entities.
    - Manages the first-level cache (persistence context) for tracked entities.
    - Provides methods for querying the database using HQL (Hibernate Query Language) or native SQL.
    - Represents a transaction boundary, where changes are persisted to the database.
- **Creation:**
    
    - A `Session` is typically created and closed within the scope of a single unit of work or a transaction.
- **Example:**
```java
SessionFactory sessionFactory = // obtain SessionFactory
Session session = sessionFactory.openSession();

// Perform database operations, queries, etc.

session.close(); // Close the session when done

```

In summary, the `SessionFactory` is a central, heavyweight factory responsible for creating `Session` instances in Hibernate. Each `Session` represents a unit of work and is used for database operations, entity tracking, and querying. The `SessionFactory` is thread-safe and shared among multiple application threads, while `Session` instances are short-lived and single-threaded.

### What is Transaction? How to manage your transaction?
A transaction is a sequence of one or more operations (database queries, updates, or other changes) that are executed as a single unit of work. Transactions ensure the consistency and integrity of the database by allowing a set of operations to either succeed as a whole or fail as a whole. In the context of databases and ORM frameworks like Hibernate or JPA, transactions are essential for maintaining data integrity.

### Transaction Management:

Transaction management involves the initiation, execution, and completion of transactions. In the context of Hibernate and JPA, the key interfaces for transaction management are `EntityTransaction` and `Transaction`.

1. **JPA (Java Persistence API) - `EntityTransaction`:**
    
    - `EntityTransaction` is the interface in JPA for managing transactions.
    - It provides methods such as `begin`, `commit`, `rollback`, and `isActive` to control the transaction lifecycle.
```java
EntityManager entityManager = // obtain EntityManager instance
EntityTransaction transaction = entityManager.getTransaction();

try {
    transaction.begin();

    // Perform database operations within the transaction

    transaction.commit(); // Commit the transaction if successful
} catch (Exception e) {
    if (transaction != null && transaction.isActive()) {
        transaction.rollback(); // Rollback the transaction in case of an exception
    }
    e.printStackTrace();
} finally {
    entityManager.close(); // Close the EntityManager when done
}

```

2. **Hibernate - `Transaction`:**
    
    - In Hibernate, the `Transaction` interface is used for managing transactions.
    - It provides methods like `begin`, `commit`, `rollback`, and `isActive`
```java
SessionFactory sessionFactory = // obtain SessionFactory
Session session = sessionFactory.openSession();
Transaction transaction = session.getTransaction();

try {
    transaction.begin();

    // Perform database operations within the transaction

    transaction.commit(); // Commit the transaction if successful
} catch (Exception e) {
    if (transaction != null && transaction.isActive()) {
        transaction.rollback(); // Rollback the transaction in case of an exception
    }
    e.printStackTrace();
} finally {
    session.close(); // Close the Session when done
}

```

### Transaction Best Practices:

1. **Begin and Commit/Rollback:**
    
    - Always begin a transaction before performing database operations and commit or rollback the transaction based on the outcome.
2. **Exception Handling:**
    
    - Use proper exception handling to catch and handle exceptions within the transaction. Rollback the transaction in case of an exception.
3. **Resource Cleanup:**
    
    - Close the `EntityManager` or `Session` after completing the transaction. This ensures that resources are released.
4. **Isolation Levels:**
    
    - Understand and choose the appropriate isolation level for your transactions based on concurrency requirements.
5. **Nested Transactions (if supported):**
    
    - Be cautious with nested transactions. Ensure that your database and ORM framework support nested transactions, and understand their behavior.
6. **Automatic Transaction Management (Spring):**
    
    - If using the Spring framework, consider leveraging its declarative transaction management features using `@Transactional` annotations.

### What is hibernate Caching?
  
Hibernate caching refers to the mechanism by which Hibernate can store and manage data in a cache to improve the performance of database operations. Caching helps reduce the number of database queries by storing frequently accessed data in memory, thereby minimizing the overhead of fetching data from the database repeatedly.

There are two main types of caching in Hibernate: first-level cache (session-level cache) and second-level cache (SessionFactory-level cache).
![[Pasted image 20240117153413.png]]



### 1. First-Level Cache:

- **Scope:** The first-level cache is associated with the `Session` in Hibernate.
- **Lifecycle:** It exists for the duration of a `Session`.
- **Responsibility:** It caches objects that are currently in use by the `Session`.
- **Usage:** When you load an entity using `session.get()` or `session.load()`, the entity is stored in the first-level cache.

Example:
```java
Session session = sessionFactory.openSession();
Author author1 = session.get(Author.class, 1L); // Retrieves and caches the Author entity
Author author2 = session.get(Author.class, 1L); // Retrieves from cache (no database query)

```

### 2. Second-Level Cache:

- **Scope:** The second-level cache is associated with the `SessionFactory` in Hibernate.
- **Lifecycle:** It spans multiple `Sessions` and is shared across the entire application.
- **Responsibility:** It caches objects at a higher level, allowing multiple `Sessions` to share cached data.
- **Usage:** Entities or query results can be configured to be cached in the second-level cache.

Example:
```java
// Enabling second-level cache for an entity
@Entity
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Author {
    // Entity definition
}

```

```java
Session session1 = sessionFactory.openSession();
Author author1 = session1.get(Author.class, 1L); // Retrieves and caches the Author entity in second-level cache
session1.close(); // Closes the session

Session session2 = sessionFactory.openSession();
Author author2 = session2.get(Author.class, 1L); // Retrieves from second-level cache (no database query)

```


### Caching Strategies:

- **Read-Only:** Suitable for entities that rarely change. Optimizes read operations.
- **Read-Write:** Suitable for entities that are frequently updated. Maintains consistency between the cache and the database.
- **Nonstrict Read-Write:** Similar to read-write, but provides more relaxed locking semantics.
- **Transactional:** Suitable for entities updated within a transaction. Ensures data consistency within the transaction.

### What is the difference between first-level cache and second-level cache?
### 1. First-Level Cache:

- **Scope:**
    
    - The first-level cache is associated with the `Session` in Hibernate.
    - It is local to and specific to a single Hibernate `Session`.
- **Lifecycle:**
    
    - The first-level cache exists for the duration of a `Session`.
    - It is created and managed by the `Session`.
- **Responsibility:**
    
    - The first-level cache caches objects that are currently in use by the `Session`.
    - It stores entities that have been retrieved or loaded within the current `Session`.
- **Usage:**
    
    - When you load an entity using `session.get()` or `session.load()`, the entity is stored in the first-level cache.
    - Subsequent requests for the same entity within the same `Session` can be served from the first-level cache without hitting the database.
- **Isolation:**
    
    - The first-level cache is isolated to a single `Session`, so changes made in one `Session` are not visible to other `Sessions`.

### 2. Second-Level Cache:

- **Scope:**
    
    - The second-level cache is associated with the `SessionFactory` in Hibernate.
    - It spans multiple `Sessions` and is shared across the entire application.
- **Lifecycle:**
    
    - The second-level cache persists beyond the scope of a single `Session`.
    - It is created and managed by the `SessionFactory`.
- **Responsibility:**
    
    - The second-level cache caches objects at a higher level, allowing multiple `Sessions` to share cached data.
    - It can cache entities or query results.
- **Usage:**
    
    - Entities or query results can be configured to be cached in the second-level cache.
    - Cached data is accessible to multiple `Sessions`, promoting data sharing and reducing the need for repeated database queries.
- **Isolation:**
    
    - The second-level cache is shared among multiple `Sessions`, so changes made in one `Session` can be visible to other `Sessions`.

### Use Cases:

- **First-Level Cache:**
    
    - Optimal for handling the caching needs within a single `Session`.
    - Well-suited for short-lived units of work or transactions.
- **Second-Level Cache:**
    
    - Useful for caching data that can be shared across multiple `Sessions`.
    - Beneficial for improving performance by reducing the number of database queries across different units of work.

In summary, the first-level cache is local to a single `Session`, while the second-level cache is shared across multiple `Sessions` and persists beyond the scope of a single unit of work. Both caches play crucial roles in optimizing database interactions in Hibernate applications, and their use depends on the specific requirements and characteristics of the application.

### How do you understand @Transactional?
The `@Transactional` annotation is a metadata-driven annotation in Spring that is used to define the scope of a database transaction. It indicates that a method (or all methods within a class) should be wrapped in a transaction, ensuring that the operations within the annotated scope are treated as a single, atomic unit of work with regard to database transactions.

Here are key aspects of understanding `@Transactional`:

1. **Transaction Management:**
    
    - The annotation is part of Spring's declarative transaction management.
    - It simplifies the management of transactions by allowing developers to specify the transactional behavior at the method or class level rather than dealing with low-level transaction APIs.
2. **Scope of Transactions:**
    
    - The `@Transactional` annotation can be applied at the method level (to annotate a specific method) or at the class level (to annotate all methods in a class).
    - It defines the scope within which the annotated operations should be executed as a single transaction.
3. **Rollback Behavior:**
    
    - By default, a transaction is committed if the annotated method completes successfully and is rolled back if an exception is thrown.
    - You can customize the rollback behavior using the `rollbackFor` and `noRollbackFor` attributes to specify exceptions that trigger a rollback or do not trigger a rollback, respectively.
```java
@Transactional(rollbackFor = CustomException.class)
public void exampleMethod() {
    // ...
}

```
4. **Propagation:**

- The `@Transactional` annotation supports the `propagation` attribute to define how transactions should behave when methods are called from within other methods annotated with `@Transactional`.
- Options include `REQUIRED`, `REQUIRES_NEW`, `NESTED`, etc.
```java
@Transactional(propagation = Propagation.REQUIRED)
public void outerMethod() {
    innerMethod();
}

@Transactional(propagation = Propagation.REQUIRES_NEW)
public void innerMethod() {
    // ...
}

```
5. **Isolation Level:**

- The `isolation` attribute allows you to specify the isolation level of the transaction (e.g., `READ_COMMITTED`, `SERIALIZABLE`).
- It defines the degree to which the changes made within the transaction are visible to other transactions.
```java
@Transactional(isolation = Isolation.READ_COMMITTED)
public void isolatedMethod() {
    // ...
}

```
6. **Transaction Management in Spring Boot:**

- In a Spring Boot application, you can use the `@SpringBootApplication` annotation, which implicitly includes `@EnableTransactionManagement`, enabling automatic transaction management.
- You can then use `@Transactional` without additional configuration.
```java
@SpringBootApplication
public class MyApplication {
    public static void main(String[] args) {
        SpringApplication.run(MyApplication.class, args);
    }
}

```
