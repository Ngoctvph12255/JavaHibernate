<%@page import="java.io.Console"%>
<%@page
	import="javax.security.auth.message.callback.PrivateKeyCallback.Request"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Management Users</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl"
	crossorigin="anonymous">


</head>

<body>
	<div class="col-8 offset-2">

		<div class="mt-5 row">

			<div class="col-6">

				<a href="/PT15302-UD/RegisterServlet" class="btn btn-success">Thêm
					mới</a>

			</div>

			<div class="col-4"></div>

			<div class="col-2 d-flex justify-content-end">
			
				

				<select class="form-select" name="perpage1">

					<option   value="5"  >5</option>

					<option  selected value="10">10</option>

					<option value="20">20</option>

					<option value="50">50</option>

				</select>

			</div>

		</div>


		<div class="mt-5 table-responsive">

			<table class="table table-striped">

				<thead>

					<tr>
						<th>Id</th>
						<th>Name</th>
						<th>Number</th>
						<th>Email</th>
						<th>Age</th>
						<th>Password</th>
						<th>Gender</th>
						<th>Role</th>
						<th>Action</th>


					</tr>

				</thead>

				<tbody>
					<c:forEach var="user" items="${LIST_USERS}">
						<tr>
							<td>${ user.id }</td>
							<td>${ user.name }</td>
							<td>${ user.number }</td>
							<td>${user.email}</td>
							<td>${user.age}</td>
							<td>${user.password}</td>
							<td>${user.role}</td>
							<td>${ user.gender }</td>

							<td><a href="/PT15302-UD/admin/users/update?id=${ user.id }"
								class="btn btn-primary">Update</a></td>

							<td><a href="/PT15302-UD/admin/users/delete?id=${ user.id }"
								class="btn btn-danger">Delete</a></td>

						</tr>
					</c:forEach>

				</tbody>

			</table>

			<div>
				<ul class="pagination">
					<li class="page-item"><a
						href="/PT15302-UD/admin/users?page=${ page - 1 }"
						class="page-link">Previous</a></li>
					<li class="page-item"><a class="page-link">${ page } / ${ Math.ceil(countUsers/Limit)}
					</a></li>
					<li class="page-item"><a
						href="/PT15302-UD/admin/users?page=${ page + 1 }"
						class="page-link" onclick ="handleClick()">Next</a></li>
				</ul>
			</div>

		</div>

	</div>
</body>
</html>
<script type="text/javascript">
  function handleClick()
  {
     if(${ page } < ${ Math.ceil(countUsers/Limit) } ){
       alert("this is " + ${ page });
     }else{
    	 alert("No record"); 
     return;
     
     }
     }
  
</script>