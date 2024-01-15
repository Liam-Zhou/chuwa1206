# 1
Check `/ShortQuestions/1.8/annotations.md`. Should be in the PR of HW8 due on 1.12.

# 2
Overlapped with Q15 in hw41-springboot-RUD due on 1.12.

# 3
{{LocalHost}} = localhost:8080

PostController API:
- POST {{LocalHost}}/api/v1/posts
- GET {{LocalHost}}/api/v1/posts
- GET {{LocalHost}}/api/v1/posts/6
- PUT {{LocalHost}}/api/v1/posts/6
- DELETE {{LocalHost}}/api/v1/posts/6
- GET {{LocalHost}}/api/v1/posts/page?page-no=1&page-size=2

CommentController API:
- POST {{LocalHost}}/api/v1/posts/5/comments
- GET {{LocalHost}}/api/v1/posts/5/comments
- GET {{LocalHost}}/api/v1/posts/5/comments/1
- PUT {{LocalHost}}/api/v1/posts/5/comments/1
- DELETE {{LocalHost}}/api/v1/posts/5/comments/1

# 4
- JPA stands for Java Persistence API. It's a Java specification for accessing, persisting, and managing data between Java objects/classes and a relational database.
- Hibernate is a popular ORM framework for Java that implements the JPA specifications.

A way to think of JPA is hibernate is that JPA is an interface whereas Hibernate is the implementation of the interface.

# 5
Hikari is a high-performance JDBC connection pooling library in Java. Connection pooling is a technique used to improve the performance of executing commands on a database. When a pool of connections is maintained, instead of opening and closing a connection for every database request, connections are reused, which significantly reduces the overhead and increases the efficiency of database interactions.

# 6
These annotations refers to the relationship between entities in a relational database.

@OneToMany means that one record in a table can be related to multiple records in another table.

@ManyToOne means that many records in a table can be related to a single record in another table.

```
@Entity
public class Restaurant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "dish")
    private Set<Dish> dishes;
}

@Entity
public class Dish {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Restaurant restaurant;
}
```

@ManyToMany means multiple records in a table can be mapped to multiple records in another table.

```
@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToMany
    @JoinTable(
        name = "student_course",
        joinColumns = @JoinColumn(name = "student_id"),
        inverseJoinColumns = @JoinColumn(name = "course_id)
    )
    private Set<Course> courses;
}

@Entity
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToMany(mappedBy = "courses")
    private Set<Student> students;
}
```

# 7
- `CascadeType.ALL` means that all persistence operations that happen on the parent entity will also be applied to the child entities. It's a shorthand for applying all cascade types.
- `orphanRemoval` is related to the removal of child entities. When set to true, it means that if a child entity is removed from the collection of the parent entity, it will be automatically deleted from the database.

We have the following cascadeType:
- `CascadeType.PERSIST` When persist EntityA, the related Entity B is also persisted.
- `CascadeType.MERGE` When merge EntityA, the related Entity B is also merged.
- `CascadeType.REMOVE` When deleting EntityA, the related Entity B is also deleted.
- `CascadeType.REFRESH` When refreshing EntityA, the related Entity B is also refreshed.
- `CascadeType.DETACH` When detach EntityA, the related Entity B is also detached.

# 8
- `FetchType.LAZY` is a fetching strategy where the related entities are not loaded immediately with the parent entity. They are loaded on-demand, when they are explicitly accessed in the code. This is preferred when dealing with large datasets or when the related field is not used frequently. It enhances performance by loading only the necessary data, reducing memory usage and the load on the database.
- `FetchType.EAGER` is a fetching strategy where the related entities are loaded immediately along with the parent entity. When you access the parent entity, JPA loads all related entities at the same time. This is useful when the related entities are almost always used with the parent entity and the size of the related data is small. It can reduce the number of database queries and avoid the "N+1 select problem" in some cases.

If the related table is frequently accessed alongside the parent entity, EAGER might be justified. If it's rarely needed, LAZY is likely better. For relationships with a large number of entities or large data sets, LAZY is generally preferred.

