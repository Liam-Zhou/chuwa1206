# Homework 9



## What is JPA? and what is Hibernate?



- JPA is a **standard** of *Object Relational Mapping(ORM)*. It is an **interface** that *defines a set of annotations for creating the object-relational mapping*.
- The most popular ORM framework is Hibernate

- JPA uses JDBC to CRUD database (relational) and also transfers results from the database to Java Entities.



## What is Hiraki? What are the benefits of a connection pool?



- Hiraki is the default connection pool of the Spring framework. 

- Connection Pool has similar benefits to a threading pool since we don't have to frequently create and destroy connections which is resource-consuming.



## What is the @OneToMany @ManyToOne @ManyToMany?



- These are annotations for data relationships in entities, which correspond to the foreign keys in relational databases



```java
@OneToOne(cascade=CascadeType.ALL)
@JoinColumn(name="profile_id", referencedColumnName="id")
private PlayerProfile playerProfile;

// In Comments
@ManyToOne(fetch=FetchType.LAZY)
@JoinColumn(name="post_id", nullable=false)
private Post post;
// In Post
@OneToMany(mappedBy="post", CascadeType.ALL, orphanRemoval=true)
private Set<Comment> comments = new HashSet<>();

@ManyToMany(fetch=FetchType.LAZY)
@JoinColumn(name="sku_inventory", joinColumns=@JoinColumn(name="sku_id"), inverseJoinColumns=@JoinColumn(name="inventory_id"))
private Set<PmsInventory> pmsInventories = new HashSet<>();
```



## What is cascade=CascadeType.ALL, orphanRemoval=true? What are the other Cascade types and their features? In which situation do we choose which one?



- Cascading means propagating an operation from the owning entity to the related entity. When a record in the owning entity (parent table) is saved, updated, or deleted, the change should be reflected in the related entity (child table) as well.

- When `orphanRemoval` is set to `true`, this attribute specifies that orphaned child entities (those that are no longer referenced by the parent entity) should be removed from the database. 

- Other Cascade types include: persist, merge, remove, refresh, detach
  
  - `CascadeType.ALL` needs to be used with caution since it might cause unwanted removal
  
  - In most cases, we can simply use `CascadeType.PERSIST`, in this case, persists the child when the parent is persisted



## What is the fetch=FetchType.LAZY, fetch=FetchType.EAGER? What is the difference? In which situation you choose which one?



- There are two ways in which data is loaded: eager and lazy. Eager fetch means that when a record is fetched from the database, all the associated records from related tables are also fetched. So if we fetch a tournament record, all the registrations for the tournament are also fetched.

- Eager fetch is the default fetch type used by Hibernate but it is not always the most efficient. Lazy fetch, on the other hand, fetches the records only when they are needed.



## What is the rule of the JPA naming convention? Shall we implement the method by ourselves? Could you list some examples?



- For example `findByTitleOrDescription(a, b)` will search for `title==a or description==b`

- We don't have to implement the methods by ourselves if we follow the naming convention



## What is JPQL?



- JPQL allows us to use SQL-like language in Java, the query language is similar to native SQL



## What is @NamedQuery and @NamedQueries?



- `@NamedQuery` and `@NamedQueries` are annotations in the Java Persistence API (JPA) used to define named queries for entities. Named queries are pre-defined queries that can be referenced by name in your Java code. They allow you to encapsulate and reuse queries, promoting better code organization and maintenance.



## What is @Query? In which Interface do we write the SQL or JPQL?



- In Spring Data JPA, the `@Query` annotation is used to declare custom queries directly within repository interfaces. It allows you to define JPQL (Java Persistence Query Language) queries or native SQL queries that are associated with specific repository methods. This annotation provides a way to execute custom queries without having to implement them in the actual repository implementation.

- SQL and JPQL can be written in corresponding Entity-Repository interfaces



## What are HQL and Criteria Queries?



- HQL is the Hibernate-specific SQL language

- Criteria Queries is a feature in the Java Persistence API (JPA) that allows you to define and execute queries using a type-safe and object-oriented approach. Instead of writing query strings in JPQL (Java Persistence Query Language) or using native SQL queries, Criteria Queries enables you to construct queries programmatically using a set of builder-like classes and methods.



## What is EntityManager?



- A JPA EntityManager manages the connection to a database as well as to database
  operations. EntityManager is associated with a PersistenceContext. All operations that are performed in a specific session are stored inside the PersistenceContext.

- EntityManager is the interface to the Persistence Context. All operations on the
  entity go through the EntityManager. We will declare an EntityManager object in our class and mark it with the @PersistenceContext annotation.



## What is SessionFactory and Session?



- The session object provides an interface between the application and data stored in the database.

- SessionFactory can create sessions, each database can have 1 SessionFactory associated with it.



## What is Transaction? How to manage your transaction?



- A transaction is a sequence of one or more operations on a database that are executed as a single unit of work. Transactions ensure the consistency, integrity, and isolation of database operations.

- In Java applications, transaction management is often handled using frameworks like Java Transaction API (JTA) or, in the case of Spring applications, the Spring Framework's transaction management capabilities.



## What is hibernate caching?



- Hibernate caching is a mechanism employed by the Hibernate framework to improve the performance of database operations by reducing the number of interactions with the database



## What is the difference between first-level cache and second-level cache?



- **First Level Cache (Session Cache):**
  
  - **Scope:** Bound to a Hibernate `Session` (or `EntityManager` in JPA).
  - **Lifetime:** Exists for the duration of a single session.
  - **Responsibility:** Caches entities and their states within the session.
  - **Usage:** Automatic and cannot be disabled. Enabled by default.
  - **Configuration:** No explicit configuration is needed for the first-level cache.

- **Second Level Cache:**
  
  - **Scope:** Application-wide, shared across sessions.
  - **Lifetime:** Persists across multiple sessions and transactions.
  - **Responsibility:** Caches entities, collections, and queries.
  - **Usage:** Optional and can be configured based on specific needs.
  - **Configuration:** Requires a second-level cache provider (e.g., Ehcache, Infinispan). Configuration is typically done in the Hibernate configuration file.





## How do you understand @Transactional?



- The `@Transactional` annotation is used in Spring to define the scope of a database transaction for a specific method or a class


