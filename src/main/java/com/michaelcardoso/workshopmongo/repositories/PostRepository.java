package com.michaelcardoso.workshopmongo.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.michaelcardoso.workshopmongo.entities.Post;


public interface PostRepository extends MongoRepository<Post, String> {
	
}
