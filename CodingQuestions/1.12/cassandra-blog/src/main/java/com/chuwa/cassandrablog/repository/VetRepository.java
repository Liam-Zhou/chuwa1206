package com.chuwa.cassandrablog.repository;

import com.chuwa.cassandrablog.entity.Vet;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface VetRepository extends CrudRepository<Vet, UUID> {
    Vet findByFirstName(String username);
}
