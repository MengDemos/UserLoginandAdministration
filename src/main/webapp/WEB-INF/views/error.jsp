<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<title>Error-Exception</title>
<link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css"
	rel="stylesheet">
</head>

<body>
	
	<nav role="navigation" class="navbar navbar-default">

		
		<div class="navbar-collapse">
			<ul class="nav navbar-nav">
				<li><a href="/admin-userlist">Users</a></li>
			</ul>
			<ul class="nav navbar-nav navbar-right">
				<li><a href="/logout">Logout</a></li>
			</ul>
		</div>

	</nav>
	
	<div class="container">
    	Application has encountered an error. Please contact support on ...
	</div>
	
	<script src="webjars/jquery/1.9.1/jquery.min.js"></script>	
	<script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
	<script src="webjars/bootstrap-datepicker/1.0.1/js/bootstrap-datepicker.js"></script>

</body>
</html>