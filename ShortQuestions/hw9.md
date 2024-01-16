### 4. JPA? Hibernate?
- JPA: Java Persistence API, makes it easier to build Spring-powered applications that use data access technologies.
- Hibernate: is an implementation of JPA and uses common standards of JPA
### 5. Hikari, what's the benefits of connection pool
Hikari connection pool is a very fast light weight Java connection pool. It is a cache of database connections which can maintain connections that can be reused when future requests to the database are required
The connection pools can significantly improve performance for database-intensive applications because creating connection objects is costly both in terms of time and resources
### 6. What is the  @OneToMany, @ManyToOne, @ManyToMany
- @OneToMany, @ManyToOne: the relationship between the school and students, one school can have many students, while one student is related to one school
- @ManyToMany: the relationship between the students and courses. One student can choose many courses and one course can have many students.
### 7. CascadeType
-  CascadeType.ALL: propagates all operations from a parent to a child entity
-  CascadeType.PERSIST: propagates the persist operation from a parent to a child entity
-  CascadeType.MERGE: propagates the merge operation from a parent to a child entity
-  CascadeType.REMOVE: propagetes the remove operation from a parent to a child entity
-  CascadeType.DETACH: the child entity will also get removed from the persistent context
### 8. fetch = FetchType.LAZY, fetch = FetchType.EAGER
LAZY is a hint to the persistence provider runtime that data should be fetched lazily when it is first accessed.
The EAGER is a requirement on the persistence provider runtime that data must be eagerly fetched.
### 9. JPA Naming Convention
JPA can create the method by following the rules to create the method name, it should contain the keywords to show what the method should do

findByPostId(id), findByTitleIsNotNull()
### 13. JPQL
Java Persistence Query Language is used to create queries against entities to store in a relational database
### 14. @NamedQuery and @NamedQueries
@NamedQuery is used to define the single named query and @NamedQueries is used to define the multiple named queries
### 15. @Query
The annotation helps to define the custom JPQL and native SQL queries directly or repository methods, the methods are written in Repository interface.
### 16. HQL and Criteria Queries
- HQL can perform both select and non-select operations but Criteria Queries is only for selecting the data
- HQL is for static queries while Criteria is suitable for the dynamic queries.
- JPA does not support Criteria queries
### 17. EntityManager
EntityManager is used to create and remove persistent entity instances to find entities by their primary key and to query the entities.
### 18. SessionFactory and Session
SeesionFactory is a factory class for the Session objects, It is available for the whole application while a Session is only available for particular transaction.
Session is short-lived and SessionFactory is long-lived. Session provides the first level cache and SessionFactory provides the second level cache.
### 19. Transaction
A unit of work performed within the database management system against a database.
### 20. hibernate Caching
It improves the performance of the application by pooling the objects in the cache. It is useful when we have to fetch the same data multiple times. There are mainly two types: First level cache and Second level cache.
### 21. @Transactional
specifies that an interface/ class / method must have transactional semantics.