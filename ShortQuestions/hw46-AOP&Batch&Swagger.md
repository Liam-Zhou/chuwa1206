# 3. What is the Aspect Oriented Programming?

AOP is a programming paradigm that separates cross-cutting concerns (like logging, security, etc.) from core business logic. Imagine weaving advice into your code without modifying it!

# 4. What are the advantages and disadvantages of Spring AOP?

Pros:

Modular code: Improved code reusability and maintainability.
Centralized concerns: Manage cross-cutting concerns in specific aspects.
Non-invasive: No need to modify existing code; advice is woven in dynamically.

Cons:

Increased complexity: Debugging and understanding code flow can be trickier.
Performance overhead: Weaving aspects adds another layer, potentially impacting performance.

# 5. What is Aspect in Spring AOP?

An aspect encapsulates a cross-cutting concern like logging or security. It contains advice (what to do) and pointcuts (where to do it). Think of it as a modular unit for handling specific concerns.

# 6. What is Pointcut in Spring AOP?

A pointcut defines where your advice should be applied. It's like a selector, specifying which methods, classes, or exceptions the aspect should "intercept." Pointcuts use AspectJ expressions for precise targeting.

# 7. What is the Join point in Spring AOP?

A join point is any point in program execution where your advice can be applied, like method execution, exception handling, etc. Think of them as potential interception points within your code.

# 8. What does it mean by Advice and its types in Spring AOP?

Advice is the code that gets executed at a join point. Spring AOP supports various advice types:

Before advice: Runs before the method execution.
After returning advice: Runs after the method successfully returns.
After throwing advice: Runs after the method throws an exception.
Around advice: Wraps the entire method execution and can control it entirely.

# 9. When to use Spring Batch?

Processing large volumes of data (e.g., reading files, transforming records, writing to databases).
Batch jobs with complex processing steps and dependencies.
Automating repetitive data processing tasks.

# 10. How Spring Batch works?

Defining jobs with steps (individual processing tasks).
Configuring readers, processors, and writers for each step.
Executing steps sequentially or in parallel, depending on job flow.
Monitoring and managing job execution with Spring Batch infrastructure.

# 11. How can we schedule a Spring Batch Job?

TaskScheduler: Schedule jobs with Java's TaskScheduler API.
Cron scheduler: Use Cron expressions to define specific dates and times.
JobLauncher: Manually trigger job execution via code or UI.

# 12. What is the cron expression?

A special syntax (e.g., 0 0/15 _ 1/5 _ ?) to define schedules based on minutes, hours, days, months, and weekdays.

# 13. What is the spring task?

Spring Task simplifies asynchronous task execution within your application.

# 14. When to use Spring task?

Running tasks in the background without blocking the main thread.
Parallelizing processing to improve performance.
Scheduling tasks for future execution.

# 15. What is Filter and any filter example?

A filter intercepts and potentially modifies a request or response based on predefined criteria. An example could be a security filter that checks user authorization before processing a request.

# 16. What is the Interceptor? What we can do with the interceptor?

An interceptor intercepts method calls or invocations to perform actions before, after, or around the actual method execution. It can be used for logging, auditing, authorization, error handling, etc.

# 17. In Interceptor, What is preHandle? What is postHandle?

Prehandle: Invoked before the actual method execution, allowing for modification of arguments or even preventing execution.

PostHandle: Invoked after the method execution, allowing for processing the return value or handling exceptions.

# 18. What is Swagger?

An open-source framework for generating API documentation from your code. It creates interactive APIs, simplifies API testing, and improves developer experience.
