### HW42 Spring Data

## Q4 What is JPA? What is Hibernate?

- JPA stands for Java Persistence API. It is a Java specification for accessing, persisting, and managing data between Java objects/classes and a relational database. JPA serves as a bridge between object-oriented domain models and relational database systems.

- Hibernate is an ORM (Object-Relational Mapping) framework for Java. It's one of the most popular and widely used JPA implementations. While JPA is a specification, Hibernate is a tool or framework that actually implements the specifications defined by JPA.

## Q5 What is Hikari? What is the benefits of connection pool?

Hikari is a high-performance JDBC connection pool for Java applications. A connection pool is a cache of database connections that are reusable, rather than being opened and closed for each new request to the database. Hikari is designed to be lightweight, fast, and efficient, making it a popular choice for managing database connections in Java applications.

Here are some benefits of using a connection pool:
1. **Improved Performance:** Reusing existing connections significantly reduces the time and resources spent in establishing new connections, especially important in high-load scenarios.

2. **Resource Management:** Connection pools limit the number of open connections to the database, which helps in effective resource management and prevents potential database crashes due to overload.

3. **Reduced Latency:** Since connections are readily available in the pool, the latency associated with database operations is reduced, leading to faster response times for the end-users.

4. **Scalability:** Connection pools can manage concurrent access to the database by allowing multiple threads to share a pool of connections. Hikari supports efficient and concurrent access, making it suitable for multi-threaded applications.


## Q6 What is the @OneToMany, @ManyToOne, @ManyToMany? write some examples.

`@OneToMany`, `@ManyToOne`, and `@ManyToMany` are annotations used to define relationships between entities in a relational database. These annotations help establish associations between entities and specify the cardinality of the relationships. Here are examples of each:

1. `@OneToMany` and `@ManyToOne`
```java
@Entity
public class User {
    @Id
    private Long id;

    @OneToMany(mappedBy = "user")
    private Set<Order> orders;
}

@Entity
public class Order {
    @Id
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}

```


3. `@ManyToMany`:
```java
@@Entity
public class Student {
    @Id
    private Long id;

    @ManyToMany
    @JoinTable(
        name = "student_course",
        joinColumns = @JoinColumn(name = "student_id"),
        inverseJoinColumns = @JoinColumn(name = "course_id")
    )
    private Set<Course> courses;
}

@Entity
public class Course {
    @Id
    private Long id;

    @ManyToMany(mappedBy = "courses")
    private Set<Student> students;
}
```

## Q7 What is the `cascade = CascadeType.ALL, orphanRemoval = true`? What are the other CascadeType and their features? In which situation we choose which one?

- `CascadeType.ALL `means that all persistence operations (such as persist, remove, refresh, merge, detach) that happen to the parent entity will also be cascaded to the associated child entity. For example, if you delete an entity, all its associated child entities will also be deleted.

- When `orphanRemoval` is set to true, it means that if a child entity is removed from the collection of children on the parent entity, it will be automatically removed from the database. This is useful for enforcing referential integrity at the object level. For example, if you have a parent entity Post with a collection of Comment entities and you remove a Comment from the Post's collection, that Comment will be automatically deleted from the database.

Other `CascadeType` options and their features:

1. `CascadeType.PERSIST`: Cascades the persist (save or create) operation. When the parent entity is persisted, the persist operation will also be cascaded to the child entities.

2. `CascadeType.MERGE`: During a merge operation (like updating an entity), any changes made to the parent entity will also be merged into the child entities.

3. `CascadeType.REMOVE`: When the parent entity is removed, the child entities are also removed.

4. `CascadeType.REFRESH`: If the parent entity is refreshed (reloaded from the database), the child entities will also be refreshed.

5. `CascadeType.DETACH`: When the parent entity is detached from the persistence context, the child entities are also detached.

Usage:
1. **Persisting and Merging**: `CascadeType.PERSIST` and `CascadeType.MERGE` are often used together in parent-child relationships where persisting or updating the parent should automatically persist/update the children.
2. **Referential Integrity**: `orphanRemoval = true` is typically used in one-to-many relationships where child entities no longer referenced by the parent should not exist independently (e.g., a comment that belongs to a specific post).


## Q8 What is the `fetch = FetchType.LAZY, fetch = FetchType.EAGER`? what is the difference? In which situation you choose which one?


1. **FetchType.LAZY**:

With lazy loading, the related entities are not loaded immediately with the parent entity. Instead, they are loaded on-demand when they are accessed for the first time. This approach is generally more efficient and is recommended in most cases because it avoids loading unnecessary data, especially when the related entities are not always needed. For example, if you have a User entity with many Order entities, using lazy loading will initially load only the User data. The Order data will be loaded only when you access the orders of that user.

