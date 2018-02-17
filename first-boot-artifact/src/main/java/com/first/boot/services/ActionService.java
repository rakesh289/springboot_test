package com.first.boot.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.first.boot.domainentities.Action;
import com.first.boot.domainentities.User;

@Service
public class ActionService {
	
	private List<Action> actions = new ArrayList<>(
				Arrays.asList(
						new Action(1L, "APP", "Approve", new User("1", "John", "Mumbai")),
						new Action(1L, "MOD", "Modify", new User("1", "John", "Mumbai"))
						
							)
			);

}
