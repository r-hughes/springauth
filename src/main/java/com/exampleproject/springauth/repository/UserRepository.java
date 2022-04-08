package com.exampleproject.springauth.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.exampleproject.springauth.model.User;

public interface UserRepository extends MongoRepository<User, String> {

	@Query("{'email': ?0}")
	Optional<User> findByEmail(String email);
}
