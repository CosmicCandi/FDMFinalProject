package com.fdmgroup.icms.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fdmgroup.icms.models.Department;
import com.fdmgroup.icms.models.Issue;

public interface IssueJpaRepository extends JpaRepository<Issue, Integer> {
	
	List<Issue> findBySubmittedByOrderByDateSubmittedDesc(int userId);
	List<Issue> findAllByOrderByDateSubmittedDesc();
	List<Issue> findByAssignedToOrderByDateSubmittedDesc(Department department);
}
