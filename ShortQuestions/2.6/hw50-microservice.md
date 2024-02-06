# 1
Done

# 2
- API Gateway Zull/Zull2/Spring Cloud Gateway
- Service Discovery Eureka
- Load Balancing Nginx, Ribbon
- Resilience Hystrix/Resilience4j
- Configuration Consul, Spring Cloud Config
- Communication Kafka

# 3
Resilience patterns in software design are strategies used to handle failures and ensure system availability, stability, and reliability, especially in distributed systems like microservices. These patterns help systems to cope with failures of services, networks, or hardware and to gracefully manage increased load.

Some of key resilience pattern include:
- Retry
- Timeout
- Circuit Breaker
- Bulkhead
- Fallback
- Rate Limiting
- Load Shedding

Circuit Breaker stops the application from performing an operation that is likely to fail. This pattern monitor for failures and if the failures reach a certain threshold, the circuit breaker trips and all further attemps to invoke the operation are automatically returned with an error response, without the underlying operation being executed.

States:
- Closed: The request from the application is routed to the operation. If the number of failures exceeds a predetermined threshold, the state changes to "Open".
- Open: The application's requests are not routed to the operation. After a specified timeout period, the circuit transitions to the "Half-Open" state.
- Half Open: A limited number of test requests are routed to the operation. If these requests are successful, the circuit returns to the "Closed" state; otherwise, it returns to "Open".

# 4
## Name three common tools mostly used for microservices.
Kafka, Eureka, Ribbon

## What do you mean by Cohesion and Coupling?
Cohesion means the level of interdependency between each component within a module. Coupling means the level of interdependency between modules. Typically, we want high cohesion and low coupling.

## Explain Idempotence and its usage.
Idempotence means repeating a task always results in the same outcome. Usage: When a server receives multiple same request, the request is only processed once. Example: bank transaction.

## Explain the term Eureka in Microservices.
Eureka is a service discovery application. It tracks all the services running on different ports and IP addresses and their health status, and provides the information to the service consumers.


## What is the main role of docker in microservices?
Docker generally provides a container environment, in which any application can be hosted. Docker, in essence, allows you to containerize your microservices and manage these microservices more easily.

# 5
Load balancing ensures that no single service instance is overwhelmed, improving the responsiveness and availability of applications. There are three types of load balancing. Client-side load balancing, where the client choose  to which server to sent request. Software load balancer in services, where the software in services decide the routing of request. And hardware load balancers, where it handles layer 4-7 requests. HLD is powerful yet expensive. There are three different types of load balancing. The first one is layer 4 load balancer, where it makes the routing decision at transport layer. The second one is layer 7 load balancer, where it makes the routing decision at application layer. The third one is global server load balancer, where it extends l4 and l7 load balancers and distributes large amount of data across servers at different geographically locations. There are several load balancing algorithms which includes but not limited to round robin, weighted round robing, least connection method, least response time method, and source IP hash.

# 6
Service Providers can register itself at Service Registry like Eureka. And Service Consumers can fetch the IP address and port of the service provider. Service providers send heartbeat periodically to the service registry to confirm it still functions well otherwise the service registry will delete the service provider from the registry.

# 7
Done
