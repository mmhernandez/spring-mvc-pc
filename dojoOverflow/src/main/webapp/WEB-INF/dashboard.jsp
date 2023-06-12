<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Questions Dashboard</title>
	<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
</head>
<body>

	<h1 class="w-50 mx-auto my-5">Questions Dashboard</h1>
	<table class="w-50 mx-auto table mb-5">
		<thead class="bg-light">
			<tr>
				<th>Question</th>
				<th>Tags</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="question" items="${ questions }">
				<tr>
					<td><a href="/questions/${ question.id }"><c:out value="${ question.text }"/></a></td>
					<td>
						<c:forEach var="tag" items="${ question.tags }">
							<c:out value="${ tag.subject }"/><c:if test="${ question.tags.indexOf(tag) < question.tags.size()-1 }" >,</c:if>
						</c:forEach>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<div class="w-50 mx-auto d-flex justify-content-end">
		<a href="/questions/new">New Question</a>
	</div>
</body>
</html>