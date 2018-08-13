package com.fdmgroup.icms.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fdmgroup.icms.models.Issue;

public interface IssueJpaRepository extends JpaRepository<Issue, Integer> {
	
	List<Issue> findBySubmittedByOrderByDateSubmittedDesc(int userId);
}
