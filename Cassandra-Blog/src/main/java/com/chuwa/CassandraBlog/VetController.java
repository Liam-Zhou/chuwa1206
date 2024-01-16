package com.chuwa.CassandraBlog;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.HashSet;
import java.util.UUID;

@RestController
@RequestMapping("/cas")
public class VetController {
    @Autowired
    private static VetRepository vetRepository;
    @PostMapping
    public void post() {
        vetRepository.deleteAll();

        Vet john = new Vet(UUID.randomUUID(), "John", "Doe", new HashSet<>(Arrays.asList("surgery")));
        Vet jane = new Vet(UUID.randomUUID(), "Jane", "Doe", new HashSet<>(Arrays.asList("radiology, surgery")));

        Vet savedJohn = vetRepository.save(john);
        Vet savedJane = vetRepository.save(jane);

        vetRepository.findAll()
                .forEach(v -> System.out.println("Vet: {}" + v.getFirstName()));

        vetRepository.findById(savedJohn.getId())
                .ifPresent(v -> System.out.println("Vet by id: {}" + v.getFirstName()));
    }
}
