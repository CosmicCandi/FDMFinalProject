package com.fdmgroup.icms.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fdmgroup.icms.classes.IcmsBeanConfig;
import com.fdmgroup.icms.classes.Issue;
import com.fdmgroup.icms.enums.Department;
import com.fdmgroup.icms.enums.Priority;
import com.fdmgroup.icms.enums.Status;

@Controller
public class MainController {

	private ApplicationContext context = new AnnotationConfigApplicationContext(IcmsBeanConfig.class);
	
	@RequestMapping(value="issues")
	public String issuesPage(Model model){
		
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
	
}
