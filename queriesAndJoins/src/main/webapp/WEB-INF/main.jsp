<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

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
						<td><fmt:formatNumber value="${ city[1] }"/></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</section>
	
	<section id="query4" class="w-75 mx-auto">
		<h2>Query 4</h2>
		<p>Countries with prominently spoken language</p>
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
				<c:forEach var="country" items="${ query4 }">
					<tr>
						<td><c:out value="${ country[0] }"/></td>
						<td><c:out value="${ country[1] }"/></td>
						<td><c:out value="${ country[2] }"/>%</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</section>
	
	<section id="query5" class="w-75 mx-auto">
		<h2>Query 5</h2>
		<p>Densely populated countries</p>
		<a href="#top">Back to top</a>
		<table class="mt-2 mb-5 table table-striped text-center">
			<thead class="fw-bold">
				<tr>
					<th>COUNTRY</th>
					<th>SURFACE AREA</th>
					<th>POPULATION</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="country" items="${ query5 }">
					<tr>
						<td><c:out value="${ country[0] }"/></td>
						<td><c:out value="${ country[1] }"/></td>
						<td><fmt:formatNumber value="${ country[2] }"/></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</section>
	
	<section id="query6" class="w-75 mx-auto">
		<h2>Query 6</h2>
		<p>High life expectancy with a surface area over 200 and under a constitutional monarcy</p>
		<a href="#top">Back to top</a>
		<table class="mt-2 mb-5 table table-striped text-center">
			<thead class="fw-bold">
				<tr>
					<th>COUNTRY</th>
					<th>SURFACE AREA</th>
					<th>POPULATION</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="country" items="${ query6 }">
					<tr>
						<td><c:out value="${ country[0] }"/></td>
						<td><fmt:formatNumber value="${ country[2] }"/></td>
						<td><c:out value="${ country[3] }"/></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</section>
	
	<section id="query7" class="w-75 mx-auto">
		<h2>Query 7</h2>
		<p>Cities within Buenos Aires Argentina with high population</p>
		<a href="#top">Back to top</a>
		<table class="mt-2 mb-5 table table-striped text-center">
			<thead class="fw-bold">
				<tr>
					<th>COUNTRY</th>
					<th>CITY</th>
					<th>DISTRICT</th>
					<th>POPULATION</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="city" items="${ query7 }">
					<tr>
						<td><c:out value="${ city[0] }"/></td>
						<td><c:out value="${ city[1] }"/></td>
						<td><c:out value="${ city[2] }"/></td>
						<td><fmt:formatNumber value="${ city[3] }"/></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</section>
	
	<section id="query8" class="w-75 mx-auto">
		<h2>Query 8</h2>
		<p>Count the number of countries per region</p>
		<a href="#top">Back to top</a>
		<table class="mt-2 mb-5 table table-striped text-center">
			<thead class="fw-bold">
				<tr>
					<th>REGION</th>
					<th>NUMBER OF COUNTRIES</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="region" items="${ query8 }">
					<tr>
						<td><c:out value="${ region[0] }"/></td>
						<td><c:out value="${ region[1] }"/></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</section>

</body>
</html>