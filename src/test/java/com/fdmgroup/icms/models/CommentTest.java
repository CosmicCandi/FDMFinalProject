package com.fdmgroup.icms.models;

import static org.junit.Assert.assertEquals;

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

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={ApplicationContextConfig.class})
@ActiveProfiles({"test"})
@WebAppConfiguration
public class CommentTest {

	@Autowired
	private ApplicationContext context;
	
	@Autowired
	private CommentService commentService;
	
	@Autowired
	private IssueService issueService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private Issue issue;
	
	@Autowired
	private Comment comment, comment2, comment3;
	
	@Autowired
	private User user;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}
	
	
	@Test
	public void test_addComment_WhenaddCommentIsCalled_ThenANewCommentIsCreated() {
		issue = (Issue)context.getBean("issue");
		comment = (Comment) context.getBean("comment");
		
		issue.addComment(comment);
		
		List<Comment> retrievedComments = issue.getComments();
		
		assertEquals(1, retrievedComments.size());
		assertEquals(comment, retrievedComments.get(0));
	}
	
	@Test
	public void test_MultipleComments_AreSortedBy_DateCreatedDesc_WhenRetrieved() {
		user = (User) context.getBean("user");
		user.setFirstName("Lilo");
		user.setLastName("Pelekai");
		user.setEmail("practicalvoodoo@pudgethefish.com");
		user.setPassword("Playground1");
		user.setRole(UserRole.GENERAL_USER);
		user.setUsername("helpdesk.lilo");
		userService.createUser(user);
			
		issue = (Issue)context.getBean("issue");
				
		comment = (Comment) context.getBean("comment");
		comment.setIssueId(issue);
		comment.setUserComment("This is the first comment. But should show up last.");
		comment.setUserId(user.getUserId());
		
		comment2 = (Comment) context.getBean("comment");
		comment2.setIssueId(issue);
		comment2.setUserComment("This is the second comment. It should not move positions.");
		comment2.setUserId(user.getUserId());
			
		comment3 = (Comment) context.getBean("comment");
		comment3.setIssueId(issue);
		comment3.setUserComment("This is the last comment. But should show up first.");
		comment3.setUserId(user.getUserId());
		
		issue.addComment(comment);
		issue.addComment(comment2);
		issue.addComment(comment3);
		
		issueService.createIssue(issue);
		
		List<Comment> retrievedComments = commentService.readCommentsByIssueId(issue.getIssueId());
		
		assertEquals(3, retrievedComments.size());
		assertEquals(retrievedComments.get(2).getUserComment(), comment.getUserComment());
		assertEquals(retrievedComments.get(1).getUserComment(), comment2.getUserComment());
		assertEquals(retrievedComments.get(0).getUserComment(), comment3.getUserComment());
	}
		
}
