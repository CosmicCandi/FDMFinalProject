<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
	<title>New Issue</title>
	<link href="<c:url value="/resources/css/icms.css" />" rel="stylesheet">
	<link href="<c:url value="/resources/css/newIssue.css" />" rel="stylesheet">
	<link  href="<c:url value="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css"/>" rel="stylesheet">
</head>
<body>

	<header>
		<section class="row">
			<a href="<c:url value="/" />" id="logo">
				<i class="fa fa-edge fa-3x" aria-hidden="true"></i>
			</a>
			<h1>Internal CMS</h1>
		</section>
		
		<div class="dropdown">
		<button onclick="toggle()" class="userButton">
			<i class="fa fa-user fa-3x" aria-hidden="true"></i>
		</button>
		<div id="dropdownContent" class="dropdown-content">
			<p>${user.role.toString()}</p> 
			<a href="<c:url value="logout" />">Logout</a>
		</div>
	</div>
	</section> 
	
	<script>
		function toggle() {
    		document.getElementById("dropdownContent").classList.toggle("show");
		}


		window.onclick = function(event) {
  			if (!event.target.matches('.userButton')) {
				var dropdowns = document.getElementsByClassName("dropdown-content");
    			var i;
    			for (i = 0; i < dropdowns.length; i++) {
      				var openDropdown = dropdowns[i];
      				if (openDropdown.classList.contains('show')) {
        				openDropdown.classList.remove('show');
      				}
    			}
  			}
		}
	</script>
	</header>

	<section class="content">
	<sf:form action="/" method="POST" id="newIssueForm" modelAttribute="newIssue">
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
	</section>
</body>
</html>