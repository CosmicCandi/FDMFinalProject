package com.fdmgroup.icms.models;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
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
	private IssueService issueService;
	
	@Autowired
	private CommentService commentService;
	
	@Autowired
	private UserService userService;
	
	private List<Comment> comments;
	private Comment comment;
	private Issue issue;
	private SeedDatabase sdb;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		sdb = (SeedDatabase)context.getBean("seedDatabase");
		comments = new ArrayList<>();
		comment = (Comment)context.getBean("comment");
		issue = (Issue)context.getBean("issue");
		
		comment.setUserComment("This is a default comment.");
		comment.setUserId(issue.getSubmittedBy());
		comment.setIssueId(issue);
	    comment.setUserId(0);
	    
	    comments.add(comment);
	    
	    issue.setAssignedTo(Department.HR);
		issue.setPriority(Priority.CRITICAL);
		issue.setTitle("This is a default issue.");
		issue.setComments(comments);
		issue.setDateSubmitted(new Date());
		issue.setSubmittedBy(0);
		
		sdb.addIssues();
	}

	@After
	public void tearDown() throws Exception {
		issueService.deleteAllIssues();
	}
				
	@Test
	public void test_CreateIssue_WritesPassedIssueToDatabase() {
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
	
	@Test
	public void test_findByUserId_ReturnsEveryIssueInDatabaseWithMatchingUserId() {
		//TODO SeedDatabase AppConfig doesn't work, it always points to null, it should be fixed and then made a static method
		List<Issue> retrievedIssues = issueService.findAllByUserId(0);
		
		assertEquals(2, retrievedIssues.size());
	}
	
	// TODO Test sorting retrieved comments by date
	// TODO Remove All for Comments WHERE issueId == 
	// TODO Remove All for Issues (Wipe Database)
	// TODO Update Operations for Issues/Comments/User
	
}
