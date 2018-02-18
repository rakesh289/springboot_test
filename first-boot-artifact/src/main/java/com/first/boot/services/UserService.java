package com.first.boot.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.first.boot.domainentities.User;
import com.first.boot.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;
	
	private List<User> users = new ArrayList<>(
			Arrays.asList(new User(1L, "John", "Mumbai"),
					new User(2L, "Jane", "Seattle"),
					new User(3L, "Smith", "Edinburgh")
			));
	
	
	
	public List<User> getAllUsers(){
		//return users;
		List<User> returnUsers = new ArrayList<>();
		userRepository.findAll().forEach(returnUsers::add);
		return returnUsers;
	}
	
	public User getUser(Long userId){
		return userRepository.findOne(userId);
	}
	
	public void addUser(User user){
		userRepository.save(user);
	}
	
	public void updateUser(User user){
		userRepository.save(user);
	}
	
	public void deleteUser(Long userId){
		userRepository.delete(userId);
	}

}
