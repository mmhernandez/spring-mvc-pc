<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Sign Up</title>
	<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
</head>
<body class="w-50 mx-auto">

	<h1 class="mt-5">Sign up for an account!</h1>
	<p>Already have an account? Log in <a href="/login" class="text-info">here</a>.</p>
	
	<form:form action="/signup" method="post" modelAttribute="user" class="bg-dark rounded p-4 text-light">
		<div class="d-flex gap-4">
			<div class="mb-3 w-50">
				<form:label path="username" class="form-label">Username</form:label>
				<form:input type="text" path="username" class="form-control" />
				<form:errors path="username" class="text-danger" />
			</div>
			<div class="mb-3 w-50">
				<form:label path="email" class="form-label">Email</form:label>
				<form:input type="email" path="email" class="form-control" />
				<form:errors path="email" class="text-danger" />
			</div>
		</div>
		<div class="d-flex gap-4">
			<div class="mb-3 w-50">
				<form:label path="password" class="form-label">Password</form:label>
				<form:input type="password" path="password" class="form-control" />
				<form:errors path="password" class="text-danger" />
			</div>
			<div class="mb-3 w-50">
				<form:label path="confirmPassword" class="form-label">Confirm Password</form:label>
				<form:input type="password" path="confirmPassword" class="form-control" />
				<form:errors path="confirmPassword" class="text-danger" />
			</div>
		</div>
		<input type="submit" value="Sign up" class="btn btn-info" />
	</form:form>
	
</body>
</html>