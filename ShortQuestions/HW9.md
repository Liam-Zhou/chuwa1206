(4) `JPA` is Java Persistence API and hibernate are both related to headling database in java. 
JPA is a Java-based specification and there are multiple implementations available, while Hibernate being one of the most popular choices. Hibernate
is a open-source ORM framework. It simplifies database interaction by mapping Java objects to database tables and providing a rich set of features for managing database operations.

(5) Hikari is a high performance java connection pooling library. It is lightweight, fast and know for its performance and efficiency in managing database connections in java applications. The benefit using connection pool is
improved performance, managed resources, scalability, consistent experience.

(6) `@OneToMany`: entity class is "one". The variable use this annotation is "many". For example: one user can have many phone number. 
```
@Entity
public class User {
    @OneToMany(mappedBy = "user")
    private Set<PhoneNumber> phoneNumbers;
    }
```
`@ManyToOne`: Entity class is "many". The variable use this annotation is "one". For example: many phone numbers belongs to one user
```
@Entity
public class PhoneNumber {
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
```
`@ManyToMany`: used for relationships where multiple entities on both sides can be associated with each other. for example: many students can enroll in many courses. 
```
@Entity
public class Course {
     @ManyToMany(mappedBy = "courses")
     private Set<Student> students;
}
 ```

(7) `cascade = CasadaType.ALL` means all operations are applied to the related entity. `orphanRemoval = true` means if you delete an entity,
all its related entities will also be deleted. There are other types of Cascade Type. `PERSIST` means when you want to create new entities along with their relationships. 
Use `REMOVE` for deleting entities and their relationships. Use `MERGE` for updating existing entities and their relationships. 
Use `REFRESH` for refreshing the state of the current entity and its relationships. Use `DETACH` when you want to detach an entity from the persistence context. 
Use `DETACH` when you want to detach an entity from the persistence context.

(8) `fetch = FetchType.LAZY` means loaded entities are fetched on-demand. They are not loaded until explicitly accessed in the code.
This is efficient for large datasets or when the associated data is not frequently accessed. 
`fetch = FetchType.EAGER` means loaded entities are loaded immediately with their parent entity, even if they are not needed. 
This is useful when the associated data is almost always used and is not too large.

(9) `JPA naming convention` rules are, by default, the class name is used as table name and filed names are used as column name. 
Use `@Table` for custom table names and `@Column` for custom column names. For `Repository Methods` JPA repositories allow
defining query methods by method naming conventions. You don't need to implement these methods. JPA provide implementation. For example, findByLastName(String lastName), 
CountByAge(int age), findByStartDateAfter(Date date). 

(13) JPQL is a query language for JPA(Java Persistence API). It allows you to write database queries using Java entity objects rather than SQL table names and columns. 
For example:
```
String jpql = "SELECT u FROM User u WHERE u.age > 18";
TypedQuery<User> query = entityManager.createQuery(jpql, User.class);
List<User> users = query.getResultList();
```

(14) `@NamedQuery` and `@NameQueries` are used to defined static, named queries at the entity level. 
For example:
```
@Entity
@NamedQuery(name = "User.findByAge", query = "SELECT u FROM User u WHERE u.age = :age")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String name;
    private int age;
    
}
```
To use `@NamedQuery`, we need to call these methods. 
```
    @PersistenceContext
    EntityManager entityManager;

TypedQuery<User> query = entityManager.createNamedQuery("User.findByAge", User.class);
query.setParameter("age", 30); // Set parameter value
List<User> users = query.getResultList(); // Execute the query and retrieve results
```
After using entityManager, Need to close it:
```
entityManager.close():
```
Here is another example:
```
@Entity
@NamedQueries({
    @NamedQuery(name = "User.findByAge", query = "SELECT u FROM User u WHERE u.age = :age"),
    @NamedQuery(name = "User.findByLastName", query = "SELECT u FROM User u WHERE u.lastName = :lastName")
})
public class User {
    // ...
}
```
(15) `@Query` annotation is used to define custom queries(SQL or JPQL). It allows for greater flexibility than standard CRUD
methods provided by JPA.  For example: 
```
public interface UserRepository extends JpaRepository<User, Long> {
    @Query("SELECT u FROM User u WHERE u.email = ?1") // ?1的意思是这里缺一个变量 需要在下面的method查询中 作为parameter输入
    User findByEmail(String email);

    @Query(value = "SELECT * FROM users WHERE last_name = :lastName", nativeQuery = true) 
    List<User> findByLastName(@Param("lastName") String lastName);
}
```
There are two ways to use `@Query`, one is using JPQL, another one is using native SQL.

We need to write them in `dao` interface which named as somethingRepository. 

(16) HQL is a object-oriented query language, similar to SQL. But instead operates on Hibernate's entity objects rather than
database tables. For example: 
```
String hql = "FROM User u WHERE u.age > 18";
Query query = session.createQuery(hql);
List results = query.list();
```
Criteria API provides a programmatic way to build queries in Hibernate. It's useful for building complex queries dynamically and is type-safe. 
For example: 
```
CriteriaBuilder cb = session.getCriteriaBuilder();
CriteriaQuery<User> cr = cb.createQuery(User.class);
Root<User> root = cr.from(User.class);
cr.select(root).where(cb.gt(root.get("age"), 18));
Query<User> query = session.createQuery(cr);
List<User> results = query.getResultList();
```
(17) EntityManager is the primary interface for interacting with the persistence context in JPA. It manages the lifecycle 
of entities including operations like persist, merge, remove, find, createQuery, createNamedQuery, createNativeQuery. 

(18) `SessionFactory` is heavyweight, thread-safe object that serves as a factory for `Session` objects. `Session` is a lightweight
, non-thread-safe object that represents a single unit of work with database. It's used to create, read, update and delete the entity objects. 

(19) A Transaction in the context of database operations and ORM frameworks. 

A transaction is a set of operations that are executed as a single unit of work which can make sure all operations within 
it either all succeed or all failed. 

To manage transactions: use `@Transactional` in service layer coding part. 

(20) Hibernate caching is a mechanism in the Hibernate framework to reduce the number of database accesses, improving the performance
of java application. It stores data that has already been retrieved from the database, so subsequent request for the same data
can be served without accessing the database again. 

(21) Scope: First-Level Cache: Associated with the `Session` object and is confirmed to a single session. It's automatically enabled. 
Second-Level Cache: Associated with the `SessionFactory` and is shared across multiple sessions. 
Lifecycle: First-Level Cache: Exists for the duration of the session. It's cleared when the session is closed. Second-Level Cache:
Persists beyond the lifetime of a single session and can cache data across sessions. 