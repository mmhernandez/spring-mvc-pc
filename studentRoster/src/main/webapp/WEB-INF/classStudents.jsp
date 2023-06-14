<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>${ cls.name }</title>
	<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
</head>
<body>

	<h1 class="text-center my-5">Students taking <c:out value="${ cls.name }"/></h1>
	
	<nav class="w-50 mx-auto d-flex flex-column gap-2 mb-4">
		<a href="/">Dashboard</a>
		<a href="/classes/all">Back to Classes</a>
	</nav>
	
		
	<main class="w-50 mx-auto">
		<form action="/classes" method="post" class="bg-dark rounded d-flex justify-content-between align-items-end mb-5">
			<input type="hidden" name="_method" value="put" />
			<input type="hidden" name="cls" value="${ cls.id }" />
			<input type="hidden" name="redirect" value="class" />
			<div class="w-75 p-3">
				<label for="student" class="form-label text-light fw-bold fs-5">Student Sign Up</label>
				<select name="student" class="form-select">
					<c:forEach var="student" items="${ availableStudents }">
						<option value="${ student.id }"><c:out value="${ student.firstName } ${ student.lastName }"/></option>
					</c:forEach>
				</select>
			</div>
			<input type="submit" class="btn btn-primary h-50 mx-auto mb-3" value="Sign up" />
		</form>
		<table class="table table-striped table-hover text-center">
			<thead class="bg-secondary text-light">
				<tr>
					<th >Name</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="student" items="${ classStudents }">
					<tr>
						<td><a href="/students/${ student.id }"><c:out value="${ student.firstName } ${ student.lastName }"/></a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</main>
	
</body>
</html>