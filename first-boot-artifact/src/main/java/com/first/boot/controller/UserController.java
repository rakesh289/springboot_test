package com.first.boot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.first.boot.domainentities.User;
import com.first.boot.services.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping("/users")
	private List<User> getAllUsers() {
		return userService.getAllUsers();
	}

	@RequestMapping(value = "/users", method = RequestMethod.POST)
	private void addUser(@RequestBody User user) {
		userService.addUser(user);
	}

	@RequestMapping(value = "/users/{userId}", method = RequestMethod.GET)
	private User getUser(@PathVariable Long userId) {
		return userService.getUser(userId);
	}

	@RequestMapping(value = "/users/{userId}", method = RequestMethod.PUT)
	private void updateUser(@RequestBody User user, @PathVariable Long userId) {
		user.setId(userId);
		userService.updateUser(user);
	}

	@RequestMapping(value = "/users/{userId}", method = RequestMethod.DELETE)
	private void deleteUser(@PathVariable Long userId) {
		userService.deleteUser(userId);
	}
}
