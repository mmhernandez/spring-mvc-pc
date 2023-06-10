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

	<header class="w-50 mx-auto my-5 d-flex justify-content-between">
		<h1>Add a book to the shelf!</h1>
		<div class="d-flex flex-column gap-4">
			<a href="/logout">logout</a>
			<a href="/books">Back to shelves</a>
		</div>
	</header>
	
	<main class="w-50 mx-auto">
		<form:form action="/books/add" method="post" modelAttribute="book">
			<input type="hidden" name="user" value="${ user.id }" />
			<div class="mb-3">
				<form:label path="title" class="form-label">Title</form:label>
				<form:input type="text" path="title" class="form-control" />
				<form:errors path="title" class="text-danger" />
			</div>
			<div class="mb-3">
				<form:label path="author" class="form-label">Author</form:label>
				<form:input type="text" path="author" class="form-control" />
				<form:errors path="author" class="text-danger" />
			</div>
			<div class="mb-3">
				<form:label path="thoughts" class="form-label">My thoughts</form:label>
				<textarea name="thoughts" cols="30" rows="5" class="form-control"></textarea>
				<form:errors path="thoughts" class="text-danger" />
			</div>
			<input type="submit" value="Save" class="btn btn-outline-success"/>
		</form:form>
	</main>
	
</body>
</html>