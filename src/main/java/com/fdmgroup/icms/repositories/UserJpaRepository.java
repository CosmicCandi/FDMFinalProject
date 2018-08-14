package com.fdmgroup.icms.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fdmgroup.icms.models.User;

public interface UserJpaRepository extends JpaRepository <User, Integer> {

	User findOneByUsername(String username);
}
