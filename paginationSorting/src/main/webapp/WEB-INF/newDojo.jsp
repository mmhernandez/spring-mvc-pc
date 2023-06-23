<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>New Dojo</title>
	<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
</head>
<body>

	<nav class="w-50 mx-auto my-5 d-flex justify-content-between align-items-center">
		<h1>New Dojo</h1>
		<div class="d-flex flex-column gap-2">
			<a href="/">Home</a>
		</div>
	</nav>

	<main class="w-50 mx-auto">
		<form:form action="/dojos/new" method="post" modelAttribute="dojo">
			<div class="mb-3">
				<form:label path="name" class="form-label">Name</form:label>
				<form:input type="text" path="name" class="form-control" />
			</div>
			<input type="submit" value="Save" class="btn btn-primary" />
		</form:form>
	</main>
</body>
</html>