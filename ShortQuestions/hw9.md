1. List all of the annotations you learned from class and homework to
    annotaitons.md
    *please see annotion.md*

<!-- 2. Type out the code for the Comment feature of the class project.
3. In postman, call all of the APIs in PostController and CommentController. -->
4. What is JPA? and what is Hibernate?

   `JPA` stands for Java Persistence API. It is a Java specification that defines a common API for Object-Relational Mapping (ORM) frameworks. ORMs allow developers to map Java objects to database tables and persist Java objects to the database.
   `Hibernate` is an open-source ORM framework that implements the JPA specification. It is one of the most popular ORMs for Java and is used by many popular Java frameworks, such as Spring Boot.

5. What is Hiraki? what is the benefits of connection pool?
   1. Hikari, is crucial for improving the efficiency and performance of database interactions in Java applications by managing and reusing database connections effectively.
6. What is the  @OneToMany, @ManyToOne, @ManyToMany? write some examples.
    **@OneToMany, @ManyToOne, @ManyToMany in JPA (Java Persistence API):**

    ### 1. @OneToMany:

    The `@OneToMany` annotation is used to define a one-to-many relationship between two entities. It implies that one entity has a collection of another entity.

    **Example:**
    ```java
    @Entity
    public class Post {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        
        private String title;

        @OneToMany(mappedBy = "post", cascade = CascadeType.ALL)
        private List<Comment> comments;
        
        // Constructors, getters, and setters
    }
    ```

    ```java
    @Entity
    public class Comment {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        private String text;

        @ManyToOne
        @JoinColumn(name = "post_id", nullable = false)
        private Post post;
        
        // Constructors, getters, and setters
    }
    ```

    In this example, a `Post` entity has a one-to-many relationship with `Comment`. The `@OneToMany` annotation is used on the `List<Comment> comments` field in the `Post` entity.

    ### 2. @ManyToOne:

    The `@ManyToOne` annotation is used to define a many-to-one relationship between two entities. It implies that many instances of one entity are associated with a single instance of another entity.

    **Example:**
    ```java
    @Entity
    public class Comment {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        private String text;

        @ManyToOne
        @JoinColumn(name = "post_id", nullable = false)
        private Post post;
        
        // Constructors, getters, and setters
    }
    ```

    In the previous example, the `Comment` entity has a many-to-one relationship with `Post`. The `@ManyToOne` annotation is used on the `Post post` field in the `Comment` entity.

    ### 3. @ManyToMany:

    The `@ManyToMany` annotation is used to define a many-to-many relationship between two entities. It implies that each record in one entity can be related to multiple records in another entity, and vice versa.

    **Example:**
    ```java
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
            inverseJoinColumns = @JoinColumn(name = "course_id")
        )
        private Set<Course> courses = new HashSet<>();
        
        // Constructors, getters, and setters
    }
    ```

    ```java
    @Entity
    public class Course {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        private String title;

        @ManyToMany(mappedBy = "courses")
        private Set<Student> students = new HashSet<>();
        
        // Constructors, getters, and setters
    }
    ```

7. What is the  cascade = CascadeType.ALL, orphanRemoval = true? and what
   are the other CascadeType and their features? In which situation we choose
   which one?
    **CascadeType.ALL and orphanRemoval=true:**

    In JPA (Java Persistence API), `CascadeType` is used to define how entity operations, such as persist, merge, remove, and refresh, should be cascaded from one entity to another. `orphanRemoval` is a related feature that allows removing entities from the relationship when they are no longer referenced.

    Here's an explanation of `CascadeType.ALL` and `orphanRemoval=true`:

    1. **CascadeType.ALL:**
    - When an entity is marked with `CascadeType.ALL`, it means that all entity operations (persist, merge, remove, refresh) performed on the parent entity will be cascaded to the associated child entities.
    - For example, if you persist a parent entity, the associated child entities will also be persisted. If you remove the parent entity, the associated child entities will be removed as well.

    2. **orphanRemoval=true:**
    - The `orphanRemoval` attribute is related to the removal of orphaned child entities. When set to `true`, it means that if a child entity is removed from the collection in the parent entity, and it is no longer referenced by any other entity, it will be automatically deleted from the database.
    - This is particularly useful when you want to ensure that the database reflects the state of the entity graph, and orphaned child entities are automatically removed.

8. What is the  fetch = FetchType.LAZY, fetch = FetchType.EAGER? what is the
    difference? In which situation you choose which one?
    `FetchType.LAZY` means associated data will not be load until when it be accessed. 
    `FetchTye.EAGER` means associated data will be fetched alone the entity.

    Use FetchType.LAZY when:

    - when we want to minimize initial loading time and only load associated data when needed.
    - when have large associations, and loading them eagerly would result in unnecessary overhead.
    - when want to improve performance by avoiding unnecessary data retrieval.

    Use FetchType.EAGER when:
    - when frequently access the associated data and want to load it in a single query.
    - when The associated data is small, and the performance impact of loading it eagerly is acceptable.
    - when want to avoid the risk of lazy loading exceptions in certain scenarios.

