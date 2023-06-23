<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Pagination</title>
	<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
</head>
<body>
	
	<nav class="w-50 mx-auto my-5 d-flex justify-content-between align-items-center">
		<h1>Dojos and Ninjas</h1>
		<div class="d-flex flex-column gap-2">
			<a href="/dojos/new">+ New Dojo</a>
			<a href="/ninjas/new">+ New Ninja</a>
		</div>
	</nav>
	
	<main class="w-50 mx-auto">
		<table class="table">
			<thead>
				<tr>
					<th>Dojo</th>
					<th>Ninja</th>
					<th>Ninja Start Date</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="row" items="${ pagedList.content }">
					<tr>
						<td><c:out value="${ row.name }"/></td>
						<td><c:out value="${ row.firstName } ${ row.lastName }"/></td>
						<td><c:out value="${ row.createdAt }"/></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>	
		<div class="d-flex justify-content-end">
			<c:forEach begin="1" end="${ totalPages }" var="index">
				<a href="/pages/${ index }">index</a>
			</c:forEach>
		</div>
	</main>

</body>
</html>