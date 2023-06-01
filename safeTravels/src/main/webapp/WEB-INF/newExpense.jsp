<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
    
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Safe Travels</title>
	<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
</head>
<body>

	<nav class="text-end mx-auto my-5 w-50">
		<a href="/" class="text-secondary">Back to Expenses</a>
	</nav>
	
	<main class="mx-auto w-50 p-4 bg-light rounded">
		<h1 class="mb-4">New Expense</h1>
		<form:form action="" class="mt-5" modelAttribute="expense">
			<div class="mb-3">
				<form:label path="name" class="form-label">Expense name</form:label>
				<form:input type="text" path="name" class="form-control" />
				<form:errors path="name" class="text-danger"/>
			</div>
			<div class="mb-3">
				<form:label path="vendor" class="form-label">Vendor</form:label>
				<form:input type="text" path="vendor" class="form-control" />
				<form:errors path="vendor" class="text-danger"/>
			</div>
			<div class="input-group mb-3 d-flex flex-column">
				<form:label path="amount" class="form-label">Amount</form:label>
				<div class="d-flex">
					<span class="input-group-text">$</span>
					<form:input type="text" path="amount" class="form-control" />
				</div>
				<form:errors path="amount" class="text-danger"/>
			</div>
			<div class="mb-3">
				<form:label path="description" class="form-label">Description</form:label>
				<form:input type="text" path="description" class="form-control" />
				<form:errors path="description" class="text-danger"/>
			</div>
			<input type="submit" value="Save" class="btn btn-success" />
		</form:form>
	</main>

</body>
</html>