9.  What is the rule of JPA naming convention? Shall we implement the method by ourselves? Could you list some examples?
    **JPA Naming Conventions:**

    1. **Entity Class:** Follows Java naming conventions (e.g., `Book`).

    2. **Table Name:** Defaults to the plural form of the entity name (e.g., `Book` maps to `books`).

    3. **Column Name:** Defaults to attribute name, converted to underscores (e.g., `publicationDate` maps to `publication_date`).

    4. **Primary Key Column:** Defaults to `id`. Custom names specified with `@Column(name = "custom_id")`.

    5. **Foreign Key Column:** Derived from the referenced primary key column name.

    6. **Join Table:** Defaults to the concatenation of entity names for many-to-many relationships (e.g., `book_author`).

    7. **NamedQuery:** Unique name for queries (e.g., `@NamedQuery(name = "Book.findAll", query = "SELECT b FROM Book b")`).

    8. **Repository Method:** Follows Spring Data JPA naming conventions for query generation (e.g., `findByTitle`).

    While JPA provides defaults, custom names can be specified using annotations. Advanced control can be achieved through custom naming strategies.

10. Try to use JPA advanced methods in your class project. In the repository layer, you need to use the naming convention to use the method provided by JPA.
11. (Optional) Check out a new branch(<https://github.com/TAIsRich/springboot-redbook/tree/hw02_01_jdbcTemplate>) from branch 02_post_RUD, replace the dao layer using JdbcTemplate.
12. type the code, you need to checkout new branch from branch 02_post_RUD,
    name the new branch with https://github.com/TAIsRich/springboot-redbook/
    tree/hw05_01_slides_JPQL.



13. What is JPQL?
    *JPQL* stands for java persistence query language. it allow us to write `SQL like` way to query DB and map it to entity in java.

    ```java
    @Entity
    public class Book {
        @Id
        private Long id;
        private String title;
        private String author;

        // Other fields, getters, and setters...
    }

    // JPQL query to select books by a specific author
    TypedQuery<Book> query = entityManager.createQuery(
        "SELECT b FROM Book b WHERE b.author = :author", Book.class);
    query.setParameter("author", "John Doe");
    List<Book> books = query.getResultList();

    ```

14. What is @NamedQuery and @NamedQueries?
    `@NameQuery` is annotation in JAP used to define a single named query in entity class.

    ```java
        @Entity
        @NamedQuery(name = "Person.findByAge", query = "SELECT p FROM Person p WHERE p.age = :age")
        public class Person {
            // Entity class details...
        }
    ```
    `NamedQueryies` is for group of named queries. 
    ```java
        @Entity
        @NamedQueries({
            @NamedQuery(name = "Product.findAll", query = "SELECT p FROM Product p"),
            @NamedQuery(name = "Product.findByCategory", query = "SELECT p FROM Product p WHERE p.category = :category")
        })
        public class Product {
            // Entity class details...
        }

    ```

15. What is @Query? In which Interface we write the sql or JPQL?
    By using @Query, developers can write custom queries directly in the repository interfaces, allowing for more flexibility and control over the data access layer. we should use it in repository interface(data access layer DAO).
    ```java
    import org.springframework.data.jpa.repository.Query;
    import org.springframework.data.repository.query.Param;

    public interface UserRepository extends JpaRepository<User, Long> {

        @Query("SELECT u FROM User u WHERE u.username = :username")
        User findByUsername(@Param("username") String username);
    }

    ```
16. What is HQL and Criteria Queries?
    - HQL (Hibernate Query Language) is a query language provided by Hibernate, an ORM (Object-Relational Mapping) framework. It is a powerful and flexible query language similar to SQL but operates on Hibernate entities and their relationships.
    - Criteria Queries are a programmatic, type-safe way to express queries in Hibernate. Criteria API allows building queries using a set of Java objects representing query elements.
17. What is EnityManager?
    `EntityManager` is one of the key abstractions that JPA specification defines. EntityManager sits between the database and the application and plays the responsibility of managing the entity in context.
    Common operations include persist(Object entity), merge(Object entity), remove(Object entity), and find(Class<T> entityClass, Object primaryKey).
18. What is SessionFactory and Session?
    The `SessionFactory` is a crucial component in Hibernate that represents a factory for creating and managing Session instances.
    `session` is created by `sessionFactory`, and session is resposible for CRUD operations.
19. What is Transaction? how to manage your transaction?
    A transaction is a unit of work that consists of a sequence of one or more operations (e.g., database operations) that should be executed atomically, meaning either all operations are successfully completed, or none of them are. In the context of databases and ORM frameworks like Hibernate, a transaction ensures data integrity and consistency. a transaction should provice `ACID`.
    - we can mange the transaction in our code.
        ```java
        Session session = sessionFactory.openSession();
        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();
            // Perform operations
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }

        ```
    - we can also declare @Transactional on method to make such method to be a transaction.
20. What is hibernate Caching?
    in hibernate, `Caching` use to  to improve the performance of database operations by reducing the number of database queries. Caching involves storing frequently accessed data in memory so that it can be quickly retrieved without the need to hit the database.

21. What is the difference between first-level cache and second-level cache?

    caching in hibernate have two levels. 
    * The first-level cache is associated with the Session object and is sometimes referred to as the session cache. It is enabled by default and is specific to a particular Hibernate `Session`.
    * The second-level cache is shared across multiple sessions and is used to cache data at a higher level, reducing the need for repeated database queries.
22. How do you understand @Transactional? (<https://github.com/TAIsRich/tutorial-transaction>)

    @Transactional is a powerful annotation used in Spring to simplify transaction management in Java applications. It provides a declarative way to define transactional behavior with various attributes to customize propagation, isolation, read-only status, timeout, and more.
    - The @Transactional annotation can be applied at the `class level` (to indicate that all methods in the class should be transactional) 
    - it can also be used at the `method level` (to specify transactional behavior for individual methods).
    - It can be used with public methods to create transactional boundaries around those methods.