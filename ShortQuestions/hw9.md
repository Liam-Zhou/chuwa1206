1. List all of the annotations you learned from class and homework to annotations.md
2. Type out the code for the Comment feature of the class project.
3. In postman, call all of the APIs in PostController and CommentController.
4. What is JPA? and what is Hibernate?

   JPA uses JDBC to CRUD from the database and transfers result from database into Java entities.

   Hibernate is the most popular ORM (object relational mapping) framework that converts database records into instances in programming languages.

5. What is Hiraki? what is the benefits of connection pool?

   Hiraki is a data source connection pool that Spring Boot uses to connect to database.

   Connection pool eliminates the overhead of creating and destroying connections by reusing the connection.

6. What is the @OneToMany, @ManyToOne, @ManyToMany? write some examples.

   @OneToMany means one row in a table is mapped to multiple rows in another table.

   One post -> many comments

   @ManyToOne means multiple rows in a table is mapped to one row in another table.

   Many comments -> one post

   @ManyToMany means multiple records in a table is associated to multiple records in another table

   One book may be written be multiple authors, and one author may write multiple books.

7. What is the cascade = CascadeType.ALL, orphanRemoval = true? and what are the other CascadeType and their features? In which situation we choose which one?

   CascadeType.ALL: propagate all operations from parent entity to its child entity

   CascadeType.PERSIST: propagate persist operation to its child entity

   CascadeType.MERGE: propagates merge operation to parent to child

   CascadeType.REMOVE: propagates remove operation to parent to child

   CascadeType.DETACH: when we detach a parent entity, the child entity will be removed

   CascadeType.LOCK: reattaches the entity and child entity with persistent context again

   CascadeType.REFRESH: when parent entity is refreshed from the database, the chile entity is also refreshed

   CascadeType.REPLICATE: when we have more than one data sources and want data in sync, the sync operation will propagate from parent entity to child entity

   CascadeType.SAVE_UPDATE: propagates the same operation to the associated child entity. It’s useful when we use Hibernate-specific operations like save, update and saveOrUpdate

   orphanRemoval = true: child entity is removed when child entity is no longer associated with parent entity

   mappedBy="cart": name of the database that is related to the field below

8. What is the fetch = FetchType.LAZY, fetch = FetchType.EAGER? what is the difference? In which situation you choose which one?

   fetch = FetchType.LAZY: load child entity when needed

   fetch = FetchType.EAGER: load child entity when parent entity is loaded

9. What is the rule of JPA naming convention? Shall we implement the method by ourselves? Could you list some examples?

   Query method return type + query method subject keyword + query method predicate keyword + method parameters

   ```
   public List<Product> findByNameAndDescription(String name, String description);
   ```

10. Try to use JPA advanced methods in your class project. In the repository layer, you need to use the naming convention to use the method provided by JPA.
11. (Optional) Check out a new branch(https://github.com/TAIsRich/springboot-redbook/tree/hw02_01_jdbcTemplate) from branch 02_post_RUD, replace the dao layer using JdbcTemplate.
12. type the code, you need to checkout new branch from branch 02_post_RUD, name the new branch with https://github.com/TAIsRich/springboot-redbook/tree/hw05_01_slides_JPQL.
13. What is JPQL?

    JPQL is a query language used by JPA to make queries against relational databases

14. What is @NamedQuery and @NamedQueries?

    @NamedQuery defines a named query in hibernate

    We use @NamedQueries to define multiple named queries.

15. What is @Query? In which Interface we write the sql or JPQL?

    @Query is one of the ways provided by Spring Data to help define a query for us to execute.

    We write them in repository interface.

16. What is HQL and Criteria Queries?

    HQL is the query language used by Hibernate

    Criteria Queries are built by criteria APIs object programmatically, by applying different filtration rules and logical conditions.

17. What is EntityManager?

    A JPA EntityManager manages connection to a database as will as database operations.

18. What is SessionFactory and Session?

    SessionFactory is a thread safe object, with configuration to connect to a database, that creates session.

    Session is an object to get physical connection to the database.

19. What is Transaction? how to manage your transaction?

    A transaction represents a unit of work

    If one step fails, the whole transaction fails

20. What is hibernate Caching?

    Hibernate uses two-level caching to cache the data that is previously retrieved.

21. What is the difference between first-level cache and second-level cache?

    First-level cache is session specific. When we get the same data in the same session, the data will be directly returned. When an entity is looked up and its found in the first-level cache, it is returned from there.

    Second-level cache works at the session factory level. When the object is cached at this level, it is available for the entire application.

22. How do you understand @Transactional? (https://github.com/TAIsRich/tutorialtransaction)

    @Transactional is used to mark a class or a method. Any database operation performed within the marked class or method will be executed within a transaction.
