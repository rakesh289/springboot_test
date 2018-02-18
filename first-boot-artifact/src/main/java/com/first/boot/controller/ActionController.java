package com.first.boot.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.first.boot.domainentities.Action;
import com.first.boot.domainentities.User;
import com.first.boot.services.ActionService;

@RestController
public class ActionController {

	@Autowired
	ActionService actionService;

	@RequestMapping("/users/{userId}/actions")
	private List<Action> getAllActions() {
		return actionService.getAllActions();
	}

	@RequestMapping(value = "/users/{userId}/actions", method = RequestMethod.POST)
	private void addAction(@RequestBody Action action, @PathVariable Long userId) {
		action.setUser(new User(userId, "", ""));
		actionService.addction(action);
	}

	// I know the logic is weird but just wanted to test Java 8 features
	@RequestMapping(value = "/users/{userId}/actions/{actionId}", method = RequestMethod.GET)
	private Action getAction(@PathVariable Long userId, @PathVariable Long actionId) {
		Optional<Action> option = actionService.getAllActionByUser(userId).stream()
				.filter((Action action) -> action.getId().equals(actionId)).findFirst();
		return option.isPresent() ? option.get() : actionService.getAction(actionId);
	}

	@RequestMapping(value = "/users/{userId}/actions/{actionId}", method = RequestMethod.PUT)
	private void updateAction(@RequestBody Action action, @PathVariable Long userId, @PathVariable Long actionId) {
		action.setUser(new User(userId, "", ""));
		action.setId(actionId);
		actionService.updateAction(action);
	}

	@RequestMapping(value = "/users/{userId}/actions/{actionId}", method = RequestMethod.DELETE)
	private void deleteAction(@PathVariable Long actionId) {
		actionService.deleteAction(actionId);
	}

}
