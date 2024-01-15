# 1

List all of the annotations you learned from class and homework to annotaitons.md

Done

# 2

Type out the code for the Comment feature of the class project.

done



# 3

In postman, call all of the APIs in PostController and CommentController.

Done



# 4

What is JPA? and what is Hibernate?

JPA is like a set of rules or guidelines (a specification), and Hibernate is a tool that follows these rules and offers additional features. JPA ensures that your application is not tightly coupled with any specific ORM tool, thus providing flexibility, while Hibernate is a popular choice that brings robustness and efficiency to database operations in Java applications.



# 5

What is Hiraki? what is the benefits of connection pool?



HikariCP is a high-performance JDBC connection pool in Java, known for its efficiency and lightweight design. The main benefit of using a connection pool like HikariCP is to improve application performance by reusing existing connections to the database, thereby reducing the overhead of creating new ones for each database operation.



# 6

What is the @OneToMany, @ManyToOne, @ManyToMany ? write some examples.

In Java's JPA (Java Persistence API), `@OneToMany`, `@ManyToOne`, and `@ManyToMany` are annotations used for defining relationships between entities.

1. **@OneToMany**: This annotation defines a one-to-many relationship between two entities. It means one entity can be associated with multiple instances of another entity. For example, in a relationship between `Author` and `Book`, where one author can write multiple books:

``` java
public class Author {
    @OneToMany(mappedBy = "author")
    private List<Book> books;
}

public class Book {
    @ManyToOne
    @JoinColumn(name = "author_id")
    private Author author;
}

```

1. **@ManyToOne**: This annotation indicates a many-to-one relationship, meaning multiple instances of one entity are associated with a single instance of another entity. In the example above, multiple `Book` entities are associated with one `Author`.
2. **@ManyToMany**: This defines a many-to-many relationship where multiple instances of an entity can be associated with multiple instances of another entity. For example, if you have `Student` and `Course` entities where a student can enroll in multiple courses and a course can have multiple students:

``` Java
public class Student {
    @ManyToMany
    @JoinTable(
      name = "student_course",
      joinColumns = @JoinColumn(name = "student_id"),
      inverseJoinColumns = @JoinColumn(name = "course_id"))
    private List<Course> courses;
    // other fields, getters and setters
}

public class Course {
    @ManyToMany(mappedBy = "courses")
    private List<Student> students;
    // other fields, getters and setters
}

```

# 7

What is the cascade = CascadeType.ALL, orphanRemoval = true ? and what are the other CascadeType and their features? In which situation we choose which one?

CascadeType.ALL applies all cascading operations (like save, delete) to child entities. OrphanRemoval=true automatically deletes child entities if they're no longer referenced by the parent.

Other CascadeTypes are PERSIST (save), MERGE (update), REMOVE (delete), REFRESH (reload), DETACH (detach from persistence context). Choose based on your need: PERSIST for saving children with parent, REMOVE for deleting children with parent, MERGE for updates, and so on.



# 8

What is the fetch = FetchType.LAZY, fetch = FetchType.EAGER ? what is the difference? In which situation you choose which one?



- `FetchType.LAZY` loads data on demand, used to improve performance when you don't always need related data.
- `FetchType.EAGER` loads all data upfront, useful when you always need related data.

Choose `LAZY` for better performance in most cases, and `EAGER` when you consistently need related entities immediately.



# 9

What is the rule of JPA naming convention? Shall we implement the method by ourselves? Could you list some examples?



- JPA naming convention: Method names in repositories start with `find`, `read`, `query`, `count`, or `get`, followed by entity property names.
- No need to implement these methods; Spring Data JPA auto-generates them.
- Examples: `findByName`, `findByAgeGreaterThan`, `findByStartDateBetween`.



# 10

Try to use JPA advanced methods in your class project. In the repository layer, you need to use the naming convention to use the method provided by JPA.



Check `/CodingQuestions/hw9/bank-statement`



# 11

Optional



# 12

Done



# 13

JPQL stands for Java Persistence Query Language. It's used to query data from a database in a way that's independent of the underlying database's SQL syntax, focusing instead on entity objects and their properties.



# 14

What is @NamedQuery and @NamedQueries?



- `@NamedQuery`: A JPA annotation used to define a single static query at the entity level.
- `@NamedQueries`: Holds multiple `@NamedQuery` annotations.

They're used for defining frequently used queries in a centralized way, directly on the entity class.



# 15

What is @Query? In which Interface we write the sql or JPQL?

- `@Query` is used to define custom SQL or JPQL queries in Java.
- We write SQL or JPQL queries within an interface, specifically in a repository interface when working with JPA or Spring Data.

# 16

HQL stands for Hibernate Query Language, and it's a query language used with the Hibernate framework for interacting with databases. Criteria Queries, on the other hand, are a programmatic way to create database queries using criteria-based expressions instead of writing SQL or HQL queries directly.



# 17

- `EntityManager` is a key part of JPA.
- We use it to perform operations like inserting, updating, deleting, and querying database records using Java entities.
- It manages the entity lifecycle, including persistence, transactions, and caching.
- It represents a connection to the database and serves as a primary entry point for database interactions in JPA-based applications.

# 18

- `SessionFactory` is a factory for creating `Session` objects and manages database connections and configuration.
- `Session` is a short-lived object representing a single unit of work with the database, providing methods for database operations and queries.



# 19

A transaction is a unit of work that consists of one or more database operations. To manage a transaction:

1. Begin it before executing operations.
2. Execute database operations.
3. Commit to make changes permanent, or rollback to cancel them.



# 20

What is hibernate Caching?



Hibernate caching is a mechanism that stores frequently accessed data in memory to improve database operation performance. It includes first-level cache (session-specific) and second-level cache (shared across sessions). Caching reduces the need for repeated database queries.



# 21

What is the difference between first-level cache and second-level cache?



First-Level Cache:

- Session-specific
- Short-lived
- Limited to a single session
- Enabled by default

Second-Level Cache:

- Shared across sessions
- Long-lived
- Application-wide
- Optional and configured externally



# 22

How do you understand @Transactional?



`@Transactional` is an annotation commonly used in Spring-based applications to specify that a method or a class should be managed within a transaction context. It informs the Spring framework that a specific method, when invoked, should run within a transaction, ensuring that if any part of the method fails, the entire operation is rolled back, maintaining data consistency. 