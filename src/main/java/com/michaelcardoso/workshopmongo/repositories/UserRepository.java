package com.michaelcardoso.workshopmongo.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.michaelcardoso.workshopmongo.entities.User;


public interface UserRepository extends MongoRepository<User, String> {
	
}
