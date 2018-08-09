<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
	<title>Issues</title>
	<link href="<c:url value="/resources/css/icms.css" />"rel="stylesheet">
	<link href="<c:url value="/resources/css/issues.css" />"rel="stylesheet">
	<link href="<c:url value="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css"/>" rel="stylesheet">
</head>
<body>
	<header> 
	
	<section class="row"> 
	<a href="<c:url value="/" />" id="logo"> 
		<i class="fa fa-edge fa-3x" aria-hidden="true"></i>
	</a>
	<h1>Internal CMS</h1>

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
	<section>
	<p>These are your issues:</p>
	<section>
	<p>Issue ID</p>
	<p>Title</p>
	<p>Date Submitted</p>
	<p>Status</p>
	<p>Assigned To</p>
	<p>Priority</p>
	</section>

	<section> <c:forEach items="${issueList}" var="i">
		<a href="<c:url value="issueDetails" />/${i.issueId}" class="issueButtons">
			<section class="buttonSection">
				<p class="id">${i.issueId}</p>
				<p class="title">${i.title}</p>
				<p class="date">${i.dateSubmitted}</p>
				<p class="status">${i.status}</p>
				<p class="assignee">${i.assignedTo}</p>
				<p class="priority">${i.priority}</p>
			</section>
		</a>
	</c:forEach> 
	</section>
	<button onclick="location.href='<c:url value="newIssue" />'"
		type="button">
		<p>+ New Issue</p>
	</button>

	<button onclick="location.href='<c:url value="history" />'"
		type="button">
		<p>History</p>
	</button>
	</section>
	<footer class="content foot">
	<p>&copy; 2018 - POS Masters</p>
	</footer>
</body>
</html>