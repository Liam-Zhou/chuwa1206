# HW9

## What is JPA? and what is Hibernate?

JPA is Java persistence API for accessing, managing, and persisting data between Java objects (entities) and a **relational database**.

Hibernate is the most widely used implementation of the JPA specification. It is a Java-based ORM framework that simplifies database interactions in Java applications.



## What is Hiraki? what is the benefits of connection pool?

HikariPool maintains a pool of database connections. These connections are created when the pool is initially set up and are managed throughout the application's lifecycle.

Creating an deleting connection is very resource-consuming. Using a pool can reuse such resource, thus improve performance.



## What is the @OneToMany, @ManyToOne, @ManyToMany? write some examples

@ManyToOne

Many current entity can be associated with one instance of the annotated entiry. e.g. In entity Book, 

``` java
@ManyToOne 
@JoinColumn(name = "authorId")
private Author author;
```



## What is the cascade = CascadeType.ALL, orphanRemoval = true? and what are the other CascadeType and their features? In which situation we choose
which one?
1. `CascadeType.ALL`: This cascade type specifies that all operations (including persist, merge, remove, refresh, and detach) should be cascaded from the parent entity to the related entity. It means that if you perform any of these operations on the parent entity, the same operation will be applied to the related entity.
2. `orphanRemoval = true`: When `orphanRemoval` is set to true, it indicates that if an entity is removed from the collection of related entities on the parent side, it should also be automatically removed from the database. In other words, if an entity becomes an orphan (i.e., it is no longer associated with the parent), it will be deleted from the database.

Other type include persist, merge, remove, refresh and detach.



## What is the fetch = FetchType.LAZY, fetch = FetchType.EAGER? what is the difference? In which situation you choose which one?

They define the style how to load the related data of an entity. lazy means it will not be loaded until explictly acess that field. Eager means that related field is retrieved as soon as entity is quereid. 

Lazy: large amount of related data. can improve database performance

Eager: when related data is frequently required. 



## What is the rule of JPA naming convention? Shall we implement the method by ourselves? Could you list some examples?

entity class name "Post"  ->  table name "post", or defined by @Table(name = ...)

field name "postCreateTime" -> column name "post_create_time" or defined by @Column(name = ...)

JPA assume your entity contains getter and setter like getVar()



Define repository method:

```
findBy`, `findBy...And...`, `findBy...Or...`, `findBy...Not...
And, Or, Not, Is, Equals, GreaterThan, LessThan, Between, Like, OrderBy, IsNull, In, IgnoreCase ...
```

Define by @Query

``` java
@Query("SELECT p FROM Product p WHERE p.available = true")
List<Product> findAvailableProducts();
```



## JDBCTemplate

Hanyun_Zhao/redboook_02_01_jdbcTemplate



## Query and NamedQuery

Hanyun_Zhao/redbook_02_JPQL



## What is JPQL

Java Persistence Query Language. It is a platform-independent, object-oriented query language. It operates on entity objects rather than database tables.



## What is @NamedQuery and @NamedQueries?

@NamedQuery is defined in Entity and managed by EntityManager. It use JPQL to sepcify the query instruction. The function should be called by entityManager together with Entity name as parameter.



## What is @Query? In which Interface we write the sql or JPQL?

@Query is defined in repository layer, and can customize query. The format can be either SQL or JPQL. The function should be called by e.g. myRepository.getMySth(). 



## What is HQL and Criteria Queries?

They are two different ways to query data when working with Hibernate.

HQL queries are written using entity class names and their properties, making them object-oriented.

``` java
Query query = session.createQuery("select m.name from DeptEmployee m where m.id = 1");
List employees = query.list();
```

Criteria Queries Instead of writing query strings, you create query criteria by chaining methods that represent various query components (e.g., conditions, joins, projections).

``` java
CriteriaBuilder builder = session.getCriteriaBuilder();
CriteriaQuery<Product> criteria = builder.createQuery(Product.class);
Root<Product> root = criteria.from(Product.class);

criteria.select(root)
        .where(
            builder.equal(root.get("category"), category),
            builder.greaterThan(root.get("price"), minPrice)
        );

List<Product> products = session.createQuery(criteria).getResultList();
```



## What is EnityManager?

it manage entity objects and performing database operations in Java applications that work with relational databases. EntityManager is a component of JPA

- Entity lifecycle management
- transcation management
- query execution
- relationship management(@Onetoone)
- Caching



## Session and Session Factory

They are responsible for managing the lifecycle of persistent objects (entities) and performing database operations in Hibernate-based applications. Session is a component of Hibernate.



`SessionFactory` is a factory class that is responsible for creating and managing `Session` instances in Hibernate. 

A `Session` represents a single unit of work or transaction in Hibernate. It provides a runtime environment for executing database operations, managing the persistence of entities, and tracking changes.



## What is Transaction? how to manage your transaction?

Transaction represents a unit of work. If one step fails, the whole transaction fails. manage by session. roll back in catch block, close session in finally block.



## What is hibernate Caching? What is the difference between first-level cache and second-level cache?

Hibernate caching is a mechanism to improve the performance and efficiency of database operations in Java applications. It involves the temporary storage of frequently accessed data in memory to reduce the need for repeated database queries. 

Each session maintains its own first-level cache.

The session factory maintains the second level cache which is shared by all session.





## 22. How do you understand @Transactional?

@Transactional is an brief usage of transaction which save you from session operation and exception handling.
