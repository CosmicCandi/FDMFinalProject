package com.fdmgroup.icms.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fdmgroup.icms.models.Comment;

public interface CommentJpaRepository extends JpaRepository<Comment, Integer> {

	Comment findOneByCommentId(int commentId);
	List<Comment> findByIssue_IssueIdOrderByCommentIdDesc(int issueId);
}
