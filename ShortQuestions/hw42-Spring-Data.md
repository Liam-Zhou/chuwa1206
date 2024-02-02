#### 4.What is JPA? What is Hibernate?

JPA is Java Persistence API. It is a specification for Object-Relational Mapping (ORM), to access, persist and manage data between Java objects and relational database tables. It allows developers to map java objects to relational database tables and vice versa.

Hibernate is an implementation of JPA. It provides a framework to map an object-oriented domain model to a relational database.

#### 5.What is Hiraki? what is the benefit of connection pool?

Hiraki is a very fast, lightweight Java connection poll.

Connection pool is a cache of database connections maintained so that the connections can be reused when future requests to the database.

Using connection pool can reduce latency by reusing existing connections. It may also prevent too much connections to a database,

#### 6.What is the  @OneToMany, @ManyToOne, @ManyToMany? write some examples.

@OneToMany:     One-to-Many relationship between entities. One current entity will be mapped to several below entities, but on below entity can only map to one current entity.

@manyToOne: many-To-One relationship between entities.

```java
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // ...

    @OneToMany(mappedBy = "user")
    private Set<Order> orders;
}

@Entity
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // ...

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
```

@manyToMany

```java
@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // ...

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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // ...

    @ManyToMany(mappedBy = "courses")
    private Set<Student> students;
}

```

#### 7.What is the  cascade = CascadeType.ALL, orphanRemoval = true? and what are the other CascadeType and their features? In which situation we choose which one?

When an operation (like persist, remove, refresh, merge, detach) is performed on an entity, it's also cascaded to the associated entities 

If a child entity is removed from the relationship (e.g., removed from a collection), it's considered an orphan and will be automatically removed from the database.

1. **`CascadeType.PERSIST`**: Cascade only the persist (save/update) operation. If the parent is saved, the children are also saved.
2. **`CascadeType.MERGE`**: Cascade the merge operation. Used when you want to merge changes made to the entity back into the persistence context.
3. **`CascadeType.REFRESH`**: Cascade the refresh operation. If the parent entity is refreshed, the children are also refreshed.
4. **`CascadeType.REMOVE`**: Cascade the remove operation. If the parent is deleted, the children are also deleted.
5. **`CascadeType.DETACH`**: Cascade the detach operation. When an entity is detached from the persistence context, all associated entities are also detached.
6. **`CascadeType.ALL`**: Cascade all above operations.



#### 8.What is the  fetch = FetchType.LAZY, fetch = FetchType.EAGER? what is the difference? In which situation you choose which one?

With `LAZY` fetching, the associated entities are loaded on demand. This means they are not loaded immediately when the parent entity is loaded.

With `EAGER` fetching, associated entities are loaded immediately with the parent entity, even if they are not explicitly accessed in the business logic.

#### 9.What is the rule of JPA naming convention? Shall we implement the method by ourselves? Could you list some examples?

JPA naming convention is a convention to define methods to access and manage JPARepository data.

We don't need to implement the method by ourselves.

##### JPA Naming Convention Rules

The method naming convention in JPA repositories is quite intuitive. The method name usually starts with a prefix like `find...By`, `read...By`, `query...By`, `count...By`, and `get...By`. Following the prefix, you add a condition based on the entity's attributes. Here are the key rules:

1. **Start with a method prefix**: such as `find`, `read`, `query`, `count`, or `get`.
2. **Specify the criteria**: Use property names of the entity with conditions like `GreaterThan`, `LessThan`, `Like`, etc.
3. **Combine criteria with `And` or `Or`**: When you need to use multiple criteria in a single method.



User findByNameAndDateBetween(String name, Date start, Date end).

List<User> findByAgeGreaterThan(int age);

List<User> findByNameLike(String namePattern);



#### 13.What is JPQL?

JPQL is a query language defined in the Java Persistence API (JPA). It is used to write queries against entities stored in a relational database.

#### 14.What is @NamedQuery and @NamedQueries?

 `@NamedQuery` defines a single static query on an entity class. It can be invoked elsewhere in the application using its name.

`@NamedQueries` is a container annotation that holds multiple `@NamedQuery` annotations. It's useful when you want to define several named queries on a single entity.

#### 15.What is @Query? In which Interface we write the sql or JPQL?

`@Query` is an annotation provided by Spring Data JPA used for specifying custom JPQL (Java Persistence Query Language) or native SQL queries directly on repository methods. 

You typically define methods annotated with `@Query` in a repository interface that extends one of the Spring Data repository interfaces, such as `JpaRepository` or `CrudRepository`. These interfaces provide basic CRUD operations and query execution support.

#### 16.What is HQL and Criteria Queries?

HQL is an object-oriented query language, similar to SQL, but instead of operating on tables and columns, HQL works with persistent objects and their properties. It's specific to Hibernate and allows you to write database-independent queries.

The Criteria API helps to build structured queries programmatically to ensure type-safety and to avoid syntax errors at compile time.

#### 17.What is EntityManager?

`EntityManager` is a fundamental part of the Java Persistence API (JPA), which is the standard Java specification for object-relational mapping. It acts as the primary interface for interacting with the persistence context and managing the lifecycle of entities.

The `EntityManager` API provides operations for creating, reading, updating, and deleting entities. This includes methods like `persist()`, `find()`, `merge()`, `remove()`, and more.

#### 18.What is SessionFactory and Session?

`SessionFactory` is a heavyweight, thread-safe, and immutable object that acts as a factory for `Session` objects.

A `Session` in Hibernate is a lightweight, non-thread-safe object that represents a single unit of work with the database. It's the primary interface used by Hibernate applications to perform CRUD operations on database entities.

#### 19.What is Transaction? how to manage your transaction?

a transaction is a sequence of operations performed as a single logical unit of work.

1. **Atomicity**: The entire transaction is treated as a single unit. It either fully completes or fully fails. There's no in-between state.
2. **Consistency**: The transaction transforms the system from one consistent state to another consistent state.
3. **Isolation**: Transactions are isolated from each other until they're complete.
4. **Durability**: Once a transaction is completed, its results are permanently stored and not lost even in the case of a system failure.

##### 1. Programmatic Transaction Management

##### 2. Declarative Transaction Management (@Transactional)

##### 3. Using Transaction Managers

##### 4. ORM Tools (e.g., Hibernate, JPA)

#### 20.What is hibernate Caching?

Hibernate caching is a mechanism in the Hibernate ORM (Object-Relational Mapping) framework that helps improve application performance by reducing the number of database accesses. 

#### 21.What is the difference between first-level cache and second-level cache?

The first level cache is associated with the `Session` object (Hibernate’s representation of a unit of work). It's enabled by default and cannot be disabled. Each `Session` object maintains its own first-level cache.

 The second level cache is associated with the `SessionFactory` and is shared by all sessions created using that `SessionFactory`. It's not enabled by default and requires explicit configuration.

It caches objects across sessions. When an entity is not found in the first-level cache, Hibernate checks the second-level cache before hitting the database. If the entity is found in the second-level cache, it is loaded into the first-level cache of the respective session.

#### 22.How do you understand @Transactional?

`@Transactional` is used to define the scope of a single database transaction. The database transaction happens inside the scope of a persisted context.

The annotation can be applied at both the class and method levels. When placed at the class level, it applies to all methods within the class. When used at the method level, it only affects that specific method.

When a method annotated with `@Transactional` is called, Spring starts a new transaction. If the method completes successfully, the transaction is committed. If the method throws a runtime exception, the transaction is rolled back.