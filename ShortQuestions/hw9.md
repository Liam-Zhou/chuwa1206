1. See annotaitons.md


2. Type out the code for the Comment feature of the class project.

    Done in hw8.

3. In postman, call all of the APIs in PostController and CommentController.

   Done in hw8.

4. What is JPA? and what is Hibernate?

    - JPA is a standard of Object Relational Mapping. It is an interface that defines a set of
      annotations for creating the object relational mapping
    - Hibernate is a popular open-source implementation of the JPA specification. It is essentially a JPA provider, meaning it implements the interfaces and functionalities defined by JPA. Hibernate goes beyond just implementing JPA; it provides additional features and capabilities that enhance the JPA specification.

5. What is Hikari? what is the benefits of connection pool?

    - Hikari is a high-performance JDBC connection pool.
    - benefits:
        1. Improved Performance: Connection pools reduce the overhead of opening and closing database connections for each database operation.
           
      2. Connection Reuse: Pooled connections are reused, saving the time it takes to establish a new connection each time.
      3. Resource Management: Connection pools manage and control the number of database connections that are opened, preventing resource exhaustion. Pools help prevent issues such as "connection leaks" by ensuring that connections are properly released back to the pool after use.
      4. Concurrency and Scalability: Connection pooling allows multiple threads to share a pool of connections efficiently.
      5. Configuration and Tuning: provide configuration options to fine-tune the behavior of the pool based on application requirements.

6. What is the @OneToMany, @ManyToOne, @ManyToMany? write some examples.

    - @OneToMany, @ManyToOne, and @ManyToMany are annotations used to define relationships between entities in a relational database. These annotations help establish how entities are related to each other, and they are often used in conjunction with the concept of object-relational mapping (ORM).
    - @OneToMany
   ```
   @Entity
    public class University {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "university")
    private List<Student> students;

    // other fields, getters, setters, etc.

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }
   }
   ```
   - @ManyToOne
```
@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "university_id")
    private University university;

    // other fields, getters, setters, etc.

    public University getUniversity() {
        return university;
    }

    public void setUniversity(University university) {
        this.university = university;
    }
}
```

   - @ManyToMany
```
@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToMany
    @JoinTable(
      name = "student_course",
      joinColumns = @JoinColumn(name = "student_id"),
      inverseJoinColumns = @JoinColumn(name = "course_id"))
    private Set<Course> courses;

    // other fields, getters, setters, etc.

    public Set<Course> getCourses() {
        return courses;
    }

    public void setCourses(Set<Course> courses) {
        this.courses = courses;
    }
}
```

7. What is the cascade = CascadeType.ALL, orphanRemoval = true? and what
   are the other CascadeType and their features? In which situation we choose
   which one?

    - All: All cascade operations on owning entity applied to related entity.
    - Persist: Owning entity saved => related entity saved
    - Merge: Owning entity merged => related entity merged
    - Refresh: Owning entity refreshed => related entity refreshed
    - Remove: Owning entity removed => related entity removed
    - Detach: Owning entity detached => related entity detached

   - The orphanRemoval attribute is a boolean attribute that is used to indicate whether orphaned child entities (those that are no longer referenced by the parent) should be automatically removed. It works in conjunction with the cascade attribute.
   - Persist (CascadeType.PERSIST): Use when you want to propagate the creation of a new entity to associated entities.

   - Merge (CascadeType.MERGE): Use when you want to propagate the update of a detached entity to associated entities.

    - Refresh (CascadeType.REFRESH): Use when you want to propagate a refresh operation to associated entities.

    - Remove (CascadeType.REMOVE): Use when you want to propagate the removal of an entity to associated entities.

    - Detach (CascadeType.DETACH): Use when you want to propagate the detachment of an entity from the persistence context to associated entities.

    - All (CascadeType.ALL): Use when you want to cascade all operations.

8. What is the fetch = FetchType.LAZY, fetch = FetchType.EAGER? what is the
   difference? In which situation you choose which one?

    - LAZY: the associated entities will be loaded from the database only when they are explicitly accessed in the code.
   Used when you want to load related entities only when needed, to optimize performance and reduce initial data retrieval overhead.
      Suitable for associations that are not always accessed and where the additional data is not always necessary.
    - EAGER: the associated entities will be loaded immediately along with the parent entity when it is fetched from the database.
      Used when you know that you will frequently access the related entities and want to minimize subsequent database queries.
      Suitable when the associated entities are relatively small and the overhead of fetching them eagerly is acceptable.

9. What is the rule of JPA naming convention? Shall we implement the method by
   ourselves? Could you list some examples?

   - JPA (Java Persistence API) uses a set of naming conventions for generating database queries based on the names of methods defined in repository interfaces. These conventions help Spring Data JPA to automatically create queries for common CRUD operations without the need for explicit query definitions.
   - We can implement the method on ourselves.
   - Examples: Find By, And, Or, OrderBy, Count By, Exists By, Delete By, Distinct By


11. (Optional) Check out a new branch(https://github.com/TAIsRich/springboot-red
    book/tree/hw02_01_jdbcTemplate) from branch 02_post_RUD, replace the dao
    layer using JdbcTemplate.



12. type the code, you need to checkout new branch from branch 02_post_RUD,
    name the new branch with https://github.com/TAIsRich/springboot-redbook/
    tree/hw05_01_slides_JPQL.



