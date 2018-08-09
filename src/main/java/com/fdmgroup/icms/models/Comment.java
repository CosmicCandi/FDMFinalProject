package com.fdmgroup.icms.models;

import java.util.Calendar;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="issue_comment")
@SequenceGenerator(name="comment_id_seq", initialValue=1, allocationSize=1)
public class Comment {

	public Comment(){
		this.dateCreated = Calendar.getInstance().getTime();
	}

	public Comment(String userComment, Issue issue){
		this.userComment = userComment;
		this.dateCreated = Calendar.getInstance().getTime();
		this.issue = issue;
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="comment_id_seq")
	private int commentId;
	
	@Column(name="userComment")
	private String userComment;
		
	@ManyToOne
	@JoinColumn(name="issueId")
	private Issue issue;
	
	@Column
	private Date dateCreated;
	
	@Column
	private int userId;

	public String getUserComment() {
		return userComment;
	}

	public void setUserComment(String comment) {
		this.userComment = comment;
	}

	public Issue getIssueId() {
		return issue;
	}

	public void setIssueId(Issue issue) {
		this.issue = issue;
	}

	public Date getDateCreated() {
		return dateCreated;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getCommentId() {
		return commentId;
	}
	
		
}