2. **`FetchType.EAGER`:**

With eager loading, the related entities are loaded at the same time as the parent entity. This means all data is fetched in a single operation.
This can be useful when you know you will always need the related entities and want to avoid additional database queries.
However, it can lead to performance issues, especially if the relationship includes a large number of entities or if there are many eager relationships in your entity model.

- **Default Settings**: By default, `@ManyToOne` and `@OneToOne` associations are eager, while `@OneToMany` and `@ManyToMany` are lazy.

- **Use `FetchType.LAZY`:** If you don't always need related entities, or if there are many related entities that might not be used, prefer lazy loading to improve performance.

- **Use `FetchType.EAGER`:** Use eager loading when you are sure that you will need the related entities every time you fetch the parent entity and the size of the related data is manageable.

## Q9 What is the rule of JPA naming convention? Shall we implement the method by ourselves? Could you list some examples?

1. **Entity Names**: By default, the table name is assumed to be the same as the entity name. If the entity class name is `User`, the default table name would be `User`. You can override this with the `@Table` annotation.

2. **Column Names**: Similarly, column names default to the field names of the entity. For example, a field `firstName` in an entity corresponds to a column `first_name` in the table. Use the `@Column` annotation to specify a different column name.

3. **Repository Method Naming**: In Spring Data JPA, the naming of methods in repository interfaces is significant. It follows a pattern that allows the Spring framework to automatically generate the query implementation based on the method name. For example, `findByName(String name)` will generate a query that finds entities based on the name column.`findByAgeLessThan(int age)` generates a query to find entities where the age column value is less than the provided value. JPA supports various keywords in derived query method names, such as `And`, `Or`, `Between`, `LessThan`, `GreaterThan`, etc. These keywords are used to construct queries based on the specified criteria. Example: `findByFirstNameAndLastName(String firstName, String lastName)`

5. **Custom Named Queries:** You can define custom named queries in an entity using `@NamedQuery` or `@NamedQueries`. These queries can be named and then referenced in your code. This query is associated with a specific entity class and is typically defined within the entity class or its mapping file. Named queries are pre-defined in the entity class and can be referenced by their name in the EntityManager for executing queries.

```java
@Entity
@NamedQuery(
    name = "Employee.findByLastName",
    query = "SELECT e FROM Employee e WHERE e.lastName = :lastName"
)
public class Employee {
    @Id
    private Long id;

    private String firstName;
    private String lastName;
    // Other fields, getters and setters
}
```

```java
public List<Employee> findByLastName(String lastName) {
    return entityManager.createNamedQuery("Employee.findByLastName", Employee.class)
                        .setParameter("lastName", lastName)
                        .getResultList();
}

```
6. **Custom Query Methods:** You can define custom query methods in repository interfaces by using `@Query` annotations and providing the JPQL or SQL query.
```java
@Query("SELECT u FROM User u WHERE u.age < :age")
    List<User> findYoungerThan(@Param("age") int age);

```

## Q13 What is JPQL?
JPQL stands for Java Persistence Query Language. It is a query language defined as part of the Java Persistence API (JPA) specification. JPQL is used to make queries against entities stored in a relational database. It is similar in nature to SQL, but it operates on the entity objects rather than the database tables. This makes it a high-level object-oriented query language.


## Q14 What is @NamedQuery and @NamedQueries?
- The `@NamedQuery` annotation is used to specify a single named query for an entity. It is declared on the entity class and allows defining a query with a name and the JPQL (Java Persistence Query Language) query string. This query can be later referred to by this name in different parts of the application. Example: 
``` java
@Entity
@NamedQuery(name = "Employee.findAll", query = "SELECT e FROM Employee e")
public class Employee {
    // Entity fields, constructors, getters, and setters
}

```
- The `@NamedQueries` annotation is a container annotation that holds multiple `@NamedQuery` annotations. This is useful when you have several named queries for a single entity class and you want to group them together for better organization and readability. Example:
```java
@Entity
@NamedQueries({
    @NamedQuery(name = "Employee.findAll", query = "SELECT e FROM Employee e"),
    @NamedQuery(name = "Employee.findByDepartment", query = "SELECT e FROM Employee e WHERE e.department = :department")
})
public class Employee {
    // Entity fields, constructors, getters, and setters
}

```

## Q15 What is @Query? In which Interface do we write the SQL or JPQL?

`@Query` is an annotation used in Spring Data JPA, a part of the larger Spring framework, to define SQL or JPQL queries directly on repository interface methods. This annotation allows for the execution of both standard JPA queries and native SQL queries, providing flexibility in how data is retrieved or manipulated.


Example using JPQL:
```JAVA
public interface UserRepository extends JpaRepository<User, Long> {
    @Query("SELECT u FROM User u WHERE u.email = ?1")
    User findByEmail(String email);
}

```

