<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Log in</title>
	<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
</head>
<body class="w-50 mx-auto">

	<c:if test="${ logoutMessage != null }">
		<p class="text-info fw-bold"><c:out value="${ logoutMessage }"/></p>
	</c:if>
	<h1 class="mt-5">Log in below!</h1>
	<p>Don't have an account? Sign up <a href="/signup" class="text-info">here</a>.</p>
	
	<form action="/login" method="post" class="w-50">
		<c:if test="${ errorMessage != null }">
			<p class="text-danger"><c:out value="${ errorMessage }" /></p>
		</c:if>
		<div class="mb-3">
			<label for="email" class="form-label">Email</label>
			<input type="email" name="email" class="form-control" />
		</div>
		<div class="mb-3">
			<label for="password" class="form-label">Password</label>
			<input type="password" name="password" class="form-control" />
		</div>
		<input type="hidden" name="${ _csrf.parameterName }" value="${ _csrf.token }" />
		<input type="submit" value="Log in" class="btn btn-info" />
	</form>

</body>
</html>