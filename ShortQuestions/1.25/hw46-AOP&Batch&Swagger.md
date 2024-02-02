# 1
Done

# 2
Done

# 3
AOP is a programming paradigm that provides a way to modularize cross-cutting concerns away from the business logic of your application. Cross-cutting concerns are aspects of a program that affect multiple components, such as logging, transaction management, or security.

# 4
Advantage:
- Improved Modularity
- Reusability
- Easier Maintainability
- Declarative Approach
- Reduced Boilerplate code
- Integration with Spring Framework

Disadvantage:
- Runtime weaving only
- Limited to Method Execution Join Points
- Proxy-Based Approach: Since Spring AOP uses proxies for aspects, it can't advise objects that are not created by the Spring container. Also, it requires that the advised methods must be declared in an interface.

# 5
An aspect is a module that encapsulates a concern that cuts across multiple classes (cross-cutting concern).

# 6
Define expression to find all main application methods to insert advice.

# 7
A point in the execution of the program, such as the execution of a method or the handling of an exception.

# 8
Action taken by an aspect at a particular join point. Different types of advice include `Before`, `After`, `AfterReturning`, `AfterThrowing`, `Around`.

# 9
Done

# 10
Spring batch is particularly well-suited for scenarios that involve processing large volumes of data, require repeatable results, and can be run in an offline mode. There are several situations that is suitable for Spring Batch:
- Data processing and transformation
- Batch jobs with complex business rules
- High-Performance Requirements
- Scalability Needs
- Scheduled Operations
- Stateful Jobs

# 11
Core Concepts of Spring Batch:
- Job: The entity that encapsulates an entire batch process. A job constitutes the entire batch process from start to finish.
- Step: A domain within a job that represents an independent phase of a batch job (e.g., read, process, write). A job consists of one or more steps.
- ItemReader: The component that is responsible for reading input data from a variety of data sources (file, database, message queue, etc.).
- ItemProcessor (optional): The component where the input can be transformed before writing. It's optional because not all batch jobs require input transformation.
- ItemWriter: The component that is responsible for writing the output to a destination (file, database, message queue, etc.).

Operational Flow:
- Job Launch: The starting point of a batch job. Jobs are typically started using the JobLauncher, which can be triggered manually or by a scheduler.
- Job Instance: When a job is launched, a JobInstance is created. It's a logical run of a job, associated with a specific set of job parameters.
- Job Execution: Each job instance can have one or more JobExecutions, which are individual attempts to run a JobInstance.
- Step Execution: Inside a job, steps are executed in sequence or conditionally based on the job configuration. Each step has its own StepExecution, which holds details about the runtime of the step, like status and statistics.
- Reading, Processing, Writing: Within a step, the typical sequence involves reading data one at a time using ItemReader, optionally processing it using ItemProcessor, and writing it using ItemWriter. This cycle continues until there's no more data to read.
- Chunk Processing: Spring Batch processes data in chunks. A chunk is a set of items that are processed as a batch. After reading and processing each chunk, the transaction is committed.
- Job Completion: Once all the steps are completed, the job is marked as completed. Job execution details are stored, which can be useful for job restartability and tracking.

# 12
We can use @Schedule annotation. First, we can add @EnableScheduling annotation to configuration class to enable Spring's scheduling capabilities. Then we can use the @Scheduled annotation on a method to trigger it at specified times.

```
@EnableScheduling
@Configuration
public class SchedulerConfig {
    
    @Autowired
    private JobLauncher jobLauncher;
    
    @Autowired
    private Job job;
    
    @Scheduled(cron = "0 0 * * * ?") // runs every hour
    public void perform() throws Exception {
        Map<String, JobParameter> params = new HashMap<>();
        params.put("currentTime", new JobParameter(System.currentTimeMillis()));
        JobParameters jobParameters = new JobParameters(params);
        
        jobLauncher.run(job, jobParameters);
    }
}
```

# 13
A cron expression is a string representing a schedule in a time-based job scheduling format. A cron expression typically consists of five or six fields, separated by white space, representing a time pattern. The first field stands for seconds, second field stands for minute, third one stands for hour, then day of the month, month, and day of the week.

```
* * * * * *
| | | | | |
| | | | | +-- Day of the week (optional in some systems)
| | | | +---- Month (0 - 7) (Sunday=0 or 7)
| | | +------ Date (1 - 12)
| | +-------- Hour (1 - 31)
| +---------- Minute (0 - 23)
+------------ Second (0 - 59)
```

Each field can have a specific value or a special character.
- `*` (asterisk): Represents all possible values for that field, meaning it's not a constraint (e.g., every minute, every hour, etc.).
- `-` (hyphen): Defines a range of values (e.g., 10-12 in the hour field means 10, 11, and 12).
- `,` (comma): Specifies additional values (e.g., MON,WED,FRI in the day-of-week field means Mondays, Wednesdays, and Fridays).
- `/` (slash): Specifies increments. For example, 0/15 in the minutes field means every 15 minutes starting from minute 0 (0, 15, 30, and 45).
- `?` (question mark): Used in the day-of-month and day-of-week fields to specify 'no specific value' (useful when you need to specify something in one of these fields but not the other).

# 14
Spring Task refers to the functionality within the Spring Framework that allows for the execution of tasks or methods at specific intervals or times, essentially providing support for scheduling tasks.

# 15
Spring Task is particularly beneficial when you want to leverage the Spring Framework's capabilities for managing task execution and scheduling, ensuring that these tasks are integrated smoothly into the lifecycle of your application. Here are some choices:
- Periodic Tasks
- Asynchronous Execution
- Background Jobs
- Scheduled Data Processing
- Resource Management
- Notification Systems

# 16
A filter is a component that allows you to process and modify request and response objects before and after a request is processed by a servlet. Filters are used for a variety of tasks, such as logging, security (authentication and authorization), modifying request/response headers, data compression, and more.

```
import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class LoggingFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) {
        // Initialization logic, executed once when the web application starts.
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        
        // Cast the request to HttpServletRequest
        HttpServletRequest req = (HttpServletRequest) request;

        // Log the incoming request
        long startTime = System.currentTimeMillis();
        System.out.println("Logging Filter: " + req.getMethod() + " " + req.getRequestURI());

        // Proceed with the rest of the filter chain (including resource execution)
        chain.doFilter(request, response);

        // Log the time taken to execute the request
        long endTime = System.currentTimeMillis();
        System.out.println("Logging Filter: " + req.getMethod() + " " + req.getRequestURI() + " completed in " + (endTime - startTime) + " ms");
    }

    @Override
    public void destroy() {
        // Cleanup logic, executed once when the web application shuts down.
    }
}
```

# 17
An interceptor is a type of component that allows you to intercept and process requests and responses before and after a request is handled by a controller.

We can use interceptors in authentication and authorization, logging and auditing, validation, transformation, performance monitoring, exception handling, locale and theme resolution

# 18
- The preHandle method is called before the actual handler (controller method) is executed.

- The postHandle method is called after the handler (controller method) is executed but before the view is rendered.

# 19
Swagger, now officially known as OpenAPI Specification, is a framework for describing your API using a common language that everyone can understand. Think of it as a blueprint or contract for your API that details how the API behaves and what it can do, including the paths (endpoints), methods (GET, POST, etc.), possible request and response types, authentication methods, and other metadata.