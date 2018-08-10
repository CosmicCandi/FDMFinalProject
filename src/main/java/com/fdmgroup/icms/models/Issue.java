package com.fdmgroup.icms.models;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="icms_issue")
@SequenceGenerator(name="issue_id_seq", initialValue=1, allocationSize=1 )
public class Issue {
		
	public Issue(){
		comments = new ArrayList<>();
		this.dateSubmitted = Calendar.getInstance().getTime();
	}
	
	public Issue(String title, String userDescription, /*List<Comment> comments,*/ Department assignedTo, Long submittedBy, Status status, 
			     Priority priority, Date dateResolved){
		this.title = title;
		this.userDescription = userDescription;
//		this.comments = comments;
		this.assignedTo = assignedTo;
		this.submittedBy = submittedBy;
		this.status = status;
		this.priority = priority;
		this.dateSubmitted = Calendar.getInstance().getTime();
		this.dateResolved = dateResolved;
	}
	
	@Id
	@Column(name="issue_id")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="issue_id_seq")
	private int issueId;
	
	@Column(name="title")
	private String title;
	
	@Column(name="user_description")
	private String userDescription;
	
	@OneToMany(mappedBy="issue", fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Comment> comments;

	public List<Comment> getComments() {
		return comments;
	}
	
	public void addComment(Comment comment) {
		comments.add(comment);
	}
	
	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}
	
	@Column(name="department")
	private Department assignedTo;
	
	@Column(name="submitted_by")
	private Long submittedBy;
	
	@Column(name="status")
	private Status status;
	
	@Column(name="priority")
	private Priority priority;
	
	@Column(name="date_submitted")
	private Date dateSubmitted;
	
	@Column(name="date_resolved")
	private Date dateResolved;

	public int getIssueId() {
		return issueId;
	}

	public void setIssueId(int issueId) {
		this.issueId = issueId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getUserDescription() {
		return userDescription;
	}

	public void setUserDescription(String userDescription) {
		this.userDescription = userDescription;
	}


	public Department getAssignedTo() {
		return assignedTo;
	}

	public void setAssignedTo(Department assignedTo) {
		this.assignedTo = assignedTo;
	}

	public Long getSubmittedBy() {
		return submittedBy;
	}

	public void setSubmittedBy(Long submittedBy) {
		this.submittedBy = submittedBy;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Priority getPriority() {
		return priority;
	}

	public void setPriority(Priority priority) {
		this.priority = priority;
	}

	public Date getDateSubmitted() {
		return dateSubmitted;
	}

	public void setDateSubmitted(Date dateSubmitted) {
		this.dateSubmitted = dateSubmitted;
	}

	public Date getDateResolved() {
		return dateResolved;
	}

	public void setDateResolved(Date dateResolved) {
		this.dateResolved = dateResolved;
	}
}
