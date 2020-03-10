package com.k0ft3.atman.repository;

import com.k0ft3.atman.model.User;

import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * UserRepository
 */
public interface UserRepository extends MongoRepository<User, String> {

}