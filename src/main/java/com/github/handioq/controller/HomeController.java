package com.github.handioq.controller;

import com.github.handioq.model.User;
import com.github.handioq.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

	//@PreAuthorize("hasRole('ROLE_USER')")
	private final UserRepository userRepository;

	@Autowired
	public HomeController(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@RequestMapping("/")
	public Iterable<User> getUsers() {
		return userRepository.findAll();
	}

}
