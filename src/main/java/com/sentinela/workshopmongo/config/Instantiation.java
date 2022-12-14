package com.sentinela.workshopmongo.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.sentinela.workshopmongo.domain.Post;
import com.sentinela.workshopmongo.domain.User;
import com.sentinela.workshopmongo.dto.AuthorDTO;
import com.sentinela.workshopmongo.dto.CommentDTO;
import com.sentinela.workshopmongo.repositories.PostRepository;
import com.sentinela.workshopmongo.repositories.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PostRepository postRepository;

	@Override
	public void run(String... args) throws Exception {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		
		userRepository.deleteAll();
		postRepository.deleteAll();
		
		User parker = new User(null, "Peter Parker", "parker@gmail.com");
		User rogers = new User(null, "Steve Rogers", "rogers@gmail.com");
		User stark = new User(null, "Antony Stark", "stark@gmail.com");
		
		userRepository.saveAll(Arrays.asList(parker, rogers, stark));
		
		Post p1 = new Post(null, new AuthorDTO(parker), sdf.parse("21/03/2022"), "Let's go trip", "I'm going to Washington. bye!");
		Post p2 = new Post(null, new AuthorDTO(parker), sdf.parse("23/03/2022"), "Good morning", "I woke up happy today!");
		
		CommentDTO com1 = new CommentDTO("Nice trip bro!", sdf.parse("21/03/2022"), new AuthorDTO(rogers));
		CommentDTO com2 = new CommentDTO("I told you not to leave new york!", sdf.parse("22/03/2022"), new AuthorDTO(stark));
		CommentDTO com3 = new CommentDTO("Stark is looking for you!", sdf.parse("23/03/2022"), new AuthorDTO(rogers));
		
		p1.getComments().addAll(Arrays.asList(com1, com2));
		p1.getComments().addAll(Arrays.asList(com3));

		postRepository.saveAll(Arrays.asList(p1, p2));
		
		parker.getPosts().addAll(Arrays.asList(p1, p2));
		
		userRepository.save(parker);
		
	}

}
