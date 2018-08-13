package com.fdmgroup.icms.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fdmgroup.icms.models.Comment;
import com.fdmgroup.icms.models.Department;
import com.fdmgroup.icms.models.Issue;
import com.fdmgroup.icms.models.IssueService;
import com.fdmgroup.icms.models.Priority;
import com.fdmgroup.icms.models.Status;
import com.fdmgroup.icms.models.User;
import com.fdmgroup.icms.models.UserRole;

@Controller
public class MainController {

	@Autowired
	private ApplicationContext context;// = new AnnotationConfigApplicationContext(ApplicationContextConfig.class);
	
	@Autowired
	private IssueService issueService;
	
	@ModelAttribute
	public User user() {
		User user = (User)context.getBean("user");
		user.setRole(UserRole.GENERAL_ADMINISTRATOR);
		return user;
	}
	
	@RequestMapping(value="issues")
	public String issuesPage(Model model, User user){
		
		//TODO * Query Database *
		
		List<Issue> issueList = new ArrayList<>();
		Issue issue = (Issue) context.getBean("issue");
		
		issue.setAssignedTo(Department.TELECOM);
		issue.setPriority(Priority.CRITICAL);
		issue.setStatus(Status.SUBMITTED);
		issue.setTitle("Pickle Issue");
		issueList.add(issue);
		issueList.add(issue);
		issueList.add(issue);issueList.add(issue);issueList.add(issue);issueList.add(issue);issueList.add(issue);issueList.add(issue);issueList.add(issue);issueList.add(issue);issueList.add(issue);issueList.add(issue);issueList.add(issue);issueList.add(issue);issueList.add(issue);issueList.add(issue);issueList.add(issue);issueList.add(issue);issueList.add(issue);issueList.add(issue);issueList.add(issue);issueList.add(issue);

//		switch (user.getRole()) {
//		case GENERAL_ADMINISTRATOR: 
//			issueList = issueService.readAll();
//			break;
//		case DEPARTMENT_ADMINISTRATOR:
//			break;
//		case GENERAL_USER:
//			break;
//		}	
		
		model.addAttribute("issue", issue);
		model.addAttribute("issueList", issueList);
		
		return "issues";
	}
	
	@RequestMapping(value="newIssue")
	public String newIssuePage(Model model){
		
		model.addAttribute("newIssue", (Issue) context.getBean("issue"));
		
		model.addAttribute("departmentList", Department.ticketHandlers);
		return "newIssue";
	}
	
	@RequestMapping(value="history")
	public String historyPage(Model model){
		
		return "history";
	}
	
	@RequestMapping(value="/issueDetails/{ID}")
	public String issueDetailsPage(Model model, @ModelAttribute User user, @PathVariable String ID){		
		
		//TODO * Query Database *
		
		Issue issue = (Issue) context.getBean("issue");
		issue.setAssignedTo(Department.TELECOM);
		issue.setPriority(Priority.CRITICAL);
		issue.setStatus(Status.SUBMITTED);
		issue.setTitle("Pickle Issue");
		issue.setUserDescription("User description User description User description User description User description User description User description User description User descriptionUser descriptionUser descriptionUser descriptionUser descriptionUser descriptionUser descriptionUser descriptionUser descriptionUser descriptionUser descriptionUser descriptionUser descriptionUser descriptionUser descriptionUser descriptionUser descriptionUser descriptionUser descriptionUser descriptionUser descriptionUser descriptionUser descriptionUser descriptionUser descriptionUser descriptionUser descriptionUser descriptionUser descriptionUser descriptionUser descriptionUser descriptionUser descriptionUser descriptionUser descriptionUser descriptionUser descriptionUser descriptionUser descriptionUser descriptionUser descriptionUser descriptionUser descriptionUser description");
		
		User submitter = (User) context.getBean("user");
		submitter.setFirstName("Steven");
		submitter.setLastName("Smith");
		submitter.setEmail("steve_s@email.com");
		submitter.setDepartmentId(Department.ACCOUNTING);
		
		List<Comment> commentList = new ArrayList<>();
		
		Comment comment = (Comment) context.getBean("comment");
		comment.setUserComment("This is a comment");
		Comment comment2 = (Comment) context.getBean("comment");
		comment2.setUserComment("This is a comment also");
		Comment comment3 = (Comment) context.getBean("comment");
		comment3.setUserComment("This is a comment too");
		Comment comment4 = (Comment) context.getBean("comment");
		comment4.setUserComment("This is a comment This is a comment This is a comment This is a comment This is a comment This is a comment");
		
		commentList.add(comment);
		commentList.add(comment2);
		commentList.add(comment3);
		commentList.add(comment4);
		
		model.addAttribute("submitter", submitter);
		model.addAttribute("commentList", commentList);
		model.addAttribute("issue", issue);
		
		return "issueDetails";
	}
	
	@RequestMapping(value="logout")
	public String logoutPage(Model model, HttpSession session) {
		
		session.invalidate();
		
		return "login";
	}
	
	@RequestMapping(value="createIssue")
	public String createIssuePage(Model model, Issue issue) {
		
		issueService.createOrUpdateIssue(issue);
		
		return "issues";
	}
	
}
