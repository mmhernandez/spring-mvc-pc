<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Question</title>
	<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
</head>
<body>

	<h1 class="w-50 mt-5 mb-2 mx-auto"><c:out value="${ question.text }" /></h1>
	<div class="w-50 mx-auto d-flex justify-content-start mb-5">
		<a href="/">Dashboard</a>
	</div>

	<div class="w-50 mx-auto my-4 d-flex gap-3">
		<h3>Tags:</h3>
		<c:forEach var="tag" items="${ question.tags }">
			<button class="btn btn-secondary" disabled>${ tag.subject }</button>
		</c:forEach>
	</div>
	
	<main class="w-50 mx-auto my-4 d-flex justify-content-between">
		<div class="w-50">
			<h3>Answers:</h3>
			<ul>
				<c:forEach var="answer" items="${ question.answers }">
					<li><c:out value="${ answer.text }" /></li>
				</c:forEach>
			</ul>
		</div>
		<div class="w-50">
			<h3>Add your answer:</h3>
			<form:form action="/answers/add" method="post" modelAttribute="answer">
				<div class="d-flex flex-column">
					<input type="hidden" name="questionId" value="${ question.id }"/>
					<form:label path="text" class="form-label">Answer:</form:label>
					<form:textarea path="text" class="form-control" cols="30" rows="4"></form:textarea>
					<form:errors path="text" class="text-danger" />
				</div>
				<input type="submit" class="btn btn-dark mt-2" value="Add" />
			</form:form>
		</div>
	</main>
</body>
</html>