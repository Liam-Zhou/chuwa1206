# 1. List all of the annotations you learned from class and homework to annotations.md
    @Bean you could take full control to create and configure the beans as needed
    @Component: allow spring to detect custom beans automatically and managed by spring container 
    @Controller, @Service and @Repository are special types of @Component
    they are used to indicate the roles of the annnotated classes witin the application
    @RequestMapping: map the requets to specifict class and its method base on the uri
    @PathVariable: @RequestParam; get the path paramenter or query paraement from the url of request 
    @RestController: (@Controller and @ResponseBody) attache the generted output directly into the body of the HTTP response
    @Entity: indicates that the class is a JPA entity 
    @Table: specifies the details of the databases table to which the entity is mapped 
    @Id: marks a filed as the primary key of the entityt 
    @GeneratedValue: configures the way primary keys are genereated 
    @Column: Specifies the dtails of the database column to which this field is mapped 
    @ManyToOne, @OneToMany, @OneToOne, @ManyToMany: Define the relationships between entities 
    @JoinColumn: Specifies the deatails of the join coluimn for relationships 

# 2. Type out the code for the Comment feature of the class project.
# 3. In postman, call all of the APIs in PostController and CommentController.
# 4. What is JPA? and what is Hibernate?
    It is standard for Object-relational mapping and use JDBC to CRUD database and transfer result from database to java entities
    Hibernated is the implementaion of ORM framework 
# 5. What is Hiraki? what is the benefits of connection pool?
    HikariCP (Connection Pool). it is the JDC connection pool for Java applications
    It is used to manage and optimize database connections.
# 6. What is the @OneToMany, @ManyToOne, @ManyToMany? write some examples.
    It is annotaion define the relationship between entities that connrespoidning to the tables in database
    @OneToMany: Author -> Book 
    @ManyToOne: Book ->  Author
    @ManyToMany: class -> students
# 7. What is the cascade = CascadeType.ALL, orphanRemoval = true? and what are the other CascadeType and their features? In which situation we choose which one?
    Cascading means propagating an operation from the owning entity to the related entity 
    CascadeType.ALL: All cascade operations on wning entity appliced to related entity
    It means that if an tenttity is removed from the association. It wiill be deleted from the database 
     (entities that are no longer associated with any parent) are automatically deleted.
    Use CascadeType.REMOVE if you want associated entities to be removed when the owning entity is removed.

# 8. What is the fetch = FetchType.LAZY, fetch = FetchType.EAGER? what is the difference? In which situation you choose which one?
    Eager fetch: when a recorrd id fetched from the database, all the associated records from related tables are also fetched
        when you consistently need the related entities and want to minimize the number of subsequent queries.
    Lazy fetch: when we nend data from the that field, then JPA will fetch those realted data: 
         when you have a large number of related entities and want to optimize initial loading performance

# 9. What is the rule of JPA naming convention? Shall we implement the method by ourselves? Could you list some examples?
    JPA will implement those methods automatacally 
    JPA Naming Convention: 
    findyByAgeIsNull: Where age is null
    findByAgeIsNotNull: Where age is not null
    findyByStartDateBetween(a, b): where stardata between ? and ?
    
# 10. Try to use JPA advanced methods in your class project. In the repository layer, you need to use the naming convention to use the method provided by JPA.
# 11. (Optional) Check out a new branch(https://github.com/TAIsRich/springboot-redbook/tree/hw02_01_jdbcTemplate) from branch 02_post_RUD, replace the dao layer using JdbcTemplate.
# 12. type the code, you need to checkout new branch from branch 02_post_RUD, name the new branch with https://github.com/TAIsRich/springboot-redbook/tree/hw05_01_slides_JPQL.
# 13. What is JPQL?
    JPQL is a platform-independent query language defined as part of the Java Persistence API(JPA). It operates at the object level rather than on the database tables.
# 14. What is @NamedQuery and @NamedQueries?
    They are the annotations in the JPA. named queries are pre-defined queries associated with an entity and they can be referenced by name in application code.
    @Entity
    @NamedQueries({
        @NamedQuery(
        name = "findEmployeeByName",
        query = "SELECT e FROM Employee e WHERE e.name = :name"
        ),
        @NamedQuery(
        name = "findAllEmployees",
        query = "SELECT e FROM Employee e"
        )
    })
# 15. What is @Query? In which Interface we write the sql or JPQL?
    The @Query annotation is part of the Spring Data JPA framework and it is used to define custom queryies diredtly in a Spring Data repository interface. It allows
    developers to write SQL, JPQL, or native queries to retrieve data from a database
# 16. What is HQL and Criteria Queries?
    HQL is a powerful query language provided by Hibernate that is similar to SQL but operates on Hibernate-managed entities. 
    String hql = "FROM Employee WHERE department = :department";
    Query query = session.createQuery(hql);
    query.setParameter("department", "IT");
    List<Employee> employees = query.list();
    Criteria Queries
    Criteria Queries in Hibernate are API-based queries where criteria objects are used to build queries dynamically.
    CriteriaBuilder builder = session.getCriteriaBuilder();
    CriteriaQuery<Employee> criteriaQuery = builder.createQuery(Employee.class);
    Root<Employee> root = criteriaQuery.from(Employee.class);
    
    criteriaQuery.select(root)
    .where(builder.equal(root.get("department"), "IT"));
    
    List<Employee> employees = session.createQuery(criteriaQuery).getResultList();

# 17. What is EnityManager?
    The primary purpose of EntityManager is to manage the lifecycle of entities in a JPA-based application.
    It serves as the main interface for interacting with the underlying database through JPA.
    
# 18. What is SessionFactory and Session?
    SessionFactory and Session are core components in Hibernate.
    The SessionFactory is a heavyweight object responsible for creating and managing Session instances in Hibernate.
    Session is used for interacting with the database, performing CRUD operations, and managing the persistence context within a unit of work.
# 19. What is Transaction? how to manage your transaction?
    A transaction is a set of one or more operations that are executed as a single unit of work. if one step fails, the whole transaction fail
    ransactions ensure data integrity, consistency, and isolation.
# 20. What is hibernate Caching? No. 1 / 2
    Hibernate cacing is a mechanism employed by the Hibernate framework to store and manage frequently accessed data in memory,
    reducing the need to repreatedly query the database, avoding redundant database calls 
# 21. What is the difference between first-level cache and second-level cache?
    First Level Cache                                                                               Second Level Cache
    This is local to the Session object and cannot be shared between multiple sessions.             This cache is maintained at the SessionFactory level and shared among all sessions in Hibernate.
    This cache is enabled by default and but we can enable there is no way to disable it             This is disabled by default. it through configuration.
    The first level cache is available only until the session is open, once the session is closed, the first level cache is destroyed.     The second-level cache is available through the application’s life cycle, it is only destroyed and recreated when an application is restarted.      
# 22. How do you understand @Transactional? (https://github.com/TAIsRich/tutorial-transaction)
    using @Transactional, the developer delegates the management of transactions to the underlying framework (e.g., Spring).
    The framework ensures that transactions are handled correctly, providing a consistent and reliable mechanism for database operations. 
     If an exception occurs, the framework takes care of rolling back the transaction, preventing partial updates and maintaining data integrity.
    not for distributed transaction