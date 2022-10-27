package com.sentinela.workshopmongo.resources;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sentinela.workshopmongo.domain.User;

@RestController
@RequestMapping(value = "/users")
public class UserResource {
	
	@GetMapping
	public ResponseEntity<List<User>> findAll() {
		List<User> list = new ArrayList<>();
		
		User rogers = new User("1", "Steve Rogers", "rogers@gmail.com");
		User stark = new User("2", "Antony Stark", "stark@gmail.com");
		
		list.addAll(Arrays.asList(rogers, stark));
		
		return ResponseEntity.ok().body(list);
	}

}
