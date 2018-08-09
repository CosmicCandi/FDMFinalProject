package com.fdmgroup.icms.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fdmgroup.icms.classes.IcmsBeanConfig;
import com.fdmgroup.icms.classes.Issue;
import com.fdmgroup.icms.classes.User;
import com.fdmgroup.icms.enums.Department;
import com.fdmgroup.icms.enums.Priority;
import com.fdmgroup.icms.enums.Status;
import com.fdmgroup.icms.enums.UserRole;

@Controller
public class MainController {

	private ApplicationContext context = new AnnotationConfigApplicationContext(IcmsBeanConfig.class);
	
	@ModelAttribute
	public User user() {
		User user = new User();
		user.setUserId(1);
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
		
		model.addAttribute("issue", issue);
		model.addAttribute("issueList", issueList);
		
		return "issues";
	}
	
	@RequestMapping(value="newIssue")
	public String newIssuePage(Model model){
		
		model.addAttribute("issue", (Issue) context.getBean("issue"));
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
		
		model.addAttribute("issue", issue);
		
		return "issueDetails";
	}
	
	@RequestMapping(value="logout")
	public String logoutPage(Model model, HttpSession session) {
		
		session.invalidate();
		
		return "login";
	}
	
}
