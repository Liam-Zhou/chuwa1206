

1. Type out the code for the Comment feature of the class project.

2. In postman, call all of the APIs in PostController and CommentController. 

3. What is JPA? and what is Hibernate? 

   JPA is a Java specification for ORM that defines a set of standard interfaces and annotations for mapping Java objects to relational databases.

   Hibernate It is an open-source ORM framework for Java applications.

   Hibernate simplifies database interaction by providing a high-level, object-oriented API for data persistence. It allows developers to work with Java objects directly, and it handles the mapping between these objects and database tables.

4. What is hikari? what is the benefits of connection pool? 

   - HikariCP is a lightweight and fast connection pooling library for Java applications.
   - It provides a pool of database connections that can be reused by multiple clients in a Java application, such as web applications.
   - 
   - 
   - Connection pooling reduces the overhead of creating and destroying database connections, optimizing resource usage.
   - reduces the time and latency associated with establishing new connections 
   - Connection pools enable multiple threads or clients to safely share a limited number of database connections

5. What is the @OneToMany, @ManyToOne, @ManyToMany? write some examples. 

   **`@OneToMany`**:

   - The `@OneToMany` annotation is used to define a one-to-many relationship between two entities. It indicates that one entity has multiple related entities.

   ```java
   @Entity
   public class Author {
       @Id
       @GeneratedValue(strategy = GenerationType.IDENTITY)
       private Long id;
       private String name;
       
       @OneToMany(mappedBy = "author")
       private List<Book> books;
       
       // Getters and setters...
   }
   
   @Entity
   public class Book {
       @Id
       @GeneratedValue(strategy = GenerationType.IDENTITY)
       private Long id;
       private String title;
       
       @ManyToOne
       @JoinColumn(name = "author_id")
       private Author author;
       
       // Getters and setters...
   }
   
   ```

   **`@ManyToOne`**:

   - The `@ManyToOne` annotation is used to define the many-to-one side of a relationship. It specifies that many instances of one entity are related to one instance of another entity.

   ```java
   @Entity
   public class Employee {
       @Id
       @GeneratedValue(strategy = GenerationType.IDENTITY)
       private Long id;
       private String name;
       
       @ManyToOne
       @JoinColumn(name = "department_id")
       private Department department;
       
       // Getters and setters...
   }
   
   @Entity
   public class Department {
       @Id
       @GeneratedValue(strategy = GenerationType.IDENTITY)
       private Long id;
       private String name;
       
       @OneToMany(mappedBy = "department")
       private List<Employee> employees;
       
       // Getters and setters...
   }
   
   ```

   **`@ManyToMany`**:

   - The `@ManyToMany` annotation is used to define a many-to-many relationship between two entities, indicating that each entity can be associated with multiple instances of the other entity.

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
       private List<Course> courses;
       
       // Getters and setters...
   }
   
   @Entity
   public class Course {
       @Id
       @GeneratedValue(strategy = GenerationType.IDENTITY)
       private Long id;
       private String title;
       
       @ManyToMany(mappedBy = "courses")
       private List<Student> students;
       
       // Getters and setters...
   }
   
   ```

   

6. What is the cascade = CascadeType.ALL, orphanRemoval = true? and what are the other CascadeType and their features? In which situation we choose which one? 

   cascade = CascadeType.ALL

   - all entity state transitions (e.g., persist, merge, remove, refresh) should be cascaded from the parent entity to the related child entities.
   - When an operation (e.g., persist or remove) is performed on the parent entity, the same operation is applied to the associated child entities.

   orphanRemoval = true

    It indicates that when an entity is removed from the association (i.e., it becomes orphaned), it should **also be removed from the database.**

   
   In JPA (Java Persistence API), the `cascade` attribute and `orphanRemoval` attribute are used in entity associations to define how the lifecycle of related entities should be managed. These attributes help specify the behavior of associated entities when the owning entity (parent) is persisted, updated, or removed.

   **1. `cascade = CascadeType.ALL`:**

   - `cascade = CascadeType.ALL` is an option for the `cascade` attribute, and it indicates that all entity state transitions (e.g., persist, merge, remove, refresh) should be cascaded from the parent entity to the related child entities.
   - When an operation (e.g., persist or remove) is performed on the parent entity, the same operation is applied to the associated child entities.

   **2. `orphanRemoval = true`:**

   - `orphanRemoval = true` is an attribute that can be set to `true` on a `@OneToMany` or `@OneToOne` association. It indicates that when an entity is removed from the association (i.e., it becomes orphaned), it should also be removed from the database.

   Now, let's explore other `CascadeType` options and their features:

   **CascadeType Options:**

   - `CascadeType.PERSIST`: Cascades the persist operation, meaning that when the parent entity is persisted, the associated child entities will also be persisted if they are not already managed.
   - `CascadeType.MERGE`: Cascades the merge operation, allowing changes made to the parent entity to be propagated to associated child entities.
   - `CascadeType.REMOVE`: Cascades the remove operation, so when the parent entity is removed, the associated child entities are also removed from the database.
   - `CascadeType.REFRESH`: Cascades the refresh operation, which can be used to re-synchronize the parent entity and its associated child entities with the database state.
   - `CascadeType.DETACH`: Cascades the detach operation, allowing the parent entity and associated child entities to be detached from the persistence context.
   - `CascadeType.ALL`: As mentioned earlier, `CascadeType.ALL` combines all the above cascade types.

   **When to Choose Cascade Types:**

   1. **PERSIST**:
      - Use `CascadeType.PERSIST` when you want to ensure that related child entities are automatically persisted when the parent entity is persisted.
      - For example, when saving a new parent entity with new child entities, and you want to persist them together.
   2. **MERGE**:
      - Use `CascadeType.MERGE` when you want changes made to the parent entity to be propagated to associated child entities.
      - This is useful when updating child entities along with the parent entity.
   3. **REMOVE**:
      - Use `CascadeType.REMOVE` when you want to ensure that deleting the parent entity also deletes the associated child entities.
      - Be cautious with this cascade type, as it can lead to unintended data deletion.
   4. **REFRESH**:
      - Use `CascadeType.REFRESH` when you need to refresh both the parent and child entities with the latest database state.
   5. **DETACH**:
      - Use `CascadeType.DETACH` when you want to detach both parent and child entities from the persistence context.
   6. **ALL**:
      - `CascadeType.ALL` should be used when you want all of the above cascade operations to apply to the association.

7. What is the fetch = FetchType.LAZY, fetch = FetchType.EAGER? what is the difference? In which situation you choose which one?  

   **1. `fetch = FetchType.LAZY`**:

   - When you specify `fetch = FetchType.LAZY`, it means that related entities are loaded lazily, which is the default behavior in JPA.
   - Lazily fetched associations are not loaded immediately when the parent entity is queried. Instead, they are loaded from the database only when you access the associated property or collection in your code.
   - Lazy loading can help improve performance by loading related entities only when they are needed, reducing unnecessary database queries.
   - Use `fetch = FetchType.LAZY` when you have associations that are rarely accessed or when loading related entities would cause performance issues.

   **2. `fetch = FetchType.EAGER`**:

   - When you specify `fetch = FetchType.EAGER`, it means that related entities are loaded eagerly, meaning they are fetched immediately along with the parent entity when it is queried from the database.
   - Eager loading can simplify your code because all related data is available without the need for additional database queries. However, it can lead to performance issues if used excessively or if the associated data is not always needed.
   - Use `fetch = FetchType.EAGER` when you know that you will consistently need the associated data and when the additional load time is acceptable.

   - 
   - 
   - 
   - 
   - Use `LAZY` fetch when you want to optimize performance and reduce the initial load time of your entities. This is especially useful for large or rarely accessed associations.
   - Use `EAGER` fetch when you consistently need the associated data and want to simplify your code by avoiding additional database queries. However, be cautious about potential performance issues, especially with deep object graphs.

8. What is the rule of JPA naming convention? Shall we implement the method by ourselves? Could you list some examples? 

   **1. Entity Class Naming**:

   - By default, the entity class name is used as the name for the corresponding database table.
   - For example, if you have an entity class named `Author`, JPA will map it to a database table named `Author`.

   **2. Primary Key Column Naming**:

   - The primary key column is named after the primary key field in the entity class.
   - For example, if you have an entity class with a primary key field named `id`, JPA will create a primary key column named `id`.

   **3. Property/Field Mapping**:

   - Entity properties or fields are mapped to table columns with the same name.
   - For example, if you have a property named `name` in your entity class, JPA will map it to a table column named `name`.

   **4. Join Column Naming**:

   - When defining relationships between entities (e.g., `@ManyToOne`, `@OneToMany`), JPA uses a default naming convention for join columns.
   - The default join column name is the name of the referenced entity's primary key field followed by an underscore and the name of the field in the owning entity.
   - For example, if you have a `Book` entity with a `author` field referencing an `Author` entity, JPA will use the default join column name `author_id`.

   **1. Simple Property Expressions**:

   - You can create a query method by using the property names of the entity as keywords in the method name.
   - For example, to find books by their title, you can create a method named `findByTitle(String title)`.

   **2. Complex Property Expressions**:

   - You can chain property names to create more complex queries. Use `And` or `Or` to concatenate properties.
   - For example, to find books by both title and author, you can create a method named `findByTitleAndAuthor(String title, Author author)`.

   **3. Comparison Operators**:

   - You can use comparison operators (`Equals`, `Is`, `GreaterThan`, `LessThan`, etc.) to create queries.
   - For example, to find books published after a certain date, you can create a method named `findByPublishDateAfter(Date date)`.

   **4. Like Expressions**:

   - You can use `Containing`, `StartingWith`, `EndingWith`, or `Like` to create queries based on partial matching.
   - For example, to find books with titles containing a specific keyword, you can create a method named `findByTitleContaining(String keyword)`.

   **5. Negation Expressions**:

   - You can negate a condition using `Not` or `IsNot`.
   - For example, to find books that are not published by a specific author, you can create a method named `findByAuthorIsNot(Author author)`.

   **6. Ordering Results**:

   - You can specify the order in which results should be sorted using `OrderBy`.
   - For example, to find books sorted by title in ascending order, you can create a method named `findByOrderByTitleAsc()`.

   **7. Limiting Results**:

   - You can limit the number of results returned using `First`, `Top`, `FirstBy`, or `TopBy`.
   - For example, to find the first 10 books by a specific author, you can create a method named `findFirst10ByAuthor(Author author)`.

   

9. type the code, you need to checkout new branch from branch 02_post_RUD, name the new branch with https://github.com/TAIsRich/springboot-redbook/ tree/hw05_01_slides_JPQL. 

10. What is JPQL?

    JPQL  is a query language that is part of the (JPA)

11. What is @NamedQuery and @NamedQueries?

    **1. `@NamedQuery`**:

    - The `@NamedQuery` annotation is used to define a single named query for an entity class. This named query can be used to retrieve data from the database using a specific JPQL query.
    - The `@NamedQuery` annotation is typically placed above a method in the entity class, and it associates the method with a named JPQL query.

    **2. `@NamedQueries`**:

    - The `@NamedQueries` annotation is used to define multiple named queries for an entity class. It allows you to specify multiple named queries within a single annotation.
    - This annotation is helpful when you have multiple named queries associated with the same entity and want to group them together.

    ```java
    @Entity
    @NamedQueries({
        @NamedQuery(name = "findBooksByTitle", query = "SELECT b FROM Book b WHERE b.title = :title"),
        @NamedQuery(name = "findBooksByAuthor", query = "SELECT b FROM Book b WHERE b.author = :author")
    })
    public class Book {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        
        private String title;
        
        // ...
    }
    
    ```

    

12. What is @Query? In which Interface we write the sql or JPQL?

    use the `@Query` annotation to specify your own query statements and associate them with methods in a repository interface.

    ```java
    public interface BookRepository extends JpaRepository<Book, Long> {
    
        @Query("SELECT b FROM Book b WHERE b.author = ?1")
        List<Book> findBooksByAuthor(String authorName);
    }
    ```

    Write sql or jpql in interface that : extends one of the Spring Data JPA repository base interfaces, such as `JpaRepository` or `CrudRepository`.

13. What is HQL and Criteria Queries? 

    **HQL (Hibernate Query Language)**:

    1. **Description**:
       - HQL is a language specific to Hibernate and is similar in syntax to SQL . However, HQL operates on the object-oriented model provided by Hibernate, not directly on database tables and columns.

    **Criteria Queries**:

    1. **Description**:

       - Criteria Queries are a programmatic and type-safe way of building queries using the Criteria API provided by Hibernate.
       - Instead of writing queries as strings, Criteria Queries allow you to construct queries using Java code and a set of criteria objects.

       ```java
       CriteriaBuilder builder = session.getCriteriaBuilder();
       CriteriaQuery<Book> criteria = builder.createQuery(Book.class);
       Root<Book> root = criteria.from(Book.class);
       
       criteria.select(root).where(builder.equal(root.get("title"), "Sample Book"));
       
       List<Book> books = session.createQuery(criteria).getResultList();
       
       ```

       

14. What is EnityManager?

    `EntityManager` is responsible for managing the lifecycle of JPA entities, including persisting, retrieving, updating, and deleting entities.

    

    ```java
    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myPersistenceUnit");
    EntityManager entityManager = entityManagerFactory.createEntityManager();
    
    // Begin a transaction
    entityManager.getTransaction().begin();
    
    // Create and persist an entity
    Author author = new Author();
    author.setName("John Doe");
    entityManager.persist(author);
    
    // Commit the transaction
    entityManager.getTransaction().commit();
    
    // Close the EntityManager when done
    entityManager.close();
    
    ```

    In this example, we create an `EntityManager`, begin a transaction, persist an `Author` entity, commit the transaction, and finally close the `EntityManager`. The `EntityManager` manages the database interactions and transactional behavior for us, ensuring that changes are properly synchronized with the database.

15.  What is SessionFactory and Session?

    `SessionFactory` and `Session` are core components of Hibernate. They play a central role in managing database connections, transactions, and interactions with the database.

    Key responsibilities of the `SessionFactory` include:

    - Establishing and managing database connections
    - It holds the configuration settings for Hibernate, such as database connection details, entity mappings, and caching settings.
    - Creating `Session` instances: It creates new `Session` objects, which represent individual units of work with the database.

    **2. Session**:

    - The `Session` is a short-lived, non-thread-safe object in Hibernate.
    - It represents a single unit of work with the database and is used to perform database operations on entities.
    - Typically, you create and discard `Session` objects within a specific scope, such as a method or a transaction.

    Key responsibilities of the `Session` include:

    - CRUD operations: It provides methods for persisting, retrieving, updating, and deleting entities from the database.

    - Transaction management: It allows you to start and commit or roll back transactions, ensuring data consistency.

    - Caching: It manages the first-level cache (session cache) for entities, improving performance by reducing database round-trips.

      ```java
      Session session = sessionFactory.openSession(); // Create a new Session
      Transaction transaction = session.beginTransaction(); // Begin a transaction
      
      Author author = new Author();
      author.setName("John Doe");
      
      session.persist(author); // Persist the entity to the database
      
      transaction.commit(); // Commit the transaction
      session.close(); // Close the Session
      
      ```

      

16. What is Transaction? how to manage your transaction?

    A transaction represents a sequence of one or more database operations that are treated as a single unit of work. 

    ACID

    A: Atomicity: a transaction is single operations, either all changes within the transaction are applied or none of them are.

    C: Consistency:  A transaction brings the database from one consistent state to another consistent state. 

    I: Isolation: Transactions are isolated from each other, meaning that the changes made by one transaction are not visible to other transactions until the first transaction is committed.

    D: Durability: Once a transaction is committed, its changes are permanent and will survive any subsequent system failures.

    

    - You typically use the `begin()` method to start a transaction, `commit()` to apply changes and make the transaction permanent, and `rollback()` to undo changes and abort the transaction.

    - Here's an example of programmatic transaction management with Hibernate:

    - ```java
      Session session = sessionFactory.openSession();
      Transaction transaction = session.beginTransaction();
      
      try {
          // Perform database operations here
          session.save(entity);
          
          transaction.commit(); // Commit the transaction if all operations succeed
      } catch (Exception e) {
          transaction.rollback(); // Roll back the transaction in case of an exception
      } finally {
          session.close(); // Close the session
      }
      
      ```

      

17. What is hibernate Caching? 

    Hibernate provides two main types of caching:

    1. **First-Level Cache (Session Cache)**:

       is associated with an individual Hibernate `Session`. Each `Session` has its own first-level cache.

    2. **Second-Level Cache**:

       - The second-level cache is a shared cache that is available across multiple `Session` instances in an application. It is often used to cache data that is accessed frequently by multiple users or sessions.

18. What is the difference between first-level cache and second-level cache?

    first-level cache is specific to a single `Session` and is primarily used to reduce the number of database queries within that `Session`. 

    second-level cache, on the other hand, is shared across multiple sessions and is used to cache data that is accessed frequently by multiple parts of an application, improving overall performance. 

19. How do you understand @Transactional?  

    The `@Transactional` annotation in Spring is used to define the scope of a database transaction for a specific method or class. It is a declarative way of specifying transaction management behavior in a Spring application. When you annotate a method or class with `@Transactional`, you are telling Spring to manage the transactional behavior for that method or class automatically.