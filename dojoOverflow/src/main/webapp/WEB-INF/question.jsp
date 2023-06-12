<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Question</title>
	<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
</head>
<body>

	<h1 class="w-50 mt-5 mb-2 mx-auto"><c:out value="${ question.text }" /></h1>
	<div class="w-50 mx-auto d-flex justify-content-start mb-5">
		<a href="/">Dashboard</a>
	</div>

	<div class="w-50 mx-auto my-4 d-flex gap-3">
		<h3>Tags:</h3>
		
	</div>
</body>
</html>