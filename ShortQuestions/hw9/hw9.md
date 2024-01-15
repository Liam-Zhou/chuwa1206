4.  What is JPA? and what is Hibernate?
    JPA defines a set of concepts and APIs that Java developers can use to map Java objects to database tables. It is an abstraction layer that allows developers to work with data as Java objects, rather than dealing directly with SQL statements and database specifics.
    Hibernate is an open-source ORM framework for Java. It is one of the most popular ORM tools and provides an implementation of the JPA specifications. As an ORM framework, Hibernate handles the mapping from Java classes to database tables and from Java data types to SQL data types, and relieves the developer from manual data handling and conversion.

5.  What is Hiraki? what is the benefits of connection pool?
    HikariCP is a high-performance Java connection pooling library. Connection pooling is a technique used to improve the performance and resource utilization when interfacing with a database. Rather than opening and closing a database connection for each user request, a pool of connections is maintained and reused.
    Improved Performance, Resource Utilization, Reduced Latency, Better Management of Database Resources, Automatic Connection Recovery, Load Balancing, Consistency and Transaction Management, Simplified Database Access Code

6.  What is the  @OneToMany, @ManyToOne, @ManyToMany? write some examples.
    The @OneToMany, @ManyToOne, and @ManyToMany annotations in Java Persistence API (JPA) are used to define the relationships between entities.

@OneToMany
Represents a one-to-many relationship between two entities. It is used on the 'one' side of the relationship.

`` @Entity
public class User {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;

    @OneToMany(mappedBy = "user")
    private List<Post> posts;
}
``

@ManyToOne
Represents a many-to-one relationship between two entities. It is used on the 'many' side of the relationship.

``@Entity
public class Post {
// ... other fields ...

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}``

@ManyToMany
Represents a many-to-many relationship between two entities. It requires a join table to handle the relationship.

`` @Entity
    public class Course {
    @Id
    private Long id;
    
        @ManyToMany
        @JoinTable(
          name = "student_course",
          joinColumns = @JoinColumn(name = "course_id"),
          inverseJoinColumns = @JoinColumn(name = "student_id")
        )
        private Set<Student> students;
        // ...
    } ``


7. What is the  cascade = CascadeType.ALL, orphanRemoval = true? and what
   are the other CascadeType and their features? In which situation we choose
   which one?

   cascade = CascadeType.ALL, orphanRemoval = true:

CascadeType.ALL means that all persistence operations (such as persist, remove, merge, etc.) will be cascaded from the parent entity to the associated child entity.
orphanRemoval = true means that if an associated child entity is no longer referenced from the parent entity, it will be automatically removed, which is useful for cleaning up dependent objects that should not exist without a reference from an owning entity.

Other CascadeTypes and their features:

CascadeType.PERSIST: Only cascades the persist operation.
CascadeType.MERGE: Only cascades the merge operation.
CascadeType.REMOVE: Only cascades the remove operation.
CascadeType.DETACH: Only cascades the detach operation.
CascadeType.REFRESH: Only cascades the refresh operation.

You choose the cascade type based on the needs of your application. If you want to propagate all entity state changes, use CascadeType.ALL. For more fine-grained control, you might choose specific cascade types to avoid unintended operations on child entities.


8.  What is the  fetch = FetchType.LAZY, fetch = FetchType.EAGER? what is the
    difference? In which situation you choose which one?

FetchType.LAZY: This is the default fetching strategy for all collections and to-one associations. The related entities are loaded lazily from the database when they are accessed for the first time. This strategy is preferred for better performance, especially when
you have a large number of entities with associations and you don't always need the associated entities.

FetchType.EAGER: This strategy tells the persistence provider to fetch the related entities immediately along with the parent entity. It's useful when you always need the associated entities and they are not too large or too numerous to cause a performance issue.

You choose LAZY to improve performance by avoiding unnecessary database joins and data loading, and EAGER when you need the related data available without an additional database query.

9.  What is the rule of JPA naming convention? Shall we implement the method by
    ourselves? Could you list some examples?
    In JPA, naming conventions primarily relate to the naming of entity classes, fields, and query methods.

