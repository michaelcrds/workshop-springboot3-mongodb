package com.michaelcardoso.workshopmongo.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.michaelcardoso.workshopmongo.entities.Post;
import com.michaelcardoso.workshopmongo.entities.User;
import com.michaelcardoso.workshopmongo.repositories.PostRepository;
import com.michaelcardoso.workshopmongo.repositories.UserRepository;

@Configuration
public class TestConfig implements CommandLineRunner {

	@Autowired
	UserRepository userRepository;
	
	@Autowired
	PostRepository postRepository;
	
	@Override
	public void run(String... args) throws Exception {
		userRepository.deleteAll();
		
		User maria = new User(null, "Maria Brown", "maria@gmail.com");
		User alex = new User(null, "Alex Green", "alex@gmail.com");
		User bob = new User(null, "Bob Grey", "bob@gmail.com");
		
		Post p1 = new Post(null, Instant.now(), "Partiu viagem", "Vou viajar para São Paulo, beijos", maria);
		Post p2 = new Post(null, Instant.now(), "Bom dia", "Hoje o dia amanheceu lindo", maria);

		
		userRepository.saveAll(Arrays.asList(maria, alex, bob));
		postRepository.saveAll(Arrays.asList(p1, p2));
	}

}
