package com.first.boot.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.first.boot.domainentities.Action;

public interface ActionRepository extends CrudRepository<Action, Long> {

	public List<Action> findByUserId(Long userId);
}
