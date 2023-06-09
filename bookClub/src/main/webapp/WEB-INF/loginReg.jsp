<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Book Club - Read Share</title>
	<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
</head>
<body>
	
	<header class="w-50 mx-auto my-5">
		<h1>Book Club</h1>
		<p>A place for friends to share thoughts on books.</p>
	</header>
	<main class="w-50 mx-auto d-flex justify-content-between gap-5">
		<form:form action="/signup" method="post" modelAttribute="newUser" class="w-50 bg-dark rounded text-light p-3">
			<p class="fs-2 mb-4 text-primary">Sign Up</p>
			<div class="mb-3">
				<form:label path="name" class="form-label">Name</form:label>
				<form:input type="text" path="name" class="form-control" />
				<form:errors path="name" class="text-danger" />
			</div>
			<div class="mb-3">
				<form:label path="email" class="form-label">Email</form:label>
				<form:input type="email" path="email" class="form-control" />
				<form:errors path="email" class="text-danger" />
			</div>
			<div class="mb-3">
				<form:label path="password" class="form-label">Password</form:label>
				<form:input type="password" path="password" class="form-control" />
				<form:errors path="password" class="text-danger" />
			</div>
			<div class="mb-3">
				<form:label path="confirmPassword" class="form-label">Confirm Password</form:label>
				<form:input type="password" path="confirmPassword" class="form-control" />
				<form:errors path="confirmPassword" class="text-danger" />
			</div>
			<input type="submit" value="Sign up" class="btn btn-outline-primary" />
		</form:form>
		<form:form action="/login" method="post" modelAttribute="newLogin" class="w-50">
			<p class="fs-2 mb-4 text-warning">Log In</p>
			<div class="mb-3">
				<form:label path="email" class="form-label">Email</form:label>
				<form:input type="email" path="email" class="form-control" />
				<form:errors path="email" class="text-danger" />
			</div>
			<div class="mb-3">
				<form:label path="password" class="form-label">Password</form:label>
				<form:input type="password" path="password" class="form-control" />
				<form:errors path="password" class="text-danger" />
			</div>
			<input type="submit" value="Log in" class="btn btn-outline-warning" />
		</form:form>
	</main>

</body>
</html>