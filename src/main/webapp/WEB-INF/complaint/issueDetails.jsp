<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
	<title>Issue Details</title>
	<link href="<c:url value="/resources/css/icms.css" />"rel="stylesheet">
	<link href="<c:url value="/resources/css/issueDetails.css" />"rel="stylesheet">
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
	<section class="issueInfo">
		<p>Issue ID:  ${issue.issueId}</p>
		<p>Title:  ${issue.title}</p>
		<p>Date Submitted:  ${issue.dateSubmitted}</p>
		<p>Status: ${issue.status}</p>
		<p>Assigned To:  ${issue.assignedTo}</p>
		<p>Priority:  ${issue.priority}</p>
	</section>
	
	<section class="submitterInfo">
		<p>Submitted by:  ${submitter.firstname} ${submitter.lastname}</p>
		<p>Email:  ${submitter.email}</p>
		<p>Department:  ${submitter.departmentId}</p>
	</section>
	
	<section class="commentInfo">
		<c:forEach items="${commentList}" var="i"> 
         	<c:out value="${i.comment}" />
         	<c:out value="${i.dateCreated}" />
         	<c:out value="${i.userId}" />
		</c:forEach>
	</section>
	
	<section class="buttonOptions">
		
	<button onclick="" type="button">Add Comment</button>
	<c:if test="${issue.status != 'CLOSED'}">
		<c:if test="${issue.status == 'RESOLVED'}">
			<button onclick="" type="button">Approve Resolution</button>
		</c:if>
	</c:if>
	
	<c:if test="${user.role == 'DEPARTMENT_ADMINISTRATOR'}">
		<c:if test="${issue.status != 'CLOSED'}">
			<button onclick="" type="button">Change Status</button>
			<button onclick="" type="button">Request Department Change</button>
			<c:if test="${issue.submittedBy != submitter.userId}">
				<button onclick="" type="button">Reject Complaint</button>
			</c:if>
		</c:if>
	</c:if>
	
	<c:if test="${user.role == 'GENERAL_ADMINISTRATOR'}">
		<c:if test="${issue.status != 'CLOSED'}">
			<button onclick="" type="button">Change Status</button>
			<button onclick="" type="button">Change Department</button>
			<c:if test="${issue.submittedBy != submitter.userId}">
				<button onclick="" type="button">Reject Complaint</button>
			</c:if>
		</c:if>
		
		<c:if test="${issue.status == 'CLOSED'}">
			<button onclick="" type="button">Reopen Complaint</button>
		</c:if>
	</c:if>
	
	<c:if test="${issue.status != 'CLOSED'}">
		<c:if test="${issue.submittedBy == submitter.userId}">
			<button onclick="" type="button">Cancel Complaint</button>
		</c:if>
	</c:if>
	
	
	</section>
	</section>
	<footer class="content foot">
		<p>&copy; 2018 - POS Masters</p>
	</footer>
</body>
</html>