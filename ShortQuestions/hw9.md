## 4. What is JPA? and what is Hibernate?

JAP: JPA is a Java specification for managing, persisting, and accessing data between Java objects and a relational database. It defines a standard interface for Java developers to interact with databases, providing a set of annotations and APIs.

Hibernate: Hibernate is an open-source ORM framework that implements the JPA specification. It provides a robust and feature-rich implementation of JPA, along with additional features that go beyond the standard.

## 5. What is Hiraki? what is the benefits of connection pool?

Hikari is a high-performance JDBC connection pool for Java applications. It is designed to be fast, lightweight, and efficient, making it a popular choice for managing database connections in Java-based projects. HikariCP is often used in conjunction with various Java frameworks and persistence technologies, such as Spring and Hibernate.

Connection pooling is a technique used to manage and reuse database connections to improve the performance and efficiency of database access in applications. 

1. Establishing a new connection to a database can be a resource-intensive operation. Connection pooling keeps a pool of pre-established connections, reducing the overhead associated with creating and closing connections for each database operation.

2. By reusing existing connections from the pool, applications can perform database operations more quickly. This is especially beneficial in scenarios with high traffic or frequent database access.

3. Connection pooling helps manage system resources effectively by limiting the number of concurrently open connections. This prevents resource exhaustion and ensures that the application operates within defined resource constraints.

## 6. What is the @OneToMany, @ManyToOne, @ManyToMany? write some examples

Annotations @OneToMany, @ManyToOne, and @ManyToMany are used to define relationships between entities in a relational database.

class Department{
    @OneToMany(mappedBy = "department")
    private List<Employee> employees;
}

In this example, we can see the first 'one' mapping to Department, 'Many' mapping to employee.

## 7. What is the cascade = CascadeType.ALL, orphanRemoval = true? and what are the other CascadeType and their features? In which situation we choose which one?

The cascade attribute and orphanRemoval attribute are used in conjunction with the @OneToMany and @OneToOne annotations to specify the cascade operations to be applied to associated entities.

The cascade attribute is used to define the cascade operations to be applied to the associated entities when the owning entity is persisted, updated, or removed. 

CascadeType.ALL:

It includes all cascade operations: persist, merge, remove, refresh, and detach. When the owning entity is affected by any of these operations, the associated entities will be cascaded accordingly.

CascadeType.PERSIST:

It includes the persist operation. When the owning entity is persisted, the associated entities will also be persisted.

CascadeType.MERGE:

It includes the merge operation. When the owning entity is merged, the associated entities will also be merged.

CascadeType.REMOVE:

It includes the remove operation. When the owning entity is removed, the associated entities will also be removed.

CascadeType.REFRESH:

It includes the refresh operation. When the owning entity is refreshed, the associated entities will also be refreshed.

CascadeType.DETACH:

It includes the detach operation. When the owning entity is detached, the associated entities will also be detached.

The orphanRemoval attribute is a boolean attribute that is used to specify whether orphaned entities (entities that are no longer referenced by the owning entity) should be removed. If set to true, orphaned entities will be removed when the owning entity is updated.

## 8.What is the fetch = FetchType.LAZY, fetch = FetchType.EAGER? what is the difference? In which situation you choose which one?

FetchType.LAZY, is a fetching strategy where associated entities are loaded lazily, meaning that they are loaded from the database only when they are accessed for the first time in the application.

FetchType.EAGER, is a fetching strategy where associated entities are loaded eagerly along with the owning entity. When an entity is loaded, its associated entities are also immediately loaded from the database.

## 9. What is the rule of JPA naming convention? Shall we implement the method by ourselves? Could you list some examples?

JPA (Java Persistence API) follows a naming convention for automatically generating database table and column names based on the names of Java entities and their attributes. This convention helps reduce the amount of configuration needed when mapping Java entities to database tables. 

@Entity
@Table(name = "people")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name")
    private String firstName;
}

## 13. What is JPQL?

JPQL (Java Persistence Query Language) is a query language defined as part of the Java Persistence API (JPA) specification. It is used for querying entities and their relationships from a relational database using object-oriented syntax.

## 14. What is @NamedQuery and @NamedQueries?

The @NamedQuery annotation is used to define a named query for a specific entity class. This named query can be referenced in your application code or used in other contexts, such as in a TypedQuery or Query object.

The @NamedQueries annotation is used to define multiple named queries for a single entity class. This annotation takes an array of @NamedQuery annotations.

## 15. What is @Query? In which Interface we write the sql or JPQL?

The @Query annotation can be applied to a method in a Spring Data JPA repository interface, and it allows you to specify the query string that should be executed when the method is called. In the @Query we can write both sql and JPQL. 

## 16. What is HQL and Criteria Queries?

HQL is a query language specific to Hibernate, and it is similar to SQL (Structured Query Language). However, instead of operating on database tables and columns, HQL operates on Hibernate entities and their relationships.

Criteria Queries in Hibernate provide a programmatic, type-safe way to express queries using a set of API methods. Instead of writing queries as strings, developers construct queries using the Criteria API.

## 17. What is EnityManager?

The EntityManager is a key interface in the Java Persistence API (JPA) that provides a set of methods for interacting with the persistence context of a JPA-enabled application. It is used for managing entities, which are Java objects representing data stored in a relational database.

## 18. What is SessionFactory and Session?

The SessionFactory is a factory for Session instances. It is a heavyweight object that is typically created once during the application's startup and represents a configuration for Hibernate.

The Session is a short-lived object that represents a unit of work with the database. It is created by the SessionFactory and provides methods for CRUD (Create, Read, Update, Delete) operations, as well as querying the database.

## 19. What is Transaction? how to manage your transaction?

A transaction is a sequence of one or more operations (database queries, inserts, updates, deletes, etc.) that are executed as a single unit of work. Transactions ensure the consistency and integrity of a database by allowing a series of operations to be executed as a single atomic operation. In a transaction, either all operations are completed successfully (committed), or none of them are applied (rolled back).

In Hibernate, transaction management is typically handled using the Transaction interface.

1. Obtain Session
2. Begin Transaction
3. Perform Database Operations
4. Commit Transaction
5. Rollback on Failure
6. Close Session

## 20. What is hibernate Caching?

Hibernate caching is a mechanism used to improve the performance and responsiveness of an application by reducing the number of database queries. It involves storing and reusing the results of expensive database queries or computations, thereby avoiding the need to repeatedly access the database for the same data. 

## 21. What is the difference between first-level cache and second-level cache?

First-level cache: Associated with a Hibernate Session. Exists for the duration of a single session.

Second-Level Cache: Shared across multiple Hibernate Sessions. Global to the entire application.

## 22. How do you understand @Transactional?

The @Transactional annotation in Spring is used to define the scope of a single database transaction. It is a declarative way of specifying that a method, or all methods within a class, should be executed within a transaction context. The annotation provides a convenient and consistent approach to managing transactions without the need for explicit transaction management code.