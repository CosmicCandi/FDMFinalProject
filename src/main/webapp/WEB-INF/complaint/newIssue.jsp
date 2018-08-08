<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>New Issue</title>
	<link href="<c:url value="src/main/webapp/resources/css/newIssue.css" />" rel="stylesheet">
	<link  href="<c:url value="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css"/>" rel="stylesheet">
</head>
<body>

	<sf:form action="/" method="POST" id="newIssueForm" modelAttribute="issue">
		<sf:label path="assignedTo">Actionable Department</sf:label>
		<sf:select path="assignedTo">
        	<sf:option value = "NONE" label = "Select"/>
        	<sf:options items = "${departmentList}" />
        </sf:select>
		<sf:label path="title">Issue Title</sf:label>
		<sf:input type="text" path="title" /><br />
		<!-- <sf:label path="userDescription">Description</sf:label>
		<sf:input type="text" path="userDescription" /><br /> -->
	</sf:form>
	<label path="userDescription" form="newIssueForm">Description</label>
	<textarea rows="4" cols="50" path="userDescription" form="newIssueForm"></textarea> 

</body>
</html>