package com.michaelcardoso.workshopmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.michaelcardoso.workshopmongo.dto.UserDTO;
import com.michaelcardoso.workshopmongo.entities.User;
import com.michaelcardoso.workshopmongo.repositories.UserRepository;
import com.michaelcardoso.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repository;
	
	public List<User> findAll(){
		return repository.findAll();
	}
	
	public User findById(String id) {
		Optional<User> user = repository.findById(id);
		return user.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id(" + id + ")")); 
	}
	
	public User insert(User obj) {
		return repository.insert(obj);
	}
	
	public void deleteById(String id) {
		findById(id);
		repository.deleteById(id);
	}
	
	public User fromDTO(UserDTO objDto) {
		return new User(objDto.getId(),objDto.getName(),objDto.getEmail());
	}
}
