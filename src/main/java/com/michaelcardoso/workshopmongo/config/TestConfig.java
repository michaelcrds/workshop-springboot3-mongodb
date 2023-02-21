package com.michaelcardoso.workshopmongo.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.michaelcardoso.workshopmongo.dto.AuthorDTO;
import com.michaelcardoso.workshopmongo.dto.CommentDTO;
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
		postRepository.deleteAll();
		
		User maria = new User(null, "Maria Brown", "maria@gmail.com");
		User alex = new User(null, "Alex Green", "alex@gmail.com");
		User bob = new User(null, "Bob Grey", "bob@gmail.com");
		
		userRepository.saveAll(Arrays.asList(maria, alex, bob));

		Post p1 = new Post(null, Instant.now(), "Partiu viagem", "Vou viajar para São Paulo, beijos", new AuthorDTO(maria));
		Post p2 = new Post(null, Instant.now(), "Bom dia", "Hoje o dia amanheceu lindo", new AuthorDTO(maria));
		
		CommentDTO c1 = new CommentDTO(null, Instant.now(), "Boa viagem", new AuthorDTO(alex));
		CommentDTO c2 = new CommentDTO(null, Instant.now(), "Aproveite", new AuthorDTO(bob));
		CommentDTO c3 = new CommentDTO(null, Instant.now(), "Tenha um ótimo dia", new AuthorDTO(alex));

		p1.getComments().addAll(Arrays.asList(c1, c2));
		p2.getComments().addAll(Arrays.asList(c3));

		postRepository.saveAll(Arrays.asList(p1, p2));
		
		maria.getPosts().addAll(Arrays.asList(p1, p2));
		
		userRepository.save(maria);
	}

}
