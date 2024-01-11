package com.chuwa.CassandraBlog;

import java.util.UUID;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.repository.CrudRepository;

public interface VetRepository extends CassandraRepository<Vet, UUID> {
    Vet findByFirstName(String username);
}