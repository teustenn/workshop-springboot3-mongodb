package com.sentinela.workshopmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sentinela.workshopmongo.domain.Post;
import com.sentinela.workshopmongo.repositories.PostRepository;
import com.sentinela.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class PostService {
	
	@Autowired
	private PostRepository repository;
	
	public Post findById(String id) {
		Optional<Post> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Object NOT FOUND."));
	}
	
	public List<Post> findByTitle(String text) {
		return repository.findByTitleContainingIgnoreCase(text);
	}
	
}
