<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>New Student</title>
	<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
</head>
<body>

	<h1 class="text-center my-5">New Student</h1>
	
	<nav class="w-50 mx-auto d-flex flex-column gap-2 mb-4">
		<a href="/">Dashboard</a>
	</nav>
	
	<main class="w-50 mx-auto">
		<form:form action="/students/create" method="post" modelAttribute="student" class="bg-light rounded p-4">
			<div class="mb-3">
				<form:label path="firstName" class="form-label">First Name</form:label>
				<form:input type="text" path="firstName" class="form-control" />
				<form:errors path="firstName" class="text-danger"/>
			</div>
			<div class="mb-3">
				<form:label path="lastName" class="form-label">Last Name</form:label>
				<form:input type="text" path="lastName" class="form-control" />
				<form:errors path="lastName" class="text-danger"/>
			</div>
			<div class="mb-3">
				<form:label path="dorm" class="form-label">Select Dorm</form:label>
				<form:select path="dorm" class="form-select">
					<c:forEach var="dorm" items="${ dorms }">
						<option value="${ dorm.id }">${ dorm.name }</option>
					</c:forEach>
				</form:select>
				<form:errors path="dorm" class="text-danger"/>
			</div>
			<input type="submit" value="Add" class="btn btn-primary"/>
		</form:form>
	</main>

</body>
</html>