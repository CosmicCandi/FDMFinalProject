package com.fdmgroup.icms.models;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class SeedDatabase {
	
	@Autowired
	private ApplicationContext context;
	
	@Autowired
	private IssueService issueService;
	
	public void addIssues() {
		Issue issue = (Issue)context.getBean("issue");

		String title = "Change my password";
		String userDescription = "I forgot my password to gitlab over 3 times";
				
		issue.setAssignedTo(Department.NETWORKING);
		issue.setDateSubmitted(new Date(System.currentTimeMillis() - (1 * 24 * 60 * 60 * 1000))); //1 day old
		issue.setPriority(Priority.MAJOR);
		issue.setStatus(Status.IN_PROGRESS);
		issue.setSubmittedBy(15);
		issue.setTitle(title);
		issue.setUserDescription(userDescription);
		
		Comment comment = (Comment)context.getBean("comment");
		comment.setIssueId(issue);
		comment.setUserComment("Short comment");
		comment.setUserId(15);
		issue.addComment(comment);
		
		comment = (Comment)context.getBean("comment");
		comment.setIssueId(issue);
		comment.setUserComment("Medium sized comment that should probably spill over to a new line because I am writing out an issue just because oh well end of sentence.");
		comment.setUserId(0);
		issue.addComment(comment);
		
		comment = (Comment)context.getBean("comment");
		comment.setIssueId(issue);
		comment.setUserComment("Long comment lorem ipsum to follow purus non enim praesent elementum facilisis leo vel fringilla est ullamcorper "
				+ "eget nulla facilisi etiam dignissim diam quis enim lobortis scelerisque fermentum dui faucibus in ornare quam viverra orci sagittis eu volutpat odio facilisis mauris sit amet massa vitae "
				+ "tortor condimentum lacinia quis vel eros donec ac odio tempor orci dapibus ultrices in iaculis nunc sed augue lacus viverra vitae congue eu consequat ac felis donec et odio pellentesque "
				+ "diam volutpat commodo sed egestas egestas fringilla phasellus faucibus scelerisque eleifend donec pretium vulputate sapien nec sagittis aliquam malesuada bibendum arcu vitae elementum "
				+ "curabitur vitae nunc sed velit dignissim sodales ut eu sem integer vitae justo eget magna fermentum iaculis eu non diam phasellus vestibulum lorem sed risus ultricies tristique nulla aliquet enim "
				+ "tortor at auctor urna nunc id cursus metus aliquam eleifend mi in nulla posuere sollicitudin aliquam ultrices sagittis orci a scelerisque purus semper eget duis at tellus at urna condimentum mattis "
				+ "pellentesque id nibh tortor id aliquet lectus proin nibh nisl condimentum id venenatis a condimentum vitae sapien pellentesque habitant morbi tristique senectus et netus et malesuada fames ac "
				+ "turpis egestas sed tempus urna et pharetra pharetra massa massa ultricies mi quis hendrerit dolor magna eget est lorem ipsum dolor sit amet consectetur adipiscing elit pellentesque habitant morbi "
				+ "tristique senectus et netus et malesuada fames ac turpis egestas integer eget aliquet nibh praesent tristique magna sit amet purus gravida quis blandit turpis cursus in hac habitasse platea dictumst "
				+ "quisque sagittis purus sit amet volutpat consequat mauris nunc congue nisi vitae suscipit tellus mauris a diam maecenas sed enim ut sem viverra aliquet eget sit amet tellus cras adipiscing enim eu "
				+ "turpis egestas pretium aenean pharetra magna ac placerat vestibulum lectus mauris ultrices eros in cursus turpis massa tincidunt dui ut ornare lectus sit amet est placerat in egestas erat imperdiet "
				+ "sed euismod nisi porta lorem mollis aliquam ut porttitor leo a diam sollicitudin tempor id eu nisl nunc mi ipsum faucibus vitae aliquet nec ullamcorper sit amet risus nullam eget felis eget nunc "
				+ "lobortis mattis aliquam faucibus purus in massa tempor nec feugiat nisl pretium fusce id velit ut tortor pretium viverra suspendisse potenti nullam ac tortor vitae purus faucibus ornare suspendisse "
				+ "sed nisi lacus sed viverra tellus in hac habitasse platea dictumst vestibulum rhoncus est pellentesque elit ullamcorper dignissim cras tincidunt lobortis feugiat vivamus at augue eget arcu dictum varius "
				+ "duis at consectetur lorem donec massa sapien faucibus et molestie ac feugiat sed lectus vestibulum mattis ullamcorper velit sed ullamcorper morbi tincidunt ornare massa eget egestas purus viverra "
				+ "accumsan in nisl nisi scelerisque eu ultrices vitae auctor eu augue ut lectus arcu bibendum at varius vel pharetra vel turpis nunc eget lorem dolor sed viverra ipsum nunc aliquet bibendum enim facilisis "
				+ "gravida neque convallis a cras semper auctor neque vitae tempus quam pellentesque nec nam aliquam sem et tortor consequat id porta nibh venenatis cras sed felis eget velit aliquet sagittis id consectetur "
				+ "purus ut faucibus pulvinar elementum integer enim neque volutpat ac tincidunt vitae semper quis");
		comment.setUserId(0);
		issue.addComment(comment);
		
		issueService.createOrUpdateIssue(issue);
		
		issue = (Issue)context.getBean("issue");

		title = "My Internet Won't Work";
		userDescription = "Fix my bleepin' internet you dumb IT person";
				
		issue.setAssignedTo(Department.NETWORKING);
		issue.setDateSubmitted(new Date(System.currentTimeMillis() - (6 * 24 * 60 * 60 * 1000))); //6 days old;
		issue.setPriority(Priority.CRITICAL);
		issue.setStatus(Status.SUBMITTED);
		issue.setSubmittedBy(0);
		issue.setTitle(title);
		issue.setUserDescription(userDescription);
		
		comment = (Comment)context.getBean("comment");
		comment.setIssueId(issue);
		comment.setUserComment("Short comment");
		comment.setUserId(101);
		issue.addComment(comment);
		
		comment = (Comment)context.getBean("comment");
		comment.setIssueId(issue);
		comment.setUserComment("Medium sized comment that should probably spill over to a new line because I am writing out an issue just because oh well end of sentence.");
		comment.setUserId(0);
		issue.addComment(comment);
		
		comment = (Comment)context.getBean("comment");
		comment.setIssueId(issue);
		comment.setUserComment("Long comment lorem ipsum to follow purus non enim praesent elementum facilisis leo vel fringilla est ullamcorper "
				+ "eget nulla facilisi etiam dignissim diam quis enim lobortis scelerisque fermentum dui faucibus in ornare quam viverra orci sagittis eu volutpat odio facilisis mauris sit amet massa vitae "
				+ "tortor condimentum lacinia quis vel eros donec ac odio tempor orci dapibus ultrices in iaculis nunc sed augue lacus viverra vitae congue eu consequat ac felis donec et odio pellentesque "
				+ "diam volutpat commodo sed egestas egestas fringilla phasellus faucibus scelerisque eleifend donec pretium vulputate sapien nec sagittis aliquam malesuada bibendum arcu vitae elementum "
				+ "curabitur vitae nunc sed velit dignissim sodales ut eu sem integer vitae justo eget magna fermentum iaculis eu non diam phasellus vestibulum lorem sed risus ultricies tristique nulla aliquet enim "
				+ "tortor at auctor urna nunc id cursus metus aliquam eleifend mi in nulla posuere sollicitudin aliquam ultrices sagittis orci a scelerisque purus semper eget duis at tellus at urna condimentum mattis "
				+ "pellentesque id nibh tortor id aliquet lectus proin nibh nisl condimentum id venenatis a condimentum vitae sapien pellentesque habitant morbi tristique senectus et netus et malesuada fames ac "
				+ "turpis egestas sed tempus urna et pharetra pharetra massa massa ultricies mi quis hendrerit dolor magna eget est lorem ipsum dolor sit amet consectetur adipiscing elit pellentesque habitant morbi "
				+ "tristique senectus et netus et malesuada fames ac turpis egestas integer eget aliquet nibh praesent tristique magna sit amet purus gravida quis blandit turpis cursus in hac habitasse platea dictumst "
				+ "quisque sagittis purus sit amet volutpat consequat mauris nunc congue nisi vitae suscipit tellus mauris a diam maecenas sed enim ut sem viverra aliquet eget sit amet tellus cras adipiscing enim eu "
				+ "turpis egestas pretium aenean pharetra magna ac placerat vestibulum lectus mauris ultrices eros in cursus turpis massa tincidunt dui ut ornare lectus sit amet est placerat in egestas erat imperdiet "
				+ "sed euismod nisi porta lorem mollis aliquam ut porttitor leo a diam sollicitudin tempor id eu nisl nunc mi ipsum faucibus vitae aliquet nec ullamcorper sit amet risus nullam eget felis eget nunc "
				+ "lobortis mattis aliquam faucibus purus in massa tempor nec feugiat nisl pretium fusce id velit ut tortor pretium viverra suspendisse potenti nullam ac tortor vitae purus faucibus ornare suspendisse "
				+ "sed nisi lacus sed viverra tellus in hac habitasse platea dictumst vestibulum rhoncus est pellentesque elit ullamcorper dignissim cras tincidunt lobortis feugiat vivamus at augue eget arcu dictum varius "
				+ "duis at consectetur lorem donec massa sapien faucibus et molestie ac feugiat sed lectus vestibulum mattis ullamcorper velit sed ullamcorper morbi tincidunt ornare massa eget egestas purus viverra "
				+ "accumsan in nisl nisi scelerisque eu ultrices vitae auctor eu augue ut lectus arcu bibendum at varius vel pharetra vel turpis nunc eget lorem dolor sed viverra ipsum nunc aliquet bibendum enim facilisis "
				+ "gravida neque convallis a cras semper auctor neque vitae tempus quam pellentesque nec nam aliquam sem et tortor consequat id porta nibh venenatis cras sed felis eget velit aliquet sagittis id consectetur "
				+ "purus ut faucibus pulvinar elementum integer enim neque volutpat ac tincidunt vitae semper quis");
		comment.setUserId(0);
		issue.addComment(comment);
		
		issueService.createOrUpdateIssue(issue);
		
		issue = (Issue)context.getBean("issue");

		title = "Broken HTML link";
		userDescription = "The link to go to my awesome new web page isn't working";
				
		issue.setAssignedTo(Department.WEB_SERVICES);
		issue.setDateSubmitted(new Date(System.currentTimeMillis() - (0 * 24 * 60 * 60 * 1000))); //0 days old;;
		issue.setPriority(Priority.NORMAL);
		issue.setStatus(Status.IN_PROGRESS);
		issue.setSubmittedBy(101);
		issue.setTitle(title);
		issue.setUserDescription(userDescription);
		
		comment = (Comment)context.getBean("comment");
		comment.setIssueId(issue);
		comment.setUserComment("Short comment");
		comment.setUserId(15);
		issue.addComment(comment);
		
		comment = (Comment)context.getBean("comment");
		comment.setIssueId(issue);
		comment.setUserComment("Medium sized comment that should probably spill over to a new line because I am writing out an issue just because oh well end of sentence.");
		comment.setUserId(0);
		issue.addComment(comment);
		
		comment = (Comment)context.getBean("comment");
		comment.setIssueId(issue);
		comment.setUserComment("Long comment lorem ipsum to follow purus non enim praesent elementum facilisis leo vel fringilla est ullamcorper "
				+ "eget nulla facilisi etiam dignissim diam quis enim lobortis scelerisque fermentum dui faucibus in ornare quam viverra orci sagittis eu volutpat odio facilisis mauris sit amet massa vitae "
				+ "tortor condimentum lacinia quis vel eros donec ac odio tempor orci dapibus ultrices in iaculis nunc sed augue lacus viverra vitae congue eu consequat ac felis donec et odio pellentesque "
				+ "diam volutpat commodo sed egestas egestas fringilla phasellus faucibus scelerisque eleifend donec pretium vulputate sapien nec sagittis aliquam malesuada bibendum arcu vitae elementum "
				+ "curabitur vitae nunc sed velit dignissim sodales ut eu sem integer vitae justo eget magna fermentum iaculis eu non diam phasellus vestibulum lorem sed risus ultricies tristique nulla aliquet enim "
				+ "tortor at auctor urna nunc id cursus metus aliquam eleifend mi in nulla posuere sollicitudin aliquam ultrices sagittis orci a scelerisque purus semper eget duis at tellus at urna condimentum mattis "
				+ "pellentesque id nibh tortor id aliquet lectus proin nibh nisl condimentum id venenatis a condimentum vitae sapien pellentesque habitant morbi tristique senectus et netus et malesuada fames ac "
				+ "turpis egestas sed tempus urna et pharetra pharetra massa massa ultricies mi quis hendrerit dolor magna eget est lorem ipsum dolor sit amet consectetur adipiscing elit pellentesque habitant morbi "
				+ "tristique senectus et netus et malesuada fames ac turpis egestas integer eget aliquet nibh praesent tristique magna sit amet purus gravida quis blandit turpis cursus in hac habitasse platea dictumst "
				+ "quisque sagittis purus sit amet volutpat consequat mauris nunc congue nisi vitae suscipit tellus mauris a diam maecenas sed enim ut sem viverra aliquet eget sit amet tellus cras adipiscing enim eu "
				+ "turpis egestas pretium aenean pharetra magna ac placerat vestibulum lectus mauris ultrices eros in cursus turpis massa tincidunt dui ut ornare lectus sit amet est placerat in egestas erat imperdiet "
				+ "sed euismod nisi porta lorem mollis aliquam ut porttitor leo a diam sollicitudin tempor id eu nisl nunc mi ipsum faucibus vitae aliquet nec ullamcorper sit amet risus nullam eget felis eget nunc "
				+ "lobortis mattis aliquam faucibus purus in massa tempor nec feugiat nisl pretium fusce id velit ut tortor pretium viverra suspendisse potenti nullam ac tortor vitae purus faucibus ornare suspendisse "
				+ "sed nisi lacus sed viverra tellus in hac habitasse platea dictumst vestibulum rhoncus est pellentesque elit ullamcorper dignissim cras tincidunt lobortis feugiat vivamus at augue eget arcu dictum varius "
				+ "duis at consectetur lorem donec massa sapien faucibus et molestie ac feugiat sed lectus vestibulum mattis ullamcorper velit sed ullamcorper morbi tincidunt ornare massa eget egestas purus viverra "
				+ "accumsan in nisl nisi scelerisque eu ultrices vitae auctor eu augue ut lectus arcu bibendum at varius vel pharetra vel turpis nunc eget lorem dolor sed viverra ipsum nunc aliquet bibendum enim facilisis "
				+ "gravida neque convallis a cras semper auctor neque vitae tempus quam pellentesque nec nam aliquam sem et tortor consequat id porta nibh venenatis cras sed felis eget velit aliquet sagittis id consectetur "
				+ "purus ut faucibus pulvinar elementum integer enim neque volutpat ac tincidunt vitae semper quis");
		comment.setUserId(0);
		issue.addComment(comment);
		
		issueService.createOrUpdateIssue(issue);
		
		issue = (Issue)context.getBean("issue");

		title = "The css on page login is a different shade of blue";
		userDescription = "See title";
				
		issue.setAssignedTo(Department.WEB_SERVICES);
		issue.setDateSubmitted(new Date(System.currentTimeMillis() - (3 * 24 * 60 * 60 * 1000))); //3 days old
		issue.setPriority(Priority.MINOR);
		issue.setStatus(Status.SUBMITTED);
		issue.setSubmittedBy(0);
		issue.setTitle(title);
		issue.setUserDescription(userDescription);
		
		comment = (Comment)context.getBean("comment");
		comment.setIssueId(issue);
		comment.setUserComment("Short comment");
		comment.setUserId(15);
		issue.addComment(comment);
		
		comment = (Comment)context.getBean("comment");
		comment.setIssueId(issue);
		comment.setUserComment("Medium sized comment that should probably spill over to a new line because I am writing out an issue just because oh well end of sentence.");
		comment.setUserId(0);
		issue.addComment(comment);
		
		comment = (Comment)context.getBean("comment");
		comment.setIssueId(issue);
		comment.setUserComment("Long comment lorem ipsum to follow purus non enim praesent elementum facilisis leo vel fringilla est ullamcorper "
				+ "eget nulla facilisi etiam dignissim diam quis enim lobortis scelerisque fermentum dui faucibus in ornare quam viverra orci sagittis eu volutpat odio facilisis mauris sit amet massa vitae "
				+ "tortor condimentum lacinia quis vel eros donec ac odio tempor orci dapibus ultrices in iaculis nunc sed augue lacus viverra vitae congue eu consequat ac felis donec et odio pellentesque "
				+ "diam volutpat commodo sed egestas egestas fringilla phasellus faucibus scelerisque eleifend donec pretium vulputate sapien nec sagittis aliquam malesuada bibendum arcu vitae elementum "
				+ "curabitur vitae nunc sed velit dignissim sodales ut eu sem integer vitae justo eget magna fermentum iaculis eu non diam phasellus vestibulum lorem sed risus ultricies tristique nulla aliquet enim "
				+ "tortor at auctor urna nunc id cursus metus aliquam eleifend mi in nulla posuere sollicitudin aliquam ultrices sagittis orci a scelerisque purus semper eget duis at tellus at urna condimentum mattis "
				+ "pellentesque id nibh tortor id aliquet lectus proin nibh nisl condimentum id venenatis a condimentum vitae sapien pellentesque habitant morbi tristique senectus et netus et malesuada fames ac "
				+ "turpis egestas sed tempus urna et pharetra pharetra massa massa ultricies mi quis hendrerit dolor magna eget est lorem ipsum dolor sit amet consectetur adipiscing elit pellentesque habitant morbi "
				+ "tristique senectus et netus et malesuada fames ac turpis egestas integer eget aliquet nibh praesent tristique magna sit amet purus gravida quis blandit turpis cursus in hac habitasse platea dictumst "
				+ "quisque sagittis purus sit amet volutpat consequat mauris nunc congue nisi vitae suscipit tellus mauris a diam maecenas sed enim ut sem viverra aliquet eget sit amet tellus cras adipiscing enim eu "
				+ "turpis egestas pretium aenean pharetra magna ac placerat vestibulum lectus mauris ultrices eros in cursus turpis massa tincidunt dui ut ornare lectus sit amet est placerat in egestas erat imperdiet "
				+ "sed euismod nisi porta lorem mollis aliquam ut porttitor leo a diam sollicitudin tempor id eu nisl nunc mi ipsum faucibus vitae aliquet nec ullamcorper sit amet risus nullam eget felis eget nunc "
				+ "lobortis mattis aliquam faucibus purus in massa tempor nec feugiat nisl pretium fusce id velit ut tortor pretium viverra suspendisse potenti nullam ac tortor vitae purus faucibus ornare suspendisse "
				+ "sed nisi lacus sed viverra tellus in hac habitasse platea dictumst vestibulum rhoncus est pellentesque elit ullamcorper dignissim cras tincidunt lobortis feugiat vivamus at augue eget arcu dictum varius "
				+ "duis at consectetur lorem donec massa sapien faucibus et molestie ac feugiat sed lectus vestibulum mattis ullamcorper velit sed ullamcorper morbi tincidunt ornare massa eget egestas purus viverra "
				+ "accumsan in nisl nisi scelerisque eu ultrices vitae auctor eu augue ut lectus arcu bibendum at varius vel pharetra vel turpis nunc eget lorem dolor sed viverra ipsum nunc aliquet bibendum enim facilisis "
				+ "gravida neque convallis a cras semper auctor neque vitae tempus quam pellentesque nec nam aliquam sem et tortor consequat id porta nibh venenatis cras sed felis eget velit aliquet sagittis id consectetur "
				+ "purus ut faucibus pulvinar elementum integer enim neque volutpat ac tincidunt vitae semper quis");
		comment.setUserId(0);
		issue.addComment(comment);
		
		issueService.createOrUpdateIssue(issue);
		
		issue = (Issue)context.getBean("issue");

		title = "Incorrect query results";
		userDescription = "When I query my super cool database by primary key it returns the wrong results";
				
		issue.setAssignedTo(Department.WEB_APPS);
		issue.setDateSubmitted(new Date(System.currentTimeMillis() - (10 * 24 * 60 * 60 * 1000))); //10 days old
		issue.setPriority(Priority.MAJOR);
		issue.setStatus(Status.IN_PROGRESS);
		issue.setSubmittedBy(15);
		issue.setTitle(title);
		issue.setUserDescription(userDescription);
		
		comment = (Comment)context.getBean("comment");
		comment.setIssueId(issue);
		comment.setUserComment("Short comment");
		comment.setUserId(15);
		issue.addComment(comment);
		
		comment = (Comment)context.getBean("comment");
		comment.setIssueId(issue);
		comment.setUserComment("Medium sized comment that should probably spill over to a new line because I am writing out an issue just because oh well end of sentence.");
		comment.setUserId(0);
		issue.addComment(comment);
		
		comment = (Comment)context.getBean("comment");
		comment.setIssueId(issue);
		comment.setUserComment("Long comment lorem ipsum to follow purus non enim praesent elementum facilisis leo vel fringilla est ullamcorper "
				+ "eget nulla facilisi etiam dignissim diam quis enim lobortis scelerisque fermentum dui faucibus in ornare quam viverra orci sagittis eu volutpat odio facilisis mauris sit amet massa vitae "
				+ "tortor condimentum lacinia quis vel eros donec ac odio tempor orci dapibus ultrices in iaculis nunc sed augue lacus viverra vitae congue eu consequat ac felis donec et odio pellentesque "
				+ "diam volutpat commodo sed egestas egestas fringilla phasellus faucibus scelerisque eleifend donec pretium vulputate sapien nec sagittis aliquam malesuada bibendum arcu vitae elementum "
				+ "curabitur vitae nunc sed velit dignissim sodales ut eu sem integer vitae justo eget magna fermentum iaculis eu non diam phasellus vestibulum lorem sed risus ultricies tristique nulla aliquet enim "
				+ "tortor at auctor urna nunc id cursus metus aliquam eleifend mi in nulla posuere sollicitudin aliquam ultrices sagittis orci a scelerisque purus semper eget duis at tellus at urna condimentum mattis "
				+ "pellentesque id nibh tortor id aliquet lectus proin nibh nisl condimentum id venenatis a condimentum vitae sapien pellentesque habitant morbi tristique senectus et netus et malesuada fames ac "
				+ "turpis egestas sed tempus urna et pharetra pharetra massa massa ultricies mi quis hendrerit dolor magna eget est lorem ipsum dolor sit amet consectetur adipiscing elit pellentesque habitant morbi "
				+ "tristique senectus et netus et malesuada fames ac turpis egestas integer eget aliquet nibh praesent tristique magna sit amet purus gravida quis blandit turpis cursus in hac habitasse platea dictumst "
				+ "quisque sagittis purus sit amet volutpat consequat mauris nunc congue nisi vitae suscipit tellus mauris a diam maecenas sed enim ut sem viverra aliquet eget sit amet tellus cras adipiscing enim eu "
				+ "turpis egestas pretium aenean pharetra magna ac placerat vestibulum lectus mauris ultrices eros in cursus turpis massa tincidunt dui ut ornare lectus sit amet est placerat in egestas erat imperdiet "
				+ "sed euismod nisi porta lorem mollis aliquam ut porttitor leo a diam sollicitudin tempor id eu nisl nunc mi ipsum faucibus vitae aliquet nec ullamcorper sit amet risus nullam eget felis eget nunc "
				+ "lobortis mattis aliquam faucibus purus in massa tempor nec feugiat nisl pretium fusce id velit ut tortor pretium viverra suspendisse potenti nullam ac tortor vitae purus faucibus ornare suspendisse "
				+ "sed nisi lacus sed viverra tellus in hac habitasse platea dictumst vestibulum rhoncus est pellentesque elit ullamcorper dignissim cras tincidunt lobortis feugiat vivamus at augue eget arcu dictum varius "
				+ "duis at consectetur lorem donec massa sapien faucibus et molestie ac feugiat sed lectus vestibulum mattis ullamcorper velit sed ullamcorper morbi tincidunt ornare massa eget egestas purus viverra "
				+ "accumsan in nisl nisi scelerisque eu ultrices vitae auctor eu augue ut lectus arcu bibendum at varius vel pharetra vel turpis nunc eget lorem dolor sed viverra ipsum nunc aliquet bibendum enim facilisis "
				+ "gravida neque convallis a cras semper auctor neque vitae tempus quam pellentesque nec nam aliquam sem et tortor consequat id porta nibh venenatis cras sed felis eget velit aliquet sagittis id consectetur "
				+ "purus ut faucibus pulvinar elementum integer enim neque volutpat ac tincidunt vitae semper quis");
		comment.setUserId(0);
		issue.addComment(comment);
		
		issueService.createOrUpdateIssue(issue);
		
		issue = (Issue)context.getBean("issue");

		title = "I'm bored";
		userDescription = "I created this ticket to tell whoever is sees this to have a wonderful day";
				
		issue.setAssignedTo(Department.HELP_DESK);
		issue.setDateSubmitted(new Date(System.currentTimeMillis() - (4 * 60 * 60 * 1000))); //4 hours old
		issue.setPriority(Priority.MINOR);
		issue.setStatus(Status.SUBMITTED);
		issue.setSubmittedBy(15);
		issue.setTitle(title);
		issue.setUserDescription(userDescription);
		
		comment = (Comment)context.getBean("comment");
		comment.setIssueId(issue);
		comment.setUserComment("Short comment");
		comment.setUserId(15);
		issue.addComment(comment);
		
		comment = (Comment)context.getBean("comment");
		comment.setIssueId(issue);
		comment.setUserComment("Medium sized comment that should probably spill over to a new line because I am writing out an issue just because oh well end of sentence.");
		comment.setUserId(0);
		issue.addComment(comment);
		
		comment = (Comment)context.getBean("comment");
		comment.setIssueId(issue);
		comment.setUserComment("Long comment lorem ipsum to follow purus non enim praesent elementum facilisis leo vel fringilla est ullamcorper "
				+ "eget nulla facilisi etiam dignissim diam quis enim lobortis scelerisque fermentum dui faucibus in ornare quam viverra orci sagittis eu volutpat odio facilisis mauris sit amet massa vitae "
				+ "tortor condimentum lacinia quis vel eros donec ac odio tempor orci dapibus ultrices in iaculis nunc sed augue lacus viverra vitae congue eu consequat ac felis donec et odio pellentesque "
				+ "diam volutpat commodo sed egestas egestas fringilla phasellus faucibus scelerisque eleifend donec pretium vulputate sapien nec sagittis aliquam malesuada bibendum arcu vitae elementum "
				+ "curabitur vitae nunc sed velit dignissim sodales ut eu sem integer vitae justo eget magna fermentum iaculis eu non diam phasellus vestibulum lorem sed risus ultricies tristique nulla aliquet enim "
				+ "tortor at auctor urna nunc id cursus metus aliquam eleifend mi in nulla posuere sollicitudin aliquam ultrices sagittis orci a scelerisque purus semper eget duis at tellus at urna condimentum mattis "
				+ "pellentesque id nibh tortor id aliquet lectus proin nibh nisl condimentum id venenatis a condimentum vitae sapien pellentesque habitant morbi tristique senectus et netus et malesuada fames ac "
				+ "turpis egestas sed tempus urna et pharetra pharetra massa massa ultricies mi quis hendrerit dolor magna eget est lorem ipsum dolor sit amet consectetur adipiscing elit pellentesque habitant morbi "
				+ "tristique senectus et netus et malesuada fames ac turpis egestas integer eget aliquet nibh praesent tristique magna sit amet purus gravida quis blandit turpis cursus in hac habitasse platea dictumst "
				+ "quisque sagittis purus sit amet volutpat consequat mauris nunc congue nisi vitae suscipit tellus mauris a diam maecenas sed enim ut sem viverra aliquet eget sit amet tellus cras adipiscing enim eu "
				+ "turpis egestas pretium aenean pharetra magna ac placerat vestibulum lectus mauris ultrices eros in cursus turpis massa tincidunt dui ut ornare lectus sit amet est placerat in egestas erat imperdiet "
				+ "sed euismod nisi porta lorem mollis aliquam ut porttitor leo a diam sollicitudin tempor id eu nisl nunc mi ipsum faucibus vitae aliquet nec ullamcorper sit amet risus nullam eget felis eget nunc "
				+ "lobortis mattis aliquam faucibus purus in massa tempor nec feugiat nisl pretium fusce id velit ut tortor pretium viverra suspendisse potenti nullam ac tortor vitae purus faucibus ornare suspendisse "
				+ "sed nisi lacus sed viverra tellus in hac habitasse platea dictumst vestibulum rhoncus est pellentesque elit ullamcorper dignissim cras tincidunt lobortis feugiat vivamus at augue eget arcu dictum varius "
				+ "duis at consectetur lorem donec massa sapien faucibus et molestie ac feugiat sed lectus vestibulum mattis ullamcorper velit sed ullamcorper morbi tincidunt ornare massa eget egestas purus viverra "
				+ "accumsan in nisl nisi scelerisque eu ultrices vitae auctor eu augue ut lectus arcu bibendum at varius vel pharetra vel turpis nunc eget lorem dolor sed viverra ipsum nunc aliquet bibendum enim facilisis "
				+ "gravida neque convallis a cras semper auctor neque vitae tempus quam pellentesque nec nam aliquam sem et tortor consequat id porta nibh venenatis cras sed felis eget velit aliquet sagittis id consectetur "
				+ "purus ut faucibus pulvinar elementum integer enim neque volutpat ac tincidunt vitae semper quis");
		comment.setUserId(0);
		issue.addComment(comment);
		
		issueService.createOrUpdateIssue(issue);
	}
}
