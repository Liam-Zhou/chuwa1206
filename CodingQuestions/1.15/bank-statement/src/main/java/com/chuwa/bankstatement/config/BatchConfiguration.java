package com.chuwa.bankstatement.config;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.core.step.tasklet.TaskletStep;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
@EnableBatchProcessing
public class BatchConfiguration {

    private final JobRepository jobRepository;
    private final PlatformTransactionManager transactionManager;

    @Autowired
    public BatchConfiguration(JobRepository jobRepository, PlatformTransactionManager transactionManager) {
        this.jobRepository = jobRepository;
        this.transactionManager = transactionManager;
    }

    @Bean
    public Job myJob() {
        JobBuilder jobBuilder = new JobBuilder("myJob3", jobRepository);
        return jobBuilder.start(myStep()).build();
    }

    @Bean
    public Step myStep() {
        StepBuilder stepBuilder = new StepBuilder("myStep", jobRepository);
        TaskletStep step = stepBuilder
                .tasklet(myTasklet(), transactionManager)
                .build();
        return step;
    }

    public Tasklet myTasklet() {
        return (contribution, chunkContext) -> {
            System.out.println("Tasklet has been executed");
            return RepeatStatus.FINISHED;
        };
    }
}
