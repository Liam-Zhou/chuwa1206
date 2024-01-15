# HW9

## 1. What is JPA? and what is Hibernate?

JPA, or Java Persistence API, is a Java specification for accessing, persisting, and managing data between Java objects and relational databases. Hibernate is a popular JPA implementation that facilitates the management of relational data in Java applications.

## 2. What is Hikari? What are the benefits of a connection pool?

HikariCP is a high-performance JDBC connection pool. Connection pools like HikariCP improve application performance by reusing existing database connections, reducing the overhead of creating new connections for each database operation.

## 3. What are `@OneToMany`, `@ManyToOne`, `@ManyToMany`? Write some examples.

- `@OneToMany`: One entity is related to multiple instances of another entity. E.g., one author has many books.

  ```java
  @Entity
  public class Author {
      @Id
      private Long id;
  
      @OneToMany(mappedBy = "author")
      private Set<Book> books;
  }
  
  @Entity
  public class Book {
      @Id
      private Long id;
  
      @ManyToOne
      @JoinColumn(name = "author_id")
      private Author author;
  }
  ```

- `@ManyToOne`: Multiple entities are related to a single instance of another entity. E.g., many books belong to one publisher.

  ```java
  @Entity
  public class Book {
      @Id
      private Long id;
  
      @ManyToOne
      @JoinColumn(name = "publisher_id")
      private Publisher publisher;
  }
  
  @Entity
  public class Publisher {
      @Id
      private Long id;  
  
      @OneToMany(mappedBy = "publisher")
      private Set<Book> books;
  }
  ```

- `@ManyToMany`: Multiple instances of an entity are related to multiple instances of another entity. E.g., many students enrolled in many courses.

  ```java
  @Entity
  public class Student {
      @Id
      private Long id;
  
      @ManyToMany(mappedBy = "students")
      private Set<Course> courses;
  }
  
  @Entity
  public class Course {
      @Id
      private Long id;
      
      @ManyToMany
      @JoinTable(
          name = "course_student",
          joinColumns = @JoinColumn(name = "course_id"),
          inverseJoinColumns = @JoinColumn(name = "student_id")
      )
      private Set<Student> students;
  }
  ```

## 4. What is `cascade = CascadeType.ALL, orphanRemoval = true`?  What are the other `CascadeType` and their features? In which situation do we choose which one?

`cascade = CascadeType.ALL` means that all CascadeType operations (like persist, remove, refresh) are applied to the associated entity. `orphanRemoval = true` automatically removes child entities when they are no longer referenced. Other `CascadeType` include PERSIST, REMOVE, MERGE, etc., chosen based on the specific need of entity operations.

## 5. What are `fetch = FetchType.LAZY`, `fetch = FetchType.EAGER`? What is the difference? In which situation do you choose which one?

- `FetchType.LAZY` loads the data on demand, i.e., the data is fetched only when it's accessed for the first time.
- `FetchType.EAGER` loads all data immediately. The choice between them depends on the use case: use LAZY to improve performance when complete data isn't needed immediately, and EAGER when all related data is required.

## 6. What is the rule of JPA naming convention? Should we implement the method by ourselves? Could you list some examples?

JPA naming convention suggests using meaningful, descriptive names for entities and fields, following Java naming conventions (like camelCase for fields). Implementing methods is often not necessary as JPA provides automatic query generation based on method names.

```java
public interface CustomerOrderRepository extends JpaRepository<CustomerOrder, Long> {
    List<CustomerOrder> findByOrderDate(LocalDate date);

    List<CustomerOrder> findByTotalGreaterThan(Double minTotal);

    List<CustomerOrder> findByOrderDateBetween(LocalDate startDate, LocalDate endDate);
}
```

- **Method `findByOrderDate`**: Automatically queries `CustomerOrder` entities by the `orderDate` field.
- **Method `findByTotalGreaterThan`**: Retrieves orders where the `total` is greater than a specified value.
- **Method `findByOrderDateBetween`**: Finds orders with an `orderDate` between two specified dates.

## 7. What is JPQL?

JPQL, Java Persistence Query Language, is a query language used in JPA to write queries against entities stored in a relational database. It's similar to SQL but operates on JPA entities instead of database tables.

## 8. What are `@NamedQuery` and `@NamedQueries`?

`@Query` is an annotation used in JPA repositories to define custom queries (either JPQL or native SQL). These queries are usually written in repository interfaces extending `JpaRepository` or similar.

## 9. What is `@Query`? In which Interface do we write the SQL or JPQL?

`@Query` is an annotation used in JPA repositories to define custom queries (either JPQL or native SQL). These queries are usually written in repository interfaces extending `JpaRepository` or similar.

## 10. What are HQL and Criteria Queries?

HQL (Hibernate Query Language) is similar to SQL, but operates on Hibernate's entity objects. Criteria Queries are a programmatic, type-safe way to build queries in Hibernate.

## 11. What is `EntityManager`?

`EntityManager` in JPA manages the lifecycle of entities (e.g., persisting, removing, querying) and handles transactions. It's a key interface in JPA for interacting with the persistence context.

## 12. What are `SessionFactory` and `Session`?

In Hibernate, `SessionFactory` is a thread-safe and immutable cache of compiled mappings for a single database. A `Session` is a single-threaded, short-lived object representing a conversation between the application and the database, managing the state of the mapped objects.

## 13. What is `Transaction`? How do you manage your transaction?

A transaction in JPA and Hibernate represents a series of operations that should be executed as a single unit of work. Transactions are managed using the `EntityTransaction` interface in JPA or through the `Session` in Hibernate. They can be controlled programmatically or declaratively (e.g., with annotations).

## 14. What is Hibernate Caching?

Hibernate caching is a mechanism to reduce the number of database hits by storing entities or query results in memory. There are two levels of caching in Hibernate:

- First-Level Cache: Associated with the `Session` object, it's enabled by default and stores objects within the current session.
- Second-Level Cache: Associated with the `SessionFactory` and is shared across sessions. It needs to be explicitly enabled.

## 15. What is the difference between first-level cache and second-level cache?

The first-level cache in Hibernate is enabled by default and is associated with the `Session` scope. It's a per-session cache and not accessible to other sessions. The second-level cache is associated with the `SessionFactory`, and it's shared across different sessions. It needs explicit configuration and can hold data across transactions and sessions.

## 16. How do you understand @Transactional?

In `placeOrder` method, we are performing multiple database operations:

- Saving an `Order`.
- Saving a `Payment`.

These operations are inherently related – the payment is linked to the order. If, for example, the payment saving operation fails (due to an unsupported card type or any other reason), you wouldn't want the order to be saved independently, as it would lead to inconsistent data (an order without a corresponding payment).

By marking `placeOrder` as `@Transactional`, we ensure that:

- Both the order and payment are saved only if both operations succeed.
- If an error occurs during payment processing, neither the order nor the payment is saved, maintaining database consistency.