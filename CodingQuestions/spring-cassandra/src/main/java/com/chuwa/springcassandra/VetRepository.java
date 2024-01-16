package com.chuwa.springcassandra;

import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface VetRepository extends CrudRepository<Vet, UUID> {
    Vet findByFirstName(String username);
}
