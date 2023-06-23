<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>New Ninja</title>
	<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
</head>
<body>

	<nav class="w-50 mx-auto my-5 d-flex justify-content-between align-items-center">
		<h1>New Ninja</h1>
		<div class="d-flex flex-column gap-2">
			<a href="/">Home</a>
		</div>
	</nav>
	
	<main class="w-50 mx-auto">
		<form:form action="/ninjas/new" method="post" modelAttribute="ninja">
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
				<form:label path="dojo" class="form-label">Dojo</form:label>
				<form:select path="dojo" class="form-select">
					<c:forEach var="dojo" items="${ dojos }">
						<option value="${ dojo.id }">${ dojo.name }</option>
					</c:forEach>
				</form:select>
				<form:errors path="dojo" class="text-danger"/>
			</div>
			<input type="submit" value="Save" class="btn btn-primary" />
		</form:form>
	</main>

</body>
</html>