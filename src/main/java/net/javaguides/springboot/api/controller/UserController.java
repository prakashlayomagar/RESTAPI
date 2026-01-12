package net.javaguides.springboot.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

import net.javaguides.springboot.api.model.User;
import net.javaguides.springboot.service.UserService;

@RestController
public class UserController {
	
	private final UserService userService;
	
	@Autowired
	public UserController(UserService userService) {
		this.userService = userService ;
	}

	 @GetMapping("/user")
	 public User getUser(@RequestParam Integer id) {
		 Optional<User> user = userService.getUser(id);
		 return user.orElse(null);
	 }

}
