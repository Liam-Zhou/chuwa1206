### Question 3:
AOP complements Object-Oriented Programming (OOP) by allowing the separation of cross-cutting concerns, making them independent from the main business logic of the program. AOP improves modularity, making code easier to maintain and scale.

### Question 4:
Advantages: Increases modularity by separating cross-cutting concerns, reduces code duplication, and improves maintainability. It also allows for declarative programming through annotations.
Disadvantages: Can introduce complexity, may affect application performance due to runtime weaving, and requires understanding of AOP concepts which could have a learning curve.

### Question 5:
An aspect is a modularization of a concern that cuts across multiple classes. It is the unit of modularity in AOP, comprising advice and pointcuts.

### Question 6:
A pointcut is an expression that selects one or more join points. Pointcuts determine where advice should be applied within your application.

### Question 7:
A join point represents a point in the execution of the program, such as method execution, exception handling, or field access. In Spring AOP, a join point always represents a method execution.

### Question 8:
Before: Run before the join point method execution.
After returning: Run after the join point method returns normally.
After throwing: Run if the method exits by throwing an exception.
After (finally): Run after the join point method execution (regardless of its exit).
Around: Run around the join point method execution, providing the opportunity to perform actions both before and after the method execution.

### Question 10:
Use Spring Batch for processing large volumes of data, batch processing, complex processing that requires transactions, retries, skip logic, and more, especially when dealing with resources like databases, files, and queues.

### Question 11:
Spring Batch follows a chunk-oriented processing model where data is read in chunks, processed, and then written out. It is structured around Job, Step, Reader, Processor, and Writer components to manage and execute batch processing tasks.

### Question 12:
Spring Batch jobs can be scheduled using task scheduling in Spring with @Scheduled annotation or by integrating with scheduling frameworks like Quartz.

### Question 13:
A cron expression is a string of fields separated by spaces that represents a schedule. It is used to specify timings for recurring tasks in Unix-based systems and is commonly used in scheduling frameworks like Quartz and Spring.

### Question 14:
Spring Task provides ways to programmatically execute logic asynchronously using simple annotations, facilitating task execution and scheduling without needing an external scheduling system.

### Question 15:
Use Spring Task for executing asynchronous tasks and for simple scheduling of tasks without the complexity of a full-fledged scheduling system like Quartz.

### Question 16:
In web applications, a filter is used to intercept and process requests before they reach a servlet, or to modify responses leaving a servlet. An example is a logging filter that logs requests/responses.

### Question 17:
Interceptors provide a way to intercept and manipulate requests and responses in an application, often used in frameworks like Spring MVC. They can be used for logging, security, and transaction management.

### Question 18:
preHandle: Called before the actual handler is executed; can be used to perform operations before sending the request to the controller.
postHandle: Called after the handler method is executed; can be used to perform operations before sending the response to the client.

### Question 19:
Swagger is a set of tools for designing, building, documenting, and consuming RESTful web services. It includes specifications for documenting API endpoints, their expected inputs, outputs, and the Swagger UI for visualizing and interacting with APIs.