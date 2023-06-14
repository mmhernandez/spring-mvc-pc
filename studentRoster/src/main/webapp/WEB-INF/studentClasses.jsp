<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title><c:out value="${ student.firstName }"/></title>
	<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
	<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>

	<h1 class="text-center my-5"><c:out value="${ student.firstName } ${ student.lastName }"/>'s Classes</h1>
	
	<nav class="w-50 mx-auto d-flex flex-column gap-2 mb-4">
		<a href="/">Dashboard</a>
	</nav>
	
	<main class="w-50 mx-auto">
		<form action="/classes" method="post" class="bg-dark rounded d-flex justify-content-between align-items-end mb-5">
			<input type="hidden" name="_method" value="put" />
			<input type="hidden" name="student" value="${ student.id }" />
			<input type="hidden" name="redirect" value="student" />
			<div class="w-75 p-3">
				<label for="cls" class="form-label text-light fw-bold fs-5">Sign Up for Classes</label>
				<select name="cls" class="form-select">
					<c:forEach var="cls" items="${ availableClasses }">
						<option value="${ cls.id }"><c:out value="${ cls.name }"/></option>
					</c:forEach>
				</select>
			</div>
			<input type="submit" class="btn btn-primary h-50 mx-auto mb-3" value="Sign up" />
		</form>
	
		<table class="table table-striped text-center">
			<thead class="bg-secondary text-light">
				<tr>
					<th>Class</th>
					<th>Action</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="cls" items="${ classes }">
					<tr>
						<td>
							<a href="/classes/${ cls.id }"><c:out value="${ cls.name }" /></a>
						</td>
						<td class="d-flex gap-2 justify-content-center">
					        <form action="/classes/${ cls.id }" method="post">
					        	<input type="hidden" name="_method" value="put" />
					        	<input type="hidden" name="studentId" value="${ student.id }" />
					        	<input type="submit" class="btn btn-link link-danger" value="Drop" />
					        </form>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</main>

</body>
</html>