package com.first.boot.domainentities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Action {

	@Id
	private Long id;
	
	private String code;

	private String description;

	@ManyToOne
	private User user;

	public Action(Long id, String code, String description, User user) {
		super();
		this.id = id;
		this.code = code;
		this.description = description;
		this.user = user;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
