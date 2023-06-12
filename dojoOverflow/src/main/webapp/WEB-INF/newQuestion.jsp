<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>New Question</title>
	<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
</head>
<body>
	
	<h1 class="w-50 mt-5 mb-2 mx-auto">What is your question?</h1>
	<div class="w-50 mx-auto d-flex justify-content-start mb-5">
		<a href="/">Dashboard</a>
	</div>
	
	<form:form action="/questions/add" method="post" modelAttribute="question" class="w-50 mx-auto">
		<div class="mb-3">
			<form:label path="text" class="form-label">Question</form:label>
			<form:textarea path="text" cols="30" rows="3" class="form-control"></form:textarea>
			<form:errors path="text" class="text-danger" />
		</div>
		<div class="mb-3">
			<form:label path="tags" class="form-label">Tags <span class="fst-italic text-secondary">(separate tags with a comma)</span></form:label>
			<form:input type="text" path="tags" class="form-control" />
			<form:errors path="tags" class="text-danger" />
			<p class="text-danger">${ tagError }</p>
		</div>
		<input type="submit" value="Save" class="btn btn-dark"/>
	</form:form>
	
</body>
</html>