13. What is JPQL?

   - JPQL (Java Persistence Query Language) is a query language defined by the Java Persistence API (JPA) for querying entities and their relationships in a database-agnostic way. It provides a way to express database queries in a syntax similar to SQL but operates on Java objects rather than database tables.

14. What is @NamedQuery and @NamedQueries?

@NamedQuery and @NamedQueries are annotations in JPA (Java Persistence API) that allow you to define named queries at the entity level.
   - The @NamedQuery annotation is used to define a named query at the entity level.
   - The @NamedQueries annotation is used to define multiple named queries at once.

15. What is @Query? In which Interface we write the sql or JPQL?

   - The @Query annotation in Spring Data JPA is used to define custom queries directly within a repository interface.
   - In repository interface.

16. What is HQL and Criteria Queries?

   - HQL (Hibernate Query Language) and Criteria Queries are two different approaches provided by Hibernate for querying data from a relational database using the Hibernate ORM (Object-Relational Mapping) framework.
   - HQL (Hibernate Query Language)  is a powerful query language specific to Hibernate, which is an implementation of JPA (Java Persistence API). It is similar to SQL but operates on the entity objects rather than database tables.
   - Criteria Queries provide a programmatic, type-safe way to build queries using a set of criteria objects. Instead of writing queries as strings, developers construct queries using a fluent API of Criteria API provided by Hibernate.

17. What is EntityManager?

   - The EntityManager is a core interface in the Java Persistence API (JPA) that provides a set of methods to interact with the persistence context, manage entities, and perform CRUD (Create, Read, Update, Delete) operations in a database. It is a fundamental part of the JPA specification and serves as a bridge between the application and the underlying database.
   - Use EntityManager When:

      You need fine-grained control over database operations.
      You want to write custom queries using JPQL or native SQL.
      Dynamic queries and complex criteria are required.
      Native SQL execution is necessary.
   - Use JpaRepository When:

      You want a more declarative and abstract approach to database operations.
      Common CRUD operations and queries can be satisfied by the built-in methods.
      Query derivation based on method names is sufficient.
      You want to leverage Spring Data features like pagination and sorting.

18. What is SessionFactory and Session?

   - The SessionFactory is a heavyweight object in Hibernate responsible for creating and managing Session instances.
     It is a factory for Session objects and is typically created once during the application's startup.
   - A Session is a short-lived, lightweight object representing a single unit of work with the database.
     It is created by the SessionFactory and used to perform database operations (CRUD) for a particular unit of work.

19. What is Transaction? how to manage your transaction?

   - A transaction is a sequence of one or more operations (database queries or updates) that are executed as a single unit of work.
   - Several ways to manage transaction:
     1. Programmatic Transaction Management: explicitly write code to demarcate the boundaries of transactions.
     2. Declarative Transaction Management: Transaction management is declaratively specified using annotations or configuration, such as @Transactional
     3. Container-Managed Transactions (CMT): In a Java EE (Enterprise Edition) environment, the application server manages transactions.

20. What is hibernate Caching?

   - Hibernate caching is a mechanism provided by the Hibernate ORM (Object-Relational Mapping) framework to improve the performance of database operations by reducing the need to repeatedly access the database. Caching involves storing and retrieving data in memory so that subsequent requests for the same data can be fulfilled without querying the database again. There are primarily two levels of caching in Hibernate: first-level cache (also known as the session cache) and second-level cache:
      


21. What is the difference between first-level cache and second-level cache?

    1. First-Level Cache (Session Cache): Scope: The first-level cache is associated with the Session object.
            Lifetime: It is short-lived and lasts for the duration of a single Hibernate Session.
            Mechanism: When an entity is queried or loaded, it is stored in the first-level cache. Subsequent requests for the same entity within the same session are served from the cache instead of hitting the database again.
    2. Second-Level Cache: Scope: The second-level cache is shared across different Session instances.
       Lifetime: It can persist data beyond the duration of a single session and is typically associated with the entire application.
       Mechanism: Entities or query results are stored in the second-level cache, and multiple sessions can benefit from the cached data.

22. How do you understand @Transactional? (https://github.com/TAIsRich/tutorialtransaction)

   - The @Transactional annotation is used in Java to indicate that a method (or all methods of a class) should be wrapped in a transaction. Transactions ensure the atomicity, consistency, isolation, and durability (ACID properties) of database operations.
   - Scope of Transaction:
     When you annotate a method (or class) with @Transactional, it specifies that a transaction should be started before the method is executed and committed (or rolled back in case of an exception) after the method completes.
   - Method-Level Annotation:
     Placing @Transactional on a specific method means that a transaction will be created, and the annotated method will execute within that transaction.
   - Class-Level Annotation:
     If you annotate the entire class with @Transactional, all public methods of the class are transactional.
   - Propagation and Nesting:
     The @Transactional annotation supports the propagation attribute, which determines how the annotated method behaves when it is called by another method that is already in a transaction.
   - Rollback Rules:
     The @Transactional annotation supports the rollbackFor and noRollbackFor attributes, allowing you to specify exceptions that should trigger a rollback or exceptions that should not trigger a rollback.
   - Isolation Level:
     The @Transactional annotation allows you to set the isolation level using the isolation attribute.
   - Read-Only Transactions:
     You can specify that a transaction is read-only using the readOnly attribute. This can improve performance for read-only operations.
   - Transaction Timeout:
     The timeout attribute allows you to set a timeout for the transaction.