<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Dorms</title>
	<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
</head>
<body>

	<h1 class="text-center my-5">Dorms</h1>
	
	<nav class="w-50 mx-auto d-flex flex-column gap-2 mb-4">
		<a href="/dorms/new">+ New Dorm</a>
		<a href="/students/new">+ New Student</a>
	</nav>
	
	<main class="w-50 mx-auto">
		<table class="table table-striped text-center">
			<thead class="bg-light">
				<tr>
					<th>Dorm</th>
					<th>Action</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="dorm" items="${ dorms }">
					<tr>
						<td><c:out value="${ dorm.name }" /></td>
						<td>
							<a href="/dorms/${ dorm.id }">See Students</a>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</main>

</body>
</html>