Example 1:

```
@Aspect
@Component
public class LoggingAspect {

    // Define pointcut expression to match any public method in any class in the "com.example" package
    @Before("execution(public * com.example..*.*(..))")
    public void logBeforeMethodExecution() {
        System.out.println("Before executing method...");
    }
}
```

`@Aspect` annotation in Spring AOP is used to define an aspect, which is a modularization of cross-cutting concerns.

Example 2:

```
    @Component
    public class JobScheduler {

        @Autowired
        private Job job; // Autowire the Spring Batch job

        @Autowired
        private JobLauncher jobLauncher; // Autowire the JobLauncher

        // Schedule the job to run every 5 minutes
        @Scheduled(fixedRate = 300000) // 300000 milliseconds = 5 minutes
        public void scheduleJob() throws Exception {
            JobExecution jobExecution = jobLauncher.run(job, new JobParameters());
            System.out.println("Job Execution Status: " + jobExecution.getStatus());
        }
    }
```

`@Scheduled` annotation to specify when you want to run the job. This annotation can be applied to a method that triggers the job execution.
