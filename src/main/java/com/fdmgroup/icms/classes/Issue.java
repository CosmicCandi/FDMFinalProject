package com.fdmgroup.icms.classes;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.fdmgroup.icms.enums.Department;
import com.fdmgroup.icms.enums.Status;
import com.fdmgroup.icms.enums.Priority;

public class Issue {

	private long issueId;
	private String title;
	private String userDescription;
	private List<Comment> comments = new ArrayList<>();
	private Department assignedTo;
	private long submittedBy;
	private Status Status;
	private Priority Priority;
	private Date dateSubmitted;
	private Date dateResolved;
	
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

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

	public void addComment(Comment comment) {
		this.comments.add(comment);
	}
	
	public Department getAssignedTo() {
		return assignedTo;
	}

	public void setAssignedTo(Department assignedTo) {
		this.assignedTo = assignedTo;
	}

	public long getSubmittedBy() {
		return submittedBy;
	}

	public void setSubmittedBy(long submittedBy) {
		this.submittedBy = submittedBy;
	}

	public Status getStatus() {
		return Status;
	}

	public void setStatus(Status status) {
		Status = status;
	}

	public Priority getPriority() {
		return Priority;
	}

	public void setPriority(Priority priority) {
		Priority = priority;
	}

	public Date getDateResolved() {
		return dateResolved;
	}

	public void setDateResolved(Date dateResolved) {
		this.dateResolved = dateResolved;
	}

	public long getIssueId() {
		return issueId;
	}

	public Date getDateSubmitted() {
		return dateSubmitted;
	}

	public Issue() {
	}

	public Issue(long issue_id, Date dateSubmitted) {
		this.issueId = issue_id;
		this.dateSubmitted = dateSubmitted;
	}
}
