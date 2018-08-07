package com.fdmgroup.icms.classes;
import com.fdmgroup.icms.enums.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Issue {

	private long issue_id;
	private String title;
	private String userDescription;
	private List<Comment> comments = new ArrayList<>();
	//private Department assignedTo;
	private long submittedBy;
	//private Status Status;
	//private Priority Priority;
	private Date dateSubmitted;
	private Date dateResolved;
	
	public final List<Comment> getComments() {
		return comments;
	}

	public final void setComments(List<Comment> comments) {
		this.comments = comments;
	}

	public void addComment(Comment comment) {
		this.comments.add(comment);
	}

	public Issue() {
	}
}