# 9 
- Entity Classes: Class names are usually in PascalCase 
- Entity Fields: Field names are typically in camelCase
In Spring Data JPA, the method names in your repository interfaces are automatically translated into SQL queries based on the naming convention. Here are some examples: `List<User> findByLastName(String lastName);` and `List<User> findByFirstNameAndLastName(String firstName, String lastName);`

We do not need to provide implementation manually when using Spring Boot JPA.

# 10
Done

# 12
Done

# 13
JPQL stands for Java Persistence Query Language, a query language used in Java Persistence API (JPA) to execute queries against a relational database, managing data in Java applications. JPQL is similar in syntax to SQL (Structured Query Language) but operates on the concept of entities, their relationships, and attributes, rather than directly on database tables and columns.

# 14
They are used to define static, named queries at the entity level.

@NamedQuery is used to specify a single named query. 

```
@Entity
@NamedQuery(name="Entity.findAll", query="SELECT e FROM Entity e")
public class Entity {
    // class code
}
```

@NamedQueries is used to define multiple @NamedQuery annotations.

```
@Entity
@NamedQueries({
    @NamedQuery(name="Entity.findAll", query="SELECT e FROM Entity e"),
    @NamedQuery(name="Entity.findById", query="SELECT e FROM Entity e WHERE e.id = :id")
})
public class Entity {
    // class code
}
```

# 15
@Query is typically used in repository interfaces to define custom query methods with JPQL and SQL. It can be used to specify both JPQL and native SQL queries. It allows for the definition of complex queries that are not easily supported by the naming conventions of Spring Data JPA's query methods. @Query is used in repository interfaces that extend one of Spring Data's repository interfaces, such as JpaRepository, CrudRepository, or PagingAndSortingRepository. These repository interfaces are part of the Spring Data JPA framework and provide the mechanism for defining data access methods, including custom query methods.

# 16 
- HQL stands for Hibernate Query Language. HQL is a powerful, object-oriented query language similar to SQL, but instead of operating on tables and columns, HQL works with persistent objects and their properties. HQL queries are translated by Hibernate into conventional SQL queries which in turn perform action on the database.
- Criteria Queries is a more object-oriented and type-safe way to query entities by creating a query object tree. The Criteria API allows you to build up a criteria query object programmatically where you can apply filtration rules and logical conditions.

# 17
EntityManager is the primary interface for interacting with the persistence context. It manages the lifecycle of entities (persist, remove, find, etc.) and queries over entities.

# 18
- SessionFactory is a factory class that creates the Session objects. It's heavyweight, usually created during application start-up and kept for later use. It's a thread-safe object intended to be shared by all application threads.
- session represents a single-threaded unit of work. It's not a thread-safe object and is used by the application to specify the boundaries of a single database transaction.

# 19
In Hibernate, a transaction is a sequence of actions that are treated as a single unit of work. These actions should either complete entirely or fail completely. Managing transactions involves specifying boundaries within which these actions are executed, often corresponding to the boundaries of a business process.

Managing Transactions: You can manage transactions programmatically using the Hibernate Session API, or declaratively using annotations or XML-based configuration. The @Transactional annotation in Spring, for instance, declaratively manages the transaction boundaries.

# 20
Hibernate uses internal caching to reduce database access. There are two types of caching:
 - First-Level Cache: It's associated with the Session object and is enabled by default. The first-level cache ensures that each entity instance is loaded only once in the persistent context.
 - Second-Level Cache: This is associated with the SessionFactory and is optional. It's used to store entities shared across different user sessions. It helps in reducing the number of database queries for frequently read data.

# 21
First-level cache is tied to a specific Hibernate Session, whereas the second-level cache is tied to the SessionFactory and shared across sessions.  First-level cache lasts as long as the session is open, while the second-level cache data can persist across multiple sessions.

# 22
When you annotate a method with @Transactional, Spring creates a proxy around the method to manage the transaction. If the method completes successfully, the transaction is committed; if an exception occurs, it's rolled back.