* annotations you learned from class 
- @Aspect @PointCut @After @AfterReturning @Around @AfterThrowing 

* What is the Aspect Oriented Programming?
- Aspect-Oriented Programming (AOP) is a programming paradigm that provides a way to modularize cross-cutting concerns, which are aspects of a program that affect multiple modules or components.

* What is Aspect in Spring AOP?
- Aspect: An aspect is a class that implements enterprise application concerns that cut across multiple classes, such as transaction management. Aspects can be a normal class configured through Spring XML configuration or we can use Spring AspectJ integration to define a class as Aspect using @Aspect annotation.

* What is Pointcut in Spring AOP?
- Pointcut is a set of one or more JoinPoint where an advice should be executed. You can specify Pointcuts using expressions or patterns as we will see in our AOP examples.

* What is JointPoint in Spring AOP?
- A Joinpoint is a point in Spring AOP during the execution of a program, such as the execution of a method or the handling of an exception, etc.

* What does it mean by Advice and its types in Spring AOP?
- Advice: action taken by an aspect at a particular join point. Different types of advice include "around," "before" and "after" advice. (Advice types are discussed below.)

* When to use Spring Batch?
- Spring Batch provides reusable functions that are essential in processing large volumes of records, including logging/tracing, transaction management, job processing statistics, job restart, skip, and resource management.

* How Spring Batch works ? 
- Spring Batch follows the traditional batch architecture where a job repository does the work of scheduling and interacting with the job.

* How can we schedule a Spring Batch Job?
- Using the @EnableScheduling annotation.
- Creating a method annotated with @Scheduled and providing recurrence details with the job. Then add the job execution logic inside this method.

* What is the cron expression?
- A cron expression is a string consisting of six or seven subexpressions (fields) that describe individual details of the schedule.

* What is the spring task?
  Spring Cloud Task allows a user to develop and run short lived microservices using Spring Cloud and run them locally, in the cloud, even on Spring Cloud Data Flow. 

* When to use Spring task?
- Spring provides a task scheduling framework that allows you to schedule tasks in your application. The Spring TaskScheduler and related interfaces provide a convenient way to execute tasks at fixed intervals

* What is Filter and any filter example?
- In the context of web development, a filter is a software component that performs filtering tasks on either the request to a resource, the response from a resource, or both. Filters are often used in Java web applications, such as those built with Servlet technology, to perform common tasks like logging, authentication, authorization, input validation, compression, and more.

*  What is the Interceptor? What we can do with interceptor?
- They can be used to perform various tasks related to HTTP requests and responses, such as adding headers, handling errors, modifying the request or response data, logging, authentication, etc.

* In Interceptor, What is preHandle? What is postHandle?
- prehandle() – called before the execution of the actual handler. postHandle() – called after the handler is executed. afterCompletion() – called after the complete request is finished and the view is generated.

* What is Swagger?
- Swagger is a set of open-source tools built around the OpenAPI Specification that can help you design, build, document and consume REST APIs.