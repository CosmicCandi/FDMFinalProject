package com.fdmgroup.icms.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fdmgroup.icms.models.User;

public interface UserJpaRepository extends JpaRepository <User, Integer> {

	User findOneByUsername(String username);
	
	List<User> findByUsername(String username);
}
