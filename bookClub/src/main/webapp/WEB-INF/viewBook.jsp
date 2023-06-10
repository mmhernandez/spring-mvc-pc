<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Insert title here</title>
	<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
</head>
<body>

	<header class="w-50 mx-auto my-5 d-flex justify-content-between">
		<h1><c:out value="${ book.title }" /></h1>
		<div class="d-flex flex-column gap-4">
			<a href="/logout">logout</a>
			<a href="/books">Back to shelves</a>
		</div>
	</header>
	
	<main class="w-50 mx-auto">
		<c:if test="${ user.id != book.user.id }">
			<h3>
				<span class="text-primary"><c:out value="${ book.user.name }"/></span>
				read
				<span class="fw-bold"><c:out value="${ book.title }"/></span>
				by
				<span class="text-success"><c:out value="${ book.author }"/></span>
			</h3>
			<p class="mt-5">Here are <c:out value="${ book.user.name }"/>'s thoughts:</p>
			<p class="mt-4 p-4 border-top border-bottom border-4 fst-italic">
				<c:out value="${ book.thoughts }"/>
			</p>
		</c:if>
		<c:if test="${ user.id == book.user.id }">		
			<h3>
				You read
				<span class="fw-bold"><c:out value="${ book.title }"/></span>
				by
				<span class="text-success"><c:out value="${ book.author }"/></span>
			</h3>
			<p class="mt-5">Here are your thoughts:</p>
			<p class="mt-4 p-4 border-top border-bottom border-4 fst-italic">
				<c:out value="${ book.thoughts }"/>
			</p>
		</c:if>
		<div class="d-flex justify-content-end gap-2">
			<c:if test="${ user.id == book.user.id }">
				<a href="/books/edit/${ book.id }" class="btn btn-outline-warning">Edit</a>
				<form action="/books/${ book.id }" method="post">
					<input type="hidden" name="_method" value="delete" />
					<input type="submit" value="Delete" class="btn btn-outline-danger"/>
				</form>
			</c:if>
		</div>
	</main>
		
</body>
</html>