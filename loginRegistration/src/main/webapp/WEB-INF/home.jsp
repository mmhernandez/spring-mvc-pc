<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Dashboard</title>
	<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
</head>
<body>

	<section class="w-75 mx-auto mt-5">
		<h1>Welcome <c:out value="${ user.firstName }" /></h1>
		<p>This is your dashboard. Nothing to see here yet.</p>
		<a href="/logout">logout</a>
	</section>

</body>
</html>