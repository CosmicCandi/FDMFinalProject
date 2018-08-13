package com.fdmgroup.icms.models;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fdmgroup.icms.repositories.IssueJpaRepository;

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
		return issueRepo.findOne(issueId);
	}
	
	public List<Issue> readAll() {
		return issueRepo.findAllByOrderByDateSubmittedDesc();
	}
	
	@Transactional(readOnly=false)
	public void removeIssue(int issueId){
		issueRepo.delete(issueId);
	}

	public List<Issue> readAllByUserId(int userId) {
		return issueRepo.findBySubmittedByOrderByDateSubmittedDesc(userId);
	}
	
	public List<Issue> readAllByDepartment(Department department) {
		return issueRepo.findByAssignedToOrderByDateSubmittedDesc(department);
	}
	
	@Transactional(readOnly=false)
	public void deleteAllIssues() {
		issueRepo.deleteAll();
	}
}
	
	

