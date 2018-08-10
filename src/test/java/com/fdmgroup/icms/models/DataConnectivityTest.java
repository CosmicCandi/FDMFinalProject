package com.fdmgroup.icms.models;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.fdmgroup.icms.appconfig.ApplicationContextConfig;
import com.fdmgroup.icms.models.Comment;
import com.fdmgroup.icms.models.CommentService;
import com.fdmgroup.icms.models.Issue;
import com.fdmgroup.icms.models.IssueService;
import com.fdmgroup.icms.models.User;
import com.fdmgroup.icms.models.UserService;

@RunWith(SpringJUnit4ClassRunner.class)		// runs with Spring to be autowired
@ContextConfiguration(classes={ApplicationContextConfig.class})	// classes which include for this test's dependencies
@ActiveProfiles({"test"})	// we want to use the "test" profile + all of the beans without a profile, not the "live" beans
@WebAppConfiguration					// a dummy annotation, necessary so when the test sees @EnableWebMvc, it doesn't attempt to find something to configure the web app
public class DataConnectivityTest {

	@Autowired 
	private ApplicationContext context;

	@Autowired
	private IssueService issueService;
	
	@Autowired
	private CommentService commentService;
	
	@Autowired
	private UserService userService;
	
	
	//Long issueId, String title, String userDescription, List<Comment> comments, Department assignedTo, Long submittedBy, Status status, 
    //Priority priority, Date dateSubmitted, Date dateResolved
				
	@Test
	public void test_CreateIssue_WritesPassedIssueToDatabase() {
		List<Comment> comments = new ArrayList<>();
		Comment comment = (Comment) context.getBean("comment");
		Issue issue = (Issue) context.getBean("issue");
		
		comment.setUserComment("This should hopefully work.");
		comment.setUserId(issue.getIssueId());
	    comments.add(comment);
		comment.setIssueId(issue);
		
		issue.setAssignedTo(Department.HR);
		issue.setPriority(Priority.CRITICAL);
		issue.setTitle("Please work!");
		issue.setComments(comments);
		issueService.createOrUpdateIssue(issue);

		Issue retrievedIssue = issueService.readIssue(issue.getIssueId());
		
		assertEquals(retrievedIssue.getIssueId(), issue.getIssueId());
		assertEquals(retrievedIssue.getTitle(), issue.getTitle());
		assertEquals(retrievedIssue.getComments().get(0).getUserComment(), issue.getComments().get(0).getUserComment());
				
	}

	@Test
	public void test_ReadUser_WhenUsernameIsPassed_ReturnsProperUser(){
		User user = (User) context.getBean("user");
		user.setUsername("civilwardabest");
		user.setPassword("Playground1");
		user.setEmail("harley@halley.com");
		user.setDepartmentId(Department.WEB_APPS);
		user.setRole(UserRole.GENERAL_USER);
		
		userService.createOrUpdateUser(user);
		
		User retrievedUser = userService.readUser("civilwardabest");
		assertEquals(user.getUsername(), retrievedUser.getUsername());
	}
	
	@Test
	public void test_IssueAddComment_SuccessfullyAddsAComment_AndWritesItToTheDatabase(){
		Issue issue = (Issue) context.getBean("issue");
		issue.setAssignedTo(Department.HR);
	    issue.setPriority(Priority.CRITICAL);
	    issue.setTitle("This is a default issue.");
	    issue.setDateSubmitted(Calendar.getInstance().getTime());
	    
	    Comment comment = (Comment) context.getBean("comment");
		comment.setIssueId(issue);
		comment.setUserComment("Testing adding a comment to an existing issue");
		comment.setUserId(0);
		issue.addComment(comment);
		issueService.createOrUpdateIssue(issue);
		
		Comment comment2 = (Comment) context.getBean("comment");
		comment2.setIssueId(issue);
		comment2.setUserComment("This is the second comment.");
		comment2.setUserId(42);
		
		issue.addComment(comment2);

		
		Comment comment3 = (Comment) context.getBean("comment");
		comment3.setIssueId(issue);
		comment3.setUserComment("Written directly to database");
		comment3.setUserId(0);
		commentService.createOrUpdateComment(comment3);
		
		issueService.createOrUpdateIssue(issue);
		
		Issue retrievedIssue = issueService.readIssue(issue.getIssueId());
		
		assertNotNull(retrievedIssue.getComments());
		assertEquals(3, retrievedIssue.getComments().size());
	}
	
	// TODO Test sorting retrieved comments by date
	// TODO Remove All for Comments WHERE issueId == 
	// TODO Remove All for Issues (Wipe Database)
	// TODO Update Operations for Issues/Comments/User
	
		
}
