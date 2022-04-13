package com.exampleproject.springregister.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.exampleproject.springregister.model.User;

public interface UserRepository extends MongoRepository<User, String> {

	@Query("{'email': ?0}")
	Optional<User> findByEmail(String email);
}
