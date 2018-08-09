package com.fdmgroup.icms.models;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fdmgroup.icms.classes.TestJpaConfig;
import com.fdmgroup.icms.repositories.IssueJpaRepository;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@Service("issueService")
@Transactional(readOnly=true)
public class IssueService {

	@Autowired
	private IssueJpaRepository issueRepo;
	
	@Transactional(readOnly=false)
	public void createOrUpdateIssue(Issue issue){
		issueRepo.save(issue);		
	}
	
	public Issue readIssue(int issueId){
		return issueRepo.findOneByIssueId(issueId);
	}
	
	@Transactional(readOnly=false)
	public void removeIssue(int issueId){
		issueRepo.delete(issueId);
	}

}
	
	

