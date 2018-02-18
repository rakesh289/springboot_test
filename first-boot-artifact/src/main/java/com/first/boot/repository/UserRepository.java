package com.first.boot.repository;

import org.springframework.data.repository.CrudRepository;

import com.first.boot.domainentities.User;

public interface UserRepository extends CrudRepository<User, Long> {

}
