<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
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
	
	<nav class="w-50 mx-auto d-flex justify-content-between align-items-end gap-2 mb-4">
		<div class="d-flex flex-column gap-2">
			<a href="/dorms/new">+ New Dorm</a>
			<a href="/students/new">+ New Student</a>
			<a href="/classes/new">+ New Class</a>
		</div>
		<div class="d-flex flex-column gap-2">
			<a href="#">All Students</a>
			<a href="/classes/all">All Classes</a>
		</div>
	</nav>
	
	<main class="w-50 mx-auto">
		<table class="table table-striped table-hover text-center">
			<thead class="bg-secondary text-light">
				<tr>
					<th>Dorm</th>
					<th># Students</th>
					<th>Action</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="dorm" items="${ dorms }">
					<tr>
						<td><c:out value="${ dorm.name }" /></td>
						<td><c:out value="${ students.get(dorm.id) }" /></td>
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