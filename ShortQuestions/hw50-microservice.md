1. list all of the new annotations you learned to your annotations.md

2. Document the microservice architeture and components/tools/dependencies

   - DNS: Route53 / 

   - API Gateway: Spring Cloud Gateway
   - LoadBalancer: Elastic Load Balancer / Spring Cloud LoadBalancer / Ribbon
   - Service Discovery / Service Registry: Eureka / Spring Cloud Consul
   - Circuit Breaker：Hystrix / Spring Cloud Circuit Breaker
     - **Spring Cloud integrates Hystrix** to provide a convenient way to implement circuit breakers in Spring-based applications. The integration includes annotations like `@HystrixCommand` to mark methods that should be wrapped with circuit breaker logic.
   - Config Server
   - Kafka
   - Docker

3. What are Resilience patterns? What is circuit breaker?

   - Resilience patterns refer to various design principles and techniques used in software engineering to enhance the reliability, fault tolerance, and stability of distributed systems.
   - The circuit breaker pattern is borrowed from electrical engineering. In software design, it's a mechanism used to detect and handle failures or faults in distributed systems, particularly in communication between different components or services.

4. how to do load balance in microservice? Write a long Summary by yourself.
   a. https://www.geeksforgeeks.org/load-balancer-system-design-interview-question/
    b. https://www.fullstack.cafe/blog/load-balancing-interview-questions

   - A load balancer acts as a central point of entry for incoming requests and distributes them across multiple instances of microservices based on a chosen algorithm, such as round-robin, least connections, or weighted load balancing. Load balancers can be implemented as software (e.g., NGINX, HAProxy) or provided as a service by cloud providers.

5. How to do service discovery?

    - service discovery is a critical component of microservices architecture, enabling dynamic and resilient communication between services in a distributed environment. By leveraging service registries, discovery clients, health checks, and dynamic updates, organizations can build scalable and reliable microservices-based applications.

6. What are the major components of Kafka?

    - **Producer**
    - **Consumer**
    - **Broker**
    - **Topic**
    - **Partition**
    - **Replication**
    - **Consumer Group**
    - **ZooKeeper**

7. What do you mean by a Partition in Kafka?

    - Partitions are the basic unit of parallelism in Kafka. Each topic is divided into partitions, and each partition can be hosted on a different broker. This allows Kafka to scale horizontally across multiple servers.

8. What do you mean by zookeeper in Kafka and what are its uses?

    -  Although not technically a part of Kafka, ZooKeeper is often used for managing and coordinating Kafka brokers and maintaining metadata such as topic configurations, broker information, and partition leadership. However, recent versions of Kafka have been moving away from ZooKeeper dependency.

9. Can we use Kafka without Zookeeper?

    - Yes

10. Explain the concept of Leader and Follower in Kafka.

    - Having a Leader and Follower architecture allows Kafka to achieve fault tolerance and high availability. If the Leader fails, one of the Followers can quickly take over as the new Leader, minimizing downtime and ensuring continuous operation of the Kafka cluster. Additionally, by replicating data across multiple brokers, Kafka can handle hardware failures and ensure data durability.

11. Why is Topic Replication important in Kafka? What do you mean by ISR in Kafka?

     - topic replication in Kafka provides resilience against failures, ensures high availability and durability of data, facilitates load distribution, and leverages the concept of In-Sync Replicas to maintain data consistency and integrity within the cluster. It is a critical feature for building robust and reliable Kafka-based systems.

12. What do you understand about a consumer group in Kafka?

     - consumer groups play a critical role in enabling efficient and scalable message consumption in Kafka, making it well-suited for building real-time data processing pipelines and event-driven architectures.

13. How do you start a Kafka server?

     ```java
     bin/kafka-server-start.sh config/server.properties
     ```

     

14. Tell me about some of the real-world usages of Apache Kafka.

     - **Microservices Architecture**: Kafka facilitates communication and data exchange between microservices in distributed systems, enabling decoupled and scalable architectures. Real-world use cases include:
       - Event-driven Microservices: Kafka serves as a message broker for inter-service communication, allowing microservices to publish and subscribe to events for data synchronization, orchestration, and workflow management.
       - Choreography-based Integration: Kafka enables choreography-style communication patterns, where microservices interact with each other through events and asynchronous messaging, avoiding the need for centralized orchestration.
       - Scalable Data Processing: Kafka Streams and Kafka Connect are used to build scalable stream processing pipelines and data integration workflows that operate on real-time data streams.

15. Describe partitioning key in Kafka.

     -  partitioning keys are a fundamental concept in Kafka's distributed architecture, enabling efficient message routing, load balancing, and parallel processing of data streams. Choosing an appropriate partitioning key strategy is essential for optimizing the performance, scalability, and reliability of Kafka applications.

16. What is the purpose of partitions in Kafka?

     - partitions are a fundamental building block of Kafka's distributed architecture, providing parallelism, scalability, fault tolerance, and efficient data management capabilities. They allow Kafka to handle large-scale data processing and streaming workloads while ensuring reliability and high availability.

17. Differentiate between Rabbitmq and Kafka.

     - RabbitMQ and Kafka are both powerful messaging systems with distinct architectures and use cases. RabbitMQ is suitable for traditional messaging scenarios and queuing-based workflows, while Kafka excels in handling real-time data streams, event-driven architectures, and stream processing applications. The choice between RabbitMQ and Kafka depends on factors such as the nature of the data, the required messaging semantics, scalability requirements, and the overall architecture of the system.

18. What are the guarantees that Kafka provides?

     - **Persistence**: Kafka ensures messages are stored safely on disk, so they're not lost even if a server fails.
     - **Replication**: Kafka copies data across multiple servers to prevent data loss and ensure availability.
     - **Ordering**: Messages within a Kafka topic are kept in order, but this doesn't apply across different topics.
     - **At-least-once Delivery**: Kafka ensures that messages will be delivered to consumers at least once, even if there are network issues.
     - **Scalability and Performance**: Kafka can handle huge amounts of data and still perform well, making it great for big projects.

19. What do you mean by an unbalanced cluster in Kafka? How can you balance it?

     - By actively managing and monitoring your Kafka cluster, you can ensure that partitions are evenly distributed across brokers, leading to better resource utilization, improved fault tolerance, and smoother operation of your Kafka-based applications.

     

20. What is offset?

