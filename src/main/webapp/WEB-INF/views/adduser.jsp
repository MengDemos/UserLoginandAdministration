<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<title>Adduser</title>
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
        <form:form value="/admin/adduser" method="post" commandName="user">
            <form:hidden path="id"/>
            <fieldset class="form-group">
                <form:label path="firstname">Firstname</form:label>
                <form:input path="firstname" type="text" class="form-control"
                    required="required"/>
                <form:errors path="firstname" cssClass="text-warning" />
            </fieldset>
            <fieldset class="form-group">
                <form:label path="lastname">Lastname</form:label>
                <form:input path="lastname" type="text" class="form-control"
                    required="required"/>
                <form:errors path="lastname" cssClass="text-warning" />
            </fieldset>
            <fieldset class="form-group">
                <form:label path="email">Email Address</form:label>
                <form:input path="email" type="text" class="form-control"
                    required="required"/>
                <form:errors path="email" cssClass="text-warning" />
            </fieldset>
            <fieldset class="form-group">
                <form:label path="username">Username</form:label>
                <form:input path="username" type="text" class="form-control"
                    required="required"/>
                <form:errors path="username" cssClass="text-warning" />
            </fieldset>
            <fieldset class="form-group">
                <form:label path="password">Password</form:label>
                <form:input path="password" type="password" class="form-control"
                    required="required"/>
                <form:errors path="password" cssClass="text-warning" />
            </fieldset>
            <button type="submit" class="btn btn-success">Submit</button>
        </form:form>
    </div>

    <script src="webjars/jquery/1.9.1/jquery.min.js"></script>
    <script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>

</body>
</html>