Example using native SQL:
```java
public interface UserRepository extends JpaRepository<User, Long> {
    @Query(value = "SELECT * FROM users WHERE email = ?1", nativeQuery = true)
    User findByEmailNative(String email);
}

```

## Q16 What is HQL and Criteria Queries?

- HQL, or Hibernate Query Language, is the object-oriented query language of Hibernate, which is a popular ORM (Object-Relational Mapping) framework in Java. HQL is very similar to SQL (Structured Query Language), but it operates on the persistent entities and their properties instead of directly dealing with database tables and columns. This makes HQL fully object-oriented and integrated with the concepts of Java and Hibernate.

```java
String hql = "FROM Employee E WHERE E.id = 10";
Query query = session.createQuery(hql);
List results = query.list();

```

- Criteria Queries are another way of defining and executing database operations in Hibernate. Unlike HQL, which uses string-based queries, Criteria Queries are built programmatically using a specific API. This approach is more dynamic and type-safe, as it allows constructing a query at runtime without dealing with strings and is less prone to errors like syntax issues.

```java
CriteriaBuilder cb = session.getCriteriaBuilder();
CriteriaQuery<Employee> cr = cb.createQuery(Employee.class);
Root<Employee> root = cr.from(Employee.class);
cr.select(root).where(cb.equal(root.get("id"), 10));

Query<Employee> query = session.createQuery(cr);
List<Employee> results = query.getResultList();

```


## Q17 What is EnityManager?

EntityManager is a core class in the Java Persistence API (JPA), which is used for managing the persistence of entities in relational databases. It acts as an interface between the Java application and the underlying database, enabling CRUD (Create, Read, Update, Delete) operations, transaction management, and query execution on the entities.

Key aspects and functionalities of EntityManager include:

1. Entity Lifecycle Management: EntityManager is responsible for managing the life cycle of entities which includes states like new, managed, detached, and removed. It handles operations such as persisting new entities, merging detached entities, and removing entities.

2. Transaction Management: It allows controlling transactions at a fine-grained level. Operations can be wrapped in transactions to ensure data integrity and consistency. This is crucial in scenarios where multiple operations need to be executed as a single unit of work.

3. Query Execution: EntityManager provides methods to execute both JPQL (Java Persistence Query Language) and native SQL queries. It also supports named queries and the Criteria API for building dynamic queries.

4. Persistence Context: It maintains a persistence context, a set of entity instances, where each instance is associated with a unique entity in the database. This context acts as a cache and helps in reducing the number of database hits.

5. Entity Association and Lazy Loading: It manages entity associations (like OneToMany, ManyToOne) and supports lazy loading, whereby associated entities are loaded on demand, improving performance.

6. Flush and Refresh Operations: EntityManager can flush changes to the database before the transaction is committed. It can also refresh entity state from the database, overriding changes made to the entity if needed.



Example:
```java
public class PostDAO {

    @PersistenceContext
    private EntityManager entityManager;

    public Post find(Long id) {
        return entityManager.find(Post.class, id);
    }

    public void save(Post post) {
        entityManager.persist(post);
    }

    public Post update(Post post) {
        return entityManager.merge(post);
    }

    public void delete(Post post) {
        entityManager.remove(post);
    }

    public List<Post> findAll() {
        return entityManager.createQuery("SELECT p FROM Post p", Post.class).getResultList();
    }

    // Additional methods like adding a comment to a post
    public void addComment(Long postId, Comment comment) {
        Post post = find(postId);
        post.getComments().add(comment);
        comment.setPost(post);
        entityManager.persist(comment);
    }
}

```


## Q18 What is SessionFactory and Session?

- **SessionFactory**: 
    - The SessionFactory is a heavyweight object that serves as a factory for Session instances. It's typically created once during application initialization and used throughout the application's lifetime.

    - Function: It holds configuration data such as database connection properties, mapping setup (entity to table mappings), and other configuration settings necessary for establishing a connection with the database.

    - Lifecycle: A SessionFactory is a thread-safe object and intended to be shared among all application threads. Creating a SessionFactory is an expensive operation in terms of resources and time, so it's usually done once during application startup.

    - Usage: It's used to create Session instances for interactions with the database.

```java
Configuration configuration = new Configuration().configure();
SessionFactory sessionFactory = configuration.buildSessionFactory();

```

- **Session**:
    - The Session in Hibernate is a lightweight object that represents a single unit of work with the database, wrapping a JDBC connection.
    - It is created by the `SessionFactory` and is responsible for managing the lifecycle of persistent objects.
    - The Session holds a first-level cache of retrieved entities, ensuring that within a single session context, entities are consistent and only retrieved once from the database even if queried multiple times.
    - Function: It's used to create, read, update, and delete entity objects. It also provides transaction management capabilities (begin, commit, or rollback transactions).
    - Lifecycle: A Session is not thread-safe and should be created and destroyed as needed, typically for each transaction or request. 

