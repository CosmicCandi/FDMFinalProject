package com.fdmgroup.icms.models;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.fdmgroup.icms.appconfig.ApplicationContextConfig;

@RunWith(SpringJUnit4ClassRunner.class)		// runs with Spring to be autowired
@ContextConfiguration(classes={ApplicationContextConfig.class})	// classes which include for this test's dependencies
@ActiveProfiles({"test"})	// we want to use the "test" profile + all of the beans without a profile, not the "live" beans
@WebAppConfiguration					// a dummy annotation, necessary so when the test sees @EnableWebMvc, it doesn't attempt to find something to configure the web app
public class DataConnectivityTest {

	@Autowired 
	private ApplicationContext context;

	@Autowired
	private Issue issue;
	
	@Autowired
	private IssueService issueService;
	
	@Autowired
	private CommentService commentService;
	
	@Autowired
	private UserService userService;
						
	@Test
	public void test_CreateIssue_WritesPassedIssueToDatabase() {
		List<Comment> comments = new ArrayList<>();
		Comment comment = (Comment) context.getBean("comment");
		Issue issue = (Issue) context.getBean("issue");
		
		comment.setUserComment("This will work.");
		comment.setUserId(issue.getIssueId());
	    comments.add(comment);
		comment.setIssueId(issue);
		
		issue.setAssignedTo(Department.HR);
		issue.setPriority(Priority.CRITICAL);
		issue.setTitle("Please work!");
		issue.setComments(comments);
		issueService.createIssue(issue);

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
		
		userService.createUser(user);
		
		User retrievedUser = userService.readUser("civilwardabest");
		assertEquals(user.getUsername(), retrievedUser.getUsername());
	}
	
	@Test
	public void test_IssueAddComment_SuccessfullyAddsAComment_AndWritesItToTheDatabase(){
		issue = (Issue) context.getBean("issue");
		issue.setAssignedTo(Department.HR);
	    issue.setPriority(Priority.CRITICAL);
	    issue.setTitle("This is a default issue.");
	    issue.setDateSubmitted(Calendar.getInstance().getTime());
	    
	    Comment comment = (Comment) context.getBean("comment");
		comment.setIssueId(issue);
		comment.setUserComment("Testing adding a comment to an existing issue");
		comment.setUserId(0);
		issue.addComment(comment);
		issueService.createIssue(issue);
		
		Comment comment2 = (Comment) context.getBean("comment");
		comment2.setIssueId(issue);
		comment2.setUserComment("This is the second comment.");
		comment2.setUserId(42);
		
		issue.addComment(comment2);

		
		Comment comment3 = (Comment) context.getBean("comment");
		comment3.setIssueId(issue);
		comment3.setUserComment("Written directly to database");
		comment3.setUserId(0);
		commentService.createComment(comment3);
		
		issueService.createIssue(issue);
		
		Issue retrievedIssue = issueService.readIssue(issue.getIssueId());
		
		assertNotNull(retrievedIssue.getComments());
		assertEquals(3, retrievedIssue.getComments().size());
	}
	
	@Test
	public void test_WhenAnIssueIsUpdated_TheReturnedValuesAreTheUpdatedValues(){
		User user = (User) context.getBean("user");
		user.setUsername("civilwardabest");
		user.setPassword("Playground1");
		user.setEmail("harley@halley.com");
		user.setDepartmentId(Department.WEB_APPS);
		user.setRole(UserRole.GENERAL_USER);
		
		userService.createUser(user);
		
		issue = (Issue) context.getBean("issue");
		issue.setAssignedTo(Department.HR);
		issue.setUserDescription("Testing Update functionality");
	    issue.setPriority(Priority.CRITICAL);
	    issue.setTitle("Database Update Functionality");
	    issue.setDateSubmitted(Calendar.getInstance().getTime());
	    issue.setSubmittedBy(user.getUserId());
	    issueService.createIssue(issue);
	    
	    Issue copyOfIssue = issueService.readIssue(issue.getIssueId());
	    
	    issue.setAssignedTo(Department.TELECOM);
	    issue.setPriority(Priority.MINOR);
	    
	    issueService.updateIssue(issue);
	    
	    assertNotEquals(copyOfIssue.getAssignedTo(), issue.getAssignedTo());
	    assertNotEquals(copyOfIssue.getAssignedTo(), issue.getPriority());
	    assertNotEquals(issue, copyOfIssue);
	}

	@Test
	public void test_WhenACommentGetsUpdated_TheUpdatedValuesAreReturned(){
		User user = (User) context.getBean("user");
		user.setUsername("civilwardabest");
		user.setPassword("Playground1");
		user.setEmail("harley@halley.com");
		user.setDepartmentId(Department.WEB_APPS);
		user.setRole(UserRole.GENERAL_USER);
		
		userService.createUser(user);
		
		issue = (Issue) context.getBean("issue");
		issue.setAssignedTo(Department.HR);
	    issue.setPriority(Priority.CRITICAL);
	    issue.setTitle("Test Comment Update.");
	    issue.setUserDescription("Tests that update functionality works for comments.");
	    issue.setDateSubmitted(Calendar.getInstance().getTime());
	    
	    
	    Comment comment = (Comment) context.getBean("comment");
		comment.setIssueId(issue);
		comment.setUserComment("This is the original comment.");
		comment.setUserId(user.getUserId());
		
		issue.addComment(comment);
		issueService.createIssue(issue);
		
		Comment copyOfComment = commentService.readComment(comment.getCommentId());
				
		
		comment.setUserComment("I made a typo in the previous comment. Not really. But I needed to type something here.");
		commentService.updateComment(comment);
				
		assertNotEquals(copyOfComment.getUserComment(), comment.getUserComment());
		assertEquals(copyOfComment.getCommentId(), comment.getCommentId());
		assertNotEquals(copyOfComment.getDateCreated(), comment.getDateCreated());
		
	}
	
	@Test
	public void test_WhenAUserGetsUpdated_UpdatedValuesAreReturned(){
		User user = (User) context.getBean("user");
		user.setUsername("civilwardabest");
		user.setPassword("Playground1");
		user.setEmail("harley@halley.com");
		user.setDepartmentId(Department.WEB_APPS);
		user.setRole(UserRole.GENERAL_USER);
		
		User copyOfHarley = userService.readUser("civilwardabest");
		userService.createUser(user);
		
		user.setDepartmentId(Department.HELP_DESK);
		user.setUsername("helpdeskisme");
		user.setPassword("GrantIsB3stGener@l!");
		user.setEmail("harley@helpdesk.com");
		user.setRole(UserRole.GENERAL_ADMINISTRATOR);
		
		userService.updateUser(user);
		
		assertNotEquals(copyOfHarley.getUsername(), user.getUsername());
		assertNotEquals(copyOfHarley.getPassword(), user.getPassword());
		assertNotEquals(copyOfHarley.getEmail(), user.getEmail());
		assertNotEquals(copyOfHarley.getDepartmentId(), user.getDepartmentId());
		assertNotEquals(copyOfHarley.getRole(), user.getRole());
	}
}
