<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Login</title>
	<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
</head>
<body>

	<section class="w-50 mx-auto mt-5 d-flex justify-content-between align-items-center">
		<div>
			<h1 class="fw-bold text-primary">Welcome back!</h1>
			<p>Glad to see you again.</p>
		</div>
		<div class="text-end">
			<p>Don't have an account?</p>
			<a href="/register" class="btn btn-outline-warning">Register</a>
		</div>
	</section>
	
	<main class="w-50 mx-auto">
		<form:form action="/login" method="post" modelAttribute="newLogin" class="my-2 bg-dark text-light rounded shadow">
			<p class="fs-2 text-center text-primary pt-2 fw-bold">Login</p>
			<table class="w-100">
				<tr>
					<th class="w-50 border border-light"><form:label path="email" class="form-label ps-3">Email</form:label></th>
					<td class="border border-light"><form:input type="email" path="email" class="form-control my-3 mx-auto w-75" /></td>
				</tr>
				<tr>
					<th class="w-50 border border-light"><form:label path="password" class="form-label ps-3">Password</form:label></th>
					<td class="border border-light"><form:input type="password" path="password" class="form-control my-3 mx-auto w-75" /></td>
				</tr>
			</table>
			<div class="d-flex justify-content-center border border-light py-2">
				<input type="submit" class="btn btn-primary" value="login" />
			</div>
		</form:form>
	</main>

</body>
</html>