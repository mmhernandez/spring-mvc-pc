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
				<th>Role</th>
				<th>Action</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="user" items="${ users }">
				<tr>
					<td><c:out value="${ user.username }"/></td>
					<td><c:out value="${ user.email }"/></td>
					<td>
						<c:forEach var="role" items="${ user.roles }">						
							<c:choose>
								<c:when test="${ role.name == 'ROLE_SUPERADMIN' }">
									<span class="fw-bold text-info">Super Admin</span>
								</c:when>
								<c:when test="${ role.name == 'ROLE_ADMIN' }">
									<span class="fw-bold">Admin</span>
								</c:when>
								<c:otherwise>
									<span>User</span>
								</c:otherwise>
							</c:choose>
						</c:forEach>
					</td>
					<td>
						<c:forEach var="role" items="${ user.roles }">	
							<c:if test="${ role.name == 'ROLE_USER' }">
								<div class="d-flex gap-2 align-items-center">
									<form action="/user/${ user.id }" method="post">
										<input type="hidden" name="_method" value="put" />
										<input type="submit" value="make admin" class="btn btn-outline-info"/>
									</form>

									<a href="/user/delete/${ user.id }">
										<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-trash3 text-danger" viewBox="0 0 16 16">
										  <path d="M6.5 1h3a.5.5 0 0 1 .5.5v1H6v-1a.5.5 0 0 1 .5-.5ZM11 2.5v-1A1.5 1.5 0 0 0 9.5 0h-3A1.5 1.5 0 0 0 5 1.5v1H2.506a.58.58 0 0 0-.01 0H1.5a.5.5 0 0 0 0 1h.538l.853 10.66A2 2 0 0 0 4.885 16h6.23a2 2 0 0 0 1.994-1.84l.853-10.66h.538a.5.5 0 0 0 0-1h-.995a.59.59 0 0 0-.01 0H11Zm1.958 1-.846 10.58a1 1 0 0 1-.997.92h-6.23a1 1 0 0 1-.997-.92L3.042 3.5h9.916Zm-7.487 1a.5.5 0 0 1 .528.47l.5 8.5a.5.5 0 0 1-.998.06L5 5.03a.5.5 0 0 1 .47-.53Zm5.058 0a.5.5 0 0 1 .47.53l-.5 8.5a.5.5 0 1 1-.998-.06l.5-8.5a.5.5 0 0 1 .528-.47ZM8 4.5a.5.5 0 0 1 .5.5v8.5a.5.5 0 0 1-1 0V5a.5.5 0 0 1 .5-.5Z"/>
										</svg>
									</a>
								</div>
							</c:if>
						</c:forEach>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>