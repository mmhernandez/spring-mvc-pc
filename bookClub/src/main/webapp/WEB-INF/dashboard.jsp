<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Book Club - Read Share</title>
	<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
</head>
<body>

	<header class="w-50 mx-auto my-5 d-flex justify-content-between">
		<div>
			<h1>Welcome <c:out value="${ user.name }" /></h1>
			<p>Here are the books from everyone's shelves:</p>
		</div>
		<div class="d-flex flex-column gap-4">
			<a href="/logout">logout</a>
			<a href="/books/add">+ Add book!</a>
		</div>
	</header>

	<main class="w-50 mx-auto">
		<table class="table">
			<thead>
				<tr>
					<th>ID</th>
					<th>Title</th>
					<th>Author Name</th>
					<th>Posted By</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="book" items="${ books }">
					<tr>
						<td><c:out value="${ book.id }" /></td>
						<td>
							<a href="/books/${ book.id }"><c:out value="${ book.title }" /></a>
						</td>
						<td><c:out value="${ book.author }" /></td>
						<td><c:out value="${ book.user.name }" /></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</main>
	
</body>
</html>