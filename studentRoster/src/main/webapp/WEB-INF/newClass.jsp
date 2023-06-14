<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>New Class</title>
	<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
</head>
<body>

	<h1 class="text-center my-5">New Class</h1>
	
	<nav class="w-50 mx-auto d-flex flex-column gap-2 mb-4">
		<a href="/">Dashboard</a>
	</nav>
	
	<main class="w-50 mx-auto">
		<form:form action="/classes/create" method="post" modelAttribute="cls" class="bg-light rounded p-4">
			<div class="mb-3">
				<form:label path="name" class="form-label">Name</form:label>
				<form:input type="text" path="name" class="form-control" />
				<form:errors path="name" class="text-danger"/>
			</div>
			<input type="submit" value="Add" class="btn btn-primary"/>
		</form:form>
	</main>
	
</body>
</html>