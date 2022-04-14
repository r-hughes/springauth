package com.exampleproject.springregister.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.exampleproject.springregister.model.User;

@Repository
public interface UserRepository extends MongoRepository<User, String> {

	@Query("{'email': ?0}")
	Optional<User> findByEmail(String email);
}
