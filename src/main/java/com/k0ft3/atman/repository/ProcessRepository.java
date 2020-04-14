package com.k0ft3.atman.repository;

import com.k0ft3.atman.model.Process;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProcessRepository extends MongoRepository<Process, String> {

}