- **Example:**
```java
try (Session session = sessionFactory.openSession()) {
    session.beginTransaction();
    // Perform database operations
    session.getTransaction().commit();
}

```

## Q19 What is Transaction? How to manage your transaction?
A transaction is a sequence of one or more operations (database queries, updates, or other changes) that are executed as a single unit of work. Transactions ensure the consistency and integrity of the database by allowing a set of operations to either succeed as a whole or fail as a whole. 

Transaction Management:

1. **JPA`EntityTransaction`:** `EntityTransaction` is the interface in JPA for managing transactions.
    
```java
EntityTransaction transaction = entityManager.getTransaction();
try {
    transaction.begin();
    // business logic
    transaction.commit();
} catch (RuntimeException e) {
    transaction.rollback();
    throw e;
}

```

2. **Hibernate `Transaction`:** `Transaction` is the interface in Hibernate for managing transactions. It provides methods like `begin`, `commit`, `rollback`, and `isActive`
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
3. **@Transactional**
```java
@Transactional
    public void transferMoney(Long fromAccountId, Long toAccountId, Double amount) {
        Account fromAccount = accountRepository.findById(fromAccountId).orElseThrow();
        Account toAccount = accountRepository.findById(toAccountId).orElseThrow();

        fromAccount.debit(amount);
        toAccount.credit(amount);

        accountRepository.save(fromAccount);
        accountRepository.save(toAccount);
    }
```

## Q20 What is hibernate Caching?

In Hibernate, there are two main types of caching: First Level Cache and Second Level Cache, along with Query Cache. These caches store data that has been retrieved from the database to avoid repeated database hits for the same data.


- First-Level Cache:
The First Level Cache is associated with the Session object and is enabled by default in Hibernate. It's a mandatory cache through which all database requests must pass. The scope of this cache is limited to a single session and it can't be shared between different sessions. When an entity is looked up, added, or removed in a session, these changes are reflected in the First Level Cache.


- Second Level Cache:
Unlike the First Level Cache, the Second Level Cache is session-independent and is shared among sessions. It needs to be explicitly enabled in Hibernate.
This cache stores entities, collections, and queries results across sessions, which significantly reduces the number of database queries for frequently accessed data. Example:

```java
@Entity
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String author;

    // Getters and Setters
}
```
```java
Session session1 = sessionFactory.openSession();
Book book1 = session1.get(Book.class, 1L); // Retrieves and caches the Author entity in second-level cache
session1.close(); // Closes the session

Session session2 = sessionFactory.openSession();
Book book2 = session2.get(Book.class, 1L); // Retrieves from second-level cache (no database query)

```


## Q21 What is the difference between first-level cache and second-level cache?
1. First-Level Cache:

- Scope: The First-Level Cache is associated with the `Session` object and is enabled by default. It is a mandatory cache and each session in Hibernate has its own First-Level Cache.

- Lifetime: The cache is alive as long as the session object is alive. It is destroyed when the session is closed.

- Usage: It stores entities that are retrieved within a session. If an entity is fetched more than once within the same session, Hibernate retrieves it from the cache, reducing the number of database hits.

- Isolation: It is limited to a single session and is not accessible by other sessions.


2. Second-Level Cahce:
- Scope: The Second-Level Cache is session factory scoped, meaning it is shared by all sessions created using the same session factory. It is not enabled by default and requires explicit configuration.

- Lifetime: This cache lives as long as the session factory is alive, and thus can span multiple sessions and transactions.

- Usage: It stores entities, collections, and query results that are shared across sessions. This reduces the number of database queries for frequently accessed data.

- Shared: Since it is associated with the session factory, it can be accessed by any session created by that particular session factory.


## Q22 How do you understand @Transactional?
- Scope: When a method annotated with @Transactional is executed, all the database operations performed within this method are part of a single database transaction.

- Rollback: By default, a transaction will be rolled back on runtime exceptions. However, you can customize this behavior by specifying which exceptions should cause a rollback and which should not.

- Propagation: The `@Transactional` annotation supports the `propagation` attribute to define how transactions should behave when methods are called from within other methods annotated with `@Transactional`. Options include `REQUIRED`, `REQUIRES_NEW`, `NESTED`, etc.

- Isolation Level: The `isolation` attribute allows you to specify the isolation level of the transaction (e.g., `READ_COMMITTED`, `SERIALIZABLE`). It defines the degree to which the changes made within the transaction are visible to other transactions.
