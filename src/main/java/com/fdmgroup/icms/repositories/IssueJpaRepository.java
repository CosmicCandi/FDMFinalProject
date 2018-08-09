package com.fdmgroup.icms.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fdmgroup.icms.models.Issue;

public interface IssueJpaRepository extends JpaRepository<Issue, Integer> {

	Issue findOneByIssueId(int issueId);
		
}
