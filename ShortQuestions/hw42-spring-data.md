## Q4 What is JPA and what is Hibernate?
JPA (Java Persistence API) is a Java specification for accessing, persisting, and managing data between Java objects/classes and a relational database. JPA is a specification and requires an implementation.
Hibernate is an open-source ORM (Object-Relational Mapping) framework for Java applications. It is one of the most popular JPA implementations, providing a framework for mapping an object-oriented domain model to a relational database

## Q5What is HikariCP, and what are the benefits of a connection pool?

HikariCP is a high-performance JDBC connection pool. It is lightweight, fast, and provides a robust connection pooling mechanism.
The benefits of a connection pool include reduced overhead in creating and closing connections, improved application performance by reusing existing connections, and better resource management by limiting the number of database connections.

## Q6 What is the @OneToMany, @ManyToOne, @ManyToMany? write some examples.

@OneToMany: Defines a single-valued association to a collection of another entity. Example: A User has many Orders.
@ManyToOne: Defines a many-to-one association to another entity. Example: Many Orders belong to one User.
@ManyToMany: Defines a many-valued association with many-to-many multiplicity. Example: A Student can attend many Courses and a Course can include many Students.

## Q7 What is the cascade = CascadeType.ALL, orphanRemoval = true? What are the other CascadeType and their features? In which situation we choose which one?

cascade = CascadeType.ALL means that the persistence will propagate (cascade) all EntityManager operations (PERSIST, REMOVE, REFRESH, MERGE, DETACH) to the relating entities.
orphanRemoval = true means that any child entity not contained in the parent entity's collection will be automatically removed.
Other CascadeType: MERGE, PERSIST, REMOVE, REFRESH, DETACH. Each type controls how operations are cascaded from parent to child entities.
Choosing CascadeType: Depends on the specific requirements of the relationship between entities. For example, PERSIST for new entities that should be persisted together, REMOVE for entities that should be deleted together.

## Q8 What is the fetch = FetchType.LAZY, fetch = FetchType.EAGER? what is the difference? In which situation you choose which one?

FetchType.LAZY: Data is fetched lazily when it is needed. It improves performance by avoiding unnecessary data loading.
FetchType.EAGER: Data is fetched immediately. It is useful when the data is always used and avoiding multiple round-trips to the database is a priority.
Choosing FetchType: Use LAZY for data that isn't always needed and to improve performance. Use EAGER for essential data that is always used after loading the entity.

## Q9 What is the rule of JPA naming convention? Shall we implement the method by ourselves? Could you list some examples?

JPA allows defining query methods directly in the repository interface. By following a specific naming convention, JPA can automatically generate the query.
Implementing method by ourselves: Not required for simple queries. JPA generates the implementation based on method names.
Examples: findByName, findByEmailAndName, findByActiveTrue, findByAgeGreaterThanEqual. These methods correspond to queries that search by name, both email and name, entities where active is true, and entities with age greater than or equal to a specified value, respectively.
## Q13 What is JPQL?
JPQL stands for Java Persistence Query Language, a platform-independent object-oriented query language defined as part of the Java Persistence API (JPA). It allows queries to be run against entities to retrieve data from a relational database in an object-oriented fashion.
## Q14 What is @NamedQuery and @NamedQueries?
@NamedQuery: An annotation used in JPA to declare a static, named query in an entity class. Each @NamedQuery annotation specifies a query and associates it with a name.
@NamedQueries: A container annotation that holds multiple @NamedQuery annotations. It's used to group several named queries on an entity class.
## Q15 What is @Query? In which Interface do we write the SQL or JPQL?
@Query: An annotation used in Spring Data JPA to define SQL or JPQL queries directly on repository methods.
SQL or JPQL queries annotated with @Query are typically written in repository interfaces that extend JpaRepository or one of the Spring Data repository interfaces.
## Q16 What is HQL and Criteria Queries?
HQL (Hibernate Query Language): A powerful query language, similar to SQL, but operates on Hibernate's entity objects rather than database tables. It is object-oriented and understands concepts like inheritance, polymorphism, and association.
Criteria Queries: A type-safe, programmatic way of building queries in Hibernate. It is used for defining complex queries programmatically where HQL is not sufficient or its dynamic query capabilities are needed.
## Q17 What is EnityManager?

EntityManager is the primary JPA interface used to interact with the persistence context. It manages the lifecycle of entities (persist, remove, merge, find) and queries over entities.

## Q18 What is SessionFactory and Session?

SessionFactory: A thread-safe, immutable cache of compiled mappings for a single database. It's used to instantiate Session objects for interactions with the database.
Session: A single-threaded, short-lived object representing a conversation between the application and the database. It's the main runtime interface between a Java application and Hibernate, providing methods for CRUD operations and querying.

## Q19 What is Transaction? How to manage your transaction?

A transaction is a sequence of operations performed as a single logical unit of work. A transaction must be atomic, consistent, isolated, and durable (ACID).
Transactions can be managed declaratively using the @Transactional annotation or programmatically by using the transaction APIs provided by Spring or JPA/Hibernate (e.g., EntityManager.getTransaction().begin() and .commit()).

## Q20 What is hibernate Caching?

Hibernate caching is a mechanism to reduce the number of database hits by keeping recently or frequently accessed data in memory. There are two types of caching in Hibernate:
First-level cache: Enabled by default and associated with the Session object. It ensures that each entity instance is loaded only once in the persistent context.
Second-level cache: Optional and associated with the SessionFactory object. It can be shared across different sessions and can cache data across transactions, sessions, and even applications.

##  Q21 What is the difference between first-level cache and second-level cache?

The first-level cache is associated with the Session scope and cannot be disabled. Each session maintains its own first-level cache.
The second-level cache is associated with the SessionFactory and is shared across sessions. It can cache objects across sessions and needs to be explicitly enabled.

## Q22 How do you understand @Transactional?

@Transactional is an annotation provided by Spring that manages transactions declaratively. It simplifies transaction management by allowing the developer to annotate classes or methods where transactional behavior is required. Spring manages the creation, commit, and rollback of transactions automatically based on the method's execution outcome. This approach separates transaction management from business logic, making the code cleaner and more maintainable. For more detailed insights and usage, you can refer to the tutorial or documentation provided by Spring at the specified URL or the official Spring documentation.
