package com.fdmgroup.icms.models;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fdmgroup.icms.repositories.UserJpaRepository;

@Service
@Transactional(readOnly=true)
public class UserService {

	@Autowired 
	private UserJpaRepository userRepo;
	
	@Transactional(readOnly=false)
	public void createOrUpdateUser(User user){
		userRepo.save(user);
	}
	
	public User readUser(String username){
		return userRepo.findOneByUsername(username);
	}
	
	public List<User> readUsers(String username) {
		return userRepo.findByUsername(username);
	}
	
	@Transactional(readOnly=false)
	public void removeUser(int userId){
		userRepo.delete(userId);
	}	
	
}
