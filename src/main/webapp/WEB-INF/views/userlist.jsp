<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<title>UserAdministration</title>
<link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css"
	rel="stylesheet">
</head>

<body>
	
	<nav role="navigation" class="navbar navbar-default">

		
		<div class="navbar-collapse">
			<ul class="nav navbar-nav">
				<li><a href="/admin/userlist">Users</a></li>
			</ul>
			<ul class="nav navbar-nav navbar-right">
				<li><a href="/logout">Logout</a></li>
			</ul>
		</div>

	</nav>
	
	<div class="container">
		<table class="table table-striped">
			
			<thead>
				<tr>
					<th>Firstname</th>
					<th>Lastname</th>
					<th>Email</th>
					<th>Username</th>
					<th>Password</th>
					<th></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${users}" var="user">
					<tr>
						<td>${user.firstname}</td>				
						<td>${user.lastname}</td>
						<td>${user.email}</td>
						<td>${user.username}</td>
						<td>${user.password}</td>
						<td><a type="button" class="btn btn-primary"
							href="/admin/updateuser?id=${user.id}">Edit</a> <a type="button"
							class="btn btn-warning" href="/admin/deleteuser?id=${user.id}">Delete</a>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<div>
			<a type="button" class="btn btn-success" href="/admin/adduser">Add</a>
		</div>
	</div>
	
	<script src="webjars/jquery/1.9.1/jquery.min.js"></script>	
	<script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>

</body>
</html>