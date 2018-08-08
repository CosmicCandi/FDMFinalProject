<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>Issue Details</title>
	<link href="<c:url value="src/main/webapp/resources/css/issueDetails.css" />" rel="stylesheet">
	<link  href="<c:url value="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css"/>" rel="stylesheet">
</head>
<body>
	<header>
		<section class="row">
			<a href="<c:url value="/" />" id="logo">
				<i class="fa fa-edge fa-3x" aria-hidden="true"></i>
			</a>
			<h1>Company Internal Complaint Management System</h1>
		</section>
	</header>
	
	<section>
		<p>Issue ID:  ${issue.issueId}</p>
		<p>Title:  ${issue.title}</p>
		<p>Date Submitted:  ${issue.dateSubmitted}</p>
		<p>Status: ${issue.status}</p>
		<p>Assigned To:  ${issue.assignedTo}</p>
		<p>Priority:  ${issue.priority}</p>
	</section>
	
	<section>
		<p>Submitted by:  ${submitter.firstname} ${submitter.lastname}</p>
		<p>Email:  ${submitter.email}</p>
		<p>Department:  ${submitter.departmentId}</p>
	</section>
	
	<section>
		<c:forEach items="${commentList}" var="i"> 
         	<c:out value="${i.comment}" />
         	<c:out value="${i.dateCreated}" />
         	<c:out value="${i.userId}" />
		</c:forEach>
	</section>
	
	<section>
		
	<button onclick="#" type="button">Add Comment</button>
	
	<c:if test="${user.role == 'GENERAL_ADMINISTRATOR'}">
		<button onclick="#" type="button">Reject Complaint</button>
		<button onclick="#" type="button">Change Status</button>
		<button onclick="#" type="button">Change Department</button>
	</c:if>
	
	</section>
	
	<footer class="content foot">
		<p>&copy; 2018 - POS Masters</p>
	</footer>
</body>
</html>