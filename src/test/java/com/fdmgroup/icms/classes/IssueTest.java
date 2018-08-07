package com.fdmgroup.icms.classes;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class IssueTest {

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
		Issue issue = new Issue();
		Comment comment = new Comment();
		issue.addComment(comment);
		
		List<Comment> retrievedComments = issue.getComments();
		
		assertEquals(1, retrievedComments.size());
		assertEquals(comment, retrievedComments.get(0));
	}

}
