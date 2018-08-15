package com.fdmgroup.icms.models;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.context.annotation.EnableAspectJAutoProxy;



@Entity
@Table(name="icms_issue")
@SequenceGenerator(name="issue_id_seq", initialValue=1, allocationSize=1 )
@EnableAspectJAutoProxy
public class Issue {

	public Issue(){
		comments = new ArrayList<>();
		this.dateSubmitted = new Date();
	}
	
	public Issue(String title, String userDescription, Department assignedTo, int submittedBy, Status status, Priority priority, Date dateResolved){
		this.title = title;
		this.userDescription = userDescription;
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
	
	@Column(name="user_description", length = 3500)
	private String userDescription;
	
	@OneToMany(mappedBy="issue", fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Comment> comments;

	@Column(name="department")
	@Enumerated(EnumType.STRING)
	private Department assignedTo;
	
	@Column(name="submitted_by")
	private int submittedBy;
	
	@Column(name="status")
	@Enumerated(EnumType.STRING)
	private Status status;
	
	@Column(name="priority")
	@Enumerated(EnumType.STRING)
	private Priority priority;
	
	@Column(name="date_submitted")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateSubmitted;
	
	@Column(name="date_resolved")
	@Temporal(TemporalType.TIMESTAMP)
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

	public List<Comment> getComments() {
		return comments;
	}
	
	public void addComment(Comment comment) {
		comments.add(comment);
	}
	
	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}
	
	public Department getAssignedTo() {
		return assignedTo;
	}

	public void setAssignedTo(Department assignedTo) {
		this.assignedTo = assignedTo;
	}

	public int getSubmittedBy() {
		return submittedBy;
	}

	public void setSubmittedBy(int submittedBy) {
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
