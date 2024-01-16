package com.chuwa.springcassandra;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;
import java.util.HashSet;
import java.util.UUID;

@SpringBootApplication
public class SpringCassandraApplication {

	private final static Logger log = LoggerFactory.getLogger(SpringCassandraApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(SpringCassandraApplication.class, args);
	}

	@Bean
	public CommandLineRunner clr(VetRepository vetRepository) {
		return args -> {
			vetRepository.deleteAll();
			Vet john = new Vet(UUID.randomUUID(), "John", "Doe", new HashSet<>(Arrays.asList("surgery")));
			Vet jane = new Vet(UUID.randomUUID(), "Jane", "Doe", new HashSet<>(Arrays.asList("radiology", "surgery")));

			Vet savedJohn = vetRepository.save(john);
			Vet savedJane = vetRepository.save(jane);

			vetRepository.findAll()
					.forEach(v -> log.info("Vet: {}", v.getFirstName()));
			vetRepository.findById(savedJohn.getId())
					.ifPresent(v -> log.info("Vet by id: {}", v.getFirstName()));
		};
	}

}
