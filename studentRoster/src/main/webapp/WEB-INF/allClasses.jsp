<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>All Classes</title>
	<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
</head>
<body>

	<h1 class="text-center my-5">All Classes</h1>
	
	<nav class="w-50 mx-auto d-flex flex-column gap-2 mb-4">
		<a href="/">Dashboard</a>
		<a href="/classes/new">+ New Class</a>
	</nav>
	
	<main class="w-50 mx-auto">
		<table class="table table-striped table-hover text-center">
			<thead class="bg-secondary text-light">
				<tr>
					<th >Class</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="cls" items="${ classes }">
					<tr>
						<td><a href="/classes/${ cls.id }"><c:out value="${ cls.name }"/></a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</main>
	
</body>
</html>