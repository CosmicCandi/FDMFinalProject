<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>Internal Complaint Management System</title>
	<link href="<c:url value="src/main/webapp/resources/css/login.css" />" rel="stylesheet">
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

	<form method="POST" action="j_security_check">
		<label>Username:<input type="text" name="j_username" /></label><br />
		<label>Password:<input type="password" name="j_password" /></label><br />
		<input type="submit" value="Login!">
	</form>

	<footer class="content foot">
		<p>&copy; 2018 - POS Masters</p>
	</footer>
</body>
</html>