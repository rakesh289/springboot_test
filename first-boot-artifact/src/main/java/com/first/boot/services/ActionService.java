package com.first.boot.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.first.boot.domainentities.Action;
import com.first.boot.domainentities.User;
import com.first.boot.repository.ActionRepository;

@Service
public class ActionService {
	
	@Autowired
	private ActionRepository actionRepository;
	private List<Action> actions = new ArrayList<>(
				Arrays.asList(
						new Action(1L, "APP", "Approve", new User(1L, "John", "Mumbai")),
						new Action(1L, "MOD", "Modify", new User(1L, "John", "Mumbai"))
						
							)
			);
	
	
	public List<Action> getAllActions(){
		//return actions;
		List<Action> returnActions = new ArrayList<>();
		actionRepository.findAll().forEach(returnActions::add);
		return returnActions;
	}
	
	public Action getAction(Long id){
		return actionRepository.findOne(id);
	}
	
	public List<Action> getAllActionByUser(Long userId){
		List<Action> returnActions = new ArrayList();
		actionRepository.findByUserId(userId).forEach(returnActions::add);
		return returnActions;
	}
	
	public void addction(Action action){
		actionRepository.save(action);
	}
	
	public void updateAction(Action action){
		actionRepository.save(action);
	}
	
	public void deleteAction(Long id){
		actionRepository.delete(id);
	}

}
