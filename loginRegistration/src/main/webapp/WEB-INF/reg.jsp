<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Registration</title>
	<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
</head>
<body>

	<section class="w-50 mx-auto mt-5 d-flex justify-content-between align-items-center">
		<div>
			<h1 class="fw-bold text-warning">Welcome!</h1>
			<p>Join our growing community.</p>
		</div>
		<div class="text-end">
			<p>Already have an account?</p>
			<a href="/login" class="btn btn-outline-primary">Log in</a>
		</div>
	</section>
	
	<main class="w-50 mx-auto">
		<form:form action="/register" method="post" modelAttribute="newUser" class="my-2 bg-dark text-light rounded shadow">
			<p class="fs-2 text-center text-warning pt-2 fw-bold">Register</p>
			<table class="w-100">
				<tr>
					<th class="w-50 border border-light"><form:label path="firstName" class="form-label ps-3">First Name</form:label></th>
					<td class="border border-light">
						<form:input type="text" path="firstName" class="form-control my-3 mx-auto w-75" />
						<form:errors path="firstName" class="text-danger text-center ps-5" />	
					</td>
				</tr>
				<tr>
					<th class="w-50 border border-light"><form:label path="lastName" class="form-label ps-3">Last Name</form:label></th>
					<td class="border border-light">
						<form:input type="text" path="lastName" class="form-control my-3 mx-auto w-75" />
						<form:errors path="lastName" class="text-danger ps-5" />
					</td>
				</tr>
				<tr>
					<th class="w-50 border border-light"><form:label path="birthday" class="form-label ps-3">Birthday</form:label></th>
					<td class="border border-light">
						<form:input type="date" path="birthday" class="form-control my-3 mx-auto w-75" />
						<form:errors path="birthday" class="text-danger ps-5" />
					</td>
				</tr>
				<tr>
					<th class="w-50 border border-light"><form:label path="maritalStatus" class="form-label ps-3">Marital Status</form:label></th>
					<td class="border border-light">
						<form:select path="maritalStatus" class="form-select my-3 mx-auto w-75">
							<option value="single">Single</option>
							<option value="married">Married</option>
							<option value="divorced">Divorced</option>
							<option value="widowed">Widowed</option>
						</form:select>
						<form:errors path="maritalStatus" class="text-danger ps-5" />
					</td>
				</tr>
				<tr>
					<th class="w-50 border border-light"><label path="numPets" class="form-label ps-3">Number of Pets</label></th>
					<td class="my-3 d-flex flex-column gap-2 w-75 mx-auto">
						<div class="d-flex gap-1"><form:radiobutton path="numPets" value="0" label="None" class="form-check-input" /></div>
						<div class="d-flex gap-1"><form:radiobutton path="numPets" value="1" label="One" class="form-check-input" /></div>
						<div class="d-flex gap-1"><form:radiobutton path="numPets" value="2" label="Two" class="form-check-input" /></div>
						<div class="d-flex gap-1"><form:radiobutton path="numPets" value="3" label="Three or more" class="form-check-input" /></div>
						<form:errors path="numPets" class="text-danger" />
					</td>
				</tr>
				<tr>
					<th class="w-50 border border-light"><form:label path="email" class="form-label ps-3">Email</form:label></th>
					<td class="border border-light">
						<form:input type="email" path="email" class="form-control my-3 mx-auto w-75" />
						<form:errors path="email" class="text-danger ps-5" />
					</td>
				</tr>
				<tr>
					<th class="w-50 border border-light"><form:label path="password" class="form-label ps-3">Password</form:label></th>
					<td class="border border-light">
						<form:input type="password" path="password" class="form-control my-3 mx-auto w-75" />
						<form:errors path="password" class="text-danger ps-5" />
					</td>
				</tr>
				<tr>
					<th class="w-50 border border-light"><form:label path="confirmPassword" class="form-label ps-3">Confirm Password</form:label></th>
					<td class="border border-light">
						<form:input type="password" path="confirmPassword" class="form-control my-3 mx-auto w-75" />
						<form:errors path="confirmPassword" class="text-danger ps-5" />
					</td>
				</tr>
			</table>
			<div class="border border-light py-2 ps-3">			
				<div class="d-flex gap-1">
					<form:checkbox path="agreeToTerms" label="" class="form-check-input" /> 
					<form:label path="agreeToTerms" class="form-label">
						I have read the <a href="http://google.com" target="_blank" class="link-warning">terms of service</a>
					</form:label>
				</div>
				<form:errors path="agreeToTerms" class="text-danger" />
			</div>
			<div class="d-flex justify-content-center border border-light py-2">
				<input type="submit" class="btn btn-warning" value="Register" />
			</div>
		</form:form>
	</main>

</body>
</html>