Entity Classes: Should clearly represent the database table, using CamelCase.
Fields: Should match table column names, using camelCase.
Query Methods: Named using patterns like find...By, reflecting the entity properties, with custom queries annotated by @Query.

example:

if the DB table name is student_details，the entity class name should be StudentDetails。
if there is a column named date_of_birth, in the class, the field should be named as dateOfBirth

findStudentByLastName(String lastName)
@Query("SELECT s FROM StudentDetails s WHERE s.status = 'Active'")。

13. What is JPQL?
    is part of the Java Persistence API (JPA) and is a query language specifically designed for querying entity objects

14. What is @NamedQuery and @NamedQueries?
    @NamedQuery and @NamedQueries are annotations in JPA (Java Persistence API) used to define static, named queries at the class level. These queries are associated with entity classes and can be invoked anywhere in the application using their names.

15. What is @Query? In which Interface we write the sql or JPQL?
    @Query is an annotation used in the context of Spring Data JPA, a part of the larger Spring framework. It's used to define SQL or JPQL queries directly on repository methods.
    Used in Repository Interface: @Query is typically used in a repository interface that extends JpaRepository or CrudRepository.

16. What is HQL and Criteria Queries?
    HQL (Hibernate Query Language) and Criteria Queries are two different ways to query data when using Hibernate.
    ``String hql = "FROM Employee E WHERE E.id = 10";
    Query query = session.createQuery(hql);
    List results = query.list();``

    ``CriteriaBuilder cb = session.getCriteriaBuilder();
    CriteriaQuery<Employee> cr = cb.createQuery(Employee.class);
    Root<Employee> root = cr.from(Employee.class);
    cr.select(root).where(cb.equal(root.get("id"), 10));
    Query<Employee> query = session.createQuery(cr);
    List<Employee> results = query.getResultList();``


17.  What is EnityManager?
     EntityManager is a fundamental part of the Java Persistence API (JPA), which is a specification for managing relational data in Java applications.
    ``EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistenceUnit");
        EntityManager em = emf.createEntityManager();
        
        em.getTransaction().begin();
        Employee emp = new Employee();
        emp.setName("John Doe");
        em.persist(emp);
        em.getTransaction().commit();
        
        em.close();
        emf.close();``

    18. What is SessionFactory and Session?
        SessionFactory and Session are key components used for managing the interaction with the database.
    
        ``
    SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
    Session session = sessionFactory.openSession();
    session.beginTransaction();

    Employee employee = new Employee("John Doe");
    session.save(employee);

    session.getTransaction().commit();
    session.close();
``
    
19. What is Transaction? how to manage your transaction?
    a transaction is a fundamental concept that refers to a sequence of operations performed as a single logical unit of work. The key properties of a transaction are often summarized by the acronym ACID, standing for Atomicity, Consistency, Isolation, and Durability.

20. What is hibernate Caching?
    Hibernate caching is a mechanism in the Hibernate framework that helps improve the performance of database-driven applications by reducing the number of direct database accesses. It does this by storing some results in memory.

21. What is the difference between first-level cache and second-level cache?

scope:
First-level cache is session-specific; it exists within the scope of a single Hibernate Session.
Second-level cache is global; shared across all sessions created by the same SessionFactory.

life cycle:
First-level cache lives as long as the session lives. It's cleared when the session is closed.
Second-level cache can persist across multiple sessions and lasts as long as the SessionFactory is active.

configuration:
First-level cache is enabled by default and requires no explicit setup.
Second-level cache requires explicit configuration to be enabled and used.

use case:
First-level cache is useful within a single transaction or session.
Second-level cache benefits the application at a broader level, reducing database hits across multiple sessions.

22. How do you understand @Transactional? (https://github.com/TAIsRich/tutorial-
    transaction)
    The @Transactional annotation in the context of Spring Framework is a key aspect of declarative transaction management. It helps in managing transaction boundaries declaratively. 
``import org.springframework.transaction.annotation.Transactional;

@Transactional
public class MyService {
public void myTransactionalMethod() {
// method logic
}
}``