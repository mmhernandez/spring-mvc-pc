<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Queries and Joins</title>
	<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
</head>
<body>

	<nav class="d-flex justify-content-center gap-2 my-5" id="top">
		<a href="#query1">Query 1</a>
		<p>|</p>
		<a href="#query2">Query 2</a>
		<p>|</p>
		<a href="#query3">Query 3</a>
		<p>|</p>
		<a href="#query4">Query 4</a>
		<p>|</p>
		<a href="#query5">Query 5</a>
		<p>|</p>
		<a href="#query6">Query 6</a>
		<p>|</p>
		<a href="#query7">Query 7</a>
		<p>|</p>
		<a href="#query8">Query 8</a>
	</nav>
	
	<section id="query1" class="w-75 mx-auto">
		<h2>Query 1</h2>
		<p>Countries that speak Slovene</p>
		<a href="#top">Back to top</a>
		<table class="mt-2 mb-5 table table-striped text-center">
			<thead class="fw-bold">
				<tr>
					<th>COUNTRY</th>
					<th>LANGUAGE</th>
					<th>PERCENTAGE</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="country" items="${ query1 }">
					<tr>
						<td><c:out value="${ country[0] }"/></td>
						<td><c:out value="${ country[1] }"/></td>
						<td><c:out value="${ country[2] }"/>%</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</section>
	
	<section id="query2" class="w-75 mx-auto">
		<h2>Query 2</h2>
		<p>Total number of cities in each country</p>
		<a href="#top">Back to top</a>
		<table class="mt-2 mb-5 table table-striped text-center">
			<thead class="fw-bold">
				<tr>
					<th class="w-50">COUNTRY</th>
					<th class="w-50">CITY COUNT</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="country" items="${ query2 }">
					<tr>
						<td><c:out value="${ country[0] }"/></td>
						<td><c:out value="${ country[1] }"/></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</section>
	
	<section id="query3" class="w-75 mx-auto">
		<h2>Query 3</h2>
		<p>Cities in Mexico with a population over 500,000</p>
		<a href="#top">Back to top</a>
		<table class="mt-2 mb-5 table table-striped text-center">
			<thead class="fw-bold">
				<tr>
					<th>City</th>
					<th>Population</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="city" items="${ query3 }">
					<tr>
						<td><c:out value="${ city[0] }"/></td>
						<td><c:out value="${ city[1] }"/></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</section>
	
	<%-- <section id="query3" class="w-75 mx-auto">
		<h2>Query 3</h2>
		<p>...</p>
		<a href="#top">Back to top</a>
		<table class="mt-2 mb-5 table table-striped text-center">
			<thead class="fw-bold">
				<tr>
					<th></th>
					<th></th>
					<th></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="" items="">
					<tr>
						<td></td>
						<td></td>
						<td></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</section> --%>

</body>
</html>