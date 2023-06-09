<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Dashboard</title>
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
	<p class="fw-bold">Email: <span class="fw-normal"><c:out value="${ currentUser.email }"/></span></p>
	<p class="fw-bold">Sign Up Date: <span class="fw-normal"><fmt:formatDate value="${ currentUser.createdAt }"/></span></p>
	<p class="fw-bold">Last Login: <span class="fw-normal"><fmt:formatDate value="${ currentUser.lastLogin }"/></span></p>

</body>
</html>