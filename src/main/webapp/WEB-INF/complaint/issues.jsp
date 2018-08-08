<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>Issues</title>
	<link href="<c:url value="src/main/webapp/resources/css/issues.css" />" rel="stylesheet">
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
	
	<p>These are your issues:</p>
	<section>
		<p>Issue ID</p>
		<p>Title</p>
		<p>Date Submitted</p>
		<p>Status</p>
		<p>Assigned To</p>
		<p>Priority</p>
	</section>
	
	<section>
		<c:forEach items="${issueList}" var="i"> 
         <div>
         	ID <c:out value="${i.issueId}" />
         	<c:out value="${i.title}" />
         	<c:out value="${i.dateSubmitted}" />
         	<c:out value="${i.status}" />
         	<c:out value="${i.assignedTo}" />
         	<c:out value="${i.priority}" />
         </div>
		</c:forEach>
	</section>
	<button onclick="location.href='<c:url value="newIssue" />'" type="button">
		<p>+ New Issue</p>
	</button>
	
	<button onclick="location.href='<c:url value="history" />'" type="button">
		<p>History</p>
	</button>
	
	<footer class="content foot">
		<p>&copy; 2018 - POS Masters</p>
	</footer>
</body>
</html>