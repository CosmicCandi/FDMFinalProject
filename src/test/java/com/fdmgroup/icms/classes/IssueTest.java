package com.fdmgroup.icms.classes;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.fdmgroup.icms.enums.Department;

public class IssueTest {

	private ApplicationContext context;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		context = new AnnotationConfigApplicationContext(IcmsBeanConfig.class);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test_addComment_WhenaddCommentIsCalled_ThenANewCommentIsCreated() {
		Issue issue = (Issue)context.getBean("issue");
		Comment comment = new Comment();
		issue.addComment(comment);
		
		List<Comment> retrievedComments = issue.getComments();
		
		assertEquals(1, retrievedComments.size());
		assertEquals(comment, retrievedComments.get(0));
	}

	@Test
	public void test_getIssueId_WhenMutltipleIssuesAreCreated_EachHasAUniqueIssueId() {
		Issue issue = (Issue)context.getBean("issue");
		Issue issue2 = (Issue)context.getBean("issue");
		Issue issue3 = (Issue)context.getBean("issue");
		
		assertNotEquals(issue.getIssueId(), issue2.getIssueId());
		assertNotEquals(issue2.getIssueId(), issue3.getIssueId());
		assertNotEquals(issue.getIssueId(), issue3.getIssueId());
	}
}
