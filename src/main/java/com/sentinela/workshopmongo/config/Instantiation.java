package com.sentinela.workshopmongo.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.sentinela.workshopmongo.domain.Post;
import com.sentinela.workshopmongo.domain.User;
import com.sentinela.workshopmongo.dto.AuthorDTO;
import com.sentinela.workshopmongo.repositories.PostRepository;
import com.sentinela.workshopmongo.repositories.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner {
	
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PostRepository postRepository;

	@Override
	public void run(String... args) throws Exception {
		
		userRepository.deleteAll();
		postRepository.deleteAll();
		
		User parker = new User(null, "Peter Parker", "parker@gmail.com");
		User rogers = new User(null, "Steve Rogers", "rogers@gmail.com");
		User stark = new User(null, "Antony Stark", "stark@gmail.com");
		
		userRepository.saveAll(Arrays.asList(parker, rogers, stark));
		
		Post p1 = new Post(null, new AuthorDTO(parker), sdf.parse("21/03/2022"), "Let's go trip", "I'm going to Washington. bye!");
		Post p2 = new Post(null, new AuthorDTO(parker), sdf.parse("23/03/2022"), "Good morning", "I woke up happy today!");

		postRepository.saveAll(Arrays.asList(p1, p2));
		
	}

}
