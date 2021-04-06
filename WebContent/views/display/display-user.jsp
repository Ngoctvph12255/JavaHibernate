<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JSP Page</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
</head>
<body>

	<div class="container">
	
		<h2>List Users</h2>
		<!-- UserServlet?action=AddOrEdit -->
		<a href="/PT15302-UD/RegisterServlet" class="btn btn-primary">Add
			Users</a>
		<table class="table table-bordered">
			<thead>
			
				<tr>
					<th>Name</th>
					<th>Number</th>
					<th>Email</th>
					<th>Age</th>
					<th>Password</th>
					<th>Gender</th>
					<th>Action</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="user" items="${LIST_USERS}">
				<tr>
					<td>${user.getName()}</td>
					<td>${user.getNumber()}</td>
					<td>${user.getEmail()}</td>
					<td>${user.getAge()}</td>
					<td>${user.getPassword()}</td>
					<td>${Boolean.parseBoolean(user.getGender()) ? "Nam" : "Nu"}</td>
					<td><a class="btn btn-primary btn-sm"
						href="UserServlet?action=AddOrEdit&username=a3">Edit</a> | <a
						class="btn btn-danger btn-sm"
						href="UserServlet?action=Delete&username=a3">Delete</a></td>
				</tr>
				</c:forEach>
				
			</tbody>
		</table>
	</div>
</body>
</html>