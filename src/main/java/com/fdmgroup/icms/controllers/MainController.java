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

import com.fdmgroup.icms.models.Department;
import com.fdmgroup.icms.models.Issue;
import com.fdmgroup.icms.models.IssueService;
import com.fdmgroup.icms.models.User;
import com.fdmgroup.icms.models.UserRole;

@Controller
public class MainController {

	@Autowired
	private ApplicationContext context;
	
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
		
		List<Issue> issueList = new ArrayList<>();
		
		switch (user.getRole()) {
		case GENERAL_ADMINISTRATOR: 
			issueList.addAll(issueService.readAll());
			break;
		case DEPARTMENT_ADMINISTRATOR:
			issueList.addAll(issueService.readAllByDepartment(user.getDepartmentId()));
		case GENERAL_USER:
			issueList.addAll(issueService.readAllByUserId(user.getUserId()));
			break;
		}
		
		model.addAttribute("issueList", issueList);
		
		return "issues";
	}
	
	@RequestMapping(value="newIssue")
	public String newIssuePage(Model model, Issue newIssue){
		
		model.addAttribute("newIssue", (Issue) context.getBean("issue"));
		
		issueService.createOrUpdateIssue(newIssue);
		
		model.addAttribute("departmentList", Department.ticketHandlers);
		return "newIssue";
	}
	
	@RequestMapping(value="history")
	public String historyPage(Model model){
		
		return "history";
	}
	
	@RequestMapping(value="/issueDetails/{issueId}")
	public String issueDetailsPage(Model model, @ModelAttribute User user, @PathVariable int issueId){		
		
		Issue issue = issueService.readIssue(issueId);
		
		model.addAttribute("issue", issue);
		
		return "issueDetails";
	}
	
	@RequestMapping(value="logout")
	public String logoutPage(Model model, HttpSession session) {
		
		session.invalidate();
		
		return "login";
	}
	
}
