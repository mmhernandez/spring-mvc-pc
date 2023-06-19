<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Admin Dashboard</title>
	<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
</head>
<body class="w-50 mx-auto">

	<div class="d-flex justify-content-between">
		<h1 class="mt-5">Welcome <c:out value="${ currentUser.username }"/>!</h1>
		<form action="/logout" method="post" >
	        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
	        <input type="submit" value="logout" class="btn btn-link link-info" />
	    </form>
	</div>
	<table class="table my-5">
		<thead>
			<tr>
				<th>Username</th>
				<th>Email</th>
				<th>Action</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="user" items="${ users }">
				<tr>
					<td><c:out value="${ user.username }"/></td>
					<td><c:out value="${ user.email }"/></td>
					<td>
						<c:if test=" ${ user.roles.contains('ADMIN') }">
							<a href="/test">admintest</a>
						</c:if>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>