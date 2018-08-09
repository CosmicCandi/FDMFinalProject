package com.fdmgroup.icms.models;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

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

import com.fdmgroup.icms.classes.ApplicationContextConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={ApplicationContextConfig.class})
@ActiveProfiles({"test"})
@WebAppConfiguration
public class IssueTest {

	@Autowired
	private ApplicationContext context;
	
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
		Issue issue = (Issue)context.getBean("issue");
		Comment comment = new Comment();
		issue.addComment(comment);
		
		List<Comment> retrievedComments = issue.getComments();
		
		assertEquals(1, retrievedComments.size());
		assertEquals(comment, retrievedComments.get(0));
	}
}
