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
	
	<button onclick="location.href='<c:url value="newIssue" />'"
		type="button">
		<p>+ New Issue</p>
	</button>

	<input type="text" id="search" onkeyup="searchTable()" placeholder="Search...">

	<button onclick="location.href='<c:url value="history" />'"
		type="button">
		<p>History</p>
	</button>
	
	
	
	<div class="tableHeader">
		<table>
			<tr class="labels">
				<th id="id">Issue Id</th>
				<th id="title">Title</th>
				<th id="date">Date Submitted</th>
				<th id="status">Status</th>
				<th id="assignee">Assigned To</th>
				<th id="priority">Priority</th>
			</tr>
		</table>
	</div>
	<div class="table">
	<table id="issueTable">
	
	<c:forEach items="${issueList}" var="i">
		<tr onclick="details('<c:url value="issueDetails" />/${i.issueId}');" id="issueRow">
			<td>${i.issueId}</td>
			<td>${i.title}</td>
			<td>${i.dateSubmitted}</td>
			<td>${i.status}</td>
			<td>${i.assignedTo}</td>
			<td>${i.priority}</td>
		</tr>		
	</c:forEach>
	</table>
	</div>
	
	<script>
		function details(url) {
	    	document.location.href = url;
	    }
		
		function searchTable() {
		    var input, filter, found, table, tr, td, i, j;
		    input = document.getElementById("search");
		    filter = input.value.toUpperCase();
		    table = document.getElementById("issueTable");
		    tr = table.getElementsByTagName("tr");
		    for (i = 0; i < tr.length; i++) {
		        td = tr[i].getElementsByTagName("td");
		        for (j = 0; j < td.length; j++) {
		            if (td[j].innerHTML.toUpperCase().indexOf(filter) > -1) {
		                found = true;
		            }
		        }
		        if (found) {
		            tr[i].style.display = "";
		            found = false;
		        } else {
		            tr[i].style.display = "none";
		        }
		    }
		}
	</script>
	
	</section>
	<footer class="content" id="foot">
	<p>&copy; 2018 - POS Masters</p>
	</footer>
</body>
</html>