<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title><c:out value="${ dorm.name }"/></title>
	<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
	<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>

	<h1 class="text-center my-5"><c:out value="${ dorm.name }"/> Students</h1>
	
	<nav class="w-50 mx-auto d-flex flex-column gap-2 mb-4">
		<a href="/">Dashboard</a>
	</nav>
	
	<main class="w-50 mx-auto">
	
	
		<table class="table table-striped text-center">
			<thead class="bg-light">
				<tr>
					<th>Student</th>
					<th>Action</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="student" items="${ dorm.students }">
					<tr>
						<td><c:out value="${ student.firstName } ${ student.lastName }" /></td>
						<td class="d-flex gap-2 justify-content-center">
							<!-- Reassign Button trigger modal -->
							<button type="button" class="btn btn-outline-primary" data-bs-toggle="modal" data-bs-target="#reassignModal${ student.id }">
								Reassign
							</button>
							<!-- Modal for Reassign Button -->
							<div class="modal fade" id="reassignModal${ student.id }" tabindex="-1" aria-labelledby="#reassignModalLabel" aria-hidden="true">
								<div class="modal-dialog">
									<div class="modal-content">
										<div class="modal-header">
								        <h1 class="modal-title fs-5" id="exampleModalLabel">Reassign Dorm</h1>
								        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
								        </div>
							        	<form:form action="/students" method="post" modelAttribute="student">
							        		<input type="hidden" name="_method" value="put" />
									        <div class="modal-body text-start">
								        		<div class="mb-3">
													<p>Name: <span class="fw-bold"><c:out value="${ student.firstName } ${ student.lastName }" /></span></p>
													<form:input type="hidden" path="id" value="${ student.id }" />
													<form:input type="hidden" path="firstName" value="${ student.firstName }" />
													<form:input type="hidden" path="lastName" value="${ student.lastName }" />
												</div>
								        		<div class="mb-3">
													<p>Current Dorm: <span class="fw-bold"><c:out value="${ student.dorm.name }" /></span></p>
													<input type="hidden" name="currentDorm" value="${ student.dorm.id }" />
												</div>
									        	<div class="mb-3">
													<form:label path="dorm" class="form-label">New Dorm</form:label>
													<form:select path="dorm" class="form-select">
														<c:forEach var="eachDorm" items="${ dorms }">
															<option value="${ eachDorm.id }">${ eachDorm.name }</option>
														</c:forEach>
													</form:select>
												</div>
								        	</div>
								        	<div class="modal-footer">
								        		<button type="button" class="btn btn-outline-secondary" data-bs-dismiss="modal">Cancel</button>
										        <input type="submit" class="btn btn-primary" value="Save"/>
									        </div>
							        	</form:form>
							        </div>
						        </div>
					        </div>
					        <form action="/students/${ student.id }" method="post">
					        	<input type="hidden" name="_method" value="delete" />
					        	<input type="submit" class="btn btn-outline-danger" value="Remove" />
					        </form>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</main>

</body>
</html>