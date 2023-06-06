<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Login & Registration</title>
	<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
</head>
<body>
	<section class="w-50 mx-auto">
		<h1 class="text-info mt-5 mb-2 fw-bold">Welcome!</h1>
		<p class="mb-3">Join our growing community.</p>
	</section>
	<main class="w-50 mx-auto d-flex gap-5 justify-content-between">
		<form:form action="/register" method="post" modelAttribute="newUser" class="w-50 bg-light rounded p-3">
			<p class="fs-1 mb-5">Register</p>
			<div class="mb-3">
				<form:label path="username" class="form-label">Username</form:label>
				<form:input type="text" path="username" class="form-control" />
				<form:errors path="username" class="text-danger" />
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
			<input type="submit" value="Register" class="btn btn-info" />
		</form:form>
		<form:form action="/login" method="post" modelAttribute="newLogin" class="w-50">
			<p class="fs-1 mb-5">Log In</p>
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
			<input type="submit" value="Login" class="btn btn-info" />
		</form:form>
	</main>

</body>
</html>