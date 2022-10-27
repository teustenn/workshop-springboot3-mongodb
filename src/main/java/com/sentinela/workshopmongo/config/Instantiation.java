package com.sentinela.workshopmongo.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.sentinela.workshopmongo.domain.User;
import com.sentinela.workshopmongo.repositories.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner {
	
	@Autowired
	private UserRepository repository;

	@Override
	public void run(String... args) throws Exception {
		
		repository.deleteAll();
		
		User parker = new User(null, "Peter Parker", "parker@gmail.com");
		User rogers = new User(null, "Steve Rogers", "rogers@gmail.com");
		User stark = new User(null, "Antony Stark", "stark@gmail.com");
		
		repository.saveAll(Arrays.asList(parker, rogers, stark));
		
	}

}
