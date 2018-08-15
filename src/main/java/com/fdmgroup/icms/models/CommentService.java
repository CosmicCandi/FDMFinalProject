package com.fdmgroup.icms.models;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fdmgroup.icms.repositories.CommentJpaRepository;

@Service
@Transactional(readOnly = true)
public class CommentService {
	
	@Autowired
	private Issue issue;
			
	@Autowired
	private CommentJpaRepository commentRepo;
	
	@Transactional(readOnly = false)
	public void createComment(Comment comment){
		commentRepo.save(comment);
	}
	
	public Comment readComment(int commentId){
		return commentRepo.findOne(commentId);
	}
	
	public List<Comment> readCommentsByIssueId(int issueId){
		return commentRepo.findByIssue_IssueIdOrderByCommentIdDesc(issueId);
	}
	
	@Transactional(readOnly = false)
	public void updateComment(Comment comment){
		commentRepo.save(comment);
	}
	
}
