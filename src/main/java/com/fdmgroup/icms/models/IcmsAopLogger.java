package com.fdmgroup.icms.models;

import java.util.Date;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.JoinPoint;

import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Aspect
public class IcmsAopLogger {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private IssueService issueService;

	@Autowired
	private CommentService commentService;

	@Autowired
	private UserService userService;

	//Issue Joinpoints	
	@After("execution(void com.fdmgroup.icms.models.IssueService.createIssue(com.fdmgroup.icms.models.Issue)) && args(issue)")
	public void createIssue(Issue issue) {
		System.out.println("<<< Issue Created: " + new Date() + " >>> " + issue.getTitle());
		logger.info("Issue created" + issue.getTitle());
	}
	
	//Comment Joinpoints
	@After("execution(void com.fdmgroup.icms.models.Issue.addComment(com.fdmgroup.icms.models.Comment)) && args(comment)")
	public void createComment(Comment comment) {
		System.out.println("<<< Comment Created: " + new Date() + " >>> " + comment.getUserComment());
	}
	
	//User Joinpoints
	@After("execution(void com.fdmgroup.icms.models.UserService.createUser(com.fdmgroup.icms.models.User)) && args(user)")
	public void createUser(User user) {
		System.out.println("<<< User Created: " + new Date() + " >>> " + user.getUsername());
	}
	
	
}