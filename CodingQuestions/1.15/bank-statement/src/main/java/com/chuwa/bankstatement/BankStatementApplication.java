package com.chuwa.bankstatement;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecutionException;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class BankStatementApplication implements CommandLineRunner {

	@Autowired
	private JobLauncher jobLauncher;

	@Autowired
	private Job myJob;

	public static void main(String[] args) {
		SpringApplication.run(BankStatementApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		try {
			jobLauncher.run(myJob, new JobParameters());
		} catch (JobExecutionException e) {
			// Log or rethrow the exception if desired
			e.printStackTrace();
		}
	}
}
