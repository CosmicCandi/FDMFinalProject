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
	private CommentJpaRepository commentRepo;
	
	@Transactional(readOnly = false)
	public void createOrUpdateComment(Comment comment){
		commentRepo.save(comment);
	}
	
	public Comment readComment(int commentId){
		return commentRepo.findOneByCommentId(commentId);
	}
	
	public List<Comment> findAllByIssueIdOrderByDateDesc(int issueId){
		return commentRepo.findByIssueIdOrderByDateCreatedDesc(issueId);
	}

	
}
