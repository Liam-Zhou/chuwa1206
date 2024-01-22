1. [annotation.md](./annotation.md)

2. Type out the code for the Comment feature of the class project.

3. In postman, call all of the APIs in PostController and CommentController.

4. **JPA**: Java Persistence API, a Java specification for accessing, persisting, and managing data between Java objects/classes and a relational database.

   **Hibernate**: An open-source ORM (Object-Relational Mapping) framework for Java that provides an implementation of the JPA specification.

5. **HikariCP**: A high-performance JDBC connection pool for Java, known for its efficiency and lightweight design.

   Benefits of Connection Pooling: 

   - Reuses connections to reduce creation overhead.
   - Limits and manages database connections efficiently.
   - Quick access to existing connections.
   - Supports more concurrent database operations.
   - Offers stable database interaction.

6. **@OneToMany**: Indicates a one-to-many relationship between two entities. Example: One `User` can have many `Orders`.

```java
public class User {
    @OneToMany(mappedBy = "user")
    private List<Order> orders;
}
```

**@ManyToOne**: Indicates a many-to-one relationship. Example: Many `Orders` can belong to one `User`.

```java
javaCopy codepublic class Order {
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
```

**@ManyToMany**: Represents a many-to-many relationship. Example: Many `Students` can enroll in many `Courses`.

```java
javaCopy codepublic class Student {
    @ManyToMany
    @JoinTable(
        name = "student_course",
        joinColumns = @JoinColumn(name = "student_id"),
        inverseJoinColumns = @JoinColumn(name = "course_id")
    )
    private List<Course> courses;
}

public class Course {
    @ManyToMany(mappedBy = "courses")
    private List<Student> students;
}
```

7. **cascade = CascadeType.ALL**: This option means that all JPA lifecycle events (like save, delete, update) will be propagated from the parent entity to the associated child entities. For example, deleting a `User` will also delete all its associated `Orders`.

   **orphanRemoval = true**: When enabled, it removes child entities that are no longer referenced from the parent entity. For example, removing an `Order` from a `User`'s order list will delete that `Order` from the database.

​	**CascadeType**:

- **PERSIST** when you want to save child entities automatically with the parent.
- **MERGE** for scenarios where you merge the state of the entity into the current persistence context.
- **REMOVE** when child entities should be removed when the parent is removed.
- **REFRESH** if you want updates from the database to be reflected in your child entities.
- **DETACH** when you want the child entities to become detached when the parent is detached.

8. **FetchType.LAZY** and **FetchType.EAGER** are options in JPA that define how entity associations are loaded.

9. **JPA Naming Convention Rule**: Repository methods start with keywords like `find`, `count`, `delete`, followed by the entity's attribute names (e.g., `findByUsername`, `countByStatus`).

10. Utilize JPA repository interfaces and leverage method naming conventions for automatic query generation. For example, in a `StudentRepository` interface, use methods like `findByName(String name)`, `findByAgeGreaterThan(int age)`, or `countByDepartment(String department)` to utilize JPA's built-in functionality without manually writing queries.

11. code

12. code

13. JPQL (Java Persistence Query Language) is a query language used in JPA for writing queries against JPA entities, resembling SQL but operating on object-oriented entities rather than database tables.

14. **@NamedQuery**: A JPA annotation to define a static query on an entity with a given name.

    **@NamedQueries**: A container annotation to hold multiple `@NamedQuery` annotations on an entity.

15. **@Query**: An annotation used in Spring Data JPA to define SQL or JPQL queries directly on repository methods.

​	**Interface for SQL/JPQL**: These queries are typically written in repository interfaces extending 	`JpaRepository` or `Repository` in Spring Data JPA.

16. **HQL (Hibernate Query Language)**: A powerful query language used in Hibernate, similar to SQL but works with Hibernate entities instead of database tables.

    **Criteria Queries**: A programmatic, type-safe way to build queries in Hibernate, useful for constructing dynamic queries based on various runtime conditions.

17. A JPA interface used for interacting with the persistence context, managing and querying entities in a relational database.

18. **SessionFactory**: In Hibernate, it's a factory class used to create `Session` instances. It maintains the configuration and services needed for database operations.

    **Session**: Represents a single-threaded unit of work with the database, providing methods to perform create, read, update, and delete operations on database entities

19. **Transaction**: A set of operations executed as a single unit of work, ensuring data integrity and consistency. In case of failure, the entire transaction is rolled back.

    **Managing Transaction**: Managed through transaction management APIs (like JTA or JDBC), or frameworks like Spring's declarative transaction management, using annotations (`@Transactional`) or programmatic transaction management.

20. A mechanism in Hibernate to reduce database access by storing entities or query results in memory, improving application performance. It includes two levels: first-level cache (session cache) and second-level cache (global cache shared across sessions).

21. **First-Level Cache**: Integrated within the Hibernate `Session`, it's a per-session cache that stores entities retrieved in a single session and is not accessible to other sessions.

    **Second-Level Cache**: A global cache shared across multiple sessions, enabling entity or query result sharing between sessions to reduce database access.

22. **@Transactional**: An annotation used to declare transaction boundaries declaratively. It ensures that the method it annotates is executed within a transactional context, handling transaction management automatically (like commit or rollback).

