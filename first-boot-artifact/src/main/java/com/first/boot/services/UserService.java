package com.first.boot.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.first.boot.domainentities.User;

@Service
public class UserService {
	
	private List<User> users = new ArrayList<>(
			Arrays.asList(new User("1", "John", "Mumbai"),
					new User("2", "Jane", "Seattle"),
					new User("3", "Smith", "Edinburgh")
			));
	
	

}
